package com.obric.agent.card.weather;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: TypeDefine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SingleDateWeatherInfoCardData {
    private final String backgroundResName;
    private final String highTemp;
    private final List<HourForecastUIInfo> hourForecastUIInfo;
    private final boolean isToday;
    private final String location;
    private final String lowTemp;
    private final String temp;
    private final String timeStr;
    private final String weatherCode;

    public SingleDateWeatherInfoCardData() {
        this(null, null, null, null, null, null, null, null, false, 511, null);
    }

    public static /* synthetic */ SingleDateWeatherInfoCardData copy$default(SingleDateWeatherInfoCardData r10, String r11, String r12, String r13, String r14, String r15, String r16, List r17, String r18, boolean r19, int r20, Object r21) {
        List<HourForecastUIInfo> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        if ((r20 & 1) == 0) goto L5;
        String r3 = r10.timeStr;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r4 = r10.weatherCode;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r5 = r10.temp;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r6 = r10.lowTemp;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r7 = r10.highTemp;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r8 = r10.location;
    L27:
        if ((r20 & 64) == 0) goto L30;
        r2 = r10.hourForecastUIInfo;
    L30:
        if ((r20 & 128) == 0) goto L32;
        String r9 = r10.backgroundResName;
    L34:
        if ((r20 & 256) == 0) goto L36;
        boolean r1 = r10.isToday;
    L38:
        return r10.copy(r3, r4, r5, r6, r7, r8, r2, r9, r1);
    L36:
        r1 = r19;
        goto L38
    L32:
        r9 = r18;
        goto L34
    L25:
        r8 = r16;
        goto L27
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public final String component1() {
        return this.timeStr;
    }

    public final String component2() {
        return this.weatherCode;
    }

    public final String component3() {
        return this.temp;
    }

    public final String component4() {
        return this.lowTemp;
    }

    public final String component5() {
        return this.highTemp;
    }

    public final String component6() {
        return this.location;
    }

    public final List<HourForecastUIInfo> component7() {
        return this.hourForecastUIInfo;
    }

    public final String component8() {
        return this.backgroundResName;
    }

    public final boolean component9() {
        return this.isToday;
    }

    public final SingleDateWeatherInfoCardData copy(String r12, String r13, String r14, String r15, String r16, String r17, List<HourForecastUIInfo> r18, String r19, boolean r20) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        o.e(r12, "timeStr");
        o.e(r13, "weatherCode");
        o.e(r14, "temp");
        o.e(r15, "lowTemp");
        o.e(r16, "highTemp");
        o.e(r17, "location");
        o.e(r8, "hourForecastUIInfo");
        o.e(r19, "backgroundResName");
        return new SingleDateWeatherInfoCardData(r12, r13, r14, r15, r16, r17, r8, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SingleDateWeatherInfoCardData.class) == true) goto L8;
        return false;
    L8:
        SingleDateWeatherInfoCardData r6 = (SingleDateWeatherInfoCardData) ZeusTransformUtils.preCheckCast(r5, SingleDateWeatherInfoCardData.class, "com.obric.aiagent.plugin");
        if (o.a(this.timeStr, r6.timeStr) == true) goto L12;
        return false;
    L12:
        if (o.a(this.weatherCode, r6.weatherCode) == true) goto L15;
        return false;
    L15:
        if (o.a(this.temp, r6.temp) == true) goto L18;
        return false;
    L18:
        if (o.a(this.lowTemp, r6.lowTemp) == true) goto L21;
        return false;
    L21:
        if (o.a(this.highTemp, r6.highTemp) == true) goto L24;
        return false;
    L24:
        if (o.a(this.location, r6.location) == true) goto L27;
        return false;
    L27:
        if (o.a(this.hourForecastUIInfo, r6.hourForecastUIInfo) == true) goto L30;
        return false;
    L30:
        if (o.a(this.backgroundResName, r6.backgroundResName) == true) goto L33;
        return false;
    L33:
        if (this.isToday == r6.isToday) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((this.timeStr.hashCode() * 31) + this.weatherCode.hashCode()) * 31) + this.temp.hashCode()) * 31) + this.lowTemp.hashCode()) * 31) + this.highTemp.hashCode()) * 31) + this.location.hashCode()) * 31) + this.hourForecastUIInfo.hashCode()) * 31) + this.backgroundResName.hashCode()) * 31) + Boolean.hashCode(this.isToday);
    }

    public String toString() {
        return "SingleDateWeatherInfoCardData(timeStr=" + this.timeStr + ", weatherCode=" + this.weatherCode + ", temp=" + this.temp + ", lowTemp=" + this.lowTemp + ", highTemp=" + this.highTemp + ", location=" + this.location + ", hourForecastUIInfo=" + this.hourForecastUIInfo + ", backgroundResName=" + this.backgroundResName + ", isToday=" + this.isToday + ')';
    }

    public SingleDateWeatherInfoCardData(String r3, String r4, String r5, String r6, String r7, String r8, List<HourForecastUIInfo> r9, String r10, boolean r11) {
        List<HourForecastUIInfo> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "timeStr");
        o.e(r4, "weatherCode");
        o.e(r5, "temp");
        o.e(r6, "lowTemp");
        o.e(r7, "highTemp");
        o.e(r8, "location");
        o.e(r12, "hourForecastUIInfo");
        o.e(r10, "backgroundResName");
        this.timeStr = r3;
        this.weatherCode = r4;
        this.temp = r5;
        this.lowTemp = r6;
        this.highTemp = r7;
        this.location = r8;
        this.hourForecastUIInfo = r12;
        this.backgroundResName = r10;
        this.isToday = r11;
    }

    public final String getTimeStr() {
        return this.timeStr;
    }

    public final String getWeatherCode() {
        return this.weatherCode;
    }

    public final String getTemp() {
        return this.temp;
    }

    public final String getLowTemp() {
        return this.lowTemp;
    }

    public final String getHighTemp() {
        return this.highTemp;
    }

    public final String getLocation() {
        return this.location;
    }

    public /* synthetic */ SingleDateWeatherInfoCardData(String r11, String r12, String r13, String r14, String r15, String r16, List r17, String r18, boolean r19, int r20, d.h.b.h r21) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        String r3 = "";
        if ((r20 & 1) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r7 = "";
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r20 & 64) == 0) goto L30;
        r1 = p.b();
    L30:
        if ((r20 & 128) != 0) goto L34;
        r3 = r18;
    L34:
        if ((r20 & 256) == 0) goto L36;
        boolean r0 = false;
    L37:
        this(r2, r4, r5, r6, r7, r8, r1, r3, r0);
        return;
    L36:
        r0 = r19;
        goto L37
    L25:
        r8 = r16;
        goto L27
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final List<HourForecastUIInfo> getHourForecastUIInfo() {
        return this.hourForecastUIInfo;
    }

    public final String getBackgroundResName() {
        return this.backgroundResName;
    }

    public final boolean isToday() {
        return this.isToday;
    }
}
