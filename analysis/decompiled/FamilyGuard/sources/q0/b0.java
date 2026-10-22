package q0;

import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import l0.AbstractC0822a;
import m0.InterfaceC0854b;
import m0.InterfaceC0856d;
import org.libpag.BuildConfig;
import r0.InterfaceC0993a;
import u0.C1152b;
import u0.C1154d;

/* loaded from: classes.dex */
public class b0 {

    /* renamed from: j, reason: collision with root package name */
    public static final b0 f19756j = new b0();

    /* renamed from: k, reason: collision with root package name */
    private static boolean f19757k = false;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f19758l = false;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f19759m = false;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f19760n = false;

    /* renamed from: o, reason: collision with root package name */
    private static boolean f19761o = false;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f19762p = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f19763a;

    /* renamed from: b, reason: collision with root package name */
    private C0954a f19764b;

    /* renamed from: c, reason: collision with root package name */
    protected String f19765c;

    /* renamed from: d, reason: collision with root package name */
    public l0.m f19766d;

    /* renamed from: e, reason: collision with root package name */
    private final u0.h<Type, U> f19767e;

    /* renamed from: f, reason: collision with root package name */
    private final u0.h<Type, u0.h<Type, U>> f19768f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f19769g;

    /* renamed from: h, reason: collision with root package name */
    private long[] f19770h;

    /* renamed from: i, reason: collision with root package name */
    private List<InterfaceC0993a> f19771i;

    public b0() {
        this(8192);
    }

    private final C0947J a(a0 a0Var) {
        C0947J c0947jZ = this.f19764b.z(a0Var);
        int i5 = 0;
        while (true) {
            C0938A[] c0938aArr = c0947jZ.f19687k;
            if (i5 >= c0938aArr.length) {
                return c0947jZ;
            }
            Class<?> cls = c0938aArr[i5].f19651a.f22734e;
            if (cls.isEnum() && !(h(cls) instanceof C0977y)) {
                c0947jZ.f19788i = false;
            }
            i5++;
        }
    }

    private static Member f(Class cls) throws SecurityException {
        Method method = null;
        for (Method method2 : cls.getMethods()) {
            if (method2.getReturnType() != Void.class && ((InterfaceC0854b) method2.getAnnotation(InterfaceC0854b.class)) != null) {
                if (method != null) {
                    return null;
                }
                method = method2;
            }
        }
        for (Field field : cls.getFields()) {
            if (((InterfaceC0854b) field.getAnnotation(InterfaceC0854b.class)) != null) {
                if (method != null) {
                    return null;
                }
                method = field;
            }
        }
        return method;
    }

    public static b0 g() {
        return f19756j;
    }

    private void j() {
        k(Boolean.class, C0967n.f19866a);
        k(Character.class, r.f19873a);
        k(Byte.class, C0941D.f19671a);
        k(Short.class, C0941D.f19671a);
        k(Integer.class, C0941D.f19671a);
        k(Long.class, C0952O.f19713a);
        k(Float.class, C0939B.f19668b);
        k(Double.class, C0976x.f19877b);
        k(BigDecimal.class, C0965l.f19862c);
        k(BigInteger.class, C0966m.f19865c);
        k(String.class, g0.f19851a);
        k(byte[].class, V.f19721a);
        k(short[].class, V.f19721a);
        k(int[].class, V.f19721a);
        k(long[].class, V.f19721a);
        k(float[].class, V.f19721a);
        k(double[].class, V.f19721a);
        k(boolean[].class, V.f19721a);
        k(char[].class, V.f19721a);
        k(Object[].class, T.f19720a);
        Q q5 = Q.f19717b;
        k(Class.class, q5);
        k(SimpleDateFormat.class, q5);
        k(Currency.class, new Q());
        k(TimeZone.class, q5);
        k(InetAddress.class, q5);
        k(Inet4Address.class, q5);
        k(Inet6Address.class, q5);
        k(InetSocketAddress.class, q5);
        k(File.class, q5);
        C0958e c0958e = C0958e.f19789a;
        k(Appendable.class, c0958e);
        k(StringBuffer.class, c0958e);
        k(StringBuilder.class, c0958e);
        h0 h0Var = h0.f19852a;
        k(Charset.class, h0Var);
        k(Pattern.class, h0Var);
        k(Locale.class, h0Var);
        k(URI.class, h0Var);
        k(URL.class, h0Var);
        k(UUID.class, h0Var);
        C0960g c0960g = C0960g.f19850a;
        k(AtomicBoolean.class, c0960g);
        k(AtomicInteger.class, c0960g);
        k(AtomicLong.class, c0960g);
        Y y5 = Y.f19722a;
        k(AtomicReference.class, y5);
        k(AtomicIntegerArray.class, c0960g);
        k(AtomicLongArray.class, c0960g);
        k(WeakReference.class, y5);
        k(SoftReference.class, y5);
        k(LinkedList.class, C0972t.f19875a);
    }

    public final U b(Class<?> cls) throws NoSuchFieldException, SecurityException {
        String name = cls.getName();
        if (Arrays.binarySearch(this.f19770h, u0.o.I(name)) < 0) {
            a0 a0VarD = u0.o.d(cls, null, this.f19766d, this.f19769g);
            return (a0VarD.f19752e.length == 0 && Iterable.class.isAssignableFrom(cls)) ? Q.f19717b : c(a0VarD);
        }
        throw new l0.d("not support class : " + name);
    }

    public U c(a0 a0Var) {
        Method method;
        InterfaceC0856d interfaceC0856d = a0Var.f19751d;
        boolean z5 = false;
        boolean z6 = this.f19763a && !this.f19769g;
        if (interfaceC0856d != null) {
            Class<?> clsSerializer = interfaceC0856d.serializer();
            if (clsSerializer != Void.class) {
                try {
                    Object objNewInstance = clsSerializer.newInstance();
                    if (objNewInstance instanceof U) {
                        return (U) objNewInstance;
                    }
                } catch (Throwable unused) {
                }
            }
            if (!interfaceC0856d.asm()) {
                z6 = false;
            }
            if (z6) {
                for (f0 f0Var : interfaceC0856d.serialzeFeatures()) {
                    if (f0.WriteNonStringValueAsString == f0Var || f0.WriteEnumUsingToString == f0Var || f0.NotWriteDefaultValue == f0Var || f0.BrowserCompatible == f0Var) {
                        z6 = false;
                        break;
                    }
                }
            }
            if (z6 && interfaceC0856d.serialzeFilters().length != 0) {
                z6 = false;
            }
        }
        Class<?> cls = a0Var.f19748a;
        if (!Modifier.isPublic(cls.getModifiers())) {
            return new C0947J(a0Var);
        }
        if ((z6 && this.f19764b.f19736a.c(cls)) || cls == Serializable.class || cls == Object.class) {
            z6 = false;
        }
        if (z6 && !C1152b.a(cls.getSimpleName())) {
            z6 = false;
        }
        if (z6 && a0Var.f19748a.isInterface()) {
            z6 = false;
        }
        if (z6) {
            for (C1154d c1154d : a0Var.f19752e) {
                Field field = c1154d.f22732c;
                if ((field != null && !field.getType().equals(c1154d.f22734e)) || (((method = c1154d.f22731b) != null && !method.getReturnType().equals(c1154d.f22734e)) || (c1154d.f22734e.isEnum() && d(c1154d.f22734e) != C0977y.f19879b))) {
                    break;
                }
                InterfaceC0854b interfaceC0854bG = c1154d.g();
                if (interfaceC0854bG != null) {
                    String str = interfaceC0854bG.format();
                    if ((str.length() != 0 && (c1154d.f22734e != String.class || !"trim".equals(str))) || !C1152b.a(interfaceC0854bG.name()) || interfaceC0854bG.jsonDirect() || interfaceC0854bG.serializeUsing() != Void.class || interfaceC0854bG.unwrapped()) {
                        break;
                    }
                    for (f0 f0Var2 : interfaceC0854bG.serialzeFeatures()) {
                        if (f0.WriteNonStringValueAsString == f0Var2 || f0.WriteEnumUsingToString == f0Var2 || f0.NotWriteDefaultValue == f0Var2 || f0.BrowserCompatible == f0Var2 || f0.WriteClassName == f0Var2) {
                            z6 = false;
                            break;
                        }
                    }
                    if (u0.o.m0(method) || u0.o.l0(method) || (interfaceC0854bG.defaultValue() != null && !BuildConfig.FLAVOR.equals(interfaceC0854bG.defaultValue()))) {
                        break;
                    }
                }
            }
            z5 = z6;
        } else {
            z5 = z6;
        }
        if (z5) {
            try {
                C0947J c0947jA = a(a0Var);
                if (c0947jA != null) {
                    return c0947jA;
                }
            } catch (ClassCastException | ClassFormatError | ClassNotFoundException unused2) {
            } catch (OutOfMemoryError e6) {
                if (e6.getMessage().indexOf("Metaspace") != -1) {
                    throw e6;
                }
            } catch (Throwable th) {
                throw new l0.d("create asm serializer error, verson 1.2.83, class " + cls, th);
            }
        }
        return new C0947J(a0Var);
    }

    public final U d(Type type) {
        Type typeP = AbstractC0822a.p(type);
        if (typeP == null) {
            return this.f19767e.b(type);
        }
        u0.h<Type, U> hVarB = this.f19768f.b(type);
        if (hVarB == null) {
            return null;
        }
        return hVarB.b(typeP);
    }

    protected U e() {
        return C0977y.f19879b;
    }

    public U h(Class<?> cls) {
        return i(cls, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:273:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:329:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public q0.U i(java.lang.Class<?> r26, boolean r27) throws java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException {
        /*
            Method dump skipped, instructions count: 1208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.b0.i(java.lang.Class, boolean):q0.U");
    }

    public boolean k(Type type, U u5) {
        Type typeP = AbstractC0822a.p(type);
        if (typeP == null) {
            return this.f19767e.c(type, u5);
        }
        u0.h<Type, U> hVarB = this.f19768f.b(type);
        if (hVarB == null) {
            hVarB = new u0.h<>(4);
            this.f19768f.c(type, hVarB);
        }
        return hVarB.c(typeP, u5);
    }

    public void l(boolean z5) {
        if (C1152b.f22729b) {
            return;
        }
        this.f19763a = z5;
    }

    public b0(int i5) {
        this(i5, false);
    }

    public b0(int i5, boolean z5) {
        this.f19763a = !C1152b.f22729b;
        this.f19765c = AbstractC0822a.f18018c;
        this.f19770h = new long[]{4165360493669296979L, 4446674157046724083L};
        this.f19771i = new ArrayList();
        this.f19769g = z5;
        this.f19767e = new u0.h<>(i5);
        this.f19768f = new u0.h<>(16);
        try {
            if (this.f19763a) {
                this.f19764b = new C0954a();
            }
        } catch (Throwable unused) {
            this.f19763a = false;
        }
        j();
    }
}
