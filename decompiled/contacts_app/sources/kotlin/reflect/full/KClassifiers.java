package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: compiled from: KClassifiers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\u001a.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a6\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eH\u0007\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"starProjectedType", "Lkotlin/reflect/KType;", "Lkotlin/reflect/KClassifier;", "getStarProjectedType$annotations", "(Lkotlin/reflect/KClassifier;)V", "getStarProjectedType", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KType;", "createKotlinType", "Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "attributes", "Lkotlin/reflect/jvm/internal/impl/types/TypeAttributes;", "typeConstructor", "Lkotlin/reflect/jvm/internal/impl/types/TypeConstructor;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "nullable", "", "createType", "annotations", "", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KClassifiers {

    /* JADX INFO: compiled from: KClassifiers.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[KVariance.values().length];
            r0[KVariance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[KVariance.IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void getStarProjectedType$annotations(KClassifier r0) {
    }

    public static /* synthetic */ KType createType$default(KClassifier r0, List r1, boolean r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = false;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = CollectionsKt.emptyList();
    L12:
        return createType(r0, r1, r2, r3);
    }

    public static final KType createType(KClassifier r4, List<KTypeProjection> r5, boolean r6, List<? extends Annotation> r7) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "arguments");
        Intrinsics.checkNotNullParameter(r7, "annotations");
        if ((r4 instanceof KClassifierImpl) == false) goto L5;
        KClassifierImpl r0 = (KClassifierImpl) r4;
    L6:
        if (r0 == null) goto L20;
        ClassifierDescriptor r1 = r0.getDescriptor();
        if (r1 == null) goto L20;
        TypeConstructor r8 = r1.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r8, "descriptor.typeConstructor");
        List<TypeParameterDescriptor> r2 = r8.getParameters();
        Intrinsics.checkNotNullExpressionValue(r2, "typeConstructor.parameters");
        if (r2.size() != r5.size()) goto L18;
        if (r7.isEmpty() == false) goto L14;
        TypeAttributes r9 = TypeAttributes.Companion.getEmpty();
    L16:
        return new KTypeImpl(createKotlinType(r9, r8, r5, r6), null, 2, null);
    L14:
        r9 = TypeAttributes.Companion.getEmpty();
        goto L16
    L18:
        throw new IllegalArgumentException("Class declares " + r2.size() + " type parameters, but " + r5.size() + " were provided.");
    L20:
        throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + r4 + " (" + r4.getClass() + ')');
    L5:
        r0 = null;
        goto L6
    }

    private static final SimpleType createKotlinType(TypeAttributes r12, TypeConstructor r13, List<KTypeProjection> r14, boolean r15) {
        List<TypeParameterDescriptor> r0 = r13.getParameters();
        Intrinsics.checkNotNullExpressionValue(r0, "typeConstructor.parameters");
        List<KTypeProjection> r16 = r14;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r17 = r16.iterator();
        int r2 = 0;
    L4:
        if (r17.hasNext() == false) goto L31;
        Object r3 = r17.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        KTypeProjection r5 = (KTypeProjection) r3;
        KTypeImpl r6 = (KTypeImpl) r5.getType();
        if (r6 == null) goto L11;
        KotlinType r7 = r6.getType();
    L12:
        KVariance r8 = r5.getVariance();
        if (r8 != null) goto L15;
        int r9 = -1;
    L16:
        if (r9 != (-1)) goto L18;
        TypeParameterDescriptor r10 = r0.get(r2);
        Intrinsics.checkNotNullExpressionValue(r10, "parameters[index]");
        TypeProjectionBase r11 = new StarProjectionImpl(r10);
    L29:
        r1.add(r11);
        r2 = r4;
        goto L4
    L18:
        if (r9 != 1) goto L20;
        Variance r18 = Variance.INVARIANT;
        Intrinsics.checkNotNull(r7);
        r11 = new TypeProjectionImpl(r18, r7);
        goto L29
    L20:
        if (r9 != 2) goto L22;
        Variance r19 = Variance.IN_VARIANCE;
        Intrinsics.checkNotNull(r7);
        r11 = new TypeProjectionImpl(r19, r7);
        goto L29
    L22:
        if (r9 != 3) goto L25;
        Variance r20 = Variance.OUT_VARIANCE;
        Intrinsics.checkNotNull(r7);
        r11 = new TypeProjectionImpl(r20, r7);
        goto L29
    L25:
        throw new NoWhenBranchMatchedException();
    L15:
        r9 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
        goto L16
    L11:
        r7 = null;
        goto L12
    L31:
        return KotlinTypeFactory.simpleType$default(r12, r13, r1, r15, null, 16, null);
    }

    public static final KType getStarProjectedType(KClassifier r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if ((r9 instanceof KClassifierImpl) == false) goto L5;
        KClassifierImpl r0 = (KClassifierImpl) r9;
    L6:
        if (r0 == null) goto L21;
        ClassifierDescriptor r1 = r0.getDescriptor();
        if (r1 == null) goto L21;
        List<TypeParameterDescriptor> r2 = r1.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r2, "descriptor.typeConstructor.parameters");
        if (r2.isEmpty() == true) goto L13;
        List<TypeParameterDescriptor> r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L16:
        if (r5.hasNext() == false) goto L19;
        TypeParameterDescriptor r6 = (TypeParameterDescriptor) r5.next();
        r4.add(KTypeProjection.Companion.getSTAR());
        goto L16
    L19:
        return createType$default(r9, r4, false, null, 6, null);
    L13:
        return createType$default(r9, null, false, null, 7, null);
    L21:
        return createType$default(r9, null, false, null, 7, null);
    L5:
        r0 = null;
        goto L6
    }
}
