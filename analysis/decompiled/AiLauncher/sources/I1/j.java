package I1;

import I1.b;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.fasterxml.jackson.core.JsonFactory;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public class j implements J1.f {

    /* renamed from: a, reason: collision with root package name */
    public static j f3325a = new j();

    public static Object c(b bVar, Map<Object, Object> map, Type type, Type type2, Object obj) {
        Object obj2;
        d dVar = bVar.f3258e;
        int i10 = dVar.f3280a;
        int i11 = 16;
        if (i10 != 12 && i10 != 16) {
            throw new JSONException("syntax error, expect {, actual " + e.a(i10));
        }
        J1.f fVarC = bVar.f3255b.c(type);
        J1.f fVarC2 = bVar.f3255b.c(type2);
        dVar.s();
        k kVar = bVar.f3259f;
        while (true) {
            try {
                int i12 = dVar.f3280a;
                if (i12 == 13) {
                    dVar.t(i11);
                    return map;
                }
                if (i12 == 4 && dVar.f3287h == 4 && dVar.f3296q.startsWith("$ref", dVar.f3290k + 1) && !dVar.m(Feature.DisableSpecialKeyDetect)) {
                    dVar.u(':');
                    if (dVar.f3280a != 4) {
                        throw new JSONException("illegal ref, " + e.a(i12));
                    }
                    String strX = dVar.X();
                    if ("..".equals(strX)) {
                        obj2 = kVar.f3327b.f3326a;
                    } else if ("$".equals(strX)) {
                        k kVar2 = kVar;
                        while (true) {
                            k kVar3 = kVar2.f3327b;
                            if (kVar3 == null) {
                                break;
                            }
                            kVar2 = kVar3;
                        }
                        obj2 = kVar2.f3326a;
                    } else {
                        bVar.e(new b.a(kVar, strX));
                        bVar.f3263j = 1;
                        obj2 = null;
                    }
                    dVar.t(13);
                    if (dVar.f3280a != 13) {
                        throw new JSONException("illegal ref");
                    }
                    dVar.t(16);
                    return obj2;
                }
                if (map.size() == 0 && i12 == 4 && "@type".equals(dVar.X()) && !dVar.m(Feature.DisableSpecialKeyDetect)) {
                    dVar.u(':');
                    dVar.t(16);
                    if (dVar.f3280a == 13) {
                        dVar.s();
                        return map;
                    }
                    dVar.s();
                }
                Object objB = fVarC.b(bVar, type, null);
                if (dVar.f3280a != 17) {
                    throw new JSONException("syntax error, expect :, actual " + dVar.f3280a);
                }
                dVar.s();
                Object objB2 = fVarC2.b(bVar, type2, objB);
                if (bVar.f3263j == 1) {
                    bVar.i(map, objB);
                }
                map.put(objB, objB2);
                if (dVar.f3280a == 16) {
                    dVar.s();
                }
                i11 = 16;
            } finally {
                bVar.b1(kVar);
            }
        }
    }

    public static Map d(b bVar, Map<String, Object> map, Type type, Object obj) {
        String strT;
        Object objI0;
        d dVar = bVar.f3258e;
        if (dVar.f3280a != 12) {
            throw new JSONException("syntax error, expect {, actual " + dVar.f3280a);
        }
        k kVar = bVar.f3259f;
        while (true) {
            try {
                dVar.W();
                char c10 = dVar.f3283d;
                while (c10 == ',') {
                    dVar.q();
                    dVar.W();
                    c10 = dVar.f3283d;
                }
                if (c10 == '\"') {
                    strT = dVar.S(bVar.f3254a, JsonFactory.DEFAULT_QUOTE_CHAR);
                    dVar.W();
                    if (dVar.f3283d != ':') {
                        throw new JSONException("syntax error, " + dVar.i());
                    }
                } else {
                    if (c10 == '}') {
                        dVar.q();
                        dVar.f3287h = 0;
                        dVar.t(16);
                        return map;
                    }
                    if (c10 == '\'') {
                        strT = dVar.S(bVar.f3254a, '\'');
                        dVar.W();
                        if (dVar.f3283d != ':') {
                            throw new JSONException("syntax error, " + dVar.i());
                        }
                    } else {
                        strT = dVar.T(bVar.f3254a);
                        dVar.W();
                        char c11 = dVar.f3283d;
                        if (c11 != ':') {
                            throw new JSONException("expect ':' at " + dVar.f3281b + ", actual " + c11);
                        }
                    }
                }
                dVar.q();
                dVar.W();
                dVar.f3287h = 0;
                if (strT != "@type" || dVar.m(Feature.DisableSpecialKeyDetect)) {
                    dVar.s();
                    bVar.b1(kVar);
                    if (dVar.f3280a == 8) {
                        dVar.s();
                        objI0 = null;
                    } else {
                        objI0 = bVar.I0(type, strT);
                    }
                    map.put(strT, objI0);
                    if (bVar.f3263j == 1) {
                        bVar.i(map, strT);
                    }
                    bVar.a1(kVar, objI0, strT);
                    int i10 = dVar.f3280a;
                    if (i10 == 20 || i10 == 15) {
                        break;
                    }
                    if (i10 == 13) {
                        dVar.s();
                        return map;
                    }
                } else {
                    Class<?> clsF = L1.d.F(dVar.S(bVar.f3254a, JsonFactory.DEFAULT_QUOTE_CHAR), bVar.f3255b.f3334c);
                    if (clsF != map.getClass()) {
                        J1.f fVarC = bVar.f3255b.c(clsF);
                        dVar.t(16);
                        bVar.f3263j = 2;
                        if (kVar != null && !(obj instanceof Integer)) {
                            bVar.Y0();
                        }
                        return (Map) fVarC.b(bVar, clsF, obj);
                    }
                    dVar.t(16);
                    if (dVar.f3280a == 13) {
                        dVar.t(16);
                        return map;
                    }
                }
            } finally {
                bVar.b1(kVar);
            }
        }
        return map;
    }

    public Map<?, ?> a(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type == JSONObject.class) {
            return new JSONObject();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return EnumMap.class.equals(rawType) ? new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]) : a(rawType);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new JSONException("unsupport type " + type);
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e10) {
            throw new JSONException("unsupport type " + type, e10);
        }
    }

    @Override // J1.f
    public <T> T b(b bVar, Type type, Object obj) {
        if (type == JSONObject.class && bVar.f3266m == null) {
            return (T) bVar.k0();
        }
        d dVar = bVar.f3258e;
        if (dVar.f3280a == 8) {
            dVar.t(16);
            return null;
        }
        Map<?, ?> mapA = a(type);
        k kVar = bVar.f3259f;
        try {
            bVar.a1(kVar, mapA, obj);
            if (!(type instanceof ParameterizedType)) {
                return (T) bVar.N0(mapA, obj);
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            return String.class == type2 ? (T) d(bVar, mapA, type3, obj) : (T) c(bVar, mapA, type2, type3, obj);
        } finally {
            bVar.b1(kVar);
        }
    }
}
