package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: compiled from: JavaToKotlinClassMapper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaToKotlinClassMapper {
    public static final JavaToKotlinClassMapper INSTANCE = null;

    static {
        INSTANCE = new JavaToKotlinClassMapper();
    }

    private JavaToKotlinClassMapper() {
    }

    public final Collection<ClassDescriptor> mapPlatformClass(FqName r8, KotlinBuiltIns r9) {
        Intrinsics.checkNotNullParameter(r8, "fqName");
        Intrinsics.checkNotNullParameter(r9, "builtIns");
        ClassDescriptor r7 = mapJavaToKotlin$default(this, r8, r9, null, 4, null);
        if (r7 == null) goto L5;
        FqName r10 = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(r7));
        if (r10 == null) goto L9;
        ClassDescriptor r11 = r9.getBuiltInClassByFqName(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
        return CollectionsKt.listOf(new ClassDescriptor[]{r7, r11});
    L9:
        return SetsKt.setOf(r7);
    L5:
        return SetsKt.emptySet();
    }

    public static /* synthetic */ ClassDescriptor mapJavaToKotlin$default(JavaToKotlinClassMapper r0, FqName r1, KotlinBuiltIns r2, Integer r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.mapJavaToKotlin(r1, r2, r3);
    }

    public final ClassDescriptor mapJavaToKotlin(FqName r1, KotlinBuiltIns r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r1, "fqName");
        Intrinsics.checkNotNullParameter(r2, "builtIns");
        if (r3 != null) goto L5;
    L7:
        ClassId r0 = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(r1);
    L8:
        if (r0 != null) goto L12;
        return null;
    L12:
        return r2.getBuiltInClassByFqName(r0.asSingleFqName());
    L5:
        if (Intrinsics.areEqual(r1, JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME()) == false) goto L7;
        r0 = StandardNames.getFunctionClassId(r3.intValue());
        goto L8
    }

    public final boolean isMutable(ClassDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "mutable");
        return JavaToKotlinClassMap.INSTANCE.isMutable(DescriptorUtils.getFqName(r1));
    }

    public final boolean isReadOnly(ClassDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "readOnly");
        return JavaToKotlinClassMap.INSTANCE.isReadOnly(DescriptorUtils.getFqName(r1));
    }

    public final ClassDescriptor convertMutableToReadOnly(ClassDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "mutable");
        ClassDescriptor r2 = r3;
        FqName r0 = JavaToKotlinClassMap.INSTANCE.mutableToReadOnly(DescriptorUtils.getFqName(r2));
        if (r0 == null) goto L7;
        ClassDescriptor r4 = DescriptorUtilsKt.getBuiltIns(r2).getBuiltInClassByFqName(r0);
        Intrinsics.checkNotNullExpressionValue(r4, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
        return r4;
    L7:
        throw new IllegalArgumentException("Given class " + r3 + " is not a mutable collection");
    }

    public final ClassDescriptor convertReadOnlyToMutable(ClassDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "readOnly");
        ClassDescriptor r2 = r3;
        FqName r0 = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtils.getFqName(r2));
        if (r0 == null) goto L7;
        ClassDescriptor r4 = DescriptorUtilsKt.getBuiltIns(r2).getBuiltInClassByFqName(r0);
        Intrinsics.checkNotNullExpressionValue(r4, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
        return r4;
    L7:
        throw new IllegalArgumentException("Given class " + r3 + " is not a read-only collection");
    }
}
