package org.apache.http.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes4.dex */
public interface TrustStrategy {
    boolean isTrusted(X509Certificate[] r10, String r11) throws CertificateException;
}
