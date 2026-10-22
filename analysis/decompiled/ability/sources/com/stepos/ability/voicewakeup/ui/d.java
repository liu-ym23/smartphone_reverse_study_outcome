package com.stepos.ability.voicewakeup.ui;

import H4.r;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1717j;
import org.libpag.PAGView;

/* loaded from: classes3.dex */
public final class d {
    public static final AtomicLong g = new AtomicLong();

    /* renamed from: a, reason: collision with root package name */
    public final PAGView f3445a;
    public boolean d;
    public c e;
    public final Handler b = new Handler(Looper.getMainLooper());
    public boolean c = true;
    public final int f = System.identityHashCode(this);

    public d(PAGView pAGView) {
        this.f3445a = pAGView;
        try {
            pAGView.pause();
            pAGView.setScaleMode(2);
        } catch (LinkageError e) {
            Log.w("WakeupPagPlayer", "PAG native dependency unavailable while initializing", e);
        } catch (RuntimeException e6) {
            Log.w("WakeupPagPlayer", "PAG error while initializing", e6);
        }
    }

    public static final void a(d dVar, S7.a aVar) {
        Looper looperMyLooper = Looper.myLooper();
        Handler handler = dVar.b;
        if (k.b(looperMyLooper, handler.getLooper())) {
            aVar.invoke();
        } else {
            handler.post(new r(1, aVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.stepos.ability.voicewakeup.ui.c r21) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.ui.d.b(com.stepos.ability.voicewakeup.ui.c):void");
    }

    public final void c(c cVar) {
        if (h(cVar)) {
            i("cancel", cVar, "");
            this.e = null;
            cVar.c = null;
            d(cVar);
            try {
                this.f3445a.pause();
            } catch (LinkageError e) {
                Log.w("WakeupPagPlayer", "PAG native dependency unavailable while cancelling playback", e);
            } catch (RuntimeException e6) {
                Log.w("WakeupPagPlayer", "PAG error while cancelling playback", e6);
            }
        }
    }

    public final void d(c cVar) {
        g(cVar);
        f(cVar);
        if (cVar.f3440r) {
            cVar.f3440r = false;
            this.f3445a.removeListener(cVar);
        }
    }

    public final void e(c cVar, boolean z10, WakeupPagPlayer$FinishReason wakeupPagPlayer$FinishReason) {
        PAGView pAGView = this.f3445a;
        if (!h(cVar) || cVar.f3439q) {
            return;
        }
        i("finish", cVar, "reason=" + wakeupPagPlayer$FinishReason + " holdLastFrame=" + z10);
        cVar.f3439q = true;
        d(cVar);
        String strConcat = "holding ".concat(cVar.f3437a.f3431a);
        try {
            pAGView.pause();
            if (z10 && cVar.o) {
                pAGView.setProgress(1.0d);
                pAGView.flush();
            } else {
                pAGView.setComposition(null);
            }
        } catch (LinkageError e) {
            Log.w("WakeupPagPlayer", "PAG native dependency unavailable while " + strConcat, e);
        } catch (RuntimeException e6) {
            Log.w("WakeupPagPlayer", "PAG error while " + strConcat, e6);
        }
        cVar.k = cVar.d;
        p(cVar);
        InterfaceC1717j interfaceC1717j = cVar.c;
        cVar.c = null;
        if (interfaceC1717j == null || !interfaceC1717j.isActive()) {
            return;
        }
        interfaceC1717j.resumeWith(C7.r.f317a);
    }

    public final void f(c cVar) {
        this.b.removeCallbacks(cVar.n);
        if (cVar.m) {
            long jUptimeMillis = SystemClock.uptimeMillis() - cVar.l;
            if (jUptimeMillis < 0) {
                jUptimeMillis = 0;
            }
            long j5 = cVar.k - jUptimeMillis;
            cVar.k = j5 >= 0 ? j5 : 0L;
            cVar.m = false;
        }
    }

    public final void g(c cVar) {
        this.b.removeCallbacks(cVar.f3443v);
        if (cVar.u) {
            long jUptimeMillis = SystemClock.uptimeMillis() - cVar.f3442t;
            if (jUptimeMillis < 0) {
                jUptimeMillis = 0;
            }
            long j5 = cVar.f3441s - jUptimeMillis;
            cVar.f3441s = j5 >= 0 ? j5 : 0L;
            cVar.u = false;
        }
    }

    public final boolean h(c cVar) {
        return !this.d && this.e == cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.lang.String r31, com.stepos.ability.voicewakeup.ui.c r32, java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.ui.d.i(java.lang.String, com.stepos.ability.voicewakeup.ui.c, java.lang.String):void");
    }

    public final void j() {
        if (this.d || this.c) {
            return;
        }
        this.c = true;
        c cVar = this.e;
        if (cVar != null) {
            g(cVar);
            f(cVar);
            i("pause", cVar, "");
        }
        try {
            this.f3445a.pause();
        } catch (LinkageError e) {
            Log.w("WakeupPagPlayer", "PAG native dependency unavailable while pausing", e);
        } catch (RuntimeException e6) {
            Log.w("WakeupPagPlayer", "PAG error while pausing", e6);
        }
    }

    public final void k(WakeupPagAnimation wakeupPagAnimation) {
        if (this.d) {
            return;
        }
        c cVar = this.e;
        if ((cVar != null ? cVar.f3437a : null) == wakeupPagAnimation && cVar.b == WakeupPagPlayer$Mode.f3433a && !cVar.f3439q) {
            return;
        }
        b(new c(this, wakeupPagAnimation, WakeupPagPlayer$Mode.f3433a, null, 0L, 12));
    }

    public final void l() {
        WakeupPagAnimation wakeupPagAnimation = WakeupPagAnimation.f;
        if (this.d) {
            return;
        }
        c cVar = this.e;
        if ((cVar != null ? cVar.f3437a : null) == wakeupPagAnimation && cVar.b == WakeupPagPlayer$Mode.c && cVar.d == 2000) {
            return;
        }
        b(new c(this, wakeupPagAnimation, WakeupPagPlayer$Mode.c, null, 2000L, 4));
    }

    public final Object m(WakeupPagAnimation wakeupPagAnimation, H7.c cVar) throws Throwable {
        u9.d dVar = AbstractC1691I.f5315a;
        Object objW = AbstractC1683A.w(s9.k.f6003a.d, new WakeupPagPlayer$playOnceAndAwait$2(this, wakeupPagAnimation, null), cVar);
        return objW == CoroutineSingletons.f4909a ? objW : C7.r.f317a;
    }

    public final void n() {
        PAGView pAGView = this.f3445a;
        if (this.d) {
            return;
        }
        this.d = true;
        this.c = true;
        c cVar = this.e;
        if (cVar != null) {
            i("release", cVar, "");
        }
        this.e = null;
        if (cVar != null) {
            d(cVar);
        }
        try {
            pAGView.pause();
        } catch (LinkageError e) {
            Log.w("WakeupPagPlayer", "PAG native dependency unavailable while stopping for release", e);
        } catch (RuntimeException e6) {
            Log.w("WakeupPagPlayer", "PAG error while stopping for release", e6);
        }
        try {
            pAGView.setComposition(null);
        } catch (LinkageError e9) {
            Log.w("WakeupPagPlayer", "PAG native dependency unavailable while releasing composition", e9);
        } catch (RuntimeException e10) {
            Log.w("WakeupPagPlayer", "PAG error while releasing composition", e10);
        }
        try {
            pAGView.freeCache();
        } catch (LinkageError e11) {
            Log.w("WakeupPagPlayer", "PAG native dependency unavailable while releasing render cache", e11);
        } catch (RuntimeException e12) {
            Log.w("WakeupPagPlayer", "PAG error while releasing render cache", e12);
        }
        InterfaceC1717j interfaceC1717j = cVar != null ? cVar.c : null;
        if (cVar != null) {
            cVar.c = null;
        }
        if (interfaceC1717j != null) {
            interfaceC1717j.l(new CancellationException("PAG player released"));
        }
    }

    public final void o() {
        if (this.d || !this.c) {
            return;
        }
        this.c = false;
        c cVar = this.e;
        if (cVar != null) {
            i("resume", cVar, "");
            q(cVar);
        }
    }

    public final void p(c cVar) {
        if (h(cVar) && !this.c && cVar.f3439q && cVar.b == WakeupPagPlayer$Mode.c && !cVar.m) {
            cVar.l = SystemClock.uptimeMillis();
            cVar.m = true;
            i("replay_scheduled", cVar, androidx.compose.foundation.b.p(cVar.k, "delayMs="));
            this.b.postDelayed(cVar.n, cVar.k);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0056 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(com.stepos.ability.voicewakeup.ui.c r11) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.ui.d.q(com.stepos.ability.voicewakeup.ui.c):void");
    }
}
