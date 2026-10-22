package com.smt.obric.appstore.domain.usecase.app.install;

import com.bytedanceos.common.toolbox.j;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.u;

/* JADX INFO: loaded from: classes4.dex */
public final class EnqueueAppInstallTaskUseCase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppInstallActor f18121a;

    public EnqueueAppInstallTaskUseCase(AppInstallActor r10) {
        q.g(r10, "actor");
        this.f18121a = r10;
    }

    public final Object a(com.smt.obric.appstore.domain.app.entity.a r10, Continuation r11) {
        if ((r11 instanceof EnqueueAppInstallTaskUseCase$invoke$1) == false) goto L7;
        EnqueueAppInstallTaskUseCase$invoke$1 r12 = (EnqueueAppInstallTaskUseCase$invoke$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L20;
        if (r16 == 1) goto L19;
        if (r16 != 2) goto L18;
        com.smt.obric.appstore.domain.app.entity.a r17 = (com.smt.obric.appstore.domain.app.entity.a) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L15
    L28:
        boolean r18 = ((Boolean) r14).booleanValue();     // Catch: Throwable -> L15
        j.o("[AppStatus][EnqueueAppInstallTaskUseCase] complete: " + r17.P());
        return tf.a.a(r18);
    L15:
        Throwable th = th;
    L33:
        j.o("[AppStatus][EnqueueAppInstallTaskUseCase] complete: " + r17.P());
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        CompletableDeferred r19 = (CompletableDeferred) r12.L$1;
        r10 = (com.smt.obric.appstore.domain.app.entity.a) r12.L$0;
        kotlin.c.b(r14);
    L35:
        j.o("[AppStatus][EnqueueAppInstallTaskUseCase] wait ack: " + r10.P());     // Catch: Throwable -> L31
        r12.L$0 = r10;     // Catch: Throwable -> L31
        r12.L$1 = null;     // Catch: Throwable -> L31
        r12.label = 2;     // Catch: Throwable -> L31
        r14 = r19.await(r12);     // Catch: Throwable -> L31
        if (r14 != r15) goto L27;
        return r15;
    L27:
        r17 = r10;
    L31:
        th = move-exception;
        com.smt.obric.appstore.domain.app.entity.a r20 = r10;
        th = th;
        r17 = r20;
        goto L33
    L20:
        kotlin.c.b(r14);
        j.o("[AppStatus][EnqueueAppInstallTaskUseCase] invoke: " + r10.P() + ", apkFilePath=" + r10.e() + ", dlUrl=" + r10.t());
        CompletableDeferred r110 = u.b(null, 1, null);
        SendChannel r21 = this.f18121a.T();
        AppInstallActor.b.o r22 = new AppInstallActor.b.o(r10, r110);
        r12.L$0 = r10;
        r12.L$1 = r110;
        r12.label = 1;
        if (r21.send(r22, r12) != r15) goto L23;
        return r15;
    L23:
        r19 = r110;
    L7:
        r12 = new EnqueueAppInstallTaskUseCase$invoke$1(this, r11);
        goto L8
    }
}
