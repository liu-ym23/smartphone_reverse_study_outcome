package com.bytedance.android.live.profit.scoreboard;

import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/o;", "", "", "counterId", "Ljava/lang/String;", "getCounterId", "()Ljava/lang/String;", "", "Lcom/bytedance/android/live/profit/scoreboard/m;", "points", "Ljava/util/List;", "c", "()Ljava/util/List;", "", UserInfo.UPDATE_TIME, "J", "d", "()J", "expectFinishTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "actualFinishTime", "getActualFinishTime", "", "leftResetTime", "I", "b", "()I", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f88936a;

    @SerializedName("actual_finish_time")
    private final long actualFinishTime;

    @SerializedName("counter_id")
    private final String counterId;

    @SerializedName("expect_finish_time")
    private final long expectFinishTime;

    @SerializedName("left_reset_time")
    private final int leftResetTime;

    @SerializedName("points")
    private final List<m> points;

    @SerializedName("update_time")
    private final long updateTime;

    public o() {
        this(null, null, 0, 0, 0, 0, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L20;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.counterId, r101.counterId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.points, r101.points) == true) goto L10;
        return false;
    L10:
        if (this.updateTime == r101.updateTime) goto L12;
        return false;
    L12:
        if (this.expectFinishTime == r101.expectFinishTime) goto L14;
        return false;
    L14:
        if (this.actualFinishTime == r101.actualFinishTime) goto L16;
        return false;
    L16:
        if (this.leftResetTime == r101.leftResetTime) goto L18;
        return false;
    L18:
        if (this.f88936a == r101.f88936a) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public final int hashCode() {
        String r100 = this.counterId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<m> r104 = this.points;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.updateTime;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.expectFinishTime;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.actualFinishTime;
        int r111 = (((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.leftResetTime) * 31;
        boolean r112 = this.f88936a;
        ?? r113 = r112;
        if (r112 == false) goto L13;
        r113 = 1;
    L13:
        return r111 + r113;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ScoreCountingMessage(counterId=" + this.counterId + ", points=" + this.points + ", updateTime=" + this.updateTime + ", expectFinishTime=" + this.expectFinishTime + ", actualFinishTime=" + this.actualFinishTime + ", leftResetTime=" + this.leftResetTime + ", isNextRoundStarted=" + this.f88936a + ")";
    }

    public final long a() {
        return this.expectFinishTime;
    }

    public final int b() {
        return this.leftResetTime;
    }

    public final List<m> c() {
        return this.points;
    }

    public final long d() {
        return this.updateTime;
    }

    public o(String r100, List r101, long r102, long r103, long r110, int r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r100 = "0";
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        if ((r112 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r112 & 8) == 0) goto L15;
        r103 = 0;
    L15:
        if ((r112 & 16) == 0) goto L18;
        r110 = 0;
    L18:
        if ((r112 & 32) == 0) goto L20;
        r111 = 60;
    L20:
        Intrinsics.checkNotNullParameter(r100, "counterId");
        Intrinsics.checkNotNullParameter(r101, "points");
        this.counterId = r100;
        this.points = r101;
        this.updateTime = r102;
        this.expectFinishTime = r103;
        this.actualFinishTime = r110;
        this.leftResetTime = r111;
        this.f88936a = false;
    }
}
