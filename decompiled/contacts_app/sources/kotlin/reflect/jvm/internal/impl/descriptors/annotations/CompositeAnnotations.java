package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CompositeAnnotations implements Annotations {
    private final List<Annotations> delegates;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeAnnotations(List<? extends Annotations> r2) {
        Intrinsics.checkNotNullParameter(r2, "delegates");
        this.delegates = r2;
    }

    public CompositeAnnotations(Annotations... r2) {
        Intrinsics.checkNotNullParameter(r2, "delegates");
        this(ArraysKt.toList(r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        List<Annotations> r2 = this.delegates;
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L18;
        if (((Annotations) r3.next()).isEmpty() == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Iterator r1 = CollectionsKt.asSequence(this.delegates).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        if (((Annotations) r1.next()).hasAnnotation(r2) == false) goto L4;
        return true;
    L8:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public AnnotationDescriptor mo2078findAnnotation(final FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        return (AnnotationDescriptor) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.delegates), new AnonymousClass1(r2)));
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.flatMap(CollectionsKt.asSequence(this.delegates), C04641.INSTANCE).iterator();
    }
}
