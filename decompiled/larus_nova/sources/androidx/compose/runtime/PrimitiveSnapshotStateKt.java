package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"androidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class PrimitiveSnapshotStateKt {
    public static final MutableFloatState mutableFloatStateOf(float r100) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.mutableFloatStateOf(r100);
    }

    public static final float getValue(FloatState r100, Object r101, KProperty<?> r102) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.getValue(r100, r101, r102);
    }

    public static final void setValue(MutableFloatState r100, Object r101, KProperty<?> r102, float r103) {
        PrimitiveSnapshotStateKt__SnapshotFloatStateKt.setValue(r100, r101, r102, r103);
    }
}
