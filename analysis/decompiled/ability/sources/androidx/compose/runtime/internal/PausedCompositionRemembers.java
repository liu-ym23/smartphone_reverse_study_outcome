package androidx.compose.runtime.internal;

import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.collection.MutableVector;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Set;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/internal/PausedCompositionRemembers;", "Landroidx/compose/runtime/RememberObserver;", "", "abandoning", AppAgent.CONSTRUCT, "(Ljava/util/Set;)V", "LC7/r;", "onRemembered", "()V", "onForgotten", "onAbandoned", "Ljava/util/Set;", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/RememberObserverHolder;", "pausedRemembers", "Landroidx/compose/runtime/collection/MutableVector;", "getPausedRemembers", "()Landroidx/compose/runtime/collection/MutableVector;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PausedCompositionRemembers implements RememberObserver {
    public static final int $stable = 8;
    private final Set<RememberObserver> abandoning;
    private final MutableVector<RememberObserverHolder> pausedRemembers = new MutableVector<>(new RememberObserverHolder[16], 0);

    public PausedCompositionRemembers(Set<RememberObserver> set) {
        this.abandoning = set;
    }

    public final MutableVector<RememberObserverHolder> getPausedRemembers() {
        return this.pausedRemembers;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        MutableVector<RememberObserverHolder> mutableVector = this.pausedRemembers;
        RememberObserverHolder[] rememberObserverHolderArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            RememberObserver wrapped = rememberObserverHolderArr[i].getWrapped();
            this.abandoning.remove(wrapped);
            wrapped.onRemembered();
        }
    }
}
