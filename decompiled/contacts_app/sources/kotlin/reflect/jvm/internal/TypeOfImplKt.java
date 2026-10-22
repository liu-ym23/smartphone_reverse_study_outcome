package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: typeOfImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\bH\u0002¨\u0006\t"}, d2 = {"createMutableCollectionKType", "Lkotlin/reflect/KType;", "type", "createNothingType", "createPlatformKType", "lowerBound", "upperBound", "readOnlyToMutable", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TypeOfImplKt {
    public static final KType createPlatformKType(KType r2, KType r3) {
        Intrinsics.checkNotNullParameter(r2, "lowerBound");
        Intrinsics.checkNotNullParameter(r3, "upperBound");
        KotlinType r4 = ((KTypeImpl) r2).getType();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType r5 = ((KTypeImpl) r3).getType();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new KTypeImpl(KotlinTypeFactory.flexibleType((SimpleType) r4, (SimpleType) r5), null, 2, null);
    }

    public static final KType createMutableCollectionKType(KType r11) {
        Intrinsics.checkNotNullParameter(r11, "type");
        KotlinType r0 = ((KTypeImpl) r11).getType();
        if ((r0 instanceof SimpleType) == false) goto L14;
        ClassifierDescriptor r1 = r0.getConstructor().mo2083getDeclarationDescriptor();
        if ((r1 instanceof ClassDescriptor) == false) goto L7;
        ClassDescriptor r2 = (ClassDescriptor) r1;
    L8:
        if (r2 == null) goto L12;
        SimpleType r4 = (SimpleType) r0;
        TypeConstructor r6 = readOnlyToMutable(r2).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r6, "classifier.readOnlyToMutable().typeConstructor");
        return new KTypeImpl(KotlinTypeFactory.simpleType$default(r4, null, r6, null, false, 26, null), null, 2, null);
    L12:
        throw new IllegalArgumentException("Non-class type cannot be a mutable collection type: " + r11);
    L7:
        r2 = null;
        goto L8
    L14:
        throw new IllegalArgumentException(("Non-simple type cannot be a mutable collection type: " + r11).toString());
    }

    private static final ClassDescriptor readOnlyToMutable(ClassDescriptor r3) {
        ClassDescriptor r1 = r3;
        FqName r0 = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(r1));
        if (r0 == null) goto L7;
        ClassDescriptor r4 = DescriptorUtilsKt.getBuiltIns(r1).getBuiltInClassByFqName(r0);
        Intrinsics.checkNotNullExpressionValue(r4, "builtIns.getBuiltInClassByFqName(fqName)");
        return r4;
    L7:
        throw new IllegalArgumentException("Not a readonly collection: " + r3);
    }

    public static final KType createNothingType(KType r8) {
        Intrinsics.checkNotNullParameter(r8, "type");
        KotlinType r0 = ((KTypeImpl) r8).getType();
        if ((r0 instanceof SimpleType) == false) goto L7;
        SimpleType r1 = (SimpleType) r0;
        TypeConstructor r3 = TypeUtilsKt.getBuiltIns(r0).getNothing().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r3, "kotlinType.builtIns.nothing.typeConstructor");
        return new KTypeImpl(KotlinTypeFactory.simpleType$default(r1, null, r3, null, false, 26, null), null, 2, null);
    L7:
        throw new IllegalArgumentException(("Non-simple type cannot be a Nothing type: " + r8).toString());
    }
}
