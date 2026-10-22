package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;

/* JADX INFO: compiled from: typeSignatureMapping.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeSignatureMappingKt {
    public static final <T> T boxTypeIfNeeded(JvmTypeFactory<T> r1, T r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "possiblyPrimitiveType");
        if (r3 == true) goto L5;
        return r2;
    L5:
        return r1.boxType(r2);
    }

    public static final <T> T mapBuiltInType(TypeSystemCommonBackendContext r5, KotlinTypeMarker r6, JvmTypeFactory<T> r7, TypeMappingMode r8) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r7, "typeFactory");
        Intrinsics.checkNotNullParameter(r8, "mode");
        TypeConstructorMarker r0 = r5.typeConstructor(r6);
        if (r5.isClassTypeConstructor(r0) == true) goto L5;
        return null;
    L5:
        PrimitiveType r1 = r5.getPrimitiveType(r0);
        boolean r3 = true;
        if (r1 == null) goto L15;
        T r9 = r7.createPrimitiveType(r1);
        if (r5.isNullableType(r6) == true) goto L14;
        if (TypeEnhancementUtilsKt.hasEnhancedNullability(r5, r6) == true) goto L14;
        r3 = false;
    L14:
        return (T) boxTypeIfNeeded(r7, r9, r3);
    L15:
        PrimitiveType r10 = r5.getPrimitiveArrayType(r0);
        if (r10 == null) goto L20;
        return r7.createFromString("[" + JvmPrimitiveType.get(r10).getDesc());
    L20:
        if (r5.isUnderKotlinPackage(r0) == false) goto L42;
        FqNameUnsafe r11 = r5.getClassFqNameUnsafe(r0);
        if (r11 == null) goto L24;
        ClassId r12 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r11);
    L25:
        if (r12 == null) goto L42;
        if (r8.getKotlinCollectionsToJavaCollections() == true) goto L40;
        List<JavaToKotlinClassMap.PlatformMutabilityMapping> r13 = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
        if ((r13 instanceof Collection) == true) goto L31;
    L33:
        Iterator<T> r14 = r13.iterator();
    L35:
        if (r14.hasNext() == false) goto L32;
        if (Intrinsics.areEqual(((JavaToKotlinClassMap.PlatformMutabilityMapping) r14.next()).getJavaClass(), r12) == false) goto L35;
    L38:
        if (r3 == false) goto L40;
        return null;
    L32:
        r3 = false;
        goto L38
    L31:
        if (r13.isEmpty() == false) goto L33;
    L40:
        String r15 = JvmClassName.byClassId(r12).getInternalName();
        Intrinsics.checkNotNullExpressionValue(r15, "byClassId(classId).internalName");
        return r7.createObjectType(r15);
    L24:
        r12 = null;
    L42:
        return null;
    }
}
