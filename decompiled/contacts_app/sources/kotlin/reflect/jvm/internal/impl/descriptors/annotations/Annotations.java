package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface Annotations extends Iterable<AnnotationDescriptor>, KMappedMarker {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Annotations EMPTY = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            EMPTY = new Annotations$Companion$EMPTY$1();
        }

        public final Annotations getEMPTY() {
            return EMPTY;
        }

        public final Annotations create(List<? extends AnnotationDescriptor> r1) {
            Intrinsics.checkNotNullParameter(r1, "annotations");
            if (r1.isEmpty() == false) goto L6;
            return EMPTY;
        L6:
            return new AnnotationsImpl(r1);
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class DefaultImpls {
        public static AnnotationDescriptor findAnnotation(Annotations r2, FqName r3) {
            Intrinsics.checkNotNullParameter(r3, "fqName");
            Iterator<AnnotationDescriptor> r4 = r2.iterator();
        L4:
            if (r4.hasNext() == false) goto L8;
            AnnotationDescriptor r0 = r4.next();
            if (Intrinsics.areEqual(r0.getFqName(), r3) == false) goto L4;
        L10:
            return r0;
        L8:
            r0 = null;
            goto L10
        }

        public static boolean hasAnnotation(Annotations r1, FqName r2) {
            Intrinsics.checkNotNullParameter(r2, "fqName");
            if (r1.mo2078findAnnotation(r2) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    /* JADX INFO: renamed from: findAnnotation */
    AnnotationDescriptor mo2078findAnnotation(FqName r1);

    boolean hasAnnotation(FqName r1);

    boolean isEmpty();
}
