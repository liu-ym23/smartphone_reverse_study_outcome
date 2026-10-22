package androidx.compose.ui.layout;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.spatial.RelativeLayoutBounds;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.a;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0015J\r\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0015J\r\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u0015J\u000f\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u000f\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u0015R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R.\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010,\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010@\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010F\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010A\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER$\u0010I\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR.\u0010O\u001a\u0004\u0018\u00010\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010J\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR#\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\t8\u0006¢\u0006\f\n\u0004\bR\u0010'\u001a\u0004\bS\u0010)¨\u0006T"}, d2 = {"Landroidx/compose/ui/layout/OnVisibilityChangedNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "", "minDurationMs", "", "minFractionVisible", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "viewportBounds", "Lkotlin/Function1;", "", "LC7/r;", "callback", AppAgent.CONSTRUCT, "(JFLandroidx/compose/ui/layout/LayoutBoundsHolder;LS7/k;)V", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "bounds", "viewport", "checkVisibility", "(FLandroidx/compose/ui/spatial/RelativeLayoutBounds;Landroidx/compose/ui/spatial/RelativeLayoutBounds;)V", "startTimer", "()V", "triggerCallback", "forceUpdate", "onReset", "updateViewport", "onAttach", "onDetach", "onObservedReadsChanged", "J", "getMinDurationMs", "()J", "setMinDurationMs", "(J)V", "F", "getMinFractionVisible", "()F", "setMinFractionVisible", "(F)V", "LS7/k;", "getCallback", "()LS7/k;", "setCallback", "(LS7/k;)V", "value", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "getViewportBounds", "()Landroidx/compose/ui/layout/LayoutBoundsHolder;", "setViewportBounds", "(Landroidx/compose/ui/layout/LayoutBoundsHolder;)V", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "handle", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "getHandle", "()Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "setHandle", "(Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;)V", "Lm9/c0;", "job", "Lm9/c0;", "getJob", "()Lm9/c0;", "setJob", "(Lm9/c0;)V", "lastResult", "Z", "getLastResult", "()Z", "setLastResult", "(Z)V", "firedOnce", "getFiredOnce", "setFiredOnce", "lastBounds", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "getLastBounds", "()Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "setLastBounds", "(Landroidx/compose/ui/spatial/RelativeLayoutBounds;)V", "lastViewport", "getLastViewport", "setLastViewport", "rectChanged", "getRectChanged", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OnVisibilityChangedNode extends Modifier.Node implements ObserverModifierNode {
    public static final int $stable = 8;
    private k callback;
    private boolean firedOnce;
    private DelegatableNode.RegistrationHandle handle;
    private c0 job;
    private RelativeLayoutBounds lastBounds;
    private boolean lastResult;
    private RelativeLayoutBounds lastViewport;
    private long minDurationMs;
    private float minFractionVisible;
    private final k rectChanged = new k() { // from class: androidx.compose.ui.layout.OnVisibilityChangedNode$rectChanged$1
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((RelativeLayoutBounds) obj);
            return r.f317a;
        }

        public final void invoke(RelativeLayoutBounds relativeLayoutBounds) {
            OnVisibilityChangedNode onVisibilityChangedNode = this.this$0;
            onVisibilityChangedNode.checkVisibility(onVisibilityChangedNode.getMinFractionVisible(), relativeLayoutBounds, this.this$0.getLastViewport());
        }
    };
    private LayoutBoundsHolder viewportBounds;

    @c(c = "androidx.compose.ui.layout.OnVisibilityChangedNode$startTimer$1", f = "OnVisibilityChangedModifier.kt", l = {183}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.compose.ui.layout.OnVisibilityChangedNode$startTimer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ long $minDurationMs;
        int label;
        final /* synthetic */ OnVisibilityChangedNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j5, OnVisibilityChangedNode onVisibilityChangedNode, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$minDurationMs = j5;
            this.this$0 = onVisibilityChangedNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$minDurationMs, this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                long j5 = this.$minDurationMs;
                this.label = 1;
                if (a.f(j5, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            this.this$0.triggerCallback();
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public OnVisibilityChangedNode(long j5, float f, LayoutBoundsHolder layoutBoundsHolder, k kVar) {
        this.minDurationMs = j5;
        this.minFractionVisible = f;
        this.callback = kVar;
        this.viewportBounds = layoutBoundsHolder;
    }

    public final void checkVisibility(float minFractionVisible, RelativeLayoutBounds bounds, RelativeLayoutBounds viewport) {
        this.lastBounds = bounds;
        if (viewport != null || this.viewportBounds == null) {
            float fFractionVisibleIn = viewport != null ? bounds.fractionVisibleIn(viewport) : bounds.fractionVisibleInWindow();
            boolean z10 = fFractionVisibleIn > minFractionVisible || fFractionVisibleIn == 1.0f;
            if (this.firedOnce && z10 == this.lastResult) {
                return;
            }
            this.lastResult = z10;
            this.firedOnce = true;
            startTimer();
        }
    }

    public final void forceUpdate() {
        RelativeLayoutBounds relativeLayoutBounds = this.lastBounds;
        if (relativeLayoutBounds != null) {
            checkVisibility(this.minFractionVisible, relativeLayoutBounds, this.lastViewport);
        }
    }

    public final k getCallback() {
        return this.callback;
    }

    public final boolean getFiredOnce() {
        return this.firedOnce;
    }

    public final DelegatableNode.RegistrationHandle getHandle() {
        return this.handle;
    }

    public final c0 getJob() {
        return this.job;
    }

    public final RelativeLayoutBounds getLastBounds() {
        return this.lastBounds;
    }

    public final boolean getLastResult() {
        return this.lastResult;
    }

    public final RelativeLayoutBounds getLastViewport() {
        return this.lastViewport;
    }

    public final long getMinDurationMs() {
        return this.minDurationMs;
    }

    public final float getMinFractionVisible() {
        return this.minFractionVisible;
    }

    public final k getRectChanged() {
        return this.rectChanged;
    }

    public final LayoutBoundsHolder getViewportBounds() {
        return this.viewportBounds;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        DelegatableNode.RegistrationHandle registrationHandle = this.handle;
        if (registrationHandle != null) {
            registrationHandle.unregister();
        }
        this.handle = OnLayoutRectChangedModifierKt.registerOnLayoutRectChanged(this, 0L, 0L, this.rectChanged);
        updateViewport();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        DelegatableNode.RegistrationHandle registrationHandle = this.handle;
        if (registrationHandle != null) {
            registrationHandle.unregister();
        }
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        updateViewport();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        c0 c0Var = this.job;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.job = null;
        this.lastResult = false;
        this.lastBounds = null;
        setLastViewport(null);
        this.firedOnce = false;
    }

    public final void setCallback(k kVar) {
        this.callback = kVar;
    }

    public final void setFiredOnce(boolean z10) {
        this.firedOnce = z10;
    }

    public final void setHandle(DelegatableNode.RegistrationHandle registrationHandle) {
        this.handle = registrationHandle;
    }

    public final void setJob(c0 c0Var) {
        this.job = c0Var;
    }

    public final void setLastBounds(RelativeLayoutBounds relativeLayoutBounds) {
        this.lastBounds = relativeLayoutBounds;
    }

    public final void setLastResult(boolean z10) {
        this.lastResult = z10;
    }

    public final void setLastViewport(RelativeLayoutBounds relativeLayoutBounds) {
        if (kotlin.jvm.internal.k.b(this.lastViewport, relativeLayoutBounds)) {
            return;
        }
        this.lastViewport = relativeLayoutBounds;
        forceUpdate();
    }

    public final void setMinDurationMs(long j5) {
        this.minDurationMs = j5;
    }

    public final void setMinFractionVisible(float f) {
        this.minFractionVisible = f;
    }

    public final void setViewportBounds(LayoutBoundsHolder layoutBoundsHolder) {
        this.viewportBounds = layoutBoundsHolder;
        updateViewport();
    }

    public final void startTimer() {
        long j5 = this.minDurationMs;
        if (j5 == 0) {
            triggerCallback();
            return;
        }
        c0 c0Var = this.job;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.job = AbstractC1683A.n(getCoroutineScope(), null, new AnonymousClass1(j5, this, null), 3);
    }

    public final void triggerCallback() {
        c0 c0Var = this.job;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.callback.invoke(Boolean.valueOf(this.lastResult));
    }

    public final void updateViewport() {
        if (this.viewportBounds == null) {
            setLastViewport(null);
        } else {
            ObserverModifierNodeKt.observeReads(this, new S7.a() { // from class: androidx.compose.ui.layout.OnVisibilityChangedNode.updateViewport.1
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m5607invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m5607invoke() {
                    OnVisibilityChangedNode onVisibilityChangedNode = OnVisibilityChangedNode.this;
                    LayoutBoundsHolder viewportBounds = onVisibilityChangedNode.getViewportBounds();
                    onVisibilityChangedNode.setLastViewport(viewportBounds != null ? viewportBounds.getBounds() : null);
                }
            });
        }
    }
}
