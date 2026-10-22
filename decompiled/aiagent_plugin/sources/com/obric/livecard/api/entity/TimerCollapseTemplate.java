package com.obric.livecard.api.entity;

import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TimerCollapseTemplate.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimerCollapseTemplate {
    private long current_timestamp;
    private Integer duration;
    private Integer is_auto;
    private Icon startIcon;
    private TimeStyle timeStyle;
    private int type;
    private String unit;

    public static /* synthetic */ TimerCollapseTemplate copy$default(TimerCollapseTemplate r9, long r10, Integer r12, Integer r13, int r14, String r15, Icon r16, TimeStyle r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        long r1 = r9.current_timestamp;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Integer r3 = r9.duration;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Integer r4 = r9.is_auto;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r5 = r9.type;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.unit;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Icon r7 = r9.startIcon;
    L27:
        if ((r18 & 64) == 0) goto L29;
        TimeStyle r8 = r9.timeStyle;
    L31:
        return r9.copy(r1, r3, r4, r5, r6, r7, r8);
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final long component1() {
        return this.current_timestamp;
    }

    public final Integer component2() {
        return this.duration;
    }

    public final Integer component3() {
        return this.is_auto;
    }

    public final int component4() {
        return this.type;
    }

    public final String component5() {
        return this.unit;
    }

    public final Icon component6() {
        return this.startIcon;
    }

    public final TimeStyle component7() {
        return this.timeStyle;
    }

    public final TimerCollapseTemplate copy(long r11, Integer r13, Integer r14, int r15, String r16, Icon r17, TimeStyle r18) {
        o.e(r16, Scraps.INNER_UNIT);
        o.e(r17, "startIcon");
        o.e(r18, "timeStyle");
        return new TimerCollapseTemplate(r11, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, TimerCollapseTemplate.class) == true) goto L8;
        return false;
    L8:
        TimerCollapseTemplate r10 = (TimerCollapseTemplate) ZeusTransformUtils.preCheckCast(r9, TimerCollapseTemplate.class, "com.obric.aiagent.plugin");
        if (this.current_timestamp == r10.current_timestamp) goto L12;
        return false;
    L12:
        if (o.a(this.duration, r10.duration) == true) goto L15;
        return false;
    L15:
        if (o.a(this.is_auto, r10.is_auto) == true) goto L18;
        return false;
    L18:
        if (this.type == r10.type) goto L21;
        return false;
    L21:
        if (o.a(this.unit, r10.unit) == true) goto L24;
        return false;
    L24:
        if (o.a(this.startIcon, r10.startIcon) == true) goto L27;
        return false;
    L27:
        if (o.a(this.timeStyle, r10.timeStyle) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.current_timestamp) * 31;
        Integer r1 = this.duration;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.is_auto;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((((((r4 + r2) * 31) + Integer.hashCode(this.type)) * 31) + this.unit.hashCode()) * 31) + this.startIcon.hashCode()) * 31) + this.timeStyle.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TimerCollapseTemplate(current_timestamp=" + this.current_timestamp + ", duration=" + this.duration + ", is_auto=" + this.is_auto + ", type=" + this.type + ", unit=" + this.unit + ", startIcon=" + this.startIcon + ", timeStyle=" + this.timeStyle + ')';
    }

    public TimerCollapseTemplate(long r2, Integer r4, Integer r5, int r6, String r7, Icon r8, TimeStyle r9) {
        o.e(r7, Scraps.INNER_UNIT);
        o.e(r8, "startIcon");
        o.e(r9, "timeStyle");
        this.current_timestamp = r2;
        this.duration = r4;
        this.is_auto = r5;
        this.type = r6;
        this.unit = r7;
        this.startIcon = r8;
        this.timeStyle = r9;
    }

    public /* synthetic */ TimerCollapseTemplate(long r12, Integer r14, Integer r15, int r16, String r17, Icon r18, TimeStyle r19, int r20, h r21) {
        if ((r20 & 2) == 0) goto L5;
        Integer r5 = null;
    L7:
        if ((r20 & 4) == 0) goto L9;
        Integer r6 = null;
    L10:
        this(r12, r5, r6, r16, r17, r18, r19);
        return;
    L9:
        r6 = r15;
        goto L10
    L5:
        r5 = r14;
        goto L7
    }

    public final long getCurrent_timestamp() {
        return this.current_timestamp;
    }

    public final void setCurrent_timestamp(long r1) {
        this.current_timestamp = r1;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final void setDuration(Integer r1) {
        this.duration = r1;
    }

    public final Integer is_auto() {
        return this.is_auto;
    }

    public final void set_auto(Integer r1) {
        this.is_auto = r1;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final void setUnit(String r2) {
        o.e(r2, "<set-?>");
        this.unit = r2;
    }

    public final Icon getStartIcon() {
        return this.startIcon;
    }

    public final void setStartIcon(Icon r2) {
        o.e(r2, "<set-?>");
        this.startIcon = r2;
    }

    public final TimeStyle getTimeStyle() {
        return this.timeStyle;
    }

    public final void setTimeStyle(TimeStyle r2) {
        o.e(r2, "<set-?>");
        this.timeStyle = r2;
    }

    public static /* synthetic */ IslandWidget create$default(TimerCollapseTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.create(r1);
    }

    public final IslandWidget create(Boolean r14) {
        return new IslandWidget("com.obric.island_applet:common_collapse_timer_template", this, r14, null, null, null, null, null, null, 504, null);
    }
}
