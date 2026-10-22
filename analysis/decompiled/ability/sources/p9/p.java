package p9;

import m9.C1718k;

/* loaded from: classes4.dex */
public final class p extends q9.c {

    /* renamed from: a, reason: collision with root package name */
    public long f5565a;
    public C1718k b;

    @Override // q9.c
    public final boolean a(q9.a aVar) {
        kotlinx.coroutines.flow.h hVar = (kotlinx.coroutines.flow.h) aVar;
        if (this.f5565a >= 0) {
            return false;
        }
        long j5 = hVar.i;
        if (j5 < hVar.f5228j) {
            hVar.f5228j = j5;
        }
        this.f5565a = j5;
        return true;
    }

    @Override // q9.c
    public final H7.c[] b(q9.a aVar) {
        long j5 = this.f5565a;
        this.f5565a = -1L;
        this.b = null;
        return ((kotlinx.coroutines.flow.h) aVar).u(j5);
    }
}
