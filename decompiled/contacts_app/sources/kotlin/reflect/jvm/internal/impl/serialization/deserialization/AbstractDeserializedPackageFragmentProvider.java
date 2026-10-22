package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProviderOptimized {
    protected DeserializationComponents components;
    private final KotlinMetadataFinder finder;
    private final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> fragments;
    private final ModuleDescriptor moduleDescriptor;
    private final StorageManager storageManager;

    protected abstract DeserializedPackageFragment findPackage(FqName r1);

    public AbstractDeserializedPackageFragmentProvider(StorageManager r2, KotlinMetadataFinder r3, ModuleDescriptor r4) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "finder");
        Intrinsics.checkNotNullParameter(r4, "moduleDescriptor");
        this.storageManager = r2;
        this.finder = r3;
        this.moduleDescriptor = r4;
        this.fragments = r2.createMemoizedFunctionWithNullableValues(new AbstractDeserializedPackageFragmentProvider$fragments$1(this));
    }

    protected final StorageManager getStorageManager() {
        return this.storageManager;
    }

    protected final KotlinMetadataFinder getFinder() {
        return this.finder;
    }

    protected final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    protected final DeserializationComponents getComponents() {
        DeserializationComponents r0 = this.components;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    protected final void setComponents(DeserializationComponents r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.components = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r2, Collection<PackageFragmentDescriptor> r3) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Intrinsics.checkNotNullParameter(r3, "packageFragments");
        CollectionsKt.addIfNotNull(r3, this.fragments.invoke(r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        if (this.fragments.isComputed(r2) == false) goto L5;
        PackageFragmentDescriptor r1 = this.fragments.invoke(r2);
    L6:
        if (r1 != null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r1 = findPackage(r2);
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        return kotlin.collections.CollectionsKt.listOfNotNull(this.fragments.invoke(r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName r1, Function1<? super Name, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "fqName");
        Intrinsics.checkNotNullParameter(r2, "nameFilter");
        return SetsKt.emptySet();
    }
}
