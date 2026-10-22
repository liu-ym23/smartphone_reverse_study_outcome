package com.stepos.cloud.securedata.model;

import a1.a;
import kotlin.Metadata;
import m.x;
import q7.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/stepos/cloud/securedata/model/PublicKeyResponse;", "", "code", "", "msg", "", "publicKey", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getPublicKey", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PublicKeyResponse {
    private final int code;
    private final String msg;
    private final String publicKey;

    public PublicKeyResponse(int i2, String str, String str2) {
        k.e(str, "msg");
        k.e(str2, "publicKey");
        this.code = i2;
        this.msg = str;
        this.publicKey = str2;
    }

    public static /* synthetic */ PublicKeyResponse copy$default(PublicKeyResponse publicKeyResponse, int i2, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i2 = publicKeyResponse.code;
        }
        if ((i10 & 2) != 0) {
            str = publicKeyResponse.msg;
        }
        if ((i10 & 4) != 0) {
            str2 = publicKeyResponse.publicKey;
        }
        return publicKeyResponse.copy(i2, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPublicKey() {
        return this.publicKey;
    }

    public final PublicKeyResponse copy(int code, String msg, String publicKey) {
        k.e(msg, "msg");
        k.e(publicKey, "publicKey");
        return new PublicKeyResponse(code, msg, publicKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublicKeyResponse)) {
            return false;
        }
        PublicKeyResponse publicKeyResponse = (PublicKeyResponse) other;
        return this.code == publicKeyResponse.code && k.a(this.msg, publicKeyResponse.msg) && k.a(this.publicKey, publicKeyResponse.publicKey);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        return this.publicKey.hashCode() + x.g(this.msg, Integer.hashCode(this.code) * 31, 31);
    }

    public String toString() {
        int i2 = this.code;
        String str = this.msg;
        String str2 = this.publicKey;
        StringBuilder sb2 = new StringBuilder("PublicKeyResponse(code=");
        sb2.append(i2);
        sb2.append(", msg=");
        sb2.append(str);
        sb2.append(", publicKey=");
        return a.m(sb2, str2, ")");
    }
}
