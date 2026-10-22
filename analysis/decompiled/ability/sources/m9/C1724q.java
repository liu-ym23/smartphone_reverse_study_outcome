package m9;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* renamed from: m9.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1724q extends kotlinx.coroutines.c implements InterfaceC1723p {
    public C1724q() {
        super(true);
        R(null);
    }

    @Override // m9.InterfaceC1686D
    public final Object f(SuspendLambda suspendLambda) {
        Object objZ = z(suspendLambda);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objZ;
    }

    public final boolean g0(Throwable th) {
        return U(new C1727t(th, false));
    }
}
