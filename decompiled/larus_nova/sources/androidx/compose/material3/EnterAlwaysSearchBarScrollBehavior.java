package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u0000 02\u00020\u0001:\u00010BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010%\u001a\u00020&*\u00020&H\u0016J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u00061"}, d2 = {"Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior;", "Landroidx/compose/material3/SearchBarScrollBehavior;", "initialOffset", "", "initialOffsetLimit", "canScroll", "Lkotlin/Function0;", "", "reverseLayout", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "<init>", "(FFLkotlin/jvm/functions/Function0;ZLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;)V", "getCanScroll", "()Lkotlin/jvm/functions/Function0;", "getReverseLayout", "()Z", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getFlingAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "_offset", "Landroidx/compose/runtime/MutableFloatState;", "newOffset", "scrollOffset", "getScrollOffset", "()F", "setScrollOffset", "(F)V", "<set-?>", "scrollOffsetLimit", "getScrollOffsetLimit", "setScrollOffsetLimit", "scrollOffsetLimit$delegate", "Landroidx/compose/runtime/MutableFloatState;", "searchBarScrollBehavior", "Landroidx/compose/ui/Modifier;", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "settleSearchBar", "Landroidx/compose/ui/unit/Velocity;", "velocity", "settleSearchBar-OhffZ5M", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class EnterAlwaysSearchBarScrollBehavior implements SearchBarScrollBehavior {
    public static final Companion Companion = null;
    private MutableFloatState _offset;
    private final Function0<Boolean> canScroll;
    private final DecayAnimationSpec<Float> flingAnimationSpec;
    private final NestedScrollConnection nestedScrollConnection;
    private final boolean reverseLayout;
    private final MutableFloatState scrollOffsetLimit$delegate;
    private final AnimationSpec<Float> snapAnimationSpec;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ EnterAlwaysSearchBarScrollBehavior a(Function0 r100, AnimationSpec r101, DecayAnimationSpec r102, List r103) {
            return Saver$lambda$1(r100, r101, r102, r103);
        }

        public static /* synthetic */ List b(SaverScope r100, EnterAlwaysSearchBarScrollBehavior r101) {
            return Saver$lambda$0(r100, r101);
        }

        private static final List Saver$lambda$0(SaverScope r100, EnterAlwaysSearchBarScrollBehavior r101) {
            return CollectionsKt.listOf(new Object[]{Float.valueOf(r101.getScrollOffset()), Float.valueOf(r101.getScrollOffsetLimit()), Boolean.valueOf(r101.getReverseLayout())});
        }

        public final Saver<EnterAlwaysSearchBarScrollBehavior, ?> Saver(final Function0<Boolean> r100, final AnimationSpec<Float> r101, final DecayAnimationSpec<Float> r102) {
            return ListSaverKt.listSaver(new ga(), new ha(r100, r101, r102));
        }

        private static final EnterAlwaysSearchBarScrollBehavior Saver$lambda$1(Function0 r100, AnimationSpec r110, DecayAnimationSpec r111, List r112) {
            Object r101 = ListProtector.get(r112, 0);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
            float r102 = ((Float) r101).floatValue();
            Object r103 = ListProtector.get(r112, 1);
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Float");
            float r104 = ((Float) r103).floatValue();
            Object r113 = ListProtector.get(r112, 2);
            Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type kotlin.Boolean");
            return new EnterAlwaysSearchBarScrollBehavior(r102, r104, r100, ((Boolean) r113).booleanValue(), r110, r111);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$searchBarScrollBehavior$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "velocity", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$searchBarScrollBehavior$2", f = "SearchBar.kt", i = {}, l = {904}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
        /* synthetic */ float F$0;
        int label;
        final /* synthetic */ EnterAlwaysSearchBarScrollBehavior this$0;

        public AnonymousClass2(EnterAlwaysSearchBarScrollBehavior r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(3, r101);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Float r101, Continuation<? super Unit> r102) {
            return invoke(r100, r101.floatValue(), r102);
        }

        public final Object invoke(CoroutineScope r100, float r101, Continuation<? super Unit> r102) {
            AnonymousClass2 r103 = new AnonymousClass2(this.this$0, r102);
            r103.F$0 = r101;
            return r103.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            float r103 = this.F$0;
            EnterAlwaysSearchBarScrollBehavior r104 = this.this$0;
            this.label = 1;
            if (EnterAlwaysSearchBarScrollBehavior.m2191access$settleSearchBarOhffZ5M(r104, r103, this) != r101) goto L12;
            return r101;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Unit a(EnterAlwaysSearchBarScrollBehavior r100, IntSize r101) {
        return searchBarScrollBehavior$lambda$3(r100, r101);
    }

    public static /* synthetic */ Unit b(Ref.FloatRef r100, EnterAlwaysSearchBarScrollBehavior r101, Ref.FloatRef r102, AnimationScope r103) {
        return settleSearchBar_OhffZ5M$lambda$4(r100, r101, r102, r103);
    }

    public static /* synthetic */ MeasureResult c(EnterAlwaysSearchBarScrollBehavior r100, MeasureScope r101, Measurable r102, Constraints r103) {
        return searchBarScrollBehavior$lambda$2(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit d(Placeable r100, int r101, Placeable.PlacementScope r102) {
        return searchBarScrollBehavior$lambda$2$lambda$1(r100, r101, r102);
    }

    public static /* synthetic */ Unit e(EnterAlwaysSearchBarScrollBehavior r100, AnimationScope r101) {
        return settleSearchBar_OhffZ5M$lambda$5(r100, r101);
    }

    public static /* synthetic */ Unit f(EnterAlwaysSearchBarScrollBehavior r100, float r101) {
        return searchBarScrollBehavior$lambda$0(r100, r101);
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public float getScrollOffset() {
        return this._offset.getFloatValue();
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public float getScrollOffsetLimit() {
        return this.scrollOffsetLimit$delegate.getFloatValue();
    }

    public final Function0<Boolean> getCanScroll() {
        return this.canScroll;
    }

    public final DecayAnimationSpec<Float> getFlingAnimationSpec() {
        return this.flingAnimationSpec;
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public Modifier searchBarScrollBehavior(Modifier r110) {
        Orientation r100 = Orientation.Vertical;
        return OnRemeasuredModifierKt.onSizeChanged(LayoutModifierKt.layout(ClipKt.clipToBounds(DraggableKt.draggable$default(r110, DraggableKt.DraggableState(new aa(this)), r100, this.canScroll.invoke().booleanValue(), null, false, null, new AnonymousClass2(this, null), false, 184, null)), new ba(this)), new ca(this));
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public void setScrollOffset(float r100) {
        this._offset.setFloatValue(RangesKt.coerceIn(r100, getScrollOffsetLimit(), 0.0f));
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public void setScrollOffsetLimit(float r100) {
        this.scrollOffsetLimit$delegate.setFloatValue(r100);
    }

    private static final Unit searchBarScrollBehavior$lambda$0(EnterAlwaysSearchBarScrollBehavior r100, float r101) {
        r100.setScrollOffset(r100.getScrollOffset() + r101);
        return Unit.INSTANCE;
    }

    private static final Unit searchBarScrollBehavior$lambda$3(EnterAlwaysSearchBarScrollBehavior r100, IntSize r101) {
        r100.setScrollOffsetLimit(-((int) (r101.m7723unboximpl() & BodyPartID.bodyIdMax)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: settleSearchBar-OhffZ5M, reason: not valid java name */
    private final Object m2192settleSearchBarOhffZ5M(float r210, Continuation<? super Velocity> r211) {
        if ((r211 instanceof EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1) == false) goto L7;
        EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1 r100 = (EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        Ref.FloatRef r104 = (Ref.FloatRef) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L49:
        final Ref.FloatRef r111 = r104;
    L51:
        return Velocity.m7777boximpl(VelocityKt.Velocity(0.0f, r111.element));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float r105 = r100.F$0;
        Ref.FloatRef r106 = (Ref.FloatRef) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L36:
        float r107 = r105;
        r111 = r106;
    L38:
        if (getScrollOffsetLimit() >= getScrollOffset()) goto L51;
        if (getScrollOffset() >= 0.0f) goto L51;
        AnimationState r108 = AnimationStateKt.AnimationState$default(getScrollOffset(), 0.0f, 0, 0, false, 30, null);
        if (r107 >= 0.5f) goto L44;
        float r109 = 0.0f;
    L45:
        Float r112 = Boxing.boxFloat(r109);
        AnimationSpec<Float> r113 = this.snapAnimationSpec;
        Function1 r114 = new fa(this);
        r100.L$0 = r111;
        r100.label = 2;
        if (SuspendAnimationKt.animateTo$default(r108, r112, r113, false, r114, r100, 4, null) != r110) goto L48;
        return r110;
    L48:
        r104 = r111;
        goto L49
    L44:
        r109 = getScrollOffsetLimit();
        goto L45
    L16:
        ResultKt.throwOnFailure(r102);
        boolean r115 = false;
        if (getScrollOffsetLimit() != 0.0f) goto L19;
        boolean r116 = true;
    L20:
        if (r116 == true) goto L22;
        r107 = getScrollOffset() / getScrollOffsetLimit();
    L24:
        if (r107 < 0.01f) goto L53;
        if (r107 != 1.0f) goto L28;
        r115 = true;
    L28:
        if (r115 == true) goto L53;
        r111 = new Ref.FloatRef();
        r111.element = r210;
        if (Math.abs(r210) <= 1.0f) goto L38;
        final Ref.FloatRef r117 = new Ref.FloatRef();
        AnimationState r118 = AnimationStateKt.AnimationState$default(0.0f, r210, 0, 0, false, 28, null);
        DecayAnimationSpec<Float> r119 = this.flingAnimationSpec;
        Function1 r120 = new ea(r117, this, r111);
        r100.L$0 = r111;
        r100.F$0 = r107;
        r100.label = 1;
        if (SuspendAnimationKt.animateDecay$default(r118, r119, false, r120, r100, 2, null) != r110) goto L35;
        return r110;
    L35:
        r105 = r107;
        r106 = r111;
    L53:
        return Velocity.m7777boximpl(Velocity.Companion.m7797getZero9UxMQ8M());
    L22:
        r107 = 0.0f;
        goto L24
    L19:
        r116 = false;
    L7:
        r100 = new EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1(this, r211);
        goto L8
    }

    private static final Unit settleSearchBar_OhffZ5M$lambda$5(EnterAlwaysSearchBarScrollBehavior r100, AnimationScope r101) {
        r100.setScrollOffset(((Number) r101.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$settleSearchBar-OhffZ5M, reason: not valid java name */
    public static final /* synthetic */ Object m2191access$settleSearchBarOhffZ5M(EnterAlwaysSearchBarScrollBehavior r100, float r101, Continuation r102) {
        return r100.m2192settleSearchBarOhffZ5M(r101, r102);
    }

    private static final Unit searchBarScrollBehavior$lambda$2$lambda$1(Placeable r100, int r101, Placeable.PlacementScope r110) {
        Placeable.PlacementScope.placeWithLayer$default(r110, r100, 0, r101, 0.0f, null, 12, null);
        return Unit.INSTANCE;
    }

    private static final MeasureResult searchBarScrollBehavior$lambda$2(EnterAlwaysSearchBarScrollBehavior r100, MeasureScope r101, Measurable r110, Constraints r111) {
        final Placeable r112 = r110.mo6256measureBRTryo0(r111.m7493unboximpl());
        final int r102 = MathKt.roundToInt(r100.getScrollOffset());
        int r103 = RangesKt.coerceAtLeast(r112.getHeight() + r102, 0);
        return MeasureScope.CC.layout$default(r101, r112.getWidth(), r103, null, new da(r112, r102), 4, null);
    }

    private static final Unit settleSearchBar_OhffZ5M$lambda$4(Ref.FloatRef r100, EnterAlwaysSearchBarScrollBehavior r101, Ref.FloatRef r102, AnimationScope r103) {
        float r104 = ((Number) r103.getValue()).floatValue() - r100.element;
        float r105 = r101.getScrollOffset();
        r101.setScrollOffset(r105 + r104);
        float r106 = Math.abs(r105 - r101.getScrollOffset());
        r100.element = ((Number) r103.getValue()).floatValue();
        r102.element = ((Number) r103.getVelocity()).floatValue();
        if (Math.abs(r104 - r106) <= 0.5f) goto L6;
        r103.cancelAnimation();
    L6:
        return Unit.INSTANCE;
    }

    public EnterAlwaysSearchBarScrollBehavior(float r100, float r101, Function0<Boolean> r102, boolean r103, AnimationSpec<Float> r104, DecayAnimationSpec<Float> r105) {
        this.canScroll = r102;
        this.reverseLayout = r103;
        this.snapAnimationSpec = r104;
        this.flingAnimationSpec = r105;
        this._offset = PrimitiveSnapshotStateKt.mutableFloatStateOf(r100);
        this.scrollOffsetLimit$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(r101);
        this.nestedScrollConnection = new EnterAlwaysSearchBarScrollBehavior$nestedScrollConnection$1(this);
    }
}
