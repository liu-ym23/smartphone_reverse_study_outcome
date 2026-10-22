package db;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.view.MotionEvent;
import d7.b0;
import e7.j;
import f8.x;
import g3.k;
import j1.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3028f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f3029g;

    public /* synthetic */ d(int i2, Object obj) {
        this.f3028f = i2;
        this.f3029g = obj;
    }

    public j a() throws IOException {
        k kVar = (k) this.f3029g;
        j jVar = new j();
        Cursor cursorM = kVar.f3811a.m(new x("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
        while (cursorM.moveToNext()) {
            try {
                jVar.add(Integer.valueOf(cursorM.getInt(0)));
            } finally {
            }
        }
        cursorM.close();
        j jVarI = ib.k.i(jVar);
        if (jVarI.f3117f.isEmpty()) {
            return jVarI;
        }
        if (((k) this.f3029g).f3817g == null) {
            throw new IllegalStateException("Required value was null.");
        }
        n3.j jVar2 = ((k) this.f3029g).f3817g;
        if (jVar2 == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        jVar2.b();
        return jVarI;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVarC;
        long jNanoTime;
        Set setA;
        switch (this.f3028f) {
            case 0:
                break;
            case 1:
                ReentrantReadWriteLock.ReadLock lock = ((k) this.f3029g).f3811a.f2673h.readLock();
                q7.k.d(lock, "readWriteLock.readLock()");
                lock.lock();
                try {
                    try {
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                } catch (SQLiteException e10) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
                    setA = b0.f2947f;
                } catch (IllegalStateException e11) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e11);
                    setA = b0.f2947f;
                }
                if (((k) this.f3029g).a() && ((k) this.f3029g).f3815e.compareAndSet(true, false) && !((k) this.f3029g).f3811a.h().N().i()) {
                    n3.c cVarN = ((k) this.f3029g).f3811a.h().N();
                    cVarN.b();
                    try {
                        setA = a();
                        cVarN.q();
                        lock.unlock();
                        if (setA.isEmpty()) {
                            return;
                        }
                        k kVar = (k) this.f3029g;
                        synchronized (kVar.f3819i) {
                            Iterator it = kVar.f3819i.iterator();
                            while (true) {
                                j.b bVar = (j.b) it;
                                if (bVar.hasNext()) {
                                    ((g3.j) ((Map.Entry) bVar.next()).getValue()).a(setA);
                                }
                            }
                        }
                        return;
                    } finally {
                        cVarN.e();
                    }
                }
                lock.unlock();
                return;
            default:
                y yVar = (y) this.f3029g;
                yVar.removeCallbacks(this);
                MotionEvent motionEvent = yVar.f5385u0;
                if (motionEvent != null) {
                    boolean z4 = motionEvent.getToolType(0) == 3;
                    int actionMasked = motionEvent.getActionMasked();
                    if (z4) {
                        if (actionMasked == 10 || actionMasked == 1) {
                            return;
                        }
                    } else if (actionMasked == 1) {
                        return;
                    }
                    int i2 = 7;
                    if (actionMasked != 7 && actionMasked != 9) {
                        i2 = 2;
                    }
                    y yVar2 = (y) this.f3029g;
                    yVar2.D(motionEvent, i2, yVar2.f5387v0, false);
                    return;
                }
                return;
        }
        while (true) {
            e eVar = (e) this.f3029g;
            synchronized (eVar) {
                aVarC = eVar.c();
            }
            if (aVarC == null) {
                return;
            }
            c cVar = aVarC.f3018c;
            q7.k.b(cVar);
            e eVar2 = (e) this.f3029g;
            boolean zIsLoggable = e.f3031i.isLoggable(Level.FINE);
            if (zIsLoggable) {
                jNanoTime = System.nanoTime();
                ib.c.d(aVarC, cVar, "starting");
            } else {
                jNanoTime = -1;
            }
            try {
                e.a(eVar2, aVarC);
                if (zIsLoggable) {
                    ib.c.d(aVarC, cVar, "finished run in ".concat(ib.c.z(System.nanoTime() - jNanoTime)));
                }
            } finally {
            }
        }
    }
}
