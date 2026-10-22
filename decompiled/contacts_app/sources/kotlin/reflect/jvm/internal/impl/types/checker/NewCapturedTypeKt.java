package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NewCapturedTypeKt {
    public static final SimpleType captureFromArguments(SimpleType r1, CaptureStatus r2) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r2, "status");
        SimpleType r3 = r1;
        List<TypeProjection> r4 = captureArguments(r3, r2);
        if (r4 != null) goto L7;
        return null;
    L7:
        return replaceArguments(r3, r4);
    }

    private static final SimpleType replaceArguments(UnwrappedType r7, List<? extends TypeProjection> r8) {
        return KotlinTypeFactory.simpleType$default(r7.getAttributes(), r7.getConstructor(), r8, r7.isMarkedNullable(), null, 16, null);
    }

    private static final List<TypeProjection> captureArguments(UnwrappedType r11, CaptureStatus r12) {
        if (r11.getArguments().size() == r11.getConstructor().getParameters().size()) goto L5;
        return null;
    L5:
        List<TypeProjection> r0 = r11.getArguments();
        List<TypeProjection> r1 = r0;
        int r4 = 0;
        boolean r5 = true;
        if ((r1 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r3 = r1.iterator();
    L12:
        if (r3.hasNext() == false) goto L19;
        if (((TypeProjection) r3.next()).getProjectionKind() != Variance.INVARIANT) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L12;
        r5 = false;
        goto L19
    L16:
        r6 = false;
    L19:
        if (r5 == false) goto L21;
        return null;
    L21:
        List<TypeParameterDescriptor> r7 = r11.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r7, "type.constructor.parameters");
        List r2 = CollectionsKt.zip(r1, r7);
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r9 = r2.iterator();
    L23:
        if (r9.hasNext() == false) goto L35;
        Pair r10 = (Pair) r9.next();
        TypeProjection r13 = (TypeProjection) r10.component1();
        TypeParameterDescriptor r14 = (TypeParameterDescriptor) r10.component2();
        if (r13.getProjectionKind() == Variance.INVARIANT) goto L34;
        if (r13.isStarProjection() == false) goto L30;
    L32:
        UnwrappedType r15 = (UnwrappedType) null;
        UnwrappedType r16 = null;
    L33:
        Intrinsics.checkNotNullExpressionValue(r14, "parameter");
        r13 = TypeUtilsKt.asTypeProjection(new NewCapturedType(r12, r16, r13, r14));
        goto L34
    L30:
        if (r13.getProjectionKind() != Variance.IN_VARIANCE) goto L32;
        r16 = r13.getType().unwrap();
    L34:
        r8.add(r13);
        goto L23
    L35:
        ArrayList r17 = r8;
        TypeSubstitutor r18 = TypeConstructorSubstitution.Companion.create(r11.getConstructor(), r17).buildSubstitutor();
        int r19 = r0.size();
    L36:
        if (r4 >= r19) goto L50;
        TypeProjection r20 = r0.get(r4);
        TypeProjection r21 = (TypeProjection) r17.get(r4);
        if (r20.getProjectionKind() == Variance.INVARIANT) goto L49;
        List<KotlinType> r22 = r11.getConstructor().getParameters().get(r4).getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r22, "type.constructor.parameters[index].upperBounds");
        ArrayList r23 = new ArrayList();
        Iterator<T> r24 = r22.iterator();
    L41:
        if (r24.hasNext() == false) goto L43;
        r23.add(KotlinTypePreparator.Default.INSTANCE.prepareType(r18.safeSubstitute((KotlinType) r24.next(), Variance.INVARIANT).unwrap()));
        goto L41
    L43:
        ArrayList r25 = r23;
        if (r20.isStarProjection() == false) goto L46;
    L48:
        KotlinType r26 = r21.getType();
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
        ((NewCapturedType) r26).getConstructor().initializeSupertypes(r25);
        goto L49
    L46:
        if (r20.getProjectionKind() != Variance.OUT_VARIANCE) goto L48;
        r25.add(KotlinTypePreparator.Default.INSTANCE.prepareType(r20.getType().unwrap()));
    L49:
        r4 = r4 + 1;
        goto L36
    L50:
        return r17;
    L8:
        if (r1.isEmpty() == false) goto L10;
        goto L10
    }
}
