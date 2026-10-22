package stepai.aios.guiagent.config;

import B7.a;
import S7.k;
import android.graphics.Bitmap;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import stepai.aios.guiagent.llm.LlmService;
import stepai.aios.guiagent.llm.cell.config.ModelConfigs;
import stepai.aios.guiagent.llm.parser.IModelCell;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018JN\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0014J\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0010R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010\u0014R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b*\u0010\u0016R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010+\u001a\u0004\b,\u0010\u0018¨\u0006-"}, d2 = {"Lstepai/aios/guiagent/config/LlmConfig;", "", "Lstepai/aios/guiagent/llm/LlmService;", "llmService", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "compressor", "", "modelId", "Lstepai/aios/guiagent/llm/parser/IModelCell;", "modelCell", "Lstepai/aios/guiagent/config/StateCompressionConfig;", "stateCompressionConfig", AppAgent.CONSTRUCT, "(Lstepai/aios/guiagent/llm/LlmService;LS7/k;Ljava/lang/String;Lstepai/aios/guiagent/llm/parser/IModelCell;Lstepai/aios/guiagent/config/StateCompressionConfig;)V", "component1", "()Lstepai/aios/guiagent/llm/LlmService;", "component2", "()LS7/k;", "component3", "()Ljava/lang/String;", "component4", "()Lstepai/aios/guiagent/llm/parser/IModelCell;", "component5", "()Lstepai/aios/guiagent/config/StateCompressionConfig;", "copy", "(Lstepai/aios/guiagent/llm/LlmService;LS7/k;Ljava/lang/String;Lstepai/aios/guiagent/llm/parser/IModelCell;Lstepai/aios/guiagent/config/StateCompressionConfig;)Lstepai/aios/guiagent/config/LlmConfig;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lstepai/aios/guiagent/llm/LlmService;", "getLlmService", "LS7/k;", "getCompressor", "Ljava/lang/String;", "getModelId", "Lstepai/aios/guiagent/llm/parser/IModelCell;", "getModelCell", "Lstepai/aios/guiagent/config/StateCompressionConfig;", "getStateCompressionConfig", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LlmConfig {
    private final k compressor;
    private final LlmService llmService;
    private final IModelCell modelCell;
    private final String modelId;
    private final StateCompressionConfig stateCompressionConfig;

    public LlmConfig(LlmService llmService, k compressor, String modelId, IModelCell modelCell, StateCompressionConfig stateCompressionConfig) {
        kotlin.jvm.internal.k.f(llmService, "llmService");
        kotlin.jvm.internal.k.f(compressor, "compressor");
        kotlin.jvm.internal.k.f(modelId, "modelId");
        kotlin.jvm.internal.k.f(modelCell, "modelCell");
        kotlin.jvm.internal.k.f(stateCompressionConfig, "stateCompressionConfig");
        this.llmService = llmService;
        this.compressor = compressor;
        this.modelId = modelId;
        this.modelCell = modelCell;
        this.stateCompressionConfig = stateCompressionConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap _init_$lambda$0(Bitmap it) {
        kotlin.jvm.internal.k.f(it, "it");
        return it;
    }

    public static /* synthetic */ LlmConfig copy$default(LlmConfig llmConfig, LlmService llmService, k kVar, String str, IModelCell iModelCell, StateCompressionConfig stateCompressionConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            llmService = llmConfig.llmService;
        }
        if ((i & 2) != 0) {
            kVar = llmConfig.compressor;
        }
        if ((i & 4) != 0) {
            str = llmConfig.modelId;
        }
        if ((i & 8) != 0) {
            iModelCell = llmConfig.modelCell;
        }
        if ((i & 16) != 0) {
            stateCompressionConfig = llmConfig.stateCompressionConfig;
        }
        StateCompressionConfig stateCompressionConfig2 = stateCompressionConfig;
        String str2 = str;
        return llmConfig.copy(llmService, kVar, str2, iModelCell, stateCompressionConfig2);
    }

    /* renamed from: component1, reason: from getter */
    public final LlmService getLlmService() {
        return this.llmService;
    }

    /* renamed from: component2, reason: from getter */
    public final k getCompressor() {
        return this.compressor;
    }

    /* renamed from: component3, reason: from getter */
    public final String getModelId() {
        return this.modelId;
    }

    /* renamed from: component4, reason: from getter */
    public final IModelCell getModelCell() {
        return this.modelCell;
    }

    /* renamed from: component5, reason: from getter */
    public final StateCompressionConfig getStateCompressionConfig() {
        return this.stateCompressionConfig;
    }

    public final LlmConfig copy(LlmService llmService, k compressor, String modelId, IModelCell modelCell, StateCompressionConfig stateCompressionConfig) {
        kotlin.jvm.internal.k.f(llmService, "llmService");
        kotlin.jvm.internal.k.f(compressor, "compressor");
        kotlin.jvm.internal.k.f(modelId, "modelId");
        kotlin.jvm.internal.k.f(modelCell, "modelCell");
        kotlin.jvm.internal.k.f(stateCompressionConfig, "stateCompressionConfig");
        return new LlmConfig(llmService, compressor, modelId, modelCell, stateCompressionConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LlmConfig)) {
            return false;
        }
        LlmConfig llmConfig = (LlmConfig) other;
        return kotlin.jvm.internal.k.b(this.llmService, llmConfig.llmService) && kotlin.jvm.internal.k.b(this.compressor, llmConfig.compressor) && kotlin.jvm.internal.k.b(this.modelId, llmConfig.modelId) && kotlin.jvm.internal.k.b(this.modelCell, llmConfig.modelCell) && kotlin.jvm.internal.k.b(this.stateCompressionConfig, llmConfig.stateCompressionConfig);
    }

    public final k getCompressor() {
        return this.compressor;
    }

    public final LlmService getLlmService() {
        return this.llmService;
    }

    public final IModelCell getModelCell() {
        return this.modelCell;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final StateCompressionConfig getStateCompressionConfig() {
        return this.stateCompressionConfig;
    }

    public int hashCode() {
        return this.stateCompressionConfig.hashCode() + ((this.modelCell.hashCode() + a.c((this.compressor.hashCode() + (this.llmService.hashCode() * 31)) * 31, 31, this.modelId)) * 31);
    }

    public String toString() {
        return "LlmConfig(llmService=" + this.llmService + ", compressor=" + this.compressor + ", modelId=" + this.modelId + ", modelCell=" + this.modelCell + ", stateCompressionConfig=" + this.stateCompressionConfig + ")";
    }

    public /* synthetic */ LlmConfig(LlmService llmService, k kVar, String str, IModelCell iModelCell, StateCompressionConfig stateCompressionConfig, int i, e eVar) {
        this(llmService, (i & 2) != 0 ? new m5.a(13) : kVar, (i & 4) != 0 ? ModelConfigs.instance.getCurrentModelId() : str, (i & 8) != 0 ? ModelConfigs.instance.getCurrentModelCell() : iModelCell, (i & 16) != 0 ? new StateCompressionConfig(false, 0, 0, 0, 15, null) : stateCompressionConfig);
    }
}
