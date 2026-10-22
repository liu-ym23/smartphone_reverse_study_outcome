package com.bytedance.applet.aibridge.calendar;

import com.alipay.sdk.m.x.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015Jx\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017¨\u0006:"}, d2 = {"Lcom/bytedance/applet/aibridge/calendar/RemindInfo;", "", "id", "", "dtStart", "", "duration", "rRule", "title", "group", "location", "enableRemind", "", "remindDate", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getDtStart", "()Ljava/lang/Long;", "setDtStart", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDuration", "setDuration", "getRRule", "setRRule", "getTitle", d.f25925o, "getGroup", "setGroup", "getLocation", "setLocation", "getEnableRemind", "()Ljava/lang/Boolean;", "setEnableRemind", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRemindDate", "setRemindDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/bytedance/applet/aibridge/calendar/RemindInfo;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemindInfo {
    private Long dtStart;
    private Long duration;
    private Boolean enableRemind;
    private String group;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f190996id;
    private String location;
    private String rRule;
    private Long remindDate;
    private String title;

    public RemindInfo() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ RemindInfo copy$default(RemindInfo r110, String r111, Long r112, Long r113, String r114, String r115, String r116, String r117, Boolean r118, Long r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.f190996id;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Long r101 = r110.dtStart;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Long r102 = r110.duration;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.rRule;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.title;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.group;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.location;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Boolean r107 = r110.enableRemind;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Long r108 = r110.remindDate;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
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

    public final String component1() {
        return this.f190996id;
    }

    public final Long component2() {
        return this.dtStart;
    }

    public final Long component3() {
        return this.duration;
    }

    public final String component4() {
        return this.rRule;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.group;
    }

    public final String component7() {
        return this.location;
    }

    public final Boolean component8() {
        return this.enableRemind;
    }

    public final Long component9() {
        return this.remindDate;
    }

    public final RemindInfo copy(String r110, Long r111, Long r112, String r113, String r114, String r115, String r116, Boolean r117, Long r210) {
        Intrinsics.checkNotNullParameter(r110, "id");
        return new RemindInfo(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RemindInfo) == true) goto L8;
        return false;
    L8:
        RemindInfo r101 = (RemindInfo) r100;
        if (Intrinsics.areEqual(this.f190996id, r101.f190996id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dtStart, r101.dtStart) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rRule, r101.rRule) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.group, r101.group) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.location, r101.location) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.enableRemind, r101.enableRemind) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.remindDate, r101.remindDate) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = this.f190996id.hashCode() * 31;
        Long r101 = this.dtStart;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.duration;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.rRule;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.title;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.group;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.location;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Boolean r120 = this.enableRemind;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Long r123 = this.remindDate;
        if (r123 == null) goto L35;
        r102 = r123.hashCode();
    L35:
        return r122 + r102;
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "RemindInfo(id=" + this.f190996id + ", dtStart=" + this.dtStart + ", duration=" + this.duration + ", rRule=" + this.rRule + ", title=" + this.title + ", group=" + this.group + ", location=" + this.location + ", enableRemind=" + this.enableRemind + ", remindDate=" + this.remindDate + ')';
    }

    public final Long getDtStart() {
        return this.dtStart;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final Boolean getEnableRemind() {
        return this.enableRemind;
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getId() {
        return this.f190996id;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getRRule() {
        return this.rRule;
    }

    public final Long getRemindDate() {
        return this.remindDate;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setDtStart(Long r100) {
        this.dtStart = r100;
    }

    public final void setDuration(Long r100) {
        this.duration = r100;
    }

    public final void setEnableRemind(Boolean r100) {
        this.enableRemind = r100;
    }

    public final void setGroup(String r100) {
        this.group = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f190996id = r100;
    }

    public final void setLocation(String r100) {
        this.location = r100;
    }

    public final void setRRule(String r100) {
        this.rRule = r100;
    }

    public final void setRemindDate(Long r100) {
        this.remindDate = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public RemindInfo(String r100, Long r101, Long r102, String r103, String r104, String r105, String r106, Boolean r107, Long r110) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f190996id = r100;
        this.dtStart = r101;
        this.duration = r102;
        this.rRule = r103;
        this.title = r104;
        this.group = r105;
        this.location = r106;
        this.enableRemind = r107;
        this.remindDate = r110;
    }

    public /* synthetic */ RemindInfo(String r110, Long r111, Long r112, String r113, String r114, String r115, String r116, Boolean r117, Long r118, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = "";
    L6:
        Long r101 = null;
        if ((r210 & 2) == 0) goto L9;
        Long r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Long r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Boolean r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r101 = r118;
    L38:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r101);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
