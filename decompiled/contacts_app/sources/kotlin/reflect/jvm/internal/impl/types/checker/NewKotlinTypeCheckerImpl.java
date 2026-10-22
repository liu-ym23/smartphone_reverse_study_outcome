package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NewKotlinTypeCheckerImpl implements NewKotlinTypeChecker {
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeRefiner kotlinTypeRefiner;
    private final OverridingUtil overridingUtil;

    public NewKotlinTypeCheckerImpl(KotlinTypeRefiner r2, KotlinTypePreparator r3) {
        Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
        Intrinsics.checkNotNullParameter(r3, "kotlinTypePreparator");
        this.kotlinTypeRefiner = r2;
        this.kotlinTypePreparator = r3;
        OverridingUtil r4 = OverridingUtil.createWithTypeRefiner(getKotlinTypeRefiner());
        Intrinsics.checkNotNullExpressionValue(r4, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.overridingUtil = r4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public KotlinTypeRefiner getKotlinTypeRefiner() {
        return this.kotlinTypeRefiner;
    }

    public /* synthetic */ NewKotlinTypeCheckerImpl(KotlinTypeRefiner r1, KotlinTypePreparator.Default r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = KotlinTypePreparator.Default.INSTANCE;
    L5:
        this(r1, r2);
    }

    public KotlinTypePreparator getKotlinTypePreparator() {
        return this.kotlinTypePreparator;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public OverridingUtil getOverridingUtil() {
        return this.overridingUtil;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean isSubtypeOf(KotlinType r9, KotlinType r10) {
        Intrinsics.checkNotNullParameter(r9, "subtype");
        Intrinsics.checkNotNullParameter(r10, "supertype");
        KotlinTypeRefiner r5 = getKotlinTypeRefiner();
        return isSubtypeOf(ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(true, false, null, getKotlinTypePreparator(), r5, 6, null), r9.unwrap(), r10.unwrap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean equalTypes(KotlinType r9, KotlinType r10) {
        Intrinsics.checkNotNullParameter(r9, "a");
        Intrinsics.checkNotNullParameter(r10, "b");
        KotlinTypeRefiner r5 = getKotlinTypeRefiner();
        return equalTypes(ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(false, false, null, getKotlinTypePreparator(), r5, 6, null), r9.unwrap(), r10.unwrap());
    }

    public final boolean equalTypes(TypeCheckerState r1, UnwrappedType r2, UnwrappedType r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "a");
        Intrinsics.checkNotNullParameter(r3, "b");
        return AbstractTypeChecker.INSTANCE.equalTypes(r1, r2, r3);
    }

    public final boolean isSubtypeOf(TypeCheckerState r8, UnwrappedType r9, UnwrappedType r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "subType");
        Intrinsics.checkNotNullParameter(r10, "superType");
        return AbstractTypeChecker.isSubtypeOf$default(AbstractTypeChecker.INSTANCE, r8, r9, r10, false, 8, null);
    }
}
