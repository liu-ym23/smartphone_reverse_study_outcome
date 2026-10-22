package am3;

import java.io.IOException;

/* JADX INFO: loaded from: classes14.dex */
public interface f {
    void a();

    f b();

    void c(long r100) throws IOException;

    boolean d() throws IOException;

    byte readByte() throws IOException;

    byte[] readByteArray(long r100) throws IOException;

    int readIntLe() throws IOException;

    long readLongLe() throws IOException;

    String readUtf8(long r100) throws IOException;

    void skip(long r100) throws IOException;
}
