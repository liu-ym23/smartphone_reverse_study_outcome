package com.stepos.ability.voicewakeup.service;

import H4.r;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.util.Log;
import com.stepos.ability.IVoiceWakeupCallback;
import com.stepos.ability.voicewakeup.service.RebuildScheduler;
import com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel;
import fa.C1449a;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Result;

/* loaded from: classes3.dex */
public final class l {
    public static volatile Thread d;
    public static volatile b f;
    public static volatile androidx.compose.ui.text.d g;
    public static volatile boolean h;
    public static volatile int i;

    /* renamed from: j, reason: collision with root package name */
    public static volatile boolean f3334j;
    public static final Object k;
    public static final CopyOnWriteArrayList l;
    public static WakeupEngine m;
    public static Context n;
    public static E4.e o;
    public static C4.a p;

    /* renamed from: q, reason: collision with root package name */
    public static int f3335q;

    /* renamed from: r, reason: collision with root package name */
    public static final HashMap f3336r;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f3337s;

    /* renamed from: t, reason: collision with root package name */
    public static int f3338t;
    public static int u;

    /* renamed from: v, reason: collision with root package name */
    public static RebuildScheduler.Cancellable f3339v;

    /* renamed from: w, reason: collision with root package name */
    public static boolean f3340w;

    /* renamed from: x, reason: collision with root package name */
    public static final RemoteCallbackList f3341x;

    /* renamed from: a, reason: collision with root package name */
    public static final l f3333a = new l();
    public static final long[] b = {2000, 4000, FullScreenActivityViewModel.OVERLAY_RESUME_FALLBACK_MS, 16000, 30000, 30000};
    public static final ExecutorService c = Executors.newSingleThreadExecutor(new A4.b(8));
    public static volatile com.bumptech.glide.load.resource.bitmap.b e = o.f3342a;

    static {
        b bVar = new b();
        androidx.compose.ui.text.d dVar = new androidx.compose.ui.text.d(16);
        f = bVar;
        g = dVar;
        k = new Object();
        l = new CopyOnWriteArrayList();
        f3336r = new HashMap();
        u = -1;
        f3341x = new RemoteCallbackList();
    }

    public static boolean a(int i6) {
        k kVarG = g();
        return kVarG.f3332a && kVarG.b == i6 && k();
    }

    public static void b(k kVar, String str) {
        int i6;
        int i10 = kVar.b;
        if (f3337s && (i6 = u) != i10) {
            c(i6);
        }
        if (!kVar.f3332a || !f()) {
            Log.i("VoiceWakeupController", str.concat(": skip rebuild (not desired)"));
            return;
        }
        if (!f3337s || u != i10) {
            f3337s = true;
            f3338t = 0;
            u = i10;
            p(i10);
            return;
        }
        Log.i("VoiceWakeupController", str + ": retry already active gen=" + i10);
    }

    public static void c(int i6) {
        if (f3337s && u == i6) {
            RebuildScheduler.Cancellable cancellable = f3339v;
            if (cancellable != null) {
                cancellable.cancel();
            }
            f3339v = null;
            f3337s = false;
            f3338t = 0;
            u = -1;
        }
    }

    public static void d() {
        Context context = n;
        if (context == null) {
            return;
        }
        Log.w("VoiceWakeupController", "dispatchError: notifying STATE_ERROR");
        RemoteCallbackList remoteCallbackList = f3341x;
        int iBeginBroadcast = remoteCallbackList.beginBroadcast();
        for (int i6 = 0; i6 < iBeginBroadcast; i6++) {
            try {
                ((IVoiceWakeupCallback) remoteCallbackList.getBroadcastItem(i6)).onStateChanged(2);
            } catch (Throwable th) {
                kotlin.b.a(th);
            }
        }
        remoteCallbackList.finishBroadcast();
        Intent intentPutExtra = new Intent("com.stepos.ability.voicewakeup.ACTION_STATE_CHANGED").putExtra("state", 2);
        kotlin.jvm.internal.k.e(intentPutExtra, "putExtra(...)");
        q(context, intentPutExtra);
    }

    public static C1449a e() {
        Context context = n;
        if (context == null) {
            throw new IllegalStateException("not initialized");
        }
        E4.e eVar = o;
        if (eVar != null) {
            return new C1449a(context, eVar);
        }
        throw new IllegalStateException("not initialized");
    }

    public static boolean f() {
        Object objA;
        try {
            objA = Boolean.valueOf(k() && ((E4.e) e().c).b());
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public static k g() {
        k kVar;
        synchronized (k) {
            kVar = new k(h, i);
        }
        return kVar;
    }

    public static boolean h(int i6) {
        if (!f3337s || u != i6) {
            return false;
        }
        k kVarG = g();
        return kVarG.f3332a && kVarG.b == i6;
    }

    public static boolean i() {
        return kotlin.jvm.internal.k.b(Looper.myLooper(), Looper.getMainLooper());
    }

    public static void j(WakeupEngine wakeupEngine, String str) {
        if (m != wakeupEngine) {
            Log.i("VoiceWakeupController", "onEngineLost: ignore stale engine reason=" + str);
            return;
        }
        f3334j = false;
        m();
        k kVarG = g();
        Log.w("VoiceWakeupController", "onEngineLost: reason=" + str + " gen=" + kVarG.b);
        b(kVarG, "onEngineLost");
    }

    public static boolean k() {
        if (f3335q != 0) {
            return false;
        }
        C4.a aVar = p;
        return (aVar == null || aVar.isEnabled()) && e().isEnabled();
    }

    public static void m() {
        WakeupEngine wakeupEngine = m;
        m = null;
        f3336r.clear();
        f3334j = false;
        if (wakeupEngine != null) {
            try {
                wakeupEngine.release();
            } catch (Throwable th) {
                kotlin.b.a(th);
            }
        }
    }

    public static void o(boolean z10, S7.a aVar) {
        if (Thread.currentThread() == d) {
            aVar.invoke();
            return;
        }
        r rVar = new r(5, aVar);
        if (z10) {
            c.submit(rVar).get();
        } else {
            c.execute(rVar);
        }
    }

    public static void p(int i6) {
        if (h(i6)) {
            long[] jArr = b;
            int i10 = f3338t;
            long j5 = (i10 < 0 || i10 >= 6) ? jArr[5] : jArr[i10];
            Log.i("VoiceWakeupController", "scheduleRebuild: attempt=" + (i10 + 1) + "/6 backoff=" + j5 + "ms gen=" + i6);
            f3339v = f.schedule(j5, new h(i6, 0));
        }
    }

    public static void q(Context context, Intent intent) {
        intent.setPackage("com.stepos.ailauncher");
        if (Build.VERSION.SDK_INT >= 34) {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        } else {
            context.sendBroadcastAsUser(intent, Process.myUserHandle());
        }
    }

    public static void s(WakeupEngine wakeupEngine, boolean z10) {
        if (wakeupEngine == null || m == wakeupEngine) {
            m();
        } else {
            try {
                wakeupEngine.release();
            } catch (Throwable th) {
                kotlin.b.a(th);
            }
        }
        if (z10) {
            d();
        }
    }

    public static void t() {
        if (n == null) {
            return;
        }
        v(true);
        o(true ^ i(), new P3.d(29));
    }

    public static void u() {
        v(false);
        o(!i(), new P3.d(28));
    }

    public static k v(boolean z10) {
        k kVar;
        synchronized (k) {
            h = z10;
            i++;
            kVar = new k(h, i);
        }
        return kVar;
    }

    public static k w(int i6, boolean z10) {
        k kVar;
        synchronized (k) {
            try {
                if (i == i6) {
                    h = z10;
                    i++;
                }
                kVar = new k(h, i);
            } catch (Throwable th) {
                throw th;
            }
        }
        return kVar;
    }

    public final void l() {
        while (true) {
            k kVarG = g();
            if (kVarG.f3332a && !k()) {
                kVarG = w(kVarG.b, false);
                if (kVarG.f3332a) {
                    continue;
                }
            }
            if (!kVarG.f3332a) {
                c(u);
                m();
                return;
            }
            boolean z10 = f3334j;
            boolean z11 = kVarG.f3332a;
            if (z10 == z11) {
                return;
            }
            if (!z11) {
                m();
            } else if (!r(false)) {
                if (f3340w) {
                    Log.i("VoiceWakeupController", "pump: no loadable words, settle as not-running");
                    return;
                }
                k kVarG2 = g();
                if (kVarG2.f3332a) {
                    b(kVarG2, "pump");
                    return;
                }
                return;
            }
        }
    }

    public final void n(WakeupEngine wakeupEngine, String str) {
        Object objA;
        if (m != wakeupEngine) {
            return;
        }
        if (!g().f3332a || !k()) {
            l();
            return;
        }
        try {
            objA = Integer.valueOf(wakeupEngine.restart(str));
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (Result.a(objA) != null) {
            objA = Integer.MIN_VALUE;
        }
        if (((Number) objA).intValue() == 0) {
            f3336r.put(str, Boolean.FALSE);
            return;
        }
        j(wakeupEngine, "restartFailed:" + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x01a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0199  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(boolean r21) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.service.l.r(boolean):boolean");
    }
}
