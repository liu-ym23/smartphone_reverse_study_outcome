package l0;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import m0.InterfaceC0856d;
import o0.C0888a;
import o0.C0896i;
import o0.EnumC0889b;
import o0.InterfaceC0890c;
import p0.v;
import q0.C0946I;
import q0.C0947J;
import q0.InterfaceC0944G;
import q0.U;
import q0.b0;
import q0.c0;
import q0.e0;
import q0.f0;
import u0.o;

/* renamed from: l0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0822a implements j, c {

    /* renamed from: i, reason: collision with root package name */
    private static final ThreadLocal<byte[]> f18024i;

    /* renamed from: j, reason: collision with root package name */
    private static final ThreadLocal<char[]> f18025j;

    /* renamed from: a, reason: collision with root package name */
    public static TimeZone f18016a = TimeZone.getDefault();

    /* renamed from: b, reason: collision with root package name */
    public static Locale f18017b = Locale.getDefault();

    /* renamed from: c, reason: collision with root package name */
    public static String f18018c = "@type";

    /* renamed from: d, reason: collision with root package name */
    static final c0[] f18019d = new c0[0];

    /* renamed from: e, reason: collision with root package name */
    public static String f18020e = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: h, reason: collision with root package name */
    private static final ConcurrentHashMap<Type, Type> f18023h = new ConcurrentHashMap<>(16);

    /* renamed from: f, reason: collision with root package name */
    public static int f18021f = ((((((EnumC0889b.AutoCloseSource.b() | EnumC0889b.InternFieldNames.b()) | EnumC0889b.UseBigDecimal.b()) | EnumC0889b.AllowUnQuotedFieldNames.b()) | EnumC0889b.AllowSingleQuotes.b()) | EnumC0889b.AllowArbitraryCommas.b()) | EnumC0889b.SortFeidFastMatch.b()) | EnumC0889b.IgnoreNotMatch.b();

    /* renamed from: g, reason: collision with root package name */
    public static int f18022g = ((f0.QuoteFieldNames.b() | f0.SkipTransientField.b()) | f0.WriteEnumUsingName.b()) | f0.SortField.b();

    static {
        n(u0.g.f22753a);
        f18024i = new ThreadLocal<>();
        f18025j = new ThreadLocal<>();
    }

    public static <T> T A(String str, Type type, C0896i c0896i, v vVar, int i5, EnumC0889b... enumC0889bArr) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (enumC0889bArr != null) {
            for (EnumC0889b enumC0889b : enumC0889bArr) {
                i5 |= enumC0889b.f18991a;
            }
        }
        C0888a c0888a = new C0888a(str, c0896i, i5);
        if (vVar != null) {
            if (vVar instanceof p0.k) {
                c0888a.C().add((p0.k) vVar);
            }
            if (vVar instanceof p0.j) {
                c0888a.A().add((p0.j) vVar);
            }
            if (vVar instanceof p0.m) {
                c0888a.B0((p0.m) vVar);
            }
        }
        T t5 = (T) c0888a.k0(type, null);
        c0888a.N(t5);
        c0888a.close();
        return t5;
    }

    public static <T> T B(String str, Type type, EnumC0889b... enumC0889bArr) {
        return (T) z(str, type, C0896i.f19034z, f18021f, enumC0889bArr);
    }

    public static e C(String str) {
        Object objQ = q(str);
        if (objQ instanceof e) {
            return (e) objQ;
        }
        try {
            return (e) D(objQ);
        } catch (RuntimeException e6) {
            throw new d("can not cast to JSONObject.", e6);
        }
    }

    public static Object D(Object obj) {
        return E(obj, b0.f19756j);
    }

    public static Object E(Object obj, b0 b0Var) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof AbstractC0822a) {
            return obj;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            int size = map.size();
            e eVar = new e((Map<String, Object>) (map instanceof LinkedHashMap ? new LinkedHashMap(size) : map instanceof TreeMap ? new TreeMap() : new HashMap(size)));
            for (Map.Entry entry : map.entrySet()) {
                eVar.put(o.z(entry.getKey()), E(entry.getValue(), b0Var));
            }
            return eVar;
        }
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            C0823b c0823b = new C0823b(collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                c0823b.add(E(it.next(), b0Var));
            }
            return c0823b;
        }
        if (obj instanceof InterfaceC0944G) {
            return q(F(obj));
        }
        Class<?> cls = obj.getClass();
        if (cls.isEnum()) {
            return ((Enum) obj).name();
        }
        boolean z5 = false;
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            C0823b c0823b2 = new C0823b(length);
            for (int i5 = 0; i5 < length; i5++) {
                c0823b2.add(D(Array.get(obj, i5)));
            }
            return c0823b2;
        }
        if (C0896i.v(cls)) {
            return obj;
        }
        U uH = b0Var.h(cls);
        if (!(uH instanceof C0947J)) {
            return q(I(obj, b0Var, new f0[0]));
        }
        C0947J c0947j = (C0947J) uH;
        InterfaceC0856d interfaceC0856dX = c0947j.x();
        if (interfaceC0856dX != null) {
            boolean z6 = false;
            for (f0 f0Var : interfaceC0856dX.serialzeFeatures()) {
                if (f0Var == f0.SortField || f0Var == f0.MapSortField) {
                    z6 = true;
                }
            }
            z5 = z6;
        }
        e eVar2 = new e(z5);
        try {
            for (Map.Entry<String, Object> entry2 : c0947j.w(obj).entrySet()) {
                eVar2.put(entry2.getKey(), E(entry2.getValue(), b0Var));
            }
            return eVar2;
        } catch (Exception e6) {
            throw new d("toJSON error", e6);
        }
    }

    public static String F(Object obj) {
        return J(obj, f18019d, new f0[0]);
    }

    public static String G(Object obj, b0 b0Var, c0 c0Var, f0... f0VarArr) {
        return H(obj, b0Var, new c0[]{c0Var}, null, f18022g, f0VarArr);
    }

    public static String H(Object obj, b0 b0Var, c0[] c0VarArr, String str, int i5, f0... f0VarArr) {
        e0 e0Var = new e0(null, i5, f0VarArr);
        try {
            C0946I c0946i = new C0946I(e0Var, b0Var);
            if (str != null && str.length() != 0) {
                c0946i.F(str);
                c0946i.q(f0.WriteDateUseDateFormat, true);
            }
            if (c0VarArr != null) {
                for (c0 c0Var : c0VarArr) {
                    c0946i.d(c0Var);
                }
            }
            c0946i.G(obj);
            String string = e0Var.toString();
            e0Var.close();
            return string;
        } catch (Throwable th) {
            e0Var.close();
            throw th;
        }
    }

    public static String I(Object obj, b0 b0Var, f0... f0VarArr) {
        return G(obj, b0Var, null, f0VarArr);
    }

    public static String J(Object obj, c0[] c0VarArr, f0... f0VarArr) {
        return H(obj, b0.f19756j, c0VarArr, null, f18022g, f0VarArr);
    }

    private static void n(Properties properties) {
        String property = properties.getProperty("fastjson.serializerFeatures.MapSortField");
        int iB = f0.MapSortField.b();
        if ("true".equals(property)) {
            f18022g |= iB;
        } else if ("false".equals(property)) {
            f18022g &= ~iB;
        }
        if ("true".equals(properties.getProperty("parser.features.NonStringKeyAsString"))) {
            f18021f |= EnumC0889b.NonStringKeyAsString.b();
        }
        if ("true".equals(properties.getProperty("parser.features.ErrorOnEnumNotMatch")) || "true".equals(properties.getProperty("fastjson.parser.features.ErrorOnEnumNotMatch"))) {
            f18021f |= EnumC0889b.ErrorOnEnumNotMatch.b();
        }
        if ("false".equals(properties.getProperty("fastjson.asmEnable"))) {
            C0896i.f19034z.z(false);
            b0.f19756j.l(false);
        }
    }

    public static Type p(Type type) {
        if (type != null) {
            return f18023h.get(type);
        }
        return null;
    }

    public static Object q(String str) {
        return s(str, f18021f);
    }

    public static Object s(String str, int i5) {
        return u(str, C0896i.s(), i5);
    }

    public static Object t(String str, C0896i c0896i) {
        return u(str, c0896i, f18021f);
    }

    public static Object u(String str, C0896i c0896i, int i5) {
        if (str == null) {
            return null;
        }
        C0888a c0888a = new C0888a(str, c0896i, i5);
        Object objS = c0888a.S();
        c0888a.N(objS);
        c0888a.close();
        return objS;
    }

    public static <T> List<T> v(String str, Class<T> cls) {
        return w(str, cls, C0896i.f19034z);
    }

    public static <T> List<T> w(String str, Class<T> cls, C0896i c0896i) {
        ArrayList arrayList = null;
        if (str == null) {
            return null;
        }
        C0888a c0888a = new C0888a(str, c0896i);
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        int iU = interfaceC0890c.U();
        if (iU == 8) {
            interfaceC0890c.nextToken();
        } else if (iU != 20 || !interfaceC0890c.m()) {
            arrayList = new ArrayList();
            c0888a.V(cls, arrayList);
            c0888a.N(arrayList);
        }
        c0888a.close();
        return arrayList;
    }

    public static <T> T x(String str, Class<T> cls) {
        return (T) y(str, cls, new EnumC0889b[0]);
    }

    public static <T> T y(String str, Class<T> cls, EnumC0889b... enumC0889bArr) {
        return (T) A(str, cls, C0896i.f19034z, null, f18021f, enumC0889bArr);
    }

    public static <T> T z(String str, Type type, C0896i c0896i, int i5, EnumC0889b... enumC0889bArr) {
        return (T) A(str, type, c0896i, null, i5, enumC0889bArr);
    }

    public <T> T K(Type type) {
        return (T) o.h(this, type, C0896i.s());
    }

    @Override // l0.j
    public void h(Appendable appendable) {
        e0 e0Var = new e0();
        try {
            try {
                new C0946I(e0Var).G(this);
                appendable.append(e0Var.toString());
            } catch (IOException e6) {
                throw new d(e6.getMessage(), e6);
            }
        } finally {
            e0Var.close();
        }
    }

    @Override // l0.c
    public String i() {
        e0 e0Var = new e0();
        try {
            new C0946I(e0Var).G(this);
            return e0Var.toString();
        } finally {
            e0Var.close();
        }
    }

    public String toString() {
        return i();
    }
}
