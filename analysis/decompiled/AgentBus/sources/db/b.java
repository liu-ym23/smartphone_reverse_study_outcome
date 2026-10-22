package db;

import eb.m;
import eb.n;
import hb.p;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import q7.k;

/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3020e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f3021f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i2, Object obj, String str) {
        super(str, true);
        this.f3020e = i2;
        this.f3021f = obj;
    }

    @Override // db.a
    public final long a() throws IOException {
        switch (this.f3020e) {
            case 0:
                ((p7.a) this.f3021f).c();
                return -1L;
            case 1:
                n nVar = (n) this.f3021f;
                long jNanoTime = System.nanoTime();
                Iterator it = nVar.f3315d.iterator();
                int i2 = 0;
                long j2 = Long.MIN_VALUE;
                m mVar = null;
                int i10 = 0;
                while (it.hasNext()) {
                    m mVar2 = (m) it.next();
                    k.d(mVar2, "connection");
                    synchronized (mVar2) {
                        if (nVar.b(mVar2, jNanoTime) > 0) {
                            i10++;
                        } else {
                            i2++;
                            long j4 = jNanoTime - mVar2.f3311q;
                            if (j4 > j2) {
                                mVar = mVar2;
                                j2 = j4;
                            }
                        }
                    }
                }
                long j10 = nVar.f3312a;
                if (j2 < j10 && i2 <= 5) {
                    if (i2 > 0) {
                        return j10 - j2;
                    }
                    if (i10 > 0) {
                        return j10;
                    }
                    return -1L;
                }
                k.b(mVar);
                synchronized (mVar) {
                    if (!mVar.f3310p.isEmpty()) {
                        return 0L;
                    }
                    if (mVar.f3311q + j2 != jNanoTime) {
                        return 0L;
                    }
                    mVar.f3304j = true;
                    nVar.f3315d.remove(mVar);
                    Socket socket = mVar.f3298d;
                    k.b(socket);
                    bb.b.e(socket);
                    if (!nVar.f3315d.isEmpty()) {
                        return 0L;
                    }
                    nVar.f3313b.a();
                    return 0L;
                }
            default:
                p pVar = (p) this.f3021f;
                pVar.getClass();
                try {
                    pVar.C.i(2, 0, false);
                    return -1L;
                } catch (IOException e10) {
                    pVar.a(2, 2, e10);
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(n nVar, String str) {
        super(str, true);
        this.f3020e = 1;
        this.f3021f = nVar;
    }
}
