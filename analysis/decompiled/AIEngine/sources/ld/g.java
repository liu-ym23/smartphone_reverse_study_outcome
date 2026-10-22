package ld;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kd.h;
import ld.i;
import okhttp3.Protocol;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements j {

    /* renamed from: a, reason: collision with root package name */
    public static final a f10427a = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements i.a {
        @Override // ld.i.a
        public final boolean a(SSLSocket sSLSocket) {
            boolean z = kd.c.f9965b;
            return false;
        }

        @Override // ld.i.a
        public final j b(SSLSocket sSLSocket) {
            return new g();
        }
    }

    @Override // ld.j
    public final boolean a(SSLSocket sSLSocket) {
        return false;
    }

    @Override // ld.j
    public final boolean b() {
        boolean z = kd.c.f9965b;
        return kd.c.f9965b;
    }

    @Override // ld.j
    public final String c(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // ld.j
    public final void f(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            kd.h.Companion.getClass();
            parameters.setApplicationProtocols((String[]) h.a.a(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }
}
