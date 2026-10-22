package ld;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kd.h;
import ld.i;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h implements j {

    /* renamed from: a, reason: collision with root package name */
    public static final a f10428a = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements i.a {
        @Override // ld.i.a
        public final boolean a(SSLSocket sSLSocket) {
            return kd.d.f9967b && Conscrypt.isConscrypt(sSLSocket);
        }

        @Override // ld.i.a
        public final j b(SSLSocket sSLSocket) {
            return new h();
        }
    }

    @Override // ld.j
    public final boolean a(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // ld.j
    public final boolean b() {
        boolean z = kd.d.f9967b;
        return kd.d.f9967b;
    }

    @Override // ld.j
    public final String c(SSLSocket sSLSocket) {
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // ld.j
    public final void f(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            kd.h.Companion.getClass();
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) h.a.a(list).toArray(new String[0]));
        }
    }
}
