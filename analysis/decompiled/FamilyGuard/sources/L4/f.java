package L4;

import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface f extends w, WritableByteChannel {
    f H(String str);

    f Q(long j5);

    f R(h hVar);

    @Override // L4.w, java.io.Flushable
    void flush();

    e i();

    f r0(long j5);

    f write(byte[] bArr);

    f write(byte[] bArr, int i5, int i6);

    f writeByte(int i5);

    f writeInt(int i5);

    f writeShort(int i5);
}
