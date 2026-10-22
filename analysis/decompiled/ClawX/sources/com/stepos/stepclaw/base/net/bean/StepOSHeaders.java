package com.stepos.stepclaw.base.net.bean;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/stepos/stepclaw/base/net/bean/StepOSHeaders;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "traceId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "userId", "deviceId", "appId", "nonce", "timestamp", "sign", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTraceId", "()Ljava/lang/String;", "getUserId", "getDeviceId", "getAppId", "getNonce", "getTimestamp", "getSign", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class StepOSHeaders {
    private final String appId;
    private final String deviceId;
    private final String nonce;
    private final String sign;
    private final String timestamp;
    private final String traceId;
    private final String userId;

    public StepOSHeaders(String traceId, String userId, String deviceId, String appId, String nonce, String timestamp, String sign) {
        p.e(traceId, "traceId");
        p.e(userId, "userId");
        p.e(deviceId, "deviceId");
        p.e(appId, "appId");
        p.e(nonce, "nonce");
        p.e(timestamp, "timestamp");
        p.e(sign, "sign");
        this.traceId = traceId;
        this.userId = userId;
        this.deviceId = deviceId;
        this.appId = appId;
        this.nonce = nonce;
        this.timestamp = timestamp;
        this.sign = sign;
    }

    public static /* synthetic */ StepOSHeaders copy$default(StepOSHeaders stepOSHeaders, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = stepOSHeaders.traceId;
        }
        if ((i8 & 2) != 0) {
            str2 = stepOSHeaders.userId;
        }
        if ((i8 & 4) != 0) {
            str3 = stepOSHeaders.deviceId;
        }
        if ((i8 & 8) != 0) {
            str4 = stepOSHeaders.appId;
        }
        if ((i8 & 16) != 0) {
            str5 = stepOSHeaders.nonce;
        }
        if ((i8 & 32) != 0) {
            str6 = stepOSHeaders.timestamp;
        }
        if ((i8 & 64) != 0) {
            str7 = stepOSHeaders.sign;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        String str11 = str3;
        return stepOSHeaders.copy(str, str2, str11, str4, str10, str8, str9);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSign() {
        return this.sign;
    }

    public final StepOSHeaders copy(String traceId, String userId, String deviceId, String appId, String nonce, String timestamp, String sign) {
        p.e(traceId, "traceId");
        p.e(userId, "userId");
        p.e(deviceId, "deviceId");
        p.e(appId, "appId");
        p.e(nonce, "nonce");
        p.e(timestamp, "timestamp");
        p.e(sign, "sign");
        return new StepOSHeaders(traceId, userId, deviceId, appId, nonce, timestamp, sign);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StepOSHeaders)) {
            return false;
        }
        StepOSHeaders stepOSHeaders = (StepOSHeaders) other;
        return p.a(this.traceId, stepOSHeaders.traceId) && p.a(this.userId, stepOSHeaders.userId) && p.a(this.deviceId, stepOSHeaders.deviceId) && p.a(this.appId, stepOSHeaders.appId) && p.a(this.nonce, stepOSHeaders.nonce) && p.a(this.timestamp, stepOSHeaders.timestamp) && p.a(this.sign, stepOSHeaders.sign);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getSign() {
        return this.sign;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.sign.hashCode() + b.f(b.f(b.f(b.f(b.f(this.traceId.hashCode() * 31, 31, this.userId), 31, this.deviceId), 31, this.appId), 31, this.nonce), 31, this.timestamp);
    }

    public String toString() {
        String str = this.traceId;
        String str2 = this.userId;
        String str3 = this.deviceId;
        String str4 = this.appId;
        String str5 = this.nonce;
        String str6 = this.timestamp;
        String str7 = this.sign;
        StringBuilder sbV = b.v("StepOSHeaders(traceId=", str, ", userId=", str2, ", deviceId=");
        b.A(sbV, str3, ", appId=", str4, ", nonce=");
        b.A(sbV, str5, ", timestamp=", str6, ", sign=");
        return f.f(sbV, str7, ")");
    }
}
