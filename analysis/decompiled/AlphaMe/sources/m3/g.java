package m3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.fragment.app.A;

/* loaded from: classes2.dex */
public final class g extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final i f13616a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13617b;

    /* renamed from: c, reason: collision with root package name */
    public final e f13618c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13619d;

    public g(e eVar, Looper looper) {
        super(looper);
        this.f13618c = eVar;
        this.f13617b = 10;
        this.f13616a = new i();
    }

    public final void a(Object obj, o oVar) {
        j jVarA = j.a(obj, oVar);
        synchronized (this) {
            try {
                this.f13616a.a(jVarA);
                if (!this.f13619d) {
                    this.f13619d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new A("Could not send handler message", 10);
                    }
                }
            } finally {
            }
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                j jVarB = this.f13616a.b();
                if (jVarB == null) {
                    synchronized (this) {
                        jVarB = this.f13616a.b();
                        if (jVarB == null) {
                            this.f13619d = false;
                            return;
                        }
                    }
                }
                this.f13618c.d(jVarB);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f13617b);
            if (!sendMessage(obtainMessage())) {
                throw new A("Could not send handler message", 10);
            }
            this.f13619d = true;
        } catch (Throwable th) {
            this.f13619d = false;
            throw th;
        }
    }
}
