package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: compiled from: KotlinClassFinder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class KotlinClassFinderKt {
    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder r1, ClassId r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "classId");
        KotlinClassFinder.Result r3 = r1.findKotlinClassOrContent(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.toKotlinJvmBinaryClass();
    }

    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder r1, JavaClass r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "javaClass");
        KotlinClassFinder.Result r3 = r1.findKotlinClassOrContent(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.toKotlinJvmBinaryClass();
    }
}
