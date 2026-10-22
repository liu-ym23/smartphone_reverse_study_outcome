package g5;

import com.google.gson.reflect.TypeToken;
import d5.u;
import d5.v;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements v {

    /* renamed from: c, reason: collision with root package name */
    public static final a f8977c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f8978d;

    /* renamed from: a, reason: collision with root package name */
    public final f5.a f8979a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f8980b = new ConcurrentHashMap();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements v {
        private a() {
        }

        @Override // d5.v
        public final <T> u<T> b(d5.i iVar, TypeToken<T> typeToken) {
            throw new AssertionError("Factory should not be used");
        }

        public /* synthetic */ a(int i10) {
            this();
        }
    }

    static {
        int i10 = 0;
        f8977c = new a(i10);
        f8978d = new a(i10);
    }

    public d(f5.a aVar) {
        this.f8979a = aVar;
    }

    public final u<?> a(f5.a aVar, d5.i iVar, TypeToken<?> typeToken, e5.a aVar2, boolean z) {
        u<?> uVarB;
        Object objC = aVar.b(TypeToken.get((Class) aVar2.value())).c();
        boolean zNullSafe = aVar2.nullSafe();
        if (objC instanceof u) {
            uVarB = (u) objC;
        } else if (objC instanceof v) {
            v vVar = (v) objC;
            if (z) {
                v vVar2 = (v) this.f8980b.putIfAbsent(typeToken.getRawType(), vVar);
                if (vVar2 != null) {
                    vVar = vVar2;
                }
            }
            uVarB = vVar.b(iVar, typeToken);
        } else {
            boolean z3 = objC instanceof d5.s;
            if (!z3 && !(objC instanceof d5.n)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objC.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            n nVar = new n(z3 ? (d5.s) objC : null, objC instanceof d5.n ? (d5.n) objC : null, iVar, typeToken, z ? f8977c : f8978d, zNullSafe);
            zNullSafe = false;
            uVarB = nVar;
        }
        return (uVarB == null || !zNullSafe) ? uVarB : new d5.h(uVarB, 1);
    }

    @Override // d5.v
    public final <T> u<T> b(d5.i iVar, TypeToken<T> typeToken) {
        e5.a aVar = (e5.a) typeToken.getRawType().getAnnotation(e5.a.class);
        if (aVar == null) {
            return null;
        }
        return (u<T>) a(this.f8979a, iVar, typeToken, aVar, true);
    }
}
