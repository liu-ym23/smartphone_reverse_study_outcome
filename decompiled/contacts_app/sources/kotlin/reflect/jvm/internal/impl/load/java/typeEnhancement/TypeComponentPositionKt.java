package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypeComponentPosition.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeComponentPositionKt {
    public static final boolean shouldEnhance(TypeComponentPosition r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1 == TypeComponentPosition.INFLEXIBLE) goto L5;
        return true;
    L5:
        return false;
    }
}
