package L4;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public interface g extends y, ReadableByteChannel {
    int J(p pVar);

    String K(Charset charset);

    String b0();

    long e0(w wVar);

    byte[] g0(long j5);

    h j(long j5);

    void q0(long j5);

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    short readShort();

    e s();

    void skip(long j5);

    boolean t();

    long v0();

    InputStream x0();

    String y(long j5);
}
