package com.bytedance.framwork.core.sdklib.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: LogSender.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.framwork.core.sdklib.thread.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicInteger f8617c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicLong f8618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentLinkedQueue<b> f8619b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8620d;

    /* JADX INFO: renamed from: com.bytedance.framwork.core.sdklib.a.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: LogSender.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: LogSender.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f8621a = null;

        static /* synthetic */ f a() {
            return f8621a;
        }

        static {
            f8621a = new f(null);
        }
    }

    /* JADX INFO: compiled from: LogSender.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        byte[] f8622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f8624c;

        b(byte[] r1, int r2, long r3) {
            this.f8622a = r1;
            this.f8623b = r2;
            this.f8624c = r3;
        }
    }

    /* synthetic */ f(AnonymousClass1 r1) {
        this();
    }

    static {
        f8617c = new AtomicInteger(0);
    }

    private f() {
        this.f8618a = new AtomicLong(0);
        this.f8619b = new ConcurrentLinkedQueue();
    }

    public static f a() {
        return a.a();
    }

    public void b() {
        com.bytedance.framwork.core.sdklib.thread.a.a().a(this);
    }

    @Override // com.bytedance.framwork.core.sdklib.thread.b
    public void b(long r3) {
        if ((r3 - this.f8620d) < 90000) goto L12;
        c();     // Catch: Throwable -> L6
    L8:
        this.f8620d = System.currentTimeMillis();
        return;
    L6:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "onTimeEvent", th);
        goto L8
    }

    public void a(List<com.bytedance.framwork.core.sdklib.a.b> r12) {
        List<com.bytedance.framwork.core.sdklib.a.b> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
    L36:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "sendLog", th);
        return;
    L4:
        if (d.a().i() == true) goto L6;
        byte[] r2 = b(r13);     // Catch: Throwable -> L36
        if (r2 != null) goto L14;
        d(r13);     // Catch: Throwable -> L36
        return;
    L14:
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L36
        boolean r7 = false;
        if ((r4 - this.f8618a.get()) < 5000) goto L25;
        this.f8618a.set(r4);     // Catch: Throwable -> L36
        if (d.a().f() == true) goto L19;
    L21:
        int r3 = 0;
    L23:
        if (k.d() == false) goto L26;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "sendDirect:isReportLogEnable " + d.a().f() + " :sendResult " + r7);     // Catch: Throwable -> L36
    L26:
        if (r7 == true) goto L34;
        long r5 = d.a().a(r3);     // Catch: Throwable -> L36
        long r6 = System.currentTimeMillis() + r5;     // Catch: Throwable -> L36
        boolean r8 = g.a().a(r2, r3, r6);     // Catch: Throwable -> L36
        if (k.d() == false) goto L30;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "saveFile:Result:" + r8 + " " + r3 + " " + r5);     // Catch: Throwable -> L36
    L30:
        if (r8 == true) goto L34;
        this.f8619b.add(new b(r2, r3, r6));     // Catch: Throwable -> L36
        if (this.f8619b.size() <= 10) goto L34;
        this.f8619b.poll();     // Catch: Throwable -> L36
    L34:
        d(r13);     // Catch: Throwable -> L36
        return;
    L19:
        if (com.bytedance.apm6.util.g.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(k.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L21;
        r7 = i.a().a(r2);     // Catch: Throwable -> L36
        r3 = 1;
        goto L23
    L25:
        r3 = 0;
        goto L26
    L6:
        if (k.d() == false) goto L8;
        com.bytedance.framwork.core.sdklib.a.c.d.c("APM-SDK", "stop collect log");     // Catch: Throwable -> L36
    L8:
        d(r13);     // Catch: Throwable -> L36
    }

    private void c() {
        if (com.bytedance.apm6.util.g.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(k.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L5;
        return;
    L5:
        if (d.a().f() == true) goto L7;
        return;
    L7:
        if (k.d() == false) goto L9;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "trigger send.");
    L9:
        d();
        if (k.c() == false) goto L15;
        e();
        return;
    }

    private void d() {
        if (this.f8619b.isEmpty() == false) goto L5;
        return;
    L5:
        Object[] r0 = this.f8619b.toArray();
        b r1 = null;
        int r2 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L18;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r0[r3], b.class, "com.obric.aiagent.plugin");
        if (r5.f8623b <= d.a().d()) goto L12;
        this.f8619b.remove(r5);
    L16:
        r3 = r3 + 1;
        goto L7
    L12:
        if (r5.f8623b <= 0) goto L17;
        if ((System.currentTimeMillis() - r5.f8624c) <= 0) goto L16;
    L17:
        r1 = r5;
    L18:
        if (r1 == null) goto L20;
    L22:
        if (r1 != null) goto L25;
        return;
    L25:
        if (k.d() == false) goto L28;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "sendMemory");
    L28:
        if (i.a().a(r1.f8622a) == false) goto L30;
        this.f8619b.remove(r1);
        return;
    L30:
        r1.f8623b++;
        r1.f8624c = d.a().a(r1.f8623b) + System.currentTimeMillis();
        return;
    L20:
        if (this.f8619b.size() <= 0) goto L22;
        r1 = (b) ZeusTransformUtils.preCheckCast(this.f8619b.peek(), b.class, "com.obric.aiagent.plugin");
        goto L22
    }

    private void e() {
        File r7 = g.a().b();
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.exists() == true) goto L8;
        return;
    L8:
        if (i.a().a(com.bytedance.apm6.util.c.a(r7)) == true) goto L10;
        g.b r0 = g.a().b(r7);
        int r2 = 0;
        if (r0 == null) goto L16;
        r2 = r0.a() + 1;
    L16:
        long r3 = d.a().a(r2) + System.currentTimeMillis();
        g.a().a(r7, r2, r3);
        if (k.d() == false) goto L22;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "sendfile error retry count:" + r7.getName() + "  " + r2 + " nextRetryTime:" + r3);
        return;
    L22:
        return;
    L10:
        if (k.d() == false) goto L12;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "sendFile: success");
    L12:
        g.a().a(r7);
    }

    private byte[] b(List<com.bytedance.framwork.core.sdklib.a.b> r4) {
        Map<String, List<c>> r5 = c((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        a(r5);     // Catch: Throwable -> L8
        JSONArray r3 = b(r5);     // Catch: Throwable -> L8
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L8
        r6.put("list", r3);     // Catch: Throwable -> L8
        if (k.d() == false) goto L6;
        com.bytedance.framwork.core.sdklib.a.c.d.b("APM-SDK", "request : " + r6.toString());     // Catch: Throwable -> L8
    L6:
        return com.bytedance.apm6.util.i.a(r6.toString());
    L8:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "LogSender serialize failed.", th);
        return null;
    }

    private void a(Map<String, List<c>> r12) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        if (k.d() == false) goto L12;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "sendLog: input sendList merged into " + r11.size() + " group(s)");
        Iterator r13 = r11.keySet().iterator();
        int r3 = 0;
    L6:
        if (r13.hasNext() == false) goto L15;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r11.get((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin")), List.class, "com.obric.aiagent.plugin");
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "----------------");
        int r8 = r3 + 1;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "group " + r3 + " aid " + ((c) ZeusTransformUtils.preCheckCast(r4.get(0), c.class, "com.obric.aiagent.plugin")).c() + " headerId " + ((c) ZeusTransformUtils.preCheckCast(r4.get(0), c.class, "com.obric.aiagent.plugin")).b() + " header:" + com.bytedance.framwork.core.sdklib.a.a.a.a().a(((c) ZeusTransformUtils.preCheckCast(r4.get(0), c.class, "com.obric.aiagent.plugin")).c(), ((c) ZeusTransformUtils.preCheckCast(r4.get(0), c.class, "com.obric.aiagent.plugin")).b()));
        int r5 = 0;
    L9:
        if (r5 >= r4.size()) goto L11;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "  log[" + r5 + "]=" + ((c) ZeusTransformUtils.preCheckCast(r4.get(r5), c.class, "com.obric.aiagent.plugin")).toString());
        r5 = r5 + 1;
        goto L9
    L11:
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "----------------");
        r3 = r8;
        goto L6
    L15:
        return;
    }

    private Map<String, List<c>> c(List<com.bytedance.framwork.core.sdklib.a.b> r9) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        HashMap r10 = new HashMap();
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        Iterator<c> r1 = ((com.bytedance.framwork.core.sdklib.a.b) ZeusTransformUtils.preCheckCast(r11.next(), com.bytedance.framwork.core.sdklib.a.b.class, "com.obric.aiagent.plugin")).b().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r1.next(), c.class, "com.obric.aiagent.plugin");
        String r3 = r2.b() + "_" + r2.c();
        List r4 = (List) ZeusTransformUtils.preCheckCast(r10.get(r3), List.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L11;
        r4 = new ArrayList();
        r10.put(r3, r4);
    L11:
        r4.add(r2);
        goto L7
    L12:
        return r10;
    }

    private JSONArray b(Map<String, List<c>> r17) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        JSONArray r3 = new JSONArray();
        Iterator r4 = r2.keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L26;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(r2.get(r5), List.class, "com.obric.aiagent.plugin");
        if (com.bytedance.apm6.util.f.a(r6) == true) goto L4;
        JSONArray r7 = new JSONArray();
        int r9 = 0;
    L10:
        if (r9 >= r6.size()) goto L17;
        JSONObject r12 = new JSONObject(new String(((c) ZeusTransformUtils.preCheckCast(r6.get(r9), c.class, "com.obric.aiagent.plugin")).a()));     // Catch: Exception -> L14
        a(r12);
        r7.put(r12);
    L16:
        r9 = r9 + 1;
    L14:
        e = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "toJSON", e);
        goto L16
    L17:
        JSONObject r0 = com.bytedance.framwork.core.sdklib.a.a.a.a().a(((c) ZeusTransformUtils.preCheckCast(r6.get(0), c.class, "com.obric.aiagent.plugin")).c(), ((c) ZeusTransformUtils.preCheckCast(r6.get(0), c.class, "com.obric.aiagent.plugin")).b());
        if (r0 == null) goto L20;
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L24
        r8.put("data", r7);     // Catch: Exception -> L24
        r8.put("header", r0);     // Catch: Exception -> L24
        r3.put(r8);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "toJSON", e);
        goto L4
    L20:
        if (k.d() == false) goto L4;
        com.bytedance.framwork.core.sdklib.a.c.d.b("APM-SDK", "HeaderInfo null for key " + r5);
        goto L4
    L26:
        return r3;
    }

    private void a(JSONObject r2) {
        JSONObject r0 = r2.optJSONObject("_debug_self");
        if (r0 == null) goto L8;
    L5:
        r0.put("debug_sender_number", f8617c.getAndIncrement());     // Catch: Exception -> L7
        return;
    L10:
        return;
    L8:
        r0 = new JSONObject();     // Catch: Exception -> L7
        r2.put("_debug_self", r0);     // Catch: Exception -> L7
        goto L5
    }

    private void d(List<com.bytedance.framwork.core.sdklib.a.b> r4) {
        Iterator r3 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        com.bytedance.framwork.core.sdklib.a.b r5 = (com.bytedance.framwork.core.sdklib.a.b) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.framwork.core.sdklib.a.b.class, "com.obric.aiagent.plugin");
    L10:
        com.bytedance.framwork.core.sdklib.a.c.d.b("APM-SDK", "delete LogFile's source File failed. logFile=" + r5.c());
        goto L4
    L7:
        if (r5.c() == null) goto L4;
        com.bytedance.apm6.util.c.c(r5.c());     // Catch: Exception -> L10
        goto L4
    }
}
