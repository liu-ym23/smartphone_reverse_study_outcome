package okhttp3.internal.e;

import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.af;
import okhttp3.v;
import okhttp3.w;
import okhttp3.z;

/* JADX INFO: compiled from: RetryAndFollowUpInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39933a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z f39934c;

    /* JADX INFO: compiled from: RetryAndFollowUpInterceptor.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f39933a = new a(null);
    }

    public j(z r2) {
        o.e(r2, "client");
        this.f39934c = r2;
    }

    @Override // okhttp3.w
    public ad intercept(w.a r12) {
        w.a r13 = (w.a) ZeusTransformUtils.wrapperContextForParams(r12, w.a.class, "com.obric.aiagent.plugin");
        o.e(r13, "chain");
        g r0 = (g) ZeusTransformUtils.preCheckCast(r13, g.class, "com.obric.aiagent.plugin");
        ab r14 = ((g) ZeusTransformUtils.preCheckCast(r13, g.class, "com.obric.aiagent.plugin")).e();
        okhttp3.internal.d.e r2 = r0.c();
        List r3 = p.b();
        ad r8 = null;
        boolean r7 = true;
        int r9 = 0;
    L3:
        r2.a(r14, r7);
    L50:
        th = move-exception;
        r2.a(true);
        throw th;
    L5:
        if (r2.d() == true) goto L49;
        ad r15 = r0.a(r14);     // Catch: IOException -> L31 okhttp3.internal.d.i -> L41 Throwable -> L50
    L7:
        if (r8 == null) goto L9;
        r15 = r15.o().c(r8.o().a(null).b()).b();     // Catch: Throwable -> L50
    L9:
        r8 = r15;
        okhttp3.internal.d.c r16 = r2.j();     // Catch: Throwable -> L50
        ab r10 = a(r8, r16);     // Catch: Throwable -> L50
        if (r10 == null) goto L11;
        ac r17 = r10.d();     // Catch: Throwable -> L50
        if (r17 != null) goto L20;
    L23:
        ae r18 = r8.g();     // Catch: Throwable -> L50
        if (r18 == null) goto L26;
        okhttp3.internal.c.a((Closeable) ZeusTransformUtils.preCheckCast(r18, Closeable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L50
    L26:
        r9 = r9 + 1;
        if (r9 > 20) goto L30;
        r2.a(true);
        r14 = r10;
        r7 = true;
        goto L3
    L30:
        throw new ProtocolException("Too many follow-up requests: " + r9);     // Catch: Throwable -> L50
    L20:
        if (r17.e() == false) goto L23;
        r2.a(false);
        return r8;
    L11:
        if (r16 != null) goto L13;
    L15:
        r2.a(false);
        return r8;
    L13:
        if (r16.d() == false) goto L15;
        r2.o();     // Catch: Throwable -> L50
    L31:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, okhttp3.internal.g.a.class) == true) goto L35;
        boolean r11 = true;
    L37:
        if (a(e, r2, r14, r11) == false) goto L40;
        r3 = p.a((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin"), e);     // Catch: Throwable -> L50
    L45:
        r2.a(true);
        r7 = false;
        goto L3
    L40:
        throw okhttp3.internal.c.a((Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.aiagent.plugin"), r3);     // Catch: Throwable -> L50
    L35:
        r11 = false;
    L41:
        e = move-exception;
        if (a(e.b(), r2, r14, false) == false) goto L47;
        r3 = p.a((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin"), e.a());     // Catch: Throwable -> L50
        goto L45
    L47:
        throw okhttp3.internal.c.a((Exception) ZeusTransformUtils.preCheckCast(e.a(), Exception.class, "com.obric.aiagent.plugin"), r3);     // Catch: Throwable -> L50
    L49:
        throw new IOException("Canceled");     // Catch: Throwable -> L50
    }

    private final boolean a(IOException r3, okhttp3.internal.d.e r4, ab r5, boolean r6) {
        if (this.f39934c.f() == true) goto L5;
        return false;
    L5:
        if (r6 == false) goto L10;
        if (a(r3, r5) == false) goto L10;
        return false;
    L10:
        if (a(r3, r6) == true) goto L13;
        return false;
    L13:
        if (r4.p() == true) goto L15;
        return false;
    L15:
        return true;
    }

    private final boolean a(IOException r1, ab r2) {
        ac r0 = r2.d();
        if (r0 == null) goto L7;
        if (r0.e() == false) goto L7;
    L8:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, FileNotFoundException.class) == true) goto L8;
        return false;
    }

    private final boolean a(IOException r3, boolean r4) {
        if (ZeusTransformUtils.instanceOf(r3, ProtocolException.class) == false) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, InterruptedIOException.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, SocketTimeoutException.class) == false) goto L21;
        if (r4 == false) goto L11;
        return false;
    L11:
        return true;
    L21:
        return false;
    L13:
        if (ZeusTransformUtils.instanceOf(r3, SSLHandshakeException.class) == false) goto L18;
        if (ZeusTransformUtils.instanceOf(r3.getCause(), CertificateException.class) == false) goto L18;
        return false;
    L18:
        if (ZeusTransformUtils.instanceOf(r3, SSLPeerUnverifiedException.class) == false) goto L20;
        return false;
    L20:
        return true;
    }

    private final ab a(ad r6, okhttp3.internal.d.c r7) {
        if (r7 == null) goto L7;
        okhttp3.internal.d.f r1 = r7.f();
        if (r1 == null) goto L7;
        af r2 = r1.a();
    L8:
        int r3 = r6.d();
        String r4 = r6.a().b();
        if (r3 == 307) goto L73;
        if (r3 == 308) goto L73;
        if (r3 == 401) goto L71;
        if (r3 != 421) goto L17;
        ac r5 = r6.a().d();
        if (r5 != null) goto L61;
    L63:
        if (r7 != null) goto L65;
    L69:
        return null;
    L65:
        if (r7.g() == false) goto L69;
        r7.f().i();
        return r6.a();
    L61:
        if (r5.e() == false) goto L63;
        return null;
    L17:
        if (r3 != 503) goto L19;
        ad r8 = r6.j();
        if (r8 == null) goto L54;
        if (r8.d() != 503) goto L54;
        return null;
    L54:
        if (a(r6, Integer.MAX_VALUE) == 0) goto L56;
        return null;
    L56:
        return r6.a();
    L19:
        if (r3 != 407) goto L21;
        o.a(r2);
        if (r2.b().type() != Proxy.Type.HTTP) goto L47;
        return this.f39934c.o().authenticate(r2, r6);
    L47:
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    L21:
        if (r3 == 408) goto L25;
        switch(r3) {
            case 300: goto L73;
            case 301: goto L73;
            case 302: goto L73;
            case 303: goto L73;
            default: goto L23;
        };
    L23:
        return null;
    L25:
        if (this.f39934c.f() == true) goto L27;
        return null;
    L27:
        ac r9 = r6.a().d();
        if (r9 != null) goto L30;
    L32:
        ad r10 = r6.j();
        if (r10 == null) goto L38;
        if (r10.d() != 408) goto L38;
        return null;
    L38:
        if (a(r6, 0) <= 0) goto L41;
        return null;
    L41:
        return r6.a();
    L30:
        if (r9.e() == false) goto L32;
        return null;
    L71:
        return this.f39934c.g().authenticate(r2, r6);
    L73:
        return a(r6, r4);
    L7:
        r2 = null;
        goto L8
    }

    private final ab a(ad r8, String r9) {
        ac r1 = null;
        if (this.f39934c.h() == true) goto L5;
        return null;
    L5:
        String r0 = ad.a(r8, "Location", null, 2, null);
        if (r0 != null) goto L8;
        return null;
    L8:
        v r2 = r8.a().a().a(r0);
        if (r2 != null) goto L12;
        return null;
    L12:
        if (o.a(r2.a(), r8.a().a().a()) == false) goto L14;
    L16:
        ab.a r7 = r8.a().h();
        if (f.c(r9) == false) goto L36;
        int r3 = r8.d();
        if (f.f39923a.d(r9) == true) goto L24;
        if (r3 == 308) goto L24;
        if (r3 == 307) goto L24;
        boolean r4 = false;
    L26:
        if (f.f39923a.e(r9) == false) goto L30;
        if (r3 == 308) goto L30;
        if (r3 == 307) goto L30;
        r7.a("GET", null);
    L33:
        if (r4 == true) goto L36;
        r7.b(DownloadHelper.TRANSFER_ENCODING);
        r7.b(DownloadUtils.CONTENT_LENGTH);
        r7.b(DownloadHelper.CONTENT_TYPE);
    L30:
        if (r4 == false) goto L32;
        r1 = r8.a().d();
    L32:
        r7.a(r9, r1);
    L24:
        r4 = true;
    L36:
        if (okhttp3.internal.c.a(r8.a().a(), r2) == true) goto L39;
        r7.b("Authorization");
    L39:
        return r7.a(r2).b();
    L14:
        if (this.f39934c.i() == true) goto L16;
        return null;
    }

    private final int a(ad r3, int r4) {
        String r2 = ad.a(r3, "Retry-After", null, 2, null);
        if (r2 != null) goto L5;
        return r4;
    L5:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (new d.o.k("\\d+").a(r5) == false) goto L9;
        Integer r6 = Integer.valueOf(r2);
        o.c(r6, "valueOf(header)");
        return ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue();
    L9:
        return Integer.MAX_VALUE;
    }
}
