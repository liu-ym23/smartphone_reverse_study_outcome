package android.view.compose;

import S7.k;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\n\u001a\u00020\t2\u0014\b\u0004\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", AppAgent.CONSTRUCT, "(Landroidx/lifecycle/Lifecycle;)V", "Lkotlin/Function1;", "LC7/r;", "onStopOrDisposeEffect", "Landroidx/lifecycle/compose/LifecycleStopOrDisposeEffectResult;", "onStopOrDispose", "(LS7/k;)Landroidx/lifecycle/compose/LifecycleStopOrDisposeEffectResult;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycle-runtime-compose_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LifecycleStartStopEffectScope implements LifecycleOwner {
    public static final int $stable = 8;
    private final Lifecycle lifecycle;

    public LifecycleStartStopEffectScope(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @Override // android.view.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public final LifecycleStopOrDisposeEffectResult onStopOrDispose(final k onStopOrDisposeEffect) {
        return new LifecycleStopOrDisposeEffectResult() { // from class: androidx.lifecycle.compose.LifecycleStartStopEffectScope.onStopOrDispose.1
            @Override // android.view.compose.LifecycleStopOrDisposeEffectResult
            public void runStopOrDisposeEffect() {
                onStopOrDisposeEffect.invoke(this);
            }
        };
    }
}
