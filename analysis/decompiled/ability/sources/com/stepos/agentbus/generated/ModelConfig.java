package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentbus/generated/ModelConfig;", "", "provider", "", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "baseUrl", "api", "apiKey", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProvider", "()Ljava/lang/String;", "getModel", "getBaseUrl", "getApi", "getApiKey", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ModelConfig {
    private final String api;
    private final String apiKey;
    private final String baseUrl;
    private final String model;
    private final String provider;

    public ModelConfig(String provider, String model, String str, String str2, String str3) {
        k.f(provider, "provider");
        k.f(model, "model");
        this.provider = provider;
        this.model = model;
        this.baseUrl = str;
        this.api = str2;
        this.apiKey = str3;
    }

    public static /* synthetic */ ModelConfig copy$default(ModelConfig modelConfig, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelConfig.provider;
        }
        if ((i & 2) != 0) {
            str2 = modelConfig.model;
        }
        if ((i & 4) != 0) {
            str3 = modelConfig.baseUrl;
        }
        if ((i & 8) != 0) {
            str4 = modelConfig.api;
        }
        if ((i & 16) != 0) {
            str5 = modelConfig.apiKey;
        }
        String str6 = str5;
        String str7 = str3;
        return modelConfig.copy(str, str2, str7, str4, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component2, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getApi() {
        return this.api;
    }

    /* renamed from: component5, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    public final ModelConfig copy(String provider, String model, String baseUrl, String api, String apiKey) {
        k.f(provider, "provider");
        k.f(model, "model");
        return new ModelConfig(provider, model, baseUrl, api, apiKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelConfig)) {
            return false;
        }
        ModelConfig modelConfig = (ModelConfig) other;
        return k.b(this.provider, modelConfig.provider) && k.b(this.model, modelConfig.model) && k.b(this.baseUrl, modelConfig.baseUrl) && k.b(this.api, modelConfig.api) && k.b(this.apiKey, modelConfig.apiKey);
    }

    public final String getApi() {
        return this.api;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getProvider() {
        return this.provider;
    }

    public int hashCode() {
        int iC = B7.a.c(this.provider.hashCode() * 31, 31, this.model);
        String str = this.baseUrl;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.api;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.apiKey;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        String str = this.provider;
        String str2 = this.model;
        String str3 = this.baseUrl;
        String str4 = this.api;
        String str5 = this.apiKey;
        StringBuilder sbW = B7.a.w("ModelConfig(provider=", str, ", model=", str2, ", baseUrl=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", api=", str4, ", apiKey=");
        return B7.a.q(sbW, str5, ")");
    }

    public /* synthetic */ ModelConfig(String str, String str2, String str3, String str4, String str5, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }
}
