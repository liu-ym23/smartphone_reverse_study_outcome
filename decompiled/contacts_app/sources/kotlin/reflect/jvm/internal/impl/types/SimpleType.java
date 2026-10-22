package kotlin.reflect.jvm.internal.impl.types;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SimpleType extends UnwrappedType implements SimpleTypeMarker, TypeArgumentListMarker {
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public abstract SimpleType makeNullableAsSpecified(boolean r1);

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public abstract SimpleType replaceAttributes(TypeAttributes r1);

    public SimpleType() {
        super(null);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Iterator<AnnotationDescriptor> r1 = getAnnotations().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        StringsKt.append(r0, new String[]{"[", DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.DEBUG_TEXT, r1.next(), null, 2, null), "] "});
        goto L4
    L6:
        r0.append(getConstructor());
        if ((!getArguments().isEmpty()) == false) goto L10;
        CollectionsKt.joinTo$default(getArguments(), r0, ", ", "<", ">", 0, null, null, 112, null);
    L10:
        if (isMarkedNullable() == false) goto L12;
        r0.append("?");
    L12:
        String r12 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder().apply(builderAction).toString()");
        return r12;
    }
}
