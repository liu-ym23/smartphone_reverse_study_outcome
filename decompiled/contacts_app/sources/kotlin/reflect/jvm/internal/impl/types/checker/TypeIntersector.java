package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeIntersector {
    public static final TypeIntersector INSTANCE = null;

    /* JADX INFO: compiled from: IntersectionType.kt */
    private static final enum ResultNullability extends Enum<ResultNullability> {
        private static final /* synthetic */ ResultNullability[] $VALUES = null;
        public static final ResultNullability ACCEPT_NULL = null;
        public static final ResultNullability NOT_NULL = null;
        public static final ResultNullability START = null;
        public static final ResultNullability UNKNOWN = null;

        /* JADX INFO: compiled from: IntersectionType.kt */
        static final class ACCEPT_NULL extends ResultNullability {
            ACCEPT_NULL(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType r2) {
                Intrinsics.checkNotNullParameter(r2, "nextType");
                return getResultNullability(r2);
            }
        }

        /* JADX INFO: compiled from: IntersectionType.kt */
        static final class NOT_NULL extends ResultNullability {
            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public NOT_NULL combine(UnwrappedType r2) {
                Intrinsics.checkNotNullParameter(r2, "nextType");
                return this;
            }

            NOT_NULL(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public /* bridge */ /* synthetic */ ResultNullability combine(UnwrappedType r1) {
                return combine(r1);
            }
        }

        /* JADX INFO: compiled from: IntersectionType.kt */
        static final class START extends ResultNullability {
            START(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType r2) {
                Intrinsics.checkNotNullParameter(r2, "nextType");
                return getResultNullability(r2);
            }
        }

        /* JADX INFO: compiled from: IntersectionType.kt */
        static final class UNKNOWN extends ResultNullability {
            UNKNOWN(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType r2) {
                Intrinsics.checkNotNullParameter(r2, "nextType");
                ResultNullability r3 = getResultNullability(r2);
                if (r3 == ResultNullability.ACCEPT_NULL) goto L5;
                return r3;
            L5:
                return this;
            }
        }

        private static final /* synthetic */ ResultNullability[] $values() {
            return new ResultNullability[]{START, ACCEPT_NULL, UNKNOWN, NOT_NULL};
        }

        public /* synthetic */ ResultNullability(String r1, int r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        public static ResultNullability valueOf(String r1) {
            return (ResultNullability) Enum.valueOf(ResultNullability.class, r1);
        }

        public static ResultNullability[] values() {
            return (ResultNullability[]) $VALUES.clone();
        }

        public abstract ResultNullability combine(UnwrappedType r1);

        private ResultNullability(String r1, int r2) {
            super(r1, r2);
        }

        static {
            START = new START("START", 0);
            ACCEPT_NULL = new ACCEPT_NULL("ACCEPT_NULL", 1);
            UNKNOWN = new UNKNOWN("UNKNOWN", 2);
            NOT_NULL = new NOT_NULL("NOT_NULL", 3);
            $VALUES = $values();
        }

        protected final ResultNullability getResultNullability(UnwrappedType r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            if (r1.isMarkedNullable() == false) goto L6;
            return ACCEPT_NULL;
        L6:
            if ((r1 instanceof DefinitelyNotNullType) == false) goto L11;
            if ((((DefinitelyNotNullType) r1).getOriginal() instanceof StubTypeForBuilderInference) == false) goto L11;
            return NOT_NULL;
        L11:
            if ((r1 instanceof StubTypeForBuilderInference) == false) goto L14;
            return UNKNOWN;
        L14:
            if (NullabilityChecker.INSTANCE.isSubtypeOfAny(r1) == false) goto L17;
            return NOT_NULL;
        L17:
            return UNKNOWN;
        }
    }

    static {
        INSTANCE = new TypeIntersector();
    }

    private TypeIntersector() {
    }

    public static final /* synthetic */ boolean access$isStrictSupertype(TypeIntersector r0, KotlinType r1, KotlinType r2) {
        return r0.isStrictSupertype(r1, r2);
    }

    public final SimpleType intersectTypes$descriptors(List<? extends SimpleType> r9) {
        Intrinsics.checkNotNullParameter(r9, GloableSearchConfig.KEY_CONFIGS);
        r9.size();
        ArrayList r0 = new ArrayList();
        Iterator<? extends SimpleType> r1 = r9.iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        SimpleType r2 = r1.next();
        if ((r2.getConstructor() instanceof IntersectionTypeConstructor) == true) goto L7;
        r0.add(r2);
        goto L4
    L7:
        Collection<KotlinType> r5 = r2.getConstructor().mo2084getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r5, "type.constructor.supertypes");
        Collection<KotlinType> r6 = r5;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r4 = r6.iterator();
    L9:
        if (r4.hasNext() == false) goto L14;
        KotlinType r8 = (KotlinType) r4.next();
        Intrinsics.checkNotNullExpressionValue(r8, "it");
        SimpleType r10 = FlexibleTypesKt.upperIfFlexible(r8);
        if (r2.isMarkedNullable() == false) goto L13;
        r10 = r10.makeNullableAsSpecified(true);
    L13:
        r7.add(r10);
        goto L9
    L14:
        r0.addAll(r7);
        goto L4
    L16:
        ArrayList r3 = r0;
        ResultNullability r11 = ResultNullability.START;
        Iterator r12 = r3.iterator();
    L18:
        if (r12.hasNext() == false) goto L20;
        r11 = r11.combine((UnwrappedType) r12.next());
        goto L18
    L20:
        LinkedHashSet r13 = new LinkedHashSet();
        Iterator r14 = r3.iterator();
    L22:
        if (r14.hasNext() == false) goto L30;
        NewCapturedType r15 = (SimpleType) r14.next();
        if (r11 != ResultNullability.NOT_NULL) goto L29;
        if ((r15 instanceof NewCapturedType) == false) goto L28;
        r15 = SpecialTypesKt.withNotNullProjection((NewCapturedType) r15);
    L28:
        r15 = SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull$default(r15, false, 1, null);
    L29:
        r13.add(r15);
        goto L22
    L30:
        LinkedHashSet r16 = r13;
        List<? extends SimpleType> r17 = r9;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r19 = r17.iterator();
    L32:
        if (r19.hasNext() == false) goto L34;
        r18.add(((SimpleType) r19.next()).getAttributes());
        goto L32
    L34:
        Iterator r20 = r18.iterator();
        if (r20.hasNext() == false) goto L43;
        Object r21 = r20.next();
    L38:
        if (r20.hasNext() == false) goto L40;
        TypeAttributes r22 = (TypeAttributes) r21;
        r21 = r22.intersect((TypeAttributes) r20.next());
        goto L38
    L40:
        SimpleType r23 = intersectTypesWithoutIntersectionType(r16);
        return r23.replaceAttributes((TypeAttributes) r21);
    L43:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    private final SimpleType intersectTypesWithoutIntersectionType(final Set<? extends SimpleType> r4) {
        if (r4.size() == 1) goto L5;
        new TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(r4);
        Set<? extends SimpleType> r5 = r4;
        Collection<SimpleType> r0 = filterTypes(r5, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        r0.isEmpty();
        SimpleType r1 = IntegerLiteralTypeConstructor.Companion.findIntersectionType(r0);
        if (r1 == null) goto L9;
        return r1;
    L9:
        Collection<SimpleType> r3 = filterTypes(r0, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(NewKotlinTypeChecker.Companion.getDefault()));
        r3.isEmpty();
        if (r3.size() >= 2) goto L14;
        return (SimpleType) CollectionsKt.single(r3);
    L14:
        return new IntersectionTypeConstructor(r5).createType();
    L5:
        return (SimpleType) CollectionsKt.single(r4);
    }

    private final Collection<SimpleType> filterTypes(Collection<? extends SimpleType> r7, Function2<? super SimpleType, ? super SimpleType, Boolean> r8) {
        ArrayList r6 = new ArrayList(r7);
        Iterator r9 = r6.iterator();
        Intrinsics.checkNotNullExpressionValue(r9, "filteredTypes.iterator()");
    L4:
        if (r9.hasNext() == false) goto L24;
        SimpleType r0 = (SimpleType) r9.next();
        ArrayList r1 = r6;
        boolean r3 = false;
        if ((r1 instanceof Collection) == true) goto L8;
    L10:
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L21;
        SimpleType r4 = (SimpleType) r2.next();
        if (r4 == r0) goto L18;
        Intrinsics.checkNotNullExpressionValue(r4, "lower");
        Intrinsics.checkNotNullExpressionValue(r0, "upper");
        if (r8.invoke(r4, r0).booleanValue() == false) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L12;
        r3 = true;
    L18:
        r5 = false;
    L21:
        if (r3 == false) goto L4;
        r9.remove();
        goto L4
    L8:
        if (r1.isEmpty() == false) goto L10;
    L24:
        return r6;
    }

    private final boolean isStrictSupertype(KotlinType r2, KotlinType r3) {
        NewKotlinTypeCheckerImpl r1 = NewKotlinTypeChecker.Companion.getDefault();
        if (r1.isSubtypeOf(r2, r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.isSubtypeOf(r3, r2) == true) goto L7;
        return true;
    }
}
