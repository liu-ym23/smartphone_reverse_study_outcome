package org.apache.http.io;

import java.io.IOException;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public interface SessionOutputBuffer {
    void flush() throws IOException;

    HttpTransportMetrics getMetrics();

    void write(int r10) throws IOException;

    void write(byte[] r10) throws IOException;

    void write(byte[] r10, int r11, int r12) throws IOException;

    void writeLine(String r10) throws IOException;

    void writeLine(CharArrayBuffer r10) throws IOException;
}
