package stepai.aios.guiagent.config;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lstepai/aios/guiagent/config/ActionType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "CLICK", "TYPE", "WAIT", "AWAKE", "INQUIRY", "TAKEOVER", "COMPLETE", "ABORT", "SWIPE", "BACK", "HOME", "ENTER", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ActionType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ActionType[] $VALUES;
    public static final ActionType CLICK = new ActionType("CLICK", 0);
    public static final ActionType TYPE = new ActionType("TYPE", 1);
    public static final ActionType WAIT = new ActionType("WAIT", 2);
    public static final ActionType AWAKE = new ActionType("AWAKE", 3);
    public static final ActionType INQUIRY = new ActionType("INQUIRY", 4);
    public static final ActionType TAKEOVER = new ActionType("TAKEOVER", 5);
    public static final ActionType COMPLETE = new ActionType("COMPLETE", 6);
    public static final ActionType ABORT = new ActionType("ABORT", 7);
    public static final ActionType SWIPE = new ActionType("SWIPE", 8);
    public static final ActionType BACK = new ActionType("BACK", 9);
    public static final ActionType HOME = new ActionType("HOME", 10);
    public static final ActionType ENTER = new ActionType("ENTER", 11);

    private static final /* synthetic */ ActionType[] $values() {
        return new ActionType[]{CLICK, TYPE, WAIT, AWAKE, INQUIRY, TAKEOVER, COMPLETE, ABORT, SWIPE, BACK, HOME, ENTER};
    }

    static {
        ActionType[] actionTypeArr$values = $values();
        $VALUES = actionTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(actionTypeArr$values);
    }

    private ActionType(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static ActionType valueOf(String str) {
        return (ActionType) Enum.valueOf(ActionType.class, str);
    }

    public static ActionType[] values() {
        return (ActionType[]) $VALUES.clone();
    }
}
