package kotlinx.coroutines.flow;

import com.stepos.core.download.ModelFlowMeta;
import kotlin.coroutines.d;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class StateFlowKt {
    private static final Symbol NONE = new Symbol(ModelFlowMeta.PLAN_NONE);
    private static final Symbol PENDING = new Symbol("PENDING");

    public static final <T> MutableStateFlow<T> MutableStateFlow(T t8) {
        if (t8 == null) {
            t8 = (T) NullSurrogateKt.NULL;
        }
        return new StateFlowImpl(t8);
    }

    public static final <T> Flow<T> fuseStateFlow(StateFlow<? extends T> stateFlow, d dVar, int i10, BufferOverflow bufferOverflow) {
        return (((i10 < 0 || i10 >= 2) && i10 != -2) || bufferOverflow != BufferOverflow.DROP_OLDEST) ? SharedFlowKt.fuseSharedFlow(stateFlow, dVar, i10, bufferOverflow) : stateFlow;
    }
}
