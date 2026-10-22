package n8;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import x8.InterfaceC2122e;

/* loaded from: classes4.dex */
public final class q extends p implements InterfaceC2122e {

    /* renamed from: a, reason: collision with root package name */
    public final Method f5362a;

    public q(Method member) {
        kotlin.jvm.internal.k.f(member, "member");
        this.f5362a = member;
    }

    @Override // n8.p
    public final Member b() {
        return this.f5362a;
    }

    public final u f() {
        Type genericReturnType = this.f5362a.getGenericReturnType();
        kotlin.jvm.internal.k.e(genericReturnType, "getGenericReturnType(...)");
        boolean z10 = genericReturnType instanceof Class;
        if (z10) {
            Class cls = (Class) genericReturnType;
            if (cls.isPrimitive()) {
                return new s(cls);
            }
        }
        return ((genericReturnType instanceof GenericArrayType) || (z10 && ((Class) genericReturnType).isArray())) ? new h(genericReturnType) : genericReturnType instanceof WildcardType ? new x((WildcardType) genericReturnType) : new j(genericReturnType);
    }

    public final List g() {
        Method method = this.f5362a;
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        kotlin.jvm.internal.k.e(genericParameterTypes, "getGenericParameterTypes(...)");
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        kotlin.jvm.internal.k.e(parameterAnnotations, "getParameterAnnotations(...)");
        return d(genericParameterTypes, parameterAnnotations, method.isVarArgs());
    }

    @Override // x8.InterfaceC2122e
    public final ArrayList getTypeParameters() {
        TypeVariable<Method>[] typeParameters = this.f5362a.getTypeParameters();
        kotlin.jvm.internal.k.e(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new v(typeVariable));
        }
        return arrayList;
    }
}
