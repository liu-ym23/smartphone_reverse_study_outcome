package okhttp3.internal.i.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: ConscryptSocketAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40114a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final j.a f40115b = null;

    /* JADX INFO: compiled from: ConscryptSocketAdapter.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final j.a a() {
            return i.b();
        }
    }

    /* JADX INFO: compiled from: ConscryptSocketAdapter.kt */
    public static final class b implements j.a {
        b() {
        }

        @Override // okhttp3.internal.i.a.j.a
        public boolean a(SSLSocket r1) {
            o.e(r1, "sslSocket");
            if (okhttp3.internal.i.d.f40130a.a() == true) goto L5;
        L7:
            return false;
        L5:
            if (Conscrypt.isConscrypt(r1) == false) goto L7;
            return true;
        }

        @Override // okhttp3.internal.i.a.j.a
        public k b(SSLSocket r2) {
            o.e(r2, "sslSocket");
            return (k) ZeusTransformUtils.preCheckCast(new i(), k.class, "com.obric.aiagent.plugin");
        }
    }

    public i() {
    }

    public static final /* synthetic */ j.a b() {
        return f40115b;
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
    public boolean a(SSLSocket r1) {
        o.e(r1, "sslSocket");
        return Conscrypt.isConscrypt(r1);
    }

    @Override // okhttp3.internal.i.a.k
    public boolean a() {
        return okhttp3.internal.i.d.f40130a.a();
    }

    @Override // okhttp3.internal.i.a.k
    public String b(SSLSocket r2) {
        o.e(r2, "sslSocket");
        if (a(r2) == true) goto L7;
        return null;
    L7:
        return Conscrypt.getApplicationProtocol(r2);
    }

    @Override // okhttp3.internal.i.a.k
    public void a(SSLSocket r2, String r3, List<? extends aa> r4) {
        List<? extends aa> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r2, "sslSocket");
        o.e(r5, "protocols");
        if (a(r2) == false) goto L6;
        Conscrypt.setUseSessionTickets(r2, true);
        Conscrypt.setApplicationProtocols(r2, (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(okhttp3.internal.i.h.f40147b.a(r5), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));
        return;
    }

    static {
        f40114a = new a(null);
        f40115b = (j.a) ZeusTransformUtils.preCheckCast(new b(), j.a.class, "com.obric.aiagent.plugin");
    }
}
