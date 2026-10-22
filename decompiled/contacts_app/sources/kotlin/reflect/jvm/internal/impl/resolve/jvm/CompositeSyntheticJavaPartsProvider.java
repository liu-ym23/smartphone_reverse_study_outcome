package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: SyntheticJavaPartsProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CompositeSyntheticJavaPartsProvider implements SyntheticJavaPartsProvider {
    private final List<SyntheticJavaPartsProvider> inner;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeSyntheticJavaPartsProvider(List<? extends SyntheticJavaPartsProvider> r2) {
        Intrinsics.checkNotNullParameter(r2, "inner");
        this.inner = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getMethodNames(ClassDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "thisDescriptor");
        List<SyntheticJavaPartsProvider> r2 = this.inner;
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        CollectionsKt.addAll(r0, ((SyntheticJavaPartsProvider) r4.next()).getMethodNames(r3));
        goto L4
    L7:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateMethods(ClassDescriptor r2, Name r3, Collection<SimpleFunctionDescriptor> r4) {
        Intrinsics.checkNotNullParameter(r2, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "result");
        Iterator<T> r1 = this.inner.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r1.next()).generateMethods(r2, r3, r4);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getStaticFunctionNames(ClassDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "thisDescriptor");
        List<SyntheticJavaPartsProvider> r2 = this.inner;
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        CollectionsKt.addAll(r0, ((SyntheticJavaPartsProvider) r4.next()).getStaticFunctionNames(r3));
        goto L4
    L7:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateStaticFunctions(ClassDescriptor r2, Name r3, Collection<SimpleFunctionDescriptor> r4) {
        Intrinsics.checkNotNullParameter(r2, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "result");
        Iterator<T> r1 = this.inner.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r1.next()).generateStaticFunctions(r2, r3, r4);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateConstructors(ClassDescriptor r2, List<ClassConstructorDescriptor> r3) {
        Intrinsics.checkNotNullParameter(r2, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r3, "result");
        Iterator<T> r1 = this.inner.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r1.next()).generateConstructors(r2, r3);
        goto L4
    }
}
