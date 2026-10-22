package ob;

import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public interface j extends k0, ReadableByteChannel {
    long A(i iVar);

    int B(y yVar);

    long D(k kVar);

    String F(long j2);

    void J(h hVar, long j2);

    void L(long j2);

    long O();

    String P(Charset charset);

    h c();

    k j(long j2);

    boolean p(long j2);

    e0 peek();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    void skip(long j2);

    String w();

    long y(k kVar);
}
