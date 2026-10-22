package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.apm.constant.PerfConsts;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker INSTANCE = null;
    public static boolean RUN_SLOW_ASSERTIONS;

    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[TypeVariance.values().length];
            r0[TypeVariance.INV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[TypeVariance.OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[TypeVariance.IN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            r1[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            $EnumSwitchMapping$1 = r1;
        }
    }

    static {
        INSTANCE = new AbstractTypeChecker();
    }

    public final boolean isSubtypeOf(TypeCheckerState r9, KotlinTypeMarker r10, KotlinTypeMarker r11) {
        Intrinsics.checkNotNullParameter(r9, "state");
        Intrinsics.checkNotNullParameter(r10, "subType");
        Intrinsics.checkNotNullParameter(r11, "superType");
        return isSubtypeOf$default(this, r9, r10, r11, false, 8, null);
    }

    private AbstractTypeChecker() {
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker r0, TypeCheckerState r1, KotlinTypeMarker r2, KotlinTypeMarker r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        return r0.isSubtypeOf(r1, r2, r3, r4);
    }

    public final boolean isSubtypeOf(TypeCheckerState r2, KotlinTypeMarker r3, KotlinTypeMarker r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "subType");
        Intrinsics.checkNotNullParameter(r4, "superType");
        if (r3 != r4) goto L7;
        return true;
    L7:
        if (r2.customIsSubtypeOf(r3, r4) == true) goto L11;
        return false;
    L11:
        return completeIsSubTypeOf(r2, r3, r4, r5);
    }

    public final boolean equalTypes(TypeCheckerState r11, KotlinTypeMarker r12, KotlinTypeMarker r13) {
        Intrinsics.checkNotNullParameter(r11, "state");
        Intrinsics.checkNotNullParameter(r12, "a");
        Intrinsics.checkNotNullParameter(r13, "b");
        TypeSystemContext r10 = r11.getTypeSystemContext();
        if (r12 != r13) goto L5;
        return true;
    L5:
        AbstractTypeChecker r8 = INSTANCE;
        if (r8.isCommonDenotableType(r10, r12) == false) goto L25;
        if (r8.isCommonDenotableType(r10, r13) == false) goto L25;
        KotlinTypeMarker r1 = r11.prepareType(r11.refineType(r12));
        KotlinTypeMarker r2 = r11.prepareType(r11.refineType(r13));
        SimpleTypeMarker r3 = r10.lowerBoundIfFlexible(r1);
        if (r10.areEqualTypeConstructors(r10.typeConstructor(r1), r10.typeConstructor(r2)) == true) goto L13;
        return false;
    L13:
        if (r10.argumentsCount(r3) != 0) goto L25;
        if (r10.hasFlexibleNullability(r1) == false) goto L17;
        return true;
    L17:
        if (r10.hasFlexibleNullability(r2) == false) goto L20;
        return true;
    L20:
        if (r10.isMarkedNullable(r3) != r10.isMarkedNullable(r10.lowerBoundIfFlexible(r2))) goto L23;
        return true;
    L23:
        return false;
    L25:
        if (isSubtypeOf$default(r8, r11, r12, r13, false, 8, null) == false) goto L30;
        if (isSubtypeOf$default(r8, r11, r13, r12, false, 8, null) == false) goto L30;
        return true;
    L30:
        return false;
    }

    private final boolean completeIsSubTypeOf(TypeCheckerState r4, KotlinTypeMarker r5, KotlinTypeMarker r6, boolean r7) {
        TypeSystemContext r3 = r4.getTypeSystemContext();
        KotlinTypeMarker r8 = r4.prepareType(r4.refineType(r5));
        KotlinTypeMarker r9 = r4.prepareType(r4.refineType(r6));
        AbstractTypeChecker r0 = INSTANCE;
        Boolean r1 = r0.checkSubtypeForSpecialCases(r4, r3.lowerBoundIfFlexible(r8), r3.upperBoundIfFlexible(r9));
        if (r1 == null) goto L6;
        boolean r10 = r1.booleanValue();
        r4.addSubtypeConstraint(r8, r9, r7);
        return r10;
    L6:
        Boolean r11 = r4.addSubtypeConstraint(r8, r9, r7);
        if (r11 == null) goto L11;
        return r11.booleanValue();
    L11:
        return r0.isSubtypeOfForSingleClassifierType(r4, r3.lowerBoundIfFlexible(r8), r3.upperBoundIfFlexible(r9));
    }

    private final Boolean checkSubtypeForIntegerLiteralType(TypeCheckerState r4, SimpleTypeMarker r5, SimpleTypeMarker r6) {
        TypeSystemContext r3 = r4.getTypeSystemContext();
        if (r3.isIntegerLiteralType(r5) == true) goto L8;
        if (r3.isIntegerLiteralType(r6) == true) goto L8;
        return null;
    L8:
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(r3, r5) == false) goto L14;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(r3, r6) == false) goto L14;
        return true;
    L14:
        if (r3.isIntegerLiteralType(r5) == false) goto L20;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(r3, r4, r5, r6, false) == true) goto L18;
    L27:
        return null;
    L18:
        return true;
    L20:
        if (r3.isIntegerLiteralType(r6) == false) goto L27;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(r3, r5) == true) goto L26;
        if (checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(r3, r4, r6, r5, true) == false) goto L27;
    L26:
        return true;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(TypeSystemContext r10, TypeCheckerState r11, SimpleTypeMarker r12, SimpleTypeMarker r13, boolean r14) {
        Collection<KotlinTypeMarker> r15 = r10.possibleIntegerTypes(r12);
        if ((r15 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r16 = r15.iterator();
    L9:
        if (r16.hasNext() == false) goto L27;
        KotlinTypeMarker r5 = (KotlinTypeMarker) r16.next();
        if (Intrinsics.areEqual(r10.typeConstructor(r5), r10.typeConstructor(r13)) == true) goto L17;
        if (r14 == true) goto L14;
    L16:
        boolean r0 = false;
    L18:
        if (r0 == false) goto L9;
        return true;
    L14:
        if (isSubtypeOf$default(INSTANCE, r11, r13, r5, false, 8, null) == false) goto L16;
    L17:
        r0 = true;
        goto L18
    L27:
        return false;
    L5:
        if (r15.isEmpty() == false) goto L7;
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(TypeSystemContext r3, SimpleTypeMarker r4) {
        TypeConstructorMarker r5 = r3.typeConstructor(r4);
        if ((r5 instanceof IntersectionTypeConstructorMarker) == false) goto L28;
        Collection<KotlinTypeMarker> r6 = r3.supertypes(r5);
        if ((r6 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L8;
        SimpleTypeMarker r0 = r3.asSimpleType((KotlinTypeMarker) r7.next());
        if (r0 != null) goto L15;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == false) goto L11;
        boolean r8 = true;
    L20:
        if (r8 == true) goto L22;
        return false;
    L22:
        return true;
    L15:
        if (r3.isIntegerLiteralType(r0) != true) goto L17;
        r1 = true;
    L8:
        r8 = false;
        goto L20
    L7:
        if (r6.isEmpty() == false) goto L9;
    L28:
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(TypeSystemContext r2, SimpleTypeMarker r3) {
        if ((r3 instanceof CapturedTypeMarker) == true) goto L5;
        return false;
    L5:
        TypeArgumentMarker r4 = r2.projection(r2.typeConstructor((CapturedTypeMarker) r3));
        if (r2.isStarProjection(r4) == false) goto L8;
        return false;
    L8:
        if (r2.isIntegerLiteralType(r2.upperBoundIfFlexible(r2.getType(r4))) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(TypeSystemContext r1, SimpleTypeMarker r2) {
        if (r1.isIntegerLiteralType(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(r1, r2) == true) goto L8;
        return false;
    }

    private final boolean hasNothingSupertype(TypeCheckerState r13, SimpleTypeMarker r14) {
        TypeSystemContext r12 = r13.getTypeSystemContext();
        TypeConstructorMarker r0 = r12.typeConstructor(r14);
        if (r12.isClassTypeConstructor(r0) == false) goto L7;
        return r12.isNothingConstructor(r0);
    L7:
        if (r12.isNothingConstructor(r12.typeConstructor(r14)) == true) goto L47;
        r13.initialize();
        ArrayDeque<SimpleTypeMarker> r1 = r13.getSupertypesDeque();
        Intrinsics.checkNotNull(r1);
        Set<SimpleTypeMarker> r2 = r13.getSupertypesSet();
        Intrinsics.checkNotNull(r2);
        r1.push(r14);
    L11:
        if ((!r1.isEmpty()) == false) goto L35;
        if (r2.size() > 1000) goto L34;
        SimpleTypeMarker r3 = r1.pop();
        Intrinsics.checkNotNullExpressionValue(r3, PerfConsts.KEY_CURRENT_GALVANIC);
        if (r2.add(r3) == false) goto L11;
        if (r12.isClassType(r3) == false) goto L19;
        TypeCheckerState.SupertypesPolicy.LowerIfFlexible r4 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L21:
        if ((!Intrinsics.areEqual(r4, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L24;
        r4 = null;
    L24:
        if (r4 == null) goto L11;
        TypeSystemContext r5 = r13.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r6 = r5.supertypes(r5.typeConstructor(r3)).iterator();
    L28:
        if (r6.hasNext() == false) goto L11;
        SimpleTypeMarker r7 = r4.mo2087transformType(r13, r6.next());
        if (r12.isNothingConstructor(r12.typeConstructor(r7)) == true) goto L31;
        r1.add(r7);
        goto L28
    L31:
        r13.clear();
        return true;
    L19:
        r4 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L21
    L34:
        throw new IllegalStateException(("Too many supertypes for type: " + r14 + ". Supertypes = " + CollectionsKt.joinToString$default(r2, null, null, null, 0, null, null, 63, null)).toString());
    L35:
        r13.clear();
        return false;
    L47:
        return true;
    }

    private final boolean isSubtypeOfForSingleClassifierType(final TypeCheckerState r17, SimpleTypeMarker r18, final SimpleTypeMarker r19) {
        final TypeSystemContext r3 = r17.getTypeSystemContext();
        if (RUN_SLOW_ASSERTIONS == true) goto L5;
    L12:
        boolean r5 = false;
        if (AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(r17, r18, r19) == true) goto L15;
        return false;
    L15:
        AbstractTypeChecker r4 = INSTANCE;
        SimpleTypeMarker r6 = r18;
        SimpleTypeMarker r8 = r19;
        Boolean r7 = r4.checkSubtypeForIntegerLiteralType(r17, r3.lowerBoundIfFlexible(r6), r3.upperBoundIfFlexible(r8));
        if (r7 == null) goto L19;
        boolean r9 = r7.booleanValue();
        TypeCheckerState.addSubtypeConstraint$default(r17, r6, r8, false, 4, null);
        return r9;
    L19:
        TypeConstructorMarker r10 = r3.typeConstructor(r19);
        boolean r11 = true;
        if (r3.areEqualTypeConstructors(r3.typeConstructor(r18), r10) == false) goto L25;
        if (r3.parametersCount(r10) != 0) goto L25;
        return true;
    L25:
        if (r3.isAnyConstructor(r3.typeConstructor(r19)) == false) goto L27;
        return true;
    L27:
        List<SimpleTypeMarker> r12 = r4.findCorrespondingSupertypes(r17, r18, r10);
        int r13 = 10;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r15 = r12.iterator();
    L29:
        if (r15.hasNext() == false) goto L35;
        SimpleTypeMarker r16 = (SimpleTypeMarker) r15.next();
        SimpleTypeMarker r110 = r3.asSimpleType(r17.prepareType(r16));
        if (r110 == null) goto L34;
        r16 = r110;
    L34:
        r14.add(r16);
        goto L29
    L35:
        final ArrayList r20 = r14;
        int r21 = r20.size();
        if (r21 == 0) goto L77;
        if (r21 == 1) goto L75;
        ArgumentList r22 = new ArgumentList(r3.parametersCount(r10));
        int r111 = r3.parametersCount(r10);
        int r112 = 0;
        boolean r113 = false;
    L39:
        if (r112 >= r111) goto L67;
        if (r113 == false) goto L42;
    L45:
        r113 = r11;
    L46:
        if (r113 == true) goto L66;
        ArrayList r114 = r20;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, r13));
        Iterator r116 = r114.iterator();
    L49:
        if (r116.hasNext() == false) goto L65;
        SimpleTypeMarker r117 = (SimpleTypeMarker) r116.next();
        TypeArgumentMarker r23 = r3.getArgumentOrNull(r117, r112);
        if (r23 == null) goto L64;
        if (r3.getVariance(r23) != TypeVariance.INV) goto L55;
        boolean r24 = true;
    L56:
        if (r24 == true) goto L59;
        r23 = null;
    L59:
        if (r23 == null) goto L64;
        KotlinTypeMarker r25 = r3.getType(r23);
        if (r25 == null) goto L64;
        r115.add(r25);
        goto L49
    L55:
        r24 = false;
    L64:
        throw new IllegalStateException(("Incorrect type: " + r117 + ", subType: " + r18 + ", superType: " + r19).toString());
    L65:
        r22.add(r3.asTypeArgument(r3.intersectTypes(r115)));
    L66:
        r112 = r112 + 1;
        r5 = false;
        r11 = true;
        r13 = 10;
        goto L39
    L42:
        if (r3.getVariance(r3.getParameter(r10, r112)) != TypeVariance.OUT) goto L45;
        r113 = r5;
        goto L46
    L67:
        if (r113 == true) goto L73;
        if (INSTANCE.isSubtypeForSameConstructor(r17, r22, r19) == false) goto L73;
        return true;
    L73:
        return r17.runForkingPoint(new AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$4(r20, r17, r3, r19));
    L75:
        return INSTANCE.isSubtypeForSameConstructor(r17, r3.asArgumentList((SimpleTypeMarker) CollectionsKt.first(r20)), r19);
    L77:
        return INSTANCE.hasNothingSupertype(r17, r18);
    L5:
        if (r3.isSingleClassifierType(r18) == true) goto L10;
        if (r3.isIntersection(r3.typeConstructor(r18)) == true) goto L10;
        r17.isAllowedTypeVariable(r18);
    L10:
        if (r3.isSingleClassifierType(r19) == true) goto L12;
        r17.isAllowedTypeVariable(r19);
        goto L12
    }

    private final boolean isTypeVariableAgainstStarProjectionForSelfType(TypeSystemContext r2, KotlinTypeMarker r3, KotlinTypeMarker r4, TypeConstructorMarker r5) {
        SimpleTypeMarker r1 = r2.asSimpleType(r3);
        if ((r1 instanceof CapturedTypeMarker) == false) goto L24;
        CapturedTypeMarker r6 = (CapturedTypeMarker) r1;
        if (r2.isOldCapturedType(r6) == false) goto L7;
        return false;
    L7:
        if (r2.isStarProjection(r2.projection(r2.typeConstructor(r6))) == true) goto L10;
        return false;
    L10:
        if (r2.captureStatus(r6) == CaptureStatus.FOR_SUBTYPING) goto L12;
        return false;
    L12:
        TypeConstructorMarker r7 = r2.typeConstructor(r4);
        if ((r7 instanceof TypeVariableTypeConstructorMarker) == false) goto L15;
        TypeVariableTypeConstructorMarker r8 = (TypeVariableTypeConstructorMarker) r7;
    L16:
        if (r8 != null) goto L18;
        return false;
    L18:
        TypeParameterMarker r9 = r2.getTypeParameter(r8);
        if (r9 != null) goto L21;
        return false;
    L21:
        if (r2.hasRecursiveBounds(r9, r5) == true) goto L23;
        return false;
    L23:
        return true;
    L15:
        r8 = null;
        goto L16
    L24:
        return false;
    }

    public final boolean isSubtypeForSameConstructor(TypeCheckerState r17, TypeArgumentListMarker r18, SimpleTypeMarker r19) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r18, "capturedSubArguments");
        Intrinsics.checkNotNullParameter(r19, "superType");
        TypeSystemContext r9 = r17.getTypeSystemContext();
        TypeConstructorMarker r10 = r9.typeConstructor(r19);
        int r1 = r9.size(r18);
        int r11 = r9.parametersCount(r10);
        if (r1 != r11) goto L46;
        SimpleTypeMarker r13 = r19;
        if (r1 != r9.argumentsCount(r13)) goto L46;
        int r14 = 0;
    L9:
        if (r14 >= r11) goto L45;
        TypeArgumentMarker r2 = r9.getArgument(r13, r14);
        if (r9.isStarProjection(r2) == true) goto L44;
        KotlinTypeMarker r3 = r9.getType(r2);
        TypeArgumentMarker r4 = r9.get(r18, r14);
        r9.getVariance(r4);
        TypeVariance r5 = TypeVariance.INV;
        KotlinTypeMarker r6 = r9.getType(r4);
        AbstractTypeChecker r7 = INSTANCE;
        TypeVariance r8 = r7.effectiveVariance(r9.getVariance(r9.getParameter(r10, r14)), r9.getVariance(r2));
        if (r8 == null) goto L15;
        if (r8 == TypeVariance.INV) goto L19;
    L23:
        boolean r12 = false;
    L24:
        if (r12 == true) goto L44;
        if (TypeCheckerState.access$getArgumentsDepth(r17) > 100) goto L43;
        TypeCheckerState.access$setArgumentsDepth(r17, TypeCheckerState.access$getArgumentsDepth(r17) + 1);
        int r15 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
        if (r15 != 1) goto L31;
        boolean r0 = r7.equalTypes(r17, r6, r3);
    L39:
        TypeCheckerState.access$setArgumentsDepth(r17, TypeCheckerState.access$getArgumentsDepth(r17) - 1);
        if (r0 == true) goto L44;
        return false;
    L31:
        if (r15 != 2) goto L33;
        r0 = isSubtypeOf$default(r7, r17, r6, r3, false, 8, null);
        goto L39
    L33:
        if (r15 != 3) goto L36;
        r0 = isSubtypeOf$default(r7, r17, r3, r6, false, 8, null);
        goto L39
    L36:
        throw new NoWhenBranchMatchedException();
    L43:
        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + r6).toString());
    L19:
        if (r7.isTypeVariableAgainstStarProjectionForSelfType(r9, r6, r3, r10) == false) goto L21;
    L22:
        r12 = true;
        goto L24
    L21:
        if (r7.isTypeVariableAgainstStarProjectionForSelfType(r9, r3, r6, r10) == false) goto L23;
    L15:
        return r17.isErrorTypeEqualsToAnything();
    L44:
        r14 = r14 + 1;
        goto L9
    L45:
        return true;
    L46:
        return false;
    }

    private final boolean isCommonDenotableType(TypeSystemContext r1, KotlinTypeMarker r2) {
        if (r1.isDenotable(r1.typeConstructor(r2)) == true) goto L5;
    L13:
        return false;
    L5:
        if (r1.isDynamic(r2) == true) goto L13;
        if (r1.isDefinitelyNotNullType(r2) == true) goto L13;
        if (r1.isNotNullTypeParameter(r2) == true) goto L13;
        if (Intrinsics.areEqual(r1.typeConstructor(r1.lowerBoundIfFlexible(r2)), r1.typeConstructor(r1.upperBoundIfFlexible(r2))) == false) goto L13;
        return true;
    }

    public final TypeVariance effectiveVariance(TypeVariance r1, TypeVariance r2) {
        Intrinsics.checkNotNullParameter(r1, "declared");
        Intrinsics.checkNotNullParameter(r2, "useSite");
        if (r1 != TypeVariance.INV) goto L6;
        return r2;
    L6:
        if (r2 != TypeVariance.INV) goto L8;
        return r1;
    L8:
        if (r1 != r2) goto L10;
        return r1;
    L10:
        return null;
    }

    private final boolean isStubTypeSubtypeOfAnother(TypeSystemContext r3, SimpleTypeMarker r4, SimpleTypeMarker r5) {
        DefinitelyNotNullTypeMarker r2 = r3.asDefinitelyNotNullType(r4);
        if (r2 == null) goto L6;
        SimpleTypeMarker r6 = r3.original(r2);
        if (r6 == null) goto L6;
    L7:
        DefinitelyNotNullTypeMarker r0 = r3.asDefinitelyNotNullType(r5);
        if (r0 == null) goto L11;
        SimpleTypeMarker r1 = r3.original(r0);
        if (r1 == null) goto L11;
    L13:
        if (r3.typeConstructor(r6) == r3.typeConstructor(r1)) goto L16;
        return false;
    L16:
        if (r3.isDefinitelyNotNullType(r4) == true) goto L21;
        if (r3.isDefinitelyNotNullType(r5) == false) goto L21;
        return false;
    L21:
        if (r3.isMarkedNullable(r4) == true) goto L23;
        return true;
    L23:
        if (r3.isMarkedNullable(r5) == true) goto L27;
        return false;
    L27:
        return true;
    L11:
        r1 = r5;
    L6:
        r6 = r4;
        goto L7
    }

    private final Boolean checkSubtypeForSpecialCases(TypeCheckerState r18, SimpleTypeMarker r19, SimpleTypeMarker r20) {
        TypeSystemContext r2 = r18.getTypeSystemContext();
        SimpleTypeMarker r10 = r19;
        boolean r11 = false;
        if (r2.isError(r10) == true) goto L89;
        SimpleTypeMarker r14 = r20;
        if (r2.isError(r14) == true) goto L89;
        if (r2.isStubTypeForBuilderInference(r19) == false) goto L19;
        if (r2.isStubTypeForBuilderInference(r20) == false) goto L19;
        if (INSTANCE.isStubTypeSubtypeOfAnother(r2, r19, r20) == false) goto L14;
    L15:
        r11 = true;
    L17:
        return Boolean.valueOf(r11);
    L14:
        if (r18.isStubTypeEqualsToAnything() == false) goto L17;
    L19:
        if (r2.isStubType(r19) == true) goto L87;
        if (r2.isStubType(r20) == true) goto L87;
        DefinitelyNotNullTypeMarker r3 = r2.asDefinitelyNotNullType(r20);
        if (r3 == null) goto L27;
        SimpleTypeMarker r4 = r2.original(r3);
        if (r4 == null) goto L27;
    L28:
        CapturedTypeMarker r5 = r2.asCapturedType(r4);
        if (r5 == null) goto L31;
        KotlinTypeMarker r6 = r2.lowerType(r5);
    L32:
        if (r5 == null) goto L51;
        if (r6 == null) goto L51;
        if (r2.isMarkedNullable(r20) == false) goto L39;
        r6 = r2.withNullability(r6, true);
    L37:
        KotlinTypeMarker r7 = r6;
        int r8 = WhenMappings.$EnumSwitchMapping$1[r18.getLowerCapturedTypePolicy(r19, r5).ordinal()];
        if (r8 == 1) goto L50;
        if (r8 != 2) goto L51;
        if (isSubtypeOf$default(INSTANCE, r18, r10, r7, false, 8, null) == false) goto L51;
        return true;
    L50:
        return Boolean.valueOf(isSubtypeOf$default(INSTANCE, r18, r10, r7, false, 8, null));
    L39:
        if (r2.isDefinitelyNotNullType(r14) == false) goto L37;
        r6 = r2.makeDefinitelyNotNullOrNotNull(r6);
    L51:
        TypeConstructorMarker r9 = r2.typeConstructor(r20);
        if (r2.isIntersection(r9) == false) goto L65;
        r2.isMarkedNullable(r20);
        Collection<KotlinTypeMarker> r0 = r2.supertypes(r9);
        if ((r0 instanceof Collection) == true) goto L56;
    L58:
        Iterator<T> r1 = r0.iterator();
    L60:
        if (r1.hasNext() == false) goto L57;
        if (isSubtypeOf$default(INSTANCE, r18, r10, (KotlinTypeMarker) r1.next(), false, 8, null) == true) goto L60;
    L64:
        return Boolean.valueOf(r11);
    L57:
        r11 = true;
        goto L64
    L56:
        if (r0.isEmpty() == false) goto L58;
    L65:
        TypeConstructorMarker r12 = r2.typeConstructor(r19);
        if ((r19 instanceof CapturedTypeMarker) == false) goto L68;
    L80:
        TypeParameterMarker r13 = INSTANCE.getTypeParameterForArgumentInBaseIfItEqualToTarget(r18.getTypeSystemContext(), r14, r10);
        if (r13 != null) goto L83;
    L85:
        return null;
    L83:
        if (r2.hasRecursiveBounds(r13, r2.typeConstructor(r20)) == false) goto L85;
        return true;
    L68:
        if (r2.isIntersection(r12) == false) goto L85;
        Collection<KotlinTypeMarker> r15 = r2.supertypes(r12);
        if ((r15 instanceof Collection) == true) goto L72;
    L74:
        Iterator<T> r16 = r15.iterator();
    L76:
        if (r16.hasNext() == false) goto L73;
        if ((((KotlinTypeMarker) r16.next()) instanceof CapturedTypeMarker) == true) goto L76;
    L79:
        if (r11 == false) goto L85;
    L73:
        r11 = true;
        goto L79
    L72:
        if (r15.isEmpty() == false) goto L74;
    L31:
        r6 = null;
    L27:
        r4 = r20;
    L87:
        return Boolean.valueOf(r18.isStubTypeEqualsToAnything());
    L89:
        if (r18.isErrorTypeEqualsToAnything() == false) goto L92;
        return true;
    L92:
        if (r2.isMarkedNullable(r19) == false) goto L98;
        if (r2.isMarkedNullable(r20) == true) goto L98;
        return false;
    L98:
        return Boolean.valueOf(AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(r2, r2.withNullability(r19, false), r2.withNullability(r20, false)));
    }

    private final TypeParameterMarker getTypeParameterForArgumentInBaseIfItEqualToTarget(TypeSystemContext r8, KotlinTypeMarker r9, KotlinTypeMarker r10) {
        int r0 = r8.argumentsCount(r9);
        int r2 = 0;
    L3:
        TypeArgumentMarker r3 = null;
        if (r2 >= r0) goto L30;
        TypeArgumentMarker r4 = r8.getArgument(r9, r2);
        boolean r6 = true;
        if ((!r8.isStarProjection(r4)) == false) goto L8;
        r3 = r4;
    L8:
        if (r3 == null) goto L29;
        KotlinTypeMarker r5 = r8.getType(r3);
        if (r5 == null) goto L29;
        if (r8.isCapturedType(r8.lowerBoundIfFlexible(r5)) == true) goto L15;
    L17:
        r6 = false;
    L19:
        if (Intrinsics.areEqual(r5, r10) == true) goto L28;
        if (r6 == true) goto L22;
    L24:
        TypeParameterMarker r7 = getTypeParameterForArgumentInBaseIfItEqualToTarget(r8, r5, r10);
        if (r7 == null) goto L29;
        return r7;
    L22:
        if (Intrinsics.areEqual(r8.typeConstructor(r5), r8.typeConstructor(r10)) == false) goto L24;
    L28:
        return r8.getParameter(r8.typeConstructor(r9), r2);
    L15:
        if (r8.isCapturedType(r8.lowerBoundIfFlexible(r10)) == false) goto L17;
    L29:
        r2 = r2 + 1;
        goto L3
    L30:
        return null;
    }

    private final List<SimpleTypeMarker> collectAllSupertypesWithGivenTypeConstructor(TypeCheckerState r13, SimpleTypeMarker r14, TypeConstructorMarker r15) {
        TypeSystemContext r12 = r13.getTypeSystemContext();
        List<SimpleTypeMarker> r0 = r12.fastCorrespondingSupertypes(r14, r15);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (r12.isClassTypeConstructor(r15) == true) goto L12;
        if (r12.isClassType(r14) == false) goto L12;
        return CollectionsKt.emptyList();
    L12:
        if (r12.isCommonFinalClassConstructor(r15) == true) goto L14;
        SmartList r1 = new SmartList();
        r13.initialize();
        ArrayDeque<SimpleTypeMarker> r2 = r13.getSupertypesDeque();
        Intrinsics.checkNotNull(r2);
        Set<SimpleTypeMarker> r3 = r13.getSupertypesSet();
        Intrinsics.checkNotNull(r3);
        r2.push(r14);
    L24:
        if ((!r2.isEmpty()) == false) goto L51;
        if (r3.size() > 1000) goto L50;
        SimpleTypeMarker r4 = r2.pop();
        Intrinsics.checkNotNullExpressionValue(r4, PerfConsts.KEY_CURRENT_GALVANIC);
        if (r3.add(r4) == false) goto L24;
        SimpleTypeMarker r5 = r12.captureFromArguments(r4, CaptureStatus.FOR_SUBTYPING);
        if (r5 != null) goto L33;
        r5 = r4;
    L33:
        if (r12.areEqualTypeConstructors(r12.typeConstructor(r5), r15) == false) goto L36;
        r1.add(r5);
        TypeCheckerState.SupertypesPolicy.LowerIfFlexible r6 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L40:
        if ((!Intrinsics.areEqual(r6, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L43;
        r6 = null;
    L43:
        if (r6 == null) goto L24;
        TypeSystemContext r7 = r13.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r8 = r7.supertypes(r7.typeConstructor(r4)).iterator();
    L47:
        if (r8.hasNext() == false) goto L24;
        r2.add(r6.mo2087transformType(r13, r8.next()));
        goto L47
    L36:
        if (r12.argumentsCount(r5) != 0) goto L38;
        r6 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L40
    L38:
        r6 = r13.getTypeSystemContext().substitutionSupertypePolicy(r5);
        goto L40
    L50:
        throw new IllegalStateException(("Too many supertypes for type: " + r14 + ". Supertypes = " + CollectionsKt.joinToString$default(r3, null, null, null, 0, null, null, 63, null)).toString());
    L51:
        r13.clear();
        return r1;
    L14:
        if (r12.areEqualTypeConstructors(r12.typeConstructor(r14), r15) == false) goto L21;
        SimpleTypeMarker r16 = r12.captureFromArguments(r14, CaptureStatus.FOR_SUBTYPING);
        if (r16 == null) goto L61;
        r14 = r16;
    L61:
        return CollectionsKt.listOf(r14);
    L21:
        return CollectionsKt.emptyList();
    }

    private final List<SimpleTypeMarker> collectAndFilter(TypeCheckerState r1, SimpleTypeMarker r2, TypeConstructorMarker r3) {
        return selectOnlyPureKotlinSupertypes(r1, collectAllSupertypesWithGivenTypeConstructor(r1, r2, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<SimpleTypeMarker> selectOnlyPureKotlinSupertypes(TypeCheckerState r9, List<? extends SimpleTypeMarker> r10) {
        TypeSystemContext r8 = r9.getTypeSystemContext();
        if (r10.size() >= 2) goto L5;
        return r10;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator r11 = r10.iterator();
    L6:
        boolean r2 = true;
        if (r11.hasNext() == false) goto L19;
        Object r1 = r11.next();
        TypeArgumentListMarker r3 = r8.asArgumentList((SimpleTypeMarker) r1);
        int r4 = r8.size(r3);
        int r6 = 0;
    L9:
        if (r6 >= r4) goto L17;
        if (r8.asFlexibleType(r8.getType(r8.get(r3, r6))) != null) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L15;
        r6 = r6 + 1;
        goto L9
    L15:
        r2 = false;
        goto L17
    L13:
        r7 = false;
    L17:
        if (r2 == false) goto L6;
        r0.add(r1);
        goto L6
    L19:
        ArrayList r5 = r0;
        if ((!r5.isEmpty()) == true) goto L22;
        return r10;
    L22:
        return r5;
    }

    public final List<SimpleTypeMarker> findCorrespondingSupertypes(TypeCheckerState r13, SimpleTypeMarker r14, TypeConstructorMarker r15) {
        Intrinsics.checkNotNullParameter(r13, "state");
        Intrinsics.checkNotNullParameter(r14, "subType");
        Intrinsics.checkNotNullParameter(r15, "superConstructor");
        TypeSystemContext r12 = r13.getTypeSystemContext();
        if (r12.isClassType(r14) == false) goto L7;
        return INSTANCE.collectAndFilter(r13, r14, r15);
    L7:
        if (r12.isClassTypeConstructor(r15) == false) goto L9;
    L12:
        SmartList r0 = new SmartList();
        r13.initialize();
        ArrayDeque<SimpleTypeMarker> r1 = r13.getSupertypesDeque();
        Intrinsics.checkNotNull(r1);
        Set<SimpleTypeMarker> r2 = r13.getSupertypesSet();
        Intrinsics.checkNotNull(r2);
        r1.push(r14);
    L14:
        if ((!r1.isEmpty()) == false) goto L35;
        if (r2.size() > 1000) goto L34;
        SimpleTypeMarker r3 = r1.pop();
        Intrinsics.checkNotNullExpressionValue(r3, PerfConsts.KEY_CURRENT_GALVANIC);
        if (r2.add(r3) == false) goto L14;
        if (r12.isClassType(r3) == false) goto L22;
        r0.add(r3);
        TypeCheckerState.SupertypesPolicy.LowerIfFlexible r4 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L24:
        if ((!Intrinsics.areEqual(r4, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L27;
        r4 = null;
    L27:
        if (r4 == null) goto L14;
        TypeSystemContext r5 = r13.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r6 = r5.supertypes(r5.typeConstructor(r3)).iterator();
    L31:
        if (r6.hasNext() == false) goto L14;
        r1.add(r4.mo2087transformType(r13, r6.next()));
        goto L31
    L22:
        r4 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L24
    L34:
        throw new IllegalStateException(("Too many supertypes for type: " + r14 + ". Supertypes = " + CollectionsKt.joinToString$default(r2, null, null, null, 0, null, null, 63, null)).toString());
    L35:
        r13.clear();
        ArrayList r16 = new ArrayList();
        Iterator<E> r17 = r0.iterator();
    L37:
        if (r17.hasNext() == false) goto L40;
        SimpleTypeMarker r7 = (SimpleTypeMarker) r17.next();
        AbstractTypeChecker r8 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r7, "it");
        CollectionsKt.addAll(r16, r8.collectAndFilter(r13, r7, r15));
        goto L37
    L40:
        return r16;
    L9:
        if (r12.isIntegerLiteralTypeConstructor(r15) == true) goto L12;
        return INSTANCE.collectAllSupertypesWithGivenTypeConstructor(r13, r14, r15);
    }
}
