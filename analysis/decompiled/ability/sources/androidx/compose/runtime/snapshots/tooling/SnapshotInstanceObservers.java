package androidx.compose.runtime.snapshots.tooling;

import S7.k;
import androidx.compose.runtime.ExperimentalComposeRuntimeApi;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@ExperimentalComposeRuntimeApi
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R%\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\t\u0010\nR%\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/snapshots/tooling/SnapshotInstanceObservers;", "", "Lkotlin/Function1;", "LC7/r;", "readObserver", "writeObserver", AppAgent.CONSTRUCT, "(LS7/k;LS7/k;)V", "LS7/k;", "getReadObserver", "()LS7/k;", "getWriteObserver", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotInstanceObservers {
    public static final int $stable = 0;
    private final k readObserver;
    private final k writeObserver;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotInstanceObservers() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final k getReadObserver() {
        return this.readObserver;
    }

    public final k getWriteObserver() {
        return this.writeObserver;
    }

    public SnapshotInstanceObservers(k kVar, k kVar2) {
        this.readObserver = kVar;
        this.writeObserver = kVar2;
    }

    public /* synthetic */ SnapshotInstanceObservers(k kVar, k kVar2, int i, e eVar) {
        this((i & 1) != 0 ? null : kVar, (i & 2) != 0 ? null : kVar2);
    }
}
