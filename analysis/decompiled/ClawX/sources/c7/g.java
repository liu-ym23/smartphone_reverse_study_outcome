package c7;

import java.nio.channels.WritableByteChannel;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public interface g extends t, WritableByteChannel {
    g B(String str);

    f c();

    @Override // c7.t, java.io.Flushable
    void flush();

    g r(i iVar);

    g write(byte[] bArr);

    g writeByte(int i8);

    g writeInt(int i8);

    g writeShort(int i8);
}
