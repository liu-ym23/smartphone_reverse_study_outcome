package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PackageFragmentProviderImpl implements PackageFragmentProviderOptimized {
    private final Collection<PackageFragmentDescriptor> packageFragments;

    /* JADX WARN: Multi-variable type inference failed */
    public PackageFragmentProviderImpl(Collection<? extends PackageFragmentDescriptor> r2) {
        Intrinsics.checkNotNullParameter(r2, "packageFragments");
        this.packageFragments = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r3, Collection<PackageFragmentDescriptor> r4) {
        Intrinsics.checkNotNullParameter(r3, "fqName");
        Intrinsics.checkNotNullParameter(r4, "packageFragments");
        Iterator<T> r2 = this.packageFragments.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r0 = r2.next();
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r0).getFqName(), r3) == false) goto L4;
        r4.add(r0);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r3) {
        Intrinsics.checkNotNullParameter(r3, "fqName");
        Collection<PackageFragmentDescriptor> r2 = this.packageFragments;
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r4.next()).getFqName(), r3) == false) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName r4) {
        Intrinsics.checkNotNullParameter(r4, "fqName");
        Collection<PackageFragmentDescriptor> r3 = this.packageFragments;
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Object r1 = r5.next();
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r1).getFqName(), r4) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(final FqName r2, Function1<? super Name, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Intrinsics.checkNotNullParameter(r3, "nameFilter");
        return SequencesKt.toList(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(this.packageFragments), AnonymousClass1.INSTANCE), new AnonymousClass2(r2)));
    }
}
