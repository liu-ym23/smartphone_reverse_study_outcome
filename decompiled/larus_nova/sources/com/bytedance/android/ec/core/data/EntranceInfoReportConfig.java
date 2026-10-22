package com.bytedance.android.ec.core.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/core/data/EntranceInfoReportConfig;", "Ljava/io/Serializable;", "reportCount", "", "enable", "", "(ILjava/lang/Boolean;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getReportCount", "()I", "setReportCount", "(I)V", "component1", "component2", "copy", "(ILjava/lang/Boolean;)Lcom/bytedance/android/ec/core/data/EntranceInfoReportConfig;", "equals", "other", "", "hashCode", "toString", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EntranceInfoReportConfig implements Serializable {

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("report_count")
    private int reportCount;

    /* JADX WARN: Multi-variable type inference failed */
    public EntranceInfoReportConfig() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ EntranceInfoReportConfig copy$default(EntranceInfoReportConfig r100, int r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.reportCount;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.enable;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.reportCount;
    }

    public final Boolean component2() {
        return this.enable;
    }

    public final EntranceInfoReportConfig copy(int r100, Boolean r101) {
        return new EntranceInfoReportConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EntranceInfoReportConfig) == false) goto L10;
        EntranceInfoReportConfig r101 = (EntranceInfoReportConfig) r100;
        if (this.reportCount == r101.reportCount) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r100 = this.reportCount * 31;
        Boolean r101 = this.enable;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "EntranceInfoReportConfig(reportCount=" + this.reportCount + ", enable=" + this.enable + ")";
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final int getReportCount() {
        return this.reportCount;
    }

    public final void setReportCount(int r100) {
        this.reportCount = r100;
    }

    public EntranceInfoReportConfig(int r100, Boolean r101) {
        this.reportCount = r100;
        this.enable = r101;
    }

    public /* synthetic */ EntranceInfoReportConfig(int r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 5;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = Boolean.FALSE;
    L8:
        this(r100, r101);
    }
}
