package com.stepos.common.picker;

import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6542a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6543b;

    public /* synthetic */ g(Object obj, int i10) {
        this.f6542a = i10;
        this.f6543b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jNanoTime;
        int i10 = this.f6542a;
        Object obj = this.f6543b;
        switch (i10) {
            case 0:
                h hVar = (h) obj;
                if (hVar.f6547d) {
                    if (SystemClock.uptimeMillis() - hVar.f6551i <= hVar.h) {
                        Log.w("SoundPoolHelper", "play so fast, has filter this time.");
                        return;
                    }
                    hVar.f6551i = SystemClock.uptimeMillis();
                    Log.i("SoundPoolHelper", "play sound pool result:" + hVar.f6546c.play(hVar.f6548e, 1.0f, 1.0f, 0, 0, 1.0f));
                    return;
                }
                return;
            case 1:
                dd.e eVar = (dd.e) obj;
                ReentrantLock reentrantLock = eVar.f8482c;
                while (true) {
                    reentrantLock.lock();
                    try {
                        dd.a aVarC = eVar.c();
                        if (aVarC == null) {
                            return;
                        }
                        Logger logger = eVar.f8481b;
                        dd.d dVar = aVarC.f8468c;
                        kotlin.jvm.internal.g.c(dVar);
                        boolean zIsLoggable = logger.isLoggable(Level.FINE);
                        if (zIsLoggable) {
                            jNanoTime = System.nanoTime();
                            a4.a.b(logger, aVarC, dVar, "starting");
                        } else {
                            jNanoTime = -1;
                        }
                        try {
                            try {
                                dd.e.a(eVar, aVarC);
                                n nVar = n.f10413a;
                                if (zIsLoggable) {
                                    a4.a.b(logger, aVarC, dVar, "finished run in ".concat(a4.a.l(System.nanoTime() - jNanoTime)));
                                }
                            } catch (Throwable th) {
                                reentrantLock.lock();
                                try {
                                    eVar.f8480a.b(eVar, this);
                                    n nVar2 = n.f10413a;
                                    throw th;
                                } finally {
                                }
                            }
                        } finally {
                        }
                    } finally {
                    }
                }
            default:
                de.d.a((de.d) obj);
                return;
        }
    }
}
