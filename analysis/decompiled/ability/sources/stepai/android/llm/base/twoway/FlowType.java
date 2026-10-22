package stepai.android.llm.base.twoway;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lstepai/android/llm/base/twoway/FlowType;", "", AppAgent.CONSTRUCT, "()V", "TRANSCRIPT", "", "SENDCLOSE", "COMPLETED", "FAILED", "CANCELED", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FlowType {
    public static final String CANCELED = "canceled";
    public static final String COMPLETED = "completed";
    public static final String FAILED = "failed";
    public static final FlowType INSTANCE = new FlowType();
    public static final String SENDCLOSE = "sendclose";
    public static final String TRANSCRIPT = "transcript";

    private FlowType() {
    }
}
