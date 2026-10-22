package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 12\u00020\u0001:\u00011BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H\u0007J\b\u0010,\u001a\u00020'H\u0002R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020.X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Landroidx/compose/material/BackdropScaffoldState;", "", "initialValue", "Landroidx/compose/material/BackdropValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "<init>", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;)V", "getConfirmValueChange", "()Lkotlin/jvm/functions/Function1;", "getSnackbarHostState", "()Landroidx/compose/material/SnackbarHostState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/BackdropValue;", "targetValue", "getTargetValue", "requireOffset", "isRevealed", "()Z", "isConcealed", "reveal", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conceal", "progress", "from", RemoteMessageConst.TO, "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material", "()Landroidx/compose/material/AnchoredDraggableState;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$material", "()Landroidx/compose/ui/unit/Density;", "setDensity$material", "(Landroidx/compose/ui/unit/Density;)V", "requireDensity", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection$material", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BackdropScaffoldState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final AnchoredDraggableState<BackdropValue> anchoredDraggableState;
    private final Function1<BackdropValue, Boolean> confirmValueChange;
    private Density density;
    private final NestedScrollConnection nestedScrollConnection;
    private final SnackbarHostState snackbarHostState;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/BackdropScaffoldState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BackdropScaffoldState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Landroidx/compose/material/BackdropValue;", "", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "density", "Landroidx/compose/ui/unit/Density;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ BackdropValue a(SaverScope r100, BackdropScaffoldState r101) {
            return Saver$lambda$0(r100, r101);
        }

        public static /* synthetic */ BackdropScaffoldState b(Density r100, AnimationSpec r101, Function1 r102, SnackbarHostState r103, BackdropValue r104) {
            return Saver$lambda$1(r100, r101, r102, r103, r104);
        }

        private static final BackdropValue Saver$lambda$0(SaverScope r100, BackdropScaffoldState r101) {
            return r101.getAnchoredDraggableState$material().getCurrentValue();
        }

        public final Saver<BackdropScaffoldState, ?> Saver(final AnimationSpec<Float> r100, final Function1<? super BackdropValue, Boolean> r101, final SnackbarHostState r102, final Density r103) {
            return SaverKt.Saver(new g1(), new h1(r103, r100, r101, r102));
        }

        private static final BackdropScaffoldState Saver$lambda$1(Density r100, AnimationSpec r101, Function1 r102, SnackbarHostState r103, BackdropValue r104) {
            return BackdropScaffoldKt.BackdropScaffoldState(r104, r100, r101, r102, r103);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final boolean _init_$lambda$0(BackdropValue r100) {
        return true;
    }

    public static /* synthetic */ float a(BackdropScaffoldState r100) {
        return anchoredDraggableState$lambda$4(r100);
    }

    public static /* synthetic */ float b(BackdropScaffoldState r100, float r101) {
        return anchoredDraggableState$lambda$2(r100, r101);
    }

    public static /* synthetic */ boolean c(BackdropValue r100) {
        return _init_$lambda$0(r100);
    }

    private final Density requireDensity() {
        Density r100 = this.density;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException(("The density on BackdropScaffoldState (" + this + ") was not set. Did you use BackdropScaffoldState with the BackdropScaffold composable?").toString());
    }

    public final BackdropValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final BackdropValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isConcealed() {
        if (this.anchoredDraggableState.getCurrentValue() != BackdropValue.Concealed) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRevealed() {
        if (this.anchoredDraggableState.getCurrentValue() != BackdropValue.Revealed) goto L5;
        return true;
    L5:
        return false;
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final AnchoredDraggableState<BackdropValue> getAnchoredDraggableState$material() {
        return this.anchoredDraggableState;
    }

    public final Function1<BackdropValue, Boolean> getConfirmValueChange() {
        return this.confirmValueChange;
    }

    public final Density getDensity$material() {
        return this.density;
    }

    public final NestedScrollConnection getNestedScrollConnection$material() {
        return this.nestedScrollConnection;
    }

    public final SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }

    private static final float anchoredDraggableState$lambda$4(BackdropScaffoldState r100) {
        return r100.requireDensity().mo371toPx0680j_4(BackdropScaffoldKt.access$getVelocityThreshold$p());
    }

    public final Object conceal(Continuation<? super Unit> r100) {
        Object r101 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BackdropValue.Concealed, 0.0f, r100, 2, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final Object reveal(Continuation<? super Unit> r100) {
        Object r101 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BackdropValue.Revealed, 0.0f, r100, 2, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final void setDensity$material(Density r100) {
        this.density = r100;
    }

    private static final float anchoredDraggableState$lambda$2(BackdropScaffoldState r100, float r101) {
        return r100.requireDensity().mo371toPx0680j_4(BackdropScaffoldKt.access$getPositionalThreshold$p());
    }

    public final float progress(BackdropValue r100, BackdropValue r101) {
        float r102 = this.anchoredDraggableState.getAnchors().positionOf(r100);
        float r103 = this.anchoredDraggableState.getAnchors().positionOf(r101);
        float r104 = (RangesKt.coerceIn(this.anchoredDraggableState.getOffset(), Math.min(r102, r103), Math.max(r102, r103)) - r102) / (r103 - r102);
        if (Float.isNaN(r104) == false) goto L6;
        return 1.0f;
    L6:
        return Math.abs(r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "This constructor is deprecated. Density must be provided by the component. Please use the constructor that provides a [Density].", replaceWith = @ReplaceWith(expression = "\n            BackdropScaffoldState(\n                initialValue = initialValue,\n                density = LocalDensity.current,\n                animationSpec = animationSpec,\n                confirmValueChange = confirmValueChange\n            )\n            ", imports = {}))
    public BackdropScaffoldState(BackdropValue r100, AnimationSpec<Float> r101, Function1<? super BackdropValue, Boolean> r102, SnackbarHostState r110) {
        this.confirmValueChange = r102;
        this.snackbarHostState = r110;
        AnchoredDraggableState<BackdropValue> r111 = new AnchoredDraggableState(r100, new d1(this), new e1(this), r101, r102);
        this.anchoredDraggableState = r111;
        this.nestedScrollConnection = BackdropScaffoldKt.ConsumeSwipeNestedScrollConnection(r111, Orientation.Vertical);
    }

    public /* synthetic */ BackdropScaffoldState(BackdropValue r100, AnimationSpec r101, Function1 r102, SnackbarHostState r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = BackdropScaffoldDefaults.INSTANCE.getAnimationSpec();
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = new f1();
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = new SnackbarHostState();
    L11:
        this(r100, r101, r102, r103);
    }
}
