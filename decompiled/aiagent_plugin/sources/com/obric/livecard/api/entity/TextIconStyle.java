package com.obric.livecard.api.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: CommonUINode.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TextIconStyle {
    private String backgroundColor;
    private String textColor;
    private int textSize;

    public static /* synthetic */ TextIconStyle copy$default(TextIconStyle r0, String r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.backgroundColor;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.textSize;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.textColor;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.backgroundColor;
    }

    public final int component2() {
        return this.textSize;
    }

    public final String component3() {
        return this.textColor;
    }

    public final TextIconStyle copy(String r1, int r2, String r3) {
        o.e(r1, "backgroundColor");
        o.e(r3, "textColor");
        return new TextIconStyle(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TextIconStyle.class) == true) goto L8;
        return false;
    L8:
        TextIconStyle r6 = (TextIconStyle) ZeusTransformUtils.preCheckCast(r5, TextIconStyle.class, "com.obric.aiagent.plugin");
        if (o.a(this.backgroundColor, r6.backgroundColor) == true) goto L12;
        return false;
    L12:
        if (this.textSize == r6.textSize) goto L15;
        return false;
    L15:
        if (o.a(this.textColor, r6.textColor) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.backgroundColor.hashCode() * 31) + Integer.hashCode(this.textSize)) * 31) + this.textColor.hashCode();
    }

    public String toString() {
        return "TextIconStyle(backgroundColor=" + this.backgroundColor + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ')';
    }

    public TextIconStyle(String r2, int r3, String r4) {
        o.e(r2, "backgroundColor");
        o.e(r4, "textColor");
        this.backgroundColor = r2;
        this.textSize = r3;
        this.textColor = r4;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(String r2) {
        o.e(r2, "<set-?>");
        this.backgroundColor = r2;
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
