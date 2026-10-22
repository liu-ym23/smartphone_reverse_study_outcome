package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class m3<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f161830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f161831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f161832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f161833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f161834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f161835f;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleEmitter f161836a;

        public a(SingleEmitter r100) {
            this.f161836a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
            this.f161836a.onSuccess(Boolean.TRUE);
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleEmitter f161837a;

        public b(SingleEmitter r100) {
            this.f161837a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
            this.f161837a.onSuccess(Boolean.FALSE);
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleEmitter f161838a;

        public c(SingleEmitter r100) {
            this.f161838a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            this.f161838a.onSuccess(Boolean.FALSE);
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x0 f161839a;

        public d(x0 r100) {
            this.f161839a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            x0 r100 = this.f161839a;
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r102 == null) goto L16;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L7;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }
    }

    public m3(Context r100, String r101, String r102, String r103, String r104) {
        this.f161830a = r100;
        this.f161831b = r101;
        this.f161832c = r102;
        this.f161833d = r103;
        this.f161834e = r104;
        this.f161835f = true;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Context r101 = this.f161830a;
        x0.d r102 = new x0.d();
        r102.f162243b = r101;
        r102.f162242a = 0;
        r102.f162242a = 4;
        r102.f162244c = this.f161831b;
        r102.f162245d = this.f161832c;
        String r103 = this.f161833d;
        a r104 = new a(r100);
        x0.c[] r105 = r102.f162248g;
        x0.c r106 = r105[0];
        if (r106 != null) goto L5;
        r106 = new x0.c();
        r105[0] = r106;
    L5:
        r106.f162239a = r103;
        r106.f162240b = r104;
        String r107 = this.f161834e;
        b r108 = new b(r100);
        x0.c[] r109 = r102.f162248g;
        x0.c r110 = r109[1];
        if (r110 != null) goto L8;
        r110 = new x0.c();
        r109[1] = r110;
    L8:
        r110.f162239a = r107;
        r110.f162240b = r108;
        r102.f162252k = this.f161835f;
        r102.f162249h = new c(r100);
        x0 r111 = new x0(r102.f162243b, r102);
        x0.b.g(r111);
        r100.setDisposable(Disposables.fromAction(new d(r111)));
    }
}
