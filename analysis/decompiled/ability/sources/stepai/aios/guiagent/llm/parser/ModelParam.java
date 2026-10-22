package stepai.aios.guiagent.llm.parser;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J8\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lstepai/aios/guiagent/llm/parser/ModelParam;", "", LlmRuntimeArgsBundle.KEY_TEMPERATURE, "", "topP", "maxToken", "", "frequencyPenalty", AppAgent.CONSTRUCT, "(FFILjava/lang/Float;)V", "getTemperature", "()F", "getTopP", "getMaxToken", "()I", "getFrequencyPenalty", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "copy", "(FFILjava/lang/Float;)Lstepai/aios/guiagent/llm/parser/ModelParam;", "equals", "", "other", "hashCode", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ModelParam {
    private final Float frequencyPenalty;
    private final int maxToken;
    private final float temperature;
    private final float topP;

    public ModelParam(float f, float f7, int i, Float f9) {
        this.temperature = f;
        this.topP = f7;
        this.maxToken = i;
        this.frequencyPenalty = f9;
    }

    public static /* synthetic */ ModelParam copy$default(ModelParam modelParam, float f, float f7, int i, Float f9, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            f = modelParam.temperature;
        }
        if ((i6 & 2) != 0) {
            f7 = modelParam.topP;
        }
        if ((i6 & 4) != 0) {
            i = modelParam.maxToken;
        }
        if ((i6 & 8) != 0) {
            f9 = modelParam.frequencyPenalty;
        }
        return modelParam.copy(f, f7, i, f9);
    }

    /* renamed from: component1, reason: from getter */
    public final float getTemperature() {
        return this.temperature;
    }

    /* renamed from: component2, reason: from getter */
    public final float getTopP() {
        return this.topP;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMaxToken() {
        return this.maxToken;
    }

    /* renamed from: component4, reason: from getter */
    public final Float getFrequencyPenalty() {
        return this.frequencyPenalty;
    }

    public final ModelParam copy(float temperature, float topP, int maxToken, Float frequencyPenalty) {
        return new ModelParam(temperature, topP, maxToken, frequencyPenalty);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelParam)) {
            return false;
        }
        ModelParam modelParam = (ModelParam) other;
        return Float.compare(this.temperature, modelParam.temperature) == 0 && Float.compare(this.topP, modelParam.topP) == 0 && this.maxToken == modelParam.maxToken && k.b(this.frequencyPenalty, modelParam.frequencyPenalty);
    }

    public final Float getFrequencyPenalty() {
        return this.frequencyPenalty;
    }

    public final int getMaxToken() {
        return this.maxToken;
    }

    public final float getTemperature() {
        return this.temperature;
    }

    public final float getTopP() {
        return this.topP;
    }

    public int hashCode() {
        int iA = a.a(this.maxToken, androidx.appfunctions.metadata.a.b(this.topP, Float.hashCode(this.temperature) * 31, 31), 31);
        Float f = this.frequencyPenalty;
        return iA + (f == null ? 0 : f.hashCode());
    }

    public String toString() {
        return "ModelParam(temperature=" + this.temperature + ", topP=" + this.topP + ", maxToken=" + this.maxToken + ", frequencyPenalty=" + this.frequencyPenalty + ")";
    }

    public /* synthetic */ ModelParam(float f, float f7, int i, Float f9, int i6, e eVar) {
        this(f, f7, i, (i6 & 8) != 0 ? null : f9);
    }
}
