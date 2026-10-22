package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;

/* JADX INFO: compiled from: LazyJavaPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LazyJavaPackageFragmentProvider implements PackageFragmentProviderOptimized {
    private final LazyJavaResolverContext c;
    private final CacheWithNotNullValues<FqName, LazyJavaPackageFragment> packageFragments;

    public LazyJavaPackageFragmentProvider(JavaResolverComponents r4) {
        Intrinsics.checkNotNullParameter(r4, "components");
        LazyJavaResolverContext r0 = new LazyJavaResolverContext(r4, TypeParameterResolver.EMPTY.INSTANCE, LazyKt.lazyOf(null));
        this.c = r0;
        this.packageFragments = r0.getStorageManager().createCacheWithNotNullValues();
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaPackageFragmentProvider r0) {
        return r0.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public /* bridge */ /* synthetic */ Collection getSubPackagesOf(FqName r1, Function1 r2) {
        return getSubPackagesOf(r1, r2);
    }

    private final LazyJavaPackageFragment getPackageFragment(FqName r5) {
        final JavaPackage r0 = JavaClassFinder.DefaultImpls.findPackage$default(this.c.getComponents().getFinder(), r5, false, 2, null);
        if (r0 != null) goto L6;
        return null;
    L6:
        return this.packageFragments.computeIfAbsent(r5, new AnonymousClass1(this, r0));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<LazyJavaPackageFragment> getPackageFragments(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        return CollectionsKt.listOfNotNull(getPackageFragment(r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r2, Collection<PackageFragmentDescriptor> r3) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Intrinsics.checkNotNullParameter(r3, "packageFragments");
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r3, getPackageFragment(r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r4) {
        Intrinsics.checkNotNullParameter(r4, "fqName");
        if (JavaClassFinder.DefaultImpls.findPackage$default(this.c.getComponents().getFinder(), r4, false, 2, null) != null) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public List<FqName> getSubPackagesOf(FqName r2, Function1<? super Name, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Intrinsics.checkNotNullParameter(r3, "nameFilter");
        LazyJavaPackageFragment r1 = getPackageFragment(r2);
        if (r1 == null) goto L5;
        List<FqName> r4 = r1.getSubPackageFqNames$descriptors_jvm();
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r4 = null;
        goto L6
    }

    public String toString() {
        return "LazyJavaPackageFragmentProvider of module " + this.c.getComponents().getModule();
    }
}
