package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: compiled from: KTypeImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class KTypeImpl$arguments$2 extends Lambda implements Function0<List<? extends KTypeProjection>> {
    final /* synthetic */ Function0<Type> $computeJavaType;
    final /* synthetic */ KTypeImpl this$0;

    /* JADX INFO: compiled from: KTypeImpl.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Variance.values().length];
            r0[Variance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Variance.IN_VARIANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Variance.OUT_VARIANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    KTypeImpl$arguments$2(KTypeImpl r1, Function0<? extends Type> r2) {
        this.this$0 = r1;
        this.$computeJavaType = r2;
        super(0);
    }

    public static final /* synthetic */ List access$invoke$lambda$0(Lazy r0) {
        return invoke$lambda$0(r0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends KTypeProjection> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends KTypeProjection> invoke2() {
        List<TypeProjection> r0 = this.this$0.getType().getArguments();
        if (r0.isEmpty() == true) goto L5;
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        final KTypeImpl r3 = this.this$0;
        final Lazy r2 = LazyKt.lazy(r1, new KTypeImpl$arguments$2$parameterizedTypeArguments$2(r3));
        List<TypeProjection> r4 = r0;
        Function0<Type> r5 = this.$computeJavaType;
        final KTypeImpl r10 = this.this$0;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r7 = r4.iterator();
        final int r8 = 0;
    L8:
        if (r7.hasNext() == false) goto L32;
        Object r9 = r7.next();
        int r11 = r8 + 1;
        if (r8 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        TypeProjection r12 = (TypeProjection) r9;
        if (r12.isStarProjection() == false) goto L15;
        KTypeProjection r13 = KTypeProjection.Companion.getSTAR();
    L30:
        r6.add(r13);
        r8 = r11;
        goto L8
    L15:
        KotlinType r14 = r12.getType();
        Intrinsics.checkNotNullExpressionValue(r14, "typeProjection.type");
        if (r5 != null) goto L18;
        Function0<Type> r15 = null;
    L19:
        KTypeImpl r16 = new KTypeImpl(r14, r15);
        Variance r17 = r12.getProjectionKind();
        int r18 = WhenMappings.$EnumSwitchMapping$0[r17.ordinal()];
        if (r18 != 1) goto L22;
        r13 = KTypeProjection.Companion.invariant(r16);
        goto L30
    L22:
        if (r18 != 2) goto L24;
        r13 = KTypeProjection.Companion.contravariant(r16);
        goto L30
    L24:
        if (r18 != 3) goto L27;
        r13 = KTypeProjection.Companion.covariant(r16);
        goto L30
    L27:
        throw new NoWhenBranchMatchedException();
    L18:
        r15 = new KTypeImpl$arguments$2$1$type$1(r10, r8, r2);
        goto L19
    L32:
        return r6;
    L5:
        return CollectionsKt.emptyList();
    }

    private static final List<Type> invoke$lambda$0(Lazy<? extends List<? extends Type>> r0) {
        return (List) r0.getValue();
    }
}
