package yb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ljava/io/IOException;", "Lokio/IOException;", "e", "", Const.INTENT_KEY_APIKEY, "(Ljava/io/IOException;)Z", "okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6036q {
    public static final boolean a(IOException e10) {
        kotlin.jvm.internal.p.i(e10, "e");
        if ((e10 instanceof ProtocolException) || (e10 instanceof InterruptedIOException)) {
            return false;
        }
        return (((e10 instanceof SSLHandshakeException) && (e10.getCause() instanceof CertificateException)) || (e10 instanceof SSLPeerUnverifiedException) || !(e10 instanceof SSLException)) ? false : true;
    }
}
