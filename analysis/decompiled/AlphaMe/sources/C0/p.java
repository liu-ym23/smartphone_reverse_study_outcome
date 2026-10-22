package C0;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import t0.P;

/* loaded from: classes.dex */
public final class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final t0.r f313a;

    /* renamed from: b, reason: collision with root package name */
    public final t0.x f314b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f315c;

    /* renamed from: d, reason: collision with root package name */
    public final int f316d;

    public p(t0.r processor, t0.x token, boolean z4, int i4) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(token, "token");
        this.f313a = processor;
        this.f314b = token;
        this.f315c = z4;
        this.f316d = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zD;
        P pB;
        if (this.f315c) {
            t0.r rVar = this.f313a;
            t0.x xVar = this.f314b;
            int i4 = this.f316d;
            rVar.getClass();
            String str = xVar.f15425a.f150a;
            synchronized (rVar.f15413k) {
                pB = rVar.b(str);
            }
            zD = t0.r.d(str, pB, i4);
        } else {
            t0.r rVar2 = this.f313a;
            t0.x xVar2 = this.f314b;
            int i5 = this.f316d;
            rVar2.getClass();
            String str2 = xVar2.f15425a.f150a;
            synchronized (rVar2.f15413k) {
                try {
                    if (rVar2.f15408f.get(str2) != null) {
                        s0.t.d().a(t0.r.f15402l, "Ignored stopWork. WorkerWrapper " + str2 + " is in foreground");
                    } else {
                        Set set = (Set) rVar2.f15410h.get(str2);
                        if (set != null && set.contains(xVar2)) {
                            zD = t0.r.d(str2, rVar2.b(str2), i5);
                        }
                    }
                    zD = false;
                } finally {
                }
            }
        }
        s0.t.d().a(s0.t.f("StopWorkRunnable"), "StopWorkRunnable for " + this.f314b.f15425a.f150a + "; Processor.stopWork = " + zD);
    }
}
