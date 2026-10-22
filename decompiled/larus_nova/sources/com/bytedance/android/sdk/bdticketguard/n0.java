package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/n0;", "Lcom/bytedance/android/sdk/bdticketguard/m0;", "", "ticket", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tsSign", "c", "clientCert", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class n0 implements m0 {

    @SerializedName("client_cert")
    private final String clientCert;

    @SerializedName("ticket")
    private final String ticket;

    @SerializedName("ts_sign")
    private final String tsSign;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n0) == false) goto L12;
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.ticket, r101.ticket) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tsSign, r101.tsSign) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.clientCert, r101.clientCert) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.ticket;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.tsSign;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.clientCert;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ServerDataV1(ticket=" + this.ticket + ", tsSign=" + this.tsSign + ", clientCert=" + this.clientCert + ")";
    }

    public final String a() {
        return this.clientCert;
    }

    public final String b() {
        return this.ticket;
    }

    public final String c() {
        return this.tsSign;
    }
}
