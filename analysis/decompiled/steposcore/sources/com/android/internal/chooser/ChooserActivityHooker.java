package com.android.internal.chooser;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.BuildExt;
import android.os.Bundle;
import android.os.StepOSCtsUtils;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.chooser.base.BaseResolverContract;
import com.android.internal.chooser.base.IntentModifier;
import com.android.internal.chooser.base.OnTargetClickHandler;
import com.android.internal.chooser.chooser.ChooserClickHandler;
import com.android.internal.chooser.chooser.ChooserFinder;
import com.android.internal.chooser.chooser.ChooserIntentModifier;
import com.android.internal.chooser.chooser.ChooserPresenter;
import com.android.internal.chooser.chooser.ChooserUsageStats;
import com.android.internal.chooser.db.ChooserRepository;
import com.android.internal.chooser.utils.LogUtils;
import com.android.internal.chooser.utils.StepOSThemeUtils;
import com.android.internal.chooser.utils.Utils;
import com.android.internal.chooser.widget.CustomRoundImageView;
import com.stepos.feature.StepOSFeature;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import stepos.app.StepOSWindowManager;

/* loaded from: classes.dex */
public class ChooserActivityHooker extends BaseResolverHooker {
    public static final String KEY_DISABLE_STEPOS_CHOOSER = "KEY_DISABLE_STEPOS_CHOOSER";
    public static final String KEY_DISABLE_X_VCARD_STEPOS_CHOOSER = "KEY_DISABLE_X_VCARD_STEPOS_CHOOSER";
    private static final String TAG = "ChooserActivityHooker";
    private static boolean sIsPoleStarTheme = false;
    private String mFileName;
    private String mFileType;
    private Uri mSingleUri;
    private final UserManager mUserManager;
    private final boolean sShouldHook;

    public ChooserActivityHooker(Activity activity, Runnable finishTask) {
        super(activity, finishTask);
        this.sShouldHook = SystemProperties.getBoolean("persist.sdk.hook.chooser", true);
        this.mUserManager = (UserManager) activity.getSystemService("user");
        sIsPoleStarTheme = StepOSThemeUtils.isPoleStarTheme();
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public boolean shouldHook() {
        boolean disableStepOSChooser = this.mActivity.getIntent().getBooleanExtra(KEY_DISABLE_STEPOS_CHOOSER, false);
        return this.sShouldHook && !disableStepOSChooser && StepOSFeature.isEnabled(17) && Objects.equals(this.mActivity.getClass().toString(), "class com.android.intentresolver.ChooserActivity") && !StepOSCtsUtils.isCtsRunning() && !isIntlAvailable();
    }

    private boolean isIntlAvailable() {
        List<UserInfo> profiles = this.mUserManager.getProfiles(UserHandle.myUserId());
        if (profiles == null) {
            return false;
        }
        int i = profiles.size() - 1;
        while (true) {
            if (i < 0) {
                break;
            }
            UserInfo userInfo = profiles.get(i);
            if (userInfo.id != 999) {
                i--;
            } else {
                profiles.remove(userInfo);
                break;
            }
        }
        int count = profiles.size();
        UserInfo workProfile = null;
        int i2 = 0;
        while (true) {
            if (i2 >= count) {
                break;
            }
            UserInfo profile = profiles.get(i2);
            if (!profile.isManagedProfile() || profile.getUserHandle().getIdentifier() == UserHandle.myUserId()) {
                i2++;
            } else {
                workProfile = profile;
                break;
            }
        }
        return (!BuildExt.isProductInternational() || workProfile == null || workProfile.getUserHandle() == null || this.mUserManager.isManagedProfile() || this.mUserManager.isLinkedUser() || count <= 1) ? false : true;
    }

    @Override // com.android.internal.chooser.BaseResolverHooker, com.android.internal.chooser.hook.ResolverHooker
    public void onCreate(Bundle savedInstanceState) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, IllegalArgumentException {
        setSafeForwardingMode(true);
        super.onCreate(savedInstanceState);
        setRetainInOnStop(this.mActivity.getIntent().getBooleanExtra("com.android.internal.app.ChooserActivity.EXTRA_PRIVATE_RETAIN_IN_ON_STOP", false));
        init();
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected BaseResolverContract.Presenter getPresenter() {
        String launchedFromPackage = Utils.getPackageName(getActivityToken());
        boolean xVCardFlag = this.mActivity.getIntent().getBooleanExtra(KEY_DISABLE_X_VCARD_STEPOS_CHOOSER, false);
        boolean isDisableXVCard = "com.android.dialer".equals(launchedFromPackage) || xVCardFlag;
        return new ChooserPresenter(this, new ChooserFinder(this.mActivity, isDisableXVCard));
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected OnTargetClickHandler getTargetClickHandler() {
        int launchedFromUid = Utils.getPackageUID(getActivityToken());
        String launchedFromPackage = Utils.getPackageName(getActivityToken());
        return new ChooserClickHandler(this.mSafeForwardingMode, launchedFromUid, launchedFromPackage);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected IntentModifier getIntentModifier() {
        return new ChooserIntentModifier();
    }

    private void init() {
        this.mFileType = sharingType(this.mExtraIntent.getType(), Uris());
        LogUtils.d("IntentUri  = " + this.mUris + " UriNum = " + this.mIntentUriNum + " IntentType = " + this.mExtraIntentType + " FileType = " + this.mFileType);
        View rvParent = (View) this.mRecyclerView.getParent();
        rvParent.setPadding(Utils.dp2px(this.mActivity, 16.0f), 0, Utils.dp2px(this.mActivity, 16.0f), Utils.dp2px(this.mActivity, 64.0f));
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupFileName(final TextView fileNameTv) {
        String displayName;
        init();
        if (this.mDoubleFiles) {
            fileNameTv.post(new Runnable() { // from class: com.android.internal.chooser.ChooserActivityHooker.1
                @Override // java.lang.Runnable
                public void run() {
                    fileNameTv.setText(ChooserActivityHooker.this.customFilesName(ChooserActivityHooker.this.mIntentUriNum));
                    fileNameTv.setVisibility(0);
                }
            });
            return;
        }
        if (isShareText()) {
            fileNameTv.setText(String.valueOf(getQueryIntent().getExtras().get("android.intent.extra.TEXT")));
            fileNameTv.setEllipsize(TextUtils.TruncateAt.END);
            fileNameTv.setVisibility(0);
            return;
        }
        this.mFileName = Utils.loadFileInfomation(this.mActivity, this.mSingleUri, this.mExtraIntent, "");
        if (TextUtils.isEmpty(this.mFileName)) {
            this.mFileName = Utils.substringLastIndex(this.mSingleUri);
        }
        if (TextUtils.length(this.mFileName) > 200) {
            displayName = TextUtils.substring(this.mFileName, 0, 50);
        } else {
            displayName = this.mFileName;
        }
        fileNameTv.setText(displayName);
        fileNameTv.setVisibility(0);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupTitleLayout(View titleLayout) {
        if (this.mIsSharingScreenshotOrRecod) {
            titleLayout.setVisibility(8);
            return;
        }
        if (!this.mDoubleFiles) {
            if (!TextUtils.isEmpty(this.mExtraIntentType) && this.mExtraIntentType.startsWith("text/")) {
                titleLayout.setVisibility(0);
                return;
            } else if (Uris() == null || this.mSingleUri == null || Objects.equals(this.mSingleUri.getAuthority(), "media")) {
                titleLayout.setVisibility(8);
                return;
            }
        }
        titleLayout.setVisibility(0);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupFileType(TextView fileTypeTv) {
        if (this.mDoubleFiles || Objects.equals(this.mFileType, getResources().getString(17042474)) || Objects.equals(this.mFileType, getResources().getString(17042479))) {
            fileTypeTv.setVisibility(8);
            return;
        }
        fileTypeTv.setVisibility(0);
        if (isShareText()) {
            showTextCopy(fileTypeTv);
        } else {
            fileTypeTv.setText(this.mFileType);
        }
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupFileThumbnail(CustomRoundImageView fileThumbnailIv) {
        if (Uris() == null || this.mIsSharingScreenshotOrRecod) {
            fileThumbnailIv.setVisibility(8);
            return;
        }
        fileThumbnailIv.setVisibility(0);
        if (this.mIntentUriNum == 1) {
            if (Utils.isTypeImageOrVideo(this.mExtraIntentType) || Utils.isTypeApplication(this.mExtraIntent, this.mActivity)) {
                fileThumbnailIv.setPainteThumbnailStroke(true);
            }
            if (handledSingleFileThumbnail(fileThumbnailIv, this.mExtraIntent)) {
                return;
            }
        }
        Drawable drawable = this.mActivity.getDrawable(getDefaultThumbnailResId(this.mFileType));
        fileThumbnailIv.setImageBitmap(Utils.getBitmapFromDrawable(drawable));
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupFileSize(TextView fileSizeTv) {
        String size = Utils.calculateTotalSize(this.mActivity, Uris());
        if (TextUtils.isEmpty(size) || isShareText()) {
            fileSizeTv.setVisibility(8);
        } else {
            fileSizeTv.setText(size);
            fileSizeTv.setVisibility(0);
        }
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupFilePolicy(TextView textView, ImageView imageView) {
        if (!this.mHasFilePolicyInfo || this.mIntentUriNum == 0 || Uris() == null || this.mIsSharingScreenshotOrRecod || isSharingUriWithoutScheme(this.mSingleUri)) {
            textView.setVisibility(8);
            imageView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        imageView.setVisibility(0);
        if (sIsPoleStarTheme) {
            textView.setTextColor(getResources().getColor(17171518));
            imageView.setImageDrawable(getResources().getDrawable(17304648));
        }
        updateFilePolicy();
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.chooser.ChooserActivityHooker.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChooserActivityHooker.this.startChooserFilePolicyActivity();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.chooser.ChooserActivityHooker.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChooserActivityHooker.this.startChooserFilePolicyActivity();
            }
        });
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupPreview(FrameLayout parent, View customView) {
        ViewGroup parentViewGroup;
        if (this.mIntentUriNum > 1 || Uris() == null || customView == null) {
            parent.setVisibility(8);
            return;
        }
        if (customView != null && (parentViewGroup = (ViewGroup) customView.getParent()) != null) {
            parentViewGroup.removeView(customView);
        }
        parent.removeAllViews();
        parent.addView(customView);
        parent.setVisibility(0);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupOpenFileCheckBox(TextView checkboxTip, CheckBox checkBox) {
        checkboxTip.setVisibility(8);
        checkBox.setVisibility(8);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupCheckBox(CheckBox checkBox) {
        checkBox.setVisibility(this.mIntentParser.isShowCheckBox() ? 0 : 8);
        checkBox.setChecked(this.mIntentParser.isCheckBoxChecked());
        String checkBoxText = this.mIntentParser.getCheckBoxText();
        if (sIsPoleStarTheme) {
            checkBox.setButtonDrawable(17304601);
        }
        if (!TextUtils.isEmpty(checkBoxText)) {
            checkBox.setText(checkBoxText);
        }
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    public void onActivityStart() {
        String launchedFromPackage;
        super.onActivityStart();
        try {
            launchedFromPackage = ActivityManager.getService().getLaunchedFromPackage(getActivityToken());
        } catch (Exception e) {
            launchedFromPackage = "??";
        }
        ChooserUsageStats.onActivityStart(this.mActivity, launchedFromPackage);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    public void onTargetClick(Intent intent, ResolveInfo resolveInfo, boolean isChecked) throws JSONException {
        super.onTargetClick(intent, resolveInfo, isChecked);
        ChooserUsageStats.onTargetClick(this.mActivity, resolveInfo, isChecked);
        ChooserRepository.getInstance(this.mActivity).updateUsageCount(resolveInfo);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected Intent getQueryIntent() {
        return this.mIntentParser.getExtraIntent();
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected Intent[] getInitialIntents() {
        if (BuildExt.isProductInternational()) {
            Intent[] result = this.mIntentParser.getInitialIntents();
            return result != null ? result : new Intent[0];
        }
        ComponentName componentName = this.mActivity.getCallingActivity();
        if (componentName != null) {
            String className = componentName.getShortClassName();
            String packageName = componentName.getPackageName();
            if ("com.sankuai.waimai.business.knb.KNBWebViewActivity".equals(className) || "com.sankuai.titans.adapter.mtapp.KNBWebViewActivity".equals(className) || "com.cmccit.webview.ac.CommonHtml5Activity".equals(className)) {
                return this.mIntentParser.getInitialIntents();
            }
            if ("com.cqdcg.ykbapp".equals(packageName)) {
                return this.mIntentParser.getInitialIntents(true);
            }
        }
        return new Intent[0];
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected List<ResolveInfo> getInitialResolveInfo() {
        return null;
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected boolean showRecommendTagIfNeed() {
        return false;
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected boolean isChooserActivity() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence customFilesName(int fileNum) {
        SpannableStringBuilder spannableString = new SpannableStringBuilder();
        int formatResId = 17042490;
        if (Objects.equals(this.mFileType, getResources().getString(17042482))) {
            formatResId = 17042491;
        } else if (Objects.equals(this.mFileType, getResources().getString(17042486)) || Objects.equals(this.mFileType, getResources().getString(17042488))) {
            formatResId = 17042492;
        }
        String content = String.format(this.mActivity.getResources().getString(formatResId), Integer.valueOf(fileNum), this.mFileType);
        spannableString.append((CharSequence) content);
        return spannableString;
    }

    private void showTextCopy(final TextView fileTypeTv) {
        fileTypeTv.post(new Runnable(this) { // from class: com.android.internal.chooser.ChooserActivityHooker.4
            @Override // java.lang.Runnable
            public void run() {
                fileTypeTv.setText(17042508);
                if (ChooserActivityHooker.sIsPoleStarTheme) {
                    fileTypeTv.setTextColor(Color.parseColor("#FFFF7500"));
                } else {
                    fileTypeTv.setTextColor(Color.parseColor("#FF1368FB"));
                }
            }
        });
        final String text = String.valueOf(getQueryIntent().getExtras().get("android.intent.extra.TEXT"));
        fileTypeTv.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.chooser.ChooserActivityHooker.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                fileTypeTv.performHapticFeedback(31020);
                Utils.copyToClipboard(ChooserActivityHooker.this.mActivity, text);
                Log.i(ChooserActivityHooker.TAG, "copy to clipboard is " + text);
            }
        });
    }

    private ArrayList<Uri> Uris() {
        if (this.mUris != null && this.mUris.size() != 0) {
            this.mSingleUri = this.mUris.get(0);
            return this.mUris;
        }
        ArrayList<Uri> uris = Utils.getIntentUris(this.mExtraIntent);
        if (uris.isEmpty()) {
            return null;
        }
        return uris;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startChooserFilePolicyActivity() {
        Intent intent = new Intent("stepos.intent.action.CHOOSER_FILEPOLICY");
        intent.putExtra("file_policy_uri", Uris());
        this.mActivity.startActivityForResult(intent, StepOSWindowManager.VERSION_CODE);
    }
}
