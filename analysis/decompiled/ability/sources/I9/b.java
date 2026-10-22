package I9;

import J9.k;
import M9.o;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes4.dex */
public final class b extends a {
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i, Object obj, String str) {
        super(str, true);
        this.e = i;
        this.f = obj;
    }

    @Override // I9.a
    public final long a() throws IOException {
        switch (this.e) {
            case 0:
                ((S7.a) this.f).invoke();
                return -1L;
            case 1:
                k kVar = (k) this.f;
                long jNanoTime = System.nanoTime();
                Iterator it = ((ConcurrentLinkedQueue) kVar.f).iterator();
                int i = 0;
                long j5 = Long.MIN_VALUE;
                okhttp3.internal.connection.a aVar = null;
                int i6 = 0;
                while (it.hasNext()) {
                    okhttp3.internal.connection.a connection = (okhttp3.internal.connection.a) it.next();
                    kotlin.jvm.internal.k.e(connection, "connection");
                    synchronized (connection) {
                        if (kVar.b(connection, jNanoTime) > 0) {
                            i6++;
                        } else {
                            i++;
                            long j6 = jNanoTime - connection.f5472q;
                            if (j6 > j5) {
                                aVar = connection;
                                j5 = j6;
                            }
                        }
                    }
                }
                long j10 = kVar.c;
                if (j5 < j10 && i <= kVar.b) {
                    if (i > 0) {
                        return j10 - j5;
                    }
                    if (i6 > 0) {
                        return j10;
                    }
                    return -1L;
                }
                kotlin.jvm.internal.k.c(aVar);
                synchronized (aVar) {
                    if (!aVar.p.isEmpty()) {
                        return 0L;
                    }
                    if (aVar.f5472q + j5 != jNanoTime) {
                        return 0L;
                    }
                    aVar.f5471j = true;
                    ((ConcurrentLinkedQueue) kVar.f).remove(aVar);
                    Socket socket = aVar.d;
                    kotlin.jvm.internal.k.c(socket);
                    G9.b.d(socket);
                    if (!((ConcurrentLinkedQueue) kVar.f).isEmpty()) {
                        return 0L;
                    }
                    ((c) kVar.d).a();
                    return 0L;
                }
            default:
                o oVar = (o) this.f;
                oVar.getClass();
                try {
                    oVar.f991w.k(2, 0, false);
                    return -1L;
                } catch (IOException e) {
                    oVar.c(e);
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(k kVar, String str) {
        super(str, true);
        this.e = 1;
        this.f = kVar;
    }
}
