package c7;

import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ReentrantLock reentrantLock;
        d dVarD;
        while (true) {
            try {
                b0.j jVar = d.f1148h;
                reentrantLock = d.f1150j;
                reentrantLock.lock();
                try {
                    dVarD = t1.f.d();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } catch (InterruptedException unused) {
                continue;
            }
            if (dVarD == d.f1149i) {
                d.f1149i = null;
                reentrantLock.unlock();
                return;
            } else {
                reentrantLock.unlock();
                if (dVarD != null) {
                    dVarD.l();
                }
            }
        }
    }
}
