package stepai.aios.guiagent.llm;

import H4.o;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003Jd\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006'"}, d2 = {"Lstepai/aios/guiagent/llm/ModelCapabilities;", "", "supportsVision", "", "supportsTools", "supportsStreaming", "maxTokens", "", "contextLength", "supportedImageFormats", "", "", "supportedTextFormats", AppAgent.CONSTRUCT, "(ZZZLjava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "getSupportsVision", "()Z", "getSupportsTools", "getSupportsStreaming", "getMaxTokens", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContextLength", "getSupportedImageFormats", "()Ljava/util/List;", "getSupportedTextFormats", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ZZZLjava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)Lstepai/aios/guiagent/llm/ModelCapabilities;", "equals", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ModelCapabilities {
    private final Integer contextLength;
    private final Integer maxTokens;
    private final List<String> supportedImageFormats;
    private final List<String> supportedTextFormats;
    private final boolean supportsStreaming;
    private final boolean supportsTools;
    private final boolean supportsVision;

    public ModelCapabilities() {
        this(false, false, false, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ModelCapabilities copy$default(ModelCapabilities modelCapabilities, boolean z10, boolean z11, boolean z12, Integer num, Integer num2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = modelCapabilities.supportsVision;
        }
        if ((i & 2) != 0) {
            z11 = modelCapabilities.supportsTools;
        }
        if ((i & 4) != 0) {
            z12 = modelCapabilities.supportsStreaming;
        }
        if ((i & 8) != 0) {
            num = modelCapabilities.maxTokens;
        }
        if ((i & 16) != 0) {
            num2 = modelCapabilities.contextLength;
        }
        if ((i & 32) != 0) {
            list = modelCapabilities.supportedImageFormats;
        }
        if ((i & 64) != 0) {
            list2 = modelCapabilities.supportedTextFormats;
        }
        List list3 = list;
        List list4 = list2;
        Integer num3 = num2;
        boolean z13 = z12;
        return modelCapabilities.copy(z10, z11, z13, num, num3, list3, list4);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSupportsVision() {
        return this.supportsVision;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSupportsTools() {
        return this.supportsTools;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSupportsStreaming() {
        return this.supportsStreaming;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getMaxTokens() {
        return this.maxTokens;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getContextLength() {
        return this.contextLength;
    }

    public final List<String> component6() {
        return this.supportedImageFormats;
    }

    public final List<String> component7() {
        return this.supportedTextFormats;
    }

    public final ModelCapabilities copy(boolean supportsVision, boolean supportsTools, boolean supportsStreaming, Integer maxTokens, Integer contextLength, List<String> supportedImageFormats, List<String> supportedTextFormats) {
        k.f(supportedImageFormats, "supportedImageFormats");
        k.f(supportedTextFormats, "supportedTextFormats");
        return new ModelCapabilities(supportsVision, supportsTools, supportsStreaming, maxTokens, contextLength, supportedImageFormats, supportedTextFormats);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelCapabilities)) {
            return false;
        }
        ModelCapabilities modelCapabilities = (ModelCapabilities) other;
        return this.supportsVision == modelCapabilities.supportsVision && this.supportsTools == modelCapabilities.supportsTools && this.supportsStreaming == modelCapabilities.supportsStreaming && k.b(this.maxTokens, modelCapabilities.maxTokens) && k.b(this.contextLength, modelCapabilities.contextLength) && k.b(this.supportedImageFormats, modelCapabilities.supportedImageFormats) && k.b(this.supportedTextFormats, modelCapabilities.supportedTextFormats);
    }

    public final Integer getContextLength() {
        return this.contextLength;
    }

    public final Integer getMaxTokens() {
        return this.maxTokens;
    }

    public final List<String> getSupportedImageFormats() {
        return this.supportedImageFormats;
    }

    public final List<String> getSupportedTextFormats() {
        return this.supportedTextFormats;
    }

    public final boolean getSupportsStreaming() {
        return this.supportsStreaming;
    }

    public final boolean getSupportsTools() {
        return this.supportsTools;
    }

    public final boolean getSupportsVision() {
        return this.supportsVision;
    }

    public int hashCode() {
        int iD = androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(Boolean.hashCode(this.supportsVision) * 31, 31, this.supportsTools), 31, this.supportsStreaming);
        Integer num = this.maxTokens;
        int iHashCode = (iD + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.contextLength;
        return this.supportedTextFormats.hashCode() + androidx.appfunctions.metadata.a.e(this.supportedImageFormats, (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31, 31);
    }

    public String toString() {
        boolean z10 = this.supportsVision;
        boolean z11 = this.supportsTools;
        boolean z12 = this.supportsStreaming;
        Integer num = this.maxTokens;
        Integer num2 = this.contextLength;
        List<String> list = this.supportedImageFormats;
        List<String> list2 = this.supportedTextFormats;
        StringBuilder sb = new StringBuilder("ModelCapabilities(supportsVision=");
        sb.append(z10);
        sb.append(", supportsTools=");
        sb.append(z11);
        sb.append(", supportsStreaming=");
        sb.append(z12);
        sb.append(", maxTokens=");
        sb.append(num);
        sb.append(", contextLength=");
        sb.append(num2);
        sb.append(", supportedImageFormats=");
        sb.append(list);
        sb.append(", supportedTextFormats=");
        return androidx.appfunctions.metadata.a.q(sb, list2, ")");
    }

    public ModelCapabilities(boolean z10, boolean z11, boolean z12, Integer num, Integer num2, List list, List list2, int i, e eVar) {
        this((i & 1) != 0 ? false : z10, (i & 2) != 0 ? false : z11, (i & 4) != 0 ? true : z12, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? EmptyList.f4893a : list, (i & 64) != 0 ? o.N("text", "json_object") : list2);
    }

    public ModelCapabilities(boolean z10, boolean z11, boolean z12, Integer num, Integer num2, List<String> supportedImageFormats, List<String> supportedTextFormats) {
        k.f(supportedImageFormats, "supportedImageFormats");
        k.f(supportedTextFormats, "supportedTextFormats");
        this.supportsVision = z10;
        this.supportsTools = z11;
        this.supportsStreaming = z12;
        this.maxTokens = num;
        this.contextLength = num2;
        this.supportedImageFormats = supportedImageFormats;
        this.supportedTextFormats = supportedTextFormats;
    }
}
