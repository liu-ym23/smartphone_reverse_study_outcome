package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;

/* JADX INFO: compiled from: JavaClassDataFinder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaClassDataFinder implements ClassDataFinder {
    private final DeserializedDescriptorResolver deserializedDescriptorResolver;
    private final KotlinClassFinder kotlinClassFinder;

    public JavaClassDataFinder(KotlinClassFinder r2, DeserializedDescriptorResolver r3) {
        Intrinsics.checkNotNullParameter(r2, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(r3, "deserializedDescriptorResolver");
        this.kotlinClassFinder = r2;
        this.deserializedDescriptorResolver = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r3) {
        Intrinsics.checkNotNullParameter(r3, "classId");
        KotlinJvmBinaryClass r0 = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r3);
        if (r0 != null) goto L6;
        return null;
    L6:
        Intrinsics.areEqual(r0.getClassId(), r3);
        return this.deserializedDescriptorResolver.readClassData$descriptors_jvm(r0);
    }
}
