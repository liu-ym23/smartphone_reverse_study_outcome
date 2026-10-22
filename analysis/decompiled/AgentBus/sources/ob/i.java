package ob;

import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface i extends i0, WritableByteChannel {
    i M(String str);

    h c();

    i f(String str, int i2, int i10);

    @Override // ob.i0, java.io.Flushable
    void flush();

    i h(long j2);

    i m();

    i v(k kVar);

    i write(byte[] bArr);

    i writeByte(int i2);

    i writeInt(int i2);

    i writeShort(int i2);
}
