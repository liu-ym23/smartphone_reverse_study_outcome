package okhttp3.internal.connection;

import h3.C0610t;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/connection/ConnectionSpecSelector;", "", "Ljavax/net/ssl/SSLSocket;", "socket", "", "isFallbackPossible", "(Ljavax/net/ssl/SSLSocket;)Z", "sslSocket", "Lh3/t;", "configureSecureSocket", "(Ljavax/net/ssl/SSLSocket;)Lh3/t;", "Ljava/io/IOException;", "e", "connectionFailed", "(Ljava/io/IOException;)Z", "", "connectionSpecs", "Ljava/util/List;", "", "nextModeIndex", "I", "Z", "isFallback", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class ConnectionSpecSelector {

    @NotNull
    private final List<C0610t> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(@NotNull List<C0610t> connectionSpecs) {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        this.connectionSpecs = connectionSpecs;
    }

    private final boolean isFallbackPossible(SSLSocket socket) {
        int i4 = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (i4 < size) {
            int i5 = i4 + 1;
            if (this.connectionSpecs.get(i4).c(socket)) {
                return true;
            }
            i4 = i5;
        }
        return false;
    }

    @NotNull
    public final C0610t configureSecureSocket(@NotNull SSLSocket sslSocket) throws IOException {
        C0610t c0610t;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        int i4 = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i4 >= size) {
                c0610t = null;
                break;
            }
            int i5 = i4 + 1;
            c0610t = this.connectionSpecs.get(i4);
            if (c0610t.c(sslSocket)) {
                this.nextModeIndex = i5;
                break;
            }
            i4 = i5;
        }
        if (c0610t != null) {
            this.isFallbackPossible = isFallbackPossible(sslSocket);
            c0610t.a(sslSocket, this.isFallback);
            return c0610t;
        }
        StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        sb.append(this.isFallback);
        sb.append(", modes=");
        sb.append(this.connectionSpecs);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        Intrinsics.checkNotNull(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        sb.append(string);
        throw new UnknownServiceException(sb.toString());
    }

    public final boolean connectionFailed(@NotNull IOException e4) {
        Intrinsics.checkNotNullParameter(e4, "e");
        this.isFallback = true;
        return (!this.isFallbackPossible || (e4 instanceof ProtocolException) || (e4 instanceof InterruptedIOException) || ((e4 instanceof SSLHandshakeException) && (e4.getCause() instanceof CertificateException)) || (e4 instanceof SSLPeerUnverifiedException) || !(e4 instanceof SSLException)) ? false : true;
    }
}
