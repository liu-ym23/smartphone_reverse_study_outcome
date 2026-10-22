package k3;

import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* renamed from: k3.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0696k extends InterfaceC0680B, ReadableByteChannel {
    void E(long j4);

    void F(C0694i c0694i, long j4);

    long J();

    String K(Charset charset);

    long L(C0694i c0694i);

    C0693h M();

    boolean c(long j4);

    C0694i f();

    l h();

    l i(long j4);

    void j(long j4);

    String n();

    byte[] o();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    boolean s();

    String y(long j4);

    int z(t tVar);
}
