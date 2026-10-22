package F4;

import C4.l;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<l> f1756a;

    /* renamed from: b, reason: collision with root package name */
    private int f1757b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1758c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1759d;

    b(List<l> list) {
        this.f1756a = list;
    }

    private boolean c(SSLSocket sSLSocket) {
        for (int i5 = this.f1757b; i5 < this.f1756a.size(); i5++) {
            if (this.f1756a.get(i5).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    l a(SSLSocket sSLSocket) throws UnknownServiceException {
        l lVar;
        int i5 = this.f1757b;
        int size = this.f1756a.size();
        while (true) {
            if (i5 >= size) {
                lVar = null;
                break;
            }
            lVar = this.f1756a.get(i5);
            if (lVar.c(sSLSocket)) {
                this.f1757b = i5 + 1;
                break;
            }
            i5++;
        }
        if (lVar != null) {
            this.f1758c = c(sSLSocket);
            D4.a.f1202a.c(lVar, sSLSocket, this.f1759d);
            return lVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f1759d + ", modes=" + this.f1756a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    boolean b(IOException iOException) {
        this.f1759d = true;
        if (!this.f1758c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return iOException instanceof SSLException;
    }
}
