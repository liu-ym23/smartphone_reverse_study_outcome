package L1;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes.dex */
public class a implements Comparable<a> {

    /* renamed from: a, reason: collision with root package name */
    public final String f4261a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f4262b;

    /* renamed from: c, reason: collision with root package name */
    public final Field f4263c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4264d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4265e;

    /* renamed from: f, reason: collision with root package name */
    public int f4266f;

    /* renamed from: g, reason: collision with root package name */
    public final Class<?> f4267g;

    /* renamed from: h, reason: collision with root package name */
    public final Type f4268h;

    /* renamed from: i, reason: collision with root package name */
    public final Class<?> f4269i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f4270j;

    /* renamed from: k, reason: collision with root package name */
    public final H1.b f4271k;

    /* renamed from: l, reason: collision with root package name */
    public final H1.b f4272l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f4273m;

    /* renamed from: n, reason: collision with root package name */
    public final String f4274n;

    /* renamed from: o, reason: collision with root package name */
    public final long f4275o;

    /* renamed from: p, reason: collision with root package name */
    public final String[] f4276p;

    public a(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i10, int i11) {
        this.f4261a = str;
        this.f4269i = cls;
        this.f4267g = cls2;
        this.f4268h = type;
        this.f4262b = null;
        this.f4263c = field;
        this.f4266f = i10;
        this.f4273m = cls2.isEnum() && !G1.b.class.isAssignableFrom(cls2);
        this.f4271k = null;
        this.f4272l = null;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.f4264d = true;
            this.f4265e = Modifier.isTransient(modifiers);
        } else {
            this.f4264d = false;
            this.f4265e = false;
        }
        this.f4270j = false;
        long jCharAt = -2128831035;
        for (int i12 = 0; i12 < str.length(); i12++) {
            jCharAt = (jCharAt ^ str.charAt(i12)) * 16777619;
        }
        this.f4275o = jCharAt;
        this.f4274n = null;
        this.f4276p = new String[0];
    }

    public static Type i(Class<?> cls, Type type, Type type2) {
        TypeVariable<Class<? super Object>>[] typeParameters;
        ParameterizedType parameterizedType;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type typeI = i(cls, type, genericComponentType);
                return genericComponentType != typeI ? Array.newInstance(d.x(typeI), 0).getClass() : type2;
            }
            if (d.D(type)) {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) d.B(type);
                    Class<?> clsX = d.x(parameterizedType2);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    for (int i10 = 0; i10 < clsX.getTypeParameters().length; i10++) {
                        if (clsX.getTypeParameters()[i10].getName().equals(typeVariable.getName())) {
                            return parameterizedType2.getActualTypeArguments()[i10];
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                    Type[] actualTypeArguments2 = null;
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                        typeParameters = cls.getTypeParameters();
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        typeParameters = cls.getSuperclass().getTypeParameters();
                    } else {
                        typeParameters = null;
                        parameterizedType = null;
                    }
                    boolean z10 = false;
                    for (int i11 = 0; i11 < actualTypeArguments.length && parameterizedType != null; i11++) {
                        Type type3 = actualTypeArguments[i11];
                        if (type3 instanceof TypeVariable) {
                            TypeVariable typeVariable2 = (TypeVariable) type3;
                            for (int i12 = 0; i12 < typeParameters.length; i12++) {
                                if (typeParameters[i12].getName().equals(typeVariable2.getName())) {
                                    if (actualTypeArguments2 == null) {
                                        actualTypeArguments2 = parameterizedType.getActualTypeArguments();
                                    }
                                    actualTypeArguments[i11] = actualTypeArguments2[i12];
                                    z10 = true;
                                }
                            }
                        }
                    }
                    if (z10) {
                        return new c(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                    }
                }
            }
        }
        return type2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        int i10 = this.f4266f;
        int i11 = aVar.f4266f;
        if (i10 < i11) {
            return -1;
        }
        if (i10 > i11) {
            return 1;
        }
        return this.f4261a.compareTo(aVar.f4261a);
    }

    public boolean b(a aVar) {
        return aVar == this || compareTo(aVar) == 0;
    }

    public Object c(Object obj) throws IllegalAccessException, InvocationTargetException {
        return this.f4264d ? this.f4263c.get(obj) : this.f4262b.invoke(obj, null);
    }

    public H1.b e() {
        H1.b bVar = this.f4271k;
        return bVar != null ? bVar : this.f4272l;
    }

    public void j(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.f4262b;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.f4263c.set(obj, obj2);
        }
    }

    public String toString() {
        return this.f4261a;
    }

    public a(String str, Method method, Field field, Class<?> cls, Type type, int i10, int i11, H1.b bVar, H1.b bVar2, boolean z10) {
        String str2;
        Type genericType;
        Class<?> clsX;
        this.f4261a = str;
        this.f4262b = method;
        this.f4263c = field;
        this.f4266f = i10;
        this.f4272l = bVar;
        this.f4271k = bVar2;
        H1.b bVarE = e();
        boolean z11 = false;
        Type type2 = null;
        if (bVarE != null) {
            str2 = bVarE.format();
            str2 = str2.trim().length() == 0 ? null : str2;
            this.f4276p = bVarE.alternateNames();
        } else {
            this.f4276p = new String[0];
            str2 = null;
        }
        this.f4274n = str2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.f4264d = method == null || ((modifiers & 1) != 0 && method.getReturnType() == field.getType());
            this.f4265e = (modifiers & 128) != 0;
        } else {
            this.f4264d = false;
            this.f4265e = false;
        }
        long jCharAt = -2128831035;
        for (int i12 = 0; i12 < str.length(); i12++) {
            jCharAt = (jCharAt ^ str.charAt(i12)) * 16777619;
        }
        this.f4275o = jCharAt;
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                clsX = parameterTypes[0];
                genericType = (clsX == Class.class || clsX == String.class || clsX.isPrimitive() || !z10) ? clsX : method.getGenericParameterTypes()[0];
                this.f4270j = false;
            } else {
                clsX = method.getReturnType();
                genericType = (clsX != Class.class && z10) ? method.getGenericReturnType() : clsX;
                this.f4270j = true;
            }
            this.f4269i = method.getDeclaringClass();
        } else {
            Class<?> type3 = field.getType();
            genericType = (type3.isPrimitive() || type3 == String.class || type3.isEnum() || !z10) ? type3 : field.getGenericType();
            this.f4269i = field.getDeclaringClass();
            this.f4270j = Modifier.isFinal(field.getModifiers());
            clsX = type3;
        }
        if (cls != null && clsX == Object.class && (genericType instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) genericType;
            Type[] actualTypeArguments = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
            for (Class<?> superclass = cls; superclass != null && superclass != Object.class && superclass != this.f4269i; superclass = superclass.getSuperclass()) {
                Type genericSuperclass = superclass.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    d.w(actualTypeArguments2, superclass.getTypeParameters(), actualTypeArguments);
                    actualTypeArguments = actualTypeArguments2;
                }
            }
            if (actualTypeArguments != null) {
                TypeVariable<Class<?>>[] typeParameters = this.f4269i.getTypeParameters();
                int i13 = 0;
                while (true) {
                    if (i13 >= typeParameters.length) {
                        break;
                    }
                    if (typeVariable.equals(typeParameters[i13])) {
                        type2 = actualTypeArguments[i13];
                        break;
                    }
                    i13++;
                }
            }
            if (type2 != null) {
                this.f4267g = d.x(type2);
                this.f4268h = type2;
                if (clsX.isEnum() && !G1.b.class.isAssignableFrom(clsX)) {
                    z11 = true;
                }
                this.f4273m = z11;
                return;
            }
        }
        if (!(genericType instanceof Class)) {
            Type typeI = i(cls, type == null ? cls : type, genericType);
            if (typeI != genericType && ((typeI instanceof ParameterizedType) || (typeI instanceof Class))) {
                clsX = d.x(typeI);
            }
            genericType = typeI;
        }
        this.f4268h = genericType;
        this.f4267g = clsX;
        if (!clsX.isArray() && clsX.isEnum() && !G1.b.class.isAssignableFrom(clsX)) {
            z11 = true;
        }
        this.f4273m = z11;
    }
}
