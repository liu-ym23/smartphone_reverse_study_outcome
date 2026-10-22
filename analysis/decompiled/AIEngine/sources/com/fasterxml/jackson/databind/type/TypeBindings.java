package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class TypeBindings implements Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f4451e;
    public static final JavaType[] h;

    /* renamed from: j, reason: collision with root package name */
    public static final TypeBindings f4452j;

    /* renamed from: a, reason: collision with root package name */
    public final String[] f4453a;

    /* renamed from: b, reason: collision with root package name */
    public final JavaType[] f4454b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f4455c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4456d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f4457a;

        /* renamed from: b, reason: collision with root package name */
        public final JavaType[] f4458b;

        /* renamed from: c, reason: collision with root package name */
        public final int f4459c;

        public a(Class<?> cls, JavaType[] javaTypeArr, int i10) {
            this.f4457a = cls;
            this.f4458b = javaTypeArr;
            this.f4459c = i10;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f4459c == aVar.f4459c && this.f4457a == aVar.f4457a) {
                JavaType[] javaTypeArr = aVar.f4458b;
                JavaType[] javaTypeArr2 = this.f4458b;
                int length = javaTypeArr2.length;
                if (length == javaTypeArr.length) {
                    for (int i10 = 0; i10 < length; i10++) {
                        if (!javaTypeArr2[i10].equals(javaTypeArr[i10])) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.f4459c;
        }

        public final String toString() {
            return this.f4457a.getName().concat("<>");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final TypeVariable<?>[] f4460a = AbstractList.class.getTypeParameters();

        /* renamed from: b, reason: collision with root package name */
        public static final TypeVariable<?>[] f4461b = Collection.class.getTypeParameters();

        /* renamed from: c, reason: collision with root package name */
        public static final TypeVariable<?>[] f4462c = Iterable.class.getTypeParameters();

        /* renamed from: d, reason: collision with root package name */
        public static final TypeVariable<?>[] f4463d = List.class.getTypeParameters();

        /* renamed from: e, reason: collision with root package name */
        public static final TypeVariable<?>[] f4464e = ArrayList.class.getTypeParameters();

        /* renamed from: f, reason: collision with root package name */
        public static final TypeVariable<?>[] f4465f = Map.class.getTypeParameters();

        /* renamed from: g, reason: collision with root package name */
        public static final TypeVariable<?>[] f4466g = HashMap.class.getTypeParameters();
        public static final TypeVariable<?>[] h = LinkedHashMap.class.getTypeParameters();
    }

    static {
        String[] strArr = new String[0];
        f4451e = strArr;
        JavaType[] javaTypeArr = new JavaType[0];
        h = javaTypeArr;
        f4452j = new TypeBindings(strArr, javaTypeArr, null);
    }

    public TypeBindings(String[] strArr, JavaType[] javaTypeArr, String[] strArr2) {
        strArr = strArr == null ? f4451e : strArr;
        this.f4453a = strArr;
        javaTypeArr = javaTypeArr == null ? h : javaTypeArr;
        this.f4454b = javaTypeArr;
        if (strArr.length != javaTypeArr.length) {
            StringBuilder sb2 = new StringBuilder("Mismatching names (");
            sb2.append(strArr.length);
            sb2.append("), types (");
            throw new IllegalArgumentException(ai.onnxruntime.a.j(")", javaTypeArr.length, sb2));
        }
        int length = javaTypeArr.length;
        int i10 = 1;
        for (int i11 = 0; i11 < length; i11++) {
            i10 += this.f4454b[i11].f3691b;
        }
        this.f4455c = strArr2;
        this.f4456d = i10;
    }

    public static TypeBindings a(JavaType javaType, Class cls) {
        TypeVariable<?>[] typeParameters;
        if (cls == Collection.class) {
            typeParameters = b.f4461b;
        } else if (cls == List.class) {
            typeParameters = b.f4463d;
        } else if (cls == ArrayList.class) {
            typeParameters = b.f4464e;
        } else if (cls == AbstractList.class) {
            typeParameters = b.f4460a;
        } else if (cls == Iterable.class) {
            typeParameters = b.f4462c;
        } else {
            TypeVariable<?>[] typeVariableArr = b.f4460a;
            typeParameters = cls.getTypeParameters();
        }
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 1) {
            return new TypeBindings(new String[]{typeParameters[0].getName()}, new JavaType[]{javaType}, null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 1 type parameter: class expects " + length);
    }

    public static TypeBindings b(Class<?> cls, JavaType javaType, JavaType javaType2) {
        TypeVariable[] typeParameters;
        if (cls == Map.class) {
            typeParameters = b.f4465f;
        } else if (cls == HashMap.class) {
            typeParameters = b.f4466g;
        } else if (cls == LinkedHashMap.class) {
            typeParameters = b.h;
        } else {
            TypeVariable<?>[] typeVariableArr = b.f4460a;
            typeParameters = cls.getTypeParameters();
        }
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 2) {
            return new TypeBindings(new String[]{typeParameters[0].getName(), typeParameters[1].getName()}, new JavaType[]{javaType, javaType2}, null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 2 type parameters: class expects " + length);
    }

    public static TypeBindings c(Class<?> cls, JavaType[] javaTypeArr) {
        String[] strArr;
        if (javaTypeArr == null) {
            javaTypeArr = h;
        } else {
            int length = javaTypeArr.length;
            if (length == 1) {
                return a(javaTypeArr[0], cls);
            }
            if (length == 2) {
                return b(cls, javaTypeArr[0], javaTypeArr[1]);
            }
        }
        TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            strArr = f4451e;
        } else {
            int length2 = typeParameters.length;
            strArr = new String[length2];
            for (int i10 = 0; i10 < length2; i10++) {
                strArr[i10] = typeParameters[i10].getName();
            }
        }
        if (strArr.length == javaTypeArr.length) {
            return new TypeBindings(strArr, javaTypeArr, null);
        }
        StringBuilder sb2 = new StringBuilder("Cannot create TypeBindings for class ");
        sb2.append(cls.getName());
        sb2.append(" with ");
        sb2.append(javaTypeArr.length);
        sb2.append(" type parameter");
        sb2.append(javaTypeArr.length == 1 ? "" : "s");
        sb2.append(": class expects ");
        sb2.append(strArr.length);
        throw new IllegalArgumentException(sb2.toString());
    }

    public final JavaType d(int i10) {
        if (i10 < 0) {
            return null;
        }
        JavaType[] javaTypeArr = this.f4454b;
        if (i10 >= javaTypeArr.length) {
            return null;
        }
        return javaTypeArr[i10];
    }

    public final List<JavaType> e() {
        JavaType[] javaTypeArr = this.f4454b;
        return javaTypeArr.length == 0 ? Collections.EMPTY_LIST : Arrays.asList(javaTypeArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!com.fasterxml.jackson.databind.util.a.s(getClass(), obj)) {
            return false;
        }
        JavaType[] javaTypeArr = this.f4454b;
        int length = javaTypeArr.length;
        JavaType[] javaTypeArr2 = ((TypeBindings) obj).f4454b;
        if (length != javaTypeArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (!javaTypeArr2[i10].equals(javaTypeArr[i10])) {
                return false;
            }
        }
        return true;
    }

    public final boolean f() {
        return this.f4454b.length == 0;
    }

    public final int hashCode() {
        return this.f4456d;
    }

    public Object readResolve() {
        String[] strArr = this.f4453a;
        return (strArr == null || strArr.length == 0) ? f4452j : this;
    }

    public final String toString() {
        JavaType[] javaTypeArr = this.f4454b;
        if (javaTypeArr.length == 0) {
            return "<>";
        }
        StringBuilder sb2 = new StringBuilder("<");
        int length = javaTypeArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 > 0) {
                sb2.append(',');
            }
            JavaType javaType = javaTypeArr[i10];
            StringBuilder sb3 = new StringBuilder(40);
            javaType.m(sb3);
            sb2.append(sb3.toString());
        }
        sb2.append('>');
        return sb2.toString();
    }
}
