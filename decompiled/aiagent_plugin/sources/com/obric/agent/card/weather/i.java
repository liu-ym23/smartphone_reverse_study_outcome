package com.obric.agent.card.weather;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.autogui.common.api.assistant.IAssistCardResourceProvider;
import com.obric.capabilitykit.common.intent.DayWeatherInfo;
import com.obric.capabilitykit.common.intent.WeatherInfo;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.m;
import d.n;
import d.o.k;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: WeatherCodeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f14296a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<String, m<String, String>> f14297b = null;

    private static final int a(float r4) {
        if (0.0f <= r4) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        return 0;
    L11:
        if (r4 <= 0.1f) goto L16;
        if (r4 > 0.82f) goto L16;
        return 1;
    L16:
        if (r4 <= 0.82f) goto L21;
        if (r4 > 0.92f) goto L21;
        return 2;
    L21:
        if (r4 > 0.92f) goto L23;
        return 1;
    L23:
        if (r4 > 2.0f) goto L29;
        return 3;
    L29:
        return 1;
    L5:
        if (r4 > 0.1f) goto L7;
        r0 = true;
        goto L8
    }

    static {
        f14296a = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<String, m<String, String>> r0 = new HashMap();
        r0.put("00", new m("card_intent_little_icon_sunny", "card_intent_little_icon_sunny_night"));
        r0.put("01", new m("card_intent_little_icon_cloudy", "card_intent_little_icon_cloudy_night"));
        r0.put("02", new m("card_intent_little_icon_overcast", null));
        r0.put("03", new m("card_intent_little_icon_shower", null));
        r0.put("04", new m("card_intent_little_icon_thundershower", "card_intent_little_icon_thundershower_night"));
        r0.put("05", new m("card_intent_little_icon_thundershowerhail", "card_intent_little_icon_thundershowerhail_night"));
        r0.put("06", new m("card_intent_little_icon_icerain", null));
        r0.put("07", new m("card_intent_little_icon_lightrain", null));
        r0.put("08", new m("card_intent_little_icon_moderaterain", null));
        r0.put("09", new m("card_intent_little_icon_heavyrain", null));
        r0.put("10", new m("card_intent_little_icon_storm", null));
        r0.put("11", new m("card_intent_little_icon_storm", null));
        r0.put("12", new m("card_intent_little_icon_storm", null));
        r0.put("13", new m("card_intent_little_icon_snow", "card_intent_little_icon_snow_night"));
        r0.put("14", new m("card_intent_little_icon_lightsnow", null));
        r0.put("15", new m("card_intent_little_icon_snow_night", null));
        r0.put("16", new m("card_intent_little_icon_heavysnow", null));
        r0.put("17", new m("card_intent_little_icon_heavysnow", null));
        r0.put("18", new m("card_intent_little_icon_foggy", null));
        r0.put("19", new m("card_intent_little_icon_icerain", null));
        r0.put("20", new m("card_intent_little_icon_sandstorm", null));
        r0.put("21", new m("card_intent_little_icon_moderaterain", null));
        r0.put("22", new m("card_intent_little_icon_heavyrain", null));
        r0.put("23", new m("card_intent_little_icon_storm", null));
        r0.put("24", new m("card_intent_little_icon_storm", null));
        r0.put("25", new m("card_intent_little_icon_storm", null));
        r0.put("26", new m("card_intent_little_icon_snow_night", null));
        r0.put("27", new m("card_intent_little_icon_heavysnow", null));
        r0.put("28", new m("card_intent_little_icon_heavysnow", null));
        r0.put("29", new m("card_intent_little_icon_haze_shadow", "card_intent_little_icon_haze_night_shadow"));
        r0.put("30", new m("card_intent_little_icon_haze_shadow", "card_intent_little_icon_haze_night_shadow"));
        r0.put("31", new m("card_intent_little_icon_sandstorm_shadow", null));
        r0.put("53", new m("card_intent_little_icon_haze", "card_intent_little_icon_haze_night"));
        r0.put("99", new m("card_intent_little_icon_unknown_shadow", null));
        r0.put("32", new m("card_intent_little_icon_foggy", null));
        r0.put("49", new m("card_intent_little_icon_foggy", null));
        r0.put("57", new m("card_intent_little_icon_foggy", null));
        r0.put("58", new m("card_intent_little_icon_foggy", null));
        r0.put("54", new m("card_intent_little_icon_haze", "card_intent_little_icon_haze_night"));
        r0.put("55", new m("card_intent_little_icon_haze", "card_intent_little_icon_haze_night"));
        r0.put("56", new m("card_intent_little_icon_haze", "card_intent_little_icon_haze_night"));
        r0.put("59", new m("card_intent_little_icon_wind", "card_intent_little_icon_wind"));
        r0.put("1000", new m("card_intent_little_icon_sunrise", null));
        r0.put("1001", new m("card_intent_little_icon_sunset", null));
        f14297b = r0;
    }

    public static final Integer a(Context r4, String r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r5, MonitorConstants.CODE);
        HashMap<String, m<String, String>> r0 = f14297b;
        if (r0.containsKey(r5) == false) goto L13;
        m r8 = (m) ZeusTransformUtils.preCheckCast(r0.get(r5), m.class, "com.obric.aiagent.plugin");
        if (r6 == false) goto L11;
        if (r8 == null) goto L8;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.b(), String.class, "com.obric.aiagent.plugin");
    L9:
        if (r9 == null) goto L11;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r8.b(), String.class, "com.obric.aiagent.plugin");
    L17:
        if (r10 == null) goto L22;
        IAssistCardResourceProvider r11 = (IAssistCardResourceProvider) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistCardResourceProvider.class), IAssistCardResourceProvider.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L21;
        return null;
    L21:
        return Integer.valueOf(r11.getResId(r7, r10, "drawable"));
    L22:
        return null;
    L8:
        r9 = null;
    L11:
        if (r8 == null) goto L16;
        r10 = (String) ZeusTransformUtils.preCheckCast(r8.a(), String.class, "com.obric.aiagent.plugin");
    L16:
        r10 = null;
        goto L17
    L13:
        m r12 = (m) ZeusTransformUtils.preCheckCast(r0.get("99"), m.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L16;
        r10 = (String) ZeusTransformUtils.preCheckCast(r12.a(), String.class, "com.obric.aiagent.plugin");
        goto L17
    }

    public static final String a(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r5, MonitorConstants.CODE);
        if (b(r5) == false) goto L7;
        return null;
    L7:
        return ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin"), "obric_weather_text_" + r5, WsChannelMultiProcessSharedProvider.STRING_TYPE, r6.getPackageName(), "com.obric.aiagent.plugin"));
    }

    private static final String a(String r3) {
        int r0 = r3.hashCode();
        if (r0 == 1567) goto L69;
        if (r0 == 1598) goto L65;
        if (r0 == 1607) goto L62;
        if (r0 == 1700) goto L59;
        switch(r0) {
            case 1536: goto L57;
            case 1537: goto L54;
            case 1538: goto L50;
            default: goto L11;
        };
    L11:
        switch(r0) {
            case 1543: goto L47;
            case 1544: goto L44;
            case 1545: goto L41;
            default: goto L12;
        };
    L12:
        switch(r0) {
            case 1571: goto L37;
            case 1572: goto L34;
            case 1573: goto L31;
            case 1574: goto L28;
            case 1575: goto L25;
            default: goto L13;
        };
    L13:
        switch(r0) {
            case 1694: goto L22;
            case 1695: goto L19;
            case 1696: goto L16;
            default: goto L78;
        };
    L78:
        return "weather_clear_day_rounded";
    L16:
        if (r3.equals("55") == false) goto L79;
    L67:
        return "weather_haze_rounded";
    L79:
        return "weather_clear_day_rounded";
    L19:
        if (r3.equals("54") == true) goto L67;
        return "weather_clear_day_rounded";
    L22:
        if (r3.equals("53") == true) goto L67;
        return "weather_clear_day_rounded";
    L25:
        if (r3.equals("18") == true) goto L67;
        return "weather_clear_day_rounded";
    L28:
        if (r3.equals("17") == false) goto L83;
    L39:
        return "weather_snow_rounded";
    L83:
        return "weather_clear_day_rounded";
    L31:
        if (r3.equals("16") == true) goto L39;
        return "weather_clear_day_rounded";
    L34:
        if (r3.equals("15") == true) goto L39;
        return "weather_clear_day_rounded";
    L37:
        if (r3.equals("14") == true) goto L39;
        return "weather_clear_day_rounded";
    L41:
        if (r3.equals("09") == false) goto L87;
    L71:
        return "weather_rain_rounded";
    L87:
        return "weather_clear_day_rounded";
    L44:
        if (r3.equals("08") == true) goto L71;
        return "weather_clear_day_rounded";
    L47:
        if (r3.equals("07") == true) goto L71;
        return "weather_clear_day_rounded";
    L57:
        r3.equals("00");
        return "weather_clear_day_rounded";
    L50:
        if (r3.equals("02") == false) goto L90;
        return "weather_overcast_sky_rounded";
    L90:
        return "weather_clear_day_rounded";
    L54:
        if (r3.equals("01") == false) goto L91;
        return "weather_cloudy_rounded";
    L91:
        return "weather_clear_day_rounded";
    L59:
        if (r3.equals("59") == true) goto L67;
        return "weather_clear_day_rounded";
    L62:
        if (r3.equals("29") == true) goto L67;
        return "weather_clear_day_rounded";
    L65:
        if (r3.equals("20") == true) goto L67;
        return "weather_clear_day_rounded";
    L69:
        if (r3.equals("10") == true) goto L71;
        return "weather_clear_day_rounded";
    }

    public static final String a(WeatherInfo r1, String r2, boolean r3) {
        o.e(r1, "weatherInfo");
        o.e(r2, "weatherCode");
        String r0 = a(r2);
        if (r3 == true) goto L5;
        return r0;
    L5:
        if (o.a(r2, "00") == false) goto L7;
    L8:
        int r4 = a(a(r1));
        if (r4 != 0) goto L11;
    L16:
        return "weather_dusk_rounded";
    L11:
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L21;
        return "weather_night_rounded";
    L21:
        return r0;
    L7:
        if (o.a(r2, "01") == true) goto L8;
        return r0;
    }

    public static final int a(Context r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r4, "backgroundResName");
        o.e(r5, "weatherCode");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r7 = a(r5);
    L8:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
        IAssistCardResourceProvider r9 = (IAssistCardResourceProvider) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistCardResourceProvider.class), IAssistCardResourceProvider.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L11;
        return 0;
    L11:
        return r9.getResId(r6, r8, "drawable");
    L5:
        r0 = false;
        goto L6
    }

    private static final float a(WeatherInfo r13) {
        List<DayWeatherInfo> r0 = r13.getDailyWeather();
        boolean r2 = false;
        String r5 = null;
        if (r0 == null) goto L28;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r1.hasNext() == false) goto L26;
        Object r6 = r1.next();
        DayWeatherInfo r7 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r6, DayWeatherInfo.class, "com.obric.aiagent.plugin");
        n.a r8 = n.f38560a;     // Catch: Throwable -> L13
        SimpleDateFormat r9 = f14296a;     // Catch: Throwable -> L13
        String r10 = r7.getDate();     // Catch: Throwable -> L13
        if (r10 != null) goto L11;
        r10 = "";
    L11:
        Object r11 = n.f(r9.parse(r10));     // Catch: Throwable -> L13
    L16:
        if (n.b(r11) == false) goto L18;
        r11 = null;
    L18:
        Date r12 = (Date) ZeusTransformUtils.preCheckCast(r11, Date.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L21;
    L23:
        boolean r14 = false;
    L24:
        if (r14 == false) goto L6;
    L27:
        DayWeatherInfo r3 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r6, DayWeatherInfo.class, "com.obric.aiagent.plugin");
    L29:
        List<DayWeatherInfo> r15 = r13.getDailyWeather();
        if (r15 == null) goto L55;
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L33:
        if (r16.hasNext() == false) goto L53;
        Object r17 = r16.next();
        DayWeatherInfo r18 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r17, DayWeatherInfo.class, "com.obric.aiagent.plugin");
        n.a r19 = n.f38560a;     // Catch: Throwable -> L40
        SimpleDateFormat r20 = f14296a;     // Catch: Throwable -> L40
        String r21 = r18.getDate();     // Catch: Throwable -> L40
        if (r21 != null) goto L38;
        r21 = "";
    L38:
        Object r22 = n.f(r20.parse(r21));     // Catch: Throwable -> L40
    L43:
        if (n.b(r22) == false) goto L45;
        r22 = null;
    L45:
        Date r23 = (Date) ZeusTransformUtils.preCheckCast(r22, Date.class, "com.obric.aiagent.plugin");
        if (r23 != null) goto L48;
    L50:
        boolean r24 = false;
    L51:
        if (r24 == false) goto L33;
    L54:
        DayWeatherInfo r4 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r17, DayWeatherInfo.class, "com.obric.aiagent.plugin");
    L56:
        if (r3 == null) goto L58;
        String r25 = r3.getSunRise();
    L59:
        long r26 = a(r25, true, r13.getTimezone());
        if (r3 == null) goto L62;
        String r27 = r3.getSunSet();
    L63:
        long r28 = a(r27, true, r13.getTimezone());
        if (r4 == null) goto L66;
        String r29 = r4.getSunRise();
    L67:
        long r110 = a(r29, false, r13.getTimezone());
        if (r4 == null) goto L70;
        r5 = r4.getSunSet();
    L70:
        long r30 = a(r5, false, r13.getTimezone());
        if (r26 != (-1)) goto L73;
    L91:
        return -1.0f;
    L73:
        if (r28 == (-1)) goto L91;
        if (r110 == (-1)) goto L91;
        if (r30 == (-1)) goto L91;
        long r31 = System.currentTimeMillis();
        if ((1 + r26) <= r31) goto L82;
    L84:
        if (r2 == false) goto L88;
        return (r31 - r26) / (r28 - r26);
    L88:
        if (r31 <= r28) goto L91;
        return 1 + ((r31 - r28) / (r110 - r28));
    L82:
        if (r31 > r28) goto L84;
        r2 = true;
        goto L84
    L66:
        r29 = null;
        goto L67
    L62:
        r27 = null;
        goto L63
    L58:
        r25 = null;
        goto L59
    L48:
        if (b.b(r23) != true) goto L50;
        r24 = true;
    L40:
        th = move-exception;
        n.a r32 = n.f38560a;
        r22 = n.f(d.o.a(th));
        goto L43
    L53:
        r17 = null;
        goto L54
    L55:
        r4 = null;
        goto L56
    L21:
        if (b.a(r12) != true) goto L23;
        r14 = true;
    L13:
        th = move-exception;
        n.a r33 = n.f38560a;
        r11 = n.f(d.o.a(th));
        goto L16
    L26:
        r6 = null;
        goto L27
    L28:
        r3 = null;
        goto L29
    }

    private static final long a(String r8, boolean r9, String r10) {
        if (r8 != null) goto L5;
        return -1;
    L5:
        List<String> r11 = new k(":").c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), 0);
        if (r11.isEmpty() == true) goto L16;
        ListIterator<String> r2 = r11.listIterator(r11.size());
    L9:
        if (r2.hasPrevious() == false) goto L16;
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2.previous(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == true) goto L9;
        List r12 = p.c((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin"), r2.nextIndex() + 1);
    L17:
        String[] r13 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
        TimeZone r3 = null;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L20;
    L23:
        boolean r5 = true;
    L24:
        if (r5 == true) goto L37;
        r3 = TimeZone.getTimeZone(r10);
    L37:
        int r14 = Integer.parseInt(r13[0]);     // Catch: Exception -> L34
        int r15 = Integer.parseInt(r13[1]);     // Catch: Exception -> L34
        Calendar r7 = Calendar.getInstance();     // Catch: Exception -> L34
        if (r3 == null) goto L29;
        r7.setTimeZone(r3);     // Catch: Exception -> L34
    L29:
        r7.set(11, r14);     // Catch: Exception -> L34
        r7.set(12, r15);     // Catch: Exception -> L34
        long r16 = r7.getTimeInMillis();     // Catch: Exception -> L34
        if (r9 == true) goto L44;
        return r16 + TimeUnit.DAYS.toMillis(1);
    L44:
        return r16;
    L34:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L20:
        if (r4.length() == 0) goto L23;
        r5 = false;
        goto L24
    L13:
        r6 = false;
    L16:
        r12 = p.b();
        goto L17
    }

    private static final boolean b(String r4) {
        if (o.a("99", r4) == true) goto L12;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        if (f14297b.containsKey(r4) == false) goto L12;
        return false;
    L7:
        r0 = false;
    L12:
        return true;
    }
}
