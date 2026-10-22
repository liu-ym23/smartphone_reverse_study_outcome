package N0;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedTransferQueue;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f1006a = new CopyOnWriteArrayList();
    public static final LinkedTransferQueue b = new LinkedTransferQueue();
    public static volatile boolean c = false;

    public static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        b.offer(bVar);
        if (c) {
            return;
        }
        synchronized (a.class) {
            if (c) {
                return;
            }
            c = true;
            new Thread(new A1.a(9), "APM-Monitor").start();
        }
    }
}
