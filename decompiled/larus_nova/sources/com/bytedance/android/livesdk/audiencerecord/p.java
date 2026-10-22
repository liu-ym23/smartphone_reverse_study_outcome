package com.bytedance.android.livesdk.audiencerecord;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class p extends Dialog {

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f104064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f104065b;

        public a(p r100, c r101) {
            this.f104064a = r100;
            this.f104065b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            p r101 = this.f104064a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
        L17:
            this.f104065b.a();
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
            goto L17
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f104066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f104067b;

        public b(p r100, c r101) {
            this.f104066a = r100;
            this.f104067b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            p r101 = this.f104066a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
        L17:
            this.f104067b.b();
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
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
        com.bytedance.android.livesdk.f.d().a();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        com.bytedance.android.livesdk.f.d().f();
    }

    public p(DataCenter r100, Context r101, c r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "callback");
        super(r101, R.style.ttlive_live_dialog);
        BacktrackState r103 = null;
        setContentView(LayoutInflater.from(r101).inflate(R.layout.ttlive_dialog_audience_backtrace_cancel, null));
        if (r100 == null) goto L5;
        se1.c r104 = (se1.c) r100.get("data_audience_backtrace_service");
    L6:
        if (r104 == null) goto L8;
        o r105 = r104.a();
    L9:
        if (r105 == null) goto L12;
        r103 = r105.f104061a;
    L12:
        if (r103 != BacktrackState.DONE) goto L16;
        TextView r106 = (TextView) findViewById(R.id.continue_record);
        if (r106 == null) goto L16;
        r106.setText(R.string.ttlive_live_backtrack_cancel_continue_record_v2);
    L16:
        ((TextView) findViewById(R.id.sure_cancel)).setOnClickListener(new a(this, r102));
        ((TextView) findViewById(R.id.continue_record)).setOnClickListener(new b(this, r102));
        return;
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }
}
