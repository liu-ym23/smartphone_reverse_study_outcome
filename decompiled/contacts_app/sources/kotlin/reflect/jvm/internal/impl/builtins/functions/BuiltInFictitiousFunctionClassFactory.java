package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BuiltInFictitiousFunctionClassFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {
    private final ModuleDescriptor module;
    private final StorageManager storageManager;

    public BuiltInFictitiousFunctionClassFactory(StorageManager r2, ModuleDescriptor r3) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "module");
        this.storageManager = r2;
        this.module = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName r4, Name r5) {
        Intrinsics.checkNotNullParameter(r4, "packageFqName");
        Intrinsics.checkNotNullParameter(r5, "name");
        String r3 = r5.asString();
        Intrinsics.checkNotNullExpressionValue(r3, "name.asString()");
        if (StringsKt.startsWith$default(r3, "Function", false, 2, null) == true) goto L11;
        if (StringsKt.startsWith$default(r3, "KFunction", false, 2, null) == true) goto L11;
        if (StringsKt.startsWith$default(r3, "SuspendFunction", false, 2, null) == true) goto L11;
        if (StringsKt.startsWith$default(r3, "KSuspendFunction", false, 2, null) == true) goto L11;
        return false;
    L11:
        if (FunctionClassKind.Companion.parseClassName(r3, r4) == null) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId r7) {
        Intrinsics.checkNotNullParameter(r7, "classId");
        if (r7.isLocal() == false) goto L5;
    L31:
        return null;
    L5:
        if (r7.isNestedClass() == true) goto L31;
        String r0 = r7.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(r0, "classId.relativeClassName.asString()");
        if (StringsKt.contains$default(r0, "Function", false, 2, null) == true) goto L10;
        return null;
    L10:
        FqName r8 = r7.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r8, "classId.packageFqName");
        FunctionClassKind.Companion.KindWithArity r1 = FunctionClassKind.Companion.parseClassName(r0, r8);
        if (r1 != null) goto L13;
        return null;
    L13:
        FunctionClassKind r2 = r1.component1();
        int r3 = r1.component2();
        List<PackageFragmentDescriptor> r9 = this.module.getPackage(r8).getFragments();
        ArrayList r4 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L15:
        if (r10.hasNext() == false) goto L19;
        Object r5 = r10.next();
        if ((r5 instanceof BuiltInsPackageFragment) == false) goto L15;
        r4.add(r5);
        goto L15
    L19:
        ArrayList r6 = r4;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r6.iterator();
    L21:
        if (r12.hasNext() == false) goto L25;
        Object r13 = r12.next();
        if ((r13 instanceof FunctionInterfacePackageFragment) == false) goto L21;
        r11.add(r13);
        goto L21
    L25:
        Object r14 = (FunctionInterfacePackageFragment) CollectionsKt.firstOrNull(r11);
        if (r14 != null) goto L30;
        r14 = CollectionsKt.first(r6);
    L30:
        return new FunctionClassDescriptor(this.storageManager, (BuiltInsPackageFragment) r14, r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName r1) {
        Intrinsics.checkNotNullParameter(r1, "packageFqName");
        return SetsKt.emptySet();
    }
}
