package androidx.lifecycle;

import android.os.Handler;
import android.os.Looper;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class d0 {

    /* renamed from: h, reason: collision with root package name */
    public static final Object f1370h = new Object();

    /* renamed from: a, reason: collision with root package name */
    public Object f1371a;

    /* renamed from: b, reason: collision with root package name */
    public o.f f1372b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Object f1373c;

    /* renamed from: d, reason: collision with root package name */
    public volatile Object f1374d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1375e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1376f;

    /* renamed from: g, reason: collision with root package name */
    public c0 f1377g;

    public final void a(h5.t tVar) {
        boolean z10;
        synchronized (this.f1371a) {
            z10 = this.f1374d == f1370h;
            this.f1374d = tVar;
        }
        if (z10) {
            n.a aVarW = n.a.W();
            c0 c0Var = this.f1377g;
            n.c cVar = aVarW.f8611c;
            if (cVar.f8616e == null) {
                synchronized (cVar.f8614c) {
                    try {
                        if (cVar.f8616e == null) {
                            cVar.f8616e = Handler.createAsync(Looper.getMainLooper());
                        }
                    } finally {
                    }
                }
            }
            cVar.f8616e.post(c0Var);
        }
    }
}
