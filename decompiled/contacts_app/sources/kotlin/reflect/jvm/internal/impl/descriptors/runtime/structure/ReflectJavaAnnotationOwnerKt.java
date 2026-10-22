package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectJavaAnnotationOwnerKt {
    public static final List<ReflectJavaAnnotation> getAnnotations(Annotation[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(new ReflectJavaAnnotation(r5[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return r0;
    }

    public static final ReflectJavaAnnotation findAnnotation(Annotation[] r5, FqName r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "fqName");
        int r0 = r5.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        Annotation r3 = r5[r1];
        if (Intrinsics.areEqual(ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r3))).asSingleFqName(), r6) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r3 != null) goto L12;
        return null;
    L12:
        return new ReflectJavaAnnotation(r3);
    L9:
        r3 = null;
        goto L10
    }
}
