package c7;

import java.nio.channels.ReadableByteChannel;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public interface h extends v, ReadableByteChannel {
    void D(long j4, f fVar);

    void f(long j4);

    i i(long j4);

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    void skip(long j4);

    String w(long j4);
}
