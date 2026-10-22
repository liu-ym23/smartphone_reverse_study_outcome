package O9;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;

/* loaded from: classes4.dex */
public final class j implements m {

    /* renamed from: a, reason: collision with root package name */
    public static final i f1050a = new i();

    @Override // O9.m
    public final boolean a(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // O9.m
    public final boolean b() {
        boolean z10 = N9.f.b;
        return N9.f.b;
    }

    @Override // O9.m
    public final String c(SSLSocket sSLSocket) {
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // O9.m
    public final X509TrustManager d(SSLSocketFactory sSLSocketFactory) {
        return null;
    }

    @Override // O9.m
    public final boolean e(SSLSocketFactory sSLSocketFactory) {
        return false;
    }

    @Override // O9.m
    public final void f(SSLSocket sSLSocket, String str, List list) {
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            N9.m.Companion.getClass();
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) N9.l.a(list).toArray(new String[0]));
        }
    }
}
