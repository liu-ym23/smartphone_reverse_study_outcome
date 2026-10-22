package Nb;

import Mb.C0963a;
import Mb.C0966d;
import Mb.E;
import Mb.F;
import Mb.G;
import Mb.H;
import Mb.I;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0002\f\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\f\u0010\u001c¨\u0006\u001e"}, d2 = {"LNb/h;", "LMb/H;", "Ljava/net/Socket;", "socket", "<init>", "(Ljava/net/Socket;)V", "LY8/t;", "cancel", "()V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/net/Socket;", "c", "()Ljava/net/Socket;", "Ljava/util/concurrent/atomic/AtomicInteger;", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/atomic/AtomicInteger;", "closeBits", "LMb/I;", "LMb/I;", "e", "()LMb/I;", "source", "LMb/G;", Const.INTENT_KEY_UMID, "LMb/G;", "()LMb/G;", "sink", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class h implements H {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Socket socket;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public AtomicInteger closeBits;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final I source;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final G sink;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019¨\u0006\u001b"}, d2 = {"LNb/h$a;", "LMb/G;", "<init>", "(LNb/h;)V", "LMb/d;", "source", "", "byteCount", "LY8/t;", "K", "(LMb/d;J)V", "flush", "()V", "close", "LNb/m;", Const.INTENT_KEY_PKGNAME, "()LNb/m;", "", "toString", "()Ljava/lang/String;", "Ljava/io/OutputStream;", "kotlin.jvm.PlatformType", Const.INTENT_KEY_APIKEY, "Ljava/io/OutputStream;", "outputStream", "LNb/m;", "timeout", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Nb.h$a, reason: from toString */
    public final class sink implements G {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final OutputStream outputStream;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final m timeout;

        public sink() {
            this.outputStream = h.this.getSocket().getOutputStream();
            this.timeout = new m(h.this.getSocket());
        }

        @Override // Mb.G
        public void K(C0966d source, long byteCount) throws IOException {
            kotlin.jvm.internal.p.i(source, "source");
            C0963a.b(source.getSize(), 0L, byteCount);
            while (byteCount > 0) {
                this.timeout.g();
                E e10 = source.head;
                kotlin.jvm.internal.p.f(e10);
                int iMin = (int) Math.min(byteCount, e10.limit - e10.pos);
                m mVar = this.timeout;
                mVar.t();
                try {
                    try {
                        this.outputStream.write(e10.data, e10.pos, iMin);
                        Y8.t tVar = Y8.t.f7040a;
                        if (mVar.u()) {
                            throw mVar.q(null);
                        }
                        e10.pos += iMin;
                        long j10 = iMin;
                        byteCount -= j10;
                        source.a1(source.getSize() - j10);
                        if (e10.pos == e10.limit) {
                            source.head = e10.b();
                            F.b(e10);
                        }
                    } catch (IOException e11) {
                        if (!mVar.u()) {
                            throw e11;
                        }
                        throw mVar.q(e11);
                    }
                } catch (Throwable th) {
                    mVar.u();
                    throw th;
                }
            }
        }

        @Override // Mb.G
        /* renamed from: b, reason: from getter */
        public m getTimeout() {
            return this.timeout;
        }

        @Override // Mb.G, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            m mVar = this.timeout;
            h hVar = h.this;
            mVar.t();
            try {
                int iA = s.a(hVar.closeBits, 1);
                if (iA != 0) {
                    if (iA != 3) {
                        if (!hVar.getSocket().isClosed() && !hVar.getSocket().isOutputShutdown()) {
                            this.outputStream.flush();
                            try {
                                hVar.getSocket().shutdownOutput();
                            } catch (UnsupportedOperationException unused) {
                                this.outputStream.close();
                            }
                        }
                        return;
                    }
                    hVar.getSocket().close();
                    Y8.t tVar = Y8.t.f7040a;
                    if (mVar.u()) {
                        throw mVar.q(null);
                    }
                }
            } catch (IOException e10) {
                if (!mVar.u()) {
                    throw e10;
                }
                throw mVar.q(e10);
            } finally {
                mVar.u();
            }
        }

        @Override // Mb.G, java.io.Flushable
        public void flush() throws IOException {
            m mVar = this.timeout;
            mVar.t();
            try {
                this.outputStream.flush();
                Y8.t tVar = Y8.t.f7040a;
                if (mVar.u()) {
                    throw mVar.q(null);
                }
            } catch (IOException e10) {
                if (!mVar.u()) {
                    throw e10;
                }
                throw mVar.q(e10);
            } finally {
                mVar.u();
            }
        }

        public String toString() {
            return "sink(" + h.this.getSocket() + ')';
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018¨\u0006\u001a"}, d2 = {"LNb/h$b;", "LMb/I;", "<init>", "(LNb/h;)V", "LMb/d;", "sink", "", "byteCount", "u0", "(LMb/d;J)J", "LY8/t;", "close", "()V", "LNb/m;", Const.INTENT_KEY_PKGNAME, "()LNb/m;", "", "toString", "()Ljava/lang/String;", "Ljava/io/InputStream;", "kotlin.jvm.PlatformType", Const.INTENT_KEY_APIKEY, "Ljava/io/InputStream;", "inputStream", "LNb/m;", "timeout", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Nb.h$b, reason: from toString */
    public final class source implements I {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final InputStream inputStream;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final m timeout;

        public source() {
            this.inputStream = h.this.getSocket().getInputStream();
            this.timeout = new m(h.this.getSocket());
        }

        @Override // Mb.I
        /* renamed from: b, reason: from getter */
        public m getTimeout() {
            return this.timeout;
        }

        @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            m mVar = this.timeout;
            h hVar = h.this;
            mVar.t();
            try {
                int iA = s.a(hVar.closeBits, 2);
                if (iA != 0) {
                    if (iA == 3) {
                        hVar.getSocket().close();
                    } else {
                        if (hVar.getSocket().isClosed() || hVar.getSocket().isInputShutdown()) {
                            return;
                        }
                        try {
                            hVar.getSocket().shutdownInput();
                        } catch (UnsupportedOperationException unused) {
                            this.inputStream.close();
                        }
                    }
                    Y8.t tVar = Y8.t.f7040a;
                    if (mVar.u()) {
                        throw mVar.q(null);
                    }
                }
            } catch (IOException e10) {
                if (!mVar.u()) {
                    throw e10;
                }
                throw mVar.q(e10);
            } finally {
                mVar.u();
            }
        }

        public String toString() {
            return "source(" + h.this.getSocket() + ')';
        }

        @Override // Mb.I
        public long u0(C0966d sink, long byteCount) throws IOException {
            kotlin.jvm.internal.p.i(sink, "sink");
            if (byteCount == 0) {
                return 0L;
            }
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            this.timeout.g();
            E eH1 = sink.h1(1);
            int iMin = (int) Math.min(byteCount, 8192 - eH1.limit);
            try {
                m mVar = this.timeout;
                mVar.t();
                try {
                    int i10 = this.inputStream.read(eH1.data, eH1.limit, iMin);
                    if (mVar.u()) {
                        throw mVar.q(null);
                    }
                    if (i10 != -1) {
                        eH1.limit += i10;
                        long j10 = i10;
                        sink.a1(sink.getSize() + j10);
                        return j10;
                    }
                    if (eH1.pos != eH1.limit) {
                        return -1L;
                    }
                    sink.head = eH1.b();
                    F.b(eH1);
                    return -1L;
                } catch (IOException e10) {
                    if (mVar.u()) {
                        throw mVar.q(e10);
                    }
                    throw e10;
                } finally {
                    mVar.u();
                }
            } catch (AssertionError e11) {
                if (t.b(e11)) {
                    throw new IOException(e11);
                }
                throw e11;
            }
        }
    }

    public h(Socket socket) {
        kotlin.jvm.internal.p.i(socket, "socket");
        this.socket = socket;
        this.closeBits = new AtomicInteger();
        this.source = new source();
        this.sink = new sink();
    }

    @Override // Mb.H
    /* renamed from: a, reason: from getter */
    public G getSink() {
        return this.sink;
    }

    /* renamed from: c, reason: from getter */
    public final Socket getSocket() {
        return this.socket;
    }

    @Override // Mb.H
    public void cancel() throws IOException {
        this.socket.close();
    }

    @Override // Mb.H
    /* renamed from: e, reason: from getter */
    public I getSource() {
        return this.source;
    }

    public String toString() {
        String string = this.socket.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }
}
