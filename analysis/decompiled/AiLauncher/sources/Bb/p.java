package Bb;

import Cb.WindowCounter;
import Mb.C0964b;
import Mb.C0966d;
import Mb.G;
import Mb.H;
import Mb.I;
import Mb.InterfaceC0968f;
import Mb.J;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.Metadata;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import tb.u;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 62\u00020\u00012\u00020\u0002:\u0004084-B3\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b#\u0010$J\u001d\u0010(\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0003¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b,\u0010$J\u000f\u0010-\u001a\u00020\u001eH\u0000¢\u0006\u0004\b-\u0010\"J\u0015\u00100\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u001eH\u0000¢\u0006\u0004\b2\u0010\"J\u000f\u00103\u001a\u00020\u001eH\u0000¢\u0006\u0004\b3\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0017\u0010@\u001a\u00020<8\u0006¢\u0006\f\n\u0004\b0\u0010=\u001a\u0004\b>\u0010?R*\u0010F\u001a\u00020.2\u0006\u0010A\u001a\u00020.8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u00101R*\u0010J\u001a\u00020.2\u0006\u0010A\u001a\u00020.8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010B\u001a\u0004\bH\u0010D\"\u0004\bI\u00101R\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\n0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010LR\u0016\u0010O\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010NR\u001e\u0010&\u001a\u00060PR\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010Q\u001a\u0004\bR\u0010SR\u001e\u0010X\u001a\u00060TR\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010U\u001a\u0004\bV\u0010WR\u001e\u0010]\u001a\u00060YR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010Z\u001a\u0004\b[\u0010\\R\u001e\u0010_\u001a\u00060YR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b:\u0010Z\u001a\u0004\b^\u0010\\R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\b`\u0010b\"\u0004\bc\u0010$R$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bd\u0010f\"\u0004\bg\u0010hR\u0011\u0010j\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bi\u0010\u0015R\u0011\u0010l\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bk\u0010\u0015R\u0011\u0010n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bm\u0010\u0015¨\u0006o"}, d2 = {"LBb/p;", "", "LMb/H;", "", "id", "Lokhttp3/internal/http2/c;", "connection", "", "outFinished", "inFinished", "Ltb/u;", "headers", "<init>", "(ILokhttp3/internal/http2/c;ZZLtb/u;)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "Ljava/io/IOException;", "errorException", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "callerIsIdle", "D", "(Z)Ltb/u;", "LMb/J;", "y", "()LMb/J;", "F", "rstStatusCode", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "cancel", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lokhttp3/internal/http2/ErrorCode;)V", "LMb/f;", "source", "length", "z", "(LMb/f;I)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ltb/u;Z)V", "B", Const.INTENT_KEY_UMID, "", "delta", "c", "(J)V", "f", ExifInterface.LONGITUDE_EAST, Const.INTENT_KEY_APIKEY, "I", "n", "()I", Const.INTENT_KEY_PKGNAME, "Lokhttp3/internal/http2/c;", "k", "()Lokhttp3/internal/http2/c;", "LCb/a;", "LCb/a;", "o", "()LCb/a;", "readBytes", UxipConstants.f30680s, "J", "t", "()J", "C", "writeBytesTotal", "e", "s", "setWriteBytesMaximum$okhttp", "writeBytesMaximum", "Ljava/util/ArrayDeque;", "Ljava/util/ArrayDeque;", "headersQueue", "Z", "hasResponseHeaders", "LBb/p$c;", "LBb/p$c;", "r", "()LBb/p$c;", "LBb/p$b;", "LBb/p$b;", "q", "()LBb/p$b;", "sink", "LBb/p$d;", "LBb/p$d;", "p", "()LBb/p$d;", "readTimeout", "u", "writeTimeout", "l", "Lokhttp3/internal/http2/ErrorCode;", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "m", "Ljava/io/IOException;", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "w", "isOpen", "v", "isLocallyInitiated", "x", "isSourceComplete", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class p implements H {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final okhttp3.internal.http2.c connection;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final WindowCounter readBytes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public long writeBytesTotal;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public long writeBytesMaximum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final ArrayDeque<u> headersQueue;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean hasResponseHeaders;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final c source;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final b sink;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final d readTimeout;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final d writeTimeout;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public ErrorCode errorCode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public IOException errorException;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u0015¨\u0006("}, d2 = {"LBb/p$b;", "LMb/G;", "", "finished", "<init>", "(LBb/p;Z)V", "LMb/d;", "source", "", "byteCount", "LY8/t;", "K", "(LMb/d;J)V", "flush", "()V", "LMb/J;", "c", "()LMb/J;", "close", "outFinishedOnLastFrame", Const.INTENT_KEY_PKGNAME, "(Z)V", Const.INTENT_KEY_APIKEY, "Z", "e", "()Z", "setFinished", "LMb/d;", "sendBuffer", "Ltb/u;", "Ltb/u;", "getTrailers", "()Ltb/u;", "setTrailers", "(Ltb/u;)V", "trailers", Const.INTENT_KEY_UMID, "getClosed", "setClosed", AlipayXuiIsland.REASON_CLOSED, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class b implements G {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public boolean finished;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final C0966d sendBuffer = new C0966d();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public u trailers;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public boolean closed;

        public b(boolean z10) {
            this.finished = z10;
        }

        @Override // Mb.G
        public void K(C0966d source, long byteCount) throws IOException {
            kotlin.jvm.internal.p.i(source, "source");
            p pVar = p.this;
            if (!ub.q.f42674b || !Thread.holdsLock(pVar)) {
                this.sendBuffer.K(source, byteCount);
                while (this.sendBuffer.getSize() >= 16384) {
                    b(false);
                }
            } else {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + pVar);
            }
        }

        /* JADX WARN: Finally extract failed */
        public final void b(boolean outFinishedOnLastFrame) throws IOException {
            long jMin;
            boolean z10;
            p pVar = p.this;
            synchronized (pVar) {
                try {
                    pVar.getWriteTimeout().t();
                    while (pVar.getWriteBytesTotal() >= pVar.getWriteBytesMaximum() && !this.finished && !this.closed && pVar.l() == null) {
                        try {
                            pVar.E();
                        } catch (Throwable th) {
                            pVar.getWriteTimeout().B();
                            throw th;
                        }
                    }
                    pVar.getWriteTimeout().B();
                    pVar.f();
                    jMin = Math.min(pVar.getWriteBytesMaximum() - pVar.getWriteBytesTotal(), this.sendBuffer.getSize());
                    pVar.C(pVar.getWriteBytesTotal() + jMin);
                    z10 = outFinishedOnLastFrame && jMin == this.sendBuffer.getSize();
                    t tVar = t.f7040a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            p.this.getWriteTimeout().t();
            try {
                p.this.getConnection().U1(p.this.getId(), z10, this.sendBuffer, jMin);
            } finally {
                p.this.getWriteTimeout().B();
            }
        }

        @Override // Mb.G
        /* renamed from: c */
        public J getTimeout() {
            return p.this.getWriteTimeout();
        }

        @Override // Mb.G, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            p pVar = p.this;
            if (ub.q.f42674b && Thread.holdsLock(pVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + pVar);
            }
            p pVar2 = p.this;
            synchronized (pVar2) {
                if (this.closed) {
                    return;
                }
                boolean z10 = pVar2.l() == null;
                t tVar = t.f7040a;
                if (!p.this.getSink().finished) {
                    boolean z11 = this.sendBuffer.getSize() > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.getSize() > 0) {
                            b(false);
                        }
                        okhttp3.internal.http2.c connection = p.this.getConnection();
                        int id = p.this.getId();
                        u uVar = this.trailers;
                        kotlin.jvm.internal.p.f(uVar);
                        connection.V1(id, z10, ub.q.s(uVar));
                    } else if (z11) {
                        while (this.sendBuffer.getSize() > 0) {
                            b(true);
                        }
                    } else if (z10) {
                        p.this.getConnection().U1(p.this.getId(), true, null, 0L);
                    }
                }
                p pVar3 = p.this;
                synchronized (pVar3) {
                    this.closed = true;
                    kotlin.jvm.internal.p.g(pVar3, "null cannot be cast to non-null type java.lang.Object");
                    pVar3.notifyAll();
                    t tVar2 = t.f7040a;
                }
                p.this.getConnection().flush();
                p.this.d();
            }
        }

        /* renamed from: e, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        @Override // Mb.G, java.io.Flushable
        public void flush() throws IOException {
            p pVar = p.this;
            if (ub.q.f42674b && Thread.holdsLock(pVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + pVar);
            }
            p pVar2 = p.this;
            synchronized (pVar2) {
                pVar2.f();
                t tVar = t.f7040a;
            }
            while (this.sendBuffer.getSize() > 0) {
                b(false);
                p.this.getConnection().flush();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010%\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010(\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$R$\u0010/\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00102\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001d\u001a\u0004\b\u001c\u0010\u001f\"\u0004\b1\u0010!¨\u00063"}, d2 = {"LBb/p$c;", "LMb/I;", "", "maxByteCount", "", "finished", "<init>", "(LBb/p;JZ)V", "LMb/d;", "sink", "byteCount", "u0", "(LMb/d;J)J", "LMb/f;", "source", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LMb/f;J)V", "LMb/J;", "c", "()LMb/J;", "close", "()V", "read", "n", "(J)V", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "Z", "e", "()Z", "l", "(Z)V", "LMb/d;", "getReceiveBuffer", "()LMb/d;", "receiveBuffer", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_COMMAND, "readBuffer", "Ltb/u;", "Ltb/u;", "getTrailers", "()Ltb/u;", "m", "(Ltb/u;)V", "trailers", "f", "setClosed$okhttp", AlipayXuiIsland.REASON_CLOSED, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class c implements I {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final long maxByteCount;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public boolean finished;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final C0966d receiveBuffer = new C0966d();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final C0966d readBuffer = new C0966d();

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public u trailers;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public boolean closed;

        public c(long j10, boolean z10) {
            this.maxByteCount = j10;
            this.finished = z10;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getClosed() {
            return this.closed;
        }

        @Override // Mb.I
        /* renamed from: c */
        public J getTimeout() {
            return p.this.getReadTimeout();
        }

        @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            p pVar = p.this;
            synchronized (pVar) {
                this.closed = true;
                size = this.readBuffer.getSize();
                this.readBuffer.g();
                kotlin.jvm.internal.p.g(pVar, "null cannot be cast to non-null type java.lang.Object");
                pVar.notifyAll();
                t tVar = t.f7040a;
            }
            if (size > 0) {
                n(size);
            }
            p.this.d();
        }

        /* renamed from: e, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        /* renamed from: g, reason: from getter */
        public final C0966d getReadBuffer() {
            return this.readBuffer;
        }

        public final void i(InterfaceC0968f source, long byteCount) throws IOException {
            boolean z10;
            boolean z11;
            kotlin.jvm.internal.p.i(source, "source");
            p pVar = p.this;
            if (ub.q.f42674b && Thread.holdsLock(pVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + pVar);
            }
            long j10 = byteCount;
            while (j10 > 0) {
                synchronized (p.this) {
                    z10 = this.finished;
                    z11 = this.readBuffer.getSize() + j10 > this.maxByteCount;
                    t tVar = t.f7040a;
                }
                if (z11) {
                    source.skip(j10);
                    p.this.i(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z10) {
                    source.skip(j10);
                    return;
                }
                long jU0 = source.u0(this.receiveBuffer, j10);
                if (jU0 == -1) {
                    throw new EOFException();
                }
                j10 -= jU0;
                p pVar2 = p.this;
                synchronized (pVar2) {
                    try {
                        if (this.closed) {
                            this.receiveBuffer.g();
                        } else {
                            boolean z12 = this.readBuffer.getSize() == 0;
                            this.readBuffer.V0(this.receiveBuffer);
                            if (z12) {
                                kotlin.jvm.internal.p.g(pVar2, "null cannot be cast to non-null type java.lang.Object");
                                pVar2.notifyAll();
                            }
                        }
                    } finally {
                    }
                }
            }
            n(byteCount);
            p.this.getConnection().getFlowControlListener().a(p.this.getId(), p.this.getReadBytes(), this.readBuffer.getSize());
        }

        public final void l(boolean z10) {
            this.finished = z10;
        }

        public final void m(u uVar) {
            this.trailers = uVar;
        }

        public final void n(long read) {
            p pVar = p.this;
            if (!ub.q.f42674b || !Thread.holdsLock(pVar)) {
                p.this.getConnection().T1(read);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + pVar);
        }

        @Override // Mb.I
        public long u0(C0966d sink, long byteCount) throws IOException {
            IOException errorException;
            boolean z10;
            long jU0;
            kotlin.jvm.internal.p.i(sink, "sink");
            long j10 = 0;
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            while (true) {
                p pVar = p.this;
                synchronized (pVar) {
                    boolean zJ = pVar.j();
                    if (zJ) {
                        pVar.getReadTimeout().t();
                    }
                    try {
                        if (pVar.l() == null || this.finished) {
                            errorException = null;
                        } else {
                            errorException = pVar.getErrorException();
                            if (errorException == null) {
                                ErrorCode errorCodeL = pVar.l();
                                kotlin.jvm.internal.p.f(errorCodeL);
                                errorException = new StreamResetException(errorCodeL);
                            }
                        }
                        if (this.closed) {
                            throw new IOException("stream closed");
                        }
                        z10 = false;
                        if (this.readBuffer.getSize() > j10) {
                            C0966d c0966d = this.readBuffer;
                            jU0 = c0966d.u0(sink, Math.min(byteCount, c0966d.getSize()));
                            WindowCounter.c(pVar.getReadBytes(), jU0, 0L, 2, null);
                            long jA = pVar.getReadBytes().a();
                            if (errorException == null && jA >= pVar.getConnection().getOkHttpSettings().c() / 2) {
                                pVar.getConnection().b2(pVar.getId(), jA);
                                WindowCounter.c(pVar.getReadBytes(), 0L, jA, 1, null);
                            }
                        } else {
                            if (!this.finished && errorException == null) {
                                pVar.E();
                                z10 = true;
                            }
                            jU0 = -1;
                        }
                        if (zJ) {
                            pVar.getReadTimeout().B();
                        }
                        t tVar = t.f7040a;
                    } finally {
                    }
                }
                p.this.getConnection().getFlowControlListener().a(p.this.getId(), p.this.getReadBytes(), this.readBuffer.getSize());
                if (!z10) {
                    if (jU0 != -1) {
                        return jU0;
                    }
                    if (errorException == null) {
                        return -1L;
                    }
                    throw errorException;
                }
                j10 = 0;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0006¨\u0006\f"}, d2 = {"LBb/p$d;", "LMb/b;", "<init>", "(LBb/p;)V", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()V", "Ljava/io/IOException;", "cause", "w", "(Ljava/io/IOException;)Ljava/io/IOException;", "B", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class d extends C0964b {
        public d() {
        }

        @Override // Mb.C0964b
        public void A() {
            p.this.i(ErrorCode.CANCEL);
            p.this.getConnection().N1();
        }

        public final void B() throws IOException {
            if (u()) {
                throw w(null);
            }
        }

        @Override // Mb.C0964b
        public IOException w(IOException cause) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (cause != null) {
                socketTimeoutException.initCause(cause);
            }
            return socketTimeoutException;
        }
    }

    public p(int i10, okhttp3.internal.http2.c connection, boolean z10, boolean z11, u uVar) {
        kotlin.jvm.internal.p.i(connection, "connection");
        this.id = i10;
        this.connection = connection;
        this.readBytes = new WindowCounter(i10);
        this.writeBytesMaximum = connection.getPeerSettings().c();
        ArrayDeque<u> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new c(connection.getOkHttpSettings().c(), z11);
        this.sink = new b(z10);
        this.readTimeout = new d();
        this.writeTimeout = new d();
        if (uVar == null) {
            if (!v()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (v()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(uVar);
        }
    }

    public final void A(u headers, boolean inFinished) {
        boolean zW;
        kotlin.jvm.internal.p.i(headers, "headers");
        if (ub.q.f42674b && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                if (this.hasResponseHeaders && headers.b(":status") == null && headers.b(":method") == null) {
                    getSource().m(headers);
                } else {
                    this.hasResponseHeaders = true;
                    this.headersQueue.add(headers);
                }
                if (inFinished) {
                    getSource().l(true);
                }
                zW = w();
                kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type java.lang.Object");
                notifyAll();
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zW) {
            return;
        }
        this.connection.L1(this.id);
    }

    public final void B(ErrorCode errorCode) {
        kotlin.jvm.internal.p.i(errorCode, "errorCode");
        synchronized (this) {
            try {
                if (l() == null) {
                    this.errorCode = errorCode;
                    kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type java.lang.Object");
                    notifyAll();
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void C(long j10) {
        this.writeBytesTotal = j10;
    }

    public final u D(boolean callerIsIdle) throws IOException {
        u uVar;
        synchronized (this) {
            while (this.headersQueue.isEmpty() && l() == null) {
                try {
                    boolean z10 = callerIsIdle || j();
                    if (z10) {
                        this.readTimeout.t();
                    }
                    try {
                        E();
                        if (z10) {
                            this.readTimeout.B();
                        }
                    } catch (Throwable th) {
                        if (z10) {
                            this.readTimeout.B();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (this.headersQueue.isEmpty()) {
                IOException iOException = this.errorException;
                if (iOException != null) {
                    throw iOException;
                }
                ErrorCode errorCodeL = l();
                kotlin.jvm.internal.p.f(errorCodeL);
                throw new StreamResetException(errorCodeL);
            }
            u uVarRemoveFirst = this.headersQueue.removeFirst();
            kotlin.jvm.internal.p.h(uVarRemoveFirst, "removeFirst(...)");
            uVar = uVarRemoveFirst;
        }
        return uVar;
    }

    public final void E() throws InterruptedException, InterruptedIOException {
        try {
            kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final J F() {
        return this.writeTimeout;
    }

    public final void c(long delta) {
        this.writeBytesMaximum += delta;
        if (delta > 0) {
            kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    @Override // Mb.H
    public void cancel() {
        i(ErrorCode.CANCEL);
    }

    public final void d() throws IOException {
        boolean z10;
        boolean zW;
        if (ub.q.f42674b && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                z10 = !getSource().getFinished() && getSource().getClosed() && (getSink().getFinished() || getSink().getClosed());
                zW = w();
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            g(ErrorCode.CANCEL, null);
        } else {
            if (zW) {
                return;
            }
            this.connection.L1(this.id);
        }
    }

    public final void f() throws IOException {
        if (getSink().getClosed()) {
            throw new IOException("stream closed");
        }
        if (getSink().getFinished()) {
            throw new IOException("stream finished");
        }
        if (l() != null) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCodeL = l();
            kotlin.jvm.internal.p.f(errorCodeL);
            throw new StreamResetException(errorCodeL);
        }
    }

    public final void g(ErrorCode rstStatusCode, IOException errorException) throws IOException {
        kotlin.jvm.internal.p.i(rstStatusCode, "rstStatusCode");
        if (h(rstStatusCode, errorException)) {
            this.connection.X1(this.id, rstStatusCode);
        }
    }

    public final boolean h(ErrorCode errorCode, IOException errorException) {
        if (ub.q.f42674b && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (l() != null) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = errorException;
            kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            if (getSource().getFinished() && getSink().getFinished()) {
                return false;
            }
            t tVar = t.f7040a;
            this.connection.L1(this.id);
            return true;
        }
    }

    public final void i(ErrorCode errorCode) {
        kotlin.jvm.internal.p.i(errorCode, "errorCode");
        if (h(errorCode, null)) {
            this.connection.Z1(this.id, errorCode);
        }
    }

    public final boolean j() {
        return !this.connection.getClient() || getSink().getClosed() || getSink().getFinished();
    }

    /* renamed from: k, reason: from getter */
    public final okhttp3.internal.http2.c getConnection() {
        return this.connection;
    }

    public final ErrorCode l() {
        ErrorCode errorCode;
        synchronized (this) {
            errorCode = this.errorCode;
        }
        return errorCode;
    }

    /* renamed from: m, reason: from getter */
    public final IOException getErrorException() {
        return this.errorException;
    }

    /* renamed from: n, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: o, reason: from getter */
    public final WindowCounter getReadBytes() {
        return this.readBytes;
    }

    /* renamed from: p, reason: from getter */
    public final d getReadTimeout() {
        return this.readTimeout;
    }

    @Override // Mb.H
    /* renamed from: q, reason: from getter */
    public b getSink() {
        return this.sink;
    }

    @Override // Mb.H
    /* renamed from: r, reason: from getter */
    public c getSource() {
        return this.source;
    }

    /* renamed from: s, reason: from getter */
    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    /* renamed from: t, reason: from getter */
    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    /* renamed from: u, reason: from getter */
    public final d getWriteTimeout() {
        return this.writeTimeout;
    }

    public final boolean v() {
        return this.connection.getClient() == ((this.id & 1) == 1);
    }

    public final boolean w() {
        synchronized (this) {
            try {
                if (l() != null) {
                    return false;
                }
                if (getSource().getFinished() || getSource().getClosed()) {
                    if (getSink().getFinished() || getSink().getClosed()) {
                        if (this.hasResponseHeaders) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x() {
        /*
            r1 = this;
            monitor-enter(r1)
            Bb.p$c r0 = r1.getSource()     // Catch: java.lang.Throwable -> L1b
            boolean r0 = r0.getFinished()     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L1d
            Bb.p$c r0 = r1.getSource()     // Catch: java.lang.Throwable -> L1b
            Mb.d r0 = r0.getReadBuffer()     // Catch: java.lang.Throwable -> L1b
            boolean r0 = r0.k()     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L1d
            r0 = 1
            goto L1e
        L1b:
            r0 = move-exception
            goto L20
        L1d:
            r0 = 0
        L1e:
            monitor-exit(r1)
            return r0
        L20:
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Bb.p.x():boolean");
    }

    public final J y() {
        return this.readTimeout;
    }

    public final void z(InterfaceC0968f source, int length) throws IOException {
        kotlin.jvm.internal.p.i(source, "source");
        if (!ub.q.f42674b || !Thread.holdsLock(this)) {
            getSource().i(source, length);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }
}
