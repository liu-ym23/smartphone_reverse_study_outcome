package p7;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u implements m7.o {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f9900c;

    @Override // m7.o
    public final m7.n a(m7.e eVar, t7.a aVar) {
        if (aVar.getRawType() != Object.class) {
            return null;
        }
        int i = this.f9900c;
        v vVar = new v();
        vVar.f9902a = eVar;
        vVar.f9903b = i;
        VarHandle.storeStoreFence();
        return vVar;
    }
}
