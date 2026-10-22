package com.smt.obric.appstore.domain.usecase.app.install;

import com.bytedanceos.common.toolbox.j;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.u;

/* JADX INFO: loaded from: classes4.dex */
public final class CancelAppInstallUseCase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppInstallActor f18120a;

    public CancelAppInstallUseCase(AppInstallActor r10) {
        q.g(r10, "installActor");
        this.f18120a = r10;
    }

    public final Object a(String r10, Continuation r11) {
        if ((r11 instanceof CancelAppInstallUseCase$invoke$1) == false) goto L7;
        CancelAppInstallUseCase$invoke$1 r12 = (CancelAppInstallUseCase$invoke$1) r11;
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
        String r17 = (String) r12.L$0;
        kotlin.c.b(r14);     // Catch: Throwable -> L15
    L28:
        j.o("[AppStatus][CancelAppInstallUseCase] complete: pkg=" + r17);
        return Unit.f21064a;
    L15:
        Throwable th = th;
    L32:
        j.o("[AppStatus][CancelAppInstallUseCase] complete: pkg=" + r17);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        CompletableDeferred r18 = (CompletableDeferred) r12.L$1;
        r10 = (String) r12.L$0;
        kotlin.c.b(r14);
    L36:
        j.o("[AppStatus][CancelAppInstallUseCase] wait ack: pkg=" + r10);     // Catch: Throwable -> L30
        r12.L$0 = r10;     // Catch: Throwable -> L30
        r12.L$1 = null;     // Catch: Throwable -> L30
        r12.label = 2;     // Catch: Throwable -> L30
        if (r18.await(r12) != r15) goto L27;
        return r15;
    L27:
        r17 = r10;
    L30:
        th = move-exception;
        String r19 = r10;
        th = th;
        r17 = r19;
        goto L32
    L20:
        kotlin.c.b(r14);
        j.n("[AppStatus][CancelAppInstallUseCase] invoke: pkg=" + r10);
        CompletableDeferred r110 = u.b(null, 1, null);
        SendChannel r20 = this.f18120a.T();
        AppInstallActor.b.a r21 = new AppInstallActor.b.a(r10, r110);
        r12.L$0 = r10;
        r12.L$1 = r110;
        r12.label = 1;
        if (r20.send(r21, r12) != r15) goto L23;
        return r15;
    L23:
        r18 = r110;
    L7:
        r12 = new CancelAppInstallUseCase$invoke$1(this, r11);
        goto L8
    }
}
