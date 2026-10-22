package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: DeserializedClassDataFinder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeserializedClassDataFinder implements ClassDataFinder {
    private final PackageFragmentProvider packageFragmentProvider;

    public DeserializedClassDataFinder(PackageFragmentProvider r2) {
        Intrinsics.checkNotNullParameter(r2, "packageFragmentProvider");
        this.packageFragmentProvider = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r3) {
        Intrinsics.checkNotNullParameter(r3, "classId");
        PackageFragmentProvider r2 = this.packageFragmentProvider;
        FqName r0 = r3.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r0, "classId.packageFqName");
        Iterator<PackageFragmentDescriptor> r4 = PackageFragmentProviderKt.packageFragments(r2, r0).iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        PackageFragmentDescriptor r1 = r4.next();
        if ((r1 instanceof DeserializedPackageFragment) == false) goto L4;
        ClassData r5 = ((DeserializedPackageFragment) r1).getClassDataFinder().findClassData(r3);
        if (r5 == null) goto L4;
        return r5;
    L10:
        return null;
    }
}
