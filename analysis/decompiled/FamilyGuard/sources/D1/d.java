package D1;

import A1.q;
import A1.t;
import A1.u;

/* loaded from: classes.dex */
public final class d implements u {

    /* renamed from: a, reason: collision with root package name */
    private final C1.c f1051a;

    public d(C1.c cVar) {
        this.f1051a = cVar;
    }

    t<?> a(C1.c cVar, A1.e eVar, com.google.gson.reflect.a<?> aVar, B1.b bVar) {
        t<?> lVar;
        Object objA = cVar.a(com.google.gson.reflect.a.get((Class) bVar.value())).a();
        if (objA instanceof t) {
            lVar = (t) objA;
        } else if (objA instanceof u) {
            lVar = ((u) objA).b(eVar, aVar);
        } else {
            boolean z5 = objA instanceof q;
            if (!z5 && !(objA instanceof A1.i)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            lVar = new l(z5 ? (q) objA : null, objA instanceof A1.i ? (A1.i) objA : null, eVar, aVar, null);
        }
        return (lVar == null || !bVar.nullSafe()) ? lVar : lVar.a();
    }

    @Override // A1.u
    public <T> t<T> b(A1.e eVar, com.google.gson.reflect.a<T> aVar) {
        B1.b bVar = (B1.b) aVar.getRawType().getAnnotation(B1.b.class);
        if (bVar == null) {
            return null;
        }
        return (t<T>) a(this.f1051a, eVar, aVar, bVar);
    }
}
