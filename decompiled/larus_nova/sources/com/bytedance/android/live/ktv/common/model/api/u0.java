package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/u0;", "", "", "foldingInfo", "Ljava/lang/String;", "getFoldingInfo", "()Ljava/lang/String;", "lyricInfo", "getLyricInfo", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class u0 implements vh7.h {

    @SerializedName("folding_info")
    protected String foldingInfo;

    @SerializedName("lyric_info")
    protected String lyricInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u0) == false) goto L10;
        u0 r101 = (u0) r100;
        if (Intrinsics.areEqual(this.foldingInfo, r101.foldingInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lyricInfo, r101.lyricInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.foldingInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.lyricInfo;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SearchFingerprintResult(foldingInfo=" + this.foldingInfo + ", lyricInfo=" + this.lyricInfo + ")";
    }

    public u0() {
        this.foldingInfo = null;
        this.lyricInfo = null;
    }

    public u0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.foldingInfo = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.lyricInfo = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.foldingInfo != null) goto L16;
        this.foldingInfo = null;
    L16:
        if (this.lyricInfo != null) goto L28;
        this.lyricInfo = null;
        return;
    }
}
