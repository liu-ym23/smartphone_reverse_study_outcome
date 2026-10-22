package androidx.compose.runtime;

import Z7.t;
import androidx.compose.runtime.snapshots.StateFactoryMarker;
import kotlin.Metadata;

@Metadata(d1 = {"androidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PrimitiveSnapshotStateKt {
    public static final float getValue(FloatState floatState, Object obj, t tVar) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.getValue(floatState, obj, tVar);
    }

    @StateFactoryMarker
    public static final MutableFloatState mutableFloatStateOf(float f) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.mutableFloatStateOf(f);
    }

    public static final void setValue(MutableFloatState mutableFloatState, Object obj, t tVar, float f) {
        PrimitiveSnapshotStateKt__SnapshotFloatStateKt.setValue(mutableFloatState, obj, tVar, f);
    }
}
