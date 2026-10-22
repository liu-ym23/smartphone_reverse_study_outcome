package I1;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.fasterxml.jackson.core.JsonFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public class f implements J1.f {

    /* renamed from: a, reason: collision with root package name */
    public final J1.d[] f3301a;

    /* renamed from: b, reason: collision with root package name */
    public final J1.d[] f3302b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, J1.d> f3303c;

    /* renamed from: d, reason: collision with root package name */
    public final Class<?> f3304d;

    /* renamed from: e, reason: collision with root package name */
    public final g f3305e;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentMap<String, Object> f3306f;

    /* renamed from: g, reason: collision with root package name */
    public transient long[] f3307g;

    /* renamed from: h, reason: collision with root package name */
    public transient int[] f3308h;

    public f(l lVar, Class<?> cls, Type type) {
        this(lVar, cls, type, g.b(cls, cls.getModifiers(), type, false, true, true, true, lVar.f3335d));
    }

    public Object a(b bVar, Type type) {
        if ((type instanceof Class) && this.f3304d.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject((bVar.f3258e.f3282c & Feature.OrderedField.mask) != 0));
        }
        g gVar = this.f3305e;
        Constructor<?> constructor = gVar.f3309a;
        if (constructor == null && gVar.f3312d == null) {
            return null;
        }
        Method method = gVar.f3312d;
        if (method != null && gVar.f3310b > 0) {
            return null;
        }
        try {
            Object objNewInstance = gVar.f3310b == 0 ? constructor != null ? constructor.newInstance(null) : method.invoke(null, null) : constructor.newInstance(bVar.f3259f.f3326a);
            if (bVar != null && (bVar.f3258e.f3282c & Feature.InitStringFieldAsEmpty.mask) != 0) {
                for (L1.a aVar : this.f3305e.f3313e) {
                    if (aVar.f4267g == String.class) {
                        aVar.j(objNewInstance, "");
                    }
                }
            }
            return objNewInstance;
        } catch (Exception e10) {
            throw new JSONException("create instance error, class " + this.f3304d.getName(), e10);
        }
    }

    @Override // J1.f
    public <T> T b(b bVar, Type type, Object obj) {
        return (T) d(bVar, type, obj, null);
    }

    public Object c(Map<String, Object> map, l lVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        g gVar = this.f3305e;
        if (gVar.f3311c == null) {
            Object objA = a(null, this.f3304d);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                J1.d dVarF = f(entry.getKey());
                if (dVarF != null) {
                    Object value = entry.getValue();
                    L1.a aVar = dVarF.f3694a;
                    Method method = aVar.f4262b;
                    if (method != null) {
                        method.invoke(objA, L1.d.c(value, method.getGenericParameterTypes()[0], lVar));
                    } else {
                        aVar.f4263c.set(objA, L1.d.c(value, aVar.f4268h, lVar));
                    }
                }
            }
            return objA;
        }
        L1.a[] aVarArr = gVar.f3313e;
        int length = aVarArr.length;
        Object[] objArr = new Object[length];
        for (int i10 = 0; i10 < length; i10++) {
            L1.a aVar2 = aVarArr[i10];
            Object objU = map.get(aVar2.f4261a);
            if (objU == null) {
                objU = L1.d.u(aVar2.f4267g);
            }
            objArr[i10] = objU;
        }
        Constructor<?> constructor = this.f3305e.f3311c;
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e10) {
            throw new JSONException("create instance error, " + this.f3305e.f3311c.toGenericString(), e10);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> T d(I1.b r44, java.lang.reflect.Type r45, java.lang.Object r46, java.lang.Object r47) {
        /*
            Method dump skipped, instructions count: 1896
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.f.d(I1.b, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final <T> T e(b bVar, Type type, Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
        Enum enumValueOf;
        String strQ;
        d dVar = bVar.f3258e;
        T t10 = (T) a(bVar, type);
        int length = this.f3302b.length;
        int i10 = 0;
        while (i10 < length) {
            char c10 = i10 == length + (-1) ? ']' : ',';
            J1.d dVar2 = this.f3302b[i10];
            L1.a aVar = dVar2.f3694a;
            Class<?> cls = aVar.f4267g;
            try {
                if (cls == Integer.TYPE) {
                    int iM = (int) dVar.M();
                    if (aVar.f4264d) {
                        aVar.f4263c.setInt(t10, iM);
                    } else {
                        dVar2.g(t10, new Integer(iM));
                    }
                    char c11 = dVar.f3283d;
                    if (c11 == ',') {
                        int i11 = dVar.f3284e + 1;
                        dVar.f3284e = i11;
                        dVar.f3283d = i11 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i11);
                        dVar.f3280a = 16;
                    } else if (c11 == ']') {
                        int i12 = dVar.f3284e + 1;
                        dVar.f3284e = i12;
                        dVar.f3283d = i12 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i12);
                        dVar.f3280a = 15;
                    } else {
                        dVar.s();
                    }
                } else if (cls == String.class) {
                    char c12 = dVar.f3283d;
                    if (c12 == '\"') {
                        strQ = dVar.Q(JsonFactory.DEFAULT_QUOTE_CHAR);
                    } else {
                        if (c12 != 'n' || !dVar.f3296q.startsWith("null", dVar.f3284e)) {
                            throw new JSONException("not match string. feild : " + obj);
                        }
                        int i13 = dVar.f3284e + 4;
                        dVar.f3284e = i13;
                        dVar.f3283d = i13 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i13);
                        strQ = null;
                    }
                    if (aVar.f4264d) {
                        aVar.f4263c.set(t10, strQ);
                    } else {
                        dVar2.g(t10, strQ);
                    }
                    char c13 = dVar.f3283d;
                    if (c13 == ',') {
                        int i14 = dVar.f3284e + 1;
                        dVar.f3284e = i14;
                        dVar.f3283d = i14 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i14);
                        dVar.f3280a = 16;
                    } else if (c13 == ']') {
                        int i15 = dVar.f3284e + 1;
                        dVar.f3284e = i15;
                        dVar.f3283d = i15 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i15);
                        dVar.f3280a = 15;
                    } else {
                        dVar.s();
                    }
                } else {
                    if (cls == Long.TYPE) {
                        long jM = dVar.M();
                        if (aVar.f4264d) {
                            aVar.f4263c.setLong(t10, jM);
                        } else {
                            dVar2.g(t10, new Long(jM));
                        }
                        char c14 = dVar.f3283d;
                        if (c14 == ',') {
                            int i16 = dVar.f3284e + 1;
                            dVar.f3284e = i16;
                            dVar.f3283d = i16 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i16);
                            dVar.f3280a = 16;
                        } else if (c14 == ']') {
                            int i17 = dVar.f3284e + 1;
                            dVar.f3284e = i17;
                            dVar.f3283d = i17 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i17);
                            dVar.f3280a = 15;
                        } else {
                            dVar.s();
                        }
                    } else if (cls == Boolean.TYPE) {
                        boolean zX = dVar.x();
                        if (aVar.f4264d) {
                            aVar.f4263c.setBoolean(t10, zX);
                        } else {
                            dVar2.g(t10, Boolean.valueOf(zX));
                        }
                        char c15 = dVar.f3283d;
                        if (c15 == ',') {
                            int i18 = dVar.f3284e + 1;
                            dVar.f3284e = i18;
                            dVar.f3283d = i18 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i18);
                            dVar.f3280a = 16;
                        } else if (c15 == ']') {
                            int i19 = dVar.f3284e + 1;
                            dVar.f3284e = i19;
                            dVar.f3283d = i19 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i19);
                            dVar.f3280a = 15;
                        } else {
                            dVar.s();
                        }
                    } else if (cls.isEnum()) {
                        char c16 = dVar.f3283d;
                        if (c16 == '\"') {
                            String strR = dVar.R(bVar.f3254a);
                            enumValueOf = strR == null ? null : Enum.valueOf(cls, strR);
                        } else {
                            if (c16 < '0' || c16 > '9') {
                                throw new JSONException("illegal enum." + dVar.i());
                            }
                            enumValueOf = ((c) ((a) dVar2).h(bVar.f3255b)).f3272b[(int) dVar.M()];
                        }
                        dVar2.g(t10, enumValueOf);
                        char c17 = dVar.f3283d;
                        if (c17 == ',') {
                            int i20 = dVar.f3284e + 1;
                            dVar.f3284e = i20;
                            dVar.f3283d = i20 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i20);
                            dVar.f3280a = 16;
                        } else if (c17 == ']') {
                            int i21 = dVar.f3284e + 1;
                            dVar.f3284e = i21;
                            dVar.f3283d = i21 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i21);
                            dVar.f3280a = 15;
                        } else {
                            dVar.s();
                        }
                    } else if (cls == Date.class && dVar.f3283d == '1') {
                        dVar2.g(t10, new Date(dVar.M()));
                        char c18 = dVar.f3283d;
                        if (c18 == ',') {
                            int i22 = dVar.f3284e + 1;
                            dVar.f3284e = i22;
                            dVar.f3283d = i22 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i22);
                            dVar.f3280a = 16;
                        } else if (c18 == ']') {
                            int i23 = dVar.f3284e + 1;
                            dVar.f3284e = i23;
                            dVar.f3283d = i23 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i23);
                            dVar.f3280a = 15;
                        } else {
                            dVar.s();
                        }
                    } else {
                        char c19 = dVar.f3283d;
                        if (c19 == '[') {
                            int i24 = dVar.f3284e + 1;
                            dVar.f3284e = i24;
                            dVar.f3283d = i24 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i24);
                            dVar.f3280a = 14;
                        } else if (c19 == '{') {
                            int i25 = dVar.f3284e + 1;
                            dVar.f3284e = i25;
                            dVar.f3283d = i25 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i25);
                            dVar.f3280a = 12;
                        } else {
                            dVar.s();
                        }
                        dVar2.b(bVar, t10, aVar.f4268h, null);
                        if (c10 == ']') {
                            if (dVar.f3280a != 15) {
                                throw new JSONException("syntax error");
                            }
                        } else if (c10 == ',' && dVar.f3280a != 16) {
                            throw new JSONException("syntax error");
                        }
                    }
                    i10++;
                }
                i10++;
            } catch (IllegalAccessException e10) {
                throw new JSONException("set " + aVar.f4261a + "error", e10);
            }
        }
        if (dVar.f3283d != ',') {
            dVar.s();
            return t10;
        }
        int i26 = dVar.f3284e + 1;
        dVar.f3284e = i26;
        dVar.f3283d = i26 >= dVar.f3297r ? (char) 26 : dVar.f3296q.charAt(i26);
        dVar.f3280a = 16;
        return t10;
    }

    public J1.d f(String str) {
        if (str == null) {
            return null;
        }
        int i10 = 0;
        if (!this.f3305e.f3316h) {
            int length = this.f3302b.length - 1;
            while (i10 <= length) {
                int i11 = (i10 + length) >>> 1;
                int iCompareTo = this.f3302b[i11].f3694a.f4261a.compareTo(str);
                if (iCompareTo < 0) {
                    i10 = i11 + 1;
                } else {
                    if (iCompareTo <= 0) {
                        return this.f3302b[i11];
                    }
                    length = i11 - 1;
                }
            }
            Map<String, J1.d> map = this.f3303c;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
        while (true) {
            J1.d[] dVarArr = this.f3302b;
            if (i10 >= dVarArr.length) {
                return null;
            }
            J1.d dVar = dVarArr[i10];
            if (dVar.f3694a.f4261a.equalsIgnoreCase(str)) {
                return dVar;
            }
            i10++;
        }
    }

    public J1.d g(long j10) {
        int i10 = 0;
        while (true) {
            J1.d[] dVarArr = this.f3302b;
            if (i10 >= dVarArr.length) {
                return null;
            }
            J1.d dVar = dVarArr[i10];
            if (dVar.f3694a.f4275o == j10) {
                return dVar;
            }
            i10++;
        }
    }

    public f h(l lVar, g gVar, String str) {
        H1.c cVar = gVar.f3315g;
        if (cVar == null) {
            return null;
        }
        for (Class<?> cls : cVar.seeAlso()) {
            J1.f fVarC = lVar.c(cls);
            if (fVarC instanceof f) {
                f fVar = (f) fVarC;
                g gVar2 = fVar.f3305e;
                if (gVar2.f3318j.equals(str)) {
                    return fVar;
                }
                f fVarH = h(lVar, gVar2, str);
                if (fVarH != null) {
                    return fVarH;
                }
            }
        }
        return null;
    }

    public void i(b bVar, Object obj, String str) {
        d dVar = bVar.f3258e;
        if ((dVar.f3282c & Feature.IgnoreNotMatch.mask) == 0) {
            throw new JSONException("setter not found, class " + this.f3304d.getName() + ", property " + str);
        }
        dVar.u(':');
        List<J1.c> list = bVar.f3264k;
        Type typeB = null;
        if (list != null) {
            Iterator<J1.c> it = list.iterator();
            while (it.hasNext()) {
                typeB = it.next().b(obj, str);
            }
        }
        Object objJ = typeB == null ? bVar.J() : bVar.D0(typeB);
        if (obj instanceof J1.a) {
            ((J1.a) obj).a(str, objJ);
            return;
        }
        List<J1.b> list2 = bVar.f3265l;
        if (list2 != null) {
            Iterator<J1.b> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().a(obj, str, objJ);
            }
        }
    }

    public final boolean j(b bVar, String str, Object obj, Type type, Map<String, Object> map) throws SecurityException {
        d dVar = bVar.f3258e;
        J1.d dVarF = f(str);
        if (dVarF == null) {
            long jV = L1.d.v(str);
            if (this.f3307g == null) {
                long[] jArr = new long[this.f3302b.length];
                int i10 = 0;
                while (true) {
                    J1.d[] dVarArr = this.f3302b;
                    if (i10 >= dVarArr.length) {
                        break;
                    }
                    jArr[i10] = L1.d.v(dVarArr[i10].f3694a.f4261a);
                    i10++;
                }
                Arrays.sort(jArr);
                this.f3307g = jArr;
            }
            int iBinarySearch = Arrays.binarySearch(this.f3307g, jV);
            if (iBinarySearch < 0 && str.startsWith("is")) {
                iBinarySearch = Arrays.binarySearch(this.f3307g, L1.d.v(str.substring(2)));
            }
            if (iBinarySearch >= 0) {
                if (this.f3308h == null) {
                    int[] iArr = new int[this.f3307g.length];
                    Arrays.fill(iArr, -1);
                    int i11 = 0;
                    while (true) {
                        J1.d[] dVarArr2 = this.f3302b;
                        if (i11 >= dVarArr2.length) {
                            break;
                        }
                        int iBinarySearch2 = Arrays.binarySearch(this.f3307g, L1.d.v(dVarArr2[i11].f3694a.f4261a));
                        if (iBinarySearch2 >= 0) {
                            iArr[iBinarySearch2] = i11;
                        }
                        i11++;
                    }
                    this.f3308h = iArr;
                }
                int i12 = this.f3308h[iBinarySearch];
                if (i12 != -1) {
                    dVarF = this.f3302b[i12];
                }
            }
        }
        int i13 = Feature.SupportNonPublicField.mask;
        if (dVarF == null && ((bVar.f3258e.f3282c & i13) != 0 || (i13 & this.f3305e.f3320l) != 0)) {
            if (this.f3306f == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                for (Field field : this.f3304d.getDeclaredFields()) {
                    String name = field.getName();
                    if (f(name) == null) {
                        int modifiers = field.getModifiers();
                        if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                            concurrentHashMap.put(name, field);
                        }
                    }
                }
                this.f3306f = concurrentHashMap;
            }
            Object obj2 = this.f3306f.get(str);
            if (obj2 != null) {
                if (obj2 instanceof J1.d) {
                    dVarF = (J1.d) obj2;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    a aVar = new a(bVar.f3255b, this.f3304d, new L1.a(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0));
                    this.f3306f.put(str, aVar);
                    dVarF = aVar;
                }
            }
        }
        if (dVarF == null) {
            i(bVar, obj, str);
            return false;
        }
        dVar.u(':');
        dVarF.b(bVar, obj, type, map);
        return true;
    }

    public f(l lVar, Class<?> cls, Type type, g gVar) {
        this.f3304d = cls;
        this.f3305e = gVar;
        L1.a[] aVarArr = gVar.f3314f;
        this.f3302b = new J1.d[aVarArr.length];
        int length = aVarArr.length;
        HashMap map = null;
        for (int i10 = 0; i10 < length; i10++) {
            L1.a aVar = gVar.f3314f[i10];
            J1.d dVarA = lVar.a(lVar, cls, aVar);
            this.f3302b[i10] = dVarA;
            for (String str : aVar.f4276p) {
                if (map == null) {
                    map = new HashMap();
                }
                map.put(str, dVarA);
            }
        }
        this.f3303c = map;
        L1.a[] aVarArr2 = gVar.f3313e;
        this.f3301a = new J1.d[aVarArr2.length];
        int length2 = aVarArr2.length;
        for (int i11 = 0; i11 < length2; i11++) {
            this.f3301a[i11] = f(gVar.f3313e[i11].f4261a);
        }
    }
}
