package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;

/* JADX INFO: compiled from: PlatformDependentDeclarationFilter.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface PlatformDependentDeclarationFilter {

    /* JADX INFO: compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class All implements PlatformDependentDeclarationFilter {
        public static final All INSTANCE = null;

        static {
            INSTANCE = new All();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(ClassDescriptor r1, SimpleFunctionDescriptor r2) {
            Intrinsics.checkNotNullParameter(r1, "classDescriptor");
            Intrinsics.checkNotNullParameter(r2, "functionDescriptor");
            return true;
        }

        private All() {
        }
    }

    /* JADX INFO: compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class NoPlatformDependent implements PlatformDependentDeclarationFilter {
        public static final NoPlatformDependent INSTANCE = null;

        static {
            INSTANCE = new NoPlatformDependent();
        }

        private NoPlatformDependent() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(ClassDescriptor r1, SimpleFunctionDescriptor r2) {
            Intrinsics.checkNotNullParameter(r1, "classDescriptor");
            Intrinsics.checkNotNullParameter(r2, "functionDescriptor");
            return !r2.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME());
        }
    }

    boolean isFunctionAvailable(ClassDescriptor r1, SimpleFunctionDescriptor r2);
}
