package dd;

import b8.d0;
import ed.m;
import hd.o;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3303e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f3304f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d0 d0Var, String str) {
        super(str, true);
        this.f3303e = 1;
        this.f3304f = d0Var;
    }

    @Override // dd.a
    public final long a() throws IOException {
        switch (this.f3303e) {
            case 0:
                ((xb.a) this.f3304f).invoke();
                return -1L;
            case 1:
                d0 d0Var = (d0) this.f3304f;
                long jNanoTime = System.nanoTime();
                Iterator it = ((ConcurrentLinkedQueue) d0Var.f1949h).iterator();
                int i = 0;
                long j10 = Long.MIN_VALUE;
                m mVar = null;
                int i3 = 0;
                while (it.hasNext()) {
                    m mVar2 = (m) it.next();
                    mVar2.getClass();
                    synchronized (mVar2) {
                        if (d0Var.b(mVar2, jNanoTime) > 0) {
                            i3++;
                        } else {
                            i++;
                            long j11 = jNanoTime - mVar2.f3834p;
                            if (j11 > j10) {
                                mVar = mVar2;
                                j10 = j11;
                            }
                        }
                    }
                }
                long j12 = d0Var.f1946c;
                if (j10 < j12 && i <= 5) {
                    if (i > 0) {
                        return j12 - j10;
                    }
                    if (i3 > 0) {
                        return j12;
                    }
                    return -1L;
                }
                mVar.getClass();
                synchronized (mVar) {
                    if (!mVar.f3833o.isEmpty()) {
                        return 0L;
                    }
                    if (mVar.f3834p + j10 != jNanoTime) {
                        return 0L;
                    }
                    mVar.i = true;
                    ((ConcurrentLinkedQueue) d0Var.f1949h).remove(mVar);
                    Socket socket = mVar.f3822c;
                    socket.getClass();
                    bd.b.e(socket);
                    if (!((ConcurrentLinkedQueue) d0Var.f1949h).isEmpty()) {
                        return 0L;
                    }
                    ((c) d0Var.f1947f).a();
                    return 0L;
                }
            default:
                o oVar = (o) this.f3304f;
                oVar.getClass();
                try {
                    oVar.A.o(2, 0, false);
                    return -1L;
                } catch (IOException e10) {
                    oVar.d(2, 2, e10);
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, int i, Object obj) {
        super(str, true);
        this.f3303e = i;
        this.f3304f = obj;
    }
}
