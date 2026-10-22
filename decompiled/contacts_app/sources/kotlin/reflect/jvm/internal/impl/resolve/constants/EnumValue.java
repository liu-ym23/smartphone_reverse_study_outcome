package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EnumValue extends ConstantValue<Pair<? extends ClassId, ? extends Name>> {
    private final ClassId enumClassId;
    private final Name enumEntryName;

    public EnumValue(ClassId r2, Name r3) {
        Intrinsics.checkNotNullParameter(r2, "enumClassId");
        Intrinsics.checkNotNullParameter(r3, "enumEntryName");
        super(TuplesKt.to(r2, r3));
        this.enumClassId = r2;
        this.enumEntryName = r3;
    }

    public final Name getEnumEntryName() {
        return this.enumEntryName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor r4) {
        Intrinsics.checkNotNullParameter(r4, "module");
        ClassDescriptor r5 = FindClassInModuleKt.findClassAcrossModuleDependencies(r4, this.enumClassId);
        SimpleType r0 = null;
        if (r5 != null) goto L5;
    L10:
        if (r0 != null) goto L13;
        ErrorTypeKind r6 = ErrorTypeKind.ERROR_ENUM_TYPE;
        String r1 = this.enumClassId.toString();
        Intrinsics.checkNotNullExpressionValue(r1, "enumClassId.toString()");
        String r3 = this.enumEntryName.toString();
        Intrinsics.checkNotNullExpressionValue(r3, "enumEntryName.toString()");
        return ErrorUtils.createErrorType(r6, new String[]{r1, r3});
    L13:
        return r0;
    L5:
        if (DescriptorUtils.isEnumClass(r5) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L10;
        r0 = r5.getDefaultType();
        goto L10
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return new StringBuilder().append(this.enumClassId.getShortClassName()).append('.').append(this.enumEntryName).toString();
    }
}
