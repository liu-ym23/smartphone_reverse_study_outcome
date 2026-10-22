package O9;

import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* loaded from: classes4.dex */
public final class i implements k {
    @Override // O9.k
    public final boolean a(SSLSocket sSLSocket) {
        return N9.f.b && Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // O9.k
    public final m b(SSLSocket sSLSocket) {
        return new j();
    }
}
