package com.obric.oui.fluid;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.material.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import d.h.b.p;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: FluidToken.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FluidToken {
    public static final FluidToken INSTANCE = null;
    public static final com.obric.oui.fluid.a OUI_Effect_Fluid_Regular_Dark = null;
    public static final com.obric.oui.fluid.a OUI_Effect_Fluid_Regular_Light = null;
    public static final com.obric.oui.fluid.a OUI_Effect_Fluid_Thin_Dark = null;
    public static final com.obric.oui.fluid.a OUI_Effect_Fluid_Thin_Light = null;
    private static final f tokens$delegate = null;

    /* JADX INFO: compiled from: FluidToken.kt */
    static final class a extends p implements d.h.a.a<ConcurrentHashMap<String, com.obric.oui.fluid.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f35252a = null;

        static {
            f35252a = new a();
        }

        a() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ConcurrentHashMap<String, com.obric.oui.fluid.a> invoke() {
            return a();
        }

        public final ConcurrentHashMap<String, com.obric.oui.fluid.a> a() {
            ConcurrentHashMap<String, com.obric.oui.fluid.a> r11 = new ConcurrentHashMap();
            n r0 = n.f35506a;
            FluidToken r1 = FluidToken.INSTANCE;
            Map<? extends String, ? extends com.obric.oui.fluid.a> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            Field[] r3 = r1.getClass().getDeclaredFields();     // Catch: Exception -> L11
            o.c(r3, "fields");     // Catch: Exception -> L11
            int r5 = 0;
            int r6 = r3.length;     // Catch: Exception -> L11
        L4:
            if (r5 >= r6) goto L13;
            Field r7 = r3[r5];     // Catch: Exception -> L11
            r5 = r5 + 1;     // Catch: Exception -> L11
            if (com.obric.oui.fluid.a.class.isAssignableFrom(r7.getType()) == false) goto L4;
            r7.setAccessible(true);     // Catch: Exception -> L11
            Object r8 = r7.get(r1);     // Catch: Exception -> L11
            if (ZeusTransformUtils.instanceOf(r8, com.obric.oui.fluid.a.class) == false) goto L4;
            String r9 = r7.getName();     // Catch: Exception -> L11
            o.c(r9, "field.name");     // Catch: Exception -> L11
            Locale r10 = Locale.ROOT;     // Catch: Exception -> L11
            o.c(r10, "ROOT");     // Catch: Exception -> L11
            String r12 = r9.toLowerCase(r10);     // Catch: Exception -> L11
            o.c(r12, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
            r2.put(r12, r8);     // Catch: Exception -> L11
        L13:
            r11.putAll(r2);
            return r11;
        L11:
            e = move-exception;
            a("TokenParser", o.a("Failed to parse tokens from ", r1.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L13
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    private FluidToken() {
    }

    static {
        INSTANCE = new FluidToken();
        tokens$delegate = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(a.f35252a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        b r0 = FluidTokenCore.OUI_Effect_Fluid_Thin_Light;
        o.c(r0, "OUI_Effect_Fluid_Thin_Light");
        OUI_Effect_Fluid_Thin_Light = c.a(r0);
        b r1 = FluidTokenCore.OUI_Effect_Fluid_Thin_Dark;
        o.c(r1, "OUI_Effect_Fluid_Thin_Dark");
        OUI_Effect_Fluid_Thin_Dark = c.a(r1);
        b r2 = FluidTokenCore.OUI_Effect_Fluid_Regular_Light;
        o.c(r2, "OUI_Effect_Fluid_Regular_Light");
        OUI_Effect_Fluid_Regular_Light = c.a(r2);
        b r3 = FluidTokenCore.OUI_Effect_Fluid_Regular_Dark;
        o.c(r3, "OUI_Effect_Fluid_Regular_Dark");
        OUI_Effect_Fluid_Regular_Dark = c.a(r3);
    }

    private final ConcurrentHashMap<String, com.obric.oui.fluid.a> getTokens() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(tokens$delegate.b(), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
    }

    public static final com.obric.oui.fluid.a parse(String r4) {
        return (com.obric.oui.fluid.a) ZeusTransformUtils.preCheckCast(n.f35506a.a(r4, (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getTokens(), Map.class, "com.obric.aiagent.plugin")), com.obric.oui.fluid.a.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    public static final void register(Object r12, boolean r13) {
        o.e(r12, "customTokenOwner");
        n r0 = n.f35506a;
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getTokens(), Map.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Field[] r5 = r12.getClass().getDeclaredFields();     // Catch: Exception -> L11
        o.c(r5, "fields");     // Catch: Exception -> L11
        int r6 = 0;
        int r7 = r5.length;     // Catch: Exception -> L11
    L4:
        if (r6 >= r7) goto L13;
        Field r8 = r5[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (com.obric.oui.fluid.a.class.isAssignableFrom(r8.getType()) == false) goto L4;
        r8.setAccessible(true);     // Catch: Exception -> L11
        Object r9 = r8.get(r12);     // Catch: Exception -> L11
        if (ZeusTransformUtils.instanceOf(r9, com.obric.oui.fluid.a.class) == false) goto L4;
        String r10 = r8.getName();     // Catch: Exception -> L11
        o.c(r10, "field.name");     // Catch: Exception -> L11
        Locale r11 = Locale.ROOT;     // Catch: Exception -> L11
        o.c(r11, "ROOT");     // Catch: Exception -> L11
        String r14 = r10.toLowerCase(r11);     // Catch: Exception -> L11
        o.c(r14, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        r4.put(r14, r9);     // Catch: Exception -> L11
    L13:
        r0.a(r1, r4, r13);
        return;
    L11:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_fluid_FluidToken_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("TokenParser", o.a("Failed to parse tokens from ", r12.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L13
    }

    public static /* synthetic */ void registerTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerTokens(r5, r2);
    }

    public static final void registerTokens(Map<String, com.obric.oui.fluid.a> r4, boolean r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r6, "customTokens");
        n.f35506a.a((Map) ZeusTransformUtils.preCheckCast(INSTANCE.getTokens(), Map.class, "com.obric.aiagent.plugin"), r6, r5);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_fluid_FluidToken_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
