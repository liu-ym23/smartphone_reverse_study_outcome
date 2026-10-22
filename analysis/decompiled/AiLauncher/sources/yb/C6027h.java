package yb;

import Mb.AbstractC0973k;
import Mb.AbstractC0974l;
import Mb.C0966d;
import Mb.G;
import Mb.H;
import Mb.I;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import kotlin.Metadata;
import tb.AbstractC5529B;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;
import zb.InterfaceC6480d;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00024/B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0015J\r\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b!\u0010\"J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\f¢\u0006\u0004\b&\u0010\u0015J\r\u0010'\u001a\u00020\f¢\u0006\u0004\b'\u0010\u0015J\r\u0010(\u001a\u00020\f¢\u0006\u0004\b(\u0010\u0015J?\u0010/\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010.¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\f¢\u0006\u0004\b1\u0010\u0015J\u0017\u00102\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020.H\u0002¢\u0006\u0004\b2\u00103R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b/\u00108\u001a\u0004\b9\u0010:R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R$\u0010A\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u000f8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b'\u0010>\u001a\u0004\b?\u0010@R$\u0010C\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u000f8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u0012\u0010>\u001a\u0004\bB\u0010@R\u0014\u0010G\u001a\u00020D8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bH\u0010@¨\u0006J"}, d2 = {"Lyb/h;", "", "Lyb/m;", "call", "Lyb/i;", "finder", "Lzb/d;", "codec", "<init>", "(Lyb/m;Lyb/i;Lzb/d;)V", "Ltb/A;", "request", "LY8/t;", "w", "(Ltb/A;)V", "", "duplex", "LMb/G;", "e", "(Ltb/A;Z)LMb/G;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", Const.INTENT_KEY_BACKGROUND_COMMAND, "t", "expectContinue", "Ltb/C$a;", "r", "(Z)Ltb/C$a;", "Ltb/C;", UxipConstants.f30685x, "s", "(Ltb/C;)V", "Ltb/D;", "q", "(Ltb/C;)Ltb/D;", "LMb/H;", "v", "()LMb/H;", "o", Const.INTENT_KEY_UMID, "f", "", "bytesRead", "isSocket", "responseDone", "requestDone", "Ljava/io/IOException;", Const.INTENT_KEY_PKGNAME, "(JZZZLjava/io/IOException;)Ljava/io/IOException;", "p", "u", "(Ljava/io/IOException;)V", Const.INTENT_KEY_APIKEY, "Lyb/m;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lyb/m;", "Lyb/i;", "k", "()Lyb/i;", "c", "Lzb/d;", UxipConstants.f30680s, "Z", "n", "()Z", "isDuplex", "l", "hasFailure", "Lyb/n;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lyb/n;", "connection", "m", "isCoalescedConnection", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6027h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6032m call;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC6028i finder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC6480d codec;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean isDuplex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean hasFailure;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019¨\u0006!"}, d2 = {"Lyb/h$a;", "LMb/k;", "LMb/G;", "delegate", "", "contentLength", "", "isSocket", "<init>", "(Lyb/h;LMb/G;JZ)V", "Ljava/io/IOException;", "e", Const.INTENT_KEY_PKGNAME, "(Ljava/io/IOException;)Ljava/io/IOException;", "LMb/d;", "source", "byteCount", "LY8/t;", "K", "(LMb/d;J)V", "flush", "()V", "close", Const.INTENT_KEY_APIKEY, "J", "Z", "c", "completed", Const.INTENT_KEY_UMID, "bytesReceived", "invokeStartEvent", "f", AlipayXuiIsland.REASON_CLOSED, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.h$a */
    public final class a extends AbstractC0973k {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final long contentLength;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final boolean isSocket;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public boolean completed;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public long bytesReceived;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public boolean invokeStartEvent;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public boolean closed;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ C6027h f44188g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C6027h c6027h, G delegate, long j10, boolean z10) {
            super(delegate);
            kotlin.jvm.internal.p.i(delegate, "delegate");
            this.f44188g = c6027h;
            this.contentLength = j10;
            this.isSocket = z10;
            this.invokeStartEvent = z10;
        }

        private final IOException b(IOException e10) {
            if (this.completed) {
                return e10;
            }
            this.completed = true;
            return C6027h.c(this.f44188g, this.bytesReceived, this.isSocket, false, true, e10, 4, null);
        }

        @Override // Mb.AbstractC0973k, Mb.G
        public void K(C0966d source, long byteCount) throws IOException {
            kotlin.jvm.internal.p.i(source, "source");
            if (this.closed) {
                throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
            }
            long j10 = this.contentLength;
            if (j10 != -1 && this.bytesReceived + byteCount > j10) {
                throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + byteCount));
            }
            try {
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.f44188g.getCall().getEventListener().t(this.f44188g.getCall());
                }
                super.K(source, byteCount);
                this.bytesReceived += byteCount;
            } catch (IOException e10) {
                IOException iOExceptionB = b(e10);
                kotlin.jvm.internal.p.f(iOExceptionB);
                throw iOExceptionB;
            }
        }

        @Override // Mb.AbstractC0973k, Mb.G, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j10 = this.contentLength;
            if (j10 != -1 && this.bytesReceived != j10) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                b(null);
            } catch (IOException e10) {
                IOException iOExceptionB = b(e10);
                kotlin.jvm.internal.p.f(iOExceptionB);
                throw iOExceptionB;
            }
        }

        @Override // Mb.AbstractC0973k, Mb.G, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e10) {
                IOException iOExceptionB = b(e10);
                kotlin.jvm.internal.p.f(iOExceptionB);
                throw iOExceptionB;
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0080\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018¨\u0006 "}, d2 = {"Lyb/h$b;", "LMb/l;", "LMb/I;", "delegate", "", "contentLength", "", "isSocket", "<init>", "(Lyb/h;LMb/I;JZ)V", "LMb/d;", "sink", "byteCount", "u0", "(LMb/d;J)J", "LY8/t;", "close", "()V", "Ljava/io/IOException;", "e", "(Ljava/io/IOException;)Ljava/io/IOException;", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "Z", "c", "bytesReceived", Const.INTENT_KEY_UMID, "invokeStartEvent", "completed", "f", AlipayXuiIsland.REASON_CLOSED, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.h$b */
    public final class b extends AbstractC0974l {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final long contentLength;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final boolean isSocket;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public long bytesReceived;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public boolean invokeStartEvent;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public boolean completed;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public boolean closed;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ C6027h f44195g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C6027h c6027h, I delegate, long j10, boolean z10) {
            super(delegate);
            kotlin.jvm.internal.p.i(delegate, "delegate");
            this.f44195g = c6027h;
            this.contentLength = j10;
            this.isSocket = z10;
            this.invokeStartEvent = true;
            if (j10 == 0) {
                e(null);
            }
        }

        @Override // Mb.AbstractC0974l, Mb.I, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                e(null);
            } catch (IOException e10) {
                IOException iOExceptionE = e(e10);
                kotlin.jvm.internal.p.f(iOExceptionE);
                throw iOExceptionE;
            }
        }

        public final IOException e(IOException e10) {
            if (this.completed) {
                return e10;
            }
            this.completed = true;
            if (e10 == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.f44195g.getCall().getEventListener().y(this.f44195g.getCall());
            }
            return C6027h.c(this.f44195g, this.bytesReceived, this.isSocket, true, false, e10, 8, null);
        }

        @Override // Mb.AbstractC0974l, Mb.I
        public long u0(C0966d sink, long byteCount) throws IOException {
            kotlin.jvm.internal.p.i(sink, "sink");
            if (this.closed) {
                throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
            }
            try {
                long jU0 = getDelegate().u0(sink, byteCount);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.f44195g.getCall().getEventListener().y(this.f44195g.getCall());
                }
                if (jU0 == -1) {
                    e(null);
                    return -1L;
                }
                long j10 = this.bytesReceived + jU0;
                long j11 = this.contentLength;
                if (j11 != -1 && j10 > j11) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j10);
                }
                this.bytesReceived = j10;
                if (this.f44195g.codec.f()) {
                    e(null);
                }
                return jU0;
            } catch (IOException e10) {
                IOException iOExceptionE = e(e10);
                kotlin.jvm.internal.p.f(iOExceptionE);
                throw iOExceptionE;
            }
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\u000b\u001a\u00060\u0005R\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0010\u001a\u00060\fR\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"yb/h$c", "LMb/H;", "LY8/t;", "cancel", "()V", "Lyb/h$a;", "Lyb/h;", Const.INTENT_KEY_APIKEY, "Lyb/h$a;", Const.INTENT_KEY_PKGNAME, "()Lyb/h$a;", "sink", "Lyb/h$b;", "Lyb/h$b;", "c", "()Lyb/h$b;", "source", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.h$c */
    public static final class c implements H {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final a sink;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final b source;

        public c() {
            this.sink = new a(C6027h.this, C6027h.this.codec.i().getSink(), -1L, true);
            this.source = new b(C6027h.this, C6027h.this.codec.i().getSource(), -1L, true);
        }

        @Override // Mb.H
        /* renamed from: b, reason: from getter */
        public a getSink() {
            return this.sink;
        }

        @Override // Mb.H
        /* renamed from: c, reason: from getter */
        public b getSource() {
            return this.source;
        }

        @Override // Mb.H
        public void cancel() {
            C6027h.this.d();
        }
    }

    public C6027h(C6032m call, InterfaceC6028i finder, InterfaceC6480d codec) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(finder, "finder");
        kotlin.jvm.internal.p.i(codec, "codec");
        this.call = call;
        this.finder = finder;
        this.codec = codec;
    }

    public static /* synthetic */ IOException c(C6027h c6027h, long j10, boolean z10, boolean z11, boolean z12, IOException iOException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = -1;
        }
        return c6027h.b(j10, z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12, iOException);
    }

    public final IOException b(long bytesRead, boolean isSocket, boolean responseDone, boolean requestDone, IOException e10) {
        boolean z10;
        boolean z11;
        boolean z12;
        if (e10 != null) {
            u(e10);
        }
        if (requestDone) {
            if (e10 != null) {
                this.call.getEventListener().u(this.call, e10);
            } else {
                this.call.getEventListener().s(this.call, bytesRead);
            }
        }
        if (responseDone) {
            if (e10 != null) {
                this.call.getEventListener().z(this.call, e10);
            } else {
                this.call.getEventListener().x(this.call, bytesRead);
            }
        }
        C6032m c6032m = this.call;
        boolean z13 = false;
        if (!requestDone || isSocket) {
            z10 = false;
        } else {
            z10 = false;
            z13 = true;
        }
        if (!responseDone || isSocket) {
            z11 = isSocket;
            z12 = z10;
        } else {
            z11 = isSocket;
            z12 = true;
        }
        return c6032m.w(this, z13, z12, (responseDone && z11) ? true : z10, (requestDone && z11) ? true : z10, e10);
    }

    public final void d() {
        this.codec.cancel();
    }

    public final G e(C5528A request, boolean duplex) throws IOException {
        kotlin.jvm.internal.p.i(request, "request");
        this.isDuplex = duplex;
        AbstractC5529B body = request.getBody();
        kotlin.jvm.internal.p.f(body);
        long jA = body.a();
        this.call.getEventListener().t(this.call);
        return new a(this, this.codec.b(request, jA), jA, false);
    }

    public final void f() {
        this.codec.cancel();
        this.call.w(this, true, true, true, true, null);
    }

    public final void g() throws IOException {
        try {
            this.codec.d();
        } catch (IOException e10) {
            this.call.getEventListener().u(this.call, e10);
            u(e10);
            throw e10;
        }
    }

    public final void h() throws IOException {
        try {
            this.codec.h();
        } catch (IOException e10) {
            this.call.getEventListener().u(this.call, e10);
            u(e10);
            throw e10;
        }
    }

    /* renamed from: i, reason: from getter */
    public final C6032m getCall() {
        return this.call;
    }

    public final C6033n j() {
        InterfaceC6480d.a carrier = this.codec.getCarrier();
        C6033n c6033n = carrier instanceof C6033n ? (C6033n) carrier : null;
        if (c6033n != null) {
            return c6033n;
        }
        throw new IllegalStateException("no connection for CONNECT tunnels");
    }

    /* renamed from: k, reason: from getter */
    public final InterfaceC6028i getFinder() {
        return this.finder;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getHasFailure() {
        return this.hasFailure;
    }

    public final boolean m() {
        return !kotlin.jvm.internal.p.d(this.finder.getRoutePlanner().getAddress().getUrl().getHost(), this.codec.getCarrier().getM5.a.CARD_TYPE_ROUTE java.lang.String().getAddress().getUrl().getHost());
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsDuplex() {
        return this.isDuplex;
    }

    public final void o() {
        this.codec.getCarrier().b();
    }

    public final void p() {
        C6032m.x(this.call, this, true, false, false, false, null, 28, null);
    }

    public final AbstractC5531D q(C5530C response) throws IOException {
        C6027h c6027h;
        kotlin.jvm.internal.p.i(response, "response");
        try {
            String strJ = C5530C.J(response, "Content-Type", null, 2, null);
            long jA = this.codec.a(response);
            c6027h = this;
            try {
                return new zb.h(strJ, jA, Mb.u.c(new b(c6027h, this.codec.c(response), jA, false)));
            } catch (IOException e10) {
                e = e10;
                IOException iOException = e;
                c6027h.call.getEventListener().z(c6027h.call, iOException);
                c6027h.u(iOException);
                throw iOException;
            }
        } catch (IOException e11) {
            e = e11;
            c6027h = this;
        }
    }

    public final C5530C.a r(boolean expectContinue) throws IOException {
        try {
            C5530C.a aVarG = this.codec.g(expectContinue);
            if (aVarG == null) {
                return aVarG;
            }
            aVarG.k(this);
            return aVarG;
        } catch (IOException e10) {
            this.call.getEventListener().z(this.call, e10);
            u(e10);
            throw e10;
        }
    }

    public final void s(C5530C response) {
        kotlin.jvm.internal.p.i(response, "response");
        this.call.getEventListener().A(this.call, response);
    }

    public final void t() {
        this.call.getEventListener().B(this.call);
    }

    public final void u(IOException e10) {
        this.hasFailure = true;
        this.codec.getCarrier().d(this.call, e10);
    }

    public final H v() throws SocketException {
        this.call.H();
        InterfaceC6480d.a carrier = this.codec.getCarrier();
        kotlin.jvm.internal.p.g(carrier, "null cannot be cast to non-null type okhttp3.internal.connection.RealConnection");
        ((C6033n) carrier).C();
        return new c();
    }

    public final void w(C5528A request) throws IOException {
        kotlin.jvm.internal.p.i(request, "request");
        try {
            this.call.getEventListener().w(this.call);
            this.codec.e(request);
            this.call.getEventListener().v(this.call, request);
        } catch (IOException e10) {
            this.call.getEventListener().u(this.call, e10);
            u(e10);
            throw e10;
        }
    }
}
