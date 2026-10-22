package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: compiled from: ClassicBuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ClassicBuiltinSpecialProperties {
    public static final ClassicBuiltinSpecialProperties INSTANCE = null;

    static {
        INSTANCE = new ClassicBuiltinSpecialProperties();
    }

    private ClassicBuiltinSpecialProperties() {
    }

    public final String getBuiltinSpecialPropertyGetterName(CallableMemberDescriptor r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        KotlinBuiltIns.isBuiltIn(r4);
        CallableMemberDescriptor r3 = DescriptorUtilsKt.firstOverridden$default(DescriptorUtilsKt.getPropertyIfAccessor(r4), false, ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1.INSTANCE, 1, null);
        if (r3 != null) goto L5;
        return null;
    L5:
        Name r5 = BuiltinSpecialProperties.INSTANCE.getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP().get(DescriptorUtilsKt.getFqNameSafe(r3));
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.asString();
    }

    public final boolean hasBuiltinSpecialPropertyFqName(CallableMemberDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "callableMemberDescriptor");
        if (BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(r3.getName()) == true) goto L7;
        return false;
    L7:
        return hasBuiltinSpecialPropertyFqNameImpl(r3);
    }

    private final boolean hasBuiltinSpecialPropertyFqNameImpl(CallableMemberDescriptor r5) {
        CallableMemberDescriptor r0 = r5;
        if (CollectionsKt.contains(BuiltinSpecialProperties.INSTANCE.getSPECIAL_FQ_NAMES(), DescriptorUtilsKt.fqNameOrNull(r0)) == false) goto L8;
        if (r5.getValueParameters().isEmpty() == false) goto L8;
        return true;
    L8:
        if (KotlinBuiltIns.isBuiltIn(r0) == true) goto L10;
        return false;
    L10:
        Collection<? extends CallableMemberDescriptor> r4 = r5.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r4, "overriddenDescriptors");
        Collection<? extends CallableMemberDescriptor> r6 = r4;
        if (r6.isEmpty() == true) goto L18;
        Iterator<T> r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L18;
        CallableMemberDescriptor r8 = (CallableMemberDescriptor) r7.next();
        ClassicBuiltinSpecialProperties r2 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r8, "it");
        if (r2.hasBuiltinSpecialPropertyFqName(r8) == false) goto L15;
        return true;
    L18:
        return false;
    }
}
