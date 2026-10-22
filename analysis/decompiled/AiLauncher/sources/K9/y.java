package K9;

import K9.D;
import Z9.InterfaceC1179b;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class y extends x implements Z9.r {

    /* renamed from: a, reason: collision with root package name */
    public final Method f4194a;

    public y(Method member) {
        kotlin.jvm.internal.p.i(member, "member");
        this.f4194a = member;
    }

    @Override // Z9.r
    public boolean J() {
        return p() != null;
    }

    @Override // K9.x
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public Method N() {
        return this.f4194a;
    }

    @Override // Z9.r
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public D getReturnType() {
        D.a aVar = D.f4146a;
        Type genericReturnType = N().getGenericReturnType();
        kotlin.jvm.internal.p.h(genericReturnType, "getGenericReturnType(...)");
        return aVar.a(genericReturnType);
    }

    @Override // Z9.z
    public List<E> getTypeParameters() {
        TypeVariable<Method>[] typeParameters = N().getTypeParameters();
        kotlin.jvm.internal.p.h(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new E(typeVariable));
        }
        return arrayList;
    }

    @Override // Z9.r
    public List<Z9.B> i() {
        Type[] genericParameterTypes = N().getGenericParameterTypes();
        kotlin.jvm.internal.p.h(genericParameterTypes, "getGenericParameterTypes(...)");
        Annotation[][] parameterAnnotations = N().getParameterAnnotations();
        kotlin.jvm.internal.p.h(parameterAnnotations, "getParameterAnnotations(...)");
        return O(genericParameterTypes, parameterAnnotations, N().isVarArgs());
    }

    @Override // Z9.r
    public InterfaceC1179b p() {
        Object defaultValue = N().getDefaultValue();
        if (defaultValue != null) {
            return h.f4176b.a(defaultValue, null);
        }
        return null;
    }
}
