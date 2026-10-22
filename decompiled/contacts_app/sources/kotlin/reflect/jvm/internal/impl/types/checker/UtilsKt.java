package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UtilsKt {
    public static final KotlinType findCorrespondingSupertype(KotlinType r9, KotlinType r10, TypeCheckingProcedureCallbacks r11) {
        Intrinsics.checkNotNullParameter(r9, "subtype");
        Intrinsics.checkNotNullParameter(r10, "supertype");
        Intrinsics.checkNotNullParameter(r11, "typeCheckingProcedureCallbacks");
        ArrayDeque r0 = new ArrayDeque();
        r0.add(new SubtypePathNode(r9, null));
        TypeConstructor r12 = r10.getConstructor();
    L4:
        if (r0.isEmpty() == true) goto L43;
        SubtypePathNode r13 = (SubtypePathNode) r0.poll();
        KotlinType r1 = r13.getType();
        TypeConstructor r3 = r1.getConstructor();
        if (r11.assertEqualTypeConstructors(r3, r12) == true) goto L7;
        Iterator<KotlinType> r2 = r3.mo2084getSupertypes().iterator();
    L41:
        if (r2.hasNext() == false) goto L4;
        KotlinType r4 = r2.next();
        Intrinsics.checkNotNullExpressionValue(r4, "immediateSupertype");
        r0.add(new SubtypePathNode(r4, r13));
        goto L41
    L7:
        boolean r5 = r1.isMarkedNullable();
        SubtypePathNode r14 = r13.getPrevious();
    L8:
        if (r14 == null) goto L33;
        KotlinType r6 = r14.getType();
        List<TypeProjection> r7 = r6.getArguments();
        if ((r7 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r8 = r7.iterator();
    L16:
        if (r8.hasNext() == false) goto L13;
        if (((TypeProjection) r8.next()).getProjectionKind() == Variance.INVARIANT) goto L20;
        boolean r15 = true;
    L21:
        if (r15 == false) goto L16;
        boolean r16 = true;
    L23:
        if (r16 == false) goto L25;
        KotlinType r17 = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create(r6), false, 1, null).buildSubstitutor().safeSubstitute(r1, Variance.INVARIANT);
        Intrinsics.checkNotNullExpressionValue(r17, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
        r1 = approximate(r17);
    L26:
        if (r5 == false) goto L28;
    L31:
        r5 = true;
    L32:
        r14 = r14.getPrevious();
        goto L8
    L28:
        if (r6.isMarkedNullable() == true) goto L31;
        r5 = false;
        goto L32
    L25:
        r1 = TypeConstructorSubstitution.Companion.create(r6).buildSubstitutor().safeSubstitute(r1, Variance.INVARIANT);
        Intrinsics.checkNotNullExpressionValue(r1, "{\n                    Ty…ARIANT)\n                }");
        goto L26
    L20:
        r15 = false;
    L13:
        r16 = false;
        goto L23
    L12:
        if (r7.isEmpty() == false) goto L14;
    L33:
        TypeConstructor r18 = r1.getConstructor();
        if (r11.assertEqualTypeConstructors(r18, r12) == false) goto L38;
        return TypeUtils.makeNullableAsSpecified(r1, r5);
    L38:
        throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + debugInfo(r18) + ", \n\nsupertype: " + debugInfo(r12) + " \n" + r11.assertEqualTypeConstructors(r18, r12));
    L43:
        return null;
    }

    private static final KotlinType approximate(KotlinType r0) {
        return CapturedTypeApproximationKt.approximateCapturedTypes(r0).getUpper();
    }

    private static final String debugInfo(TypeConstructor r4) {
        StringBuilder r0 = new StringBuilder();
        debugInfo$lambda$1$unaryPlus("type: " + r4, r0);
        debugInfo$lambda$1$unaryPlus("hashCode: " + r4.hashCode(), r0);
        debugInfo$lambda$1$unaryPlus("javaClass: " + r4.getClass().getCanonicalName(), r0);
        ClassifierDescriptor r5 = r4.mo2083getDeclarationDescriptor();
    L3:
        if (r5 == null) goto L5;
        debugInfo$lambda$1$unaryPlus("fqName: " + DescriptorRenderer.FQ_NAMES_IN_TYPES.render(r5), r0);
        debugInfo$lambda$1$unaryPlus("javaClass: " + r5.getClass().getCanonicalName(), r0);
        r5 = r5.getContainingDeclaration();
        goto L3
    L5:
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "StringBuilder().apply(builderAction).toString()");
        return r6;
    }

    private static final StringBuilder debugInfo$lambda$1$unaryPlus(String r1, StringBuilder r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r2.append(r1);
        Intrinsics.checkNotNullExpressionValue(r3, "append(value)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append('\\n')");
        return r4;
    }
}
