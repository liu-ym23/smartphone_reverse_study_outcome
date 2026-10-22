package stepai.aios.guiagent.config;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lstepai/aios/guiagent/config/EnhancedConfig;", "", "delayToPerformCaptureScreen", "", "delayToPerformFirstCaptureScreen", "delayToPerformAccessibilityAction", AppAgent.CONSTRUCT, "(JJJ)V", "getDelayToPerformCaptureScreen", "()J", "getDelayToPerformFirstCaptureScreen", "getDelayToPerformAccessibilityAction", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnhancedConfig {
    private final long delayToPerformAccessibilityAction;
    private final long delayToPerformCaptureScreen;
    private final long delayToPerformFirstCaptureScreen;

    public EnhancedConfig() {
        this(0L, 0L, 0L, 7, null);
    }

    public static /* synthetic */ EnhancedConfig copy$default(EnhancedConfig enhancedConfig, long j5, long j6, long j10, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = enhancedConfig.delayToPerformCaptureScreen;
        }
        long j11 = j5;
        if ((i & 2) != 0) {
            j6 = enhancedConfig.delayToPerformFirstCaptureScreen;
        }
        long j12 = j6;
        if ((i & 4) != 0) {
            j10 = enhancedConfig.delayToPerformAccessibilityAction;
        }
        return enhancedConfig.copy(j11, j12, j10);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDelayToPerformCaptureScreen() {
        return this.delayToPerformCaptureScreen;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDelayToPerformFirstCaptureScreen() {
        return this.delayToPerformFirstCaptureScreen;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDelayToPerformAccessibilityAction() {
        return this.delayToPerformAccessibilityAction;
    }

    public final EnhancedConfig copy(long delayToPerformCaptureScreen, long delayToPerformFirstCaptureScreen, long delayToPerformAccessibilityAction) {
        return new EnhancedConfig(delayToPerformCaptureScreen, delayToPerformFirstCaptureScreen, delayToPerformAccessibilityAction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnhancedConfig)) {
            return false;
        }
        EnhancedConfig enhancedConfig = (EnhancedConfig) other;
        return this.delayToPerformCaptureScreen == enhancedConfig.delayToPerformCaptureScreen && this.delayToPerformFirstCaptureScreen == enhancedConfig.delayToPerformFirstCaptureScreen && this.delayToPerformAccessibilityAction == enhancedConfig.delayToPerformAccessibilityAction;
    }

    public final long getDelayToPerformAccessibilityAction() {
        return this.delayToPerformAccessibilityAction;
    }

    public final long getDelayToPerformCaptureScreen() {
        return this.delayToPerformCaptureScreen;
    }

    public final long getDelayToPerformFirstCaptureScreen() {
        return this.delayToPerformFirstCaptureScreen;
    }

    public int hashCode() {
        return Long.hashCode(this.delayToPerformAccessibilityAction) + a.c(Long.hashCode(this.delayToPerformCaptureScreen) * 31, 31, this.delayToPerformFirstCaptureScreen);
    }

    public String toString() {
        return "EnhancedConfig(delayToPerformCaptureScreen=" + this.delayToPerformCaptureScreen + ", delayToPerformFirstCaptureScreen=" + this.delayToPerformFirstCaptureScreen + ", delayToPerformAccessibilityAction=" + this.delayToPerformAccessibilityAction + ")";
    }

    public EnhancedConfig(long j5, long j6, long j10) {
        this.delayToPerformCaptureScreen = j5;
        this.delayToPerformFirstCaptureScreen = j6;
        this.delayToPerformAccessibilityAction = j10;
    }

    public /* synthetic */ EnhancedConfig(long j5, long j6, long j10, int i, e eVar) {
        this((i & 1) != 0 ? 50L : j5, (i & 2) != 0 ? 500L : j6, (i & 4) != 0 ? 50L : j10);
    }
}
