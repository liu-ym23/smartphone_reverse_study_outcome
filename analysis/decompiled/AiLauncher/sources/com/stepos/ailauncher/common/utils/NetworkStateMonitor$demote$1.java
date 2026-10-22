package com.stepos.ailauncher.common.utils;

import Ua.M;
import Ua.U;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.common.utils.NetworkStateMonitor$demote$1", f = "NetworkStateMonitor.kt", l = {184}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class NetworkStateMonitor$demote$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;

    public NetworkStateMonitor$demote$1(InterfaceC4014c<? super NetworkStateMonitor$demote$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new NetworkStateMonitor$demote$1(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((NetworkStateMonitor$demote$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            this.label = 1;
            if (U.a(10000L, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (NetworkStateMonitor._phase.d(NetworkPhase.CONNECTING, NetworkPhase.LOST)) {
            C4148a.k("NetworkStateMonitor", "phase CONNECTING -> LOST (grace period elapsed)", false, 4, null);
        } else {
            C4148a.k("NetworkStateMonitor", "grace period elapsed but phase already " + NetworkStateMonitor._phase.getValue() + ", skip demote", false, 4, null);
        }
        return Y8.t.f7040a;
    }
}
