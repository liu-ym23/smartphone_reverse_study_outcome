package p0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import l0.AbstractC0822a;
import o0.C0888a;
import o0.C0894g;
import o0.C0895h;
import o0.EnumC0889b;
import o0.InterfaceC0890c;

/* loaded from: classes.dex */
public class r extends AbstractC0918e implements t {

    /* renamed from: a, reason: collision with root package name */
    public static r f19338a = new r();

    public static Object j(C0888a c0888a, Map<Object, Object> map, Type type, Type type2, Object obj) {
        Object objE;
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        if (interfaceC0890c.U() != 12 && interfaceC0890c.U() != 16) {
            throw new l0.d("syntax error, expect {, actual " + interfaceC0890c.o0());
        }
        t tVarO = c0888a.u().o(type);
        t tVarO2 = c0888a.u().o(type2);
        interfaceC0890c.A(tVarO.d());
        C0895h c0895hV = c0888a.v();
        while (interfaceC0890c.U() != 13) {
            try {
                Object obj2 = null;
                if (interfaceC0890c.U() == 4 && interfaceC0890c.u0() && !interfaceC0890c.I(EnumC0889b.DisableSpecialKeyDetect)) {
                    interfaceC0890c.L(4);
                    if (interfaceC0890c.U() != 4) {
                        throw new l0.d("illegal ref, " + C0894g.a(interfaceC0890c.U()));
                    }
                    String strN = interfaceC0890c.N();
                    if ("..".equals(strN)) {
                        obj2 = c0895hV.f19018b.f19017a;
                    } else if ("$".equals(strN)) {
                        C0895h c0895h = c0895hV;
                        while (true) {
                            C0895h c0895h2 = c0895h.f19018b;
                            if (c0895h2 == null) {
                                break;
                            }
                            c0895h = c0895h2;
                        }
                        obj2 = c0895h.f19017a;
                    } else {
                        c0888a.m(new C0888a.C0227a(c0895hV, strN));
                        c0888a.C0(1);
                    }
                    interfaceC0890c.A(13);
                    if (interfaceC0890c.U() != 13) {
                        throw new l0.d("illegal ref");
                    }
                    interfaceC0890c.A(16);
                    return obj2;
                }
                if (map.size() == 0 && interfaceC0890c.U() == 4 && AbstractC0822a.f18018c.equals(interfaceC0890c.N()) && !interfaceC0890c.I(EnumC0889b.DisableSpecialKeyDetect)) {
                    interfaceC0890c.L(4);
                    interfaceC0890c.A(16);
                    if (interfaceC0890c.U() == 13) {
                        interfaceC0890c.nextToken();
                        return map;
                    }
                    interfaceC0890c.A(tVarO.d());
                }
                if (interfaceC0890c.U() == 4 && (tVarO instanceof o)) {
                    String strN2 = interfaceC0890c.N();
                    interfaceC0890c.nextToken();
                    C0888a c0888a2 = new C0888a(strN2, c0888a.u(), c0888a.G().Y());
                    c0888a2.A0(c0888a.w());
                    objE = tVarO.e(c0888a2, type, null);
                } else {
                    objE = tVarO.e(c0888a, type, null);
                }
                if (interfaceC0890c.U() != 17) {
                    throw new l0.d("syntax error, expect :, actual " + interfaceC0890c.U());
                }
                interfaceC0890c.A(tVarO2.d());
                Object objE2 = tVarO2.e(c0888a, type2, objE);
                c0888a.r(map, objE);
                map.put(objE, objE2);
                if (interfaceC0890c.U() == 16) {
                    interfaceC0890c.A(tVarO.d());
                }
            } finally {
                c0888a.z0(c0895hV);
            }
        }
        interfaceC0890c.A(16);
        return map;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x022e, code lost:
    
        return r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ec A[Catch: all -> 0x00c3, TRY_ENTER, TryCatch #0 {all -> 0x00c3, blocks: (B:25:0x00a5, B:29:0x00b8, B:35:0x00d0, B:60:0x0165, B:62:0x0177, B:64:0x017f, B:66:0x0185, B:70:0x019c, B:73:0x01a7, B:76:0x01ae, B:77:0x01b6, B:79:0x01be, B:81:0x01c7, B:84:0x01ce, B:86:0x01db, B:88:0x01df, B:89:0x01e2, B:92:0x01ec, B:94:0x01f1, B:95:0x01f4, B:97:0x01fc, B:99:0x0205, B:105:0x0220, B:98:0x0201, B:38:0x00e3, B:39:0x00fb, B:42:0x0100, B:47:0x0113, B:49:0x011b, B:52:0x012d, B:53:0x0145, B:54:0x0146, B:55:0x014b, B:56:0x014c, B:58:0x0154, B:111:0x022f, B:112:0x024f, B:113:0x0250, B:114:0x0255), top: B:118:0x00a5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map k(o0.C0888a r11, java.util.Map<java.lang.String, java.lang.Object> r12, java.lang.reflect.Type r13, java.lang.Object r14, int r15) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.r.k(o0.a, java.util.Map, java.lang.reflect.Type, java.lang.Object, int):java.util.Map");
    }

    @Override // p0.t
    public int d() {
        return 12;
    }

    @Override // p0.AbstractC0918e
    public <T> T f(C0888a c0888a, Type type, Object obj, String str, int i5) throws Throwable {
        C0888a c0888a2;
        if (type == l0.e.class && c0888a.D() == null) {
            return (T) c0888a.n0();
        }
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        if (interfaceC0890c.U() == 8) {
            interfaceC0890c.A(16);
            return null;
        }
        boolean z5 = (type instanceof Class) && "java.util.Collections$UnmodifiableMap".equals(((Class) type).getName());
        Map<Object, Object> mapH = (interfaceC0890c.Y() & EnumC0889b.OrderedField.f18991a) != 0 ? h(type, interfaceC0890c.Y()) : g(type);
        C0895h c0895hV = c0888a.v();
        try {
            c0888a.w0(c0895hV, mapH, obj);
            c0888a2 = c0888a;
        } catch (Throwable th) {
            th = th;
            c0888a2 = c0888a;
        }
        try {
            Map map = (T) i(c0888a2, type, obj, mapH, i5);
            if (z5) {
                map = (T) Collections.unmodifiableMap(map);
            }
            c0888a2.z0(c0895hV);
            return (T) map;
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            c0888a2.z0(c0895hV);
            throw th3;
        }
    }

    public Map<Object, Object> g(Type type) {
        return h(type, AbstractC0822a.f18022g);
    }

    public Map<Object, Object> h(Type type, int i5) {
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
        if (type == Map.class) {
            return (EnumC0889b.OrderedField.f18991a & i5) != 0 ? new LinkedHashMap() : new HashMap();
        }
        if (type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return EnumMap.class.equals(rawType) ? new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]) : h(rawType, i5);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new l0.d("unsupport type " + type);
        }
        if ("java.util.Collections$UnmodifiableMap".equals(cls.getName())) {
            return new HashMap();
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e6) {
            throw new l0.d("unsupport type " + type, e6);
        }
    }

    protected Object i(C0888a c0888a, Type type, Object obj, Map map, int i5) {
        if (!(type instanceof ParameterizedType)) {
            return c0888a.m0(map, obj);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type2 = parameterizedType.getActualTypeArguments()[0];
        Type type3 = map.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap") ? List.class : parameterizedType.getActualTypeArguments()[1];
        return String.class == type2 ? k(c0888a, map, type3, obj, i5) : j(c0888a, map, type2, type3, obj);
    }
}
