package org.apache.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class ConnectionClosedException extends IOException {
    private static final long serialVersionUID = 617550366255636674L;

    public ConnectionClosedException() {
        super("Connection is closed");
    }

    public ConnectionClosedException(String r10) {
        super(HttpException.clean(r10));
    }

    public ConnectionClosedException(String r10, Object... r11) {
        super(HttpException.clean(String.format(r10, r11)));
    }
}
