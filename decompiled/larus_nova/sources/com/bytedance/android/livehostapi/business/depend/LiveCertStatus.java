package com.bytedance.android.livehostapi.business.depend;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/LiveCertStatus;", "", "certStatus", "", "manualStatus", CommonConstant.KEY_AGE_RANGE, "(III)V", "getAgeRange", "()I", "getCertStatus", "getManualStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCertStatus {
    private final int ageRange;
    private final int certStatus;
    private final int manualStatus;

    public LiveCertStatus() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ LiveCertStatus copy$default(LiveCertStatus r100, int r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.certStatus;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.manualStatus;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.ageRange;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.certStatus;
    }

    public final int component2() {
        return this.manualStatus;
    }

    public final int component3() {
        return this.ageRange;
    }

    public final LiveCertStatus copy(int r100, int r101, int r102) {
        return new LiveCertStatus(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveCertStatus) == false) goto L12;
        LiveCertStatus r101 = (LiveCertStatus) r100;
        if (this.certStatus == r101.certStatus) goto L8;
        return false;
    L8:
        if (this.manualStatus == r101.manualStatus) goto L10;
        return false;
    L10:
        if (this.ageRange == r101.ageRange) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return (((this.certStatus * 31) + this.manualStatus) * 31) + this.ageRange;
    }

    public String toString() {
        return "LiveCertStatus(certStatus=" + this.certStatus + ", manualStatus=" + this.manualStatus + ", ageRange=" + this.ageRange + ")";
    }

    public final int getAgeRange() {
        return this.ageRange;
    }

    public final int getCertStatus() {
        return this.certStatus;
    }

    public final int getManualStatus() {
        return this.manualStatus;
    }

    public LiveCertStatus(int r100, int r101, int r102) {
        this.certStatus = r100;
        this.manualStatus = r101;
        this.ageRange = r102;
    }

    public /* synthetic */ LiveCertStatus(int r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
