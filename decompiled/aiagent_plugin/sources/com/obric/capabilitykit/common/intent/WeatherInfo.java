package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Params.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WeatherInfo implements Parcelable {
    public static final Parcelable.Creator<WeatherInfo> CREATOR = null;
    private final Integer aqi;
    private final List<DayWeatherInfo> dailyWeather;
    private final Integer feelTemp;
    private final Integer highTemp;
    private final List<HourWeatherInfo> hourlyWeather;
    private final Integer humidity;
    private final String location;
    private final Integer lowTemp;
    private final String minuteRainDesc;
    private final String minuteRainShortDesc;
    private final Integer temp;
    private final String timezone;
    private final String uvLevel;
    private final String weatherCode;
    private final Double windDirection;
    private final Integer windSpeed;

    /* JADX INFO: compiled from: Params.kt */
    public static final class Creator implements Parcelable.Creator<WeatherInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WeatherInfo createFromParcel(Parcel r23) {
            int r1 = r23.readInt();
            o.e(r23, "parcel");
            String r4 = r23.readString();
            String r5 = r23.readString();
            if (r23.readInt() != 0) goto L5;
            Double r6 = null;
        L7:
            if (r23.readInt() != 0) goto L9;
            Integer r7 = null;
        L10:
            String r8 = r23.readString();
            if (r23.readInt() != 0) goto L13;
            Integer r9 = null;
        L15:
            if (r23.readInt() != 0) goto L17;
            Integer r10 = null;
        L19:
            if (r23.readInt() != 0) goto L21;
            Integer r11 = null;
        L23:
            if (r23.readInt() != 0) goto L25;
            Integer r12 = null;
        L27:
            if (r23.readInt() != 0) goto L29;
            Integer r13 = null;
        L31:
            if (r23.readInt() != 0) goto L33;
            Integer r14 = null;
        L34:
            String r15 = r23.readString();
            if (r23.readInt() != 0) goto L37;
            ArrayList r3 = null;
        L40:
            List r2 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
            if (r23.readInt() != 0) goto L43;
            ArrayList r16 = null;
        L47:
            WeatherInfo r17 = new WeatherInfo(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin"), r23.readString(), r23.readString());
            int r18 = Math.min(r1, 0);
            ClassLoader r19 = getClass().getClassLoader();
            int r20 = 1;
        L48:
            if (r20 > r18) goto L50;
            r20 = r20 + 1;
        L50:
            if (r20 > r1) goto L52;
            a.a(r23, r19);
            r20 = r20 + 1;
            goto L50
        L52:
            return r17;
        L43:
            int r21 = r23.readInt();
            ArrayList r22 = new ArrayList(r21);
            int r110 = 0;
        L44:
            if (r110 == r21) goto L46;
            int r111 = r21;
            r22.add(DayWeatherInfo.CREATOR.createFromParcel(r23));
            r110 = r110 + 1;
            r21 = r111;
            goto L44
        L46:
            r16 = r22;
            goto L47
        L37:
            int r24 = r23.readInt();
            r3 = new ArrayList(r24);
            int r25 = 0;
        L38:
            if (r25 == r24) goto L40;
            int r112 = r24;
            r3.add(HourWeatherInfo.CREATOR.createFromParcel(r23));
            r25 = r25 + 1;
            r24 = r112;
            goto L38
        L33:
            r14 = Integer.valueOf(r23.readInt());
            goto L34
        L29:
            r13 = Integer.valueOf(r23.readInt());
            goto L31
        L25:
            r12 = Integer.valueOf(r23.readInt());
            goto L27
        L21:
            r11 = Integer.valueOf(r23.readInt());
            goto L23
        L17:
            r10 = Integer.valueOf(r23.readInt());
            goto L19
        L13:
            r9 = Integer.valueOf(r23.readInt());
            goto L15
        L9:
            r7 = Integer.valueOf(r23.readInt());
            goto L10
        L5:
            r6 = Double.valueOf(r23.readDouble());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WeatherInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WeatherInfo[] newArray(int r1) {
            return new WeatherInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WeatherInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public WeatherInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, SupportMenu.USER_MASK, null);
    }

    public static /* synthetic */ WeatherInfo copy$default(WeatherInfo r17, String r18, String r19, Double r20, Integer r21, String r22, Integer r23, Integer r24, Integer r25, Integer r26, Integer r27, Integer r28, String r29, List r30, List r31, String r32, String r33, int r34, Object r35) {
        List<HourWeatherInfo> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.aiagent.plugin");
        List<DayWeatherInfo> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
        if ((r34 & 1) == 0) goto L5;
        String r4 = r17.timezone;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r5 = r17.location;
    L11:
        if ((r34 & 4) == 0) goto L13;
        Double r6 = r17.windDirection;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Integer r7 = r17.windSpeed;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r8 = r17.uvLevel;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Integer r9 = r17.humidity;
    L27:
        if ((r34 & 64) == 0) goto L29;
        Integer r10 = r17.aqi;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Integer r11 = r17.temp;
    L35:
        if ((r34 & 256) == 0) goto L37;
        Integer r12 = r17.feelTemp;
    L39:
        if ((r34 & 512) == 0) goto L41;
        Integer r13 = r17.lowTemp;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        Integer r14 = r17.highTemp;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r15 = r17.weatherCode;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        List<HourWeatherInfo> r16 = r17.hourlyWeather;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        List<DayWeatherInfo> r36 = r17.dailyWeather;
    L58:
        List<DayWeatherInfo> r37 = r36;
        if ((r34 & 16384) == 0) goto L61;
        String r38 = r17.minuteRainDesc;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        String r1 = r17.minuteRainShortDesc;
    L67:
        return r17.copy(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r37, r38, r1);
    L65:
        r1 = r33;
        goto L67
    L61:
        r38 = r32;
        goto L63
    L57:
        r36 = r3;
        goto L58
    L53:
        r16 = r2;
        goto L55
    L49:
        r15 = r29;
        goto L51
    L45:
        r14 = r28;
        goto L47
    L41:
        r13 = r27;
        goto L43
    L37:
        r12 = r26;
        goto L39
    L33:
        r11 = r25;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r20;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }

    public final String component1() {
        return this.timezone;
    }

    public final Integer component10() {
        return this.lowTemp;
    }

    public final Integer component11() {
        return this.highTemp;
    }

    public final String component12() {
        return this.weatherCode;
    }

    public final List<HourWeatherInfo> component13() {
        return this.hourlyWeather;
    }

    public final List<DayWeatherInfo> component14() {
        return this.dailyWeather;
    }

    public final String component15() {
        return this.minuteRainDesc;
    }

    public final String component16() {
        return this.minuteRainShortDesc;
    }

    public final String component2() {
        return this.location;
    }

    public final Double component3() {
        return this.windDirection;
    }

    public final Integer component4() {
        return this.windSpeed;
    }

    public final String component5() {
        return this.uvLevel;
    }

    public final Integer component6() {
        return this.humidity;
    }

    public final Integer component7() {
        return this.aqi;
    }

    public final Integer component8() {
        return this.temp;
    }

    public final Integer component9() {
        return this.feelTemp;
    }

    public final WeatherInfo copy(String r19, String r20, Double r21, Integer r22, String r23, Integer r24, Integer r25, Integer r26, Integer r27, Integer r28, Integer r29, String r30, List<HourWeatherInfo> r31, List<DayWeatherInfo> r32, String r33, String r34) {
        return new WeatherInfo(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.aiagent.plugin"), r33, r34);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, WeatherInfo.class) == true) goto L8;
        return false;
    L8:
        WeatherInfo r6 = (WeatherInfo) ZeusTransformUtils.preCheckCast(r5, WeatherInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.timezone, r6.timezone) == true) goto L12;
        return false;
    L12:
        if (o.a(this.location, r6.location) == true) goto L15;
        return false;
    L15:
        if (o.a(this.windDirection, r6.windDirection) == true) goto L18;
        return false;
    L18:
        if (o.a(this.windSpeed, r6.windSpeed) == true) goto L21;
        return false;
    L21:
        if (o.a(this.uvLevel, r6.uvLevel) == true) goto L24;
        return false;
    L24:
        if (o.a(this.humidity, r6.humidity) == true) goto L27;
        return false;
    L27:
        if (o.a(this.aqi, r6.aqi) == true) goto L30;
        return false;
    L30:
        if (o.a(this.temp, r6.temp) == true) goto L33;
        return false;
    L33:
        if (o.a(this.feelTemp, r6.feelTemp) == true) goto L36;
        return false;
    L36:
        if (o.a(this.lowTemp, r6.lowTemp) == true) goto L39;
        return false;
    L39:
        if (o.a(this.highTemp, r6.highTemp) == true) goto L42;
        return false;
    L42:
        if (o.a(this.weatherCode, r6.weatherCode) == true) goto L45;
        return false;
    L45:
        if (o.a(this.hourlyWeather, r6.hourlyWeather) == true) goto L48;
        return false;
    L48:
        if (o.a(this.dailyWeather, r6.dailyWeather) == true) goto L51;
        return false;
    L51:
        if (o.a(this.minuteRainDesc, r6.minuteRainDesc) == true) goto L54;
        return false;
    L54:
        if (o.a(this.minuteRainShortDesc, r6.minuteRainShortDesc) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        String r0 = this.timezone;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.location;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Double r7 = this.windDirection;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.windSpeed;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.uvLevel;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.humidity;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.aqi;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.temp;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.feelTemp;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.lowTemp;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.highTemp;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.weatherCode;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        List<HourWeatherInfo> r37 = this.hourlyWeather;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        List<DayWeatherInfo> r40 = this.dailyWeather;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.minuteRainDesc;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.minuteRainShortDesc;
        if (r46 == null) goto L67;
        r1 = r46.hashCode();
    L67:
        return r45 + r1;
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
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
        StringBuilder r0 = new StringBuilder();
        r0.append("WeatherInfo(timezone=").append(this.timezone).append(", location=").append(this.location).append(", windDirection=").append(this.windDirection).append(", windSpeed=").append(this.windSpeed).append(", uvLevel=").append(this.uvLevel).append(", humidity=").append(this.humidity).append(", aqi=").append(this.aqi).append(", temp=").append(this.temp).append(", feelTemp=").append(this.feelTemp).append(", lowTemp=").append(this.lowTemp).append(", highTemp=").append(this.highTemp).append(", weatherCode=");
        r0.append(this.weatherCode).append(", hourlyWeather=").append(this.hourlyWeather).append(", dailyWeather=").append(this.dailyWeather).append(", minuteRainDesc=").append(this.minuteRainDesc).append(", minuteRainShortDesc=").append(this.minuteRainShortDesc).append(')');
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r7, int r8) {
        r7.writeInt(0);
        o.e(r7, "out");
        r7.writeString(this.timezone);
        r7.writeString(this.location);
        Double r1 = this.windDirection;
        if (r1 != null) goto L5;
        r7.writeInt(0);
    L6:
        Integer r2 = this.windSpeed;
        if (r2 != null) goto L9;
        r7.writeInt(0);
    L10:
        r7.writeString(this.uvLevel);
        Integer r3 = this.humidity;
        if (r3 != null) goto L13;
        r7.writeInt(0);
    L14:
        Integer r4 = this.aqi;
        if (r4 != null) goto L17;
        r7.writeInt(0);
    L18:
        Integer r5 = this.temp;
        if (r5 != null) goto L21;
        r7.writeInt(0);
    L22:
        Integer r6 = this.feelTemp;
        if (r6 != null) goto L25;
        r7.writeInt(0);
    L26:
        Integer r9 = this.lowTemp;
        if (r9 != null) goto L29;
        r7.writeInt(0);
    L30:
        Integer r10 = this.highTemp;
        if (r10 != null) goto L33;
        r7.writeInt(0);
    L34:
        r7.writeString(this.weatherCode);
        List<HourWeatherInfo> r11 = this.hourlyWeather;
        if (r11 != null) goto L37;
        r7.writeInt(0);
    L41:
        List<DayWeatherInfo> r12 = this.dailyWeather;
        if (r12 != null) goto L44;
        r7.writeInt(0);
    L48:
        r7.writeString(this.minuteRainDesc);
        r7.writeString(this.minuteRainShortDesc);
        return;
    L44:
        r7.writeInt(1);
        r7.writeInt(r12.size());
        Iterator<DayWeatherInfo> r0 = r12.iterator();
    L46:
        if (r0.hasNext() == false) goto L48;
        ((DayWeatherInfo) ZeusTransformUtils.preCheckCast(r0.next(), DayWeatherInfo.class, "com.obric.aiagent.plugin")).writeToParcel(r7, r8);
        goto L46
    L37:
        r7.writeInt(1);
        r7.writeInt(r11.size());
        Iterator<HourWeatherInfo> r13 = r11.iterator();
    L39:
        if (r13.hasNext() == false) goto L41;
        ((HourWeatherInfo) ZeusTransformUtils.preCheckCast(r13.next(), HourWeatherInfo.class, "com.obric.aiagent.plugin")).writeToParcel(r7, r8);
        goto L39
    L33:
        r7.writeInt(1);
        r7.writeInt(r10.intValue());
        goto L34
    L29:
        r7.writeInt(1);
        r7.writeInt(r9.intValue());
        goto L30
    L25:
        r7.writeInt(1);
        r7.writeInt(r6.intValue());
        goto L26
    L21:
        r7.writeInt(1);
        r7.writeInt(r5.intValue());
        goto L22
    L17:
        r7.writeInt(1);
        r7.writeInt(r4.intValue());
        goto L18
    L13:
        r7.writeInt(1);
        r7.writeInt(r3.intValue());
        goto L14
    L9:
        r7.writeInt(1);
        r7.writeInt(r2.intValue());
        goto L10
    L5:
        r7.writeInt(1);
        r7.writeDouble(r1.doubleValue());
        goto L6
    }

    public WeatherInfo(String r6, String r7, Double r8, Integer r9, String r10, Integer r11, Integer r12, Integer r13, Integer r14, Integer r15, Integer r16, String r17, List<HourWeatherInfo> r18, List<DayWeatherInfo> r19, String r20, String r21) {
        List<HourWeatherInfo> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        List<DayWeatherInfo> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        this.timezone = r6;
        this.location = r7;
        this.windDirection = r8;
        this.windSpeed = r9;
        this.uvLevel = r10;
        this.humidity = r11;
        this.aqi = r12;
        this.temp = r13;
        this.feelTemp = r14;
        this.lowTemp = r15;
        this.highTemp = r16;
        this.weatherCode = r17;
        this.hourlyWeather = r1;
        this.dailyWeather = r2;
        this.minuteRainDesc = r20;
        this.minuteRainShortDesc = r21;
    }

    public /* synthetic */ WeatherInfo(String r18, String r19, Double r20, Integer r21, String r22, Integer r23, Integer r24, Integer r25, Integer r26, Integer r27, Integer r28, String r29, List r30, List r31, String r32, String r33, int r34, h r35) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
        if ((r34 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        Double r6 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Integer r7 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Integer r9 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        Integer r10 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Integer r11 = null;
    L35:
        if ((r34 & 256) == 0) goto L37;
        Integer r12 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        Integer r13 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        Integer r14 = null;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r15 = null;
    L51:
        if ((r34 & 4096) == 0) goto L54;
        r1 = null;
    L54:
        if ((r34 & 8192) == 0) goto L57;
        r2 = null;
    L57:
        if ((r34 & 16384) == 0) goto L59;
        String r4 = null;
    L61:
        if ((r34 & 32768) == 0) goto L63;
        String r0 = null;
    L64:
        this(r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1, r2, r4, r0);
        return;
    L63:
        r0 = r33;
        goto L64
    L59:
        r4 = r32;
        goto L61
    L49:
        r15 = r29;
        goto L51
    L45:
        r14 = r28;
        goto L47
    L41:
        r13 = r27;
        goto L43
    L37:
        r12 = r26;
        goto L39
    L33:
        r11 = r25;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r20;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final String getLocation() {
        return this.location;
    }

    public final Double getWindDirection() {
        return this.windDirection;
    }

    public final Integer getWindSpeed() {
        return this.windSpeed;
    }

    public final String getUvLevel() {
        return this.uvLevel;
    }

    public final Integer getHumidity() {
        return this.humidity;
    }

    public final Integer getAqi() {
        return this.aqi;
    }

    public final Integer getTemp() {
        return this.temp;
    }

    public final Integer getFeelTemp() {
        return this.feelTemp;
    }

    public final Integer getLowTemp() {
        return this.lowTemp;
    }

    public final Integer getHighTemp() {
        return this.highTemp;
    }

    public final String getWeatherCode() {
        return this.weatherCode;
    }

    public final List<HourWeatherInfo> getHourlyWeather() {
        return this.hourlyWeather;
    }

    public final List<DayWeatherInfo> getDailyWeather() {
        return this.dailyWeather;
    }

    public final String getMinuteRainDesc() {
        return this.minuteRainDesc;
    }

    public final String getMinuteRainShortDesc() {
        return this.minuteRainShortDesc;
    }
}
