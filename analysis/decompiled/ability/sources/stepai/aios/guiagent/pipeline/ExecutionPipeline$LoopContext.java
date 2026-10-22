package stepai.aios.guiagent.pipeline;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"stepai/aios/guiagent/pipeline/ExecutionPipeline$LoopContext", "", "Lstepai/aios/guiagent/pipeline/ExecutionPipeline$LoopContext;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$LoopContext {
    public static final ExecutionPipeline$LoopContext i;

    /* renamed from: j, reason: collision with root package name */
    public static final ExecutionPipeline$LoopContext f6036j;
    public static final /* synthetic */ ExecutionPipeline$LoopContext[] k;

    /* renamed from: a, reason: collision with root package name */
    public final String f6037a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    static {
        ExecutionPipeline$LoopContext executionPipeline$LoopContext = new ExecutionPipeline$LoopContext("NORMAL", 0, "Stop signal detected for session: ", "Takeover signal detected for session: ", "Session is cancelled: ", "Session is in manual takeover state: ", "Task stopped by user", "Task cancelled", "Manual takeover initiated", "");
        i = executionPipeline$LoopContext;
        ExecutionPipeline$LoopContext executionPipeline$LoopContext2 = new ExecutionPipeline$LoopContext("RECOVERY", 1, "Stop signal detected during recovery for session: ", "Takeover signal detected during recovery for session: ", "Session is cancelled during recovery: ", "Session returned to manual takeover state during recovery: ", "Task stopped during recovery", "Task cancelled during recovery", "Manual takeover re-initiated during recovery", " (recovery mode)");
        f6036j = executionPipeline$LoopContext2;
        ExecutionPipeline$LoopContext[] executionPipeline$LoopContextArr = {executionPipeline$LoopContext, executionPipeline$LoopContext2};
        k = executionPipeline$LoopContextArr;
        kotlin.enums.a.a(executionPipeline$LoopContextArr);
    }

    public ExecutionPipeline$LoopContext(String str, int i6, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f6037a = str2;
        this.b = str3;
        this.c = str4;
        this.d = str5;
        this.e = str6;
        this.f = str7;
        this.g = str8;
        this.h = str9;
    }

    public static ExecutionPipeline$LoopContext valueOf(String str) {
        return (ExecutionPipeline$LoopContext) Enum.valueOf(ExecutionPipeline$LoopContext.class, str);
    }

    public static ExecutionPipeline$LoopContext[] values() {
        return (ExecutionPipeline$LoopContext[]) k.clone();
    }
}
