package com.obric.oui.shadow;

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

/* JADX INFO: compiled from: ShadowToken.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ShadowToken {
    public static final ShadowToken INSTANCE = null;
    public static final com.obric.oui.shadow.a[] Oui_Shadow_Regular = null;
    public static final com.obric.oui.shadow.a[] Oui_Shadow_Text_Regular = null;
    public static final com.obric.oui.shadow.a[] Oui_Shadow_Thick = null;
    public static final com.obric.oui.shadow.a[] Oui_Shadow_Thin = null;
    public static final com.obric.oui.shadow.a[] Oui_Shadow_UltraThick = null;
    public static final com.obric.oui.shadow.a[] Shadow_1 = null;
    public static final com.obric.oui.shadow.a[] Shadow_2 = null;
    public static final com.obric.oui.shadow.a[] Shadow_3 = null;
    public static final com.obric.oui.shadow.a[] Shadow_Text = null;
    public static final com.obric.oui.shadow.a[] Shadow_Thick = null;
    private static final f tokens$delegate = null;

    /* JADX INFO: compiled from: ShadowToken.kt */
    static final class a extends p implements d.h.a.a<ConcurrentHashMap<String, com.obric.oui.shadow.a[]>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f36178a = null;

        static {
            f36178a = new a();
        }

        a() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ConcurrentHashMap<String, com.obric.oui.shadow.a[]> invoke() {
            return a();
        }

        public final ConcurrentHashMap<String, com.obric.oui.shadow.a[]> a() {
            ConcurrentHashMap<String, com.obric.oui.shadow.a[]> r11 = new ConcurrentHashMap();
            n r0 = n.f35506a;
            ShadowToken r1 = ShadowToken.INSTANCE;
            Map<? extends String, ? extends com.obric.oui.shadow.a[]> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            Field[] r3 = r1.getClass().getDeclaredFields();     // Catch: Exception -> L11
            o.c(r3, "fields");     // Catch: Exception -> L11
            int r5 = 0;
            int r6 = r3.length;     // Catch: Exception -> L11
        L4:
            if (r5 >= r6) goto L13;
            Field r7 = r3[r5];     // Catch: Exception -> L11
            r5 = r5 + 1;     // Catch: Exception -> L11
            if (com.obric.oui.shadow.a[].class.isAssignableFrom(r7.getType()) == false) goto L4;
            r7.setAccessible(true);     // Catch: Exception -> L11
            Object r8 = r7.get(r1);     // Catch: Exception -> L11
            if ((r8 instanceof com.obric.oui.shadow.a[]) == false) goto L4;
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

    private ShadowToken() {
    }

    static {
        INSTANCE = new ShadowToken();
        tokens$delegate = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(a.f36178a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        b[] r0 = ShadowTokenCore.Oui_Shadow_Thin;
        o.c(r0, "Oui_Shadow_Thin");
        Oui_Shadow_Thin = com.obric.oui.material.f.a(r0);
        b[] r1 = ShadowTokenCore.Oui_Shadow_Regular;
        o.c(r1, "Oui_Shadow_Regular");
        Oui_Shadow_Regular = com.obric.oui.material.f.a(r1);
        b[] r2 = ShadowTokenCore.Oui_Shadow_Thick;
        o.c(r2, "Oui_Shadow_Thick");
        Oui_Shadow_Thick = com.obric.oui.material.f.a(r2);
        b[] r3 = ShadowTokenCore.Oui_Shadow_UltraThick;
        o.c(r3, "Oui_Shadow_UltraThick");
        Oui_Shadow_UltraThick = com.obric.oui.material.f.a(r3);
        b[] r4 = ShadowTokenCore.Oui_Shadow_Text_Regular;
        o.c(r4, "Oui_Shadow_Text_Regular");
        Oui_Shadow_Text_Regular = com.obric.oui.material.f.a(r4);
        b[] r5 = ShadowTokenCore.Shadow_1;
        o.c(r5, "Shadow_1");
        Shadow_1 = com.obric.oui.material.f.a(r5);
        b[] r6 = ShadowTokenCore.Shadow_2;
        o.c(r6, "Shadow_2");
        Shadow_2 = com.obric.oui.material.f.a(r6);
        b[] r7 = ShadowTokenCore.Shadow_3;
        o.c(r7, "Shadow_3");
        Shadow_3 = com.obric.oui.material.f.a(r7);
        b[] r8 = ShadowTokenCore.Shadow_Thick;
        o.c(r8, "Shadow_Thick");
        Shadow_Thick = com.obric.oui.material.f.a(r8);
        b[] r9 = ShadowTokenCore.Shadow_Text;
        o.c(r9, "Shadow_Text");
        Shadow_Text = com.obric.oui.material.f.a(r9);
    }

    private final ConcurrentHashMap<String, com.obric.oui.shadow.a[]> getTokens() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(tokens$delegate.b(), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
    }

    public static final com.obric.oui.shadow.a[] parse(String r4) {
        return (com.obric.oui.shadow.a[]) ZeusTransformUtils.preCheckCast(n.f35506a.a(r4, (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getTokens(), Map.class, "com.obric.aiagent.plugin")), com.obric.oui.shadow.a[].class, "com.obric.aiagent.plugin");
    }
}
