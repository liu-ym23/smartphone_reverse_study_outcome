package org.apache.http.ssl;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public final class PrivateKeyDetails {
    private final X509Certificate[] certChain;
    private final String type;

    public PrivateKeyDetails(String r10, X509Certificate[] r11) {
        this.type = (String) Args.notNull(r10, "Private key type");
        this.certChain = r11;
    }

    public X509Certificate[] getCertChain() {
        return this.certChain;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return this.type + ':' + Arrays.toString(this.certChain);
    }
}
