package com.bytedance.android.sdk.bdticketguard.key.attestation;

import com.bytedance.android.sdk.bdticketguard.attestation.AttestSignContent;
import com.bytedance.android.sdk.bdticketguard.attestation.AttestSignContentAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/key/attestation/b;", "", "", "attestSign", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "adapterName", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/sdk/bdticketguard/attestation/AttestSignContent;", "signContent", "Lcom/bytedance/android/sdk/bdticketguard/attestation/AttestSignContent;", "d", "()Lcom/bytedance/android/sdk/bdticketguard/attestation/AttestSignContent;", "attestPubKey", "b", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 4, 0})
public final class b {

    @SerializedName("adapter_name")
    private final String adapterName;

    @SerializedName("attest_pub_key")
    private final String attestPubKey;

    @SerializedName("attest_sign")
    private final String attestSign;

    @SerializedName("sign_content")
    @JsonAdapter(nullSafe = true, value = AttestSignContentAdapter.class)
    private final AttestSignContent signContent;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.attestSign, r101.attestSign) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.adapterName, r101.adapterName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.signContent, r101.signContent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attestPubKey, r101.attestPubKey) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.attestSign;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.adapterName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        AttestSignContent r107 = this.signContent;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.attestPubKey;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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

    public final String toString() {
        return "AttestSignCache(attestSign=" + this.attestSign + ", adapterName=" + this.adapterName + ", signContent=" + this.signContent + ", attestPubKey=" + this.attestPubKey + ")";
    }

    public b() {
        this("", "", new AttestSignContent(0), "");
    }

    public final String a() {
        return this.adapterName;
    }

    public final String b() {
        return this.attestPubKey;
    }

    public final String c() {
        return this.attestSign;
    }

    public final AttestSignContent d() {
        return this.signContent;
    }

    public b(String r100, String r101, AttestSignContent r102, String r103) {
        this.attestSign = r100;
        this.adapterName = r101;
        this.signContent = r102;
        this.attestPubKey = r103;
    }
}
