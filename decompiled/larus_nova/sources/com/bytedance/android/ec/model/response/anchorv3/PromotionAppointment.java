package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003JU\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\fHÖ\u0001J\t\u0010/\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001c¨\u00060"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionAppointment;", "Ljava/io/Serializable;", DyPayConstant.KEY_START_TIME, "", "serverTime", "startTimeText", "", "showText", "showLabel", "isAppointment", "", "appointmentNum", "", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "getAppointmentNum", "()I", "setAppointmentNum", "(I)V", "()Z", "setAppointment", "(Z)V", "getServerTime", "()J", "setServerTime", "(J)V", "getShowLabel", "()Ljava/lang/String;", "setShowLabel", "(Ljava/lang/String;)V", "getShowText", "setShowText", "getStartTime", "setStartTime", "getStartTimeText", "setStartTimeText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionAppointment implements Serializable {

    @SerializedName("appointment_num")
    private int appointmentNum;

    @SerializedName("is_appointment")
    private boolean isAppointment;

    @SerializedName("server_time")
    private long serverTime;

    @SerializedName("show_label")
    private String showLabel;

    @SerializedName("show_text")
    private String showText;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private long startTime;

    @SerializedName("start_time_text")
    private String startTimeText;

    public PromotionAppointment() {
        this(0, 0, null, null, null, false, 0, 127, null);
    }

    public static /* synthetic */ PromotionAppointment copy$default(PromotionAppointment r110, long r111, long r112, String r113, String r114, String r115, boolean r116, int r117, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        long r100 = r110.startTime;
    L7:
        if ((r210 & 2) == 0) goto L9;
        long r101 = r110.serverTime;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.startTimeText;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.showText;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.showLabel;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r105 = r110.isAppointment;
    L27:
        if ((r210 & 64) == 0) goto L29;
        int r106 = r110.appointmentNum;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106);
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
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
        return this.startTime;
    }

    public final long component2() {
        return this.serverTime;
    }

    public final String component3() {
        return this.startTimeText;
    }

    public final String component4() {
        return this.showText;
    }

    public final String component5() {
        return this.showLabel;
    }

    public final boolean component6() {
        return this.isAppointment;
    }

    public final int component7() {
        return this.appointmentNum;
    }

    public final PromotionAppointment copy(long r110, long r111, String r112, String r113, String r114, boolean r115, int r210) {
        return new PromotionAppointment(r110, r111, r112, r113, r114, r115, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionAppointment) == false) goto L20;
        PromotionAppointment r101 = (PromotionAppointment) r100;
        if (this.startTime == r101.startTime) goto L8;
        return false;
    L8:
        if (this.serverTime == r101.serverTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.startTimeText, r101.startTimeText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showText, r101.showText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.showLabel, r101.showLabel) == true) goto L16;
        return false;
    L16:
        if (this.isAppointment == r101.isAppointment) goto L18;
        return false;
    L18:
        if (this.appointmentNum == r101.appointmentNum) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    public int hashCode() {
        long r100 = this.startTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.serverTime;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.startTimeText;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (r103 + r106) * 31;
        String r108 = this.showText;
        if (r108 == null) goto L9;
        int r109 = r108.hashCode();
    L10:
        int r110 = (r107 + r109) * 31;
        String r111 = this.showLabel;
        if (r111 == null) goto L13;
        r105 = r111.hashCode();
    L13:
        int r112 = (r110 + r105) * 31;
        boolean r113 = this.isAppointment;
        ?? r114 = r113;
        if (r113 == false) goto L17;
        r114 = 1;
    L17:
        return ((r112 + r114) * 31) + this.appointmentNum;
    L9:
        r109 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    public String toString() {
        return "PromotionAppointment(startTime=" + this.startTime + ", serverTime=" + this.serverTime + ", startTimeText=" + this.startTimeText + ", showText=" + this.showText + ", showLabel=" + this.showLabel + ", isAppointment=" + this.isAppointment + ", appointmentNum=" + this.appointmentNum + ")";
    }

    public final int getAppointmentNum() {
        return this.appointmentNum;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final String getShowLabel() {
        return this.showLabel;
    }

    public final String getShowText() {
        return this.showText;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getStartTimeText() {
        return this.startTimeText;
    }

    public final boolean isAppointment() {
        return this.isAppointment;
    }

    public final void setAppointment(boolean r100) {
        this.isAppointment = r100;
    }

    public final void setAppointmentNum(int r100) {
        this.appointmentNum = r100;
    }

    public final void setServerTime(long r100) {
        this.serverTime = r100;
    }

    public final void setShowLabel(String r100) {
        this.showLabel = r100;
    }

    public final void setShowText(String r100) {
        this.showText = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public final void setStartTimeText(String r100) {
        this.startTimeText = r100;
    }

    public PromotionAppointment(long r100, long r101, String r102, String r103, String r104, boolean r105, int r106) {
        this.startTime = r100;
        this.serverTime = r101;
        this.startTimeText = r102;
        this.showText = r103;
        this.showLabel = r104;
        this.isAppointment = r105;
        this.appointmentNum = r106;
    }

    public /* synthetic */ PromotionAppointment(long r110, long r111, String r112, String r113, String r114, boolean r115, int r116, int r210, DefaultConstructorMarker r211) {
        long r100 = 0;
        if ((r210 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r210 & 2) != 0) goto L10;
        r100 = r111;
    L10:
        String r102 = "";
        if ((r210 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r210 & 16) != 0) goto L22;
        r102 = r114;
    L22:
        int r105 = 0;
        if ((r210 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r210 & 64) != 0) goto L30;
        r105 = r116;
    L30:
        this(r101, r100, r103, r104, r102, r106, r105);
        return;
    L25:
        r106 = r115;
        goto L27
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
