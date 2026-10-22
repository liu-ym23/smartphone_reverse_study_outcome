package p7;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l implements m7.o {

    /* renamed from: g, reason: collision with root package name */
    public static final k f9877g;

    /* renamed from: c, reason: collision with root package name */
    public p5.c f9878c;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap f9879f;

    static {
        int i = 0;
        f9877g = new k(i);
        new k(i);
    }

    @Override // m7.o
    public final m7.n a(m7.e eVar, t7.a aVar) {
        n7.a aVar2 = (n7.a) aVar.getRawType().getAnnotation(n7.a.class);
        if (aVar2 == null) {
            return null;
        }
        return b(this.f9878c, eVar, aVar, aVar2, true);
    }

    public final m7.n b(p5.c cVar, m7.e eVar, t7.a aVar, n7.a aVar2, boolean z10) {
        m7.n nVarA;
        Object objB = cVar.k(t7.a.get(aVar2.value()), true).b();
        boolean zNullSafe = aVar2.nullSafe();
        if (objB instanceof m7.n) {
            nVarA = (m7.n) objB;
        } else {
            if (!(objB instanceof m7.o)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objB.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            m7.o oVar = (m7.o) objB;
            if (z10) {
                m7.o oVar2 = (m7.o) this.f9879f.putIfAbsent(aVar.getRawType(), oVar);
                if (oVar2 != null) {
                    oVar = oVar2;
                }
            }
            nVarA = oVar.a(eVar, aVar);
        }
        return (nVarA == null || !zNullSafe) ? nVarA : nVarA.nullSafe();
    }
}
