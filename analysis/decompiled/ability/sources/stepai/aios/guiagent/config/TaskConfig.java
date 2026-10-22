package stepai.aios.guiagent.config;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.ability.GuiAbilityProvider;
import stepai.aios.guiagent.app.AppLauncher;
import stepai.aios.guiagent.tracer.GuiTracerConfig;
import stepai.aios.guiexecutor.api.GuiActionExecutor;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00105\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010+J\u0015\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u009c\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u00122\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0007HÖ\u0001J\t\u0010A\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006B"}, d2 = {"Lstepai/aios/guiagent/config/TaskConfig;", "", "actionConfig", "Lstepai/aios/guiagent/config/ActionConfig;", "enhancedConfig", "Lstepai/aios/guiagent/config/EnhancedConfig;", "maxSteps", "", "maxFailureTolerance", "guiAbilityProvider", "Lstepai/aios/guiagent/ability/GuiAbilityProvider;", "guiActionExecutor", "Lstepai/aios/guiexecutor/api/GuiActionExecutor;", "appLauncher", "Lstepai/aios/guiagent/app/AppLauncher;", "tracerConfig", "Lstepai/aios/guiagent/tracer/GuiTracerConfig;", "debugMode", "", "metadata", "", "", "llmConfig", "Lstepai/aios/guiagent/config/LlmConfig;", AppAgent.CONSTRUCT, "(Lstepai/aios/guiagent/config/ActionConfig;Lstepai/aios/guiagent/config/EnhancedConfig;Ljava/lang/Integer;Ljava/lang/Integer;Lstepai/aios/guiagent/ability/GuiAbilityProvider;Lstepai/aios/guiexecutor/api/GuiActionExecutor;Lstepai/aios/guiagent/app/AppLauncher;Lstepai/aios/guiagent/tracer/GuiTracerConfig;Ljava/lang/Boolean;Ljava/util/Map;Lstepai/aios/guiagent/config/LlmConfig;)V", "getActionConfig", "()Lstepai/aios/guiagent/config/ActionConfig;", "getEnhancedConfig", "()Lstepai/aios/guiagent/config/EnhancedConfig;", "getMaxSteps", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxFailureTolerance", "getGuiAbilityProvider", "()Lstepai/aios/guiagent/ability/GuiAbilityProvider;", "getGuiActionExecutor", "()Lstepai/aios/guiexecutor/api/GuiActionExecutor;", "getAppLauncher", "()Lstepai/aios/guiagent/app/AppLauncher;", "getTracerConfig", "()Lstepai/aios/guiagent/tracer/GuiTracerConfig;", "getDebugMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMetadata", "()Ljava/util/Map;", "getLlmConfig", "()Lstepai/aios/guiagent/config/LlmConfig;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Lstepai/aios/guiagent/config/ActionConfig;Lstepai/aios/guiagent/config/EnhancedConfig;Ljava/lang/Integer;Ljava/lang/Integer;Lstepai/aios/guiagent/ability/GuiAbilityProvider;Lstepai/aios/guiexecutor/api/GuiActionExecutor;Lstepai/aios/guiagent/app/AppLauncher;Lstepai/aios/guiagent/tracer/GuiTracerConfig;Ljava/lang/Boolean;Ljava/util/Map;Lstepai/aios/guiagent/config/LlmConfig;)Lstepai/aios/guiagent/config/TaskConfig;", "equals", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TaskConfig {
    private final ActionConfig actionConfig;
    private final AppLauncher appLauncher;
    private final Boolean debugMode;
    private final EnhancedConfig enhancedConfig;
    private final GuiAbilityProvider guiAbilityProvider;
    private final GuiActionExecutor guiActionExecutor;
    private final LlmConfig llmConfig;
    private final Integer maxFailureTolerance;
    private final Integer maxSteps;
    private final Map<String, Object> metadata;
    private final GuiTracerConfig tracerConfig;

    public TaskConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ TaskConfig copy$default(TaskConfig taskConfig, ActionConfig actionConfig, EnhancedConfig enhancedConfig, Integer num, Integer num2, GuiAbilityProvider guiAbilityProvider, GuiActionExecutor guiActionExecutor, AppLauncher appLauncher, GuiTracerConfig guiTracerConfig, Boolean bool, Map map, LlmConfig llmConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            actionConfig = taskConfig.actionConfig;
        }
        if ((i & 2) != 0) {
            enhancedConfig = taskConfig.enhancedConfig;
        }
        if ((i & 4) != 0) {
            num = taskConfig.maxSteps;
        }
        if ((i & 8) != 0) {
            num2 = taskConfig.maxFailureTolerance;
        }
        if ((i & 16) != 0) {
            guiAbilityProvider = taskConfig.guiAbilityProvider;
        }
        if ((i & 32) != 0) {
            guiActionExecutor = taskConfig.guiActionExecutor;
        }
        if ((i & 64) != 0) {
            appLauncher = taskConfig.appLauncher;
        }
        if ((i & 128) != 0) {
            guiTracerConfig = taskConfig.tracerConfig;
        }
        if ((i & 256) != 0) {
            bool = taskConfig.debugMode;
        }
        if ((i & 512) != 0) {
            map = taskConfig.metadata;
        }
        if ((i & 1024) != 0) {
            llmConfig = taskConfig.llmConfig;
        }
        Map map2 = map;
        LlmConfig llmConfig2 = llmConfig;
        GuiTracerConfig guiTracerConfig2 = guiTracerConfig;
        Boolean bool2 = bool;
        GuiActionExecutor guiActionExecutor2 = guiActionExecutor;
        AppLauncher appLauncher2 = appLauncher;
        GuiAbilityProvider guiAbilityProvider2 = guiAbilityProvider;
        Integer num3 = num;
        return taskConfig.copy(actionConfig, enhancedConfig, num3, num2, guiAbilityProvider2, guiActionExecutor2, appLauncher2, guiTracerConfig2, bool2, map2, llmConfig2);
    }

    /* renamed from: component1, reason: from getter */
    public final ActionConfig getActionConfig() {
        return this.actionConfig;
    }

    public final Map<String, Object> component10() {
        return this.metadata;
    }

    /* renamed from: component11, reason: from getter */
    public final LlmConfig getLlmConfig() {
        return this.llmConfig;
    }

    /* renamed from: component2, reason: from getter */
    public final EnhancedConfig getEnhancedConfig() {
        return this.enhancedConfig;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getMaxSteps() {
        return this.maxSteps;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getMaxFailureTolerance() {
        return this.maxFailureTolerance;
    }

    /* renamed from: component5, reason: from getter */
    public final GuiAbilityProvider getGuiAbilityProvider() {
        return this.guiAbilityProvider;
    }

    /* renamed from: component6, reason: from getter */
    public final GuiActionExecutor getGuiActionExecutor() {
        return this.guiActionExecutor;
    }

    /* renamed from: component7, reason: from getter */
    public final AppLauncher getAppLauncher() {
        return this.appLauncher;
    }

    /* renamed from: component8, reason: from getter */
    public final GuiTracerConfig getTracerConfig() {
        return this.tracerConfig;
    }

    /* renamed from: component9, reason: from getter */
    public final Boolean getDebugMode() {
        return this.debugMode;
    }

    public final TaskConfig copy(ActionConfig actionConfig, EnhancedConfig enhancedConfig, Integer maxSteps, Integer maxFailureTolerance, GuiAbilityProvider guiAbilityProvider, GuiActionExecutor guiActionExecutor, AppLauncher appLauncher, GuiTracerConfig tracerConfig, Boolean debugMode, Map<String, ? extends Object> metadata, LlmConfig llmConfig) {
        k.f(metadata, "metadata");
        return new TaskConfig(actionConfig, enhancedConfig, maxSteps, maxFailureTolerance, guiAbilityProvider, guiActionExecutor, appLauncher, tracerConfig, debugMode, metadata, llmConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskConfig)) {
            return false;
        }
        TaskConfig taskConfig = (TaskConfig) other;
        return k.b(this.actionConfig, taskConfig.actionConfig) && k.b(this.enhancedConfig, taskConfig.enhancedConfig) && k.b(this.maxSteps, taskConfig.maxSteps) && k.b(this.maxFailureTolerance, taskConfig.maxFailureTolerance) && k.b(this.guiAbilityProvider, taskConfig.guiAbilityProvider) && k.b(this.guiActionExecutor, taskConfig.guiActionExecutor) && k.b(this.appLauncher, taskConfig.appLauncher) && k.b(this.tracerConfig, taskConfig.tracerConfig) && k.b(this.debugMode, taskConfig.debugMode) && k.b(this.metadata, taskConfig.metadata) && k.b(this.llmConfig, taskConfig.llmConfig);
    }

    public final ActionConfig getActionConfig() {
        return this.actionConfig;
    }

    public final AppLauncher getAppLauncher() {
        return this.appLauncher;
    }

    public final Boolean getDebugMode() {
        return this.debugMode;
    }

    public final EnhancedConfig getEnhancedConfig() {
        return this.enhancedConfig;
    }

    public final GuiAbilityProvider getGuiAbilityProvider() {
        return this.guiAbilityProvider;
    }

    public final GuiActionExecutor getGuiActionExecutor() {
        return this.guiActionExecutor;
    }

    public final LlmConfig getLlmConfig() {
        return this.llmConfig;
    }

    public final Integer getMaxFailureTolerance() {
        return this.maxFailureTolerance;
    }

    public final Integer getMaxSteps() {
        return this.maxSteps;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final GuiTracerConfig getTracerConfig() {
        return this.tracerConfig;
    }

    public int hashCode() {
        ActionConfig actionConfig = this.actionConfig;
        int iHashCode = (actionConfig == null ? 0 : actionConfig.hashCode()) * 31;
        EnhancedConfig enhancedConfig = this.enhancedConfig;
        int iHashCode2 = (iHashCode + (enhancedConfig == null ? 0 : enhancedConfig.hashCode())) * 31;
        Integer num = this.maxSteps;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.maxFailureTolerance;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        GuiAbilityProvider guiAbilityProvider = this.guiAbilityProvider;
        int iHashCode5 = (iHashCode4 + (guiAbilityProvider == null ? 0 : guiAbilityProvider.hashCode())) * 31;
        GuiActionExecutor guiActionExecutor = this.guiActionExecutor;
        int iHashCode6 = (iHashCode5 + (guiActionExecutor == null ? 0 : guiActionExecutor.hashCode())) * 31;
        AppLauncher appLauncher = this.appLauncher;
        int iHashCode7 = (iHashCode6 + (appLauncher == null ? 0 : appLauncher.hashCode())) * 31;
        GuiTracerConfig guiTracerConfig = this.tracerConfig;
        int iHashCode8 = (iHashCode7 + (guiTracerConfig == null ? 0 : guiTracerConfig.hashCode())) * 31;
        Boolean bool = this.debugMode;
        int iF = a.f(this.metadata, (iHashCode8 + (bool == null ? 0 : bool.hashCode())) * 31, 31);
        LlmConfig llmConfig = this.llmConfig;
        return iF + (llmConfig != null ? llmConfig.hashCode() : 0);
    }

    public String toString() {
        return "TaskConfig(actionConfig=" + this.actionConfig + ", enhancedConfig=" + this.enhancedConfig + ", maxSteps=" + this.maxSteps + ", maxFailureTolerance=" + this.maxFailureTolerance + ", guiAbilityProvider=" + this.guiAbilityProvider + ", guiActionExecutor=" + this.guiActionExecutor + ", appLauncher=" + this.appLauncher + ", tracerConfig=" + this.tracerConfig + ", debugMode=" + this.debugMode + ", metadata=" + this.metadata + ", llmConfig=" + this.llmConfig + ")";
    }

    public TaskConfig(ActionConfig actionConfig, EnhancedConfig enhancedConfig, Integer num, Integer num2, GuiAbilityProvider guiAbilityProvider, GuiActionExecutor guiActionExecutor, AppLauncher appLauncher, GuiTracerConfig guiTracerConfig, Boolean bool, Map<String, ? extends Object> metadata, LlmConfig llmConfig) {
        k.f(metadata, "metadata");
        this.actionConfig = actionConfig;
        this.enhancedConfig = enhancedConfig;
        this.maxSteps = num;
        this.maxFailureTolerance = num2;
        this.guiAbilityProvider = guiAbilityProvider;
        this.guiActionExecutor = guiActionExecutor;
        this.appLauncher = appLauncher;
        this.tracerConfig = guiTracerConfig;
        this.debugMode = bool;
        this.metadata = metadata;
        this.llmConfig = llmConfig;
    }

    public /* synthetic */ TaskConfig(ActionConfig actionConfig, EnhancedConfig enhancedConfig, Integer num, Integer num2, GuiAbilityProvider guiAbilityProvider, GuiActionExecutor guiActionExecutor, AppLauncher appLauncher, GuiTracerConfig guiTracerConfig, Boolean bool, Map map, LlmConfig llmConfig, int i, e eVar) {
        this((i & 1) != 0 ? null : actionConfig, (i & 2) != 0 ? null : enhancedConfig, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : guiAbilityProvider, (i & 32) != 0 ? null : guiActionExecutor, (i & 64) != 0 ? null : appLauncher, (i & 128) != 0 ? null : guiTracerConfig, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? kotlin.collections.a.M() : map, (i & 1024) != 0 ? null : llmConfig);
    }
}
