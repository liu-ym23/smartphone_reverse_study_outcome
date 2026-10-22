package org.apache.http.impl.io;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SocketOutputBuffer extends AbstractSessionOutputBuffer {
    public SocketOutputBuffer(Socket r10, int r11, HttpParams r12) throws IOException {
        Args.notNull(r10, "Socket");
        if (r11 >= 0) goto L6;
        r11 = r10.getSendBufferSize();
    L6:
        if (r11 >= 1024) goto L8;
        r11 = 1024;
    L8:
        init(r10.getOutputStream(), r11, r12);
    }
}
