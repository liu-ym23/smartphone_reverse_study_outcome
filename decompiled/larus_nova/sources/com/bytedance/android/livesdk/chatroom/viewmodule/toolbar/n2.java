package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n2 extends Dialog {

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n2 f116608a;

        public a(n2 r100) {
            this.f116608a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            List<i2.a> r101 = i2.f116348a;
            i2.f116349b = false;
            n2 r102 = this.f116608a;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r102);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r104 == null) goto L16;
            com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r103.getLooper()) goto L7;
            r103.post(DialogLancet.createDismissRunnable(r102));
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        List<i2.a> r100 = i2.f116348a;
        i2.f116349b = false;
        ALogger.w("ShadowNoneBrightnessDialog", "dialog dismiss");
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L7;
        r101.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        Window r100 = getWindow();
        if (r100 == null) goto L6;
        WindowManager.LayoutParams r101 = r100.getAttributes();
        r101.screenBrightness = 0.1f;
        r100.setAttributes(r101);
        r100.setDimAmount(0.0f);
        ALogger.w("ShadowNoneBrightnessDialog", "try set brightness to 0.1");
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        ALogger.w("ShadowNoneBrightnessDialog", "dialog show");
        List<i2.a> r100 = i2.f116348a;
        i2.f116349b = true;
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public n2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ttlive_common_full_screen_dialog);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setLayout(-1, -1);
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.screenBrightness = 0.1f;
        r101.setAttributes(r102);
        r101.setDimAmount(0.0f);
        ALogger.w("ShadowNoneBrightnessDialog", "try set brightness to 0.1");
    L5:
        View r103 = new View(getContext());
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r103.setOnClickListener(new a(this));
        setContentView(r103);
    }
}
