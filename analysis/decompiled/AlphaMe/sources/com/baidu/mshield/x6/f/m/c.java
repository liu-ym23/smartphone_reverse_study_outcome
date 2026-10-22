package com.baidu.mshield.x6.f.m;

import com.baidu.mshield.x6.EngineImpl;
import com.baidu.mshield.x6.f.f;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static c f8530a = null;

    /* renamed from: b, reason: collision with root package name */
    public static int f8531b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public static long f8532c = 120;

    /* renamed from: d, reason: collision with root package name */
    public ThreadPoolExecutor f8533d;

    public class a implements FileFilter {
        public a(c cVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public c() {
        int iA = (a() / 2) + 2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iA > 5 ? 5 : iA, f8531b, f8532c, TimeUnit.SECONDS, new PriorityBlockingQueue());
        this.f8533d = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new b());
    }

    public static c b() {
        synchronized (c.class) {
            try {
                if (f8530a == null) {
                    f8530a = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f8530a;
    }

    public void a(d dVar) {
        try {
            if (EngineImpl.isUnload) {
                return;
            }
            this.f8533d.execute(dVar);
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public void c() {
        try {
            this.f8533d.shutdownNow();
            f8530a = null;
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a(this)).length;
        } catch (Throwable th) {
            f.b(th);
            return 2;
        }
    }
}
