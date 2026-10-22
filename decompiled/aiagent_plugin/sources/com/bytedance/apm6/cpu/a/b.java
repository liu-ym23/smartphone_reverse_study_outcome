package com.bytedance.apm6.cpu.a;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.util.Log;
import com.bytedance.apm.core.MonitorSharedPreferences;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CpuCollectManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f5192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f5193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f5194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SharedPreferences f5195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.apm6.service.d.a f5196e;
    private com.bytedance.apm6.cpu.a.InterfaceC0127a f;
    private com.bytedance.watson.assist.a.c g;

    /* JADX INFO: compiled from: CpuCollectManager.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f5199a = null;

        static /* synthetic */ b a() {
            return f5199a;
        }

        static {
            f5199a = new b(null);
        }
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ void a(b r0) {
        r0.e();
    }

    static /* synthetic */ SharedPreferences b(b r0) {
        return r0.f5195d;
    }

    private b() {
        this.f5192a = new AtomicBoolean(false);
        this.g = com.bytedance.watson.assist.a.b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L6
    L4:
        this.f5194c = new c(this.g);
        this.f5193b = new d(this.f5194c, this.g);
    }

    public static b a() {
        return a.a();
    }

    public void b() {
        if (this.f5192a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f5196e = (com.bytedance.apm6.service.d.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.d.a.class), com.bytedance.apm6.service.d.a.class, "com.obric.aiagent.plugin");
        this.f5195d = MonitorSharedPreferences.getSharedPreferences((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), "apm_cpu_front");
        if (com.bytedance.apm6.foundation.context.a.e() == false) goto L8;
        e();
        final long r3 = 300000;
        final long r5 = 300000;
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5476d).a(new AnonymousClass1(this, r3, r5));
    L8:
        this.f5195d.edit().putString(com.bytedance.apm6.foundation.context.a.f(), Process.myPid() + "," + this.f5196e.isForeground()).apply();
        this.f5196e.register(new AnonymousClass2(this));
        com.bytedance.apm6.service.c.a(com.bytedance.apm6.cpu.b.b.class);
    }

    public boolean c() {
        if (this.f5196e.isForeground() == false) goto L6;
        this.f5195d.edit().putString(com.bytedance.apm6.foundation.context.a.f(), Process.myPid() + "," + this.f5196e.isForeground()).apply();
        return true;
    L6:
        Map<String, ?> r0 = this.f5195d.getAll();
        if (r0 == null) goto L15;
        Iterator<Map.Entry<String, ?>> r1 = r0.entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L15;
        if (((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin")).split(",")[1].equals("true") == false) goto L10;
        boolean r2 = true;
    L16:
        com.bytedance.apm6.cpu.b.a r3 = com.bytedance.apm6.cpu.b.a();
        if (r2 == false) goto L19;
        return true;
    L19:
        if (this.f5196e.isForeground() == false) goto L21;
        return true;
    L21:
        if (r3 != com.bytedance.apm6.cpu.b.a.f5219b) goto L23;
        return true;
    L23:
        if (r3 != com.bytedance.apm6.cpu.b.a.f5220c) goto L26;
        return true;
    L26:
        return false;
    L15:
        r2 = false;
        goto L16
    }

    public com.bytedance.apm6.cpu.a.InterfaceC0127a d() {
        return this.f;
    }

    private void e() {
        Map<String, ?> r0 = this.f5195d.getAll();
        if (r0 == null) goto L22;
        Iterator<Map.Entry<String, ?>> r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L39;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        File r4 = new File("/proc/" + ((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")).split(",")[0] + "/stat");     // Catch: Throwable -> L23
        BufferedReader r5 = null;
        String r6 = "";
        BufferedReader r7 = new BufferedReader(new FileReader(r4.getPath()), 100);     // Catch: Throwable -> L24
        r6 = r7.readLine();     // Catch: Throwable -> L12
        r7.close();     // Catch: Throwable -> L23
    L16:
        if (r6.isEmpty() == true) goto L17;
        String r8 = r6.split(" ")[1];     // Catch: Throwable -> L23
        if (r3.endsWith(r8.substring(1, r8.length() - 1)) == true) goto L6;
        this.f5195d.edit().remove(r3).apply();     // Catch: Throwable -> L23
        goto L6
    L17:
        this.f5195d.edit().remove(r3).apply();     // Catch: Throwable -> L23
    L12:
        r5 = r7;
    L13:
        if (r5 == null) goto L16;
        r5.close();     // Catch: Throwable -> L23
        goto L16
    L39:
        return;
    }

    public void a(com.bytedance.apm6.cpu.b.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        f.a();
        a("APM-CPU", "config: " + r3);
        if (com.bytedance.apm.c.d() == true) goto L10;
        if (r3.g() == true) goto L10;
        return;
    L10:
        if (r3.d() == false) goto L13;
        this.f5193b.a(r3);
        this.f5194c.a(r3);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
