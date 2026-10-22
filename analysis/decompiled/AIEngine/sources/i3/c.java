package i3;

import java.lang.annotation.Annotation;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements q3.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9493a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f9494b;

    public static c b(c cVar, c cVar2) {
        HashMap map;
        HashMap map2;
        if (cVar == null || (map = cVar.f9494b) == null || map.isEmpty()) {
            return cVar2;
        }
        if (cVar2 == null || (map2 = cVar2.f9494b) == null || map2.isEmpty()) {
            return cVar;
        }
        HashMap map3 = new HashMap();
        for (Annotation annotation : cVar2.f9494b.values()) {
            map3.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : cVar.f9494b.values()) {
            map3.put(annotation2.annotationType(), annotation2);
        }
        return new c(map3);
    }

    @Override // q3.a
    public Annotation a(Class cls) {
        HashMap map = this.f9494b;
        if (map == null) {
            return null;
        }
        return (Annotation) map.get(cls);
    }

    @Override // q3.a
    public int size() {
        HashMap map = this.f9494b;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public String toString() {
        switch (this.f9493a) {
            case 0:
                HashMap map = this.f9494b;
                return map == null ? "[null]" : map.toString();
            default:
                return super.toString();
        }
    }

    public c(HashMap map) {
        this.f9493a = 0;
        this.f9494b = map;
    }
}
