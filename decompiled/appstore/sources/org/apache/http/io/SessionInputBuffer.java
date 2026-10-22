package org.apache.http.io;

import java.io.IOException;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public interface SessionInputBuffer {
    HttpTransportMetrics getMetrics();

    @Deprecated
    boolean isDataAvailable(int r10) throws IOException;

    int read() throws IOException;

    int read(byte[] r10) throws IOException;

    int read(byte[] r10, int r11, int r12) throws IOException;

    int readLine(CharArrayBuffer r10) throws IOException;

    String readLine() throws IOException;
}
