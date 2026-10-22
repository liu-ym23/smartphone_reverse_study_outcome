package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AbstractNullabilityChecker {
    public static final AbstractNullabilityChecker INSTANCE = null;

    static {
        INSTANCE = new AbstractNullabilityChecker();
    }

    private AbstractNullabilityChecker() {
    }

    public final boolean isPossibleSubtype(TypeCheckerState r2, SimpleTypeMarker r3, SimpleTypeMarker r4) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "subType");
        Intrinsics.checkNotNullParameter(r4, "superType");
        return runIsPossibleSubtype(r2, r3, r4);
    }

    private final boolean runIsPossibleSubtype(TypeCheckerState r4, SimpleTypeMarker r5, SimpleTypeMarker r6) {
        TypeSystemContext r3 = r4.getTypeSystemContext();
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS == false) goto L13;
        if (r3.isSingleClassifierType(r5) == true) goto L10;
        if (r3.isIntersection(r3.typeConstructor(r5)) == true) goto L10;
        r4.isAllowedTypeVariable(r5);
    L10:
        if (r3.isSingleClassifierType(r6) == true) goto L13;
        r4.isAllowedTypeVariable(r6);
    L13:
        if (r3.isMarkedNullable(r6) == false) goto L15;
        return true;
    L15:
        SimpleTypeMarker r0 = r5;
        if (r3.isDefinitelyNotNullType(r0) == false) goto L18;
    L39:
        return true;
    L18:
        if (r3.isNotNullTypeParameter(r0) == true) goto L39;
        if ((r5 instanceof CapturedTypeMarker) == true) goto L23;
    L25:
        AbstractNullabilityChecker r1 = INSTANCE;
        if (r1.hasNotNullSupertype(r4, r5, TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE) == false) goto L29;
        return true;
    L29:
        if (r3.isDefinitelyNotNullType(r6) == false) goto L32;
        return false;
    L32:
        if (r1.hasNotNullSupertype(r4, r6, TypeCheckerState.SupertypesPolicy.UpperIfFlexible.INSTANCE) == false) goto L35;
        return false;
    L35:
        if (r3.isClassType(r5) == false) goto L38;
        return false;
    L38:
        return r1.hasPathByNotMarkedNullableNodes(r4, r5, r3.typeConstructor(r6));
    L23:
        if (r3.isProjectionNotNull((CapturedTypeMarker) r5) == false) goto L25;
        return true;
    }

    public final boolean hasNotNullSupertype(TypeCheckerState r18, SimpleTypeMarker r19, TypeCheckerState.SupertypesPolicy r20) {
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Intrinsics.checkNotNullParameter(r19, "type");
        Intrinsics.checkNotNullParameter(r20, "supertypesPolicy");
        TypeSystemContext r2 = r18.getTypeSystemContext();
        if (r2.isClassType(r19) == false) goto L7;
        if (r2.isMarkedNullable(r19) == true) goto L7;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == true) goto L56;
        r18.initialize();
        ArrayDeque<SimpleTypeMarker> r5 = r18.getSupertypesDeque();
        Intrinsics.checkNotNull(r5);
        Set<SimpleTypeMarker> r7 = r18.getSupertypesSet();
        Intrinsics.checkNotNull(r7);
        r5.push(r19);
    L14:
        if ((!r5.isEmpty()) == false) goto L45;
        if (r7.size() > 1000) goto L44;
        SimpleTypeMarker r8 = r5.pop();
        Intrinsics.checkNotNullExpressionValue(r8, PerfConsts.KEY_CURRENT_GALVANIC);
        if (r7.add(r8) == false) goto L14;
        if (r2.isMarkedNullable(r8) == false) goto L22;
        TypeCheckerState.SupertypesPolicy.None r9 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L24:
        if ((!Intrinsics.areEqual(r9, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L27;
        r9 = null;
    L27:
        if (r9 == null) goto L14;
        TypeSystemContext r10 = r18.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r11 = r10.supertypes(r10.typeConstructor(r8)).iterator();
    L31:
        if (r11.hasNext() == false) goto L14;
        SimpleTypeMarker r12 = r9.mo2087transformType(r18, r11.next());
        if (r2.isClassType(r12) == false) goto L37;
        if (r2.isMarkedNullable(r12) == true) goto L37;
    L38:
        boolean r13 = true;
    L40:
        if (r13 == true) goto L41;
        r5.add(r12);
        goto L31
    L41:
        r18.clear();
    L37:
        if (r2.isDefinitelyNotNullType(r12) == true) goto L38;
        r13 = false;
        goto L40
    L22:
        r9 = r20;
        goto L24
    L44:
        throw new IllegalStateException(("Too many supertypes for type: " + r19 + ". Supertypes = " + CollectionsKt.joinToString$default(r7, null, null, null, 0, null, null, 63, null)).toString());
    L45:
        r18.clear();
        return false;
    L56:
        return true;
    L7:
        if (r2.isDefinitelyNotNullType(r19) == true) goto L8;
        r4 = false;
        goto L10
    }

    public final boolean hasPathByNotMarkedNullableNodes(TypeCheckerState r13, SimpleTypeMarker r14, TypeConstructorMarker r15) {
        Intrinsics.checkNotNullParameter(r13, "state");
        Intrinsics.checkNotNullParameter(r14, "start");
        Intrinsics.checkNotNullParameter(r15, TraceStatsConsts.STATS_KEY_END);
        TypeSystemContext r12 = r13.getTypeSystemContext();
        if (INSTANCE.isApplicableAsEndNode(r13, r14, r15) == true) goto L43;
        r13.initialize();
        ArrayDeque<SimpleTypeMarker> r0 = r13.getSupertypesDeque();
        Intrinsics.checkNotNull(r0);
        Set<SimpleTypeMarker> r2 = r13.getSupertypesSet();
        Intrinsics.checkNotNull(r2);
        r0.push(r14);
    L7:
        if ((!r0.isEmpty()) == false) goto L31;
        if (r2.size() > 1000) goto L30;
        SimpleTypeMarker r3 = r0.pop();
        Intrinsics.checkNotNullExpressionValue(r3, PerfConsts.KEY_CURRENT_GALVANIC);
        if (r2.add(r3) == false) goto L7;
        if (r12.isMarkedNullable(r3) == false) goto L15;
        TypeCheckerState.SupertypesPolicy r4 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
    L16:
        TypeCheckerState.SupertypesPolicy r5 = r4;
        if ((!Intrinsics.areEqual(r5, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == true) goto L20;
        r5 = null;
    L20:
        if (r5 == null) goto L7;
        TypeSystemContext r6 = r13.getTypeSystemContext();
        Iterator<KotlinTypeMarker> r7 = r6.supertypes(r6.typeConstructor(r3)).iterator();
    L24:
        if (r7.hasNext() == false) goto L7;
        SimpleTypeMarker r8 = r5.mo2087transformType(r13, r7.next());
        if (INSTANCE.isApplicableAsEndNode(r13, r8, r15) == true) goto L27;
        r0.add(r8);
        goto L24
    L27:
        r13.clear();
        return true;
    L15:
        r4 = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
        goto L16
    L30:
        throw new IllegalStateException(("Too many supertypes for type: " + r14 + ". Supertypes = " + CollectionsKt.joinToString$default(r2, null, null, null, 0, null, null, 63, null)).toString());
    L31:
        r13.clear();
        return false;
    L43:
        return true;
    }

    private final boolean isApplicableAsEndNode(TypeCheckerState r3, SimpleTypeMarker r4, TypeConstructorMarker r5) {
        TypeSystemContext r2 = r3.getTypeSystemContext();
        if (r2.isNothing(r4) == false) goto L6;
        return true;
    L6:
        if (r2.isMarkedNullable(r4) == false) goto L10;
        return false;
    L10:
        if (r3.isStubTypeEqualsToAnything() == false) goto L15;
        if (r2.isStubType(r4) == false) goto L15;
        return true;
    L15:
        return r2.areEqualTypeConstructors(r2.typeConstructor(r4), r5);
    }
}
