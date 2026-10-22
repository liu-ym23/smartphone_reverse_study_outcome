package com.android.ttcjpaysdk.bindcard.base.utils;

import com.android.ttcjpaysdk.thirdparty.data.CJPayIdType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/utils/FourElementDataCache;", "", "nameInput", "", "idInput", "idType", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayIdType;", "countryName", "savedTimeMillis", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/thirdparty/data/CJPayIdType;Ljava/lang/String;J)V", "getCountryName", "()Ljava/lang/String;", "getIdInput", "getIdType", "()Lcom/android/ttcjpaysdk/thirdparty/data/CJPayIdType;", "getNameInput", "getSavedTimeMillis", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FourElementDataCache {
    private final String countryName;
    private final String idInput;
    private final CJPayIdType idType;
    private final String nameInput;
    private final long savedTimeMillis;

    public static /* synthetic */ FourElementDataCache copy$default(FourElementDataCache r100, String r101, String r102, CJPayIdType r103, String r104, long r105, int r110, Object r111) {
        if ((r110 & 1) == 0) goto L6;
        r101 = r100.nameInput;
    L6:
        if ((r110 & 2) == 0) goto L8;
        r102 = r100.idInput;
    L8:
        String r112 = r102;
        if ((r110 & 4) == 0) goto L11;
        r103 = r100.idType;
    L11:
        CJPayIdType r106 = r103;
        if ((r110 & 8) == 0) goto L14;
        r104 = r100.countryName;
    L14:
        String r107 = r104;
        if ((r110 & 16) == 0) goto L17;
        r105 = r100.savedTimeMillis;
    L17:
        String r108 = r101;
        return r100.copy(r108, r112, r106, r107, r105);
    }

    public final String component1() {
        return this.nameInput;
    }

    public final String component2() {
        return this.idInput;
    }

    public final CJPayIdType component3() {
        return this.idType;
    }

    public final String component4() {
        return this.countryName;
    }

    public final long component5() {
        return this.savedTimeMillis;
    }

    public final FourElementDataCache copy(String r100, String r110, CJPayIdType r111, String r112, long r113) {
        Intrinsics.checkNotNullParameter(r100, "nameInput");
        Intrinsics.checkNotNullParameter(r110, "idInput");
        Intrinsics.checkNotNullParameter(r111, "idType");
        return new FourElementDataCache(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FourElementDataCache) == true) goto L8;
        return false;
    L8:
        FourElementDataCache r101 = (FourElementDataCache) r100;
        if (Intrinsics.areEqual(this.nameInput, r101.nameInput) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.idInput, r101.idInput) == true) goto L15;
        return false;
    L15:
        if (this.idType == r101.idType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.countryName, r101.countryName) == true) goto L21;
        return false;
    L21:
        if (this.savedTimeMillis == r101.savedTimeMillis) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.nameInput.hashCode() * 31) + this.idInput.hashCode()) * 31) + this.idType.hashCode()) * 31;
        String r101 = this.countryName;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        long r104 = this.savedTimeMillis;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "FourElementDataCache(nameInput=" + this.nameInput + ", idInput=" + this.idInput + ", idType=" + this.idType + ", countryName=" + this.countryName + ", savedTimeMillis=" + this.savedTimeMillis + ')';
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final String getIdInput() {
        return this.idInput;
    }

    public final CJPayIdType getIdType() {
        return this.idType;
    }

    public final String getNameInput() {
        return this.nameInput;
    }

    public final long getSavedTimeMillis() {
        return this.savedTimeMillis;
    }

    public FourElementDataCache(String r100, String r101, CJPayIdType r102, String r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "nameInput");
        Intrinsics.checkNotNullParameter(r101, "idInput");
        Intrinsics.checkNotNullParameter(r102, "idType");
        this.nameInput = r100;
        this.idInput = r101;
        this.idType = r102;
        this.countryName = r103;
        this.savedTimeMillis = r104;
    }
}
