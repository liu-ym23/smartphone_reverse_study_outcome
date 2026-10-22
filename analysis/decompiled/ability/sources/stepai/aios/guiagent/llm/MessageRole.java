package stepai.aios.guiagent.llm;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lstepai/aios/guiagent/llm/MessageRole;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "SYSTEM", "USER", "ASSISTANT", "TOOL", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MessageRole {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ MessageRole[] $VALUES;
    public static final MessageRole SYSTEM = new MessageRole("SYSTEM", 0);
    public static final MessageRole USER = new MessageRole("USER", 1);
    public static final MessageRole ASSISTANT = new MessageRole("ASSISTANT", 2);
    public static final MessageRole TOOL = new MessageRole("TOOL", 3);

    private static final /* synthetic */ MessageRole[] $values() {
        return new MessageRole[]{SYSTEM, USER, ASSISTANT, TOOL};
    }

    static {
        MessageRole[] messageRoleArr$values = $values();
        $VALUES = messageRoleArr$values;
        $ENTRIES = kotlin.enums.a.a(messageRoleArr$values);
    }

    private MessageRole(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static MessageRole valueOf(String str) {
        return (MessageRole) Enum.valueOf(MessageRole.class, str);
    }

    public static MessageRole[] values() {
        return (MessageRole[]) $VALUES.clone();
    }
}
