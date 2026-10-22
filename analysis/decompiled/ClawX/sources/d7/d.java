package d7;

import a1.w;
import c7.q;
import c7.r;
import c7.v;
import c7.x;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d implements v {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f1931a;

    /* renamed from: b, reason: collision with root package name */
    public final e f1932b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f1933c;

    public d(w wVar) {
        this.f1933c = wVar;
        Socket socket = (Socket) wVar.f75b;
        this.f1931a = socket.getInputStream();
        this.f1932b = new e(socket);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i8;
        w wVar = this.f1933c;
        e eVar = this.f1932b;
        eVar.i();
        try {
            AtomicInteger atomicInteger = (AtomicInteger) wVar.f76c;
            Socket socket = (Socket) wVar.f75b;
            p.e(atomicInteger, "<this>");
            while (true) {
                int i9 = atomicInteger.get();
                if ((i9 & 2) != 0) {
                    i8 = 0;
                    break;
                }
                int i10 = i9 | 2;
                if (atomicInteger.compareAndSet(i9, i10)) {
                    i8 = i10;
                    break;
                }
            }
            if (i8 != 0) {
                if (i8 == 3) {
                    socket.close();
                } else {
                    if (socket.isClosed() || socket.isInputShutdown()) {
                        return;
                    }
                    try {
                        socket.shutdownInput();
                    } catch (UnsupportedOperationException unused) {
                        this.f1931a.close();
                    }
                }
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

    @Override // c7.v, c7.t
    public final x d() {
        return this.f1932b;
    }

    @Override // c7.v
    public final long h(long j4, c7.f fVar) throws IOException {
        e eVar = this.f1932b;
        eVar.f();
        q qVarT = fVar.t(1);
        int iMin = (int) Math.min(8192L, 8192 - qVarT.f1189c);
        try {
            eVar.i();
            try {
                int i8 = this.f1931a.read(qVarT.f1187a, qVarT.f1189c, iMin);
                if (eVar.j()) {
                    throw eVar.k(null);
                }
                if (i8 != -1) {
                    qVarT.f1189c += i8;
                    long j8 = i8;
                    fVar.f1164b += j8;
                    return j8;
                }
                if (qVarT.f1188b != qVarT.f1189c) {
                    return -1L;
                }
                fVar.f1163a = qVarT.a();
                r.a(qVarT);
                return -1L;
            } catch (IOException e9) {
                if (eVar.j()) {
                    throw eVar.k(e9);
                }
                throw e9;
            } finally {
                eVar.j();
            }
        } catch (AssertionError e10) {
            if (f.a(e10)) {
                throw new IOException(e10);
            }
            throw e10;
        }
    }

    public final String toString() {
        return "source(" + ((Socket) this.f1933c.f75b) + ')';
    }
}
