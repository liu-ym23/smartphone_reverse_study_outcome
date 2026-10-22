package G1;

import I1.l;
import J1.e;
import J1.g;
import K1.AbstractC0903a;
import K1.B;
import K1.m;
import K1.n;
import K1.r;
import K1.t;
import K1.u;
import K1.v;
import K1.x;
import K1.y;
import K1.z;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes.dex */
public abstract class a implements c, b {

    /* renamed from: a, reason: collision with root package name */
    public static TimeZone f2772a = TimeZone.getDefault();

    /* renamed from: b, reason: collision with root package name */
    public static Locale f2773b = Locale.getDefault();

    /* renamed from: c, reason: collision with root package name */
    public static int f2774c = (Feature.UseBigDecimal.mask | Feature.SortFeidFastMatch.mask) | Feature.IgnoreNotMatch.mask;

    /* renamed from: d, reason: collision with root package name */
    public static String f2775d = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: e, reason: collision with root package name */
    public static int f2776e = ((SerializerFeature.QuoteFieldNames.mask | SerializerFeature.SkipTransientField.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.SortField.mask;

    public static final <T> T D(String str, Type type, l lVar, int i10, Feature... featureArr) {
        return (T) H(str, type, lVar, null, i10, featureArr);
    }

    public static final <T> T H(String str, Type type, l lVar, g gVar, int i10, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (Feature feature : featureArr) {
            i10 |= feature.mask;
        }
        I1.b bVar = new I1.b(str, lVar, i10);
        if (gVar instanceof J1.c) {
            bVar.n().add((J1.c) gVar);
        }
        if (gVar instanceof J1.b) {
            bVar.m().add((J1.b) gVar);
        }
        if (gVar instanceof e) {
            bVar.f3266m = (e) gVar;
        }
        T t10 = (T) bVar.D0(type);
        bVar.G(t10);
        bVar.close();
        return t10;
    }

    public static final Object K(Object obj) {
        return L(obj, x.f4076d);
    }

    public static Object L(Object obj, x xVar) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            JSONObject jSONObject = new JSONObject(map.size());
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put(L1.d.r(entry.getKey()), K(entry.getValue()));
            }
            return jSONObject;
        }
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            JSONArray jSONArray = new JSONArray(collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                jSONArray.add(K(it.next()));
            }
            return jSONArray;
        }
        Class<?> cls = obj.getClass();
        if (cls.isEnum()) {
            return ((Enum) obj).name();
        }
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            JSONArray jSONArray2 = new JSONArray(length);
            for (int i10 = 0; i10 < length; i10++) {
                jSONArray2.add(K(Array.get(obj, i10)));
            }
            return jSONArray2;
        }
        if (l.e(cls)) {
            return obj;
        }
        t tVarA = xVar.a(cls);
        if (!(tVarA instanceof n)) {
            return null;
        }
        n nVar = (n) tVarA;
        JSONObject jSONObject2 = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry2 : nVar.b(obj).entrySet()) {
                jSONObject2.put(entry2.getKey(), K(entry2.getValue()));
            }
            return jSONObject2;
        } catch (Exception e10) {
            throw new JSONException("toJSON error", e10);
        }
    }

    public static final String N(Object obj) {
        return O(obj, x.f4076d, null, null, f2776e, new SerializerFeature[0]);
    }

    public static String O(Object obj, x xVar, y[] yVarArr, String str, int i10, SerializerFeature... serializerFeatureArr) {
        z zVar = new z(null, i10, serializerFeatureArr);
        try {
            m mVar = new m(zVar, xVar);
            for (SerializerFeature serializerFeature : serializerFeatureArr) {
                mVar.c(serializerFeature, true);
            }
            if (str != null && str.length() != 0) {
                mVar.q(str);
                mVar.c(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (yVarArr != null) {
                for (y yVar : yVarArr) {
                    if (yVar != null) {
                        if (yVar instanceof v) {
                            mVar.j().add((v) yVar);
                        }
                        if (yVar instanceof r) {
                            mVar.h().add((r) yVar);
                        }
                        if (yVar instanceof B) {
                            mVar.k().add((B) yVar);
                        }
                        if (yVar instanceof u) {
                            mVar.i().add((u) yVar);
                        }
                        if (yVar instanceof K1.d) {
                            mVar.f().add((K1.d) yVar);
                        }
                        if (yVar instanceof AbstractC0903a) {
                            mVar.e().add((AbstractC0903a) yVar);
                        }
                    }
                }
            }
            mVar.r(obj);
            String string = zVar.toString();
            zVar.close();
            return string;
        } catch (Throwable th) {
            zVar.close();
            throw th;
        }
    }

    public static final Object n(String str) {
        return t(str, f2774c);
    }

    public static final Object t(String str, int i10) {
        if (str == null) {
            return null;
        }
        I1.b bVar = new I1.b(str, l.f3331e, i10);
        Object objU = bVar.U(null);
        bVar.G(objU);
        bVar.close();
        return objU;
    }

    public static final JSONArray u(String str) {
        JSONArray jSONArray = null;
        if (str == null) {
            return null;
        }
        I1.b bVar = new I1.b(str, l.f3331e);
        I1.d dVar = bVar.f3258e;
        int iA0 = dVar.a0();
        if (iA0 == 8) {
            dVar.s();
        } else if (iA0 != 20) {
            jSONArray = new JSONArray();
            bVar.e0(jSONArray);
            bVar.G(jSONArray);
        }
        bVar.close();
        return jSONArray;
    }

    public static final JSONObject v(String str) {
        Object objN = n(str);
        return objN instanceof JSONObject ? (JSONObject) objN : (JSONObject) K(objN);
    }

    public static final <T> T x(String str, d<T> dVar, Feature... featureArr) {
        return (T) D(str, dVar.f2778a, l.f3331e, f2774c, featureArr);
    }

    public static final <T> T y(String str, Class<T> cls) {
        return (T) z(str, cls, new Feature[0]);
    }

    public static final <T> T z(String str, Class<T> cls, Feature... featureArr) {
        return (T) D(str, cls, l.f3331e, f2774c, featureArr);
    }

    @Override // G1.c
    public void i(Appendable appendable) {
        z zVar = new z(null, f2776e, SerializerFeature.EMPTY);
        try {
            try {
                new m(zVar, x.f4076d).r(this);
                appendable.append(zVar.toString());
            } catch (IOException e10) {
                throw new JSONException(e10.getMessage(), e10);
            }
        } finally {
            zVar.close();
        }
    }

    @Override // G1.b
    public String j() {
        z zVar = new z(null, f2776e, SerializerFeature.EMPTY);
        try {
            new m(zVar, x.f4076d).r(this);
            return zVar.toString();
        } finally {
            zVar.close();
        }
    }

    public String toString() {
        return j();
    }
}
