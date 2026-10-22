package g5;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import d5.u;
import d5.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class t implements v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f9069a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f9070b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends u<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f9071a;

        public a(Class cls) {
            this.f9071a = cls;
        }

        @Override // d5.u
        public final Object a(k5.a aVar) {
            Object objA = t.this.f9070b.a(aVar);
            if (objA != null) {
                Class cls = this.f9071a;
                if (!cls.isInstance(objA)) {
                    throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + objA.getClass().getName() + "; at path " + aVar.g0());
                }
            }
            return objA;
        }

        @Override // d5.u
        public final void b(k5.b bVar, Object obj) {
            t.this.f9070b.b(bVar, obj);
        }
    }

    public t(Class cls, u uVar) {
        this.f9069a = cls;
        this.f9070b = uVar;
    }

    @Override // d5.v
    public final <T2> u<T2> b(d5.i iVar, TypeToken<T2> typeToken) {
        Class<? super T2> rawType = typeToken.getRawType();
        if (this.f9069a.isAssignableFrom(rawType)) {
            return new a(rawType);
        }
        return null;
    }

    public final String toString() {
        return "Factory[typeHierarchy=" + this.f9069a.getName() + ",adapter=" + this.f9070b + "]";
    }
}
