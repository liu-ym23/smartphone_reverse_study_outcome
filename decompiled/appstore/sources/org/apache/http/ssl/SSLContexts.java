package org.apache.http.ssl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;

/* JADX INFO: loaded from: classes4.dex */
public class SSLContexts {
    public SSLContexts() {
    }

    public static SSLContext createDefault() throws SSLInitializationException {
        SSLContext r10 = SSLContext.getInstance("TLS");     // Catch: KeyManagementException -> L4 NoSuchAlgorithmException -> L6
        r10.init(null, null, null);     // Catch: KeyManagementException -> L4 NoSuchAlgorithmException -> L6
        return r10;
    L4:
        e = move-exception;
        throw new SSLInitializationException(e.getMessage(), e);
    L6:
        e = move-exception;
        throw new SSLInitializationException(e.getMessage(), e);
    }

    public static SSLContext createSystemDefault() throws SSLInitializationException {
        return SSLContext.getDefault();
    L5:
        return createDefault();
    }

    public static SSLContextBuilder custom() {
        return SSLContextBuilder.create();
    }
}
