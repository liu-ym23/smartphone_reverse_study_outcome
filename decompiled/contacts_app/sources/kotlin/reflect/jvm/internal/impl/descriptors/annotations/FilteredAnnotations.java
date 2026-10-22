package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FilteredAnnotations implements Annotations {
    private final Annotations delegate;
    private final Function1<FqName, Boolean> fqNameFilter;
    private final boolean isDefinitelyNewInference;

    /* JADX WARN: Multi-variable type inference failed */
    public FilteredAnnotations(Annotations r2, boolean r3, Function1<? super FqName, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        Intrinsics.checkNotNullParameter(r4, "fqNameFilter");
        this.delegate = r2;
        this.isDefinitelyNewInference = r3;
        this.fqNameFilter = r4;
    }

    public FilteredAnnotations(Annotations r2, Function1<? super FqName, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        Intrinsics.checkNotNullParameter(r3, "fqNameFilter");
        this(r2, false, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        if (this.fqNameFilter.invoke(r2).booleanValue() == true) goto L7;
        return false;
    L7:
        return this.delegate.hasAnnotation(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public AnnotationDescriptor mo2078findAnnotation(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        if (this.fqNameFilter.invoke(r2).booleanValue() == true) goto L7;
        return null;
    L7:
        return this.delegate.mo2078findAnnotation(r2);
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        Annotations r0 = this.delegate;
        ArrayList r1 = new ArrayList();
        Iterator<AnnotationDescriptor> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        AnnotationDescriptor r3 = r2.next();
        if (shouldBeReturned(r3) == false) goto L4;
        r1.add(r3);
        goto L4
    L9:
        return r1.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        Annotations r0 = this.delegate;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<AnnotationDescriptor> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (shouldBeReturned(r1.next()) == false) goto L9;
        boolean r2 = true;
    L14:
        if (this.isDefinitelyNewInference == false) goto L19;
        if (r2 == true) goto L23;
        return true;
    L23:
        return false;
    L19:
        return r2;
    L6:
        r2 = false;
        goto L14
    L5:
        if (((Collection) r0).isEmpty() == false) goto L7;
        goto L6
    }

    private final boolean shouldBeReturned(AnnotationDescriptor r1) {
        FqName r2 = r1.getFqName();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (this.fqNameFilter.invoke(r2).booleanValue() == false) goto L7;
        return true;
    }
}
