package stepai.aios.guiagent.llm.cell.config;

import android.content.Context;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import stepai.aios.guiagent.config.LlmConfig;
import stepai.aios.guiagent.llm.parser.IModelCell;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0018\u0010\u0011J\u001f\u0010\u001b\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u001d\u0010\u0011J\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eH&¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eH&¢\u0006\u0004\b!\u0010 J\u001b\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\"H&¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eH&¢\u0006\u0004\b%\u0010 J\u000f\u0010'\u001a\u00020&H&¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b)\u0010\u0016J\u0017\u0010*\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b*\u0010\u0016R\u0014\u0010-\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00061À\u0006\u0003"}, d2 = {"Lstepai/aios/guiagent/llm/cell/config/IModelConfig;", "", "Landroid/content/Context;", "context", "LC7/r;", McpSchema.METHOD_INITIALIZE, "(Landroid/content/Context;)V", "", "modelId", "setCurrentModel", "(Ljava/lang/String;)V", "Lstepai/aios/guiagent/llm/parser/IModelCell;", "modelCell", "addModel", "(Ljava/lang/String;Lstepai/aios/guiagent/llm/parser/IModelCell;)V", "modelCellType", "createModelCellByType", "(Ljava/lang/String;)Lstepai/aios/guiagent/llm/parser/IModelCell;", "", "updateModelCell", "(Ljava/lang/String;Lstepai/aios/guiagent/llm/parser/IModelCell;)Z", "hasModel", "(Ljava/lang/String;)Z", "getModelCellByModelId", "resolveModelCellForTask", "Lstepai/aios/guiagent/config/LlmConfig;", "baseLlmConfig", "resolveLlmConfigForTask", "(Ljava/lang/String;Lstepai/aios/guiagent/config/LlmConfig;)Lstepai/aios/guiagent/config/LlmConfig;", "getModelCellByModelCellType", "", "getAllModelIds", "()Ljava/util/List;", "getAllModelCellTypes", "", "getAllConfiguredModels", "()Ljava/util/Map;", "getAllModelCells", "", "removeAllCustomModels", "()I", "removeCustomModelsById", "isCustomModel", "getCurrentModelId", "()Ljava/lang/String;", "currentModelId", "getCurrentModelCell", "()Lstepai/aios/guiagent/llm/parser/IModelCell;", "currentModelCell", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IModelConfig {
    void addModel(String modelId, IModelCell modelCell);

    IModelCell createModelCellByType(String modelCellType);

    Map<String, IModelCell> getAllConfiguredModels();

    List<String> getAllModelCellTypes();

    List<IModelCell> getAllModelCells();

    List<String> getAllModelIds();

    IModelCell getCurrentModelCell();

    String getCurrentModelId();

    IModelCell getModelCellByModelCellType(String modelCellType);

    IModelCell getModelCellByModelId(String modelId);

    boolean hasModel(String modelId);

    void initialize(Context context);

    boolean isCustomModel(String modelId);

    int removeAllCustomModels();

    boolean removeCustomModelsById(String modelId);

    LlmConfig resolveLlmConfigForTask(String modelId, LlmConfig baseLlmConfig);

    IModelCell resolveModelCellForTask(String modelId);

    void setCurrentModel(String modelId);

    boolean updateModelCell(String modelId, IModelCell modelCell);
}
