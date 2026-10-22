package l3;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k extends j {

    /* renamed from: c, reason: collision with root package name */
    public final MapperConfig<?> f10214c;

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f10215d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f10216e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f10217f;

    public k(MapperConfig<?> mapperConfig, JavaType javaType, ConcurrentHashMap<String, String> concurrentHashMap, HashMap<String, JavaType> map) {
        super(javaType, mapperConfig.f3828b.f3789a);
        this.f10214c = mapperConfig;
        this.f10215d = concurrentHashMap;
        this.f10216e = map;
        this.f10217f = mapperConfig.k(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES);
    }

    @Override // k3.c
    public final String a(Object obj) {
        return f(obj.getClass());
    }

    @Override // k3.c
    public final String b() {
        TreeSet treeSet = new TreeSet();
        for (Map.Entry entry : this.f10216e.entrySet()) {
            if (((JavaType) entry.getValue()).x()) {
                treeSet.add(entry.getKey());
            }
        }
        return treeSet.toString();
    }

    @Override // k3.c
    public final JavaType c(DeserializationContext deserializationContext, String str) {
        if (this.f10217f) {
            str = str.toLowerCase();
        }
        return (JavaType) this.f10216e.get(str);
    }

    @Override // k3.c
    public final String e(Class cls, Object obj) {
        return obj == null ? f(cls) : f(obj.getClass());
    }

    public final String f(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getName();
        ConcurrentHashMap<String, String> concurrentHashMap = this.f10215d;
        String strX = concurrentHashMap.get(name);
        if (strX == null) {
            Class<?> cls2 = this.f10212a.j(cls).f3690a;
            MapperConfig<?> mapperConfig = this.f10214c;
            mapperConfig.getClass();
            if (mapperConfig.k(MapperFeature.USE_ANNOTATIONS)) {
                strX = mapperConfig.d().X(mapperConfig.j(cls2).f9499e);
            }
            if (strX == null) {
                String name2 = cls2.getName();
                int iLastIndexOf = name2.lastIndexOf(46);
                if (iLastIndexOf >= 0) {
                    name2 = name2.substring(iLastIndexOf + 1);
                }
                strX = name2;
            }
            concurrentHashMap.put(name, strX);
        }
        return strX;
    }

    public final String toString() {
        return String.format("[%s; id-to-type=%s]", k.class.getName(), this.f10216e);
    }
}
