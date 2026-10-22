package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.ReadPackageFragmentKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: compiled from: BuiltInsPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BuiltInsPackageFragmentImpl extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {
    public static final Companion Companion = null;
    private final boolean isFallback;

    /* JADX INFO: compiled from: BuiltInsPackageFragmentImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final BuiltInsPackageFragmentImpl create(FqName r9, StorageManager r10, ModuleDescriptor r11, InputStream r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r9, "fqName");
            Intrinsics.checkNotNullParameter(r10, "storageManager");
            Intrinsics.checkNotNullParameter(r11, "module");
            Intrinsics.checkNotNullParameter(r12, "inputStream");
            Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> r8 = ReadPackageFragmentKt.readBuiltinsPackageFragment(r12);
            ProtoBuf.PackageFragment r4 = r8.component1();
            BuiltInsBinaryVersion r5 = r8.component2();
            if (r4 == null) goto L7;
            return new BuiltInsPackageFragmentImpl(r9, r10, r11, r4, r5, r13, null);
        L7:
            throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + BuiltInsBinaryVersion.INSTANCE + ", actual " + r5 + ". Please update Kotlin");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ BuiltInsPackageFragmentImpl(FqName r1, StorageManager r2, ModuleDescriptor r3, ProtoBuf.PackageFragment r4, BuiltInsBinaryVersion r5, boolean r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    private BuiltInsPackageFragmentImpl(FqName r8, StorageManager r9, ModuleDescriptor r10, ProtoBuf.PackageFragment r11, BuiltInsBinaryVersion r12, boolean r13) {
        super(r8, r9, r10, r11, r12, null);
        this.isFallback = r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "builtins package fragment for " + getFqName() + " from " + DescriptorUtilsKt.getModule(this);
    }
}
