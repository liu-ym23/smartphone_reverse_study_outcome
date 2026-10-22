package com.android.ttcjpaysdk.verify.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J1\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/FingerprintStates;", "", "isSupport", "", "isLocalEnable", "isVersionSupport", "isTokenEmpty", "(ZZZZ)V", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FingerprintStates {
    private final boolean isLocalEnable;
    private final boolean isSupport;
    private final boolean isTokenEmpty;
    private final boolean isVersionSupport;

    public static /* synthetic */ FingerprintStates copy$default(FingerprintStates r100, boolean r101, boolean r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.isSupport;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.isLocalEnable;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.isVersionSupport;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.isTokenEmpty;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.isSupport;
    }

    public final boolean component2() {
        return this.isLocalEnable;
    }

    public final boolean component3() {
        return this.isVersionSupport;
    }

    public final boolean component4() {
        return this.isTokenEmpty;
    }

    public final FingerprintStates copy(boolean r100, boolean r101, boolean r102, boolean r103) {
        return new FingerprintStates(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FingerprintStates) == true) goto L8;
        return false;
    L8:
        FingerprintStates r101 = (FingerprintStates) r100;
        if (this.isSupport == r101.isSupport) goto L12;
        return false;
    L12:
        if (this.isLocalEnable == r101.isLocalEnable) goto L15;
        return false;
    L15:
        if (this.isVersionSupport == r101.isVersionSupport) goto L18;
        return false;
    L18:
        if (this.isTokenEmpty == r101.isTokenEmpty) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isSupport == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isLocalEnable == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.isVersionSupport == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.isTokenEmpty == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "FingerprintStates(isSupport=" + this.isSupport + ", isLocalEnable=" + this.isLocalEnable + ", isVersionSupport=" + this.isVersionSupport + ", isTokenEmpty=" + this.isTokenEmpty + ')';
    }

    public final boolean isLocalEnable() {
        return this.isLocalEnable;
    }

    public final boolean isSupport() {
        return this.isSupport;
    }

    public final boolean isTokenEmpty() {
        return this.isTokenEmpty;
    }

    public final boolean isVersionSupport() {
        return this.isVersionSupport;
    }

    public FingerprintStates(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.isSupport = r100;
        this.isLocalEnable = r101;
        this.isVersionSupport = r102;
        this.isTokenEmpty = r103;
    }
}
