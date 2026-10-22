package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: compiled from: BuiltInsLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface BuiltInsLoader {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: BuiltInsLoader.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Lazy<BuiltInsLoader> Instance$delegate = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            Instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, BuiltInsLoader$Companion$Instance$2.INSTANCE);
        }

        public final BuiltInsLoader getInstance() {
            return Instance$delegate.getValue();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    PackageFragmentProvider createPackageFragmentProvider(StorageManager r1, ModuleDescriptor r2, Iterable<? extends ClassDescriptorFactory> r3, PlatformDependentDeclarationFilter r4, AdditionalClassPartsProvider r5, boolean r6);
}
