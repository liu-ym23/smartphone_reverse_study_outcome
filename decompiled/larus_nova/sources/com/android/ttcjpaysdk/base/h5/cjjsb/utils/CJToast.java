package com.android.ttcjpaysdk.base.h5.cjjsb.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0014H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/CJToast;", "Landroid/widget/Toast;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "toastContainer", "Landroid/widget/LinearLayout;", "toastText", "Landroid/widget/TextView;", "toastView", "Landroid/view/View;", "topIcon", "Landroid/widget/ImageView;", "applyConfig", "config", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/ToastConfig;", "applyToastUiConfig", "", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/ToastUiConfig;", "createToastView", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJToast extends Toast {
    public static final Companion Companion = null;
    private final Context context;
    private LinearLayout toastContainer;
    private TextView toastText;
    private View toastView;
    private ImageView topIcon;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/CJToast$Companion;", "", "()V", "show", "", "config", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/ToastConfig;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final boolean show(ToastConfig r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            if (r100.isValid() == false) goto L5;
            CJToast.access$applyConfig(new CJToast(r100.getContext()), r100).show();
            return true;
        L5:
            return false;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final View createToastView() {
        TextView r100 = null;
        View r101 = LayoutInflater.from(this.context).inflate(R.layout.cj_pay_toast_view_layout, null);
        this.toastView = r101;
        if (r101 == null) goto L5;
        LinearLayout r102 = (LinearLayout) r101.findViewById(R.id.toast_container);
    L6:
        this.toastContainer = r102;
        View r103 = this.toastView;
        if (r103 == null) goto L9;
        ImageView r104 = (ImageView) r103.findViewById(R.id.icon);
    L10:
        this.topIcon = r104;
        View r105 = this.toastView;
        if (r105 == null) goto L13;
        r100 = (TextView) r105.findViewById(R.id.text);
    L13:
        this.toastText = r100;
        return this.toastView;
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final Context getContext() {
        return this.context;
    }

    public CJToast(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100.getApplicationContext());
        this.context = r100;
        View r101 = createToastView();
        if (r101 == null) goto L5;
        setView(r101);
    L5:
        setGravity(17, 0, 0);
    }

    public static final /* synthetic */ ImageView access$getTopIcon$p(CJToast r100) {
        return r100.topIcon;
    }

    private final CJToast applyConfig(ToastConfig r100) {
        TextView r101 = this.toastText;
        if (r101 == null) goto L6;
        r101.setText(r100.getText());
    L6:
        CharSequence r102 = r100.getText();
        if (r102 == null) goto L9;
        Boolean r103 = Boolean.valueOf(!StringsKt.isBlank(r102));
    L10:
        if (r103 == null) goto L12;
        boolean r104 = r103.booleanValue();
    L14:
        if (r104 == false) goto L20;
        TextView r105 = this.toastText;
        if (r105 == null) goto L29;
        r105.setText(r100.getText());
    L29:
        if (r100.getTopIconResId() == null) goto L34;
        ImageView r106 = this.topIcon;
        if (r106 == null) goto L40;
        r106.setImageResource(r100.getTopIconResId().intValue());
    L40:
        setDuration(r100.getDuration());
        ToastUiConfig r107 = r100.getCustomUiConfig();
        if (r107 != null) goto L43;
        r107 = CJToastKt.getDefaultToastUiConfig();
    L43:
        applyToastUiConfig(r107);
        return this;
    L34:
        if (r100.getTopIconUrl() == null) goto L36;
        ImageLoader.Companion.getInstance().loadImage(r100.getTopIconUrl(), new AnonymousClass1(this));
        goto L40
    L36:
        ImageView r108 = this.topIcon;
        if (r108 == null) goto L40;
        r108.setVisibility(8);
        goto L40
    L20:
        if (r100.getTextResId() == null) goto L24;
        TextView r109 = this.toastText;
        if (r109 == null) goto L29;
        r109.setText(r100.getTextResId().intValue());
        goto L29
    L24:
        TextView r110 = this.toastText;
        if (r110 == null) goto L29;
        r110.setVisibility(8);
        goto L29
    L12:
        r104 = false;
        goto L14
    L9:
        r103 = null;
        goto L10
    }

    private final void applyToastUiConfig(ToastUiConfig r100) {
        TextView r101 = this.toastText;
        if (r101 == null) goto L5;
        r101.setTextSize(2, r100.getMsgTextSize());
    L5:
        ImageView r102 = this.topIcon;
        boolean r103 = true;
        if (r102 == null) goto L32;
        TextView r104 = this.toastText;
        if (r104 != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        ViewGroup.MarginLayoutParams r106 = null;
        if (r105 == true) goto L17;
        r102 = null;
    L17:
        if (r102 == null) goto L32;
        ViewGroup.LayoutParams r107 = r102.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        r106 = (ViewGroup.MarginLayoutParams) r107;
    L21:
        int r108 = CJPayBasicExtensionKt.dp(r100.getIconSize());
        if (r106 == null) goto L25;
        r106.height = r108;
    L25:
        if (r106 == null) goto L28;
        r106.width = r108;
    L28:
        if (r106 == null) goto L31;
        r106.bottomMargin = CJPayBasicExtensionKt.dp(r100.getIconBottomMargin());
    L31:
        r102.setLayoutParams(r106);
        goto L32
    L10:
        if (r104.getVisibility() != 0) goto L12;
        r105 = true;
    L32:
        LinearLayout r109 = this.toastContainer;
        if (r109 == null) goto L61;
        ImageView r110 = this.topIcon;
        if (r110 != null) goto L37;
    L39:
        boolean r111 = false;
    L40:
        if (r111 == false) goto L42;
        int r112 = r100.getToastHPadding();
    L43:
        int r113 = CJPayBasicExtensionKt.dp(r112);
        ImageView r114 = this.topIcon;
        if (r114 != null) goto L46;
    L48:
        r103 = false;
    L49:
        if (r103 == false) goto L51;
        int r115 = r100.getToastVPadding();
    L52:
        int r116 = CJPayBasicExtensionKt.dp(r115);
        r109.setPadding(r113, r116, r113, r116);
        r109.setMinimumHeight(CJPayBasicExtensionKt.dp(r100.getToastMinHeight()));
        r109.setMinimumWidth(CJPayBasicExtensionKt.dp(r100.getToastMinWidth()));
        ViewGroup.LayoutParams r117 = r109.getLayoutParams();
        if (r117 == null) goto L56;
        r117.width = r100.getToastWidth();
    L56:
        if (r117 == null) goto L59;
        r117.height = r100.getToastHeight();
    L59:
        r109.setLayoutParams(r117);
        return;
    L51:
        r115 = r100.getOnlyTextToastVPadding();
        goto L52
    L46:
        if (r114.getVisibility() != 0) goto L48;
    L42:
        r112 = r100.getOnlyTextToastHPadding();
        goto L43
    L37:
        if (r110.getVisibility() != 0) goto L39;
        r111 = true;
        goto L40
    }

    public static final /* synthetic */ CJToast access$applyConfig(CJToast r100, ToastConfig r101) {
        return r100.applyConfig(r101);
    }
}
