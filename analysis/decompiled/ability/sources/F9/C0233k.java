package F9;

import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: F9.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0233k {

    /* renamed from: a, reason: collision with root package name */
    public final J9.k f648a;

    public C0233k(int i, long j5, TimeUnit timeUnit) {
        kotlin.jvm.internal.k.f(timeUnit, "timeUnit");
        this.f648a = new J9.k(I9.e.h, i, j5, timeUnit);
    }

    public final void a() throws IOException {
        Socket socket;
        J9.k kVar = this.f648a;
        Iterator it = ((ConcurrentLinkedQueue) kVar.f).iterator();
        kotlin.jvm.internal.k.e(it, "connections.iterator()");
        while (it.hasNext()) {
            okhttp3.internal.connection.a connection = (okhttp3.internal.connection.a) it.next();
            kotlin.jvm.internal.k.e(connection, "connection");
            synchronized (connection) {
                if (connection.p.isEmpty()) {
                    it.remove();
                    connection.f5471j = true;
                    socket = connection.d;
                    kotlin.jvm.internal.k.c(socket);
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                G9.b.d(socket);
            }
        }
        if (((ConcurrentLinkedQueue) kVar.f).isEmpty()) {
            ((I9.c) kVar.d).a();
        }
    }

    public C0233k() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
