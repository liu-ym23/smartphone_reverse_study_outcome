package androidx.compose.runtime;

import Z7.t;
import androidx.compose.runtime.snapshots.StateFactoryMarker;
import kotlin.Metadata;

@Metadata(d1 = {"androidx/compose/runtime/SnapshotLongStateKt__SnapshotLongStateKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotLongStateKt {
    public static final long getValue(LongState longState, Object obj, t tVar) {
        return SnapshotLongStateKt__SnapshotLongStateKt.getValue(longState, obj, tVar);
    }

    @StateFactoryMarker
    public static final MutableLongState mutableLongStateOf(long j5) {
        return SnapshotLongStateKt__SnapshotLongStateKt.mutableLongStateOf(j5);
    }

    public static final void setValue(MutableLongState mutableLongState, Object obj, t tVar, long j5) {
        SnapshotLongStateKt__SnapshotLongStateKt.setValue(mutableLongState, obj, tVar, j5);
    }
}
