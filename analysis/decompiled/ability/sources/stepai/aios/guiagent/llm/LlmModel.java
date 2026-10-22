package stepai.aios.guiagent.llm;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003JP\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lstepai/aios/guiagent/llm/LlmModel;", "", "id", "", HintConstants.AUTOFILL_HINT_NAME, "description", "maxContextLength", "", "supportsStreaming", "", "capabilities", "Lstepai/aios/guiagent/llm/ModelCapabilities;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLstepai/aios/guiagent/llm/ModelCapabilities;)V", "getId", "()Ljava/lang/String;", "getName", "getDescription", "getMaxContextLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSupportsStreaming", "()Z", "getCapabilities", "()Lstepai/aios/guiagent/llm/ModelCapabilities;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLstepai/aios/guiagent/llm/ModelCapabilities;)Lstepai/aios/guiagent/llm/LlmModel;", "equals", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LlmModel {
    private final ModelCapabilities capabilities;
    private final String description;
    private final String id;
    private final Integer maxContextLength;
    private final String name;
    private final boolean supportsStreaming;

    public LlmModel(String id, String name, String str, Integer num, boolean z10, ModelCapabilities modelCapabilities) {
        k.f(id, "id");
        k.f(name, "name");
        this.id = id;
        this.name = name;
        this.description = str;
        this.maxContextLength = num;
        this.supportsStreaming = z10;
        this.capabilities = modelCapabilities;
    }

    public static /* synthetic */ LlmModel copy$default(LlmModel llmModel, String str, String str2, String str3, Integer num, boolean z10, ModelCapabilities modelCapabilities, int i, Object obj) {
        if ((i & 1) != 0) {
            str = llmModel.id;
        }
        if ((i & 2) != 0) {
            str2 = llmModel.name;
        }
        if ((i & 4) != 0) {
            str3 = llmModel.description;
        }
        if ((i & 8) != 0) {
            num = llmModel.maxContextLength;
        }
        if ((i & 16) != 0) {
            z10 = llmModel.supportsStreaming;
        }
        if ((i & 32) != 0) {
            modelCapabilities = llmModel.capabilities;
        }
        boolean z11 = z10;
        ModelCapabilities modelCapabilities2 = modelCapabilities;
        return llmModel.copy(str, str2, str3, num, z11, modelCapabilities2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getMaxContextLength() {
        return this.maxContextLength;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getSupportsStreaming() {
        return this.supportsStreaming;
    }

    /* renamed from: component6, reason: from getter */
    public final ModelCapabilities getCapabilities() {
        return this.capabilities;
    }

    public final LlmModel copy(String id, String name, String description, Integer maxContextLength, boolean supportsStreaming, ModelCapabilities capabilities) {
        k.f(id, "id");
        k.f(name, "name");
        return new LlmModel(id, name, description, maxContextLength, supportsStreaming, capabilities);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LlmModel)) {
            return false;
        }
        LlmModel llmModel = (LlmModel) other;
        return k.b(this.id, llmModel.id) && k.b(this.name, llmModel.name) && k.b(this.description, llmModel.description) && k.b(this.maxContextLength, llmModel.maxContextLength) && this.supportsStreaming == llmModel.supportsStreaming && k.b(this.capabilities, llmModel.capabilities);
    }

    public final ModelCapabilities getCapabilities() {
        return this.capabilities;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getMaxContextLength() {
        return this.maxContextLength;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getSupportsStreaming() {
        return this.supportsStreaming;
    }

    public int hashCode() {
        int iC = B7.a.c(this.id.hashCode() * 31, 31, this.name);
        String str = this.description;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.maxContextLength;
        int iD = androidx.appfunctions.metadata.a.d((iHashCode + (num == null ? 0 : num.hashCode())) * 31, 31, this.supportsStreaming);
        ModelCapabilities modelCapabilities = this.capabilities;
        return iD + (modelCapabilities != null ? modelCapabilities.hashCode() : 0);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.name;
        String str3 = this.description;
        Integer num = this.maxContextLength;
        boolean z10 = this.supportsStreaming;
        ModelCapabilities modelCapabilities = this.capabilities;
        StringBuilder sbW = B7.a.w("LlmModel(id=", str, ", name=", str2, ", description=");
        sbW.append(str3);
        sbW.append(", maxContextLength=");
        sbW.append(num);
        sbW.append(", supportsStreaming=");
        sbW.append(z10);
        sbW.append(", capabilities=");
        sbW.append(modelCapabilities);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ LlmModel(String str, String str2, String str3, Integer num, boolean z10, ModelCapabilities modelCapabilities, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? true : z10, (i & 32) != 0 ? null : modelCapabilities);
    }
}
