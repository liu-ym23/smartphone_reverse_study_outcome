package com.bytedance.android.livesdk.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class p0 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f161907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CountDownTimer f161908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f161909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f161910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f161911e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f161912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f161913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f161914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public DialogInterface.OnClickListener f161915d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f161916e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f161917f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Function0<Unit> f161918g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Context f161919h;

        public final void a() {
            p0 r100 = new p0(this.f161919h, this);
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r100);
            return;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r100);
            r100.show();
            DialogLancet.afterDialogShow(r100);
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, "mContext");
            this.f161919h = r100;
            this.f161914c = "回到个播";
            this.f161916e = 10;
            this.f161917f = true;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p0 f161920a;

        public b(p0 r100) {
            this.f161920a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            p0.a(this.f161920a);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        CountDownTimer r101 = this.f161908b;
        if (r101 == null) goto L20;
        r101.cancel();
    L20:
        this.f161908b = null;
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
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CountDownTimer r100 = this.f161908b;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f161908b = null;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r100 = getWindow();
        if (r100 == null) goto L21;
        WindowManager.LayoutParams r101 = r100.getAttributes();
        if (r101 == null) goto L12;
        r101.width = (int) UIUtils.dip2Px(getContext(), this.f161907a);
    L12:
        if (r101 == null) goto L14;
        r101.height = -2;
    L14:
        if (r101 == null) goto L16;
        r101.gravity = 17;
    L16:
        r100.setAttributes(r101);
        return;
    L21:
        return;
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public static final void a(p0 r100) {
        DialogInterface.OnClickListener r101 = r100.f161911e.f161915d;
        if (r101 == null) goto L5;
        r101.onClick(r100, 1);
    L5:
        Window r102 = r100.getWindow();
        if (r102 == null) goto L12;
        View r103 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L14;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L14;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L14:
        if (r100.isShowing() == false) goto L36;
        if (r102 == null) goto L40;
        if (r103 != null) goto L18;
        return;
    L18:
        if (r103.isAttachedToWindow() != true) goto L42;
        Handler r105 = DialogLancet.resolveDialogHandler(r100);
        if (r105 != null) goto L22;
    L24:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L27 Exception -> L29
    L33:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L29:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L27
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L27
        if (r106 == null) goto L33;
        com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L22:
        if (Looper.myLooper() == r105.getLooper()) goto L24;
        r105.post(DialogLancet.createDismissRunnable(r100));
        return;
    L42:
        return;
    L40:
        return;
    L36:
        return;
    L12:
        r103 = null;
        goto L14
    }

    public final void b(int r100) {
        TextView r101 = this.f161910d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
    L5:
        if (r100 <= 0) goto L7;
        String r102 = this.f161911e.f161914c + '(' + r100 + "s)";
    L8:
        r101.setText(r102);
        return;
    L7:
        r102 = this.f161911e.f161914c;
        goto L8
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setCancelable(false);
        this.f161911e.getClass();
        setCanceledOnTouchOutside(false);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_countdown_alert, null);
        setContentView(r101);
        TextView r102 = (TextView) r101.findViewById(R.id.title);
        TextView r103 = (TextView) r101.findViewById(R.id.message);
        this.f161910d = (TextView) r101.findViewById(R.id.btn_confirm);
        String r104 = this.f161911e.f161912a;
        String r105 = "";
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        r102.setText(r104);
        String r106 = this.f161911e.f161913b;
        if (r106 == null) goto L9;
        r105 = r106;
    L9:
        r103.setText(r105);
        TextView r107 = this.f161910d;
        if (r107 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
    L12:
        r107.setOnClickListener(new b(this));
        b(this.f161909c);
        CountDownTimer r108 = this.f161908b;
        if (r108 == null) goto L15;
        r108.cancel();
    L15:
        this.f161908b = new q0(this, ((long) this.f161911e.f161916e) * 1000).start();
    }

    public p0(Context r100, a r101) {
        super(r100, R.style.ttlive_live_dialog);
        this.f161911e = r101;
        this.f161907a = 280;
        this.f161909c = r101.f161916e;
    }
}
