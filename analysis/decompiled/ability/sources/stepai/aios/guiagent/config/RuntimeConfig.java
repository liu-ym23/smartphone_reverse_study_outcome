package stepai.aios.guiagent.config;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.tracer.GuiTracerConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003JG\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006'"}, d2 = {"Lstepai/aios/guiagent/config/RuntimeConfig;", "", "sessionConfig", "Lstepai/aios/guiagent/config/SessionConfig;", "maxConcurrentTasks", "", "tracerConfig", "Lstepai/aios/guiagent/tracer/GuiTracerConfig;", "llmConfig", "Lstepai/aios/guiagent/config/LlmConfig;", "taskConfig", "Lstepai/aios/guiagent/config/TaskConfig;", "maxFailureTolerance", AppAgent.CONSTRUCT, "(Lstepai/aios/guiagent/config/SessionConfig;ILstepai/aios/guiagent/tracer/GuiTracerConfig;Lstepai/aios/guiagent/config/LlmConfig;Lstepai/aios/guiagent/config/TaskConfig;I)V", "getSessionConfig", "()Lstepai/aios/guiagent/config/SessionConfig;", "getMaxConcurrentTasks", "()I", "getTracerConfig", "()Lstepai/aios/guiagent/tracer/GuiTracerConfig;", "getLlmConfig", "()Lstepai/aios/guiagent/config/LlmConfig;", "getTaskConfig", "()Lstepai/aios/guiagent/config/TaskConfig;", "getMaxFailureTolerance", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RuntimeConfig {
    private final LlmConfig llmConfig;
    private final int maxConcurrentTasks;
    private final int maxFailureTolerance;
    private final SessionConfig sessionConfig;
    private final TaskConfig taskConfig;
    private final GuiTracerConfig tracerConfig;

    public RuntimeConfig() {
        this(null, 0, null, null, null, 0, 63, null);
    }

    public static /* synthetic */ RuntimeConfig copy$default(RuntimeConfig runtimeConfig, SessionConfig sessionConfig, int i, GuiTracerConfig guiTracerConfig, LlmConfig llmConfig, TaskConfig taskConfig, int i6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            sessionConfig = runtimeConfig.sessionConfig;
        }
        if ((i10 & 2) != 0) {
            i = runtimeConfig.maxConcurrentTasks;
        }
        if ((i10 & 4) != 0) {
            guiTracerConfig = runtimeConfig.tracerConfig;
        }
        if ((i10 & 8) != 0) {
            llmConfig = runtimeConfig.llmConfig;
        }
        if ((i10 & 16) != 0) {
            taskConfig = runtimeConfig.taskConfig;
        }
        if ((i10 & 32) != 0) {
            i6 = runtimeConfig.maxFailureTolerance;
        }
        TaskConfig taskConfig2 = taskConfig;
        int i11 = i6;
        return runtimeConfig.copy(sessionConfig, i, guiTracerConfig, llmConfig, taskConfig2, i11);
    }

    /* renamed from: component1, reason: from getter */
    public final SessionConfig getSessionConfig() {
        return this.sessionConfig;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMaxConcurrentTasks() {
        return this.maxConcurrentTasks;
    }

    /* renamed from: component3, reason: from getter */
    public final GuiTracerConfig getTracerConfig() {
        return this.tracerConfig;
    }

    /* renamed from: component4, reason: from getter */
    public final LlmConfig getLlmConfig() {
        return this.llmConfig;
    }

    /* renamed from: component5, reason: from getter */
    public final TaskConfig getTaskConfig() {
        return this.taskConfig;
    }

    /* renamed from: component6, reason: from getter */
    public final int getMaxFailureTolerance() {
        return this.maxFailureTolerance;
    }

    public final RuntimeConfig copy(SessionConfig sessionConfig, int maxConcurrentTasks, GuiTracerConfig tracerConfig, LlmConfig llmConfig, TaskConfig taskConfig, int maxFailureTolerance) {
        k.f(sessionConfig, "sessionConfig");
        k.f(tracerConfig, "tracerConfig");
        k.f(taskConfig, "taskConfig");
        return new RuntimeConfig(sessionConfig, maxConcurrentTasks, tracerConfig, llmConfig, taskConfig, maxFailureTolerance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RuntimeConfig)) {
            return false;
        }
        RuntimeConfig runtimeConfig = (RuntimeConfig) other;
        return k.b(this.sessionConfig, runtimeConfig.sessionConfig) && this.maxConcurrentTasks == runtimeConfig.maxConcurrentTasks && k.b(this.tracerConfig, runtimeConfig.tracerConfig) && k.b(this.llmConfig, runtimeConfig.llmConfig) && k.b(this.taskConfig, runtimeConfig.taskConfig) && this.maxFailureTolerance == runtimeConfig.maxFailureTolerance;
    }

    public final LlmConfig getLlmConfig() {
        return this.llmConfig;
    }

    public final int getMaxConcurrentTasks() {
        return this.maxConcurrentTasks;
    }

    public final int getMaxFailureTolerance() {
        return this.maxFailureTolerance;
    }

    public final SessionConfig getSessionConfig() {
        return this.sessionConfig;
    }

    public final TaskConfig getTaskConfig() {
        return this.taskConfig;
    }

    public final GuiTracerConfig getTracerConfig() {
        return this.tracerConfig;
    }

    public int hashCode() {
        int iHashCode = (this.tracerConfig.hashCode() + a.a(this.maxConcurrentTasks, this.sessionConfig.hashCode() * 31, 31)) * 31;
        LlmConfig llmConfig = this.llmConfig;
        return Integer.hashCode(this.maxFailureTolerance) + ((this.taskConfig.hashCode() + ((iHashCode + (llmConfig == null ? 0 : llmConfig.hashCode())) * 31)) * 31);
    }

    public String toString() {
        return "RuntimeConfig(sessionConfig=" + this.sessionConfig + ", maxConcurrentTasks=" + this.maxConcurrentTasks + ", tracerConfig=" + this.tracerConfig + ", llmConfig=" + this.llmConfig + ", taskConfig=" + this.taskConfig + ", maxFailureTolerance=" + this.maxFailureTolerance + ")";
    }

    public RuntimeConfig(SessionConfig sessionConfig, int i, GuiTracerConfig tracerConfig, LlmConfig llmConfig, TaskConfig taskConfig, int i6) {
        k.f(sessionConfig, "sessionConfig");
        k.f(tracerConfig, "tracerConfig");
        k.f(taskConfig, "taskConfig");
        this.sessionConfig = sessionConfig;
        this.maxConcurrentTasks = i;
        this.tracerConfig = tracerConfig;
        this.llmConfig = llmConfig;
        this.taskConfig = taskConfig;
        this.maxFailureTolerance = i6;
    }

    public /* synthetic */ RuntimeConfig(SessionConfig sessionConfig, int i, GuiTracerConfig guiTracerConfig, LlmConfig llmConfig, TaskConfig taskConfig, int i6, int i10, e eVar) {
        this((i10 & 1) != 0 ? new SessionConfig(0, 0, 0, 0L, 15, null) : sessionConfig, (i10 & 2) != 0 ? 10 : i, (i10 & 4) != 0 ? new GuiTracerConfig(false, 0, 0, false, 15, null) : guiTracerConfig, (i10 & 8) != 0 ? null : llmConfig, (i10 & 16) != 0 ? new TaskConfig(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : taskConfig, (i10 & 32) != 0 ? 0 : i6);
    }
}
