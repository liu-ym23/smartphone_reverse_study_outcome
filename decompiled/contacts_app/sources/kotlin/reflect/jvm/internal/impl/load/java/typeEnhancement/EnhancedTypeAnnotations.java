package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes4.dex */
final class EnhancedTypeAnnotations implements Annotations {
    private final FqName fqNameToMatch;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return false;
    }

    public EnhancedTypeAnnotations(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqNameToMatch");
        this.fqNameToMatch = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public /* bridge */ /* synthetic */ AnnotationDescriptor mo2078findAnnotation(FqName r1) {
        return mo2078findAnnotation(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r1) {
        return Annotations.DefaultImpls.hasAnnotation(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public EnhancedTypeAnnotationDescriptor mo2078findAnnotation(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        if (Intrinsics.areEqual(r2, this.fqNameToMatch) == true) goto L7;
        return null;
    L7:
        return EnhancedTypeAnnotationDescriptor.INSTANCE;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return CollectionsKt.emptyList().iterator();
    }
}
