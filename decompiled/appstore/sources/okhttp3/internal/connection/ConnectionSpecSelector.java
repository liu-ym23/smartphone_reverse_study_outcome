package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;

/* JADX INFO: loaded from: classes4.dex */
public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(List<ConnectionSpec> r10) {
        this.nextModeIndex = 0;
        this.connectionSpecs = r10;
    }

    private boolean isFallbackPossible(SSLSocket r10) {
        int r11 = this.nextModeIndex;
    L4:
        if (r11 >= this.connectionSpecs.size()) goto L10;
        if (this.connectionSpecs.get(r11).c(r10) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public ConnectionSpec configureSecureSocket(SSLSocket r10) throws IOException {
        int r11 = this.nextModeIndex;
        int r12 = this.connectionSpecs.size();
    L3:
        if (r11 >= r12) goto L8;
        ConnectionSpec r13 = this.connectionSpecs.get(r11);
        if (r13.c(r10) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        this.nextModeIndex = r11 + 1;
    L9:
        if (r13 == null) goto L13;
        this.isFallbackPossible = isFallbackPossible(r10);
        Internal.instance.apply(r13, r10, this.isFallback);
        return r13;
    L13:
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.isFallback + ", modes=" + this.connectionSpecs + ", supported protocols=" + Arrays.toString(r10.getEnabledProtocols()));
    L8:
        r13 = null;
        goto L9
    }

    public boolean connectionFailed(IOException r10) {
        this.isFallback = true;
        if (this.isFallbackPossible == true) goto L6;
        return false;
    L6:
        if ((r10 instanceof ProtocolException) == false) goto L9;
        return false;
    L9:
        if ((r10 instanceof InterruptedIOException) == false) goto L11;
        return false;
    L11:
        boolean r11 = r10 instanceof SSLHandshakeException;
        if (r11 == false) goto L17;
        if ((r10.getCause() instanceof CertificateException) == false) goto L17;
        return false;
    L17:
        if ((r10 instanceof SSLPeerUnverifiedException) == false) goto L19;
        return false;
    L19:
        if (r11 == false) goto L21;
        return true;
    L21:
        if ((r10 instanceof SSLProtocolException) == false) goto L24;
        return true;
    L24:
        return false;
    }
}
