package stepai.aios.guiagent.llm.cell.config;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lstepai/aios/guiagent/llm/cell/config/ModelConfigs;", "", AppAgent.CONSTRUCT, "()V", "instance", "Lstepai/aios/guiagent/llm/cell/config/IModelConfig;", "MODEL_ID_LOCAL", "", "DEFAULT_MODEL_ID", "getDEFAULT_MODEL_ID", "()Ljava/lang/String;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ModelConfigs {
    public static final String MODEL_ID_LOCAL = "local-vlm";
    public static final ModelConfigs INSTANCE = new ModelConfigs();
    public static final IModelConfig instance = ModelConfigInner.INSTANCE;
    private static final String DEFAULT_MODEL_ID = ModelCatalog.INSTANCE.getDEFAULT_MODEL_ID();

    private ModelConfigs() {
    }

    public final String getDEFAULT_MODEL_ID() {
        return DEFAULT_MODEL_ID;
    }
}
