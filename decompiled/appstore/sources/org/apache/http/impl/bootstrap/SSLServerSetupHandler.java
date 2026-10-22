package org.apache.http.impl.bootstrap;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;

/* JADX INFO: loaded from: classes4.dex */
public interface SSLServerSetupHandler {
    void initialize(SSLServerSocket r10) throws SSLException;
}
