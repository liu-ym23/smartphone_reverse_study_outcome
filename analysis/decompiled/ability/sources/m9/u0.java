package m9;

import kotlinx.coroutines.TimeoutCancellationException;

/* loaded from: classes4.dex */
public final class u0 extends s9.o implements Runnable {
    public final long e;

    public u0(long j5, H7.c cVar) {
        super(cVar.getContext(), cVar);
        this.e = j5;
    }

    @Override // kotlinx.coroutines.c
    public final String W() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.W());
        sb.append("(timeMillis=");
        return B7.a.p(sb, this.e, ')');
    }

    @Override // java.lang.Runnable
    public final void run() {
        kotlinx.coroutines.a.h(this.c);
        A(new TimeoutCancellationException("Timed out waiting for " + this.e + " ms", this));
    }
}
