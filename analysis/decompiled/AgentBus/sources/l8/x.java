package l8;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class x extends w implements v8.e {

    /* renamed from: a, reason: collision with root package name */
    public final Method f5886a;

    public x(Method method) {
        q7.k.e(method, "member");
        this.f5886a = method;
    }

    @Override // l8.w
    public final Member b() {
        return this.f5886a;
    }

    public final b0 f() {
        Type genericReturnType = this.f5886a.getGenericReturnType();
        q7.k.d(genericReturnType, "member.genericReturnType");
        boolean z4 = genericReturnType instanceof Class;
        if (z4) {
            Class cls = (Class) genericReturnType;
            if (cls.isPrimitive()) {
                return new z(cls);
            }
        }
        return ((genericReturnType instanceof GenericArrayType) || (z4 && ((Class) genericReturnType).isArray())) ? new i(genericReturnType) : genericReturnType instanceof WildcardType ? new e0((WildcardType) genericReturnType) : new q(genericReturnType);
    }

    public final List g() {
        Method method = this.f5886a;
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        q7.k.d(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        q7.k.d(parameterAnnotations, "member.parameterAnnotations");
        return d(genericParameterTypes, parameterAnnotations, method.isVarArgs());
    }

    @Override // v8.e
    public final ArrayList getTypeParameters() {
        TypeVariable<Method>[] typeParameters = this.f5886a.getTypeParameters();
        q7.k.d(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new c0(typeVariable));
        }
        return arrayList;
    }
}
