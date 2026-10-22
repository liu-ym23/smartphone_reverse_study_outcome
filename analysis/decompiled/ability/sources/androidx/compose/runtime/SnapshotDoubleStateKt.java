package androidx.compose.runtime;

import Z7.t;
import androidx.compose.runtime.snapshots.StateFactoryMarker;
import kotlin.Metadata;

@Metadata(d1 = {"androidx/compose/runtime/SnapshotDoubleStateKt__SnapshotDoubleStateKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotDoubleStateKt {
    public static final double getValue(DoubleState doubleState, Object obj, t tVar) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.getValue(doubleState, obj, tVar);
    }

    @StateFactoryMarker
    public static final MutableDoubleState mutableDoubleStateOf(double d) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.mutableDoubleStateOf(d);
    }

    public static final void setValue(MutableDoubleState mutableDoubleState, Object obj, t tVar, double d) {
        SnapshotDoubleStateKt__SnapshotDoubleStateKt.setValue(mutableDoubleState, obj, tVar, d);
    }
}
