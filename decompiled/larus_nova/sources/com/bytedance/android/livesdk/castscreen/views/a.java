package com.bytedance.android.livesdk.castscreen.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import androidx.core.view.GravityCompat;
import com.bytedance.android.livesdk.config.nj;
import com.bytedance.android.livesdk.f;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes7.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f104758b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f104759a;

    static {
        f104758b = nj.f120837a.getValue().booleanValue();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        f.d().f();
        com.bytedance.android.livesdk.e.b().d();
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        Window r100 = getWindow();
        if (r100 == null) goto L9;
        r100.setBackgroundDrawable(new ColorDrawable(0));
        if (this.f104759a == false) goto L7;
        r100.setLayout(-1, -2);
        return;
    L7:
        r100.setLayout(-2, -1);
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        f.d().a();
        com.bytedance.android.livesdk.e.b().a();
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public a(Context r100, boolean r101, Integer r102) {
        if (r102 != null) goto L9;
        if (r101 == true) goto L5;
        int r103 = R.style.ttlive_CommonRightDialog;
    L10:
        super(r100, r103);
        Window r104 = getWindow();
        if (r104 == null) goto L16;
        getWindow().requestFeature(1);
        if (r101 == false) goto L15;
        r104.setGravity(80);
        goto L16
    L15:
        r104.setGravity(GravityCompat.END);
    L16:
        this.f104759a = r101;
        return;
    L5:
        if (f104758b == false) goto L7;
        r103 = R.style.ttlive_CommonBottomDialog_New_Portrait_Style;
        goto L10
    L7:
        r103 = R.style.ttlive_CommonBottomDialog;
        goto L10
    L9:
        r103 = r102.intValue();
        goto L10
    }
}
