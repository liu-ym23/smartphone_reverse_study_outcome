package stepai.aios.guiagent.model;

import H4.o;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lstepai/aios/guiagent/model/StepExecutionState;", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepExecutionState {

    /* renamed from: a, reason: collision with root package name */
    public static final StepExecutionState f6033a;
    public static final StepExecutionState b;
    public static final StepExecutionState c;
    public static final StepExecutionState d;
    public static final StepExecutionState e;
    public static final StepExecutionState f;
    public static final StepExecutionState g;
    public static final /* synthetic */ StepExecutionState[] h;

    static {
        StepExecutionState stepExecutionState = new StepExecutionState("PENDING", 0);
        StepExecutionState stepExecutionState2 = new StepExecutionState("STARTED", 1);
        f6033a = stepExecutionState2;
        StepExecutionState stepExecutionState3 = new StepExecutionState("EXECUTING", 2);
        b = stepExecutionState3;
        StepExecutionState stepExecutionState4 = new StepExecutionState("COMPLETED", 3);
        c = stepExecutionState4;
        StepExecutionState stepExecutionState5 = new StepExecutionState("FAILED", 4);
        d = stepExecutionState5;
        StepExecutionState stepExecutionState6 = new StepExecutionState("RETRYING", 5);
        StepExecutionState stepExecutionState7 = new StepExecutionState("SKIPPED", 6);
        e = stepExecutionState7;
        StepExecutionState stepExecutionState8 = new StepExecutionState("CANCELLED", 7);
        f = stepExecutionState8;
        StepExecutionState stepExecutionState9 = new StepExecutionState("TAKEOVER", 8);
        g = stepExecutionState9;
        StepExecutionState[] stepExecutionStateArr = {stepExecutionState, stepExecutionState2, stepExecutionState3, stepExecutionState4, stepExecutionState5, stepExecutionState6, stepExecutionState7, stepExecutionState8, stepExecutionState9};
        h = stepExecutionStateArr;
        a.a(stepExecutionStateArr);
    }

    public static StepExecutionState valueOf(String str) {
        return (StepExecutionState) Enum.valueOf(StepExecutionState.class, str);
    }

    public static StepExecutionState[] values() {
        return (StepExecutionState[]) h.clone();
    }

    public final boolean a() {
        return o.N(c, d, e, f, g).contains(this);
    }
}
