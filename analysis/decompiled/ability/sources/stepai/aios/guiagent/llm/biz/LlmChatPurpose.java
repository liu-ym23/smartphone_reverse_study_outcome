package stepai.aios.guiagent.llm.biz;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiagent/llm/biz/LlmChatPurpose;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "ACTION_EXECUTION", "STATE_COMPRESSION", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LlmChatPurpose {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ LlmChatPurpose[] $VALUES;
    public static final LlmChatPurpose ACTION_EXECUTION = new LlmChatPurpose("ACTION_EXECUTION", 0);
    public static final LlmChatPurpose STATE_COMPRESSION = new LlmChatPurpose("STATE_COMPRESSION", 1);

    private static final /* synthetic */ LlmChatPurpose[] $values() {
        return new LlmChatPurpose[]{ACTION_EXECUTION, STATE_COMPRESSION};
    }

    static {
        LlmChatPurpose[] llmChatPurposeArr$values = $values();
        $VALUES = llmChatPurposeArr$values;
        $ENTRIES = kotlin.enums.a.a(llmChatPurposeArr$values);
    }

    private LlmChatPurpose(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static LlmChatPurpose valueOf(String str) {
        return (LlmChatPurpose) Enum.valueOf(LlmChatPurpose.class, str);
    }

    public static LlmChatPurpose[] values() {
        return (LlmChatPurpose[]) $VALUES.clone();
    }
}
