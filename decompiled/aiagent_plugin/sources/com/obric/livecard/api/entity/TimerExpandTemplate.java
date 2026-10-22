package com.obric.livecard.api.entity;

import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: TimerExpandTemplate.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimerExpandTemplate {
    private List<Button> buttonList;
    private Text content;
    private long current_timestamp;
    private Integer duration;
    private Icon icon;
    private Integer is_auto;
    private TimeStyle timeStyle;
    private Icon titleIcon;
    private int type;
    private String unit;

    public TimerExpandTemplate(Icon r3, Icon r4, Text r5, List<Button> r6, TimeStyle r7, long r8, Integer r10, Integer r11, int r12, String r13) {
        List<Button> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "content");
        o.e(r7, "timeStyle");
        o.e(r13, Scraps.INNER_UNIT);
        this.icon = r3;
        this.titleIcon = r4;
        this.content = r5;
        this.buttonList = r9;
        this.timeStyle = r7;
        this.current_timestamp = r8;
        this.duration = r10;
        this.is_auto = r11;
        this.type = r12;
        this.unit = r13;
    }

    public /* synthetic */ TimerExpandTemplate(Icon r17, Icon r18, Text r19, List r20, TimeStyle r21, long r22, Integer r24, Integer r25, int r26, String r27, int r28, h r29) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        if ((r28 & 1) == 0) goto L5;
        Icon r5 = null;
    L7:
        if ((r28 & 2) == 0) goto L9;
        Icon r6 = null;
    L11:
        if ((r28 & 8) == 0) goto L13;
        List r8 = null;
    L15:
        if ((r28 & 64) == 0) goto L17;
        Integer r12 = null;
    L19:
        if ((r28 & 128) == 0) goto L21;
        Integer r13 = null;
    L22:
        this(r5, r6, r19, r8, r21, r22, r12, r13, r26, r27);
        return;
    L21:
        r13 = r25;
        goto L22
    L17:
        r12 = r24;
        goto L19
    L13:
        r8 = r1;
        goto L15
    L9:
        r6 = r18;
        goto L11
    L5:
        r5 = r17;
        goto L7
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final void setIcon(Icon r1) {
        this.icon = r1;
    }

    public final Icon getTitleIcon() {
        return this.titleIcon;
    }

    public final void setTitleIcon(Icon r1) {
        this.titleIcon = r1;
    }

    public final Text getContent() {
        return this.content;
    }

    public final void setContent(Text r2) {
        o.e(r2, "<set-?>");
        this.content = r2;
    }

    public final List<Button> getButtonList() {
        return this.buttonList;
    }

    public final void setButtonList(List<Button> r3) {
        this.buttonList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final TimeStyle getTimeStyle() {
        return this.timeStyle;
    }

    public final void setTimeStyle(TimeStyle r2) {
        o.e(r2, "<set-?>");
        this.timeStyle = r2;
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

    public static /* synthetic */ IslandWidget create$default(TimerExpandTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.create(r1);
    }

    public final IslandWidget create(Boolean r14) {
        return new IslandWidget("com.obric.island_applet:common_expand_timer_template", this, r14, null, null, null, null, null, null, 504, null);
    }
}
