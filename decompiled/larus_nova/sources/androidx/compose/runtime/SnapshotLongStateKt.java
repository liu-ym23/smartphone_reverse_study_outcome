package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"androidx/compose/runtime/SnapshotLongStateKt__SnapshotLongStateKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class SnapshotLongStateKt {
    public static final MutableLongState mutableLongStateOf(long r100) {
        return SnapshotLongStateKt__SnapshotLongStateKt.mutableLongStateOf(r100);
    }

    public static final long getValue(LongState r100, Object r101, KProperty<?> r102) {
        return SnapshotLongStateKt__SnapshotLongStateKt.getValue(r100, r101, r102);
    }

    public static final void setValue(MutableLongState r100, Object r101, KProperty<?> r102, long r103) {
        SnapshotLongStateKt__SnapshotLongStateKt.setValue(r100, r101, r102, r103);
    }
}
