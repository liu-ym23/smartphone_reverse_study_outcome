package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ReflectJavaAnnotationOwner extends JavaAnnotationOwner {

    /* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
    public static final class DefaultImpls {
        public static boolean isDeprecatedInJavaDoc(ReflectJavaAnnotationOwner r0) {
            return false;
        }

        public static List<ReflectJavaAnnotation> getAnnotations(ReflectJavaAnnotationOwner r0) {
            AnnotatedElement r1 = r0.getElement();
            if (r1 == null) goto L9;
            Annotation[] r2 = r1.getDeclaredAnnotations();
            if (r2 == null) goto L9;
            List<ReflectJavaAnnotation> r3 = ReflectJavaAnnotationOwnerKt.getAnnotations(r2);
            if (r3 == null) goto L9;
            return r3;
        L9:
            return CollectionsKt.emptyList();
        }

        public static ReflectJavaAnnotation findAnnotation(ReflectJavaAnnotationOwner r1, FqName r2) {
            Intrinsics.checkNotNullParameter(r2, "fqName");
            AnnotatedElement r3 = r1.getElement();
            if (r3 == null) goto L7;
            Annotation[] r4 = r3.getDeclaredAnnotations();
            if (r4 == null) goto L7;
            return ReflectJavaAnnotationOwnerKt.findAnnotation(r4, r2);
        L7:
            return null;
        }
    }

    AnnotatedElement getElement();
}
