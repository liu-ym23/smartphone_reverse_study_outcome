package com.obric.agent.card.weather;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TypeDefine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HourForecastUIInfo {
    private final String temp;
    private final String timeStr;
    private final String weatherCode;

    public HourForecastUIInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ HourForecastUIInfo copy$default(HourForecastUIInfo r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.timeStr;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.temp;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.weatherCode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.timeStr;
    }

    public final String component2() {
        return this.temp;
    }

    public final String component3() {
        return this.weatherCode;
    }

    public final HourForecastUIInfo copy(String r1, String r2, String r3) {
        o.e(r1, "timeStr");
        o.e(r2, "temp");
        o.e(r3, "weatherCode");
        return new HourForecastUIInfo(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, HourForecastUIInfo.class) == true) goto L8;
        return false;
    L8:
        HourForecastUIInfo r6 = (HourForecastUIInfo) ZeusTransformUtils.preCheckCast(r5, HourForecastUIInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.timeStr, r6.timeStr) == true) goto L12;
        return false;
    L12:
        if (o.a(this.temp, r6.temp) == true) goto L15;
        return false;
    L15:
        if (o.a(this.weatherCode, r6.weatherCode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.timeStr.hashCode() * 31) + this.temp.hashCode()) * 31) + this.weatherCode.hashCode();
    }

    public String toString() {
        return "HourForecastUIInfo(timeStr=" + this.timeStr + ", temp=" + this.temp + ", weatherCode=" + this.weatherCode + ')';
    }

    public HourForecastUIInfo(String r2, String r3, String r4) {
        o.e(r2, "timeStr");
        o.e(r3, "temp");
        o.e(r4, "weatherCode");
        this.timeStr = r2;
        this.temp = r3;
        this.weatherCode = r4;
    }

    public /* synthetic */ HourForecastUIInfo(String r2, String r3, String r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }

    public final String getTimeStr() {
        return this.timeStr;
    }

    public final String getTemp() {
        return this.temp;
    }

    public final String getWeatherCode() {
        return this.weatherCode;
    }
}
