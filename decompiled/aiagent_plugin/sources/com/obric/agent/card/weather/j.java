package com.obric.agent.card.weather;

import android.content.Context;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.intent.DayWeatherInfo;
import com.obric.capabilitykit.common.intent.HourWeatherInfo;
import com.obric.capabilitykit.common.intent.WeatherInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.m;
import d.n;
import d.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: WeatherIntentWidgetEntityBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    private static final String TAG = "WeatherWidgetEntityBuilder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f14298a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SimpleDateFormat f14299b = null;

    /* JADX INFO: compiled from: WeatherIntentWidgetEntityBuilder.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f14302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f14303d;

        public final String a() {
            return this.f14300a;
        }

        public final String b() {
            return this.f14301b;
        }

        public final String c() {
            return this.f14302c;
        }

        public final int d() {
            return this.f14303d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14300a, r6.f14300a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14301b, r6.f14301b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14302c, r6.f14302c) == true) goto L18;
            return false;
        L18:
            if (this.f14303d == r6.f14303d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f14300a.hashCode() * 31) + this.f14301b.hashCode()) * 31) + this.f14302c.hashCode()) * 31) + Integer.hashCode(this.f14303d);
        }

        public String toString() {
            return "Quad(layoutType=" + this.f14300a + ", mainInfo=" + this.f14301b + ", tagText=" + this.f14302c + ", tagType=" + this.f14303d + ')';
        }

        public a(String r2, String r3, String r4, int r5) {
            o.e(r2, "layoutType");
            o.e(r3, "mainInfo");
            o.e(r4, "tagText");
            this.f14300a = r2;
            this.f14301b = r3;
            this.f14302c = r4;
            this.f14303d = r5;
        }
    }

    private j() {
    }

    static {
        f14298a = new j();
        f14299b = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    public final String a(Context r14, String r15, String r16, String r17, String r18, WeatherInfo r19, String r20) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        o.e(r15, "queryType");
        o.e(r19, "weatherInfo");
        o.e(r20, "questionId");
        Object r12 = null;
        n.a r0 = n.f38560a;     // Catch: Throwable -> L9
        j r1 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        JsonObject r3 = r1.a(r2, r1.a(r15, r20), r15, r16, r17, r18, r19);     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        String r4 = r3.toString();     // Catch: Throwable -> L9
    L7:
        Object r5 = n.f(r4);     // Catch: Throwable -> L9
    L11:
        Throwable r6 = n.c(r5);
        if (r6 == null) goto L15;
        ILogDepend.Companion.e(TAG, "failed to build weather entity json, questionId=" + r20 + ", queryType=" + r15 + ", error=" + r6.getMessage());
    L15:
        if (n.b(r5) == true) goto L19;
        r12 = r5;
    L19:
        return (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin");
    L6:
        r4 = null;
    L9:
        th = move-exception;
        n.a r7 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L11
    }

    public final JsonObject a(Context r18, String r19, String r20, String r21, String r22, String r23, WeatherInfo r24) {
        String r11 = r21;
        String r12 = r22;
        String r13 = r23;
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        o.e(r19, "cardId");
        o.e(r20, "queryType");
        o.e(r24, "weatherInfo");
        if (r12 != null) goto L91;
    L13:
        Date r0 = new Date();
    L14:
        Date r6 = r0;
        if (r13 != null) goto L89;
        Date r7 = null;
    L26:
        switch(r20.hashCode()) {
            case -1721883361: goto L57;
            case -437908363: goto L54;
            case -217870625: goto L51;
            case 2721: goto L48;
            case 69225531: goto L45;
            case 1330654387: goto L42;
            case 1336927871: goto L38;
            case 1941423060: goto L29;
            default: goto L60;
        };
    L60:
        JsonObject r1 = a(r2, r19, r20, r21, r6, r24);
    L61:
        if (r1 == null) goto L93;
        r1.addProperty("ecaid", r19);
        r1.addProperty("queryType", r20);
        String r3 = r24.getLocation();
        if (r3 != null) goto L65;
        r3 = "";
    L65:
        r1.addProperty("location", r3);
        r1.addProperty("packageName", "com.obric.weather");
        if (r11 != null) goto L68;
    L73:
        if (r12 != null) goto L75;
    L80:
        if (r13 == null) goto L88;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L85;
        r13 = null;
    L85:
        if (r13 == null) goto L88;
        r1.addProperty("endTime", r13);
    L88:
        return r1;
    L75:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L78;
        r12 = null;
    L78:
        if (r12 == null) goto L80;
        r1.addProperty("startTime", r12);
        goto L80
    L68:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L71;
        r11 = null;
    L71:
        if (r11 == null) goto L73;
        r1.addProperty("rawTime", r11);
        goto L73
    L93:
        return null;
    L29:
        if (r20.equals("WEATHER") == false) goto L60;
        if (r7 != null) goto L33;
    L36:
        r1 = a(r2, r19, r20, r21, r6, r24);
        goto L61
    L33:
        if (b.a(r6, r7) == true) goto L36;
        r1 = a(r2, r19, r20, r21, r6, r7, r24);
        goto L61
    L38:
        if (r20.equals("SUN_RISE_SET") == false) goto L60;
        r1 = a(r19, r20, r21, r6, r24);
        goto L61
    L42:
        if (r20.equals("HUMIDITY") == false) goto L60;
    L59:
        r1 = b(r19, r20, r21, r6, r24);
        goto L61
    L45:
        if (r20.equals("FEEL_TEMPERATURE") == true) goto L59;
    L48:
        if (r20.equals("UV") == true) goto L59;
    L51:
        if (r20.equals("MINUTE_RAIN") == true) goto L59;
    L54:
        if (r20.equals("AIRQUALITY") == true) goto L59;
    L57:
        if (r20.equals("WINDSPEED") == true) goto L59;
    L89:
        n.a r4 = n.f38560a;     // Catch: Throwable -> L18
        Object r5 = n.f(f14299b.parse(r13));     // Catch: Throwable -> L18
    L21:
        if (n.b(r5) == false) goto L23;
        r5 = null;
    L23:
        r7 = (Date) ZeusTransformUtils.preCheckCast(r5, Date.class, "com.obric.aiagent.plugin");
    L18:
        th = move-exception;
        n.a r8 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L21
    L91:
        n.a r9 = n.f38560a;     // Catch: Throwable -> L6
        Object r10 = n.f(f14299b.parse(r12));     // Catch: Throwable -> L6
    L9:
        if (n.b(r10) == false) goto L11;
        r10 = null;
    L11:
        r0 = (Date) ZeusTransformUtils.preCheckCast(r10, Date.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L14;
    L6:
        th = move-exception;
        n.a r14 = n.f38560a;
        r10 = n.f(d.o.a(th));
        goto L9
    }

    public final String a(String r3, String r4) {
        o.e(r3, "queryType");
        o.e(r4, "questionId");
        StringBuilder r2 = new StringBuilder().append("mock_weather_");
        Locale r0 = Locale.getDefault();
        o.c(r0, "getDefault(...)");
        String r5 = r3.toLowerCase(r0);
        o.c(r5, "toLowerCase(...)");
        return r2.append(r5).append('_').append(r4).toString();
    }

    private final JsonObject a(Context r9, String r10, String r11, String r12, Date r13, WeatherInfo r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        boolean r0 = b.a(r13);
        String r2 = "";
        if (r0 == true) goto L30;
        List<DayWeatherInfo> r4 = r14.getDailyWeather();
        if (r4 == null) goto L30;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r5.hasNext() == false) goto L28;
        Object r6 = r5.next();
        DayWeatherInfo r7 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r6, DayWeatherInfo.class, "com.obric.aiagent.plugin");
        n.a r8 = n.f38560a;     // Catch: Throwable -> L15
        SimpleDateFormat r16 = f14299b;     // Catch: Throwable -> L15
        String r17 = r7.getDate();     // Catch: Throwable -> L15
        if (r17 != null) goto L13;
        r17 = "";
    L13:
        Object r18 = n.f(r16.parse(r17));     // Catch: Throwable -> L15
    L18:
        if (n.b(r18) == false) goto L20;
        r18 = null;
    L20:
        Date r19 = (Date) ZeusTransformUtils.preCheckCast(r18, Date.class, "com.obric.aiagent.plugin");
        if (r19 != null) goto L23;
    L25:
        boolean r20 = false;
    L26:
        if (r20 == false) goto L8;
    L29:
        DayWeatherInfo r21 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r6, DayWeatherInfo.class, "com.obric.aiagent.plugin");
    L31:
        if (r0 == false) goto L33;
        String r22 = r14.getWeatherCode();
    L36:
        if (r22 == null) goto L39;
        r2 = r22;
    L39:
        if (r0 == false) goto L41;
    L40:
        Integer r23 = r14.getLowTemp();
    L45:
        if (r0 == false) goto L47;
    L46:
        Integer r24 = r14.getHighTemp();
    L51:
        JsonObject r25 = a(r10, r11, r14);
        r25.addProperty("layoutType", "single_date_weather_info");
        j r110 = f14298a;
        r25.addProperty("timeStr", r110.a(r13, r12));
        r25.addProperty("weatherCode", r2);
        String r111 = i.a(r15, r2);
        if (r111 == null) goto L54;
        r25.addProperty("weatherText", r111);
    L54:
        r110.a(r25, "temp", r14.getTemp());
        r110.a(r25, "lowTemp", r23);
        r110.a(r25, "highTemp", r24);
        r25.addProperty("backgroundResName", i.a(r14, r2, r0));
        r25.addProperty("isToday", Boolean.valueOf(r0));
        r25.add("hourlyWeather", (JsonElement) ZeusTransformUtils.preCheckCast(r110.a(r14), JsonElement.class, "com.obric.aiagent.plugin"));
        r25.add("dailyWeather", (JsonElement) ZeusTransformUtils.preCheckCast(r110.a(r15, r14, null, null), JsonElement.class, "com.obric.aiagent.plugin"));
        return r25;
    L47:
        if (r21 == null) goto L46;
        r24 = r21.getHighTemp();
        if (r24 != null) goto L51;
    L41:
        if (r21 == null) goto L40;
        r23 = r21.getLowTemp();
        if (r23 != null) goto L45;
    L33:
        if (r21 == null) goto L35;
        r22 = r21.getWeatherCode();
        goto L36
    L35:
        r22 = null;
        goto L36
    L23:
        if (b.a(r19, r13) == false) goto L25;
        r20 = true;
    L15:
        th = move-exception;
        n.a r26 = n.f38560a;
        r18 = n.f(d.o.a(th));
        goto L18
    L28:
        r6 = null;
    L30:
        r21 = null;
        goto L31
    }

    private final JsonObject a(Context r3, String r4, String r5, String r6, Date r7, Date r8, WeatherInfo r9) {
        JsonArray r10 = a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r9, r7, r8);
        JsonObject r2 = a(r4, r5, r9);
        r2.addProperty("layoutType", "multi_date_weather_info");
        int r0 = 0;
        r2.addProperty("timeStr", f.f14288a.a(r6, p.b(new Date[]{r7, r8}), "未来天气"));
        if (r10.size() <= 7) goto L5;
        r0 = 1;
    L5:
        r2.addProperty("styleType", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r0), Number.class, "com.obric.aiagent.plugin"));
        r2.add("dailyWeather", (JsonElement) ZeusTransformUtils.preCheckCast(r10, JsonElement.class, "com.obric.aiagent.plugin"));
        r2.add("hourlyWeather", (JsonElement) ZeusTransformUtils.preCheckCast(f14298a.a(r9), JsonElement.class, "com.obric.aiagent.plugin"));
        return r2;
    }

    private final JsonObject a(String r9, String r10, String r11, Date r12, WeatherInfo r13) {
        List<DayWeatherInfo> r0 = r13.getDailyWeather();
        String r1 = "";
        if (r0 == null) goto L28;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r2.hasNext() == false) goto L26;
        Object r5 = r2.next();
        DayWeatherInfo r6 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r5, DayWeatherInfo.class, "com.obric.aiagent.plugin");
        n.a r7 = n.f38560a;     // Catch: Throwable -> L13
        SimpleDateFormat r8 = f14299b;     // Catch: Throwable -> L13
        String r14 = r6.getDate();     // Catch: Throwable -> L13
        if (r14 != null) goto L11;
        r14 = "";
    L11:
        Object r15 = n.f(r8.parse(r14));     // Catch: Throwable -> L13
    L16:
        if (n.b(r15) == false) goto L18;
        r15 = null;
    L18:
        Date r16 = (Date) ZeusTransformUtils.preCheckCast(r15, Date.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L21;
    L23:
        boolean r17 = false;
    L24:
        if (r17 == false) goto L6;
    L27:
        DayWeatherInfo r3 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r5, DayWeatherInfo.class, "com.obric.aiagent.plugin");
    L29:
        if (r3 == null) goto L35;
        String r18 = r3.getSunRise();
        if (r18 == null) goto L35;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L35;
    L36:
        if (r3 == null) goto L42;
        String r4 = r3.getSunSet();
        if (r4 == null) goto L42;
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L42;
    L43:
        if (r18 != null) goto L46;
        if (r4 != null) goto L46;
        return null;
    L46:
        JsonObject r19 = a(r9, r10, r13);
        r19.addProperty("layoutType", "sun_rise_set_info");
        r19.addProperty("dateDesc", f14298a.a(r12, r11));
        if (r18 != null) goto L49;
        r18 = "";
    L49:
        r19.addProperty("sunRise", r18);
        if (r4 == null) goto L53;
        r1 = r4;
    L53:
        r19.addProperty("sunSet", r1);
        return r19;
    L42:
        r4 = null;
    L35:
        r18 = null;
        goto L36
    L21:
        if (b.a(r16, r12) == false) goto L23;
        r17 = true;
    L13:
        th = move-exception;
        n.a r20 = n.f38560a;
        r15 = n.f(d.o.a(th));
        goto L16
    L26:
        r5 = null;
        goto L27
    L28:
        r3 = null;
        goto L29
    }

    private final JsonObject b(String r8, String r9, String r10, Date r11, WeatherInfo r12) {
        int r1 = 0;
        switch(r9.hashCode()) {
            case -1721883361: goto L47;
            case -437908363: goto L40;
            case -217870625: goto L27;
            case 2721: goto L20;
            case 69225531: goto L13;
            case 1330654387: goto L6;
            default: goto L52;
        };
    L52:
        return null;
    L6:
        if (r9.equals("HUMIDITY") == false) goto L52;
        Integer r0 = r12.getHumidity();
        if (r0 == null) goto L11;
        r1 = r0.intValue();
    L11:
        m<String, CardTagType> r2 = a(r1);
        a r3 = new a("humidity_info", "相对湿度：" + r1 + '%', (String) ZeusTransformUtils.preCheckCast(r2.c(), String.class, "com.obric.aiagent.plugin"), ((CardTagType) ZeusTransformUtils.preCheckCast(r2.d(), CardTagType.class, "com.obric.aiagent.plugin")).ordinal());
    L50:
        String r4 = r3.a();
        String r5 = r3.b();
        String r6 = r3.c();
        int r7 = r3.d();
        JsonObject r13 = a(r8, r9, r12);
        r13.addProperty("layoutType", r4);
        r13.addProperty("mainInfo", r5);
        r13.addProperty("dateDesc", f14298a.a(r11, r10));
        r13.addProperty("tagText", r6);
        r13.addProperty("tagType", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r7), Number.class, "com.obric.aiagent.plugin"));
        return r13;
    L13:
        if (r9.equals("FEEL_TEMPERATURE") == false) goto L52;
        Integer r14 = r12.getFeelTemp();
        if (r14 == null) goto L18;
        int r15 = r14.intValue();
        m<String, CardTagType> r16 = c(r15);
        r3 = new a("feel_temperature_info", "体感温度：" + r15 + 176, (String) ZeusTransformUtils.preCheckCast(r16.c(), String.class, "com.obric.aiagent.plugin"), ((CardTagType) ZeusTransformUtils.preCheckCast(r16.d(), CardTagType.class, "com.obric.aiagent.plugin")).ordinal());
        goto L50
    L18:
        return null;
    L20:
        if (r9.equals("UV") == false) goto L52;
        StringBuilder r17 = new StringBuilder().append("紫外线指数：");
        String r18 = r12.getUvLevel();
        if (r18 != null) goto L25;
        r18 = "";
    L25:
        r3 = new a("uv_info", r17.append(r18).toString(), "", CardTagType.GOOD.ordinal());
        goto L50
    L27:
        if (r9.equals("MINUTE_RAIN") == false) goto L52;
        String r19 = r12.getMinuteRainShortDesc();
        if (r19 != null) goto L32;
    L38:
        return null;
    L32:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L35;
        r19 = null;
    L35:
        if (r19 == null) goto L38;
        r3 = new a("minute_rain_info", r19, "", CardTagType.GOOD.ordinal());
        goto L50
    L40:
        if (r9.equals("AIRQUALITY") == false) goto L52;
        Integer r20 = r12.getAqi();
        if (r20 == null) goto L45;
        r1 = r20.intValue();
    L45:
        m<String, CardTagType> r21 = b(r1);
        r3 = new a("aqi_info", "空气质量 " + r1, (String) ZeusTransformUtils.preCheckCast(r21.c(), String.class, "com.obric.aiagent.plugin"), ((CardTagType) ZeusTransformUtils.preCheckCast(r21.d(), CardTagType.class, "com.obric.aiagent.plugin")).ordinal());
        goto L50
    L47:
        if (r9.equals("WINDSPEED") == false) goto L52;
        r3 = new a("wind_speed_info", "风速：" + b(r12), "", CardTagType.GOOD.ordinal());
        goto L50
    }

    private final JsonObject a(String r3, String r4, WeatherInfo r5) {
        JsonObject r2 = new JsonObject();
        r2.addProperty("ecaid", r3);
        r2.addProperty("queryType", r4);
        String r6 = r5.getLocation();
        String r7 = "";
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r2.addProperty("location", r6);
        String r8 = r5.getTimezone();
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        r2.addProperty("timezone", r8);
        String r9 = r5.getWeatherCode();
        if (r9 != null) goto L11;
        r9 = "";
    L11:
        r2.addProperty("weatherCode", r9);
        j r10 = f14298a;
        r10.a(r2, "temp", r5.getTemp());
        r10.a(r2, "lowTemp", r5.getLowTemp());
        r10.a(r2, "highTemp", r5.getHighTemp());
        r10.a(r2, "humidity", r5.getHumidity());
        r10.a(r2, "aqi", r5.getAqi());
        r10.a(r2, "windSpeed", r5.getWindSpeed());
        r10.a(r2, "windDirection", r5.getWindDirection());
        String r0 = r5.getUvLevel();
        if (r0 != null) goto L14;
        r0 = "";
    L14:
        r2.addProperty("uvLevel", r0);
        r10.a(r2, "feelTemp", r5.getFeelTemp());
        String r11 = r5.getMinuteRainShortDesc();
        if (r11 == null) goto L18;
        r7 = r11;
    L18:
        r2.addProperty("minuteRainShortDesc", r7);
        return r2;
    }

    private final JsonArray a(WeatherInfo r8) {
        JsonArray r7 = new JsonArray();
        List<HourWeatherInfo> r9 = r8.getHourlyWeather();
        if (r9 == null) goto L15;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r10.hasNext() == false) goto L15;
        HourWeatherInfo r0 = (HourWeatherInfo) ZeusTransformUtils.preCheckCast(r10.next(), HourWeatherInfo.class, "com.obric.aiagent.plugin");
        JsonObject r2 = new JsonObject();
        String r3 = r0.getTime();
        String r4 = "";
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r2.addProperty("time", r3);
        f14298a.a(r2, "temp", r0.getTemp());
        String r1 = r0.getWeatherCode();
        if (r1 == null) goto L14;
        r4 = r1;
    L14:
        r2.addProperty("weatherCode", r4);
        r7.add((JsonElement) ZeusTransformUtils.preCheckCast(r2, JsonElement.class, "com.obric.aiagent.plugin"));
    L15:
        return r7;
    }

    private final JsonArray a(Context r11, WeatherInfo r12, Date r13, Date r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        j r10 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r16 = n.f(ZeusTransformUtils.getResources(r15, "com.obric.aiagent.plugin").getStringArray(ZeusTransformUtils.mapRes(R.array.weekday_arrays, "array", "weekday_arrays")));     // Catch: Throwable -> L5
    L7:
        String[] r2 = new String[0];
        if (n.b(r16) == false) goto L10;
        r16 = r2;
    L10:
        String[] r17 = (String[]) ZeusTransformUtils.preCheckCast(r16, String[].class, "com.obric.aiagent.plugin");
        JsonArray r3 = new JsonArray();
        List<DayWeatherInfo> r18 = r12.getDailyWeather();
        if (r18 == null) goto L63;
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r19.hasNext() == false) goto L63;
        DayWeatherInfo r4 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r19.next(), DayWeatherInfo.class, "com.obric.aiagent.plugin");
        n.a r5 = n.f38560a;     // Catch: Throwable -> L21
        SimpleDateFormat r6 = f14299b;     // Catch: Throwable -> L21
        String r7 = r4.getDate();     // Catch: Throwable -> L21
        if (r7 != null) goto L19;
        r7 = "";
    L19:
        Object r8 = n.f(r6.parse(r7));     // Catch: Throwable -> L21
    L23:
        String r9 = null;
        if (n.b(r8) == false) goto L26;
        r8 = null;
    L26:
        Date r20 = (Date) ZeusTransformUtils.preCheckCast(r8, Date.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L33;
        if (r13 == null) goto L33;
        if (r14 == null) goto L33;
        if (b.a(r20, r13, r14) == false) goto L14;
    L33:
        JsonObject r21 = new JsonObject();
        String r22 = r4.getDate();
        if (r22 != null) goto L36;
        r22 = "";
    L36:
        r21.addProperty("date", r22);
        if (r20 == null) goto L39;
        String r23 = TimeZone.getDefault().toZoneId().getId();
        o.c(r23, "getId(...)");
        String r24 = b.a(r20, r23);
    L40:
        if (r24 != null) goto L42;
        r24 = "";
    L42:
        r21.addProperty("timeStr", r24);
        boolean r25 = true;
        if (r20 == null) goto L45;
        r9 = (String) ZeusTransformUtils.preCheckCast(d.a.i.b(r17, b.c(r20) - 1), String.class, "com.obric.aiagent.plugin");
    L45:
        if (r9 != null) goto L47;
        r9 = "";
    L47:
        r21.addProperty("weekDay", r9);
        String r26 = r4.getWeatherCode();
        if (r26 != null) goto L50;
        r26 = "";
    L50:
        r21.addProperty("weatherCode", r26);
        j r27 = f14298a;
        r27.a(r21, "lowTemp", r4.getLowTemp());
        r27.a(r21, "highTemp", r4.getHighTemp());
        String r28 = r4.getSunRise();
        if (r28 != null) goto L53;
        r28 = "";
    L53:
        r21.addProperty("sunRise", r28);
        String r29 = r4.getSunSet();
        if (r29 != null) goto L56;
        r29 = "";
    L56:
        r21.addProperty("sunSet", r29);
        if (r20 != null) goto L59;
    L61:
        r25 = false;
    L62:
        r21.addProperty("isToday", Boolean.valueOf(r25));
        r3.add((JsonElement) ZeusTransformUtils.preCheckCast(r21, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L14
    L59:
        if (b.a(r20) != true) goto L61;
    L39:
        r24 = null;
    L21:
        th = move-exception;
        n.a r30 = n.f38560a;
        r8 = n.f(d.o.a(th));
    L63:
        return r3;
    L5:
        th = move-exception;
        n.a r110 = n.f38560a;
        r16 = n.f(d.o.a(th));
        goto L7
    }

    private final String a(Date r2, String r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(f.f14288a.a(r3, r2, ""), CharSequence.class, "com.obric.aiagent.plugin");
        if (r1.length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        String r5 = TimeZone.getDefault().toZoneId().getId();
        o.c(r5, "getId(...)");
        r1 = b.a(r2, r5);
    L9:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L5:
        r4 = false;
        goto L6
    }

    private final String b(WeatherInfo r7) {
        Double r6 = r7.getWindDirection();
        if (r6 == null) goto L5;
        double r0 = r6.doubleValue() % 360.0d;
    L7:
        if (r0 < 337.5d) goto L9;
    L47:
        String r8 = "北风";
    L49:
        return r8 + r7.getWindSpeed() + 32423;
    L9:
        if (r0 < 22.5d) goto L47;
        if (r0 < 22.5d) goto L17;
        if (r0 >= 67.5d) goto L17;
        r8 = "东北风";
    L17:
        if (r0 < 67.5d) goto L22;
        if (r0 >= 112.5d) goto L22;
        r8 = "东风";
    L22:
        if (r0 < 112.5d) goto L27;
        if (r0 >= 157.5d) goto L27;
        r8 = "东南风";
    L27:
        if (r0 < 157.5d) goto L32;
        if (r0 >= 202.5d) goto L32;
        r8 = "南风";
    L32:
        if (r0 < 202.5d) goto L37;
        if (r0 >= 247.5d) goto L37;
        r8 = "西南风";
    L37:
        if (r0 < 247.5d) goto L42;
        if (r0 >= 292.5d) goto L42;
        r8 = "西风";
    L42:
        if (r0 >= 292.5d) goto L44;
    L46:
        r8 = "--";
        goto L49
    L44:
        if (r0 >= 337.5d) goto L46;
        r8 = "西北风";
        goto L49
    L5:
        r0 = 0.0d;
        goto L7
    }

    private final m<String, CardTagType> a(int r1) {
        if (r1 > 20) goto L6;
        return s.a("极度干燥", CardTagType.BAD);
    L6:
        if (r1 > 30) goto L9;
        return s.a("干燥", CardTagType.BAD);
    L9:
        if (r1 > 40) goto L12;
        return s.a("略干", CardTagType.MEDIUM);
    L12:
        if (r1 > 60) goto L15;
        return s.a("适宜", CardTagType.GOOD);
    L15:
        if (r1 > 70) goto L18;
        return s.a("略湿", CardTagType.MEDIUM);
    L18:
        if (r1 > 80) goto L21;
        return s.a("潮湿", CardTagType.BAD);
    L21:
        if (r1 > 90) goto L24;
        return s.a("高湿", CardTagType.BAD);
    L24:
        return s.a("极高湿", CardTagType.BAD);
    }

    private final m<String, CardTagType> b(int r4) {
        boolean r0 = true;
        if (r4 < 0) goto L6;
        if (r4 >= 51) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L10;
        return s.a("优", CardTagType.GOOD);
    L10:
        if (51 > r4) goto L13;
        if (r4 >= 101) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L17;
        return s.a("良", CardTagType.GOOD);
    L17:
        if (101 > r4) goto L20;
        if (r4 >= 151) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == false) goto L24;
        return s.a("轻度污染", CardTagType.MEDIUM);
    L24:
        if (151 > r4) goto L27;
        if (r4 >= 201) goto L27;
        boolean r6 = true;
    L28:
        if (r6 == true) goto L45;
        if (201 <= r4) goto L32;
    L34:
        r0 = false;
    L35:
        if (r0 == false) goto L38;
        return s.a("重度污染", CardTagType.BAD);
    L38:
        if (r4 <= 300) goto L41;
        return s.a("严重污染", CardTagType.BAD);
    L41:
        return s.a("?", CardTagType.BAD);
    L32:
        if (r4 >= 301) goto L34;
    L45:
        return s.a("中度污染", CardTagType.MEDIUM);
    L27:
        r6 = false;
    L20:
        r5 = false;
    L13:
        r3 = false;
    L6:
        r2 = false;
        goto L7
    }

    private final m<String, CardTagType> c(int r1) {
        if (r1 <= (-10)) goto L24;
        if (r1 >= 0) goto L8;
        return s.a("低温", CardTagType.BAD);
    L8:
        if (r1 >= 10) goto L11;
        return s.a("偏低温", CardTagType.BAD);
    L11:
        if (r1 >= 20) goto L14;
        return s.a("温和偏凉", CardTagType.MEDIUM);
    L14:
        if (r1 >= 26) goto L17;
        return s.a("适宜", CardTagType.GOOD);
    L17:
        if (r1 >= 32) goto L20;
        return s.a("偏高温", CardTagType.BAD);
    L20:
        if (r1 >= 40) goto L23;
        return s.a("高温", CardTagType.BAD);
    L23:
        return s.a("极端高温", CardTagType.BAD);
    L24:
        return s.a("极端低温", CardTagType.BAD);
    }

    private final void a(JsonObject r2, String r3, Object r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L7;
        r2.addProperty(r3, (Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L9;
        r2.addProperty(r3, (Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        r2.addProperty(r3, r4.toString());
    }
}
