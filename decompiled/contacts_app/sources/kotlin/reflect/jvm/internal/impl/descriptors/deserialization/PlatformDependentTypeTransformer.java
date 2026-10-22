package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: compiled from: PlatformDependentTypeTransformer.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface PlatformDependentTypeTransformer {

    /* JADX INFO: compiled from: PlatformDependentTypeTransformer.kt */
    public static final class None implements PlatformDependentTypeTransformer {
        public static final None INSTANCE = null;

        static {
            INSTANCE = new None();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer
        public SimpleType transformPlatformType(ClassId r1, SimpleType r2) {
            Intrinsics.checkNotNullParameter(r1, "classId");
            Intrinsics.checkNotNullParameter(r2, "computedType");
            return r2;
        }

        private None() {
        }
    }

    SimpleType transformPlatformType(ClassId r1, SimpleType r2);
}
