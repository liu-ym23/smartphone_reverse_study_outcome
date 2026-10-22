package stepai.aios.guiagent.config;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lstepai/aios/guiagent/config/ActionState;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "PENDING", "EXECUTING", "SUCCESS", "FAILED", "CANCELLED", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ActionState {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ActionState[] $VALUES;
    public static final ActionState PENDING = new ActionState("PENDING", 0);
    public static final ActionState EXECUTING = new ActionState("EXECUTING", 1);
    public static final ActionState SUCCESS = new ActionState("SUCCESS", 2);
    public static final ActionState FAILED = new ActionState("FAILED", 3);
    public static final ActionState CANCELLED = new ActionState("CANCELLED", 4);

    private static final /* synthetic */ ActionState[] $values() {
        return new ActionState[]{PENDING, EXECUTING, SUCCESS, FAILED, CANCELLED};
    }

    static {
        ActionState[] actionStateArr$values = $values();
        $VALUES = actionStateArr$values;
        $ENTRIES = kotlin.enums.a.a(actionStateArr$values);
    }

    private ActionState(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static ActionState valueOf(String str) {
        return (ActionState) Enum.valueOf(ActionState.class, str);
    }

    public static ActionState[] values() {
        return (ActionState[]) $VALUES.clone();
    }
}
