package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnnotationsKt {
    public static final Annotations composeAnnotations(Annotations r3, Annotations r4) {
        Intrinsics.checkNotNullParameter(r3, "first");
        Intrinsics.checkNotNullParameter(r4, "second");
        if (r3.isEmpty() == false) goto L6;
        return r4;
    L6:
        if (r4.isEmpty() == false) goto L9;
        return r3;
    L9:
        return new CompositeAnnotations(new Annotations[]{r3, r4});
    }
}
