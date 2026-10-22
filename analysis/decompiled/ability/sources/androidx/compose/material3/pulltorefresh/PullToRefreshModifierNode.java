package androidx.compose.material3.pulltorefresh;

import C7.r;
import J7.c;
import S7.a;
import S7.n;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B5\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010 \u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\u0011J\u001a\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0018\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0082@¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020%H\u0002¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b-\u0010,R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010.\u001a\u0004\b\u0005\u0010/\"\u0004\b0\u00101R(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010.\u001a\u0004\b7\u0010/\"\u0004\b8\u00101R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\r\u0010>\u001a\u0004\b?\u0010*\"\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR+\u0010J\u001a\u00020%2\u0006\u0010E\u001a\u00020%8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010*\"\u0004\bI\u0010AR+\u0010N\u001a\u00020%2\u0006\u0010E\u001a\u00020%8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010G\u001a\u0004\bL\u0010*\"\u0004\bM\u0010AR\u0014\u0010P\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010*R\u0014\u0010T\u001a\u00020Q8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010*\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006W"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "isRefreshing", "Lkotlin/Function0;", "LC7/r;", "onRefresh", "enabled", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "state", "Landroidx/compose/ui/unit/Dp;", "threshold", AppAgent.CONSTRUCT, "(ZLS7/a;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;FLkotlin/jvm/internal/e;)V", "onAttach", "()V", "Landroidx/compose/ui/geometry/Offset;", "available", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", AgentBusWakeContract.EXTRA_SOURCE, "onPreScroll-OzD1aCk", "(JI)J", "onPreScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPostScroll", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLH7/c;)Ljava/lang/Object;", "onPreFling", "update", "consumeAvailableOffset-MK-Hz9U", "(J)J", "consumeAvailableOffset", "", "velocity", "onRelease", "(FLH7/c;)Ljava/lang/Object;", "calculateVerticalOffset", "()F", "animateToThreshold", "(LH7/c;)Ljava/lang/Object;", "animateToHidden", "Z", "()Z", "setRefreshing", "(Z)V", "LS7/a;", "getOnRefresh", "()LS7/a;", "setOnRefresh", "(LS7/a;)V", "getEnabled", "setEnabled", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "getState", "()Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "setState", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;)V", "F", "getThreshold-D9Ej5fM", "setThreshold-0680j_4", "(F)V", "Landroidx/compose/ui/node/DelegatableNode;", "nestedScrollNode", "Landroidx/compose/ui/node/DelegatableNode;", "<set-?>", "verticalOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getVerticalOffset", "setVerticalOffset", "verticalOffset", "distancePulled$delegate", "getDistancePulled", "setDistancePulled", "distancePulled", "getAdjustedDistancePulled", "adjustedDistancePulled", "", "getThresholdPx", "()I", "thresholdPx", "getProgress", "progress", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PullToRefreshModifierNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, NestedScrollConnection {
    public static final int $stable = 8;

    /* renamed from: distancePulled$delegate, reason: from kotlin metadata */
    private final MutableFloatState distancePulled;
    private boolean enabled;
    private boolean isRefreshing;
    private DelegatableNode nestedScrollNode;
    private a onRefresh;
    private PullToRefreshState state;
    private float threshold;

    /* renamed from: verticalOffset$delegate, reason: from kotlin metadata */
    private final MutableFloatState verticalOffset;

    @c(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode", f = "PullToRefresh.kt", l = {406}, m = "animateToHidden")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PullToRefreshModifierNode.this.animateToHidden(this);
        }
    }

    @c(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode", f = "PullToRefresh.kt", l = {400}, m = "animateToThreshold")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06811 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C06811(H7.c<? super C06811> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PullToRefreshModifierNode.this.animateToThreshold(this);
        }
    }

    @c(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onAttach$1", f = "PullToRefresh.kt", l = {287, 289}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onAttach$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06821 extends SuspendLambda implements n {
        int label;

        public C06821(H7.c<? super C06821> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return PullToRefreshModifierNode.this.new C06821(cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
        
            if (r5.snapTo(1.0f, r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        
            if (r5.snapTo(0.0f, r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L19
                if (r1 == r3) goto L15
                if (r1 != r2) goto Ld
                goto L15
            Ld:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L15:
                kotlin.b.b(r5)
                goto L45
            L19:
                kotlin.b.b(r5)
                androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.this
                boolean r5 = r5.getIsRefreshing()
                if (r5 == 0) goto L35
                androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.this
                androidx.compose.material3.pulltorefresh.PullToRefreshState r5 = r5.getState()
                r4.label = r3
                r1 = 1065353216(0x3f800000, float:1.0)
                java.lang.Object r4 = r5.snapTo(r1, r4)
                if (r4 != r0) goto L45
                goto L44
            L35:
                androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.this
                androidx.compose.material3.pulltorefresh.PullToRefreshState r5 = r5.getState()
                r4.label = r2
                r1 = 0
                java.lang.Object r4 = r5.snapTo(r1, r4)
                if (r4 != r0) goto L45
            L44:
                return r0
            L45:
                C7.r r4 = C7.r.f317a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.C06821.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C06821) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode", f = "PullToRefresh.kt", l = {359, 362}, m = "onRelease")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06831 extends ContinuationImpl {
        float F$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C06831(H7.c<? super C06831> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PullToRefreshModifierNode.this.onRelease(0.0f, this);
        }
    }

    @c(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$update$1", f = "PullToRefresh.kt", l = {333, 335}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$update$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06841 extends SuspendLambda implements n {
        int label;

        public C06841(H7.c<? super C06841> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return PullToRefreshModifierNode.this.new C06841(cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        
            if (r5.animateToHidden(r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
        
            if (r5.animateToThreshold(r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L19
                if (r1 == r3) goto L15
                if (r1 != r2) goto Ld
                goto L15
            Ld:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L15:
                kotlin.b.b(r5)
                goto L3a
            L19:
                kotlin.b.b(r5)
                androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.this
                boolean r5 = r5.getIsRefreshing()
                if (r5 != 0) goto L2f
                androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.this
                r4.label = r3
                java.lang.Object r4 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.access$animateToHidden(r5, r4)
                if (r4 != r0) goto L3a
                goto L39
            L2f:
                androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.this
                r4.label = r2
                java.lang.Object r4 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.access$animateToThreshold(r5, r4)
                if (r4 != r0) goto L3a
            L39:
                return r0
            L3a:
                C7.r r4 = C7.r.f317a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.C06841.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C06841) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public /* synthetic */ PullToRefreshModifierNode(boolean z10, a aVar, boolean z11, PullToRefreshState pullToRefreshState, float f, e eVar) {
        this(z10, aVar, z11, pullToRefreshState, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateToHidden(H7.c<? super C7.r> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r4 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode) r4
            kotlin.b.b(r5)
            goto L43
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r5)
            androidx.compose.material3.pulltorefresh.PullToRefreshState r5 = r4.state
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.animateToHidden(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            r5 = 0
            r4.setDistancePulled(r5)
            r4.setVerticalOffset(r5)
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.animateToHidden(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateToThreshold(H7.c<? super C7.r> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.C06811
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.C06811) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r4 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode) r4
            kotlin.b.b(r5)
            goto L43
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r5)
            androidx.compose.material3.pulltorefresh.PullToRefreshState r5 = r4.state
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.animateToThreshold(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            int r5 = r4.getThresholdPx()
            float r5 = (float) r5
            r4.setDistancePulled(r5)
            int r5 = r4.getThresholdPx()
            float r5 = (float) r5
            r4.setVerticalOffset(r5)
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.animateToThreshold(H7.c):java.lang.Object");
    }

    private final float calculateVerticalOffset() {
        if (getAdjustedDistancePulled() <= getThresholdPx()) {
            return getAdjustedDistancePulled();
        }
        float fT = AbstractC1451a.t(Math.abs(getProgress()) - 1.0f, 0.0f, 2.0f);
        return getThresholdPx() + (getThresholdPx() * (fT - (((float) Math.pow(fT, 2)) / 4)));
    }

    /* renamed from: consumeAvailableOffset-MK-Hz9U, reason: not valid java name */
    private final long m2778consumeAvailableOffsetMKHz9U(long available) {
        float distancePulled;
        if (this.isRefreshing) {
            distancePulled = 0.0f;
        } else {
            float fM3896getYimpl = Offset.m3896getYimpl(available) + getDistancePulled();
            if (fM3896getYimpl < 0.0f) {
                fM3896getYimpl = 0.0f;
            }
            distancePulled = fM3896getYimpl - getDistancePulled();
            setDistancePulled(fM3896getYimpl);
            setVerticalOffset(calculateVerticalOffset());
        }
        return OffsetKt.Offset(0.0f, distancePulled);
    }

    private final float getAdjustedDistancePulled() {
        return getDistancePulled() * 0.5f;
    }

    private final float getDistancePulled() {
        return this.distancePulled.getFloatValue();
    }

    private final float getProgress() {
        return getAdjustedDistancePulled() / getThresholdPx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getThresholdPx() {
        return ((Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalDensity())).mo375roundToPx0680j_4(this.threshold);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getVerticalOffset() {
        return this.verticalOffset.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        if (animateToThreshold(r0) == r1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        if (animateToHidden(r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onRelease(float r7, H7.c<? super java.lang.Float> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.C06831
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.C06831) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L43
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            float r7 = r0.F$0
            java.lang.Object r6 = r0.L$0
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r6 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode) r6
            kotlin.b.b(r8)
            goto L7d
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            float r7 = r0.F$0
            java.lang.Object r6 = r0.L$0
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r6 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode) r6
            kotlin.b.b(r8)
            goto L6a
        L43:
            kotlin.b.b(r8)
            boolean r8 = r6.isRefreshing
            if (r8 == 0) goto L50
            java.lang.Float r6 = new java.lang.Float
            r6.<init>(r5)
            return r6
        L50:
            float r8 = r6.getAdjustedDistancePulled()
            int r2 = r6.getThresholdPx()
            float r2 = (float) r2
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L70
            r0.L$0 = r6
            r0.F$0 = r7
            r0.label = r4
            java.lang.Object r8 = r6.animateToThreshold(r0)
            if (r8 != r1) goto L6a
            goto L7c
        L6a:
            S7.a r8 = r6.onRefresh
            r8.invoke()
            goto L7d
        L70:
            r0.L$0 = r6
            r0.F$0 = r7
            r0.label = r3
            java.lang.Object r8 = r6.animateToHidden(r0)
            if (r8 != r1) goto L7d
        L7c:
            return r1
        L7d:
            float r8 = r6.getDistancePulled()
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 != 0) goto L87
        L85:
            r7 = r5
            goto L8c
        L87:
            int r8 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r8 >= 0) goto L8c
            goto L85
        L8c:
            r6.setDistancePulled(r5)
            java.lang.Float r6 = new java.lang.Float
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.onRelease(float, H7.c):java.lang.Object");
    }

    private final void setDistancePulled(float f) {
        this.distancePulled.setFloatValue(f);
    }

    private final void setVerticalOffset(float f) {
        this.verticalOffset.setFloatValue(f);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final a getOnRefresh() {
        return this.onRefresh;
    }

    public final PullToRefreshState getState() {
        return this.state;
    }

    /* renamed from: getThreshold-D9Ej5fM, reason: not valid java name and from getter */
    public final float getThreshold() {
        return this.threshold;
    }

    /* renamed from: isRefreshing, reason: from getter */
    public final boolean getIsRefreshing() {
        return this.isRefreshing;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        delegate(this.nestedScrollNode);
        AbstractC1683A.n(getCoroutineScope(), null, new C06821(null), 3);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo501onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!this.state.isAnimating() && this.enabled && NestedScrollSource.m5300equalsimpl0(source, NestedScrollSource.INSTANCE.m5312getUserInputWNlRxjI())) {
            long jM2778consumeAvailableOffsetMKHz9U = m2778consumeAvailableOffsetMKHz9U(available);
            AbstractC1683A.n(getCoroutineScope(), null, new PullToRefreshModifierNode$onPostScroll$1(this, null), 3);
            return jM2778consumeAvailableOffsetMKHz9U;
        }
        return Offset.INSTANCE.m3911getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo775onPreFlingQWom1Mo(long r5, H7.c<? super androidx.compose.ui.unit.Velocity> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            float r4 = r0.F$0
            kotlin.b.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.b.b(r7)
            float r5 = androidx.compose.ui.unit.Velocity.m7083getYimpl(r5)
            r6 = 0
            r0.F$0 = r6
            r0.label = r3
            java.lang.Object r7 = r4.onRelease(r5, r0)
            if (r7 != r1) goto L44
            return r1
        L44:
            r4 = r6
        L45:
            java.lang.Number r7 = (java.lang.Number) r7
            float r5 = r7.floatValue()
            long r4 = androidx.compose.ui.unit.VelocityKt.Velocity(r4, r5)
            androidx.compose.ui.unit.Velocity r4 = androidx.compose.ui.unit.Velocity.m7073boximpl(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.mo775onPreFlingQWom1Mo(long, H7.c):java.lang.Object");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo776onPreScrollOzD1aCk(long available, int source) {
        if (!this.state.isAnimating() && this.enabled) {
            return (!NestedScrollSource.m5300equalsimpl0(source, NestedScrollSource.INSTANCE.m5312getUserInputWNlRxjI()) || Offset.m3896getYimpl(available) >= 0.0f) ? Offset.INSTANCE.m3911getZeroF1C5BW0() : m2778consumeAvailableOffsetMKHz9U(available);
        }
        return Offset.INSTANCE.m3911getZeroF1C5BW0();
    }

    public final void setEnabled(boolean z10) {
        this.enabled = z10;
    }

    public final void setOnRefresh(a aVar) {
        this.onRefresh = aVar;
    }

    public final void setRefreshing(boolean z10) {
        this.isRefreshing = z10;
    }

    public final void setState(PullToRefreshState pullToRefreshState) {
        this.state = pullToRefreshState;
    }

    /* renamed from: setThreshold-0680j_4, reason: not valid java name */
    public final void m2780setThreshold0680j_4(float f) {
        this.threshold = f;
    }

    public final void update() {
        AbstractC1683A.n(getCoroutineScope(), null, new C06841(null), 3);
    }

    private PullToRefreshModifierNode(boolean z10, a aVar, boolean z11, PullToRefreshState pullToRefreshState, float f) {
        this.isRefreshing = z10;
        this.onRefresh = aVar;
        this.enabled = z11;
        this.state = pullToRefreshState;
        this.threshold = f;
        this.nestedScrollNode = NestedScrollNodeKt.nestedScrollModifierNode(this, null);
        this.verticalOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.distancePulled = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    }
}
