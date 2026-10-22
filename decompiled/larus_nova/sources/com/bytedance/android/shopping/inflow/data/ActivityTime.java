package com.bytedance.android.shopping.inflow.data;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JQ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/inflow/data/ActivityTime;", "Ljava/io/Serializable;", "serverTime", "", DyPayConstant.KEY_START_TIME, "endTime", "preStartTime", "restBeginTime", "restEndTime", "countDownTextBgColor", "", "(JJJJJJLjava/lang/String;)V", "getCountDownTextBgColor", "()Ljava/lang/String;", "getEndTime", "()J", "getPreStartTime", "getRestBeginTime", "getRestEndTime", "getServerTime", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityTime implements Serializable {

    @SerializedName("count_down_text_bg_color")
    private final String countDownTextBgColor;

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("pre_start_time")
    private final long preStartTime;

    @SerializedName("rest_begin_time")
    private final long restBeginTime;

    @SerializedName("rest_end_time")
    private final long restEndTime;

    @SerializedName("server_time")
    private final long serverTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final long startTime;

    public ActivityTime() {
        this(0, 0, 0, 0, 0, 0, null, 127, null);
    }

    public static /* synthetic */ ActivityTime copy$default(ActivityTime r110, long r111, long r112, long r113, long r210, long r211, long r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        long r100 = r110.serverTime;
    L7:
        if ((r214 & 2) == 0) goto L9;
        long r101 = r110.startTime;
    L11:
        if ((r214 & 4) == 0) goto L13;
        long r102 = r110.endTime;
    L15:
        if ((r214 & 8) == 0) goto L17;
        long r103 = r110.preStartTime;
    L19:
        if ((r214 & 16) == 0) goto L21;
        long r104 = r110.restBeginTime;
    L23:
        if ((r214 & 32) == 0) goto L25;
        long r114 = r110.restEndTime;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r115 = r110.countDownTextBgColor;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r114, r115);
    L29:
        r115 = r213;
        goto L31
    L25:
        r114 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.serverTime;
    }

    public final long component2() {
        return this.startTime;
    }

    public final long component3() {
        return this.endTime;
    }

    public final long component4() {
        return this.preStartTime;
    }

    public final long component5() {
        return this.restBeginTime;
    }

    public final long component6() {
        return this.restEndTime;
    }

    public final String component7() {
        return this.countDownTextBgColor;
    }

    public final ActivityTime copy(long r110, long r111, long r210, long r211, long r212, long r213, String r214) {
        return new ActivityTime(r110, r111, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ActivityTime) == false) goto L20;
        ActivityTime r101 = (ActivityTime) r100;
        if (this.serverTime == r101.serverTime) goto L8;
        return false;
    L8:
        if (this.startTime == r101.startTime) goto L10;
        return false;
    L10:
        if (this.endTime == r101.endTime) goto L12;
        return false;
    L12:
        if (this.preStartTime == r101.preStartTime) goto L14;
        return false;
    L14:
        if (this.restBeginTime == r101.restBeginTime) goto L16;
        return false;
    L16:
        if (this.restEndTime == r101.restEndTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.countDownTextBgColor, r101.countDownTextBgColor) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        long r100 = this.serverTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.startTime;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.endTime;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.preStartTime;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.restBeginTime;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.restEndTime;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.countDownTextBgColor;
        if (r112 == null) goto L5;
        int r113 = r112.hashCode();
    L7:
        return r111 + r113;
    L5:
        r113 = 0;
        goto L7
    }

    public String toString() {
        return "ActivityTime(serverTime=" + this.serverTime + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", preStartTime=" + this.preStartTime + ", restBeginTime=" + this.restBeginTime + ", restEndTime=" + this.restEndTime + ", countDownTextBgColor=" + this.countDownTextBgColor + ")";
    }

    public final String getCountDownTextBgColor() {
        return this.countDownTextBgColor;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getPreStartTime() {
        return this.preStartTime;
    }

    public final long getRestBeginTime() {
        return this.restBeginTime;
    }

    public final long getRestEndTime() {
        return this.restEndTime;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public ActivityTime(long r100, long r101, long r102, long r103, long r104, long r110, String r111) {
        this.serverTime = r100;
        this.startTime = r101;
        this.endTime = r102;
        this.preStartTime = r103;
        this.restBeginTime = r104;
        this.restEndTime = r110;
        this.countDownTextBgColor = r111;
    }

    public /* synthetic */ ActivityTime(long r110, long r111, long r112, long r210, long r211, long r212, String r213, int r214, DefaultConstructorMarker r215) {
        long r100 = 0;
        if ((r214 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r214 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r214 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r214 & 8) == 0) goto L17;
        long r104 = 0;
    L19:
        if ((r214 & 16) == 0) goto L21;
        long r113 = 0;
    L23:
        if ((r214 & 32) != 0) goto L27;
        r100 = r212;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r105 = null;
    L30:
        this(r101, r102, r103, r104, r113, r100, r105);
        return;
    L29:
        r105 = r213;
        goto L30
    L21:
        r113 = r211;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
