package com.obric.autogui.agents.scripted.c;

import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.f;
import d.g;
import d.h.b.o;
import d.l.n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventSamplingController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "Script-EventSamplingCtrl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26915a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f26916b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f26917c = null;

    public static /* synthetic */ int lambda$72iDuNlmsONiC0sKzXJqluPIRMI() {
        return e();
    }

    public static /* synthetic */ Map lambda$CFZGdv_mYbFl_EKRU6oKumTFqLQ() {
        return d();
    }

    private a() {
    }

    static {
        f26915a = new a();
        f26916b = g.a($$Lambda$a$CFZGdv_mYbFl_EKRU6oKumTFqLQ.INSTANCE);
        f26917c = g.a($$Lambda$a$72iDuNlmsONiC0sKzXJqluPIRMI.INSTANCE);
    }

    private final Map<String, Integer> a() {
        return (Map) ZeusTransformUtils.preCheckCast(f26916b.b(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final Map d() {
        return f26915a.c();
    }

    private final int b() {
        return ((Number) ZeusTransformUtils.preCheckCast(f26917c.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    private static final int e() {
        return AutoActionConfigs.INSTANCE.getIntCfg("jsb.event_sender.sampling_default_rate", 100);
    }

    public final boolean a(String r4, String r5) {
        o.e(r4, "tag");
        int r0 = b();     // Catch: Exception -> L5
    L8:
        return a(r4, r5, r0);
    L5:
        e = move-exception;
        a("Failed to load default sampling rate", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r0 = 100;
        goto L8
    }

    public final boolean a(String r11, String r12, int r13) {
        o.e(r11, "tag");
        return a(r11, r12, r13, (Integer) ZeusTransformUtils.preCheckCast(a().get(r11), Integer.class, "com.obric.aiagent.plugin"), System.currentTimeMillis());
    L5:
        e = move-exception;
        a("Failed to decide sampling for tag=" + r11, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return a(r11, r12, r13, null, System.currentTimeMillis());
    }

    private final Map<String, Integer> c() {
        String r0 = AutoActionConfigs.INSTANCE.getStringCfg("jsb.event_sender.sampling_tag_rates");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        JSONObject r3 = new JSONObject(r0);     // Catch: Exception -> L17
        Map<String, Integer> r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L17
        Iterator<String> r5 = r3.keys();     // Catch: Exception -> L17
    L14:
        if (r5.hasNext() == false) goto L24;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L17
        r4.put(r6, Integer.valueOf(r3.getInt(r6)));     // Catch: Exception -> L17
        goto L14
    L24:
        return r4;
    L17:
        e = move-exception;
        a("Failed to parse sampling_tag_rates", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return ao.b();
    L11:
        return ao.b();
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    private final long b(String r5, String r6) {
        return ((((long) r5.hashCode()) & 4294967295L) + (((long) r6.hashCode()) & 4294967295L)) & 4294967295L;
    }

    public final boolean a(String r5, String r6, int r7, Integer r8, long r9) {
        o.e(r5, "tag");
        if (r8 == null) goto L5;
        r7 = r8.intValue();
    L5:
        int r10 = n.a(r7, 0, 100);
        if (r10 < 100) goto L8;
        return true;
    L8:
        if (r10 > 0) goto L10;
        return false;
    L10:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L19;
        long r11 = r9 % ((long) 100);
    L21:
        if (r11 < r10) goto L23;
        return false;
    L23:
        return true;
    L19:
        r11 = b(r6, r5) % ((long) 100);
        goto L21
    L13:
        if (d.o.o.d(r2) == true) goto L16;
        r3 = false;
        goto L17
    }

    private final void a(String r2, Throwable r3) {
        com.obric.autogui.agents.scripted.b.f.f26914a.a(TAG, r2, r3);
    }
}
