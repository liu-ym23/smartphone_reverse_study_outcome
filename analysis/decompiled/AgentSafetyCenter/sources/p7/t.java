package p7;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t extends m7.n {

    /* renamed from: b, reason: collision with root package name */
    public static final s f9898b;

    /* renamed from: a, reason: collision with root package name */
    public int f9899a;

    static {
        t tVar = new t();
        tVar.f9899a = 2;
        VarHandle.storeStoreFence();
        s sVar = new s(0);
        sVar.f9897f = tVar;
        VarHandle.storeStoreFence();
        f9898b = sVar;
    }

    @Override // m7.n
    public final Object read(u7.a aVar) {
        u7.b bVarY = aVar.Y();
        int iOrdinal = bVarY.ordinal();
        if (iOrdinal == 5 || iOrdinal == 6) {
            return k0.a.a(this.f9899a, aVar);
        }
        if (iOrdinal == 8) {
            aVar.U();
            return null;
        }
        StringBuilder sb2 = new StringBuilder("Expecting number, got: ");
        sb2.append(bVarY);
        String strA = aVar.A();
        sb2.append("; at path ");
        sb2.append(strA);
        throw new m7.h(sb2.toString());
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        cVar.R((Number) obj);
    }
}
