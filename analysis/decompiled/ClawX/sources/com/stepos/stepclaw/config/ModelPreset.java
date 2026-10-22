package com.stepos.stepclaw.config;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/config/ModelPreset;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_MODEL, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_PROVIDER, ConfigIpcContract.KEY_BASE_URL, ConfigIpcContract.KEY_API_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "getProvider", "getBaseUrl", "getApiKey", "component1", "component2", "component3", "component4", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ModelPreset {
    private final String apiKey;
    private final String baseUrl;
    private final String model;
    private final String provider;

    public ModelPreset(String model, String provider, String baseUrl, String apiKey) {
        p.e(model, "model");
        p.e(provider, "provider");
        p.e(baseUrl, "baseUrl");
        p.e(apiKey, "apiKey");
        this.model = model;
        this.provider = provider;
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    public static /* synthetic */ ModelPreset copy$default(ModelPreset modelPreset, String str, String str2, String str3, String str4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = modelPreset.model;
        }
        if ((i8 & 2) != 0) {
            str2 = modelPreset.provider;
        }
        if ((i8 & 4) != 0) {
            str3 = modelPreset.baseUrl;
        }
        if ((i8 & 8) != 0) {
            str4 = modelPreset.apiKey;
        }
        return modelPreset.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component2, reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    public final ModelPreset copy(String model, String provider, String baseUrl, String apiKey) {
        p.e(model, "model");
        p.e(provider, "provider");
        p.e(baseUrl, "baseUrl");
        p.e(apiKey, "apiKey");
        return new ModelPreset(model, provider, baseUrl, apiKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelPreset)) {
            return false;
        }
        ModelPreset modelPreset = (ModelPreset) other;
        return p.a(this.model, modelPreset.model) && p.a(this.provider, modelPreset.provider) && p.a(this.baseUrl, modelPreset.baseUrl) && p.a(this.apiKey, modelPreset.apiKey);
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
        return this.apiKey.hashCode() + b.f(b.f(this.model.hashCode() * 31, 31, this.provider), 31, this.baseUrl);
    }

    public String toString() {
        String str = this.model;
        String str2 = this.provider;
        String str3 = this.baseUrl;
        String str4 = this.apiKey;
        StringBuilder sbV = b.v("ModelPreset(model=", str, ", provider=", str2, ", baseUrl=");
        sbV.append(str3);
        sbV.append(", apiKey=");
        sbV.append(str4);
        sbV.append(")");
        return sbV.toString();
    }
}
