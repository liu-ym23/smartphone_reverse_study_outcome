package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: compiled from: CompanionObjectMappingUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CompanionObjectMappingUtilsKt {
    public static final boolean isMappedIntrinsicCompanionObject(CompanionObjectMapping r1, ClassDescriptor r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "classDescriptor");
        if (DescriptorUtils.isCompanionObject(r2) == false) goto L11;
        Set<ClassId> r3 = r1.getClassIds();
        ClassId r4 = DescriptorUtilsKt.getClassId(r2);
        if (r4 == null) goto L7;
        ClassId r5 = r4.getOuterClassId();
    L9:
        if (CollectionsKt.contains(r3, r5) == false) goto L11;
        return true;
    L7:
        r5 = null;
    L11:
        return false;
    }
}
