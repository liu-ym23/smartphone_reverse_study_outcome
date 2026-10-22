package com.android.ttcjpaysdk.base.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ui.wrapper.CJDialogToastHelper;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.crash.d;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0006\u0010\u001d\u001a\u00020\u001bJ\u0016\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015J$\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\r\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/CJDialogToast;", "Lcom/android/ttcjpaysdk/base/ui/IToastOperation;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "customView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "dialog", "Landroid/app/Dialog;", "handler", "Landroid/os/Handler;", "hideRunnable", "Ljava/lang/Runnable;", "isDegradeDialogToastTextOptimization", "", "()Z", "isDegradeDialogToastTextOptimization$delegate", "Lkotlin/Lazy;", "isDestroyed", "isPaused", "offsetX", "", "offsetY", "rootView", "textView", "Landroid/widget/TextView;", "applyTextDisplayMode", "", "dismiss", LiveCommonConstants.REASON_ON_DEDTROY, "setOffset", "x", "y", "showText", "text", "", "duration", GXTemplateKey.GAIAX_LAYER_GRAVITY, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJDialogToast implements IToastOperation {
    private final Dialog dialog;
    private final Handler handler;
    private final Runnable hideRunnable;
    private final Lazy isDegradeDialogToastTextOptimization$delegate;
    private boolean isDestroyed;
    private boolean isPaused;
    private int offsetX;
    private int offsetY;
    private View rootView;
    private TextView textView;

    /* JADX WARN: Multi-variable type inference failed */
    public CJDialogToast(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 2, 0 == true ? 1 : 0);
    }

    private final void applyTextDisplayMode() {
        TextView r100 = this.textView;
        if (r100 != null) goto L5;
        return;
    L5:
        if (isDegradeDialogToastTextOptimization() == true) goto L8;
        r100.setSingleLine(false);
        r100.setEllipsize(TextUtils.TruncateAt.END);
        r100.setMaxLines(2);
    L8:
        if (isDegradeDialogToastTextOptimization() == false) goto L10;
        String r101 = "降级模式(单行)";
    L11:
        CJLogger.a(CJDialogToastHelper.TAG, "应用文本显示模式: ".concat(r101));
        return;
    L10:
        r101 = "优化模式(两行)";
        goto L11
    }

    private final boolean isDegradeDialogToastTextOptimization() {
        return ((Boolean) this.isDegradeDialogToastTextOptimization$delegate.getValue()).booleanValue();
    }

    @Override // com.android.ttcjpaysdk.base.ui.IToastOperation
    public void dismiss() {
    L6:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJDialogToast#dismiss", e);
        CJLogger.b(CJDialogToastHelper.TAG, "隐藏Dialog失败: " + e.getMessage());
        CJReporter r100 = CJReporter.f202294a;
        CJReporter.k(CJPayCallBackCenter.getInstance().getCjContext(), "cj_dialog_toast_dismiss_error", 2, e.toString());
        return;
    L3:
        if (this.dialog.isShowing() == false) goto L11;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_CJDialogToast_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.dialog);     // Catch: Exception -> L6
        return;
    }

    public final void onDestroy() {
        if (this.isDestroyed == false) goto L5;
        return;
    L5:
        if (this.isPaused == true) goto L10;
        this.isDestroyed = true;
        this.handler.removeCallbacks(this.hideRunnable);
        dismiss();
        return;
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_CJDialogToast_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_CJDialogToast_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_CJDialogToast_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(Dialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public CJDialogToast(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.handler = new Handler();
        this.hideRunnable = new CJDialogToast$hideRunnable$1(this);
        this.isDegradeDialogToastTextOptimization$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
        Dialog r102 = new Dialog(r100, R.style.cj_pay_dialog_toast_dialog);
        Window r103 = r102.getWindow();
        if (r103 == null) goto L5;
        r103.addFlags(8);
        r103.addFlags(32);
        r103.addFlags(16);
        r103.setLayout(-2, -2);
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_CJDialogToast_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r103).setPadding(CJPayBasicExtensionKt.dp(10), CJPayBasicExtensionKt.dp(10), CJPayBasicExtensionKt.dp(10), CJPayBasicExtensionKt.dp(10));
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_CJDialogToast_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r103).setTag("ignore_eye_protection");
        r103.setGravity(17);
    L5:
        this.dialog = r102;
        if (r101 == null) goto L8;
        r102.setContentView(r101);     // Catch: Throwable -> L14
        this.textView = (TextView) r101.findViewById(R.id.text);     // Catch: Throwable -> L14
    L12:
        applyTextDisplayMode();     // Catch: Throwable -> L14
        return;
    L8:
        TextView r104 = null;
        View r105 = LayoutInflater.from(r100).inflate(R.layout.cj_pay_dialog_toast_layout, null);     // Catch: Throwable -> L14
        this.rootView = r105;     // Catch: Throwable -> L14
        if (r105 == null) goto L11;
        r104 = (TextView) r105.findViewById(R.id.toast_text);     // Catch: Throwable -> L14
    L11:
        this.textView = r104;     // Catch: Throwable -> L14
        View r106 = this.rootView;     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L14
        r102.setContentView(r106);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJDialogToast#unknown", th);
        CJLogger.b(CJDialogToastHelper.TAG, "初始化视图失败: " + th.getMessage());
        CJReporter r107 = CJReporter.f202294a;
        CJReporter.k(CJPayCallBackCenter.getInstance().getCjContext(), "cj_dialog_toast_init_error", 2, th.toString());
    }

    public final void setOffset(int r100, int r101) {
        this.offsetX = r100;
        this.offsetY = r101;
    }

    public final void showText(CharSequence r100, int r101, int r102) {
        if (this.isDestroyed == false) goto L5;
        return;
    L5:
        if (r101 > 0) goto L9;
        if (r101 == (-1)) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r100) == true) goto L38;
        TextView r103 = this.textView;
        if (r103 == null) goto L38;
        if (r100 == null) goto L26;
        r103.setText(r100);
        if ((r100 instanceof SpannableString) == false) goto L17;
    L18:
        TextView r104 = this.textView;
        if (r104 == null) goto L22;
        r104.setHighlightColor(0);
    L22:
        TextView r105 = this.textView;
        if (r105 == null) goto L26;
        r105.setMovementMethod(LinkMovementMethod.getInstance());
        goto L26
    L17:
        if ((r100 instanceof SpannableStringBuilder) == true) goto L18;
    L26:
        this.handler.removeCallbacks(this.hideRunnable);
        Window r106 = this.dialog.getWindow();
        if (r106 == null) goto L40;
        r106.setGravity(r102);
        WindowManager.LayoutParams r107 = r106.getAttributes();
        r107.x = this.offsetX;
        r107.y = this.offsetY;
        r106.setAttributes(r107);
    L40:
    L35:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJDialogToast#showText", e);
        CJLogger.b(CJDialogToastHelper.TAG, "显示Dialog失败: " + e.getMessage());
        CJReporter r108 = CJReporter.f202294a;
        CJReporter.k(CJPayCallBackCenter.getInstance().getCjContext(), "cj_dialog_toast_show_error", 2, e.toString());
        return;
    L30:
        if (this.dialog.isShowing() == true) goto L32;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_CJDialogToast_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.dialog);     // Catch: Exception -> L35
    L32:
        if (r101 == (-1)) goto L42;
        this.handler.postDelayed(this.hideRunnable, r101);     // Catch: Exception -> L35
        return;
    L42:
        return;
    L38:
        CJLogger.e(CJDialogToastHelper.TAG, "未设置显示文本");
    }

    public /* synthetic */ CJDialogToast(Context r100, View r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }

    public static /* synthetic */ void showText$default(CJDialogToast r100, CharSequence r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 2000;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = 17;
    L8:
        r100.showText(r101, r102, r103);
    }
}
