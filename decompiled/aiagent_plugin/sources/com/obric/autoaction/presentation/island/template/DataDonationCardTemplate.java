package com.obric.autoaction.presentation.island.template;

import com.obric.autoaction.presentation.doubao.j;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OAutoExpandCardTemplate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DataDonationCardTemplate {
    private final TextButton actionBtn;
    private final Text contentText;
    private final Text describeText;
    private final TitleWithIcon title;

    public static /* synthetic */ DataDonationCardTemplate copy$default(DataDonationCardTemplate r0, TitleWithIcon r1, Text r2, Text r3, TextButton r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.title;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.contentText;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.describeText;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.actionBtn;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final TitleWithIcon component1() {
        return this.title;
    }

    public final Text component2() {
        return this.contentText;
    }

    public final Text component3() {
        return this.describeText;
    }

    public final TextButton component4() {
        return this.actionBtn;
    }

    public final DataDonationCardTemplate copy(TitleWithIcon r1, Text r2, Text r3, TextButton r4) {
        o.e(r1, DBDefinition.TITLE);
        o.e(r2, "contentText");
        o.e(r3, "describeText");
        return new DataDonationCardTemplate(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DataDonationCardTemplate.class) == true) goto L8;
        return false;
    L8:
        DataDonationCardTemplate r6 = (DataDonationCardTemplate) ZeusTransformUtils.preCheckCast(r5, DataDonationCardTemplate.class, "com.obric.aiagent.plugin");
        if (o.a(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (o.a(this.contentText, r6.contentText) == true) goto L15;
        return false;
    L15:
        if (o.a(this.describeText, r6.describeText) == true) goto L18;
        return false;
    L18:
        if (o.a(this.actionBtn, r6.actionBtn) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.title.hashCode() * 31) + this.contentText.hashCode()) * 31) + this.describeText.hashCode()) * 31;
        TextButton r2 = this.actionBtn;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "DataDonationCardTemplate(title=" + this.title + ", contentText=" + this.contentText + ", describeText=" + this.describeText + ", actionBtn=" + this.actionBtn + ')';
    }

    public DataDonationCardTemplate(TitleWithIcon r2, Text r3, Text r4, TextButton r5) {
        o.e(r2, DBDefinition.TITLE);
        o.e(r3, "contentText");
        o.e(r4, "describeText");
        this.title = r2;
        this.contentText = r3;
        this.describeText = r4;
        this.actionBtn = r5;
    }

    public final TitleWithIcon getTitle() {
        return this.title;
    }

    public final Text getContentText() {
        return this.contentText;
    }

    public final Text getDescribeText() {
        return this.describeText;
    }

    public final TextButton getActionBtn() {
        return this.actionBtn;
    }

    public static /* synthetic */ IslandWidget create$default(DataDonationCardTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.create(r1);
    }

    public final IslandWidget create(Boolean r14) {
        String r2 = j.f24894a.a().toJson(this);
        o.c(r2, "toJson(...)");
        return new IslandWidget("com.obric.island_applet:data_donation_island", r2, r14, null, null, null, null, null, null, 504, null);
    }
}
