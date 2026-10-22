package com.bytedance.applet.aibridge.calendar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/applet/aibridge/calendar/ResultInfo;", "", "id", "", "success", "", "errMsg", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSuccess", "()Z", "getErrMsg", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultInfo {
    private final String errMsg;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f190997id;
    private final boolean success;

    public static /* synthetic */ ResultInfo copy$default(ResultInfo r100, String r101, boolean r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f190997id;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.success;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.errMsg;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.f190997id;
    }

    public final boolean component2() {
        return this.success;
    }

    public final String component3() {
        return this.errMsg;
    }

    public final ResultInfo copy(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return new ResultInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResultInfo) == true) goto L8;
        return false;
    L8:
        ResultInfo r101 = (ResultInfo) r100;
        if (Intrinsics.areEqual(this.f190997id, r101.f190997id) == true) goto L12;
        return false;
    L12:
        if (this.success == r101.success) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.errMsg, r101.errMsg) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.f190997id.hashCode() * 31;
        if (this.success == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.errMsg;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "ResultInfo(id=" + this.f190997id + ", success=" + this.success + ", errMsg=" + this.errMsg + ')';
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final String getId() {
        return this.f190997id;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public ResultInfo(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f190997id = r100;
        this.success = r101;
        this.errMsg = r102;
    }
}
