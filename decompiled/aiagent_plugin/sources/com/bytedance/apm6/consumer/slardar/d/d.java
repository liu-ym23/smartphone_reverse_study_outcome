package com.bytedance.apm6.consumer.slardar.d;

import android.app.Application;
import com.bytedance.common.utility.i;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: LogSender.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.apm6.consumer.slardar.e.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedHashMap<f, ConcurrentLinkedQueue<b>> f5145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm6.util.e.a f5146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f5148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5149e;
    private volatile boolean f;

    /* JADX INFO: compiled from: LogSender.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f5152a = null;

        static /* synthetic */ d a() {
            return f5152a;
        }

        static {
            f5152a = new d(null);
        }
    }

    /* JADX INFO: compiled from: LogSender.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        byte[] f5153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f5154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f5155c;

        b(byte[] r1, int r2, long r3) {
            this.f5153a = r1;
            this.f5154b = r2;
            this.f5155c = r3;
        }
    }

    @Override // com.bytedance.apm6.consumer.slardar.e.d
    public String c() {
        return "second_log_dir";
    }

    /* synthetic */ d(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ long a(d r2) {
        return r2.f5148d;
    }

    static /* synthetic */ long a(d r0, long r1) {
        r0.f5148d = r1;
        return r1;
    }

    static /* synthetic */ long b(d r2) {
        return r2.f5147c;
    }

    static /* synthetic */ boolean c(d r0) {
        return r0.f;
    }

    static /* synthetic */ void d(d r0) {
        r0.e();
    }

    private d() {
        this.f5145a = new LinkedHashMap();
        this.f5147c = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
        this.f5148d = 0;
        this.f5149e = 1;
        this.f = false;
    }

    public static d a() {
        return a.a();
    }

    public void b() {
        final long r2 = 0;
        final long r4 = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
        this.f5146b = new AnonymousClass1(this, r2, r4);
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5473a).a(this.f5146b);
    }

    public void a(List<com.bytedance.apm6.consumer.slardar.c.a> r20, int r21) {
        List<com.bytedance.apm6.consumer.slardar.c.a> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
    L62:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "sendLog", th);
        return;
    L4:
        if (c.a().h() == true) goto L6;
        Map<f, byte[]> r3 = g.a(r1, r21);     // Catch: Throwable -> L62
        if (r3 != null) goto L18;
        a(r1);     // Catch: Throwable -> L62
        return;
    L18:
        boolean r4 = i.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L62
        Iterator<f> r5 = r3.keySet().iterator();     // Catch: Throwable -> L62
        boolean r7 = false;
    L20:
        if (r5.hasNext() == false) goto L58;
        f r8 = (f) ZeusTransformUtils.preCheckCast(r5.next(), f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L62
        byte[] r9 = (byte[]) ZeusTransformUtils.preCheckCast(r3.get(r8), byte[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L62
        if (r9 == null) goto L20;
        if (c.a().e() == false) goto L36;
        if (r4 == false) goto L36;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L30;
        com.bytedance.apm.doctor.a.a(r9);     // Catch: Throwable -> L62
    L30:
        boolean r10 = e.a(r8).b(r9);     // Catch: Throwable -> L62
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L35;
        if (r10 == false) goto L34;
        com.bytedance.apm.doctor.a.b(r9);     // Catch: Throwable -> L62
        goto L35
    L34:
        com.bytedance.apm.doctor.a.c(r9);     // Catch: Throwable -> L62
    L35:
        this.f5148d = System.currentTimeMillis();     // Catch: Throwable -> L62
        r7 = r7 | r10;     // Catch: Throwable -> L62
        int r14 = 1;
    L38:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L40;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "sendDirect:isReportLogEnable " + c.a().e() + " :sendResult " + r10);     // Catch: Throwable -> L62
    L40:
        if (r10 == true) goto L56;
        long r12 = c.a().a(r14);     // Catch: Throwable -> L62
        boolean r22 = r7;
        long r6 = System.currentTimeMillis() + r12;     // Catch: Throwable -> L62
        if (com.bytedance.apm6.foundation.context.a.e() == false) goto L46;
        r10 = com.bytedance.apm6.consumer.slardar.d.a.a().a(r9, r8.a(), r14, r6);     // Catch: Throwable -> L62
    L46:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L48;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "saveFile:Result:" + r10 + ":isMaiProcess:" + com.bytedance.apm6.foundation.context.a.e() + " :" + r14 + " " + r12);     // Catch: Throwable -> L62
    L48:
        if (r10 == false) goto L50;
    L57:
        r7 = r22;
        r3 = r3;
        r4 = r4;
        r5 = r5;
        goto L20
    L50:
        if (this.f5145a.containsKey(r8) == false) goto L52;
        ConcurrentLinkedQueue r11 = (ConcurrentLinkedQueue) ZeusTransformUtils.preCheckCast(this.f5145a.get(r8), ConcurrentLinkedQueue.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L62
    L54:
        if (r11.size() <= 10) goto L57;
        r11.poll();     // Catch: Throwable -> L62
        goto L57
    L52:
        r11 = new ConcurrentLinkedQueue();     // Catch: Throwable -> L62
        r11.add(new b(r9, r14, r6));     // Catch: Throwable -> L62
        goto L54
    L56:
        r3 = r3;
        r4 = r4;
        r5 = r5;
        r22 = r7;
    L36:
        r10 = false;
        r14 = 0;
        goto L38
    L58:
        if (r7 == false) goto L60;
        h();     // Catch: Throwable -> L62
    L60:
        a(r1);     // Catch: Throwable -> L62
        return;
    L6:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L8;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "stop collect log");     // Catch: Throwable -> L62
    L8:
        Iterator<com.bytedance.apm6.consumer.slardar.c.a> r13 = r1.iterator();     // Catch: Throwable -> L62
        long r15 = 0;
        long r16 = 0;
    L10:
        if (r13.hasNext() == false) goto L12;
        com.bytedance.apm6.consumer.slardar.c.a r17 = (com.bytedance.apm6.consumer.slardar.c.a) ZeusTransformUtils.preCheckCast(r13.next(), com.bytedance.apm6.consumer.slardar.c.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L62
        r15 = r15 + ((long) r17.b());     // Catch: Throwable -> L62
        r16 = r16 + ((long) r17.c());     // Catch: Throwable -> L62
        goto L10
    L12:
        com.bytedance.apm6.consumer.slardar.d.b.a().a(r15, r16, System.currentTimeMillis(), com.bytedance.apm6.consumer.slardar.d.b.EnumC0126b.f5135a);     // Catch: Throwable -> L62
        a(r1);     // Catch: Throwable -> L62
    }

    @Override // com.bytedance.apm6.consumer.slardar.e.d
    public void c(long r6) {
        File[] r5 = com.bytedance.apm6.consumer.slardar.d.a.a().c();
        if (r5 != null) goto L5;
        return;
    L5:
        int r0 = r5.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        File r2 = r5[r1];
        if (com.bytedance.apm6.consumer.slardar.d.a.c(r2) > r6) goto L10;
        com.bytedance.apm6.util.c.c(r2);
    L10:
        r1 = r1 + 1;
        goto L6
    }

    @Override // com.bytedance.apm6.consumer.slardar.e.d
    public void d(long r10) {
        File[] r0 = com.bytedance.apm6.consumer.slardar.d.a.a().c();
        if (r0 != null) goto L5;
        return;
    L5:
        Arrays.sort(r0, new AnonymousClass2(this));
        int r9 = r0.length;
        int r1 = 0;
        long r2 = 0;
        int r4 = 0;
        long r5 = 0;
    L6:
        if (r4 >= r9) goto L13;
        File r7 = r0[r4];
        if (r7.exists() == false) goto L12;
        if (r7.isFile() == false) goto L12;
        r5 = r5 + r7.length();
    L12:
        r4 = r4 + 1;
        goto L6
    L13:
        int r11 = r0.length;
    L14:
        if (r1 >= r11) goto L36;
        File r6 = r0[r1];
        if ((r5 - r2) <= r10) goto L25;
        if (r6.exists() == false) goto L24;
        if (r6.isFile() == false) goto L24;
        long r8 = r6.length();
        if (com.bytedance.apm6.util.c.b(r6) == false) goto L24;
        r2 = r2 + r8;
    L24:
        r1 = r1 + 1;
        goto L14
    L25:
        return;
    }

    @Override // com.bytedance.apm6.consumer.slardar.e.d
    public long d() {
        File[] r6 = com.bytedance.apm6.consumer.slardar.d.a.a().c();
        long r0 = 0;
        if (r6 != null) goto L5;
        return 0;
    L5:
        int r2 = r6.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        r0 = r0 + r6[r3].length();
        r3 = r3 + 1;
        goto L6
    L8:
        return r0;
    }

    private void e() {
        if (i.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")) == true) goto L5;
        return;
    L5:
        if (c.a().e() == false) goto L21;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L9;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "trigger send.");
    L9:
        boolean r0 = f();
        if (com.bytedance.apm6.foundation.context.a.e() == false) goto L12;
        r0 = g();
    L12:
        if (r0 == false) goto L15;
        h();
        goto L21
    L15:
        if (this.f5147c >= 120000) goto L18;
        long r4 = this.f5149e;
        this.f5147c = (r4 + 1) * OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
        this.f5149e = r4 + 1;
    L18:
        if (this.f5147c <= 120000) goto L21;
        this.f5147c = 120000;
    L21:
        if (com.bytedance.apm6.foundation.context.a.u() == true) goto L23;
        return;
    L23:
        if (c.a().e() == true) goto L28;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "report log disable");
        return;
    }

    private boolean f() {
        if (this.f5145a.isEmpty() == false) goto L5;
        return true;
    L5:
        Iterator<f> r1 = this.f5145a.keySet().iterator();
        boolean r3 = true;
    L7:
        if (r1.hasNext() == false) goto L35;
        f r4 = (f) ZeusTransformUtils.preCheckCast(r1.next(), f.class, "com.obric.aiagent.plugin");
        ConcurrentLinkedQueue r5 = (ConcurrentLinkedQueue) ZeusTransformUtils.preCheckCast(this.f5145a.get(r4), ConcurrentLinkedQueue.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L7;
        b[] r8 = (b[]) ZeusTransformUtils.preCheckCast(r5.toArray(new b[0]), b[].class, "com.obric.aiagent.plugin");
        b r9 = null;
        int r10 = r8.length;
        int r11 = 0;
    L12:
        if (r11 >= r10) goto L20;
        b r12 = r8[r11];
        if (r12.f5154b <= 0) goto L19;
        b[] r15 = r8;
        if ((System.currentTimeMillis() - r12.f5155c) > 0) goto L19;
        r11 = r11 + 1;
        r8 = r15;
    L19:
        r9 = r12;
    L20:
        if (r9 == null) goto L22;
    L24:
        if (r9 == null) goto L7;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L29;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "sendMemory");
    L29:
        boolean r6 = e.a(r4).b(r9.f5153a);
        if (r6 == false) goto L32;
        r5.remove(r9);
    L33:
        if (r6 == true) goto L7;
        r3 = false;
        goto L7
    L32:
        r9.f5154b++;
        r9.f5155c = c.a().a(r9.f5154b) + System.currentTimeMillis();
        goto L33
    L22:
        if (r5.size() <= 0) goto L24;
        r9 = (b) ZeusTransformUtils.preCheckCast(r5.peek(), b.class, "com.obric.aiagent.plugin");
        goto L24
    L35:
        return r3;
    }

    private boolean g() {
        Iterator<f> r9 = g.a().iterator();
        boolean r1 = true;
    L4:
        if (r9.hasNext() == false) goto L24;
        f r2 = (f) ZeusTransformUtils.preCheckCast(r9.next(), f.class, "com.obric.aiagent.plugin");
        File r3 = com.bytedance.apm6.consumer.slardar.d.a.a().a(r2.a());
        if (r3 == null) goto L4;
        if (r3.exists() == false) goto L4;
        if (e.a(r2).b(com.bytedance.apm6.util.c.a(r3)) == true) goto L13;
        com.bytedance.apm6.consumer.slardar.d.a.b r4 = com.bytedance.apm6.consumer.slardar.d.a.a().b(r3);
        if (r4 == null) goto L19;
        int r5 = r4.a() + 1;
    L20:
        long r6 = c.a().a(r5) + System.currentTimeMillis();
        com.bytedance.apm6.consumer.slardar.d.a.a().a(r3, r5, r6);
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L23;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "sendfile error retry count:" + r3.getName() + "  " + r5 + " nextRetryTime:" + r6);
    L23:
        r1 = false;
        goto L4
    L19:
        r5 = 0;
        goto L20
    L13:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L15;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "sendFile: success");
    L15:
        com.bytedance.apm6.consumer.slardar.d.a.a().a(r3);
        goto L4
    L24:
        return r1;
    }

    private void h() {
        this.f5149e = 1;
        this.f5147c = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
    }

    private void a(List<com.bytedance.apm6.consumer.slardar.c.a> r5) {
        Iterator r4 = ((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        com.bytedance.apm6.consumer.slardar.c.a r6 = (com.bytedance.apm6.consumer.slardar.c.a) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.apm6.consumer.slardar.c.a.class, "com.obric.aiagent.plugin");
    L10:
        com.bytedance.apm6.util.c.b.c(com.bytedance.apm6.consumer.slardar.a.f5054a, "delete LogFile's source File failed. logFile=" + r6.e());
        goto L4
    L7:
        if (r6.e() == null) goto L4;
        com.bytedance.apm6.util.c.c(r6.e());     // Catch: Exception -> L10
        goto L4
    }
}
