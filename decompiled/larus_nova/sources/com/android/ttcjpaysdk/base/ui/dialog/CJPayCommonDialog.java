package com.android.ttcjpaysdk.base.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.larus.nova.R;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayCommonDialog extends CJPayFadeAnimationDialog {
    private static final String TAG = "CJPayCommonDialog";
    private DialogBackPressedListener backPressedListener;
    private CharSequence content;
    private int contentColor;
    private int contentGravity;
    private int height;
    private boolean isContentBold;
    private boolean isLeftBold;
    private boolean isRightBold;
    private boolean isSingleBold;
    private boolean isSubTitleBold;
    private boolean isTitleBold;
    private int leftColor;
    private View.OnClickListener leftListener;
    private String leftText;
    private DialogInterface.OnCancelListener mCancelListener;
    private boolean mCanceledOnTouchOutside;
    private View mContentContainer;
    private boolean mIsCancelable;
    private int rightColor;
    private View.OnClickListener rightListener;
    private String rightText;
    private int singleColor;
    private View.OnClickListener singleListener;
    private String singleText;
    private String subTitle;
    private int subTitleColor;
    private String title;
    private int titleColor;
    private int width;

    public static abstract class Builder {
        public Builder() {
        }

        public abstract CJPayCommonDialog build();

        public abstract Builder setCancelable(Boolean r100);

        public abstract Builder setCanceledOnTouchOutside(Boolean r100);

        public abstract Builder setContent(CharSequence r100);

        public abstract Builder setContentColor(int r100);

        public abstract Builder setContentGravity(int r100);

        public abstract Builder setContentIsBold(boolean r100);

        public abstract Builder setContentView(View r100);

        public abstract Builder setDialogLeftListener(DialogClickListener r100);

        public abstract Builder setDialogRightListener(DialogClickListener r100);

        public abstract Builder setDialogSingleListener(DialogClickListener r100);

        public abstract Builder setDialogWidth(int r100);

        public abstract Builder setLeftColor(int r100);

        public abstract Builder setLeftIsBold(boolean r100);

        public abstract Builder setLeftListener(View.OnClickListener r100);

        public abstract Builder setLeftText(String r100);

        public abstract Builder setOnCancelListener(DialogInterface.OnCancelListener r100);

        public abstract Builder setRightColor(int r100);

        public abstract Builder setRightIsBold(boolean r100);

        public abstract Builder setRightListener(View.OnClickListener r100);

        public abstract Builder setRightText(String r100);

        public abstract Builder setSingleColor(int r100);

        public abstract Builder setSingleIsBold(boolean r100);

        public abstract Builder setSingleListener(View.OnClickListener r100);

        public abstract Builder setSingleText(String r100);

        public abstract Builder setSubTitle(String r100);

        public abstract Builder setSubTitleColor(int r100);

        public abstract Builder setTitle(String r100);

        public abstract Builder setTitleColor(int r100);

        public abstract Builder setTitleIsBold(boolean r100);
    }

    public interface DialogBackPressedListener {
        void onBackPressed();
    }

    public static class DialogBuilder extends Builder {
        private Context mContext;
        private CJPayCommonDialog mDialog;

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public CJPayCommonDialog build() {
            CJPayCommonDialog.access$2800(this.mDialog, this.mContext);
            return this.mDialog;
        }

        public DialogBuilder(Context r100) {
            this.mContext = r100;
            this.mDialog = new CJPayCommonDialog(this.mContext);
        }

        public static /* synthetic */ CJPayCommonDialog access$2400(DialogBuilder r100) {
            return r100.mDialog;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setCancelable(Boolean r100) {
            CJPayCommonDialog.access$202(this.mDialog, r100.booleanValue());
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setCanceledOnTouchOutside(Boolean r100) {
            CJPayCommonDialog.access$302(this.mDialog, r100.booleanValue());
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setContent(CharSequence r100) {
            CJPayCommonDialog.access$1002(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setContentColor(int r100) {
            CJPayCommonDialog.access$1702(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setContentGravity(int r100) {
            CJPayCommonDialog.access$1102(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setContentIsBold(boolean r100) {
            CJPayCommonDialog.access$2202(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setContentView(View r100) {
            CJPayCommonDialog.access$102(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setDialogLeftListener(final DialogClickListener r100) {
            CJPayCommonDialog.access$2302(this.mDialog, new AnonymousClass1(this, r100));
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setDialogRightListener(final DialogClickListener r100) {
            CJPayCommonDialog.access$2502(this.mDialog, new AnonymousClass2(this, r100));
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setDialogSingleListener(final DialogClickListener r100) {
            CJPayCommonDialog.access$2602(this.mDialog, new AnonymousClass3(this, r100));
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setDialogWidth(int r100) {
            CJPayCommonDialog.access$2702(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setLeftColor(int r100) {
            CJPayCommonDialog.access$1202(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setLeftIsBold(boolean r100) {
            CJPayCommonDialog.access$1802(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setLeftListener(View.OnClickListener r100) {
            CJPayCommonDialog.access$2302(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setLeftText(String r100) {
            CJPayCommonDialog.access$602(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setOnCancelListener(DialogInterface.OnCancelListener r100) {
            CJPayCommonDialog.access$402(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setRightColor(int r100) {
            CJPayCommonDialog.access$1302(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setRightIsBold(boolean r100) {
            CJPayCommonDialog.access$1902(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setRightListener(View.OnClickListener r100) {
            CJPayCommonDialog.access$2502(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setRightText(String r100) {
            CJPayCommonDialog.access$702(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setSingleColor(int r100) {
            CJPayCommonDialog.access$1402(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setSingleIsBold(boolean r100) {
            CJPayCommonDialog.access$2002(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setSingleListener(View.OnClickListener r100) {
            CJPayCommonDialog.access$2602(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setSingleText(String r100) {
            CJPayCommonDialog.access$802(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setSubTitle(String r100) {
            CJPayCommonDialog.access$902(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setSubTitleColor(int r100) {
            CJPayCommonDialog.access$1602(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setTitle(String r100) {
            CJPayCommonDialog.access$502(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setTitleColor(int r100) {
            CJPayCommonDialog.access$1502(this.mDialog, r100);
            return this;
        }

        @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog.Builder
        public Builder setTitleIsBold(boolean r100) {
            CJPayCommonDialog.access$2102(this.mDialog, r100);
            return this;
        }

        public DialogBuilder(Context r100, int r101) {
            this.mContext = r100;
            this.mDialog = new CJPayCommonDialog(this.mContext, r101, true);
        }

        public DialogBuilder(Context r100, int r101, boolean r102) {
            this.mContext = r100;
            this.mDialog = new CJPayCommonDialog(this.mContext, r101, r102);
        }
    }

    public interface DialogClickListener {
        void onClick(Dialog r100);
    }

    public CJPayCommonDialog(Context r100) {
        super(r100, R.style.CJ_Pay_Dialog_With_Layer, true);
        this.contentGravity = 0;
        this.isLeftBold = false;
        this.isRightBold = false;
        this.isSingleBold = false;
        this.isTitleBold = false;
        this.isSubTitleBold = false;
        this.isContentBold = false;
        this.width = 270;
        this.height = -2;
    }

    public static /* synthetic */ DialogBackPressedListener access$000(CJPayCommonDialog r100) {
        return r100.backPressedListener;
    }

    private void init(Context r110) {
        if (initRootView(r110) == true) goto L5;
        return;
    L5:
        LinearLayout r100 = (LinearLayout) this.mContentContainer.findViewById(R.id.cj_pay_common_dialog_title_layout);
        TextView r101 = (TextView) this.mContentContainer.findViewById(R.id.cj_pay_common_dialog_title_view);
        TextView r102 = (TextView) this.mContentContainer.findViewById(R.id.cj_pay_common_dialog_sub_title_view);
        TextView r103 = (TextView) this.mContentContainer.findViewById(R.id.cj_pay_common_dialog_content_view);
        TextView r104 = (TextView) this.mContentContainer.findViewById(R.id.cj_pay_common_dialog_confirm_btn_view);
        TextView r105 = (TextView) this.mContentContainer.findViewById(R.id.cj_pay_common_dialog_cancel_btn_view);
        TextView r106 = (TextView) this.mContentContainer.findViewById(R.id.cj_pay_common_dialog_single_btn_view);
        View r107 = this.mContentContainer.findViewById(R.id.cj_pay_common_dialog_vertical_divider);
        initTitleStyle(r101, this.title, this.titleColor, this.isTitleBold);
        initTitleStyle(r102, this.subTitle, this.subTitleColor, this.isSubTitleBold);
        initContentGravity(r100, r103, this.contentGravity);
        initTitleStyle(r103, this.content, this.contentColor, this.isContentBold);
        initBtn(r105, this.leftText, this.leftColor, this.isLeftBold, this.leftListener);
        initBtn(r104, this.rightText, this.rightColor, this.isRightBold, this.rightListener);
        initBtn(r106, this.singleText, this.singleColor, this.isSingleBold, this.singleListener);
        initDivider(r107);
        setContentView(this.mContentContainer);
        setCancelable(this.mIsCancelable);
        setCanceledOnTouchOutside(this.mCanceledOnTouchOutside);
        setOnCancelListener(this.mCancelListener);
        setOnKeyListener(new AnonymousClass1(this));
        setContainerLayoutParams(r110, this.width, this.mContentContainer);
    }

    private void initDivider(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(this.singleText) == true) goto L6;
        r100.setVisibility(8);
        return;
    L6:
        r100.setVisibility(0);
    }

    private boolean initRootView(Context r100) {
        if (this.mContentContainer != null) goto L8;
        if ((r100 instanceof Activity) == false) goto L8;
        this.mContentContainer = getDefaultDialogView((Activity) r100);
    L8:
        if (this.mContentContainer == null) goto L10;
        return true;
    L10:
        return false;
    }

    public View getDefaultDialogView(Activity r100) {
        if ("en".equals(CJPayHostInfo.languageTypeStr) == false) goto L5;
        int r101 = R.layout.cj_pay_view_common_en_dialog_layout;
    L7:
        if (CJPaySettingsManager.getInstance().isDegradeDialogStyle() == true) goto L18;
    L14:
        th = move-exception;
        CJReporter r102 = CJReporter.f202294a;
        CJReporter.m(CJPayCallBackCenter.getInstance().getCjContext(), "context_theme_wrapper_exception", 1, th);
        return r100.getLayoutInflater().inflate(r101, null);
    L9:
        if (CJPayThemeManager.getInstance().isThemeDark(r100) == false) goto L11;
        ContextThemeWrapper r103 = new ContextThemeWrapper(r100.getApplication(), R.style.CJ_Pay_Theme_Apply_Dark);     // Catch: Throwable -> L14
    L12:
        return LayoutInflater.from(r103).inflate(r101, null);
    L11:
        r103 = new ContextThemeWrapper(r100.getApplication(), R.style.CJ_Pay_Theme_Apply_Light);     // Catch: Throwable -> L14
        goto L12
    L18:
        return r100.getLayoutInflater().inflate(r101, null);
    L5:
        r101 = R.layout.cj_pay_view_common_dialog_layout;
        goto L7
    }

    public void setBackPressedListener(DialogBackPressedListener r100) {
        this.backPressedListener = r100;
    }

    public static /* synthetic */ CharSequence access$1002(CJPayCommonDialog r100, CharSequence r101) {
        r100.content = r101;
        return r101;
    }

    public static /* synthetic */ View access$102(CJPayCommonDialog r100, View r101) {
        r100.mContentContainer = r101;
        return r101;
    }

    public static /* synthetic */ int access$1102(CJPayCommonDialog r100, int r101) {
        r100.contentGravity = r101;
        return r101;
    }

    public static /* synthetic */ int access$1202(CJPayCommonDialog r100, int r101) {
        r100.leftColor = r101;
        return r101;
    }

    public static /* synthetic */ int access$1302(CJPayCommonDialog r100, int r101) {
        r100.rightColor = r101;
        return r101;
    }

    public static /* synthetic */ int access$1402(CJPayCommonDialog r100, int r101) {
        r100.singleColor = r101;
        return r101;
    }

    public static /* synthetic */ int access$1502(CJPayCommonDialog r100, int r101) {
        r100.titleColor = r101;
        return r101;
    }

    public static /* synthetic */ int access$1602(CJPayCommonDialog r100, int r101) {
        r100.subTitleColor = r101;
        return r101;
    }

    public static /* synthetic */ int access$1702(CJPayCommonDialog r100, int r101) {
        r100.contentColor = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1802(CJPayCommonDialog r100, boolean r101) {
        r100.isLeftBold = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1902(CJPayCommonDialog r100, boolean r101) {
        r100.isRightBold = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2002(CJPayCommonDialog r100, boolean r101) {
        r100.isSingleBold = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(CJPayCommonDialog r100, boolean r101) {
        r100.mIsCancelable = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2102(CJPayCommonDialog r100, boolean r101) {
        r100.isTitleBold = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2202(CJPayCommonDialog r100, boolean r101) {
        r100.isContentBold = r101;
        return r101;
    }

    public static /* synthetic */ View.OnClickListener access$2302(CJPayCommonDialog r100, View.OnClickListener r101) {
        r100.leftListener = r101;
        return r101;
    }

    public static /* synthetic */ View.OnClickListener access$2502(CJPayCommonDialog r100, View.OnClickListener r101) {
        r100.rightListener = r101;
        return r101;
    }

    public static /* synthetic */ View.OnClickListener access$2602(CJPayCommonDialog r100, View.OnClickListener r101) {
        r100.singleListener = r101;
        return r101;
    }

    public static /* synthetic */ int access$2702(CJPayCommonDialog r100, int r101) {
        r100.width = r101;
        return r101;
    }

    public static /* synthetic */ void access$2800(CJPayCommonDialog r100, Context r101) {
        r100.init(r101);
    }

    public static /* synthetic */ boolean access$302(CJPayCommonDialog r100, boolean r101) {
        r100.mCanceledOnTouchOutside = r101;
        return r101;
    }

    public static /* synthetic */ DialogInterface.OnCancelListener access$402(CJPayCommonDialog r100, DialogInterface.OnCancelListener r101) {
        r100.mCancelListener = r101;
        return r101;
    }

    public static /* synthetic */ String access$502(CJPayCommonDialog r100, String r101) {
        r100.title = r101;
        return r101;
    }

    public static /* synthetic */ String access$602(CJPayCommonDialog r100, String r101) {
        r100.leftText = r101;
        return r101;
    }

    public static /* synthetic */ String access$702(CJPayCommonDialog r100, String r101) {
        r100.rightText = r101;
        return r101;
    }

    public static /* synthetic */ String access$802(CJPayCommonDialog r100, String r101) {
        r100.singleText = r101;
        return r101;
    }

    public static /* synthetic */ String access$902(CJPayCommonDialog r100, String r101) {
        r100.subTitle = r101;
        return r101;
    }

    private int getDialogWidth(Context r100, int r101) {
        if (r101 > 0) goto L4;
        return r101;
    L4:
        float r102 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r100);
        int r103 = CJPayLargeScreenUtils.resolveWindowWidthPx(r100, this.mContentContainer);
        if (r103 > 0) goto L7;
        r103 = (int) r102;
    L7:
        int r104 = CJPayLargeScreenUtils.resolveCashierVisibleWidthPx(r100, r103);
        boolean r105 = CJPayLargeScreenUtils.isLargeScreen(r100, r103);
        float r106 = CJPayBasicUtils.dipToPX(r100, r101);
        float r107 = CJPayBasicUtils.dipToPX(r100, 375.0f);
        if (r105 == false) goto L12;
        if (r104 <= 0) goto L12;
        float r108 = (r106 / r107) * r104;
    L15:
        CJLogger.d(TAG, "calculate dialog width, inWidth=" + r101 + ", screenWidth=" + r102 + ", windowWidth=" + r103 + ", visibleWindowWidth=" + r104 + ", isLargeScreen=" + r105 + ", widthPix=" + r108);
        return (int) r108;
    L12:
        if (r102 <= CJPayBasicUtils.getScreenHeight(r100)) goto L14;
        r108 = r102 * 0.35f;
        goto L15
    L14:
        r108 = (r106 / r107) * r102;
        goto L15
    }

    public CJPayCommonDialog(Context r100, int r101, boolean r102) {
        super(r100, r101, r102);
        this.contentGravity = 0;
        this.isLeftBold = false;
        this.isRightBold = false;
        this.isSingleBold = false;
        this.isTitleBold = false;
        this.isSubTitleBold = false;
        this.isContentBold = false;
        this.width = 270;
        this.height = -2;
        int r103 = r100.getResources().getColor(R.color.cj_pay_color_new_blue);
        this.singleColor = r103;
        this.leftColor = r103;
        this.rightColor = r103;
        int r104 = CJPayThemeUtils.getColor(r100, R.attr.cj_pay_text_primary, R.color.cj_pay_color_black_161823);
        this.subTitleColor = r104;
        this.titleColor = r104;
        this.contentColor = CJPayThemeUtils.getColor(r100, R.attr.cj_pay_text_primary);
    }

    private void initContentGravity(LinearLayout r100, TextView r101, int r102) {
        if (r102 != 0) goto L4;
        return;
    L4:
        RelativeLayout.LayoutParams r103 = (RelativeLayout.LayoutParams) r100.getLayoutParams();
        r103.height = -2;
        r103.width = -1;
        r100.setLayoutParams(r103);
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r101.getLayoutParams();
        r104.height = -2;
        r104.width = -1;
        r101.setLayoutParams(r104);
        r101.setGravity(r102);
    }

    private void setContainerLayoutParams(Context r100, int r101, View r102) {
        if (r101 > 375) goto L5;
        if (r101 < 0) goto L5;
    L6:
        int r103 = getDialogWidth(r100, r101);
        if (r103 <= 0) goto L10;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-1, -1);
        r104.width = r103;
        r104.height = -2;
        r102.setLayoutParams(r104);
        return;
    L10:
        return;
    L5:
        r101 = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME;
        goto L6
    }

    private void initTitleStyle(TextView r100, CharSequence r101, int r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r100.setText(r101);
        r100.setVisibility(0);
        r100.setTextColor(r102);
        if (r103 == false) goto L8;
        r100.setTypeface(Typeface.defaultFromStyle(1));
        return;
    L8:
        r100.setTypeface(Typeface.defaultFromStyle(0));
        return;
    L9:
        r100.setVisibility(8);
    }

    private void initBtn(TextView r100, String r101, int r102, boolean r103, View.OnClickListener r104) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        r100.setVisibility(0);
        r100.setText(r101);
        r100.setTextColor(r102);
        if (r103 == false) goto L8;
        r100.setTypeface(Typeface.defaultFromStyle(1));
    L9:
        r100.setOnClickListener(r104);
        return;
    L8:
        r100.setTypeface(Typeface.defaultFromStyle(0));
        goto L9
    L10:
        r100.setVisibility(8);
    }
}
