package I1;

import K1.A;
import K1.C0904b;
import K1.q;
import K1.s;
import com.alibaba.fastjson.PropertyNamingStrategy;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class l {

    /* renamed from: e, reason: collision with root package name */
    public static l f3331e = new l();

    /* renamed from: a, reason: collision with root package name */
    public final L1.b<J1.f> f3332a;

    /* renamed from: b, reason: collision with root package name */
    public final n f3333b;

    /* renamed from: c, reason: collision with root package name */
    public ClassLoader f3334c;

    /* renamed from: d, reason: collision with root package name */
    public PropertyNamingStrategy f3335d;

    public l() {
        L1.b<J1.f> bVar = new L1.b<>(1024);
        this.f3332a = bVar;
        this.f3333b = new n(16384);
        q qVar = q.f4069a;
        bVar.b(SimpleDateFormat.class, qVar);
        K1.h hVar = K1.h.f4037a;
        bVar.b(Date.class, hVar);
        bVar.b(Calendar.class, hVar);
        bVar.b(Map.class, j.f3325a);
        bVar.b(HashMap.class, j.f3325a);
        bVar.b(LinkedHashMap.class, j.f3325a);
        bVar.b(TreeMap.class, j.f3325a);
        bVar.b(ConcurrentMap.class, j.f3325a);
        bVar.b(ConcurrentHashMap.class, j.f3325a);
        K1.g gVar = K1.g.f4036a;
        bVar.b(Collection.class, gVar);
        bVar.b(List.class, gVar);
        bVar.b(ArrayList.class, gVar);
        h hVar2 = h.f3321a;
        bVar.b(Object.class, hVar2);
        bVar.b(String.class, A.f4024a);
        bVar.b(Character.TYPE, qVar);
        bVar.b(Character.class, qVar);
        s sVar = s.f4070b;
        bVar.b(Byte.TYPE, sVar);
        bVar.b(Byte.class, sVar);
        bVar.b(Short.TYPE, sVar);
        bVar.b(Short.class, sVar);
        bVar.b(Integer.TYPE, K1.k.f4046a);
        bVar.b(Integer.class, K1.k.f4046a);
        bVar.b(Long.TYPE, K1.k.f4046a);
        bVar.b(Long.class, K1.k.f4046a);
        K1.e eVar = K1.e.f4034a;
        bVar.b(BigInteger.class, eVar);
        bVar.b(BigDecimal.class, eVar);
        bVar.b(Float.TYPE, sVar);
        bVar.b(Float.class, sVar);
        bVar.b(Double.TYPE, sVar);
        bVar.b(Double.class, sVar);
        K1.f fVar = K1.f.f4035a;
        bVar.b(Boolean.TYPE, fVar);
        bVar.b(Boolean.class, fVar);
        bVar.b(Class.class, qVar);
        C0904b c0904b = C0904b.f4028a;
        bVar.b(char[].class, c0904b);
        bVar.b(Object[].class, c0904b);
        bVar.b(UUID.class, qVar);
        bVar.b(TimeZone.class, qVar);
        bVar.b(Locale.class, qVar);
        bVar.b(Currency.class, qVar);
        bVar.b(URI.class, qVar);
        bVar.b(URL.class, qVar);
        bVar.b(Pattern.class, qVar);
        bVar.b(Charset.class, qVar);
        bVar.b(Number.class, sVar);
        bVar.b(StackTraceElement.class, qVar);
        bVar.b(Serializable.class, hVar2);
        bVar.b(Cloneable.class, hVar2);
        bVar.b(Comparable.class, hVar2);
        bVar.b(Closeable.class, hVar2);
    }

    public static l d() {
        return f3331e;
    }

    public static boolean e(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == Date.class || cls == java.sql.Date.class || cls == Time.class || cls == Timestamp.class;
    }

    public J1.d a(l lVar, Class<?> cls, L1.a aVar) {
        Class<?> cls2 = aVar.f4267g;
        return (cls2 == List.class || cls2 == ArrayList.class || (cls2.isArray() && !cls2.getComponentType().isPrimitive())) ? new i(lVar, cls, aVar) : new a(lVar, cls, aVar);
    }

    public J1.f b(Class<?> cls, Type type) {
        H1.c cVar;
        Class<?> clsMappingTo;
        J1.f fVarA = this.f3332a.a(type);
        if (fVarA != null) {
            return fVarA;
        }
        if (type == null) {
            type = cls;
        }
        J1.f fVarA2 = this.f3332a.a(type);
        if (fVarA2 != null) {
            return fVarA2;
        }
        if (!e(cls) && (cVar = (H1.c) cls.getAnnotation(H1.c.class)) != null && (clsMappingTo = cVar.mappingTo()) != Void.class) {
            return b(clsMappingTo, clsMappingTo);
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            fVarA2 = this.f3332a.a(cls);
        }
        if (fVarA2 != null) {
            return fVarA2;
        }
        J1.f fVarA3 = this.f3332a.a(type);
        if (fVarA3 != null) {
            return fVarA3;
        }
        J1.f cVar2 = cls.isEnum() ? new c(cls) : cls.isArray() ? C0904b.f4028a : (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class || Collection.class.isAssignableFrom(cls)) ? K1.g.f4036a : Map.class.isAssignableFrom(cls) ? j.f3325a : Throwable.class.isAssignableFrom(cls) ? new o(this, cls) : cls.getName().equals("android.net.Uri") ? q.f4069a : new f(this, cls, type);
        f(type, cVar2);
        return cVar2;
    }

    public J1.f c(Type type) {
        J1.f fVarA = this.f3332a.a(type);
        if (fVarA != null) {
            return fVarA;
        }
        if (type instanceof Class) {
            return b((Class) type, type);
        }
        if (!(type instanceof ParameterizedType)) {
            return h.f3321a;
        }
        Type rawType = ((ParameterizedType) type).getRawType();
        return rawType instanceof Class ? b((Class) rawType, type) : c(rawType);
    }

    public void f(Type type, J1.f fVar) {
        this.f3332a.b(type, fVar);
    }
}
