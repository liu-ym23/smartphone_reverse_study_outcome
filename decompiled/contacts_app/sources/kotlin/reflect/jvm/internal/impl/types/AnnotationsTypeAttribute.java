package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;

/* JADX INFO: compiled from: AnnotationsTypeAttribute.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnnotationsTypeAttribute extends TypeAttribute<AnnotationsTypeAttribute> {
    private final Annotations annotations;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public KClass<? extends AnnotationsTypeAttribute> getKey() {
        return Reflection.getOrCreateKotlinClass(AnnotationsTypeAttribute.class);
    }

    public AnnotationsTypeAttribute(Annotations r2) {
        Intrinsics.checkNotNullParameter(r2, "annotations");
        this.annotations = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public /* bridge */ /* synthetic */ TypeAttribute add(TypeAttribute r1) {
        return add((AnnotationsTypeAttribute) r1);
    }

    public final Annotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public /* bridge */ /* synthetic */ TypeAttribute intersect(TypeAttribute r1) {
        return intersect((AnnotationsTypeAttribute) r1);
    }

    public AnnotationsTypeAttribute intersect(AnnotationsTypeAttribute r1) {
        if (Intrinsics.areEqual(r1, this) == true) goto L7;
        return null;
    L7:
        return this;
    }

    public AnnotationsTypeAttribute add(AnnotationsTypeAttribute r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        return new AnnotationsTypeAttribute(AnnotationsKt.composeAnnotations(this.annotations, r2.annotations));
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof AnnotationsTypeAttribute) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(((AnnotationsTypeAttribute) r2).annotations, this.annotations);
    }

    public int hashCode() {
        return this.annotations.hashCode();
    }
}
