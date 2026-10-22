package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformDekDecryptCryptoRequest;", "", "suite", "", "clientPub", "salt", "nonce", "ts", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getSuite", "()Ljava/lang/String;", "getClientPub", "getSalt", "getNonce", "getTs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformDekDecryptCryptoRequest {

    @SerializedName("client_pub")
    private final String clientPub;
    private final String nonce;
    private final String salt;
    private final String suite;

    /* JADX INFO: renamed from: ts, reason: collision with root package name */
    private final long f37329ts;

    public OpenPlatformDekDecryptCryptoRequest() {
        this(null, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ OpenPlatformDekDecryptCryptoRequest copy$default(OpenPlatformDekDecryptCryptoRequest r100, String r101, String r102, String r103, String r104, long r105, int r110, Object r111) {
        if ((r110 & 1) == 0) goto L6;
        r101 = r100.suite;
    L6:
        if ((r110 & 2) == 0) goto L8;
        r102 = r100.clientPub;
    L8:
        String r112 = r102;
        if ((r110 & 4) == 0) goto L11;
        r103 = r100.salt;
    L11:
        String r106 = r103;
        if ((r110 & 8) == 0) goto L14;
        r104 = r100.nonce;
    L14:
        String r107 = r104;
        if ((r110 & 16) == 0) goto L17;
        r105 = r100.f37329ts;
    L17:
        String r108 = r101;
        return r100.copy(r108, r112, r106, r107, r105);
    }

    public final String component1() {
        return this.suite;
    }

    public final String component2() {
        return this.clientPub;
    }

    public final String component3() {
        return this.salt;
    }

    public final String component4() {
        return this.nonce;
    }

    public final long component5() {
        return this.f37329ts;
    }

    public final OpenPlatformDekDecryptCryptoRequest copy(String r100, String r110, String r111, String r112, long r113) {
        return new OpenPlatformDekDecryptCryptoRequest(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenPlatformDekDecryptCryptoRequest) == true) goto L8;
        return false;
    L8:
        OpenPlatformDekDecryptCryptoRequest r101 = (OpenPlatformDekDecryptCryptoRequest) r100;
        if (Intrinsics.areEqual(this.suite, r101.suite) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.clientPub, r101.clientPub) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.salt, r101.salt) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nonce, r101.nonce) == true) goto L21;
        return false;
    L21:
        if (this.f37329ts == r101.f37329ts) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.suite;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.clientPub;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.salt;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.nonce;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        long r112 = this.f37329ts;
        return r111 + ((int) (r112 ^ (r112 >>> 32)));
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenPlatformDekDecryptCryptoRequest(suite=" + this.suite + ", clientPub=" + this.clientPub + ", salt=" + this.salt + ", nonce=" + this.nonce + ", ts=" + this.f37329ts + ')';
    }

    public final String getClientPub() {
        return this.clientPub;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getSalt() {
        return this.salt;
    }

    public final String getSuite() {
        return this.suite;
    }

    public final long getTs() {
        return this.f37329ts;
    }

    public OpenPlatformDekDecryptCryptoRequest(String r100, String r101, String r102, String r103, long r104) {
        this.suite = r100;
        this.clientPub = r101;
        this.salt = r102;
        this.nonce = r103;
        this.f37329ts = r104;
    }

    public /* synthetic */ OpenPlatformDekDecryptCryptoRequest(String r100, String r101, String r102, String r103, long r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r100 = "ECDH_P256_HKDF_SHA256_AES_256_GCM";
    L6:
        if ((r110 & 2) == 0) goto L8;
        r101 = null;
    L8:
        String r112 = r101;
        String r105 = "";
        if ((r110 & 4) == 0) goto L11;
        String r106 = "";
    L13:
        if ((r110 & 8) != 0) goto L17;
        r105 = r103;
    L17:
        if ((r110 & 16) == 0) goto L19;
        r104 = 0;
    L19:
        long r107 = r104;
        this(r100, r112, r106, r105, r107);
        return;
    L11:
        r106 = r102;
        goto L13
    }
}
