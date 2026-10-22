package com.obric.agent.card.weather;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TypeDefine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BaseInfoCardData {
    private final String dateDesc;
    private final String location;
    private final String mainInfo;
    private final String queryType;
    private final String tagText;
    private final int tagType;

    public BaseInfoCardData() {
        this(null, null, null, null, null, 0, 63, null);
    }

    public static /* synthetic */ BaseInfoCardData copy$default(BaseInfoCardData r4, String r5, String r6, String r7, String r8, String r9, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.queryType;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.mainInfo;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.location;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.dateDesc;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.tagText;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.tagType;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.queryType;
    }

    public final String component2() {
        return this.mainInfo;
    }

    public final String component3() {
        return this.location;
    }

    public final String component4() {
        return this.dateDesc;
    }

    public final String component5() {
        return this.tagText;
    }

    public final int component6() {
        return this.tagType;
    }

    public final BaseInfoCardData copy(String r8, String r9, String r10, String r11, String r12, int r13) {
        o.e(r8, "queryType");
        o.e(r9, "mainInfo");
        o.e(r10, "location");
        o.e(r11, "dateDesc");
        o.e(r12, "tagText");
        return new BaseInfoCardData(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BaseInfoCardData.class) == true) goto L8;
        return false;
    L8:
        BaseInfoCardData r6 = (BaseInfoCardData) ZeusTransformUtils.preCheckCast(r5, BaseInfoCardData.class, "com.obric.aiagent.plugin");
        if (o.a(this.queryType, r6.queryType) == true) goto L12;
        return false;
    L12:
        if (o.a(this.mainInfo, r6.mainInfo) == true) goto L15;
        return false;
    L15:
        if (o.a(this.location, r6.location) == true) goto L18;
        return false;
    L18:
        if (o.a(this.dateDesc, r6.dateDesc) == true) goto L21;
        return false;
    L21:
        if (o.a(this.tagText, r6.tagText) == true) goto L24;
        return false;
    L24:
        if (this.tagType == r6.tagType) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.queryType.hashCode() * 31) + this.mainInfo.hashCode()) * 31) + this.location.hashCode()) * 31) + this.dateDesc.hashCode()) * 31) + this.tagText.hashCode()) * 31) + Integer.hashCode(this.tagType);
    }

    public String toString() {
        return "BaseInfoCardData(queryType=" + this.queryType + ", mainInfo=" + this.mainInfo + ", location=" + this.location + ", dateDesc=" + this.dateDesc + ", tagText=" + this.tagText + ", tagType=" + this.tagType + ')';
    }

    public BaseInfoCardData(String r2, String r3, String r4, String r5, String r6, int r7) {
        o.e(r2, "queryType");
        o.e(r3, "mainInfo");
        o.e(r4, "location");
        o.e(r5, "dateDesc");
        o.e(r6, "tagText");
        this.queryType = r2;
        this.mainInfo = r3;
        this.location = r4;
        this.dateDesc = r5;
        this.tagText = r6;
        this.tagType = r7;
    }

    public final String getQueryType() {
        return this.queryType;
    }

    public final String getMainInfo() {
        return this.mainInfo;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getDateDesc() {
        return this.dateDesc;
    }

    public final String getTagText() {
        return this.tagText;
    }

    public /* synthetic */ BaseInfoCardData(String r2, String r3, String r4, String r5, String r6, int r7, int r8, d.h.b.h r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = "";
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = "";
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = CardTagType.GOOD.ordinal();
    L20:
        this(r2, r3, r4, r5, r6, r7);
    }

    public final int getTagType() {
        return this.tagType;
    }
}
