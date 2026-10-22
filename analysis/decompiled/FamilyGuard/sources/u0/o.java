package u0;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Path;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ranges.c;
import kotlin.ranges.h;
import kotlin.ranges.k;
import l0.AbstractC0822a;
import l0.C0823b;
import m0.InterfaceC0854b;
import m0.InterfaceC0856d;
import o0.C0888a;
import o0.C0893f;
import o0.C0896i;
import o0.EnumC0889b;
import org.libpag.BuildConfig;
import p0.t;
import p4.InterfaceC0931d;
import p4.InterfaceC0932e;
import q0.C0969p;
import q0.a0;
import q0.f0;

/* loaded from: classes.dex */
public class o {

    /* renamed from: A, reason: collision with root package name */
    private static volatile Map<Class, String[]> f22803A;

    /* renamed from: B, reason: collision with root package name */
    private static volatile boolean f22804B;

    /* renamed from: D, reason: collision with root package name */
    private static Class<?> f22806D;

    /* renamed from: N, reason: collision with root package name */
    private static Class f22816N;

    /* renamed from: O, reason: collision with root package name */
    private static InterfaceC1155e<Class, Boolean> f22817O;

    /* renamed from: P, reason: collision with root package name */
    private static InterfaceC1155e<Object, Object> f22818P;

    /* renamed from: Q, reason: collision with root package name */
    private static InterfaceC1155e<Object, Object> f22819Q;

    /* renamed from: R, reason: collision with root package name */
    public static InterfaceC1155e<Object, Object> f22820R;

    /* renamed from: S, reason: collision with root package name */
    private static InterfaceC1153c<Object, Class, Object> f22821S;

    /* renamed from: T, reason: collision with root package name */
    private static InterfaceC1155e<Map<String, Class<?>>, Void> f22822T;

    /* renamed from: U, reason: collision with root package name */
    private static final Map f22823U;

    /* renamed from: V, reason: collision with root package name */
    private static final Set<String> f22824V;

    /* renamed from: W, reason: collision with root package name */
    private static Object f22825W;

    /* renamed from: X, reason: collision with root package name */
    private static boolean f22826X;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f22828b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f22829c;

    /* renamed from: f, reason: collision with root package name */
    private static Method f22832f;

    /* renamed from: h, reason: collision with root package name */
    private static Method f22834h;

    /* renamed from: j, reason: collision with root package name */
    private static Class<?> f22836j;

    /* renamed from: l, reason: collision with root package name */
    private static Class<? extends Annotation> f22838l;

    /* renamed from: s, reason: collision with root package name */
    private static volatile Class f22845s;

    /* renamed from: t, reason: collision with root package name */
    private static volatile boolean f22846t;

    /* renamed from: u, reason: collision with root package name */
    private static volatile boolean f22847u;

    /* renamed from: v, reason: collision with root package name */
    private static volatile Constructor f22848v;

    /* renamed from: w, reason: collision with root package name */
    private static volatile Method f22849w;

    /* renamed from: x, reason: collision with root package name */
    private static volatile Method f22850x;

    /* renamed from: y, reason: collision with root package name */
    private static volatile Method f22851y;

    /* renamed from: z, reason: collision with root package name */
    private static volatile boolean f22852z;

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f22827a = Pattern.compile("\\.0*$");

    /* renamed from: d, reason: collision with root package name */
    private static boolean f22830d = true;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f22831e = false;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f22833g = false;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f22835i = false;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f22837k = false;

    /* renamed from: m, reason: collision with root package name */
    private static Class<? extends Annotation> f22839m = null;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f22840n = false;

    /* renamed from: o, reason: collision with root package name */
    private static Class<? extends Annotation> f22841o = null;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f22842p = false;

    /* renamed from: q, reason: collision with root package name */
    private static Method f22843q = null;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f22844r = false;

    /* renamed from: C, reason: collision with root package name */
    private static ConcurrentMap<String, Class<?>> f22805C = new ConcurrentHashMap(256, 0.75f, 1);

    /* renamed from: E, reason: collision with root package name */
    private static boolean f22807E = false;

    /* renamed from: F, reason: collision with root package name */
    private static Class<? extends Annotation> f22808F = null;

    /* renamed from: G, reason: collision with root package name */
    private static boolean f22809G = false;

    /* renamed from: H, reason: collision with root package name */
    private static volatile Class f22810H = null;

    /* renamed from: I, reason: collision with root package name */
    private static volatile Class f22811I = null;

    /* renamed from: J, reason: collision with root package name */
    private static volatile boolean f22812J = false;

    /* renamed from: K, reason: collision with root package name */
    private static volatile Method f22813K = null;

    /* renamed from: L, reason: collision with root package name */
    private static volatile Field f22814L = null;

    /* renamed from: M, reason: collision with root package name */
    private static volatile Object f22815M = null;

    static class a implements InterfaceC1155e<Class, Boolean> {
        a() {
        }

        @Override // u0.InterfaceC1155e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Class cls) {
            return Boolean.valueOf(Clob.class.isAssignableFrom(cls));
        }
    }

    static class b implements InterfaceC1155e<Object, Object> {
        b() {
        }

        @Override // u0.InterfaceC1155e
        public Object apply(Object obj) throws NumberFormatException {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Date) {
                return (Date) obj;
            }
            if (obj instanceof java.util.Date) {
                return new Date(((java.util.Date) obj).getTime());
            }
            if (obj instanceof Calendar) {
                return new Date(((Calendar) obj).getTimeInMillis());
            }
            long jD0 = obj instanceof BigDecimal ? o.D0((BigDecimal) obj) : obj instanceof Number ? ((Number) obj).longValue() : 0L;
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                    return null;
                }
                if (o.u0(str)) {
                    jD0 = Long.parseLong(str);
                } else {
                    C0893f c0893f = new C0893f(str);
                    if (!c0893f.t1(false)) {
                        throw new l0.d("can not cast to Timestamp, value : " + str);
                    }
                    jD0 = c0893f.F0().getTime().getTime();
                }
            }
            if (jD0 > 0) {
                return new Date(jD0);
            }
            throw new l0.d("can not cast to Date, value : " + obj);
        }
    }

    static class c implements InterfaceC1155e<Object, Object> {
        c() {
        }

        @Override // u0.InterfaceC1155e
        public Object apply(Object obj) throws NumberFormatException {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Time) {
                return (Time) obj;
            }
            if (obj instanceof java.util.Date) {
                return new Time(((java.util.Date) obj).getTime());
            }
            if (obj instanceof Calendar) {
                return new Time(((Calendar) obj).getTimeInMillis());
            }
            long jD0 = obj instanceof BigDecimal ? o.D0((BigDecimal) obj) : obj instanceof Number ? ((Number) obj).longValue() : 0L;
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equalsIgnoreCase(str)) {
                    return null;
                }
                if (o.u0(str)) {
                    jD0 = Long.parseLong(str);
                } else {
                    if (str.length() == 8 && str.charAt(2) == ':' && str.charAt(5) == ':') {
                        return Time.valueOf(str);
                    }
                    C0893f c0893f = new C0893f(str);
                    if (!c0893f.t1(false)) {
                        throw new l0.d("can not cast to Timestamp, value : " + str);
                    }
                    jD0 = c0893f.F0().getTime().getTime();
                }
            }
            if (jD0 > 0) {
                return new Time(jD0);
            }
            throw new l0.d("can not cast to Date, value : " + obj);
        }
    }

    static class d implements InterfaceC1155e<Object, Object> {
        d() {
        }

        @Override // u0.InterfaceC1155e
        public Object apply(Object obj) throws NumberFormatException {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Calendar) {
                return new Timestamp(((Calendar) obj).getTimeInMillis());
            }
            if (obj instanceof Timestamp) {
                return (Timestamp) obj;
            }
            if (obj instanceof java.util.Date) {
                return new Timestamp(((java.util.Date) obj).getTime());
            }
            long jD0 = obj instanceof BigDecimal ? o.D0((BigDecimal) obj) : obj instanceof Number ? ((Number) obj).longValue() : 0L;
            if (obj instanceof String) {
                String strSubstring = (String) obj;
                if (strSubstring.length() == 0 || "null".equals(strSubstring) || "NULL".equals(strSubstring)) {
                    return null;
                }
                if (strSubstring.endsWith(".000000000")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 10);
                } else if (strSubstring.endsWith(".000000")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 7);
                }
                if (strSubstring.length() == 29 && strSubstring.charAt(4) == '-' && strSubstring.charAt(7) == '-' && strSubstring.charAt(10) == ' ' && strSubstring.charAt(13) == ':' && strSubstring.charAt(16) == ':' && strSubstring.charAt(19) == '.') {
                    return new Timestamp(o.G0(strSubstring.charAt(0), strSubstring.charAt(1), strSubstring.charAt(2), strSubstring.charAt(3)) - 1900, o.F0(strSubstring.charAt(5), strSubstring.charAt(6)) - 1, o.F0(strSubstring.charAt(8), strSubstring.charAt(9)), o.F0(strSubstring.charAt(11), strSubstring.charAt(12)), o.F0(strSubstring.charAt(14), strSubstring.charAt(15)), o.F0(strSubstring.charAt(17), strSubstring.charAt(18)), o.H0(strSubstring.charAt(20), strSubstring.charAt(21), strSubstring.charAt(22), strSubstring.charAt(23), strSubstring.charAt(24), strSubstring.charAt(25), strSubstring.charAt(26), strSubstring.charAt(27), strSubstring.charAt(28)));
                }
                if (o.u0(strSubstring)) {
                    jD0 = Long.parseLong(strSubstring);
                } else {
                    C0893f c0893f = new C0893f(strSubstring);
                    if (!c0893f.t1(false)) {
                        throw new l0.d("can not cast to Timestamp, value : " + strSubstring);
                    }
                    jD0 = c0893f.F0().getTime().getTime();
                }
            }
            return new Timestamp(jD0);
        }
    }

    static class e implements InterfaceC1153c<Object, Class, Object> {
        e() {
        }

        @Override // u0.InterfaceC1153c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object obj, Class cls) {
            if (cls == Date.class) {
                return o.x(obj);
            }
            if (cls == Time.class) {
                return o.y(obj);
            }
            if (cls == Timestamp.class) {
                return o.A(obj);
            }
            return null;
        }
    }

    static class f implements InterfaceC1155e<Map<String, Class<?>>, Void> {
        f() {
        }

        @Override // u0.InterfaceC1155e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void apply(Map<String, Class<?>> map) {
            Class<?>[] clsArr = {Time.class, Date.class, Timestamp.class};
            for (int i5 = 0; i5 < 3; i5++) {
                Class<?> cls = clsArr[i5];
                if (cls != null) {
                    map.put(cls.getName(), cls);
                }
            }
            return null;
        }
    }

    static class g extends HashMap<Class, String> {
        g(int i5) {
            super(i5);
            put(Boolean.TYPE, "Z");
            put(Character.TYPE, "C");
            put(Byte.TYPE, "B");
            put(Short.TYPE, ExifInterface.LATITUDE_SOUTH);
            put(Integer.TYPE, "I");
            put(Long.TYPE, "J");
            put(Float.TYPE, "F");
            put(Double.TYPE, "D");
        }
    }

    static class h extends HashSet<String> {
        h(int i5) {
            super(i5);
            add("net.sf.cglib.proxy.Factory");
            add("org.springframework.cglib.proxy.Factory");
            add("javassist.util.proxy.ProxyObject");
            add("org.apache.ibatis.javassist.util.proxy.ProxyObject");
            add("org.hibernate.proxy.HibernateProxy");
            add("org.springframework.context.annotation.ConfigurationClassEnhancer$EnhancedConfiguration");
        }
    }

    public static class i implements Comparator<Method> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Method method, Method method2) {
            int iCompareTo = method.getName().compareTo(method2.getName());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            Class<?> returnType = method.getReturnType();
            Class<?> returnType2 = method2.getReturnType();
            if (returnType.equals(returnType2)) {
                return 0;
            }
            if (returnType.isAssignableFrom(returnType2)) {
                return -1;
            }
            return returnType2.isAssignableFrom(returnType) ? 1 : 0;
        }
    }

    static {
        f22828b = false;
        f22829c = false;
        f22816N = null;
        try {
            f22828b = "true".equals(u0.g.h("fastjson.compatibleWithJavaBean"));
            f22829c = "true".equals(u0.g.h("fastjson.compatibleWithFieldName"));
        } catch (Throwable unused) {
        }
        try {
            f22816N = Deque.class;
        } catch (Throwable unused2) {
        }
        f22817O = new a();
        f22818P = new b();
        f22819Q = new c();
        f22820R = new d();
        f22821S = new e();
        f22822T = new f();
        a();
        f22823U = new g(8);
        f22824V = new h(6);
        f22826X = false;
    }

    public static Object A(Object obj) {
        return j.c(f22820R, obj);
    }

    public static Class<?> A0(String str, ClassLoader classLoader) {
        return B0(str, classLoader, false);
    }

    private static void B(Class<?> cls, Map<String, String> map, l0.m mVar, Map<String, C1154d> map2, Field[] fieldArr) throws NoSuchFieldException {
        int i5;
        int i6;
        int i7;
        String strLabel;
        for (Field field : fieldArr) {
            if (!Modifier.isStatic(field.getModifiers())) {
                InterfaceC0854b interfaceC0854b = (InterfaceC0854b) N(field, InterfaceC0854b.class);
                String name = field.getName();
                if (interfaceC0854b == null) {
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    strLabel = null;
                } else if (interfaceC0854b.serialize()) {
                    int iOrdinal = interfaceC0854b.ordinal();
                    int iG = f0.g(interfaceC0854b.serialzeFeatures());
                    int iE = EnumC0889b.e(interfaceC0854b.parseFeatures());
                    if (interfaceC0854b.name().length() != 0) {
                        name = interfaceC0854b.name();
                    }
                    strLabel = interfaceC0854b.label().length() != 0 ? interfaceC0854b.label() : null;
                    i5 = iOrdinal;
                    i6 = iG;
                    i7 = iE;
                }
                if (map == null || (name = map.get(name)) != null) {
                    if (mVar != null) {
                        name = mVar.b(name);
                    }
                    String str = name;
                    if (!map2.containsKey(str)) {
                        map2.put(str, new C1154d(str, null, field, cls, null, i5, i6, i7, null, interfaceC0854b, strLabel));
                    }
                }
            }
        }
    }

    public static Class<?> B0(String str, ClassLoader classLoader, boolean z5) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() > 198) {
            throw new l0.d("illegal className : " + str);
        }
        Class<?> clsLoadClass = f22805C.get(str);
        if (clsLoadClass != null) {
            return clsLoadClass;
        }
        if (str.charAt(0) == '[') {
            return Array.newInstance(A0(str.substring(1), classLoader), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(";")) {
            return A0(str.substring(1, str.length() - 1), classLoader);
        }
        if (classLoader != null) {
            try {
                clsLoadClass = classLoader.loadClass(str);
                if (!z5) {
                    return clsLoadClass;
                }
                f22805C.put(str, clsLoadClass);
                return clsLoadClass;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null && contextClassLoader != classLoader) {
                clsLoadClass = contextClassLoader.loadClass(str);
                if (z5) {
                    f22805C.put(str, clsLoadClass);
                }
                return clsLoadClass;
            }
        } catch (Throwable unused) {
        }
        try {
            clsLoadClass = Class.forName(str);
            if (z5) {
                f22805C.put(str, clsLoadClass);
            }
        } catch (Throwable unused2) {
        }
        return clsLoadClass;
    }

    /* JADX WARN: Code restructure failed: missing block: B:248:0x0462, code lost:
    
        if (r0 == null) goto L202;
     */
    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
    	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    /* JADX WARN: Removed duplicated region for block: B:147:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x040d A[PHI: r12
      0x040d: PHI (r12v7 java.util.Map<java.lang.String, java.lang.reflect.Field>) = 
      (r12v6 java.util.Map<java.lang.String, java.lang.reflect.Field>)
      (r12v8 java.util.Map<java.lang.String, java.lang.reflect.Field>)
      (r12v8 java.util.Map<java.lang.String, java.lang.reflect.Field>)
     binds: [B:228:0x040b, B:231:0x0414, B:241:0x0433] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0466 A[PHI: r0
      0x0466: PHI (r0v29 java.lang.String) = (r0v19 java.lang.String), (r0v31 java.lang.String) binds: [B:244:0x0452, B:246:0x0458] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0101 A[PHI: r6 r8 r21
      0x0101: PHI (r6v14 java.lang.String[]) = (r6v1 java.lang.String[]), (r6v1 java.lang.String[]), (r6v16 java.lang.String[]) binds: [B:44:0x00c5, B:46:0x00cf, B:48:0x00d9] A[DONT_GENERATE, DONT_INLINE]
      0x0101: PHI (r8v14 java.lang.annotation.Annotation[][]) = 
      (r8v1 java.lang.annotation.Annotation[][])
      (r8v1 java.lang.annotation.Annotation[][])
      (r8v16 java.lang.annotation.Annotation[][])
     binds: [B:44:0x00c5, B:46:0x00cf, B:48:0x00d9] A[DONT_GENERATE, DONT_INLINE]
      0x0101: PHI (r21v2 java.lang.reflect.Constructor<?>[]) = 
      (r21v0 java.lang.reflect.Constructor<?>[])
      (r21v7 java.lang.reflect.Constructor<?>[])
      (r21v7 java.lang.reflect.Constructor<?>[])
     binds: [B:44:0x00c5, B:46:0x00cf, B:48:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<u0.C1154d> C(java.lang.Class<?> r32, m0.InterfaceC0856d r33, java.util.Map<java.lang.String, java.lang.String> r34, java.util.Map<java.lang.String, java.lang.reflect.Field> r35, boolean r36, l0.m r37) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 1221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.o.C(java.lang.Class, m0.d, java.util.Map, java.util.Map, boolean, l0.m):java.util.List");
    }

    public static long C0(Number number) {
        return number instanceof BigDecimal ? ((BigDecimal) number).longValueExact() : number.longValue();
    }

    public static List<C1154d> D(Class<?> cls, Map<String, String> map, boolean z5, l0.m mVar) throws NoSuchFieldException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            B(superclass, map, mVar, linkedHashMap, superclass.getDeclaredFields());
        }
        return X(cls, z5, linkedHashMap);
    }

    public static long D0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0L;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.longValueExact() : bigDecimal.longValue();
    }

    private static Map<TypeVariable, Type> E(TypeVariable[] typeVariableArr, Type[] typeArr) {
        int length = typeVariableArr.length;
        HashMap map = new HashMap(length);
        for (int i5 = 0; i5 < length; i5++) {
            map.put(typeVariableArr[i5], typeArr[i5]);
        }
        return map;
    }

    private static ParameterizedType E0(Class<?> cls, Type[] typeArr, Map<TypeVariable, Type> map) {
        int length = typeArr.length;
        Type[] typeArr2 = new Type[length];
        for (int i5 = 0; i5 < length; i5++) {
            typeArr2[i5] = L(typeArr[i5], map);
        }
        return new k(typeArr2, null, cls);
    }

    public static Collection F(Type type) {
        Class<?> cls;
        Class<?> clsH0 = h0(type);
        if (clsH0 == AbstractCollection.class || clsH0 == Collection.class) {
            return new ArrayList();
        }
        if (clsH0.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (clsH0.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (clsH0.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (clsH0.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (clsH0.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        if (clsH0.isAssignableFrom(Queue.class) || ((cls = f22816N) != null && clsH0.isAssignableFrom(cls))) {
            return new LinkedList();
        }
        try {
            return (Collection) clsH0.newInstance();
        } catch (Exception unused) {
            throw new l0.d("create instance error, class " + clsH0.getName());
        }
    }

    static int F0(char c6, char c7) {
        if (c6 < '0' || c6 > '9' || c7 < '0' || c7 > '9') {
            return -1;
        }
        return ((c6 - '0') * 10) + (c7 - '0');
    }

    public static Set G(Type type) {
        Class<?> clsH0 = h0(type);
        if (clsH0 == AbstractCollection.class || clsH0 == Collection.class) {
            return new HashSet();
        }
        if (clsH0.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (clsH0.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (clsH0.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (clsH0.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        try {
            return (Set) clsH0.newInstance();
        } catch (Exception unused) {
            throw new l0.d("create instance error, class " + clsH0.getName());
        }
    }

    static int G0(char c6, char c7, char c8, char c9) {
        if (c6 < '0' || c6 > '9' || c7 < '0' || c7 > '9' || c8 < '0' || c8 > '9' || c9 < '0' || c9 > '9') {
            return -1;
        }
        return ((c6 - '0') * 1000) + ((c7 - '0') * 100) + ((c8 - '0') * 10) + (c9 - '0');
    }

    public static String H(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    static int H0(char c6, char c7, char c8, char c9, char c10, char c11, char c12, char c13, char c14) {
        if (c6 < '0' || c6 > '9' || c7 < '0' || c7 > '9' || c8 < '0' || c8 > '9' || c9 < '0' || c9 > '9' || c10 < '0' || c10 > '9' || c11 < '0' || c11 > '9' || c12 < '0' || c12 > '9' || c13 < '0' || c13 > '9' || c14 < '0' || c14 > '9') {
            return -1;
        }
        return ((c6 - '0') * 100000000) + ((c7 - '0') * 10000000) + ((c8 - '0') * 1000000) + ((c9 - '0') * 100000) + ((c10 - '0') * 10000) + ((c11 - '0') * 1000) + ((c12 - '0') * 100) + ((c13 - '0') * 10) + (c14 - '0');
    }

    public static long I(String str) {
        long jCharAt = -3750763034362895579L;
        for (int i5 = 0; i5 < str.length(); i5++) {
            jCharAt = (jCharAt ^ str.charAt(i5)) * 1099511628211L;
        }
        return jCharAt;
    }

    public static Object I0(Type type) {
        Class<?> clsP;
        if (f22826X || (clsP = P(type)) == null) {
            return null;
        }
        String name = clsP.getName();
        if (!"java.util.Optional".equals(name)) {
            return null;
        }
        if (f22825W == null) {
            try {
                f22825W = Class.forName(name).getMethod("empty", null).invoke(null, null);
            } catch (Throwable unused) {
                f22826X = true;
            }
        }
        return f22825W;
    }

    public static long J(String str) {
        long j5 = -3750763034362895579L;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt != '_' && cCharAt != '-') {
                if (cCharAt >= 'A' && cCharAt <= 'Z') {
                    cCharAt = (char) (cCharAt + ' ');
                }
                j5 = (j5 ^ cCharAt) * 1099511628211L;
            }
        }
        return j5;
    }

    public static double J0(String str) {
        double d6;
        double d7;
        int length = str.length();
        if (length > 10) {
            return Double.parseDouble(str);
        }
        long j5 = 0;
        boolean z5 = false;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt = str.charAt(i6);
            if (cCharAt == '-' && i6 == 0) {
                z5 = true;
            } else if (cCharAt == '.') {
                if (i5 != 0) {
                    return Double.parseDouble(str);
                }
                i5 = (length - i6) - 1;
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    return Double.parseDouble(str);
                }
                j5 = (j5 * 10) + (cCharAt - '0');
            }
        }
        if (z5) {
            j5 = -j5;
        }
        switch (i5) {
            case 0:
                return j5;
            case 1:
                d6 = j5;
                d7 = 10.0d;
                break;
            case 2:
                d6 = j5;
                d7 = 100.0d;
                break;
            case 3:
                d6 = j5;
                d7 = 1000.0d;
                break;
            case 4:
                d6 = j5;
                d7 = 10000.0d;
                break;
            case 5:
                d6 = j5;
                d7 = 100000.0d;
                break;
            case 6:
                d6 = j5;
                d7 = 1000000.0d;
                break;
            case 7:
                d6 = j5;
                d7 = 1.0E7d;
                break;
            case 8:
                d6 = j5;
                d7 = 1.0E8d;
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                d6 = j5;
                d7 = 1.0E9d;
                break;
            default:
                return Double.parseDouble(str);
        }
        return d6 / d7;
    }

    public static long K(String str) {
        long j5 = -3750763034362895579L;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                cCharAt = (char) (cCharAt + ' ');
            }
            j5 = (j5 ^ cCharAt) * 1099511628211L;
        }
        return j5;
    }

    public static float K0(String str) {
        float f5;
        float f6;
        int length = str.length();
        if (length >= 10) {
            return Float.parseFloat(str);
        }
        long j5 = 0;
        boolean z5 = false;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt = str.charAt(i6);
            if (cCharAt == '-' && i6 == 0) {
                z5 = true;
            } else if (cCharAt == '.') {
                if (i5 != 0) {
                    return Float.parseFloat(str);
                }
                i5 = (length - i6) - 1;
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    return Float.parseFloat(str);
                }
                j5 = (j5 * 10) + (cCharAt - '0');
            }
        }
        if (z5) {
            j5 = -j5;
        }
        switch (i5) {
            case 0:
                return j5;
            case 1:
                f5 = j5;
                f6 = 10.0f;
                break;
            case 2:
                f5 = j5;
                f6 = 100.0f;
                break;
            case 3:
                f5 = j5;
                f6 = 1000.0f;
                break;
            case 4:
                f5 = j5;
                f6 = 10000.0f;
                break;
            case 5:
                f5 = j5;
                f6 = 100000.0f;
                break;
            case 6:
                f5 = j5;
                f6 = 1000000.0f;
                break;
            case 7:
                f5 = j5;
                f6 = 1.0E7f;
                break;
            case 8:
                f5 = j5;
                f6 = 1.0E8f;
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                f5 = j5;
                f6 = 1.0E9f;
                break;
            default:
                return Float.parseFloat(str);
        }
        return f5 / f6;
    }

    private static Type L(Type type, Map<TypeVariable, Type> map) {
        return type instanceof TypeVariable ? map.get(type) : type instanceof ParameterizedType ? E0(h0(type), ((ParameterizedType) type).getActualTypeArguments(), map) : type instanceof GenericArrayType ? new u0.f(L(((GenericArrayType) type).getGenericComponentType(), map)) : type;
    }

    static void L0(AccessibleObject accessibleObject) {
        if (f22830d && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (Throwable unused) {
                f22830d = false;
            }
        }
    }

    public static <A extends Annotation> A M(Class<?> cls, Class<A> cls2) {
        A a6 = (A) cls.getAnnotation(cls2);
        Type typeP = AbstractC0822a.p(cls);
        Class cls3 = typeP instanceof Class ? (Class) typeP : null;
        if (cls3 != null) {
            A a7 = (A) cls3.getAnnotation(cls2);
            Annotation[] annotations = cls3.getAnnotations();
            if (a7 == null && annotations.length > 0) {
                for (Annotation annotation : annotations) {
                    a7 = (A) annotation.annotationType().getAnnotation(cls2);
                    if (a7 != null) {
                        break;
                    }
                }
            }
            if (a7 != null) {
                return a7;
            }
        }
        Annotation[] annotations2 = cls.getAnnotations();
        if (a6 == null && annotations2.length > 0) {
            for (Annotation annotation2 : annotations2) {
                a6 = (A) annotation2.annotationType().getAnnotation(cls2);
                if (a6 != null) {
                    return a6;
                }
            }
        }
        return a6;
    }

    public static short M0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (short) 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.shortValueExact() : bigDecimal.shortValue();
    }

    public static <A extends Annotation> A N(Field field, Class<A> cls) throws NoSuchFieldException {
        A a6;
        A a7 = (A) field.getAnnotation(cls);
        Type typeP = AbstractC0822a.p(field.getDeclaringClass());
        Field declaredField = null;
        Class superclass = typeP instanceof Class ? (Class) typeP : null;
        if (superclass != null) {
            String name = field.getName();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredField = superclass.getDeclaredField(name);
                    break;
                } catch (NoSuchFieldException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredField != null && (a6 = (A) declaredField.getAnnotation(cls)) != null) {
                return a6;
            }
        }
        return a7;
    }

    public static Locale N0(String str) {
        String[] strArrSplit = str.split("_");
        return strArrSplit.length == 1 ? new Locale(strArrSplit[0]) : strArrSplit.length == 2 ? new Locale(strArrSplit[0], strArrSplit[1]) : new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }

    public static <A extends Annotation> A O(Method method, Class<A> cls) throws NoSuchMethodException, SecurityException {
        A a6;
        A a7 = (A) method.getAnnotation(cls);
        Type typeP = AbstractC0822a.p(method.getDeclaringClass());
        Method declaredMethod = null;
        Class superclass = typeP instanceof Class ? (Class) typeP : null;
        if (superclass != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredMethod = superclass.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredMethod != null && (a6 = (A) declaredMethod.getAnnotation(cls)) != null) {
                return a6;
            }
        }
        return a7;
    }

    public static Type O0(Type type) {
        if (!f22835i) {
            try {
                f22836j = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } catch (Throwable th) {
                f22835i = true;
                throw th;
            }
            f22835i = true;
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getRawType() == f22836j ? parameterizedType.getActualTypeArguments()[0] : type;
    }

    public static Class<?> P(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return P(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            Type type2 = ((TypeVariable) type).getBounds()[0];
            return type2 instanceof Class ? (Class) type2 : P(type2);
        }
        if (!(type instanceof WildcardType)) {
            return Object.class;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length == 1 ? P(upperBounds[0]) : Object.class;
    }

    public static Class<?> Q(String str) {
        return f22805C.get(str);
    }

    public static Class<?> R(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        if (!(type2 instanceof Class)) {
            throw new l0.d("can not create ASMParser");
        }
        Class<?> cls = (Class) type2;
        if (Modifier.isPublic(cls.getModifiers())) {
            return cls;
        }
        throw new l0.d("can not create ASMParser");
    }

    private static Type S(Class<?> cls) {
        return cls.getName().startsWith("java.") ? Object.class : U(V(cls));
    }

    private static Type T(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (rawType == Collection.class) {
            return j0(actualTypeArguments[0]);
        }
        Class cls = (Class) rawType;
        Map<TypeVariable, Type> mapE = E(cls.getTypeParameters(), actualTypeArguments);
        Type typeV = V(cls);
        if (!(typeV instanceof ParameterizedType)) {
            return S((Class) typeV);
        }
        Class<?> clsH0 = h0(typeV);
        Type[] actualTypeArguments2 = ((ParameterizedType) typeV).getActualTypeArguments();
        return actualTypeArguments2.length > 0 ? T(E0(clsH0, actualTypeArguments2, mapE)) : S(clsH0);
    }

    public static Type U(Type type) {
        return type instanceof ParameterizedType ? T((ParameterizedType) type) : type instanceof Class ? S((Class) type) : Object.class;
    }

    private static Type V(Class<?> cls) {
        Type type = null;
        for (Type type2 : cls.getGenericInterfaces()) {
            Class<?> clsH0 = h0(type2);
            if (clsH0 == Collection.class) {
                return type2;
            }
            if (Collection.class.isAssignableFrom(clsH0)) {
                type = type2;
            }
        }
        return type == null ? cls.getGenericSuperclass() : type;
    }

    public static Field W(Class<?> cls, String str, Field[] fieldArr) {
        char cCharAt;
        char cCharAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name) || (str.length() > 2 && (cCharAt = str.charAt(0)) >= 'a' && cCharAt <= 'z' && (cCharAt2 = str.charAt(1)) >= 'A' && cCharAt2 <= 'Z' && str.equalsIgnoreCase(name))) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return W(superclass, str, superclass.getDeclaredFields());
    }

    private static List<C1154d> X(Class<?> cls, boolean z5, Map<String, C1154d> map) {
        ArrayList arrayList = new ArrayList();
        InterfaceC0856d interfaceC0856d = (InterfaceC0856d) M(cls, InterfaceC0856d.class);
        String[] strArrOrders = interfaceC0856d != null ? interfaceC0856d.orders() : null;
        if (strArrOrders == null || strArrOrders.length <= 0) {
            arrayList.addAll(map.values());
            if (z5) {
                Collections.sort(arrayList);
            }
            return arrayList;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
        for (C1154d c1154d : map.values()) {
            linkedHashMap.put(c1154d.f22730a, c1154d);
        }
        for (String str : strArrOrders) {
            C1154d c1154d2 = (C1154d) linkedHashMap.get(str);
            if (c1154d2 != null) {
                arrayList.add(c1154d2);
                linkedHashMap.remove(str);
            }
        }
        arrayList.addAll(linkedHashMap.values());
        return arrayList;
    }

    public static Type Y(Type type) {
        return (!(type instanceof ParameterizedType) && (type instanceof Class)) ? Y(((Class) type).getGenericSuperclass()) : type;
    }

    public static String[] Z(Class cls) {
        if (f22848v == null && !f22847u) {
            try {
                f22848v = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getConstructor(Class.class);
            } catch (Throwable unused) {
                f22847u = true;
            }
        }
        if (f22848v == null) {
            return null;
        }
        if (f22849w == null && !f22847u) {
            try {
                f22849w = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getMethod("getConstructors", null);
            } catch (Throwable unused2) {
                f22847u = true;
            }
        }
        if (f22850x == null && !f22847u) {
            try {
                f22850x = InterfaceC0931d.class.getMethod("getParameters", null);
            } catch (Throwable unused3) {
                f22847u = true;
            }
        }
        if (f22851y == null && !f22847u) {
            try {
                f22851y = InterfaceC0932e.class.getMethod("getName", null);
            } catch (Throwable unused4) {
                f22847u = true;
            }
        }
        if (f22852z) {
            return null;
        }
        try {
            Iterator it = ((Iterable) f22849w.invoke(f22848v.newInstance(cls), null)).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) f22850x.invoke(next, null);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            if (obj == null) {
                return null;
            }
            List list2 = (List) f22850x.invoke(obj, null);
            String[] strArr = new String[list2.size()];
            for (int i5 = 0; i5 < list2.size(); i5++) {
                strArr[i5] = (String) f22851y.invoke(list2.get(i5), null);
            }
            return strArr;
        } catch (Throwable th) {
            th.printStackTrace();
            f22852z = true;
            return null;
        }
    }

    private static void a() {
        f22805C.put("byte", Byte.TYPE);
        f22805C.put("short", Short.TYPE);
        f22805C.put("int", Integer.TYPE);
        f22805C.put("long", Long.TYPE);
        f22805C.put("float", Float.TYPE);
        f22805C.put("double", Double.TYPE);
        f22805C.put("boolean", Boolean.TYPE);
        f22805C.put("char", Character.TYPE);
        f22805C.put("[byte", byte[].class);
        f22805C.put("[short", short[].class);
        f22805C.put("[int", int[].class);
        f22805C.put("[long", long[].class);
        f22805C.put("[float", float[].class);
        f22805C.put("[double", double[].class);
        f22805C.put("[boolean", boolean[].class);
        f22805C.put("[char", char[].class);
        f22805C.put("[B", byte[].class);
        f22805C.put("[S", short[].class);
        f22805C.put("[I", int[].class);
        f22805C.put("[J", long[].class);
        f22805C.put("[F", float[].class);
        f22805C.put("[D", double[].class);
        f22805C.put("[C", char[].class);
        f22805C.put("[Z", boolean[].class);
        Class<?>[] clsArr = {Object.class, Cloneable.class, z0("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, LinkedHashMap.class, Hashtable.class, TreeMap.class, IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, ArrayList.class, TimeUnit.class, ConcurrentHashMap.class, AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Number.class, String.class, BigDecimal.class, BigInteger.class, BitSet.class, Calendar.class, java.util.Date.class, Locale.class, UUID.class, SimpleDateFormat.class, l0.e.class, l0.f.class, C0823b.class};
        for (int i5 = 0; i5 < 69; i5++) {
            Class<?> cls = clsArr[i5];
            if (cls != null) {
                f22805C.put(cls.getName(), cls);
            }
        }
        j.c(f22822T, f22805C);
    }

    public static Constructor a0(Constructor[] constructorArr) {
        return b0(constructorArr, null);
    }

    public static void b(String str, Class<?> cls) {
        f22805C.put(str, cls);
    }

    public static Constructor b0(Constructor[] constructorArr, String[] strArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if ((strArr == null || parameterTypes.length == strArr.length) && ((parameterTypes.length <= 0 || !parameterTypes[parameterTypes.length - 1].getName().equals("j4.g")) && (constructor == null || constructor.getParameterTypes().length < parameterTypes.length))) {
                constructor = constructor2;
            }
        }
        return constructor;
    }

    public static a0 c(Class<?> cls, Map<String, String> map, l0.m mVar) throws NoSuchFieldException, SecurityException {
        return d(cls, map, mVar, false);
    }

    public static Annotation[][] c0(Constructor constructor) {
        Annotation[][] parameterAnnotations;
        Constructor declaredConstructor;
        Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
        Type typeP = AbstractC0822a.p(constructor.getDeclaringClass());
        Constructor constructor2 = null;
        Class cls = typeP instanceof Class ? (Class) typeP : null;
        if (cls != null) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            ArrayList arrayList = new ArrayList(2);
            for (Class<?> enclosingClass = cls.getEnclosingClass(); enclosingClass != null; enclosingClass = enclosingClass.getEnclosingClass()) {
                arrayList.add(enclosingClass);
            }
            int size = arrayList.size();
            Class superclass = cls;
            while (true) {
                if (superclass == null || superclass == Object.class) {
                    break;
                }
                try {
                    if (size != 0) {
                        Class<?>[] clsArr = new Class[parameterTypes.length + size];
                        System.arraycopy(parameterTypes, 0, clsArr, size, parameterTypes.length);
                        for (int i5 = size; i5 > 0; i5--) {
                            int i6 = i5 - 1;
                            clsArr[i6] = (Class) arrayList.get(i6);
                        }
                        declaredConstructor = cls.getDeclaredConstructor(clsArr);
                    } else {
                        declaredConstructor = cls.getDeclaredConstructor(parameterTypes);
                    }
                    constructor2 = declaredConstructor;
                } catch (NoSuchMethodException unused) {
                    size--;
                    superclass = superclass.getSuperclass();
                }
            }
            if (constructor2 != null && (parameterAnnotations = constructor2.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static a0 d(Class<?> cls, Map<String, String> map, l0.m mVar, boolean z5) throws NoSuchFieldException, SecurityException {
        l0.m mVar2;
        int i5;
        String[] strArr;
        String str;
        String str2;
        Class<?> cls2;
        Map<String, String> map2;
        List<C1154d> listC;
        List arrayList;
        InterfaceC0856d interfaceC0856d = (InterfaceC0856d) M(cls, InterfaceC0856d.class);
        if (interfaceC0856d != null) {
            String[] strArrOrders = interfaceC0856d.orders();
            String strTypeName = interfaceC0856d.typeName();
            if (strTypeName.length() == 0) {
                strTypeName = null;
            }
            l0.m mVarNaming = interfaceC0856d.naming();
            if (mVarNaming != l0.m.NeverUseThisValueExceptDefaultValue) {
                mVar = mVarNaming;
            }
            int iG = f0.g(interfaceC0856d.serialzeFeatures());
            String strTypeKey = null;
            for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                InterfaceC0856d interfaceC0856d2 = (InterfaceC0856d) M(superclass, InterfaceC0856d.class);
                if (interfaceC0856d2 == null) {
                    break;
                }
                strTypeKey = interfaceC0856d2.typeKey();
                if (strTypeKey.length() != 0) {
                    break;
                }
            }
            for (Class<?> cls3 : cls.getInterfaces()) {
                InterfaceC0856d interfaceC0856d3 = (InterfaceC0856d) M(cls3, InterfaceC0856d.class);
                if (interfaceC0856d3 != null) {
                    strTypeKey = interfaceC0856d3.typeKey();
                    if (strTypeKey.length() != 0) {
                        break;
                    }
                }
            }
            mVar2 = mVar;
            str2 = (strTypeKey == null || strTypeKey.length() != 0) ? strTypeKey : null;
            strArr = strArrOrders;
            str = strTypeName;
            i5 = iG;
        } else {
            mVar2 = mVar;
            i5 = 0;
            strArr = null;
            str = null;
            str2 = null;
        }
        HashMap map3 = new HashMap();
        C0896i.x(cls, map3);
        if (z5) {
            listC = D(cls, map, false, mVar2);
            cls2 = cls;
            map2 = map;
        } else {
            cls2 = cls;
            map2 = map;
            listC = C(cls2, interfaceC0856d, map2, map3, false, mVar2);
        }
        C1154d[] c1154dArr = new C1154d[listC.size()];
        listC.toArray(c1154dArr);
        if (strArr == null || strArr.length == 0) {
            arrayList = new ArrayList(listC);
            Collections.sort(arrayList);
        } else {
            arrayList = z5 ? D(cls2, map2, true, mVar2) : C(cls2, interfaceC0856d, map2, map3, true, mVar2);
        }
        C1154d[] c1154dArr2 = new C1154d[arrayList.size()];
        arrayList.toArray(c1154dArr2);
        if (Arrays.equals(c1154dArr2, c1154dArr)) {
            c1154dArr2 = c1154dArr;
        }
        return new a0(cls2, interfaceC0856d, str, str2, i5, c1154dArr, c1154dArr2);
    }

    public static Annotation[][] d0(Method method) {
        Annotation[][] parameterAnnotations;
        Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
        Type typeP = AbstractC0822a.p(method.getDeclaringClass());
        Method declaredMethod = null;
        Class superclass = typeP instanceof Class ? (Class) typeP : null;
        if (superclass != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredMethod = superclass.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredMethod != null && (parameterAnnotations = declaredMethod.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static byte e(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (byte) 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.byteValueExact() : bigDecimal.byteValue();
    }

    public static int e0(Class<?> cls) {
        InterfaceC0856d interfaceC0856d = (InterfaceC0856d) M(cls, InterfaceC0856d.class);
        if (interfaceC0856d == null) {
            return 0;
        }
        return EnumC0889b.e(interfaceC0856d.parseFeatures());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T f(Object obj, Class<T> cls, C0896i c0896i) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        Object obj2;
        Class<T> cls2 = Boolean.TYPE;
        Class<T> cls3 = Double.TYPE;
        Class<T> cls4 = Float.TYPE;
        Class<T> cls5 = Byte.TYPE;
        Class<T> cls6 = Short.TYPE;
        Class<T> cls7 = Long.TYPE;
        Class<T> cls8 = Integer.TYPE;
        int i5 = 0;
        if (obj == 0) {
            if (cls == cls8) {
                return (T) 0;
            }
            if (cls == cls7) {
                return (T) 0L;
            }
            if (cls == cls6) {
                return (T) (short) 0;
            }
            if (cls == cls5) {
                return (T) (byte) 0;
            }
            if (cls == cls4) {
                return (T) Float.valueOf(0.0f);
            }
            if (cls == cls3) {
                return (T) Double.valueOf(0.0d);
            }
            if (cls == cls2) {
                return (T) Boolean.FALSE;
            }
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls != obj.getClass()) {
            if (!(obj instanceof Map)) {
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection collection = (Collection) obj;
                        T t5 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                        Iterator it = collection.iterator();
                        while (it.hasNext()) {
                            Array.set(t5, i5, f(it.next(), cls.getComponentType(), c0896i));
                            i5++;
                        }
                        return t5;
                    }
                    if (cls == byte[].class) {
                        return (T) m(obj);
                    }
                }
                if (!cls.isAssignableFrom(obj.getClass())) {
                    if (cls == cls2 || cls == Boolean.class) {
                        return (T) k(obj);
                    }
                    if (cls == cls5 || cls == Byte.class) {
                        return (T) l(obj);
                    }
                    if (cls == Character.TYPE || cls == Character.class) {
                        return (T) n(obj);
                    }
                    if (cls == cls6 || cls == Short.class) {
                        return (T) w(obj);
                    }
                    if (cls == cls8 || cls == Integer.class) {
                        return (T) t(obj);
                    }
                    if (cls == cls7 || cls == Long.class) {
                        return (T) v(obj);
                    }
                    if (cls == cls4 || cls == Float.class) {
                        return (T) s(obj);
                    }
                    if (cls == cls3 || cls == Double.class) {
                        return (T) q(obj);
                    }
                    if (cls == String.class) {
                        return (T) z(obj);
                    }
                    if (cls == BigDecimal.class) {
                        return (T) i(obj);
                    }
                    if (cls == BigInteger.class) {
                        return (T) j(obj);
                    }
                    if (cls == java.util.Date.class) {
                        return (T) o(obj);
                    }
                    T t6 = (T) j.b(f22821S, obj, cls);
                    if (t6 != null) {
                        return t6;
                    }
                    if (cls.isEnum()) {
                        return (T) r(obj, cls, c0896i);
                    }
                    if (Calendar.class.isAssignableFrom(cls)) {
                        java.util.Date dateO = o(obj);
                        if (cls == Calendar.class) {
                            obj2 = (T) Calendar.getInstance(AbstractC0822a.f18016a, AbstractC0822a.f18017b);
                        } else {
                            try {
                                obj2 = (T) ((Calendar) cls.newInstance());
                            } catch (Exception e6) {
                                throw new l0.d("can not cast to : " + cls.getName(), e6);
                            }
                        }
                        ((Calendar) obj2).setTime(dateO);
                        return (T) obj2;
                    }
                    String name = cls.getName();
                    if (name.equals("javax.xml.datatype.XMLGregorianCalendar")) {
                        java.util.Date dateO2 = o(obj);
                        Calendar calendar = Calendar.getInstance(AbstractC0822a.f18016a, AbstractC0822a.f18017b);
                        calendar.setTime(dateO2);
                        return (T) C0969p.f19871b.g(calendar);
                    }
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                            return null;
                        }
                        if (cls == Currency.class) {
                            return (T) Currency.getInstance(str);
                        }
                        if (cls == Locale.class) {
                            return (T) N0(str);
                        }
                        if (name.startsWith("java.time.")) {
                            return (T) AbstractC0822a.x(AbstractC0822a.F(str), cls);
                        }
                    }
                    if (c0896i.l(cls) != null) {
                        return (T) AbstractC0822a.x(AbstractC0822a.F(obj), cls);
                    }
                    throw new l0.d("can not cast to : " + cls.getName());
                }
            } else if (cls != Map.class) {
                Map map = (Map) obj;
                if (cls != Object.class || map.containsKey(AbstractC0822a.f18018c)) {
                    return (T) u(map, cls, c0896i);
                }
            }
        }
        return obj;
    }

    private static String f0(Map<String, Field> map, String str, String str2, int i5) {
        if (f22829c && !map.containsKey(str2)) {
            String strSubstring = str.substring(i5);
            if (map.containsKey(strSubstring)) {
                return strSubstring;
            }
        }
        return str2;
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [T, java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v6, types: [T, java.util.HashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v14, types: [T, java.util.Map$Entry] */
    public static <T> T g(Object obj, ParameterizedType parameterizedType, C0896i c0896i) {
        Type rawType = parameterizedType.getRawType();
        if (rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List list = (List) obj;
                ?? r10 = (T) new ArrayList(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    r10.add(type instanceof Class ? (next == null || next.getClass() != l0.e.class) ? f(next, (Class) type, c0896i) : ((l0.e) next).T((Class) type, c0896i, 0) : h(next, type, c0896i));
                }
                return r10;
            }
        }
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == Collection.class || rawType == List.class || rawType == ArrayList.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                T t5 = (rawType == Set.class || rawType == HashSet.class) ? (T) new HashSet() : rawType == TreeSet.class ? (T) new TreeSet() : (T) new ArrayList();
                Iterator<T> it2 = ((Iterable) obj).iterator();
                while (it2.hasNext()) {
                    T next2 = it2.next();
                    ((Collection) t5).add(type2 instanceof Class ? (next2 == null || next2.getClass() != l0.e.class) ? f(next2, (Class) type2, c0896i) : ((l0.e) next2).T((Class) type2, c0896i, 0) : h(next2, type2, c0896i));
                }
                return t5;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r102 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r102.put(h(entry.getKey(), type3, c0896i), h(entry.getValue(), type4, c0896i));
                }
                return r102;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments.length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) h(obj, rawType, c0896i);
        }
        if (rawType == Map.Entry.class && (obj instanceof Map)) {
            Map map = (Map) obj;
            if (map.size() == 1) {
                ?? r9 = (T) ((Map.Entry) map.entrySet().iterator().next());
                Object value = r9.getValue();
                if (actualTypeArguments.length == 2 && (value instanceof Map)) {
                    r9.setValue(h(value, actualTypeArguments[1], c0896i));
                }
                return r9;
            }
        }
        if (rawType instanceof Class) {
            if (c0896i == null) {
                c0896i = C0896i.f19034z;
            }
            t tVarO = c0896i.o(rawType);
            if (tVarO != null) {
                return (T) tVarO.e(new C0888a(AbstractC0822a.F(obj), c0896i), parameterizedType, null);
            }
        }
        throw new l0.d("can not cast to : " + parameterizedType);
    }

    public static String g0(String str) {
        return Character.toLowerCase(str.charAt(3)) + str.substring(4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T h(Object obj, Type type, C0896i c0896i) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) f(obj, (Class) type, c0896i);
        }
        if (type instanceof ParameterizedType) {
            return (T) g(obj, (ParameterizedType) type, c0896i);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new l0.d("can not cast to : " + type);
    }

    public static Class<?> h0(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return h0(((ParameterizedType) type).getRawType());
        }
        if (!(type instanceof WildcardType)) {
            throw new l0.d("TODO");
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        if (upperBounds.length == 1) {
            return h0(upperBounds[0]);
        }
        throw new l0.d("TODO");
    }

    public static BigDecimal i(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Float) {
            Float f5 = (Float) obj;
            if (Float.isNaN(f5.floatValue()) || Float.isInfinite(f5.floatValue())) {
                return null;
            }
        } else if (obj instanceof Double) {
            Double d6 = (Double) obj;
            if (Double.isNaN(d6.doubleValue()) || Double.isInfinite(d6.doubleValue())) {
                return null;
            }
        } else {
            if (obj instanceof BigDecimal) {
                return (BigDecimal) obj;
            }
            if (obj instanceof BigInteger) {
                return new BigDecimal((BigInteger) obj);
            }
            if ((obj instanceof Map) && ((Map) obj).size() == 0) {
                return null;
            }
        }
        String string = obj.toString();
        if (string.length() == 0 || string.equalsIgnoreCase("null")) {
            return null;
        }
        if (string.length() <= 65535) {
            return new BigDecimal(string);
        }
        throw new l0.d("decimal overflow");
    }

    public static InterfaceC0854b i0(Class<?> cls, Method method) throws SecurityException {
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> cls2 : interfaces) {
                for (Method method2 : cls2.getMethods()) {
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= parameterTypes.length) {
                                InterfaceC0854b interfaceC0854b = (InterfaceC0854b) O(method2, InterfaceC0854b.class);
                                if (interfaceC0854b != null) {
                                    return interfaceC0854b;
                                }
                            } else {
                                if (!parameterTypes2[i5].equals(parameterTypes[i5])) {
                                    break;
                                }
                                i5++;
                            }
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= parameterTypes3.length) {
                            InterfaceC0854b interfaceC0854b2 = (InterfaceC0854b) O(method3, InterfaceC0854b.class);
                            if (interfaceC0854b2 != null) {
                                return interfaceC0854b2;
                            }
                        } else {
                            if (!parameterTypes4[i6].equals(parameterTypes3[i6])) {
                                break;
                            }
                            i6++;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static BigInteger j(Object obj) {
        BigDecimal bigDecimal;
        int iScale;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Float) {
            Float f5 = (Float) obj;
            if (Float.isNaN(f5.floatValue()) || Float.isInfinite(f5.floatValue())) {
                return null;
            }
            return BigInteger.valueOf(f5.longValue());
        }
        if (obj instanceof Double) {
            Double d6 = (Double) obj;
            if (Double.isNaN(d6.doubleValue()) || Double.isInfinite(d6.doubleValue())) {
                return null;
            }
            return BigInteger.valueOf(d6.longValue());
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof BigDecimal) && (iScale = (bigDecimal = (BigDecimal) obj).scale()) > -1000 && iScale < 1000) {
            return bigDecimal.toBigInteger();
        }
        String string = obj.toString();
        if (string.length() == 0 || string.equalsIgnoreCase("null")) {
            return null;
        }
        if (string.length() <= 65535) {
            return new BigInteger(string);
        }
        throw new l0.d("decimal overflow");
    }

    private static Type j0(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length > 0 ? upperBounds[0] : Object.class;
    }

    public static Boolean k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof BigDecimal) {
            return Boolean.valueOf(k0((BigDecimal) obj) == 1);
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
            if ("Y".equalsIgnoreCase(str) || ExifInterface.GPS_DIRECTION_TRUE.equals(str)) {
                return Boolean.TRUE;
            }
            if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new l0.d("can not cast to boolean, value : " + obj);
    }

    public static int k0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.intValueExact() : bigDecimal.intValue();
    }

    public static Byte l(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Byte.valueOf(e((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        if (obj instanceof Boolean) {
            return Byte.valueOf(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
        }
        throw new l0.d("can not cast to byte, value : " + obj);
    }

    public static boolean l0(Method method) {
        if (method == null) {
            return false;
        }
        if (f22841o == null && !f22842p) {
            try {
                f22841o = Class.forName("javax.persistence.ManyToMany");
            } catch (Throwable unused) {
                f22842p = true;
            }
        }
        if (f22841o != null) {
            return method.isAnnotationPresent(f22839m) || method.isAnnotationPresent(f22841o);
        }
        return false;
    }

    public static byte[] m(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return u0.g.b((String) obj);
        }
        throw new l0.d("can not cast to byte[], value : " + obj);
    }

    public static boolean m0(Method method) {
        if (method == null) {
            return false;
        }
        if (f22839m == null && !f22840n) {
            try {
                f22839m = Class.forName("javax.persistence.OneToMany");
            } catch (Throwable unused) {
                f22840n = true;
            }
        }
        Class<? extends Annotation> cls = f22839m;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static Character n(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (!(obj instanceof String)) {
            throw new l0.d("can not cast to char, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new l0.d("can not cast to char, value : " + obj);
    }

    public static boolean n0(Class cls) {
        Boolean bool = (Boolean) j.c(f22817O, cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static java.util.Date o(Object obj) {
        return p(obj, null);
    }

    public static boolean o0(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        return (type instanceof Class) && (genericSuperclass = ((Class) type).getGenericSuperclass()) != Object.class && o0(genericSuperclass);
    }

    public static java.util.Date p(Object obj, String str) throws NumberFormatException {
        long j5;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.util.Date) {
            return (java.util.Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof BigDecimal) {
            return new java.util.Date(D0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            long jLongValue = ((Number) obj).longValue();
            if ("unixtime".equals(str)) {
                jLongValue *= 1000;
            }
            return new java.util.Date(jLongValue);
        }
        if (obj instanceof String) {
            String strSubstring = (String) obj;
            C0893f c0893f = new C0893f(strSubstring);
            try {
                if (c0893f.t1(false)) {
                    return c0893f.F0().getTime();
                }
                c0893f.close();
                if (strSubstring.startsWith("/Date(") && strSubstring.endsWith(")/")) {
                    strSubstring = strSubstring.substring(6, strSubstring.length() - 2);
                }
                if (strSubstring.indexOf(45) > 0 || strSubstring.indexOf(43) > 0 || str != null) {
                    if (str == null) {
                        int length = strSubstring.length();
                        str = (length == AbstractC0822a.f18020e.length() || (length == 22 && AbstractC0822a.f18020e.equals("yyyyMMddHHmmssSSSZ"))) ? AbstractC0822a.f18020e : length == 10 ? "yyyy-MM-dd" : length == 19 ? "yyyy-MM-dd HH:mm:ss" : (length == 29 && strSubstring.charAt(26) == ':' && strSubstring.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : (length == 23 && strSubstring.charAt(19) == ',') ? "yyyy-MM-dd HH:mm:ss,SSS" : "yyyy-MM-dd HH:mm:ss.SSS";
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, AbstractC0822a.f18017b);
                    simpleDateFormat.setTimeZone(AbstractC0822a.f18016a);
                    try {
                        return simpleDateFormat.parse(strSubstring);
                    } catch (ParseException unused) {
                        throw new l0.d("can not cast to Date, value : " + strSubstring);
                    }
                }
                if (strSubstring.length() == 0) {
                    return null;
                }
                j5 = Long.parseLong(strSubstring);
            } finally {
                c0893f.close();
            }
        } else {
            j5 = -1;
        }
        if (j5 != -1) {
            return new java.util.Date(j5);
        }
        Class<?> cls = obj.getClass();
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (f22832f == null && !f22831e) {
                try {
                    f22832f = cls.getMethod("toJdbc", null);
                } catch (NoSuchMethodException unused2) {
                } catch (Throwable th) {
                    f22831e = true;
                    throw th;
                }
                f22831e = true;
            }
            try {
                return (java.util.Date) f22832f.invoke(obj, null);
            } catch (Exception e6) {
                throw new l0.d("can not cast oracle.sql.TIMESTAMP to Date", e6);
            }
        }
        if (!"oracle.sql.DATE".equals(cls.getName())) {
            throw new l0.d("can not cast to Date, value : " + obj);
        }
        if (f22834h == null && !f22833g) {
            try {
                f22834h = cls.getMethod("toJdbc", null);
            } catch (NoSuchMethodException unused3) {
            } catch (Throwable th2) {
                f22833g = true;
                throw th2;
            }
            f22833g = true;
        }
        try {
            return (java.util.Date) f22834h.invoke(obj, null);
        } catch (Exception e7) {
            throw new l0.d("can not cast oracle.sql.DATE to Date", e7);
        }
    }

    public static boolean p0(Object obj) {
        if (obj == null) {
            return false;
        }
        if (f22843q == null && !f22844r) {
            try {
                f22843q = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", Object.class);
            } catch (Throwable unused) {
                f22844r = true;
            }
        }
        Method method = f22843q;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(null, obj)).booleanValue();
            } catch (Throwable unused2) {
            }
        }
        return true;
    }

    public static Double q(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Double.valueOf(((Boolean) obj).booleanValue() ? 1.0d : 0.0d);
            }
            throw new l0.d("can not cast to double, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != -1) {
            string = string.replaceAll(",", BuildConfig.FLAVOR);
        }
        return Double.valueOf(Double.parseDouble(string));
    }

    private static boolean q0(Class<?> cls, String str) {
        InterfaceC0856d interfaceC0856d = (InterfaceC0856d) M(cls, InterfaceC0856d.class);
        if (interfaceC0856d != null) {
            String[] strArrIncludes = interfaceC0856d.includes();
            if (strArrIncludes.length > 0) {
                for (String str2 : strArrIncludes) {
                    if (str.equals(str2)) {
                        return false;
                    }
                }
                return true;
            }
            for (String str3 : interfaceC0856d.ignores()) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        if (cls.getSuperclass() == Object.class || cls.getSuperclass() == null) {
            return false;
        }
        return q0(cls.getSuperclass(), str);
    }

    public static <T> T r(Object obj, Class<T> cls, C0896i c0896i) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                if (c0896i == null) {
                    c0896i = C0896i.s();
                }
                t tVarO = c0896i.o(cls);
                return tVarO instanceof p0.h ? (T) ((p0.h) tVarO).b(I(str)) : (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof BigDecimal) {
                int iK0 = k0((BigDecimal) obj);
                T[] enumConstants = cls.getEnumConstants();
                if (iK0 < enumConstants.length) {
                    return enumConstants[iK0];
                }
            }
            if (obj instanceof Number) {
                int iIntValue = ((Number) obj).intValue();
                T[] enumConstants2 = cls.getEnumConstants();
                if (iIntValue < enumConstants2.length) {
                    return enumConstants2[iIntValue];
                }
            }
            throw new l0.d("can not cast to : " + cls.getName());
        } catch (Exception e6) {
            throw new l0.d("can not cast to : " + cls.getName(), e6);
        }
    }

    public static boolean r0(Method method) {
        if (method == null) {
            return false;
        }
        if (f22808F == null && !f22809G) {
            try {
                f22808F = Class.forName("com.fasterxml.jackson.annotation.JsonCreator");
            } catch (Throwable unused) {
                f22809G = true;
            }
        }
        Class<? extends Annotation> cls = f22808F;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static Float s(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Float.valueOf(((Boolean) obj).booleanValue() ? 1.0f : 0.0f);
            }
            throw new l0.d("can not cast to float, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != -1) {
            string = string.replaceAll(",", BuildConfig.FLAVOR);
        }
        return Float.valueOf(Float.parseFloat(string));
    }

    public static boolean s0(Class cls) {
        if (f22845s == null && !f22846t) {
            try {
                f22845s = V3.k.class;
            } catch (Throwable unused) {
                f22846t = true;
            }
        }
        return f22845s != null && cls.isAnnotationPresent(f22845s);
    }

    public static Integer t(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof BigDecimal) {
            return Integer.valueOf(k0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != -1) {
                strReplaceAll = strReplaceAll.replaceAll(",", BuildConfig.FLAVOR);
            }
            Matcher matcher = f22827a.matcher(strReplaceAll);
            if (matcher.find()) {
                strReplaceAll = matcher.replaceAll(BuildConfig.FLAVOR);
            }
            return Integer.valueOf(Integer.parseInt(strReplaceAll));
        }
        if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return t(it.next());
            }
        }
        throw new l0.d("can not cast to int, value : " + obj);
    }

    private static boolean t0(Class cls, String str) {
        if (f22803A == null && !f22804B) {
            try {
                HashMap map = new HashMap();
                c.a aVar = kotlin.ranges.c.f17955e;
                map.put(kotlin.ranges.c.class, new String[]{"getEndInclusive", "isEmpty"});
                h.a aVar2 = kotlin.ranges.h.f17969e;
                map.put(kotlin.ranges.h.class, new String[]{"getEndInclusive", "isEmpty"});
                k.a aVar3 = kotlin.ranges.k.f17979e;
                map.put(kotlin.ranges.k.class, new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.e"), new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.d"), new String[]{"getEndInclusive", "isEmpty"});
                f22803A = map;
            } catch (Throwable unused) {
                f22804B = true;
            }
        }
        if (f22803A == null) {
            return false;
        }
        String[] strArr = f22803A.get(cls);
        return strArr != null && Arrays.binarySearch(strArr, str) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T u(Map<String, Object> map, Class<T> cls, C0896i c0896i) throws ClassNotFoundException {
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                return (T) new StackTraceElement(str, str2, str3, number == null ? 0 : number instanceof BigDecimal ? ((BigDecimal) number).intValueExact() : number.intValue());
            }
            Object obj = map.get(AbstractC0822a.f18018c);
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (c0896i == null) {
                    c0896i = C0896i.f19034z;
                }
                Class<?> clsH = c0896i.h(str4, null);
                if (clsH == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!clsH.equals(cls)) {
                    return (T) u(map, clsH, c0896i);
                }
            }
            if (cls.isInterface()) {
                l0.e eVar = map instanceof l0.e ? (l0.e) map : new l0.e(map);
                if (c0896i == null) {
                    c0896i = C0896i.s();
                }
                return c0896i.l(cls) != null ? (T) AbstractC0822a.x(AbstractC0822a.F(eVar), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, eVar);
            }
            if (cls == Locale.class) {
                Object obj2 = map.get("language");
                Object obj3 = map.get("country");
                if (obj2 instanceof String) {
                    String str5 = (String) obj2;
                    if (obj3 instanceof String) {
                        return (T) new Locale(str5, (String) obj3);
                    }
                    if (obj3 == null) {
                        return (T) new Locale(str5);
                    }
                }
            }
            if (cls == String.class && (map instanceof l0.e)) {
                return (T) map.toString();
            }
            if (cls == AbstractC0822a.class && (map instanceof l0.e)) {
                return map;
            }
            if (cls == LinkedHashMap.class && (map instanceof l0.e)) {
                T t5 = (T) ((l0.e) map).N();
                if (t5 instanceof LinkedHashMap) {
                    return t5;
                }
            }
            if (cls.isInstance(map)) {
                return map;
            }
            if (cls == l0.e.class) {
                return (T) new l0.e(map);
            }
            if (c0896i == null) {
                c0896i = C0896i.s();
            }
            t tVarO = c0896i.o(cls);
            p0.o oVar = tVarO instanceof p0.o ? (p0.o) tVarO : null;
            if (oVar != null) {
                return (T) oVar.f(map, c0896i);
            }
            throw new l0.d("can not get javaBeanDeserializer. " + cls.getName());
        } catch (Exception e6) {
            throw new l0.d(e6.getMessage(), e6);
        }
    }

    public static boolean u0(String str) {
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt == '+' || cCharAt == '-') {
                if (i5 != 0) {
                    return false;
                }
            } else if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static Long v(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Long.valueOf(D0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != -1) {
                strReplaceAll = strReplaceAll.replaceAll(",", BuildConfig.FLAVOR);
            }
            try {
                return Long.valueOf(Long.parseLong(strReplaceAll));
            } catch (NumberFormatException unused) {
                C0893f c0893f = new C0893f(strReplaceAll);
                Calendar calendarF0 = c0893f.t1(false) ? c0893f.F0() : null;
                c0893f.close();
                if (calendarF0 != null) {
                    return Long.valueOf(calendarF0.getTimeInMillis());
                }
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return v(it.next());
            }
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        throw new l0.d("can not cast to long, value : " + obj);
    }

    public static boolean v0(Class<?> cls) {
        if (f22806D == null && !f22807E) {
            try {
                f22806D = Path.class;
            } catch (Throwable unused) {
                f22807E = true;
            }
        }
        Class<?> cls2 = f22806D;
        if (cls2 != null) {
            return cls2.isAssignableFrom(cls);
        }
        return false;
    }

    public static Short w(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Short.valueOf(M0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        if (obj instanceof Boolean) {
            return Short.valueOf(((Boolean) obj).booleanValue() ? (short) 1 : (short) 0);
        }
        throw new l0.d("can not cast to short, value : " + obj);
    }

    public static boolean w0(Class<?> cls) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (f22824V.contains(cls2.getName())) {
                return true;
            }
        }
        return false;
    }

    public static Object x(Object obj) {
        return j.c(f22818P, obj);
    }

    public static boolean x0(Method method) {
        if (method == null) {
            return false;
        }
        if (!f22837k) {
            try {
                f22838l = Class.forName("java.beans.Transient");
            } catch (Exception unused) {
            } catch (Throwable th) {
                f22837k = true;
                throw th;
            }
            f22837k = true;
        }
        Class<? extends Annotation> cls = f22838l;
        return (cls == null || O(method, cls) == null) ? false : true;
    }

    public static Object y(Object obj) {
        return j.c(f22819Q, obj);
    }

    public static boolean y0(Class cls) {
        Annotation annotationM;
        Object objInvoke;
        if (f22811I == null && !f22812J) {
            try {
                f22811I = Class.forName("javax.xml.bind.annotation.XmlAccessorType");
            } catch (Throwable unused) {
                f22812J = true;
            }
        }
        if (f22811I == null || (annotationM = M(cls, f22811I)) == null) {
            return false;
        }
        if (f22813K == null && !f22812J) {
            try {
                f22813K = f22811I.getMethod("value", null);
            } catch (Throwable unused2) {
                f22812J = true;
            }
        }
        if (f22813K == null) {
            return false;
        }
        if (f22812J) {
            objInvoke = null;
        } else {
            try {
                objInvoke = f22813K.invoke(annotationM, null);
            } catch (Throwable unused3) {
                f22812J = true;
            }
        }
        if (objInvoke == null) {
            return false;
        }
        if (f22810H == null && !f22812J) {
            try {
                f22810H = Class.forName("javax.xml.bind.annotation.XmlAccessType");
                f22814L = f22810H.getField("FIELD");
                f22815M = f22814L.get(null);
            } catch (Throwable unused4) {
                f22812J = true;
            }
        }
        return objInvoke == f22815M;
    }

    public static String z(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Class<?> z0(String str) {
        return A0(str, null);
    }
}
