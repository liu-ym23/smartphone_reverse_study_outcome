package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"kotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState", "", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CoroutineScheduler$WorkerState {

    /* renamed from: a, reason: collision with root package name */
    public static final CoroutineScheduler$WorkerState f5252a;
    public static final CoroutineScheduler$WorkerState b;
    public static final CoroutineScheduler$WorkerState c;
    public static final CoroutineScheduler$WorkerState d;
    public static final CoroutineScheduler$WorkerState e;
    public static final /* synthetic */ CoroutineScheduler$WorkerState[] f;

    static {
        CoroutineScheduler$WorkerState coroutineScheduler$WorkerState = new CoroutineScheduler$WorkerState("CPU_ACQUIRED", 0);
        f5252a = coroutineScheduler$WorkerState;
        CoroutineScheduler$WorkerState coroutineScheduler$WorkerState2 = new CoroutineScheduler$WorkerState("BLOCKING", 1);
        b = coroutineScheduler$WorkerState2;
        CoroutineScheduler$WorkerState coroutineScheduler$WorkerState3 = new CoroutineScheduler$WorkerState("PARKING", 2);
        c = coroutineScheduler$WorkerState3;
        CoroutineScheduler$WorkerState coroutineScheduler$WorkerState4 = new CoroutineScheduler$WorkerState("DORMANT", 3);
        d = coroutineScheduler$WorkerState4;
        CoroutineScheduler$WorkerState coroutineScheduler$WorkerState5 = new CoroutineScheduler$WorkerState("TERMINATED", 4);
        e = coroutineScheduler$WorkerState5;
        CoroutineScheduler$WorkerState[] coroutineScheduler$WorkerStateArr = {coroutineScheduler$WorkerState, coroutineScheduler$WorkerState2, coroutineScheduler$WorkerState3, coroutineScheduler$WorkerState4, coroutineScheduler$WorkerState5};
        f = coroutineScheduler$WorkerStateArr;
        a.a(coroutineScheduler$WorkerStateArr);
    }

    public static CoroutineScheduler$WorkerState valueOf(String str) {
        return (CoroutineScheduler$WorkerState) Enum.valueOf(CoroutineScheduler$WorkerState.class, str);
    }

    public static CoroutineScheduler$WorkerState[] values() {
        return (CoroutineScheduler$WorkerState[]) f.clone();
    }
}
