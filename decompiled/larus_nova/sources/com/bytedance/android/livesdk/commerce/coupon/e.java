package com.bytedance.android.livesdk.commerce.coupon;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f119609a;

    public static void a(e r100) {
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
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (getWindow() != null) goto L6;
        a(this);
        return;
    L6:
        Window r101 = getWindow();
        if (r101 == null) goto L9;
        r101.setGravity(17);
    L9:
        View r102 = this.f119609a;
        if (r102 == null) goto L26;
        setContentView(r102);
        Window r103 = getWindow();
        if (r103 == null) goto L14;
        r103.setLayout(-1, -1);
    L14:
        Window r104 = getWindow();
        if (r104 == null) goto L17;
        r104.setBackgroundDrawableResource(R.color.ttlive_color_8A_000000);
    L17:
        Window r105 = getWindow();
        if (r105 == null) goto L21;
        r105.setDimAmount(0.0f);
    L21:
        if (DigHoleScreenUtil.isDigHole(getContext()) == true) goto L28;
        Window r106 = getWindow();
        if (r106 == null) goto L29;
        r106.addFlags(1024);
        return;
    L29:
        return;
    L28:
        return;
    L26:
        a(this);
    }

    public e(Context r100, LiveCouponView r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f119609a = r101;
    }
}
