package com.obric.livecard.api.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CommonCollapseTemplate.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonCollapseTemplate {
    private Icon endIcon;
    private Text endText;
    private Icon startIcon;
    private Text startText;

    public CommonCollapseTemplate() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CommonCollapseTemplate copy$default(CommonCollapseTemplate r0, Icon r1, Text r2, Icon r3, Text r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.endIcon;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.endText;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.startIcon;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.startText;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Icon component1() {
        return this.endIcon;
    }

    public final Text component2() {
        return this.endText;
    }

    public final Icon component3() {
        return this.startIcon;
    }

    public final Text component4() {
        return this.startText;
    }

    public final CommonCollapseTemplate copy(Icon r1, Text r2, Icon r3, Text r4) {
        return new CommonCollapseTemplate(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CommonCollapseTemplate.class) == true) goto L8;
        return false;
    L8:
        CommonCollapseTemplate r6 = (CommonCollapseTemplate) ZeusTransformUtils.preCheckCast(r5, CommonCollapseTemplate.class, "com.obric.aiagent.plugin");
        if (o.a(this.endIcon, r6.endIcon) == true) goto L12;
        return false;
    L12:
        if (o.a(this.endText, r6.endText) == true) goto L15;
        return false;
    L15:
        if (o.a(this.startIcon, r6.startIcon) == true) goto L18;
        return false;
    L18:
        if (o.a(this.startText, r6.startText) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Icon r0 = this.endIcon;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Text r4 = this.endText;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Icon r7 = this.startIcon;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Text r10 = this.startText;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CommonCollapseTemplate(endIcon=" + this.endIcon + ", endText=" + this.endText + ", startIcon=" + this.startIcon + ", startText=" + this.startText + ')';
    }

    public CommonCollapseTemplate(Icon r1, Text r2, Icon r3, Text r4) {
        this.endIcon = r1;
        this.endText = r2;
        this.startIcon = r3;
        this.startText = r4;
    }

    public /* synthetic */ CommonCollapseTemplate(Icon r2, Text r3, Icon r4, Text r5, int r6, h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final Icon getEndIcon() {
        return this.endIcon;
    }

    public final void setEndIcon(Icon r1) {
        this.endIcon = r1;
    }

    public final Text getEndText() {
        return this.endText;
    }

    public final void setEndText(Text r1) {
        this.endText = r1;
    }

    public final Icon getStartIcon() {
        return this.startIcon;
    }

    public final void setStartIcon(Icon r1) {
        this.startIcon = r1;
    }

    public final Text getStartText() {
        return this.startText;
    }

    public final void setStartText(Text r1) {
        this.startText = r1;
    }

    public static /* synthetic */ IslandWidget create$default(CommonCollapseTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.create(r1);
    }

    public final IslandWidget create(Boolean r14) {
        return new IslandWidget("com.obric.island_applet:common_collapse_template", this, r14, null, null, null, null, null, null, 504, null);
    }
}
