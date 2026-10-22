package androidx.compose.runtime;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007\u001a\u0012\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\t0\u0002H\u0007\u001a\u0012\u0010\n\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\f0\u0002H\u0007¨\u0006\r"}, d2 = {"asIntState", "Landroidx/compose/runtime/IntState;", "Landroidx/compose/runtime/State;", "", "asLongState", "Landroidx/compose/runtime/LongState;", "", "asFloatState", "Landroidx/compose/runtime/FloatState;", "", "asDoubleState", "Landroidx/compose/runtime/DoubleState;", "", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnapshotStateExtensionsKt {
    public static final DoubleState asDoubleState(State<Double> r100) {
        if ((r100 instanceof DoubleState) == false) goto L6;
        return (DoubleState) r100;
    L6:
        return new UnboxedDoubleState(r100);
    }

    public static final FloatState asFloatState(State<Float> r100) {
        if ((r100 instanceof FloatState) == false) goto L6;
        return (FloatState) r100;
    L6:
        return new UnboxedFloatState(r100);
    }

    public static final IntState asIntState(State<Integer> r100) {
        if ((r100 instanceof IntState) == false) goto L6;
        return (IntState) r100;
    L6:
        return new UnboxedIntState(r100);
    }

    public static final LongState asLongState(State<Long> r100) {
        if ((r100 instanceof LongState) == false) goto L6;
        return (LongState) r100;
    L6:
        return new UnboxedLongState(r100);
    }
}
