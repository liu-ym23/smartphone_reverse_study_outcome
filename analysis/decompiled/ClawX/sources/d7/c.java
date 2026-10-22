package d7;

import a1.w;
import c7.q;
import c7.r;
import c7.t;
import c7.x;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements t {

    /* renamed from: a, reason: collision with root package name */
    public final OutputStream f1928a;

    /* renamed from: b, reason: collision with root package name */
    public final e f1929b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f1930c;

    public c(w wVar) {
        this.f1930c = wVar;
        Socket socket = (Socket) wVar.f75b;
        this.f1928a = socket.getOutputStream();
        this.f1929b = new e(socket);
    }

    @Override // c7.t, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        int i8;
        OutputStream outputStream = this.f1928a;
        w wVar = this.f1930c;
        e eVar = this.f1929b;
        eVar.i();
        try {
            AtomicInteger atomicInteger = (AtomicInteger) wVar.f76c;
            Socket socket = (Socket) wVar.f75b;
            p.e(atomicInteger, "<this>");
            while (true) {
                int i9 = atomicInteger.get();
                if ((i9 & 1) != 0) {
                    i8 = 0;
                    break;
                }
                int i10 = i9 | 1;
                if (atomicInteger.compareAndSet(i9, i10)) {
                    i8 = i10;
                    break;
                }
            }
            if (i8 != 0) {
                if (i8 != 3) {
                    if (!socket.isClosed() && !socket.isOutputShutdown()) {
                        outputStream.flush();
                        try {
                            socket.shutdownOutput();
                        } catch (UnsupportedOperationException unused) {
                            outputStream.close();
                        }
                    }
                    return;
                }
                socket.close();
                if (eVar.j()) {
                    throw eVar.k(null);
                }
            }
        } catch (IOException e9) {
            if (!eVar.j()) {
                throw e9;
            }
            throw eVar.k(e9);
        } finally {
            eVar.j();
        }
    }

    @Override // c7.t
    public final x d() {
        return this.f1929b;
    }

    @Override // c7.t, java.io.Flushable
    public final void flush() throws IOException {
        e eVar = this.f1929b;
        eVar.i();
        try {
            this.f1928a.flush();
            if (eVar.j()) {
                throw eVar.k(null);
            }
        } catch (IOException e9) {
            if (!eVar.j()) {
                throw e9;
            }
            throw eVar.k(e9);
        } finally {
            eVar.j();
        }
    }

    public final String toString() {
        return "sink(" + ((Socket) this.f1930c.f75b) + ')';
    }

    @Override // c7.t
    public final void x(long j4, c7.f fVar) throws IOException {
        c7.b.d(fVar.f1164b, 0L, j4);
        while (j4 > 0) {
            e eVar = this.f1929b;
            eVar.f();
            q qVar = fVar.f1163a;
            p.b(qVar);
            int iMin = (int) Math.min(j4, qVar.f1189c - qVar.f1188b);
            eVar.i();
            try {
                try {
                    this.f1928a.write(qVar.f1187a, qVar.f1188b, iMin);
                    if (eVar.j()) {
                        throw eVar.k(null);
                    }
                    int i8 = qVar.f1188b + iMin;
                    qVar.f1188b = i8;
                    long j8 = iMin;
                    j4 -= j8;
                    fVar.f1164b -= j8;
                    if (i8 == qVar.f1189c) {
                        fVar.f1163a = qVar.a();
                        r.a(qVar);
                    }
                } catch (IOException e9) {
                    if (!eVar.j()) {
                        throw e9;
                    }
                    throw eVar.k(e9);
                }
            } catch (Throwable th) {
                eVar.j();
                throw th;
            }
        }
    }
}
