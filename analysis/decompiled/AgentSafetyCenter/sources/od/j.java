package od;

import java.nio.channels.WritableByteChannel;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface j extends g0, WritableByteChannel {
    j I(long j10);

    i a();

    @Override // od.g0, java.io.Flushable
    void flush();

    j t(l lVar);

    j u(int i, byte[] bArr);

    j v(String str);

    j write(byte[] bArr);

    j writeByte(int i);

    j y(long j10);
}
