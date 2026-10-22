package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.room.f;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.EmptySet;
import kotlin.collections.builders.SetBuilder;
import mb.y;
import n.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f2561a;

    public g(f fVar) {
        this.f2561a = fVar;
    }

    public final SetBuilder a() throws IOException {
        f fVar = this.f2561a;
        SetBuilder setBuilder = new SetBuilder();
        Cursor cursorM = fVar.f2540a.m(new y1.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
        while (cursorM.moveToNext()) {
            try {
                setBuilder.add(Integer.valueOf(cursorM.getInt(0)));
            } finally {
            }
        }
        lb.n nVar = lb.n.f10413a;
        cursorM.close();
        SetBuilder setBuilderJ = y.j(setBuilder);
        if (setBuilderJ.f10050a.isEmpty()) {
            return setBuilderJ;
        }
        if (this.f2561a.h == null) {
            throw new IllegalStateException("Required value was null.");
        }
        y1.f fVar2 = this.f2561a.h;
        if (fVar2 == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        fVar2.r();
        return setBuilderJ;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Set<Integer> setA;
        ReentrantReadWriteLock.ReadLock lock = this.f2561a.f2540a.h.readLock();
        kotlin.jvm.internal.g.e(lock, "readWriteLock.readLock()");
        lock.lock();
        try {
            try {
                try {
                } catch (SQLiteException e10) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
                    setA = EmptySet.f10003a;
                }
            } catch (IllegalStateException e11) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e11);
                setA = EmptySet.f10003a;
            }
            if (this.f2561a.a()) {
                if (this.f2561a.f2545f.compareAndSet(true, false)) {
                    if (this.f2561a.f2540a.h().n0().w0()) {
                        return;
                    }
                    y1.b bVarN0 = this.f2561a.f2540a.h().n0();
                    bVarN0.A();
                    try {
                        setA = a();
                        bVarN0.y();
                        if (setA.isEmpty()) {
                            return;
                        }
                        f fVar = this.f2561a;
                        synchronized (fVar.f2548j) {
                            try {
                                Iterator<Map.Entry<f.c, f.d>> it = fVar.f2548j.iterator();
                                while (true) {
                                    b.e eVar = (b.e) it;
                                    if (eVar.hasNext()) {
                                        ((f.d) ((Map.Entry) eVar.next()).getValue()).a(setA);
                                    } else {
                                        lb.n nVar = lb.n.f10413a;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } finally {
                        bVarN0.H();
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
