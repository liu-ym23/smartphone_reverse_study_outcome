package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* JADX INFO: compiled from: ReflectJavaMethod.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectJavaMethod extends ReflectJavaMember implements JavaMethod {
    private final Method member;

    public ReflectJavaMethod(Method r2) {
        Intrinsics.checkNotNullParameter(r2, "member");
        this.member = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public boolean getHasAnnotationParameterDefaultValue() {
        return JavaMethod.DefaultImpls.getHasAnnotationParameterDefaultValue(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public /* bridge */ /* synthetic */ Member getMember() {
        return getMember();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Method getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public /* bridge */ /* synthetic */ JavaType getReturnType() {
        return getReturnType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public List<JavaValueParameter> getValueParameters() {
        Type[] r0 = getMember().getGenericParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r0, "member.genericParameterTypes");
        Annotation[][] r1 = getMember().getParameterAnnotations();
        Intrinsics.checkNotNullExpressionValue(r1, "member.parameterAnnotations");
        return getValueParameters(r0, r1, getMember().isVarArgs());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public ReflectJavaType getReturnType() {
        ReflectJavaType.Factory r0 = ReflectJavaType.Factory;
        Type r2 = getMember().getGenericReturnType();
        Intrinsics.checkNotNullExpressionValue(r2, "member.genericReturnType");
        return r0.create(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public JavaAnnotationArgument getAnnotationParameterDefaultValue() {
        Object r2 = getMember().getDefaultValue();
        ReflectJavaAnnotationArgument r0 = null;
        if (r2 == null) goto L6;
        r0 = ReflectJavaAnnotationArgument.Factory.create(r2, null);
    L6:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Method>[] r5 = getMember().getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r5, "member.typeParameters");
        TypeVariable<Method>[] r6 = r5;
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(new ReflectJavaTypeParameter(r6[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return r0;
    }
}
