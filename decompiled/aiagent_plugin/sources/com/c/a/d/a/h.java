package com.c.a.d.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: compiled from: MonitorLogMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends com.c.a.d.a implements com.c.a.h.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.c.a.b.f f11913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f11914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentLinkedQueue<a> f11915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f11916d;

    /* JADX INFO: compiled from: MonitorLogMessageHandler.java */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f11920c;

        public a(h r1, String r2, String r3) {
            this.f11920c = r1;
            this.f11918a = r2;
            this.f11919b = r3;
        }
    }

    @Override // com.c.a.d.a
    public String b() {
        return "monitor_log";
    }

    public h() {
        this.f11914b = null;
        this.f11915c = new ConcurrentLinkedQueue();
        this.f11916d = new a(this, "error_data", "error_ids");
    }

    @Override // com.c.a.d.a
    public boolean d(com.c.a.c.a r25) {
        JSONObject r0 = new JSONObject(r25.a());
        if (this.f11913a != null) goto L6;
        return false;
    L6:
        if (a(r0, r25) == false) goto L8;
        return true;
    L8:
        long r19 = r0.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000);
        long r21 = r0.optLong("fetch_end_time", System.currentTimeMillis() / 1000);
        String[] r7 = this.f11913a.b(r0);
        if (r7 != null) goto L11;
    L33:
        return true;
    L11:
        if (r7.length <= 0) goto L33;
        int r6 = r7.length;
        boolean r1 = false;
        boolean r2 = false;
        int r5 = 0;
    L13:
        if (r5 >= r6) goto L30;
        String r4 = r7[r5];
        int r3 = 0;
    L15:
        r3 = r3 + 1;
        if (r3 > 100) goto L29;
        if (this.f11915c.isEmpty() == true) goto L20;
        a r13 = (a) ZeusTransformUtils.preCheckCast(this.f11915c.poll(), a.class, "com.obric.aiagent.plugin");
        if (r13 == this.f11916d) goto L24;
        File r8 = com.c.a.e.b.a.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r13.f11918a, b(r4));
        this.f11914b = r8;
        if (r8 == null) goto L28;
        String r14 = r4;
        com.c.a.h.b.a r12 = new com.c.a.h.b.a(a(r4), 0, false, r25.d(), this, null);
        r12.a(1);
        r12.c(true);
        com.c.a.h.a.a(r12);
        this.f11913a.a(r14, r13.f11919b);
        Thread.sleep(100);
        r2 = false;
        r1 = true;
        r4 = r14;
        r5 = r5;
        r6 = r6;
        r7 = r7;
        r3 = r3;
        goto L15
    L28:
        this.f11915c.clear();
        r1 = false;
        r2 = false;
        goto L29
    L24:
        this.f11915c.clear();
        r2 = false;
        goto L29
    L20:
        if (r2 == true) goto L15;
        this.f11913a.a(r19, r21, r4, new AnonymousClass1(this));
        r2 = true;
    L29:
        r5 = r5 + 1;
        r6 = r6;
        r7 = r7;
        goto L13
    L30:
        if (r1 == false) goto L32;
        c(r25);
        goto L33
    L32:
        a("Monitor日志查询为空", r25);
        goto L33
    }

    public void a(com.c.a.b.f r3) {
        this.f11913a = (com.c.a.b.f) ZeusTransformUtils.wrapperContextForParams(r3, com.c.a.b.f.class, "com.obric.aiagent.plugin");
    }

    public String a(String r1) {
        if ("block_monitor".equals(r1) == false) goto L5;
        return "log_exception";
    L5:
        return "log_performance";
    }

    public String b(String r2) {
        return "cloudMessage_" + r2;
    }

    @Override // com.c.a.h.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList();
        File r1 = this.f11914b;
        if (r1 == null) goto L5;
        r0.add(r1.getAbsolutePath());
    L5:
        return r0;
    }
}
