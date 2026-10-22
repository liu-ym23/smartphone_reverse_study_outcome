package d6;

import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.base.health.EngineMetrics;
import com.stepos.base.model.ReleaseReason;
import com.stepos.core.ability.h;
import com.stepos.core.callback.IReleaseCallback;
import com.stepos.core.common.cloud.d;
import h0.e;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f8388a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, CopyOnWriteArraySet<IReleaseCallback>> f8389b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f8390c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap.KeySetView<String, Boolean> f8391d = ConcurrentHashMap.newKeySet();

    public static void a(String modelId, ReleaseReason reason, Set affectedUids) {
        Object objA;
        g.f(modelId, "modelId");
        g.f(reason, "reason");
        g.f(affectedUids, "affectedUids");
        int iOrdinal = reason.ordinal();
        int i10 = reason.f6342a;
        if (iOrdinal != 0 && iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 3) {
            throw new NoWhenBranchMatchedException();
        }
        ReleaseReason releaseReason = ReleaseReason.f6338b;
        if (reason != releaseReason) {
            f8391d.add(modelId);
        }
        if (reason == releaseReason) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ConcurrentHashMap<String, Long> concurrentHashMap = f8390c;
            Long l10 = concurrentHashMap.get(modelId);
            if (jElapsedRealtime - (l10 != null ? l10.longValue() : 0L) < 100) {
                EngineMetrics.f6235k.incrementAndGet();
                return;
            }
            concurrentHashMap.put(modelId, Long.valueOf(jElapsedRealtime));
        }
        if (affectedUids.isEmpty()) {
            return;
        }
        String strName = reason.name();
        Iterator it = affectedUids.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            CopyOnWriteArraySet<IReleaseCallback> copyOnWriteArraySet = f8389b.get(Integer.valueOf(iIntValue));
            if (copyOnWriteArraySet != null) {
                for (IReleaseCallback iReleaseCallback : copyOnWriteArraySet) {
                    try {
                        iReleaseCallback.onReleased(modelId, i10, strName);
                        objA = n.f10413a;
                    } catch (Throwable th) {
                        objA = kotlin.c.a(th);
                    }
                    Throwable thB = Result.b(objA);
                    if (thB != null) {
                        EngineMetrics.f6236l.incrementAndGet();
                        String message = thB.getMessage();
                        StringBuilder sbE = e.e("notify uid=", iIntValue, " modelId=", modelId, " failed: ");
                        sbE.append(message);
                        Log.w("ReleaseNotifier", sbE.toString());
                        if (thB instanceof DeadObjectException) {
                            g.c(iReleaseCallback);
                            f8388a.getClass();
                            c(iReleaseCallback, iIntValue);
                        }
                    }
                }
            }
        }
        EngineMetrics.f6234j.incrementAndGet();
    }

    public static void c(IReleaseCallback cb2, int i10) {
        g.f(cb2, "cb");
        Integer numValueOf = Integer.valueOf(i10);
        ConcurrentHashMap<Integer, CopyOnWriteArraySet<IReleaseCallback>> concurrentHashMap = f8389b;
        CopyOnWriteArraySet<IReleaseCallback> copyOnWriteArraySet = concurrentHashMap.get(numValueOf);
        if (copyOnWriteArraySet == null) {
            return;
        }
        copyOnWriteArraySet.remove(cb2);
        if (copyOnWriteArraySet.isEmpty()) {
            concurrentHashMap.remove(Integer.valueOf(i10), copyOnWriteArraySet);
        }
    }

    public final void b(final IReleaseCallback iReleaseCallback, final int i10) {
        Object objA;
        f8389b.computeIfAbsent(Integer.valueOf(i10), new h(new d(24), 4)).add(iReleaseCallback);
        try {
            iReleaseCallback.asBinder().linkToDeath(new IBinder.DeathRecipient(this) { // from class: d6.b
                @Override // android.os.IBinder.DeathRecipient
                public final void binderDied() {
                    c.c(iReleaseCallback, i10);
                }
            }, 0);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            a0.a.u("linkToDeath failed for uid=", i10, ": ", thB.getMessage(), "ReleaseNotifier");
            f8388a.getClass();
            c(iReleaseCallback, i10);
        }
    }
}
