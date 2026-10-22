package org.extra.tools;

import C5.f;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f5478a = new AtomicReference(c.f5479a);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f5479a;
        public static final c b;
        public static final c c;
        public static final /* synthetic */ c[] d;

        static {
            c cVar = new c("Unreported", 0);
            f5479a = cVar;
            c cVar2 = new c("Reporting", 1);
            b = cVar2;
            c cVar3 = new c("Reported", 2);
            c = cVar3;
            d = new c[]{cVar, cVar2, cVar3};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) d.clone();
        }
    }

    public static String a(f fVar) {
        StringBuilder sb = new StringBuilder("{\"appVersion\":\"\",\"sdkId\":\"\",\"sdkVersion\":\"");
        sb.append((String) fVar.f302a);
        sb.append("\",\"mainAppKey\":\"0DOU0K0WD05SLYU3\",\"platformId\":\"\",\"common\":{\"A2\":\"pag_sdk_report\"},\"events\":[{\"eventCode\":\"pag_sdk_report\",\"eventTime\":\"");
        sb.append(System.currentTimeMillis());
        sb.append("\",\"mapValue\":{\"appName\":\"");
        sb.append((String) fVar.b);
        sb.append("\",\"appID\":\"");
        sb.append((String) fVar.c);
        sb.append("\",\"appPlatform\":\"Android\",\"systemVersion\":\"");
        sb.append((String) fVar.e);
        sb.append("\",\"deviceName\":\"");
        sb.append((String) fVar.f);
        sb.append("\",\"gpuVersion\":\"");
        sb.append((String) fVar.g);
        sb.append("\",\"gpuVendor\":\"");
        sb.append((String) fVar.h);
        sb.append("\",\"previousSDKVersion\":\"");
        return B7.a.q(sb, (String) fVar.d, "\"}}]}");
    }

    public static void b() {
        ThreadPoolExecutor threadPoolExecutor;
        AtomicReference atomicReference = f5478a;
        if (atomicReference.get() != c.f5479a) {
            return;
        }
        atomicReference.set(c.b);
        ThreadPoolExecutor threadPoolExecutor2 = null;
        try {
            threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue(2));
        } catch (Throwable th) {
            th = th;
        }
        try {
            threadPoolExecutor.execute(new a());
            threadPoolExecutor.shutdown();
        } catch (Throwable th2) {
            th = th2;
            threadPoolExecutor2 = threadPoolExecutor;
            try {
                th.printStackTrace();
            } finally {
                threadPoolExecutor2.shutdown();
            }
        }
    }
}
