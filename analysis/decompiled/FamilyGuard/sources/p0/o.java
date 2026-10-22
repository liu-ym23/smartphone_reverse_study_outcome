package p0;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import m0.InterfaceC0856d;
import o0.AbstractC0891d;
import o0.C0888a;
import o0.C0895h;
import o0.C0896i;
import o0.EnumC0889b;
import o0.InterfaceC0890c;
import org.libpag.BuildConfig;
import u0.C1154d;

/* loaded from: classes.dex */
public class o implements t {

    /* renamed from: a, reason: collision with root package name */
    private final l[] f19306a;

    /* renamed from: b, reason: collision with root package name */
    protected final l[] f19307b;

    /* renamed from: c, reason: collision with root package name */
    protected final Class<?> f19308c;

    /* renamed from: d, reason: collision with root package name */
    public final u0.i f19309d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentMap<String, Object> f19310e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, l> f19311f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, l> f19312g;

    /* renamed from: h, reason: collision with root package name */
    private transient long[] f19313h;

    /* renamed from: i, reason: collision with root package name */
    private transient short[] f19314i;

    /* renamed from: j, reason: collision with root package name */
    private final C0896i.c f19315j;

    public o(C0896i c0896i, Class<?> cls, Type type) {
        this(c0896i, u0.i.c(cls, type, c0896i.f19040f, c0896i.f19047m, c0896i.f19049o, c0896i.u()));
    }

    private Object c(C0896i c0896i, Object obj) {
        return this.f19309d.f22780e.invoke(null, obj);
    }

    protected static o m(C0896i c0896i, u0.i iVar, String str) {
        InterfaceC0856d interfaceC0856d = iVar.f22786k;
        if (interfaceC0856d == null) {
            return null;
        }
        for (Class<?> cls : interfaceC0856d.seeAlso()) {
            t tVarO = c0896i.o(cls);
            if (tVarO instanceof o) {
                o oVar = (o) tVarO;
                u0.i iVar2 = oVar.f19309d;
                if (iVar2.f22787l.equals(str)) {
                    return oVar;
                }
                o oVarM = m(c0896i, iVar2, str);
                if (oVarM != null) {
                    return oVarM;
                }
            }
        }
        return null;
    }

    static boolean n(int i5, int[] iArr) {
        int i6;
        if (iArr != null && (i6 = i5 / 32) < iArr.length) {
            if (((1 << (i5 % 32)) & iArr[i6]) != 0) {
                return true;
            }
        }
        return false;
    }

    protected void b(InterfaceC0890c interfaceC0890c, int i5) {
        if (interfaceC0890c.U() != i5) {
            throw new l0.d("syntax error");
        }
    }

    @Override // p0.t
    public int d() {
        return 12;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        return (T) h(c0888a, type, obj, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.util.Map<java.lang.String, java.lang.Object> r22, o0.C0896i r23) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 783
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.o.f(java.util.Map, o0.i):java.lang.Object");
    }

    public Object g(C0888a c0888a, Type type) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance;
        if ((type instanceof Class) && this.f19308c.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new l0.e());
        }
        u0.i iVar = this.f19309d;
        Constructor<?> constructor = iVar.f22778c;
        Object obj = null;
        if (constructor == null && iVar.f22780e == null) {
            return null;
        }
        Method method = iVar.f22780e;
        if (method != null && iVar.f22782g > 0) {
            return null;
        }
        try {
            if (iVar.f22782g == 0) {
                objNewInstance = constructor != null ? constructor.newInstance(null) : method.invoke(null, null);
            } else {
                C0895h c0895hV = c0888a.v();
                if (c0895hV == null || c0895hV.f19017a == null) {
                    throw new l0.d("can't create non-static inner class instance.");
                }
                if (!(type instanceof Class)) {
                    throw new l0.d("can't create non-static inner class instance.");
                }
                String name = ((Class) type).getName();
                String strSubstring = name.substring(0, name.lastIndexOf(36));
                Object obj2 = c0895hV.f19017a;
                String name2 = obj2.getClass().getName();
                if (!name2.equals(strSubstring)) {
                    C0895h c0895h = c0895hV.f19018b;
                    if (c0895h == null || c0895h.f19017a == null || !("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2))) {
                        obj = obj2;
                    } else if (c0895h.f19017a.getClass().getName().equals(strSubstring)) {
                        obj = c0895h.f19017a;
                    }
                    obj2 = obj;
                }
                if (obj2 == null || ((obj2 instanceof Collection) && ((Collection) obj2).isEmpty())) {
                    throw new l0.d("can't create non-static inner class instance.");
                }
                objNewInstance = constructor.newInstance(obj2);
            }
            if (c0888a != null && c0888a.f18948f.I(EnumC0889b.InitStringFieldAsEmpty)) {
                for (C1154d c1154d : this.f19309d.f22783h) {
                    if (c1154d.f22734e == String.class) {
                        try {
                            c1154d.q(objNewInstance, BuildConfig.FLAVOR);
                        } catch (Exception e6) {
                            throw new l0.d("create instance error, class " + this.f19308c.getName(), e6);
                        }
                    }
                }
            }
            return objNewInstance;
        } catch (l0.d e7) {
            throw e7;
        } catch (Exception e8) {
            throw new l0.d("create instance error, class " + this.f19308c.getName(), e8);
        }
    }

    public <T> T h(C0888a c0888a, Type type, Object obj, int i5) {
        return (T) i(c0888a, type, obj, null, i5, null);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    protected <T> T i(o0.C0888a r43, java.lang.reflect.Type r44, java.lang.Object r45, java.lang.Object r46, int r47, int[] r48) {
        /*
            Method dump skipped, instructions count: 2676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.o.i(o0.a, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    public <T> T j(C0888a c0888a, Type type, Object obj, Object obj2) {
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        if (interfaceC0890c.U() != 14) {
            throw new l0.d("error");
        }
        String strN0 = interfaceC0890c.n0(c0888a.f18944b);
        if (strN0 != null) {
            t tVarM = m(c0888a.u(), this.f19309d, strN0);
            if (tVarM == null) {
                tVarM = c0888a.u().o(c0888a.u().i(strN0, u0.o.P(type), interfaceC0890c.Y()));
            }
            if (tVarM instanceof o) {
                return (T) ((o) tVarM).j(c0888a, type, obj, obj2);
            }
        }
        T t5 = (T) g(c0888a, type);
        int length = this.f19307b.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            }
            char c6 = i5 == length + (-1) ? ']' : ',';
            l lVar = this.f19307b[i5];
            Class<?> cls = lVar.f19303a.f22734e;
            if (cls == Integer.TYPE) {
                lVar.f(t5, interfaceC0890c.E(c6));
            } else if (cls == String.class) {
                lVar.i(t5, interfaceC0890c.W(c6));
            } else if (cls == Long.TYPE) {
                lVar.g(t5, interfaceC0890c.l0(c6));
            } else if (cls.isEnum()) {
                char cD0 = interfaceC0890c.d0();
                lVar.h(t5, (cD0 == '\"' || cD0 == 'n') ? interfaceC0890c.X(cls, c0888a.L(), c6) : (cD0 < '0' || cD0 > '9') ? p(interfaceC0890c, c6) : ((h) ((C0919f) lVar).k(c0888a.u())).c(interfaceC0890c.E(c6)));
            } else if (cls == Boolean.TYPE) {
                lVar.j(t5, interfaceC0890c.o(c6));
            } else if (cls == Float.TYPE) {
                lVar.h(t5, Float.valueOf(interfaceC0890c.r(c6)));
            } else if (cls == Double.TYPE) {
                lVar.h(t5, Double.valueOf(interfaceC0890c.c0(c6)));
            } else if (cls == Date.class && interfaceC0890c.d0() == '1') {
                lVar.h(t5, new Date(interfaceC0890c.l0(c6)));
            } else if (cls == BigDecimal.class) {
                lVar.h(t5, interfaceC0890c.h0(c6));
            } else {
                interfaceC0890c.A(14);
                C1154d c1154d = lVar.f19303a;
                lVar.h(t5, c0888a.k0(c1154d.f22735f, c1154d.f22730a));
                if (interfaceC0890c.U() == 15) {
                    break;
                }
                b(interfaceC0890c, c6 == ']' ? 15 : 16);
            }
            i5++;
        }
        interfaceC0890c.A(16);
        return t5;
    }

    public l k(String str) {
        return l(str, null);
    }

    public l l(String str, int[] iArr) {
        l lVar;
        if (str == null) {
            return null;
        }
        Map<String, l> map = this.f19312g;
        if (map != null && (lVar = map.get(str)) != null) {
            return lVar;
        }
        int length = this.f19307b.length - 1;
        int i5 = 0;
        while (i5 <= length) {
            int i6 = (i5 + length) >>> 1;
            int iCompareTo = this.f19307b[i6].f19303a.f22730a.compareTo(str);
            if (iCompareTo < 0) {
                i5 = i6 + 1;
            } else {
                if (iCompareTo <= 0) {
                    if (n(i6, iArr)) {
                        return null;
                    }
                    return this.f19307b[i6];
                }
                length = i6 - 1;
            }
        }
        Map<String, l> map2 = this.f19311f;
        if (map2 != null) {
            return map2.get(str);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0115  */
    /* JADX WARN: Type inference failed for: r17v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o(o0.C0888a r21, java.lang.String r22, java.lang.Object r23, java.lang.reflect.Type r24, java.util.Map<java.lang.String, java.lang.Object> r25, int[] r26) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.o.o(o0.a, java.lang.String, java.lang.Object, java.lang.reflect.Type, java.util.Map, int[]):boolean");
    }

    protected Enum<?> p(InterfaceC0890c interfaceC0890c, char c6) {
        throw new l0.d("illegal enum. " + interfaceC0890c.c());
    }

    protected Enum q(AbstractC0891d abstractC0891d, char[] cArr, t tVar) {
        h hVar = tVar instanceof h ? (h) tVar : null;
        if (hVar == null) {
            abstractC0891d.f19008n = -1;
            return null;
        }
        long jP0 = abstractC0891d.P0(cArr);
        if (abstractC0891d.f19008n <= 0) {
            return null;
        }
        Enum enumB = hVar.b(jP0);
        if (enumB == null) {
            if (jP0 == -3750763034362895579L) {
                return null;
            }
            if (abstractC0891d.I(EnumC0889b.ErrorOnEnumNotMatch)) {
                throw new l0.d("not match enum value, " + hVar.f19299a);
            }
        }
        return enumB;
    }

    public l r(String str) {
        return s(str, null);
    }

    public l s(String str, int[] iArr) {
        boolean zStartsWith;
        if (str == null) {
            return null;
        }
        l lVarL = l(str, iArr);
        if (lVarL == null) {
            int i5 = 0;
            if (this.f19313h == null) {
                long[] jArr = new long[this.f19307b.length];
                int i6 = 0;
                while (true) {
                    l[] lVarArr = this.f19307b;
                    if (i6 >= lVarArr.length) {
                        break;
                    }
                    jArr[i6] = lVarArr[i6].f19303a.f22751v;
                    i6++;
                }
                Arrays.sort(jArr);
                this.f19313h = jArr;
            }
            int iBinarySearch = Arrays.binarySearch(this.f19313h, u0.o.K(str));
            if (iBinarySearch < 0) {
                iBinarySearch = Arrays.binarySearch(this.f19313h, u0.o.J(str));
            }
            if (iBinarySearch < 0) {
                zStartsWith = str.startsWith("is");
                if (zStartsWith) {
                    iBinarySearch = Arrays.binarySearch(this.f19313h, u0.o.J(str.substring(2)));
                }
            } else {
                zStartsWith = false;
            }
            if (iBinarySearch >= 0) {
                if (this.f19314i == null) {
                    short[] sArr = new short[this.f19313h.length];
                    Arrays.fill(sArr, (short) -1);
                    while (true) {
                        l[] lVarArr2 = this.f19307b;
                        if (i5 >= lVarArr2.length) {
                            break;
                        }
                        int iBinarySearch2 = Arrays.binarySearch(this.f19313h, lVarArr2[i5].f19303a.f22751v);
                        if (iBinarySearch2 >= 0) {
                            sArr[iBinarySearch2] = (short) i5;
                        }
                        i5++;
                    }
                    this.f19314i = sArr;
                }
                short s5 = this.f19314i[iBinarySearch];
                if (s5 != -1 && !n(s5, iArr)) {
                    lVarL = this.f19307b[s5];
                }
            }
            if (lVarL != null) {
                C1154d c1154d = lVarL.f19303a;
                if ((c1154d.f22739j & EnumC0889b.DisableFieldSmartMatch.f18991a) != 0) {
                    return null;
                }
                Class<?> cls = c1154d.f22734e;
                if (zStartsWith && cls != Boolean.TYPE && cls != Boolean.class) {
                    return null;
                }
            }
        }
        return lVarL;
    }

    public o(C0896i c0896i, u0.i iVar) throws IllegalAccessException, InstantiationException {
        C0896i.c cVarNewInstance;
        this.f19308c = iVar.f22776a;
        this.f19309d = iVar;
        InterfaceC0856d interfaceC0856d = iVar.f22786k;
        HashMap map = null;
        if (interfaceC0856d == null || interfaceC0856d.autoTypeCheckHandler() == C0896i.c.class) {
            cVarNewInstance = null;
        } else {
            try {
                cVarNewInstance = iVar.f22786k.autoTypeCheckHandler().newInstance();
            } catch (Exception unused) {
            }
        }
        this.f19315j = cVarNewInstance;
        C1154d[] c1154dArr = iVar.f22784i;
        this.f19307b = new l[c1154dArr.length];
        int length = c1154dArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            C1154d c1154d = iVar.f22784i[i5];
            l lVarJ = c0896i.j(c0896i, iVar, c1154d);
            this.f19307b[i5] = lVarJ;
            if (length > 128) {
                if (this.f19312g == null) {
                    this.f19312g = new HashMap();
                }
                this.f19312g.put(c1154d.f22730a, lVarJ);
            }
            for (String str : c1154d.f22750u) {
                if (map == null) {
                    map = new HashMap();
                }
                map.put(str, lVarJ);
            }
        }
        this.f19311f = map;
        C1154d[] c1154dArr2 = iVar.f22783h;
        this.f19306a = new l[c1154dArr2.length];
        int length2 = c1154dArr2.length;
        for (int i6 = 0; i6 < length2; i6++) {
            this.f19306a[i6] = k(iVar.f22783h[i6].f22730a);
        }
    }
}
