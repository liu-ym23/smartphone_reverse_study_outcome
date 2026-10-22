package com.obric.oui.material;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.shadow.ShadowToken;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.p;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BlurShadowToken.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BlurShadowToken {
    public static final com.obric.oui.material.a Blur_Shadow_Regular = null;
    public static final com.obric.oui.material.a Blur_Shadow_Regular_On_Image = null;
    public static final com.obric.oui.material.a Blur_Shadow_Thin = null;
    public static final com.obric.oui.material.a Blur_Shadow_Thin_On_Image = null;
    public static final BlurShadowToken INSTANCE = null;
    private static final d.f tokens$delegate = null;

    /* JADX INFO: compiled from: BlurShadowToken.kt */
    static final class a extends p implements d.h.a.a<Map<String, ? extends com.obric.oui.material.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f35451a = null;

        static {
            f35451a = new a();
        }

        a() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Map<String, ? extends com.obric.oui.material.a> invoke() {
            return a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Map<String, com.obric.oui.material.a> a() {
            n r10 = n.f35506a;
            BlurShadowToken r11 = BlurShadowToken.INSTANCE;
            Map<String, com.obric.oui.material.a> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            Field[] r2 = r11.getClass().getDeclaredFields();     // Catch: Exception -> L11
            d.h.b.o.c(r2, "fields");     // Catch: Exception -> L11
            int r4 = 0;
            int r5 = r2.length;     // Catch: Exception -> L11
        L4:
            if (r4 >= r5) goto L13;
            Field r6 = r2[r4];     // Catch: Exception -> L11
            r4 = r4 + 1;     // Catch: Exception -> L11
            if (com.obric.oui.material.a.class.isAssignableFrom(r6.getType()) == false) goto L4;
            r6.setAccessible(true);     // Catch: Exception -> L11
            Object r7 = r6.get(r11);     // Catch: Exception -> L11
            if (ZeusTransformUtils.instanceOf(r7, com.obric.oui.material.a.class) == false) goto L4;
            String r8 = r6.getName();     // Catch: Exception -> L11
            d.h.b.o.c(r8, "field.name");     // Catch: Exception -> L11
            Locale r9 = Locale.ROOT;     // Catch: Exception -> L11
            d.h.b.o.c(r9, "ROOT");     // Catch: Exception -> L11
            String r12 = r8.toLowerCase(r9);     // Catch: Exception -> L11
            d.h.b.o.c(r12, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
            r1.put(r12, r7);     // Catch: Exception -> L11
        L13:
            return r1;
        L11:
            e = move-exception;
            a("TokenParser", d.h.b.o.a("Failed to parse tokens from ", r11.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L13
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    private BlurShadowToken() {
    }

    static {
        INSTANCE = new BlurShadowToken();
        tokens$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(a.f35451a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        Blur_Shadow_Thin = new com.obric.oui.material.a(BlurToken.Blur_Thin, ShadowToken.Shadow_2);
        Blur_Shadow_Regular = new com.obric.oui.material.a(BlurToken.Blur_Regular, ShadowToken.Shadow_3);
        Blur_Shadow_Thin_On_Image = new com.obric.oui.material.a(BlurToken.Blur_Regular, ShadowToken.Shadow_3);
        Blur_Shadow_Regular_On_Image = new com.obric.oui.material.a(BlurToken.Blur_Thick, ShadowToken.Shadow_Thick);
    }

    private final Map<String, com.obric.oui.material.a> getTokens() {
        return (Map) ZeusTransformUtils.preCheckCast(tokens$delegate.b(), Map.class, "com.obric.aiagent.plugin");
    }

    public static final com.obric.oui.material.a parse(String r2) {
        return (com.obric.oui.material.a) ZeusTransformUtils.preCheckCast(n.f35506a.a(r2, INSTANCE.getTokens()), com.obric.oui.material.a.class, "com.obric.aiagent.plugin");
    }
}
