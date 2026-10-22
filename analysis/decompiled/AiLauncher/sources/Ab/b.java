package Ab;

import La.D;
import La.H;
import Mb.C0966d;
import Mb.C0975m;
import Mb.G;
import Mb.I;
import Mb.InterfaceC0967e;
import Mb.J;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.sse.ServerSentEventKt;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.AbstractC5529B;
import tb.C5528A;
import tb.C5530C;
import tb.InterfaceC5546m;
import tb.u;
import tb.v;
import tb.z;
import ub.n;
import ub.q;
import yb.InterfaceC6020a;
import zb.C6481e;
import zb.InterfaceC6480d;
import zb.i;
import zb.k;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 72\u00020\u0001:\u0007H ($*7-B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00102\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00122\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u001aH\u0016¢\u0006\u0004\b,\u0010#J\u000f\u0010-\u001a\u00020\u001aH\u0016¢\u0006\u0004\b-\u0010#J\u001d\u00102\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J\u0019\u00107\u001a\u0004\u0018\u0001062\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b7\u00108J\u0015\u00109\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b9\u0010:R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010;R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010<\u001a\u0004\b=\u0010>R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u000204*\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0018\u0010M\u001a\u000204*\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010Q\u001a\u0002048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010P¨\u0006R"}, d2 = {"LAb/b;", "Lzb/d;", "Ltb/z;", "client", "Lzb/d$a;", "carrier", "Lyb/a;", "socket", "<init>", "(Ltb/z;Lzb/d$a;Lyb/a;)V", "LMb/G;", "v", "()LMb/G;", "y", "Ltb/v;", "url", "", "length", "LMb/I;", "x", "(Ltb/v;J)LMb/I;", "w", "(Ltb/v;)LMb/I;", "z", "LMb/m;", "timeout", "LY8/t;", "r", "(LMb/m;)V", "Ltb/A;", "request", "contentLength", Const.INTENT_KEY_PKGNAME, "(Ltb/A;J)LMb/G;", "cancel", "()V", "e", "(Ltb/A;)V", "Ltb/C;", UxipConstants.f30685x, Const.INTENT_KEY_APIKEY, "(Ltb/C;)J", "c", "(Ltb/C;)LMb/I;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_UMID, "Ltb/u;", "headers", "", "requestLine", "B", "(Ltb/u;Ljava/lang/String;)V", "", "expectContinue", "Ltb/C$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Z)Ltb/C$a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ltb/C;)V", "Ltb/z;", "Lzb/d$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lzb/d$a;", "Lyb/a;", "s", "()Lyb/a;", "", "I", VoiceWakeupReceiver.EXTRA_STATE, "LAb/a;", "LAb/a;", "headersReader", "f", "Ltb/u;", "trailers", "u", "(Ltb/C;)Z", "isChunked", "t", "(Ltb/A;)Z", "()Z", "isResponseComplete", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class b implements InterfaceC6480d {

    /* renamed from: h, reason: collision with root package name */
    public static final u f1361h = u.INSTANCE.a("OkHttp-Response-Body", "Truncated");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final z client;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC6480d.a carrier;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC6020a socket;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int state;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Ab.a headersReader;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public u trailers;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b¢\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\u00188\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006$"}, d2 = {"LAb/b$a;", "LMb/I;", "Ltb/v;", "url", "<init>", "(LAb/b;Ltb/v;)V", "LMb/J;", "c", "()LMb/J;", "LMb/d;", "sink", "", "byteCount", "u0", "(LMb/d;J)J", "Ltb/u;", "trailers", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ltb/u;)V", Const.INTENT_KEY_APIKEY, "Ltb/v;", "getUrl", "()Ltb/v;", "LMb/m;", "LMb/m;", "getTimeout", "()LMb/m;", "timeout", "", "Z", "getClosed", "()Z", "e", "(Z)V", AlipayXuiIsland.REASON_CLOSED, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public abstract class a implements I {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final v url;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final C0975m timeout;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public boolean closed;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f1371d;

        public a(b bVar, v url) {
            p.i(url, "url");
            this.f1371d = bVar;
            this.url = url;
            this.timeout = new C0975m(bVar.i().getSource().getTimeout());
        }

        public final void b(u trailers) {
            z zVar;
            InterfaceC5546m cookieJar;
            p.i(trailers, "trailers");
            if (this.f1371d.state == 6) {
                return;
            }
            if (this.f1371d.state != 5) {
                throw new IllegalStateException("state: " + this.f1371d.state);
            }
            this.f1371d.r(this.timeout);
            this.f1371d.trailers = trailers;
            this.f1371d.state = 6;
            if (trailers.size() <= 0 || (zVar = this.f1371d.client) == null || (cookieJar = zVar.getCookieJar()) == null) {
                return;
            }
            C6481e.g(cookieJar, this.url, trailers);
        }

        @Override // Mb.I
        /* renamed from: c */
        public J getTimeout() {
            return this.timeout;
        }

        public final void e(boolean z10) {
            this.closed = z10;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        @Override // Mb.I
        public long u0(C0966d sink, long byteCount) throws IOException {
            p.i(sink, "sink");
            try {
                return this.f1371d.i().getSource().u0(sink, byteCount);
            } catch (IOException e10) {
                this.f1371d.getCarrier().b();
                this.b(b.f1361h);
                throw e10;
            }
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"LAb/b$b;", "LMb/G;", "<init>", "(LAb/b;)V", "LMb/J;", "c", "()LMb/J;", "LMb/d;", "source", "", "byteCount", "LY8/t;", "K", "(LMb/d;J)V", "flush", "()V", "close", "LMb/m;", Const.INTENT_KEY_APIKEY, "LMb/m;", "timeout", "", Const.INTENT_KEY_PKGNAME, "Z", AlipayXuiIsland.REASON_CLOSED, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Ab.b$b, reason: collision with other inner class name */
    public final class C0006b implements G {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final C0975m timeout;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public boolean closed;

        public C0006b() {
            this.timeout = new C0975m(b.this.i().getSink().getTimeout());
        }

        @Override // Mb.G
        public void K(C0966d source, long byteCount) throws IOException {
            p.i(source, "source");
            if (this.closed) {
                throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
            }
            if (byteCount == 0) {
                return;
            }
            InterfaceC0967e sink = b.this.i().getSink();
            sink.W0(byteCount);
            sink.L(ServerSentEventKt.END_OF_LINE);
            sink.K(source, byteCount);
            sink.L(ServerSentEventKt.END_OF_LINE);
        }

        @Override // Mb.G
        /* renamed from: c */
        public J getTimeout() {
            return this.timeout;
        }

        @Override // Mb.G, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            b.this.i().getSink().L("0\r\n\r\n");
            b.this.r(this.timeout);
            b.this.state = 3;
        }

        @Override // Mb.G, java.io.Flushable
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            b.this.i().getSink().flush();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"LAb/b$c;", "LAb/b$a;", "LAb/b;", "Ltb/v;", "url", "<init>", "(LAb/b;Ltb/v;)V", "LMb/d;", "sink", "", "byteCount", "u0", "(LMb/d;J)J", "LY8/t;", "close", "()V", Const.INTENT_KEY_BACKGROUND_COMMAND, "e", "J", "bytesRemainingInChunk", "", "f", "Z", "hasMoreChunks", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class c extends a {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public long bytesRemainingInChunk;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public boolean hasMoreChunks;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ b f1377g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, v url) {
            super(bVar, url);
            p.i(url, "url");
            this.f1377g = bVar;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !q.i(this, 100, TimeUnit.MILLISECONDS)) {
                this.f1377g.getCarrier().b();
                b(b.f1361h);
            }
            e(true);
        }

        public final void g() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                this.f1377g.i().getSource().h0();
            }
            try {
                this.bytesRemainingInChunk = this.f1377g.i().getSource().p1();
                String string = H.D1(this.f1377g.i().getSource().h0()).toString();
                if (this.bytesRemainingInChunk >= 0 && (string.length() <= 0 || D.X(string, Const.STR_MART_SEMICOLON, false, 2, null))) {
                    if (this.bytesRemainingInChunk == 0) {
                        this.hasMoreChunks = false;
                        b(this.f1377g.headersReader.a());
                        return;
                    }
                    return;
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + string + JsonFactory.DEFAULT_QUOTE_CHAR);
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }

        @Override // Ab.b.a, Mb.I
        public long u0(C0966d sink, long byteCount) throws IOException {
            p.i(sink, "sink");
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            long j10 = this.bytesRemainingInChunk;
            if (j10 == 0 || j10 == -1) {
                g();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long jU0 = super.u0(sink, Math.min(byteCount, this.bytesRemainingInChunk));
            if (jU0 != -1) {
                this.bytesRemainingInChunk -= jU0;
                return jU0;
            }
            this.f1377g.getCarrier().b();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            b(b.f1361h);
            throw protocolException;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"LAb/b$e;", "LAb/b$a;", "LAb/b;", "Ltb/v;", "url", "", "bytesRemaining", "<init>", "(LAb/b;Ltb/v;J)V", "LMb/d;", "sink", "byteCount", "u0", "(LMb/d;J)J", "LY8/t;", "close", "()V", "e", "J", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class e extends a {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public long bytesRemaining;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f1379f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(b bVar, v url, long j10) {
            super(bVar, url);
            p.i(url, "url");
            this.f1379f = bVar;
            this.bytesRemaining = j10;
            if (j10 == 0) {
                b(u.f42241c);
            }
        }

        @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0 && !q.i(this, 100, TimeUnit.MILLISECONDS)) {
                this.f1379f.getCarrier().b();
                b(b.f1361h);
            }
            e(true);
        }

        @Override // Ab.b.a, Mb.I
        public long u0(C0966d sink, long byteCount) throws IOException {
            p.i(sink, "sink");
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
            }
            long j10 = this.bytesRemaining;
            if (j10 == 0) {
                return -1L;
            }
            long jU0 = super.u0(sink, Math.min(j10, byteCount));
            if (jU0 == -1) {
                this.f1379f.getCarrier().b();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b(b.f1361h);
                throw protocolException;
            }
            long j11 = this.bytesRemaining - jU0;
            this.bytesRemaining = j11;
            if (j11 == 0) {
                b(u.f42241c);
            }
            return jU0;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"LAb/b$f;", "LMb/G;", "<init>", "(LAb/b;)V", "LMb/J;", "c", "()LMb/J;", "LMb/d;", "source", "", "byteCount", "LY8/t;", "K", "(LMb/d;J)V", "flush", "()V", "close", "LMb/m;", Const.INTENT_KEY_APIKEY, "LMb/m;", "timeout", "", Const.INTENT_KEY_PKGNAME, "Z", AlipayXuiIsland.REASON_CLOSED, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class f implements G {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final C0975m timeout;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public boolean closed;

        public f() {
            this.timeout = new C0975m(b.this.i().getSink().getTimeout());
        }

        @Override // Mb.G
        public void K(C0966d source, long byteCount) throws IOException {
            p.i(source, "source");
            if (this.closed) {
                throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
            }
            n.e(source.getSize(), 0L, byteCount);
            b.this.i().getSink().K(source, byteCount);
        }

        @Override // Mb.G
        /* renamed from: c */
        public J getTimeout() {
            return this.timeout;
        }

        @Override // Mb.G, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            b.this.r(this.timeout);
            b.this.state = 3;
        }

        @Override // Mb.G, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed) {
                return;
            }
            b.this.i().getSink().flush();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"LAb/b$g;", "LAb/b$a;", "LAb/b;", "Ltb/v;", "url", "<init>", "(LAb/b;Ltb/v;)V", "LMb/d;", "sink", "", "byteCount", "u0", "(LMb/d;J)J", "LY8/t;", "close", "()V", "", "e", "Z", "inputExhausted", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class g extends a {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public boolean inputExhausted;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f1384f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(b bVar, v url) {
            super(bVar, url);
            p.i(url, "url");
            this.f1384f = bVar;
        }

        @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                b(b.f1361h);
            }
            e(true);
        }

        @Override // Ab.b.a, Mb.I
        public long u0(C0966d sink, long byteCount) throws IOException {
            p.i(sink, "sink");
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long jU0 = super.u0(sink, byteCount);
            if (jU0 != -1) {
                return jU0;
            }
            this.inputExhausted = true;
            b(u.f42241c);
            return -1L;
        }
    }

    public b(z zVar, InterfaceC6480d.a carrier, InterfaceC6020a socket) {
        p.i(carrier, "carrier");
        p.i(socket, "socket");
        this.client = zVar;
        this.carrier = carrier;
        this.socket = socket;
        this.headersReader = new Ab.a(i().getSource());
    }

    public final void A(C5530C response) throws IOException {
        p.i(response, "response");
        long jK = q.k(response);
        if (jK == -1) {
            return;
        }
        I iX = x(response.getRequest().getUrl(), jK);
        q.p(iX, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        iX.close();
    }

    public final void B(u headers, String requestLine) throws IOException {
        p.i(headers, "headers");
        p.i(requestLine, "requestLine");
        if (this.state != 0) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        i().getSink().L(requestLine).L(ServerSentEventKt.END_OF_LINE);
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            i().getSink().L(headers.f(i10)).L(": ").L(headers.k(i10)).L(ServerSentEventKt.END_OF_LINE);
        }
        i().getSink().L(ServerSentEventKt.END_OF_LINE);
        this.state = 1;
    }

    @Override // zb.InterfaceC6480d
    public long a(C5530C response) {
        p.i(response, "response");
        if (!C6481e.c(response)) {
            return 0L;
        }
        if (u(response)) {
            return -1L;
        }
        return q.k(response);
    }

    @Override // zb.InterfaceC6480d
    public G b(C5528A request, long contentLength) throws ProtocolException {
        p.i(request, "request");
        AbstractC5529B body = request.getBody();
        if (body != null && body.e()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (t(request)) {
            return v();
        }
        if (contentLength != -1) {
            return y();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // zb.InterfaceC6480d
    public I c(C5530C response) {
        p.i(response, "response");
        if (!C6481e.c(response)) {
            return x(response.getRequest().getUrl(), 0L);
        }
        if (u(response)) {
            return w(response.getRequest().getUrl());
        }
        long jK = q.k(response);
        return jK != -1 ? x(response.getRequest().getUrl(), jK) : z(response.getRequest().getUrl());
    }

    @Override // zb.InterfaceC6480d
    public void cancel() {
        getCarrier().cancel();
    }

    @Override // zb.InterfaceC6480d
    public void d() throws IOException {
        i().getSink().flush();
    }

    @Override // zb.InterfaceC6480d
    public void e(C5528A request) throws IOException {
        p.i(request, "request");
        i iVar = i.f45464a;
        Proxy.Type type = getCarrier().getM5.a.CARD_TYPE_ROUTE java.lang.String().getProxy().type();
        p.h(type, "type(...)");
        B(request.getHeaders(), iVar.a(request, type));
    }

    @Override // zb.InterfaceC6480d
    public boolean f() {
        return this.state == 6;
    }

    @Override // zb.InterfaceC6480d
    public C5530C.a g(boolean expectContinue) throws IOException {
        int i10 = this.state;
        if (i10 != 0 && i10 != 1 && i10 != 2 && i10 != 3) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        try {
            k kVarA = k.INSTANCE.a(this.headersReader.b());
            C5530C.a aVarJ = new C5530C.a().o(kVarA.protocol).f(kVarA.code).l(kVarA.message).j(this.headersReader.a());
            if (expectContinue && kVarA.code == 100) {
                return null;
            }
            int i11 = kVarA.code;
            if (i11 == 100) {
                this.state = 3;
                return aVarJ;
            }
            if (102 > i11 || i11 >= 200) {
                this.state = 4;
                return aVarJ;
            }
            this.state = 3;
            return aVarJ;
        } catch (EOFException e10) {
            throw new IOException("unexpected end of stream on " + getCarrier().getM5.a.CARD_TYPE_ROUTE java.lang.String().getAddress().getUrl().r(), e10);
        }
    }

    @Override // zb.InterfaceC6480d
    public void h() throws IOException {
        i().getSink().flush();
    }

    @Override // zb.InterfaceC6480d
    /* renamed from: j, reason: from getter */
    public InterfaceC6480d.a getCarrier() {
        return this.carrier;
    }

    public final void r(C0975m timeout) {
        J delegate = timeout.getDelegate();
        timeout.k(J.f4694f);
        delegate.b();
        delegate.c();
    }

    @Override // zb.InterfaceC6480d
    /* renamed from: s, reason: from getter and merged with bridge method [inline-methods] */
    public InterfaceC6020a i() {
        return this.socket;
    }

    public final boolean t(C5528A c5528a) {
        return D.L(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30859r, c5528a.e(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30846e), true);
    }

    public final boolean u(C5530C c5530c) {
        return D.L(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30859r, C5530C.J(c5530c, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30846e, null, 2, null), true);
    }

    public final G v() {
        if (this.state == 1) {
            this.state = 2;
            return new C0006b();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    public final I w(v url) {
        if (this.state == 4) {
            this.state = 5;
            return new c(this, url);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    public final I x(v url, long length) {
        if (this.state == 4) {
            this.state = 5;
            return new e(this, url, length);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    public final G y() {
        if (this.state == 1) {
            this.state = 2;
            return new f();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    public final I z(v url) {
        if (this.state == 4) {
            this.state = 5;
            getCarrier().b();
            return new g(this, url);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }
}
