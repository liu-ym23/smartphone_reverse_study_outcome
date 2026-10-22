package com.obric.agent.card.weather;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: TypeDefine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MultiDateWeatherInfoCardData {
    private final List<MultiDateWeatherInfoSingleDayCardData> datas;
    private final String location;
    private final String locationName;
    private final int styleType;

    public MultiDateWeatherInfoCardData() {
        this(null, null, null, 0, 15, null);
    }

    public static /* synthetic */ MultiDateWeatherInfoCardData copy$default(MultiDateWeatherInfoCardData r1, String r2, String r3, List r4, int r5, int r6, Object r7) {
        List<MultiDateWeatherInfoSingleDayCardData> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.location;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.locationName;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.datas;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.styleType;
    L15:
        return r1.copy(r2, r3, r8, r5);
    }

    public final String component1() {
        return this.location;
    }

    public final String component2() {
        return this.locationName;
    }

    public final List<MultiDateWeatherInfoSingleDayCardData> component3() {
        return this.datas;
    }

    public final int component4() {
        return this.styleType;
    }

    public final MultiDateWeatherInfoCardData copy(String r2, String r3, List<MultiDateWeatherInfoSingleDayCardData> r4, int r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r2, "location");
        o.e(r3, "locationName");
        o.e(r1, "datas");
        return new MultiDateWeatherInfoCardData(r2, r3, r1, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MultiDateWeatherInfoCardData.class) == true) goto L8;
        return false;
    L8:
        MultiDateWeatherInfoCardData r6 = (MultiDateWeatherInfoCardData) ZeusTransformUtils.preCheckCast(r5, MultiDateWeatherInfoCardData.class, "com.obric.aiagent.plugin");
        if (o.a(this.location, r6.location) == true) goto L12;
        return false;
    L12:
        if (o.a(this.locationName, r6.locationName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.datas, r6.datas) == true) goto L18;
        return false;
    L18:
        if (this.styleType == r6.styleType) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.location.hashCode() * 31) + this.locationName.hashCode()) * 31) + this.datas.hashCode()) * 31) + Integer.hashCode(this.styleType);
    }

    public String toString() {
        return "MultiDateWeatherInfoCardData(location=" + this.location + ", locationName=" + this.locationName + ", datas=" + this.datas + ", styleType=" + this.styleType + ')';
    }

    public MultiDateWeatherInfoCardData(String r3, String r4, List<MultiDateWeatherInfoSingleDayCardData> r5, int r6) {
        List<MultiDateWeatherInfoSingleDayCardData> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "location");
        o.e(r4, "locationName");
        o.e(r7, "datas");
        this.location = r3;
        this.locationName = r4;
        this.datas = r7;
        this.styleType = r6;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getLocationName() {
        return this.locationName;
    }

    public /* synthetic */ MultiDateWeatherInfoCardData(String r2, String r3, List r4, int r5, int r6, d.h.b.h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = p.b();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0;
    L14:
        this(r2, r3, r8, r5);
    }

    public final List<MultiDateWeatherInfoSingleDayCardData> getDatas() {
        return this.datas;
    }

    public final int getStyleType() {
        return this.styleType;
    }
}
