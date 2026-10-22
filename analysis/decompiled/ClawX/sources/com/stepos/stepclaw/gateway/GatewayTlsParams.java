package com.stepos.stepclaw.gateway;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayTlsParams;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "required", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "expectedFingerprint", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "allowTOFU", "stableId", "<init>", "(ZLjava/lang/String;ZLjava/lang/String;)V", "getRequired", "()Z", "getExpectedFingerprint", "()Ljava/lang/String;", "getAllowTOFU", "getStableId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GatewayTlsParams {
    private final boolean allowTOFU;
    private final String expectedFingerprint;
    private final boolean required;
    private final String stableId;

    public GatewayTlsParams(boolean z, String str, boolean z2, String stableId) {
        p.e(stableId, "stableId");
        this.required = z;
        this.expectedFingerprint = str;
        this.allowTOFU = z2;
        this.stableId = stableId;
    }

    public static /* synthetic */ GatewayTlsParams copy$default(GatewayTlsParams gatewayTlsParams, boolean z, String str, boolean z2, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z = gatewayTlsParams.required;
        }
        if ((i8 & 2) != 0) {
            str = gatewayTlsParams.expectedFingerprint;
        }
        if ((i8 & 4) != 0) {
            z2 = gatewayTlsParams.allowTOFU;
        }
        if ((i8 & 8) != 0) {
            str2 = gatewayTlsParams.stableId;
        }
        return gatewayTlsParams.copy(z, str, z2, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    /* renamed from: component2, reason: from getter */
    public final String getExpectedFingerprint() {
        return this.expectedFingerprint;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAllowTOFU() {
        return this.allowTOFU;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStableId() {
        return this.stableId;
    }

    public final GatewayTlsParams copy(boolean required, String expectedFingerprint, boolean allowTOFU, String stableId) {
        p.e(stableId, "stableId");
        return new GatewayTlsParams(required, expectedFingerprint, allowTOFU, stableId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GatewayTlsParams)) {
            return false;
        }
        GatewayTlsParams gatewayTlsParams = (GatewayTlsParams) other;
        return this.required == gatewayTlsParams.required && p.a(this.expectedFingerprint, gatewayTlsParams.expectedFingerprint) && this.allowTOFU == gatewayTlsParams.allowTOFU && p.a(this.stableId, gatewayTlsParams.stableId);
    }

    public final boolean getAllowTOFU() {
        return this.allowTOFU;
    }

    public final String getExpectedFingerprint() {
        return this.expectedFingerprint;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final String getStableId() {
        return this.stableId;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.required) * 31;
        String str = this.expectedFingerprint;
        return this.stableId.hashCode() + a8.b.g((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.allowTOFU);
    }

    public String toString() {
        return "GatewayTlsParams(required=" + this.required + ", expectedFingerprint=" + this.expectedFingerprint + ", allowTOFU=" + this.allowTOFU + ", stableId=" + this.stableId + ")";
    }
}
