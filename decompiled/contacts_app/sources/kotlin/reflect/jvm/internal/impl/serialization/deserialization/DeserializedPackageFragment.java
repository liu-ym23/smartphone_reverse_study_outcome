package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: compiled from: DeserializedPackageFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DeserializedPackageFragment extends PackageFragmentDescriptorImpl {
    private final StorageManager storageManager;

    public abstract ClassDataFinder getClassDataFinder();

    public abstract void initialize(DeserializationComponents r1);

    public DeserializedPackageFragment(FqName r2, StorageManager r3, ModuleDescriptor r4) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Intrinsics.checkNotNullParameter(r3, "storageManager");
        Intrinsics.checkNotNullParameter(r4, "module");
        super(r4, r2);
        this.storageManager = r3;
    }

    public boolean hasTopLevelClass(Name r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        MemberScope r1 = getMemberScope();
        if ((r1 instanceof DeserializedMemberScope) == true) goto L5;
    L7:
        return false;
    L5:
        if (((DeserializedMemberScope) r1).getClassNames$deserialization().contains(r2) == false) goto L7;
        return true;
    }
}
