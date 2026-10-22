package bt3;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ExecutorService f20540a;

    public class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            return new PthreadThreadV2(r100, "Apm_Log_Bypass_Store");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f20541a = null;

        static {
            f20541a = new c();
        }
    }

    public static c a() {
        if (com.bytedance.apm.d.f190515c == true) goto L5;
        return null;
    L5:
        return b.f20541a;
    }

    public c() {
        this.f20540a = PThreadExecutorsUtils.newFixedThreadPool(1, new a());
    }

    public final void b(Runnable r100) {
        this.f20540a.submit(r100);
    }
}
