package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: javaLoading.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaLoadingKt {
    public static final boolean isObjectMethodInInterface(JavaMember r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getContainingClass().isInterface() == true) goto L5;
    L9:
        return false;
    L5:
        if ((r1 instanceof JavaMethod) == false) goto L9;
        if (isObjectMethod((JavaMethod) r1) == false) goto L9;
        return true;
    }

    private static final boolean isObjectMethod(JavaMethod r3) {
        String r0 = r3.getName().asString();
        int r1 = r0.hashCode();
        if (r1 == (-1776922004)) goto L17;
        if (r1 == (-1295482945)) goto L13;
        if (r1 == 147696667) goto L10;
    L19:
        return false;
    L10:
        if (r0.equals("hashCode") == false) goto L19;
    L22:
        return r3.getValueParameters().isEmpty();
    L13:
        if (r0.equals("equals") == false) goto L19;
        return isMethodWithOneObjectParameter(r3);
    L17:
        if (r0.equals("toString") == false) goto L19;
        goto L19
    }

    private static final boolean isMethodWithOneObjectParameter(JavaMethod r2) {
        JavaValueParameter r3 = (JavaValueParameter) CollectionsKt.singleOrNull(r2.getValueParameters());
        JavaClassifierType r0 = null;
        if (r3 == null) goto L5;
        JavaType r4 = r3.getType();
    L7:
        if ((r4 instanceof JavaClassifierType) == false) goto L10;
        r0 = (JavaClassifierType) r4;
    L10:
        if (r0 != null) goto L12;
        return false;
    L12:
        JavaClassifier r1 = r0.getClassifier();
        if ((r1 instanceof JavaClass) == false) goto L20;
        FqName r5 = ((JavaClass) r1).getFqName();
        if (r5 != null) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r5.asString(), "java.lang.Object") == false) goto L22;
        return true;
    L22:
        return false;
    L20:
        return false;
    L5:
        r4 = null;
        goto L7
    }
}
