package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/i2;", "", "", "maxTime", "J", "e", "()J", "jumpCheckTime", "b", "", "maxStack", "I", "d", "()I", "maxScanCnt", "c", "", "scanTime", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "frequencyTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "scanInThread", "Z", "f", "()Z", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i2 {

    @SerializedName("frequency_time")
    private final List<Long> frequencyTime;

    @SerializedName("jump_check_time")
    private final long jumpCheckTime;

    @SerializedName("max_scan_cnt")
    private final int maxScanCnt;

    @SerializedName("max_stack")
    private final int maxStack;

    @SerializedName("max_time")
    private final long maxTime;

    @SerializedName("scan_in_thread")
    private final boolean scanInThread;

    @SerializedName(EventConstants.ExtraJson.SCAN_TIME)
    private final List<Long> scanTime;

    public i2() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i2) == false) goto L20;
        i2 r101 = (i2) r100;
        if (this.maxTime == r101.maxTime) goto L8;
        return false;
    L8:
        if (this.jumpCheckTime == r101.jumpCheckTime) goto L10;
        return false;
    L10:
        if (this.maxStack == r101.maxStack) goto L12;
        return false;
    L12:
        if (this.maxScanCnt == r101.maxScanCnt) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.scanTime, r101.scanTime) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.frequencyTime, r101.frequencyTime) == true) goto L18;
        return false;
    L18:
        if (this.scanInThread == r101.scanInThread) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    public final int hashCode() {
        long r100 = this.maxTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.jumpCheckTime;
        int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.maxStack) * 31) + this.maxScanCnt) * 31;
        List<Long> r104 = this.scanTime;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (r103 + r106) * 31;
        List<Long> r108 = this.frequencyTime;
        if (r108 == null) goto L9;
        r105 = r108.hashCode();
    L9:
        int r109 = (r107 + r105) * 31;
        boolean r110 = this.scanInThread;
        ?? r111 = r110;
        if (r110 == false) goto L13;
        r111 = 1;
    L13:
        return r109 + r111;
    L5:
        r106 = 0;
        goto L6
    }

    public final String toString() {
        return "InstallFrequencyConfig(maxTime=" + this.maxTime + ", jumpCheckTime=" + this.jumpCheckTime + ", maxStack=" + this.maxStack + ", maxScanCnt=" + this.maxScanCnt + ", scanTime=" + this.scanTime + ", frequencyTime=" + this.frequencyTime + ", scanInThread=" + this.scanInThread + ")";
    }

    public final List<Long> a() {
        return this.frequencyTime;
    }

    public final long b() {
        return this.jumpCheckTime;
    }

    public final int c() {
        return this.maxScanCnt;
    }

    public final int d() {
        return this.maxStack;
    }

    public final long e() {
        return this.maxTime;
    }

    public final boolean f() {
        return this.scanInThread;
    }

    public final List<Long> g() {
        return this.scanTime;
    }

    public i2(Object r100) {
        List<Long> r101 = CollectionsKt.listOf(new Long[]{1000L, 15000L});
        List<Long> r102 = CollectionsKt.listOf(new Long[]{120000L, 300000L});
        Intrinsics.checkNotNullParameter(r101, "scanTime");
        Intrinsics.checkNotNullParameter(r102, "frequencyTime");
        this.maxTime = 300000;
        this.jumpCheckTime = 5000;
        this.maxStack = 10;
        this.maxScanCnt = 140;
        this.scanTime = r101;
        this.frequencyTime = r102;
        this.scanInThread = false;
    }
}
