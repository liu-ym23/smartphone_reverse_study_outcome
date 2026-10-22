package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* JADX INFO: compiled from: JavaTypeAttributes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaTypeAttributesKt {
    public static /* synthetic */ JavaTypeAttributes toAttributes$default(TypeUsage r1, boolean r2, boolean r3, TypeParameterDescriptor r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = null;
    L12:
        return toAttributes(r1, r2, r3, r4);
    }

    public static final JavaTypeAttributes toAttributes(TypeUsage r10, boolean r11, boolean r12, TypeParameterDescriptor r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r13 == null) goto L5;
        Set r14 = SetsKt.setOf(r13);
    L7:
        return new JavaTypeAttributes(r10, null, r12, r11, r14, null, 34, null);
    L5:
        r14 = null;
        goto L7
    }
}
