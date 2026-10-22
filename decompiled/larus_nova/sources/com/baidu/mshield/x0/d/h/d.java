package com.baidu.mshield.x0.d.h;

import com.baidu.mshield.x0.EngineImpl;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes39.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f32498a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f32499b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f32500c = 120;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ThreadPoolExecutor f32501d;

    public class a implements FileFilter {
        public a(d r100) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File r100) {
            if (Pattern.matches("cpu[0-9]", r100.getName()) == false) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public static d b() {
        monitor-enter(d.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f32498a != null) goto L7;
        f32498a = new d();     // Catch: Throwable -> L10
    L7:
        monitor-exit(d.class);     // Catch: Throwable -> L10
        return f32498a;
    }

    public int a() {
        return new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(new a(this)).length;
    L4:
        return 2;
    }

    public void c() {
        this.f32501d.shutdownNow();     // Catch: Throwable -> L4
        f32498a = null;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.x0.d.d.a(th);
    }

    public d() {
        int r100 = (a() / 2) + 2;
        if (r100 <= 5) goto L5;
        int r101 = 5;
    L6:
        PThreadPoolExecutor r102 = new PThreadPoolExecutor(r101, f32499b, f32500c, TimeUnit.SECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory("ield/x0/d/h/d"));
        this.f32501d = r102;
        r102.setThreadFactory(new c());
        return;
    L5:
        r101 = r100;
        goto L6
    }

    public void a(com.baidu.mshield.x0.d.h.a r100) {
    L7:
        th = move-exception;
        com.baidu.mshield.x0.d.d.a(th);
        return;
    L3:
        if (EngineImpl.isUnload == false) goto L5;
        return;
    L5:
        this.f32501d.execute(r100);     // Catch: Throwable -> L7
    }
}
