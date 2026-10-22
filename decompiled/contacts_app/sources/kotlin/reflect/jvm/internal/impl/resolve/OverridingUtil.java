package kotlin.reflect.jvm.internal.impl.resolve;

import com.bytedance.apm.constant.PerfConsts;
import com.obric.contactsdk.loader.ContractKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: classes4.dex */
public class OverridingUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final OverridingUtil DEFAULT = null;
    private static final KotlinTypeChecker.TypeConstructorEquality DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = null;
    private static final List<ExternalOverridabilityCondition> EXTERNAL_CONDITIONS = null;
    private final Function2<KotlinType, KotlinType, Boolean> customSubtype;
    private final KotlinTypeChecker.TypeConstructorEquality equalityAxioms;
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeRefiner kotlinTypeRefiner;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$8, reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$descriptors$Modality = null;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result = null;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result = null;

        static {
            int[] r0 = new int[Modality.values().length];
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality = r0;
            r0[Modality.FINAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L33:
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.SEALED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L39:
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.OPEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L51:
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.ABSTRACT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L10:
            int[] r4 = new int[OverrideCompatibilityInfo.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result = r4;
            r4[OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L35:
            $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[OverrideCompatibilityInfo.Result.CONFLICT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L37:
            $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[OverrideCompatibilityInfo.Result.INCOMPATIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L14:
            int[] r5 = new int[ExternalOverridabilityCondition.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result = r5;
            r5[ExternalOverridabilityCondition.Result.OVERRIDABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L49:
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.CONFLICT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L31:
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.INCOMPATIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L45:
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
            return;
        }
    }

    public static class OverrideCompatibilityInfo {
        private static final OverrideCompatibilityInfo SUCCESS = null;
        private final String debugMessage;
        private final Result overridable;

        public static final enum Result extends Enum<Result> {
            private static final /* synthetic */ Result[] $VALUES = null;
            public static final Result CONFLICT = null;
            public static final Result INCOMPATIBLE = null;
            public static final Result OVERRIDABLE = null;

            private Result(String r1, int r2) {
                super(r1, r2);
            }

            public static Result valueOf(String r1) {
                return (Result) Enum.valueOf(Result.class, r1);
            }

            public static Result[] values() {
                return (Result[]) $VALUES.clone();
            }

            static {
                Result r0 = new Result("OVERRIDABLE", 0);
                OVERRIDABLE = r0;
                Result r1 = new Result("INCOMPATIBLE", 1);
                INCOMPATIBLE = r1;
                Result r3 = new Result("CONFLICT", 2);
                CONFLICT = r3;
                $VALUES = new Result[]{r0, r1, r3};
            }
        }

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 1) goto L8;
            if (r10 == 2) goto L8;
            if (r10 == 3) goto L8;
            if (r10 == 4) goto L8;
            String r4 = "@NotNull method %s.%s must not return null";
        L9:
            if (r10 == 1) goto L14;
            if (r10 == 2) goto L14;
            if (r10 == 3) goto L14;
            if (r10 == 4) goto L14;
            int r5 = 2;
        L15:
            Object[] r6 = new Object[r5];
            if (r10 == 1) goto L22;
            if (r10 == 2) goto L22;
            if (r10 == 3) goto L21;
            if (r10 == 4) goto L22;
            r6[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
        L23:
            switch(r10) {
                case 1: goto L27;
                case 2: goto L27;
                case 3: goto L27;
                case 4: goto L27;
                case 5: goto L26;
                case 6: goto L25;
                default: goto L24;
            };
        L24:
            r6[1] = "success";
        L28:
            if (r10 == 1) goto L35;
            if (r10 == 2) goto L34;
            if (r10 == 3) goto L33;
            if (r10 == 4) goto L33;
        L36:
            String r7 = String.format(r4, r6);
            if (r10 == 1) goto L43;
            if (r10 == 2) goto L43;
            if (r10 == 3) goto L43;
            if (r10 == 4) goto L43;
            throw new IllegalStateException(r7);
        L43:
            throw new IllegalArgumentException(r7);
        L33:
            r6[2] = "<init>";
            goto L36
        L34:
            r6[2] = "conflict";
            goto L36
        L35:
            r6[2] = "incompatible";
            goto L36
        L25:
            r6[1] = "getDebugMessage";
            goto L28
        L26:
            r6[1] = "getResult";
            goto L28
        L27:
            r6[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
            goto L28
        L21:
            r6[0] = "success";
        L22:
            r6[0] = "debugMessage";
        L14:
            r5 = 3;
        L8:
            r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            goto L9
        }

        static {
            SUCCESS = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        }

        public static OverrideCompatibilityInfo success() {
            OverrideCompatibilityInfo r0 = SUCCESS;
            if (r0 != null) goto L5;
            $$$reportNull$$$0(0);
        L5:
            return r0;
        }

        public static OverrideCompatibilityInfo incompatible(String r2) {
            if (r2 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, r2);
        }

        public static OverrideCompatibilityInfo conflict(String r2) {
            if (r2 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return new OverrideCompatibilityInfo(Result.CONFLICT, r2);
        }

        public OverrideCompatibilityInfo(Result r2, String r3) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(3);
        L4:
            if (r3 != null) goto L6;
            $$$reportNull$$$0(4);
        L6:
            this.overridable = r2;
            this.debugMessage = r3;
        }

        public Result getResult() {
            Result r1 = this.overridable;
            if (r1 != null) goto L5;
            $$$reportNull$$$0(5);
        L5:
            return r1;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r24) {
        if (r24 == 11) goto L17;
        if (r24 == 12) goto L17;
        if (r24 == 16) goto L17;
        if (r24 == 21) goto L17;
        if (r24 == 95) goto L17;
        if (r24 == 98) goto L17;
        if (r24 == 103) goto L17;
        if (r24 == 44) goto L17;
        if (r24 == 45) goto L17;
        switch(r24) {
            case 24: goto L17;
            case 25: goto L17;
            case 26: goto L17;
            case 27: goto L17;
            case 28: goto L17;
            case 29: goto L17;
            default: goto L13;
        };
    L13:
        switch(r24) {
            case 32: goto L17;
            case 33: goto L17;
            case 34: goto L17;
            case 35: goto L17;
            case 36: goto L17;
            case 37: goto L17;
            case 38: goto L17;
            case 39: goto L17;
            default: goto L14;
        };
    L14:
        switch(r24) {
            case 80: goto L17;
            case 81: goto L17;
            case 82: goto L17;
            case 83: goto L17;
            case 84: goto L17;
            default: goto L15;
        };
    L15:
        switch(r24) {
            case 90: goto L17;
            case 91: goto L17;
            case 92: goto L17;
            default: goto L16;
        };
    L16:
        String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L19:
        if (r24 == 11) goto L33;
        if (r24 == 12) goto L157;
        if (r24 == 16) goto L158;
        if (r24 == 21) goto L159;
        if (r24 == 95) goto L160;
        if (r24 == 98) goto L161;
        if (r24 == 103) goto L162;
        if (r24 == 44) goto L163;
        if (r24 == 45) goto L164;
        switch(r24) {
            case 24: goto L165;
            case 25: goto L165;
            case 26: goto L165;
            case 27: goto L165;
            case 28: goto L165;
            case 29: goto L165;
            default: goto L29;
        };
    L29:
        switch(r24) {
            case 32: goto L166;
            case 33: goto L166;
            case 34: goto L166;
            case 35: goto L166;
            case 36: goto L166;
            case 37: goto L166;
            case 38: goto L166;
            case 39: goto L166;
            default: goto L30;
        };
    L30:
        switch(r24) {
            case 80: goto L167;
            case 81: goto L167;
            case 82: goto L167;
            case 83: goto L167;
            case 84: goto L167;
            default: goto L31;
        };
    L31:
        switch(r24) {
            case 90: goto L168;
            case 91: goto L168;
            case 92: goto L168;
            default: goto L32;
        };
    L32:
        int r12 = 3;
    L34:
        Object[] r13 = new Object[r12];
        switch(r24) {
            case 1: goto L80;
            case 2: goto L79;
            case 3: goto L36;
            case 4: goto L78;
            case 5: goto L77;
            case 6: goto L36;
            case 7: goto L80;
            case 8: goto L76;
            case 9: goto L76;
            case 10: goto L75;
            case 11: goto L74;
            case 12: goto L74;
            case 13: goto L73;
            case 14: goto L72;
            case 15: goto L71;
            case 16: goto L74;
            case 17: goto L71;
            case 18: goto L70;
            case 19: goto L69;
            case 20: goto L68;
            case 21: goto L74;
            case 22: goto L69;
            case 23: goto L68;
            case 24: goto L74;
            case 25: goto L74;
            case 26: goto L74;
            case 27: goto L74;
            case 28: goto L74;
            case 29: goto L74;
            case 30: goto L69;
            case 31: goto L68;
            case 32: goto L74;
            case 33: goto L74;
            case 34: goto L74;
            case 35: goto L74;
            case 36: goto L74;
            case 37: goto L74;
            case 38: goto L74;
            case 39: goto L74;
            case 40: goto L69;
            case 41: goto L68;
            case 42: goto L67;
            case 43: goto L66;
            case 44: goto L74;
            case 45: goto L74;
            case 46: goto L65;
            case 47: goto L64;
            case 48: goto L63;
            case 49: goto L62;
            case 50: goto L61;
            case 51: goto L63;
            case 52: goto L60;
            case 53: goto L59;
            case 54: goto L58;
            case 55: goto L57;
            case 56: goto L56;
            case 57: goto L55;
            case 58: goto L54;
            case 59: goto L53;
            case 60: goto L52;
            case 61: goto L57;
            case 62: goto L56;
            case 63: goto L51;
            case 64: goto L57;
            case 65: goto L51;
            case 66: goto L56;
            case 67: goto L50;
            case 68: goto L49;
            case 69: goto L50;
            case 70: goto L49;
            case 71: goto L48;
            case 72: goto L47;
            case 73: goto L50;
            case 74: goto L46;
            case 75: goto L49;
            case 76: goto L45;
            case 77: goto L63;
            case 78: goto L44;
            case 79: goto L43;
            case 80: goto L74;
            case 81: goto L74;
            case 82: goto L74;
            case 83: goto L74;
            case 84: goto L74;
            case 85: goto L44;
            case 86: goto L57;
            case 87: goto L56;
            case 88: goto L47;
            case 89: goto L57;
            case 90: goto L74;
            case 91: goto L74;
            case 92: goto L74;
            case 93: goto L47;
            case 94: goto L42;
            case 95: goto L74;
            case 96: goto L57;
            case 97: goto L41;
            case 98: goto L74;
            case 99: goto L40;
            case 100: goto L39;
            case 101: goto L43;
            case 102: goto L38;
            case 103: goto L74;
            case 104: goto L40;
            case 105: goto L39;
            case 106: goto L56;
            case 107: goto L37;
            case 108: goto L37;
            case 109: goto L47;
            default: goto L36;
        };
    L36:
        r13[0] = "kotlinTypeRefiner";
    L82:
        if (r24 == 11) goto L105;
        if (r24 == 12) goto L105;
        if (r24 == 16) goto L104;
        if (r24 == 21) goto L103;
        if (r24 == 95) goto L102;
        if (r24 == 98) goto L101;
        if (r24 == 103) goto L100;
        if (r24 == 44) goto L99;
        if (r24 == 45) goto L99;
        switch(r24) {
            case 24: goto L103;
            case 25: goto L103;
            case 26: goto L103;
            case 27: goto L103;
            case 28: goto L103;
            case 29: goto L103;
            default: goto L92;
        };
    L92:
        switch(r24) {
            case 32: goto L98;
            case 33: goto L98;
            case 34: goto L98;
            case 35: goto L98;
            case 36: goto L98;
            case 37: goto L98;
            case 38: goto L98;
            case 39: goto L98;
            default: goto L93;
        };
    L93:
        switch(r24) {
            case 80: goto L97;
            case 81: goto L97;
            case 82: goto L97;
            case 83: goto L97;
            case 84: goto L97;
            default: goto L94;
        };
    L94:
        switch(r24) {
            case 90: goto L96;
            case 91: goto L96;
            case 92: goto L96;
            default: goto L95;
        };
    L95:
        r13[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
    L106:
        switch(r24) {
            case 1: goto L139;
            case 2: goto L139;
            case 3: goto L138;
            case 4: goto L138;
            case 5: goto L137;
            case 6: goto L137;
            case 7: goto L137;
            case 8: goto L136;
            case 9: goto L135;
            case 10: goto L135;
            case 11: goto L140;
            case 12: goto L140;
            case 13: goto L134;
            case 14: goto L134;
            case 15: goto L133;
            case 16: goto L140;
            case 17: goto L132;
            case 18: goto L132;
            case 19: goto L131;
            case 20: goto L131;
            case 21: goto L140;
            case 22: goto L131;
            case 23: goto L131;
            case 24: goto L140;
            case 25: goto L140;
            case 26: goto L140;
            case 27: goto L140;
            case 28: goto L140;
            case 29: goto L140;
            case 30: goto L130;
            case 31: goto L130;
            case 32: goto L140;
            case 33: goto L140;
            case 34: goto L140;
            case 35: goto L140;
            case 36: goto L140;
            case 37: goto L140;
            case 38: goto L140;
            case 39: goto L140;
            case 40: goto L129;
            case 41: goto L129;
            case 42: goto L128;
            case 43: goto L128;
            case 44: goto L140;
            case 45: goto L140;
            case 46: goto L127;
            case 47: goto L127;
            case 48: goto L127;
            case 49: goto L126;
            case 50: goto L126;
            case 51: goto L126;
            case 52: goto L125;
            case 53: goto L125;
            case 54: goto L125;
            case 55: goto L125;
            case 56: goto L125;
            case 57: goto L124;
            case 58: goto L124;
            case 59: goto L123;
            case 60: goto L123;
            case 61: goto L123;
            case 62: goto L123;
            case 63: goto L122;
            case 64: goto L121;
            case 65: goto L121;
            case 66: goto L121;
            case 67: goto L120;
            case 68: goto L120;
            case 69: goto L119;
            case 70: goto L119;
            case 71: goto L118;
            case 72: goto L118;
            case 73: goto L117;
            case 74: goto L117;
            case 75: goto L117;
            case 76: goto L117;
            case 77: goto L117;
            case 78: goto L116;
            case 79: goto L116;
            case 80: goto L140;
            case 81: goto L140;
            case 82: goto L140;
            case 83: goto L140;
            case 84: goto L140;
            case 85: goto L115;
            case 86: goto L115;
            case 87: goto L115;
            case 88: goto L114;
            case 89: goto L114;
            case 90: goto L140;
            case 91: goto L140;
            case 92: goto L140;
            case 93: goto L113;
            case 94: goto L113;
            case 95: goto L140;
            case 96: goto L112;
            case 97: goto L112;
            case 98: goto L140;
            case 99: goto L111;
            case 100: goto L111;
            case 101: goto L111;
            case 102: goto L111;
            case 103: goto L140;
            case 104: goto L111;
            case 105: goto L111;
            case 106: goto L111;
            case 107: goto L110;
            case 108: goto L109;
            case 109: goto L108;
            default: goto L107;
        };
    L107:
        r13[2] = "createWithTypeRefiner";
        goto L140
    L108:
        r13[2] = "findMaxVisibility";
        goto L140
    L109:
        r13[2] = "computeVisibilityToInherit";
        goto L140
    L110:
        r13[2] = "resolveUnknownVisibilityForMember";
        goto L140
    L111:
        r13[2] = "extractMembersOverridableInBothWays";
        goto L140
    L112:
        r13[2] = "filterVisibleFakeOverrides";
        goto L140
    L113:
        r13[2] = "getMinimalModality";
        goto L140
    L114:
        r13[2] = "determineModalityForFakeOverride";
        goto L140
    L115:
        r13[2] = "createAndBindFakeOverride";
        goto L140
    L116:
        r13[2] = "selectMostSpecificMember";
        goto L140
    L117:
        r13[2] = "isReturnTypeMoreSpecific";
        goto L140
    L118:
        r13[2] = "isMoreSpecificThenAllOf";
        goto L140
    L119:
        r13[2] = "isVisibilityMoreSpecific";
        goto L140
    L120:
        r13[2] = "isMoreSpecific";
        goto L140
    L121:
        r13[2] = "createAndBindFakeOverrides";
        goto L140
    L122:
        r13[2] = "allHasSameContainingDeclaration";
        goto L140
    L123:
        r13[2] = "extractAndBindOverridesForMember";
        goto L140
    L124:
        r13[2] = "isVisibleForOverride";
        goto L140
    L125:
        r13[2] = "generateOverridesInFunctionGroup";
        goto L140
    L126:
        r13[2] = "areTypeParametersEquivalent";
        goto L140
    L127:
        r13[2] = "areTypesEquivalent";
        goto L140
    L128:
        r13[2] = "createTypeCheckerState";
        goto L140
    L129:
        r13[2] = "getBasicOverridabilityProblem";
        goto L140
    L130:
        r13[2] = "isOverridableByWithoutExternalConditions";
        goto L140
    L131:
        r13[2] = "isOverridableBy";
        goto L140
    L132:
        r13[2] = "collectOverriddenDeclarations";
        goto L140
    L133:
        r13[2] = "getOverriddenDeclarations";
        goto L140
    L134:
        r13[2] = "overrides";
        goto L140
    L135:
        r13[2] = "filterOverrides";
        goto L140
    L136:
        r13[2] = "filterOutOverridden";
        goto L140
    L137:
        r13[2] = "<init>";
        goto L140
    L138:
        r13[2] = ContractKt.OBRIC_ACTION_CREATE;
        goto L140
    L139:
        r13[2] = "createWithTypePreparatorAndCustomSubtype";
    L140:
        String r11 = String.format(r10, r13);
        if (r24 == 11) goto L156;
        if (r24 == 12) goto L156;
        if (r24 == 16) goto L156;
        if (r24 == 21) goto L156;
        if (r24 == 95) goto L156;
        if (r24 == 98) goto L156;
        if (r24 == 103) goto L156;
        if (r24 == 44) goto L156;
        if (r24 == 45) goto L156;
        switch(r24) {
            case 24: goto L156;
            case 25: goto L156;
            case 26: goto L156;
            case 27: goto L156;
            case 28: goto L156;
            case 29: goto L156;
            default: goto L151;
        };
    L151:
        switch(r24) {
            case 32: goto L156;
            case 33: goto L156;
            case 34: goto L156;
            case 35: goto L156;
            case 36: goto L156;
            case 37: goto L156;
            case 38: goto L156;
            case 39: goto L156;
            default: goto L152;
        };
    L152:
        switch(r24) {
            case 80: goto L156;
            case 81: goto L156;
            case 82: goto L156;
            case 83: goto L156;
            case 84: goto L156;
            default: goto L153;
        };
    L153:
        switch(r24) {
            case 90: goto L156;
            case 91: goto L156;
            case 92: goto L156;
            default: goto L169;
        };
    L169:
        throw new IllegalArgumentException(r11);
    L156:
        throw new IllegalStateException(r11);
    L96:
        r13[1] = "determineModalityForFakeOverride";
        goto L106
    L97:
        r13[1] = "selectMostSpecificMember";
        goto L106
    L98:
        r13[1] = "isOverridableByWithoutExternalConditions";
    L99:
        r13[1] = "createTypeCheckerState";
        goto L106
    L100:
        r13[1] = "extractMembersOverridableInBothWays";
        goto L106
    L101:
        r13[1] = "filterVisibleFakeOverrides";
        goto L106
    L102:
        r13[1] = "getMinimalModality";
    L103:
        r13[1] = "isOverridableBy";
        goto L106
    L104:
        r13[1] = "getOverriddenDeclarations";
    L105:
        r13[1] = "filterOverrides";
        goto L106
    L37:
        r13[0] = "memberDescriptor";
        goto L82
    L38:
        r13[0] = "onConflict";
        goto L82
    L39:
        r13[0] = "extractFrom";
        goto L82
    L40:
        r13[0] = "overrider";
        goto L82
    L41:
        r13[0] = "toFilter";
        goto L82
    L42:
        r13[0] = "classModality";
        goto L82
    L43:
        r13[0] = "descriptorByHandle";
        goto L82
    L44:
        r13[0] = "overridables";
        goto L82
    L45:
        r13[0] = "bReturnType";
        goto L82
    L46:
        r13[0] = "aReturnType";
        goto L82
    L47:
        r13[0] = "descriptors";
        goto L82
    L48:
        r13[0] = "candidate";
        goto L82
    L49:
        r13[0] = "b";
        goto L82
    L50:
        r13[0] = "a";
        goto L82
    L51:
        r13[0] = "notOverridden";
        goto L82
    L52:
        r13[0] = "descriptorsFromSuper";
        goto L82
    L53:
        r13[0] = "fromCurrent";
        goto L82
    L54:
        r13[0] = "fromSuper";
        goto L82
    L55:
        r13[0] = "overriding";
        goto L82
    L56:
        r13[0] = "strategy";
        goto L82
    L57:
        r13[0] = PerfConsts.KEY_CURRENT_GALVANIC;
        goto L82
    L58:
        r13[0] = "membersFromCurrent";
        goto L82
    L59:
        r13[0] = "membersFromSupertypes";
        goto L82
    L60:
        r13[0] = "name";
        goto L82
    L61:
        r13[0] = "subTypeParameter";
        goto L82
    L62:
        r13[0] = "superTypeParameter";
        goto L82
    L63:
        r13[0] = "typeCheckerState";
        goto L82
    L64:
        r13[0] = "typeInSub";
        goto L82
    L65:
        r13[0] = "typeInSuper";
        goto L82
    L66:
        r13[0] = "secondParameters";
        goto L82
    L67:
        r13[0] = "firstParameters";
        goto L82
    L68:
        r13[0] = "subDescriptor";
        goto L82
    L69:
        r13[0] = "superDescriptor";
        goto L82
    L70:
        r13[0] = "result";
        goto L82
    L71:
        r13[0] = "descriptor";
        goto L82
    L72:
        r13[0] = "g";
        goto L82
    L73:
        r13[0] = "f";
        goto L82
    L74:
        r13[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
        goto L82
    L75:
        r13[0] = "transformFirst";
        goto L82
    L76:
        r13[0] = "candidateSet";
        goto L82
    L77:
        r13[0] = "axioms";
        goto L82
    L78:
        r13[0] = "equalityAxioms";
        goto L82
    L79:
        r13[0] = "customSubtype";
        goto L82
    L80:
        r13[0] = "kotlinTypePreparator";
        goto L82
    L168:
        r12 = 2;
        goto L34
    L167:
        r12 = 2;
        goto L34
    L166:
        r12 = 2;
        goto L34
    L165:
        r12 = 2;
        goto L34
    L164:
        r12 = 2;
        goto L34
    L163:
        r12 = 2;
        goto L34
    L162:
        r12 = 2;
        goto L34
    L161:
        r12 = 2;
        goto L34
    L160:
        r12 = 2;
        goto L34
    L159:
        r12 = 2;
        goto L34
    L158:
        r12 = 2;
        goto L34
    L157:
        r12 = 2;
        goto L34
    L33:
        r12 = 2;
    L17:
        r10 = "@NotNull method %s.%s must not return null";
        goto L19
    }

    static {
        EXTERNAL_CONDITIONS = CollectionsKt.toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
        KotlinTypeChecker.TypeConstructorEquality r0 = new AnonymousClass1();
        DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = r0;
        DEFAULT = new OverridingUtil(r0, KotlinTypeRefiner.Default.INSTANCE, KotlinTypePreparator.Default.INSTANCE, null);
    }

    public static OverridingUtil createWithTypeRefiner(KotlinTypeRefiner r4) {
        if (r4 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, r4, KotlinTypePreparator.Default.INSTANCE, null);
    }

    public static OverridingUtil create(KotlinTypeRefiner r3, KotlinTypeChecker.TypeConstructorEquality r4) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r4 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return new OverridingUtil(r4, r3, KotlinTypePreparator.Default.INSTANCE, null);
    }

    private OverridingUtil(KotlinTypeChecker.TypeConstructorEquality r2, KotlinTypeRefiner r3, KotlinTypePreparator r4, Function2<KotlinType, KotlinType, Boolean> r5) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(6);
    L6:
        if (r4 != null) goto L8;
        $$$reportNull$$$0(7);
    L8:
        this.equalityAxioms = r2;
        this.kotlinTypeRefiner = r3;
        this.kotlinTypePreparator = r4;
        this.customSubtype = r5;
    }

    public static <D extends CallableDescriptor> Set<D> filterOutOverridden(Set<D> r3) {
        if (r3 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        if (r3.isEmpty() == false) goto L7;
    L9:
        boolean r0 = false;
    L11:
        return filterOverrides(r3, r0, null, new AnonymousClass2());
    L7:
        if (DescriptorUtilsKt.isTypeRefinementEnabled(DescriptorUtilsKt.getModule(r3.iterator().next())) == false) goto L9;
        r0 = true;
        goto L11
    }

    public static <D> Set<D> filterOverrides(Set<D> r7, boolean r8, Function0<?> r9, Function2<? super D, ? super D, Pair<CallableDescriptor, CallableDescriptor>> r10) {
        if (r7 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(10);
    L7:
        if (r7.size() > 1) goto L11;
        if (r7 != null) goto L10;
        $$$reportNull$$$0(11);
    L10:
        return r7;
    L11:
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<D> r11 = r7.iterator();
    L13:
        if (r11.hasNext() == false) goto L27;
        Object r2 = r11.next();
        if (r9 == null) goto L17;
        r9.invoke();
    L17:
        Iterator r3 = r0.iterator();
    L19:
        if (r3.hasNext() == false) goto L26;
        Pair<CallableDescriptor, CallableDescriptor> r4 = r10.invoke(r2, (Object) r3.next());
        CallableDescriptor r5 = r4.component1();
        CallableDescriptor r6 = r4.component2();
        if (overrides(r5, r6, r8, true) == true) goto L22;
        if (overrides(r6, r5, r8, true) == false) goto L19;
    L22:
        r3.remove();
        goto L19
    L26:
        r0.add(r2);
        goto L13
    L27:
        return r0;
    }

    public static <D extends CallableDescriptor> boolean overrides(D r4, D r5, boolean r6, boolean r7) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        if (r5 != null) goto L7;
        $$$reportNull$$$0(14);
    L7:
        if (r4.equals(r5) == false) goto L9;
    L11:
        CallableDescriptor r8 = r5.getOriginal();
        Iterator r9 = DescriptorUtils.getAllOverriddenDescriptors(r4).iterator();
    L13:
        if (r9.hasNext() == false) goto L17;
        CallableDescriptor r0 = (CallableDescriptor) r9.next();
        if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(r8, r0, r6, r7) == false) goto L13;
        return true;
    L17:
        return false;
    L9:
        if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(r4.getOriginal(), r5.getOriginal(), r6, r7) == false) goto L11;
        return true;
    }

    public static Set<CallableMemberDescriptor> getOverriddenDeclarations(CallableMemberDescriptor r1) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(15);
    L4:
        LinkedHashSet r0 = new LinkedHashSet();
        collectOverriddenDeclarations(r1, r0);
        return r0;
    }

    private static void collectOverriddenDeclarations(CallableMemberDescriptor r2, Set<CallableMemberDescriptor> r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(17);
    L4:
        if (r3 != null) goto L7;
        $$$reportNull$$$0(18);
    L7:
        if (r2.getKind().isReal() == false) goto L10;
        r3.add(r2);
        return;
    L10:
        if (r2.getOverriddenDescriptors().isEmpty() == true) goto L17;
        Iterator<? extends CallableMemberDescriptor> r4 = r2.getOverriddenDescriptors().iterator();
    L13:
        if (r4.hasNext() == false) goto L19;
        collectOverriddenDeclarations(r4.next(), r3);
        goto L13
    L19:
        return;
    L17:
        throw new IllegalStateException("No overridden descriptors found for (fake override) " + r2);
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor r2, CallableDescriptor r3, ClassDescriptor r4) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(20);
    L6:
        OverrideCompatibilityInfo r1 = isOverridableBy(r2, r3, r4, false);
        if (r1 != null) goto L9;
        $$$reportNull$$$0(21);
    L9:
        return r1;
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor r10, CallableDescriptor r11, ClassDescriptor r12, boolean r13) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(22);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(23);
    L6:
        OverrideCompatibilityInfo r9 = isOverridableByWithoutExternalConditions(r10, r11, r13);
        if (r9.getResult() != OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L9;
        boolean r14 = true;
    L10:
        Iterator<ExternalOverridabilityCondition> r0 = EXTERNAL_CONDITIONS.iterator();
    L12:
        if (r0.hasNext() == false) goto L34;
        ExternalOverridabilityCondition r2 = r0.next();
        if (r2.getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) goto L12;
        if (r14 == false) goto L20;
        if (r2.getContract() == ExternalOverridabilityCondition.Contract.SUCCESS_ONLY) goto L12;
    L20:
        int r3 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[r2.isOverridable(r10, r11, r12).ordinal()];
        if (r3 != 1) goto L22;
        r14 = true;
        goto L12
    L22:
        if (r3 == 2) goto L29;
        if (r3 != 3) goto L12;
        OverrideCompatibilityInfo r15 = OverrideCompatibilityInfo.incompatible("External condition");
        if (r15 != null) goto L28;
        $$$reportNull$$$0(25);
    L28:
        return r15;
    L29:
        OverrideCompatibilityInfo r16 = OverrideCompatibilityInfo.conflict("External condition failed");
        if (r16 != null) goto L32;
        $$$reportNull$$$0(24);
    L32:
        return r16;
    L34:
        if (r14 == true) goto L38;
        if (r9 != null) goto L37;
        $$$reportNull$$$0(26);
    L37:
        return r9;
    L38:
        Iterator<ExternalOverridabilityCondition> r17 = EXTERNAL_CONDITIONS.iterator();
    L40:
        if (r17.hasNext() == false) goto L59;
        ExternalOverridabilityCondition r18 = r17.next();
        if (r18.getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) goto L40;
        int r1 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[r18.isOverridable(r10, r11, r12).ordinal()];
        if (r1 == 1) goto L58;
        if (r1 == 2) goto L53;
        if (r1 != 3) goto L40;
        OverrideCompatibilityInfo r19 = OverrideCompatibilityInfo.incompatible("External condition");
        if (r19 != null) goto L52;
        $$$reportNull$$$0(28);
    L52:
        return r19;
    L53:
        OverrideCompatibilityInfo r20 = OverrideCompatibilityInfo.conflict("External condition failed");
        if (r20 != null) goto L56;
        $$$reportNull$$$0(27);
    L56:
        return r20;
    L58:
        throw new IllegalStateException("Contract violation in " + r18.getClass().getName() + " condition. It's not supposed to end with success");
    L59:
        OverrideCompatibilityInfo r21 = OverrideCompatibilityInfo.success();
        if (r21 != null) goto L62;
        $$$reportNull$$$0(29);
    L62:
        return r21;
    L9:
        r14 = false;
        goto L10
    }

    public OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(CallableDescriptor r9, CallableDescriptor r10, boolean r11) {
        if (r9 != null) goto L4;
        $$$reportNull$$$0(30);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(31);
    L6:
        OverrideCompatibilityInfo r0 = getBasicOverridabilityProblem(r9, r10);
        if (r0 == null) goto L11;
        if (r0 != null) goto L10;
        $$$reportNull$$$0(32);
    L10:
        return r0;
    L11:
        List<KotlinType> r1 = compiledValueParameters(r9);
        List<KotlinType> r2 = compiledValueParameters(r10);
        List<TypeParameterDescriptor> r3 = r9.getTypeParameters();
        List<TypeParameterDescriptor> r4 = r10.getTypeParameters();
        int r6 = 0;
        if (r3.size() != r4.size()) goto L14;
        TypeCheckerState r8 = createTypeCheckerState(r3, r4);
        int r5 = 0;
    L28:
        if (r5 >= r3.size()) goto L36;
        if (areTypeParametersEquivalent(r3.get(r5), r4.get(r5), r8) == false) goto L31;
        r5 = r5 + 1;
        goto L28
    L31:
        OverrideCompatibilityInfo r12 = OverrideCompatibilityInfo.incompatible("Type parameter bounds mismatch");
        if (r12 != null) goto L34;
        $$$reportNull$$$0(35);
    L34:
        return r12;
    L36:
        int r7 = 0;
    L38:
        if (r7 >= r1.size()) goto L47;
        if (areTypesEquivalent(r1.get(r7), r2.get(r7), r8) == false) goto L41;
        r7 = r7 + 1;
        goto L38
    L41:
        OverrideCompatibilityInfo r13 = OverrideCompatibilityInfo.incompatible("Value parameter type mismatch");
        if (r13 != null) goto L44;
        $$$reportNull$$$0(36);
    L44:
        return r13;
    L47:
        if ((r9 instanceof FunctionDescriptor) == true) goto L49;
    L56:
        if (r11 == false) goto L72;
        KotlinType r14 = r9.getReturnType();
        KotlinType r15 = r10.getReturnType();
        if (r14 == null) goto L72;
        if (r15 == null) goto L72;
        if (KotlinTypeKt.isError(r15) == true) goto L63;
    L65:
        if (r6 != 0) goto L72;
        if (AbstractTypeChecker.INSTANCE.isSubtypeOf(r8, r15.unwrap(), r14.unwrap()) == true) goto L72;
        OverrideCompatibilityInfo r16 = OverrideCompatibilityInfo.conflict("Return type mismatch");
        if (r16 != null) goto L71;
        $$$reportNull$$$0(38);
    L71:
        return r16;
    L63:
        if (KotlinTypeKt.isError(r14) == false) goto L65;
        r6 = 1;
    L72:
        OverrideCompatibilityInfo r17 = OverrideCompatibilityInfo.success();
        if (r17 != null) goto L75;
        $$$reportNull$$$0(39);
    L75:
        return r17;
    L49:
        if ((r10 instanceof FunctionDescriptor) == false) goto L56;
        if (((FunctionDescriptor) r9).isSuspend() == ((FunctionDescriptor) r10).isSuspend()) goto L56;
        OverrideCompatibilityInfo r18 = OverrideCompatibilityInfo.conflict("Incompatible suspendability");
        if (r18 != null) goto L55;
        $$$reportNull$$$0(37);
    L55:
        return r18;
    L14:
        if (r6 >= r1.size()) goto L22;
        if (KotlinTypeChecker.DEFAULT.equalTypes(r1.get(r6), r2.get(r6)) == false) goto L17;
        r6 = r6 + 1;
        goto L14
    L17:
        OverrideCompatibilityInfo r19 = OverrideCompatibilityInfo.incompatible("Type parameter number mismatch");
        if (r19 != null) goto L20;
        $$$reportNull$$$0(33);
    L20:
        return r19;
    L22:
        OverrideCompatibilityInfo r20 = OverrideCompatibilityInfo.conflict("Type parameter number mismatch");
        if (r20 != null) goto L25;
        $$$reportNull$$$0(34);
    L25:
        return r20;
    }

    public static OverrideCompatibilityInfo getBasicOverridabilityProblem(CallableDescriptor r3, CallableDescriptor r4) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(40);
    L4:
        if (r4 != null) goto L6;
        $$$reportNull$$$0(41);
    L6:
        boolean r0 = r3 instanceof FunctionDescriptor;
        if (r0 == true) goto L9;
    L10:
        boolean r1 = r3 instanceof PropertyDescriptor;
        if (r1 == true) goto L13;
    L16:
        if (r0 == true) goto L22;
        if (r1 == true) goto L22;
        throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + r3);
    L22:
        if (r3.getName().equals(r4.getName()) == false) goto L24;
        OverrideCompatibilityInfo r5 = checkReceiverAndParameterCount(r3, r4);
        if (r5 == null) goto L28;
        return r5;
    L28:
        return null;
    L24:
        return OverrideCompatibilityInfo.incompatible("Name mismatch");
    L13:
        if ((r4 instanceof PropertyDescriptor) == true) goto L16;
    L15:
        return OverrideCompatibilityInfo.incompatible("Member kind mismatch");
    L9:
        if ((r4 instanceof FunctionDescriptor) == false) goto L15;
        goto L10
    }

    private TypeCheckerState createTypeCheckerState(List<TypeParameterDescriptor> r9, List<TypeParameterDescriptor> r10) {
        if (r9 != null) goto L4;
        $$$reportNull$$$0(42);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(43);
    L7:
        if (r9.isEmpty() == false) goto L12;
        TypeCheckerState r8 = new OverridingUtilTypeSystemContext(null, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true);
        if (r8 != null) goto L11;
        $$$reportNull$$$0(44);
    L11:
        return r8;
    L12:
        HashMap r3 = new HashMap();
        int r0 = 0;
    L14:
        if (r0 >= r9.size()) goto L16;
        r3.put(r9.get(r0).getTypeConstructor(), r10.get(r0).getTypeConstructor());
        r0 = r0 + 1;
        goto L14
    L16:
        TypeCheckerState r11 = new OverridingUtilTypeSystemContext(r3, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true);
        if (r11 != null) goto L19;
        $$$reportNull$$$0(45);
    L19:
        return r11;
    }

    private static OverrideCompatibilityInfo checkReceiverAndParameterCount(CallableDescriptor r4, CallableDescriptor r5) {
        boolean r1 = true;
        if (r4.getExtensionReceiverParameter() != null) goto L5;
        boolean r0 = true;
    L7:
        if (r5.getExtensionReceiverParameter() == null) goto L10;
        r1 = false;
    L10:
        if (r0 == r1) goto L14;
        return OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
    L14:
        if (r4.getValueParameters().size() != r5.getValueParameters().size()) goto L16;
        return null;
    L16:
        return OverrideCompatibilityInfo.incompatible("Value parameter number mismatch");
    L5:
        r0 = false;
        goto L7
    }

    private static boolean areTypesEquivalent(KotlinType r2, KotlinType r3, TypeCheckerState r4) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(46);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(47);
    L6:
        if (r4 != null) goto L9;
        $$$reportNull$$$0(48);
    L9:
        if (KotlinTypeKt.isError(r2) == true) goto L11;
    L13:
        boolean r0 = false;
    L14:
        if (r0 == false) goto L17;
        return true;
    L17:
        return AbstractTypeChecker.INSTANCE.equalTypes(r4, r2.unwrap(), r3.unwrap());
    L11:
        if (KotlinTypeKt.isError(r3) == false) goto L13;
        r0 = true;
        goto L14
    }

    private static boolean areTypeParametersEquivalent(TypeParameterDescriptor r4, TypeParameterDescriptor r5, TypeCheckerState r6) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(49);
    L4:
        if (r5 != null) goto L6;
        $$$reportNull$$$0(50);
    L6:
        if (r6 != null) goto L8;
        $$$reportNull$$$0(51);
    L8:
        List<KotlinType> r7 = r4.getUpperBounds();
        ArrayList r0 = new ArrayList(r5.getUpperBounds());
        if (r7.size() == r0.size()) goto L11;
        return false;
    L11:
        Iterator<KotlinType> r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L21;
        KotlinType r9 = r8.next();
        ListIterator r1 = r0.listIterator();
    L16:
        if (r1.hasNext() == false) goto L20;
        if (areTypesEquivalent(r9, (KotlinType) r1.next(), r6) == false) goto L16;
        r1.remove();
        goto L13
    L20:
        return false;
    L21:
        return true;
    }

    private static List<KotlinType> compiledValueParameters(CallableDescriptor r2) {
        ReceiverParameterDescriptor r0 = r2.getExtensionReceiverParameter();
        ArrayList r1 = new ArrayList();
        if (r0 == null) goto L5;
        r1.add(r0.getType());
    L5:
        Iterator<ValueParameterDescriptor> r3 = r2.getValueParameters().iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r1.add(r3.next().getType());
        goto L7
    L9:
        return r1;
    }

    public void generateOverridesInFunctionGroup(Name r2, Collection<? extends CallableMemberDescriptor> r3, Collection<? extends CallableMemberDescriptor> r4, ClassDescriptor r5, OverridingStrategy r6) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(52);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(53);
    L6:
        if (r4 != null) goto L8;
        $$$reportNull$$$0(54);
    L8:
        if (r5 != null) goto L10;
        $$$reportNull$$$0(55);
    L10:
        if (r6 != null) goto L12;
        $$$reportNull$$$0(56);
    L12:
        LinkedHashSet r7 = new LinkedHashSet(r3);
        Iterator<? extends CallableMemberDescriptor> r8 = r4.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        r7.removeAll(extractAndBindOverridesForMember(r8.next(), r3, r5, r6));
        goto L14
    L16:
        createAndBindFakeOverrides(r5, r7, r6);
    }

    public static boolean isVisibleForOverride(MemberDescriptor r1, MemberDescriptor r2, boolean r3) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(57);
    L4:
        if (r2 != null) goto L7;
        $$$reportNull$$$0(58);
    L7:
        if (DescriptorVisibilities.isPrivate(r2.getVisibility()) == false) goto L9;
    L11:
        return false;
    L9:
        if (DescriptorVisibilities.isVisibleIgnoringReceiver(r2, r1, r3) == false) goto L11;
        return true;
    }

    private Collection<CallableMemberDescriptor> extractAndBindOverridesForMember(CallableMemberDescriptor r7, Collection<? extends CallableMemberDescriptor> r8, ClassDescriptor r9, OverridingStrategy r10) {
        if (r7 != null) goto L4;
        $$$reportNull$$$0(59);
    L4:
        if (r8 != null) goto L6;
        $$$reportNull$$$0(60);
    L6:
        if (r9 != null) goto L8;
        $$$reportNull$$$0(61);
    L8:
        if (r10 != null) goto L10;
        $$$reportNull$$$0(62);
    L10:
        ArrayList r0 = new ArrayList(r8.size());
        SmartSet r1 = SmartSet.create();
        Iterator<? extends CallableMemberDescriptor> r11 = r8.iterator();
    L12:
        if (r11.hasNext() == false) goto L24;
        CallableMemberDescriptor r2 = r11.next();
        OverrideCompatibilityInfo.Result r3 = isOverridableBy(r2, r7, r9).getResult();
        boolean r4 = isVisibleForOverride(r7, r2, false);
        int r5 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[r3.ordinal()];
        if (r5 != 1) goto L16;
        if (r4 == false) goto L23;
        r1.add(r2);
    L23:
        r0.add(r2);
        goto L12
    L16:
        if (r5 != 2) goto L12;
        if (r4 == false) goto L20;
        r10.overrideConflict(r2, r7);
    L20:
        r0.add(r2);
        goto L12
    L24:
        r10.setOverriddenDescriptors(r7, r1);
        return r0;
    }

    private static boolean allHasSameContainingDeclaration(Collection<CallableMemberDescriptor> r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(63);
    L5:
        if (r2.size() >= 2) goto L8;
        return true;
    L8:
        final DeclarationDescriptor r0 = r2.iterator().next().getContainingDeclaration();
        return CollectionsKt.all(r2, new AnonymousClass3(r0));
    }

    private static void createAndBindFakeOverrides(ClassDescriptor r1, Collection<CallableMemberDescriptor> r2, OverridingStrategy r3) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(64);
    L4:
        if (r2 != null) goto L6;
        $$$reportNull$$$0(65);
    L6:
        if (r3 != null) goto L9;
        $$$reportNull$$$0(66);
    L9:
        if (allHasSameContainingDeclaration(r2) == false) goto L15;
        Iterator<CallableMemberDescriptor> r4 = r2.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        createAndBindFakeOverride(Collections.singleton(r4.next()), r1, r3);
        goto L12
    L14:
        return;
    L15:
        LinkedList r0 = new LinkedList(r2);
    L17:
        if (r0.isEmpty() == true) goto L19;
        createAndBindFakeOverride(extractMembersOverridableInBothWays(VisibilityUtilKt.findMemberWithMaxVisibility(r0), r0, r3), r1, r3);
        goto L17
    }

    public static boolean isMoreSpecific(CallableDescriptor r8, CallableDescriptor r9) {
        if (r8 != null) goto L4;
        $$$reportNull$$$0(67);
    L4:
        if (r9 != null) goto L6;
        $$$reportNull$$$0(68);
    L6:
        KotlinType r0 = r8.getReturnType();
        KotlinType r1 = r9.getReturnType();
        if (isVisibilityMoreSpecific(r8, r9) == true) goto L9;
        return false;
    L9:
        TypeCheckerState r2 = DEFAULT.createTypeCheckerState(r8.getTypeParameters(), r9.getTypeParameters());
        if ((r8 instanceof FunctionDescriptor) == false) goto L14;
        return isReturnTypeMoreSpecific(r8, r0, r9, r1, r2);
    L14:
        if ((r8 instanceof PropertyDescriptor) == false) goto L33;
        PropertyDescriptor r4 = (PropertyDescriptor) r8;
        PropertyDescriptor r5 = (PropertyDescriptor) r9;
        if (isAccessorMoreSpecific(r4.getSetter(), r5.getSetter()) == true) goto L19;
        return false;
    L19:
        if (r4.isVar() == false) goto L25;
        if (r5.isVar() == false) goto L25;
        return AbstractTypeChecker.INSTANCE.equalTypes(r2, r0.unwrap(), r1.unwrap());
    L25:
        if (r4.isVar() == true) goto L29;
        if (r5.isVar() == false) goto L29;
        return false;
    L29:
        if (isReturnTypeMoreSpecific(r8, r0, r9, r1, r2) == false) goto L35;
        return true;
    L35:
        return false;
    L33:
        throw new IllegalArgumentException("Unexpected callable: " + r8.getClass());
    }

    private static boolean isVisibilityMoreSpecific(DeclarationDescriptorWithVisibility r1, DeclarationDescriptorWithVisibility r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(69);
    L4:
        if (r2 != null) goto L6;
        $$$reportNull$$$0(70);
    L6:
        Integer r3 = DescriptorVisibilities.compare(r1.getVisibility(), r2.getVisibility());
        if (r3 != null) goto L9;
    L12:
        return true;
    L9:
        if (r3.intValue() >= 0) goto L12;
        return false;
    }

    private static boolean isAccessorMoreSpecific(PropertyAccessorDescriptor r0, PropertyAccessorDescriptor r1) {
        if (r0 == null) goto L7;
        if (r1 != null) goto L6;
        return true;
    L6:
        return isVisibilityMoreSpecific(r0, r1);
    L7:
        return true;
    }

    private static boolean isMoreSpecificThenAllOf(CallableDescriptor r1, Collection<CallableDescriptor> r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(71);
    L4:
        if (r2 != null) goto L6;
        $$$reportNull$$$0(72);
    L6:
        Iterator<CallableDescriptor> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L13;
        if (isMoreSpecific(r1, r3.next()) == true) goto L8;
        return false;
    L13:
        return true;
    }

    private static boolean isReturnTypeMoreSpecific(CallableDescriptor r0, KotlinType r1, CallableDescriptor r2, KotlinType r3, TypeCheckerState r4) {
        if (r0 != null) goto L4;
        $$$reportNull$$$0(73);
    L4:
        if (r1 != null) goto L6;
        $$$reportNull$$$0(74);
    L6:
        if (r2 != null) goto L8;
        $$$reportNull$$$0(75);
    L8:
        if (r3 != null) goto L10;
        $$$reportNull$$$0(76);
    L10:
        if (r4 != null) goto L13;
        $$$reportNull$$$0(77);
    L13:
        return AbstractTypeChecker.INSTANCE.isSubtypeOf(r4, r1.unwrap(), r3.unwrap());
    }

    public static <H> H selectMostSpecificMember(Collection<H> r8, Function1<H, CallableDescriptor> r9) {
        if (r8 != null) goto L4;
        $$$reportNull$$$0(78);
    L4:
        if (r9 != null) goto L7;
        $$$reportNull$$$0(79);
    L7:
        if (r8.size() != 1) goto L12;
        H r10 = (H) CollectionsKt.first(r8);
        if (r10 != null) goto L11;
        $$$reportNull$$$0(80);
    L11:
        return r10;
    L12:
        ArrayList r0 = new ArrayList(2);
        List r2 = CollectionsKt.map(r8, r9);
        H r3 = (H) CollectionsKt.first(r8);
        CallableDescriptor r4 = r9.invoke(r3);
        Iterator<H> r11 = r8.iterator();
    L14:
        if (r11.hasNext() == false) goto L24;
        H r5 = r11.next();
        CallableDescriptor r6 = r9.invoke(r5);
        if (isMoreSpecificThenAllOf(r6, r2) == false) goto L19;
        r0.add(r5);
    L19:
        if (isMoreSpecific(r6, r4) == false) goto L14;
        if (isMoreSpecific(r4, r6) == true) goto L14;
        r3 = r5;
        goto L14
    L24:
        if (r0.isEmpty() == false) goto L29;
        if (r3 != null) goto L27;
        $$$reportNull$$$0(81);
    L27:
        return r3;
    L29:
        if (r0.size() != 1) goto L34;
        H r12 = (H) CollectionsKt.first(r0);
        if (r12 != null) goto L33;
        $$$reportNull$$$0(82);
    L33:
        return r12;
    L34:
        Iterator r13 = r0.iterator();
    L36:
        if (r13.hasNext() == false) goto L40;
        H r1 = (H) r13.next();
        if (FlexibleTypesKt.isFlexible(r9.invoke(r1).getReturnType()) == true) goto L36;
    L41:
        if (r1 == null) goto L45;
        if (r1 != null) goto L44;
        $$$reportNull$$$0(83);
    L44:
        return r1;
    L45:
        H r14 = (H) CollectionsKt.first(r0);
        if (r14 != null) goto L48;
        $$$reportNull$$$0(84);
    L48:
        return r14;
    L40:
        r1 = null;
        goto L41
    }

    private static void createAndBindFakeOverride(Collection<CallableMemberDescriptor> r8, ClassDescriptor r9, OverridingStrategy r10) {
        if (r8 != null) goto L4;
        $$$reportNull$$$0(85);
    L4:
        if (r9 != null) goto L6;
        $$$reportNull$$$0(86);
    L6:
        if (r10 != null) goto L8;
        $$$reportNull$$$0(87);
    L8:
        Collection<CallableMemberDescriptor> r0 = filterVisibleFakeOverrides(r9, r8);
        boolean r1 = r0.isEmpty();
        if (r1 == true) goto L12;
        r8 = r0;
    L12:
        Modality r4 = determineModalityForFakeOverride(r8, r9);
        if (r1 == false) goto L15;
        DescriptorVisibility r2 = DescriptorVisibilities.INVISIBLE_FAKE;
    L16:
        DescriptorVisibility r5 = r2;
        CallableMemberDescriptor r11 = ((CallableMemberDescriptor) selectMostSpecificMember(r8, new AnonymousClass4())).copy(r9, r4, r5, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        r10.setOverriddenDescriptors(r11, r8);
        r10.addFakeOverride(r11);
        return;
    L15:
        r2 = DescriptorVisibilities.INHERITED;
        goto L16
    }

    private static Modality determineModalityForFakeOverride(Collection<CallableMemberDescriptor> r8, ClassDescriptor r9) {
        if (r8 != null) goto L4;
        $$$reportNull$$$0(88);
    L4:
        if (r9 != null) goto L6;
        $$$reportNull$$$0(89);
    L6:
        Iterator<CallableMemberDescriptor> r0 = r8.iterator();
        boolean r1 = false;
        boolean r2 = false;
        boolean r3 = false;
    L8:
        if (r0.hasNext() == false) goto L27;
        CallableMemberDescriptor r4 = r0.next();
        int r6 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$descriptors$Modality[r4.getModality().ordinal()];
        if (r6 == 1) goto L22;
        if (r6 == 2) goto L21;
        if (r6 != 3) goto L16;
        r2 = true;
        goto L8
    L16:
        if (r6 != 4) goto L8;
        r3 = true;
        goto L8
    L21:
        throw new IllegalStateException("Member cannot have SEALED modality: " + r4);
    L22:
        Modality r10 = Modality.FINAL;
        if (r10 != null) goto L25;
        $$$reportNull$$$0(90);
    L25:
        return r10;
    L27:
        if (r9.isExpect() == true) goto L29;
    L33:
        if (r2 == false) goto L39;
        if (r3 == true) goto L39;
        Modality r11 = Modality.OPEN;
        if (r11 != null) goto L38;
        $$$reportNull$$$0(91);
    L38:
        return r11;
    L39:
        if (r2 == true) goto L47;
        if (r3 == false) goto L47;
        if (r1 == false) goto L43;
        Modality r12 = r9.getModality();
    L44:
        if (r12 != null) goto L46;
        $$$reportNull$$$0(92);
    L46:
        return r12;
    L43:
        r12 = Modality.ABSTRACT;
    L47:
        HashSet r5 = new HashSet();
        Iterator<CallableMemberDescriptor> r13 = r8.iterator();
    L49:
        if (r13.hasNext() == false) goto L52;
        r5.addAll(getOverriddenDeclarations(r13.next()));
        goto L49
    L52:
        return getMinimalModality(filterOutOverridden(r5), r1, r9.getModality());
    L29:
        if (r9.getModality() == Modality.ABSTRACT) goto L33;
        if (r9.getModality() == Modality.SEALED) goto L33;
        r1 = true;
        goto L33
    }

    private static Modality getMinimalModality(Collection<CallableMemberDescriptor> r4, boolean r5, Modality r6) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(93);
    L4:
        if (r6 != null) goto L6;
        $$$reportNull$$$0(94);
    L6:
        Modality r0 = Modality.ABSTRACT;
        Iterator<CallableMemberDescriptor> r7 = r4.iterator();
    L8:
        if (r7.hasNext() == false) goto L18;
        CallableMemberDescriptor r1 = r7.next();
        if (r5 == true) goto L12;
    L14:
        Modality r2 = r1.getModality();
    L16:
        if (r2.compareTo(r0) >= 0) goto L8;
        r0 = r2;
        goto L8
    L12:
        if (r1.getModality() != Modality.ABSTRACT) goto L14;
        r2 = r6;
        goto L16
    L18:
        if (r0 != null) goto L20;
        $$$reportNull$$$0(95);
    L20:
        return r0;
    }

    private static Collection<CallableMemberDescriptor> filterVisibleFakeOverrides(final ClassDescriptor r1, Collection<CallableMemberDescriptor> r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(96);
    L4:
        if (r2 != null) goto L6;
        $$$reportNull$$$0(97);
    L6:
        List r3 = CollectionsKt.filter(r2, new AnonymousClass5(r1));
        if (r3 != null) goto L9;
        $$$reportNull$$$0(98);
    L9:
        return r3;
    }

    public static <H> Collection<H> extractMembersOverridableInBothWays(H r5, Collection<H> r6, Function1<H, CallableDescriptor> r7, Function1<H, Unit> r8) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(99);
    L4:
        if (r6 != null) goto L6;
        $$$reportNull$$$0(100);
    L6:
        if (r7 != null) goto L8;
        $$$reportNull$$$0(101);
    L8:
        if (r8 != null) goto L10;
        $$$reportNull$$$0(102);
    L10:
        ArrayList r0 = new ArrayList();
        r0.add(r5);
        CallableDescriptor r1 = r7.invoke(r5);
        Iterator<H> r9 = r6.iterator();
    L12:
        if (r9.hasNext() == false) goto L22;
        H r2 = r9.next();
        CallableDescriptor r3 = r7.invoke(r2);
        if (r5 == r2) goto L15;
        OverrideCompatibilityInfo.Result r4 = getBothWaysOverridability(r1, r3);
        if (r4 == OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L18;
        if (r4 != OverrideCompatibilityInfo.Result.CONFLICT) goto L12;
        r8.invoke(r2);
        r9.remove();
        goto L12
    L18:
        r0.add(r2);
        r9.remove();
        goto L12
    L15:
        r9.remove();
        goto L12
    L22:
        return r0;
    }

    public static OverrideCompatibilityInfo.Result getBothWaysOverridability(CallableDescriptor r3, CallableDescriptor r4) {
        OverridingUtil r0 = DEFAULT;
        OverrideCompatibilityInfo.Result r2 = r0.isOverridableBy(r4, r3, null).getResult();
        OverrideCompatibilityInfo.Result r5 = r0.isOverridableBy(r3, r4, null).getResult();
        if (r2 != OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L8;
        if (r5 != OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L8;
        return OverrideCompatibilityInfo.Result.OVERRIDABLE;
    L8:
        if (r2 == OverrideCompatibilityInfo.Result.CONFLICT) goto L14;
        if (r5 == OverrideCompatibilityInfo.Result.CONFLICT) goto L14;
        return OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    L14:
        return OverrideCompatibilityInfo.Result.CONFLICT;
    }

    private static Collection<CallableMemberDescriptor> extractMembersOverridableInBothWays(final CallableMemberDescriptor r2, Queue<CallableMemberDescriptor> r3, final OverridingStrategy r4) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(104);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(105);
    L6:
        if (r4 != null) goto L9;
        $$$reportNull$$$0(106);
    L9:
        return extractMembersOverridableInBothWays(r2, r3, new AnonymousClass6(), new AnonymousClass7(r4, r2));
    }

    public static void resolveUnknownVisibilityForMember(CallableMemberDescriptor r4, Function1<CallableMemberDescriptor, Unit> r5) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(107);
    L4:
        Iterator<? extends CallableMemberDescriptor> r0 = r4.getOverriddenDescriptors().iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        CallableMemberDescriptor r1 = r0.next();
        if (r1.getVisibility() != DescriptorVisibilities.INHERITED) goto L6;
        resolveUnknownVisibilityForMember(r1, r5);
        goto L6
    L11:
        if (r4.getVisibility() == DescriptorVisibilities.INHERITED) goto L13;
        return;
    L13:
        DescriptorVisibility r2 = computeVisibilityToInherit(r4);
        if (r2 != null) goto L18;
        if (r5 == null) goto L17;
        r5.invoke(r4);
    L17:
        DescriptorVisibility r3 = DescriptorVisibilities.PUBLIC;
    L20:
        if ((r4 instanceof PropertyDescriptorImpl) == false) goto L30;
        ((PropertyDescriptorImpl) r4).setVisibility(r3);
        Iterator<PropertyAccessorDescriptor> r6 = ((PropertyDescriptor) r4).getAccessors().iterator();
    L23:
        if (r6.hasNext() == false) goto L46;
        PropertyAccessorDescriptor r7 = r6.next();
        if (r2 != null) goto L27;
        Function1<CallableMemberDescriptor, Unit> r8 = null;
    L28:
        resolveUnknownVisibilityForMember(r7, r8);
        goto L23
    L27:
        r8 = r5;
        goto L28
    L46:
        return;
    L30:
        if ((r4 instanceof FunctionDescriptorImpl) == false) goto L32;
        ((FunctionDescriptorImpl) r4).setVisibility(r3);
        return;
    L32:
        PropertyAccessorDescriptorImpl r9 = (PropertyAccessorDescriptorImpl) r4;
        r9.setVisibility(r3);
        if (r3 == r9.getCorrespondingProperty().getVisibility()) goto L45;
        r9.setDefault(false);
        return;
    L45:
        return;
    L18:
        r3 = r2;
        goto L20
    }

    private static DescriptorVisibility computeVisibilityToInherit(CallableMemberDescriptor r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(108);
    L4:
        Collection<? extends CallableMemberDescriptor> r0 = r5.getOverriddenDescriptors();
        DescriptorVisibility r1 = findMaxVisibility(r0);
        if (r1 != null) goto L8;
        return null;
    L8:
        if (r5.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L19;
        Iterator<? extends CallableMemberDescriptor> r6 = r0.iterator();
    L11:
        if (r6.hasNext() == false) goto L17;
        CallableMemberDescriptor r2 = r6.next();
        if (r2.getModality() == Modality.ABSTRACT) goto L11;
        if (r2.getVisibility().equals(r1) == true) goto L11;
        return null;
    L17:
        return r1;
    L19:
        return r1.normalize();
    }

    public static DescriptorVisibility findMaxVisibility(Collection<? extends CallableMemberDescriptor> r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(109);
    L5:
        if (r5.isEmpty() == true) goto L7;
        Iterator<? extends CallableMemberDescriptor> r0 = r5.iterator();
    L9:
        DescriptorVisibility r2 = null;
    L11:
        if (r0.hasNext() == false) goto L21;
        DescriptorVisibility r3 = r0.next().getVisibility();
        if (r2 == null) goto L14;
        Integer r4 = DescriptorVisibilities.compare(r3, r2);
        if (r4 == null) goto L9;
        if (r4.intValue() <= 0) goto L11;
    L14:
        r2 = r3;
        goto L11
    L21:
        if (r2 != null) goto L23;
        return null;
    L23:
        Iterator<? extends CallableMemberDescriptor> r6 = r5.iterator();
    L25:
        if (r6.hasNext() == false) goto L31;
        Integer r1 = DescriptorVisibilities.compare(r2, r6.next().getVisibility());
        if (r1 == null) goto L30;
        if (r1.intValue() >= 0) goto L25;
    L30:
        return null;
    L31:
        return r2;
    L7:
        return DescriptorVisibilities.DEFAULT_VISIBILITY;
    }
}
