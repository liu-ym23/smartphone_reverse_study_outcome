package androidx.compose.foundation;

import C7.r;
import S7.k;
import android.content.Context;
import android.widget.EdgeEffect;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntSizeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016J\u001a\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0016J6\u0010$\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0 H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J?\u0010-\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%2\"\u0010*\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0(\u0012\u0006\u0012\u0004\u0018\u00010)0'H\u0096@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u00102\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.H\u0000ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0015\u00105\u001a\u00020\u000eH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u000f\u00107\u001a\u00020\u000bH\u0000¢\u0006\u0004\b6\u0010\rR\u001e\u00108\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R \u0010>\u001a\b\u0012\u0004\u0012\u00020\u000b0=8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR(\u0010B\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bB\u0010C\u0012\u0004\bG\u0010\r\u001a\u0004\bD\u0010\n\"\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010CR\u001c\u0010I\u001a\u00020.8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bI\u0010JR\u001e\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bL\u0010MR\u001a\u0010O\u001a\u00020N8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006T"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "Landroid/content/Context;", "context", "Landroidx/compose/foundation/OverscrollConfiguration;", "overscrollConfig", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "", "stopOverscrollAnimation", "()Z", "LC7/r;", "animateToRelease", "()V", "Landroidx/compose/ui/geometry/Offset;", "delta", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "releaseOppositeOverscroll", "scroll", "", "pullTop-k-4lQ0M", "(J)F", "pullTop", "pullBottom-k-4lQ0M", "pullBottom", "pullLeft-k-4lQ0M", "pullLeft", "pullRight-k-4lQ0M", "pullRight", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", AgentBusWakeContract.EXTRA_SOURCE, "Lkotlin/Function1;", "performScroll", "applyToScroll-Rhakbz0", "(JILS7/k;)J", "applyToScroll", "Landroidx/compose/ui/unit/Velocity;", "velocity", "Lkotlin/Function2;", "LH7/c;", "", "performFling", "applyToFling-BMRW4eQ", "(JLS7/n;LH7/c;)Ljava/lang/Object;", "applyToFling", "Landroidx/compose/ui/geometry/Size;", "size", "updateSize-uvyYCjk$foundation_release", "(J)V", "updateSize", "displacement-F1C5BW0$foundation_release", "()J", "displacement", "invalidateOverscroll$foundation_release", "invalidateOverscroll", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/EdgeEffectWrapper;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "Landroidx/compose/runtime/MutableState;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "getRedrawSignal$foundation_release", "()Landroidx/compose/runtime/MutableState;", "invalidationEnabled", "Z", "getInvalidationEnabled$foundation_release", "setInvalidationEnabled$foundation_release", "(Z)V", "getInvalidationEnabled$foundation_release$annotations", "scrollCycleInProgress", "containerSize", "J", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "Landroidx/compose/ui/Modifier;", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "isInProgress", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public static final int $stable = 0;
    private long containerSize;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final Modifier effectModifier;
    private boolean invalidationEnabled;
    private PointerId pointerId;
    private Offset pointerPosition;
    private final MutableState<r> redrawSignal;
    private boolean scrollCycleInProgress;

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfiguration) {
        EdgeEffectWrapper edgeEffectWrapper = new EdgeEffectWrapper(context, ColorKt.m4193toArgb8_81llA(overscrollConfiguration.getGlowColor()));
        this.edgeEffectWrapper = edgeEffectWrapper;
        SnapshotMutationPolicy snapshotMutationPolicyNeverEqualPolicy = SnapshotStateKt.neverEqualPolicy();
        r rVar = r.f317a;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(rVar, snapshotMutationPolicyNeverEqualPolicy);
        this.invalidationEnabled = true;
        this.containerSize = Size.INSTANCE.m3973getZeroNHjbRc();
        this.effectModifier = Modifier.INSTANCE.then(new SuspendPointerInputElement(rVar, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null)), 6, null)).then(new DrawStretchOverscrollModifier(this, edgeEffectWrapper, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("overscroll");
                inspectorInfo.setValue(this.this$0);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    private final void animateToRelease() {
        boolean zIsFinished;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = edgeEffect.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished = edgeEffect2.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished = edgeEffect3.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished = edgeEffect4.isFinished() || zIsFinished;
        }
        if (zIsFinished) {
            invalidateOverscroll$foundation_release();
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    /* renamed from: pullBottom-k-4lQ0M, reason: not valid java name */
    private final float m215pullBottomk4lQ0M(long scroll) {
        float fM3895getXimpl = Offset.m3895getXimpl(m222displacementF1C5BW0$foundation_release());
        float fM3896getYimpl = Offset.m3896getYimpl(scroll) / Size.m3961getHeightimpl(this.containerSize);
        EdgeEffect orCreateBottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateBottomEffect) == 0.0f ? Size.m3961getHeightimpl(this.containerSize) * (-edgeEffectCompat.onPullDistanceCompat(orCreateBottomEffect, -fM3896getYimpl, 1 - fM3895getXimpl)) : Offset.m3896getYimpl(scroll);
    }

    /* renamed from: pullLeft-k-4lQ0M, reason: not valid java name */
    private final float m216pullLeftk4lQ0M(long scroll) {
        float fM3896getYimpl = Offset.m3896getYimpl(m222displacementF1C5BW0$foundation_release());
        float fM3895getXimpl = Offset.m3895getXimpl(scroll) / Size.m3964getWidthimpl(this.containerSize);
        EdgeEffect orCreateLeftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateLeftEffect) == 0.0f ? Size.m3964getWidthimpl(this.containerSize) * edgeEffectCompat.onPullDistanceCompat(orCreateLeftEffect, fM3895getXimpl, 1 - fM3896getYimpl) : Offset.m3895getXimpl(scroll);
    }

    /* renamed from: pullRight-k-4lQ0M, reason: not valid java name */
    private final float m217pullRightk4lQ0M(long scroll) {
        float fM3896getYimpl = Offset.m3896getYimpl(m222displacementF1C5BW0$foundation_release());
        float fM3895getXimpl = Offset.m3895getXimpl(scroll) / Size.m3964getWidthimpl(this.containerSize);
        EdgeEffect orCreateRightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateRightEffect) == 0.0f ? Size.m3964getWidthimpl(this.containerSize) * (-edgeEffectCompat.onPullDistanceCompat(orCreateRightEffect, -fM3895getXimpl, fM3896getYimpl)) : Offset.m3895getXimpl(scroll);
    }

    /* renamed from: pullTop-k-4lQ0M, reason: not valid java name */
    private final float m218pullTopk4lQ0M(long scroll) {
        float fM3895getXimpl = Offset.m3895getXimpl(m222displacementF1C5BW0$foundation_release());
        float fM3896getYimpl = Offset.m3896getYimpl(scroll) / Size.m3961getHeightimpl(this.containerSize);
        EdgeEffect orCreateTopEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateTopEffect) == 0.0f ? Size.m3961getHeightimpl(this.containerSize) * edgeEffectCompat.onPullDistanceCompat(orCreateTopEffect, fM3896getYimpl, fM3895getXimpl) : Offset.m3896getYimpl(scroll);
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m219releaseOppositeOverscrollk4lQ0M(long delta) {
        boolean z10;
        if (!this.edgeEffectWrapper.isLeftAnimating() || Offset.m3895getXimpl(delta) >= 0.0f) {
            z10 = false;
        } else {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Offset.m3895getXimpl(delta));
            z10 = !this.edgeEffectWrapper.isLeftAnimating();
        }
        if (this.edgeEffectWrapper.isRightAnimating() && Offset.m3895getXimpl(delta) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Offset.m3895getXimpl(delta));
            z10 = z10 || !this.edgeEffectWrapper.isRightAnimating();
        }
        if (this.edgeEffectWrapper.isTopAnimating() && Offset.m3896getYimpl(delta) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Offset.m3896getYimpl(delta));
            z10 = z10 || !this.edgeEffectWrapper.isTopAnimating();
        }
        if (!this.edgeEffectWrapper.isBottomAnimating() || Offset.m3896getYimpl(delta) <= 0.0f) {
            return z10;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Offset.m3896getYimpl(delta));
        return z10 || !this.edgeEffectWrapper.isBottomAnimating();
    }

    private final boolean stopOverscrollAnimation() {
        boolean z10;
        if (this.edgeEffectWrapper.isLeftStretched()) {
            m216pullLeftk4lQ0M(Offset.INSTANCE.m3911getZeroF1C5BW0());
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.edgeEffectWrapper.isRightStretched()) {
            m217pullRightk4lQ0M(Offset.INSTANCE.m3911getZeroF1C5BW0());
            z10 = true;
        }
        if (this.edgeEffectWrapper.isTopStretched()) {
            m218pullTopk4lQ0M(Offset.INSTANCE.m3911getZeroF1C5BW0());
            z10 = true;
        }
        if (!this.edgeEffectWrapper.isBottomStretched()) {
            return z10;
        }
        m215pullBottomk4lQ0M(Offset.INSTANCE.m3911getZeroF1C5BW0());
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo220applyToFlingBMRW4eQ(long r14, S7.n r16, H7.c<? super C7.r> r17) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo220applyToFlingBMRW4eQ(long, S7.n, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011b A[ADDED_TO_REGION] */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long mo221applyToScrollRhakbz0(long r11, int r13, S7.k r14) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo221applyToScrollRhakbz0(long, int, S7.k):long");
    }

    /* renamed from: displacement-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m222displacementF1C5BW0$foundation_release() {
        Offset offset = this.pointerPosition;
        long jM3905unboximpl = offset != null ? offset.m3905unboximpl() : SizeKt.m3974getCenteruvyYCjk(this.containerSize);
        return OffsetKt.Offset(Offset.m3895getXimpl(jM3905unboximpl) / Size.m3964getWidthimpl(this.containerSize), Offset.m3896getYimpl(jM3905unboximpl) / Size.m3961getHeightimpl(this.containerSize));
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    /* renamed from: getInvalidationEnabled$foundation_release, reason: from getter */
    public final boolean getInvalidationEnabled() {
        return this.invalidationEnabled;
    }

    public final MutableState<r> getRedrawSignal$foundation_release() {
        return this.redrawSignal;
    }

    public final void invalidateOverscroll$foundation_release() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(r.f317a);
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect2) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect3) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        return (edgeEffect4 == null || EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect4) == 0.0f) ? false : true;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z10) {
        this.invalidationEnabled = z10;
    }

    /* renamed from: updateSize-uvyYCjk$foundation_release, reason: not valid java name */
    public final void m223updateSizeuvyYCjk$foundation_release(long size) {
        boolean zM3960equalsimpl0 = Size.m3960equalsimpl0(this.containerSize, Size.INSTANCE.m3973getZeroNHjbRc());
        boolean zM3960equalsimpl02 = Size.m3960equalsimpl0(size, this.containerSize);
        this.containerSize = size;
        if (!zM3960equalsimpl02) {
            this.edgeEffectWrapper.m296setSizeozmzZPI(IntSizeKt.IntSize(U7.a.U(Size.m3964getWidthimpl(size)), U7.a.U(Size.m3961getHeightimpl(size))));
        }
        if (zM3960equalsimpl0 || zM3960equalsimpl02) {
            return;
        }
        invalidateOverscroll$foundation_release();
        animateToRelease();
    }
}
