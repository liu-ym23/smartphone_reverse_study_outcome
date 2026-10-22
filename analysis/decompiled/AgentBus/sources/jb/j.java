package jb;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* loaded from: classes.dex */
public final class j implements m {

    /* renamed from: a, reason: collision with root package name */
    public static final i f5438a = new i();

    @Override // jb.m
    public final boolean a(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // jb.m
    public final String b(SSLSocket sSLSocket) {
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // jb.m
    public final boolean c() {
        boolean z4 = ib.g.f5036d;
        return ib.g.f5036d;
    }

    @Override // jb.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        q7.k.e(list, "protocols");
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            ib.m mVar = ib.m.f5049a;
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) ib.c.h(list).toArray(new String[0]));
        }
    }
}
