package com.android.internal.chooser;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppGlobals;
import android.content.Intent;
import android.content.IntentExt;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.StepOSCtsUtils;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.app.NfcResolverActivity;
import com.android.internal.app.ResolverActivity;
import com.android.internal.chooser.base.BaseResolverContract;
import com.android.internal.chooser.base.IntentModifier;
import com.android.internal.chooser.base.OnTargetClickHandler;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import com.android.internal.chooser.resolver.ResolverClickHandler;
import com.android.internal.chooser.resolver.ResolverFinder;
import com.android.internal.chooser.resolver.ResolverIntentModifier;
import com.android.internal.chooser.resolver.ResolverItemComparator;
import com.android.internal.chooser.resolver.ResolverPresenter;
import com.android.internal.chooser.resolver.ResolverUsageStats;
import com.android.internal.chooser.utils.LogUtils;
import com.android.internal.chooser.utils.NFCUtils;
import com.android.internal.chooser.utils.StepOSThemeUtils;
import com.android.internal.chooser.utils.Utils;
import com.android.internal.chooser.widget.CustomRoundImageView;
import com.stepos.feature.StepOSFeature;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class ResolverActivityHooker extends BaseResolverHooker {
    private static final String TAG = "ResolverActivityHooker";
    private static boolean sIsPoleStar = false;
    private boolean isTypeNFC;
    private boolean isTypeWebSearch;
    private boolean mAlwaysUseOption;
    private Intent mDefaultIntent;
    private int mDefaultTitleRes;
    private String mFileType;
    private Intent[] mInitialIntents;
    private List<ResolveInfo> mInitialResolveInfo;
    private Intent mIntent;
    private String mIntentType;
    private Uri mIntentUri;
    private CharSequence mTitle;
    private final boolean sShouldHook;

    public ResolverActivityHooker(Activity activity, Runnable finishTask) {
        super(activity, finishTask);
        this.sShouldHook = SystemProperties.getBoolean("persist.sdk.hook.resolver", true);
    }

    @Override // com.android.internal.chooser.hook.ResolverHooker
    public boolean shouldHook() {
        return this.sShouldHook && StepOSFeature.isEnabled(17) && (this.mActivity.getClass().equals(ResolverActivity.class) || this.mActivity.getClass().equals(NfcResolverActivity.class)) && !StepOSCtsUtils.isCtsRunning();
    }

    public void onCreate(Bundle savedInstanceState, Intent intent, CharSequence title, int defaultTitleRes, Intent[] initialIntents, List<ResolveInfo> rList, boolean alwaysUseOption) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, IllegalArgumentException {
        this.mActivity.setTheme(R.style.Theme.Material.Light.Dialog.BaseAlert);
        this.mIntent = intent;
        this.mTitle = title;
        this.mDefaultTitleRes = defaultTitleRes;
        this.mInitialIntents = initialIntents;
        this.mInitialResolveInfo = rList;
        this.mAlwaysUseOption = alwaysUseOption;
        sIsPoleStar = StepOSThemeUtils.isPoleStarTheme();
        super.onCreate(savedInstanceState);
    }

    public void onCreate(Bundle savedInstanceState, Intent intent, CharSequence title, Intent[] initialIntents, List<ResolveInfo> rList, boolean alwaysUseOption) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, IllegalArgumentException {
        onCreate(savedInstanceState, intent, title, 0, initialIntents, rList, alwaysUseOption);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker, com.android.internal.chooser.hook.ResolverHooker
    public void onCreate(Bundle savedInstanceState) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, IllegalArgumentException {
        setSafeForwardingMode(true);
        onCreate(savedInstanceState, null, null, 0, null, null, true);
    }

    private void init() {
        this.mDefaultIntent = getQueryIntent();
        this.mIntentUri = Utils.getIntentUri(this.mDefaultIntent);
        this.mIntentType = this.mDefaultIntent.getType();
        LogUtils.d("mIntentType  = " + this.mIntentType);
        this.mFileType = sharingType(this.mIntentType, null);
        this.isTypeNFC = NFCUtils.isNfcIntent(this.mDefaultIntent);
        this.isTypeWebSearch = isTypeWebSearch(this.mDefaultIntent);
        LogUtils.d("IntentUri  = " + this.mIntentUri + " IntentType = " + this.mIntentType + " FileType = " + this.mFileType + " isTypeGeoUri = " + this.isTypeGeoUri);
        View rvParent = (View) this.mRecyclerView.getParent();
        int rvPaddingBottom = this.isTypeNFC ? 0 : Utils.dp2px(this.mActivity, 64.0f);
        rvParent.setPadding(Utils.dp2px(this.mActivity, 16.0f), 0, Utils.dp2px(this.mActivity, 16.0f), rvPaddingBottom);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void onAllItemsLoaded() {
        int contentHeight;
        if (!this.isTypeNFC || this.mNestedScrollingLayout == null || this.mNestedScrollView == null || (contentHeight = this.mNestedScrollView.getBottom()) <= 0 || contentHeight >= this.mNestedScrollingLayout.getUncollapsibleHeight()) {
            return;
        }
        LogUtils.d("onAllItemsLoaded: shrink NFC popup to contentHeight = " + contentHeight + ", was " + this.mNestedScrollingLayout.getUncollapsibleHeight());
        this.mNestedScrollingLayout.setStyle(1);
        this.mNestedScrollingLayout.setUncollapsibleHeight(contentHeight);
        this.mNestedScrollingLayout.requestLayout();
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected BaseResolverContract.Presenter getPresenter() {
        int launchedFromUid;
        try {
            int launchedFromUid2 = ActivityManager.getService().getLaunchedFromUid(getActivityToken());
            launchedFromUid = launchedFromUid2;
        } catch (Exception e) {
            launchedFromUid = -1;
        }
        return new ResolverPresenter(this, new ResolverFinder(this.mActivity, isShowAllApp(), isFilterPriority(), launchedFromUid, getComparator()));
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected OnTargetClickHandler getTargetClickHandler() {
        int launchedFromUid;
        String launchedFromPackage;
        try {
            int launchedFromUid2 = ActivityManager.getService().getLaunchedFromUid(getActivityToken());
            launchedFromUid = launchedFromUid2;
        } catch (Exception e) {
            launchedFromUid = -1;
        }
        try {
            String launchedFromPackage2 = ActivityManager.getService().getLaunchedFromPackage(getActivityToken());
            launchedFromPackage = launchedFromPackage2;
        } catch (Exception e2) {
            launchedFromPackage = "??";
        }
        return new ResolverClickHandler(this.mSafeForwardingMode, launchedFromUid, launchedFromPackage, isSetLastChosen(), this.mActivity);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected IntentModifier getIntentModifier() {
        return new ResolverIntentModifier();
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected Intent getQueryIntent() {
        if (this.mIntent != null) {
            return this.mIntent;
        }
        return this.mIntentParser.getOriginIntent();
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected Intent[] getInitialIntents() {
        if (this.mInitialIntents != null) {
            return this.mInitialIntents;
        }
        return new Intent[0];
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected List<ResolveInfo> getInitialResolveInfo() {
        if (this.mInitialResolveInfo != null) {
            return this.mInitialResolveInfo;
        }
        return null;
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupCheckBox(CheckBox checkBox) {
        checkBox.setVisibility(8);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected boolean showRecommendTagIfNeed() {
        return true;
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected boolean isChooserActivity() {
        return false;
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupFileName(TextView fileNameTv) {
        init();
        if (this.mDefaultIntent == null || this.mIntentType == null) {
            if (this.isTypeWebSearch) {
                fileNameTv.setText(getQueryString());
                fileNameTv.setVisibility(0);
                return;
            }
            if (this.isTypeNFC) {
                fileNameTv.setText("NFC");
                fileNameTv.setVisibility(0);
                return;
            }
            if (this.mIntentUri != null && this.isTypeGeoUri) {
                String address = Utils.loadGeoUriQParams(this.mIntentUri);
                if (address != null) {
                    fileNameTv.setText(address);
                    fileNameTv.setVisibility(0);
                    return;
                }
            } else if (this.mIntentUri != null && this.mIntentType == null) {
                String referer = this.mActivity.getReferrer().getHost();
                String name = Utils.loadApplicationName(this.mActivity, referer);
                if (!TextUtils.isEmpty(name)) {
                    fileNameTv.setText(this.mActivity.getString(17042484, new Object[]{name}));
                    fileNameTv.setVisibility(0);
                    return;
                }
            }
            fileNameTv.setVisibility(4);
            return;
        }
        String mFileName = Utils.loadFileInfomation(this.mActivity, this.mIntentUri, this.mDefaultIntent, "");
        if (TextUtils.isEmpty(mFileName)) {
            fileNameTv.setVisibility(4);
        } else {
            fileNameTv.setText(mFileName);
            fileNameTv.setVisibility(0);
        }
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupTitleLayout(View titleLayout) {
        titleLayout.setVisibility(0);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupFileType(TextView fileTypeTv) {
        fileTypeTv.setVisibility(0);
        if (this.isTypeNFC) {
            fileTypeTv.setText(this.mActivity.getResources().getString(17042480));
            return;
        }
        if (this.isTypeGeoUri) {
            fileTypeTv.setText(this.mActivity.getResources().getString(17042478));
            return;
        }
        if (this.isTypeWebSearch) {
            fileTypeTv.setVisibility(0);
            showTextCopy(fileTypeTv);
        } else {
            if (this.mIntentType == null && this.mIntentUri != null) {
                this.mFileType = getResources().getString(17042477);
            }
            fileTypeTv.setText(this.mFileType);
        }
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupFileThumbnail(CustomRoundImageView fileThumbnailIv) {
        if (this.isTypeNFC) {
            fileThumbnailIv.setImageBitmap(Utils.getBitmapFromDrawable(this.mActivity.getDrawable(17304619)));
            return;
        }
        if (this.isTypeGeoUri) {
            fileThumbnailIv.setImageBitmap(Utils.getBitmapFromDrawable(this.mActivity.getDrawable(17304616)));
            return;
        }
        if (this.isTypeWebSearch) {
            String type = this.mActivity.getString(17042485);
            fileThumbnailIv.setImageBitmap(Utils.getBitmapFromDrawable(this.mActivity.getDrawable(getDefaultThumbnailResId(type))));
            return;
        }
        String type2 = this.mIntentType;
        if (type2 == null && this.mIntentUri != null) {
            String referer = this.mActivity.getReferrer().getHost();
            Drawable drawable = Utils.loadApplicationIcon(this.mActivity, referer);
            if (drawable == null) {
                drawable = this.mActivity.getDrawable(17304610);
            }
            fileThumbnailIv.setImageBitmap(Utils.getBitmapFromDrawable(drawable));
            return;
        }
        String referer2 = this.mIntentType;
        if (Utils.isTypeImageOrVideo(referer2) || Utils.isTypeApplication(this.mDefaultIntent, this.mActivity)) {
            fileThumbnailIv.setPainteThumbnailStroke(true);
        }
        handleFileThumbnail(fileThumbnailIv, this.mDefaultIntent, this.mFileType);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupFileSize(TextView fileSizeTv) {
        if (this.mIntentUri == null) {
            fileSizeTv.setVisibility(8);
            return;
        }
        String size = Utils.calculateSize(this.mActivity, this.mIntentUri);
        if (TextUtils.isEmpty(size)) {
            fileSizeTv.setVisibility(8);
        } else {
            fileSizeTv.setText(size);
            fileSizeTv.setVisibility(0);
        }
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupFilePolicy(TextView textView, ImageView imageView) {
        textView.setVisibility(8);
        imageView.setVisibility(8);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupPreview(FrameLayout parent, View customView) {
        parent.setVisibility(8);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    protected void setupOpenFileCheckBox(TextView checkboxTip, CheckBox checkBox) {
        if (this.mAlwaysUseOption) {
            checkboxTip.setVisibility(0);
            checkBox.setVisibility(0);
            checkBox.setText(getResources().getString(17042538));
            if (sIsPoleStar) {
                checkBox.setButtonDrawable(17304601);
                return;
            }
            return;
        }
        checkboxTip.setVisibility(8);
        checkBox.setVisibility(8);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    public void onActivityStart() {
        super.onActivityStart();
        ResolverUsageStats.onActivityStart(this.mActivity);
    }

    @Override // com.android.internal.chooser.BaseResolverHooker
    public void onTargetClick(Intent intent, ResolveInfo resolveInfo, boolean isChecked) {
        super.onTargetClick(intent, resolveInfo, isChecked);
        ResolverUsageStats.onTargetClick(this.mActivity, resolveInfo, isChecked);
    }

    private String getQueryString() {
        if (this.mDefaultIntent == null) {
            return "";
        }
        Bundle bundle = this.mDefaultIntent.getExtras();
        String query = bundle != null ? bundle.getString("query") : "";
        return query == null ? "" : query;
    }

    private void showTextCopy(final TextView fileTypeTv) {
        fileTypeTv.post(new Runnable() { // from class: com.android.internal.chooser.ResolverActivityHooker.1
            @Override // java.lang.Runnable
            public void run() {
                fileTypeTv.setText(17042508);
                if (ResolverActivityHooker.sIsPoleStar) {
                    fileTypeTv.setTextColor(ResolverActivityHooker.this.mActivity.getResources().getColor(17171518));
                } else {
                    fileTypeTv.setTextColor(ResolverActivityHooker.this.mActivity.getResources().getColor(17171388));
                }
            }
        });
        final String text = getQueryString();
        fileTypeTv.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.chooser.ResolverActivityHooker.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                fileTypeTv.performHapticFeedback(31020);
                Utils.copyToClipboard(ResolverActivityHooker.this.mActivity, text);
                Log.i(ResolverActivityHooker.TAG, "copy to clipboard is " + text);
            }
        });
    }

    protected boolean isSetLastChosen() {
        return true;
    }

    protected boolean isShowAllApp() {
        return this.mIntentParser.isShowAllApp();
    }

    protected boolean isFilterPriority() {
        return true;
    }

    protected Comparator<DisplayResolveInfo> getComparator() {
        ResolveInfo lastChosen = null;
        try {
            lastChosen = AppGlobals.getPackageManager().getLastChosenActivity(this.mQueryIntent, this.mDefaultIntent.resolveTypeIfNeeded(getContentResolver()), IntentExt.STEPOS_FLAG_SPLIT_MODE);
        } catch (Exception e) {
        }
        return new ResolverItemComparator(lastChosen);
    }

    private boolean isTypeWebSearch(Intent intent) {
        return intent != null && "android.intent.action.WEB_SEARCH".equals(intent.getAction());
    }
}
