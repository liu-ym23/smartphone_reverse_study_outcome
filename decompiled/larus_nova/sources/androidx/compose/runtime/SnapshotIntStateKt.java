package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"androidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class SnapshotIntStateKt {
    public static final MutableIntState mutableIntStateOf(int r100) {
        return SnapshotIntStateKt__SnapshotIntStateKt.mutableIntStateOf(r100);
    }

    public static final int getValue(IntState r100, Object r101, KProperty<?> r102) {
        return SnapshotIntStateKt__SnapshotIntStateKt.getValue(r100, r101, r102);
    }

    public static final void setValue(MutableIntState r100, Object r101, KProperty<?> r102, int r103) {
        SnapshotIntStateKt__SnapshotIntStateKt.setValue(r100, r101, r102, r103);
    }
}
