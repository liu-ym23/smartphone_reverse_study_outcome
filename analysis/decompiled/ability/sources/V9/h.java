package V9;

import java.nio.channels.WritableByteChannel;
import okio.ByteString;

/* loaded from: classes4.dex */
public interface h extends u, WritableByteChannel {
    h A(ByteString byteString);

    long B(w wVar);

    g a();

    @Override // V9.u, java.io.Flushable
    void flush();

    h m(String str);

    h u(long j5);

    h write(byte[] bArr);

    h write(byte[] bArr, int i, int i6);

    h writeByte(int i);

    h writeInt(int i);

    h writeShort(int i);

    h y(long j5);
}
