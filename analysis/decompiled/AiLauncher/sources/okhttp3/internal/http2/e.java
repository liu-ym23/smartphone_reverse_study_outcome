package okhttp3.internal.http2;

import Bb.s;
import Mb.C0966d;
import Mb.InterfaceC0967e;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import okhttp3.internal.http2.b;
import ub.q;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001BB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u000bJ\u001d\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010#\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u0010¢\u0006\u0004\b#\u0010$J/\u0010'\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u0010¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020\f¢\u0006\u0004\b*\u0010\u000fJ%\u0010.\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0010¢\u0006\u0004\b.\u0010/J%\u00103\u001a\u00020\t2\u0006\u00100\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u001d\u00107\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J-\u0010;\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\tH\u0016¢\u0006\u0004\b=\u0010\u000bJ+\u0010?\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b?\u0010@J\u001f\u0010A\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\"\u001a\u000205H\u0002¢\u0006\u0004\bA\u00108R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010DR\u0014\u0010G\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010DR\u0017\u0010Q\u001a\u00020L8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P¨\u0006R"}, d2 = {"Lokhttp3/internal/http2/e;", "Ljava/io/Closeable;", "", "LMb/e;", "sink", "", "client", "<init>", "(LMb/e;Z)V", "LY8/t;", "e", "()V", "LBb/s;", "peerSettings", Const.INTENT_KEY_PKGNAME, "(LBb/s;)V", "", "streamId", "promisedStreamId", "", "LBb/a;", "requestHeaders", "J", "(IILjava/util/List;)V", "flush", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "U", "(ILokhttp3/internal/http2/ErrorCode;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()I", "outFinished", "LMb/d;", "source", "byteCount", Const.INTENT_KEY_BACKGROUND_COMMAND, "(ZILMb/d;I)V", "flags", "buffer", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(IILMb/d;I)V", "settings", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "ack", "payload1", "payload2", "G", "(ZII)V", "lastGoodStreamId", "", "debugData", "m", "(ILokhttp3/internal/http2/ErrorCode;[B)V", "", "windowSizeIncrement", "Y", "(IJ)V", "length", "type", "l", "(IIII)V", "close", "headerBlock", "n", "(ZILjava/util/List;)V", "e0", Const.INTENT_KEY_APIKEY, "LMb/e;", "Z", "c", "LMb/d;", "hpackBuffer", Const.INTENT_KEY_UMID, "I", "maxFrameSize", AlipayXuiIsland.REASON_CLOSED, "Lokhttp3/internal/http2/b$b;", "f", "Lokhttp3/internal/http2/b$b;", "getHpackWriter", "()Lokhttp3/internal/http2/b$b;", "hpackWriter", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class e implements Closeable {

    /* renamed from: h, reason: collision with root package name */
    public static final Logger f37724h = Logger.getLogger(Bb.b.class.getName());

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC0967e sink;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean client;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final C0966d hpackBuffer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int maxFrameSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final b.C0483b hpackWriter;

    public e(InterfaceC0967e sink, boolean z10) {
        p.i(sink, "sink");
        this.sink = sink;
        this.client = z10;
        C0966d c0966d = new C0966d();
        this.hpackBuffer = c0966d;
        this.maxFrameSize = 16384;
        this.hpackWriter = new b.C0483b(0, false, c0966d, 3, null);
    }

    /* renamed from: A, reason: from getter */
    public final int getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public final void G(boolean ack, int payload1, int payload2) throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException(AlipayXuiIsland.REASON_CLOSED);
            }
            l(0, 8, 6, ack ? 1 : 0);
            this.sink.writeInt(payload1);
            this.sink.writeInt(payload2);
            this.sink.flush();
            t tVar = t.f7040a;
        }
    }

    public final void J(int streamId, int promisedStreamId, List<Bb.a> requestHeaders) throws IOException {
        p.i(requestHeaders, "requestHeaders");
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException(AlipayXuiIsland.REASON_CLOSED);
                }
                this.hpackWriter.g(requestHeaders);
                long size = this.hpackBuffer.getSize();
                int iMin = (int) Math.min(this.maxFrameSize - 4, size);
                long j10 = iMin;
                l(streamId, iMin + 4, 5, size == j10 ? 4 : 0);
                this.sink.writeInt(promisedStreamId & Integer.MAX_VALUE);
                this.sink.K(this.hpackBuffer, j10);
                if (size > j10) {
                    e0(streamId, size - j10);
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void U(int streamId, ErrorCode errorCode) throws IOException {
        p.i(errorCode, "errorCode");
        synchronized (this) {
            if (this.closed) {
                throw new IOException(AlipayXuiIsland.REASON_CLOSED);
            }
            if (errorCode.getHttpCode() == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            l(streamId, 4, 3, 0);
            this.sink.writeInt(errorCode.getHttpCode());
            this.sink.flush();
            t tVar = t.f7040a;
        }
    }

    public final void V(s settings) throws IOException {
        p.i(settings, "settings");
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException(AlipayXuiIsland.REASON_CLOSED);
                }
                l(0, settings.i() * 6, 4, 0);
                for (int i10 = 0; i10 < 10; i10++) {
                    if (settings.f(i10)) {
                        this.sink.writeShort(i10);
                        this.sink.writeInt(settings.a(i10));
                    }
                }
                this.sink.flush();
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void Y(int streamId, long windowSizeIncrement) throws IOException {
        int i10;
        long j10;
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException(AlipayXuiIsland.REASON_CLOSED);
                }
                if (windowSizeIncrement == 0 || windowSizeIncrement > 2147483647L) {
                    throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + windowSizeIncrement).toString());
                }
                Logger logger = f37724h;
                if (logger.isLoggable(Level.FINE)) {
                    i10 = streamId;
                    j10 = windowSizeIncrement;
                    logger.fine(Bb.b.f1489a.d(false, i10, 4, j10));
                } else {
                    i10 = streamId;
                    j10 = windowSizeIncrement;
                }
                l(i10, 4, 8, 0);
                this.sink.writeInt((int) j10);
                this.sink.flush();
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(s peerSettings) throws IOException {
        p.i(peerSettings, "peerSettings");
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException(AlipayXuiIsland.REASON_CLOSED);
                }
                this.maxFrameSize = peerSettings.e(this.maxFrameSize);
                if (peerSettings.b() != -1) {
                    this.hpackWriter.e(peerSettings.b());
                }
                l(0, 0, 4, 1);
                this.sink.flush();
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.closed = true;
            this.sink.close();
            t tVar = t.f7040a;
        }
    }

    public final void e() throws IOException {
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException(AlipayXuiIsland.REASON_CLOSED);
                }
                if (this.client) {
                    Logger logger = f37724h;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(q.j(">> CONNECTION " + Bb.b.CONNECTION_PREFACE.t(), new Object[0]));
                    }
                    this.sink.j1(Bb.b.CONNECTION_PREFACE);
                    this.sink.flush();
                    t tVar = t.f7040a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e0(int streamId, long byteCount) throws IOException {
        while (byteCount > 0) {
            long jMin = Math.min(this.maxFrameSize, byteCount);
            byteCount -= jMin;
            l(streamId, (int) jMin, 9, byteCount == 0 ? 4 : 0);
            this.sink.K(this.hpackBuffer, jMin);
        }
    }

    public final void flush() throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException(AlipayXuiIsland.REASON_CLOSED);
            }
            this.sink.flush();
            t tVar = t.f7040a;
        }
    }

    public final void g(boolean outFinished, int streamId, C0966d source, int byteCount) throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException(AlipayXuiIsland.REASON_CLOSED);
            }
            i(streamId, outFinished ? 1 : 0, source, byteCount);
            t tVar = t.f7040a;
        }
    }

    public final void i(int streamId, int flags, C0966d buffer, int byteCount) throws IOException {
        l(streamId, byteCount, 0, flags);
        if (byteCount > 0) {
            InterfaceC0967e interfaceC0967e = this.sink;
            p.f(buffer);
            interfaceC0967e.K(buffer, byteCount);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r9, int r10, int r11, int r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 8
            if (r11 == r0) goto L1d
            java.util.logging.Logger r0 = okhttp3.internal.http2.e.f37724h
            java.util.logging.Level r1 = java.util.logging.Level.FINE
            boolean r1 = r0.isLoggable(r1)
            if (r1 == 0) goto L1d
            Bb.b r2 = Bb.b.f1489a
            r3 = 0
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            java.lang.String r9 = r2.c(r3, r4, r5, r6, r7)
            r0.fine(r9)
            goto L21
        L1d:
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
        L21:
            int r9 = r8.maxFrameSize
            if (r5 > r9) goto L62
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = r9 & r4
            if (r9 != 0) goto L47
            Mb.e r9 = r8.sink
            ub.n.E(r9, r5)
            Mb.e r9 = r8.sink
            r10 = r6 & 255(0xff, float:3.57E-43)
            r9.writeByte(r10)
            Mb.e r9 = r8.sink
            r10 = r7 & 255(0xff, float:3.57E-43)
            r9.writeByte(r10)
            Mb.e r8 = r8.sink
            r9 = 2147483647(0x7fffffff, float:NaN)
            r9 = r9 & r4
            r8.writeInt(r9)
            return
        L47:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "reserved bit set: "
            r8.append(r9)
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        L62:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "FRAME_SIZE_ERROR length > "
            r9.append(r10)
            int r8 = r8.maxFrameSize
            r9.append(r8)
            java.lang.String r8 = ": "
            r9.append(r8)
            r9.append(r5)
            java.lang.String r8 = r9.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.e.l(int, int, int, int):void");
    }

    public final void m(int lastGoodStreamId, ErrorCode errorCode, byte[] debugData) throws IOException {
        p.i(errorCode, "errorCode");
        p.i(debugData, "debugData");
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException(AlipayXuiIsland.REASON_CLOSED);
                }
                if (errorCode.getHttpCode() == -1) {
                    throw new IllegalArgumentException("errorCode.httpCode == -1");
                }
                l(0, debugData.length + 8, 7, 0);
                this.sink.writeInt(lastGoodStreamId);
                this.sink.writeInt(errorCode.getHttpCode());
                if (!(debugData.length == 0)) {
                    this.sink.write(debugData);
                }
                this.sink.flush();
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n(boolean outFinished, int streamId, List<Bb.a> headerBlock) throws IOException {
        p.i(headerBlock, "headerBlock");
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException(AlipayXuiIsland.REASON_CLOSED);
                }
                this.hpackWriter.g(headerBlock);
                long size = this.hpackBuffer.getSize();
                long jMin = Math.min(this.maxFrameSize, size);
                int i10 = size == jMin ? 4 : 0;
                if (outFinished) {
                    i10 |= 1;
                }
                l(streamId, (int) jMin, 1, i10);
                this.sink.K(this.hpackBuffer, jMin);
                if (size > jMin) {
                    e0(streamId, size - jMin);
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
