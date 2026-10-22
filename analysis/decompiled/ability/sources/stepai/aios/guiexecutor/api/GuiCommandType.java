package stepai.aios.guiexecutor.api;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiCommandType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "CLICK", "INPUT", "SWIPE", "WAIT", "ASK_FOR_INPUT", "TAKEOVER", "AWAKE_APP", "SYSTEM_NAVIGATION", "TASK_COMPLETE", "TASK_ABORT", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuiCommandType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ GuiCommandType[] $VALUES;
    public static final GuiCommandType CLICK = new GuiCommandType("CLICK", 0);
    public static final GuiCommandType INPUT = new GuiCommandType("INPUT", 1);
    public static final GuiCommandType SWIPE = new GuiCommandType("SWIPE", 2);
    public static final GuiCommandType WAIT = new GuiCommandType("WAIT", 3);
    public static final GuiCommandType ASK_FOR_INPUT = new GuiCommandType("ASK_FOR_INPUT", 4);
    public static final GuiCommandType TAKEOVER = new GuiCommandType("TAKEOVER", 5);
    public static final GuiCommandType AWAKE_APP = new GuiCommandType("AWAKE_APP", 6);
    public static final GuiCommandType SYSTEM_NAVIGATION = new GuiCommandType("SYSTEM_NAVIGATION", 7);
    public static final GuiCommandType TASK_COMPLETE = new GuiCommandType("TASK_COMPLETE", 8);
    public static final GuiCommandType TASK_ABORT = new GuiCommandType("TASK_ABORT", 9);

    private static final /* synthetic */ GuiCommandType[] $values() {
        return new GuiCommandType[]{CLICK, INPUT, SWIPE, WAIT, ASK_FOR_INPUT, TAKEOVER, AWAKE_APP, SYSTEM_NAVIGATION, TASK_COMPLETE, TASK_ABORT};
    }

    static {
        GuiCommandType[] guiCommandTypeArr$values = $values();
        $VALUES = guiCommandTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(guiCommandTypeArr$values);
    }

    private GuiCommandType(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static GuiCommandType valueOf(String str) {
        return (GuiCommandType) Enum.valueOf(GuiCommandType.class, str);
    }

    public static GuiCommandType[] values() {
        return (GuiCommandType[]) $VALUES.clone();
    }
}
