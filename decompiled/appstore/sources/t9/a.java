package t9;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import r9.e;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f24759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p9.a f24760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Thread f24761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ServerSocket f24762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f24763e;

    /* JADX INFO: renamed from: t9.a$a, reason: collision with other inner class name */
    public class RunnableC0382a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CountDownLatch f24764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f24765b;

        public RunnableC0382a(a r10, CountDownLatch r11) {
            this.f24765b = r10;
            this.f24764a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f24764a.countDown();
            a.a(this.f24765b);
        }
    }

    public a(p9.a r10) {
        this.f24759a = Executors.newFixedThreadPool(8);
        this.f24760b = r10;
        ServerSocket r11 = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));     // Catch: Exception -> L5
        this.f24762d = r11;     // Catch: Exception -> L5
        int r12 = r11.getLocalPort();     // Catch: Exception -> L5
        this.f24763e = r12;     // Catch: Exception -> L5
        r10.j("127.0.0.1", r12);     // Catch: Exception -> L5
        CountDownLatch r13 = new CountDownLatch(1);     // Catch: Exception -> L5
        Thread r14 = new Thread(new RunnableC0382a(this, r13));     // Catch: Exception -> L5
        this.f24761c = r14;     // Catch: Exception -> L5
        r14.setName("VideoProxyCacheThread");     // Catch: Exception -> L5
        this.f24761c.start();     // Catch: Exception -> L5
        r13.await();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        c();
        o0.a.d("Cannot create serverSocket, exception=" + e);
    }

    public static /* synthetic */ void a(a r10) {
        r10.b();
    }

    public final void b() {
    L13:
        Socket r10 = this.f24762d.accept();     // Catch: Exception -> L5
        if (this.f24760b.d() <= 0) goto L7;
        r10.setSoTimeout(this.f24760b.d());     // Catch: Exception -> L5
    L7:
        this.f24759a.submit(new e(r10, this.f24760b));     // Catch: Exception -> L5
    L11:
        if (this.f24762d.isClosed() == false) goto L13;
        return;
    L5:
        e = move-exception;
        o0.a.d("WaitRequestsRun ServerSocket accept failed, exception=" + e);
        goto L11
    }

    public final void c() {
        ServerSocket r10 = this.f24762d;
        if (r10 != null) goto L26;
        return;
    L26:
        r10.close();     // Catch: Throwable -> L10 Exception -> L12
        this.f24759a.shutdown();
        Thread r11 = this.f24761c;
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.isAlive() == false) goto L30;
    L9:
        this.f24761c.interrupt();
        return;
    L30:
        return;
    L12:
        e = move-exception;
        o0.a.d("ServerSocket close failed, exception=" + e);     // Catch: Throwable -> L10
        this.f24759a.shutdown();
        Thread r12 = this.f24761c;
        if (r12 != null) goto L17;
        return;
    L17:
        if (r12.isAlive() == true) goto L9;
        return;
    L10:
        th = move-exception;
        this.f24759a.shutdown();
        Thread r13 = this.f24761c;
        if (r13 != null) goto L22;
    L24:
        throw th;
    L22:
        if (r13.isAlive() == false) goto L24;
        this.f24761c.interrupt();
        goto L24
    }
}
