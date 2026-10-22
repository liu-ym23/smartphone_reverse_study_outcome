package stepai.aios.guiagent.llm.cell;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import j9.t;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.llm.cell.config.ModelCatalog;
import stepai.aios.guiagent.llm.config.LlmMessageBuilder;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00168\u0014X\u0094D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lstepai/aios/guiagent/llm/cell/LocalCloudModelCell;", "Lstepai/aios/guiagent/llm/cell/LocalModelCell;", AppAgent.CONSTRUCT, "()V", "", "imageBase64", "toImageDataUrl", "(Ljava/lang/String;)Ljava/lang/String;", "Lstepai/aios/guiagent/llm/config/LlmMessageBuilder;", "builder", "imageUrl", "LC7/r;", "appendImageContent", "(Lstepai/aios/guiagent/llm/config/LlmMessageBuilder;Ljava/lang/String;Ljava/lang/String;)V", HintConstants.AUTOFILL_HINT_NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "desc", "getDesc", "type", "getType", "", "userImageBeforeText", "Z", "getUserImageBeforeText", "()Z", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocalCloudModelCell extends LocalModelCell {
    private final String name = "Local-VLM-CloudTest";
    private final String desc = "端侧视觉语言模型云测配置";
    private final String type = ModelCatalog.MODEL_CELL_TYPE_LOCAL_CLOUD_TEST;
    private final boolean userImageBeforeText = true;

    private final String toImageDataUrl(String imageBase64) {
        return t.e0(imageBase64, "data:image", true) ? imageBase64 : "data:image/jpeg;base64,".concat(imageBase64);
    }

    @Override // stepai.aios.guiagent.llm.cell.LocalModelCell
    public void appendImageContent(LlmMessageBuilder builder, String imageBase64, String imageUrl) {
        k.f(builder, "builder");
        if (imageUrl != null && !m.s0(imageUrl)) {
            builder.image(imageUrl);
        } else {
            if (imageBase64 == null || m.s0(imageBase64)) {
                return;
            }
            builder.image(toImageDataUrl(imageBase64));
        }
    }

    @Override // stepai.aios.guiagent.llm.cell.LocalModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public String getDesc() {
        return this.desc;
    }

    @Override // stepai.aios.guiagent.llm.cell.LocalModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public String getName() {
        return this.name;
    }

    @Override // stepai.aios.guiagent.llm.cell.LocalModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public String getType() {
        return this.type;
    }

    @Override // stepai.aios.guiagent.llm.cell.LocalModelCell
    public boolean getUserImageBeforeText() {
        return this.userImageBeforeText;
    }
}
