package ob;

import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class c extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ReentrantLock reentrantLock;
        f fVarF;
        while (true) {
            try {
                ReentrantLock reentrantLock2 = f.f7967h;
                reentrantLock = f.f7967h;
                reentrantLock.lock();
                try {
                    fVarF = h4.n.f();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } catch (InterruptedException unused) {
                continue;
            }
            if (fVarF == f.f7971l) {
                f.f7971l = null;
                reentrantLock.unlock();
                return;
            } else {
                reentrantLock.unlock();
                if (fVarF != null) {
                    fVarF.k();
                }
            }
        }
    }
}
