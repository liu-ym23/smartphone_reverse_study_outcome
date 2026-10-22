package v4;

import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l implements f5.c, h5.d {

    /* renamed from: a, reason: collision with root package name */
    public int f5978a = Integer.MIN_VALUE;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f5979b;

    public l(m mVar) {
        this.f5979b = mVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [f5.c[]] */
    /* JADX WARN: Type inference failed for: r2v2 */
    @Override // h5.d
    public final h5.d getCallerFrame() {
        k kVar = k.f5977a;
        int i8 = this.f5978a;
        m mVar = this.f5979b;
        if (i8 == Integer.MIN_VALUE) {
            this.f5978a = mVar.f5983f;
        }
        int i9 = this.f5978a;
        if (i9 < 0) {
            this.f5978a = Integer.MIN_VALUE;
            kVar = null;
        } else {
            try {
                ?? r22 = mVar.f5982e[i9];
                if (r22 != 0) {
                    this.f5978a = i9 - 1;
                    kVar = r22;
                }
            } catch (Throwable unused) {
            }
        }
        if (kVar instanceof h5.d) {
            return kVar;
        }
        return null;
    }

    @Override // f5.c
    public final f5.h getContext() {
        m mVar = this.f5979b;
        f5.c[] cVarArr = mVar.f5982e;
        int i8 = mVar.f5983f;
        f5.c cVar = cVarArr[i8];
        if (cVar != this && cVar != null) {
            return cVar.getContext();
        }
        int i9 = i8 - 1;
        while (i9 >= 0) {
            int i10 = i9 - 1;
            f5.c cVar2 = cVarArr[i9];
            if (cVar2 != this && cVar2 != null) {
                return cVar2.getContext();
            }
            i9 = i10;
        }
        throw new IllegalStateException("Not started");
    }

    @Override // f5.c
    public final void resumeWith(Object obj) {
        boolean z = obj instanceof b5.h;
        m mVar = this.f5979b;
        if (!z) {
            mVar.f(false);
            return;
        }
        Throwable thA = b5.i.a(obj);
        p.b(thA);
        mVar.g(a.a.o(thA));
    }
}
