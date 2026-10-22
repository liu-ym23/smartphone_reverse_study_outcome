package com.bytedance.applog.monitor.a;

import com.bytedance.applog.log.m;
import com.bytedance.applog.monitor.v3.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: AppLogExceptionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f5732a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f5734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f5735d;

    public b() {
        this.f5733b = false;
    }

    static {
        f5732a = new b();
    }

    public static b a() {
        return f5732a;
    }

    public void a(i r4, String r5, String r6, long r7) {
        if (b() == true) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put("tag", r5);
        r0.put("params", r6);
        a(d.f5740b, e.f, c.f5736a, r4 + " out of data boundary, event limit length: " + r7, r0);
    }

    public void a(d r8) {
        if (b() == true) goto L5;
        return;
    L5:
        a(r8, e.f5746c, c.f5737b, "report interrupted due to tourist mode.", null);
    }

    public void b(d r8) {
        if (b() == true) goto L5;
        return;
    L5:
        a(r8, e.f5744a, c.f5737b, "report interrupted due to invalid did.", null);
    }

    public void a(d r7, e r8, c r9, String r10, Map<String, ?> r11) {
        Map<String, ?> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if (b() == true) goto L5;
        return;
    L5:
        a r0 = this.f5734c;
        if (r0 != null) goto L13;
        return;
    L13:
        r0.a(r7, r8, r9, r10, r5);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        m.a().a("AppLogExceptionHandler onException failed, ", th, new Object[0]);
    }

    public void a(String r8) {
        if (b() == true) goto L5;
        return;
    L5:
        a(d.f5740b, e.g, c.f5736a, r8, null);
    }

    public void a(String r8, Throwable r9) {
        if (b() == true) goto L5;
        return;
    L5:
        HashMap r6 = new HashMap();
        r6.put("throwable", r9);
        a(d.f5739a, e.h, c.f5736a, r8, r6);
    }

    public void a(e r8, String r9) {
        if (b() == true) goto L5;
        return;
    L5:
        a(d.f5740b, r8, c.f5737b, r9, null);
    }

    public void a(i r2, String r3, long r4) {
        if (b() == true) goto L5;
        return;
    L5:
        f r1 = this.f5735d;
        if (r1 == null) goto L12;
        r1.a(r2, r3, r4);     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    public boolean b() {
        return this.f5733b;
    }
}
