package androidx.compose.runtime;

import Z7.t;
import androidx.compose.runtime.snapshots.StateFactoryMarker;
import kotlin.Metadata;

@Metadata(d1 = {"androidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotIntStateKt {
    public static final int getValue(IntState intState, Object obj, t tVar) {
        return SnapshotIntStateKt__SnapshotIntStateKt.getValue(intState, obj, tVar);
    }

    @StateFactoryMarker
    public static final MutableIntState mutableIntStateOf(int i) {
        return SnapshotIntStateKt__SnapshotIntStateKt.mutableIntStateOf(i);
    }

    public static final void setValue(MutableIntState mutableIntState, Object obj, t tVar, int i) {
        SnapshotIntStateKt__SnapshotIntStateKt.setValue(mutableIntState, obj, tVar, i);
    }
}
