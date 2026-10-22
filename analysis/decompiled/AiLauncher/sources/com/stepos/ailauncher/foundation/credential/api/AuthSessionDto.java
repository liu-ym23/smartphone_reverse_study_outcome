package com.stepos.ailauncher.foundation.credential.api;

import La.D;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 02\u00020\u0001:\u00010Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u001c2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u00061"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/api/AuthSessionDto;", "", "sessionId", "", "status", "authorizationUrl", "appRedirectUrl", "vendorId", "integrationId", "pollUrl", "pollIntervalMs", "", "expiresAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getStatus", "getAuthorizationUrl", "getAppRedirectUrl", "getVendorId", "getIntegrationId", "getPollUrl", "getPollIntervalMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExpiresAt", "isCompleted", "", "isFailed", "isExpired", "isTerminal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/credential/api/AuthSessionDto;", "equals", "other", "hashCode", "", "toString", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AuthSessionDto {
    public static final String STATUS_COMPLETED = "completed";
    public static final String STATUS_EXPIRED = "expired";
    public static final String STATUS_FAILED = "failed";
    public static final String STATUS_PENDING = "pending";

    @SerializedName("app_redirect_url")
    private final String appRedirectUrl;

    @SerializedName("authorization_url")
    private final String authorizationUrl;

    @SerializedName("expires_at")
    private final String expiresAt;

    @SerializedName("integration_id")
    private final String integrationId;

    @SerializedName("poll_interval_ms")
    private final Long pollIntervalMs;

    @SerializedName("poll_url")
    private final String pollUrl;

    @SerializedName("session_id")
    private final String sessionId;

    @SerializedName("status")
    private final String status;

    @SerializedName("vendor_id")
    private final String vendorId;

    public AuthSessionDto() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ AuthSessionDto copy$default(AuthSessionDto authSessionDto, String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l10, String str8, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = authSessionDto.sessionId;
        }
        if ((i10 & 2) != 0) {
            str2 = authSessionDto.status;
        }
        if ((i10 & 4) != 0) {
            str3 = authSessionDto.authorizationUrl;
        }
        if ((i10 & 8) != 0) {
            str4 = authSessionDto.appRedirectUrl;
        }
        if ((i10 & 16) != 0) {
            str5 = authSessionDto.vendorId;
        }
        if ((i10 & 32) != 0) {
            str6 = authSessionDto.integrationId;
        }
        if ((i10 & 64) != 0) {
            str7 = authSessionDto.pollUrl;
        }
        if ((i10 & 128) != 0) {
            l10 = authSessionDto.pollIntervalMs;
        }
        if ((i10 & 256) != 0) {
            str8 = authSessionDto.expiresAt;
        }
        Long l11 = l10;
        String str9 = str8;
        String str10 = str6;
        String str11 = str7;
        String str12 = str5;
        String str13 = str3;
        return authSessionDto.copy(str, str2, str13, str4, str12, str10, str11, l11, str9);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAuthorizationUrl() {
        return this.authorizationUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAppRedirectUrl() {
        return this.appRedirectUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final String getVendorId() {
        return this.vendorId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIntegrationId() {
        return this.integrationId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPollUrl() {
        return this.pollUrl;
    }

    /* renamed from: component8, reason: from getter */
    public final Long getPollIntervalMs() {
        return this.pollIntervalMs;
    }

    /* renamed from: component9, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final AuthSessionDto copy(String sessionId, String status, String authorizationUrl, String appRedirectUrl, String vendorId, String integrationId, String pollUrl, Long pollIntervalMs, String expiresAt) {
        return new AuthSessionDto(sessionId, status, authorizationUrl, appRedirectUrl, vendorId, integrationId, pollUrl, pollIntervalMs, expiresAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthSessionDto)) {
            return false;
        }
        AuthSessionDto authSessionDto = (AuthSessionDto) other;
        return p.d(this.sessionId, authSessionDto.sessionId) && p.d(this.status, authSessionDto.status) && p.d(this.authorizationUrl, authSessionDto.authorizationUrl) && p.d(this.appRedirectUrl, authSessionDto.appRedirectUrl) && p.d(this.vendorId, authSessionDto.vendorId) && p.d(this.integrationId, authSessionDto.integrationId) && p.d(this.pollUrl, authSessionDto.pollUrl) && p.d(this.pollIntervalMs, authSessionDto.pollIntervalMs) && p.d(this.expiresAt, authSessionDto.expiresAt);
    }

    public final String getAppRedirectUrl() {
        return this.appRedirectUrl;
    }

    public final String getAuthorizationUrl() {
        return this.authorizationUrl;
    }

    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final String getIntegrationId() {
        return this.integrationId;
    }

    public final Long getPollIntervalMs() {
        return this.pollIntervalMs;
    }

    public final String getPollUrl() {
        return this.pollUrl;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        String str = this.sessionId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.status;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.authorizationUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.appRedirectUrl;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.vendorId;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.integrationId;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.pollUrl;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l10 = this.pollIntervalMs;
        int iHashCode8 = (iHashCode7 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str8 = this.expiresAt;
        return iHashCode8 + (str8 != null ? str8.hashCode() : 0);
    }

    public final boolean isCompleted() {
        return D.L(this.status, "completed", true);
    }

    public final boolean isExpired() {
        return D.L(this.status, "expired", true);
    }

    public final boolean isFailed() {
        return D.L(this.status, "failed", true);
    }

    public final boolean isTerminal() {
        return isCompleted() || isFailed() || isExpired();
    }

    public String toString() {
        return "AuthSessionDto(sessionId=" + this.sessionId + ", status=" + this.status + ", authorizationUrl=" + this.authorizationUrl + ", appRedirectUrl=" + this.appRedirectUrl + ", vendorId=" + this.vendorId + ", integrationId=" + this.integrationId + ", pollUrl=" + this.pollUrl + ", pollIntervalMs=" + this.pollIntervalMs + ", expiresAt=" + this.expiresAt + ")";
    }

    public AuthSessionDto(String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l10, String str8) {
        this.sessionId = str;
        this.status = str2;
        this.authorizationUrl = str3;
        this.appRedirectUrl = str4;
        this.vendorId = str5;
        this.integrationId = str6;
        this.pollUrl = str7;
        this.pollIntervalMs = l10;
        this.expiresAt = str8;
    }

    public /* synthetic */ AuthSessionDto(String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l10, String str8, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & 128) != 0 ? null : l10, (i10 & 256) != 0 ? null : str8);
    }
}
