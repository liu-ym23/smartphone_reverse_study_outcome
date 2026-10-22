package com.obric.livecard.api.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CommonUINode.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class Icon {
    private Integer autoplay;
    private String backgroundIcon;
    private int height;
    private String icon;
    private String id;
    private Integer loop;
    private int width;

    public static /* synthetic */ Icon copy$default(Icon r5, int r6, int r7, String r8, Integer r9, Integer r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.height;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.width;
    L8:
        int r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.icon;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.loop;
    L14:
        Integer r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.autoplay;
    L17:
        Integer r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.id;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.backgroundIcon;
    L23:
        int r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final int component1() {
        return this.height;
    }

    public final int component2() {
        return this.width;
    }

    public final String component3() {
        return this.icon;
    }

    public final Integer component4() {
        return this.loop;
    }

    public final Integer component5() {
        return this.autoplay;
    }

    public final String component6() {
        return this.id;
    }

    public final String component7() {
        return this.backgroundIcon;
    }

    public final Icon copy(int r9, int r10, String r11, Integer r12, Integer r13, String r14, String r15) {
        o.e(r11, "icon");
        return new Icon(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Icon.class) == true) goto L8;
        return false;
    L8:
        Icon r6 = (Icon) ZeusTransformUtils.preCheckCast(r5, Icon.class, "com.obric.aiagent.plugin");
        if (this.height == r6.height) goto L12;
        return false;
    L12:
        if (this.width == r6.width) goto L15;
        return false;
    L15:
        if (o.a(this.icon, r6.icon) == true) goto L18;
        return false;
    L18:
        if (o.a(this.loop, r6.loop) == true) goto L21;
        return false;
    L21:
        if (o.a(this.autoplay, r6.autoplay) == true) goto L24;
        return false;
    L24:
        if (o.a(this.id, r6.id) == true) goto L27;
        return false;
    L27:
        if (o.a(this.backgroundIcon, r6.backgroundIcon) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.height) * 31) + Integer.hashCode(this.width)) * 31) + this.icon.hashCode()) * 31;
        Integer r1 = this.loop;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.autoplay;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.id;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.backgroundIcon;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "Icon(height=" + this.height + ", width=" + this.width + ", icon=" + this.icon + ", loop=" + this.loop + ", autoplay=" + this.autoplay + ", id=" + this.id + ", backgroundIcon=" + this.backgroundIcon + ')';
    }

    public Icon(int r2, int r3, String r4, Integer r5, Integer r6, String r7, String r8) {
        o.e(r4, "icon");
        this.height = r2;
        this.width = r3;
        this.icon = r4;
        this.loop = r5;
        this.autoplay = r6;
        this.id = r7;
        this.backgroundIcon = r8;
    }

    public /* synthetic */ Icon(int r11, int r12, String r13, Integer r14, Integer r15, String r16, String r17, int r18, h r19) {
        if ((r18 & 8) == 0) goto L5;
        Integer r6 = null;
    L7:
        if ((r18 & 16) == 0) goto L9;
        Integer r7 = null;
    L11:
        if ((r18 & 32) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r18 & 64) == 0) goto L17;
        String r9 = null;
    L18:
        this(r11, r12, r13, r6, r7, r8, r9);
        return;
    L17:
        r9 = r17;
        goto L18
    L13:
        r8 = r16;
        goto L15
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String r2) {
        o.e(r2, "<set-?>");
        this.icon = r2;
    }

    public final Integer getLoop() {
        return this.loop;
    }

    public final void setLoop(Integer r1) {
        this.loop = r1;
    }

    public final Integer getAutoplay() {
        return this.autoplay;
    }

    public final void setAutoplay(Integer r1) {
        this.autoplay = r1;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String r1) {
        this.id = r1;
    }

    public final String getBackgroundIcon() {
        return this.backgroundIcon;
    }

    public final void setBackgroundIcon(String r1) {
        this.backgroundIcon = r1;
    }
}
