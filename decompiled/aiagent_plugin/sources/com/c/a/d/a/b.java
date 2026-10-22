package com.c.a.d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: AlogMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.c.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.c.a.b.c f11903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f11904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f11905c;

    @Override // com.c.a.d.a
    public String b() {
        return "alog";
    }

    public b() {
        this.f11904b = new ArrayList();
        this.f11905c = 0;
    }

    @Override // com.c.a.d.a
    public synchronized boolean d(com.c.a.c.a r13) {
        monitor-enter(this);
        JSONObject r5 = new JSONObject(r13.a());     // Catch: Throwable -> L51
        if (this.f11903a != null) goto L15;
        boolean r0 = com.bytedance.apm.c.d();     // Catch: Throwable -> L51
        String r2 = com.bytedance.apm.c.c();     // Catch: Throwable -> L51
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        if (r0 == false) goto L10;
        String r1 = "主进程收到命令，未设置ALog回捞组件。请宿主应用检查是否在合适时机设置ALog回捞组件。";
    L11:
        com.c.a.g.a.a(r1, r13);     // Catch: Throwable -> L51
        monitor-exit(this);
        return false;
    L10:
        r1 = "子进程\"$processName\"收到命令，等待主进程活跃后上报。".replace("$processName", r2);     // Catch: Throwable -> L51
        goto L11
    L15:
        if ((System.currentTimeMillis() - this.f11905c) >= 180000) goto L19;
        com.c.a.h.b.b r3 = new com.c.a.h.b.b(0, false, r13.d(), null);     // Catch: Throwable -> L51
        r3.a(0);     // Catch: Throwable -> L51
        r3.a("3分钟内不重复执行alog回捞");     // Catch: Throwable -> L51
        com.c.a.h.a.a(r3);     // Catch: Throwable -> L51
        monitor-exit(this);
        return false;
    L19:
        this.f11905c = System.currentTimeMillis();     // Catch: Throwable -> L51
        List<String> r4 = this.f11903a.handleAlogData(r5.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000), r5.optLong("fetch_end_time", System.currentTimeMillis() / 1000), r5);     // Catch: Throwable -> L51
        com.c.a.c.c r6 = this.f11903a.getConsumerResult();     // Catch: Throwable -> L51
        if (r4 == null) goto L24;
        if (r4.size() == 0) goto L24;
    L30:
        if (r4 == null) goto L47;
        if (r4.size() == 0) goto L47;
        if (r6.a() == false) goto L47;
        this.f11904b.clear();     // Catch: Throwable -> L51
        this.f11904b.addAll(r4);     // Catch: Throwable -> L51
        File r7 = com.c.a.g.b.a().b();     // Catch: Throwable -> L51
        if (r7 == null) goto L45;
        File r8 = new File(r7, r13.d() + "temp");     // Catch: Throwable -> L51
        if (r8.exists() == false) goto L40;
        com.c.a.i.b.b(r8);     // Catch: Throwable -> L51
    L40:
        r8.mkdirs();     // Catch: Throwable -> L51
        File r9 = new File(r8, r13.d() + "-cloudMsg.zip");     // Catch: Throwable -> L51
        if (r9.exists() == false) goto L43;
        r9.delete();     // Catch: Throwable -> L51
    L43:
        String[] r10 = (String[]) ZeusTransformUtils.preCheckCast(r4.toArray(new String[r4.size()]), String[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        com.c.a.i.b.a(r9.getAbsolutePath(), r10);     // Catch: Throwable -> L51
        com.c.a.g.a.a("Alog回捞:" + Arrays.toString(r10) + " ErrMsg=" + r6.b(), r13, r6.c());     // Catch: Throwable -> L51
        com.c.a.g.b.a().a(r13, r8, "log_agile");     // Catch: Throwable -> L51
    L49:
        monitor-exit(this);
        return true;
    L45:
        throw new com.c.a.c.b("pending目录因拿不到context而未设置");     // Catch: Throwable -> L51
    L47:
        if (r6.a() == true) goto L49;
        a(r6.b(), r6.c(), r13);     // Catch: Throwable -> L51
    L24:
        if (ZeusTransformUtils.instanceOf(this.f11903a, com.c.a.b.b.class) == false) goto L30;
        r4 = ((com.c.a.b.b) ZeusTransformUtils.preCheckCast(this.f11903a, com.c.a.b.b.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L51
        if (r4 == null) goto L30;
        if (r4.size() == 0) goto L30;
        r6 = com.c.a.c.c.a(true, "兜底策略数据", r6.c());     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    }

    public void a(com.c.a.b.c r3) {
        this.f11903a = (com.c.a.b.c) ZeusTransformUtils.wrapperContextForParams(r3, com.c.a.b.c.class, "com.obric.aiagent.plugin");
    }
}
