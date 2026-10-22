package ua;

import N9.j;
import android.content.Context;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.LlmConfig;
import stepai.aios.guiagent.config.RuntimeConfig;
import stepai.aios.guiagent.llm.cell.config.IModelConfig;
import stepai.aios.guiagent.llm.cell.config.ModelConfigs;
import stepai.aios.guiagent.llm.parser.IModelCell;
import stepai.android.mindx.client.StepLLMClient;
import stepai.android.mindx.client.config.ClientConfig;

/* renamed from: ua.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2052a {

    /* renamed from: a, reason: collision with root package name */
    public static final C2052a f6750a = new C2052a();
    public static boolean b;
    public static stepai.aios.guiagent.runtime.a c;

    public final void a(Context context, RuntimeConfig config) {
        k.f(config, "config");
        synchronized (this) {
            if (b) {
                j.J("GuiAgentManager already initialized", "GuiAgentManager");
                return;
            }
            c = new stepai.aios.guiagent.runtime.a(context, config, new androidx.compose.runtime.changelist.a(3));
            b = true;
            IModelConfig iModelConfig = ModelConfigs.instance;
            iModelConfig.initialize(context);
            stepai.aios.guiagent.runtime.a aVar = c;
            if (aVar == null) {
                throw new IllegalStateException("GuiAgentManager is not initialized");
            }
            RuntimeConfig runtimeConfig = aVar.f6128a;
            LlmConfig llmConfig = runtimeConfig.getLlmConfig();
            if (llmConfig != null) {
                String currentModelId = iModelConfig.getCurrentModelId();
                IModelCell currentModelCell = iModelConfig.getCurrentModelCell();
                LlmConfig llmConfigCopy$default = LlmConfig.copy$default(llmConfig, null, null, currentModelId, currentModelCell, null, 19, null);
                stepai.aios.guiagent.runtime.a aVar2 = c;
                if (aVar2 == null) {
                    throw new IllegalStateException("GuiAgentManager is not initialized");
                }
                aVar2.p(RuntimeConfig.copy$default(runtimeConfig, null, 0, null, llmConfigCopy$default, null, 0, 55, null));
                j.H("初始化完成后同步当前模型到 runtime: modelId=" + currentModelId + ", modelCell=" + currentModelCell.getName(), "GuiAgentManager");
            }
            StepLLMClient stepLLMClient = StepLLMClient.INSTANCE;
            stepLLMClient.bindService(context);
            stepLLMClient.updateSetting(new ClientConfig(120000L));
            j.H("GuiAgentManager initialized", "GuiAgentManager");
        }
    }
}
