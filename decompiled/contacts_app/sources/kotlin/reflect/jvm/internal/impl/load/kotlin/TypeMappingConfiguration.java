package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface TypeMappingConfiguration<T> {

    /* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
    public static final class DefaultImpls {
        public static <T> String getPredefinedFullInternalNameForClass(TypeMappingConfiguration<? extends T> r0, ClassDescriptor r1) {
            Intrinsics.checkNotNullParameter(r1, "classDescriptor");
            return null;
        }

        public static <T> KotlinType preprocessType(TypeMappingConfiguration<? extends T> r0, KotlinType r1) {
            Intrinsics.checkNotNullParameter(r1, "kotlinType");
            return null;
        }
    }

    KotlinType commonSupertype(Collection<KotlinType> r1);

    String getPredefinedFullInternalNameForClass(ClassDescriptor r1);

    String getPredefinedInternalNameForClass(ClassDescriptor r1);

    T getPredefinedTypeForClass(ClassDescriptor r1);

    KotlinType preprocessType(KotlinType r1);

    void processErrorType(KotlinType r1, ClassDescriptor r2);
}
