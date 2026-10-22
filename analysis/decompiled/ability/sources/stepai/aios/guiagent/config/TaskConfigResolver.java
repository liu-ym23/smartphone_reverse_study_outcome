package stepai.aios.guiagent.config;

import android.util.Size;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import i9.l;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.ability.DefaultGuiAbilityProvider;
import stepai.aios.guiagent.ability.GuiAbilityProvider;
import stepai.aios.guiagent.app.AppLauncher;
import stepai.aios.guiagent.llm.parser.IModelCell;
import stepai.aios.guiagent.tracer.GuiTracerConfig;
import stepai.aios.guiexecutor.api.GuiActionExecutor;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lstepai/aios/guiagent/config/TaskConfigResolver;", "", AppAgent.CONSTRUCT, "()V", "DEFAULT_MAX_STEPS", "", "DEFAULT_MAX_FAILURE_TOLERANCE", "resolve", "Lstepai/aios/guiagent/config/ResolvedTaskConfig;", "runtimeConfig", "Lstepai/aios/guiagent/config/RuntimeConfig;", "taskConfig", "Lstepai/aios/guiagent/config/TaskConfig;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TaskConfigResolver {
    private static final int DEFAULT_MAX_FAILURE_TOLERANCE = 0;
    private static final int DEFAULT_MAX_STEPS = 50;
    public static final TaskConfigResolver INSTANCE = new TaskConfigResolver();

    private TaskConfigResolver() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Size resolve$lambda$0(LlmConfig llmConfig) {
        IModelCell modelCell = llmConfig.getModelCell();
        if (modelCell != null) {
            return modelCell.getCompressBitmapSize();
        }
        return null;
    }

    public final ResolvedTaskConfig resolve(RuntimeConfig runtimeConfig, TaskConfig taskConfig) {
        k.f(runtimeConfig, "runtimeConfig");
        TaskConfig taskConfig2 = runtimeConfig.getTaskConfig();
        TaskConfig taskConfig3 = taskConfig == null ? new TaskConfig(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : taskConfig;
        LlmConfig llmConfig = taskConfig3.getLlmConfig();
        if (llmConfig == null && (llmConfig = runtimeConfig.getLlmConfig()) == null) {
            throw new IllegalArgumentException("LlmConfig is required (neither task-level nor runtime-level provided)");
        }
        ActionConfig actionConfig = taskConfig3.getActionConfig();
        if (actionConfig == null && (actionConfig = taskConfig2.getActionConfig()) == null) {
            actionConfig = new ActionConfig(0L, 1, null);
        }
        EnhancedConfig enhancedConfig = taskConfig3.getEnhancedConfig();
        if (enhancedConfig == null && (enhancedConfig = taskConfig2.getEnhancedConfig()) == null) {
            enhancedConfig = new EnhancedConfig(0L, 0L, 0L, 7, null);
        }
        Integer maxSteps = taskConfig3.getMaxSteps();
        int iIntValue = (maxSteps == null && (maxSteps = taskConfig2.getMaxSteps()) == null) ? 50 : maxSteps.intValue();
        int i = iIntValue >= 1 ? iIntValue : 1;
        Integer maxFailureTolerance = taskConfig3.getMaxFailureTolerance();
        int maxFailureTolerance2 = (maxFailureTolerance == null && (maxFailureTolerance = taskConfig2.getMaxFailureTolerance()) == null) ? runtimeConfig.getMaxFailureTolerance() : maxFailureTolerance.intValue();
        l lVar = new l(llmConfig, 4);
        GuiAbilityProvider guiAbilityProvider = taskConfig2.getGuiAbilityProvider();
        if (taskConfig3.getGuiAbilityProvider() != null) {
            guiAbilityProvider = taskConfig3.getGuiAbilityProvider();
        } else if (guiAbilityProvider == null || (guiAbilityProvider instanceof DefaultGuiAbilityProvider)) {
            guiAbilityProvider = new DefaultGuiAbilityProvider(lVar);
        }
        GuiAbilityProvider guiAbilityProvider2 = guiAbilityProvider;
        GuiActionExecutor guiActionExecutor = taskConfig3.getGuiActionExecutor();
        if (guiActionExecutor == null) {
            guiActionExecutor = taskConfig2.getGuiActionExecutor();
        }
        AppLauncher appLauncher = taskConfig3.getAppLauncher();
        if (appLauncher == null) {
            appLauncher = taskConfig2.getAppLauncher();
        }
        GuiTracerConfig tracerConfig = taskConfig3.getTracerConfig();
        if (tracerConfig == null && (tracerConfig = taskConfig2.getTracerConfig()) == null) {
            tracerConfig = runtimeConfig.getTracerConfig();
        }
        Boolean debugMode = taskConfig3.getDebugMode();
        return new ResolvedTaskConfig(llmConfig, actionConfig, enhancedConfig, i, maxFailureTolerance2, guiAbilityProvider2, guiActionExecutor, appLauncher, tracerConfig, (debugMode == null && (debugMode = taskConfig2.getDebugMode()) == null) ? false : debugMode.booleanValue(), a.T(taskConfig2.getMetadata(), taskConfig3.getMetadata()));
    }
}
