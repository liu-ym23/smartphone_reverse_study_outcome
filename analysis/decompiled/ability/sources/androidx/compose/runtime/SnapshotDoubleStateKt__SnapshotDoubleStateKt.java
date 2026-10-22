package androidx.compose.runtime;

import Z7.t;
import androidx.compose.runtime.snapshots.StateFactoryMarker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a*\u0010\n\u001a\u00020\u0000*\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0086\n¢\u0006\u0004\b\n\u0010\u000b\u001a2\u0010\r\u001a\u00020\f*\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"", "value", "Landroidx/compose/runtime/MutableDoubleState;", "mutableDoubleStateOf", "(D)Landroidx/compose/runtime/MutableDoubleState;", "Landroidx/compose/runtime/DoubleState;", "", "thisObj", "LZ7/t;", "property", "getValue", "(Landroidx/compose/runtime/DoubleState;Ljava/lang/Object;LZ7/t;)D", "LC7/r;", "setValue", "(Landroidx/compose/runtime/MutableDoubleState;Ljava/lang/Object;LZ7/t;D)V", "runtime"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotDoubleStateKt")
/* loaded from: classes.dex */
final /* synthetic */ class SnapshotDoubleStateKt__SnapshotDoubleStateKt {
    public static final double getValue(DoubleState doubleState, Object obj, t tVar) {
        return doubleState.getDoubleValue();
    }

    @StateFactoryMarker
    public static final MutableDoubleState mutableDoubleStateOf(double d) {
        return SnapshotDoubleState_androidKt.createSnapshotMutableDoubleState(d);
    }

    public static final void setValue(MutableDoubleState mutableDoubleState, Object obj, t tVar, double d) {
        mutableDoubleState.setDoubleValue(d);
    }
}
