package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SpecialTypesKt {
    public static final AbbreviatedType getAbbreviatedType(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UnwrappedType r2 = r1.unwrap();
        if ((r2 instanceof AbbreviatedType) == true) goto L7;
        return null;
    L7:
        return (AbbreviatedType) r2;
    }

    public static final SimpleType getAbbreviation(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        AbbreviatedType r2 = getAbbreviatedType(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getAbbreviation();
    }

    public static final SimpleType withAbbreviation(SimpleType r1, SimpleType r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "abbreviatedType");
        if (KotlinTypeKt.isError(r1) == false) goto L6;
        return r1;
    L6:
        return new AbbreviatedType(r1, r2);
    }

    public static final boolean isDefinitelyNotNullType(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.unwrap() instanceof DefinitelyNotNullType;
    }

    public static /* synthetic */ SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull$default(SimpleType r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return makeSimpleTypeDefinitelyNotNullOrNotNull(r0, r1);
    }

    public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(SimpleType r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        DefinitelyNotNullType r4 = DefinitelyNotNullType.Companion.makeDefinitelyNotNull(r2, r3);
        if (r4 != null) goto L9;
        SimpleType r5 = makeIntersectionTypeDefinitelyNotNullOrNotNull(r2);
        if (r5 == null) goto L8;
        return r5;
    L8:
        return r2.makeNullableAsSpecified(false);
    L9:
        return r4;
    }

    public static final NewCapturedType withNotNullProjection(NewCapturedType r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        return new NewCapturedType(r8.getCaptureStatus(), r8.getConstructor(), r8.getLowerType(), r8.getAttributes(), r8.isMarkedNullable(), true);
    }

    public static /* synthetic */ UnwrappedType makeDefinitelyNotNullOrNotNull$default(UnwrappedType r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return makeDefinitelyNotNullOrNotNull(r0, r1);
    }

    public static final UnwrappedType makeDefinitelyNotNullOrNotNull(UnwrappedType r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        UnwrappedType r3 = DefinitelyNotNullType.Companion.makeDefinitelyNotNull(r1, r2);
        if (r3 != null) goto L10;
        r3 = makeIntersectionTypeDefinitelyNotNullOrNotNull(r1);
        if (r3 != null) goto L10;
        return r1.makeNullableAsSpecified(false);
    L10:
        return r3;
    }

    private static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(KotlinType r2) {
        TypeConstructor r3 = r2.getConstructor();
        if ((r3 instanceof IntersectionTypeConstructor) == false) goto L5;
        IntersectionTypeConstructor r4 = (IntersectionTypeConstructor) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        IntersectionTypeConstructor r5 = makeDefinitelyNotNullOrNotNull(r4);
        if (r5 != null) goto L12;
        return null;
    L12:
        return r5.createType();
    L5:
        r4 = null;
        goto L6
    }

    private static final IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(IntersectionTypeConstructor r8) {
        Collection<KotlinType> r0 = r8.mo2084getSupertypes();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
        boolean r3 = false;
    L3:
        KotlinType r6 = null;
        if (r2.hasNext() == false) goto L9;
        UnwrappedType r4 = (KotlinType) r2.next();
        if (TypeUtils.isNullableType(r4) == false) goto L8;
        r4 = makeDefinitelyNotNullOrNotNull$default(r4.unwrap(), false, 1, null);
        r3 = true;
    L8:
        r1.add(r4);
        goto L3
    L9:
        ArrayList r5 = r1;
        if (r3 == false) goto L23;
        UnwrappedType r9 = r8.getAlternativeType();
        if (r9 == null) goto L19;
        if (TypeUtils.isNullableType(r9) == false) goto L17;
        r9 = makeDefinitelyNotNullOrNotNull$default(r9.unwrap(), false, 1, null);
    L17:
        r6 = r9;
    L19:
        return new IntersectionTypeConstructor(r5).setAlternative(r6);
    L23:
        return null;
    }
}
