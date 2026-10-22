package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: dynamicTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DynamicTypesKt {
    public static final boolean isDynamic(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.unwrap() instanceof DynamicType;
    }
}
