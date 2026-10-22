package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/l0;", "", "", "certString", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setCertString", "(Ljava/lang/String;)V", "serialNumber", "c", "setSerialNumber", "publicKey", "b", "setPublicKey", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class l0 {

    @SerializedName("cert_string")
    private String certString;

    @SerializedName("public_key")
    private String publicKey;

    @SerializedName("serial_number")
    private String serialNumber;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l0) == false) goto L12;
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.certString, r101.certString) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.serialNumber, r101.serialNumber) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.publicKey, r101.publicKey) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.certString;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.serialNumber;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.publicKey;
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
        return "ServerCert(certString=" + this.certString + ", serialNumber=" + this.serialNumber + ", publicKey=" + this.publicKey + ")";
    }

    public final String a() {
        return this.certString;
    }

    public final String b() {
        return this.publicKey;
    }

    public final String c() {
        return this.serialNumber;
    }

    public l0(String r100, String r101, String r102) {
        this.certString = r100;
        this.serialNumber = r101;
        this.publicKey = r102;
    }
}
