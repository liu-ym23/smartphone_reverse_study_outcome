package com.obric.agent.card.weather;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TypeDefine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MultiDateWeatherInfoSingleDayCardData {
    private final int currentTemperatureCelsius;
    private final String highTemp;
    private final boolean isToday;
    private final String lowTemp;
    private final String timeStr;
    private final String weatherCode;
    private final String weekDay;

    public static /* synthetic */ MultiDateWeatherInfoSingleDayCardData copy$default(MultiDateWeatherInfoSingleDayCardData r5, String r6, String r7, String r8, String r9, int r10, boolean r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.timeStr;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.weatherCode;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.lowTemp;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.highTemp;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.currentTemperatureCelsius;
    L17:
        int r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.isToday;
    L20:
        boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.weekDay;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.timeStr;
    }

    public final String component2() {
        return this.weatherCode;
    }

    public final String component3() {
        return this.lowTemp;
    }

    public final String component4() {
        return this.highTemp;
    }

    public final int component5() {
        return this.currentTemperatureCelsius;
    }

    public final boolean component6() {
        return this.isToday;
    }

    public final String component7() {
        return this.weekDay;
    }

    public final MultiDateWeatherInfoSingleDayCardData copy(String r9, String r10, String r11, String r12, int r13, boolean r14, String r15) {
        o.e(r9, "timeStr");
        o.e(r10, "weatherCode");
        o.e(r11, "lowTemp");
        o.e(r12, "highTemp");
        o.e(r15, "weekDay");
        return new MultiDateWeatherInfoSingleDayCardData(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MultiDateWeatherInfoSingleDayCardData.class) == true) goto L8;
        return false;
    L8:
        MultiDateWeatherInfoSingleDayCardData r6 = (MultiDateWeatherInfoSingleDayCardData) ZeusTransformUtils.preCheckCast(r5, MultiDateWeatherInfoSingleDayCardData.class, "com.obric.aiagent.plugin");
        if (o.a(this.timeStr, r6.timeStr) == true) goto L12;
        return false;
    L12:
        if (o.a(this.weatherCode, r6.weatherCode) == true) goto L15;
        return false;
    L15:
        if (o.a(this.lowTemp, r6.lowTemp) == true) goto L18;
        return false;
    L18:
        if (o.a(this.highTemp, r6.highTemp) == true) goto L21;
        return false;
    L21:
        if (this.currentTemperatureCelsius == r6.currentTemperatureCelsius) goto L24;
        return false;
    L24:
        if (this.isToday == r6.isToday) goto L27;
        return false;
    L27:
        if (o.a(this.weekDay, r6.weekDay) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.timeStr.hashCode() * 31) + this.weatherCode.hashCode()) * 31) + this.lowTemp.hashCode()) * 31) + this.highTemp.hashCode()) * 31) + Integer.hashCode(this.currentTemperatureCelsius)) * 31) + Boolean.hashCode(this.isToday)) * 31) + this.weekDay.hashCode();
    }

    public String toString() {
        return "MultiDateWeatherInfoSingleDayCardData(timeStr=" + this.timeStr + ", weatherCode=" + this.weatherCode + ", lowTemp=" + this.lowTemp + ", highTemp=" + this.highTemp + ", currentTemperatureCelsius=" + this.currentTemperatureCelsius + ", isToday=" + this.isToday + ", weekDay=" + this.weekDay + ')';
    }

    public MultiDateWeatherInfoSingleDayCardData(String r2, String r3, String r4, String r5, int r6, boolean r7, String r8) {
        o.e(r2, "timeStr");
        o.e(r3, "weatherCode");
        o.e(r4, "lowTemp");
        o.e(r5, "highTemp");
        o.e(r8, "weekDay");
        this.timeStr = r2;
        this.weatherCode = r3;
        this.lowTemp = r4;
        this.highTemp = r5;
        this.currentTemperatureCelsius = r6;
        this.isToday = r7;
        this.weekDay = r8;
    }

    public /* synthetic */ MultiDateWeatherInfoSingleDayCardData(String r11, String r12, String r13, String r14, int r15, boolean r16, String r17, int r18, d.h.b.h r19) {
        if ((r18 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r6 = "";
    L18:
        this(r3, r4, r5, r6, r15, r16, r17);
        return;
    L17:
        r6 = r14;
        goto L18
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

    public final String getTimeStr() {
        return this.timeStr;
    }

    public final String getWeatherCode() {
        return this.weatherCode;
    }

    public final String getLowTemp() {
        return this.lowTemp;
    }

    public final String getHighTemp() {
        return this.highTemp;
    }

    public final int getCurrentTemperatureCelsius() {
        return this.currentTemperatureCelsius;
    }

    public final boolean isToday() {
        return this.isToday;
    }

    public final String getWeekDay() {
        return this.weekDay;
    }
}
