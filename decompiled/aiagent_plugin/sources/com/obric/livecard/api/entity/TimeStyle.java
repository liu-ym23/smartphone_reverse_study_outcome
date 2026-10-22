package com.obric.livecard.api.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TimerCollapseTemplate.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimeStyle {
    private String textColor;
    private int textSize;

    public static /* synthetic */ TimeStyle copy$default(TimeStyle r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.textSize;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.textColor;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.textSize;
    }

    public final String component2() {
        return this.textColor;
    }

    public final TimeStyle copy(int r1, String r2) {
        o.e(r2, "textColor");
        return new TimeStyle(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TimeStyle.class) == true) goto L8;
        return false;
    L8:
        TimeStyle r6 = (TimeStyle) ZeusTransformUtils.preCheckCast(r5, TimeStyle.class, "com.obric.aiagent.plugin");
        if (this.textSize == r6.textSize) goto L12;
        return false;
    L12:
        if (o.a(this.textColor, r6.textColor) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.textSize) * 31) + this.textColor.hashCode();
    }

    public String toString() {
        return "TimeStyle(textSize=" + this.textSize + ", textColor=" + this.textColor + ')';
    }

    public TimeStyle(int r2, String r3) {
        o.e(r3, "textColor");
        this.textSize = r2;
        this.textColor = r3;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final void setTextSize(int r1) {
        this.textSize = r1;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(String r2) {
        o.e(r2, "<set-?>");
        this.textColor = r2;
    }
}
