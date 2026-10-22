package com.bytedance.android.ec.common.impl.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.model.promotion.ECResultDialogContentVO;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f43593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f43594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintLayout f43595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f43596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f43597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f43598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ECResultDialogContentVO f43599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f43600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f43601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f43602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Unit> f43603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Unit> f43604l;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        Function0<Unit> r100 = this.f43602j;
        if (r100 == null) goto L5;
        Unit r101 = r100.invoke();
    L5:
        Handler r102 = DialogLancet.resolveDialogHandler(this);
        if (r102 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r103 == null) goto L19;
        d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r102.getLooper()) goto L10;
        r102.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Function0<Unit> r100 = this.f43601i;
        if (r100 == null) goto L14;
        Unit r101 = r100.invoke();
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.shopping_layout_appointment_dialog);
        this.f43594b = (TextView) findViewById(R.id.tv_message);
        this.f43593a = (TextView) findViewById(R.id.tv_title);
        this.f43598f = (TextView) findViewById(R.id.tv_confirm);
        this.f43595c = (ConstraintLayout) findViewById(R.id.mutiple_options_part);
        this.f43596d = (TextView) findViewById(R.id.confirm_btn);
        this.f43597e = (TextView) findViewById(R.id.cancel_btn);
        getContext();
        Window r101 = getWindow();
        if (r101 == null) goto L10;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = -1;
        r102.height = -2;
        r101.setAttributes(r102);
        View r103 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L9:
        r103.setPadding(0, 0, 0, 0);
        r101.setBackgroundDrawableResource(R.color.transparent);
    L10:
        final ECResultDialogContentVO r105 = this.f43599g;
        if (r105 == null) goto L43;
        TextView r106 = this.f43593a;
        if (r106 == null) goto L15;
        r106.setText(r105.getTitle());
    L15:
        TextView r107 = this.f43594b;
        if (r107 == null) goto L19;
        r107.setText(r105.getContent());
    L19:
        if (this.f43600h != 0) goto L26;
        ConstraintLayout r108 = this.f43595c;
        if (r108 == null) goto L23;
        r108.setVisibility(8);
    L23:
        TextView r109 = this.f43598f;
        if (r109 == null) goto L43;
        r109.setVisibility(0);
        r109.setText(r105.getConfirm());
        f.c(r109, null, null, new ECShowResultDialog$configSingleOption$$inlined$apply$lambda$1(this, r105), 3);
        goto L43
    L26:
        ConstraintLayout r110 = this.f43595c;
        if (r110 == null) goto L40;
        r110.setVisibility(0);
        TextView r111 = this.f43596d;
        if (r111 == null) goto L31;
        r111.setText(r105.getConfirm());
    L31:
        TextView r112 = this.f43597e;
        if (r112 == null) goto L34;
        r112.setText(r105.getCancel());
    L34:
        TextView r113 = this.f43596d;
        if (r113 == null) goto L37;
        f.c(r113, null, null, new ECShowResultDialog$configMultiOption$$inlined$apply$lambda$1(this, r105), 3);
    L37:
        TextView r114 = this.f43597e;
        if (r114 == null) goto L40;
        f.c(r114, null, null, new ECShowResultDialog$configMultiOption$$inlined$apply$lambda$2(this, r105), 3);
    L40:
        TextView r115 = this.f43598f;
        if (r115 == null) goto L43;
        r115.setVisibility(8);
    L43:
        setCanceledOnTouchOutside(false);
    }

    public a(Context r100, ECResultDialogContentVO r101, int r102, Function0<Unit> r103, Function0<Unit> r104, Function0<Unit> r105, Function0<Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        this.f43599g = r101;
        this.f43600h = r102;
        this.f43601i = r103;
        this.f43602j = r104;
        this.f43603k = r105;
        this.f43604l = r106;
    }
}
