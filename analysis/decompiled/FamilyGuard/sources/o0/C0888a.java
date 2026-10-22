package o0;

import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.io.Closeable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import l0.AbstractC0822a;
import l0.C0823b;
import p0.k;
import p0.l;
import p0.m;
import p0.t;
import p0.y;
import q0.C0941D;
import q0.C0952O;
import q0.b0;
import q0.g0;
import u0.C1154d;
import u0.o;

/* renamed from: o0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0888a implements Closeable {

    /* renamed from: q, reason: collision with root package name */
    private static final Set<Class<?>> f18942q;

    /* renamed from: a, reason: collision with root package name */
    public final Object f18943a;

    /* renamed from: b, reason: collision with root package name */
    public final C0897j f18944b;

    /* renamed from: c, reason: collision with root package name */
    protected C0896i f18945c;

    /* renamed from: d, reason: collision with root package name */
    private String f18946d;

    /* renamed from: e, reason: collision with root package name */
    private DateFormat f18947e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC0890c f18948f;

    /* renamed from: g, reason: collision with root package name */
    protected C0895h f18949g;

    /* renamed from: h, reason: collision with root package name */
    private C0895h[] f18950h;

    /* renamed from: i, reason: collision with root package name */
    private int f18951i;

    /* renamed from: j, reason: collision with root package name */
    private List<C0227a> f18952j;

    /* renamed from: k, reason: collision with root package name */
    public int f18953k;

    /* renamed from: l, reason: collision with root package name */
    private List<k> f18954l;

    /* renamed from: m, reason: collision with root package name */
    private List<p0.j> f18955m;

    /* renamed from: n, reason: collision with root package name */
    protected m f18956n;

    /* renamed from: o, reason: collision with root package name */
    private int f18957o;

    /* renamed from: p, reason: collision with root package name */
    private String[] f18958p;

    /* renamed from: o0.a$a, reason: collision with other inner class name */
    public static class C0227a {

        /* renamed from: a, reason: collision with root package name */
        public final C0895h f18959a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18960b;

        /* renamed from: c, reason: collision with root package name */
        public l f18961c;

        /* renamed from: d, reason: collision with root package name */
        public C0895h f18962d;

        public C0227a(C0895h c0895h, String str) {
            this.f18959a = c0895h;
            this.f18960b = str;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f18942q = hashSet;
        hashSet.addAll(Arrays.asList(Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class));
    }

    public C0888a(String str) {
        this(str, C0896i.s(), AbstractC0822a.f18021f);
    }

    private void f(C0895h c0895h) {
        int i5 = this.f18951i;
        this.f18951i = i5 + 1;
        C0895h[] c0895hArr = this.f18950h;
        if (c0895hArr == null) {
            this.f18950h = new C0895h[8];
        } else if (i5 >= c0895hArr.length) {
            C0895h[] c0895hArr2 = new C0895h[(c0895hArr.length * 3) / 2];
            System.arraycopy(c0895hArr, 0, c0895hArr2, 0, c0895hArr.length);
            this.f18950h = c0895hArr2;
        }
        this.f18950h[i5] = c0895h;
    }

    public List<p0.j> A() {
        if (this.f18955m == null) {
            this.f18955m = new ArrayList(2);
        }
        return this.f18955m;
    }

    public void A0(String str) {
        this.f18946d = str;
        this.f18947e = null;
    }

    public void B0(m mVar) {
        this.f18956n = mVar;
    }

    public List<k> C() {
        if (this.f18954l == null) {
            this.f18954l = new ArrayList(2);
        }
        return this.f18954l;
    }

    public void C0(int i5) {
        this.f18953k = i5;
    }

    public m D() {
        return this.f18956n;
    }

    public C0227a E() {
        return this.f18952j.get(r1.size() - 1);
    }

    public InterfaceC0890c G() {
        return this.f18948f;
    }

    public int I() {
        return this.f18953k;
    }

    public C0897j L() {
        return this.f18944b;
    }

    public void N(Object obj) {
        Object objE;
        C0895h c0895h;
        C1154d c1154d;
        List<C0227a> list = this.f18952j;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            C0227a c0227a = this.f18952j.get(i5);
            String str = c0227a.f18960b;
            C0895h c0895h2 = c0227a.f18962d;
            Object obj2 = c0895h2 != null ? c0895h2.f19017a : null;
            if (str.startsWith("$")) {
                objE = getObject(str);
                if (objE == null) {
                    try {
                        l0.g gVar = new l0.g(str, b0.g(), this.f18945c, true);
                        if (gVar.o()) {
                            objE = gVar.e(obj);
                        }
                    } catch (l0.h unused) {
                    }
                }
            } else {
                objE = c0227a.f18959a.f19017a;
            }
            l lVar = c0227a.f18961c;
            if (lVar != null) {
                if (objE != null && objE.getClass() == l0.e.class && (c1154d = lVar.f19303a) != null && !Map.class.isAssignableFrom(c1154d.f22734e)) {
                    Object obj3 = this.f18950h[0].f19017a;
                    l0.g gVarB = l0.g.b(str);
                    if (gVarB.o()) {
                        objE = gVarB.e(obj3);
                    }
                }
                if (lVar.c() != null && !lVar.c().isInstance(obj2) && (c0895h = c0227a.f18962d.f19018b) != null) {
                    while (true) {
                        if (c0895h == null) {
                            break;
                        }
                        if (lVar.c().isInstance(c0895h.f19017a)) {
                            obj2 = c0895h.f19017a;
                            break;
                        }
                        c0895h = c0895h.f19018b;
                    }
                }
                lVar.h(obj2, objE);
            }
        }
    }

    public boolean O(EnumC0889b enumC0889b) {
        return this.f18948f.I(enumC0889b);
    }

    public Object S() {
        return T(null);
    }

    public Object T(Object obj) {
        InterfaceC0890c interfaceC0890c = this.f18948f;
        int iU = interfaceC0890c.U();
        if (iU == 2) {
            Number numberS = interfaceC0890c.S();
            interfaceC0890c.nextToken();
            return numberS;
        }
        if (iU == 3) {
            Number numberP0 = interfaceC0890c.p0(interfaceC0890c.I(EnumC0889b.UseBigDecimal));
            interfaceC0890c.nextToken();
            return numberP0;
        }
        if (iU == 4) {
            String strN = interfaceC0890c.N();
            interfaceC0890c.A(16);
            if (!interfaceC0890c.I(EnumC0889b.AllowISO8601DateFormat)) {
                return strN;
            }
            C0893f c0893f = new C0893f(strN);
            try {
                return c0893f.s1() ? c0893f.F0().getTime() : strN;
            } finally {
                c0893f.close();
            }
        }
        if (iU == 12) {
            return m0(O(EnumC0889b.UseNativeJavaObject) ? interfaceC0890c.I(EnumC0889b.OrderedField) ? new HashMap() : new LinkedHashMap() : new l0.e(interfaceC0890c.I(EnumC0889b.OrderedField)), obj);
        }
        if (iU == 14) {
            Collection arrayList = O(EnumC0889b.UseNativeJavaObject) ? new ArrayList() : new C0823b();
            c0(arrayList, obj);
            return interfaceC0890c.I(EnumC0889b.UseObjectArray) ? arrayList.toArray() : arrayList;
        }
        if (iU == 18) {
            if ("NaN".equals(interfaceC0890c.N())) {
                interfaceC0890c.nextToken();
                return null;
            }
            throw new l0.d("syntax error, " + interfaceC0890c.c());
        }
        if (iU == 26) {
            byte[] bArrG = interfaceC0890c.G();
            interfaceC0890c.nextToken();
            return bArrG;
        }
        switch (iU) {
            case 6:
                interfaceC0890c.nextToken();
                return Boolean.TRUE;
            case 7:
                interfaceC0890c.nextToken();
                return Boolean.FALSE;
            case 8:
                interfaceC0890c.nextToken();
                return null;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                interfaceC0890c.A(18);
                if (interfaceC0890c.U() != 18) {
                    throw new l0.d("syntax error");
                }
                interfaceC0890c.A(10);
                a(10);
                long jLongValue = interfaceC0890c.S().longValue();
                a(2);
                a(11);
                return new Date(jLongValue);
            default:
                switch (iU) {
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        if (interfaceC0890c.m()) {
                            return null;
                        }
                        throw new l0.d("unterminated json string, " + interfaceC0890c.c());
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        interfaceC0890c.nextToken();
                        HashSet hashSet = new HashSet();
                        c0(hashSet, obj);
                        return hashSet;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        interfaceC0890c.nextToken();
                        TreeSet treeSet = new TreeSet();
                        c0(treeSet, obj);
                        return treeSet;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        interfaceC0890c.nextToken();
                        return null;
                    default:
                        throw new l0.d("syntax error, " + interfaceC0890c.c());
                }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0239, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object U(p0.w r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.C0888a.U(p0.w, java.lang.Object):java.lang.Object");
    }

    public void V(Class<?> cls, Collection collection) {
        W(cls, collection);
    }

    public void W(Type type, Collection collection) {
        X(type, collection, null);
    }

    public void X(Type type, Collection collection, Object obj) {
        t tVarO;
        int iU = this.f18948f.U();
        if (iU == 21 || iU == 22) {
            this.f18948f.nextToken();
            iU = this.f18948f.U();
        }
        if (iU != 14) {
            throw new l0.d("field " + obj + " expect '[', but " + C0894g.a(iU) + ", " + this.f18948f.c());
        }
        Class cls = Integer.TYPE;
        if (cls == type) {
            tVarO = C0941D.f19671a;
            this.f18948f.A(2);
        } else if (String.class == type) {
            tVarO = g0.f19851a;
            this.f18948f.A(4);
        } else {
            tVarO = this.f18945c.o(type);
            this.f18948f.A(tVarO.d());
        }
        C0895h c0895h = this.f18949g;
        u0(collection, obj);
        int i5 = 0;
        while (true) {
            try {
                if (this.f18948f.I(EnumC0889b.AllowArbitraryCommas)) {
                    while (this.f18948f.U() == 16) {
                        this.f18948f.nextToken();
                    }
                }
                if (this.f18948f.U() == 15) {
                    z0(c0895h);
                    this.f18948f.A(16);
                    return;
                }
                Object objE = null;
                if (cls == type) {
                    collection.add(C0941D.f19671a.e(this, null, null));
                } else if (String.class == type) {
                    if (this.f18948f.U() == 4) {
                        objE = this.f18948f.N();
                        this.f18948f.A(16);
                    } else {
                        Object objS = S();
                        if (objS != null) {
                            objE = objS.toString();
                        }
                    }
                    collection.add(objE);
                } else {
                    if (this.f18948f.U() == 8) {
                        this.f18948f.nextToken();
                    } else {
                        objE = tVarO.e(this, type, Integer.valueOf(i5));
                    }
                    collection.add(objE);
                    o(collection);
                }
                if (this.f18948f.U() == 16) {
                    this.f18948f.A(tVarO.d());
                }
                i5++;
            } catch (Throwable th) {
                z0(c0895h);
                throw th;
            }
        }
    }

    public final void Y(Collection collection) {
        c0(collection, null);
    }

    public final void a(int i5) {
        InterfaceC0890c interfaceC0890c = this.f18948f;
        if (interfaceC0890c.U() == i5) {
            interfaceC0890c.nextToken();
            return;
        }
        throw new l0.d("syntax error, expect " + C0894g.a(i5) + ", actual " + C0894g.a(interfaceC0890c.U()));
    }

    public void c(String str) {
        InterfaceC0890c interfaceC0890c = this.f18948f;
        interfaceC0890c.m0();
        if (interfaceC0890c.U() != 4) {
            throw new l0.d("type not match error");
        }
        if (!str.equals(interfaceC0890c.N())) {
            throw new l0.d("type not match error");
        }
        interfaceC0890c.nextToken();
        if (interfaceC0890c.U() == 16) {
            interfaceC0890c.nextToken();
        }
    }

    public final void c0(Collection collection, Object obj) {
        Object objP0;
        InterfaceC0890c interfaceC0890c = this.f18948f;
        if (interfaceC0890c.U() == 21 || interfaceC0890c.U() == 22) {
            interfaceC0890c.nextToken();
        }
        if (interfaceC0890c.U() != 14) {
            throw new l0.d("syntax error, expect [, actual " + C0894g.a(interfaceC0890c.U()) + ", pos " + interfaceC0890c.a() + ", fieldName " + obj);
        }
        interfaceC0890c.A(4);
        C0895h c0895h = this.f18949g;
        if (c0895h != null && c0895h.f19020d > 512) {
            throw new l0.d("array level > 512");
        }
        u0(collection, obj);
        int i5 = 0;
        while (true) {
            try {
                try {
                    if (interfaceC0890c.I(EnumC0889b.AllowArbitraryCommas)) {
                        while (interfaceC0890c.U() == 16) {
                            interfaceC0890c.nextToken();
                        }
                    }
                    int iU = interfaceC0890c.U();
                    if (iU == 2) {
                        Number numberS = interfaceC0890c.S();
                        interfaceC0890c.A(16);
                        objP0 = numberS;
                    } else if (iU == 3) {
                        objP0 = interfaceC0890c.I(EnumC0889b.UseBigDecimal) ? interfaceC0890c.p0(true) : interfaceC0890c.p0(false);
                        interfaceC0890c.A(16);
                    } else if (iU == 4) {
                        String strN = interfaceC0890c.N();
                        interfaceC0890c.A(16);
                        objP0 = strN;
                        if (interfaceC0890c.I(EnumC0889b.AllowISO8601DateFormat)) {
                            C0893f c0893f = new C0893f(strN);
                            Object time = strN;
                            if (c0893f.s1()) {
                                time = c0893f.F0().getTime();
                            }
                            c0893f.close();
                            objP0 = time;
                        }
                    } else if (iU == 6) {
                        Boolean bool = Boolean.TRUE;
                        interfaceC0890c.A(16);
                        objP0 = bool;
                    } else if (iU != 7) {
                        objP0 = null;
                        objP0 = null;
                        if (iU == 8) {
                            interfaceC0890c.A(4);
                        } else if (iU == 12) {
                            objP0 = m0(new l0.e(interfaceC0890c.I(EnumC0889b.OrderedField)), Integer.valueOf(i5));
                        } else {
                            if (iU == 20) {
                                throw new l0.d("unclosed jsonArray");
                            }
                            if (iU == 23) {
                                interfaceC0890c.A(4);
                            } else if (iU == 14) {
                                C0823b c0823b = new C0823b();
                                c0(c0823b, Integer.valueOf(i5));
                                objP0 = c0823b;
                                if (interfaceC0890c.I(EnumC0889b.UseObjectArray)) {
                                    objP0 = c0823b.toArray();
                                }
                            } else {
                                if (iU == 15) {
                                    interfaceC0890c.A(16);
                                    z0(c0895h);
                                    return;
                                }
                                objP0 = S();
                            }
                        }
                    } else {
                        Boolean bool2 = Boolean.FALSE;
                        interfaceC0890c.A(16);
                        objP0 = bool2;
                    }
                    collection.add(objP0);
                    o(collection);
                    if (interfaceC0890c.U() == 16) {
                        interfaceC0890c.A(4);
                    }
                    i5++;
                } catch (ClassCastException e6) {
                    throw new l0.d("unkown error", e6);
                }
            } catch (Throwable th) {
                z0(c0895h);
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InterfaceC0890c interfaceC0890c = this.f18948f;
        try {
            if (interfaceC0890c.I(EnumC0889b.AutoCloseSource) && interfaceC0890c.U() != 20) {
                throw new l0.d("not close json text, token : " + C0894g.a(interfaceC0890c.U()));
            }
        } finally {
            interfaceC0890c.close();
        }
    }

    public void d0(Object obj, String str) {
        this.f18948f.m0();
        List<k> list = this.f18954l;
        Type typeD = null;
        if (list != null) {
            Iterator<k> it = list.iterator();
            while (it.hasNext()) {
                typeD = it.next().d(obj, str);
            }
        }
        Object objS = typeD == null ? S() : j0(typeD);
        if (obj instanceof p0.i) {
            ((p0.i) obj).a(str, objS);
            return;
        }
        List<p0.j> list2 = this.f18955m;
        if (list2 != null) {
            Iterator<p0.j> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().a(obj, str, objS);
            }
        }
        if (this.f18953k == 1) {
            this.f18953k = 0;
        }
    }

    public Object getObject(String str) {
        for (int i5 = 0; i5 < this.f18951i; i5++) {
            if (str.equals(this.f18950h[i5].toString())) {
                return this.f18950h[i5].f19017a;
            }
        }
        return null;
    }

    public <T> T h0(Class<T> cls) {
        return (T) k0(cls, null);
    }

    public <T> T j0(Type type) {
        return (T) k0(type, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T k0(Type type, Object obj) {
        int iU = this.f18948f.U();
        if (iU == 8) {
            this.f18948f.nextToken();
            return (T) o.I0(type);
        }
        if (iU == 4) {
            if (type == byte[].class) {
                T t5 = (T) this.f18948f.G();
                this.f18948f.nextToken();
                return t5;
            }
            if (type == char[].class) {
                String strN = this.f18948f.N();
                this.f18948f.nextToken();
                return (T) strN.toCharArray();
            }
        }
        t tVarO = this.f18945c.o(type);
        try {
            if (tVarO.getClass() != p0.o.class) {
                return (T) tVarO.e(this, type, obj);
            }
            if (this.f18948f.U() != 12 && this.f18948f.U() != 14) {
                throw new l0.d("syntax error,expect start with { or [,but actually start with " + this.f18948f.o0());
            }
            return (T) ((p0.o) tVarO).h(this, type, obj, 0);
        } catch (l0.d e6) {
            throw e6;
        } catch (Throwable th) {
            throw new l0.d(th.getMessage(), th);
        }
    }

    public Object l0(Map map) {
        return m0(map, null);
    }

    public void m(C0227a c0227a) {
        if (this.f18952j == null) {
            this.f18952j = new ArrayList(2);
        }
        this.f18952j.add(c0227a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x02a6, code lost:
    
        r5.A(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02b1, code lost:
    
        if (r5.U() != 13) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02b3, code lost:
    
        r5.A(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02be, code lost:
    
        if ((r17.f18945c.o(r8) instanceof p0.o) == false) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02c0, code lost:
    
        r13 = u0.o.f(r18, r8, r17.f18945c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02c8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02ca, code lost:
    
        if (r13 != null) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02ce, code lost:
    
        if (r8 != java.lang.Cloneable.class) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02d0, code lost:
    
        r13 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02dc, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r7) == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02de, code lost:
    
        r13 = java.util.Collections.EMPTY_MAP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02e7, code lost:
    
        if ("java.util.Collections$UnmodifiableMap".equals(r7) == false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02e9, code lost:
    
        r13 = java.util.Collections.unmodifiableMap(new java.util.HashMap());
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x02f3, code lost:
    
        r13 = r8.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02f7, code lost:
    
        z0(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02fa, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0302, code lost:
    
        throw new l0.d("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0303, code lost:
    
        C0(2);
        r3 = r17.f18949g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0309, code lost:
    
        if (r3 == null) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x030b, code lost:
    
        if (r19 == null) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x030f, code lost:
    
        if ((r19 instanceof java.lang.Integer) != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0315, code lost:
    
        if ((r3.f19019c instanceof java.lang.Integer) != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0317, code lost:
    
        p0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x031e, code lost:
    
        if (r18.size() <= 0) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0320, code lost:
    
        r0 = u0.o.f(r18, r8, r17.f18945c);
        C0(0);
        o0(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x032d, code lost:
    
        z0(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0330, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0331, code lost:
    
        r0 = r17.f18945c.o(r8);
        r3 = r0.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0341, code lost:
    
        if (p0.o.class.isAssignableFrom(r3) == false) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0345, code lost:
    
        if (r3 == p0.o.class) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0349, code lost:
    
        if (r3 == p0.C0912B.class) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x034b, code lost:
    
        C0(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0352, code lost:
    
        if ((r0 instanceof p0.r) == false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0354, code lost:
    
        C0(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0358, code lost:
    
        r0 = r0.e(r17, r8, r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x035c, code lost:
    
        z0(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x035f, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x021e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:31:0x0085, B:34:0x0098, B:38:0x00ad, B:117:0x021e, B:118:0x0224, B:120:0x022f, B:122:0x0237, B:126:0x024d, B:128:0x025b, B:148:0x029e, B:149:0x02a6, B:151:0x02b3, B:152:0x02b6, B:154:0x02c0, B:160:0x02d0, B:161:0x02d6, B:163:0x02de, B:164:0x02e1, B:166:0x02e9, B:167:0x02f3, B:170:0x02fb, B:171:0x0302, B:172:0x0303, B:175:0x030d, B:177:0x0311, B:179:0x0317, B:180:0x031a, B:182:0x0320, B:185:0x0331, B:191:0x034b, B:195:0x0358, B:192:0x0350, B:194:0x0354, B:130:0x0261, B:133:0x026c, B:137:0x0278, B:139:0x027e, B:144:0x028b, B:145:0x028e, B:203:0x0369, B:207:0x0375, B:209:0x037d, B:211:0x0387, B:213:0x0398, B:215:0x03a2, B:217:0x03aa, B:219:0x03ae, B:221:0x03b4, B:224:0x03b9, B:226:0x03bd, B:249:0x0422, B:251:0x042a, B:254:0x0433, B:255:0x044d, B:228:0x03c3, B:230:0x03cb, B:233:0x03d1, B:234:0x03de, B:237:0x03e7, B:240:0x03ed, B:243:0x03f2, B:244:0x03ff, B:246:0x0409, B:248:0x0417, B:256:0x044e, B:257:0x046c, B:259:0x046f, B:261:0x0473, B:263:0x0477, B:266:0x047d, B:270:0x0486, B:276:0x0496, B:278:0x04a5, B:280:0x04b0, B:281:0x04b8, B:282:0x04bb, B:294:0x04e7, B:296:0x04f2, B:301:0x04ff, B:304:0x050f, B:305:0x052f, B:289:0x04cb, B:291:0x04d5, B:293:0x04e4, B:292:0x04da, B:308:0x0534, B:310:0x053e, B:312:0x0546, B:313:0x0549, B:315:0x0554, B:316:0x0558, B:318:0x0563, B:321:0x056a, B:324:0x0574, B:325:0x0579, B:328:0x057e, B:330:0x0583, B:334:0x058f, B:336:0x0597, B:338:0x05aa, B:342:0x05c5, B:344:0x05cd, B:347:0x05d3, B:349:0x05d9, B:351:0x05e1, B:354:0x05f1, B:357:0x05f9, B:359:0x05fd, B:360:0x0604, B:362:0x0609, B:363:0x060c, B:365:0x0614, B:368:0x061e, B:371:0x0628, B:372:0x062d, B:373:0x0632, B:374:0x064c, B:339:0x05b3, B:340:0x05b8, B:375:0x064d, B:377:0x065f, B:380:0x0666, B:383:0x0674, B:384:0x0694, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f7, B:54:0x00fd, B:61:0x010c, B:63:0x0114, B:66:0x0126, B:67:0x013e, B:68:0x013f, B:69:0x0144, B:80:0x0159, B:81:0x015f, B:83:0x0166, B:85:0x0171, B:92:0x0183, B:95:0x018d, B:96:0x01a5, B:90:0x017e, B:84:0x016b, B:97:0x01a6, B:98:0x01be, B:104:0x01c8, B:106:0x01d0, B:109:0x01e3, B:110:0x0203, B:111:0x0204, B:112:0x0209, B:113:0x020a, B:115:0x0214, B:385:0x0695, B:386:0x069c, B:387:0x069d, B:388:0x06a2, B:389:0x06a3, B:390:0x06a8), top: B:393:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x029e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:31:0x0085, B:34:0x0098, B:38:0x00ad, B:117:0x021e, B:118:0x0224, B:120:0x022f, B:122:0x0237, B:126:0x024d, B:128:0x025b, B:148:0x029e, B:149:0x02a6, B:151:0x02b3, B:152:0x02b6, B:154:0x02c0, B:160:0x02d0, B:161:0x02d6, B:163:0x02de, B:164:0x02e1, B:166:0x02e9, B:167:0x02f3, B:170:0x02fb, B:171:0x0302, B:172:0x0303, B:175:0x030d, B:177:0x0311, B:179:0x0317, B:180:0x031a, B:182:0x0320, B:185:0x0331, B:191:0x034b, B:195:0x0358, B:192:0x0350, B:194:0x0354, B:130:0x0261, B:133:0x026c, B:137:0x0278, B:139:0x027e, B:144:0x028b, B:145:0x028e, B:203:0x0369, B:207:0x0375, B:209:0x037d, B:211:0x0387, B:213:0x0398, B:215:0x03a2, B:217:0x03aa, B:219:0x03ae, B:221:0x03b4, B:224:0x03b9, B:226:0x03bd, B:249:0x0422, B:251:0x042a, B:254:0x0433, B:255:0x044d, B:228:0x03c3, B:230:0x03cb, B:233:0x03d1, B:234:0x03de, B:237:0x03e7, B:240:0x03ed, B:243:0x03f2, B:244:0x03ff, B:246:0x0409, B:248:0x0417, B:256:0x044e, B:257:0x046c, B:259:0x046f, B:261:0x0473, B:263:0x0477, B:266:0x047d, B:270:0x0486, B:276:0x0496, B:278:0x04a5, B:280:0x04b0, B:281:0x04b8, B:282:0x04bb, B:294:0x04e7, B:296:0x04f2, B:301:0x04ff, B:304:0x050f, B:305:0x052f, B:289:0x04cb, B:291:0x04d5, B:293:0x04e4, B:292:0x04da, B:308:0x0534, B:310:0x053e, B:312:0x0546, B:313:0x0549, B:315:0x0554, B:316:0x0558, B:318:0x0563, B:321:0x056a, B:324:0x0574, B:325:0x0579, B:328:0x057e, B:330:0x0583, B:334:0x058f, B:336:0x0597, B:338:0x05aa, B:342:0x05c5, B:344:0x05cd, B:347:0x05d3, B:349:0x05d9, B:351:0x05e1, B:354:0x05f1, B:357:0x05f9, B:359:0x05fd, B:360:0x0604, B:362:0x0609, B:363:0x060c, B:365:0x0614, B:368:0x061e, B:371:0x0628, B:372:0x062d, B:373:0x0632, B:374:0x064c, B:339:0x05b3, B:340:0x05b8, B:375:0x064d, B:377:0x065f, B:380:0x0666, B:383:0x0674, B:384:0x0694, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f7, B:54:0x00fd, B:61:0x010c, B:63:0x0114, B:66:0x0126, B:67:0x013e, B:68:0x013f, B:69:0x0144, B:80:0x0159, B:81:0x015f, B:83:0x0166, B:85:0x0171, B:92:0x0183, B:95:0x018d, B:96:0x01a5, B:90:0x017e, B:84:0x016b, B:97:0x01a6, B:98:0x01be, B:104:0x01c8, B:106:0x01d0, B:109:0x01e3, B:110:0x0203, B:111:0x0204, B:112:0x0209, B:113:0x020a, B:115:0x0214, B:385:0x0695, B:386:0x069c, B:387:0x069d, B:388:0x06a2, B:389:0x06a3, B:390:0x06a8), top: B:393:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x046f A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:31:0x0085, B:34:0x0098, B:38:0x00ad, B:117:0x021e, B:118:0x0224, B:120:0x022f, B:122:0x0237, B:126:0x024d, B:128:0x025b, B:148:0x029e, B:149:0x02a6, B:151:0x02b3, B:152:0x02b6, B:154:0x02c0, B:160:0x02d0, B:161:0x02d6, B:163:0x02de, B:164:0x02e1, B:166:0x02e9, B:167:0x02f3, B:170:0x02fb, B:171:0x0302, B:172:0x0303, B:175:0x030d, B:177:0x0311, B:179:0x0317, B:180:0x031a, B:182:0x0320, B:185:0x0331, B:191:0x034b, B:195:0x0358, B:192:0x0350, B:194:0x0354, B:130:0x0261, B:133:0x026c, B:137:0x0278, B:139:0x027e, B:144:0x028b, B:145:0x028e, B:203:0x0369, B:207:0x0375, B:209:0x037d, B:211:0x0387, B:213:0x0398, B:215:0x03a2, B:217:0x03aa, B:219:0x03ae, B:221:0x03b4, B:224:0x03b9, B:226:0x03bd, B:249:0x0422, B:251:0x042a, B:254:0x0433, B:255:0x044d, B:228:0x03c3, B:230:0x03cb, B:233:0x03d1, B:234:0x03de, B:237:0x03e7, B:240:0x03ed, B:243:0x03f2, B:244:0x03ff, B:246:0x0409, B:248:0x0417, B:256:0x044e, B:257:0x046c, B:259:0x046f, B:261:0x0473, B:263:0x0477, B:266:0x047d, B:270:0x0486, B:276:0x0496, B:278:0x04a5, B:280:0x04b0, B:281:0x04b8, B:282:0x04bb, B:294:0x04e7, B:296:0x04f2, B:301:0x04ff, B:304:0x050f, B:305:0x052f, B:289:0x04cb, B:291:0x04d5, B:293:0x04e4, B:292:0x04da, B:308:0x0534, B:310:0x053e, B:312:0x0546, B:313:0x0549, B:315:0x0554, B:316:0x0558, B:318:0x0563, B:321:0x056a, B:324:0x0574, B:325:0x0579, B:328:0x057e, B:330:0x0583, B:334:0x058f, B:336:0x0597, B:338:0x05aa, B:342:0x05c5, B:344:0x05cd, B:347:0x05d3, B:349:0x05d9, B:351:0x05e1, B:354:0x05f1, B:357:0x05f9, B:359:0x05fd, B:360:0x0604, B:362:0x0609, B:363:0x060c, B:365:0x0614, B:368:0x061e, B:371:0x0628, B:372:0x062d, B:373:0x0632, B:374:0x064c, B:339:0x05b3, B:340:0x05b8, B:375:0x064d, B:377:0x065f, B:380:0x0666, B:383:0x0674, B:384:0x0694, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f7, B:54:0x00fd, B:61:0x010c, B:63:0x0114, B:66:0x0126, B:67:0x013e, B:68:0x013f, B:69:0x0144, B:80:0x0159, B:81:0x015f, B:83:0x0166, B:85:0x0171, B:92:0x0183, B:95:0x018d, B:96:0x01a5, B:90:0x017e, B:84:0x016b, B:97:0x01a6, B:98:0x01be, B:104:0x01c8, B:106:0x01d0, B:109:0x01e3, B:110:0x0203, B:111:0x0204, B:112:0x0209, B:113:0x020a, B:115:0x0214, B:385:0x0695, B:386:0x069c, B:387:0x069d, B:388:0x06a2, B:389:0x06a3, B:390:0x06a8), top: B:393:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0496 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:31:0x0085, B:34:0x0098, B:38:0x00ad, B:117:0x021e, B:118:0x0224, B:120:0x022f, B:122:0x0237, B:126:0x024d, B:128:0x025b, B:148:0x029e, B:149:0x02a6, B:151:0x02b3, B:152:0x02b6, B:154:0x02c0, B:160:0x02d0, B:161:0x02d6, B:163:0x02de, B:164:0x02e1, B:166:0x02e9, B:167:0x02f3, B:170:0x02fb, B:171:0x0302, B:172:0x0303, B:175:0x030d, B:177:0x0311, B:179:0x0317, B:180:0x031a, B:182:0x0320, B:185:0x0331, B:191:0x034b, B:195:0x0358, B:192:0x0350, B:194:0x0354, B:130:0x0261, B:133:0x026c, B:137:0x0278, B:139:0x027e, B:144:0x028b, B:145:0x028e, B:203:0x0369, B:207:0x0375, B:209:0x037d, B:211:0x0387, B:213:0x0398, B:215:0x03a2, B:217:0x03aa, B:219:0x03ae, B:221:0x03b4, B:224:0x03b9, B:226:0x03bd, B:249:0x0422, B:251:0x042a, B:254:0x0433, B:255:0x044d, B:228:0x03c3, B:230:0x03cb, B:233:0x03d1, B:234:0x03de, B:237:0x03e7, B:240:0x03ed, B:243:0x03f2, B:244:0x03ff, B:246:0x0409, B:248:0x0417, B:256:0x044e, B:257:0x046c, B:259:0x046f, B:261:0x0473, B:263:0x0477, B:266:0x047d, B:270:0x0486, B:276:0x0496, B:278:0x04a5, B:280:0x04b0, B:281:0x04b8, B:282:0x04bb, B:294:0x04e7, B:296:0x04f2, B:301:0x04ff, B:304:0x050f, B:305:0x052f, B:289:0x04cb, B:291:0x04d5, B:293:0x04e4, B:292:0x04da, B:308:0x0534, B:310:0x053e, B:312:0x0546, B:313:0x0549, B:315:0x0554, B:316:0x0558, B:318:0x0563, B:321:0x056a, B:324:0x0574, B:325:0x0579, B:328:0x057e, B:330:0x0583, B:334:0x058f, B:336:0x0597, B:338:0x05aa, B:342:0x05c5, B:344:0x05cd, B:347:0x05d3, B:349:0x05d9, B:351:0x05e1, B:354:0x05f1, B:357:0x05f9, B:359:0x05fd, B:360:0x0604, B:362:0x0609, B:363:0x060c, B:365:0x0614, B:368:0x061e, B:371:0x0628, B:372:0x062d, B:373:0x0632, B:374:0x064c, B:339:0x05b3, B:340:0x05b8, B:375:0x064d, B:377:0x065f, B:380:0x0666, B:383:0x0674, B:384:0x0694, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f7, B:54:0x00fd, B:61:0x010c, B:63:0x0114, B:66:0x0126, B:67:0x013e, B:68:0x013f, B:69:0x0144, B:80:0x0159, B:81:0x015f, B:83:0x0166, B:85:0x0171, B:92:0x0183, B:95:0x018d, B:96:0x01a5, B:90:0x017e, B:84:0x016b, B:97:0x01a6, B:98:0x01be, B:104:0x01c8, B:106:0x01d0, B:109:0x01e3, B:110:0x0203, B:111:0x0204, B:112:0x0209, B:113:0x020a, B:115:0x0214, B:385:0x0695, B:386:0x069c, B:387:0x069d, B:388:0x06a2, B:389:0x06a3, B:390:0x06a8), top: B:393:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x04f2 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:31:0x0085, B:34:0x0098, B:38:0x00ad, B:117:0x021e, B:118:0x0224, B:120:0x022f, B:122:0x0237, B:126:0x024d, B:128:0x025b, B:148:0x029e, B:149:0x02a6, B:151:0x02b3, B:152:0x02b6, B:154:0x02c0, B:160:0x02d0, B:161:0x02d6, B:163:0x02de, B:164:0x02e1, B:166:0x02e9, B:167:0x02f3, B:170:0x02fb, B:171:0x0302, B:172:0x0303, B:175:0x030d, B:177:0x0311, B:179:0x0317, B:180:0x031a, B:182:0x0320, B:185:0x0331, B:191:0x034b, B:195:0x0358, B:192:0x0350, B:194:0x0354, B:130:0x0261, B:133:0x026c, B:137:0x0278, B:139:0x027e, B:144:0x028b, B:145:0x028e, B:203:0x0369, B:207:0x0375, B:209:0x037d, B:211:0x0387, B:213:0x0398, B:215:0x03a2, B:217:0x03aa, B:219:0x03ae, B:221:0x03b4, B:224:0x03b9, B:226:0x03bd, B:249:0x0422, B:251:0x042a, B:254:0x0433, B:255:0x044d, B:228:0x03c3, B:230:0x03cb, B:233:0x03d1, B:234:0x03de, B:237:0x03e7, B:240:0x03ed, B:243:0x03f2, B:244:0x03ff, B:246:0x0409, B:248:0x0417, B:256:0x044e, B:257:0x046c, B:259:0x046f, B:261:0x0473, B:263:0x0477, B:266:0x047d, B:270:0x0486, B:276:0x0496, B:278:0x04a5, B:280:0x04b0, B:281:0x04b8, B:282:0x04bb, B:294:0x04e7, B:296:0x04f2, B:301:0x04ff, B:304:0x050f, B:305:0x052f, B:289:0x04cb, B:291:0x04d5, B:293:0x04e4, B:292:0x04da, B:308:0x0534, B:310:0x053e, B:312:0x0546, B:313:0x0549, B:315:0x0554, B:316:0x0558, B:318:0x0563, B:321:0x056a, B:324:0x0574, B:325:0x0579, B:328:0x057e, B:330:0x0583, B:334:0x058f, B:336:0x0597, B:338:0x05aa, B:342:0x05c5, B:344:0x05cd, B:347:0x05d3, B:349:0x05d9, B:351:0x05e1, B:354:0x05f1, B:357:0x05f9, B:359:0x05fd, B:360:0x0604, B:362:0x0609, B:363:0x060c, B:365:0x0614, B:368:0x061e, B:371:0x0628, B:372:0x062d, B:373:0x0632, B:374:0x064c, B:339:0x05b3, B:340:0x05b8, B:375:0x064d, B:377:0x065f, B:380:0x0666, B:383:0x0674, B:384:0x0694, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f7, B:54:0x00fd, B:61:0x010c, B:63:0x0114, B:66:0x0126, B:67:0x013e, B:68:0x013f, B:69:0x0144, B:80:0x0159, B:81:0x015f, B:83:0x0166, B:85:0x0171, B:92:0x0183, B:95:0x018d, B:96:0x01a5, B:90:0x017e, B:84:0x016b, B:97:0x01a6, B:98:0x01be, B:104:0x01c8, B:106:0x01d0, B:109:0x01e3, B:110:0x0203, B:111:0x0204, B:112:0x0209, B:113:0x020a, B:115:0x0214, B:385:0x0695, B:386:0x069c, B:387:0x069d, B:388:0x06a2, B:389:0x06a3, B:390:0x06a8), top: B:393:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x05ec  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x05f1 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:31:0x0085, B:34:0x0098, B:38:0x00ad, B:117:0x021e, B:118:0x0224, B:120:0x022f, B:122:0x0237, B:126:0x024d, B:128:0x025b, B:148:0x029e, B:149:0x02a6, B:151:0x02b3, B:152:0x02b6, B:154:0x02c0, B:160:0x02d0, B:161:0x02d6, B:163:0x02de, B:164:0x02e1, B:166:0x02e9, B:167:0x02f3, B:170:0x02fb, B:171:0x0302, B:172:0x0303, B:175:0x030d, B:177:0x0311, B:179:0x0317, B:180:0x031a, B:182:0x0320, B:185:0x0331, B:191:0x034b, B:195:0x0358, B:192:0x0350, B:194:0x0354, B:130:0x0261, B:133:0x026c, B:137:0x0278, B:139:0x027e, B:144:0x028b, B:145:0x028e, B:203:0x0369, B:207:0x0375, B:209:0x037d, B:211:0x0387, B:213:0x0398, B:215:0x03a2, B:217:0x03aa, B:219:0x03ae, B:221:0x03b4, B:224:0x03b9, B:226:0x03bd, B:249:0x0422, B:251:0x042a, B:254:0x0433, B:255:0x044d, B:228:0x03c3, B:230:0x03cb, B:233:0x03d1, B:234:0x03de, B:237:0x03e7, B:240:0x03ed, B:243:0x03f2, B:244:0x03ff, B:246:0x0409, B:248:0x0417, B:256:0x044e, B:257:0x046c, B:259:0x046f, B:261:0x0473, B:263:0x0477, B:266:0x047d, B:270:0x0486, B:276:0x0496, B:278:0x04a5, B:280:0x04b0, B:281:0x04b8, B:282:0x04bb, B:294:0x04e7, B:296:0x04f2, B:301:0x04ff, B:304:0x050f, B:305:0x052f, B:289:0x04cb, B:291:0x04d5, B:293:0x04e4, B:292:0x04da, B:308:0x0534, B:310:0x053e, B:312:0x0546, B:313:0x0549, B:315:0x0554, B:316:0x0558, B:318:0x0563, B:321:0x056a, B:324:0x0574, B:325:0x0579, B:328:0x057e, B:330:0x0583, B:334:0x058f, B:336:0x0597, B:338:0x05aa, B:342:0x05c5, B:344:0x05cd, B:347:0x05d3, B:349:0x05d9, B:351:0x05e1, B:354:0x05f1, B:357:0x05f9, B:359:0x05fd, B:360:0x0604, B:362:0x0609, B:363:0x060c, B:365:0x0614, B:368:0x061e, B:371:0x0628, B:372:0x062d, B:373:0x0632, B:374:0x064c, B:339:0x05b3, B:340:0x05b8, B:375:0x064d, B:377:0x065f, B:380:0x0666, B:383:0x0674, B:384:0x0694, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f7, B:54:0x00fd, B:61:0x010c, B:63:0x0114, B:66:0x0126, B:67:0x013e, B:68:0x013f, B:69:0x0144, B:80:0x0159, B:81:0x015f, B:83:0x0166, B:85:0x0171, B:92:0x0183, B:95:0x018d, B:96:0x01a5, B:90:0x017e, B:84:0x016b, B:97:0x01a6, B:98:0x01be, B:104:0x01c8, B:106:0x01d0, B:109:0x01e3, B:110:0x0203, B:111:0x0204, B:112:0x0209, B:113:0x020a, B:115:0x0214, B:385:0x0695, B:386:0x069c, B:387:0x069d, B:388:0x06a2, B:389:0x06a3, B:390:0x06a8), top: B:393:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:359:0x05fd A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:31:0x0085, B:34:0x0098, B:38:0x00ad, B:117:0x021e, B:118:0x0224, B:120:0x022f, B:122:0x0237, B:126:0x024d, B:128:0x025b, B:148:0x029e, B:149:0x02a6, B:151:0x02b3, B:152:0x02b6, B:154:0x02c0, B:160:0x02d0, B:161:0x02d6, B:163:0x02de, B:164:0x02e1, B:166:0x02e9, B:167:0x02f3, B:170:0x02fb, B:171:0x0302, B:172:0x0303, B:175:0x030d, B:177:0x0311, B:179:0x0317, B:180:0x031a, B:182:0x0320, B:185:0x0331, B:191:0x034b, B:195:0x0358, B:192:0x0350, B:194:0x0354, B:130:0x0261, B:133:0x026c, B:137:0x0278, B:139:0x027e, B:144:0x028b, B:145:0x028e, B:203:0x0369, B:207:0x0375, B:209:0x037d, B:211:0x0387, B:213:0x0398, B:215:0x03a2, B:217:0x03aa, B:219:0x03ae, B:221:0x03b4, B:224:0x03b9, B:226:0x03bd, B:249:0x0422, B:251:0x042a, B:254:0x0433, B:255:0x044d, B:228:0x03c3, B:230:0x03cb, B:233:0x03d1, B:234:0x03de, B:237:0x03e7, B:240:0x03ed, B:243:0x03f2, B:244:0x03ff, B:246:0x0409, B:248:0x0417, B:256:0x044e, B:257:0x046c, B:259:0x046f, B:261:0x0473, B:263:0x0477, B:266:0x047d, B:270:0x0486, B:276:0x0496, B:278:0x04a5, B:280:0x04b0, B:281:0x04b8, B:282:0x04bb, B:294:0x04e7, B:296:0x04f2, B:301:0x04ff, B:304:0x050f, B:305:0x052f, B:289:0x04cb, B:291:0x04d5, B:293:0x04e4, B:292:0x04da, B:308:0x0534, B:310:0x053e, B:312:0x0546, B:313:0x0549, B:315:0x0554, B:316:0x0558, B:318:0x0563, B:321:0x056a, B:324:0x0574, B:325:0x0579, B:328:0x057e, B:330:0x0583, B:334:0x058f, B:336:0x0597, B:338:0x05aa, B:342:0x05c5, B:344:0x05cd, B:347:0x05d3, B:349:0x05d9, B:351:0x05e1, B:354:0x05f1, B:357:0x05f9, B:359:0x05fd, B:360:0x0604, B:362:0x0609, B:363:0x060c, B:365:0x0614, B:368:0x061e, B:371:0x0628, B:372:0x062d, B:373:0x0632, B:374:0x064c, B:339:0x05b3, B:340:0x05b8, B:375:0x064d, B:377:0x065f, B:380:0x0666, B:383:0x0674, B:384:0x0694, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f7, B:54:0x00fd, B:61:0x010c, B:63:0x0114, B:66:0x0126, B:67:0x013e, B:68:0x013f, B:69:0x0144, B:80:0x0159, B:81:0x015f, B:83:0x0166, B:85:0x0171, B:92:0x0183, B:95:0x018d, B:96:0x01a5, B:90:0x017e, B:84:0x016b, B:97:0x01a6, B:98:0x01be, B:104:0x01c8, B:106:0x01d0, B:109:0x01e3, B:110:0x0203, B:111:0x0204, B:112:0x0209, B:113:0x020a, B:115:0x0214, B:385:0x0695, B:386:0x069c, B:387:0x069d, B:388:0x06a2, B:389:0x06a3, B:390:0x06a8), top: B:393:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0609 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:31:0x0085, B:34:0x0098, B:38:0x00ad, B:117:0x021e, B:118:0x0224, B:120:0x022f, B:122:0x0237, B:126:0x024d, B:128:0x025b, B:148:0x029e, B:149:0x02a6, B:151:0x02b3, B:152:0x02b6, B:154:0x02c0, B:160:0x02d0, B:161:0x02d6, B:163:0x02de, B:164:0x02e1, B:166:0x02e9, B:167:0x02f3, B:170:0x02fb, B:171:0x0302, B:172:0x0303, B:175:0x030d, B:177:0x0311, B:179:0x0317, B:180:0x031a, B:182:0x0320, B:185:0x0331, B:191:0x034b, B:195:0x0358, B:192:0x0350, B:194:0x0354, B:130:0x0261, B:133:0x026c, B:137:0x0278, B:139:0x027e, B:144:0x028b, B:145:0x028e, B:203:0x0369, B:207:0x0375, B:209:0x037d, B:211:0x0387, B:213:0x0398, B:215:0x03a2, B:217:0x03aa, B:219:0x03ae, B:221:0x03b4, B:224:0x03b9, B:226:0x03bd, B:249:0x0422, B:251:0x042a, B:254:0x0433, B:255:0x044d, B:228:0x03c3, B:230:0x03cb, B:233:0x03d1, B:234:0x03de, B:237:0x03e7, B:240:0x03ed, B:243:0x03f2, B:244:0x03ff, B:246:0x0409, B:248:0x0417, B:256:0x044e, B:257:0x046c, B:259:0x046f, B:261:0x0473, B:263:0x0477, B:266:0x047d, B:270:0x0486, B:276:0x0496, B:278:0x04a5, B:280:0x04b0, B:281:0x04b8, B:282:0x04bb, B:294:0x04e7, B:296:0x04f2, B:301:0x04ff, B:304:0x050f, B:305:0x052f, B:289:0x04cb, B:291:0x04d5, B:293:0x04e4, B:292:0x04da, B:308:0x0534, B:310:0x053e, B:312:0x0546, B:313:0x0549, B:315:0x0554, B:316:0x0558, B:318:0x0563, B:321:0x056a, B:324:0x0574, B:325:0x0579, B:328:0x057e, B:330:0x0583, B:334:0x058f, B:336:0x0597, B:338:0x05aa, B:342:0x05c5, B:344:0x05cd, B:347:0x05d3, B:349:0x05d9, B:351:0x05e1, B:354:0x05f1, B:357:0x05f9, B:359:0x05fd, B:360:0x0604, B:362:0x0609, B:363:0x060c, B:365:0x0614, B:368:0x061e, B:371:0x0628, B:372:0x062d, B:373:0x0632, B:374:0x064c, B:339:0x05b3, B:340:0x05b8, B:375:0x064d, B:377:0x065f, B:380:0x0666, B:383:0x0674, B:384:0x0694, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f7, B:54:0x00fd, B:61:0x010c, B:63:0x0114, B:66:0x0126, B:67:0x013e, B:68:0x013f, B:69:0x0144, B:80:0x0159, B:81:0x015f, B:83:0x0166, B:85:0x0171, B:92:0x0183, B:95:0x018d, B:96:0x01a5, B:90:0x017e, B:84:0x016b, B:97:0x01a6, B:98:0x01be, B:104:0x01c8, B:106:0x01d0, B:109:0x01e3, B:110:0x0203, B:111:0x0204, B:112:0x0209, B:113:0x020a, B:115:0x0214, B:385:0x0695, B:386:0x069c, B:387:0x069d, B:388:0x06a2, B:389:0x06a3, B:390:0x06a8), top: B:393:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x061e A[Catch: all -> 0x0080, TRY_ENTER, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:31:0x0085, B:34:0x0098, B:38:0x00ad, B:117:0x021e, B:118:0x0224, B:120:0x022f, B:122:0x0237, B:126:0x024d, B:128:0x025b, B:148:0x029e, B:149:0x02a6, B:151:0x02b3, B:152:0x02b6, B:154:0x02c0, B:160:0x02d0, B:161:0x02d6, B:163:0x02de, B:164:0x02e1, B:166:0x02e9, B:167:0x02f3, B:170:0x02fb, B:171:0x0302, B:172:0x0303, B:175:0x030d, B:177:0x0311, B:179:0x0317, B:180:0x031a, B:182:0x0320, B:185:0x0331, B:191:0x034b, B:195:0x0358, B:192:0x0350, B:194:0x0354, B:130:0x0261, B:133:0x026c, B:137:0x0278, B:139:0x027e, B:144:0x028b, B:145:0x028e, B:203:0x0369, B:207:0x0375, B:209:0x037d, B:211:0x0387, B:213:0x0398, B:215:0x03a2, B:217:0x03aa, B:219:0x03ae, B:221:0x03b4, B:224:0x03b9, B:226:0x03bd, B:249:0x0422, B:251:0x042a, B:254:0x0433, B:255:0x044d, B:228:0x03c3, B:230:0x03cb, B:233:0x03d1, B:234:0x03de, B:237:0x03e7, B:240:0x03ed, B:243:0x03f2, B:244:0x03ff, B:246:0x0409, B:248:0x0417, B:256:0x044e, B:257:0x046c, B:259:0x046f, B:261:0x0473, B:263:0x0477, B:266:0x047d, B:270:0x0486, B:276:0x0496, B:278:0x04a5, B:280:0x04b0, B:281:0x04b8, B:282:0x04bb, B:294:0x04e7, B:296:0x04f2, B:301:0x04ff, B:304:0x050f, B:305:0x052f, B:289:0x04cb, B:291:0x04d5, B:293:0x04e4, B:292:0x04da, B:308:0x0534, B:310:0x053e, B:312:0x0546, B:313:0x0549, B:315:0x0554, B:316:0x0558, B:318:0x0563, B:321:0x056a, B:324:0x0574, B:325:0x0579, B:328:0x057e, B:330:0x0583, B:334:0x058f, B:336:0x0597, B:338:0x05aa, B:342:0x05c5, B:344:0x05cd, B:347:0x05d3, B:349:0x05d9, B:351:0x05e1, B:354:0x05f1, B:357:0x05f9, B:359:0x05fd, B:360:0x0604, B:362:0x0609, B:363:0x060c, B:365:0x0614, B:368:0x061e, B:371:0x0628, B:372:0x062d, B:373:0x0632, B:374:0x064c, B:339:0x05b3, B:340:0x05b8, B:375:0x064d, B:377:0x065f, B:380:0x0666, B:383:0x0674, B:384:0x0694, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f7, B:54:0x00fd, B:61:0x010c, B:63:0x0114, B:66:0x0126, B:67:0x013e, B:68:0x013f, B:69:0x0144, B:80:0x0159, B:81:0x015f, B:83:0x0166, B:85:0x0171, B:92:0x0183, B:95:0x018d, B:96:0x01a5, B:90:0x017e, B:84:0x016b, B:97:0x01a6, B:98:0x01be, B:104:0x01c8, B:106:0x01d0, B:109:0x01e3, B:110:0x0203, B:111:0x0204, B:112:0x0209, B:113:0x020a, B:115:0x0214, B:385:0x0695, B:386:0x069c, B:387:0x069d, B:388:0x06a2, B:389:0x06a3, B:390:0x06a8), top: B:393:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:407:0x02a6 A[EDGE_INSN: B:407:0x02a6->B:149:0x02a6 BREAK  A[LOOP:0: B:31:0x0085->B:423:0x0085], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:414:0x04fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0614 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m0(java.util.Map r18, java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 1709
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.C0888a.m0(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public l0.e n0() {
        Object objL0 = l0(new l0.e(this.f18948f.I(EnumC0889b.OrderedField)));
        if (objL0 instanceof l0.e) {
            return (l0.e) objL0;
        }
        if (objL0 == null) {
            return null;
        }
        return new l0.e((Map<String, Object>) objL0);
    }

    public void o(Collection collection) {
        if (this.f18953k == 1) {
            if (!(collection instanceof List)) {
                C0227a c0227aE = E();
                c0227aE.f18961c = new y(collection);
                c0227aE.f18962d = this.f18949g;
                C0(0);
                return;
            }
            int size = collection.size() - 1;
            C0227a c0227aE2 = E();
            c0227aE2.f18961c = new y(this, (List) collection, size);
            c0227aE2.f18962d = this.f18949g;
            C0(0);
        }
    }

    public void o0(Object obj) {
        Object objE;
        Class<?> cls = obj.getClass();
        t tVarO = this.f18945c.o(cls);
        p0.o oVar = tVarO instanceof p0.o ? (p0.o) tVarO : null;
        if (this.f18948f.U() != 12 && this.f18948f.U() != 16) {
            throw new l0.d("syntax error, expect {, actual " + this.f18948f.o0());
        }
        while (true) {
            String strD = this.f18948f.D(this.f18944b);
            if (strD == null) {
                if (this.f18948f.U() == 13) {
                    this.f18948f.A(16);
                    return;
                } else if (this.f18948f.U() != 16 || !this.f18948f.I(EnumC0889b.AllowArbitraryCommas)) {
                }
            }
            l lVarK = oVar != null ? oVar.k(strD) : null;
            if (lVarK != null) {
                C1154d c1154d = lVarK.f19303a;
                Class<?> cls2 = c1154d.f22734e;
                Type type = c1154d.f22735f;
                if (cls2 == Integer.TYPE) {
                    this.f18948f.L(2);
                    objE = C0941D.f19671a.e(this, type, null);
                } else if (cls2 == String.class) {
                    this.f18948f.L(4);
                    objE = g0.f(this);
                } else if (cls2 == Long.TYPE) {
                    this.f18948f.L(2);
                    objE = C0952O.f19713a.e(this, type, null);
                } else {
                    t tVarN = this.f18945c.n(cls2, type);
                    this.f18948f.L(tVarN.d());
                    objE = tVarN.e(this, type, null);
                }
                lVarK.h(obj, objE);
                if (this.f18948f.U() != 16 && this.f18948f.U() == 13) {
                    this.f18948f.A(16);
                    return;
                }
            } else {
                if (!this.f18948f.I(EnumC0889b.IgnoreNotMatch)) {
                    throw new l0.d("setter not found, class " + cls.getName() + ", property " + strD);
                }
                this.f18948f.m0();
                S();
                if (this.f18948f.U() == 13) {
                    this.f18948f.nextToken();
                    return;
                }
            }
        }
    }

    public void p0() {
        if (this.f18948f.I(EnumC0889b.DisableCircularReferenceDetect)) {
            return;
        }
        this.f18949g = this.f18949g.f19018b;
        int i5 = this.f18951i;
        if (i5 <= 0) {
            return;
        }
        int i6 = i5 - 1;
        this.f18951i = i6;
        this.f18950h[i6] = null;
    }

    public void r(Map map, Object obj) {
        if (this.f18953k == 1) {
            y yVar = new y(map, obj);
            C0227a c0227aE = E();
            c0227aE.f18961c = yVar;
            c0227aE.f18962d = this.f18949g;
            C0(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object s0(java.lang.String r5) {
        /*
            r4 = this;
            o0.h[] r0 = r4.f18950h
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            r0 = 0
        L7:
            o0.h[] r2 = r4.f18950h
            int r3 = r2.length
            if (r0 >= r3) goto L22
            int r3 = r4.f18951i
            if (r0 >= r3) goto L22
            r2 = r2[r0]
            java.lang.String r3 = r2.toString()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L1f
            java.lang.Object r4 = r2.f19017a
            return r4
        L1f:
            int r0 = r0 + 1
            goto L7
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.C0888a.s0(java.lang.String):java.lang.Object");
    }

    public C0896i u() {
        return this.f18945c;
    }

    public C0895h u0(Object obj, Object obj2) {
        if (this.f18948f.I(EnumC0889b.DisableCircularReferenceDetect)) {
            return null;
        }
        return w0(this.f18949g, obj, obj2);
    }

    public C0895h v() {
        return this.f18949g;
    }

    public String w() {
        return this.f18946d;
    }

    public C0895h w0(C0895h c0895h, Object obj, Object obj2) {
        if (this.f18948f.I(EnumC0889b.DisableCircularReferenceDetect)) {
            return null;
        }
        C0895h c0895h2 = new C0895h(c0895h, obj, obj2);
        this.f18949g = c0895h2;
        f(c0895h2);
        return this.f18949g;
    }

    public DateFormat x() {
        if (this.f18947e == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f18946d, this.f18948f.s0());
            this.f18947e = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.f18948f.O());
        }
        return this.f18947e;
    }

    public void z0(C0895h c0895h) {
        if (this.f18948f.I(EnumC0889b.DisableCircularReferenceDetect)) {
            return;
        }
        this.f18949g = c0895h;
    }

    public C0888a(String str, C0896i c0896i) {
        this(str, new C0893f(str, AbstractC0822a.f18021f), c0896i);
    }

    public C0888a(String str, C0896i c0896i, int i5) {
        this(str, new C0893f(str, i5), c0896i);
    }

    public C0888a(Object obj, InterfaceC0890c interfaceC0890c, C0896i c0896i) {
        this.f18946d = AbstractC0822a.f18020e;
        this.f18951i = 0;
        this.f18953k = 0;
        this.f18954l = null;
        this.f18955m = null;
        this.f18956n = null;
        this.f18957o = 0;
        this.f18958p = null;
        this.f18948f = interfaceC0890c;
        this.f18943a = obj;
        this.f18945c = c0896i;
        this.f18944b = c0896i.f19039e;
        char cD0 = interfaceC0890c.d0();
        if (cD0 == '{') {
            interfaceC0890c.next();
            ((AbstractC0891d) interfaceC0890c).f18995a = 12;
        } else if (cD0 == '[') {
            interfaceC0890c.next();
            ((AbstractC0891d) interfaceC0890c).f18995a = 14;
        } else {
            interfaceC0890c.nextToken();
        }
    }
}
