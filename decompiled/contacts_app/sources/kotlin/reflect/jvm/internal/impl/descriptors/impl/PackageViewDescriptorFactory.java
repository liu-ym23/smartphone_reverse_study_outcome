package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: compiled from: PackageViewDescriptorFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface PackageViewDescriptorFactory {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: PackageViewDescriptorFactory.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final ModuleCapability<PackageViewDescriptorFactory> CAPABILITY = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            CAPABILITY = new ModuleCapability("PackageViewDescriptorFactory");
        }

        public final ModuleCapability<PackageViewDescriptorFactory> getCAPABILITY() {
            return CAPABILITY;
        }
    }

    /* JADX INFO: compiled from: PackageViewDescriptorFactory.kt */
    public static final class Default implements PackageViewDescriptorFactory {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory
        public PackageViewDescriptor compute(ModuleDescriptorImpl r1, FqName r2, StorageManager r3) {
            Intrinsics.checkNotNullParameter(r1, "module");
            Intrinsics.checkNotNullParameter(r2, "fqName");
            Intrinsics.checkNotNullParameter(r3, "storageManager");
            return new LazyPackageViewDescriptorImpl(r1, r2, r3);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    PackageViewDescriptor compute(ModuleDescriptorImpl r1, FqName r2, StorageManager r3);
}
