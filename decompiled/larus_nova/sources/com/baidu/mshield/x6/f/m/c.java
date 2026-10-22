package com.baidu.mshield.x6.f.m;

import com.baidu.mshield.x6.EngineImpl;
import com.baidu.mshield.x6.f.f;
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
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f32629a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f32630b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f32631c = 120;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ThreadPoolExecutor f32632d;

    public class a implements FileFilter {
        public a(c r100) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File r100) {
            if (Pattern.matches("cpu[0-9]", r100.getName()) == false) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public static c b() {
        monitor-enter(c.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f32629a != null) goto L7;
        f32629a = new c();     // Catch: Throwable -> L10
    L7:
        monitor-exit(c.class);     // Catch: Throwable -> L10
        return f32629a;
    }

    public int a() {
        return new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(new a(this)).length;
    L4:
        th = move-exception;
        f.b(th);
        return 2;
    }

    public void c() {
        this.f32632d.shutdownNow();     // Catch: Throwable -> L4
        f32629a = null;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        f.b(th);
    }

    public c() {
        int r100 = (a() / 2) + 2;
        if (r100 <= 5) goto L5;
        int r101 = 5;
    L6:
        PThreadPoolExecutor r102 = new PThreadPoolExecutor(r101, f32630b, f32631c, TimeUnit.SECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory("ield/x6/f/m/c"));
        this.f32632d = r102;
        r102.setThreadFactory(new b());
        return;
    L5:
        r101 = r100;
        goto L6
    }

    public void a(d r100) {
    L7:
        th = move-exception;
        f.b(th);
        return;
    L3:
        if (EngineImpl.isUnload == false) goto L5;
        return;
    L5:
        this.f32632d.execute(r100);     // Catch: Throwable -> L7
    }
}
