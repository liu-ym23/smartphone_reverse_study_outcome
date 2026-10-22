package com.obric.agent.card.weather;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TypeDefine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SunRiseSetCardData {
    private final String dateDesc;
    private final String location;
    private final String queryType;
    private final String sunRise;
    private final String sunSet;

    public SunRiseSetCardData() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SunRiseSetCardData copy$default(SunRiseSetCardData r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.queryType;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.location;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.dateDesc;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.sunRise;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.sunSet;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.queryType;
    }

    public final String component2() {
        return this.location;
    }

    public final String component3() {
        return this.dateDesc;
    }

    public final String component4() {
        return this.sunRise;
    }

    public final String component5() {
        return this.sunSet;
    }

    public final SunRiseSetCardData copy(String r7, String r8, String r9, String r10, String r11) {
        o.e(r7, "queryType");
        o.e(r8, "location");
        o.e(r9, "dateDesc");
        o.e(r10, "sunRise");
        o.e(r11, "sunSet");
        return new SunRiseSetCardData(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SunRiseSetCardData.class) == true) goto L8;
        return false;
    L8:
        SunRiseSetCardData r6 = (SunRiseSetCardData) ZeusTransformUtils.preCheckCast(r5, SunRiseSetCardData.class, "com.obric.aiagent.plugin");
        if (o.a(this.queryType, r6.queryType) == true) goto L12;
        return false;
    L12:
        if (o.a(this.location, r6.location) == true) goto L15;
        return false;
    L15:
        if (o.a(this.dateDesc, r6.dateDesc) == true) goto L18;
        return false;
    L18:
        if (o.a(this.sunRise, r6.sunRise) == true) goto L21;
        return false;
    L21:
        if (o.a(this.sunSet, r6.sunSet) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.queryType.hashCode() * 31) + this.location.hashCode()) * 31) + this.dateDesc.hashCode()) * 31) + this.sunRise.hashCode()) * 31) + this.sunSet.hashCode();
    }

    public String toString() {
        return "SunRiseSetCardData(queryType=" + this.queryType + ", location=" + this.location + ", dateDesc=" + this.dateDesc + ", sunRise=" + this.sunRise + ", sunSet=" + this.sunSet + ')';
    }

    public SunRiseSetCardData(String r2, String r3, String r4, String r5, String r6) {
        o.e(r2, "queryType");
        o.e(r3, "location");
        o.e(r4, "dateDesc");
        o.e(r5, "sunRise");
        o.e(r6, "sunSet");
        this.queryType = r2;
        this.location = r3;
        this.dateDesc = r4;
        this.sunRise = r5;
        this.sunSet = r6;
    }

    public /* synthetic */ SunRiseSetCardData(String r2, String r3, String r4, String r5, String r6, int r7, d.h.b.h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = "";
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = "";
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String getQueryType() {
        return this.queryType;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getDateDesc() {
        return this.dateDesc;
    }

    public final String getSunRise() {
        return this.sunRise;
    }

    public final String getSunSet() {
        return this.sunSet;
    }
}
