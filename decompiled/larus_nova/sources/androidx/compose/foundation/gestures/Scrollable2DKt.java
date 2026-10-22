package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aB\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u001a\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0014\u001a\u00020\u0015*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0018\u0010\u0019\u001a\u00020\u0015*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, d2 = {"scrollable2D", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "enabled", "", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/Scroll2DScope;", "semanticsScrollBy", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/ScrollingLogic2D;", "offset", "semanticsScrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/ScrollingLogic2D;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "magnitude", "", "Landroidx/compose/ui/unit/Velocity;", "getMagnitude-TH1AsA0", "(J)F", "angle", "getAngle-TH1AsA0", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Scrollable2DKt {
    private static final Scroll2DScope NoOpScrollScope = null;

    static {
        NoOpScrollScope = new Scrollable2DKt$NoOpScrollScope$1();
    }

    public static final /* synthetic */ Scroll2DScope access$getNoOpScrollScope$p() {
        return NoOpScrollScope;
    }

    /* JADX INFO: renamed from: access$getAngle-TH1AsA0, reason: not valid java name */
    public static final /* synthetic */ float m487access$getAngleTH1AsA0(long r100) {
        return m490getAngleTH1AsA0(r100);
    }

    /* JADX INFO: renamed from: access$getMagnitude-TH1AsA0, reason: not valid java name */
    public static final /* synthetic */ float m488access$getMagnitudeTH1AsA0(long r100) {
        return m491getMagnitudeTH1AsA0(r100);
    }

    /* JADX INFO: renamed from: getAngle-TH1AsA0, reason: not valid java name */
    private static final float m490getAngleTH1AsA0(long r100) {
        return (float) Math.atan2(Velocity.m7787getYimpl(r100), Velocity.m7786getXimpl(r100));
    }

    /* JADX INFO: renamed from: getMagnitude-TH1AsA0, reason: not valid java name */
    private static final float m491getMagnitudeTH1AsA0(long r100) {
        double r101 = 2;
        return (float) Math.sqrt(((float) Math.pow(Velocity.m7786getXimpl(r100), r101)) + ((float) Math.pow(Velocity.m7787getYimpl(r100), r101)));
    }

    /* JADX INFO: renamed from: access$semanticsScrollBy-d-4ec7I, reason: not valid java name */
    public static final /* synthetic */ Object m489access$semanticsScrollByd4ec7I(ScrollingLogic2D r100, long r101, Continuation r102) {
        return m492semanticsScrollByd4ec7I(r100, r101, r102);
    }

    /* JADX INFO: renamed from: semanticsScrollBy-d-4ec7I, reason: not valid java name */
    private static final Object m492semanticsScrollByd4ec7I(ScrollingLogic2D r100, long r101, Continuation<? super Offset> r102) {
        if ((r102 instanceof Scrollable2DKt$semanticsScrollBy$1) == false) goto L7;
        Scrollable2DKt$semanticsScrollBy$1 r103 = (Scrollable2DKt$semanticsScrollBy$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        Ref.LongRef r108 = (Ref.LongRef) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L19:
        return Offset.m4571boximpl(r108.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        Ref.LongRef r109 = new Ref.LongRef();
        r109.element = Offset.Companion.m4598getZeroF1C5BW0();
        MutatePriority r110 = MutatePriority.Default;
        Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> r111 = new Scrollable2DKt$semanticsScrollBy$2(r101, r109, null);
        r103.L$0 = r109;
        r103.label = 1;
        if (r100.scroll(r110, r111, r103) != r106) goto L17;
        return r106;
    L17:
        r108 = r109;
    L7:
        r103 = new Scrollable2DKt$semanticsScrollBy$1(r102);
        goto L8
    }

    public static final Modifier scrollable2D(Modifier r100, Scrollable2DState r101, boolean r102, OverscrollEffect r110, FlingBehavior r111, MutableInteractionSource r112) {
        return r100.then(new Scrollable2DElement(r101, r110, r102, r111, r112));
    }

    public static /* synthetic */ Modifier scrollable2D$default(Modifier r100, Scrollable2DState r101, boolean r102, OverscrollEffect r103, FlingBehavior r110, MutableInteractionSource r111, int r112, Object r113) {
        if ((r112 & 2) == 0) goto L5;
        boolean r104 = true;
    L7:
        if ((r112 & 4) == 0) goto L9;
        OverscrollEffect r105 = null;
    L11:
        if ((r112 & 8) == 0) goto L13;
        FlingBehavior r106 = null;
    L15:
        if ((r112 & 16) == 0) goto L17;
        MutableInteractionSource r107 = null;
    L19:
        return scrollable2D(r100, r101, r104, r105, r106, r107);
    L17:
        r107 = r111;
        goto L19
    L13:
        r106 = r110;
        goto L15
    L9:
        r105 = r103;
        goto L11
    L5:
        r104 = r102;
        goto L7
    }
}
