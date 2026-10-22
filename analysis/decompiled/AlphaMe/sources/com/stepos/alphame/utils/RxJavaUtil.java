package com.stepos.alphame.utils;

import A3.d;
import A3.h;
import A3.q;
import B3.k;
import android.util.Log;
import h3.C0611u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import x3.e;
import y3.c;

/* loaded from: classes.dex */
public class RxJavaUtil {
    public static final String TAG = "RxJavaUtil";

    public static void postDelayRunOnSingleThread(long j4, x3.b bVar) {
        F3.a aVar;
        k kVar = new k(0);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        while (true) {
            AtomicReference atomicReference = F3.a.f455d;
            aVar = (F3.a) atomicReference.get();
            if (aVar != null) {
                break;
            }
            aVar = new F3.a();
            if (atomicReference.compareAndSet(null, aVar)) {
                break;
            }
            synchronized (aVar) {
                try {
                    h hVar = aVar.f456a;
                    if (hVar instanceof q) {
                        hVar.a();
                    }
                    d dVar = aVar.f457b;
                    if (dVar instanceof q) {
                        dVar.a();
                    }
                    Object obj = aVar.f458c;
                    if (obj instanceof q) {
                        ((q) obj).a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        t3.a cVar = new c(kVar.f15443a, new y3.h(j4, timeUnit, aVar.f456a), 0);
        C0611u c0611u = E3.c.f413b;
        if (c0611u != null) {
            cVar = (t3.a) c0611u.call(cVar);
        }
        new t3.c(cVar).a(WorkerScheduler.SINGLE).b(bVar, new x3.b() { // from class: com.stepos.alphame.utils.RxJavaUtil.5
            @Override // x3.b
            public void call(Throwable th2) {
                Log.w(RxJavaUtil.TAG, "postDelayRunOnSingleThread", th2);
            }
        });
    }

    public static <T, R> t3.h postOnIoObserveOnMain(T t4, e eVar, x3.b bVar, x3.b bVar2) {
        t3.a cVar = new c(new k(t4), eVar, 1);
        C0611u c0611u = E3.c.f413b;
        if (c0611u != null) {
            cVar = (t3.a) c0611u.call(cVar);
        }
        t3.c cVarA = new t3.c(cVar).c(WorkerScheduler.IO).a(WorkerScheduler.ANDROID_MAIN);
        if (bVar2 == null) {
            bVar2 = new x3.b() { // from class: com.stepos.alphame.utils.RxJavaUtil.11
                @Override // x3.b
                public void call(Throwable th) {
                    Log.w(RxJavaUtil.TAG, "postRunOnIoObserveOnMain", th);
                }
            };
        }
        return cVarA.b(bVar, bVar2);
    }

    public static void postRunOnCardThread(x3.b bVar) {
        new k(0).a(WorkerScheduler.CARDS_MAIN).b(bVar, new x3.b() { // from class: com.stepos.alphame.utils.RxJavaUtil.6
            @Override // x3.b
            public void call(Throwable th) {
                Log.w(RxJavaUtil.TAG, "postRunOnCardThread", th);
            }
        });
    }

    public static void postRunOnIOThread(x3.b bVar) {
        new k(0).a(WorkerScheduler.IO).b(bVar, new x3.b() { // from class: com.stepos.alphame.utils.RxJavaUtil.2
            @Override // x3.b
            public void call(Throwable th) {
                Log.w(RxJavaUtil.TAG, "postRunOnIOThread", th);
            }
        });
    }

    public static void postRunOnIoObserveOnCard(e eVar, x3.b bVar) {
        t3.a cVar = new c(new k(0), eVar, 1);
        C0611u c0611u = E3.c.f413b;
        if (c0611u != null) {
            cVar = (t3.a) c0611u.call(cVar);
        }
        new t3.c(cVar).c(WorkerScheduler.IO).a(WorkerScheduler.CARDS_MAIN).b(bVar, new x3.b() { // from class: com.stepos.alphame.utils.RxJavaUtil.8
            @Override // x3.b
            public void call(Throwable th) {
                Log.w(RxJavaUtil.TAG, "postRunOnIoObserveOnCard", th);
            }
        });
    }

    public static void postRunOnIoObserveOnMain(e eVar, x3.b bVar) {
        t3.a cVar = new c(new k(0), eVar, 1);
        C0611u c0611u = E3.c.f413b;
        if (c0611u != null) {
            cVar = (t3.a) c0611u.call(cVar);
        }
        new t3.c(cVar).c(WorkerScheduler.IO).a(WorkerScheduler.ANDROID_MAIN).b(bVar, new x3.b() { // from class: com.stepos.alphame.utils.RxJavaUtil.9
            @Override // x3.b
            public void call(Throwable th) {
                Log.w(RxJavaUtil.TAG, "postRunOnIoObserveOnMain", th);
            }
        });
    }

    public static void postRunOnMainThread(x3.b bVar) {
        new k(0).a(WorkerScheduler.ANDROID_MAIN).b(bVar, new x3.b() { // from class: com.stepos.alphame.utils.RxJavaUtil.1
            @Override // x3.b
            public void call(Throwable th) {
                Log.w(RxJavaUtil.TAG, "postRunOnMainThread", th);
            }
        });
    }

    public static void postRunOnSingleObserveOnCard(e eVar, x3.b bVar) {
        t3.a cVar = new c(new k(0), eVar, 1);
        C0611u c0611u = E3.c.f413b;
        if (c0611u != null) {
            cVar = (t3.a) c0611u.call(cVar);
        }
        new t3.c(cVar).c(WorkerScheduler.SINGLE).a(WorkerScheduler.CARDS_MAIN).b(bVar, new x3.b() { // from class: com.stepos.alphame.utils.RxJavaUtil.7
            @Override // x3.b
            public void call(Throwable th) {
                Log.w(RxJavaUtil.TAG, "postRunOnSingleObserveOnCard", th);
            }
        });
    }

    public static void postRunOnSingleObserveOnMain(e eVar, x3.b bVar) {
        t3.a cVar = new c(new k(0), eVar, 1);
        C0611u c0611u = E3.c.f413b;
        if (c0611u != null) {
            cVar = (t3.a) c0611u.call(cVar);
        }
        new t3.c(cVar).c(WorkerScheduler.SINGLE).a(WorkerScheduler.ANDROID_MAIN).b(bVar, new x3.b() { // from class: com.stepos.alphame.utils.RxJavaUtil.10
            @Override // x3.b
            public void call(Throwable th) {
                Log.w(RxJavaUtil.TAG, "postRunOnIoObserveOnMain", th);
            }
        });
    }

    public static void postRunOnSingleThread(x3.b bVar) {
        new k(0).a(WorkerScheduler.SINGLE).b(bVar, new x3.b() { // from class: com.stepos.alphame.utils.RxJavaUtil.4
            @Override // x3.b
            public void call(Throwable th) {
                Log.e(RxJavaUtil.TAG, "postRunOnSingleThread", th);
            }
        });
    }

    public static <T> void postRunOnSingleThread(T t4, x3.b bVar) {
        new k(t4).a(WorkerScheduler.SINGLE).b(bVar, new x3.b() { // from class: com.stepos.alphame.utils.RxJavaUtil.3
            @Override // x3.b
            public void call(Throwable th) {
                Log.e(RxJavaUtil.TAG, "postRunOnSingleThread", th);
            }
        });
    }
}
