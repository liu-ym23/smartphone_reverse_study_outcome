package stepai.aios.guiagent.config;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.ability.GuiAbilityProvider;
import stepai.aios.guiagent.app.AppLauncher;
import stepai.aios.guiagent.tracer.GuiTracerConfig;
import stepai.aios.guiexecutor.api.GuiActionExecutor;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00107\u001a\u00020\u0012HÆ\u0003J\t\u00108\u001a\u00020\u0014HÆ\u0003J\u0015\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016HÆ\u0003J\u0087\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016HÆ\u0001J\u0013\u0010;\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\tHÖ\u0001J\t\u0010>\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006?"}, d2 = {"Lstepai/aios/guiagent/config/ResolvedTaskConfig;", "", "llmConfig", "Lstepai/aios/guiagent/config/LlmConfig;", "actionConfig", "Lstepai/aios/guiagent/config/ActionConfig;", "enhancedConfig", "Lstepai/aios/guiagent/config/EnhancedConfig;", "maxSteps", "", "maxFailureTolerance", "guiAbilityProvider", "Lstepai/aios/guiagent/ability/GuiAbilityProvider;", "guiActionExecutor", "Lstepai/aios/guiexecutor/api/GuiActionExecutor;", "appLauncher", "Lstepai/aios/guiagent/app/AppLauncher;", "tracerConfig", "Lstepai/aios/guiagent/tracer/GuiTracerConfig;", "debugMode", "", "metadata", "", "", AppAgent.CONSTRUCT, "(Lstepai/aios/guiagent/config/LlmConfig;Lstepai/aios/guiagent/config/ActionConfig;Lstepai/aios/guiagent/config/EnhancedConfig;IILstepai/aios/guiagent/ability/GuiAbilityProvider;Lstepai/aios/guiexecutor/api/GuiActionExecutor;Lstepai/aios/guiagent/app/AppLauncher;Lstepai/aios/guiagent/tracer/GuiTracerConfig;ZLjava/util/Map;)V", "getLlmConfig", "()Lstepai/aios/guiagent/config/LlmConfig;", "getActionConfig", "()Lstepai/aios/guiagent/config/ActionConfig;", "getEnhancedConfig", "()Lstepai/aios/guiagent/config/EnhancedConfig;", "getMaxSteps", "()I", "getMaxFailureTolerance", "getGuiAbilityProvider", "()Lstepai/aios/guiagent/ability/GuiAbilityProvider;", "getGuiActionExecutor", "()Lstepai/aios/guiexecutor/api/GuiActionExecutor;", "getAppLauncher", "()Lstepai/aios/guiagent/app/AppLauncher;", "getTracerConfig", "()Lstepai/aios/guiagent/tracer/GuiTracerConfig;", "getDebugMode", "()Z", "getMetadata", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ResolvedTaskConfig {
    private final ActionConfig actionConfig;
    private final AppLauncher appLauncher;
    private final boolean debugMode;
    private final EnhancedConfig enhancedConfig;
    private final GuiAbilityProvider guiAbilityProvider;
    private final GuiActionExecutor guiActionExecutor;
    private final LlmConfig llmConfig;
    private final int maxFailureTolerance;
    private final int maxSteps;
    private final Map<String, Object> metadata;
    private final GuiTracerConfig tracerConfig;

    public ResolvedTaskConfig(LlmConfig llmConfig, ActionConfig actionConfig, EnhancedConfig enhancedConfig, int i, int i6, GuiAbilityProvider guiAbilityProvider, GuiActionExecutor guiActionExecutor, AppLauncher appLauncher, GuiTracerConfig tracerConfig, boolean z10, Map<String, ? extends Object> metadata) {
        k.f(llmConfig, "llmConfig");
        k.f(actionConfig, "actionConfig");
        k.f(enhancedConfig, "enhancedConfig");
        k.f(guiAbilityProvider, "guiAbilityProvider");
        k.f(tracerConfig, "tracerConfig");
        k.f(metadata, "metadata");
        this.llmConfig = llmConfig;
        this.actionConfig = actionConfig;
        this.enhancedConfig = enhancedConfig;
        this.maxSteps = i;
        this.maxFailureTolerance = i6;
        this.guiAbilityProvider = guiAbilityProvider;
        this.guiActionExecutor = guiActionExecutor;
        this.appLauncher = appLauncher;
        this.tracerConfig = tracerConfig;
        this.debugMode = z10;
        this.metadata = metadata;
    }

    public static /* synthetic */ ResolvedTaskConfig copy$default(ResolvedTaskConfig resolvedTaskConfig, LlmConfig llmConfig, ActionConfig actionConfig, EnhancedConfig enhancedConfig, int i, int i6, GuiAbilityProvider guiAbilityProvider, GuiActionExecutor guiActionExecutor, AppLauncher appLauncher, GuiTracerConfig guiTracerConfig, boolean z10, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            llmConfig = resolvedTaskConfig.llmConfig;
        }
        if ((i10 & 2) != 0) {
            actionConfig = resolvedTaskConfig.actionConfig;
        }
        if ((i10 & 4) != 0) {
            enhancedConfig = resolvedTaskConfig.enhancedConfig;
        }
        if ((i10 & 8) != 0) {
            i = resolvedTaskConfig.maxSteps;
        }
        if ((i10 & 16) != 0) {
            i6 = resolvedTaskConfig.maxFailureTolerance;
        }
        if ((i10 & 32) != 0) {
            guiAbilityProvider = resolvedTaskConfig.guiAbilityProvider;
        }
        if ((i10 & 64) != 0) {
            guiActionExecutor = resolvedTaskConfig.guiActionExecutor;
        }
        if ((i10 & 128) != 0) {
            appLauncher = resolvedTaskConfig.appLauncher;
        }
        if ((i10 & 256) != 0) {
            guiTracerConfig = resolvedTaskConfig.tracerConfig;
        }
        if ((i10 & 512) != 0) {
            z10 = resolvedTaskConfig.debugMode;
        }
        if ((i10 & 1024) != 0) {
            map = resolvedTaskConfig.metadata;
        }
        boolean z11 = z10;
        Map map2 = map;
        AppLauncher appLauncher2 = appLauncher;
        GuiTracerConfig guiTracerConfig2 = guiTracerConfig;
        GuiAbilityProvider guiAbilityProvider2 = guiAbilityProvider;
        GuiActionExecutor guiActionExecutor2 = guiActionExecutor;
        int i11 = i6;
        EnhancedConfig enhancedConfig2 = enhancedConfig;
        return resolvedTaskConfig.copy(llmConfig, actionConfig, enhancedConfig2, i, i11, guiAbilityProvider2, guiActionExecutor2, appLauncher2, guiTracerConfig2, z11, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final LlmConfig getLlmConfig() {
        return this.llmConfig;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getDebugMode() {
        return this.debugMode;
    }

    public final Map<String, Object> component11() {
        return this.metadata;
    }

    /* renamed from: component2, reason: from getter */
    public final ActionConfig getActionConfig() {
        return this.actionConfig;
    }

    /* renamed from: component3, reason: from getter */
    public final EnhancedConfig getEnhancedConfig() {
        return this.enhancedConfig;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMaxSteps() {
        return this.maxSteps;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMaxFailureTolerance() {
        return this.maxFailureTolerance;
    }

    /* renamed from: component6, reason: from getter */
    public final GuiAbilityProvider getGuiAbilityProvider() {
        return this.guiAbilityProvider;
    }

    /* renamed from: component7, reason: from getter */
    public final GuiActionExecutor getGuiActionExecutor() {
        return this.guiActionExecutor;
    }

    /* renamed from: component8, reason: from getter */
    public final AppLauncher getAppLauncher() {
        return this.appLauncher;
    }

    /* renamed from: component9, reason: from getter */
    public final GuiTracerConfig getTracerConfig() {
        return this.tracerConfig;
    }

    public final ResolvedTaskConfig copy(LlmConfig llmConfig, ActionConfig actionConfig, EnhancedConfig enhancedConfig, int maxSteps, int maxFailureTolerance, GuiAbilityProvider guiAbilityProvider, GuiActionExecutor guiActionExecutor, AppLauncher appLauncher, GuiTracerConfig tracerConfig, boolean debugMode, Map<String, ? extends Object> metadata) {
        k.f(llmConfig, "llmConfig");
        k.f(actionConfig, "actionConfig");
        k.f(enhancedConfig, "enhancedConfig");
        k.f(guiAbilityProvider, "guiAbilityProvider");
        k.f(tracerConfig, "tracerConfig");
        k.f(metadata, "metadata");
        return new ResolvedTaskConfig(llmConfig, actionConfig, enhancedConfig, maxSteps, maxFailureTolerance, guiAbilityProvider, guiActionExecutor, appLauncher, tracerConfig, debugMode, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResolvedTaskConfig)) {
            return false;
        }
        ResolvedTaskConfig resolvedTaskConfig = (ResolvedTaskConfig) other;
        return k.b(this.llmConfig, resolvedTaskConfig.llmConfig) && k.b(this.actionConfig, resolvedTaskConfig.actionConfig) && k.b(this.enhancedConfig, resolvedTaskConfig.enhancedConfig) && this.maxSteps == resolvedTaskConfig.maxSteps && this.maxFailureTolerance == resolvedTaskConfig.maxFailureTolerance && k.b(this.guiAbilityProvider, resolvedTaskConfig.guiAbilityProvider) && k.b(this.guiActionExecutor, resolvedTaskConfig.guiActionExecutor) && k.b(this.appLauncher, resolvedTaskConfig.appLauncher) && k.b(this.tracerConfig, resolvedTaskConfig.tracerConfig) && this.debugMode == resolvedTaskConfig.debugMode && k.b(this.metadata, resolvedTaskConfig.metadata);
    }

    public final ActionConfig getActionConfig() {
        return this.actionConfig;
    }

    public final AppLauncher getAppLauncher() {
        return this.appLauncher;
    }

    public final boolean getDebugMode() {
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

    public final int getMaxFailureTolerance() {
        return this.maxFailureTolerance;
    }

    public final int getMaxSteps() {
        return this.maxSteps;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final GuiTracerConfig getTracerConfig() {
        return this.tracerConfig;
    }

    public int hashCode() {
        int iHashCode = (this.guiAbilityProvider.hashCode() + a.a(this.maxFailureTolerance, a.a(this.maxSteps, (this.enhancedConfig.hashCode() + ((this.actionConfig.hashCode() + (this.llmConfig.hashCode() * 31)) * 31)) * 31, 31), 31)) * 31;
        GuiActionExecutor guiActionExecutor = this.guiActionExecutor;
        int iHashCode2 = (iHashCode + (guiActionExecutor == null ? 0 : guiActionExecutor.hashCode())) * 31;
        AppLauncher appLauncher = this.appLauncher;
        return this.metadata.hashCode() + androidx.appfunctions.metadata.a.d((this.tracerConfig.hashCode() + ((iHashCode2 + (appLauncher != null ? appLauncher.hashCode() : 0)) * 31)) * 31, 31, this.debugMode);
    }

    public String toString() {
        return "ResolvedTaskConfig(llmConfig=" + this.llmConfig + ", actionConfig=" + this.actionConfig + ", enhancedConfig=" + this.enhancedConfig + ", maxSteps=" + this.maxSteps + ", maxFailureTolerance=" + this.maxFailureTolerance + ", guiAbilityProvider=" + this.guiAbilityProvider + ", guiActionExecutor=" + this.guiActionExecutor + ", appLauncher=" + this.appLauncher + ", tracerConfig=" + this.tracerConfig + ", debugMode=" + this.debugMode + ", metadata=" + this.metadata + ")";
    }
}
