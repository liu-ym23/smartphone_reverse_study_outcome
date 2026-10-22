package hb;

import java.net.SocketTimeoutException;

/* loaded from: classes.dex */
public final class w extends ob.f {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ x f4363m;

    public w(x xVar) {
        this.f4363m = xVar;
    }

    @Override // ob.f
    public final void k() {
        this.f4363m.e(9);
        p pVar = this.f4363m.f4365b;
        synchronized (pVar) {
            long j2 = pVar.f4328t;
            long j4 = pVar.f4327s;
            if (j2 < j4) {
                return;
            }
            pVar.f4327s = j4 + 1;
            pVar.f4329u = System.nanoTime() + 1000000000;
            pVar.f4321m.c(new db.b(2, pVar, a1.a.m(new StringBuilder(), pVar.f4316h, " ping")), 0L);
        }
    }

    public final void l() {
        if (j()) {
            throw new SocketTimeoutException("timeout");
        }
    }
}
