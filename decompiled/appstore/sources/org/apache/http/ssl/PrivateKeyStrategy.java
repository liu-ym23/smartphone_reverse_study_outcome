package org.apache.http.ssl;

import java.net.Socket;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface PrivateKeyStrategy {
    String chooseAlias(Map<String, PrivateKeyDetails> r10, Socket r11);
}
