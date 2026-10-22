package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ListBasedJavaAnnotationOwner extends JavaAnnotationOwner {

    /* JADX INFO: compiled from: javaElements.kt */
    public static final class DefaultImpls {
        public static JavaAnnotation findAnnotation(ListBasedJavaAnnotationOwner r3, FqName r4) {
            Intrinsics.checkNotNullParameter(r4, "fqName");
            Iterator<T> r5 = r3.getAnnotations().iterator();
        L3:
            Object r1 = null;
            if (r5.hasNext() == false) goto L12;
            Object r0 = r5.next();
            ClassId r2 = ((JavaAnnotation) r0).getClassId();
            if (r2 == null) goto L9;
            r1 = r2.asSingleFqName();
        L9:
            if (Intrinsics.areEqual(r1, r4) == false) goto L3;
            r1 = r0;
        L12:
            return (JavaAnnotation) r1;
        }
    }
}
