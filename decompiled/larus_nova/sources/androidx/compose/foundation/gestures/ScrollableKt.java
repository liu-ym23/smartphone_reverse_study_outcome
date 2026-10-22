package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aH\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007\u001a^\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007\u001a\u001c\u0010%\u001a\u00020&*\u00020'2\u0006\u0010(\u001a\u00020&H\u0082@¢\u0006\u0004\b)\u0010*\" \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0018\u001a\u00020\u0007*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u000e\u0010\u001b\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u001d\u001a\u00020\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0014\u0010!\u001a\u00020\"X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006+"}, d2 = {"scrollable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "CanDragCalculation", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "getCanDragCalculation", "()Lkotlin/jvm/functions/Function1;", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "shouldBeTriggeredByMouseWheel", "getShouldBeTriggeredByMouseWheel", "(Landroidx/compose/foundation/gestures/FlingBehavior;)Z", "DefaultScrollMotionDurationScaleFactor", "", "DefaultScrollMotionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "getDefaultScrollMotionDurationScale", "()Landroidx/compose/ui/MotionDurationScale;", "UnityDensity", "Landroidx/compose/ui/unit/Density;", "getUnityDensity", "()Landroidx/compose/ui/unit/Density;", "semanticsScrollBy", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "offset", "semanticsScrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/ScrollingLogic;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScrollableKt {
    private static final Function1<PointerInputChange, Boolean> CanDragCalculation = null;
    private static final MotionDurationScale DefaultScrollMotionDurationScale = null;
    private static final float DefaultScrollMotionDurationScaleFactor = 1.0f;
    private static final ScrollScope NoOpScrollScope = null;
    private static final Density UnityDensity = null;

    public static /* synthetic */ boolean a(PointerInputChange r100) {
        return CanDragCalculation$lambda$0(r100);
    }

    static {
        CanDragCalculation = new d2();
        NoOpScrollScope = new ScrollableKt$NoOpScrollScope$1();
        DefaultScrollMotionDurationScale = new ScrollableKt$DefaultScrollMotionDurationScale$1();
        UnityDensity = new ScrollableKt$UnityDensity$1();
    }

    public static final /* synthetic */ ScrollScope access$getNoOpScrollScope$p() {
        return NoOpScrollScope;
    }

    public static final Function1<PointerInputChange, Boolean> getCanDragCalculation() {
        return CanDragCalculation;
    }

    public static final MotionDurationScale getDefaultScrollMotionDurationScale() {
        return DefaultScrollMotionDurationScale;
    }

    public static final Density getUnityDensity() {
        return UnityDensity;
    }

    private static final boolean CanDragCalculation$lambda$0(PointerInputChange r100) {
        return !PointerType.m6198equalsimpl0(r100.m6129getTypeT8wyACA(), PointerType.Companion.m6203getMouseT8wyACA());
    }

    public static final /* synthetic */ boolean access$getShouldBeTriggeredByMouseWheel(FlingBehavior r100) {
        return getShouldBeTriggeredByMouseWheel(r100);
    }

    private static final boolean getShouldBeTriggeredByMouseWheel(FlingBehavior r100) {
        return !(r100 instanceof ScrollableDefaultFlingBehavior);
    }

    /* JADX INFO: renamed from: access$semanticsScrollBy-d-4ec7I, reason: not valid java name */
    public static final /* synthetic */ Object m494access$semanticsScrollByd4ec7I(ScrollingLogic r100, long r101, Continuation r102) {
        return m495semanticsScrollByd4ec7I(r100, r101, r102);
    }

    /* JADX INFO: renamed from: semanticsScrollBy-d-4ec7I, reason: not valid java name */
    private static final Object m495semanticsScrollByd4ec7I(ScrollingLogic r110, long r111, Continuation<? super Offset> r112) {
        if ((r112 instanceof ScrollableKt$semanticsScrollBy$1) == false) goto L7;
        ScrollableKt$semanticsScrollBy$1 r100 = (ScrollableKt$semanticsScrollBy$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        Ref.FloatRef r114 = (Ref.FloatRef) r100.L$1;
        ScrollingLogic r115 = (ScrollingLogic) r100.L$0;
        ResultKt.throwOnFailure(r113);
        Ref.FloatRef r116 = r114;
        r110 = r115;
    L18:
        return Offset.m4571boximpl(r110.m515toOffsettuRUvjQ(r116.element));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        r116 = new Ref.FloatRef();
        MutatePriority r104 = MutatePriority.Default;
        ScrollableKt$semanticsScrollBy$2 r117 = new ScrollableKt$semanticsScrollBy$2(r110, r111, r116, null);
        r100.L$0 = r110;
        r100.L$1 = r116;
        r100.label = 1;
        if (r110.scroll(r104, r117, r100) != r102) goto L18;
        return r102;
    L7:
        r100 = new ScrollableKt$semanticsScrollBy$1(r112);
        goto L8
    }

    public static final Modifier scrollable(Modifier r110, ScrollableState r111, Orientation r112, boolean r113, boolean r114, FlingBehavior r115, MutableInteractionSource r116) {
        return scrollable$default(r110, r111, r112, null, r113, r114, r115, r116, null, 128, null);
    }

    public static final Modifier scrollable(Modifier r110, ScrollableState r111, Orientation r112, OverscrollEffect r113, boolean r114, boolean r115, FlingBehavior r116, MutableInteractionSource r117, BringIntoViewSpec r118) {
        return r110.then(new ScrollableElement(r111, r112, r113, r114, r115, r116, r117, r118));
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier r100, ScrollableState r101, Orientation r102, boolean r110, boolean r111, FlingBehavior r112, MutableInteractionSource r113, int r114, Object r115) {
        if ((r114 & 4) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r114 & 8) == 0) goto L9;
        boolean r104 = false;
    L11:
        if ((r114 & 16) == 0) goto L13;
        FlingBehavior r105 = null;
    L15:
        if ((r114 & 32) == 0) goto L17;
        MutableInteractionSource r106 = null;
    L19:
        return scrollable(r100, r101, r102, r103, r104, r105, r106);
    L17:
        r106 = r113;
        goto L19
    L13:
        r105 = r112;
        goto L15
    L9:
        r104 = r111;
        goto L11
    L5:
        r103 = r110;
        goto L7
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier r110, ScrollableState r111, Orientation r112, OverscrollEffect r113, boolean r114, boolean r115, FlingBehavior r116, MutableInteractionSource r117, BringIntoViewSpec r118, int r210, Object r211) {
        if ((r210 & 8) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r210 & 16) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r210 & 32) == 0) goto L13;
        FlingBehavior r102 = null;
    L15:
        if ((r210 & 64) == 0) goto L17;
        MutableInteractionSource r103 = null;
    L19:
        if ((r210 & 128) == 0) goto L21;
        BringIntoViewSpec r119 = null;
    L23:
        return scrollable(r110, r111, r112, r113, r100, r101, r102, r103, r119);
    L21:
        r119 = r118;
        goto L23
    L17:
        r103 = r117;
        goto L19
    L13:
        r102 = r116;
        goto L15
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
