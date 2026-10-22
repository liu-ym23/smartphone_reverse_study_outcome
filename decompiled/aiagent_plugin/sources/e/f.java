package e;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: BufferedSink.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface f extends y, WritableByteChannel {
    f B();

    f C();

    f b(String r1);

    e c();

    f c(h r1);

    f c(byte[] r1);

    f c(byte[] r1, int r2, int r3);

    e d();

    OutputStream e();

    @Override // e.y, java.io.Flushable
    void flush();

    f h(int r1);

    f i(int r1);

    f j(int r1);

    f k(int r1);

    f m(long r1);

    f n(long r1);

    f o(long r1);
}
