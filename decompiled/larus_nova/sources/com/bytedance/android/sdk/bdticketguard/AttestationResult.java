package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001:\u0001 BE\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003JG\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0012\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001aR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/AttestationResult;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "component5", "Lcom/bytedance/android/sdk/bdticketguard/AttestationResult$a;", "component6", "teePublicKey", "reePublicKey", "attestationAdapter", "attestType", "logId", "monitorData", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getTeePublicKey", "()Ljava/lang/String;", "getReePublicKey", "getAttestationAdapter", "I", "getAttestType", "()I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getLogId", "b", "Lcom/bytedance/android/sdk/bdticketguard/AttestationResult$a;", "getMonitorData", "()Lcom/bytedance/android/sdk/bdticketguard/AttestationResult$a;", "setMonitorData", "(Lcom/bytedance/android/sdk/bdticketguard/AttestationResult$a;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/android/sdk/bdticketguard/AttestationResult$a;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class AttestationResult implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f163480a;

    @SerializedName("attest_type")
    private final int attestType;

    @SerializedName("attestation_adapter")
    private final String attestationAdapter;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient a f163481b;

    @SerializedName("ree_public_key")
    private final String reePublicKey;

    @SerializedName("tee_public_key")
    private final String teePublicKey;

    /* JADX INFO: loaded from: classes12.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f163482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f163483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f163484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.bytedance.android.sdk.bdticketguard.data.a f163485d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L22:
            return true;
        L5:
            if ((r100 instanceof a) == false) goto L21;
            a r101 = (a) r100;
            if (this.f163482a != r101.f163482a) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == false) goto L21;
            if (this.f163483b != r101.f163483b) goto L14;
            boolean r103 = true;
        L15:
            if (r103 == false) goto L21;
            if (Intrinsics.areEqual(this.f163484c, r101.f163484c) == false) goto L21;
            if (Intrinsics.areEqual(this.f163485d, r101.f163485d) == false) goto L21;
        L14:
            r103 = false;
            goto L15
        L9:
            r102 = false;
        L21:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f163482a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f163483b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            d r104 = this.f163484c;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r104.hashCode();
        L6:
            int r107 = (r103 + r106) * 31;
            com.bytedance.android.sdk.bdticketguard.data.a r108 = this.f163485d;
            if (r108 == null) goto L10;
            r105 = r108.hashCode();
        L10:
            return r107 + r105;
        L5:
            r106 = 0;
            goto L6
        }

        public final String toString() {
            return "MonitorData(localAttestationTimeMs=" + this.f163482a + ", remoteAttestationTimeMs=" + this.f163483b + ", snapshot=" + this.f163484c + ", attestationParams=" + this.f163485d + ")";
        }

        public a(long r100, long r101, d r102, com.bytedance.android.sdk.bdticketguard.data.a r103) {
            this.f163482a = r100;
            this.f163483b = r101;
            this.f163484c = r102;
            this.f163485d = r103;
        }
    }

    public AttestationResult() {
        this(null, null, null, 0, null, null, 63, null);
    }

    public static /* synthetic */ AttestationResult copy$default(AttestationResult r100, String r101, String r102, String r103, int r104, String r105, a r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.teePublicKey;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.reePublicKey;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.attestationAdapter;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.attestType;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.f163480a;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.f163481b;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.teePublicKey;
    }

    public final String component2() {
        return this.reePublicKey;
    }

    public final String component3() {
        return this.attestationAdapter;
    }

    public final int component4() {
        return this.attestType;
    }

    public final String component5() {
        return this.f163480a;
    }

    public final a component6() {
        return this.f163481b;
    }

    public final AttestationResult copy(String r100, String r110, String r111, int r112, String r113, a r114) {
        return new AttestationResult(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
    L23:
        return true;
    L5:
        if ((r100 instanceof AttestationResult) == false) goto L22;
        AttestationResult r101 = (AttestationResult) r100;
        if (Intrinsics.areEqual(this.teePublicKey, r101.teePublicKey) == false) goto L22;
        if (Intrinsics.areEqual(this.reePublicKey, r101.reePublicKey) == false) goto L22;
        if (Intrinsics.areEqual(this.attestationAdapter, r101.attestationAdapter) == false) goto L22;
        if (this.attestType != r101.attestType) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == false) goto L22;
        if (Intrinsics.areEqual(this.f163480a, r101.f163480a) == false) goto L22;
        if (Intrinsics.areEqual(this.f163481b, r101.f163481b) == false) goto L22;
    L15:
        r102 = false;
    L22:
        return false;
    }

    public int hashCode() {
        String r100 = this.teePublicKey;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.reePublicKey;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.attestationAdapter;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.attestType) * 31;
        String r110 = this.f163480a;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        a r113 = this.f163481b;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AttestationResult(teePublicKey=" + this.teePublicKey + ", reePublicKey=" + this.reePublicKey + ", attestationAdapter=" + this.attestationAdapter + ", attestType=" + this.attestType + ", logId=" + this.f163480a + ", monitorData=" + this.f163481b + ")";
    }

    public final int getAttestType() {
        return this.attestType;
    }

    public final String getAttestationAdapter() {
        return this.attestationAdapter;
    }

    public final String getLogId() {
        return this.f163480a;
    }

    public final a getMonitorData() {
        return this.f163481b;
    }

    public final String getReePublicKey() {
        return this.reePublicKey;
    }

    public final String getTeePublicKey() {
        return this.teePublicKey;
    }

    public final void setMonitorData(a r100) {
        this.f163481b = r100;
    }

    public AttestationResult(String r100, String r101, String r102, int r103, String r104, a r105) {
        this.teePublicKey = r100;
        this.reePublicKey = r101;
        this.attestationAdapter = r102;
        this.attestType = r103;
        this.f163480a = r104;
        this.f163481b = r105;
    }

    public /* synthetic */ AttestationResult(String r100, String r101, String r102, int r103, String r104, a r110, int r111, DefaultConstructorMarker r112) {
        String r105 = "";
        if ((r111 & 1) == 0) goto L5;
        String r113 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r106 = "";
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r107 = "";
    L15:
        if ((r111 & 8) == 0) goto L17;
        int r108 = 0;
    L19:
        if ((r111 & 16) != 0) goto L23;
        r105 = r104;
    L23:
        if ((r111 & 32) == 0) goto L25;
        r110 = null;
    L25:
        a r114 = r110;
        this(r113, r106, r107, r108, r105, r114);
        return;
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
