package stepai.aios.guiagent.pipeline;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"stepai/aios/guiagent/pipeline/ExecutionPipeline$ControlEvent", "", "Lstepai/aios/guiagent/pipeline/ExecutionPipeline$ControlEvent;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$ControlEvent {

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutionPipeline$ControlEvent f6035a;
    public static final ExecutionPipeline$ControlEvent b;
    public static final /* synthetic */ ExecutionPipeline$ControlEvent[] c;

    static {
        ExecutionPipeline$ControlEvent executionPipeline$ControlEvent = new ExecutionPipeline$ControlEvent("STOP", 0);
        f6035a = executionPipeline$ControlEvent;
        ExecutionPipeline$ControlEvent executionPipeline$ControlEvent2 = new ExecutionPipeline$ControlEvent("TAKEOVER", 1);
        b = executionPipeline$ControlEvent2;
        ExecutionPipeline$ControlEvent[] executionPipeline$ControlEventArr = {executionPipeline$ControlEvent, executionPipeline$ControlEvent2};
        c = executionPipeline$ControlEventArr;
        kotlin.enums.a.a(executionPipeline$ControlEventArr);
    }

    public static ExecutionPipeline$ControlEvent valueOf(String str) {
        return (ExecutionPipeline$ControlEvent) Enum.valueOf(ExecutionPipeline$ControlEvent.class, str);
    }

    public static ExecutionPipeline$ControlEvent[] values() {
        return (ExecutionPipeline$ControlEvent[]) c.clone();
    }
}
