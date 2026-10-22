package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016J$\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0087@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u001fJ\r\u0010'\u001a\u00020\u001cH\u0000¢\u0006\u0002\b(J\b\u0010/\u001a\u00020*H\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0019\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0012R\u001a\u0010#\u001a\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010!\u001a\u0004\b%\u0010&R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00061"}, d2 = {"Landroidx/compose/material/DrawerState;", "", "initialValue", "Landroidx/compose/material/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "<init>", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material", "()Landroidx/compose/material/AnchoredDraggableState;", "isOpen", "()Z", "isClosed", "currentValue", "getCurrentValue", "()Landroidx/compose/material/DrawerValue;", "isAnimationRunning", "open", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "animateTo", "targetValue", "anim", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/material/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "(Landroidx/compose/material/DrawerValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTargetValue$annotations", "()V", "getTargetValue", "offset", "getOffset$annotations", "getOffset", "()F", "requireOffset", "requireOffset$material", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$material", "()Landroidx/compose/ui/unit/Density;", "setDensity$material", "(Landroidx/compose/ui/unit/Density;)V", "requireDensity", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DrawerState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final AnchoredDraggableState<DrawerValue> anchoredDraggableState;
    private Density density;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/material/DrawerState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/DrawerState;", "Landroidx/compose/material/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ DrawerValue a(SaverScope r100, DrawerState r101) {
            return Saver$lambda$0(r100, r101);
        }

        public static /* synthetic */ DrawerState b(Function1 r100, DrawerValue r101) {
            return Saver$lambda$1(r100, r101);
        }

        public final Saver<DrawerState, DrawerValue> Saver(final Function1<? super DrawerValue, Boolean> r100) {
            return SaverKt.Saver(new o4(), new p4(r100));
        }

        private static final DrawerValue Saver$lambda$0(SaverScope r100, DrawerState r101) {
            return r101.getCurrentValue();
        }

        private static final DrawerState Saver$lambda$1(Function1 r100, DrawerValue r101) {
            return new DrawerState(r101, r100);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final boolean _init_$lambda$0(DrawerValue r100) {
        return true;
    }

    public static /* synthetic */ boolean a(DrawerValue r100) {
        return _init_$lambda$0(r100);
    }

    public static /* synthetic */ float b(DrawerState r100, float r101) {
        return anchoredDraggableState$lambda$2(r100, r101);
    }

    public static /* synthetic */ float c(DrawerState r100) {
        return anchoredDraggableState$lambda$4(r100);
    }

    public static /* synthetic */ void getOffset$annotations() {
    }

    public static /* synthetic */ void getTargetValue$annotations() {
    }

    private final Density requireDensity() {
        Density r100 = this.density;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException(("The density on DrawerState (" + this + ") was not set. Did you use DrawerState with the Drawer composable?").toString());
    }

    public final DrawerValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final float getOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final DrawerValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isAnimationRunning() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final float requireOffset$material() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final boolean isClosed() {
        if (getCurrentValue() != DrawerValue.Closed) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOpen() {
        if (getCurrentValue() != DrawerValue.Open) goto L5;
        return true;
    L5:
        return false;
    }

    public final AnchoredDraggableState<DrawerValue> getAnchoredDraggableState$material() {
        return this.anchoredDraggableState;
    }

    public final Density getDensity$material() {
        return this.density;
    }

    private static final float anchoredDraggableState$lambda$4(DrawerState r100) {
        return r100.requireDensity().mo371toPx0680j_4(DrawerKt.access$getDrawerVelocityThreshold$p());
    }

    public final Object close(Continuation<? super Unit> r100) {
        Object r101 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, DrawerValue.Closed, 0.0f, r100, 2, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final Object open(Continuation<? super Unit> r100) {
        Object r101 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, DrawerValue.Open, 0.0f, r100, 2, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final void setDensity$material(Density r100) {
        this.density = r100;
    }

    public DrawerState(DrawerValue r100, Function1<? super DrawerValue, Boolean> r101) {
        TweenSpec r102 = DrawerKt.access$getAnimationSpec$p();
        this.anchoredDraggableState = new AnchoredDraggableState(r100, new l4(this), new m4(this), r102, r101);
    }

    private static final float anchoredDraggableState$lambda$2(DrawerState r100, float r101) {
        return r100.requireDensity().mo371toPx0680j_4(DrawerKt.access$getDrawerPositionalThreshold$p());
    }

    public final Object snapTo(DrawerValue r100, Continuation<? super Unit> r101) {
        Object r102 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This method has been replaced by the open and close methods. The animation spec is now an implementation detail of ModalDrawer.")
    public final Object animateTo(DrawerValue r100, AnimationSpec<Float> r101, Continuation<? super Unit> r102) {
        Object r103 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, r100, 0.0f, r102, 2, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public /* synthetic */ DrawerState(DrawerValue r100, Function1 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = new n4();
    L5:
        this(r100, r101);
    }
}
