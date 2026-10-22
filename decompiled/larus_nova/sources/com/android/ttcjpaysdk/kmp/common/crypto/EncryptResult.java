package com.android.ttcjpaysdk.kmp.common.crypto;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/crypto/EncryptResult;", "", "data", "", "version", "", "type1", "type2", "supportCertType", "<init>", "(Ljava/lang/String;IIII)V", "getData", "()Ljava/lang/String;", "getVersion", "()I", "getType1", "getType2", "getSupportCertType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EncryptResult {
    public static final int $stable = 0;
    private final String data;
    private final int supportCertType;
    private final int type1;
    private final int type2;
    private final int version;

    public static /* synthetic */ EncryptResult copy$default(EncryptResult r100, String r101, int r102, int r103, int r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.version;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.type1;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.type2;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.supportCertType;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.data;
    }

    public final int component2() {
        return this.version;
    }

    public final int component3() {
        return this.type1;
    }

    public final int component4() {
        return this.type2;
    }

    public final int component5() {
        return this.supportCertType;
    }

    public final EncryptResult copy(String r100, int r101, int r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return new EncryptResult(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EncryptResult) == true) goto L8;
        return false;
    L8:
        EncryptResult r101 = (EncryptResult) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (this.version == r101.version) goto L15;
        return false;
    L15:
        if (this.type1 == r101.type1) goto L18;
        return false;
    L18:
        if (this.type2 == r101.type2) goto L21;
        return false;
    L21:
        if (this.supportCertType == r101.supportCertType) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.data.hashCode() * 31) + this.version) * 31) + this.type1) * 31) + this.type2) * 31) + this.supportCertType;
    }

    public String toString() {
        return "EncryptResult(data=" + this.data + ", version=" + this.version + ", type1=" + this.type1 + ", type2=" + this.type2 + ", supportCertType=" + this.supportCertType + ')';
    }

    public final String getData() {
        return this.data;
    }

    public final int getSupportCertType() {
        return this.supportCertType;
    }

    public final int getType1() {
        return this.type1;
    }

    public final int getType2() {
        return this.type2;
    }

    public final int getVersion() {
        return this.version;
    }

    public EncryptResult(String r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.data = r100;
        this.version = r101;
        this.type1 = r102;
        this.type2 = r103;
        this.supportCertType = r104;
    }

    public /* synthetic */ EncryptResult(String r100, int r101, int r102, int r110, int r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 2) == 0) goto L5;
        int r103 = 20;
    L7:
        if ((r112 & 4) == 0) goto L9;
        int r104 = 2;
    L11:
        if ((r112 & 8) == 0) goto L13;
        int r105 = 1;
    L15:
        if ((r112 & 16) == 0) goto L17;
        int r106 = 0;
    L18:
        this(r100, r103, r104, r105, r106);
        return;
    L17:
        r106 = r111;
        goto L18
    L13:
        r105 = r110;
        goto L15
    L9:
        r104 = r102;
        goto L11
    L5:
        r103 = r101;
        goto L7
    }
}
