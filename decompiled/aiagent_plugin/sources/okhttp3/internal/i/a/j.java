package okhttp3.internal.i.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;

/* JADX INFO: compiled from: DeferredSocketAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f40116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f40117b;

    /* JADX INFO: compiled from: DeferredSocketAdapter.kt */
    public interface a {
        boolean a(SSLSocket r1);

        k b(SSLSocket r1);
    }

    @Override // okhttp3.internal.i.a.k
    public boolean a() {
        return true;
    }

    public j(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        o.e(r4, "socketAdapterFactory");
        this.f40116a = r4;
    }

    @Override // okhttp3.internal.i.a.k
    public X509TrustManager a(SSLSocketFactory r1) {
        return k.a.a(this, r1);
    }

    @Override // okhttp3.internal.i.a.k
    public boolean b(SSLSocketFactory r1) {
        return k.a.b(this, r1);
    }

    @Override // okhttp3.internal.i.a.k
    public boolean a(SSLSocket r2) {
        o.e(r2, "sslSocket");
        return this.f40116a.a(r2);
    }

    @Override // okhttp3.internal.i.a.k
    public void a(SSLSocket r3, String r4, List<? extends aa> r5) {
        List<? extends aa> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "sslSocket");
        o.e(r6, "protocols");
        k r2 = c(r3);
        if (r2 == null) goto L6;
        r2.a(r3, r4, r6);
        return;
    }

    @Override // okhttp3.internal.i.a.k
    public String b(SSLSocket r2) {
        o.e(r2, "sslSocket");
        k r1 = c(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.b(r2);
    }

    private final synchronized k c(SSLSocket r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f40117b == null) goto L6;
    L8:
        k r3 = this.f40117b;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r3;
    L6:
        if (this.f40116a.a(r2) == false) goto L8;
        this.f40117b = this.f40116a.b(r2);     // Catch: Throwable -> L11
        goto L8
    }
}
