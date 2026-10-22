package com.bytedanceos.common.ui;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.R$style;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.utils.FeedBackUtil;
import com.bytedanceos.common.utils.u;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class AppInfoFeedBackActivity extends StatusBarActivity implements FetchDataCallBack, View.OnClickListener {
    private static final int FEEDBACK_CONTENT_MAX = 100;
    private static final int FEEDBACK_TYPE_1 = 1;
    private static final int FEEDBACK_TYPE_2 = 2;
    private static final int FEEDBACK_TYPE_3 = 3;
    private static final int FEEDBACK_TYPE_4 = 4;
    private static final int FEEDBACK_TYPE_5 = 5;
    private static final int FEEDBACK_TYPE_6 = 6;
    private static final int MAX_SELECTED_PICS = 4;
    private static final int MSG_WHAT_SCROLL = 1;
    private static final int MSG_WHAT_SCROLL_TOP = 2;
    private static final int REQUEST_CODE_PICK = 10;
    private static final String TAG = "AppInfoFeedBackActivity";
    private AlertDialog mAlertDialog;
    private CommonAPIHelper mApiHelper;
    private String mAppPkg;
    private int mAppVersionCode;
    private ImageButton mDelBtn1;
    private ImageButton mDelBtn2;
    private ImageButton mDelBtn3;
    private ImageButton mDelBtn4;
    private FeedBackUtil mFeedBackImage;
    private String mFeedbackContent;
    private TextWatcher mFeedbackContentChanged;
    private EditText mFeedbackDetail;
    private HashSet<Integer> mFeedbackTypes;
    private Handler mHandler;
    private ScrollView mScrollView;
    private ImageView mUploadImage1;
    private ImageView mUploadImage2;
    private ImageView mUploadImage3;
    private ImageView mUploadImage4;

    public AppInfoFeedBackActivity() {
        this.mScrollView = null;
        this.mFeedbackDetail = null;
        this.mUploadImage1 = null;
        this.mUploadImage2 = null;
        this.mUploadImage3 = null;
        this.mUploadImage4 = null;
        this.mDelBtn1 = null;
        this.mDelBtn2 = null;
        this.mDelBtn3 = null;
        this.mDelBtn4 = null;
        this.mFeedbackTypes = new HashSet();
        this.mFeedBackImage = null;
        this.mAppPkg = null;
        this.mAlertDialog = null;
        this.mApiHelper = new CommonAPIHelper();
        this.mHandler = new AnonymousClass1(this);
        this.mFeedbackContentChanged = new AnonymousClass2(this);
    }

    public static /* synthetic */ ScrollView access$000(AppInfoFeedBackActivity r10) {
        return r10.mScrollView;
    }

    public static /* synthetic */ EditText access$100(AppInfoFeedBackActivity r10) {
        return r10.mFeedbackDetail;
    }

    public static /* synthetic */ TextWatcher access$200(AppInfoFeedBackActivity r10) {
        return r10.mFeedbackContentChanged;
    }

    public static /* synthetic */ String access$300(AppInfoFeedBackActivity r10) {
        return r10.mFeedbackContent;
    }

    public static /* synthetic */ String access$302(AppInfoFeedBackActivity r10, String r11) {
        r10.mFeedbackContent = r11;
        return r11;
    }

    private void deleteUnloadImage(int r10, boolean r11) {
    }

    private void dismiss() {
        senSubmitBtnEnable(true);
        AlertDialog r10 = this.mAlertDialog;
        if (r10 == null) goto L6;
        r10.dismiss();
        return;
    }

    private ArrayList<Uri> getImagesUri(Intent r10) {
        ArrayList<Uri> r11 = new ArrayList();
        ClipData r12 = r10.getClipData();
        if (r12 == null) goto L15;
        int r13 = r12.getItemCount();
        if (r13 <= 4) goto L7;
        r13 = 4;
    L7:
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L17;
        Uri r15 = r12.getItemAt(r14).getUri();
        if (FeedBackUtil.x(FeedBackUtil.s(r15)) == false) goto L12;
        r11.add(r15);
    L13:
        r14 = r14 + 1;
        goto L8
    L12:
        e0.e(R$string.feedback_file_error);
    L17:
        return r11;
    L15:
        if (r11.isEmpty() == false) goto L17;
        r11.add(r10.getData());
        goto L17
    }

    private int getMaxPics() {
        if (this.mDelBtn1.getVisibility() != 0) goto L5;
        int r10 = 3;
    L7:
        if (this.mDelBtn2.getVisibility() != 0) goto L10;
        r10 = r10 - 1;
    L10:
        if (this.mDelBtn3.getVisibility() != 0) goto L13;
        r10 = r10 - 1;
    L13:
        if (this.mDelBtn4.getVisibility() != 0) goto L15;
        r10 = r10 - 1;
    L15:
        if (r10 > 0) goto L19;
        return 1;
    L19:
        return r10;
    L5:
        r10 = 4;
        goto L7
    }

    private boolean isCanDeleteFile(File r10) {
        if (this.mDelBtn1.getVisibility() == 0) goto L5;
    L9:
        int r11 = 0;
    L11:
        if (this.mDelBtn2.getVisibility() != 0) goto L18;
        if ((this.mDelBtn2.getTag() instanceof File) == false) goto L18;
        if (((File) this.mDelBtn2.getTag()).getAbsolutePath().equals(r10.getAbsolutePath()) == false) goto L18;
        r11 = r11 + 1;
    L18:
        if (this.mDelBtn3.getVisibility() != 0) goto L25;
        if ((this.mDelBtn3.getTag() instanceof File) == false) goto L25;
        if (((File) this.mDelBtn3.getTag()).getAbsolutePath().equals(r10.getAbsolutePath()) == false) goto L25;
        r11 = r11 + 1;
    L25:
        if (this.mDelBtn4.getVisibility() == 0) goto L27;
    L31:
        if (r11 != 1) goto L34;
        return true;
    L34:
        return false;
    L27:
        if ((this.mDelBtn4.getTag() instanceof File) == false) goto L31;
        if (((File) this.mDelBtn4.getTag()).getAbsolutePath().equals(r10.getAbsolutePath()) == false) goto L31;
        r11 = r11 + 1;
        goto L31
    L5:
        if ((this.mDelBtn1.getTag() instanceof File) == false) goto L9;
        if (((File) this.mDelBtn1.getTag()).getAbsolutePath().equals(r10.getAbsolutePath()) == false) goto L9;
        r11 = 1;
        goto L11
    }

    private void pickImage() {
        Intent r10 = new Intent();
        r10.setAction("android.intent.action.PICK");
        r10.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        r10.putExtra("max_get_content", getMaxPics());
        r10.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        r10.putExtra("return-data", true);
        startActivityForResult(r10, 10);
    }

    private boolean reUseResouse(ImageView r10, ImageView r11) {
        ImageButton r12 = (ImageButton) r10.getTag();
        ImageButton r13 = (ImageButton) r11.getTag();
        if (r13 != null) goto L5;
    L7:
        r11.setVisibility(4);
        r10.setEnabled(true);
        r10.setImageResource(R$drawable.feedback_bg_selector);
        r12.setVisibility(8);
        r10.setTag(null);
        return false;
    L5:
        if (r13.getVisibility() != 0) goto L7;
        r10.setImageDrawable(r11.getDrawable());
        r12.setTag(r13.getTag());
        return true;
    }

    private void senSubmitBtnEnable(boolean r10) {
    }

    private void setFeedbackType(int r10, View r11) {
    }

    private void showUploadingDialog() {
        senSubmitBtnEnable(false);
        if (this.mAlertDialog != null) goto L5;
        this.mAlertDialog = new AlertDialog.Builder(new ContextThemeWrapper(this, R$style.AppStoreDialogTheme)).setMessage(R$string.feedback_uploading).setPositiveButton(R$string.done, new AnonymousClass3(this)).create();
    L5:
        this.mAlertDialog.show();
    }

    private void submitFeedBack() {
        if (com.bytedanceos.common.toolbox.e.A0(BaseApplication.c()) == true) goto L6;
        e0.e(R$string.feedback_no_net_retry);
        return;
    L6:
        showUploadingDialog();
        StringBuilder r10 = new StringBuilder();
        Iterator<Integer> r11 = this.mFeedbackTypes.iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        Integer r12 = r11.next();
        if (r10.length() <= 0) goto L12;
        r10.append(",");
    L12:
        r10.append(r12);
        goto L8
    L13:
        String r13 = this.mFeedbackDetail.getText().toString();
        String r14 = this.mFeedBackImage.i(this.mAppPkg, this.mAppVersionCode, r10, r13);
        if (r14 != null) goto L16;
        dismiss();
        e0.e(R$string.feedback_fail);
        com.bytedanceos.common.toolbox.j.a("submit info is null");
        return;
    L16:
        CommonAPIHelper.b0(r14, this);
    }

    private void updateViewContentDescription() {
        ImageView r10 = this.mUploadImage1;
        Resources r11 = getResources();
        int r12 = R$string.feed_back_add_image;
        r10.setContentDescription(r11.getString(r12, new Object[]{1}));
        this.mUploadImage2.setContentDescription(getResources().getString(r12, new Object[]{2}));
        this.mUploadImage3.setContentDescription(getResources().getString(r12, new Object[]{3}));
        this.mUploadImage4.setContentDescription(getResources().getString(r12, new Object[]{4}));
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R$anim.slide_in_from_left, R$anim.slide_out_to_right);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public View initHeaderView() {
        OFloatingTitleBar r10 = (OFloatingTitleBar) findViewById(R$id.toolbar);
        u.e(r10, R$string.feedback_title);
        u.a(r10, this);
        return r10;
    }

    public void initView() {
        senSubmitBtnEnable(false);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r10, int r11, Intent r12) {
        if (r10 == 10) goto L6;
        com.bytedanceos.common.toolbox.j.a("ignore requestCode:" + r10);
        return;
    L6:
        if (r12 != null) goto L9;
        com.bytedanceos.common.toolbox.j.a("uri = " + r12 + " / requestCode = " + r10);
        return;
    L9:
        ArrayList<Uri> r13 = getImagesUri(r12);
        if (r13.isEmpty() == false) goto L14;
        com.bytedanceos.common.toolbox.j.a("not have pics");
        return;
    L14:
        if (this.mDelBtn1.getVisibility() != 8) goto L19;
        if (r13.isEmpty() == true) goto L19;
        Uri r14 = r13.remove(0);
        this.mUploadImage1.setTag(this.mDelBtn1);
        this.mUploadImage2.setVisibility(0);
        this.mFeedBackImage.y(0, r14, this.mAppPkg, this.mUploadImage1);
    L19:
        if (this.mDelBtn2.getVisibility() != 8) goto L24;
        if (r13.isEmpty() == true) goto L24;
        Uri r15 = r13.remove(0);
        this.mUploadImage2.setTag(this.mDelBtn2);
        this.mUploadImage3.setVisibility(0);
        this.mFeedBackImage.y(1, r15, this.mAppPkg, this.mUploadImage2);
    L24:
        if (this.mDelBtn3.getVisibility() != 8) goto L29;
        if (r13.isEmpty() == true) goto L29;
        Uri r16 = r13.remove(0);
        this.mUploadImage3.setTag(this.mDelBtn3);
        this.mUploadImage4.setVisibility(0);
        this.mFeedBackImage.y(2, r16, this.mAppPkg, this.mUploadImage3);
    L29:
        if (this.mDelBtn4.getVisibility() == 8) goto L31;
        return;
    L31:
        if (r13.isEmpty() == true) goto L35;
        Uri r17 = r13.remove(0);
        this.mUploadImage4.setTag(this.mDelBtn4);
        this.mFeedBackImage.y(3, r17, this.mAppPkg, this.mUploadImage4);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        setContentView(R$layout.feedback_activity);
        initView();
        DisplayMetrics r11 = getResources().getDisplayMetrics();
        this.mFeedBackImage = new FeedBackUtil(r11.widthPixels, r11.heightPixels);
        this.mAppPkg = getIntent().getStringExtra("PackageName");
        this.mAppVersionCode = getIntent().getIntExtra("AppVersionCode", 0);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mFeedBackImage.j();
        this.mFeedBackImage.l();
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
        dismiss();
        switch(this.mFeedBackImage.o(r12)) {
            case 1006008: goto L5;
            case 1006009: goto L5;
            default: goto L4;
        };
    L4:
        e0.e(R$string.feedback_fail);
        return;
    L5:
        e0.e(R$string.feedback_image_fail);
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
        e0.e(R$string.feedback_success);
        dismiss();
        finish();
    }

    private void deleteUnloadImage(View r10, ImageView r11) {
        Object r12 = r10.getTag();
        if (r12 != null) goto L7;
        com.bytedanceos.common.toolbox.j.a("tag file is null");
        return;
    L7:
        if ((r12 instanceof File) == false) goto L11;
        File r13 = (File) r12;
        if (isCanDeleteFile(r13) == false) goto L13;
        r13.delete();
        return;
    L13:
        return;
    L11:
        com.bytedanceos.common.toolbox.j.a("unkown delete file:" + r12);
    }
}
