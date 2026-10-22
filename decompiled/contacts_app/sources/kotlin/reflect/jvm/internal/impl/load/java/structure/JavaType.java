package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: javaTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface JavaType extends ListBasedJavaAnnotationOwner {

    /* JADX INFO: compiled from: javaTypes.kt */
    public static final class DefaultImpls {
        public static JavaAnnotation findAnnotation(JavaType r1, FqName r2) {
            Intrinsics.checkNotNullParameter(r2, "fqName");
            return ListBasedJavaAnnotationOwner.DefaultImpls.findAnnotation(r1, r2);
        }
    }
}
