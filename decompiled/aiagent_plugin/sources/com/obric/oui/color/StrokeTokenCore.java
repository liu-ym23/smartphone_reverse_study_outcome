package com.obric.oui.color;

import com.obric.oui.material.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class StrokeTokenCore {
    public static final Function1<Boolean, f> OUI_Effect_Stroke_Blue_Regular = null;
    public static final f OUI_Effect_Stroke_Blue_Regular_Dark = null;
    public static final f OUI_Effect_Stroke_Blue_Regular_Light = null;
    public static final Function1<Boolean, f> OUI_Effect_Stroke_Blue_Thin = null;
    public static final f OUI_Effect_Stroke_Blue_Thin_Dark = null;
    public static final f OUI_Effect_Stroke_Blue_Thin_Light = null;
    public static final Function1<Boolean, f> OUI_Effect_Stroke_Green_Regular = null;
    public static final f OUI_Effect_Stroke_Green_Regular_Dark = null;
    public static final f OUI_Effect_Stroke_Green_Regular_Light = null;
    public static final Function1<Boolean, f> OUI_Effect_Stroke_Green_Thin = null;
    public static final f OUI_Effect_Stroke_Green_Thin_Dark = null;
    public static final f OUI_Effect_Stroke_Green_Thin_Light = null;
    public static final Function1<Boolean, f> OUI_Effect_Stroke_Red_Regular = null;
    public static final f OUI_Effect_Stroke_Red_Regular_Dark = null;
    public static final f OUI_Effect_Stroke_Red_Regular_Light = null;
    public static final Function1<Boolean, f> OUI_Effect_Stroke_Red_Thin = null;
    public static final f OUI_Effect_Stroke_Red_Thin_Dark = null;
    public static final f OUI_Effect_Stroke_Red_Thin_Light = null;
    public static final Function1<Boolean, f> OUI_Effect_Stroke_Regular = null;
    public static final f OUI_Effect_Stroke_Regular_Dark = null;
    public static final f OUI_Effect_Stroke_Regular_Light = null;
    public static final Function1<Boolean, f> OUI_Effect_Stroke_Thick = null;
    public static final f OUI_Effect_Stroke_Thick_Dark = null;
    public static final f OUI_Effect_Stroke_Thick_Light = null;
    public static final Function1<Boolean, f> OUI_Effect_Stroke_Thin = null;
    public static final f OUI_Effect_Stroke_Thin_Dark = null;
    public static final f OUI_Effect_Stroke_Thin_Light = null;
    public static final f OUI_Effect_Stroke_Tinted_Dark = null;
    public static final f OUI_Effect_Stroke_Tinted_Light = null;
    public static final Function1<Boolean, f> OUI_Effect_Stroke_UltraThin = null;
    public static final f OUI_Effect_Stroke_UltraThin_Dark = null;
    public static final f OUI_Effect_Stroke_UltraThin_Light = null;
    public static final Function1<Boolean, f> OUI_Effect_Stroke_Yellow_Regular = null;
    public static final f OUI_Effect_Stroke_Yellow_Regular_Dark = null;
    public static final f OUI_Effect_Stroke_Yellow_Regular_Light = null;
    public static final Function1<Boolean, f> OUI_Effect_Stroke_Yellow_Thin = null;
    public static final f OUI_Effect_Stroke_Yellow_Thin_Dark = null;
    public static final f OUI_Effect_Stroke_Yellow_Thin_Light = null;
    private static volatile ConcurrentHashMap<String, Function1<Boolean, f>> providers;
    private static volatile ConcurrentHashMap<String, f> tokens;

    static {
        OUI_Effect_Stroke_Regular_Light = new f(1.0f, 1728053247, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Regular_Dark = new f(1.0f, 1715618370, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Regular = $$Lambda$StrokeTokenCore$GFmhcpthEsxhmKEQPuNXpKPBNkU.INSTANCE;
        OUI_Effect_Stroke_UltraThin_Light = new f(1.0f, 452984831, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_UltraThin_Dark = new f(1.0f, 452984831, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_UltraThin = $$Lambda$StrokeTokenCore$xVcLdHt44Nel47xA6oIEzKfhwU.INSTANCE;
        OUI_Effect_Stroke_Thin_Light = new f(1.0f, 1728053247, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Thin_Dark = new f(1.0f, 134217728, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Thin = $$Lambda$StrokeTokenCore$gcNtv_c24RJ3CnRdw6oGkuyVvk.INSTANCE;
        OUI_Effect_Stroke_Thick_Light = new f(1.0f, 1727526903, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Thick_Dark = new f(1.0f, 1294872110, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Thick = $$Lambda$StrokeTokenCore$a5NapqSKTsp2SY1Pv4W6gSzjd_8.INSTANCE;
        OUI_Effect_Stroke_Tinted_Light = new f(1.0f, 1728053247, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Tinted_Dark = new f(1.0f, 1728053247, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Blue_Regular_Light = new f(1.0f, 1713799679, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Blue_Regular_Dark = new f(1.0f, 1713799679, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Blue_Regular = $$Lambda$StrokeTokenCore$L5NHnGbTkFgtl7Q1Qt7mftmMiHs.INSTANCE;
        OUI_Effect_Stroke_Blue_Thin_Light = new f(1.0f, 1718003455, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Blue_Thin_Dark = new f(1.0f, 1718003455, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Blue_Thin = $$Lambda$StrokeTokenCore$hC20gpH0twe65xM6CAWcxG2_Pc4.INSTANCE;
        OUI_Effect_Stroke_Red_Regular_Light = new f(1.0f, 1728007501, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Red_Regular_Dark = new f(1.0f, 1728007501, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Red_Regular = $$Lambda$StrokeTokenCore$a8n5JFGNJJP0YFML9NWYv_Wiqqo.INSTANCE;
        OUI_Effect_Stroke_Red_Thin_Light = new f(1.0f, 1728022407, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Red_Thin_Dark = new f(1.0f, 1728022407, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Red_Thin = $$Lambda$StrokeTokenCore$_Q59curiyf_4mpM7mTn9rcEM1ls.INSTANCE;
        OUI_Effect_Stroke_Green_Regular_Light = new f(1.0f, 1712637776, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Green_Regular_Dark = new f(1.0f, 1712637776, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Green_Regular = $$Lambda$StrokeTokenCore$IfruSvYTWx07S7VLN0lEbFMTTk8.INSTANCE;
        OUI_Effect_Stroke_Green_Thin_Light = new f(1.0f, 1719135647, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Green_Thin_Dark = new f(1.0f, 1719135647, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Green_Thin = $$Lambda$StrokeTokenCore$Aw5TUYOQvzm9m_V1r3GProQsMtg.INSTANCE;
        OUI_Effect_Stroke_Yellow_Regular_Light = new f(1.0f, 1728038170, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Yellow_Regular_Dark = new f(1.0f, 1728038170, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Yellow_Regular = $$Lambda$StrokeTokenCore$Ndx_5JjlA65cgBda4R3nvntasiU.INSTANCE;
        OUI_Effect_Stroke_Yellow_Thin_Light = new f(1.0f, 1728041577, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Yellow_Thin_Dark = new f(1.0f, 1728041577, com.obric.oui.a.a.f33929d);
        OUI_Effect_Stroke_Yellow_Thin = $$Lambda$StrokeTokenCore$OdZWqH6LpdF1nIrIfGqTtray_VU.INSTANCE;
    }

    static /* synthetic */ f lambda$static$0(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Regular_Dark;
    }

    static /* synthetic */ f lambda$static$1(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_UltraThin_Light;
    L6:
        return OUI_Effect_Stroke_UltraThin_Dark;
    }

    static /* synthetic */ f lambda$static$2(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Thin_Dark;
    }

    static /* synthetic */ f lambda$static$3(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Thick_Light;
    L6:
        return OUI_Effect_Stroke_Thick_Dark;
    }

    static /* synthetic */ f lambda$static$4(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Blue_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Blue_Regular_Dark;
    }

    static /* synthetic */ f lambda$static$5(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Blue_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Blue_Thin_Dark;
    }

    static /* synthetic */ f lambda$static$6(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Red_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Red_Regular_Dark;
    }

    static /* synthetic */ f lambda$static$7(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Red_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Red_Thin_Dark;
    }

    static /* synthetic */ f lambda$static$8(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Green_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Green_Regular_Dark;
    }

    static /* synthetic */ f lambda$static$9(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Green_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Green_Thin_Dark;
    }

    static /* synthetic */ f lambda$static$10(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Yellow_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Yellow_Regular_Dark;
    }

    static /* synthetic */ f lambda$static$11(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Yellow_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Yellow_Thin_Dark;
    }

    private StrokeTokenCore() {
    }

    public static void register(Object r2, Object r3, boolean r4) {
        o.a(getTokens(r2), r3, f.class, r4);
        o.a(getTokens(r2), toCoreTokens(o.a(r3, f.class)), r4);
    }

    public static void registerTokens(Object r2, Map<String, f> r3, boolean r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.a(getTokens(r2), toCoreTokens(r5), r4);
    }

    public static void registerProvider(Object r1, Object r2, boolean r3) {
        o.a(getProviders(r1), r2, Function1.class, r3);
    }

    public static void registerProviderTokens(Object r2, Map<String, ? extends Function1<Boolean, f>> r3, boolean r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.a(getProviders(r2), toCoreProviders(r5), r4);
    }

    public static Function1<Boolean, f> parseProvider(Object r1, String r2) {
        return (Function1) ZeusTransformUtils.preCheckCast(o.a(r2, getProviders(r1)), Function1.class, "com.obric.aiagent.plugin");
    }

    public static f parse(Object r3, String r4, boolean r5) {
        f r0 = (f) ZeusTransformUtils.preCheckCast(o.a(r4, getTokens(r3)), f.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L10;
        StringBuilder r6 = new StringBuilder().append(r4);
        if (r5 == false) goto L7;
        String r7 = "_light";
    L9:
        return (f) ZeusTransformUtils.preCheckCast(o.a(r6.append(r7).toString(), getTokens(r3)), f.class, "com.obric.aiagent.plugin");
    L7:
        r7 = "_dark";
        goto L9
    L10:
        return r0;
    }

    private static ConcurrentHashMap<String, f> getTokens(Object r1) {
        ConcurrentHashMap<String, f> r0 = tokens;
        if (r0 != null) goto L13;
        monitor-enter(StrokeTokenCore.class);
        r0 = tokens;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = o.a(StrokeTokenCore.class, f.class);     // Catch: Throwable -> L10
        tokens = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(StrokeTokenCore.class);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }

    private static ConcurrentHashMap<String, Function1<Boolean, f>> getProviders(Object r1) {
        ConcurrentHashMap<String, Function1<Boolean, f>> r0 = providers;
        if (r0 != null) goto L13;
        monitor-enter(StrokeTokenCore.class);
        r0 = providers;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = o.a(StrokeTokenCore.class, Function1.class);     // Catch: Throwable -> L10
        providers = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(StrokeTokenCore.class);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }

    private static ConcurrentHashMap<String, f> toCoreTokens(Map<String, f> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        ConcurrentHashMap<String, f> r0 = new ConcurrentHashMap();
        if (r6 != null) goto L5;
    L11:
        return r0;
    L5:
        if (r6.isEmpty() == true) goto L11;
        Iterator r7 = r6.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), toCore((f) ZeusTransformUtils.preCheckCast(r2.getValue(), f.class, "com.obric.aiagent.plugin")));
        goto L9
    }

    private static ConcurrentHashMap<String, Function1<Boolean, f>> toCoreProviders(Map<String, ? extends Function1<Boolean, f>> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        ConcurrentHashMap<String, Function1<Boolean, f>> r0 = new ConcurrentHashMap();
        if (r6 != null) goto L5;
    L11:
        return r0;
    L5:
        if (r6.isEmpty() == true) goto L11;
        Iterator r7 = r6.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        final Function1 r3 = (Function1) ZeusTransformUtils.preCheckCast(r2.getValue(), Function1.class, "com.obric.aiagent.plugin");
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), new $$Lambda$StrokeTokenCore$_rqXuPrBf7xdEEfBaeP0RW5yMF4(r3));
        goto L9
    }

    static /* synthetic */ f lambda$toCoreProviders$12(Function1 r2, Boolean r3) {
        return toCore((f) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.aiagent.plugin")).invoke(r3), f.class, "com.obric.aiagent.plugin"));
    }

    private static f toCore(f r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return new f(r3.a(), r3.b(), r3.c());
    }
}
