package com.stepos.agentframework.adapter.bff;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0015\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eHÆ\u0003Jy\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\bHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/stepos/agentframework/adapter/bff/AuthInfo;", "", "token", "", "uid", "token_type", "product", "platform", "", "device", "app_version", "channel", "did", "reserved", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getToken", "()Ljava/lang/String;", "getUid", "getToken_type", "getProduct", "getPlatform", "()I", "getDevice", "getApp_version", "getChannel", "getDid", "getReserved", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    public AuthInfo(String token, String uid, String token_type, String product, int i, String device, String app_version, String channel, String did, Map<String, String> reserved) {
        k.f(token, "token");
        k.f(uid, "uid");
        k.f(token_type, "token_type");
        k.f(product, "product");
        k.f(device, "device");
        k.f(app_version, "app_version");
        k.f(channel, "channel");
        k.f(did, "did");
        k.f(reserved, "reserved");
        this.token = token;
        this.uid = uid;
        this.token_type = token_type;
        this.product = product;
        this.platform = i;
        this.device = device;
        this.app_version = app_version;
        this.channel = channel;
        this.did = did;
        this.reserved = reserved;
    }

    public static /* synthetic */ AuthInfo copy$default(AuthInfo authInfo, String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, Map map, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = authInfo.token;
        }
        if ((i6 & 2) != 0) {
            str2 = authInfo.uid;
        }
        if ((i6 & 4) != 0) {
            str3 = authInfo.token_type;
        }
        if ((i6 & 8) != 0) {
            str4 = authInfo.product;
        }
        if ((i6 & 16) != 0) {
            i = authInfo.platform;
        }
        if ((i6 & 32) != 0) {
            str5 = authInfo.device;
        }
        if ((i6 & 64) != 0) {
            str6 = authInfo.app_version;
        }
        if ((i6 & 128) != 0) {
            str7 = authInfo.channel;
        }
        if ((i6 & 256) != 0) {
            str8 = authInfo.did;
        }
        if ((i6 & 512) != 0) {
            map = authInfo.reserved;
        }
        String str9 = str8;
        Map map2 = map;
        String str10 = str6;
        String str11 = str7;
        int i10 = i;
        String str12 = str5;
        return authInfo.copy(str, str2, str3, str4, i10, str12, str10, str11, str9, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final Map<String, String> component10() {
        return this.reserved;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToken_type() {
        return this.token_type;
    }

    /* renamed from: component4, reason: from getter */
    public final String getProduct() {
        return this.product;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPlatform() {
        return this.platform;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDevice() {
        return this.device;
    }

    /* renamed from: component7, reason: from getter */
    public final String getApp_version() {
        return this.app_version;
    }

    /* renamed from: component8, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDid() {
        return this.did;
    }

    public final AuthInfo copy(String token, String uid, String token_type, String product, int platform, String device, String app_version, String channel, String did, Map<String, String> reserved) {
        k.f(token, "token");
        k.f(uid, "uid");
        k.f(token_type, "token_type");
        k.f(product, "product");
        k.f(device, "device");
        k.f(app_version, "app_version");
        k.f(channel, "channel");
        k.f(did, "did");
        k.f(reserved, "reserved");
        return new AuthInfo(token, uid, token_type, product, platform, device, app_version, channel, did, reserved);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthInfo)) {
            return false;
        }
        AuthInfo authInfo = (AuthInfo) other;
        return k.b(this.token, authInfo.token) && k.b(this.uid, authInfo.uid) && k.b(this.token_type, authInfo.token_type) && k.b(this.product, authInfo.product) && this.platform == authInfo.platform && k.b(this.device, authInfo.device) && k.b(this.app_version, authInfo.app_version) && k.b(this.channel, authInfo.channel) && k.b(this.did, authInfo.did) && k.b(this.reserved, authInfo.reserved);
    }

    public final String getApp_version() {
        return this.app_version;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getDevice() {
        return this.device;
    }

    public final String getDid() {
        return this.did;
    }

    public final int getPlatform() {
        return this.platform;
    }

    public final String getProduct() {
        return this.product;
    }

    public final Map<String, String> getReserved() {
        return this.reserved;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getToken_type() {
        return this.token_type;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return this.reserved.hashCode() + B7.a.c(B7.a.c(B7.a.c(B7.a.c(androidx.constraintlayout.core.dsl.a.a(this.platform, B7.a.c(B7.a.c(B7.a.c(this.token.hashCode() * 31, 31, this.uid), 31, this.token_type), 31, this.product), 31), 31, this.device), 31, this.app_version), 31, this.channel), 31, this.did);
    }

    public String toString() {
        String str = this.token;
        String str2 = this.uid;
        String str3 = this.token_type;
        String str4 = this.product;
        int i = this.platform;
        String str5 = this.device;
        String str6 = this.app_version;
        String str7 = this.channel;
        String str8 = this.did;
        Map<String, String> map = this.reserved;
        StringBuilder sbW = B7.a.w("AuthInfo(token=", str, ", uid=", str2, ", token_type=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", product=", str4, ", platform=");
        sbW.append(i);
        sbW.append(", device=");
        sbW.append(str5);
        sbW.append(", app_version=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str6, ", channel=", str7, ", did=");
        sbW.append(str8);
        sbW.append(", reserved=");
        sbW.append(map);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ AuthInfo(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, Map map, int i6, e eVar) {
        this(str, str2, (i6 & 4) != 0 ? "" : str3, (i6 & 8) != 0 ? "" : str4, (i6 & 16) != 0 ? 0 : i, (i6 & 32) != 0 ? "" : str5, (i6 & 64) != 0 ? "" : str6, (i6 & 128) != 0 ? "" : str7, (i6 & 256) != 0 ? "" : str8, (i6 & 512) != 0 ? new HashMap() : map);
    }
}
