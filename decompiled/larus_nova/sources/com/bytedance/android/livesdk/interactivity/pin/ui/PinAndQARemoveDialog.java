package com.bytedance.android.livesdk.interactivity.pin.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.livesdk.interactivity.pin.container.v2.g;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/ui/PinAndQARemoveDialog;", "Landroidx/appcompat/app/AppCompatDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinAndQARemoveDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f138871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f138872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f138873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f138874d;

    public interface a {
        void a();

        void b();
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PinAndQARemoveDialog f138875a;

        public b(PinAndQARemoveDialog r100) {
            this.f138875a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f138875a.f138874d.b();
            PinAndQARemoveDialog r101 = this.f138875a;
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
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PinAndQARemoveDialog f138876a;

        public c(PinAndQARemoveDialog r100) {
            this.f138876a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f138876a.f138874d.a();
            PinAndQARemoveDialog r101 = this.f138876a;
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
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PinAndQARemoveDialog f138877a;

        public d(PinAndQARemoveDialog r100) {
            this.f138877a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            PinAndQARemoveDialog r101 = this.f138877a;
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
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setGravity(80);
    L5:
        setContentView(R.layout.ttlive_pin_and_qa_remove_dialog);
        Window r102 = getWindow();
        if (r102 == null) goto L8;
        r102.setLayout(-1, -2);
    L8:
        TextView r103 = (TextView) this.f138871a.getValue();
        if (r103 == null) goto L11;
        r103.setOnClickListener(new b(this));
    L11:
        TextView r104 = (TextView) this.f138872b.getValue();
        if (r104 == null) goto L14;
        r104.setOnClickListener(new c(this));
    L14:
        TextView r105 = (TextView) this.f138873c.getValue();
        if (r105 == null) goto L18;
        r105.setOnClickListener(new d(this));
        return;
    }

    public PinAndQARemoveDialog(Context r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100, R.style.ttlive_common_bottom_dialog_normal);
        this.f138874d = r101;
        this.f138871a = LazyKt.lazy(new PinAndQARemoveDialog$tvRemoveItem$2(this));
        this.f138872b = LazyKt.lazy(new PinAndQARemoveDialog$tvRemoveAll$2(this));
        this.f138873c = LazyKt.lazy(new PinAndQARemoveDialog$cancelView$2(this));
    }
}
