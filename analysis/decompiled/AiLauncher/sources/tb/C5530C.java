package tb;

import Mb.H;
import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import okhttp3.Protocol;
import tb.u;
import yb.C6027h;
import zb.C6481e;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001.B\u008d\u0001\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u0013\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010-R\u0017\u0010\t\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010\r\u001a\u00020\f8\u0007¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0017\u0010\u000f\u001a\u00020\u000e8\u0007¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\b=\u0010GR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0007¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\bP\u0010M\u001a\u0004\bL\u0010OR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\bQ\u0010M\u001a\u0004\bR\u0010OR\u0017\u0010\u0016\u001a\u00020\u00158\u0007¢\u0006\f\n\u0004\b'\u0010S\u001a\u0004\bT\u0010UR\u0017\u0010\u0017\u001a\u00020\u00158\u0007¢\u0006\f\n\u0004\b;\u0010S\u001a\u0004\bV\u0010UR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0001X\u0080\u0004¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bW\u0010YR\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R$\u0010c\u001a\u0004\u0018\u00010\\8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0017\u0010g\u001a\u00020d8\u0006¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u0017\u0010j\u001a\u00020d8\u0006¢\u0006\f\n\u0004\bi\u0010f\u001a\u0004\bj\u0010hR\u0011\u0010k\u001a\u00020\\8G¢\u0006\u0006\u001a\u0004\bE\u0010`¨\u0006l"}, d2 = {"Ltb/C;", "Ljava/io/Closeable;", "Ltb/A;", "request", "Lokhttp3/Protocol;", "protocol", "", "message", "", "code", "Lokhttp3/c;", "handshake", "Ltb/u;", "headers", "Ltb/D;", "body", "LMb/H;", "socket", "networkResponse", "cacheResponse", "priorResponse", "", "sentRequestAtMillis", "receivedResponseAtMillis", "Lyb/h;", "exchange", "Ltb/F;", "trailersSource", "<init>", "(Ltb/A;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/c;Ltb/u;Ltb/D;LMb/H;Ltb/C;Ltb/C;Ltb/C;JJLyb/h;Ltb/F;)V", "name", "defaultValue", "G", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Ltb/C$a;", "e0", "()Ltb/C$a;", "", "Ltb/i;", "l", "()Ljava/util/List;", "LY8/t;", "close", "()V", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ltb/A;", "D0", "()Ltb/A;", Const.INTENT_KEY_PKGNAME, "Lokhttp3/Protocol;", "k0", "()Lokhttp3/Protocol;", "c", "Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, Const.INTENT_KEY_UMID, "I", "m", "()I", "e", "Lokhttp3/c;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lokhttp3/c;", "f", "Ltb/u;", "U", "()Ltb/u;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ltb/D;", "()Ltb/D;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LMb/H;", "N0", "()LMb/H;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ltb/C;", "Y", "()Ltb/C;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", "g0", "J", "I0", "()J", "v0", "n", "Lyb/h;", "()Lyb/h;", "o", "Ltb/F;", "Ltb/d;", "p", "Ltb/d;", "getLazyCacheControl$okhttp", "()Ltb/d;", "setLazyCacheControl$okhttp", "(Ltb/d;)V", "lazyCacheControl", "", "q", "Z", "isSuccessful", "()Z", "r", "isRedirect", "cacheControl", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.C, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5530C implements Closeable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C5528A request;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Protocol protocol;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String message;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final int code;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final okhttp3.c handshake;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final u headers;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final AbstractC5531D body;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final H socket;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final C5530C networkResponse;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final C5530C cacheResponse;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final C5530C priorResponse;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final long sentRequestAtMillis;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final long receivedResponseAtMillis;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final C6027h exchange;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5533F trailersSource;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public C5537d lazyCacheControl;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final boolean isSuccessful;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final boolean isRedirect;

    public C5530C(C5528A request, Protocol protocol, String message, int i10, okhttp3.c cVar, u headers, AbstractC5531D body, H h10, C5530C c5530c, C5530C c5530c2, C5530C c5530c3, long j10, long j11, C6027h c6027h, InterfaceC5533F trailersSource) {
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(protocol, "protocol");
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(headers, "headers");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.i(trailersSource, "trailersSource");
        this.request = request;
        this.protocol = protocol;
        this.message = message;
        this.code = i10;
        this.handshake = cVar;
        this.headers = headers;
        this.body = body;
        this.socket = h10;
        this.networkResponse = c5530c;
        this.cacheResponse = c5530c2;
        this.priorResponse = c5530c3;
        this.sentRequestAtMillis = j10;
        this.receivedResponseAtMillis = j11;
        this.exchange = c6027h;
        this.trailersSource = trailersSource;
        boolean z10 = true;
        this.isSuccessful = 200 <= i10 && i10 < 300;
        if (i10 != 307 && i10 != 308) {
            switch (i10) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    z10 = false;
                    break;
            }
        }
        this.isRedirect = z10;
    }

    public static /* synthetic */ String J(C5530C c5530c, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return c5530c.G(str, str2);
    }

    /* renamed from: A, reason: from getter */
    public final okhttp3.c getHandshake() {
        return this.handshake;
    }

    /* renamed from: D0, reason: from getter */
    public final C5528A getRequest() {
        return this.request;
    }

    public final String G(String name, String defaultValue) {
        kotlin.jvm.internal.p.i(name, "name");
        String strB = this.headers.b(name);
        return strB == null ? defaultValue : strB;
    }

    /* renamed from: I0, reason: from getter */
    public final long getSentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    /* renamed from: N0, reason: from getter */
    public final H getSocket() {
        return this.socket;
    }

    /* renamed from: U, reason: from getter */
    public final u getHeaders() {
        return this.headers;
    }

    /* renamed from: V, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: Y, reason: from getter */
    public final C5530C getNetworkResponse() {
        return this.networkResponse;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.body.close();
    }

    /* renamed from: e, reason: from getter */
    public final AbstractC5531D getBody() {
        return this.body;
    }

    public final a e0() {
        return new a(this);
    }

    public final C5537d g() {
        C5537d c5537d = this.lazyCacheControl;
        if (c5537d != null) {
            return c5537d;
        }
        C5537d c5537dA = C5537d.INSTANCE.a(this.headers);
        this.lazyCacheControl = c5537dA;
        return c5537dA;
    }

    /* renamed from: g0, reason: from getter */
    public final C5530C getPriorResponse() {
        return this.priorResponse;
    }

    /* renamed from: i, reason: from getter */
    public final C5530C getCacheResponse() {
        return this.cacheResponse;
    }

    /* renamed from: isSuccessful, reason: from getter */
    public final boolean getIsSuccessful() {
        return this.isSuccessful;
    }

    /* renamed from: k0, reason: from getter */
    public final Protocol getProtocol() {
        return this.protocol;
    }

    public final List<C5542i> l() {
        String str;
        u uVar = this.headers;
        int i10 = this.code;
        if (i10 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i10 != 407) {
                return C1173v.m();
            }
            str = "Proxy-Authenticate";
        }
        return C6481e.b(uVar, str);
    }

    /* renamed from: m, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: n, reason: from getter */
    public final C6027h getExchange() {
        return this.exchange;
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.getUrl() + '}';
    }

    /* renamed from: v0, reason: from getter */
    public final long getReceivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b'\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J!\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010!J\u0017\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0019\u00100\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b0\u00101J\u0019\u00103\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b3\u00101J\u0019\u00105\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b5\u00101J\u0017\u00108\u001a\u00020\u00002\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00002\u0006\u0010>\u001a\u00020:H\u0016¢\u0006\u0004\b?\u0010=J\u0017\u0010B\u001a\u00020\t2\u0006\u0010A\u001a\u00020@H\u0000¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0004H\u0016¢\u0006\u0004\bD\u0010ER$\u0010\r\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bD\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b3\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010$\u001a\u00020_8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010(\u001a\u00020'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bQ\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR$\u0010,\u001a\u0004\u0018\u00010+8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u0010/\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010o\u001a\u0004\bp\u0010E\"\u0004\bq\u0010\u0006R$\u00102\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010o\u001a\u0004\br\u0010E\"\u0004\bs\u0010\u0006R$\u00104\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bB\u0010o\u001a\u0004\bt\u0010E\"\u0004\bu\u0010\u0006R\"\u0010;\u001a\u00020:8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\"\u0010>\u001a\u00020:8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u0010v\u001a\u0004\b{\u0010x\"\u0004\b|\u0010zR%\u0010A\u001a\u0004\u0018\u00010@8\u0000@\u0000X\u0080\u000e¢\u0006\u0013\n\u0004\b5\u0010}\u001a\u0004\b~\u0010\u007f\"\u0005\b\u0080\u0001\u0010CR'\u00107\u001a\u0002068\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u0012\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001¨\u0006\u0086\u0001"}, d2 = {"Ltb/C$a;", "", "<init>", "()V", "Ltb/C;", UxipConstants.f30685x, "(Ltb/C;)V", "", "name", "LY8/t;", "e", "(Ljava/lang/String;Ltb/C;)V", "Ltb/A;", "request", "q", "(Ltb/A;)Ltb/C$a;", "Lokhttp3/Protocol;", "protocol", "o", "(Lokhttp3/Protocol;)Ltb/C$a;", "", "code", "f", "(I)Ltb/C$a;", "message", "l", "(Ljava/lang/String;)Ltb/C$a;", "Lokhttp3/c;", "handshake", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lokhttp3/c;)Ltb/C$a;", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;)Ltb/C$a;", Const.INTENT_KEY_APIKEY, "Ltb/u;", "headers", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ltb/u;)Ltb/C$a;", "Ltb/D;", "body", Const.INTENT_KEY_PKGNAME, "(Ltb/D;)Ltb/C$a;", "LMb/H;", "socket", "s", "(LMb/H;)Ltb/C$a;", "networkResponse", "m", "(Ltb/C;)Ltb/C$a;", "cacheResponse", Const.INTENT_KEY_UMID, "priorResponse", "n", "Ltb/F;", "trailersSource", "t", "(Ltb/F;)Ltb/C$a;", "", "sentRequestAtMillis", "r", "(J)Ltb/C$a;", "receivedResponseAtMillis", "p", "Lyb/h;", "exchange", "k", "(Lyb/h;)V", "c", "()Ltb/C;", "Ltb/A;", "getRequest$okhttp", "()Ltb/A;", "setRequest$okhttp", "(Ltb/A;)V", "Lokhttp3/Protocol;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "setProtocol$okhttp", "(Lokhttp3/Protocol;)V", "I", Const.INTENT_KEY_BACKGROUND_COMMAND, "()I", "setCode$okhttp", "(I)V", "Ljava/lang/String;", "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "Lokhttp3/c;", "getHandshake$okhttp", "()Lokhttp3/c;", "setHandshake$okhttp", "(Lokhttp3/c;)V", "Ltb/u$a;", "Ltb/u$a;", "getHeaders$okhttp", "()Ltb/u$a;", "setHeaders$okhttp", "(Ltb/u$a;)V", "Ltb/D;", "getBody$okhttp", "()Ltb/D;", "setBody$okhttp", "(Ltb/D;)V", "LMb/H;", "getSocket$okhttp", "()LMb/H;", "setSocket$okhttp", "(LMb/H;)V", "Ltb/C;", "getNetworkResponse$okhttp", "setNetworkResponse$okhttp", "getCacheResponse$okhttp", "setCacheResponse$okhttp", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "J", "getSentRequestAtMillis$okhttp", "()J", "setSentRequestAtMillis$okhttp", "(J)V", "getReceivedResponseAtMillis$okhttp", "setReceivedResponseAtMillis$okhttp", "Lyb/h;", "getExchange$okhttp", "()Lyb/h;", "setExchange$okhttp", "Ltb/F;", "getTrailersSource$okhttp", "()Ltb/F;", "setTrailersSource$okhttp", "(Ltb/F;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.C$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public C5528A request;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public Protocol protocol;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int code;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public String message;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public okhttp3.c handshake;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public u.a headers;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public AbstractC5531D body;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public H socket;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public C5530C networkResponse;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public C5530C cacheResponse;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public C5530C priorResponse;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        public long sentRequestAtMillis;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        public long receivedResponseAtMillis;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        public C6027h exchange;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        public InterfaceC5533F trailersSource;

        public a() {
            this.code = -1;
            this.body = AbstractC5531D.f42132c;
            this.trailersSource = InterfaceC5533F.f42145b;
            this.headers = new u.a();
        }

        public a a(String name, String value) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(value, "value");
            this.headers.a(name, value);
            return this;
        }

        public a b(AbstractC5531D body) {
            kotlin.jvm.internal.p.i(body, "body");
            this.body = body;
            return this;
        }

        public C5530C c() {
            int i10 = this.code;
            if (i10 < 0) {
                throw new IllegalStateException(("code < 0: " + this.code).toString());
            }
            C5528A c5528a = this.request;
            if (c5528a == null) {
                throw new IllegalStateException("request == null");
            }
            Protocol protocol = this.protocol;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null");
            }
            String str = this.message;
            if (str != null) {
                return new C5530C(c5528a, protocol, str, i10, this.handshake, this.headers.f(), this.body, this.socket, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange, this.trailersSource);
            }
            throw new IllegalStateException("message == null");
        }

        public a d(C5530C cacheResponse) {
            e("cacheResponse", cacheResponse);
            this.cacheResponse = cacheResponse;
            return this;
        }

        public final void e(String name, C5530C response) {
            if (response != null) {
                if (response.getNetworkResponse() != null) {
                    throw new IllegalArgumentException((name + ".networkResponse != null").toString());
                }
                if (response.getCacheResponse() != null) {
                    throw new IllegalArgumentException((name + ".cacheResponse != null").toString());
                }
                if (response.getPriorResponse() == null) {
                    return;
                }
                throw new IllegalArgumentException((name + ".priorResponse != null").toString());
            }
        }

        public a f(int code) {
            this.code = code;
            return this;
        }

        /* renamed from: g, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        public a h(okhttp3.c handshake) {
            this.handshake = handshake;
            return this;
        }

        public a i(String name, String value) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(value, "value");
            this.headers.i(name, value);
            return this;
        }

        public a j(u headers) {
            kotlin.jvm.internal.p.i(headers, "headers");
            this.headers = headers.i();
            return this;
        }

        public final void k(C6027h exchange) {
            kotlin.jvm.internal.p.i(exchange, "exchange");
            this.exchange = exchange;
        }

        public a l(String message) {
            kotlin.jvm.internal.p.i(message, "message");
            this.message = message;
            return this;
        }

        public a m(C5530C networkResponse) {
            e("networkResponse", networkResponse);
            this.networkResponse = networkResponse;
            return this;
        }

        public a n(C5530C priorResponse) {
            this.priorResponse = priorResponse;
            return this;
        }

        public a o(Protocol protocol) {
            kotlin.jvm.internal.p.i(protocol, "protocol");
            this.protocol = protocol;
            return this;
        }

        public a p(long receivedResponseAtMillis) {
            this.receivedResponseAtMillis = receivedResponseAtMillis;
            return this;
        }

        public a q(C5528A request) {
            kotlin.jvm.internal.p.i(request, "request");
            this.request = request;
            return this;
        }

        public a r(long sentRequestAtMillis) {
            this.sentRequestAtMillis = sentRequestAtMillis;
            return this;
        }

        public a s(H socket) {
            kotlin.jvm.internal.p.i(socket, "socket");
            this.socket = socket;
            return this;
        }

        public a t(InterfaceC5533F trailersSource) {
            kotlin.jvm.internal.p.i(trailersSource, "trailersSource");
            this.trailersSource = trailersSource;
            return this;
        }

        public a(C5530C response) {
            kotlin.jvm.internal.p.i(response, "response");
            this.code = -1;
            this.body = AbstractC5531D.f42132c;
            this.trailersSource = InterfaceC5533F.f42145b;
            this.request = response.getRequest();
            this.protocol = response.getProtocol();
            this.code = response.getCode();
            this.message = response.getMessage();
            this.handshake = response.getHandshake();
            this.headers = response.getHeaders().i();
            this.body = response.getBody();
            this.socket = response.getSocket();
            this.networkResponse = response.getNetworkResponse();
            this.cacheResponse = response.getCacheResponse();
            this.priorResponse = response.getPriorResponse();
            this.sentRequestAtMillis = response.getSentRequestAtMillis();
            this.receivedResponseAtMillis = response.getReceivedResponseAtMillis();
            this.exchange = response.getExchange();
            this.trailersSource = response.trailersSource;
        }
    }
}
