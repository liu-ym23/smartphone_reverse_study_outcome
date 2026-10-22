package com.obric.autogui.resourcemanage;

import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: RequestHeaderBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f30625a = null;

    static {
        f30625a = new h();
    }

    private h() {
    }

    public final Map<String, String> a(String r3, p r4, String r5, d.h.a.b<? super String, ? extends Map<String, String>> r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "body");
        d.h.b.o.e(r4, "config");
        d.h.b.o.e(r5, "requestDeviceId");
        Map<String, String> r8 = i.a(r5);
        r8.putAll(a(r3, r4.a(), r4.b()));
        if (IAppContext.Companion.isDebug() == false) goto L5;
        String r2 = "1";
    L6:
        r8.put("get-svc", r2);
        if (r7 == null) goto L11;
        Map<? extends String, ? extends String> r9 = (Map) ZeusTransformUtils.preCheckCast(r7.invoke(r3), Map.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L11;
        r8.putAll(r9);
    L11:
        return r8;
    L5:
        r2 = "0";
        goto L6
    }

    private final Map<String, String> a(String r11, String r12, String r13) {
        Map<String, String> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        SimpleDateFormat r1 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.CHINA);
        r1.setTimeZone(TimeZone.getTimeZone("UTC"));
        String r2 = r1.format(new Date());
        d.h.b.o.a(r2);
        String r14 = a(r2, r13);
        StringBuilder r3 = new StringBuilder();
        String r4 = "X-Mars-Date".toLowerCase(Locale.ROOT);
        d.h.b.o.c(r4, "toLowerCase(...)");
        String r5 = r3.append(r4).append(';').toString();
        StringBuilder r6 = new StringBuilder();
        String r7 = "X-Mars-Date".toLowerCase(Locale.ROOT);
        d.h.b.o.c(r7, "toLowerCase(...)");
        r0.put("Authorization", "HMAC-SHA256 Credential=" + r12 + ",SignedHeaders=" + r5 + ",Signature=" + a(r6.append(r7).append(':').append(d.o.o.a(r2, " ", "", false, 4, null)).append('\n').toString() + com.bytedance.common.utility.d.a(r11), r14));
        r0.put("X-mars-date", r2);
        return r0;
    }

    private final String a(String r5, String r6) {
        Mac r1 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L5
        byte[] r7 = r6.getBytes(d.o.d.f38623b);     // Catch: Exception -> L5
        d.h.b.o.c(r7, "getBytes(...)");     // Catch: Exception -> L5
        r1.init((Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r7, "HmacSHA256"), Key.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L5
        byte[] r8 = r5.getBytes(d.o.d.f38623b);     // Catch: Exception -> L5
        d.h.b.o.c(r8, "getBytes(...)");     // Catch: Exception -> L5
        byte[] r4 = r1.doFinal(r8);     // Catch: Exception -> L5
        return e.f30619a.a(r4);
    L5:
        return "";
    }
}
