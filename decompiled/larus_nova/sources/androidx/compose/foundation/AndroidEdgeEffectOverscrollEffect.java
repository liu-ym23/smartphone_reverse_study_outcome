package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0$H\u0016¢\u0006\u0004\b%\u0010&J<\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\"\u0010*\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0,\u0012\u0006\u0012\u0004\u0018\u00010-0+H\u0096@¢\u0006\u0004\b.\u0010/J\u0017\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u000201H\u0000¢\u0006\u0004\b5\u00106J\u000f\u00109\u001a\u00020\rH\u0000¢\u0006\u0004\b:\u0010;J\r\u0010B\u001a\u00020\u0013H\u0000¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\u0013H\u0002J\u0017\u0010E\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bN\u0010LJ\u0017\u0010O\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bP\u0010LJ\u0017\u0010Q\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bR\u0010LR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00178\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u00102\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001bR\u0010\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020?X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A¨\u0006S"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "density", "Landroidx/compose/ui/unit/Density;", "glowColor", "Landroidx/compose/ui/graphics/Color;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroid/content/Context;Landroidx/compose/ui/unit/Density;JLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "", "getRedrawSignal$foundation_release", "()Landroidx/compose/runtime/MutableState;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "scrollCycleInProgress", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "containerSize", "Landroidx/compose/ui/geometry/Size;", "isInProgress", "updateSize", "size", "updateSize-uvyYCjk$foundation_release", "(J)V", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "displacement", "displacement-F1C5BW0$foundation_release", "()J", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "invalidateOverscroll", "invalidateOverscroll$foundation_release", "animateToReleaseIfNeeded", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "pullTop", "", GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, "pullTop-k-4lQ0M", "(J)F", "pullBottom", "pullBottom-k-4lQ0M", "pullLeft", "pullLeft-k-4lQ0M", "pullRight", "pullRight-k-4lQ0M", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public static final int $stable = 0;
    private long containerSize;
    private final Density density;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private boolean invalidationEnabled;
    private final DelegatableNode node;
    private long pointerId;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private long pointerPosition;
    private final MutableState<Unit> redrawSignal;
    private boolean scrollCycleInProgress;

    public /* synthetic */ AndroidEdgeEffectOverscrollEffect(Context r100, Density r101, long r102, PaddingValues r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public final /* synthetic */ Modifier getEffectModifier() {
        return OverscrollEffect.CC.$default$getEffectModifier(this);
    }

    private final void animateToReleaseIfNeeded() {
        EdgeEffectWrapper r100 = this.edgeEffectWrapper;
        EdgeEffect r101 = EdgeEffectWrapper.access$getTopEffect$p(r100);
        boolean r102 = true;
        if (r101 == null) goto L5;
        r101.onRelease();
        boolean r103 = !r101.isFinished();
    L6:
        EdgeEffect r104 = EdgeEffectWrapper.access$getBottomEffect$p(r100);
        if (r104 == null) goto L14;
        r104.onRelease();
        if (r104.isFinished() == false) goto L13;
        if (r103 == true) goto L13;
        r103 = false;
    L13:
        r103 = true;
    L14:
        EdgeEffect r105 = EdgeEffectWrapper.access$getLeftEffect$p(r100);
        if (r105 == null) goto L22;
        r105.onRelease();
        if (r105.isFinished() == false) goto L21;
        if (r103 == true) goto L21;
        r103 = false;
    L21:
        r103 = true;
    L22:
        EdgeEffect r106 = EdgeEffectWrapper.access$getRightEffect$p(r100);
        if (r106 == null) goto L30;
        r106.onRelease();
        if (r106.isFinished() == false) goto L29;
        if (r103 == true) goto L29;
        r102 = false;
    L29:
        r103 = r102;
    L30:
        if (r103 == false) goto L33;
        invalidateOverscroll$foundation_release();
        return;
    L33:
        return;
    L5:
        r103 = false;
        goto L6
    }

    /* JADX INFO: renamed from: displacement-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m212displacementF1C5BW0$foundation_release() {
        long r100 = this.pointerPosition;
        if ((9223372034707292159L & r100) == InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = SizeKt.m4661getCenteruvyYCjk(this.containerSize);
    L9:
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) / Float.intBitsToFloat((int) (this.containerSize & BodyPartID.bodyIdMax));
        long r104 = Float.floatToRawIntBits(r102);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r103)) & BodyPartID.bodyIdMax) | (r104 << 32));
    L5:
        r101 = false;
        goto L6
    }

    public final void invalidateOverscroll$foundation_release() {
        if (this.invalidationEnabled == false) goto L6;
        this.redrawSignal.setValue(Unit.INSTANCE);
        return;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        EdgeEffectWrapper r100 = this.edgeEffectWrapper;
        EdgeEffect r101 = EdgeEffectWrapper.access$getTopEffect$p(r100);
        if (r101 != null) goto L5;
    L10:
        EdgeEffect r102 = EdgeEffectWrapper.access$getBottomEffect$p(r100);
        if (r102 != null) goto L13;
    L18:
        EdgeEffect r103 = EdgeEffectWrapper.access$getLeftEffect$p(r100);
        if (r103 != null) goto L21;
    L26:
        EdgeEffect r104 = EdgeEffectWrapper.access$getRightEffect$p(r100);
        if (r104 != null) goto L29;
    L34:
        return false;
    L29:
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(r104) != 0.0f) goto L31;
        boolean r105 = true;
    L32:
        if (r105 == true) goto L34;
        return true;
    L31:
        r105 = false;
        goto L32
    L21:
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(r103) != 0.0f) goto L23;
        boolean r106 = true;
    L24:
        if (r106 == true) goto L26;
        return true;
    L23:
        r106 = false;
        goto L24
    L13:
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(r102) != 0.0f) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == true) goto L18;
        return true;
    L15:
        r107 = false;
        goto L16
    L5:
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(r101) != 0.0f) goto L7;
        boolean r108 = true;
    L8:
        if (r108 == true) goto L10;
        return true;
    L7:
        r108 = false;
        goto L8
    }

    public final boolean getInvalidationEnabled$foundation_release() {
        return this.invalidationEnabled;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public DelegatableNode getNode() {
        return this.node;
    }

    public final MutableState<Unit> getRedrawSignal$foundation_release() {
        return this.redrawSignal;
    }

    public static final /* synthetic */ long access$getPointerId$p(AndroidEdgeEffectOverscrollEffect r100) {
        return r100.pointerId;
    }

    /* JADX INFO: renamed from: pullBottom-k-4lQ0M, reason: not valid java name */
    private final float m205pullBottomk4lQ0M(long r100) {
        float r101 = Float.intBitsToFloat((int) (m212displacementF1C5BW0$foundation_release() >> 32));
        int r110 = (int) (r100 & BodyPartID.bodyIdMax);
        float r102 = Float.intBitsToFloat(r110) / Float.intBitsToFloat((int) (this.containerSize & BodyPartID.bodyIdMax));
        EdgeEffect r103 = this.edgeEffectWrapper.getOrCreateBottomEffect();
        EdgeEffectCompat r104 = EdgeEffectCompat.INSTANCE;
        boolean r105 = true;
        float r106 = (-r104.onPullDistanceCompat(r103, -r102, 1 - r101)) * Float.intBitsToFloat((int) (this.containerSize & BodyPartID.bodyIdMax));
        if (r104.getDistanceCompat(r103) == 0.0f) goto L6;
        r105 = false;
    L6:
        if (r105 == false) goto L8;
        return r106;
    L8:
        return Float.intBitsToFloat(r110);
    }

    /* JADX INFO: renamed from: pullLeft-k-4lQ0M, reason: not valid java name */
    private final float m206pullLeftk4lQ0M(long r100) {
        float r101 = Float.intBitsToFloat((int) (m212displacementF1C5BW0$foundation_release() & BodyPartID.bodyIdMax));
        int r102 = (int) (r100 >> 32);
        float r103 = Float.intBitsToFloat(r102) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect r104 = this.edgeEffectWrapper.getOrCreateLeftEffect();
        EdgeEffectCompat r105 = EdgeEffectCompat.INSTANCE;
        boolean r106 = true;
        float r107 = r105.onPullDistanceCompat(r104, r103, 1 - r101) * Float.intBitsToFloat((int) (this.containerSize >> 32));
        if (r105.getDistanceCompat(r104) == 0.0f) goto L6;
        r106 = false;
    L6:
        if (r106 == false) goto L8;
        return r107;
    L8:
        return Float.intBitsToFloat(r102);
    }

    /* JADX INFO: renamed from: pullRight-k-4lQ0M, reason: not valid java name */
    private final float m207pullRightk4lQ0M(long r100) {
        float r101 = Float.intBitsToFloat((int) (m212displacementF1C5BW0$foundation_release() & BodyPartID.bodyIdMax));
        int r102 = (int) (r100 >> 32);
        float r103 = Float.intBitsToFloat(r102) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect r104 = this.edgeEffectWrapper.getOrCreateRightEffect();
        EdgeEffectCompat r105 = EdgeEffectCompat.INSTANCE;
        float r106 = (-r105.onPullDistanceCompat(r104, -r103, r101)) * Float.intBitsToFloat((int) (this.containerSize >> 32));
        if (r105.getDistanceCompat(r104) != 0.0f) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == false) goto L8;
        return r106;
    L8:
        return Float.intBitsToFloat(r102);
    L5:
        r107 = false;
        goto L6
    }

    /* JADX INFO: renamed from: pullTop-k-4lQ0M, reason: not valid java name */
    private final float m208pullTopk4lQ0M(long r100) {
        float r101 = Float.intBitsToFloat((int) (m212displacementF1C5BW0$foundation_release() >> 32));
        int r102 = (int) (r100 & BodyPartID.bodyIdMax);
        float r103 = Float.intBitsToFloat(r102) / Float.intBitsToFloat((int) (this.containerSize & BodyPartID.bodyIdMax));
        EdgeEffect r104 = this.edgeEffectWrapper.getOrCreateTopEffect();
        EdgeEffectCompat r105 = EdgeEffectCompat.INSTANCE;
        float r106 = r105.onPullDistanceCompat(r104, r103, r101) * Float.intBitsToFloat((int) (this.containerSize & BodyPartID.bodyIdMax));
        if (r105.getDistanceCompat(r104) != 0.0f) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == false) goto L8;
        return r106;
    L8:
        return Float.intBitsToFloat(r102);
    L5:
        r107 = false;
        goto L6
    }

    /* JADX INFO: renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m209releaseOppositeOverscrollk4lQ0M(long r110) {
        boolean r100 = false;
        if (this.edgeEffectWrapper.isLeftAnimating() == false) goto L7;
        int r101 = (int) (r110 >> 32);
        if (Float.intBitsToFloat(r101) >= 0.0f) goto L7;
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Float.intBitsToFloat(r101));
        boolean r102 = this.edgeEffectWrapper.isLeftAnimating();
    L9:
        if (this.edgeEffectWrapper.isRightAnimating() == false) goto L20;
        int r103 = (int) (r110 >> 32);
        if (Float.intBitsToFloat(r103) <= 0.0f) goto L20;
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Float.intBitsToFloat(r103));
        if (r102 == false) goto L15;
    L18:
        r102 = true;
        goto L20
    L15:
        if (this.edgeEffectWrapper.isRightAnimating() == true) goto L18;
        r102 = false;
    L20:
        if (this.edgeEffectWrapper.isTopAnimating() == false) goto L31;
        int r104 = (int) (r110 & BodyPartID.bodyIdMax);
        if (Float.intBitsToFloat(r104) >= 0.0f) goto L31;
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Float.intBitsToFloat(r104));
        if (r102 == false) goto L26;
    L29:
        r102 = true;
        goto L31
    L26:
        if (this.edgeEffectWrapper.isTopAnimating() == true) goto L29;
        r102 = false;
    L31:
        if (this.edgeEffectWrapper.isBottomAnimating() == false) goto L41;
        int r111 = (int) (r110 & BodyPartID.bodyIdMax);
        if (Float.intBitsToFloat(r111) <= 0.0f) goto L42;
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Float.intBitsToFloat(r111));
        if (r102 == false) goto L37;
    L38:
        r100 = true;
    L40:
        return r100;
    L37:
        if (this.edgeEffectWrapper.isBottomAnimating() == false) goto L40;
    L42:
        return r102;
    L41:
        return r102;
    L7:
        r102 = false;
        goto L9
    }

    public final void setInvalidationEnabled$foundation_release(boolean r100) {
        this.invalidationEnabled = r100;
    }

    /* JADX INFO: renamed from: updateSize-uvyYCjk$foundation_release, reason: not valid java name */
    public final void m213updateSizeuvyYCjk$foundation_release(long r110) {
        boolean r100 = Size.m4647equalsimpl0(this.containerSize, Size.Companion.m4660getZeroNHjbRc());
        boolean r101 = !Size.m4647equalsimpl0(r110, this.containerSize);
        this.containerSize = r110;
        if (r101 == false) goto L5;
        EdgeEffectWrapper r102 = this.edgeEffectWrapper;
        int r103 = MathKt.roundToInt(Float.intBitsToFloat((int) (r110 >> 32)));
        r102.m286updateSizeozmzZPI(IntSize.m7714constructorimpl((((long) MathKt.roundToInt(Float.intBitsToFloat((int) (r110 & BodyPartID.bodyIdMax)))) & BodyPartID.bodyIdMax) | (((long) r103) << 32)));
    L5:
        if (r100 == true) goto L9;
        if (r101 == false) goto L10;
        animateToReleaseIfNeeded();
        return;
    L10:
        return;
    }

    public static final /* synthetic */ void access$setPointerId$p(AndroidEdgeEffectOverscrollEffect r100, long r101) {
        r100.pointerId = r101;
    }

    public static final /* synthetic */ void access$setPointerPosition$p(AndroidEdgeEffectOverscrollEffect r100, long r101) {
        r100.pointerPosition = r101;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    public Object mo210applyToFlingBMRW4eQ(long r110, Function2<? super Velocity, ? super Continuation<? super Velocity>, ? extends Object> r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof AndroidEdgeEffectOverscrollEffect$applyToFling$1) == false) goto L7;
        AndroidEdgeEffectOverscrollEffect$applyToFling$1 r100 = (AndroidEdgeEffectOverscrollEffect$applyToFling$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        long r114 = r100.J$0;
        ResultKt.throwOnFailure(r113);
    L51:
        long r115 = Velocity.m7789minusAH228Gc(r114, ((Velocity) r113).m7795unboximpl());
        this.scrollCycleInProgress = false;
        if (Velocity.m7786getXimpl(r115) <= 0.0f) goto L55;
        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.m7786getXimpl(r115)));
    L58:
        if (Velocity.m7787getYimpl(r115) <= 0.0f) goto L61;
        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.m7787getYimpl(r115)));
    L63:
        animateToReleaseIfNeeded();
        return Unit.INSTANCE;
    L61:
        if (Velocity.m7787getYimpl(r115) >= 0.0f) goto L63;
        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateBottomEffect(), -MathKt.roundToInt(Velocity.m7787getYimpl(r115)));
        goto L63
    L55:
        if (Velocity.m7786getXimpl(r115) >= 0.0f) goto L58;
        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateRightEffect(), -MathKt.roundToInt(Velocity.m7786getXimpl(r115)));
        goto L58
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r113);
    L22:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r113);
        if (Size.m4653isEmptyimpl(this.containerSize) == false) goto L24;
        Velocity r116 = Velocity.m7777boximpl(r110);
        r100.label = 1;
        if (r111.invoke(r116, r100) != r102) goto L22;
        return r102;
    L24:
        if (this.edgeEffectWrapper.isLeftStretched() == false) goto L29;
        if (Velocity.m7786getXimpl(r110) >= 0.0f) goto L29;
        float r117 = EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateLeftEffect(), Velocity.m7786getXimpl(r110), Float.intBitsToFloat((int) (this.containerSize >> 32)), this.density);
    L35:
        if (this.edgeEffectWrapper.isTopStretched() == false) goto L40;
        if (Velocity.m7787getYimpl(r110) >= 0.0f) goto L40;
        float r104 = EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateTopEffect(), Velocity.m7787getYimpl(r110), Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & this.containerSize)), this.density);
    L45:
        long r105 = VelocityKt.Velocity(r117, r104);
        if (Velocity.m7785equalsimpl0(r105, Velocity.Companion.m7797getZero9UxMQ8M()) == true) goto L48;
        invalidateOverscroll$foundation_release();
    L48:
        r114 = Velocity.m7789minusAH228Gc(r110, r105);
        Velocity r118 = Velocity.m7777boximpl(r114);
        r100.J$0 = r114;
        r100.label = 2;
        r113 = r111.invoke(r118, r100);
        if (r113 != r102) goto L51;
        return r102;
    L40:
        if (this.edgeEffectWrapper.isBottomStretched() == true) goto L42;
    L44:
        r104 = 0.0f;
        goto L45
    L42:
        if (Velocity.m7787getYimpl(r110) <= 0.0f) goto L44;
        r104 = -EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateBottomEffect(), -Velocity.m7787getYimpl(r110), Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & this.containerSize)), this.density);
    L29:
        if (this.edgeEffectWrapper.isRightStretched() == true) goto L31;
    L33:
        r117 = 0.0f;
        goto L35
    L31:
        if (Velocity.m7786getXimpl(r110) <= 0.0f) goto L33;
        r117 = -EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateRightEffect(), -Velocity.m7786getXimpl(r110), Float.intBitsToFloat((int) (this.containerSize >> 32)), this.density);
    L7:
        r100 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, r112);
        goto L8
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    public long mo211applyToScrollRhakbz0(long r210, int r211, Function1<? super Offset, Offset> r212) {
        if (Size.m4653isEmptyimpl(this.containerSize) == false) goto L7;
        return r212.invoke(Offset.m4571boximpl(r210)).m4592unboximpl();
    L7:
        if (this.scrollCycleInProgress == false) goto L9;
    L21:
        float r100 = AndroidOverscroll_androidKt.m228access$destretchMultiplierGyEprt8(r211);
        long r101 = Offset.m4589timestuRUvjQ(r210, r100);
        int r110 = (int) (r210 & BodyPartID.bodyIdMax);
        if (Float.intBitsToFloat(r110) != 0.0f) goto L24;
        boolean r111 = true;
    L25:
        if (r111 == false) goto L28;
    L26:
        float r112 = 0.0f;
    L54:
        int r113 = (int) (r210 >> 32);
        if (Float.intBitsToFloat(r113) != 0.0f) goto L57;
        boolean r114 = true;
    L58:
        if (r114 == false) goto L61;
    L59:
        float r102 = 0.0f;
    L88:
        long r103 = Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (((long) Float.floatToRawIntBits(r112)) & BodyPartID.bodyIdMax));
        Offset.Companion r104 = Offset.Companion;
        if (Offset.m4579equalsimpl0(r103, r104.m4598getZeroF1C5BW0()) == true) goto L91;
        invalidateOverscroll$foundation_release();
    L91:
        long r115 = Offset.m4586minusMKHz9U(r210, r103);
        long r105 = r212.invoke(Offset.m4571boximpl(r115)).m4592unboximpl();
        long r116 = Offset.m4586minusMKHz9U(r115, r105);
        if (Float.intBitsToFloat((int) (r115 >> 32)) != 0.0f) goto L94;
        boolean r106 = true;
    L96:
        if (r106 == false) goto L103;
        if (Float.intBitsToFloat((int) (r115 & BodyPartID.bodyIdMax)) != 0.0f) goto L100;
        boolean r107 = true;
    L101:
        if (r107 == false) goto L103;
    L122:
        if (NestedScrollSource.m6006equalsimpl0(r211, NestedScrollSource.Companion.m6018getUserInputWNlRxjI()) == false) goto L143;
        int r108 = (int) (r116 >> 32);
        if (Float.intBitsToFloat(r108) <= 0.5f) goto L129;
        m206pullLeftk4lQ0M(r116);
    L126:
        boolean r109 = true;
    L132:
        int r117 = (int) (BodyPartID.bodyIdMax & r116);
        if (Float.intBitsToFloat(r117) <= 0.5f) goto L137;
        m208pullTopk4lQ0M(r116);
    L135:
        boolean r118 = true;
    L140:
        if (r109 == true) goto L142;
        if (r118 == false) goto L143;
    L142:
        boolean r119 = true;
    L145:
        if (Offset.m4579equalsimpl0(r115, r104.m4598getZeroF1C5BW0()) == false) goto L147;
    L153:
        if (r119 == false) goto L156;
        invalidateOverscroll$foundation_release();
    L156:
        return Offset.m4587plusMKHz9U(r103, r105);
    L147:
        if (m209releaseOppositeOverscrollk4lQ0M(r210) == true) goto L151;
        if (r119 == true) goto L151;
        boolean r120 = false;
    L152:
        r119 = r120;
    L151:
        r120 = true;
        goto L152
    L137:
        if (Float.intBitsToFloat(r117) >= (-0.5f)) goto L139;
        m205pullBottomk4lQ0M(r116);
        goto L135
    L139:
        r118 = false;
        goto L140
    L129:
        if (Float.intBitsToFloat(r108) >= (-0.5f)) goto L131;
        m207pullRightk4lQ0M(r116);
        goto L126
    L131:
        r109 = false;
    L143:
        r119 = false;
        goto L145
    L100:
        r107 = false;
    L103:
        if (Float.intBitsToFloat((int) (r105 >> 32)) != 0.0f) goto L105;
        boolean r121 = true;
    L106:
        if (r121 == true) goto L108;
    L112:
        EdgeEffectWrapper r122 = this.edgeEffectWrapper;
        if (r122.isLeftStretched() == false) goto L115;
    L120:
        animateToReleaseIfNeeded();
        goto L122
    L115:
        if (r122.isTopStretched() == true) goto L120;
        if (r122.isRightStretched() == true) goto L120;
        if (r122.isBottomStretched() == false) goto L122;
    L108:
        if (Float.intBitsToFloat((int) (r105 & BodyPartID.bodyIdMax)) != 0.0f) goto L110;
        boolean r123 = true;
    L111:
        if (r123 == true) goto L122;
    L110:
        r123 = false;
        goto L111
    L105:
        r121 = false;
        goto L106
    L94:
        r106 = false;
        goto L96
    L61:
        if (this.edgeEffectWrapper.isLeftStretched() == false) goto L75;
        if (Float.intBitsToFloat(r113) >= 0.0f) goto L75;
        float r124 = m206pullLeftk4lQ0M(r101);
        if (this.edgeEffectWrapper.isLeftStretched() == true) goto L68;
        this.edgeEffectWrapper.getOrCreateLeftEffect().finish();
    L68:
        if (r124 != Float.intBitsToFloat((int) (r101 >> 32))) goto L70;
        boolean r125 = true;
    L71:
        if (r125 == false) goto L73;
        r102 = Float.intBitsToFloat(r113);
        goto L88
    L73:
        r102 = r124 / r100;
        goto L88
    L70:
        r125 = false;
    L75:
        if (this.edgeEffectWrapper.isRightStretched() == false) goto L59;
        if (Float.intBitsToFloat(r113) <= 0.0f) goto L59;
        float r126 = m207pullRightk4lQ0M(r101);
        if (this.edgeEffectWrapper.isRightStretched() == true) goto L82;
        this.edgeEffectWrapper.getOrCreateRightEffect().finish();
    L82:
        if (r126 != Float.intBitsToFloat((int) (r101 >> 32))) goto L84;
        boolean r127 = true;
    L85:
        if (r127 == false) goto L87;
        r102 = Float.intBitsToFloat(r113);
        goto L88
    L87:
        r102 = r126 / r100;
        goto L88
    L84:
        r127 = false;
        goto L85
    L57:
        r114 = false;
        goto L58
    L28:
        if (this.edgeEffectWrapper.isTopStretched() == false) goto L42;
        if (Float.intBitsToFloat(r110) >= 0.0f) goto L42;
        float r128 = m208pullTopk4lQ0M(r101);
        if (this.edgeEffectWrapper.isTopStretched() == true) goto L35;
        this.edgeEffectWrapper.getOrCreateTopEffect().finish();
    L35:
        if (r128 != Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax))) goto L37;
        boolean r129 = true;
    L38:
        if (r129 == false) goto L40;
        r112 = Float.intBitsToFloat(r110);
    L40:
        r112 = r128 / r100;
        goto L54
    L37:
        r129 = false;
    L42:
        if (this.edgeEffectWrapper.isBottomStretched() == false) goto L26;
        if (Float.intBitsToFloat(r110) <= 0.0f) goto L26;
        r128 = m205pullBottomk4lQ0M(r101);
        if (this.edgeEffectWrapper.isBottomStretched() == true) goto L49;
        this.edgeEffectWrapper.getOrCreateBottomEffect().finish();
    L49:
        if (r128 != Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax))) goto L51;
        boolean r130 = true;
    L52:
        if (r130 == false) goto L40;
        r112 = Float.intBitsToFloat(r110);
        goto L54
    L51:
        r130 = false;
        goto L52
    L24:
        r111 = false;
        goto L25
    L9:
        if (this.edgeEffectWrapper.isLeftStretched() == false) goto L12;
        m206pullLeftk4lQ0M(Offset.Companion.m4598getZeroF1C5BW0());
    L12:
        if (this.edgeEffectWrapper.isRightStretched() == false) goto L15;
        m207pullRightk4lQ0M(Offset.Companion.m4598getZeroF1C5BW0());
    L15:
        if (this.edgeEffectWrapper.isTopStretched() == false) goto L18;
        m208pullTopk4lQ0M(Offset.Companion.m4598getZeroF1C5BW0());
    L18:
        if (this.edgeEffectWrapper.isBottomStretched() == false) goto L20;
        m205pullBottomk4lQ0M(Offset.Companion.m4598getZeroF1C5BW0());
    L20:
        this.scrollCycleInProgress = true;
        goto L21
    }

    private AndroidEdgeEffectOverscrollEffect(Context r100, Density r101, long r102, PaddingValues r103) {
        this.density = r101;
        this.pointerPosition = Offset.Companion.m4597getUnspecifiedF1C5BW0();
        EdgeEffectWrapper r104 = new EdgeEffectWrapper(r100, ColorKt.m4881toArgb8_81llA(r102));
        this.edgeEffectWrapper = r104;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.Companion.m4660getZeroNHjbRc();
        this.pointerId = PointerId.m6106constructorimpl(-1);
        SuspendingPointerInputModifierNode r105 = SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AndroidEdgeEffectOverscrollEffect$pointerInputNode$1(this));
        this.pointerInputNode = r105;
        if (Build.VERSION.SDK_INT < 31) goto L5;
        DelegatableNode r106 = new StretchOverscrollNode(r105, this, r104);
    L6:
        this.node = r106;
        return;
    L5:
        r106 = new GlowOverscrollNode(r105, this, r104, r103);
        goto L6
    }
}
