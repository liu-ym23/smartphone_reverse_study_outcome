package d2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ExecutorService f19026a;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f19027a;

        public a(b r10) {
            this.f19027a = r10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            return new Thread(r10, "Apm_Log_Bypass_Store");
        }
    }

    /* JADX INFO: renamed from: d2.b$b, reason: collision with other inner class name */
    public static class C0230b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f19028a = null;

        static {
            f19028a = new b(null);
        }
    }

    public /* synthetic */ b(a r10) {
        this();
    }

    public static b a() {
        if (w0.c.D() == true) goto L5;
        return null;
    L5:
        return C0230b.f19028a;
    }

    public void b(Runnable r10) {
        this.f19026a.submit(r10);
    }

    public b() {
        this.f19026a = Executors.newFixedThreadPool(1, new a(this));
    }
}
