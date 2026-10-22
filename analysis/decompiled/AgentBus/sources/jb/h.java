package jb;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* loaded from: classes.dex */
public final class h implements m {

    /* renamed from: a, reason: collision with root package name */
    public static final g f5437a = new g();

    @Override // jb.m
    public final boolean a(SSLSocket sSLSocket) {
        return false;
    }

    @Override // jb.m
    public final String b(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // jb.m
    public final boolean c() {
        boolean z4 = ib.d.f5033d;
        return ib.d.f5033d;
    }

    @Override // jb.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        q7.k.e(list, "protocols");
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            ib.m mVar = ib.m.f5049a;
            parameters.setApplicationProtocols((String[]) ib.c.h(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }
}
