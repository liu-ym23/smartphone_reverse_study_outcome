package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: compiled from: TypeAttributes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeAttributesKt {
    public static final TypeAttributes toDefaultAttributes(Annotations r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        return TypeAttributeTranslator.DefaultImpls.toAttributes$default(DefaultTypeAttributeTranslator.INSTANCE, r7, null, null, 6, null);
    }

    public static final TypeAttributes replaceAnnotations(TypeAttributes r1, Annotations r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "newAnnotations");
        if (AnnotationsTypeAttributeKt.getAnnotations(r1) != r2) goto L5;
        return r1;
    L5:
        AnnotationsTypeAttribute r0 = AnnotationsTypeAttributeKt.getAnnotationsAttribute(r1);
        if (r0 == null) goto L12;
        TypeAttributes r3 = r1.remove(r0);
        if (r3 == null) goto L12;
        r1 = r3;
    L12:
        if (r2.iterator().hasNext() == true) goto L17;
        if (r2.isEmpty() == false) goto L17;
        return r1;
    L17:
        return r1.plus(new AnnotationsTypeAttribute(r2));
    }
}
