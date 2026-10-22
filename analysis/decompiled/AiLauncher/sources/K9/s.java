package K9;

import Z8.C1168p;
import Z8.C1173v;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class s extends x implements Z9.k {

    /* renamed from: a, reason: collision with root package name */
    public final Constructor<?> f4190a;

    public s(Constructor<?> member) {
        kotlin.jvm.internal.p.i(member, "member");
        this.f4190a = member;
    }

    @Override // K9.x
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public Constructor<?> N() {
        return this.f4190a;
    }

    @Override // Z9.z
    public List<E> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = N().getTypeParameters();
        kotlin.jvm.internal.p.h(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new E(typeVariable));
        }
        return arrayList;
    }

    @Override // Z9.k
    public List<Z9.B> i() {
        Type[] genericParameterTypes = N().getGenericParameterTypes();
        kotlin.jvm.internal.p.f(genericParameterTypes);
        if (genericParameterTypes.length == 0) {
            return C1173v.m();
        }
        Class<?> declaringClass = N().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) C1168p.q(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = N().getParameterAnnotations();
        if (parameterAnnotations.length < genericParameterTypes.length) {
            throw new IllegalStateException("Illegal generic signature: " + N());
        }
        if (parameterAnnotations.length > genericParameterTypes.length) {
            kotlin.jvm.internal.p.f(parameterAnnotations);
            parameterAnnotations = (Annotation[][]) C1168p.q(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
        }
        kotlin.jvm.internal.p.f(genericParameterTypes);
        kotlin.jvm.internal.p.f(parameterAnnotations);
        return O(genericParameterTypes, parameterAnnotations, N().isVarArgs());
    }
}
