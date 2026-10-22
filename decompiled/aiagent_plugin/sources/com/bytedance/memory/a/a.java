package com.bytedance.memory.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import com.bytedance.crash.Npth;
import com.bytedance.memory.b.c;
import com.bytedance.memory.b.d;
import com.bytedance.memory.b.e;
import com.bytedance.memory.b.g;
import com.bytedance.memory.i.b;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MemoryApi.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f8762c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile long f8763e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.memory.f.a f8765b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8766d;
    private volatile boolean f;
    private com.bytedance.memory.b.a g;
    private volatile boolean h;
    private volatile boolean i;
    private String j;

    static {
    }

    static /* synthetic */ long a(a r2) {
        return r2.f8766d;
    }

    static /* synthetic */ boolean a(a r0, boolean r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.memory.f.a b(a r0) {
        return r0.f8765b;
    }

    static /* synthetic */ boolean b(a r0, boolean r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.memory.b.a c(a r0) {
        return r0.g;
    }

    public void a(Context r3) {
        this.f8764a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public void a(String r1) {
        this.j = r1;
    }

    public String a() {
        return this.j;
    }

    private a() {
        this.f8766d = 0;
        this.g = new AnonymousClass1(this);
    }

    public boolean b() {
        com.bytedance.memory.f.a r1 = this.f8765b;     // Catch: Exception -> L10
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.d() == false) goto L16;
        if (d.a(this.f8764a) == true) goto L18;
        return false;
    L18:
        return true;
    L16:
        return false;
    L10:
        e = move-exception;
        c.a(Log.getStackTraceString(e), new Object[0]);
        return false;
    }

    public static a c() {
        if (f8762c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8762c != null) goto L9;
        f8762c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f8762c;
    }

    public void a(Context r5, com.bytedance.memory.f.a r6, b r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
        if (this.h == false) goto L5;
        return;
    L5:
        g.a(r8, Context.class.getSimpleName() + " mustn't be null");
        g.a(r6, com.bytedance.memory.f.a.class.getSimpleName() + " mustn't be null");
        this.f8764a = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.f8765b = r6;
        e.f8775a = r6.d();
        if (r6.c() == false) goto L8;
        a(r8, r9);
    L8:
        Npth.registerOOMCallback(new com.bytedance.memory.e.a());
        this.h = true;
    }

    private void a(Context r4, b r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        PluginBroadcastReceiver r8 = new AnonymousClass2(this);
    L9:
        th = move-exception;
        c.a("sendBroadcast catch", new Object[0]);
        th.printStackTrace();
        return;
    L5:
        if (Build.VERSION.SDK_INT <= 33) goto L7;
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8, new IntentFilter("Action_Result_Memory_Client_Analyzer"), 2, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8, new IntentFilter("Action_Result_Memory_Client_Analyzer"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        goto L12
    }

    public void d() {
        if (this.i == false) goto L5;
        return;
    L5:
        c.a("MemoryApi start", new Object[0]);
        this.i = true;
        g.a(this.h, "You must call init() first before using !!!");
        com.bytedance.memory.b.b.f8771b.a(new AnonymousClass3(this), "MemoryApi-start");
    }

    public void a(boolean r10) {
        if (r10 == false) goto L5;
    L7:
        long r2 = System.currentTimeMillis();
        if (r10 == false) goto L10;
    L13:
        f8763e = r2;
        com.bytedance.memory.heap.a.a().n();
        if (this.f8765b.c() == false) goto L25;
        c.a("client analyze mode", new Object[0]);
        if (this.f == false) goto L18;
        return;
    L18:
        if (com.bytedance.memory.c.b.i().e() == false) goto L29;
        d.a(this.f8764a, ZeusTransformUtils.forName("com.bytedance.apm.momory.analyzer.AnalyzerService", "com.obric.aiagent.plugin"), true);     // Catch: Throwable -> L22
        Intent r11 = new Intent(this.f8764a, ZeusTransformUtils.forName("com.bytedance.apm.momory.analyzer.AnalyzerService", "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
        r11.putExtra("hprofFilePath", com.bytedance.memory.c.b.i().g().getAbsolutePath());     // Catch: Throwable -> L22
        r11.putExtra("debug", this.f8765b.d());     // Catch: Throwable -> L22
        ZeusTransformUtils.startService(this.f8764a, r11, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        this.f8766d = System.currentTimeMillis();     // Catch: Throwable -> L22
        c.a("start Service success", new Object[0]);     // Catch: Throwable -> L22
        com.bytedance.memory.d.a.a("client_analyze_begin");     // Catch: Throwable -> L22
        this.f = true;     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        c.a("start Service failed", new Object[0]);
        this.f8765b.a(false);
        th.printStackTrace();
        return;
    L29:
        return;
    L25:
        c.a("upload mode", new Object[0]);
        com.bytedance.memory.h.a.b();
        return;
    L10:
        if ((r2 - f8763e) >= 300000) goto L13;
        c.a("uploadCheck return", new Object[0]);
        return;
    L5:
        if (com.bytedance.memory.heap.a.a().b() == false) goto L7;
    }

    public Context getContext() {
        g.a(this.f8764a, "You must call init() first before using !!!");
        return this.f8764a;
    }

    public com.bytedance.memory.f.a e() {
        g.a(this.f8765b, com.bytedance.memory.f.a.class.getSimpleName() + " mustn't be null");
        return this.f8765b;
    }
}
