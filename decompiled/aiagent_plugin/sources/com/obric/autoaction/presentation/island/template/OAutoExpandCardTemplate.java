package com.obric.autoaction.presentation.island.template;

import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: OAutoExpandCardTemplate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OAutoExpandCardTemplate {
    private final TextButton actionBtn;
    private final List<TextButton> clarifyBtnList;
    private final Text contentText;
    private final Text describeText;
    private final TitleWithIcon title;

    public static /* synthetic */ OAutoExpandCardTemplate copy$default(OAutoExpandCardTemplate r6, TitleWithIcon r7, Text r8, Text r9, TextButton r10, List r11, int r12, Object r13) {
        List<TextButton> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.title;
    L5:
        TitleWithIcon r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.describeText;
    L8:
        Text r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = r6.contentText;
    L11:
        Text r3 = r9;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.actionBtn;
    L14:
        TextButton r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r14 = r6.clarifyBtnList;
    L18:
        return r6.copy(r1, r2, r3, r4, r14);
    }

    public final TitleWithIcon component1() {
        return this.title;
    }

    public final Text component2() {
        return this.describeText;
    }

    public final Text component3() {
        return this.contentText;
    }

    public final TextButton component4() {
        return this.actionBtn;
    }

    public final List<TextButton> component5() {
        return this.clarifyBtnList;
    }

    public final OAutoExpandCardTemplate copy(TitleWithIcon r7, Text r8, Text r9, TextButton r10, List<TextButton> r11) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        o.e(r7, DBDefinition.TITLE);
        o.e(r8, "describeText");
        o.e(r9, "contentText");
        return new OAutoExpandCardTemplate(r7, r8, r9, r10, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OAutoExpandCardTemplate.class) == true) goto L8;
        return false;
    L8:
        OAutoExpandCardTemplate r6 = (OAutoExpandCardTemplate) ZeusTransformUtils.preCheckCast(r5, OAutoExpandCardTemplate.class, "com.obric.aiagent.plugin");
        if (o.a(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (o.a(this.describeText, r6.describeText) == true) goto L15;
        return false;
    L15:
        if (o.a(this.contentText, r6.contentText) == true) goto L18;
        return false;
    L18:
        if (o.a(this.actionBtn, r6.actionBtn) == true) goto L21;
        return false;
    L21:
        if (o.a(this.clarifyBtnList, r6.clarifyBtnList) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.title.hashCode() * 31) + this.describeText.hashCode()) * 31) + this.contentText.hashCode()) * 31;
        TextButton r1 = this.actionBtn;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<TextButton> r5 = this.clarifyBtnList;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "OAutoExpandCardTemplate(title=" + this.title + ", describeText=" + this.describeText + ", contentText=" + this.contentText + ", actionBtn=" + this.actionBtn + ", clarifyBtnList=" + this.clarifyBtnList + ')';
    }

    public OAutoExpandCardTemplate(TitleWithIcon r3, Text r4, Text r5, TextButton r6, List<TextButton> r7) {
        List<TextButton> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.e(r3, DBDefinition.TITLE);
        o.e(r4, "describeText");
        o.e(r5, "contentText");
        this.title = r3;
        this.describeText = r4;
        this.contentText = r5;
        this.actionBtn = r6;
        this.clarifyBtnList = r8;
    }

    public /* synthetic */ OAutoExpandCardTemplate(TitleWithIcon r7, Text r8, Text r9, TextButton r10, List r11, int r12, h r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 16) == 0) goto L5;
        r14 = null;
    L5:
        this(r7, r8, r9, r10, r14);
    }

    public final TitleWithIcon getTitle() {
        return this.title;
    }

    public final Text getDescribeText() {
        return this.describeText;
    }

    public final Text getContentText() {
        return this.contentText;
    }

    public final TextButton getActionBtn() {
        return this.actionBtn;
    }

    public final List<TextButton> getClarifyBtnList() {
        return this.clarifyBtnList;
    }

    public static /* synthetic */ IslandWidget create$default(OAutoExpandCardTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.create(r1);
    }

    public final IslandWidget create(Boolean r14) {
        return new IslandWidget("com.obric.island_applet:action_expand_island", this, r14, null, null, null, null, null, null, 504, null);
    }
}
