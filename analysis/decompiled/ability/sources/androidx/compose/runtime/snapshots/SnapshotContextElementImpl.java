package androidx.compose.runtime.snapshots;

import H7.f;
import H7.g;
import H7.h;
import S7.n;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotContextElement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import kotlin.Metadata;
import m9.s0;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0018\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotContextElementImpl;", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "Lm9/s0;", "Landroidx/compose/runtime/snapshots/Snapshot;", RequestInfo.FUNCTION_SNAPSHOT, AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "LH7/h;", "context", "updateThreadContext", "(LH7/h;)Landroidx/compose/runtime/snapshots/Snapshot;", "oldState", "LC7/r;", "restoreThreadContext", "(LH7/h;Landroidx/compose/runtime/snapshots/Snapshot;)V", "Landroidx/compose/runtime/snapshots/Snapshot;", "LH7/g;", "getKey", "()LH7/g;", "key", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotContextElementImpl implements SnapshotContextElement, s0 {
    public static final int $stable = 8;
    private final Snapshot snapshot;

    public SnapshotContextElementImpl(Snapshot snapshot) {
        this.snapshot = snapshot;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, H7.h
    public <R> R fold(R r5, n nVar) {
        return (R) SnapshotContextElement.DefaultImpls.fold(this, r5, nVar);
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, H7.h
    public <E extends f> E get(g gVar) {
        return (E) SnapshotContextElement.DefaultImpls.get(this, gVar);
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, H7.f
    public g getKey() {
        return SnapshotContextElement.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, H7.h
    public h minusKey(g gVar) {
        return SnapshotContextElement.DefaultImpls.minusKey(this, gVar);
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, H7.h
    public h plus(h hVar) {
        return SnapshotContextElement.DefaultImpls.plus(this, hVar);
    }

    @Override // m9.s0
    public void restoreThreadContext(h context, Snapshot oldState) {
        this.snapshot.unsafeLeave(oldState);
    }

    @Override // m9.s0
    public Snapshot updateThreadContext(h context) {
        return this.snapshot.unsafeEnter();
    }
}
