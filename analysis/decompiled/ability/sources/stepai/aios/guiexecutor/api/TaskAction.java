package stepai.aios.guiexecutor.api;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiexecutor/api/TaskAction;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "COMPLETE", "ABORT", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TaskAction {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ TaskAction[] $VALUES;
    public static final TaskAction COMPLETE = new TaskAction("COMPLETE", 0);
    public static final TaskAction ABORT = new TaskAction("ABORT", 1);

    private static final /* synthetic */ TaskAction[] $values() {
        return new TaskAction[]{COMPLETE, ABORT};
    }

    static {
        TaskAction[] taskActionArr$values = $values();
        $VALUES = taskActionArr$values;
        $ENTRIES = kotlin.enums.a.a(taskActionArr$values);
    }

    private TaskAction(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static TaskAction valueOf(String str) {
        return (TaskAction) Enum.valueOf(TaskAction.class, str);
    }

    public static TaskAction[] values() {
        return (TaskAction[]) $VALUES.clone();
    }
}
