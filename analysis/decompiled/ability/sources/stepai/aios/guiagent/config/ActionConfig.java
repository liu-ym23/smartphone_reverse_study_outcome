package stepai.aios.guiagent.config;

import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lstepai/aios/guiagent/config/ActionConfig;", "", "delayMs", "", AppAgent.CONSTRUCT, "(J)V", "getDelayMs", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ActionConfig {
    private final long delayMs;

    public ActionConfig() {
        this(0L, 1, null);
    }

    public static /* synthetic */ ActionConfig copy$default(ActionConfig actionConfig, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = actionConfig.delayMs;
        }
        return actionConfig.copy(j5);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDelayMs() {
        return this.delayMs;
    }

    public final ActionConfig copy(long delayMs) {
        return new ActionConfig(delayMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ActionConfig) && this.delayMs == ((ActionConfig) other).delayMs;
    }

    public final long getDelayMs() {
        return this.delayMs;
    }

    public int hashCode() {
        return Long.hashCode(this.delayMs);
    }

    public String toString() {
        return b.q(this.delayMs, "ActionConfig(delayMs=", ")");
    }

    public ActionConfig(long j5) {
        this.delayMs = j5;
    }

    public /* synthetic */ ActionConfig(long j5, int i, e eVar) {
        this((i & 1) != 0 ? 500L : j5);
    }
}
