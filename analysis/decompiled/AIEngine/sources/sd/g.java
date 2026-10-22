package sd;

import java.nio.channels.WritableByteChannel;
import okio.ByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface g extends c0, WritableByteChannel {
    g D(String str);

    e c();

    @Override // sd.c0, java.io.Flushable
    void flush();

    g p();

    g s0(long j10);

    long u(e0 e0Var);

    g write(byte[] bArr);

    g write(byte[] bArr, int i10, int i11);

    g writeByte(int i10);

    g writeInt(int i10);

    g writeShort(int i10);

    g z0(ByteString byteString);
}
