package u3;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24848a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f24849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f24850b;

        public a(c r10, Runnable r11) {
            this.f24850b = r10;
            this.f24849a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            this.f24849a.run();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            s3.a.c("APM-AsyncTask", "SingleThreadFactory error when running in thread " + c.a(this.f24850b), th);
        }
    }

    public c(String r10) {
        this.f24848a = "APM6-" + r10;
    }

    public static /* synthetic */ String a(c r10) {
        return r10.f24848a;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r10) {
        if (r3.a.c() == false) goto L6;
        s3.a.a("APM-AsyncTask", "creating newThread " + this.f24848a);
    L6:
        return new Thread(new a(this, r10), this.f24848a);
    }
}
