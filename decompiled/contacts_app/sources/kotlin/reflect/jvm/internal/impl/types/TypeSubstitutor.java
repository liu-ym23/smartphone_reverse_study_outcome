package kotlin.reflect.jvm.internal.impl.types;

import com.obric.contactsdk.loader.ContractKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;

/* JADX INFO: loaded from: classes4.dex */
public class TypeSubstitutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TypeSubstitutor EMPTY = null;
    private final TypeSubstitution substitution;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType = null;

        static {
            int[] r0 = new int[VarianceConflictType.values().length];
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType = r0;
            r0[VarianceConflictType.OUT_IN_IN_POSITION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[VarianceConflictType.IN_IN_OUT_POSITION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[VarianceConflictType.NO_CONFLICT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static final class SubstitutionException extends Exception {
        public SubstitutionException(String r1) {
            super(r1);
        }
    }

    private static final enum VarianceConflictType extends Enum<VarianceConflictType> {
        private static final /* synthetic */ VarianceConflictType[] $VALUES = null;
        public static final VarianceConflictType IN_IN_OUT_POSITION = null;
        public static final VarianceConflictType NO_CONFLICT = null;
        public static final VarianceConflictType OUT_IN_IN_POSITION = null;

        private VarianceConflictType(String r1, int r2) {
            super(r1, r2);
        }

        public static VarianceConflictType valueOf(String r1) {
            return (VarianceConflictType) Enum.valueOf(VarianceConflictType.class, r1);
        }

        public static VarianceConflictType[] values() {
            return (VarianceConflictType[]) $VALUES.clone();
        }

        static {
            VarianceConflictType r0 = new VarianceConflictType("NO_CONFLICT", 0);
            NO_CONFLICT = r0;
            VarianceConflictType r1 = new VarianceConflictType("IN_IN_OUT_POSITION", 1);
            IN_IN_OUT_POSITION = r1;
            VarianceConflictType r3 = new VarianceConflictType("OUT_IN_IN_POSITION", 2);
            OUT_IN_IN_POSITION = r3;
            $VALUES = new VarianceConflictType[]{r0, r1, r3};
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r13) {
        if (r13 == 1) goto L13;
        if (r13 == 2) goto L13;
        if (r13 == 8) goto L13;
        if (r13 == 34) goto L13;
        if (r13 == 37) goto L13;
        switch(r13) {
            case 11: goto L13;
            case 12: goto L13;
            case 13: goto L13;
            default: goto L9;
        };
    L9:
        switch(r13) {
            case 19: goto L13;
            case 20: goto L13;
            case 21: goto L13;
            case 22: goto L13;
            case 23: goto L13;
            case 24: goto L13;
            case 25: goto L13;
            default: goto L10;
        };
    L10:
        switch(r13) {
            case 29: goto L13;
            case 30: goto L13;
            case 31: goto L13;
            case 32: goto L13;
            default: goto L11;
        };
    L11:
        switch(r13) {
            case 40: goto L13;
            case 41: goto L13;
            case 42: goto L13;
            default: goto L12;
        };
    L12:
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L14:
        if (r13 == 1) goto L24;
        if (r13 == 2) goto L85;
        if (r13 == 8) goto L86;
        if (r13 == 34) goto L87;
        if (r13 == 37) goto L88;
        switch(r13) {
            case 11: goto L89;
            case 12: goto L89;
            case 13: goto L89;
            default: goto L20;
        };
    L20:
        switch(r13) {
            case 19: goto L90;
            case 20: goto L90;
            case 21: goto L90;
            case 22: goto L90;
            case 23: goto L90;
            case 24: goto L90;
            case 25: goto L90;
            default: goto L21;
        };
    L21:
        switch(r13) {
            case 29: goto L91;
            case 30: goto L91;
            case 31: goto L91;
            case 32: goto L91;
            default: goto L22;
        };
    L22:
        switch(r13) {
            case 40: goto L92;
            case 41: goto L92;
            case 42: goto L92;
            default: goto L23;
        };
    L23:
        int r6 = 3;
    L25:
        Object[] r7 = new Object[r6];
        switch(r13) {
            case 1: goto L41;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L27;
            case 8: goto L41;
            case 9: goto L36;
            case 10: goto L35;
            case 11: goto L41;
            case 12: goto L41;
            case 13: goto L41;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L34;
            case 17: goto L34;
            case 18: goto L33;
            case 19: goto L41;
            case 20: goto L41;
            case 21: goto L41;
            case 22: goto L41;
            case 23: goto L41;
            case 24: goto L41;
            case 25: goto L41;
            case 26: goto L32;
            case 27: goto L31;
            case 28: goto L33;
            case 29: goto L41;
            case 30: goto L41;
            case 31: goto L41;
            case 32: goto L41;
            case 33: goto L30;
            case 34: goto L41;
            case 35: goto L29;
            case 36: goto L34;
            case 37: goto L41;
            case 38: goto L29;
            case 39: goto L28;
            case 40: goto L41;
            case 41: goto L41;
            case 42: goto L41;
            default: goto L27;
        };
    L27:
        r7[0] = "substitution";
    L43:
        if (r13 == 1) goto L60;
        if (r13 == 2) goto L59;
        if (r13 == 8) goto L58;
        if (r13 == 34) goto L57;
        if (r13 == 37) goto L56;
        switch(r13) {
            case 11: goto L55;
            case 12: goto L55;
            case 13: goto L55;
            default: goto L49;
        };
    L49:
        switch(r13) {
            case 19: goto L54;
            case 20: goto L54;
            case 21: goto L54;
            case 22: goto L54;
            case 23: goto L54;
            case 24: goto L54;
            case 25: goto L54;
            default: goto L50;
        };
    L50:
        switch(r13) {
            case 29: goto L53;
            case 30: goto L53;
            case 31: goto L53;
            case 32: goto L53;
            default: goto L51;
        };
    L51:
        switch(r13) {
            case 40: goto L56;
            case 41: goto L56;
            case 42: goto L56;
            default: goto L52;
        };
    L52:
        r7[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
    L61:
        switch(r13) {
            case 1: goto L72;
            case 2: goto L72;
            case 3: goto L71;
            case 4: goto L71;
            case 5: goto L62;
            case 6: goto L62;
            case 7: goto L70;
            case 8: goto L72;
            case 9: goto L69;
            case 10: goto L69;
            case 11: goto L72;
            case 12: goto L72;
            case 13: goto L72;
            case 14: goto L68;
            case 15: goto L68;
            case 16: goto L68;
            case 17: goto L67;
            case 18: goto L66;
            case 19: goto L72;
            case 20: goto L72;
            case 21: goto L72;
            case 22: goto L72;
            case 23: goto L72;
            case 24: goto L72;
            case 25: goto L72;
            case 26: goto L65;
            case 27: goto L65;
            case 28: goto L65;
            case 29: goto L72;
            case 30: goto L72;
            case 31: goto L72;
            case 32: goto L72;
            case 33: goto L64;
            case 34: goto L72;
            case 35: goto L63;
            case 36: goto L63;
            case 37: goto L72;
            case 38: goto L63;
            case 39: goto L63;
            case 40: goto L72;
            case 41: goto L72;
            case 42: goto L72;
            default: goto L62;
        };
    L62:
        r7[2] = ContractKt.OBRIC_ACTION_CREATE;
        goto L72
    L63:
        r7[2] = "combine";
        goto L72
    L64:
        r7[2] = "filterOutUnsafeVariance";
        goto L72
    L65:
        r7[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
        goto L72
    L66:
        r7[2] = "unsafeSubstitute";
        goto L72
    L67:
        r7[2] = "substituteWithoutApproximation";
        goto L72
    L68:
        r7[2] = "substitute";
        goto L72
    L69:
        r7[2] = "safeSubstitute";
        goto L72
    L70:
        r7[2] = "<init>";
        goto L72
    L71:
        r7[2] = "createChainedSubstitutor";
    L72:
        String r8 = String.format(r5, r7);
        if (r13 == 1) goto L84;
        if (r13 == 2) goto L84;
        if (r13 == 8) goto L84;
        if (r13 == 34) goto L84;
        if (r13 == 37) goto L84;
        switch(r13) {
            case 11: goto L84;
            case 12: goto L84;
            case 13: goto L84;
            default: goto L79;
        };
    L79:
        switch(r13) {
            case 19: goto L84;
            case 20: goto L84;
            case 21: goto L84;
            case 22: goto L84;
            case 23: goto L84;
            case 24: goto L84;
            case 25: goto L84;
            default: goto L80;
        };
    L80:
        switch(r13) {
            case 29: goto L84;
            case 30: goto L84;
            case 31: goto L84;
            case 32: goto L84;
            default: goto L81;
        };
    L81:
        switch(r13) {
            case 40: goto L84;
            case 41: goto L84;
            case 42: goto L84;
            default: goto L93;
        };
    L93:
        throw new IllegalArgumentException(r8);
    L84:
        throw new IllegalStateException(r8);
    L53:
        r7[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
        goto L61
    L54:
        r7[1] = "unsafeSubstitute";
        goto L61
    L55:
        r7[1] = "safeSubstitute";
    L56:
        r7[1] = "combine";
        goto L61
    L57:
        r7[1] = "filterOutUnsafeVariance";
        goto L61
    L58:
        r7[1] = "getSubstitution";
        goto L61
    L59:
        r7[1] = "replaceWithContravariantApproximatingSubstitution";
        goto L61
    L60:
        r7[1] = "replaceWithNonApproximatingSubstitution";
        goto L61
    L28:
        r7[0] = "projectionKind";
        goto L43
    L29:
        r7[0] = "typeParameterVariance";
        goto L43
    L30:
        r7[0] = "annotations";
        goto L43
    L31:
        r7[0] = "substituted";
        goto L43
    L32:
        r7[0] = "originalType";
        goto L43
    L33:
        r7[0] = "originalProjection";
        goto L43
    L34:
        r7[0] = "typeProjection";
        goto L43
    L35:
        r7[0] = "howThisTypeIsUsed";
        goto L43
    L36:
        r7[0] = "type";
        goto L43
    L37:
        r7[0] = "context";
        goto L43
    L38:
        r7[0] = "substitutionContext";
        goto L43
    L39:
        r7[0] = "second";
        goto L43
    L40:
        r7[0] = "first";
        goto L43
    L41:
        r7[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
        goto L43
    L92:
        r6 = 2;
        goto L25
    L91:
        r6 = 2;
        goto L25
    L90:
        r6 = 2;
        goto L25
    L89:
        r6 = 2;
        goto L25
    L88:
        r6 = 2;
        goto L25
    L87:
        r6 = 2;
        goto L25
    L86:
        r6 = 2;
        goto L25
    L85:
        r6 = 2;
        goto L25
    L24:
        r6 = 2;
    L13:
        r5 = "@NotNull method %s.%s must not return null";
        goto L14
    }

    static {
        EMPTY = create(TypeSubstitution.EMPTY);
    }

    public static TypeSubstitutor create(TypeSubstitution r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new TypeSubstitutor(r1);
    }

    public TypeSubstitutor replaceWithNonApproximatingSubstitution() {
        TypeSubstitution r0 = this.substitution;
        if ((r0 instanceof IndexedParametersSubstitution) == true) goto L5;
    L9:
        return this;
    L5:
        if (r0.approximateContravariantCapturedTypes() == false) goto L9;
        return new TypeSubstitutor(new IndexedParametersSubstitution(((IndexedParametersSubstitution) this.substitution).getParameters(), ((IndexedParametersSubstitution) this.substitution).getArguments(), false));
    }

    public static TypeSubstitutor createChainedSubstitutor(TypeSubstitution r1, TypeSubstitution r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r2 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return create(DisjointKeysUnionTypeSubstitution.create(r1, r2));
    }

    public static TypeSubstitutor create(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return create(TypeConstructorSubstitution.create(r1.getConstructor(), r1.getArguments()));
    }

    protected TypeSubstitutor(TypeSubstitution r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        this.substitution = r2;
    }

    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    public TypeSubstitution getSubstitution() {
        TypeSubstitution r1 = this.substitution;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r1;
    }

    public KotlinType safeSubstitute(KotlinType r3, Variance r4) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        if (r4 != null) goto L7;
        $$$reportNull$$$0(10);
    L7:
        if (isEmpty() == false) goto L21;
        if (r3 != null) goto L10;
        $$$reportNull$$$0(11);
    L10:
        return r3;
    L21:
        KotlinType r2 = unsafeSubstitute(new TypeProjectionImpl(r4, r3), null, 0).getType();     // Catch: SubstitutionException -> L16
        if (r2 != null) goto L15;
        $$$reportNull$$$0(12);
    L15:
        return r2;
    L16:
        e = move-exception;
        ErrorType r5 = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, new String[]{e.getMessage()});
        if (r5 != null) goto L20;
        $$$reportNull$$$0(13);
    L20:
        return r5;
    }

    public KotlinType substitute(KotlinType r3, Variance r4) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        if (r4 != null) goto L6;
        $$$reportNull$$$0(15);
    L6:
        TypeProjection r2 = substitute(new TypeProjectionImpl(r4, getSubstitution().prepareTopLevelType(r3, r4)));
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.getType();
    }

    public TypeProjection substitute(TypeProjection r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(16);
    L4:
        TypeProjection r3 = substituteWithoutApproximation(r2);
        if (this.substitution.approximateCapturedTypes() == true) goto L10;
        if (this.substitution.approximateContravariantCapturedTypes() == true) goto L10;
        return r3;
    L10:
        return CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary(r3, this.substitution.approximateContravariantCapturedTypes());
    }

    public TypeProjection substituteWithoutApproximation(TypeProjection r3) {
        if (r3 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        if (isEmpty() == false) goto L11;
        return r3;
    L11:
        return unsafeSubstitute(r3, null, 0);
    L10:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private TypeProjection unsafeSubstitute(TypeProjection r7, TypeParameterDescriptor r8, int r9) throws SubstitutionException {
        if (r7 != null) goto L4;
        $$$reportNull$$$0(18);
    L4:
        assertRecursionDepth(r9, r7, this.substitution);
        if (r7.isStarProjection() == false) goto L9;
        if (r7 != null) goto L8;
        $$$reportNull$$$0(19);
    L8:
        return r7;
    L9:
        KotlinType r0 = r7.getType();
        if ((r0 instanceof TypeWithEnhancement) == false) goto L19;
        TypeWithEnhancement r1 = (TypeWithEnhancement) r0;
        UnwrappedType r2 = r1.getOrigin();
        KotlinType r3 = r1.getEnhancement();
        TypeProjection r10 = unsafeSubstitute(new TypeProjectionImpl(r7.getProjectionKind(), r2), r8, r9 + 1);
        if (r10.isStarProjection() == false) goto L17;
        if (r10 != null) goto L15;
        $$$reportNull$$$0(20);
    L15:
        return r10;
    L17:
        return new TypeProjectionImpl(r10.getProjectionKind(), TypeWithEnhancementKt.wrapEnhancement(r10.getType().unwrap(), substitute(r3, r7.getProjectionKind())));
    L19:
        if (DynamicTypesKt.isDynamic(r0) == false) goto L21;
    L81:
        if (r7 != null) goto L83;
        $$$reportNull$$$0(21);
    L83:
        return r7;
    L21:
        if ((r0.unwrap() instanceof RawType) == true) goto L81;
        TypeProjection r4 = this.substitution.mo2088get(r0);
        if (r4 == null) goto L26;
        TypeProjection r5 = projectedTypeForConflictedTypeWithUnsafeVariance(r0, r4, r8, r7);
    L27:
        Variance r6 = r7.getProjectionKind();
        if (r5 != null) goto L43;
        if (FlexibleTypesKt.isFlexible(r0) == false) goto L43;
        if (TypeCapabilitiesKt.isCustomTypeParameter(r0) == true) goto L43;
        FlexibleType r11 = FlexibleTypesKt.asFlexibleType(r0);
        int r12 = r9 + 1;
        TypeProjection r13 = unsafeSubstitute(new TypeProjectionImpl(r6, r11.getLowerBound()), r8, r12);
        TypeProjection r14 = unsafeSubstitute(new TypeProjectionImpl(r6, r11.getUpperBound()), r8, r12);
        Variance r15 = r13.getProjectionKind();
        if (r13.getType() != r11.getLowerBound()) goto L41;
        if (r14.getType() != r11.getUpperBound()) goto L41;
        if (r7 != null) goto L39;
        $$$reportNull$$$0(22);
    L39:
        return r7;
    L41:
        return new TypeProjectionImpl(r15, KotlinTypeFactory.flexibleType(TypeSubstitutionKt.asSimpleType(r13.getType()), TypeSubstitutionKt.asSimpleType(r14.getType())));
    L43:
        if (KotlinBuiltIns.isNothing(r0) == false) goto L45;
    L78:
        if (r7 != null) goto L80;
        $$$reportNull$$$0(23);
    L80:
        return r7;
    L45:
        if (KotlinTypeKt.isError(r0) == true) goto L78;
        if (r5 == null) goto L74;
        VarianceConflictType r16 = conflictType(r6, r5.getProjectionKind());
        if (CapturedTypeConstructorKt.isCaptured(r0) == true) goto L58;
        int r17 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[r16.ordinal()];
        if (r17 == 1) goto L57;
        if (r17 != 2) goto L58;
        return new TypeProjectionImpl(Variance.OUT_VARIANCE, r0.getConstructor().getBuiltIns().getNullableAnyType());
    L57:
        throw new SubstitutionException("Out-projection in in-position");
    L58:
        CustomTypeParameter r18 = TypeCapabilitiesKt.getCustomTypeParameter(r0);
        if (r5.isStarProjection() == false) goto L63;
        if (r5 != null) goto L62;
        $$$reportNull$$$0(24);
    L62:
        return r5;
    L63:
        if (r18 == null) goto L65;
        KotlinType r19 = r18.substitutionResult(r5.getType());
    L67:
        if (r0.getAnnotations().isEmpty() == true) goto L70;
        r19 = TypeUtilsKt.replaceAnnotations(r19, new CompositeAnnotations(new Annotations[]{r19.getAnnotations(), filterOutUnsafeVariance(this.substitution.filterAnnotations(r0.getAnnotations()))}));
    L70:
        if (r16 != VarianceConflictType.NO_CONFLICT) goto L73;
        r6 = combine(r6, r5.getProjectionKind());
    L73:
        return new TypeProjectionImpl(r6, r19);
    L65:
        r19 = TypeUtils.makeNullableIfNeeded(r5.getType(), r0.isMarkedNullable());
        goto L67
    L74:
        TypeProjection r20 = substituteCompoundType(r7, r9);
        if (r20 != null) goto L77;
        $$$reportNull$$$0(25);
    L77:
        return r20;
    L26:
        r5 = null;
        goto L27
    }

    private static TypeProjection projectedTypeForConflictedTypeWithUnsafeVariance(KotlinType r2, TypeProjection r3, TypeParameterDescriptor r4, TypeProjection r5) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(27);
    L6:
        if (r5 != null) goto L9;
        $$$reportNull$$$0(28);
    L9:
        if (r2.getAnnotations().hasAnnotation(StandardNames.FqNames.unsafeVariance) == true) goto L13;
        if (r3 != null) goto L12;
        $$$reportNull$$$0(29);
    L12:
        return r3;
    L13:
        TypeConstructor r6 = r3.getType().getConstructor();
        if ((r6 instanceof NewCapturedTypeConstructor) == true) goto L18;
        if (r3 != null) goto L17;
        $$$reportNull$$$0(30);
    L17:
        return r3;
    L18:
        TypeProjection r7 = ((NewCapturedTypeConstructor) r6).getProjection();
        Variance r0 = r7.getProjectionKind();
        if (conflictType(r5.getProjectionKind(), r0) == VarianceConflictType.OUT_IN_IN_POSITION) goto L21;
        if (r4 != null) goto L27;
        if (r3 != null) goto L25;
        $$$reportNull$$$0(31);
    L25:
        return r3;
    L27:
        if (conflictType(r4.getVariance(), r0) == VarianceConflictType.OUT_IN_IN_POSITION) goto L29;
        if (r3 != null) goto L32;
        $$$reportNull$$$0(32);
    L32:
        return r3;
    L29:
        return new TypeProjectionImpl(r7.getType());
    L21:
        return new TypeProjectionImpl(r7.getType());
    }

    private static Annotations filterOutUnsafeVariance(Annotations r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(33);
    L5:
        if (r2.hasAnnotation(StandardNames.FqNames.unsafeVariance) == true) goto L10;
        if (r2 != null) goto L8;
        $$$reportNull$$$0(34);
    L8:
        return r2;
    L10:
        return new FilteredAnnotations(r2, new AnonymousClass1());
    }

    private TypeProjection substituteCompoundType(TypeProjection r5, int r6) throws SubstitutionException {
        KotlinType r0 = r5.getType();
        Variance r1 = r5.getProjectionKind();
        if ((r0.getConstructor().mo2083getDeclarationDescriptor() instanceof TypeParameterDescriptor) == false) goto L5;
        return r5;
    L5:
        SimpleType r7 = SpecialTypesKt.getAbbreviation(r0);
        if (r7 == null) goto L8;
        KotlinType r8 = replaceWithNonApproximatingSubstitution().substitute(r7, Variance.INVARIANT);
    L9:
        KotlinType r4 = TypeSubstitutionKt.replace(r0, substituteTypeArguments(r0.getConstructor().getParameters(), r0.getArguments(), r6), this.substitution.filterAnnotations(r0.getAnnotations()));
        if ((r4 instanceof SimpleType) == false) goto L15;
        if ((r8 instanceof SimpleType) == false) goto L15;
        r4 = SpecialTypesKt.withAbbreviation((SimpleType) r4, (SimpleType) r8);
    L15:
        return new TypeProjectionImpl(r1, r4);
    L8:
        r8 = null;
        goto L9
    }

    private List<TypeProjection> substituteTypeArguments(List<TypeParameterDescriptor> r11, List<TypeProjection> r12, int r13) throws SubstitutionException {
        ArrayList r0 = new ArrayList(r11.size());
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= r11.size()) goto L21;
        TypeParameterDescriptor r3 = r11.get(r1);
        TypeProjection r4 = r12.get(r1);
        TypeProjection r6 = unsafeSubstitute(r4, r3, r13 + 1);
        int r7 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[conflictType(r3.getVariance(), r6.getProjectionKind()).ordinal()];
        if (r7 != 1) goto L8;
    L17:
        r6 = TypeUtils.makeStarProjection(r3);
    L18:
        if (r6 == r4) goto L20;
        r2 = true;
    L20:
        r0.add(r6);
        r1 = r1 + 1;
        goto L4
    L8:
        if (r7 == 2) goto L17;
        if (r7 != 3) goto L18;
        if (r3.getVariance() == Variance.INVARIANT) goto L18;
        if (r6.isStarProjection() == true) goto L18;
        r6 = new TypeProjectionImpl(Variance.INVARIANT, r6.getType());
        goto L18
    L21:
        if (r2 == true) goto L23;
        return r12;
    L23:
        return r0;
    }

    public static Variance combine(Variance r1, TypeProjection r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(35);
    L4:
        if (r2 != null) goto L7;
        $$$reportNull$$$0(36);
    L7:
        if (r2.isStarProjection() == false) goto L13;
        Variance r3 = Variance.OUT_VARIANCE;
        if (r3 != null) goto L11;
        $$$reportNull$$$0(37);
    L11:
        return r3;
    L13:
        return combine(r1, r2.getProjectionKind());
    }

    public static Variance combine(Variance r3, Variance r4) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(38);
    L4:
        if (r4 != null) goto L7;
        $$$reportNull$$$0(39);
    L7:
        if (r3 != Variance.INVARIANT) goto L12;
        if (r4 != null) goto L10;
        $$$reportNull$$$0(40);
    L10:
        return r4;
    L12:
        if (r4 != Variance.INVARIANT) goto L16;
        if (r3 != null) goto L15;
        $$$reportNull$$$0(41);
    L15:
        return r3;
    L16:
        if (r3 != r4) goto L21;
        if (r4 != null) goto L19;
        $$$reportNull$$$0(42);
    L19:
        return r4;
    L21:
        throw new AssertionError("Variance conflict: type parameter variance '" + r3 + "' and projection kind '" + r4 + "' cannot be combined");
    }

    private static VarianceConflictType conflictType(Variance r1, Variance r2) {
        if (r1 != Variance.IN_VARIANCE) goto L9;
        if (r2 != Variance.OUT_VARIANCE) goto L9;
        return VarianceConflictType.OUT_IN_IN_POSITION;
    L9:
        if (r1 != Variance.OUT_VARIANCE) goto L15;
        if (r2 != Variance.IN_VARIANCE) goto L15;
        return VarianceConflictType.IN_IN_OUT_POSITION;
    L15:
        return VarianceConflictType.NO_CONFLICT;
    }

    private static void assertRecursionDepth(int r2, TypeProjection r3, TypeSubstitution r4) {
        if (r2 > 100) goto L6;
        return;
    L6:
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + safeToString(r3) + "; substitution: " + safeToString(r4));
    }

    private static String safeToString(Object r2) {
        return r2.toString();
    L4:
        th = move-exception;
        if (ExceptionUtilsKt.isProcessCanceledException(th) == true) goto L10;
        return "[Exception while computing toString(): " + th + "]";
    L10:
        throw th;
    }
}
