package com.obric.livecard.api.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: CommonExpandedTemplate.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonExpandedTemplate {
    private List<Button> buttonList;
    private Text content;
    private Icon icon;
    private Text title;
    private Icon titleIcon;

    public static /* synthetic */ CommonExpandedTemplate copy$default(CommonExpandedTemplate r3, List r4, Text r5, Icon r6, Text r7, Icon r8, int r9, Object r10) {
        List<Button> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r9 & 1) == 0) goto L6;
        r11 = r3.buttonList;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.content;
    L8:
        Text r12 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.icon;
    L11:
        Icon r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.title;
    L14:
        Text r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.titleIcon;
    L17:
        List<Button> r13 = r11;
        return r3.copy(r13, r12, r0, r1, r8);
    }

    public final List<Button> component1() {
        return this.buttonList;
    }

    public final Text component2() {
        return this.content;
    }

    public final Icon component3() {
        return this.icon;
    }

    public final Text component4() {
        return this.title;
    }

    public final Icon component5() {
        return this.titleIcon;
    }

    public final CommonExpandedTemplate copy(List<Button> r7, Text r8, Icon r9, Text r10, Icon r11) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "buttonList");
        o.e(r8, "content");
        return new CommonExpandedTemplate(r1, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CommonExpandedTemplate.class) == true) goto L8;
        return false;
    L8:
        CommonExpandedTemplate r6 = (CommonExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, CommonExpandedTemplate.class, "com.obric.aiagent.plugin");
        if (o.a(this.buttonList, r6.buttonList) == true) goto L12;
        return false;
    L12:
        if (o.a(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (o.a(this.icon, r6.icon) == true) goto L18;
        return false;
    L18:
        if (o.a(this.title, r6.title) == true) goto L21;
        return false;
    L21:
        if (o.a(this.titleIcon, r6.titleIcon) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.buttonList.hashCode() * 31) + this.content.hashCode()) * 31;
        Icon r1 = this.icon;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Text r5 = this.title;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Icon r8 = this.titleIcon;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "CommonExpandedTemplate(buttonList=" + this.buttonList + ", content=" + this.content + ", icon=" + this.icon + ", title=" + this.title + ", titleIcon=" + this.titleIcon + ')';
    }

    public CommonExpandedTemplate(List<Button> r3, Text r4, Icon r5, Text r6, Icon r7) {
        List<Button> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "buttonList");
        o.e(r4, "content");
        this.buttonList = r8;
        this.content = r4;
        this.icon = r5;
        this.title = r6;
        this.titleIcon = r7;
    }

    public /* synthetic */ CommonExpandedTemplate(List r7, Text r8, Icon r9, Text r10, Icon r11, int r12, h r13) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 4) == 0) goto L5;
        Icon r3 = null;
    L7:
        if ((r12 & 8) == 0) goto L9;
        Text r4 = null;
    L11:
        if ((r12 & 16) == 0) goto L13;
        Icon r5 = null;
    L14:
        this(r1, r8, r3, r4, r5);
        return;
    L13:
        r5 = r11;
        goto L14
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public final List<Button> getButtonList() {
        return this.buttonList;
    }

    public final void setButtonList(List<Button> r3) {
        List<Button> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.buttonList = r4;
    }

    public final Text getContent() {
        return this.content;
    }

    public final void setContent(Text r2) {
        o.e(r2, "<set-?>");
        this.content = r2;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final void setIcon(Icon r1) {
        this.icon = r1;
    }

    public final Text getTitle() {
        return this.title;
    }

    public final void setTitle(Text r1) {
        this.title = r1;
    }

    public final Icon getTitleIcon() {
        return this.titleIcon;
    }

    public final void setTitleIcon(Icon r1) {
        this.titleIcon = r1;
    }

    public static /* synthetic */ IslandWidget create$default(CommonExpandedTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.create(r1);
    }

    public final IslandWidget create(Boolean r14) {
        return new IslandWidget("com.obric.island_applet:common_expand_template", this, r14, null, null, null, null, null, null, 504, null);
    }
}
