package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
public class TypeCheckerState {
    private final boolean allowedTypeVariable;
    private int argumentsDepth;
    private final boolean isErrorTypeEqualsToAnything;
    private final boolean isStubTypeEqualsToAnything;
    private final AbstractTypePreparator kotlinTypePreparator;
    private final AbstractTypeRefiner kotlinTypeRefiner;
    private ArrayDeque<SimpleTypeMarker> supertypesDeque;
    private boolean supertypesLocked;
    private Set<SimpleTypeMarker> supertypesSet;
    private final TypeSystemContext typeSystemContext;

    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public interface ForkPointContext {

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class Default implements ForkPointContext {
            private boolean result;

            public Default() {
            }

            public final boolean getResult() {
                return this.result;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.ForkPointContext
            public void fork(Function0<Boolean> r2) {
                Intrinsics.checkNotNullParameter(r2, "block");
                if (this.result == false) goto L5;
                return;
            L5:
                this.result = r2.invoke().booleanValue();
            }
        }

        void fork(Function0<Boolean> r1);
    }

    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public static final enum LowerCapturedTypePolicy extends Enum<LowerCapturedTypePolicy> {
        private static final /* synthetic */ LowerCapturedTypePolicy[] $VALUES = null;
        public static final LowerCapturedTypePolicy CHECK_ONLY_LOWER = null;
        public static final LowerCapturedTypePolicy CHECK_SUBTYPE_AND_LOWER = null;
        public static final LowerCapturedTypePolicy SKIP_LOWER = null;

        private static final /* synthetic */ LowerCapturedTypePolicy[] $values() {
            return new LowerCapturedTypePolicy[]{CHECK_ONLY_LOWER, CHECK_SUBTYPE_AND_LOWER, SKIP_LOWER};
        }

        public static LowerCapturedTypePolicy valueOf(String r1) {
            return (LowerCapturedTypePolicy) Enum.valueOf(LowerCapturedTypePolicy.class, r1);
        }

        public static LowerCapturedTypePolicy[] values() {
            return (LowerCapturedTypePolicy[]) $VALUES.clone();
        }

        private LowerCapturedTypePolicy(String r1, int r2) {
            super(r1, r2);
        }

        static {
            CHECK_ONLY_LOWER = new LowerCapturedTypePolicy("CHECK_ONLY_LOWER", 0);
            CHECK_SUBTYPE_AND_LOWER = new LowerCapturedTypePolicy("CHECK_SUBTYPE_AND_LOWER", 1);
            SKIP_LOWER = new LowerCapturedTypePolicy("SKIP_LOWER", 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public static abstract class SupertypesPolicy {

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static abstract class DoCustomTransform extends SupertypesPolicy {
            public DoCustomTransform() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class LowerIfFlexible extends SupertypesPolicy {
            public static final LowerIfFlexible INSTANCE = null;

            static {
                INSTANCE = new LowerIfFlexible();
            }

            private LowerIfFlexible() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType */
            public SimpleTypeMarker mo2087transformType(TypeCheckerState r1, KotlinTypeMarker r2) {
                Intrinsics.checkNotNullParameter(r1, "state");
                Intrinsics.checkNotNullParameter(r2, "type");
                return r1.getTypeSystemContext().lowerBoundIfFlexible(r2);
            }
        }

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class None extends SupertypesPolicy {
            public static final None INSTANCE = null;

            static {
                INSTANCE = new None();
            }

            private None() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ SimpleTypeMarker mo2087transformType(TypeCheckerState r1, KotlinTypeMarker r2) {
                return (SimpleTypeMarker) transformType(r1, r2);
            }

            public Void transformType(TypeCheckerState r1, KotlinTypeMarker r2) {
                Intrinsics.checkNotNullParameter(r1, "state");
                Intrinsics.checkNotNullParameter(r2, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class UpperIfFlexible extends SupertypesPolicy {
            public static final UpperIfFlexible INSTANCE = null;

            static {
                INSTANCE = new UpperIfFlexible();
            }

            private UpperIfFlexible() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType */
            public SimpleTypeMarker mo2087transformType(TypeCheckerState r1, KotlinTypeMarker r2) {
                Intrinsics.checkNotNullParameter(r1, "state");
                Intrinsics.checkNotNullParameter(r2, "type");
                return r1.getTypeSystemContext().upperBoundIfFlexible(r2);
            }
        }

        public /* synthetic */ SupertypesPolicy(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: transformType */
        public abstract SimpleTypeMarker mo2087transformType(TypeCheckerState r1, KotlinTypeMarker r2);

        private SupertypesPolicy() {
        }
    }

    public Boolean addSubtypeConstraint(KotlinTypeMarker r1, KotlinTypeMarker r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "subType");
        Intrinsics.checkNotNullParameter(r2, "superType");
        return null;
    }

    public boolean customIsSubtypeOf(KotlinTypeMarker r1, KotlinTypeMarker r2) {
        Intrinsics.checkNotNullParameter(r1, "subType");
        Intrinsics.checkNotNullParameter(r2, "superType");
        return true;
    }

    public TypeCheckerState(boolean r2, boolean r3, boolean r4, TypeSystemContext r5, AbstractTypePreparator r6, AbstractTypeRefiner r7) {
        Intrinsics.checkNotNullParameter(r5, "typeSystemContext");
        Intrinsics.checkNotNullParameter(r6, "kotlinTypePreparator");
        Intrinsics.checkNotNullParameter(r7, "kotlinTypeRefiner");
        this.isErrorTypeEqualsToAnything = r2;
        this.isStubTypeEqualsToAnything = r3;
        this.allowedTypeVariable = r4;
        this.typeSystemContext = r5;
        this.kotlinTypePreparator = r6;
        this.kotlinTypeRefiner = r7;
    }

    public static final /* synthetic */ int access$getArgumentsDepth(TypeCheckerState r0) {
        return r0.argumentsDepth;
    }

    public static final /* synthetic */ void access$setArgumentsDepth(TypeCheckerState r0, int r1) {
        r0.argumentsDepth = r1;
    }

    public final boolean isErrorTypeEqualsToAnything() {
        return this.isErrorTypeEqualsToAnything;
    }

    public final boolean isStubTypeEqualsToAnything() {
        return this.isStubTypeEqualsToAnything;
    }

    public final TypeSystemContext getTypeSystemContext() {
        return this.typeSystemContext;
    }

    public final KotlinTypeMarker refineType(KotlinTypeMarker r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return this.kotlinTypeRefiner.refineType(r2);
    }

    public final KotlinTypeMarker prepareType(KotlinTypeMarker r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return this.kotlinTypePreparator.prepareType(r2);
    }

    public LowerCapturedTypePolicy getLowerCapturedTypePolicy(SimpleTypeMarker r1, CapturedTypeMarker r2) {
        Intrinsics.checkNotNullParameter(r1, "subType");
        Intrinsics.checkNotNullParameter(r2, "superType");
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    public static /* synthetic */ Boolean addSubtypeConstraint$default(TypeCheckerState r0, KotlinTypeMarker r1, KotlinTypeMarker r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L7;
        r3 = false;
    L7:
        return r0.addSubtypeConstraint(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
    }

    public boolean runForkingPoint(Function1<? super ForkPointContext, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "block");
        ForkPointContext.Default r0 = new ForkPointContext.Default();
        r1.invoke(r0);
        return r0.getResult();
    }

    public final ArrayDeque<SimpleTypeMarker> getSupertypesDeque() {
        return this.supertypesDeque;
    }

    public final Set<SimpleTypeMarker> getSupertypesSet() {
        return this.supertypesSet;
    }

    public final void initialize() {
        this.supertypesLocked = true;
        if (this.supertypesDeque != null) goto L6;
        this.supertypesDeque = new ArrayDeque(4);
    L6:
        if (this.supertypesSet != null) goto L9;
        this.supertypesSet = SmartSet.Companion.create();
        return;
    }

    public final void clear() {
        ArrayDeque<SimpleTypeMarker> r0 = this.supertypesDeque;
        Intrinsics.checkNotNull(r0);
        r0.clear();
        Set<SimpleTypeMarker> r1 = this.supertypesSet;
        Intrinsics.checkNotNull(r1);
        r1.clear();
        this.supertypesLocked = false;
    }

    public final boolean isAllowedTypeVariable(KotlinTypeMarker r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (this.allowedTypeVariable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.typeSystemContext.isTypeVariableType(r2) == false) goto L7;
        return true;
    }
}
