package com.baidu.mshield.x0.d.h;

import com.baidu.mshield.x0.EngineImpl;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static d f8399a = null;

    /* renamed from: b, reason: collision with root package name */
    public static int f8400b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public static long f8401c = 120;

    /* renamed from: d, reason: collision with root package name */
    public ThreadPoolExecutor f8402d;

    public class a implements FileFilter {
        public a(d dVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public d() {
        int iA = (a() / 2) + 2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iA > 5 ? 5 : iA, f8400b, f8401c, TimeUnit.SECONDS, new PriorityBlockingQueue());
        this.f8402d = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new c());
    }

    public static d b() {
        synchronized (d.class) {
            try {
                if (f8399a == null) {
                    f8399a = new d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f8399a;
    }

    public void a(com.baidu.mshield.x0.d.h.a aVar) {
        try {
            if (EngineImpl.isUnload) {
                return;
            }
            this.f8402d.execute(aVar);
        } catch (Throwable th) {
            com.baidu.mshield.x0.d.d.a(th);
        }
    }

    public void c() {
        try {
            this.f8402d.shutdownNow();
            f8399a = null;
        } catch (Throwable th) {
            com.baidu.mshield.x0.d.d.a(th);
        }
    }

    public int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a(this)).length;
        } catch (Throwable unused) {
            return 2;
        }
    }
}
