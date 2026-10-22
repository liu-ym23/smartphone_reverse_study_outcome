package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.annie.view.DoubleColorBallAnimationView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DoubleColorBallAnimationView f129272a;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Activity r100 = getOwnerActivity();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L18;
        a(this);     // Catch: Exception -> L9
    L10:
        DoubleColorBallAnimationView r101 = this.f129272a;
        if (r101 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mDoubleColorBallAnimationView");
    L13:
        r101.f40087i = false;
        r101.f40085g = false;
        r101.f40083e = 0.0f;
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (isShowing() == true) goto L22;
        Activity r100 = getOwnerActivity();
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isFinishing() == false) goto L10;
        return;
    L10:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(this);
    L14:
        DoubleColorBallAnimationView r101 = this.f129272a;
        if (r101 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDoubleColorBallAnimationView");
    L17:
        r101.a();
        r101.f40087i = true;
        r101.f40084f = true;
        r101.postInvalidate();
        return;
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L13:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L14
    }

    public b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ttlive_dialog_fullscreen);
        setOwnerActivity(r100);
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.ttlive_gift_cache_cleaning_dialog);
        this.f129272a = (DoubleColorBallAnimationView) findViewById(R.id.clean_gift_cache_double_loading_view);
    }
}
