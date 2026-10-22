package com.smt.obric.appstore.domain.usecase.app.install;

import com.bytedanceos.common.toolbox.j;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.smt.obric.appstore.domain.app.entity.AppInstallMode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.u;

/* JADX INFO: loaded from: classes4.dex */
public final class InstallSysAppAutoUpdateManuallyUseCase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppInstallActor f18142a;

    public InstallSysAppAutoUpdateManuallyUseCase(AppInstallActor r10) {
        q.g(r10, "actor");
        this.f18142a = r10;
    }

    public final Object a(String r10, AppInstallMode r11, Continuation r12) {
        if ((r12 instanceof InstallSysAppAutoUpdateManuallyUseCase$invoke$1) == false) goto L7;
        InstallSysAppAutoUpdateManuallyUseCase$invoke$1 r13 = (InstallSysAppAutoUpdateManuallyUseCase$invoke$1) r12;
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
        String r18 = (String) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L15
    L28:
        j.o("[AppStatus][InstallSysAppAutoUpdateManuallyUseCase] complete: pkg=" + r18);
        return Unit.f21064a;
    L15:
        Throwable th = th;
    L32:
        j.o("[AppStatus][InstallSysAppAutoUpdateManuallyUseCase] complete: pkg=" + r18);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        CompletableDeferred r19 = (CompletableDeferred) r13.L$1;
        r10 = (String) r13.L$0;
        kotlin.c.b(r15);
    L36:
        j.o("[AppStatus][InstallSysAppAutoUpdateManuallyUseCase] wait ack: pkg=" + r10);     // Catch: Throwable -> L30
        r13.L$0 = r10;     // Catch: Throwable -> L30
        r13.L$1 = null;     // Catch: Throwable -> L30
        r13.label = 2;     // Catch: Throwable -> L30
        if (r19.await(r13) != r16) goto L27;
        return r16;
    L27:
        r18 = r10;
    L30:
        th = move-exception;
        String r20 = r10;
        th = th;
        r18 = r20;
        goto L32
    L20:
        kotlin.c.b(r15);
        j.n("[AppStatus][InstallSysAppAutoUpdateManuallyUseCase] invoke: pkg=" + r10);
        CompletableDeferred r110 = u.b(null, 1, null);
        SendChannel r21 = this.f18142a.T();
        AppInstallActor.b.t r22 = new AppInstallActor.b.t(r10, r110, r11);
        r13.L$0 = r10;
        r13.L$1 = r110;
        r13.label = 1;
        if (r21.send(r22, r13) != r16) goto L23;
        return r16;
    L23:
        r19 = r110;
    L7:
        r13 = new InstallSysAppAutoUpdateManuallyUseCase$invoke$1(this, r12);
        goto L8
    }
}
