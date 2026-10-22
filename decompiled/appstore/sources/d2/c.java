package d2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread f19029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlockingQueue f19030b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f19031a;

        public a(c r10) {
            this.f19031a = r10;
        }

        /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
        @Override // java.lang.Runnable
        public void run() {
        L6:
            ((Runnable) c.a(this.f19031a).take()).run();     // Catch: InterruptedException -> L4
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L6
        }
    }

    public c(String r10) {
        this.f19030b = new LinkedTransferQueue();
        this.f19029a = new Thread(new a(this), r10);
    }

    public static /* synthetic */ BlockingQueue a(c r10) {
        return r10.f19030b;
    }

    public final boolean b(Runnable r10) {
        return this.f19030b.offer(r10);
    }

    public void c() {
        this.f19029a.start();
    }
}
