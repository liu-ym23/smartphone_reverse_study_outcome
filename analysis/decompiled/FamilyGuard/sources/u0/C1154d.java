package u0;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;
import m0.InterfaceC0854b;
import org.libpag.BuildConfig;

/* renamed from: u0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1154d implements Comparable<C1154d> {

    /* renamed from: a, reason: collision with root package name */
    public final String f22730a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f22731b;

    /* renamed from: c, reason: collision with root package name */
    public final Field f22732c;

    /* renamed from: d, reason: collision with root package name */
    private int f22733d;

    /* renamed from: e, reason: collision with root package name */
    public final Class<?> f22734e;

    /* renamed from: f, reason: collision with root package name */
    public final Type f22735f;

    /* renamed from: g, reason: collision with root package name */
    public final Class<?> f22736g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f22737h;

    /* renamed from: i, reason: collision with root package name */
    public final int f22738i;

    /* renamed from: j, reason: collision with root package name */
    public final int f22739j;

    /* renamed from: k, reason: collision with root package name */
    public final String f22740k;

    /* renamed from: l, reason: collision with root package name */
    private final InterfaceC0854b f22741l;

    /* renamed from: m, reason: collision with root package name */
    private final InterfaceC0854b f22742m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f22743n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f22744o;

    /* renamed from: p, reason: collision with root package name */
    public final char[] f22745p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f22746q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f22747r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f22748s;

    /* renamed from: t, reason: collision with root package name */
    public final String f22749t;

    /* renamed from: u, reason: collision with root package name */
    public final String[] f22750u;

    /* renamed from: v, reason: collision with root package name */
    public final long f22751v;

    public C1154d(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i5, int i6, int i7) {
        this.f22733d = 0;
        i5 = i5 < 0 ? 0 : i5;
        this.f22730a = str;
        this.f22736g = cls;
        this.f22734e = cls2;
        this.f22735f = type;
        this.f22731b = null;
        this.f22732c = field;
        this.f22733d = i5;
        this.f22738i = i6;
        this.f22739j = i7;
        this.f22746q = cls2.isEnum();
        if (field != null) {
            int modifiers = field.getModifiers();
            this.f22743n = true;
            this.f22744o = Modifier.isTransient(modifiers);
        } else {
            this.f22744o = false;
            this.f22743n = false;
        }
        this.f22745p = d();
        if (field != null) {
            o.L0(field);
        }
        this.f22740k = BuildConfig.FLAVOR;
        InterfaceC0854b interfaceC0854b = field == null ? null : (InterfaceC0854b) o.N(field, InterfaceC0854b.class);
        this.f22741l = interfaceC0854b;
        this.f22742m = null;
        this.f22737h = false;
        this.f22747r = false;
        this.f22748s = false;
        this.f22749t = null;
        this.f22750u = new String[0];
        this.f22751v = p(str, interfaceC0854b);
    }

    private static boolean h(Type[] typeArr, Map<TypeVariable, Type> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        boolean z5 = false;
        for (int i5 = 0; i5 < typeArr.length; i5++) {
            Type type = typeArr[i5];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (h(actualTypeArguments, map)) {
                    typeArr[i5] = l0.n.b(new k(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                    z5 = true;
                }
            } else if ((type instanceof TypeVariable) && map.containsKey(type)) {
                typeArr[i5] = map.get(type);
                z5 = true;
            }
        }
        return z5;
    }

    private static boolean i(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z5 = false;
        for (int i5 = 0; i5 < typeArr.length; i5++) {
            Type type = typeArr[i5];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (i(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i5] = l0.n.b(new k(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                    z5 = true;
                }
            } else if (type instanceof TypeVariable) {
                for (int i6 = 0; i6 < typeVariableArr.length; i6++) {
                    if (type.equals(typeVariableArr[i6])) {
                        typeArr[i5] = typeArr2[i6];
                        z5 = true;
                    }
                }
            }
        }
        return z5;
    }

    public static Type k(Class<?> cls, Type type, Type type2) {
        return l(cls, type, type2, null);
    }

    public static Type l(Class<?> cls, Type type, Type type2, Map<TypeVariable, Type> map) {
        TypeVariable<Class<?>>[] typeParameters;
        ParameterizedType parameterizedType;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type typeL = l(cls, type, genericComponentType, map);
                return genericComponentType != typeL ? Array.newInstance(o.P(typeL), 0).getClass() : type2;
            }
            if (o.o0(type)) {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) o.Y(type);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    TypeVariable<Class<?>>[] typeParameters2 = o.P(parameterizedType2).getTypeParameters();
                    for (int i5 = 0; i5 < typeParameters2.length; i5++) {
                        if (typeParameters2[i5].getName().equals(typeVariable.getName())) {
                            return parameterizedType2.getActualTypeArguments()[i5];
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                    boolean zH = h(actualTypeArguments, map);
                    if (!zH) {
                        if (type instanceof ParameterizedType) {
                            parameterizedType = (ParameterizedType) type;
                            typeParameters = cls.getTypeParameters();
                        } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                            parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                            typeParameters = cls.getSuperclass().getTypeParameters();
                        } else {
                            typeParameters = type.getClass().getTypeParameters();
                            parameterizedType = parameterizedType3;
                        }
                        zH = i(actualTypeArguments, typeParameters, parameterizedType.getActualTypeArguments());
                    }
                    if (zH) {
                        return l0.n.b(new k(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType()));
                    }
                }
            }
        }
        return type2;
    }

    private static Type n(Class<?> cls, Type type, TypeVariable<?> typeVariable) {
        Type[] actualTypeArguments;
        Class<?> cls2 = typeVariable.getGenericDeclaration() instanceof Class ? (Class) typeVariable.getGenericDeclaration() : null;
        if (cls2 == cls) {
            actualTypeArguments = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
        } else {
            Type[] typeArr = null;
            while (cls != null && cls != Object.class && cls != cls2) {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    i(actualTypeArguments2, cls.getTypeParameters(), typeArr);
                    typeArr = actualTypeArguments2;
                }
                cls = cls.getSuperclass();
            }
            actualTypeArguments = typeArr;
        }
        if (actualTypeArguments != null && cls2 != null) {
            TypeVariable<Class<?>>[] typeParameters = cls2.getTypeParameters();
            for (int i5 = 0; i5 < typeParameters.length; i5++) {
                if (typeVariable.equals(typeParameters[i5])) {
                    return actualTypeArguments[i5];
                }
            }
        }
        return null;
    }

    private long p(String str, InterfaceC0854b interfaceC0854b) {
        return (interfaceC0854b == null || interfaceC0854b.name().length() == 0) ? o.J(str) : o.K(str);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1154d c1154d) {
        Method method = c1154d.f22731b;
        if (method != null && this.f22731b != null && method.isBridge() && !this.f22731b.isBridge() && c1154d.f22731b.getName().equals(this.f22731b.getName())) {
            return 1;
        }
        int i5 = this.f22733d;
        int i6 = c1154d.f22733d;
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        int iCompareTo = this.f22730a.compareTo(c1154d.f22730a);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        Class<?> clsJ = j();
        Class<?> clsJ2 = c1154d.j();
        if (clsJ != null && clsJ2 != null && clsJ != clsJ2) {
            if (clsJ.isAssignableFrom(clsJ2)) {
                return -1;
            }
            if (clsJ2.isAssignableFrom(clsJ)) {
                return 1;
            }
        }
        Field field = this.f22732c;
        boolean z5 = false;
        boolean z6 = field != null && field.getType() == this.f22734e;
        Field field2 = c1154d.f22732c;
        if (field2 != null && field2.getType() == c1154d.f22734e) {
            z5 = true;
        }
        if (z6 && !z5) {
            return 1;
        }
        if (z5 && !z6) {
            return -1;
        }
        if (c1154d.f22734e.isPrimitive() && !this.f22734e.isPrimitive()) {
            return 1;
        }
        if (this.f22734e.isPrimitive() && !c1154d.f22734e.isPrimitive()) {
            return -1;
        }
        if (c1154d.f22734e.getName().startsWith("java.") && !this.f22734e.getName().startsWith("java.")) {
            return 1;
        }
        if (!this.f22734e.getName().startsWith("java.") || c1154d.f22734e.getName().startsWith("java.")) {
            return this.f22734e.getName().compareTo(c1154d.f22734e.getName());
        }
        return -1;
    }

    protected char[] d() {
        int length = this.f22730a.length();
        char[] cArr = new char[length + 3];
        String str = this.f22730a;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
        return cArr;
    }

    public Object e(Object obj) {
        Method method = this.f22731b;
        return method != null ? method.invoke(obj, null) : this.f22732c.get(obj);
    }

    public InterfaceC0854b g() {
        InterfaceC0854b interfaceC0854b = this.f22741l;
        return interfaceC0854b != null ? interfaceC0854b : this.f22742m;
    }

    protected Class<?> j() {
        Method method = this.f22731b;
        if (method != null) {
            return method.getDeclaringClass();
        }
        Field field = this.f22732c;
        if (field != null) {
            return field.getDeclaringClass();
        }
        return null;
    }

    public String m() {
        return this.f22749t;
    }

    public Member o() {
        Method method = this.f22731b;
        return method != null ? method : this.f22732c;
    }

    public void q(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f22731b;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.f22732c.set(obj, obj2);
        }
    }

    public void r() {
        Method method = this.f22731b;
        if (method != null) {
            o.L0(method);
        } else {
            o.L0(this.f22732c);
        }
    }

    public String toString() {
        return this.f22730a;
    }

    public C1154d(String str, Method method, Field field, Class<?> cls, Type type, int i5, int i6, int i7, InterfaceC0854b interfaceC0854b, InterfaceC0854b interfaceC0854b2, String str2) {
        this(str, method, field, cls, type, i5, i6, i7, interfaceC0854b, interfaceC0854b2, str2, null);
    }

    public C1154d(String str, Method method, Field field, Class<?> cls, Type type, int i5, int i6, int i7, InterfaceC0854b interfaceC0854b, InterfaceC0854b interfaceC0854b2, String str2, Map<TypeVariable, Type> map) {
        boolean zJsonDirect;
        boolean zIsFinal;
        Class<?> cls2;
        Type type2;
        Type typeN;
        Class<?> cls3;
        Class<?> cls4;
        Type genericReturnType;
        Class<?> returnType;
        Type type3;
        boolean z5 = false;
        this.f22733d = 0;
        if (field != null) {
            String name = field.getName();
            if (name.equals(str)) {
                str = name;
            }
        }
        i5 = i5 < 0 ? 0 : i5;
        this.f22730a = str;
        this.f22731b = method;
        this.f22732c = field;
        this.f22733d = i5;
        this.f22738i = i6;
        this.f22739j = i7;
        this.f22741l = interfaceC0854b;
        this.f22742m = interfaceC0854b2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.f22743n = (modifiers & 1) != 0 || method == null;
            this.f22744o = Modifier.isTransient(modifiers) || o.x0(method);
        } else {
            this.f22743n = false;
            this.f22744o = o.x0(method);
        }
        if (str2 != null && str2.length() > 0) {
            this.f22740k = str2;
        } else {
            this.f22740k = BuildConfig.FLAVOR;
        }
        InterfaceC0854b interfaceC0854bG = g();
        this.f22751v = p(str, interfaceC0854bG);
        if (interfaceC0854bG != null) {
            String str3 = interfaceC0854bG.format();
            str = str3.trim().length() != 0 ? str3 : null;
            zJsonDirect = interfaceC0854bG.jsonDirect();
            this.f22748s = interfaceC0854bG.unwrapped();
            this.f22750u = interfaceC0854bG.alternateNames();
        } else {
            this.f22748s = false;
            this.f22750u = new String[0];
            zJsonDirect = false;
        }
        this.f22749t = str;
        this.f22745p = d();
        if (method != null) {
            o.L0(method);
        }
        if (field != null) {
            o.L0(field);
        }
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                cls4 = parameterTypes[0];
                type3 = method.getGenericParameterTypes()[0];
            } else if (parameterTypes.length == 2 && (cls3 = parameterTypes[0]) == String.class && parameterTypes[1] == Object.class) {
                cls4 = cls3;
                type3 = cls3;
            } else {
                zIsFinal = true;
                returnType = method.getReturnType();
                genericReturnType = method.getGenericReturnType();
                this.f22736g = method.getDeclaringClass();
                cls2 = returnType;
                type2 = genericReturnType;
            }
            zIsFinal = false;
            returnType = cls4;
            genericReturnType = type3;
            this.f22736g = method.getDeclaringClass();
            cls2 = returnType;
            type2 = genericReturnType;
        } else {
            Class<?> type4 = field.getType();
            Type genericType = field.getGenericType();
            this.f22736g = field.getDeclaringClass();
            zIsFinal = Modifier.isFinal(field.getModifiers());
            cls2 = type4;
            type2 = genericType;
        }
        this.f22737h = zIsFinal;
        if (zJsonDirect && cls2 == String.class) {
            z5 = true;
        }
        this.f22747r = z5;
        if (cls != null && cls2 == Object.class && (type2 instanceof TypeVariable) && (typeN = n(cls, type, (TypeVariable) type2)) != null) {
            this.f22734e = o.P(typeN);
            this.f22735f = typeN;
            this.f22746q = cls2.isEnum();
            return;
        }
        boolean z6 = type2 instanceof Class;
        Class<?> cls5 = cls2;
        Type type5 = type2;
        if (!z6) {
            Type typeL = l(cls, type == null ? cls : type, type2, map);
            Class<?> clsP = cls2;
            if (typeL != type2) {
                if (typeL instanceof ParameterizedType) {
                    clsP = o.P(typeL);
                } else {
                    clsP = cls2;
                    if (typeL instanceof Class) {
                        clsP = o.P(typeL);
                    }
                }
            }
            type5 = typeL;
            cls5 = clsP;
        }
        this.f22735f = type5;
        this.f22734e = cls5;
        this.f22746q = cls5.isEnum();
    }
}
