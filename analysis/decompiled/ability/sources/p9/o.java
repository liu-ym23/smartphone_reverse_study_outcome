package p9;

import m9.C1718k;
import m9.InterfaceC1693K;

/* loaded from: classes4.dex */
public final class o implements InterfaceC1693K {

    /* renamed from: a, reason: collision with root package name */
    public final kotlinx.coroutines.flow.h f5564a;
    public final long b;
    public final Object c;
    public final C1718k d;

    public o(kotlinx.coroutines.flow.h hVar, long j5, Object obj, C1718k c1718k) {
        this.f5564a = hVar;
        this.b = j5;
        this.c = obj;
        this.d = c1718k;
    }

    @Override // m9.InterfaceC1693K
    public final void dispose() {
        kotlinx.coroutines.flow.h hVar = this.f5564a;
        synchronized (hVar) {
            if (this.b < hVar.o()) {
                return;
            }
            Object[] objArr = hVar.h;
            kotlin.jvm.internal.k.c(objArr);
            long j5 = this.b;
            if (objArr[((int) j5) & (objArr.length - 1)] != this) {
                return;
            }
            e.d(objArr, j5, e.b);
            hVar.j();
        }
    }
}
