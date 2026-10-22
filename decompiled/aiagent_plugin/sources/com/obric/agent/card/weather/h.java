package com.obric.agent.card.weather;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.CardProvider;
import com.obric.capabilitykit.common.RemoteCard;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: WeatherCardManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f14294a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SimpleDateFormat f14295b = null;

    private h() {
    }

    static {
        f14294a = new h();
        f14295b = new SimpleDateFormat("yyyy-MM-dd");
    }

    public final void a() {
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a((com.obric.aiagent.assistant_card.provider_core.a) ZeusTransformUtils.preCheckCast(new a("aqi_info"), com.obric.aiagent.assistant_card.provider_core.a.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a((com.obric.aiagent.assistant_card.provider_core.a) ZeusTransformUtils.preCheckCast(new a("humidity_info"), com.obric.aiagent.assistant_card.provider_core.a.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a((com.obric.aiagent.assistant_card.provider_core.a) ZeusTransformUtils.preCheckCast(new a("uv_info"), com.obric.aiagent.assistant_card.provider_core.a.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a((com.obric.aiagent.assistant_card.provider_core.a) ZeusTransformUtils.preCheckCast(new a("wind_speed_info"), com.obric.aiagent.assistant_card.provider_core.a.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a((com.obric.aiagent.assistant_card.provider_core.a) ZeusTransformUtils.preCheckCast(new a("feel_temperature_info"), com.obric.aiagent.assistant_card.provider_core.a.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a((com.obric.aiagent.assistant_card.provider_core.a) ZeusTransformUtils.preCheckCast(new e("sun_rise_set_info"), com.obric.aiagent.assistant_card.provider_core.a.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a((com.obric.aiagent.assistant_card.provider_core.a) ZeusTransformUtils.preCheckCast(new a("minute_rain_info"), com.obric.aiagent.assistant_card.provider_core.a.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a((com.obric.aiagent.assistant_card.provider_core.a) ZeusTransformUtils.preCheckCast(new d("single_date_weather_info"), com.obric.aiagent.assistant_card.provider_core.a.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a((com.obric.aiagent.assistant_card.provider_core.a) ZeusTransformUtils.preCheckCast(new c("multi_date_weather_info"), com.obric.aiagent.assistant_card.provider_core.a.class, "com.obric.aiagent.plugin"));
    }

    public final RemoteCard a(Context r9, String r10, String r11, String r12, String r13, WeatherInfo r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r10, "type");
        o.e(r14, "weatherInfo");
        if (r12 != null) goto L62;
    L13:
        Date r15 = new Date();
    L14:
        Date r5 = r15;
        if (r13 != null) goto L64;
        Date r6 = null;
    L26:
        switch(r10.hashCode()) {
            case -1721883361: goto L58;
            case -437908363: goto L54;
            case 2721: goto L50;
            case 69225531: goto L46;
            case 1330654387: goto L42;
            case 1336927871: goto L38;
            case 1941423060: goto L29;
            default: goto L73;
        };
    L73:
        return null;
    L29:
        if (r10.equals("WEATHER") == false) goto L74;
        if (r6 == null) goto L67;
        if (b.a(r5, r6) == true) goto L67;
        return a(r3, r11, r5, r6, r14);
    L67:
        return a(r3, r11, r5, r14);
    L74:
        return null;
    L38:
        if (r10.equals("SUN_RISE_SET") == true) goto L68;
        return null;
    L68:
        return b(r3, r11, r5, r14);
    L42:
        if (r10.equals("HUMIDITY") == true) goto L69;
        return null;
    L69:
        return f(r3, r11, r5, r14);
    L46:
        if (r10.equals("FEEL_TEMPERATURE") == true) goto L70;
        return null;
    L70:
        return c(r3, r11, r5, r14);
    L50:
        if (r10.equals("UV") == true) goto L71;
        return null;
    L71:
        return g(r3, r11, r5, r14);
    L54:
        if (r10.equals("AIRQUALITY") == true) goto L72;
        return null;
    L72:
        return d(r3, r11, r5, r14);
    L58:
        if (r10.equals("WINDSPEED") == true) goto L61;
        return null;
    L61:
        return e(r3, r11, r5, r14);
    L64:
        n.a r16 = n.f38560a;     // Catch: Throwable -> L18
        Object r17 = n.f(f14295b.parse(r13));     // Catch: Throwable -> L18
    L21:
        if (n.b(r17) == false) goto L23;
        r17 = null;
    L23:
        r6 = (Date) ZeusTransformUtils.preCheckCast(r17, Date.class, "com.obric.aiagent.plugin");
    L18:
        th = move-exception;
        n.a r18 = n.f38560a;
        r17 = n.f(d.o.a(th));
        goto L21
    L62:
        n.a r0 = n.f38560a;     // Catch: Throwable -> L6
        Object r19 = n.f(f14295b.parse(r12));     // Catch: Throwable -> L6
    L9:
        if (n.b(r19) == false) goto L11;
        r19 = null;
    L11:
        r15 = (Date) ZeusTransformUtils.preCheckCast(r19, Date.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L14;
    L6:
        th = move-exception;
        n.a r1 = n.f38560a;
        r19 = n.f(d.o.a(th));
        goto L9
    }

    private final RemoteCard a(Context r23, String r24, Date r25, Date r26, WeatherInfo r27) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List<DayWeatherInfo> r0 = r27.getDailyWeather();
        if (r0 == null) goto L33;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r4.hasNext() == false) goto L33;
        DayWeatherInfo r5 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r4.next(), DayWeatherInfo.class, "com.obric.aiagent.plugin");
        SimpleDateFormat r6 = new SimpleDateFormat("MM/dd", Locale.getDefault());
        n.a r1 = n.f38560a;     // Catch: Throwable -> L13
        SimpleDateFormat r3 = f14295b;     // Catch: Throwable -> L13
        String r7 = r5.getDate();     // Catch: Throwable -> L13
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        Object r8 = n.f(r3.parse(r7));     // Catch: Throwable -> L13
    L16:
        if (n.b(r8) == false) goto L18;
        r8 = null;
    L18:
        Date r9 = (Date) ZeusTransformUtils.preCheckCast(r8, Date.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L22;
        r9 = new Date();
    L22:
        if (b.a(r9, r25, r26) == false) goto L6;
        String[] r11 = ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin").getStringArray(ZeusTransformUtils.mapRes(R.array.weekday_arrays, "array", "weekday_arrays"));
        o.c(r11, "getStringArray(...)");
        String r15 = r6.format(r9);
        o.c(r15, "format(...)");
        String r12 = r5.getWeatherCode();
        if (r12 != null) goto L27;
        String r16 = "";
    L28:
        String r17 = String.valueOf(r5.getLowTemp());
        String r18 = String.valueOf(r5.getHighTemp());
        Integer r13 = r27.getTemp();
        if (r13 == null) goto L31;
        int r19 = r13.intValue();
    L32:
        boolean r20 = b.a(r9);
        String r14 = r11[b.c(r9) - 1];
        o.c(r14, "get(...)");
        r10.add(new MultiDateWeatherInfoSingleDayCardData(r15, r16, r17, r18, r19, r20, r14));
        goto L6
    L31:
        r19 = 0;
        goto L32
    L27:
        r16 = r12;
    L13:
        th = move-exception;
        n.a r21 = n.f38560a;
        r8 = n.f(d.o.a(th));
    L33:
        String r22 = r27.getLocation();
        if (r22 != null) goto L36;
        String r28 = "";
    L38:
        if (r10.size() <= 7) goto L40;
        int r29 = 1;
    L41:
        String r30 = com.obric.capabilitykit.common.a.a().toJson(new MultiDateWeatherInfoCardData(r28, null, r10, r29, 2, null));
        o.c(r30, "toJson(...)");
        return new RemoteCard(true, new CardProvider[]{new CardProvider(a(r2, "multi_date_weather_info", r30), Integer.valueOf((r10.size() * 40) + 82), null, null, 12, null)});
    L40:
        r29 = 0;
        goto L41
    L36:
        r28 = r22;
        goto L38
    }

    private final RemoteCard a(Context r18, String r19, Date r20, WeatherInfo r21) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        boolean r14 = b.a(r20);
        String r6 = null;
        if (r14 == true) goto L30;
        List<DayWeatherInfo> r0 = r21.getDailyWeather();
        if (r0 == null) goto L30;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r7.hasNext() == false) goto L28;
        Object r8 = r7.next();
        DayWeatherInfo r1 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r8, DayWeatherInfo.class, "com.obric.aiagent.plugin");
        n.a r9 = n.f38560a;     // Catch: Throwable -> L15
        SimpleDateFormat r10 = f14295b;     // Catch: Throwable -> L15
        String r2 = r1.getDate();     // Catch: Throwable -> L15
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        Object r3 = n.f(r10.parse(r2));     // Catch: Throwable -> L15
    L18:
        if (n.b(r3) == false) goto L20;
        r3 = null;
    L20:
        Date r5 = (Date) ZeusTransformUtils.preCheckCast(r3, Date.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L23;
    L25:
        boolean r11 = false;
    L26:
        if (r11 == false) goto L8;
    L29:
        DayWeatherInfo r12 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r8, DayWeatherInfo.class, "com.obric.aiagent.plugin");
    L31:
        if (r14 == false) goto L33;
        r6 = r21.getWeatherCode();
    L35:
        if (r6 != null) goto L37;
        String r13 = "";
    L38:
        if (r14 == false) goto L40;
    L39:
        Integer r15 = r21.getLowTemp();
    L44:
        if (r14 == false) goto L47;
    L45:
        Integer r16 = r21.getHighTemp();
    L51:
        String r17 = a(r20, r19);
        String r22 = String.valueOf(r21.getTemp());
        String r23 = String.valueOf(r15);
        String r110 = String.valueOf(r16);
        String r24 = r21.getLocation();
        if (r24 != null) goto L54;
        String r111 = "";
    L55:
        List<HourWeatherInfo> r25 = r21.getHourlyWeather();
        if (r25 == null) goto L69;
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.aiagent.plugin");
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r26, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r28 = r26.iterator();
    L59:
        if (r28.hasNext() == false) goto L68;
        HourWeatherInfo r112 = (HourWeatherInfo) ZeusTransformUtils.preCheckCast(r28.next(), HourWeatherInfo.class, "com.obric.aiagent.plugin");
        String r113 = r112.getTime();
        if (r113 != null) goto L63;
        String r114 = "";
    L64:
        Iterator r115 = r28;
        String r29 = String.valueOf(r112.getTemp());
        String r116 = r112.getWeatherCode();
        if (r116 != null) goto L67;
        r116 = "";
    L67:
        r27.add(new HourForecastUIInfo(r114, r29, r116));
        r28 = r115;
        goto L59
    L63:
        r114 = r113;
        goto L64
    L68:
        List r30 = (List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.aiagent.plugin");
    L70:
        String r31 = com.obric.capabilitykit.common.a.a().toJson(new SingleDateWeatherInfoCardData(r17, r13, r22, r23, r110, r111, r30, i.a(r21, r13, r14), r14));
        o.c(r31, "toJson(...)");
        return new RemoteCard(true, new CardProvider[]{new CardProvider(a(r4, "single_date_weather_info", r31), 212, null, null, 12, null)});
    L69:
        r30 = p.b();
        goto L70
    L54:
        r111 = r24;
        goto L55
    L47:
        if (r12 == null) goto L45;
        r16 = r12.getHighTemp();
        if (r16 != null) goto L51;
    L40:
        if (r12 == null) goto L39;
        r15 = r12.getLowTemp();
        if (r15 != null) goto L44;
    L37:
        r13 = r6;
        goto L38
    L33:
        if (r12 == null) goto L35;
        r6 = r12.getWeatherCode();
        goto L35
    L23:
        if (b.a(r5, r20) == false) goto L25;
        r11 = true;
    L15:
        th = move-exception;
        n.a r32 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L18
    L28:
        r8 = null;
    L30:
        r12 = null;
        goto L31
    }

    private final RemoteCard b(Context r17, String r18, Date r19, WeatherInfo r20) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        List<DayWeatherInfo> r0 = r20.getDailyWeather();
        if (r0 == null) goto L28;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r9.hasNext() == false) goto L26;
        Object r10 = r9.next();
        DayWeatherInfo r1 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r10, DayWeatherInfo.class, "com.obric.aiagent.plugin");
        n.a r11 = n.f38560a;     // Catch: Throwable -> L13
        SimpleDateFormat r12 = f14295b;     // Catch: Throwable -> L13
        String r2 = r1.getDate();     // Catch: Throwable -> L13
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        Object r3 = n.f(r12.parse(r2));     // Catch: Throwable -> L13
    L16:
        if (n.b(r3) == false) goto L18;
        r3 = null;
    L18:
        Date r5 = (Date) ZeusTransformUtils.preCheckCast(r3, Date.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L21;
    L23:
        boolean r6 = false;
    L24:
        if (r6 == false) goto L6;
    L27:
        DayWeatherInfo r7 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r10, DayWeatherInfo.class, "com.obric.aiagent.plugin");
    L29:
        if (r7 == null) goto L35;
        String r13 = r7.getSunRise();
        if (r13 == null) goto L35;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L35;
    L36:
        if (r7 == null) goto L42;
        String r8 = r7.getSunSet();
        if (r8 == null) goto L42;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L42;
    L43:
        if (r13 != null) goto L46;
        if (r8 != null) goto L46;
        return null;
    L46:
        String r14 = r20.getLocation();
        if (r14 != null) goto L49;
        String r15 = "";
    L50:
        String r16 = a(r19, r18);
        if (r13 != null) goto L53;
        String r110 = "";
    L54:
        if (r8 != null) goto L56;
        String r111 = "";
    L57:
        String r21 = com.obric.capabilitykit.common.a.a().toJson(new SunRiseSetCardData("SUN_RISE_SET", r15, r16, r110, r111));
        o.c(r21, "toJson(...)");
        return new RemoteCard(true, new CardProvider[]{new CardProvider(a(r4, "sun_rise_set_info", r21), Integer.valueOf(ApWakeEvent.OTHER_START), "", null, 8, null)});
    L56:
        r111 = r8;
        goto L57
    L53:
        r110 = r13;
        goto L54
    L49:
        r15 = r14;
    L42:
        r8 = null;
    L35:
        r13 = null;
        goto L36
    L21:
        if (b.a(r5, r19) == false) goto L23;
        r6 = true;
    L13:
        th = move-exception;
        n.a r112 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L16
    L26:
        r10 = null;
        goto L27
    L28:
        r7 = null;
        goto L29
    }

    private final RemoteCard c(Context r13, String r14, Date r15, WeatherInfo r16) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        Integer r0 = r16.getFeelTemp();
        if (r0 == null) goto L27;
        int r1 = r0.intValue();
        if (r1 > (-10)) goto L7;
        m r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_feel_temperature_extremely_cold, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_feel_temperature_extremely_cold")), CardTagType.BAD);
    L25:
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r2.c(), Number.class, "com.obric.aiagent.plugin")).intValue();
        CardTagType r4 = (CardTagType) ZeusTransformUtils.preCheckCast(r2.d(), CardTagType.class, "com.obric.aiagent.plugin");
        String r6 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_feel_temperature, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_feel_temperature"), new Object[]{Integer.valueOf(r1)});
        o.c(r6, "getString(...)");
        String r10 = r3.getString(r5);
        o.c(r10, "getString(...)");
        return a(r3, "feel_temperature_info", "FEEL_TEMPERATURE", r6, r16, r14, r15, r10, r4.ordinal());
    L7:
        if (r1 >= 0) goto L10;
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_feel_temperature_very_cold, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_feel_temperature_very_cold")), CardTagType.BAD);
        goto L25
    L10:
        if (r1 >= 10) goto L13;
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_feel_temperature_cold, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_feel_temperature_cold")), CardTagType.BAD);
        goto L25
    L13:
        if (r1 >= 20) goto L16;
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_feel_temperature_cool_comfort, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_feel_temperature_cool_comfort")), CardTagType.MEDIUM);
        goto L25
    L16:
        if (r1 >= 26) goto L19;
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_feel_temperature_comfortable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_feel_temperature_comfortable")), CardTagType.GOOD);
        goto L25
    L19:
        if (r1 >= 32) goto L22;
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_feel_temperature_warm, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_feel_temperature_warm")), CardTagType.BAD);
        goto L25
    L22:
        if (r1 >= 40) goto L24;
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_feel_temperature_very_hot, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_feel_temperature_very_hot")), CardTagType.BAD);
        goto L25
    L24:
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_feel_temperature_extreme_hot, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_feel_temperature_extreme_hot")), CardTagType.BAD);
        goto L25
    L27:
        return null;
    }

    private final RemoteCard d(Context r11, String r12, Date r13, WeatherInfo r14) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        Integer r15 = r14.getAqi();
        if (r15 == null) goto L5;
        int r16 = r15.intValue();
    L7:
        if (r16 < 0) goto L10;
        if (r16 >= 51) goto L10;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L15;
        int r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_aqi_good, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_aqi_good");
    L47:
        if (r16 > 100) goto L51;
        int r5 = CardTagType.GOOD.ordinal();
    L49:
        int r9 = r5;
        String r6 = r1.getString(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_aqi, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_aqi"), new Object[]{Integer.valueOf(r16)});
        o.c(r6, "getString(...)");
        String r8 = r1.getString(r2);
        o.c(r8, "getString(...)");
        return a(r1, "aqi_info", "AIRQUALITY", r6, r14, r12, r13, r8, r9);
    L51:
        if (r16 > 200) goto L53;
        r5 = CardTagType.MEDIUM.ordinal();
        goto L49
    L53:
        r5 = CardTagType.BAD.ordinal();
        goto L49
    L15:
        if (51 > r16) goto L18;
        if (r16 >= 101) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L22;
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_aqi_moderate, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_aqi_moderate");
        goto L47
    L22:
        if (101 > r16) goto L25;
        if (r16 >= 151) goto L25;
        boolean r7 = true;
    L26:
        if (r7 == false) goto L29;
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_aqi_unhealthy_low, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_aqi_unhealthy_low");
        goto L47
    L29:
        if (151 > r16) goto L32;
        if (r16 >= 201) goto L32;
        boolean r10 = true;
    L33:
        if (r10 == false) goto L35;
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_aqi_unhealthy_middle, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_aqi_unhealthy_middle");
        goto L47
    L35:
        if (201 <= r16) goto L37;
    L39:
        boolean r17 = false;
    L40:
        if (r17 == false) goto L43;
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_aqi_unhealthy_hight, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_aqi_unhealthy_hight");
        goto L47
    L43:
        if (r16 <= 300) goto L45;
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_aqi_hazardous, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_aqi_hazardous");
        goto L47
    L45:
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_aqi_unknow, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_aqi_unknow");
        goto L47
    L37:
        if (r16 >= 301) goto L39;
        r17 = true;
    L32:
        r10 = false;
    L25:
        r7 = false;
    L18:
        r3 = false;
    L10:
        r4 = false;
        goto L12
    L5:
        r16 = 0;
        goto L7
    }

    private final RemoteCard e(Context r15, String r16, Date r17, WeatherInfo r18) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
        Double r0 = r18.getWindDirection();
        if (r0 == null) goto L5;
        double r1 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).doubleValue() % ((double) 360);
    L7:
        if (r1 < 337.5d) goto L9;
    L47:
        int r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_wind_dir_n, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_wind_dir_n");
    L48:
        String r6 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_wind_speed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_wind_speed"), new Object[]{r3.getString(r2) + r18.getWindSpeed() + r3.getString(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_forecast_wind_level, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_forecast_wind_level"))});
        o.c(r6, "getString(...)");
        return a(this, r3, "wind_speed_info", "WINDSPEED", r6, r18, r16, r17, null, 0, 384, null);
    L9:
        if (r1 < 22.5d) goto L47;
        if (r1 < 22.5d) goto L17;
        if (r1 >= 67.5d) goto L17;
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_wind_dir_ne, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_wind_dir_ne");
    L17:
        if (r1 < 67.5d) goto L22;
        if (r1 >= 112.5d) goto L22;
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_wind_dir_e, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_wind_dir_e");
    L22:
        if (r1 < 112.5d) goto L27;
        if (r1 >= 157.5d) goto L27;
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_wind_dir_se, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_wind_dir_se");
    L27:
        if (r1 < 157.5d) goto L32;
        if (r1 >= 202.5d) goto L32;
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_wind_dir_s, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_wind_dir_s");
    L32:
        if (r1 < 202.5d) goto L37;
        if (r1 >= 247.5d) goto L37;
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_wind_dir_sw, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_wind_dir_sw");
    L37:
        if (r1 < 247.5d) goto L42;
        if (r1 >= 292.5d) goto L42;
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_wind_dir_w, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_wind_dir_w");
    L42:
        if (r1 >= 292.5d) goto L44;
    L46:
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_wind_unknow, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_wind_unknow");
        goto L48
    L44:
        if (r1 >= 337.5d) goto L46;
        r2 = ZeusTransformUtils.mapRes(R.string.obric_weather_widget_wind_dir_nw, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_wind_dir_nw");
        goto L48
    L5:
        r1 = 0.0d;
        goto L7
    }

    private final RemoteCard f(Context r13, String r14, Date r15, WeatherInfo r16) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        Integer r0 = r16.getHumidity();
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        String r4 = new StringBuilder().append(r1).append('%').toString();
        if (r1 > 20) goto L10;
        m r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_humidity_extremely_dry, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_humidity_extremely_dry")), CardTagType.BAD);
    L28:
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r2.c(), Number.class, "com.obric.aiagent.plugin")).intValue();
        CardTagType r6 = (CardTagType) ZeusTransformUtils.preCheckCast(r2.d(), CardTagType.class, "com.obric.aiagent.plugin");
        String r7 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_humidity, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_humidity"), new Object[]{r4});
        o.c(r7, "getString(...)");
        String r10 = r3.getString(r5);
        o.c(r10, "getString(...)");
        return a(r3, "humidity_info", "HUMIDITY", r7, r16, r14, r15, r10, r6.ordinal());
    L10:
        if (r1 > 30) goto L13;
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_humidity_dry, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_humidity_dry")), CardTagType.BAD);
        goto L28
    L13:
        if (r1 > 40) goto L16;
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_humidity_slightly_dry, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_humidity_slightly_dry")), CardTagType.MEDIUM);
        goto L28
    L16:
        if (r1 > 60) goto L19;
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_humidity_optimal, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_humidity_optimal")), CardTagType.GOOD);
        goto L28
    L19:
        if (r1 > 70) goto L22;
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_humidity_slightly_humid, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_humidity_slightly_humid")), CardTagType.MEDIUM);
        goto L28
    L22:
        if (r1 > 80) goto L25;
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_humidity_humid, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_humidity_humid")), CardTagType.BAD);
        goto L28
    L25:
        if (r1 > 90) goto L27;
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_humidity_high_humidity, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_humidity_high_humidity")), CardTagType.BAD);
        goto L28
    L27:
        r2 = s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_humidity_extremely_humid, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_humidity_extremely_humid")), CardTagType.BAD);
        goto L28
    L5:
        r1 = 0;
        goto L6
    }

    private final RemoteCard g(Context r14, String r15, Date r16, WeatherInfo r17) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        String r0 = r17.getUvLevel();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r5 = r2.getString(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_uv_level, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_uv_level"), new Object[]{r0});
        o.c(r5, "getString(...)");
        return a(this, r2, "uv_info", "UV", r5, r17, r15, r16, null, 0, 384, null);
    }

    private final String a(Context r2, String r3, String r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.assistant_card.provider_core.a.c r5 = com.obric.aiagent.assistant_card.provider_core.a.c.f16335a;
        String r6 = r1.getPackageName();
        o.c(r6, "getPackageName(...)");
        String r7 = r5.a(r6, r3, "1").buildUpon().appendQueryParameter("data", r4).appendQueryParameter("card_service_name", "com.obric.aiagent.assistant_card.CardProviderService").build().toString();
        o.c(r7, "toString(...)");
        return r7;
    }

    static /* synthetic */ RemoteCard a(h r12, Context r13, String r14, String r15, String r16, WeatherInfo r17, String r18, Date r19, String r20, int r21, int r22, Object r23) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        if ((r22 & 128) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r22 & 256) == 0) goto L9;
        int r11 = 0;
    L11:
        return r12.a(r3, r14, r15, r16, r17, r18, r19, r10, r11);
    L9:
        r11 = r21;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }

    private final RemoteCard a(Context r12, String r13, String r14, String r15, WeatherInfo r16, String r17, Date r18, String r19, int r20) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        String r2 = r16.getLocation();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r3 = com.obric.capabilitykit.common.a.a().toJson(new BaseInfoCardData(r14, r15, r2, a(r18, r17), r19, r20));
        o.c(r3, "toJson(...)");
        return new RemoteCard(true, new CardProvider[]{new CardProvider(a(r1, r13, r3), 106, "", null, 8, null)});
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
}
