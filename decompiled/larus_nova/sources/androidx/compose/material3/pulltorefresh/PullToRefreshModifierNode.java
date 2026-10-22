package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u00108\u001a\u00020\u0007H\u0016J\u001f\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J'\u0010@\u001a\u00020:2\u0006\u0010A\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020=H\u0016¢\u0006\u0004\bB\u0010CJ\u0018\u0010D\u001a\u00020E2\u0006\u0010;\u001a\u00020EH\u0096@¢\u0006\u0004\bF\u0010GJ\u0006\u0010H\u001a\u00020\u0007J\u0017\u0010I\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\bJ\u0010KJ\u0016\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020&H\u0082@¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020&H\u0002J\u000e\u0010P\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010QJ\u000e\u0010R\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010QR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u000fR\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001fR+\u0010,\u001a\u00020&2\u0006\u0010%\u001a\u00020&8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010+\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u0014\u00100\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001dR\u0014\u00102\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u001d¨\u0006S"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "isRefreshing", "", com.alipay.sdk.m.x.d.f25926p, "Lkotlin/Function0;", "", "enabled", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "threshold", "Landroidx/compose/ui/unit/Dp;", "<init>", "(ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "setRefreshing", "(Z)V", "getOnRefresh", "()Lkotlin/jvm/functions/Function0;", "setOnRefresh", "(Lkotlin/jvm/functions/Function0;)V", "getEnabled", "setEnabled", "getState", "()Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "setState", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;)V", "getThreshold-D9Ej5fM", "()F", "setThreshold-0680j_4", "(F)V", FaceService.girlLabel, "shouldAutoInvalidate", "getShouldAutoInvalidate", "nestedScrollNode", "Landroidx/compose/ui/node/DelegatableNode;", "<set-?>", "", "verticalOffset", "getVerticalOffset", "setVerticalOffset", "verticalOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "distancePulled", "getDistancePulled", "setDistancePulled", "distancePulled$delegate", "adjustedDistancePulled", "getAdjustedDistancePulled", "thresholdPx", "", "getThresholdPx", "()I", "progress", "getProgress", "onAttach", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "consumeAvailableOffset", "consumeAvailableOffset-MK-Hz9U", "(J)J", "onRelease", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateVerticalOffset", "animateToThreshold", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToHidden", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PullToRefreshModifierNode extends DelegatingNode implements NestedScrollConnection {
    public static final int $stable = 8;
    private final MutableFloatState distancePulled$delegate;
    private boolean enabled;
    private boolean isRefreshing;
    private DelegatableNode nestedScrollNode;
    private Function0<Unit> onRefresh;
    private PullToRefreshState state;
    private float threshold;
    private final MutableFloatState verticalOffset$delegate;

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode", f = "PullToRefresh.kt", i = {}, l = {384}, m = "animateToHidden", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PullToRefreshModifierNode this$0;

        public AnonymousClass1(PullToRefreshModifierNode r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return PullToRefreshModifierNode.access$animateToHidden(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode", f = "PullToRefresh.kt", i = {}, l = {371}, m = "animateToThreshold", n = {}, s = {})
    public static final class C87211 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PullToRefreshModifierNode this$0;

        public C87211(PullToRefreshModifierNode r100, Continuation<? super C87211> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return PullToRefreshModifierNode.access$animateToThreshold(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onAttach$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onAttach$1", f = "PullToRefresh.kt", i = {}, l = {260}, m = "invokeSuspend", n = {}, s = {})
    public static final class C87221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PullToRefreshModifierNode this$0;

        public C87221(PullToRefreshModifierNode r100, Continuation<? super C87221> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C87221(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C87221) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            PullToRefreshState r103 = this.this$0.getState();
            if (this.this$0.isRefreshing() == false) goto L11;
            float r104 = 1.0f;
        L12:
            this.label = 1;
            if (r103.snapTo(r104, this) != r101) goto L16;
            return r101;
        L11:
            r104 = 0.0f;
            goto L12
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode", f = "PullToRefresh.kt", i = {0}, l = {345}, m = "onRelease", n = {"consumed"}, s = {"F$0"})
    public static final class C87231 extends ContinuationImpl {
        float F$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PullToRefreshModifierNode this$0;

        public C87231(PullToRefreshModifierNode r100, Continuation<? super C87231> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return PullToRefreshModifierNode.access$onRelease(this.this$0, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$update$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$update$1", f = "PullToRefresh.kt", i = {}, l = {304, 306}, m = "invokeSuspend", n = {}, s = {})
    public static final class C87241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PullToRefreshModifierNode this$0;

        public C87241(PullToRefreshModifierNode r100, Continuation<? super C87241> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C87241(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C87241) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L19:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r100);
            if (this.this$0.isRefreshing() == true) goto L15;
            PullToRefreshModifierNode r103 = this.this$0;
            this.label = 1;
            if (PullToRefreshModifierNode.access$animateToHidden(r103, this) != r101) goto L19;
            return r101;
        L15:
            PullToRefreshModifierNode r104 = this.this$0;
            this.label = 2;
            if (PullToRefreshModifierNode.access$animateToThreshold(r104, this) != r101) goto L19;
            return r101;
        }
    }

    public /* synthetic */ PullToRefreshModifierNode(boolean r100, Function0 r101, boolean r102, PullToRefreshState r103, float r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public final /* synthetic */ Object mo496onPostFlingRZ2iAVY(long r100, long r101, Continuation r102) {
        return NestedScrollConnection.CC.m5985$default$onPostFlingRZ2iAVY(this, r100, r101, r102);
    }

    private final float getDistancePulled() {
        return this.distancePulled$delegate.getFloatValue();
    }

    private final float getVerticalOffset() {
        return this.verticalOffset$delegate.getFloatValue();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        delegate(this.nestedScrollNode);
        BuildersKt.launch$default(getCoroutineScope(), null, null, new C87221(this, null), 3, null);
        if (this.isRefreshing == false) goto L5;
        float r100 = getThresholdPx();
    L6:
        setVerticalOffset(r100);
        return;
    L5:
        r100 = 0.0f;
        goto L6
    }

    private final float calculateVerticalOffset() {
        if (getAdjustedDistancePulled() <= getThresholdPx()) goto L7;
        float r100 = RangesKt.coerceIn(Math.abs(getProgress()) - 1.0f, 0.0f, 2.0f);
        return getThresholdPx() + (getThresholdPx() * (r100 - (((float) Math.pow(r100, 2)) / 4)));
    L7:
        return getAdjustedDistancePulled();
    }

    private final float getAdjustedDistancePulled() {
        return getDistancePulled() * 0.5f;
    }

    private final float getProgress() {
        return getAdjustedDistancePulled() / getThresholdPx();
    }

    private final int getThresholdPx() {
        return DelegatableNodeKt.requireDensity(this).mo365roundToPx0680j_4(this.threshold);
    }

    public final void update() {
        BuildersKt.launch$default(getCoroutineScope(), null, null, new C87241(this, null), 3, null);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Function0<Unit> getOnRefresh() {
        return this.onRefresh;
    }

    public final PullToRefreshState getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: getThreshold-D9Ej5fM, reason: not valid java name */
    public final float m3249getThresholdD9Ej5fM() {
        return this.threshold;
    }

    public final boolean isRefreshing() {
        return this.isRefreshing;
    }

    public static final /* synthetic */ int access$getThresholdPx(PullToRefreshModifierNode r100) {
        return r100.getThresholdPx();
    }

    public static final /* synthetic */ float access$getVerticalOffset(PullToRefreshModifierNode r100) {
        return r100.getVerticalOffset();
    }

    private final Object animateToHidden(Continuation<? super Unit> r100) {
        if ((r100 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r101 = (AnonymousClass1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L17;
        if (r105 != 1) goto L16;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L13
    L21:
        setDistancePulled(0.0f);
        setVerticalOffset(0.0f);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
        PullToRefreshState r106 = this.state;     // Catch: Throwable -> L13
        r101.label = 1;     // Catch: Throwable -> L13
        if (r106.animateToHidden(r101) != r104) goto L21;
        return r104;
    L13:
        th = move-exception;
        setDistancePulled(0.0f);
        setVerticalOffset(0.0f);
        throw th;
    L7:
        r101 = new AnonymousClass1(this, r100);
        goto L8
    }

    private final Object animateToThreshold(Continuation<? super Unit> r100) {
        if ((r100 instanceof C87211) == false) goto L7;
        C87211 r101 = (C87211) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L17;
        if (r105 != 1) goto L16;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L13
    L21:
        if (isAttached() == false) goto L25;
        setDistancePulled(getThresholdPx());
        setVerticalOffset(getThresholdPx());
    L25:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
        PullToRefreshState r106 = this.state;     // Catch: Throwable -> L13
        r101.label = 1;     // Catch: Throwable -> L13
        if (r106.animateToThreshold(r101) != r104) goto L21;
        return r104;
    L13:
        th = move-exception;
        if (isAttached() == false) goto L29;
        setDistancePulled(getThresholdPx());
        setVerticalOffset(getThresholdPx());
    L29:
        throw th;
    L7:
        r101 = new C87211(this, r100);
        goto L8
    }

    /* JADX INFO: renamed from: consumeAvailableOffset-MK-Hz9U, reason: not valid java name */
    private final long m3248consumeAvailableOffsetMKHz9U(long r100) {
        if (this.isRefreshing == false) goto L5;
        float r101 = 0.0f;
    L6:
        long r102 = Float.floatToRawIntBits(0.0f);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    L5:
        float r103 = RangesKt.coerceAtLeast(getDistancePulled() + Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)), 0.0f);
        r101 = r103 - getDistancePulled();
        setDistancePulled(r103);
        setVerticalOffset(calculateVerticalOffset());
        goto L6
    }

    private final void setDistancePulled(float r100) {
        this.distancePulled$delegate.setFloatValue(r100);
    }

    private final void setVerticalOffset(float r100) {
        this.verticalOffset$delegate.setFloatValue(r100);
    }

    public final void setEnabled(boolean r100) {
        this.enabled = r100;
    }

    public final void setOnRefresh(Function0<Unit> r100) {
        this.onRefresh = r100;
    }

    public final void setRefreshing(boolean r100) {
        this.isRefreshing = r100;
    }

    public final void setState(PullToRefreshState r100) {
        this.state = r100;
    }

    /* JADX INFO: renamed from: setThreshold-0680j_4, reason: not valid java name */
    public final void m3250setThreshold0680j_4(float r100) {
        this.threshold = r100;
    }

    public static final /* synthetic */ Object access$animateToHidden(PullToRefreshModifierNode r100, Continuation r101) {
        return r100.animateToHidden(r101);
    }

    public static final /* synthetic */ Object access$animateToThreshold(PullToRefreshModifierNode r100, Continuation r101) {
        return r100.animateToThreshold(r101);
    }

    private final Object onRelease(float r100, Continuation<? super Float> r101) {
        if ((r101 instanceof C87231) == false) goto L7;
        C87231 r102 = (C87231) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = r102.F$0;
        ResultKt.throwOnFailure(r104);
    L33:
        setDistancePulled(0.0f);
        return Boxing.boxFloat(r100);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (this.isRefreshing == false) goto L19;
        return Boxing.boxFloat(0.0f);
    L19:
        if (getAdjustedDistancePulled() <= getThresholdPx()) goto L22;
        this.onRefresh.invoke();
    L22:
        if (getDistancePulled() != 0.0f) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == false) goto L28;
    L26:
        r100 = 0.0f;
    L30:
        r102.F$0 = r100;
        r102.label = 1;
        if (animateToHidden(r102) != r105) goto L33;
        return r105;
    L28:
        if (r100 >= 0.0f) goto L30;
    L24:
        r107 = false;
    L7:
        r102 = new C87231(this, r101);
        goto L8
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo498onPreFlingQWom1Mo(long r100, Continuation<? super Velocity> r101) {
        if ((r101 instanceof PullToRefreshModifierNode$onPreFling$1) == false) goto L7;
        PullToRefreshModifierNode$onPreFling$1 r102 = (PullToRefreshModifierNode$onPreFling$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        float r107 = r102.F$0;
        ResultKt.throwOnFailure(r104);
    L19:
        return Velocity.m7777boximpl(VelocityKt.Velocity(r107, ((Number) r104).floatValue()));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        float r108 = Velocity.m7787getYimpl(r100);
        r102.F$0 = 0.0f;
        r102.label = 1;
        r104 = onRelease(r108, r102);
        if (r104 != r105) goto L17;
        return r105;
    L17:
        r107 = 0.0f;
    L7:
        r102 = new PullToRefreshModifierNode$onPreFling$1(this, r101);
        goto L8
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo499onPreScrollOzD1aCk(long r100, int r101) {
        if (this.state.isAnimating() == false) goto L6;
        return Offset.Companion.m4598getZeroF1C5BW0();
    L6:
        if (this.enabled == true) goto L9;
        return Offset.Companion.m4598getZeroF1C5BW0();
    L9:
        if (NestedScrollSource.m6006equalsimpl0(r101, NestedScrollSource.Companion.m6018getUserInputWNlRxjI()) == false) goto L14;
        if (Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & r100)) >= 0.0f) goto L14;
        return m3248consumeAvailableOffsetMKHz9U(r100);
    L14:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }

    public static final /* synthetic */ Object access$onRelease(PullToRefreshModifierNode r100, float r101, Continuation r102) {
        return r100.onRelease(r101, r102);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo497onPostScrollDzOQY0M(long r100, long r101, int r110) {
        if (this.state.isAnimating() == false) goto L6;
        return Offset.Companion.m4598getZeroF1C5BW0();
    L6:
        if (this.enabled == true) goto L9;
        return Offset.Companion.m4598getZeroF1C5BW0();
    L9:
        if (NestedScrollSource.m6006equalsimpl0(r110, NestedScrollSource.Companion.m6018getUserInputWNlRxjI()) == false) goto L12;
        long r102 = m3248consumeAvailableOffsetMKHz9U(r101);
        BuildersKt.launch$default(getCoroutineScope(), null, null, new PullToRefreshModifierNode$onPostScroll$1(this, null), 3, null);
        return r102;
    L12:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }

    private PullToRefreshModifierNode(boolean r100, Function0<Unit> r101, boolean r102, PullToRefreshState r103, float r104) {
        this.isRefreshing = r100;
        this.onRefresh = r101;
        this.enabled = r102;
        this.state = r103;
        this.threshold = r104;
        this.nestedScrollNode = NestedScrollNodeKt.nestedScrollModifierNode(this, null);
        this.verticalOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.distancePulled$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    }
}
