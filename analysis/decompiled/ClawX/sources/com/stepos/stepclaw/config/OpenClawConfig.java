package com.stepos.stepclaw.config;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m0.f;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003JX\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0019\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/stepos/stepclaw/config/OpenClawConfig;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_API_KEY, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_MODEL, ConfigIpcContract.KEY_PROVIDER, ConfigIpcContract.KEY_BASE_URL, ConfigIpcContract.KEY_PORT, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_IMAGE_INPUT, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_API_FORMAT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "getModel", "getProvider", "getBaseUrl", "getPort", "()I", "getImageInput", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getApi", "isValid", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/String;)Lcom/stepos/stepclaw/config/OpenClawConfig;", "equals", "other", "hashCode", "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class OpenClawConfig {
    private final String api;
    private final String apiKey;
    private final String baseUrl;
    private final Boolean imageInput;
    private final String model;
    private final int port;
    private final String provider;

    public OpenClawConfig() {
        this(null, null, null, null, 0, null, null, 127, null);
    }

    public static /* synthetic */ OpenClawConfig copy$default(OpenClawConfig openClawConfig, String str, String str2, String str3, String str4, int i8, Boolean bool, String str5, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = openClawConfig.apiKey;
        }
        if ((i9 & 2) != 0) {
            str2 = openClawConfig.model;
        }
        if ((i9 & 4) != 0) {
            str3 = openClawConfig.provider;
        }
        if ((i9 & 8) != 0) {
            str4 = openClawConfig.baseUrl;
        }
        if ((i9 & 16) != 0) {
            i8 = openClawConfig.port;
        }
        if ((i9 & 32) != 0) {
            bool = openClawConfig.imageInput;
        }
        if ((i9 & 64) != 0) {
            str5 = openClawConfig.api;
        }
        Boolean bool2 = bool;
        String str6 = str5;
        int i10 = i8;
        String str7 = str3;
        return openClawConfig.copy(str, str2, str7, str4, i10, bool2, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component3, reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getImageInput() {
        return this.imageInput;
    }

    /* renamed from: component7, reason: from getter */
    public final String getApi() {
        return this.api;
    }

    public final OpenClawConfig copy(String apiKey, String model, String provider, String baseUrl, int port, Boolean imageInput, String api) {
        p.e(apiKey, "apiKey");
        p.e(model, "model");
        p.e(provider, "provider");
        p.e(baseUrl, "baseUrl");
        return new OpenClawConfig(apiKey, model, provider, baseUrl, port, imageInput, api);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenClawConfig)) {
            return false;
        }
        OpenClawConfig openClawConfig = (OpenClawConfig) other;
        return p.a(this.apiKey, openClawConfig.apiKey) && p.a(this.model, openClawConfig.model) && p.a(this.provider, openClawConfig.provider) && p.a(this.baseUrl, openClawConfig.baseUrl) && this.port == openClawConfig.port && p.a(this.imageInput, openClawConfig.imageInput) && p.a(this.api, openClawConfig.api);
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

    public final int getPort() {
        return this.port;
    }

    public final String getProvider() {
        return this.provider;
    }

    public int hashCode() {
        int iC = b.C(this.port, b.f(b.f(b.f(this.apiKey.hashCode() * 31, 31, this.model), 31, this.provider), 31, this.baseUrl), 31);
        Boolean bool = this.imageInput;
        int iHashCode = (iC + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.api;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final boolean isValid() {
        return !n.t1(this.apiKey);
    }

    public String toString() {
        String str = this.apiKey;
        String str2 = this.model;
        String str3 = this.provider;
        String str4 = this.baseUrl;
        int i8 = this.port;
        Boolean bool = this.imageInput;
        String str5 = this.api;
        StringBuilder sbV = b.v("OpenClawConfig(apiKey=", str, ", model=", str2, ", provider=");
        b.A(sbV, str3, ", baseUrl=", str4, ", port=");
        sbV.append(i8);
        sbV.append(", imageInput=");
        sbV.append(bool);
        sbV.append(", api=");
        return f.f(sbV, str5, ")");
    }

    public OpenClawConfig(String apiKey, String model, String provider, String baseUrl, int i8, Boolean bool, String str) {
        p.e(apiKey, "apiKey");
        p.e(model, "model");
        p.e(provider, "provider");
        p.e(baseUrl, "baseUrl");
        this.apiKey = apiKey;
        this.model = model;
        this.provider = provider;
        this.baseUrl = baseUrl;
        this.port = i8;
        this.imageInput = bool;
        this.api = str;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ OpenClawConfig(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, int r6, java.lang.Boolean r7, java.lang.String r8, int r9, kotlin.jvm.internal.i r10) {
        /*
            r1 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r10 = r9 & 2
            if (r10 == 0) goto Lc
            java.lang.String r3 = "qwen/qwen3.5-397b-a17b"
        Lc:
            r10 = r9 & 4
            if (r10 == 0) goto L12
            java.lang.String r4 = "openrouter"
        L12:
            r10 = r9 & 8
            if (r10 == 0) goto L18
            java.lang.String r5 = "https://openrouter.ai/api/v1"
        L18:
            r10 = r9 & 16
            if (r10 == 0) goto L1e
            r6 = 18789(0x4965, float:2.6329E-41)
        L1e:
            r10 = r9 & 32
            r0 = 0
            if (r10 == 0) goto L24
            r7 = r0
        L24:
            r9 = r9 & 64
            if (r9 == 0) goto L31
            r10 = r0
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L39
        L31:
            r10 = r8
            r9 = r7
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L39:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.config.OpenClawConfig.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.i):void");
    }
}
