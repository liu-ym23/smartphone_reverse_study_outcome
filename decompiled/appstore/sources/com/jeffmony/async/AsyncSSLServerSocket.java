package com.jeffmony.async;

import java.security.PrivateKey;
import java.security.cert.Certificate;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncSSLServerSocket extends AsyncServerSocket {
    Certificate getCertificate();

    PrivateKey getPrivateKey();
}
