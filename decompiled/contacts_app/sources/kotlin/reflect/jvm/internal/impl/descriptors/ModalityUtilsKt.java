package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModalityUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ModalityUtilsKt {
    public static final boolean isFinalClass(ClassDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getModality() == Modality.FINAL) goto L5;
    L7:
        return false;
    L5:
        if (r2.getKind() == ClassKind.ENUM_CLASS) goto L7;
        return true;
    }
}
