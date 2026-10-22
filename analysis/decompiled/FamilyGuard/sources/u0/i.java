package u0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import m0.InterfaceC0853a;
import m0.InterfaceC0854b;
import m0.InterfaceC0856d;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f22776a;

    /* renamed from: b, reason: collision with root package name */
    public final Class<?> f22777b;

    /* renamed from: c, reason: collision with root package name */
    public final Constructor<?> f22778c;

    /* renamed from: d, reason: collision with root package name */
    public final Constructor<?> f22779d;

    /* renamed from: e, reason: collision with root package name */
    public final Method f22780e;

    /* renamed from: f, reason: collision with root package name */
    public final Method f22781f;

    /* renamed from: g, reason: collision with root package name */
    public final int f22782g;

    /* renamed from: h, reason: collision with root package name */
    public final C1154d[] f22783h;

    /* renamed from: i, reason: collision with root package name */
    public final C1154d[] f22784i;

    /* renamed from: j, reason: collision with root package name */
    public final int f22785j;

    /* renamed from: k, reason: collision with root package name */
    public final InterfaceC0856d f22786k;

    /* renamed from: l, reason: collision with root package name */
    public final String f22787l;

    /* renamed from: m, reason: collision with root package name */
    public final String f22788m;

    /* renamed from: n, reason: collision with root package name */
    public String[] f22789n;

    /* renamed from: o, reason: collision with root package name */
    public Type[] f22790o;

    /* renamed from: p, reason: collision with root package name */
    public String[] f22791p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f22792q;

    /* renamed from: r, reason: collision with root package name */
    public Constructor<?> f22793r;

    public i(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, InterfaceC0856d interfaceC0856d, List<C1154d> list) {
        InterfaceC0854b interfaceC0854b;
        this.f22776a = cls;
        this.f22777b = cls2;
        this.f22778c = constructor;
        this.f22779d = constructor2;
        this.f22780e = method;
        this.f22785j = o.e0(cls);
        this.f22781f = method2;
        this.f22786k = interfaceC0856d;
        if (interfaceC0856d != null) {
            String strTypeName = interfaceC0856d.typeName();
            String strTypeKey = interfaceC0856d.typeKey();
            this.f22788m = strTypeKey.length() <= 0 ? null : strTypeKey;
            if (strTypeName.length() != 0) {
                this.f22787l = strTypeName;
            } else {
                this.f22787l = cls.getName();
            }
            String[] strArrOrders = interfaceC0856d.orders();
            this.f22789n = strArrOrders.length == 0 ? null : strArrOrders;
        } else {
            this.f22787l = cls.getName();
            this.f22788m = null;
            this.f22789n = null;
        }
        C1154d[] c1154dArr = new C1154d[list.size()];
        this.f22783h = c1154dArr;
        list.toArray(c1154dArr);
        C1154d[] c1154dArr2 = new C1154d[c1154dArr.length];
        int i5 = 0;
        if (this.f22789n != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (C1154d c1154d : c1154dArr) {
                linkedHashMap.put(c1154d.f22730a, c1154d);
            }
            int i6 = 0;
            for (String str : this.f22789n) {
                C1154d c1154d2 = (C1154d) linkedHashMap.get(str);
                if (c1154d2 != null) {
                    c1154dArr2[i6] = c1154d2;
                    linkedHashMap.remove(str);
                    i6++;
                }
            }
            Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                c1154dArr2[i6] = (C1154d) it.next();
                i6++;
            }
        } else {
            System.arraycopy(c1154dArr, 0, c1154dArr2, 0, c1154dArr.length);
            Arrays.sort(c1154dArr2);
        }
        this.f22784i = Arrays.equals(this.f22783h, c1154dArr2) ? this.f22783h : c1154dArr2;
        if (constructor != null) {
            this.f22782g = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.f22782g = method.getParameterTypes().length;
        } else {
            this.f22782g = 0;
        }
        if (constructor2 != null) {
            this.f22790o = constructor2.getParameterTypes();
            boolean zS0 = o.s0(cls);
            this.f22792q = zS0;
            if (!zS0) {
                if (this.f22790o.length == this.f22783h.length) {
                    while (true) {
                        Type[] typeArr = this.f22790o;
                        if (i5 >= typeArr.length) {
                            return;
                        }
                        if (typeArr[i5] != this.f22783h[i5].f22734e) {
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
                this.f22791p = C1152b.f(constructor2);
                return;
            }
            this.f22791p = o.Z(cls);
            try {
                this.f22793r = cls.getConstructor(null);
            } catch (Throwable unused) {
            }
            Annotation[][] annotationArrC0 = o.c0(constructor2);
            for (int i7 = 0; i7 < this.f22791p.length && i7 < annotationArrC0.length; i7++) {
                Annotation[] annotationArr = annotationArrC0[i7];
                int length = annotationArr.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        interfaceC0854b = null;
                        break;
                    }
                    Annotation annotation = annotationArr[i8];
                    if (annotation instanceof InterfaceC0854b) {
                        interfaceC0854b = (InterfaceC0854b) annotation;
                        break;
                    }
                    i8++;
                }
                if (interfaceC0854b != null) {
                    String strName = interfaceC0854b.name();
                    if (strName.length() > 0) {
                        this.f22791p[i7] = strName;
                    }
                }
            }
        }
    }

    static boolean a(List<C1154d> list, C1154d c1154d) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C1154d c1154d2 = list.get(size);
            if (c1154d2.f22730a.equals(c1154d.f22730a) && (!c1154d2.f22737h || c1154d.f22737h)) {
                if (c1154d2.f22734e.isAssignableFrom(c1154d.f22734e)) {
                    list.set(size, c1154d);
                    return true;
                }
                if (c1154d2.compareTo(c1154d) >= 0) {
                    return false;
                }
                list.set(size, c1154d);
                return true;
            }
        }
        list.add(c1154d);
        return true;
    }

    public static i b(Class<?> cls, Type type, l0.m mVar) {
        return c(cls, type, mVar, false, o.f22828b, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0692  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x07a5  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x07aa  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x080d  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0830  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x083e  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0842  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x08ef  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0908  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x091d  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0924  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x094e  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0951  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x09d2  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x09e6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:485:0x0b40  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01cc  */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18, types: [m0.b] */
    /* JADX WARN: Type inference failed for: r10v49 */
    /* JADX WARN: Type inference failed for: r10v50 */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static u0.i c(java.lang.Class<?> r45, java.lang.reflect.Type r46, l0.m r47, boolean r48, boolean r49, boolean r50) {
        /*
            Method dump skipped, instructions count: 3004
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.i.c(java.lang.Class, java.lang.reflect.Type, l0.m, boolean, boolean, boolean):u0.i");
    }

    private static Map<TypeVariable, Type> d(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = null;
        if (superclass == null) {
            return null;
        }
        while (true) {
            Class<? super Object> cls2 = superclass;
            Class<?> cls3 = cls;
            cls = cls2;
            if (cls == null || cls == Object.class) {
                break;
            }
            if (cls3.getGenericSuperclass() instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) cls3.getGenericSuperclass()).getActualTypeArguments();
                TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
                for (int i5 = 0; i5 < actualTypeArguments.length; i5++) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    if (map.containsKey(actualTypeArguments[i5])) {
                        map.put(typeParameters[i5], map.get(actualTypeArguments[i5]));
                    } else {
                        map.put(typeParameters[i5], actualTypeArguments[i5]);
                    }
                }
            }
            superclass = cls.getSuperclass();
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0019 A[EDGE_INSN: B:44:0x0019->B:6:0x0019 BREAK  A[LOOP:1: B:20:0x0053->B:45:?]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(java.lang.Class<?> r18, java.lang.reflect.Type r19, l0.m r20, java.util.List<u0.C1154d> r21, java.lang.reflect.Field[] r22) {
        /*
            r0 = r20
            r1 = r22
            java.util.Map r14 = d(r18)
            int r15 = r1.length
            r16 = 0
            r2 = r16
        Ld:
            if (r2 >= r15) goto Lcd
            r5 = r1[r2]
            int r3 = r5.getModifiers()
            r4 = r3 & 8
            if (r4 == 0) goto L1f
        L19:
            r17 = r2
            r2 = r21
            goto Lc8
        L1f:
            r3 = r3 & 16
            if (r3 == 0) goto L4f
            java.lang.Class r3 = r5.getType()
            java.lang.Class<java.util.Map> r4 = java.util.Map.class
            boolean r4 = r4.isAssignableFrom(r3)
            if (r4 != 0) goto L4f
            java.lang.Class<java.util.Collection> r4 = java.util.Collection.class
            boolean r4 = r4.isAssignableFrom(r3)
            if (r4 != 0) goto L4f
            java.lang.Class<java.util.concurrent.atomic.AtomicLong> r4 = java.util.concurrent.atomic.AtomicLong.class
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L4f
            java.lang.Class<java.util.concurrent.atomic.AtomicInteger> r4 = java.util.concurrent.atomic.AtomicInteger.class
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L4f
            java.lang.Class<java.util.concurrent.atomic.AtomicBoolean> r4 = java.util.concurrent.atomic.AtomicBoolean.class
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L19
        L4f:
            java.util.Iterator r3 = r21.iterator()
        L53:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L6c
            java.lang.Object r4 = r3.next()
            u0.d r4 = (u0.C1154d) r4
            java.lang.String r4 = r4.f22730a
            java.lang.String r6 = r5.getName()
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L53
            goto L19
        L6c:
            java.lang.String r3 = r5.getName()
            java.lang.Class<m0.b> r4 = m0.InterfaceC0854b.class
            java.lang.annotation.Annotation r4 = u0.o.N(r5, r4)
            r12 = r4
            m0.b r12 = (m0.InterfaceC0854b) r12
            if (r12 == 0) goto La8
            boolean r4 = r12.deserialize()
            if (r4 != 0) goto L82
            goto L19
        L82:
            int r4 = r12.ordinal()
            q0.f0[] r6 = r12.serialzeFeatures()
            int r6 = q0.f0.g(r6)
            o0.b[] r7 = r12.parseFeatures()
            int r7 = o0.EnumC0889b.e(r7)
            java.lang.String r8 = r12.name()
            int r8 = r8.length()
            if (r8 == 0) goto La4
            java.lang.String r3 = r12.name()
        La4:
            r8 = r4
            r9 = r6
            r10 = r7
            goto Lac
        La8:
            r8 = r16
            r9 = r8
            r10 = r9
        Lac:
            if (r0 == 0) goto Lb2
            java.lang.String r3 = r0.b(r3)
        Lb2:
            r4 = r2
            u0.d r2 = new u0.d
            r11 = 0
            r13 = 0
            r6 = r4
            r4 = 0
            r7 = r19
            r17 = r6
            r6 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r3 = r2
            r2 = r21
            a(r2, r3)
        Lc8:
            int r3 = r17 + 1
            r2 = r3
            goto Ld
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.i.e(java.lang.Class, java.lang.reflect.Type, l0.m, java.util.List, java.lang.reflect.Field[]):void");
    }

    public static Class<?> f(Class<?> cls, InterfaceC0856d interfaceC0856d) {
        Class<?> clsBuilder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return o.z0("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (interfaceC0856d == null || (clsBuilder = interfaceC0856d.builder()) == Void.class) {
            return null;
        }
        return clsBuilder;
    }

    public static Constructor<?> g(Constructor[] constructorArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            if (((InterfaceC0853a) constructor2.getAnnotation(InterfaceC0853a.class)) != null) {
                if (constructor != null) {
                    throw new l0.d("multi-JSONCreator");
                }
                constructor = constructor2;
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (Constructor constructor3 : constructorArr) {
            Annotation[][] annotationArrC0 = o.c0(constructor3);
            if (annotationArrC0.length != 0) {
                int length = annotationArrC0.length;
                int i5 = 0;
                while (true) {
                    if (i5 < length) {
                        for (Annotation annotation : annotationArrC0[i5]) {
                            if (annotation instanceof InterfaceC0854b) {
                                break;
                            }
                        }
                    } else {
                        if (constructor != null) {
                            throw new l0.d("multi-JSONCreator");
                        }
                        constructor = constructor3;
                    }
                    i5++;
                }
            }
        }
        return constructor;
    }

    static Constructor<?> h(Class<?> cls, Constructor<?>[] constructorArr) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        int length = constructorArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            }
            Constructor<?> constructor2 = constructorArr[i5];
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
            i5++;
        }
        if (constructor == null && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            for (Constructor<?> constructor3 : constructorArr) {
                Class<?>[] parameterTypes = constructor3.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                    return constructor3;
                }
            }
        }
        return constructor;
    }

    private static Method i(Class<?> cls, Method[] methodArr, boolean z5) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((InterfaceC0853a) o.O(method2, InterfaceC0853a.class)) != null) {
                if (method != null) {
                    throw new l0.d("multi-JSONCreator");
                }
                method = method2;
            }
        }
        if (method == null && z5) {
            for (Method method3 : methodArr) {
                if (o.r0(method3)) {
                    return method3;
                }
            }
        }
        return method;
    }

    private static C1154d j(List<C1154d> list, String str) {
        Field field;
        for (C1154d c1154d : list) {
            if (c1154d.f22730a.equals(str) || ((field = c1154d.f22732c) != null && c1154d.g() != null && field.getName().equals(str))) {
                return c1154d;
            }
        }
        return null;
    }
}
