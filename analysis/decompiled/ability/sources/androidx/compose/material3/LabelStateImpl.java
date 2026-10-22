package androidx.compose.material3;

import C7.r;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.MutatePriority;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0003\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0004\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/LabelStateImpl;", "Landroidx/compose/material3/TooltipState;", "", "isVisible", "isPersistent", AppAgent.CONSTRUCT, "(ZZ)V", "Landroidx/compose/foundation/MutatePriority;", "mutatePriority", "LC7/r;", "show", "(Landroidx/compose/foundation/MutatePriority;LH7/c;)Ljava/lang/Object;", "dismiss", "()V", "onDispose", "Z", "()Z", "Landroidx/compose/animation/core/MutableTransitionState;", "transition", "Landroidx/compose/animation/core/MutableTransitionState;", "getTransition", "()Landroidx/compose/animation/core/MutableTransitionState;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class LabelStateImpl implements TooltipState {
    private final boolean isPersistent;
    private final boolean isVisible;
    private final MutableTransitionState<Boolean> transition;

    /* JADX WARN: Illegal instructions before constructor call */
    public LabelStateImpl() {
        boolean z10 = false;
        this(z10, z10, 3, null);
    }

    @Override // androidx.compose.material3.TooltipState
    public void dismiss() {
    }

    @Override // androidx.compose.material3.TooltipState
    public MutableTransitionState<Boolean> getTransition() {
        return this.transition;
    }

    @Override // androidx.compose.material3.TooltipState
    /* renamed from: isPersistent, reason: from getter */
    public boolean getIsPersistent() {
        return this.isPersistent;
    }

    @Override // androidx.compose.material3.TooltipState
    /* renamed from: isVisible, reason: from getter */
    public boolean getIsVisible() {
        return this.isVisible;
    }

    @Override // androidx.compose.material3.TooltipState
    public void onDispose() {
    }

    @Override // androidx.compose.material3.TooltipState
    public Object show(MutatePriority mutatePriority, H7.c<? super r> cVar) {
        return r.f317a;
    }

    public LabelStateImpl(boolean z10, boolean z11) {
        this.isVisible = z10;
        this.isPersistent = z11;
        this.transition = new MutableTransitionState<>(Boolean.FALSE);
    }

    public /* synthetic */ LabelStateImpl(boolean z10, boolean z11, int i, e eVar) {
        this((i & 1) != 0 ? true : z10, (i & 2) != 0 ? true : z11);
    }
}
