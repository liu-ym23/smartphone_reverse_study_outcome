package com.smt.obric.appstore.domain.usecase.app.install;

import com.bytedanceos.common.toolbox.j;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.u;

/* JADX INFO: loaded from: classes4.dex */
public final class ResumeAppDownloadUseCase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppInstallActor f18143a;

    public ResumeAppDownloadUseCase(AppInstallActor r10) {
        q.g(r10, "appInstallActor");
        this.f18143a = r10;
    }

    public final Object a(String r10, boolean r11, Continuation r12) {
        if ((r12 instanceof ResumeAppDownloadUseCase$invoke$1) == false) goto L7;
        ResumeAppDownloadUseCase$invoke$1 r13 = (ResumeAppDownloadUseCase$invoke$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L20;
        if (r17 == 1) goto L19;
        if (r17 != 2) goto L18;
        boolean r18 = r13.Z$0;
        r10 = (String) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L15
    L28:
        boolean r19 = ((Boolean) r15).booleanValue();     // Catch: Throwable -> L15
        j.o("[AppStatus][ResumeAppDownloadUseCase] complete: pkg=" + r10 + ", wifiOnly=" + r18);
        return tf.a.a(r19);
    L15:
        Throwable th = th;
    L33:
        j.o("[AppStatus][ResumeAppDownloadUseCase] complete: pkg=" + r10 + ", wifiOnly=" + r18);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r11 = r13.Z$0;
        CompletableDeferred r20 = (CompletableDeferred) r13.L$1;
        r10 = (String) r13.L$0;
        kotlin.c.b(r15);
    L37:
        j.o("[AppStatus][ResumeAppDownloadUseCase] wait ack: pkg=" + r10 + ", wifiOnly=" + r11);     // Catch: Throwable -> L31
        r13.L$0 = r10;     // Catch: Throwable -> L31
        r13.L$1 = null;     // Catch: Throwable -> L31
        r13.Z$0 = r11;     // Catch: Throwable -> L31
        r13.label = 2;     // Catch: Throwable -> L31
        r15 = r20.await(r13);     // Catch: Throwable -> L31
        if (r15 != r16) goto L27;
        return r16;
    L27:
        r18 = r11;
    L31:
        th = move-exception;
        boolean r21 = r11;
        th = th;
        r18 = r21;
        goto L33
    L20:
        kotlin.c.b(r15);
        j.n("[AppStatus][ResumeAppDownloadUseCase] invoke: pkg=" + r10 + ", wifiOnly=" + r11);
        CompletableDeferred r110 = u.b(null, 1, null);
        SendChannel r22 = this.f18143a.T();
        AppInstallActor.b.u r23 = new AppInstallActor.b.u(r10, r11, r110);
        r13.L$0 = r10;
        r13.L$1 = r110;
        r13.Z$0 = r11;
        r13.label = 1;
        if (r22.send(r23, r13) != r16) goto L23;
        return r16;
    L23:
        r20 = r110;
    L7:
        r13 = new ResumeAppDownloadUseCase$invoke$1(this, r12);
        goto L8
    }
}
