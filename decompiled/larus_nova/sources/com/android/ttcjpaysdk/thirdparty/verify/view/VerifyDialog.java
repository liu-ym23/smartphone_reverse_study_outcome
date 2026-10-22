package com.android.ttcjpaysdk.thirdparty.verify.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCustomButton;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayFadeAnimationDialog;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001%B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020 R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/VerifyDialog;", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayFadeAnimationDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "btnText", "", "getBtnText", "()Ljava/lang/String;", "setBtnText", "(Ljava/lang/String;)V", "verifyBtn", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCustomButton;", "getVerifyBtn", "()Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCustomButton;", "setVerifyBtn", "(Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCustomButton;)V", "verifyBtnLayout", "Landroid/widget/FrameLayout;", "getVerifyBtnLayout", "()Landroid/widget/FrameLayout;", "setVerifyBtnLayout", "(Landroid/widget/FrameLayout;)V", "verifyBtnLoading", "Landroid/widget/ProgressBar;", "getVerifyBtnLoading", "()Landroid/widget/ProgressBar;", "setVerifyBtnLoading", "(Landroid/widget/ProgressBar;)V", "hideBtnLoading", "", "init", "dialogLayoutView", "Landroid/view/View;", "showBtnLoading", "Builder", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyDialog extends CJPayFadeAnimationDialog {
    private String btnText;
    private CJPayCustomButton verifyBtn;
    private FrameLayout verifyBtnLayout;
    private ProgressBar verifyBtnLoading;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/VerifyDialog$Builder;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "closeListenter", "Landroid/view/View$OnClickListener;", "iconUrl", "", "inputPasswordListenter", "inputPasswordText", "recommendText", "verifyAndPayButtonListenter", "verifyAndPayButtonText", "build", "Lcom/android/ttcjpaysdk/thirdparty/verify/view/VerifyDialog;", "loadImage", "", "url", "view", "Landroid/widget/ImageView;", "setCloseListenser", "listener", "setIconUrl", "setInputPasswordListenter", "setInputPasswordText", "setRecommendText", "setVerifyAndPayButtonListenter", "setVerifyAndPayButtonText", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private View.OnClickListener closeListenter;
        private final Context context;
        private String iconUrl;
        private View.OnClickListener inputPasswordListenter;
        private String inputPasswordText;
        private String recommendText;
        private View.OnClickListener verifyAndPayButtonListenter;
        private String verifyAndPayButtonText;

        public final VerifyDialog build() {
            VerifyDialog r100 = new VerifyDialog(this.context, R.style.CJ_Pay_Dialog_With_Layer);
            Object r101 = this.context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.LayoutInflater");
            View r102 = ((LayoutInflater) r101).inflate(R.layout.cj_pay_forget_pwd_verify_dialog, null);
            VerifyDialog.access$init(r100, r102);
            r100.addContentView(r102, new ViewGroup.LayoutParams(-2, -2));
            String r103 = this.iconUrl;
            if (r103 == null) goto L6;
            View r104 = r102.findViewById(R.id.verify_icon);
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.ImageView");
            loadImage(r103, (ImageView) r104);
        L6:
            if (this.recommendText == null) goto L9;
            View r105 = r102.findViewById(R.id.recommend_text);
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) r105).setText(this.recommendText);
        L9:
            if (this.verifyAndPayButtonText == null) goto L20;
            if (this.verifyAndPayButtonListenter == null) goto L20;
            CJPayCustomButton r106 = r100.getVerifyBtn();
            if (r106 == null) goto L16;
            r106.setText(this.verifyAndPayButtonText);
        L16:
            CJPayCustomButton r107 = r100.getVerifyBtn();
            if (r107 == null) goto L20;
            CJPayViewExtensionsKt.setDebouncingOnClickListener(r107, new VerifyDialog$Builder$build$1(this));
        L20:
            if (this.inputPasswordText == null) goto L25;
            if (this.inputPasswordListenter == null) goto L25;
            View r108 = r102.findViewById(R.id.input_password);
            Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) r108).setText(this.inputPasswordText);
            View r109 = r102.findViewById(R.id.input_password);
            Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.widget.TextView");
            CJPayViewExtensionsKt.setDebouncingOnClickListener((TextView) r109, new VerifyDialog$Builder$build$2(this));
        L25:
            if (this.closeListenter == null) goto L27;
            View r110 = r102.findViewById(R.id.close_btn);
            Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.widget.ImageView");
            CJPayViewExtensionsKt.setDebouncingOnClickListener((ImageView) r110, new VerifyDialog$Builder$build$3(this));
        L27:
            r100.setCanceledOnTouchOutside(false);
            return r100;
        }

        public Builder(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.context = r100;
        }

        public static final /* synthetic */ View.OnClickListener access$getCloseListenter$p(Builder r100) {
            return r100.closeListenter;
        }

        public static final /* synthetic */ View.OnClickListener access$getInputPasswordListenter$p(Builder r100) {
            return r100.inputPasswordListenter;
        }

        public static final /* synthetic */ View.OnClickListener access$getVerifyAndPayButtonListenter$p(Builder r100) {
            return r100.verifyAndPayButtonListenter;
        }

        public final Builder setCloseListenser(View.OnClickListener r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.closeListenter = r100;
            return this;
        }

        public final Builder setIconUrl(String r100) {
            Intrinsics.checkNotNullParameter(r100, "iconUrl");
            this.iconUrl = r100;
            return this;
        }

        public final Builder setInputPasswordListenter(View.OnClickListener r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.inputPasswordListenter = r100;
            return this;
        }

        public final Builder setInputPasswordText(String r100) {
            Intrinsics.checkNotNullParameter(r100, "inputPasswordText");
            this.inputPasswordText = r100;
            return this;
        }

        public final Builder setRecommendText(String r100) {
            Intrinsics.checkNotNullParameter(r100, "recommendText");
            this.recommendText = r100;
            return this;
        }

        public final Builder setVerifyAndPayButtonListenter(View.OnClickListener r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.verifyAndPayButtonListenter = r100;
            return this;
        }

        public final Builder setVerifyAndPayButtonText(String r100) {
            Intrinsics.checkNotNullParameter(r100, "verifyAndPayButtonText");
            this.verifyAndPayButtonText = r100;
            return this;
        }

        public final void loadImage(String r100, final ImageView r101) {
            Intrinsics.checkNotNullParameter(r101, "view");
            ImageLoader.Companion.getInstance().loadImage(r100, new VerifyDialog$Builder$loadImage$1(r101));
        }
    }

    public final void hideBtnLoading() {
        CJPayCustomButton r100 = this.verifyBtn;
        if (r100 == null) goto L6;
        r100.setText(this.btnText);
    L6:
        CJPayCustomButton r101 = this.verifyBtn;
        if (r101 == null) goto L10;
        r101.setClickable(true);
    L10:
        ProgressBar r102 = this.verifyBtnLoading;
        if (r102 == null) goto L15;
        r102.setVisibility(8);
        return;
    }

    public final void showBtnLoading() {
        CJPayCustomButton r100 = this.verifyBtn;
        if (r100 == null) goto L8;
        CharSequence r101 = r100.getText();
        if (r101 == null) goto L8;
        String r102 = r101.toString();
        if (r102 == null) goto L8;
    L9:
        this.btnText = r102;
        CJPayCustomButton r103 = this.verifyBtn;
        if (r103 == null) goto L13;
        r103.setText("");
    L13:
        CJPayCustomButton r104 = this.verifyBtn;
        if (r104 == null) goto L17;
        r104.setClickable(false);
    L17:
        ProgressBar r105 = this.verifyBtnLoading;
        if (r105 == null) goto L22;
        r105.setVisibility(0);
        return;
    L22:
        return;
    L8:
        r102 = "";
        goto L9
    }

    public final String getBtnText() {
        return this.btnText;
    }

    public final CJPayCustomButton getVerifyBtn() {
        return this.verifyBtn;
    }

    public final FrameLayout getVerifyBtnLayout() {
        return this.verifyBtnLayout;
    }

    public final ProgressBar getVerifyBtnLoading() {
        return this.verifyBtnLoading;
    }

    private final void init(View r100) {
        this.verifyBtnLayout = (FrameLayout) r100.findViewById(R.id.cj_pay_verify_btn_layout);
        this.verifyBtn = (CJPayCustomButton) r100.findViewById(R.id.cj_pay_verify_btn);
        this.verifyBtnLoading = (ProgressBar) r100.findViewById(R.id.cj_pay_verify_btn_loading);
    }

    public final void setBtnText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.btnText = r100;
    }

    public final void setVerifyBtn(CJPayCustomButton r100) {
        this.verifyBtn = r100;
    }

    public final void setVerifyBtnLayout(FrameLayout r100) {
        this.verifyBtnLayout = r100;
    }

    public final void setVerifyBtnLoading(ProgressBar r100) {
        this.verifyBtnLoading = r100;
    }

    public VerifyDialog(Context r100, int r101) {
        Intrinsics.checkNotNull(r100);
        super(r100, r101, false, 4, null);
        this.btnText = "";
    }

    public static final /* synthetic */ void access$init(VerifyDialog r100, View r101) {
        r100.init(r101);
    }
}
