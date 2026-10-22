package kotlin.reflect.jvm.internal.impl.types;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: compiled from: TypeAttributeTranslator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DefaultTypeAttributeTranslator implements TypeAttributeTranslator {
    public static final DefaultTypeAttributeTranslator INSTANCE = null;

    static {
        INSTANCE = new DefaultTypeAttributeTranslator();
    }

    private DefaultTypeAttributeTranslator() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator
    public TypeAttributes toAttributes(Annotations r1, TypeConstructor r2, DeclarationDescriptor r3) {
        Intrinsics.checkNotNullParameter(r1, "annotations");
        if (r1.isEmpty() == false) goto L6;
        return TypeAttributes.Companion.getEmpty();
    L6:
        return TypeAttributes.Companion.create(CollectionsKt.listOf(new AnnotationsTypeAttribute(r1)));
    }
}
