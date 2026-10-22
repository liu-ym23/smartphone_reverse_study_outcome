package stepai.aios.guiagent.llm;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lstepai/aios/guiagent/llm/FinishReason;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "STOP", "LENGTH", "CONTENT_FILTER", "TOOL_CALLS", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FinishReason {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ FinishReason[] $VALUES;
    public static final FinishReason STOP = new FinishReason("STOP", 0);
    public static final FinishReason LENGTH = new FinishReason("LENGTH", 1);
    public static final FinishReason CONTENT_FILTER = new FinishReason("CONTENT_FILTER", 2);
    public static final FinishReason TOOL_CALLS = new FinishReason("TOOL_CALLS", 3);

    private static final /* synthetic */ FinishReason[] $values() {
        return new FinishReason[]{STOP, LENGTH, CONTENT_FILTER, TOOL_CALLS};
    }

    static {
        FinishReason[] finishReasonArr$values = $values();
        $VALUES = finishReasonArr$values;
        $ENTRIES = kotlin.enums.a.a(finishReasonArr$values);
    }

    private FinishReason(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static FinishReason valueOf(String str) {
        return (FinishReason) Enum.valueOf(FinishReason.class, str);
    }

    public static FinishReason[] values() {
        return (FinishReason[]) $VALUES.clone();
    }
}
