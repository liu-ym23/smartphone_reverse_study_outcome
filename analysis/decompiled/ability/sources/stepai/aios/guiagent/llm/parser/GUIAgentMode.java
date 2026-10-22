package stepai.aios.guiagent.llm.parser;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lstepai/aios/guiagent/llm/parser/GUIAgentMode;", "", "displayName", "", "icon", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getIcon", "PLANNING_TREE", "PATH_FOLLOWING", "NO_PATH", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GUIAgentMode {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ GUIAgentMode[] $VALUES;
    private final String displayName;
    private final String icon;
    public static final GUIAgentMode PLANNING_TREE = new GUIAgentMode("PLANNING_TREE", 0, "规划树", "🌲");
    public static final GUIAgentMode PATH_FOLLOWING = new GUIAgentMode("PATH_FOLLOWING", 1, "路径遵循", "🛤️");
    public static final GUIAgentMode NO_PATH = new GUIAgentMode("NO_PATH", 2, "无路径", "🔀");

    private static final /* synthetic */ GUIAgentMode[] $values() {
        return new GUIAgentMode[]{PLANNING_TREE, PATH_FOLLOWING, NO_PATH};
    }

    static {
        GUIAgentMode[] gUIAgentModeArr$values = $values();
        $VALUES = gUIAgentModeArr$values;
        $ENTRIES = kotlin.enums.a.a(gUIAgentModeArr$values);
    }

    private GUIAgentMode(String str, int i, String str2, String str3) {
        this.displayName = str2;
        this.icon = str3;
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static GUIAgentMode valueOf(String str) {
        return (GUIAgentMode) Enum.valueOf(GUIAgentMode.class, str);
    }

    public static GUIAgentMode[] values() {
        return (GUIAgentMode[]) $VALUES.clone();
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getIcon() {
        return this.icon;
    }
}
