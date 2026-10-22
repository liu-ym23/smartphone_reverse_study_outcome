package stepai.aios.guiagent.llm.local;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lstepai/aios/guiagent/llm/local/LocalInferenceConfig;", "", "maxNewTokens", "", LlmRuntimeArgsBundle.KEY_TEMPERATURE, "", "topP", AppAgent.CONSTRUCT, "(IFF)V", "getMaxNewTokens", "()I", "getTemperature", "()F", "getTopP", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LocalInferenceConfig {
    private final int maxNewTokens;
    private final float temperature;
    private final float topP;

    public LocalInferenceConfig() {
        this(0, 0.0f, 0.0f, 7, null);
    }

    public static /* synthetic */ LocalInferenceConfig copy$default(LocalInferenceConfig localInferenceConfig, int i, float f, float f7, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = localInferenceConfig.maxNewTokens;
        }
        if ((i6 & 2) != 0) {
            f = localInferenceConfig.temperature;
        }
        if ((i6 & 4) != 0) {
            f7 = localInferenceConfig.topP;
        }
        return localInferenceConfig.copy(i, f, f7);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMaxNewTokens() {
        return this.maxNewTokens;
    }

    /* renamed from: component2, reason: from getter */
    public final float getTemperature() {
        return this.temperature;
    }

    /* renamed from: component3, reason: from getter */
    public final float getTopP() {
        return this.topP;
    }

    public final LocalInferenceConfig copy(int maxNewTokens, float temperature, float topP) {
        return new LocalInferenceConfig(maxNewTokens, temperature, topP);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalInferenceConfig)) {
            return false;
        }
        LocalInferenceConfig localInferenceConfig = (LocalInferenceConfig) other;
        return this.maxNewTokens == localInferenceConfig.maxNewTokens && Float.compare(this.temperature, localInferenceConfig.temperature) == 0 && Float.compare(this.topP, localInferenceConfig.topP) == 0;
    }

    public final int getMaxNewTokens() {
        return this.maxNewTokens;
    }

    public final float getTemperature() {
        return this.temperature;
    }

    public final float getTopP() {
        return this.topP;
    }

    public int hashCode() {
        return Float.hashCode(this.topP) + a.b(this.temperature, Integer.hashCode(this.maxNewTokens) * 31, 31);
    }

    public String toString() {
        int i = this.maxNewTokens;
        float f = this.temperature;
        float f7 = this.topP;
        StringBuilder sb = new StringBuilder("LocalInferenceConfig(maxNewTokens=");
        sb.append(i);
        sb.append(", temperature=");
        sb.append(f);
        sb.append(", topP=");
        return b.u(sb, ")", f7);
    }

    public LocalInferenceConfig(int i, float f, float f7) {
        this.maxNewTokens = i;
        this.temperature = f;
        this.topP = f7;
    }

    public /* synthetic */ LocalInferenceConfig(int i, float f, float f7, int i6, e eVar) {
        this((i6 & 1) != 0 ? 2048 : i, (i6 & 2) != 0 ? 0.0f : f, (i6 & 4) != 0 ? 0.7f : f7);
    }
}
