package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"androidx/compose/runtime/SnapshotDoubleStateKt__SnapshotDoubleStateKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class SnapshotDoubleStateKt {
    public static final MutableDoubleState mutableDoubleStateOf(double r100) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.mutableDoubleStateOf(r100);
    }

    public static final double getValue(DoubleState r100, Object r101, KProperty<?> r102) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.getValue(r100, r101, r102);
    }

    public static final void setValue(MutableDoubleState r100, Object r101, KProperty<?> r102, double r103) {
        SnapshotDoubleStateKt__SnapshotDoubleStateKt.setValue(r100, r101, r102, r103);
    }
}
