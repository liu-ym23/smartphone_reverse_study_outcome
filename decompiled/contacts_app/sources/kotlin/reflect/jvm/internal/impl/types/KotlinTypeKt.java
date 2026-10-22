package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class KotlinTypeKt {
    public static final boolean isNullable(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return TypeUtils.isNullableType(r1);
    }

    public static final boolean isError(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UnwrappedType r2 = r1.unwrap();
        if ((r2 instanceof ErrorType) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r2 instanceof FlexibleType) == true) goto L7;
    L9:
        return false;
    L7:
        if ((((FlexibleType) r2).getDelegate() instanceof ErrorType) == false) goto L9;
        goto L9
    }
}
