package q;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.Consumer;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f23476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f23477b;

        /* JADX INFO: renamed from: q.d$a$a, reason: collision with other inner class name */
        public static class C0342a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f23478a;

            public C0342a(Runnable r10, String r11, int r12) {
                super(r10, r11);
                this.f23478a = r12;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f23478a);
                super.run();
            }
        }

        public a(String r10, int r11) {
            this.f23476a = r10;
            this.f23477b = r11;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            return new C0342a(r10, this.f23476a, this.f23477b);
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Callable f23479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Consumer f23480b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Handler f23481c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Consumer f23482a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f23483b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f23484c;

            public a(b r10, Consumer r11, Object r12) {
                this.f23484c = r10;
                this.f23482a = r11;
                this.f23483b = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f23482a.accept(this.f23483b);
            }
        }

        public b(Handler r10, Callable r11, Consumer r12) {
            this.f23479a = r11;
            this.f23480b = r12;
            this.f23481c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = this.f23479a.call();     // Catch: Exception -> L4
        L5:
            Consumer r11 = this.f23480b;
            this.f23481c.post(new a(this, r11, r10));
            return;
        L4:
            r10 = null;
            goto L5
        }
    }

    public static ThreadPoolExecutor a(String r10, int r11, int r12) {
        ThreadPoolExecutor r13 = new ThreadPoolExecutor(0, 1, r12, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(r10, r11));
        r13.allowCoreThreadTimeOut(true);
        return r13;
    }

    public static void b(Executor r10, Callable r11, Consumer r12) {
        r10.execute(new b(q.a.a(), r11, r12));
    }

    public static Object c(ExecutorService r10, Callable r11, int r12) {
        return r10.submit(r11).get(r12, TimeUnit.MILLISECONDS);
    L5:
        e = move-exception;
        throw e;
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L10:
        throw new InterruptedException("timeout");
    }
}
