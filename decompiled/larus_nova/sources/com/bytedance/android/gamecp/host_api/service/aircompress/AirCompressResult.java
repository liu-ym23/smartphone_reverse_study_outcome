package com.bytedance.android.gamecp.host_api.service.aircompress;

import com.bytedance.lynx.service.monitor.LynxMonitorService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0014HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J«\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u00109\u001a\u00020\u00142\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017¨\u0006="}, d2 = {"Lcom/bytedance/android/gamecp/host_api/service/aircompress/AirCompressResult;", "", "err", "", "msg", "", "writeCost", "writeCount", "writeSemaphoreWait", "totalCost", "streamCost", LynxMonitorService.KEY_MEMORY_COST_FROM, "lzmaCost", "zstdCost", "deflateCost", "halfDeflateCost", "checkSumCost", "newFileCheckSum", "remainList", "isAcpFileDownloaded", "", "(ILjava/lang/String;IIIIIIIIIIIILjava/lang/String;Z)V", "getCheckSumCost", "()I", "getDeflateCost", "getErr", "getHalfDeflateCost", "()Z", "getLzmaCost", "getMemoryCost", "getMsg", "()Ljava/lang/String;", "getNewFileCheckSum", "getRemainList", "getStreamCost", "getTotalCost", "getWriteCost", "getWriteCount", "getWriteSemaphoreWait", "getZstdCost", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AirCompressResult {
    private final int checkSumCost;
    private final int deflateCost;
    private final int err;
    private final int halfDeflateCost;
    private final boolean isAcpFileDownloaded;
    private final int lzmaCost;
    private final int memoryCost;
    private final String msg;
    private final int newFileCheckSum;
    private final String remainList;
    private final int streamCost;
    private final int totalCost;
    private final int writeCost;
    private final int writeCount;
    private final int writeSemaphoreWait;
    private final int zstdCost;

    public static /* synthetic */ AirCompressResult copy$default(AirCompressResult r110, int r111, String r112, int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r218, int r219, int r310, int r311, String r312, boolean r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        int r100 = r110.err;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = r110.msg;
    L11:
        if ((r314 & 4) == 0) goto L13;
        int r102 = r110.writeCost;
    L15:
        if ((r314 & 8) == 0) goto L17;
        int r103 = r110.writeCount;
    L19:
        if ((r314 & 16) == 0) goto L21;
        int r104 = r110.writeSemaphoreWait;
    L23:
        if ((r314 & 32) == 0) goto L25;
        int r105 = r110.totalCost;
    L27:
        if ((r314 & 64) == 0) goto L29;
        int r106 = r110.streamCost;
    L31:
        if ((r314 & 128) == 0) goto L33;
        int r107 = r110.memoryCost;
    L35:
        if ((r314 & 256) == 0) goto L37;
        int r113 = r110.lzmaCost;
    L39:
        if ((r314 & 512) == 0) goto L41;
        int r114 = r110.zstdCost;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        int r115 = r110.deflateCost;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        int r116 = r110.halfDeflateCost;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        int r117 = r110.checkSumCost;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        int r118 = r110.newFileCheckSum;
    L58:
        int r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        String r119 = r110.remainList;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        boolean r108 = r110.isAcpFileDownloaded;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.err;
    }

    public final int component10() {
        return this.zstdCost;
    }

    public final int component11() {
        return this.deflateCost;
    }

    public final int component12() {
        return this.halfDeflateCost;
    }

    public final int component13() {
        return this.checkSumCost;
    }

    public final int component14() {
        return this.newFileCheckSum;
    }

    public final String component15() {
        return this.remainList;
    }

    public final boolean component16() {
        return this.isAcpFileDownloaded;
    }

    public final String component2() {
        return this.msg;
    }

    public final int component3() {
        return this.writeCost;
    }

    public final int component4() {
        return this.writeCount;
    }

    public final int component5() {
        return this.writeSemaphoreWait;
    }

    public final int component6() {
        return this.totalCost;
    }

    public final int component7() {
        return this.streamCost;
    }

    public final int component8() {
        return this.memoryCost;
    }

    public final int component9() {
        return this.lzmaCost;
    }

    public final AirCompressResult copy(int r110, String r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r218, int r219, int r310, int r311, int r312, String r313, boolean r314) {
        Intrinsics.checkNotNullParameter(r313, "remainList");
        return new AirCompressResult(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AirCompressResult) == false) goto L38;
        AirCompressResult r101 = (AirCompressResult) r100;
        if (this.err == r101.err) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L10;
        return false;
    L10:
        if (this.writeCost == r101.writeCost) goto L12;
        return false;
    L12:
        if (this.writeCount == r101.writeCount) goto L14;
        return false;
    L14:
        if (this.writeSemaphoreWait == r101.writeSemaphoreWait) goto L16;
        return false;
    L16:
        if (this.totalCost == r101.totalCost) goto L18;
        return false;
    L18:
        if (this.streamCost == r101.streamCost) goto L20;
        return false;
    L20:
        if (this.memoryCost == r101.memoryCost) goto L22;
        return false;
    L22:
        if (this.lzmaCost == r101.lzmaCost) goto L24;
        return false;
    L24:
        if (this.zstdCost == r101.zstdCost) goto L26;
        return false;
    L26:
        if (this.deflateCost == r101.deflateCost) goto L28;
        return false;
    L28:
        if (this.halfDeflateCost == r101.halfDeflateCost) goto L30;
        return false;
    L30:
        if (this.checkSumCost == r101.checkSumCost) goto L32;
        return false;
    L32:
        if (this.newFileCheckSum == r101.newFileCheckSum) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.remainList, r101.remainList) == true) goto L36;
        return false;
    L36:
        if (this.isAcpFileDownloaded == r101.isAcpFileDownloaded) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v20 */
    public int hashCode() {
        int r100 = this.err * 31;
        String r101 = this.msg;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((((((((((((((((((((((((r100 + r103) * 31) + this.writeCost) * 31) + this.writeCount) * 31) + this.writeSemaphoreWait) * 31) + this.totalCost) * 31) + this.streamCost) * 31) + this.memoryCost) * 31) + this.lzmaCost) * 31) + this.zstdCost) * 31) + this.deflateCost) * 31) + this.halfDeflateCost) * 31) + this.checkSumCost) * 31) + this.newFileCheckSum) * 31;
        String r105 = this.remainList;
        if (r105 == null) goto L9;
        r102 = r105.hashCode();
    L9:
        int r106 = (r104 + r102) * 31;
        boolean r107 = this.isAcpFileDownloaded;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        return r106 + r108;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "AirCompressResult(err=" + this.err + ", msg=" + this.msg + ", writeCost=" + this.writeCost + ", writeCount=" + this.writeCount + ", writeSemaphoreWait=" + this.writeSemaphoreWait + ", totalCost=" + this.totalCost + ", streamCost=" + this.streamCost + ", memoryCost=" + this.memoryCost + ", lzmaCost=" + this.lzmaCost + ", zstdCost=" + this.zstdCost + ", deflateCost=" + this.deflateCost + ", halfDeflateCost=" + this.halfDeflateCost + ", checkSumCost=" + this.checkSumCost + ", newFileCheckSum=" + this.newFileCheckSum + ", remainList=" + this.remainList + ", isAcpFileDownloaded=" + this.isAcpFileDownloaded + ")";
    }

    public final int getCheckSumCost() {
        return this.checkSumCost;
    }

    public final int getDeflateCost() {
        return this.deflateCost;
    }

    public final int getErr() {
        return this.err;
    }

    public final int getHalfDeflateCost() {
        return this.halfDeflateCost;
    }

    public final int getLzmaCost() {
        return this.lzmaCost;
    }

    public final int getMemoryCost() {
        return this.memoryCost;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final int getNewFileCheckSum() {
        return this.newFileCheckSum;
    }

    public final String getRemainList() {
        return this.remainList;
    }

    public final int getStreamCost() {
        return this.streamCost;
    }

    public final int getTotalCost() {
        return this.totalCost;
    }

    public final int getWriteCost() {
        return this.writeCost;
    }

    public final int getWriteCount() {
        return this.writeCount;
    }

    public final int getWriteSemaphoreWait() {
        return this.writeSemaphoreWait;
    }

    public final int getZstdCost() {
        return this.zstdCost;
    }

    public final boolean isAcpFileDownloaded() {
        return this.isAcpFileDownloaded;
    }

    public AirCompressResult(int r100, String r101, int r102, int r103, int r104, int r105, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, String r118, boolean r119) {
        Intrinsics.checkNotNullParameter(r118, "remainList");
        this.err = r100;
        this.msg = r101;
        this.writeCost = r102;
        this.writeCount = r103;
        this.writeSemaphoreWait = r104;
        this.totalCost = r105;
        this.streamCost = r110;
        this.memoryCost = r111;
        this.lzmaCost = r112;
        this.zstdCost = r113;
        this.deflateCost = r114;
        this.halfDeflateCost = r115;
        this.checkSumCost = r116;
        this.newFileCheckSum = r117;
        this.remainList = r118;
        this.isAcpFileDownloaded = r119;
    }

    public /* synthetic */ AirCompressResult(int r110, String r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r218, int r219, int r310, int r311, int r312, String r313, boolean r314, int r315, DefaultConstructorMarker r316) {
        if ((r315 & 1) == 0) goto L5;
        int r100 = 0;
    L6:
        this(r100, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
        return;
    L5:
        r100 = r110;
        goto L6
    }
}
