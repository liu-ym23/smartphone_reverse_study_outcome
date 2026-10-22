package l1;

import androidx.fragment.app.A;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13463a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final g f13464b = new g();

    /* renamed from: c, reason: collision with root package name */
    public boolean f13465c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13466d;

    /* renamed from: e, reason: collision with root package name */
    public Exception f13467e;

    public final void a() {
        boolean z4;
        Exception exc;
        String strConcat;
        boolean z5;
        Object obj;
        if (this.f13465c) {
            int i4 = C0756a.f13453a;
            synchronized (this.f13463a) {
                z4 = this.f13465c;
            }
            if (!z4) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            synchronized (this.f13463a) {
                exc = this.f13467e;
            }
            if (exc == null) {
                synchronized (this.f13463a) {
                    try {
                        z5 = false;
                        if (this.f13465c && this.f13467e == null) {
                            z5 = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z5) {
                    synchronized (this.f13463a) {
                        com.stepos.statsrpk.c.n("Task is not yet complete", this.f13465c);
                        Exception exc2 = this.f13467e;
                        if (exc2 != null) {
                            throw new A(4, exc2);
                        }
                        obj = this.f13466d;
                    }
                    strConcat = "result ".concat(String.valueOf(obj));
                } else {
                    strConcat = "unknown issue";
                }
            } else {
                strConcat = "failure";
            }
        }
    }
}
