package stepai.aios.guiagent.tracer;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiTracerConfig;", "", "enabled", "", "maxTaskTraces", "", "maxStepTracesPerTask", "captureScreenshots", AppAgent.CONSTRUCT, "(ZIIZ)V", "getEnabled", "()Z", "getMaxTaskTraces", "()I", "getMaxStepTracesPerTask", "getCaptureScreenshots", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiTracerConfig {
    private final boolean captureScreenshots;
    private final boolean enabled;
    private final int maxStepTracesPerTask;
    private final int maxTaskTraces;

    public GuiTracerConfig() {
        this(false, 0, 0, false, 15, null);
    }

    public static /* synthetic */ GuiTracerConfig copy$default(GuiTracerConfig guiTracerConfig, boolean z10, int i, int i6, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = guiTracerConfig.enabled;
        }
        if ((i10 & 2) != 0) {
            i = guiTracerConfig.maxTaskTraces;
        }
        if ((i10 & 4) != 0) {
            i6 = guiTracerConfig.maxStepTracesPerTask;
        }
        if ((i10 & 8) != 0) {
            z11 = guiTracerConfig.captureScreenshots;
        }
        return guiTracerConfig.copy(z10, i, i6, z11);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMaxTaskTraces() {
        return this.maxTaskTraces;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMaxStepTracesPerTask() {
        return this.maxStepTracesPerTask;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getCaptureScreenshots() {
        return this.captureScreenshots;
    }

    public final GuiTracerConfig copy(boolean enabled, int maxTaskTraces, int maxStepTracesPerTask, boolean captureScreenshots) {
        return new GuiTracerConfig(enabled, maxTaskTraces, maxStepTracesPerTask, captureScreenshots);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTracerConfig)) {
            return false;
        }
        GuiTracerConfig guiTracerConfig = (GuiTracerConfig) other;
        return this.enabled == guiTracerConfig.enabled && this.maxTaskTraces == guiTracerConfig.maxTaskTraces && this.maxStepTracesPerTask == guiTracerConfig.maxStepTracesPerTask && this.captureScreenshots == guiTracerConfig.captureScreenshots;
    }

    public final boolean getCaptureScreenshots() {
        return this.captureScreenshots;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getMaxStepTracesPerTask() {
        return this.maxStepTracesPerTask;
    }

    public final int getMaxTaskTraces() {
        return this.maxTaskTraces;
    }

    public int hashCode() {
        return Boolean.hashCode(this.captureScreenshots) + a.a(this.maxStepTracesPerTask, a.a(this.maxTaskTraces, Boolean.hashCode(this.enabled) * 31, 31), 31);
    }

    public String toString() {
        return "GuiTracerConfig(enabled=" + this.enabled + ", maxTaskTraces=" + this.maxTaskTraces + ", maxStepTracesPerTask=" + this.maxStepTracesPerTask + ", captureScreenshots=" + this.captureScreenshots + ")";
    }

    public GuiTracerConfig(boolean z10, int i, int i6, boolean z11) {
        this.enabled = z10;
        this.maxTaskTraces = i;
        this.maxStepTracesPerTask = i6;
        this.captureScreenshots = z11;
    }

    public /* synthetic */ GuiTracerConfig(boolean z10, int i, int i6, boolean z11, int i10, e eVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? 100 : i, (i10 & 4) != 0 ? 200 : i6, (i10 & 8) != 0 ? true : z11);
    }
}
