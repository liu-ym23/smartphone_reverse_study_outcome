package android.view;

import H7.h;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m9.AbstractC1691I;
import m9.AbstractC1729v;
import u9.d;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/lifecycle/PausingDispatcher;", "Lm9/v;", AppAgent.CONSTRUCT, "()V", "LH7/h;", "context", "", "isDispatchNeeded", "(LH7/h;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "LC7/r;", "dispatch", "(LH7/h;Ljava/lang/Runnable;)V", "Landroidx/lifecycle/DispatchQueue;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PausingDispatcher extends AbstractC1729v {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // m9.AbstractC1729v
    public void dispatch(h context, Runnable block) {
        k.f(context, "context");
        k.f(block, "block");
        this.dispatchQueue.dispatchAndEnqueue(context, block);
    }

    @Override // m9.AbstractC1729v
    public boolean isDispatchNeeded(h context) {
        k.f(context, "context");
        d dVar = AbstractC1691I.f5315a;
        if (s9.k.f6003a.d.isDispatchNeeded(context)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
