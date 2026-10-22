package jb;

import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* loaded from: classes.dex */
public final class i implements k {
    @Override // jb.k
    public final boolean a(SSLSocket sSLSocket) {
        return ib.g.f5036d && Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // jb.k
    public final m b(SSLSocket sSLSocket) {
        return new j();
    }
}
