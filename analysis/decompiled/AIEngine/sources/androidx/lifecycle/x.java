package androidx.lifecycle;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.w;
import h2.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class x<T> extends w<T> {
    public final void g(m.a aVar) {
        boolean z;
        synchronized (this.f2323a) {
            z = this.f2328f == w.f2322k;
            this.f2328f = aVar;
        }
        if (z) {
            m.b bVarK = m.b.k();
            w.a aVar2 = this.f2331j;
            m.c cVar = bVarK.f10433b;
            if (cVar.f10436d == null) {
                synchronized (cVar.f10434b) {
                    try {
                        if (cVar.f10436d == null) {
                            cVar.f10436d = Handler.createAsync(Looper.getMainLooper());
                        }
                    } finally {
                    }
                }
            }
            cVar.f10436d.post(aVar2);
        }
    }
}
