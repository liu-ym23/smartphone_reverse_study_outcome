package bua;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f20752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<c> f20753b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20754a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f20754a.getClass();     // Catch: Throwable -> L4
            this.f20754a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100) {
            this.f20754a = r100;
        }
    }

    /* JADX INFO: renamed from: bua.b$b, reason: collision with other inner class name */
    public static class C0362b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f20755a = null;

        static {
            f20755a = new b();
        }
    }

    public b() {
        new ArrayList();
        this.f20752a = new ReentrantReadWriteLock();
        this.f20753b = new LinkedList();
        new a(this);
    }

    public final List a(int r100) {
        if (this.f20753b.isEmpty() == true) goto L15;
        ArrayList r101 = new ArrayList();
        if (this.f20753b.isEmpty() == true) goto L16;
        this.f20752a.readLock().lock();
        int r102 = Math.min(r100, this.f20753b.size());     // Catch: Throwable -> L12
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L11;
        r101.add(this.f20753b.get(r103));     // Catch: Throwable -> L12
        r103 = r103 + 1;
        goto L8
    L11:
        this.f20752a.readLock().unlock();
    L12:
        th = move-exception;
        this.f20752a.readLock().unlock();
        throw th;
    L16:
        int r104 = bua.a.f20751a;
        return r101;
    L15:
        r101 = null;
        goto L16
    }
}
