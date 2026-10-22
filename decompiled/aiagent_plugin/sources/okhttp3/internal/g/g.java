package okhttp3.internal.g;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import e.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.u;
import okhttp3.z;

/* JADX INFO: compiled from: Http2ExchangeCodec.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g implements okhttp3.internal.e.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f40039b = null;
    private static final List<String> i = null;
    private static final List<String> j = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final okhttp3.internal.d.f f40040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final okhttp3.internal.e.g f40041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f40042e;
    private volatile i f;
    private final aa g;
    private volatile boolean h;

    /* JADX INFO: compiled from: Http2ExchangeCodec.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final List<c> a(ab r6) {
            o.e(r6, Ext.KEY_REQUEST);
            u r5 = r6.c();
            ArrayList r0 = new ArrayList(r5.a() + 4);
            r0.add(new c(c.g, r6.b()));
            r0.add(new c(c.h, okhttp3.internal.e.i.f39932a.a(r6.a())));
            String r1 = r6.a(DownloadConstants.HOST);
            if (r1 == null) goto L5;
            r0.add(new c(c.j, r1));
        L5:
            r0.add(new c(c.i, r6.a().a()));
            int r7 = 0;
            int r2 = r5.a();
        L6:
            if (r7 >= r2) goto L16;
            String r3 = r5.a(r7);
            Locale r4 = Locale.US;
            o.c(r4, "US");
            String r8 = r3.toLowerCase(r4);
            o.c(r8, "this as java.lang.String).toLowerCase(locale)");
            if (g.e().contains(r8) == true) goto L10;
        L13:
            r0.add(new c(r8, r5.b(r7)));
        L14:
            r7 = r7 + 1;
            goto L6
        L10:
            if (o.a(r8, "te") == false) goto L14;
            if (o.a(r5.b(r7), "trailers") == false) goto L14;
        L16:
            return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        }

        public final ad.a a(u r7, aa r8) {
            o.e(r7, "headerBlock");
            o.e(r8, MonitorConstants.PROTOCOL);
            u.a r6 = new u.a();
            int r0 = r7.a();
            okhttp3.internal.e.k r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            String r3 = r7.a(r2);
            String r4 = r7.b(r2);
            if (o.a(r3, ":status") == false) goto L8;
            r1 = okhttp3.internal.e.k.f39935a.a("HTTP/1.1 " + r4);
        L10:
            r2 = r2 + 1;
            goto L3
        L8:
            if (g.f().contains(r3) == true) goto L10;
            r6.b(r3, r4);
            goto L10
        L11:
            if (r1 == null) goto L15;
            return new ad.a().a(r8).a(r1.f39937c).a(r1.f39938d).a(r6.b());
        L15:
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    public g(z r2, okhttp3.internal.d.f r3, okhttp3.internal.e.g r4, f r5) {
        o.e(r2, "client");
        o.e(r3, WsConstants.KEY_CONNECTION);
        o.e(r4, "chain");
        o.e(r5, "http2Connection");
        this.f40040c = r3;
        this.f40041d = r4;
        this.f40042e = r5;
        if (r2.t().contains(aa.f) == false) goto L5;
        aa r6 = aa.f;
    L6:
        this.g = r6;
        return;
    L5:
        r6 = aa.f39697e;
        goto L6
    }

    public static final /* synthetic */ List e() {
        return i;
    }

    public static final /* synthetic */ List f() {
        return j;
    }

    @Override // okhttp3.internal.e.d
    public okhttp3.internal.d.f a() {
        return this.f40040c;
    }

    @Override // okhttp3.internal.e.d
    public y a(ab r1, long r2) {
        o.e(r1, Ext.KEY_REQUEST);
        i r0 = this.f;
        o.a(r0);
        return r0.r();
    }

    @Override // okhttp3.internal.e.d
    public void a(ab r4) {
        o.e(r4, Ext.KEY_REQUEST);
        if (this.f == null) goto L6;
        return;
    L6:
        if (r4.d() == null) goto L8;
        boolean r0 = true;
    L9:
        this.f = this.f40042e.a(f40039b.a(r4), r0);
        if (this.h == true) goto L13;
        i r5 = this.f;
        o.a(r5);
        r5.p().a(this.f40041d.g(), TimeUnit.MILLISECONDS);
        i r6 = this.f;
        o.a(r6);
        r6.q().a(this.f40041d.h(), TimeUnit.MILLISECONDS);
        return;
    L13:
        i r3 = this.f;
        o.a(r3);
        r3.a(b.j);
        throw new IOException("Canceled");
    L8:
        r0 = false;
        goto L9
    }

    @Override // okhttp3.internal.e.d
    public void b() {
        this.f40042e.k();
    }

    @Override // okhttp3.internal.e.d
    public void c() {
        i r0 = this.f;
        o.a(r0);
        r0.r().close();
    }

    @Override // okhttp3.internal.e.d
    public ad.a a(boolean r3) {
        i r0 = this.f;
        if (r0 == null) goto L11;
        u r1 = r0.o();
        ad.a r2 = f40039b.a(r1, this.g);
        if (r3 == true) goto L7;
        return r2;
    L7:
        if (r2.a() != 100) goto L13;
        return null;
    L13:
        return r2;
    L11:
        throw new IOException("stream wasn't created");
    }

    @Override // okhttp3.internal.e.d
    public long a(ad r1) {
        o.e(r1, "response");
        if (okhttp3.internal.e.e.a(r1) == true) goto L6;
        return 0;
    L6:
        return okhttp3.internal.c.a(r1);
    }

    @Override // okhttp3.internal.e.d
    public e.aa b(ad r2) {
        o.e(r2, "response");
        i r1 = this.f;
        o.a(r1);
        return (e.aa) ZeusTransformUtils.preCheckCast(r1.g(), e.aa.class, "com.obric.aiagent.plugin");
    }

    @Override // okhttp3.internal.e.d
    public void d() {
        this.h = true;
        i r1 = this.f;
        if (r1 == null) goto L6;
        r1.a(b.j);
        return;
    }

    static {
        f40039b = new a(null);
        i = okhttp3.internal.c.a(new String[]{WsConstants.KEY_CONNECTION, "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});
        j = okhttp3.internal.c.a(new String[]{WsConstants.KEY_CONNECTION, "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});
    }
}
