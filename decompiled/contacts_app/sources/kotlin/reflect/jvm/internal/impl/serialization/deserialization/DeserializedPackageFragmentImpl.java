package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DeserializedPackageFragmentImpl extends DeserializedPackageFragment {
    private MemberScope _memberScope;
    private ProtoBuf.PackageFragment _proto;
    private final ProtoBasedClassDataFinder classDataFinder;
    private final DeserializedContainerSource containerSource;
    private final BinaryVersion metadataVersion;
    private final NameResolverImpl nameResolver;

    public static final /* synthetic */ DeserializedContainerSource access$getContainerSource$p(DeserializedPackageFragmentImpl r0) {
        return r0.containerSource;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public /* bridge */ /* synthetic */ ClassDataFinder getClassDataFinder() {
        return getClassDataFinder();
    }

    public DeserializedPackageFragmentImpl(FqName r2, StorageManager r3, ModuleDescriptor r4, ProtoBuf.PackageFragment r5, BinaryVersion r6, DeserializedContainerSource r7) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Intrinsics.checkNotNullParameter(r3, "storageManager");
        Intrinsics.checkNotNullParameter(r4, "module");
        Intrinsics.checkNotNullParameter(r5, "proto");
        Intrinsics.checkNotNullParameter(r6, "metadataVersion");
        super(r2, r3, r4);
        this.metadataVersion = r6;
        this.containerSource = r7;
        ProtoBuf.StringTable r8 = r5.getStrings();
        Intrinsics.checkNotNullExpressionValue(r8, "proto.strings");
        ProtoBuf.QualifiedNameTable r9 = r5.getQualifiedNames();
        Intrinsics.checkNotNullExpressionValue(r9, "proto.qualifiedNames");
        NameResolverImpl r10 = new NameResolverImpl(r8, r9);
        this.nameResolver = r10;
        this.classDataFinder = new ProtoBasedClassDataFinder(r5, r10, r6, new DeserializedPackageFragmentImpl$classDataFinder$1(this));
        this._proto = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public ProtoBasedClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public void initialize(DeserializationComponents r12) {
        Intrinsics.checkNotNullParameter(r12, "components");
        ProtoBuf.PackageFragment r0 = this._proto;
        if (r0 == null) goto L7;
        this._proto = null;
        ProtoBuf.Package r4 = r0.getPackage();
        Intrinsics.checkNotNullExpressionValue(r4, "proto.`package`");
        this._memberScope = new DeserializedPackageMemberScope(this, r4, this.nameResolver, this.metadataVersion, this.containerSource, r12, "scope of " + this, new AnonymousClass1(this));
        return;
    L7:
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public MemberScope getMemberScope() {
        MemberScope r0 = this._memberScope;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
        return null;
    L6:
        return r0;
    }
}
