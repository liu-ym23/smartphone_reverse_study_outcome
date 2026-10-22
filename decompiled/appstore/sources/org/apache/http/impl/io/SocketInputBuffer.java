package org.apache.http.impl.io;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.io.EofSensor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
    private boolean eof;
    private final Socket socket;

    public SocketInputBuffer(Socket r10, int r11, HttpParams r12) throws IOException {
        Args.notNull(r10, "Socket");
        this.socket = r10;
        this.eof = false;
        if (r11 >= 0) goto L6;
        r11 = r10.getReceiveBufferSize();
    L6:
        if (r11 >= 1024) goto L8;
        r11 = 1024;
    L8:
        init(r10.getInputStream(), r11, r12);
    }

    @Override // org.apache.http.impl.io.AbstractSessionInputBuffer
    public int fillBuffer() throws IOException {
        int r10 = super.fillBuffer();
        if (r10 != (-1)) goto L5;
        boolean r11 = true;
    L6:
        this.eof = r11;
        return r10;
    L5:
        r11 = false;
        goto L6
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int r10) throws IOException {
        boolean r11 = hasBufferedData();
        if (r11 == true) goto L10;
        int r12 = this.socket.getSoTimeout();
        this.socket.setSoTimeout(r10);     // Catch: Throwable -> L7
        fillBuffer();     // Catch: Throwable -> L7
        boolean r13 = hasBufferedData();     // Catch: Throwable -> L7
        this.socket.setSoTimeout(r12);
        return r13;
    L7:
        th = move-exception;
        this.socket.setSoTimeout(r12);
        throw th;
    L10:
        return r11;
    }

    @Override // org.apache.http.io.EofSensor
    public boolean isEof() {
        return this.eof;
    }
}
