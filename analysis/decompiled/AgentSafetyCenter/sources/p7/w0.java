package p7;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w0 implements m7.o {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9912c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Class f9913f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ m7.n f9914g;

    public /* synthetic */ w0(int i) {
        this.f9912c = i;
    }

    @Override // m7.o
    public final m7.n a(m7.e eVar, t7.a aVar) {
        switch (this.f9912c) {
            case 0:
                if (aVar.getRawType() == this.f9913f) {
                    return this.f9914g;
                }
                return null;
            default:
                Class<?> rawType = aVar.getRawType();
                if (!this.f9913f.isAssignableFrom(rawType)) {
                    return null;
                }
                c cVar = new c(1);
                cVar.f9841c = this;
                cVar.f9840b = rawType;
                VarHandle.storeStoreFence();
                return cVar;
        }
    }

    public final String toString() {
        switch (this.f9912c) {
            case 0:
                return "Factory[type=" + this.f9913f.getName() + ",adapter=" + this.f9914g + "]";
            default:
                return "Factory[typeHierarchy=" + this.f9913f.getName() + ",adapter=" + this.f9914g + "]";
        }
    }
}
