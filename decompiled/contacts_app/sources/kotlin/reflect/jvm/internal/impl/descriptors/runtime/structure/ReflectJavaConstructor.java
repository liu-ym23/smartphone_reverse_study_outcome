package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: ReflectJavaConstructor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectJavaConstructor extends ReflectJavaMember implements JavaConstructor {
    private final Constructor<?> member;

    public ReflectJavaConstructor(Constructor<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "member");
        this.member = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Constructor<?> getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public /* bridge */ /* synthetic */ Member getMember() {
        return getMember();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor
    public List<JavaValueParameter> getValueParameters() {
        Type[] r0 = getMember().getGenericParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r0, GloableSearchConfig.KEY_CONFIGS);
        if (r0.length != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        Class<?> r2 = getMember().getDeclaringClass();
        if (r2.getDeclaringClass() != null) goto L12;
    L14:
        Annotation[][] r3 = getMember().getParameterAnnotations();
        Annotation[][] r4 = r3;
        if (r4.length < r0.length) goto L22;
        if (r4.length <= r0.length) goto L19;
        Intrinsics.checkNotNullExpressionValue(r3, "annotations");
        r3 = (Annotation[][]) ArraysKt.copyOfRange(r4, r4.length - r0.length, r4.length);
    L19:
        Intrinsics.checkNotNullExpressionValue(r0, "realTypes");
        Intrinsics.checkNotNullExpressionValue(r3, "realAnnotations");
        return getValueParameters(r0, r3, getMember().isVarArgs());
    L22:
        throw new IllegalStateException("Illegal generic signature: " + getMember());
    L12:
        if (Modifier.isStatic(r2.getModifiers()) == true) goto L14;
        r0 = (Type[]) ArraysKt.copyOfRange(r0, 1, r0.length);
        goto L14
    L8:
        return CollectionsKt.emptyList();
    L5:
        r1 = false;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Constructor<?>>[] r5 = getMember().getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r5, "member.typeParameters");
        TypeVariable<Constructor<?>>[] r6 = r5;
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
