package o0;

import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;
import l0.AbstractC0822a;
import l0.C0823b;
import l0.m;
import m0.InterfaceC0853a;
import m0.InterfaceC0854b;
import m0.InterfaceC0856d;
import p0.C0911A;
import p0.C0912B;
import p0.C0913C;
import p0.C0914a;
import p0.C0916c;
import p0.C0919f;
import p0.C0920g;
import p0.InterfaceC0917d;
import p0.l;
import p0.n;
import p0.p;
import p0.q;
import p0.r;
import p0.s;
import p0.t;
import p0.u;
import p0.w;
import p0.x;
import p0.z;
import q0.C0939B;
import q0.C0940C;
import q0.C0941D;
import q0.C0948K;
import q0.C0952O;
import q0.C0960g;
import q0.C0962i;
import q0.C0965l;
import q0.C0966m;
import q0.C0967n;
import q0.C0968o;
import q0.C0969p;
import q0.C0970q;
import q0.C0972t;
import q0.C0975w;
import q0.Q;
import q0.T;
import q0.Y;
import q0.g0;
import r0.InterfaceC0993a;
import s0.C1046a;
import u0.C1151a;
import u0.C1152b;
import u0.C1154d;
import u0.InterfaceC1155e;
import u0.k;
import u0.o;

/* renamed from: o0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0896i {

    /* renamed from: A, reason: collision with root package name */
    private static boolean f19023A;

    /* renamed from: B, reason: collision with root package name */
    private static boolean f19024B;

    /* renamed from: C, reason: collision with root package name */
    private static boolean f19025C;

    /* renamed from: D, reason: collision with root package name */
    private static boolean f19026D;

    /* renamed from: E, reason: collision with root package name */
    private static InterfaceC1155e<Class<?>, Boolean> f19027E;

    /* renamed from: v, reason: collision with root package name */
    private static final String[] f19030v;

    /* renamed from: y, reason: collision with root package name */
    private static final long[] f19033y;

    /* renamed from: z, reason: collision with root package name */
    public static C0896i f19034z;

    /* renamed from: a, reason: collision with root package name */
    private final u0.h<Type, t> f19035a;

    /* renamed from: b, reason: collision with root package name */
    private final u0.h<Type, u0.h<Type, t>> f19036b;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentMap<String, Class<?>> f19037c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f19038d;

    /* renamed from: e, reason: collision with root package name */
    public final C0897j f19039e;

    /* renamed from: f, reason: collision with root package name */
    public m f19040f;

    /* renamed from: g, reason: collision with root package name */
    protected ClassLoader f19041g;

    /* renamed from: h, reason: collision with root package name */
    protected C0914a f19042h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f19043i;

    /* renamed from: j, reason: collision with root package name */
    private long[] f19044j;

    /* renamed from: k, reason: collision with root package name */
    private long[] f19045k;

    /* renamed from: l, reason: collision with root package name */
    private long[] f19046l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f19047m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f19048n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f19049o;

    /* renamed from: p, reason: collision with root package name */
    private List<InterfaceC0993a> f19050p;

    /* renamed from: q, reason: collision with root package name */
    private volatile List<c> f19051q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f19052r;

    /* renamed from: s, reason: collision with root package name */
    private final Callable<Void> f19053s;

    /* renamed from: t, reason: collision with root package name */
    public static final String[] f19028t = A(u0.g.h("fastjson.parser.deny.internal"));

    /* renamed from: u, reason: collision with root package name */
    public static final String[] f19029u = A(u0.g.h("fastjson.parser.deny"));

    /* renamed from: w, reason: collision with root package name */
    public static final boolean f19031w = "true".equals(u0.g.h("fastjson.parser.autoTypeSupport"));

    /* renamed from: x, reason: collision with root package name */
    public static final boolean f19032x = "true".equals(u0.g.h("fastjson.parser.safeMode"));

    /* renamed from: o0.i$a */
    class a implements Callable<Void> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            C0896i.this.f19035a.c(Timestamp.class, z.f19349c);
            C0896i.this.f19035a.c(Date.class, z.f19348b);
            C0896i.this.f19035a.c(Time.class, C0913C.f19281a);
            C0896i.this.f19035a.c(java.util.Date.class, C0975w.f19876a);
            return null;
        }
    }

    /* renamed from: o0.i$b */
    static class b implements InterfaceC1155e<Class<?>, Boolean> {
        b() {
        }

        @Override // u0.InterfaceC1155e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Class<?> cls) {
            return Boolean.valueOf(cls == Date.class || cls == Time.class || cls == Timestamp.class);
        }
    }

    /* renamed from: o0.i$c */
    public interface c {
        Class<?> a(String str, Class<?> cls, int i5);
    }

    static {
        String[] strArrA = A(u0.g.h("fastjson.parser.autoTypeAccept"));
        if (strArrA == null) {
            strArrA = new String[0];
        }
        f19030v = strArrA;
        f19033y = new long[]{-6976602508726000783L, -6293031534589903644L, 59775428743665658L, 7267793227937552092L};
        f19034z = new C0896i();
        f19023A = false;
        f19024B = false;
        f19025C = false;
        f19026D = false;
        f19027E = new b();
    }

    public C0896i() {
        this(false);
    }

    private static String[] A(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(",");
    }

    private void e(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            b(str);
        }
    }

    private void f(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            c(str);
        }
    }

    private void g(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            d(str);
        }
    }

    private static Method p(Class cls, Class cls2) throws SecurityException {
        for (Method method : cls.getMethods()) {
            if (Modifier.isStatic(method.getModifiers()) && method.getReturnType() == cls2 && method.getParameterTypes().length == 1 && ((InterfaceC0853a) method.getAnnotation(InterfaceC0853a.class)) != null) {
                return method;
            }
        }
        return null;
    }

    public static Field r(String str, Map<String, Field> map) {
        Field field = map.get(str);
        if (field == null) {
            field = map.get("_" + str);
        }
        if (field == null) {
            field = map.get("m_" + str);
        }
        if (field == null) {
            char cCharAt = str.charAt(0);
            if (cCharAt >= 'a' && cCharAt <= 'z') {
                char[] charArray = str.toCharArray();
                charArray[0] = (char) (charArray[0] - ' ');
                field = map.get(new String(charArray));
            }
            if (str.length() > 2) {
                char cCharAt2 = str.charAt(1);
                if (cCharAt >= 'a' && cCharAt <= 'z' && cCharAt2 >= 'A' && cCharAt2 <= 'Z') {
                    for (Map.Entry<String, Field> entry : map.entrySet()) {
                        if (str.equalsIgnoreCase(entry.getKey())) {
                            return entry.getValue();
                        }
                    }
                }
            }
        }
        return field;
    }

    public static C0896i s() {
        return f19034z;
    }

    private void t() {
        u0.h<Type, t> hVar = this.f19035a;
        Q q5 = Q.f19717b;
        hVar.c(SimpleDateFormat.class, q5);
        u0.h<Type, t> hVar2 = this.f19035a;
        C0969p c0969p = C0969p.f19871b;
        hVar2.c(Calendar.class, c0969p);
        this.f19035a.c(XMLGregorianCalendar.class, c0969p);
        this.f19035a.c(l0.e.class, r.f19338a);
        u0.h<Type, t> hVar3 = this.f19035a;
        C0972t c0972t = C0972t.f19875a;
        hVar3.c(C0823b.class, c0972t);
        this.f19035a.c(Map.class, r.f19338a);
        this.f19035a.c(HashMap.class, r.f19338a);
        this.f19035a.c(LinkedHashMap.class, r.f19338a);
        this.f19035a.c(TreeMap.class, r.f19338a);
        this.f19035a.c(ConcurrentMap.class, r.f19338a);
        this.f19035a.c(ConcurrentHashMap.class, r.f19338a);
        this.f19035a.c(Collection.class, c0972t);
        this.f19035a.c(List.class, c0972t);
        this.f19035a.c(ArrayList.class, c0972t);
        u0.h<Type, t> hVar4 = this.f19035a;
        p pVar = p.f19316a;
        hVar4.c(Object.class, pVar);
        this.f19035a.c(String.class, g0.f19851a);
        this.f19035a.c(StringBuffer.class, g0.f19851a);
        this.f19035a.c(StringBuilder.class, g0.f19851a);
        u0.h<Type, t> hVar5 = this.f19035a;
        q0.r rVar = q0.r.f19873a;
        hVar5.c(Character.TYPE, rVar);
        this.f19035a.c(Character.class, rVar);
        u0.h<Type, t> hVar6 = this.f19035a;
        s sVar = s.f19339a;
        hVar6.c(Byte.TYPE, sVar);
        this.f19035a.c(Byte.class, sVar);
        this.f19035a.c(Short.TYPE, sVar);
        this.f19035a.c(Short.class, sVar);
        this.f19035a.c(Integer.TYPE, C0941D.f19671a);
        this.f19035a.c(Integer.class, C0941D.f19671a);
        this.f19035a.c(Long.TYPE, C0952O.f19713a);
        this.f19035a.c(Long.class, C0952O.f19713a);
        this.f19035a.c(BigInteger.class, C0966m.f19865c);
        this.f19035a.c(BigDecimal.class, C0965l.f19862c);
        this.f19035a.c(Float.TYPE, C0939B.f19668b);
        this.f19035a.c(Float.class, C0939B.f19668b);
        this.f19035a.c(Double.TYPE, sVar);
        this.f19035a.c(Double.class, sVar);
        u0.h<Type, t> hVar7 = this.f19035a;
        C0967n c0967n = C0967n.f19866a;
        hVar7.c(Boolean.TYPE, c0967n);
        this.f19035a.c(Boolean.class, c0967n);
        this.f19035a.c(Class.class, q5);
        this.f19035a.c(char[].class, new C0970q());
        this.f19035a.c(AtomicBoolean.class, c0967n);
        this.f19035a.c(AtomicInteger.class, C0941D.f19671a);
        this.f19035a.c(AtomicLong.class, C0952O.f19713a);
        u0.h<Type, t> hVar8 = this.f19035a;
        Y y5 = Y.f19722a;
        hVar8.c(AtomicReference.class, y5);
        this.f19035a.c(WeakReference.class, y5);
        this.f19035a.c(SoftReference.class, y5);
        this.f19035a.c(UUID.class, q5);
        this.f19035a.c(TimeZone.class, q5);
        this.f19035a.c(Locale.class, q5);
        this.f19035a.c(Currency.class, q5);
        this.f19035a.c(Inet4Address.class, q5);
        this.f19035a.c(Inet6Address.class, q5);
        this.f19035a.c(InetSocketAddress.class, q5);
        this.f19035a.c(File.class, q5);
        this.f19035a.c(URI.class, q5);
        this.f19035a.c(URL.class, q5);
        this.f19035a.c(Pattern.class, q5);
        this.f19035a.c(Charset.class, q5);
        this.f19035a.c(l0.g.class, q5);
        this.f19035a.c(Number.class, sVar);
        u0.h<Type, t> hVar9 = this.f19035a;
        C0960g c0960g = C0960g.f19850a;
        hVar9.c(AtomicIntegerArray.class, c0960g);
        this.f19035a.c(AtomicLongArray.class, c0960g);
        this.f19035a.c(StackTraceElement.class, C0911A.f19280a);
        this.f19035a.c(Serializable.class, pVar);
        this.f19035a.c(Cloneable.class, pVar);
        this.f19035a.c(Comparable.class, pVar);
        this.f19035a.c(Closeable.class, pVar);
        this.f19035a.c(l0.f.class, new n());
        u0.j.a(this.f19053s);
    }

    public static boolean v(Class<?> cls) {
        boolean z5 = cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == java.util.Date.class || cls.isEnum();
        Boolean boolValueOf = Boolean.valueOf(z5);
        if (!z5) {
            boolValueOf = (Boolean) u0.j.c(f19027E, cls);
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    public static void x(Class<?> cls, Map<String, Field> map) {
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) {
                map.put(name, field);
            }
        }
        if (cls.getSuperclass() == null || cls.getSuperclass() == Object.class) {
            return;
        }
        x(cls.getSuperclass(), map);
    }

    public void b(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        long jI = o.I(str);
        if (Arrays.binarySearch(this.f19046l, jI) >= 0) {
            return;
        }
        long[] jArr = this.f19046l;
        int length = jArr.length;
        long[] jArr2 = new long[length + 1];
        jArr2[length] = jI;
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Arrays.sort(jArr2);
        this.f19046l = jArr2;
    }

    public void c(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        long jI = o.I(str);
        if (Arrays.binarySearch(this.f19045k, jI) >= 0) {
            return;
        }
        long[] jArr = this.f19045k;
        int length = jArr.length;
        long[] jArr2 = new long[length + 1];
        jArr2[length] = jI;
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Arrays.sort(jArr2);
        this.f19045k = jArr2;
    }

    public void d(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        long jI = o.I(str);
        long[] jArr = this.f19044j;
        if (jArr == null) {
            this.f19044j = new long[]{jI};
            return;
        }
        if (Arrays.binarySearch(jArr, jI) >= 0) {
            return;
        }
        long[] jArr2 = this.f19044j;
        int length = jArr2.length;
        long[] jArr3 = new long[length + 1];
        jArr3[length] = jI;
        System.arraycopy(jArr2, 0, jArr3, 0, jArr2.length);
        Arrays.sort(jArr3);
        this.f19044j = jArr3;
    }

    public Class<?> h(String str, Class<?> cls) {
        return i(str, cls, AbstractC0822a.f18021f);
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x032b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Class<?> i(java.lang.String r25, java.lang.Class<?> r26, int r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1094
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.C0896i.i(java.lang.String, java.lang.Class, int):java.lang.Class");
    }

    public l j(C0896i c0896i, u0.i iVar, C1154d c1154d) {
        Class<?> clsDeserializeUsing;
        Class<?> cls = iVar.f22776a;
        Class<?> cls2 = c1154d.f22734e;
        InterfaceC0854b interfaceC0854bG = c1154d.g();
        Class<?> cls3 = null;
        if (interfaceC0854bG != null && (clsDeserializeUsing = interfaceC0854bG.deserializeUsing()) != Void.class) {
            cls3 = clsDeserializeUsing;
        }
        return (cls3 == null && (cls2 == List.class || cls2 == ArrayList.class)) ? new C0916c(c0896i, cls, c1154d) : new C0919f(c0896i, cls, c1154d);
    }

    public t k(Class<?> cls, Type type) {
        Class<?> cls2;
        Type type2;
        InterfaceC0854b interfaceC0854bG;
        Method method;
        C0914a c0914a;
        boolean zA = this.f19038d & (!this.f19047m);
        if (zA) {
            InterfaceC0856d interfaceC0856d = (InterfaceC0856d) o.M(cls, InterfaceC0856d.class);
            if (interfaceC0856d != null) {
                Class<?> clsDeserializer = interfaceC0856d.deserializer();
                if (clsDeserializer != Void.class) {
                    try {
                        Object objNewInstance = clsDeserializer.newInstance();
                        if (objNewInstance instanceof t) {
                            return (t) objNewInstance;
                        }
                    } catch (Throwable unused) {
                    }
                }
                zA = interfaceC0856d.asm() && interfaceC0856d.parseFeatures().length == 0;
            }
            if (zA) {
                Class<?> clsF = u0.i.f(cls, interfaceC0856d);
                if (clsF == null) {
                    clsF = cls;
                }
                while (true) {
                    if (!Modifier.isPublic(clsF.getModifiers())) {
                        zA = false;
                        break;
                    }
                    clsF = clsF.getSuperclass();
                    if (clsF == Object.class || clsF == null) {
                        break;
                    }
                }
            }
        }
        if (cls.getTypeParameters().length != 0) {
            zA = false;
        }
        if (zA && (c0914a = this.f19042h) != null && c0914a.f19284a.c(cls)) {
            zA = false;
        }
        if (zA) {
            zA = C1152b.a(cls.getSimpleName());
        }
        if (zA) {
            if (cls.isInterface()) {
                zA = false;
            }
            cls2 = cls;
            type2 = type;
            u0.i iVarC = u0.i.c(cls2, type2, this.f19040f, false, o.f22828b, this.f19048n);
            if (zA && iVarC.f22783h.length > 200) {
                zA = false;
            }
            Constructor<?> constructor = iVarC.f22778c;
            if (zA && constructor == null && !cls2.isInterface()) {
                zA = false;
            }
            for (C1154d c1154d : iVarC.f22783h) {
                if (!c1154d.f22737h) {
                    Class<?> cls3 = c1154d.f22734e;
                    if (Modifier.isPublic(cls3.getModifiers()) && ((!cls3.isMemberClass() || Modifier.isStatic(cls3.getModifiers())) && ((c1154d.o() == null || C1152b.a(c1154d.o().getName())) && (((interfaceC0854bG = c1154d.g()) == null || (C1152b.a(interfaceC0854bG.name()) && interfaceC0854bG.format().length() == 0 && interfaceC0854bG.deserializeUsing() == Void.class && interfaceC0854bG.parseFeatures().length == 0 && !interfaceC0854bG.unwrapped())) && (((method = c1154d.f22731b) == null || method.getParameterTypes().length <= 1) && (!cls3.isEnum() || (o(cls3) instanceof p0.h))))))) {
                    }
                }
                zA = false;
                break;
            }
        } else {
            cls2 = cls;
            type2 = type;
        }
        if (zA && cls2.isMemberClass() && !Modifier.isStatic(cls2.getModifiers())) {
            zA = false;
        }
        if (!((zA && o.y0(cls2)) ? false : zA)) {
            return new p0.o(this, cls2, type2);
        }
        u0.i iVarB = u0.i.b(cls2, type2, this.f19040f);
        try {
            return this.f19042h.v(this, iVarB);
        } catch (NoSuchMethodException unused2) {
            return new p0.o(this, cls2, type2);
        } catch (l0.d unused3) {
            return new p0.o(this, iVarB);
        } catch (Exception e6) {
            throw new l0.d("create asm deserializer error, " + cls2.getName(), e6);
        }
    }

    public t l(Type type) {
        Type typeP = AbstractC0822a.p(type);
        if (typeP == null) {
            return this.f19035a.b(type);
        }
        u0.h<Type, t> hVarB = this.f19036b.b(type);
        if (hVarB == null) {
            return null;
        }
        return hVarB.b(typeP);
    }

    public ClassLoader m() {
        return this.f19041g;
    }

    public t n(Class<?> cls, Type type) {
        t tVarK;
        t xVar;
        Method methodP;
        Class<?> clsMappingTo;
        Type type2 = type;
        t tVarL = l(type2);
        if (tVarL == null && (type2 instanceof k)) {
            tVarL = l(l0.n.b((k) type2));
        }
        if (tVarL != null) {
            return tVarL;
        }
        if (type2 == null) {
            type2 = cls;
        }
        t tVarL2 = l(type2);
        if (tVarL2 != null) {
            return tVarL2;
        }
        InterfaceC0856d interfaceC0856d = (InterfaceC0856d) o.M(cls, InterfaceC0856d.class);
        if (interfaceC0856d != null && (clsMappingTo = interfaceC0856d.mappingTo()) != Void.class) {
            return n(clsMappingTo, clsMappingTo);
        }
        if ((type2 instanceof WildcardType) || (type2 instanceof TypeVariable) || (type2 instanceof ParameterizedType)) {
            tVarL2 = l(cls);
        }
        if (tVarL2 != null) {
            return tVarL2;
        }
        Iterator<InterfaceC0993a> it = this.f19050p.iterator();
        while (it.hasNext()) {
            tVarL2 = it.next().b(this, cls);
            if (tVarL2 != null) {
                y(type2, tVarL2);
                return tVarL2;
            }
        }
        String strReplace = cls.getName().replace('$', '.');
        if (strReplace.startsWith("java.awt.") && C0962i.k(cls) && !f19023A) {
            String[] strArr = {"java.awt.Point", "java.awt.Font", "java.awt.Rectangle", "java.awt.Color"};
            for (int i5 = 0; i5 < 4; i5++) {
                try {
                    String str = strArr[i5];
                    if (str.equals(strReplace)) {
                        Type cls2 = Class.forName(str);
                        t tVar = C0962i.f19853a;
                        y(cls2, tVar);
                        return tVar;
                    }
                } catch (Throwable unused) {
                    f19023A = true;
                }
            }
            tVarL2 = C0962i.f19853a;
        }
        if (!f19024B) {
            try {
                if (strReplace.startsWith("java.time.")) {
                    String[] strArr2 = {"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.ZoneId", "java.time.Period", "java.time.Duration", "java.time.Instant"};
                    for (int i6 = 0; i6 < 12; i6++) {
                        String str2 = strArr2[i6];
                        if (str2.equals(strReplace)) {
                            Type cls3 = Class.forName(str2);
                            t tVar2 = q.f19317a;
                            y(cls3, tVar2);
                            return tVar2;
                        }
                    }
                } else if (strReplace.startsWith("java.util.Optional")) {
                    String[] strArr3 = {"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};
                    for (int i7 = 0; i7 < 4; i7++) {
                        String str3 = strArr3[i7];
                        if (str3.equals(strReplace)) {
                            Type cls4 = Class.forName(str3);
                            t tVar3 = u.f19340a;
                            y(cls4, tVar3);
                            return tVar3;
                        }
                    }
                }
            } catch (Throwable unused2) {
                f19024B = true;
            }
        }
        if (!f19025C) {
            try {
                if (strReplace.startsWith("org.joda.time.")) {
                    String[] strArr4 = {"org.joda.time.DateTime", "org.joda.time.LocalDate", "org.joda.time.LocalDateTime", "org.joda.time.LocalTime", "org.joda.time.Instant", "org.joda.time.Period", "org.joda.time.Duration", "org.joda.time.DateTimeZone", "org.joda.time.format.DateTimeFormatter"};
                    for (int i8 = 0; i8 < 9; i8++) {
                        String str4 = strArr4[i8];
                        if (str4.equals(strReplace)) {
                            Type cls5 = Class.forName(str4);
                            tVarL2 = C0948K.f19691a;
                            y(cls5, tVarL2);
                            return tVarL2;
                        }
                    }
                }
            } catch (Throwable unused3) {
                f19025C = true;
            }
        }
        if (!f19026D && strReplace.startsWith("com.google.common.collect.")) {
            try {
                String[] strArr5 = {"com.google.common.collect.HashMultimap", "com.google.common.collect.LinkedListMultimap", "com.google.common.collect.LinkedHashMultimap", "com.google.common.collect.ArrayListMultimap", "com.google.common.collect.TreeMultimap"};
                for (int i9 = 0; i9 < 5; i9++) {
                    String str5 = strArr5[i9];
                    if (str5.equals(strReplace)) {
                        Type cls6 = Class.forName(str5);
                        tVarL2 = C0940C.f19670a;
                        y(cls6, tVarL2);
                        return tVarL2;
                    }
                }
            } catch (ClassNotFoundException unused4) {
                f19026D = true;
            }
        }
        if (strReplace.equals("java.nio.ByteBuffer")) {
            tVarL2 = C0968o.f19867a;
            y(cls, tVarL2);
        }
        if (strReplace.equals("java.nio.file.Path")) {
            tVarL2 = Q.f19717b;
            y(cls, tVarL2);
        }
        if (cls == Map.Entry.class) {
            tVarL2 = Q.f19717b;
            y(cls, tVarL2);
        }
        if (strReplace.equals("org.javamoney.moneta.Money")) {
            tVarL2 = C1046a.f20228a;
            y(cls, tVarL2);
        }
        try {
            for (InterfaceC0917d interfaceC0917d : u0.n.a(InterfaceC0917d.class, Thread.currentThread().getContextClassLoader())) {
                Iterator<Type> it2 = interfaceC0917d.a().iterator();
                while (it2.hasNext()) {
                    y(it2.next(), interfaceC0917d);
                }
            }
        } catch (Exception unused5) {
        }
        if (tVarL2 == null) {
            tVarL2 = l(type2);
        }
        if (tVarL2 != null) {
            return tVarL2;
        }
        if (cls.isEnum()) {
            if (this.f19048n) {
                for (Method method : cls.getMethods()) {
                    if (o.r0(method)) {
                        t tVarK2 = k(cls, type2);
                        y(type2, tVarK2);
                        return tVarK2;
                    }
                }
            }
            Class<?> cls7 = (Class) AbstractC0822a.p(cls);
            InterfaceC0856d interfaceC0856d2 = (InterfaceC0856d) o.M(cls7 != null ? cls7 : cls, InterfaceC0856d.class);
            if (interfaceC0856d2 != null) {
                try {
                    t tVar4 = (t) interfaceC0856d2.deserializer().newInstance();
                    y(cls, tVar4);
                    return tVar4;
                } catch (Throwable unused6) {
                }
            }
            if (cls7 != null) {
                Method methodP2 = p(cls7, cls);
                if (methodP2 != null) {
                    try {
                        methodP = cls.getMethod(methodP2.getName(), methodP2.getParameterTypes());
                    } catch (Exception unused7) {
                    }
                } else {
                    methodP = null;
                }
            } else {
                methodP = p(cls, cls);
            }
            if (methodP != null) {
                t c0920g = new C0920g(methodP);
                y(cls, c0920g);
                return c0920g;
            }
            tVarK = q(cls);
        } else if (cls.isArray()) {
            tVarK = T.f19720a;
        } else if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class || Collection.class.isAssignableFrom(cls)) {
            tVarK = C0972t.f19875a;
        } else if (Map.class.isAssignableFrom(cls)) {
            tVarK = r.f19338a;
        } else {
            if (Throwable.class.isAssignableFrom(cls)) {
                xVar = new C0912B(this, cls);
            } else if (w.class.isAssignableFrom(cls)) {
                xVar = new x(cls);
            } else {
                tVarK = cls == InetAddress.class ? Q.f19717b : k(cls, type2);
            }
            tVarK = xVar;
        }
        y(type2, tVarK);
        return tVarK;
    }

    public t o(Type type) {
        t tVarL = l(type);
        if (tVarL != null) {
            return tVarL;
        }
        if (type instanceof Class) {
            return n((Class) type, type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            return rawType instanceof Class ? n((Class) rawType, type) : o(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return o(upperBounds[0]);
            }
        }
        return p.f19316a;
    }

    protected t q(Class<?> cls) {
        return new p0.h(cls);
    }

    public boolean u() {
        return this.f19048n;
    }

    public boolean w() {
        return this.f19052r;
    }

    public void y(Type type, t tVar) {
        Type typeP = AbstractC0822a.p(type);
        if (typeP == null) {
            this.f19035a.c(type, tVar);
            return;
        }
        u0.h<Type, t> hVarB = this.f19036b.b(type);
        if (hVarB == null) {
            hVarB = new u0.h<>(4);
            this.f19036b.c(type, hVarB);
        }
        hVarB.c(typeP, tVar);
    }

    public void z(boolean z5) {
        this.f19038d = z5;
    }

    public C0896i(boolean z5) {
        this(null, null, z5);
    }

    private C0896i(C0914a c0914a, ClassLoader classLoader, boolean z5) {
        this.f19035a = new u0.h<>();
        this.f19036b = new u0.h<>(16);
        this.f19037c = new ConcurrentHashMap(16, 0.75f, 1);
        this.f19038d = !C1152b.f22729b;
        this.f19039e = new C0897j(RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
        this.f19043i = f19031w;
        this.f19048n = false;
        this.f19049o = o.f22828b;
        this.f19050p = new ArrayList();
        this.f19052r = f19032x;
        this.f19045k = new long[]{-9164606388214699518L, -8754006975464705441L, -8720046426850100497L, -8649961213709896794L, -8614556368991373401L, -8382625455832334425L, -8165637398350707645L, -8109300701639721088L, -7966123100503199569L, -7921218830998286408L, -7775351613326101303L, -7768608037458185275L, -7766605818834748097L, -6835437086156813536L, -6316154655839304624L, -6179589609550493385L, -6149130139291498841L, -6149093380703242441L, -6088208984980396913L, -6025144546313590215L, -5939269048541779808L, -5885964883385605994L, -5767141746063564198L, -5764804792063216819L, -5472097725414717105L, -5194641081268104286L, -5076846148177416215L, -4837536971810737970L, -4836620931940850535L, -4733542790109620528L, -4703320437989596122L, -4608341446948126581L, -4537258998789938600L, -4438775680185074100L, -4314457471973557243L, -4150995715611818742L, -4082057040235125754L, -3975378478825053783L, -3967588558552655563L, -3935185854875733362L, -3750763034362895579L, -3319207949486691020L, -3077205613010077203L, -3053747177772160511L, -2995060141064716555L, -2825378362173150292L, -2533039401923731906L, -2439930098895578154L, -2378990704010641148L, -2364987994247679115L, -2262244760619952081L, -2192804397019347313L, -2095516571388852610L, -1872417015366588117L, -1800035667138631116L, -1650485814983027158L, -1589194880214235129L, -1363634950764737555L, -965955008570215305L, -905177026366752536L, -831789045734283466L, -803541446955902575L, -731978084025273882L, -666475508176557463L, -582813228520337988L, -254670111376247151L, -219577392946377768L, -190281065685395680L, -26639035867733124L, -9822483067882491L, 4750336058574309L, 33238344207745342L, 156405680656087946L, 218512992947536312L, 313864100207897507L, 386461436234701831L, 744602970950881621L, 823641066473609950L, 860052378298585747L, 1073634739308289776L, 1153291637701043748L, 1203232727967308606L, 1214780596910349029L, 1268707909007641340L, 1459860845934817624L, 1502845958873959152L, 1534439610567445754L, 1698504441317515818L, 1818089308493370394L, 2078113382421334967L, 2164696723069287854L, 2622551729063269307L, 2653453629929770569L, 2660670623866180977L, 2731823439467737506L, 2836431254737891113L, 2930861374593775110L, 3058452313624178956L, 3085473968517218653L, 3089451460101527857L, 3114862868117605599L, 3129395579983849527L, 3256258368248066264L, 3452379460455804429L, 3547627781654598988L, 3637939656440441093L, 3688179072722109200L, 3718352661124136681L, 3730752432285826863L, 3740226159580918099L, 3794316665763266033L, 3977090344859527316L, 4000049462512838776L, 4046190361520671643L, 4147696707147271408L, 4193204392725694463L, 4215053018660518963L, 4241163808635564644L, 4254584350247334433L, 4319304524795015394L, 4814658433570175913L, 4841947709850912914L, 4904007817188630457L, 5100336081510080343L, 5120543992130540564L, 5274044858141538265L, 5347909877633654828L, 5450448828334921485L, 5474268165959054640L, 5545425291794704408L, 5596129856135573697L, 5688200883751798389L, 5751393439502795295L, 5916409771425455946L, 5944107969236155580L, 6007332606592876737L, 6090377589998869205L, 6280357960959217660L, 6456855723474196908L, 6511035576063254270L, 6534946468240507089L, 6584624952928234050L, 6734240326434096246L, 6742705432718011780L, 6800727078373023163L, 6854854816081053523L, 7045245923763966215L, 7123326897294507060L, 7164889056054194741L, 7179336928365889465L, 7240293012336844478L, 7347653049056829645L, 7375862386996623731L, 7442624256860549330L, 7617522210483516279L, 7658177784286215602L, 8055461369741094911L, 8064026652676081192L, 8389032537095247355L, 8409640769019589119L, 8488266005336625107L, 8537233257283452655L, 8711531061028787095L, 8735538376409180149L, 8838294710098435315L, 8861402923078831179L, 9140390920032557669L, 9140416208800006522L, 9144212112462101475L};
        long[] jArr = new long[f19030v.length];
        int i5 = 0;
        while (true) {
            String[] strArr = f19030v;
            if (i5 >= strArr.length) {
                break;
            }
            jArr[i5] = o.I(strArr[i5]);
            i5++;
        }
        Arrays.sort(jArr);
        this.f19046l = jArr;
        this.f19053s = new a();
        this.f19047m = z5;
        if (c0914a == null && !C1152b.f22729b) {
            try {
                if (classLoader == null) {
                    c0914a = new C0914a(new C1151a());
                } else {
                    c0914a = new C0914a(classLoader);
                }
            } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException unused) {
            }
        }
        this.f19042h = c0914a;
        if (c0914a == null) {
            this.f19038d = false;
        }
        t();
        f(f19029u);
        g(f19028t);
        e(f19030v);
    }
}
