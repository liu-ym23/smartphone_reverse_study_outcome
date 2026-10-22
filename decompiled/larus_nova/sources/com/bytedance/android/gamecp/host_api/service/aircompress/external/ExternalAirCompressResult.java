package com.bytedance.android.gamecp.host_api.service.aircompress.external;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/service/aircompress/external/ExternalAirCompressResult;", "", "err", "", "msg", "", "checkSumCost", "newFileCheckSum", "isAcpFileDownloaded", "", "(ILjava/lang/String;IIZ)V", "getCheckSumCost", "()I", "getErr", "()Z", "getMsg", "()Ljava/lang/String;", "getNewFileCheckSum", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExternalAirCompressResult {
    private final int checkSumCost;
    private final int err;
    private final boolean isAcpFileDownloaded;
    private final String msg;
    private final int newFileCheckSum;

    public static /* synthetic */ ExternalAirCompressResult copy$default(ExternalAirCompressResult r100, int r101, String r102, int r103, int r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.err;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.msg;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.checkSumCost;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.newFileCheckSum;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isAcpFileDownloaded;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.err;
    }

    public final String component2() {
        return this.msg;
    }

    public final int component3() {
        return this.checkSumCost;
    }

    public final int component4() {
        return this.newFileCheckSum;
    }

    public final boolean component5() {
        return this.isAcpFileDownloaded;
    }

    public final ExternalAirCompressResult copy(int r100, String r101, int r110, int r111, boolean r112) {
        return new ExternalAirCompressResult(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ExternalAirCompressResult) == false) goto L16;
        ExternalAirCompressResult r101 = (ExternalAirCompressResult) r100;
        if (this.err == r101.err) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L10;
        return false;
    L10:
        if (this.checkSumCost == r101.checkSumCost) goto L12;
        return false;
    L12:
        if (this.newFileCheckSum == r101.newFileCheckSum) goto L14;
        return false;
    L14:
        if (this.isAcpFileDownloaded == r101.isAcpFileDownloaded) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int r100 = this.err * 31;
        String r101 = this.msg;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (((((r100 + r102) * 31) + this.checkSumCost) * 31) + this.newFileCheckSum) * 31;
        boolean r104 = this.isAcpFileDownloaded;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return r103 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ExternalAirCompressResult(err=" + this.err + ", msg=" + this.msg + ", checkSumCost=" + this.checkSumCost + ", newFileCheckSum=" + this.newFileCheckSum + ", isAcpFileDownloaded=" + this.isAcpFileDownloaded + ")";
    }

    public final int getCheckSumCost() {
        return this.checkSumCost;
    }

    public final int getErr() {
        return this.err;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final int getNewFileCheckSum() {
        return this.newFileCheckSum;
    }

    public final boolean isAcpFileDownloaded() {
        return this.isAcpFileDownloaded;
    }

    public ExternalAirCompressResult(int r100, String r101, int r102, int r103, boolean r104) {
        this.err = r100;
        this.msg = r101;
        this.checkSumCost = r102;
        this.newFileCheckSum = r103;
        this.isAcpFileDownloaded = r104;
    }

    public /* synthetic */ ExternalAirCompressResult(int r100, String r101, int r102, int r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        int r103 = 0;
    L6:
        this(r103, r101, r102, r110, r111);
        return;
    L5:
        r103 = r100;
        goto L6
    }
}
