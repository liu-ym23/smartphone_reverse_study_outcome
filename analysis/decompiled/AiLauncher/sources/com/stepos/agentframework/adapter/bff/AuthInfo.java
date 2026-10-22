package com.stepos.agentframework.adapter.bff;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b \u0010\u0012R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b!\u0010\u0012R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\"\u0010\u0012R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b#\u0010\u0012R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/a;", "", "", M5.b.CREDENTIAL_TOKEN, "uid", "token_type", "product", "", "platform", Parameters.DEVICE, "app_version", "channel", "did", "", "reserved", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "e", "I", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "getDid", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.bff.a, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AuthInfo {
    private final String app_version;
    private final String channel;
    private final String device;
    private final String did;
    private final int platform;
    private final String product;
    private final Map<String, String> reserved;
    private final String token;
    private final String token_type;
    private final String uid;

    public AuthInfo(String token, String uid, String token_type, String product, int i10, String device, String app_version, String channel, String did, Map<String, String> reserved) {
        kotlin.jvm.internal.p.i(token, "token");
        kotlin.jvm.internal.p.i(uid, "uid");
        kotlin.jvm.internal.p.i(token_type, "token_type");
        kotlin.jvm.internal.p.i(product, "product");
        kotlin.jvm.internal.p.i(device, "device");
        kotlin.jvm.internal.p.i(app_version, "app_version");
        kotlin.jvm.internal.p.i(channel, "channel");
        kotlin.jvm.internal.p.i(did, "did");
        kotlin.jvm.internal.p.i(reserved, "reserved");
        this.token = token;
        this.uid = uid;
        this.token_type = token_type;
        this.product = product;
        this.platform = i10;
        this.device = device;
        this.app_version = app_version;
        this.channel = channel;
        this.did = did;
        this.reserved = reserved;
    }

    /* renamed from: a, reason: from getter */
    public final String getApp_version() {
        return this.app_version;
    }

    /* renamed from: b, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: c, reason: from getter */
    public final String getDevice() {
        return this.device;
    }

    /* renamed from: d, reason: from getter */
    public final int getPlatform() {
        return this.platform;
    }

    /* renamed from: e, reason: from getter */
    public final String getProduct() {
        return this.product;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthInfo)) {
            return false;
        }
        AuthInfo authInfo = (AuthInfo) other;
        return kotlin.jvm.internal.p.d(this.token, authInfo.token) && kotlin.jvm.internal.p.d(this.uid, authInfo.uid) && kotlin.jvm.internal.p.d(this.token_type, authInfo.token_type) && kotlin.jvm.internal.p.d(this.product, authInfo.product) && this.platform == authInfo.platform && kotlin.jvm.internal.p.d(this.device, authInfo.device) && kotlin.jvm.internal.p.d(this.app_version, authInfo.app_version) && kotlin.jvm.internal.p.d(this.channel, authInfo.channel) && kotlin.jvm.internal.p.d(this.did, authInfo.did) && kotlin.jvm.internal.p.d(this.reserved, authInfo.reserved);
    }

    public final Map<String, String> f() {
        return this.reserved;
    }

    /* renamed from: g, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: h, reason: from getter */
    public final String getToken_type() {
        return this.token_type;
    }

    public int hashCode() {
        return (((((((((((((((((this.token.hashCode() * 31) + this.uid.hashCode()) * 31) + this.token_type.hashCode()) * 31) + this.product.hashCode()) * 31) + Integer.hashCode(this.platform)) * 31) + this.device.hashCode()) * 31) + this.app_version.hashCode()) * 31) + this.channel.hashCode()) * 31) + this.did.hashCode()) * 31) + this.reserved.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    public String toString() {
        return "AuthInfo(token=" + this.token + ", uid=" + this.uid + ", token_type=" + this.token_type + ", product=" + this.product + ", platform=" + this.platform + ", device=" + this.device + ", app_version=" + this.app_version + ", channel=" + this.channel + ", did=" + this.did + ", reserved=" + this.reserved + ")";
    }

    public /* synthetic */ AuthInfo(String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7, String str8, Map map, int i11, kotlin.jvm.internal.i iVar) {
        this(str, str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? "" : str4, (i11 & 16) != 0 ? 0 : i10, (i11 & 32) != 0 ? "" : str5, (i11 & 64) != 0 ? "" : str6, (i11 & 128) != 0 ? "" : str7, (i11 & 256) != 0 ? "" : str8, (i11 & 512) != 0 ? new HashMap() : map);
    }
}
