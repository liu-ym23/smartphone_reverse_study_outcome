package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u0004\u0018\u00010\u0016H\u0082@¢\u0006\u0002\u0010$J\u001f\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J'\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u00101\u001a\u00020\u001cH\u0002¢\u0006\u0004\b2\u00103J\u0018\u00104\u001a\u0002052\u0006\u0010'\u001a\u000205H\u0096@¢\u0006\u0004\b6\u00107J \u00108\u001a\u0002052\u0006\u0010-\u001a\u0002052\u0006\u0010'\u001a\u000205H\u0096@¢\u0006\u0004\b9\u0010:J(\u0010;\u001a\u0002052\u0006\u0010'\u001a\u0002052\u0006\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u0018H\u0082@¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020\u001cH\u0002J\u0018\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020\u00162\u0006\u0010D\u001a\u00020EH\u0016J\u0006\u0010F\u001a\u00020 J\u0010\u0010G\u001a\u00020 2\u0006\u0010C\u001a\u00020\u0016H\u0016J\u0012\u0010H\u001a\u00020 2\b\u0010C\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010I\u001a\u00020 H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroid/view/WindowInsetsAnimationControlListener;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "view", "Landroid/view/View;", "sideCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;Landroid/view/View;Landroidx/compose/foundation/layout/SideCalculator;Landroidx/compose/ui/unit/Density;)V", "getWindowInsets", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "getView", "()Landroid/view/View;", "getSideCalculator", "()Landroidx/compose/foundation/layout/SideCalculator;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "animationController", "Landroid/view/WindowInsetsAnimationController;", "isControllerRequested", "", "cancellationSignal", "Landroid/os/CancellationSignal;", "partialConsumption", "", "animationJob", "Lkotlinx/coroutines/Job;", "requestAnimationController", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "getAnimationController", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, "scrollAmount", "scroll-8S9VItk", "(JF)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fling", "flingAmount", "towardShown", "fling-huYlsQE", "(JFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adjustInsets", "inset", "onReady", "controller", "types", "", "dispose", "onFinished", "onCancelled", "animationEnded", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {
    private WindowInsetsAnimationController animationController;
    private Job animationJob;
    private final CancellationSignal cancellationSignal;
    private kotlinx.coroutines.i<? super WindowInsetsAnimationController> continuation;
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    private final SideCalculator sideCalculator;
    private final View view;
    private final AndroidWindowInsets windowInsets;

    public static /* synthetic */ Unit a(Throwable r100) {
        return onReady$lambda$3(r100);
    }

    public static /* synthetic */ Unit b(Throwable r100) {
        return dispose$lambda$4(r100);
    }

    public static /* synthetic */ Unit c(Throwable r100) {
        return animationEnded$lambda$5(r100);
    }

    private final void animationEnded() {
        WindowInsetsAnimationController r100 = this.animationController;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.isReady() != true) goto L7;
    L8:
        if (r101 == false) goto L12;
        WindowInsetsAnimationController r102 = this.animationController;
        if (r102 == null) goto L12;
        r102.finish(this.windowInsets.isVisible());
    L12:
        this.animationController = null;
        kotlinx.coroutines.i<? super WindowInsetsAnimationController> r103 = this.continuation;
        if (r103 == null) goto L15;
        r103.h(null, new k2());
    L15:
        this.continuation = null;
        Job r104 = this.animationJob;
        if (r104 == null) goto L18;
        r104.cancel(new WindowInsetsAnimationCancelledException());
    L18:
        this.animationJob = null;
        this.partialConsumption = 0.0f;
        this.isControllerRequested = false;
        return;
    L7:
        r101 = false;
        goto L8
    }

    private final void requestAnimationController() {
        if (this.isControllerRequested == true) goto L8;
        this.isControllerRequested = true;
        WindowInsetsController r100 = this.view.getWindowInsetsController();
        if (r100 == null) goto L9;
        r100.controlWindowInsetsAnimation(this.windowInsets.getType$foundation_layout(), -1, null, this.cancellationSignal, this);
        return;
    L9:
        return;
    }

    public final void dispose() {
        kotlinx.coroutines.i<? super WindowInsetsAnimationController> r100 = this.continuation;
        if (r100 == null) goto L5;
        r100.h(null, new i2());
    L5:
        Job r101 = this.animationJob;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        WindowInsetsAnimationController r102 = this.animationController;
        if (r102 == null) goto L12;
        r102.finish(!Intrinsics.areEqual(r102.getCurrentInsets(), r102.getHiddenStateInsets()));
        return;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    public final View getView() {
        return this.view;
    }

    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    public static final /* synthetic */ Job access$getAnimationJob$p(WindowInsetsNestedScrollConnection r100) {
        return r100.animationJob;
    }

    public static final /* synthetic */ void access$requestAnimationController(WindowInsetsNestedScrollConnection r100) {
        r100.requestAnimationController();
    }

    private final void adjustInsets(float r100) {
        WindowInsetsAnimationController r101 = this.animationController;
        if (r101 == null) goto L6;
        Insets r102 = r101.getCurrentInsets();
        r101.setInsetsAndAlpha(this.sideCalculator.adjustInsets(r102, Math.round(r100)), 1.0f, 0.0f);
        return;
    }

    private static final Unit animationEnded$lambda$5(Throwable r100) {
        return Unit.INSTANCE;
    }

    private static final Unit dispose$lambda$4(Throwable r100) {
        return Unit.INSTANCE;
    }

    private final Object getAnimationController(Continuation<? super WindowInsetsAnimationController> r100) {
        Object r101 = this.animationController;
        if (r101 != null) goto L7;
        kotlinx.coroutines.j r102 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r102.C();
        access$setContinuation$p(this, r102);
        access$requestAnimationController(this);
        r101 = r102.B();
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L7:
        return r101;
    }

    private static final Unit onReady$lambda$3(Throwable r100) {
        return Unit.INSTANCE;
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onCancelled(WindowInsetsAnimationController r100) {
        animationEnded();
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onFinished(WindowInsetsAnimationController r100) {
        animationEnded();
    }

    public static final /* synthetic */ void access$adjustInsets(WindowInsetsNestedScrollConnection r100, float r101) {
        r100.adjustInsets(r101);
    }

    public static final /* synthetic */ Object access$getAnimationController(WindowInsetsNestedScrollConnection r100, Continuation r101) {
        return r100.getAnimationController(r101);
    }

    public static final /* synthetic */ void access$setAnimationController$p(WindowInsetsNestedScrollConnection r100, WindowInsetsAnimationController r101) {
        r100.animationController = r101;
    }

    public static final /* synthetic */ void access$setAnimationJob$p(WindowInsetsNestedScrollConnection r100, Job r101) {
        r100.animationJob = r101;
    }

    public static final /* synthetic */ void access$setContinuation$p(WindowInsetsNestedScrollConnection r100, kotlinx.coroutines.i r101) {
        r100.continuation = r101;
    }

    /* JADX INFO: renamed from: scroll-8S9VItk, reason: not valid java name */
    private final long m807scroll8S9VItk(long r100, float r110) {
        Job r101 = this.animationJob;
        if (r101 == null) goto L5;
        r101.cancel(new WindowInsetsAnimationCancelledException());
        this.animationJob = null;
    L5:
        WindowInsetsAnimationController r102 = this.animationController;
        boolean r103 = true;
        if (r110 != 0.0f) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L33;
        boolean r105 = this.windowInsets.isVisible();
        if (r110 > 0.0f) goto L14;
        r103 = false;
    L14:
        if (r105 != r103) goto L17;
        if (r102 == null) goto L33;
    L17:
        if (r102 != null) goto L20;
        this.partialConsumption = 0.0f;
        requestAnimationController();
        return this.sideCalculator.mo759consumedOffsetsMKHz9U(r100);
    L20:
        int r106 = this.sideCalculator.valueOf(r102.getHiddenStateInsets());
        int r107 = this.sideCalculator.valueOf(r102.getShownStateInsets());
        Insets r108 = r102.getCurrentInsets();
        int r109 = this.sideCalculator.valueOf(r108);
        if (r110 <= 0.0f) goto L23;
        int r111 = r107;
    L24:
        if (r109 != r111) goto L27;
        this.partialConsumption = 0.0f;
        return Offset.Companion.m4598getZeroF1C5BW0();
    L27:
        float r112 = (r109 + r110) + this.partialConsumption;
        int r113 = RangesKt.coerceIn(Math.round(r112), r106, r107);
        this.partialConsumption = r112 - Math.round(r112);
        if (r113 == r109) goto L31;
        r102.setInsetsAndAlpha(this.sideCalculator.adjustInsets(r108, r113), 1.0f, 0.0f);
    L31:
        return this.sideCalculator.mo759consumedOffsetsMKHz9U(r100);
    L23:
        r111 = r106;
    L33:
        return Offset.Companion.m4598getZeroF1C5BW0();
    L8:
        r104 = false;
        goto L9
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo498onPreFlingQWom1Mo(long r110, Continuation<? super Velocity> r111) {
        return m806flinghuYlsQE(r110, this.sideCalculator.hideMotion(Velocity.m7786getXimpl(r110), Velocity.m7787getYimpl(r110)), false, r111);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo499onPreScrollOzD1aCk(long r100, int r101) {
        return m807scroll8S9VItk(r100, this.sideCalculator.hideMotion(Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & r100))));
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onReady(WindowInsetsAnimationController r100, int r101) {
        this.animationController = r100;
        this.isControllerRequested = false;
        kotlinx.coroutines.i<? super WindowInsetsAnimationController> r102 = this.continuation;
        if (r102 == null) goto L5;
        r102.h(r100, new j2());
    L5:
        this.continuation = null;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo496onPostFlingRZ2iAVY(long r100, long r110, Continuation<? super Velocity> r111) {
        return m806flinghuYlsQE(r110, this.sideCalculator.showMotion(Velocity.m7786getXimpl(r110), Velocity.m7787getYimpl(r110)), true, r111);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo497onPostScrollDzOQY0M(long r100, long r101, int r102) {
        return m807scroll8S9VItk(r101, this.sideCalculator.showMotion(Float.intBitsToFloat((int) (r101 >> 32)), Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & r101))));
    }

    public WindowInsetsNestedScrollConnection(AndroidWindowInsets r100, View r101, SideCalculator r102, Density r103) {
        this.windowInsets = r100;
        this.view = r101;
        this.sideCalculator = r102;
        this.density = r103;
        this.cancellationSignal = new CancellationSignal();
    }

    /* JADX INFO: renamed from: fling-huYlsQE, reason: not valid java name */
    private final Object m806flinghuYlsQE(long r210, float r211, boolean r212, Continuation<? super Velocity> r213) {
        if ((r213 instanceof WindowInsetsNestedScrollConnection$fling$1) == false) goto L7;
        WindowInsetsNestedScrollConnection$fling$1 r100 = (WindowInsetsNestedScrollConnection$fling$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        WindowInsetsNestedScrollConnection$fling$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        long r104 = r110.J$0;
        ResultKt.throwOnFailure(r102);
    L69:
        return Velocity.m7777boximpl(this.sideCalculator.mo760consumedVelocityQWom1Mo(r104, 0.0f));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r105 = r110.J$0;
        Ref.FloatRef r106 = (Ref.FloatRef) r110.L$0;
        ResultKt.throwOnFailure(r102);
        WindowInsetsNestedScrollConnection r107 = this;
    L75:
        return Velocity.m7777boximpl(r107.sideCalculator.mo760consumedVelocityQWom1Mo(r105, r106.element));
    L17:
        float r108 = r110.F$0;
        long r112 = r110.J$0;
        ResultKt.throwOnFailure(r102);
        float r109 = r108;
    L37:
        WindowInsetsAnimationController r113 = (WindowInsetsAnimationController) r102;
        if (r113 == null) goto L40;
        int r114 = this.sideCalculator.valueOf(r113.getHiddenStateInsets());
        int r115 = this.sideCalculator.valueOf(r113.getShownStateInsets());
        int r116 = this.sideCalculator.valueOf(r113.getCurrentInsets());
        if (r109 > 0.0f) goto L45;
        if (r116 != r114) goto L45;
    L47:
        if (r116 != r115) goto L49;
        boolean r117 = true;
    L50:
        r113.finish(r117);
        this.animationController = null;
        return Velocity.m7777boximpl(Velocity.Companion.m7797getZero9UxMQ8M());
    L49:
        r117 = false;
    L45:
        if (r109 < 0.0f) goto L52;
        if (r116 == r115) goto L47;
    L52:
        SplineBasedFloatDecayAnimationSpec r118 = new SplineBasedFloatDecayAnimationSpec(this.density);
        float r119 = r116 + r118.flingDistance(r109);
        float r120 = r114;
        if (((r119 - r120) / (r115 - r114)) <= 0.5f) goto L55;
        boolean r121 = true;
    L56:
        if (r121 == false) goto L58;
        int r122 = r115;
    L60:
        if (r119 <= r115) goto L62;
    L70:
        Ref.FloatRef r123 = new Ref.FloatRef();
        WindowInsetsNestedScrollConnection$fling$2 r124 = new WindowInsetsNestedScrollConnection$fling$2(this, r116, r109, r118, r114, r115, r123, r113, r121, null);
        r110.L$0 = r123;
        r110.J$0 = r112;
        r110.label = 2;
        if (CoroutineScopeKt.coroutineScope(r124, r110) != r111) goto L73;
        return r111;
    L73:
        r107 = this;
        r106 = r123;
        r105 = r112;
        goto L75
    L62:
        if (r119 < r120) goto L70;
        WindowInsetsNestedScrollConnection$fling$3 r125 = new WindowInsetsNestedScrollConnection$fling$3(this, r116, r122, r109, r113, r121, null);
        r110.J$0 = r112;
        r110.label = 3;
        if (CoroutineScopeKt.coroutineScope(r125, r110) != r111) goto L67;
        return r111;
    L67:
        r104 = r112;
        goto L69
    L58:
        r122 = r114;
        goto L60
    L55:
        r121 = false;
        goto L56
    L40:
        return Velocity.m7777boximpl(Velocity.Companion.m7797getZero9UxMQ8M());
    L18:
        ResultKt.throwOnFailure(r102);
        Job r126 = this.animationJob;
        if (r126 == null) goto L21;
        r126.cancel(new WindowInsetsAnimationCancelledException());
    L21:
        this.animationJob = null;
        this.partialConsumption = 0.0f;
        if (r211 != 0.0f) goto L24;
        boolean r127 = true;
    L25:
        if (r127 == false) goto L28;
        if (r212 == true) goto L28;
    L32:
        return Velocity.m7777boximpl(Velocity.Companion.m7797getZero9UxMQ8M());
    L28:
        if (this.animationController == null) goto L30;
    L33:
        r110.J$0 = r210;
        r110.F$0 = r211;
        r110.label = 1;
        Object r128 = getAnimationController(r110);
        if (r128 != r111) goto L36;
        return r111;
    L36:
        r109 = r211;
        r112 = r210;
        r102 = r128;
        goto L37
    L30:
        if (this.windowInsets.isVisible() != r212) goto L33;
    L24:
        r127 = false;
    L7:
        r100 = new WindowInsetsNestedScrollConnection$fling$1(this, r213);
        goto L8
    }

    /* JADX INFO: renamed from: access$fling-huYlsQE, reason: not valid java name */
    public static final /* synthetic */ Object m805access$flinghuYlsQE(WindowInsetsNestedScrollConnection r100, long r101, float r102, boolean r103, Continuation r104) {
        return r100.m806flinghuYlsQE(r101, r102, r103, r104);
    }
}
