package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: compiled from: typeEnhancementUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeEnhancementUtilsKt {
    private static final <T> T select(Set<? extends T> r1, T r2, T r3, T r4, boolean r5) {
        if (r5 == true) goto L4;
        if (r4 == null) goto L24;
        Set<? extends T> r6 = CollectionsKt.toSet(SetsKt.plus(r1, r4));
        if (r6 == null) goto L24;
        r1 = r6;
    L24:
        return (T) CollectionsKt.singleOrNull(r1);
    L4:
        if (r1.contains(r2) == false) goto L7;
        T r7 = r2;
    L11:
        if (Intrinsics.areEqual(r7, r2) == true) goto L13;
    L15:
        if (r4 == null) goto L17;
        return r4;
    L17:
        return r7;
    L13:
        if (Intrinsics.areEqual(r4, r3) == false) goto L15;
        return null;
    L7:
        if (r1.contains(r3) == false) goto L9;
        r7 = r3;
        goto L11
    L9:
        r7 = null;
        goto L11
    }

    private static final NullabilityQualifier select(Set<? extends NullabilityQualifier> r2, NullabilityQualifier r3, boolean r4) {
        if (r3 != NullabilityQualifier.FORCE_FLEXIBILITY) goto L6;
        return NullabilityQualifier.FORCE_FLEXIBILITY;
    L6:
        return (NullabilityQualifier) select(r2, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, r3, r4);
    }

    private static final NullabilityQualifier getNullabilityForErrors(JavaTypeQualifiers r1) {
        if (r1.isNullabilityQualifierForWarning() == false) goto L6;
        return null;
    L6:
        return r1.getNullability();
    }

    public static final JavaTypeQualifiers computeQualifiersForOverride(JavaTypeQualifiers r6, Collection<JavaTypeQualifiers> r7, boolean r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "superQualifiers");
        Collection<JavaTypeQualifiers> r11 = r7;
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r11.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        NullabilityQualifier r2 = getNullabilityForErrors((JavaTypeQualifiers) r1.next());
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        NullabilityQualifier r3 = select(CollectionsKt.toSet(r0), getNullabilityForErrors(r6), r8);
        if (r3 != null) goto L17;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r11.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        NullabilityQualifier r12 = ((JavaTypeQualifiers) r5.next()).getNullability();
        if (r12 == null) goto L12;
        r4.add(r12);
        goto L12
    L16:
        NullabilityQualifier r13 = select(CollectionsKt.toSet(r4), r6.getNullability(), r8);
    L18:
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r11.iterator();
    L20:
        if (r15.hasNext() == false) goto L24;
        MutabilityQualifier r16 = ((JavaTypeQualifiers) r15.next()).getMutability();
        if (r16 == null) goto L20;
        r14.add(r16);
        goto L20
    L24:
        MutabilityQualifier r17 = (MutabilityQualifier) select(CollectionsKt.toSet(r14), MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, r6.getMutability(), r8);
        NullabilityQualifier r18 = null;
        boolean r19 = true;
        if (r13 == null) goto L36;
        if (r10 == true) goto L32;
        if (r9 == true) goto L29;
    L31:
        boolean r20 = false;
    L33:
        if (r20 == true) goto L36;
        r18 = r13;
        goto L36
    L29:
        if (r13 != NullabilityQualifier.NULLABLE) goto L31;
    L32:
        r20 = true;
    L36:
        if (r18 == NullabilityQualifier.NOT_NULL) goto L38;
    L50:
        boolean r21 = false;
    L51:
        if (r18 == null) goto L54;
        if (r3 == r13) goto L54;
    L56:
        return new JavaTypeQualifiers(r18, r17, r21, r19);
    L54:
        r19 = false;
        goto L56
    L38:
        if (r6.getDefinitelyNotNull() == false) goto L40;
    L49:
        r21 = true;
        goto L51
    L40:
        if (r11.isEmpty() == false) goto L42;
    L41:
        boolean r22 = false;
    L48:
        if (r22 == false) goto L50;
    L42:
        Iterator<T> r23 = r11.iterator();
    L44:
        if (r23.hasNext() == false) goto L41;
        if (((JavaTypeQualifiers) r23.next()).getDefinitelyNotNull() == false) goto L44;
        r22 = true;
        goto L48
    L17:
        r13 = r3;
        goto L18
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext r2, KotlinTypeMarker r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "type");
        FqName r0 = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(r0, "ENHANCED_NULLABILITY_ANNOTATION");
        return r2.hasAnnotation(r3, r0);
    }
}
