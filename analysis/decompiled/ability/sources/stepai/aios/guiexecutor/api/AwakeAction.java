package stepai.aios.guiexecutor.api;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiexecutor/api/AwakeAction;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "LAUNCH_APP", "SWITCH_TO_APP", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AwakeAction {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ AwakeAction[] $VALUES;
    public static final AwakeAction LAUNCH_APP = new AwakeAction("LAUNCH_APP", 0);
    public static final AwakeAction SWITCH_TO_APP = new AwakeAction("SWITCH_TO_APP", 1);

    private static final /* synthetic */ AwakeAction[] $values() {
        return new AwakeAction[]{LAUNCH_APP, SWITCH_TO_APP};
    }

    static {
        AwakeAction[] awakeActionArr$values = $values();
        $VALUES = awakeActionArr$values;
        $ENTRIES = kotlin.enums.a.a(awakeActionArr$values);
    }

    private AwakeAction(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static AwakeAction valueOf(String str) {
        return (AwakeAction) Enum.valueOf(AwakeAction.class, str);
    }

    public static AwakeAction[] values() {
        return (AwakeAction[]) $VALUES.clone();
    }
}
