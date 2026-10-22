package z2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import h2.C1483a;
import h2.RunnableC1484b;

/* loaded from: classes2.dex */
public final class p extends HandlerThread {

    /* renamed from: a, reason: collision with root package name */
    public volatile int f6938a;
    public volatile boolean b;
    public final /* synthetic */ r c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(r rVar, String str) {
        super(str);
        this.c = rVar;
        this.f6938a = 0;
        this.b = false;
    }

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        B0.f fVar;
        super.onLooperPrepared();
        synchronized (this.c.e) {
            this.c.d = new Handler();
        }
        this.c.d.post(new RunnableC1484b(this.c, 12));
        while (true) {
            try {
                Looper.loop();
            } catch (Throwable th) {
                try {
                    if (h2.d.b != null && ((C1483a) h2.d.b.f4555a) != null && (fVar = ((C1483a) h2.d.b.f4555a).f4543a) != null && !fVar.b) {
                        l.i().b((RunnableC1484b) fVar.c, 5000L);
                    }
                    if (this.f6938a < 5) {
                        int i = com.apm.insight.b.f2156a;
                        M0.i.k("NPTH_CATCH", th);
                    } else if (!this.b) {
                        this.b = true;
                        int i6 = com.apm.insight.b.f2156a;
                        M0.i.k("NPTH_ERR_MAX", new RuntimeException());
                    }
                    this.f6938a++;
                } catch (Throwable unused) {
                }
            }
        }
    }
}
