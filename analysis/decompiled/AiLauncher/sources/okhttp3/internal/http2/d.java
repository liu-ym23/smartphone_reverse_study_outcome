package okhttp3.internal.http2;

import Bb.s;
import Mb.C0966d;
import Mb.I;
import Mb.InterfaceC0968f;
import Mb.J;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import okhttp3.internal.http2.b;
import okio.ByteString;
import ub.n;
import ub.q;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0003),'B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J5\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001d\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001d\u0010\u0017J/\u0010\u001e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001e\u0010\u0017J\u001f\u0010\u001f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001f\u0010 J/\u0010!\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b!\u0010\u0017J/\u0010\"\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\"\u0010\u0017J/\u0010#\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b#\u0010\u0017J/\u0010$\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b$\u0010\u0017J/\u0010%\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b%\u0010\u0017J/\u0010&\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b&\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00063"}, d2 = {"Lokhttp3/internal/http2/d;", "Ljava/io/Closeable;", "LMb/f;", "source", "", "client", "<init>", "(LMb/f;Z)V", "Lokhttp3/internal/http2/d$c;", "handler", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lokhttp3/internal/http2/d$c;)V", "requireSettings", "e", "(ZLokhttp3/internal/http2/d$c;)Z", "close", "()V", "", "length", "flags", "streamId", "n", "(Lokhttp3/internal/http2/d$c;III)V", "padding", "", "LBb/a;", "m", "(IIII)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "J", "G", "(Lokhttp3/internal/http2/d$c;I)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Y", "U", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "l", "e0", Const.INTENT_KEY_APIKEY, "LMb/f;", Const.INTENT_KEY_PKGNAME, "Z", "Lokhttp3/internal/http2/d$b;", "c", "Lokhttp3/internal/http2/d$b;", "continuation", "Lokhttp3/internal/http2/b$a;", Const.INTENT_KEY_UMID, "Lokhttp3/internal/http2/b$a;", "hpackReader", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class d implements Closeable {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f37713f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC0968f source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean client;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final b continuation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final b.a hpackReader;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/http2/d$a;", "", "<init>", "()V", "", "length", "flags", "padding", Const.INTENT_KEY_PKGNAME, "(III)I", "Ljava/util/logging/Logger;", "logger", "Ljava/util/logging/Logger;", Const.INTENT_KEY_APIKEY, "()Ljava/util/logging/Logger;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: okhttp3.internal.http2.d$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Logger a() {
            return d.f37713f;
        }

        public final int b(int length, int flags, int padding) throws IOException {
            if ((flags & 8) != 0) {
                length--;
            }
            if (padding <= length) {
                return length - padding;
            }
            throw new IOException("PROTOCOL_ERROR padding " + padding + " > remaining length " + length);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010\"\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\"\u0010%\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001a¨\u0006&"}, d2 = {"Lokhttp3/internal/http2/d$b;", "LMb/I;", "LMb/f;", "source", "<init>", "(LMb/f;)V", "LMb/d;", "sink", "", "byteCount", "u0", "(LMb/d;J)J", "LMb/J;", "c", "()LMb/J;", "LY8/t;", "close", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "LMb/f;", "", "I", "getFlags", "()I", "e", "(I)V", "flags", "getStreamId", "l", "streamId", Const.INTENT_KEY_UMID, "getLeft", Const.INTENT_KEY_BACKGROUND_COMMAND, "left", "getPadding", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "padding", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements I {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC0968f source;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int flags;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int streamId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public int left;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public int padding;

        public b(InterfaceC0968f source) {
            p.i(source, "source");
            this.source = source;
        }

        public final void b() throws IOException {
            int i10 = this.streamId;
            int iX = n.x(this.source);
            this.left = iX;
            int iB = n.b(this.source.readByte(), 255);
            this.flags = n.b(this.source.readByte(), 255);
            Companion companion = d.INSTANCE;
            if (companion.a().isLoggable(Level.FINE)) {
                companion.a().fine(Bb.b.f1489a.c(true, this.streamId, iX, iB, this.flags));
            }
            int i11 = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = i11;
            if (iB == 9) {
                if (i11 != i10) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iB + " != TYPE_CONTINUATION");
            }
        }

        @Override // Mb.I
        /* renamed from: c */
        public J getTimeout() {
            return this.source.getTimeout();
        }

        @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final void e(int i10) {
            this.flags = i10;
        }

        public final void g(int i10) {
            this.left = i10;
        }

        public final void i(int i10) {
            this.padding = i10;
        }

        public final void l(int i10) {
            this.streamId = i10;
        }

        @Override // Mb.I
        public long u0(C0966d sink, long byteCount) throws IOException {
            p.i(sink, "sink");
            while (true) {
                int i10 = this.left;
                if (i10 != 0) {
                    long jU0 = this.source.u0(sink, Math.min(byteCount, i10));
                    if (jU0 == -1) {
                        return -1L;
                    }
                    this.left -= (int) jU0;
                    return jU0;
                }
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                b();
            }
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH&¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010 \u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H&¢\u0006\u0004\b \u0010!J'\u0010%\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H&¢\u0006\u0004\b)\u0010*J/\u0010.\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0002H&¢\u0006\u0004\b.\u0010/J-\u00102\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b2\u00103ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00064À\u0006\u0001"}, d2 = {"Lokhttp3/internal/http2/d$c;", "", "", "inFinished", "", "streamId", "LMb/f;", "source", "length", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(ZILMb/f;I)V", "associatedStreamId", "", "LBb/a;", "headerBlock", "c", "(ZIILjava/util/List;)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(ILokhttp3/internal/http2/ErrorCode;)V", "clearPrevious", "LBb/s;", "settings", Const.INTENT_KEY_APIKEY, "(ZLBb/s;)V", "f", "()V", "ack", "payload1", "payload2", Const.INTENT_KEY_BACKGROUND_COMMAND, "(ZII)V", "lastGoodStreamId", "Lokio/ByteString;", "debugData", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(ILokhttp3/internal/http2/ErrorCode;Lokio/ByteString;)V", "", "windowSizeIncrement", Const.INTENT_KEY_UMID, "(IJ)V", "streamDependency", "weight", "exclusive", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(IIIZ)V", "promisedStreamId", "requestHeaders", "e", "(IILjava/util/List;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface c {
        void a(boolean clearPrevious, s settings);

        void b(boolean inFinished, int streamId, InterfaceC0968f source, int length) throws IOException;

        void c(boolean inFinished, int streamId, int associatedStreamId, List<Bb.a> headerBlock);

        void d(int streamId, long windowSizeIncrement);

        void e(int streamId, int promisedStreamId, List<Bb.a> requestHeaders) throws IOException;

        void f();

        void g(boolean ack, int payload1, int payload2);

        void h(int streamId, int streamDependency, int weight, boolean exclusive);

        void i(int streamId, ErrorCode errorCode);

        void j(int lastGoodStreamId, ErrorCode errorCode, ByteString debugData);
    }

    static {
        Logger logger = Logger.getLogger(Bb.b.class.getName());
        p.h(logger, "getLogger(...)");
        f37713f = logger;
    }

    public d(InterfaceC0968f source, boolean z10) {
        p.i(source, "source");
        this.source = source;
        this.client = z10;
        b bVar = new b(source);
        this.continuation = bVar;
        this.hpackReader = new b.a(bVar, 4096, 0, 4, null);
    }

    public final void A(c handler, int length, int flags, int streamId) throws IOException {
        if (length != 8) {
            throw new IOException("TYPE_PING length != 8: " + length);
        }
        if (streamId != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.g((flags & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    public final void G(c handler, int streamId) throws IOException {
        int i10 = this.source.readInt();
        handler.h(streamId, i10 & Integer.MAX_VALUE, n.b(this.source.readByte(), 255) + 1, (Integer.MIN_VALUE & i10) != 0);
    }

    public final void J(c handler, int length, int flags, int streamId) throws IOException {
        if (length == 5) {
            if (streamId == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            G(handler, streamId);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + length + " != 5");
        }
    }

    public final void U(c handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iB = (flags & 8) != 0 ? n.b(this.source.readByte(), 255) : 0;
        handler.e(streamId, this.source.readInt() & Integer.MAX_VALUE, m(INSTANCE.b(length - 4, flags, iB), iB, flags, streamId));
    }

    public final void V(c handler, int length, int flags, int streamId) throws IOException {
        if (length != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + length + " != 4");
        }
        if (streamId == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i10 = this.source.readInt();
        ErrorCode errorCodeA = ErrorCode.INSTANCE.a(i10);
        if (errorCodeA != null) {
            handler.i(streamId, errorCodeA);
            return;
        }
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
    
        throw new java.io.IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y(okhttp3.internal.http2.d.c r7, int r8, int r9, int r10) throws java.io.IOException {
        /*
            r6 = this;
            if (r10 != 0) goto Lb3
            r10 = 1
            r9 = r9 & r10
            if (r9 == 0) goto L14
            if (r8 != 0) goto Lc
            r7.f()
            return
        Lc:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r7 = "FRAME_SIZE_ERROR ack frame should be empty!"
            r6.<init>(r7)
            throw r6
        L14:
            int r9 = r8 % 6
            if (r9 != 0) goto L9c
            Bb.s r9 = new Bb.s
            r9.<init>()
            r0 = 0
            v9.i r8 = v9.C5685n.s(r0, r8)
            r1 = 6
            v9.g r8 = v9.C5685n.r(r8, r1)
            int r1 = r8.getFirst()
            int r2 = r8.getLast()
            int r8 = r8.getStep()
            if (r8 <= 0) goto L37
            if (r1 <= r2) goto L3b
        L37:
            if (r8 >= 0) goto L98
            if (r2 > r1) goto L98
        L3b:
            Mb.f r3 = r6.source
            short r3 = r3.readShort()
            r4 = 65535(0xffff, float:9.1834E-41)
            int r3 = ub.n.c(r3, r4)
            Mb.f r4 = r6.source
            int r4 = r4.readInt()
            r5 = 2
            if (r3 == r5) goto L84
            r5 = 4
            if (r3 == r5) goto L79
            r5 = 5
            if (r3 == r5) goto L58
            goto L91
        L58:
            r5 = 16384(0x4000, float:2.2959E-41)
            if (r4 < r5) goto L62
            r5 = 16777215(0xffffff, float:2.3509886E-38)
            if (r4 > r5) goto L62
            goto L91
        L62:
            java.io.IOException r6 = new java.io.IOException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L79:
            if (r4 < 0) goto L7c
            goto L91
        L7c:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r7 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"
            r6.<init>(r7)
            throw r6
        L84:
            if (r4 == 0) goto L91
            if (r4 != r10) goto L89
            goto L91
        L89:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r7 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"
            r6.<init>(r7)
            throw r6
        L91:
            r9.h(r3, r4)
            if (r1 == r2) goto L98
            int r1 = r1 + r8
            goto L3b
        L98:
            r7.a(r0, r9)
            return
        L9c:
            java.io.IOException r6 = new java.io.IOException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "TYPE_SETTINGS length % 6 != 0: "
            r7.append(r9)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        Lb3:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r7 = "TYPE_SETTINGS streamId != 0"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.d.Y(okhttp3.internal.http2.d$c, int, int, int):void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public final boolean e(boolean requireSettings, c handler) throws Exception {
        p.i(handler, "handler");
        try {
            this.source.j(9L);
            int iX = n.x(this.source);
            if (iX > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + iX);
            }
            int iB = n.b(this.source.readByte(), 255);
            int iB2 = n.b(this.source.readByte(), 255);
            int i10 = this.source.readInt() & Integer.MAX_VALUE;
            if (iB != 8) {
                Logger logger = f37713f;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Bb.b.f1489a.c(true, i10, iX, iB, iB2));
                }
            }
            if (requireSettings && iB != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + Bb.b.f1489a.b(iB));
            }
            switch (iB) {
                case 0:
                    i(handler, iX, iB2, i10);
                    return true;
                case 1:
                    n(handler, iX, iB2, i10);
                    return true;
                case 2:
                    J(handler, iX, iB2, i10);
                    return true;
                case 3:
                    V(handler, iX, iB2, i10);
                    return true;
                case 4:
                    Y(handler, iX, iB2, i10);
                    return true;
                case 5:
                    U(handler, iX, iB2, i10);
                    return true;
                case 6:
                    A(handler, iX, iB2, i10);
                    return true;
                case 7:
                    l(handler, iX, iB2, i10);
                    return true;
                case 8:
                    e0(handler, iX, iB2, i10);
                    return true;
                default:
                    this.source.skip(iX);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void e0(c handler, int length, int flags, int streamId) throws Exception {
        int i10;
        try {
            if (length != 4) {
                throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + length);
            }
            try {
                long jD = n.d(this.source.readInt(), 2147483647L);
                if (jD == 0) {
                    throw new IOException("windowSizeIncrement was 0");
                }
                Logger logger = f37713f;
                if (logger.isLoggable(Level.FINE)) {
                    i10 = streamId;
                    logger.fine(Bb.b.f1489a.d(true, streamId, length, jD));
                } else {
                    i10 = streamId;
                }
                handler.d(i10, jD);
            } catch (Exception e10) {
                e = e10;
                Exception exc = e;
                f37713f.fine(Bb.b.f1489a.c(true, streamId, length, 8, flags));
                throw exc;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public final void g(c handler) throws IOException {
        p.i(handler, "handler");
        if (this.client) {
            if (!e(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        InterfaceC0968f interfaceC0968f = this.source;
        ByteString byteString = Bb.b.CONNECTION_PREFACE;
        ByteString byteStringZ0 = interfaceC0968f.z0(byteString.K());
        Logger logger = f37713f;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(q.j("<< CONNECTION " + byteStringZ0.t(), new Object[0]));
        }
        if (p.d(byteString, byteStringZ0)) {
            return;
        }
        throw new IOException("Expected a connection header but was " + byteStringZ0.Q());
    }

    public final void i(c handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z10 = (flags & 1) != 0;
        if ((flags & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iB = (flags & 8) != 0 ? n.b(this.source.readByte(), 255) : 0;
        handler.b(z10, streamId, this.source, INSTANCE.b(length, flags, iB));
        this.source.skip(iB);
    }

    public final void l(c handler, int length, int flags, int streamId) throws IOException {
        if (length < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + length);
        }
        if (streamId != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i10 = this.source.readInt();
        int i11 = this.source.readInt();
        int i12 = length - 8;
        ErrorCode errorCodeA = ErrorCode.INSTANCE.a(i11);
        if (errorCodeA == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + i11);
        }
        ByteString byteStringZ0 = ByteString.f37756e;
        if (i12 > 0) {
            byteStringZ0 = this.source.z0(i12);
        }
        handler.j(i10, errorCodeA, byteStringZ0);
    }

    public final List<Bb.a> m(int length, int padding, int flags, int streamId) throws IOException {
        this.continuation.g(length);
        this.continuation.i(padding);
        this.continuation.e(flags);
        this.continuation.l(streamId);
        this.hpackReader.l();
        return this.hpackReader.f();
    }

    public final void n(c handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z10 = (flags & 1) != 0;
        int iB = (flags & 8) != 0 ? n.b(this.source.readByte(), 255) : 0;
        if ((flags & 32) != 0) {
            G(handler, streamId);
            length -= 5;
        }
        handler.c(z10, streamId, -1, m(INSTANCE.b(length, flags, iB), iB, flags, streamId));
    }
}
