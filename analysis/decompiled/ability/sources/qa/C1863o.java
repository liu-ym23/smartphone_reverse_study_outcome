package qa;

import F9.InterfaceC0228f;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* renamed from: qa.o, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1863o extends AbstractC1864p {
    public final InterfaceC1854f d;
    public final boolean e;

    public C1863o(K k, InterfaceC0228f interfaceC0228f, InterfaceC1859k interfaceC1859k, InterfaceC1854f interfaceC1854f, boolean z10) {
        super(k, interfaceC0228f, interfaceC1859k);
        this.d = interfaceC1854f;
        this.e = z10;
    }

    @Override // qa.AbstractC1864p
    public final Object a(v vVar, Object[] objArr) {
        InterfaceC1852d interfaceC1852d = (InterfaceC1852d) this.d.i(vVar);
        H7.c cVar = (H7.c) objArr[objArr.length - 1];
        try {
            if (!this.e) {
                return retrofit2.a.a(interfaceC1852d, cVar);
            }
            kotlin.jvm.internal.k.d(interfaceC1852d, "null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>");
            return retrofit2.a.b(interfaceC1852d, cVar);
        } catch (LinkageError | ThreadDeath | VirtualMachineError e) {
            throw e;
        } catch (Throwable th) {
            retrofit2.a.c(th, cVar);
            return CoroutineSingletons.f4909a;
        }
    }
}
