package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003Js\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\rHÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityTime;", "Ljava/io/Serializable;", "serverTime", "", DyPayConstant.KEY_START_TIME, "endTime", "preStartTime", "restBeginTime", "restEndTime", "activityDesc", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "countdownInterval", "countDownTextBgColor", "", "countDownTextStyle", "Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;", "(JJJJJJLcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;JLjava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;)V", "getActivityDesc", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getCountDownTextBgColor", "()Ljava/lang/String;", "getCountDownTextStyle", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;", "getCountdownInterval", "()J", "getEndTime", "getPreStartTime", "getRestBeginTime", "getRestEndTime", "getServerTime", "getStartTime", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityTime implements Serializable {

    @SerializedName("activity_desc")
    private final TextElement activityDesc;

    @SerializedName("count_down_text_bg_color")
    private final String countDownTextBgColor;

    @SerializedName("count_down_text_style")
    private final FontStyle countDownTextStyle;

    @SerializedName("interval_time")
    private final long countdownInterval;

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
        this(0, 0, 0, 0, 0, 0, null, 0, null, null, 1023, null);
    }

    public static /* synthetic */ ActivityTime copy$default(ActivityTime r110, long r111, long r112, long r210, long r211, long r212, long r213, TextElement r214, long r310, String r311, FontStyle r312, int r313, Object r314) {
        if ((r313 & 1) == 0) goto L5;
        long r100 = r110.serverTime;
    L7:
        if ((r313 & 2) == 0) goto L9;
        long r101 = r110.startTime;
    L11:
        if ((r313 & 4) == 0) goto L13;
        long r102 = r110.endTime;
    L15:
        if ((r313 & 8) == 0) goto L17;
        long r103 = r110.preStartTime;
    L19:
        if ((r313 & 16) == 0) goto L21;
        long r113 = r110.restBeginTime;
    L23:
        if ((r313 & 32) == 0) goto L25;
        long r114 = r110.restEndTime;
    L27:
        if ((r313 & 64) == 0) goto L29;
        TextElement r115 = r110.activityDesc;
    L30:
        TextElement r215 = r115;
        if ((r313 & 128) == 0) goto L33;
        long r116 = r110.countdownInterval;
    L34:
        long r315 = r116;
        if ((r313 & 256) == 0) goto L37;
        String r117 = r110.countDownTextBgColor;
    L39:
        if ((r313 & 512) == 0) goto L41;
        FontStyle r104 = r110.countDownTextStyle;
    L43:
        return r110.copy(r100, r101, r102, r103, r113, r114, r215, r315, r117, r104);
    L41:
        r104 = r312;
        goto L43
    L37:
        r117 = r311;
        goto L39
    L33:
        r116 = r310;
        goto L34
    L29:
        r115 = r214;
        goto L30
    L25:
        r114 = r213;
        goto L27
    L21:
        r113 = r212;
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

    public final long component1() {
        return this.serverTime;
    }

    public final FontStyle component10() {
        return this.countDownTextStyle;
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

    public final TextElement component7() {
        return this.activityDesc;
    }

    public final long component8() {
        return this.countdownInterval;
    }

    public final String component9() {
        return this.countDownTextBgColor;
    }

    public final ActivityTime copy(long r210, long r211, long r212, long r213, long r214, long r310, TextElement r311, long r312, String r313, FontStyle r314) {
        return new ActivityTime(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ActivityTime) == false) goto L26;
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
        if (Intrinsics.areEqual(this.activityDesc, r101.activityDesc) == true) goto L20;
        return false;
    L20:
        if (this.countdownInterval == r101.countdownInterval) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.countDownTextBgColor, r101.countDownTextBgColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.countDownTextStyle, r101.countDownTextStyle) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
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
        TextElement r112 = this.activityDesc;
        int r113 = 0;
        if (r112 == null) goto L5;
        int r114 = r112.hashCode();
    L6:
        long r115 = this.countdownInterval;
        int r116 = (((r111 + r114) * 31) + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        String r117 = this.countDownTextBgColor;
        if (r117 == null) goto L9;
        int r118 = r117.hashCode();
    L10:
        int r119 = (r116 + r118) * 31;
        FontStyle r120 = this.countDownTextStyle;
        if (r120 == null) goto L14;
        r113 = r120.hashCode();
    L14:
        return r119 + r113;
    L9:
        r118 = 0;
        goto L10
    L5:
        r114 = 0;
        goto L6
    }

    public String toString() {
        return "ActivityTime(serverTime=" + this.serverTime + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", preStartTime=" + this.preStartTime + ", restBeginTime=" + this.restBeginTime + ", restEndTime=" + this.restEndTime + ", activityDesc=" + this.activityDesc + ", countdownInterval=" + this.countdownInterval + ", countDownTextBgColor=" + this.countDownTextBgColor + ", countDownTextStyle=" + this.countDownTextStyle + ")";
    }

    public final TextElement getActivityDesc() {
        return this.activityDesc;
    }

    public final String getCountDownTextBgColor() {
        return this.countDownTextBgColor;
    }

    public final FontStyle getCountDownTextStyle() {
        return this.countDownTextStyle;
    }

    public final long getCountdownInterval() {
        return this.countdownInterval;
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

    public ActivityTime(long r100, long r101, long r102, long r110, long r111, long r112, TextElement r113, long r114, String r115, FontStyle r210) {
        this.serverTime = r100;
        this.startTime = r101;
        this.endTime = r102;
        this.preStartTime = r110;
        this.restBeginTime = r111;
        this.restEndTime = r112;
        this.activityDesc = r113;
        this.countdownInterval = r114;
        this.countDownTextBgColor = r115;
        this.countDownTextStyle = r210;
    }

    public /* synthetic */ ActivityTime(long r110, long r210, long r211, long r212, long r213, long r214, TextElement r310, long r311, String r312, FontStyle r313, int r314, DefaultConstructorMarker r315) {
        long r100 = 0;
        if ((r314 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r314 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r314 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r314 & 8) == 0) goto L17;
        long r111 = 0;
    L19:
        if ((r314 & 16) == 0) goto L21;
        long r112 = 0;
    L23:
        if ((r314 & 32) != 0) goto L27;
        r100 = r214;
    L27:
        if ((r314 & 64) == 0) goto L29;
        TextElement r104 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        long r113 = 1000;
    L35:
        if ((r314 & 256) == 0) goto L37;
        String r114 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        FontStyle r105 = null;
    L42:
        this(r101, r102, r103, r111, r112, r100, r104, r113, r114, r105);
        return;
    L41:
        r105 = r313;
        goto L42
    L37:
        r114 = r312;
        goto L39
    L33:
        r113 = r311;
        goto L35
    L29:
        r104 = r310;
        goto L31
    L21:
        r112 = r213;
        goto L23
    L17:
        r111 = r212;
        goto L19
    L13:
        r103 = r211;
        goto L15
    L9:
        r102 = r210;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
