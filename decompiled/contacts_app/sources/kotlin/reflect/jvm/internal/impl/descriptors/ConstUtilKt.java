package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* JADX INFO: compiled from: ConstUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ConstUtilKt {
    public static final boolean canBeUsedForConstVal(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (KotlinBuiltIns.isPrimitiveType(r1) == true) goto L7;
        if (UnsignedTypes.isUnsignedType(r1) == true) goto L7;
    L9:
        if (KotlinBuiltIns.isString(r1) == true) goto L12;
        return false;
    L12:
        return true;
    L7:
        if (TypeUtils.isNullableType(r1) == false) goto L12;
        goto L12
    }
}
