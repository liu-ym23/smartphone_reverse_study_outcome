package com.stepos.taskrobot.llmapi.stepfun;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.local.AIEngineInferenceEngine;
import com.stepos.taskrobot.llmapi.stepfun.logging.LogUtilILogger;
import com.stepos.taskrobot.llmapi.stepfun.util.AuthTokenCache;
import f6.C1438c;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import stepai.aios.guiagent.config.ActionConfig;
import stepai.aios.guiagent.config.EnhancedConfig;
import stepai.aios.guiagent.config.LlmConfig;
import stepai.aios.guiagent.config.RuntimeConfig;
import stepai.aios.guiagent.config.SessionConfig;
import stepai.aios.guiagent.config.TaskConfig;
import stepai.aios.guiagent.llm.cell.config.ModelConfigs;
import stepai.aios.guiagent.llm.local.LocalLlmService;
import stepai.aios.guiagent.tracer.GuiTracerConfig;
import stepai.android.logger.Logger;
import ua.C2052a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/GuiAgentInitializer;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "Lf6/c;", "taskRobotAccountUtil", "Lstepai/aios/guiagent/config/RuntimeConfig;", "createConfig", "(Landroid/content/Context;Lf6/c;)Lstepai/aios/guiagent/config/RuntimeConfig;", "LC7/r;", "initGuiAgent", "(Landroid/content/Context;Lf6/c;)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hostLoggerRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "initialized", "Z", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GuiAgentInitializer {
    public static final GuiAgentInitializer INSTANCE = new GuiAgentInitializer();
    private static final AtomicBoolean hostLoggerRegistered = new AtomicBoolean(false);
    private static volatile boolean initialized;

    private GuiAgentInitializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final RuntimeConfig createConfig(Context context, C1438c taskRobotAccountUtil) {
        if (taskRobotAccountUtil != null) {
            AuthTokenCache.INSTANCE.init(taskRobotAccountUtil);
        }
        GuiTracerConfig guiTracerConfig = new GuiTracerConfig(true, 0, 0, true, 6, null);
        EnhancedConfig enhancedConfig = null;
        Integer num = null;
        return new RuntimeConfig(new SessionConfig(50, 0, 30, 60000L, 2, null), 0, guiTracerConfig, new LlmConfig(new ZyqlStepService(context, taskRobotAccountUtil), new n(5), null, null, null, 28, null), new TaskConfig(new ActionConfig(1000L), enhancedConfig, 50, num, null, null, null, null, Boolean.FALSE, null, null, 1786, null), 3, 2, null == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap createConfig$lambda$1(Bitmap it) {
        kotlin.jvm.internal.k.f(it, "it");
        return it;
    }

    public static /* synthetic */ void initGuiAgent$default(GuiAgentInitializer guiAgentInitializer, Context context, C1438c c1438c, int i, Object obj) {
        if ((i & 2) != 0) {
            c1438c = null;
        }
        guiAgentInitializer.initGuiAgent(context, c1438c);
    }

    public final void initGuiAgent(Context context, C1438c taskRobotAccountUtil) {
        kotlin.jvm.internal.k.f(context, "context");
        if (initialized) {
            return;
        }
        try {
            if (hostLoggerRegistered.compareAndSet(false, true)) {
                Logger.INSTANCE.addLogger(LogUtilILogger.INSTANCE);
            }
            SystemSdkBridge.INSTANCE.init(context);
            LocalLlmService.INSTANCE.setDefaultEngine(new AIEngineInferenceEngine(context));
            ModelConfigs.instance.initialize(context);
            N9.j.H("GuiAgent 将使用系统模式执行器", "GuiAgentInitializer");
            C2052a.f6750a.a(context, createConfig(context, taskRobotAccountUtil));
            Config.INSTANCE.markGuiAgentInitialized();
            DebugInfoDialogListener.INSTANCE.init(context);
            initialized = true;
            N9.j.H("GuiAgent initialized successfully!", "GuiAgentInitializer");
        } catch (Exception e) {
            Logger.INSTANCE.e("GuiAgentInitializer", B7.a.n("Failed to initialize GuiAgent: ", e.getMessage(), "\n", Log.getStackTraceString(e)));
        }
    }
}
