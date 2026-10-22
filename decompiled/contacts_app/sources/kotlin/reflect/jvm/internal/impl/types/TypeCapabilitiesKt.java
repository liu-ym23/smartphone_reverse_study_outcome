package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypeCapabilities.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeCapabilitiesKt {
    public static final boolean isCustomTypeParameter(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r2 = r1.unwrap();
        if ((r2 instanceof CustomTypeParameter) == false) goto L5;
        CustomTypeParameter r3 = (CustomTypeParameter) r2;
    L6:
        if (r3 != null) goto L10;
        return false;
    L10:
        return r3.isTypeParameter();
    L5:
        r3 = null;
        goto L6
    }

    public static final CustomTypeParameter getCustomTypeParameter(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r3 = r2.unwrap();
        if ((r3 instanceof CustomTypeParameter) == false) goto L5;
        CustomTypeParameter r4 = (CustomTypeParameter) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        if (r4.isTypeParameter() == true) goto L10;
        return null;
    L10:
        return r4;
    L5:
        r4 = null;
        goto L6
    }
}
