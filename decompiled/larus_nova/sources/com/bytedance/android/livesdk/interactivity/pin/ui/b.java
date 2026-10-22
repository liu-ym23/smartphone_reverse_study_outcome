package com.bytedance.android.livesdk.interactivity.pin.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f138885a;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f138886a;

        public a(b r100) {
            this.f138886a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f138886a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.pin.ui.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC2202b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f138887a;

        public ViewOnClickListenerC2202b(b r100) {
            this.f138887a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f138887a.f138885a.invoke();
            b r101 = this.f138887a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L12:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_remove_pin_dialog, null);
        setContentView(r101);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        ((TextView) r101.findViewById(R.id.cancel)).setOnClickListener(new a(this));
        ((TextView) r101.findViewById(R.id.confirm)).setOnClickListener(new ViewOnClickListenerC2202b(this));
    }

    public b(Context r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "action");
        super(r100, R.style.ttlive_live_dialog);
        this.f138885a = r101;
    }
}
