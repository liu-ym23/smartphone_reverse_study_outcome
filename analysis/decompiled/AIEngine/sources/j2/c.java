package j2;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.WorkInfo$State;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.a;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import h2.j;
import i2.h;
import i2.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlinx.coroutines.Job;
import mb.y;
import o2.n;
import q2.k;
import q2.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements h, m2.c, i2.b {
    public static final String r = j.f("GreedyScheduler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f9664a;

    /* renamed from: c, reason: collision with root package name */
    public final b f9666c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9667d;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.work.impl.a f9669j;

    /* renamed from: k, reason: collision with root package name */
    public final s f9670k;

    /* renamed from: l, reason: collision with root package name */
    public final androidx.work.a f9671l;

    /* renamed from: n, reason: collision with root package name */
    public Boolean f9673n;

    /* renamed from: o, reason: collision with root package name */
    public final WorkConstraintsTracker f9674o;

    /* renamed from: p, reason: collision with root package name */
    public final s2.b f9675p;

    /* renamed from: q, reason: collision with root package name */
    public final d f9676q;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f9665b = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final Object f9668e = new Object();
    public final androidx.preference.c h = new androidx.preference.c(new stepos.support.v7.app.palette.b(9));

    /* renamed from: m, reason: collision with root package name */
    public final HashMap f9672m = new HashMap();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f9677a;

        /* renamed from: b, reason: collision with root package name */
        public final long f9678b;

        public a(int i10, long j10) {
            this.f9677a = i10;
            this.f9678b = j10;
        }
    }

    public c(Context context, androidx.work.a aVar, n nVar, androidx.work.impl.a aVar2, s sVar, s2.b bVar) {
        this.f9664a = context;
        androidx.lifecycle.b bVar2 = aVar.f2820g;
        this.f9666c = new b(this, bVar2, aVar.f2817d);
        this.f9676q = new d(bVar2, sVar);
        this.f9675p = bVar;
        this.f9674o = new WorkConstraintsTracker(nVar);
        this.f9671l = aVar;
        this.f9669j = aVar2;
        this.f9670k = sVar;
    }

    @Override // i2.b
    public final void a(k kVar, boolean z) {
        Job job;
        i2.k kVarM = this.h.m(kVar);
        if (kVarM != null) {
            this.f9676q.a(kVarM);
        }
        synchronized (this.f9668e) {
            job = (Job) this.f9665b.remove(kVar);
        }
        if (job != null) {
            j.d().a(r, "Stopping tracking for " + kVar);
            job.cancel(null);
        }
        if (z) {
            return;
        }
        synchronized (this.f9668e) {
            this.f9672m.remove(kVar);
        }
    }

    @Override // m2.c
    public final void b(p pVar, androidx.work.impl.constraints.a aVar) {
        k kVarT = y.t(pVar);
        boolean z = aVar instanceof a.C0024a;
        s sVar = this.f9670k;
        d dVar = this.f9676q;
        String str = r;
        androidx.preference.c cVar = this.h;
        if (z) {
            if (cVar.h(kVarT)) {
                return;
            }
            j.d().a(str, "Constraints met: Scheduling work ID " + kVarT);
            i2.k kVarP = cVar.p(kVarT);
            dVar.b(kVarP);
            sVar.c(kVarP, null);
            return;
        }
        j.d().a(str, "Constraints not met: Cancelling work ID " + kVarT);
        i2.k kVarM = cVar.m(kVarT);
        if (kVarM != null) {
            dVar.a(kVarM);
            sVar.b(kVarM, ((a.b) aVar).f2929a);
        }
    }

    @Override // i2.h
    public final void c(p... pVarArr) {
        long jMax;
        if (this.f9673n == null) {
            this.f9673n = Boolean.valueOf(r2.j.a(this.f9664a, this.f9671l));
        }
        if (!this.f9673n.booleanValue()) {
            j.d().e(r, "Ignoring schedule request in a secondary process");
            return;
        }
        if (!this.f9667d) {
            this.f9669j.a(this);
            this.f9667d = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (p pVar : pVarArr) {
            if (!this.h.h(y.t(pVar))) {
                synchronized (this.f9668e) {
                    try {
                        k kVarT = y.t(pVar);
                        a aVar = (a) this.f9672m.get(kVarT);
                        if (aVar == null) {
                            int i10 = pVar.f11514k;
                            this.f9671l.f2817d.getClass();
                            aVar = new a(i10, System.currentTimeMillis());
                            this.f9672m.put(kVarT, aVar);
                        }
                        jMax = (Math.max((pVar.f11514k - aVar.f9677a) - 5, 0) * AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS) + aVar.f9678b;
                    } finally {
                    }
                }
                long jMax2 = Math.max(pVar.a(), jMax);
                this.f9671l.f2817d.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (pVar.f11506b == WorkInfo$State.f2792a) {
                    if (jCurrentTimeMillis < jMax2) {
                        b bVar = this.f9666c;
                        if (bVar != null) {
                            androidx.lifecycle.b bVar2 = bVar.f9661b;
                            HashMap map = bVar.f9663d;
                            Runnable runnable = (Runnable) map.remove(pVar.f11505a);
                            if (runnable != null) {
                                bVar2.a(runnable);
                            }
                            j2.a aVar2 = new j2.a(bVar, pVar);
                            map.put(pVar.f11505a, aVar2);
                            bVar2.h(jMax2 - bVar.f9662c.z(), aVar2);
                        }
                    } else if (pVar.b()) {
                        h2.c cVar = pVar.f11513j;
                        if (cVar.f9259d) {
                            j.d().a(r, "Ignoring " + pVar + ". Requires device idle.");
                        } else if (cVar.b()) {
                            j.d().a(r, "Ignoring " + pVar + ". Requires ContentUri triggers.");
                        } else {
                            hashSet.add(pVar);
                            hashSet2.add(pVar.f11505a);
                        }
                    } else if (!this.h.h(y.t(pVar))) {
                        j.d().a(r, "Starting work for " + pVar.f11505a);
                        androidx.preference.c cVar2 = this.h;
                        cVar2.getClass();
                        i2.k kVarP = cVar2.p(y.t(pVar));
                        this.f9676q.b(kVarP);
                        this.f9670k.c(kVarP, null);
                    }
                }
            }
        }
        synchronized (this.f9668e) {
            try {
                if (!hashSet.isEmpty()) {
                    j.d().a(r, "Starting tracking for " + TextUtils.join(",", hashSet2));
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        p pVar2 = (p) it.next();
                        k kVarT2 = y.t(pVar2);
                        if (!this.f9665b.containsKey(kVarT2)) {
                            this.f9665b.put(kVarT2, WorkConstraintsTrackerKt.a(this.f9674o, pVar2, this.f9675p.b(), this));
                        }
                    }
                }
            } finally {
            }
        }
    }

    @Override // i2.h
    public final void cancel(String str) {
        Runnable runnable;
        if (this.f9673n == null) {
            this.f9673n = Boolean.valueOf(r2.j.a(this.f9664a, this.f9671l));
        }
        boolean zBooleanValue = this.f9673n.booleanValue();
        String str2 = r;
        if (!zBooleanValue) {
            j.d().e(str2, "Ignoring schedule request in non-main process");
            return;
        }
        if (!this.f9667d) {
            this.f9669j.a(this);
            this.f9667d = true;
        }
        j.d().a(str2, "Cancelling work ID " + str);
        b bVar = this.f9666c;
        if (bVar != null && (runnable = (Runnable) bVar.f9663d.remove(str)) != null) {
            bVar.f9661b.a(runnable);
        }
        for (i2.k kVar : this.h.n(str)) {
            this.f9676q.a(kVar);
            this.f9670k.a(kVar);
        }
    }

    @Override // i2.h
    public final boolean d() {
        return false;
    }
}
