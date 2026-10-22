package androidx.compose.runtime.snapshots.tooling;

import androidx.compose.runtime.ExperimentalComposeRuntimeApi;
import androidx.compose.runtime.snapshots.Snapshot;
import com.mdisdk.capability.model.RequestInfo;
import java.util.Set;
import kotlin.Metadata;

@ExperimentalComposeRuntimeApi
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/snapshots/tooling/SnapshotObserver;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "parent", "", "readonly", "Landroidx/compose/runtime/snapshots/tooling/SnapshotInstanceObservers;", "onPreCreate", "(Landroidx/compose/runtime/snapshots/Snapshot;Z)Landroidx/compose/runtime/snapshots/tooling/SnapshotInstanceObservers;", RequestInfo.FUNCTION_SNAPSHOT, "observers", "LC7/r;", "onCreated", "(Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/tooling/SnapshotInstanceObservers;)V", "onPreDispose", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "", "changed", "onApplied", "(Landroidx/compose/runtime/snapshots/Snapshot;Ljava/util/Set;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface SnapshotObserver {
    default void onApplied(Snapshot snapshot, Set<? extends Object> changed) {
    }

    default void onCreated(Snapshot snapshot, Snapshot parent, SnapshotInstanceObservers observers) {
    }

    default SnapshotInstanceObservers onPreCreate(Snapshot parent, boolean readonly) {
        return null;
    }

    default void onPreDispose(Snapshot snapshot) {
    }
}
