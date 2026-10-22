package com.bytedance.android.livesdk.chatroom.backtrack;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdk.f;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.backtrack.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC1582a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f105231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f105232b;

        public ViewOnClickListenerC1582a(a r100, c r101) {
            this.f105231a = r100;
            this.f105232b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f105231a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
        L17:
            this.f105232b.a();
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
            goto L17
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f105233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f105234b;

        public b(a r100, c r101) {
            this.f105233a = r100;
            this.f105234b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f105233a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
        L17:
            this.f105234b.b();
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
            goto L17
        }
    }

    public interface c {
        void a();

        void b();
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        f.d().a();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        f.d().f();
    }

    public a(DataCenter r100, Context r101, c r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "callback");
        super(r101, R.style.ttlive_live_dialog);
        IAnchorBacktrackService r103 = null;
        setContentView(LayoutInflater.from(r101).inflate(R.layout.ttlive_dialog_anchor_backtrace_cancel, null));
        if (r100 == null) goto L5;
        r103 = (IAnchorBacktrackService) r100.get("data_backtrack_service", null);
    L5:
        if (r103 == null) goto L8;
        IAnchorBacktrackService.State r104 = r103.getState();
        if (r104 == null) goto L8;
    L10:
        if (r104 != IAnchorBacktrackService.State.BACKTRACK_DONE) goto L14;
        TextView r105 = (TextView) findViewById(R.id.continue_record);
        if (r105 == null) goto L14;
        r105.setText(R.string.ttlive_live_backtrack_cancel_continue_record_v2);
    L14:
        ((TextView) findViewById(R.id.sure_cancel)).setOnClickListener(new ViewOnClickListenerC1582a(this, r102));
        ((TextView) findViewById(R.id.continue_record)).setOnClickListener(new b(this, r102));
        return;
    L8:
        r104 = IAnchorBacktrackService.State.IDLE;
        goto L10
    }
}
