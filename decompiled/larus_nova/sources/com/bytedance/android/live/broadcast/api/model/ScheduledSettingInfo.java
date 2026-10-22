package com.bytedance.android.live.broadcast.api.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u001e\b\u0086\b\u0018\u0000 22\u00020\u0001:\u00013BQ\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b0\u00101J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0003JS\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010 \u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R$\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)¨\u00064"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/ScheduledSettingInfo;", "Ljava/io/Serializable;", "", "component1", "component2", "", "component3", "", "component4", "component5", "component6", "component7", "masterSwitch", "profileSwitch", "pushSwitch", "anchorScheduledTime", "anchorScheduledDays", "noticeSwitchDisplay", "scheduledTimeWords", "copy", "toString", "hashCode", "", "other", "equals", "Z", "getMasterSwitch", "()Z", "setMasterSwitch", "(Z)V", "getProfileSwitch", "setProfileSwitch", "I", "getPushSwitch", "()I", "setPushSwitch", "(I)V", "Ljava/lang/String;", "getAnchorScheduledTime", "()Ljava/lang/String;", "setAnchorScheduledTime", "(Ljava/lang/String;)V", "getAnchorScheduledDays", "setAnchorScheduledDays", "getNoticeSwitchDisplay", "setNoticeSwitchDisplay", "getScheduledTimeWords", "setScheduledTimeWords", "<init>", "(ZZILjava/lang/String;IILjava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScheduledSettingInfo implements Serializable {
    public static final a Companion = null;

    @SerializedName("scheduled_days")
    private int anchorScheduledDays;

    @SerializedName("scheduled_time")
    private String anchorScheduledTime;

    @SerializedName("scheduled_master_switch")
    private boolean masterSwitch;

    @SerializedName("scheduled_notice_switch_display")
    private int noticeSwitchDisplay;

    @SerializedName("scheduled_profile_switch")
    private boolean profileSwitch;

    @SerializedName("scheduled_notice_switch")
    private int pushSwitch;

    @SerializedName("scheduled_time_text")
    private String scheduledTimeWords;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ScheduledSettingInfo() {
        this(false, false, 0, null, 0, 0, null, 127, null);
    }

    public static /* synthetic */ ScheduledSettingInfo copy$default(ScheduledSettingInfo r100, boolean r101, boolean r102, int r103, String r104, int r110, int r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.masterSwitch;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.profileSwitch;
    L8:
        boolean r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.pushSwitch;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.anchorScheduledTime;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.anchorScheduledDays;
    L17:
        int r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.noticeSwitchDisplay;
    L20:
        int r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.scheduledTimeWords;
    L23:
        boolean r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final boolean component1() {
        return this.masterSwitch;
    }

    public final boolean component2() {
        return this.profileSwitch;
    }

    public final int component3() {
        return this.pushSwitch;
    }

    public final String component4() {
        return this.anchorScheduledTime;
    }

    public final int component5() {
        return this.anchorScheduledDays;
    }

    public final int component6() {
        return this.noticeSwitchDisplay;
    }

    public final String component7() {
        return this.scheduledTimeWords;
    }

    public final ScheduledSettingInfo copy(boolean r110, boolean r111, int r112, String r113, int r114, int r115, String r116) {
        return new ScheduledSettingInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ScheduledSettingInfo) == false) goto L20;
        ScheduledSettingInfo r101 = (ScheduledSettingInfo) r100;
        if (this.masterSwitch == r101.masterSwitch) goto L8;
        return false;
    L8:
        if (this.profileSwitch == r101.profileSwitch) goto L10;
        return false;
    L10:
        if (this.pushSwitch == r101.pushSwitch) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.anchorScheduledTime, r101.anchorScheduledTime) == true) goto L14;
        return false;
    L14:
        if (this.anchorScheduledDays == r101.anchorScheduledDays) goto L16;
        return false;
    L16:
        if (this.noticeSwitchDisplay == r101.noticeSwitchDisplay) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.scheduledTimeWords, r101.scheduledTimeWords) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    public int hashCode() {
        boolean r100 = this.masterSwitch;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.profileSwitch;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (((r103 + r101) * 31) + this.pushSwitch) * 31;
        String r106 = this.anchorScheduledTime;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.hashCode();
    L13:
        int r109 = (((((r105 + r108) * 31) + this.anchorScheduledDays) * 31) + this.noticeSwitchDisplay) * 31;
        String r110 = this.scheduledTimeWords;
        if (r110 == null) goto L17;
        r107 = r110.hashCode();
    L17:
        return r109 + r107;
    L12:
        r108 = 0;
        goto L13
    }

    public String toString() {
        return "ScheduledSettingInfo(masterSwitch=" + this.masterSwitch + ", profileSwitch=" + this.profileSwitch + ", pushSwitch=" + this.pushSwitch + ", anchorScheduledTime=" + this.anchorScheduledTime + ", anchorScheduledDays=" + this.anchorScheduledDays + ", noticeSwitchDisplay=" + this.noticeSwitchDisplay + ", scheduledTimeWords=" + this.scheduledTimeWords + ")";
    }

    public final int getAnchorScheduledDays() {
        return this.anchorScheduledDays;
    }

    public final String getAnchorScheduledTime() {
        return this.anchorScheduledTime;
    }

    public final boolean getMasterSwitch() {
        return this.masterSwitch;
    }

    public final int getNoticeSwitchDisplay() {
        return this.noticeSwitchDisplay;
    }

    public final boolean getProfileSwitch() {
        return this.profileSwitch;
    }

    public final int getPushSwitch() {
        return this.pushSwitch;
    }

    public final String getScheduledTimeWords() {
        return this.scheduledTimeWords;
    }

    @JvmStatic
    public static final ScheduledSettingInfo from(ScheduledSettingInfo r110) {
        Companion.getClass();
        ScheduledSettingInfo r100 = new ScheduledSettingInfo(false, false, 0, null, 0, 0, null, 127, null);
        if (r110 == null) goto L5;
        r100.setMasterSwitch(r110.getMasterSwitch());
        r100.setProfileSwitch(r110.getProfileSwitch());
        r100.setPushSwitch(r110.getPushSwitch());
        r100.setAnchorScheduledTime(r110.getAnchorScheduledTime());
        r100.setAnchorScheduledDays(r110.getAnchorScheduledDays());
        r100.setScheduledTimeWords(r110.getScheduledTimeWords());
        r100.setNoticeSwitchDisplay(r110.getNoticeSwitchDisplay());
    L5:
        return r100;
    }

    public final void setAnchorScheduledDays(int r100) {
        this.anchorScheduledDays = r100;
    }

    public final void setAnchorScheduledTime(String r100) {
        this.anchorScheduledTime = r100;
    }

    public final void setMasterSwitch(boolean r100) {
        this.masterSwitch = r100;
    }

    public final void setNoticeSwitchDisplay(int r100) {
        this.noticeSwitchDisplay = r100;
    }

    public final void setProfileSwitch(boolean r100) {
        this.profileSwitch = r100;
    }

    public final void setPushSwitch(int r100) {
        this.pushSwitch = r100;
    }

    public final void setScheduledTimeWords(String r100) {
        this.scheduledTimeWords = r100;
    }

    public ScheduledSettingInfo(boolean r100, boolean r101, int r102, String r103, int r104, int r105, String r106) {
        this.masterSwitch = r100;
        this.profileSwitch = r101;
        this.pushSwitch = r102;
        this.anchorScheduledTime = r103;
        this.anchorScheduledDays = r104;
        this.noticeSwitchDisplay = r105;
        this.scheduledTimeWords = r106;
    }

    public /* synthetic */ ScheduledSettingInfo(boolean r100, boolean r101, int r102, String r103, int r110, int r111, String r112, int r113, DefaultConstructorMarker r114) {
        int r104 = 0;
        if ((r113 & 1) == 0) goto L5;
        boolean r115 = false;
    L7:
        if ((r113 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r113 & 4) == 0) goto L13;
        int r106 = 0;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r113 & 16) == 0) goto L21;
        int r108 = 0;
    L23:
        if ((r113 & 32) != 0) goto L27;
        r104 = r111;
    L27:
        if ((r113 & 64) == 0) goto L29;
        String r116 = null;
    L30:
        this(r115, r105, r106, r107, r108, r104, r116);
        return;
    L29:
        r116 = r112;
        goto L30
    L21:
        r108 = r110;
        goto L23
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
