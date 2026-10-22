package bh4;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.IUploadCallback;
import com.bytedance.crash.monitor.j;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f19026a;

    /* JADX INFO: renamed from: bh4.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes15.dex */
    public static class RunnableC0302a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f19027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f19028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<? extends String, ? extends String> f19029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, String> f19030d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final IUploadCallback f19031e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f19032f;

        public final void a() {
            com.bytedance.crash.monitor.a r100 = j.f203315a;
            if (r100 != null) goto L13;
            return;
        L13:
            eh4.a r101 = b.a(r100, this.f19032f, this.f19027a, this.f19028b, this.f19029c, this.f19030d);     // Catch: Throwable -> L7
            boolean r102 = CrashUploader.h(n.f(CrashType.DART, r101.f472654b.f203195a), r101.f472653a);     // Catch: Throwable -> L7
        L8:
            IUploadCallback r103 = this.f19031e;
            if (r103 == null) goto L17;
            r103.afterUpload(r102);     // Catch: Throwable -> L12
            return;
        L18:
            return;
        L17:
            return;
        L7:
            r102 = false;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0302a(String r100, long r101, String r102, Map<? extends String, ? extends String> r103, Map<String, String> r104, IUploadCallback r105) {
            this.f19027a = r101;
            this.f19028b = r102;
            this.f19029c = r103;
            this.f19030d = r104;
            this.f19031e = r105;
            this.f19032f = r100;
        }
    }

    public static void a(String r100, Map<? extends String, ? extends String> r110, Map<String, String> r111, IUploadCallback r112) {
        if (f19026a == false) goto L5;
        return;
    L5:
        long r101 = System.currentTimeMillis();
        wh4.b.post(new RunnableC0302a(ThreadMethodProxy.currentThread().getName(), r101, r100, r110, r111, r112));
    }
}
