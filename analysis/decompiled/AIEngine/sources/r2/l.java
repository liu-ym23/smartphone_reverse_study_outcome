package r2;

import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.work.impl.a f11702a;

    /* renamed from: b, reason: collision with root package name */
    public final i2.k f11703b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11704c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11705d;

    public l(androidx.work.impl.a processor, i2.k token, boolean z, int i10) {
        kotlin.jvm.internal.g.f(processor, "processor");
        kotlin.jvm.internal.g.f(token, "token");
        this.f11702a = processor;
        this.f11703b = token;
        this.f11704c = z;
        this.f11705d = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zD;
        androidx.work.impl.d dVarB;
        if (this.f11704c) {
            androidx.work.impl.a aVar = this.f11702a;
            i2.k kVar = this.f11703b;
            int i10 = this.f11705d;
            aVar.getClass();
            String str = kVar.f9470a.f11498a;
            synchronized (aVar.f2873k) {
                dVarB = aVar.b(str);
            }
            zD = androidx.work.impl.a.d(str, dVarB, i10);
        } else {
            androidx.work.impl.a aVar2 = this.f11702a;
            i2.k kVar2 = this.f11703b;
            int i11 = this.f11705d;
            aVar2.getClass();
            String str2 = kVar2.f9470a.f11498a;
            synchronized (aVar2.f2873k) {
                try {
                    if (aVar2.f2869f.get(str2) != null) {
                        h2.j.d().a(androidx.work.impl.a.f2863l, "Ignored stopWork. WorkerWrapper " + str2 + " is in foreground");
                    } else {
                        Set set = (Set) aVar2.h.get(str2);
                        if (set != null && set.contains(kVar2)) {
                            zD = androidx.work.impl.a.d(str2, aVar2.b(str2), i11);
                        }
                    }
                    zD = false;
                } finally {
                }
            }
        }
        h2.j.d().a(h2.j.f("StopWorkRunnable"), "StopWorkRunnable for " + this.f11703b.f9470a.f11498a + "; Processor.stopWork = " + zD);
    }
}
