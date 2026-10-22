package t7;

import androidx.activity.b;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Objects;
import o7.e;
import o7.h;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class a<T> {
    private final int hashCode;
    private final Class<? super T> rawType;
    private final Type type;

    public a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == a.class) {
                Type typeA = h.a(parameterizedType.getActualTypeArguments()[0]);
                if (!Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), "true")) {
                    b(typeA);
                }
                this.type = typeA;
                this.rawType = h.g(typeA);
                this.hashCode = typeA.hashCode();
                return;
            }
        } else if (genericSuperclass == a.class) {
            f.e("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee ".concat("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("type-token-raw")));
            throw null;
        }
        f.e("Must only create direct subclasses of TypeToken");
        throw null;
    }

    public static boolean a(Type type, ParameterizedType parameterizedType, HashMap map) {
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class clsG = h.g(type);
        ParameterizedType parameterizedType2 = type instanceof ParameterizedType ? (ParameterizedType) type : null;
        if (parameterizedType2 != null) {
            Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            TypeVariable<Class<T>>[] typeParameters = clsG.getTypeParameters();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                Type type2 = actualTypeArguments[i];
                TypeVariable<Class<T>> typeVariable = typeParameters[i];
                while (type2 instanceof TypeVariable) {
                    type2 = (Type) map.get(((TypeVariable) type2).getName());
                }
                map.put(typeVariable.getName(), type2);
            }
            if (parameterizedType2.getRawType().equals(parameterizedType.getRawType())) {
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                Type[] actualTypeArguments3 = parameterizedType.getActualTypeArguments();
                for (int i3 = 0; i3 < actualTypeArguments2.length; i3++) {
                    Type type3 = actualTypeArguments2[i3];
                    Type type4 = actualTypeArguments3[i3];
                    if (type4.equals(type3) || ((type3 instanceof TypeVariable) && type4.equals(map.get(((TypeVariable) type3).getName())))) {
                    }
                }
                return true;
            }
        }
        for (Type type5 : clsG.getGenericInterfaces()) {
            if (a(type5, parameterizedType, new HashMap(map))) {
                return true;
            }
        }
        return a(clsG.getGenericSuperclass(), parameterizedType, new HashMap(map));
    }

    public static void b(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            StringBuilder sb2 = new StringBuilder("TypeToken type argument must not contain a type variable; captured type variable ");
            sb2.append(typeVariable.getName());
            sb2.append(" declared by ");
            sb2.append(typeVariable.getGenericDeclaration());
            g5.f.j(sb2, "\nSee ", "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("typetoken-type-variable"));
            return;
        }
        if (type instanceof GenericArrayType) {
            b(((GenericArrayType) type).getGenericComponentType());
            return;
        }
        int i = 0;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType != null) {
                b(ownerType);
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i < length) {
                b(actualTypeArguments[i]);
                i++;
            }
            return;
        }
        if (!(type instanceof WildcardType)) {
            if (type != null) {
                return;
            }
            g5.f.s("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
            return;
        }
        WildcardType wildcardType = (WildcardType) type;
        for (Type type2 : wildcardType.getLowerBounds()) {
            b(type2);
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        int length2 = upperBounds.length;
        while (i < length2) {
            b(upperBounds[i]);
            i++;
        }
    }

    public static a<?> get(Type type) {
        return new a<>(type);
    }

    public static a<?> getArray(Type type) {
        return new a<>(new e(type));
    }

    public static a<?> getParameterized(Type type, Type... typeArr) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(typeArr);
        boolean z10 = type instanceof Class;
        if (!z10) {
            g5.f.p(type, "rawType must be of type Class, but was ");
            return null;
        }
        Class cls = (Class) type;
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        int length = typeParameters.length;
        int length2 = typeArr.length;
        if (length2 != length) {
            throw new IllegalArgumentException(cls.getName() + " requires " + length + " type arguments, but got " + length2);
        }
        if (typeArr.length == 0) {
            return get(cls);
        }
        if (z10) {
            Class cls2 = (Class) type;
            if (!Modifier.isStatic(cls2.getModifiers()) && cls2.getDeclaringClass() != null) {
                g5.f.s(b.m(new StringBuilder("Raw type "), cls, " is not supported because it requires specifying an owner type"));
                return null;
            }
        }
        for (int i = 0; i < length; i++) {
            Type type2 = typeArr[i];
            Objects.requireNonNull(type2, "Type argument must not be null");
            Class<?> clsG = h.g(type2);
            TypeVariable<Class<T>> typeVariable = typeParameters[i];
            for (Type type3 : typeVariable.getBounds()) {
                if (!h.g(type3).isAssignableFrom(clsG)) {
                    throw new IllegalArgumentException("Type argument " + type2 + " does not satisfy bounds for type variable " + typeVariable + " declared by " + type);
                }
            }
        }
        return new a<>(new o7.f(null, cls, typeArr));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && h.d(this.type, ((a) obj).type);
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.reflect.Type] */
    @Deprecated
    public boolean isAssignableFrom(Type type) {
        boolean zA;
        if (type != 0) {
            if (!this.type.equals(type)) {
                Type type2 = this.type;
                if (type2 instanceof Class) {
                    return this.rawType.isAssignableFrom(h.g(type));
                }
                if (type2 instanceof ParameterizedType) {
                    return a(type, (ParameterizedType) type2, new HashMap());
                }
                if (!(type2 instanceof GenericArrayType)) {
                    Class[] clsArr = {Class.class, ParameterizedType.class, GenericArrayType.class};
                    StringBuilder sb2 = new StringBuilder("Unsupported type, expected one of: ");
                    for (int i = 0; i < 3; i++) {
                        sb2.append(clsArr[i].getName());
                        sb2.append(", ");
                    }
                    String name = type2.getClass().getName();
                    sb2.append("but got: ");
                    sb2.append(name);
                    sb2.append(", for type token: ");
                    sb2.append(type2.toString());
                    throw new IllegalArgumentException(sb2.toString());
                }
                if (this.rawType.isAssignableFrom(h.g(type))) {
                    Type genericComponentType = ((GenericArrayType) this.type).getGenericComponentType();
                    if (genericComponentType instanceof ParameterizedType) {
                        if (type instanceof GenericArrayType) {
                            type = ((GenericArrayType) type).getGenericComponentType();
                        } else if (type instanceof Class) {
                            type = (Class) type;
                            while (type.isArray()) {
                                type = type.getComponentType();
                            }
                        }
                        zA = a(type, (ParameterizedType) genericComponentType, new HashMap());
                    } else {
                        zA = true;
                    }
                    if (zA) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final String toString() {
        return h.l(this.type);
    }

    public static <T> a<T> get(Class<T> cls) {
        return new a<>(cls);
    }

    public a(Type type) {
        Objects.requireNonNull(type);
        Type typeA = h.a(type);
        this.type = typeA;
        this.rawType = h.g(typeA);
        this.hashCode = typeA.hashCode();
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    @Deprecated
    public boolean isAssignableFrom(a<?> aVar) {
        return isAssignableFrom(aVar.getType());
    }
}
