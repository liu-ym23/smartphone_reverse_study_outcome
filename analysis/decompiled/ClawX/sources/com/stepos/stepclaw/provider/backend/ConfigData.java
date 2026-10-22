package com.stepos.stepclaw.provider.backend;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JN\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/stepos/stepclaw/provider/backend/ConfigData;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_PROVIDER, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_MODEL, ConfigIpcContract.KEY_BASE_URL, ConfigIpcContract.KEY_API_KEY, ConfigIpcContract.KEY_IMAGE_INPUT, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_API_FORMAT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getProvider", "()Ljava/lang/String;", "getModel", "getBaseUrl", "getApiKey", "getImageInput", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getApi", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/stepos/stepclaw/provider/backend/ConfigData;", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ConfigData {
    private final String api;
    private final String apiKey;
    private final String baseUrl;
    private final Boolean imageInput;
    private final String model;
    private final String provider;

    public ConfigData(String provider, String model, String baseUrl, String apiKey, Boolean bool, String str) {
        p.e(provider, "provider");
        p.e(model, "model");
        p.e(baseUrl, "baseUrl");
        p.e(apiKey, "apiKey");
        this.provider = provider;
        this.model = model;
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.imageInput = bool;
        this.api = str;
    }

    public static /* synthetic */ ConfigData copy$default(ConfigData configData, String str, String str2, String str3, String str4, Boolean bool, String str5, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = configData.provider;
        }
        if ((i8 & 2) != 0) {
            str2 = configData.model;
        }
        if ((i8 & 4) != 0) {
            str3 = configData.baseUrl;
        }
        if ((i8 & 8) != 0) {
            str4 = configData.apiKey;
        }
        if ((i8 & 16) != 0) {
            bool = configData.imageInput;
        }
        if ((i8 & 32) != 0) {
            str5 = configData.api;
        }
        Boolean bool2 = bool;
        String str6 = str5;
        return configData.copy(str, str2, str3, str4, bool2, str6);
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
    public final String getApiKey() {
        return this.apiKey;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getImageInput() {
        return this.imageInput;
    }

    /* renamed from: component6, reason: from getter */
    public final String getApi() {
        return this.api;
    }

    public final ConfigData copy(String provider, String model, String baseUrl, String apiKey, Boolean imageInput, String api) {
        p.e(provider, "provider");
        p.e(model, "model");
        p.e(baseUrl, "baseUrl");
        p.e(apiKey, "apiKey");
        return new ConfigData(provider, model, baseUrl, apiKey, imageInput, api);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigData)) {
            return false;
        }
        ConfigData configData = (ConfigData) other;
        return p.a(this.provider, configData.provider) && p.a(this.model, configData.model) && p.a(this.baseUrl, configData.baseUrl) && p.a(this.apiKey, configData.apiKey) && p.a(this.imageInput, configData.imageInput) && p.a(this.api, configData.api);
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

    public final Boolean getImageInput() {
        return this.imageInput;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getProvider() {
        return this.provider;
    }

    public int hashCode() {
        int iF = b.f(b.f(b.f(this.provider.hashCode() * 31, 31, this.model), 31, this.baseUrl), 31, this.apiKey);
        Boolean bool = this.imageInput;
        int iHashCode = (iF + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.api;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        String str = this.provider;
        String str2 = this.model;
        String str3 = this.baseUrl;
        String str4 = this.apiKey;
        Boolean bool = this.imageInput;
        String str5 = this.api;
        StringBuilder sbV = b.v("ConfigData(provider=", str, ", model=", str2, ", baseUrl=");
        b.A(sbV, str3, ", apiKey=", str4, ", imageInput=");
        sbV.append(bool);
        sbV.append(", api=");
        sbV.append(str5);
        sbV.append(")");
        return sbV.toString();
    }

    public /* synthetic */ ConfigData(String str, String str2, String str3, String str4, Boolean bool, String str5, int i8, i iVar) {
        this(str, str2, str3, str4, bool, (i8 & 32) != 0 ? null : str5);
    }
}
