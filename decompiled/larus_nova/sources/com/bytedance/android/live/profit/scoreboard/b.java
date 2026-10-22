package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/b;", "", "", "counterId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", UserInfo.UPDATE_TIME, "J", "e", "()J", DyPayConstant.KEY_START_TIME, "d", "expectFinishTime", "c", "actualFinishTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/live/profit/scoreboard/n;", com.heytap.mcssdk.constant.b.f276366p, "Lcom/bytedance/android/live/profit/scoreboard/n;", "getRule", "()Lcom/bytedance/android/live/profit/scoreboard/n;", "", "Lcom/bytedance/android/live/profit/scoreboard/n1;", "topContributors", "Ljava/util/List;", "getTopContributors", "()Ljava/util/List;", "Lcom/bytedance/android/live/profit/scoreboard/m;", "points", "getPoints", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("actual_finish_time")
    private final long actualFinishTime;

    @SerializedName("counter_id")
    private final String counterId;

    @SerializedName("expect_finish_time")
    private final long expectFinishTime;

    @SerializedName("points")
    private final List<m> points;

    @SerializedName(com.heytap.mcssdk.constant.b.f276366p)
    private final n rule;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final long startTime;

    @SerializedName("top_contributors")
    private final List<n1> topContributors;

    @SerializedName("update_time")
    private final long updateTime;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L22;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.counterId, r101.counterId) == true) goto L8;
        return false;
    L8:
        if (this.updateTime == r101.updateTime) goto L10;
        return false;
    L10:
        if (this.startTime == r101.startTime) goto L12;
        return false;
    L12:
        if (this.expectFinishTime == r101.expectFinishTime) goto L14;
        return false;
    L14:
        if (this.actualFinishTime == r101.actualFinishTime) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.rule, r101.rule) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.topContributors, r101.topContributors) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.points, r101.points) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.counterId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.updateTime;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.startTime;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.expectFinishTime;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.actualFinishTime;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        n r111 = this.rule;
        if (r111 == null) goto L9;
        int r112 = r111.hashCode();
    L10:
        int r113 = (r110 + r112) * 31;
        List<n1> r114 = this.topContributors;
        if (r114 == null) goto L13;
        int r115 = r114.hashCode();
    L14:
        int r116 = (r113 + r115) * 31;
        List<m> r117 = this.points;
        if (r117 == null) goto L18;
        r101 = r117.hashCode();
    L18:
        return r116 + r101;
    L13:
        r115 = 0;
        goto L14
    L9:
        r112 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CounterInfo(counterId=" + this.counterId + ", updateTime=" + this.updateTime + ", startTime=" + this.startTime + ", expectFinishTime=" + this.expectFinishTime + ", actualFinishTime=" + this.actualFinishTime + ", rule=" + this.rule + ", topContributors=" + this.topContributors + ", points=" + this.points + ")";
    }

    public final long a() {
        return this.actualFinishTime;
    }

    public final String b() {
        return this.counterId;
    }

    public final long c() {
        return this.expectFinishTime;
    }

    public final long d() {
        return this.startTime;
    }

    public final long e() {
        return this.updateTime;
    }

    public /* synthetic */ b(int r110) {
        this("0", 0, 0, 0, 0, new n(0), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public b(String r100, long r101, long r102, long r103, long r104, n r110, List<n1> r111, List<m> r112) {
        Intrinsics.checkNotNullParameter(r100, "counterId");
        Intrinsics.checkNotNullParameter(r110, com.heytap.mcssdk.constant.b.f276366p);
        Intrinsics.checkNotNullParameter(r111, "topContributors");
        this.counterId = r100;
        this.updateTime = r101;
        this.startTime = r102;
        this.expectFinishTime = r103;
        this.actualFinishTime = r104;
        this.rule = r110;
        this.topContributors = r111;
        this.points = r112;
    }
}
