package V9;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

/* loaded from: classes4.dex */
public interface i extends w, ReadableByteChannel {
    long C();

    InputStream D();

    g a();

    g d();

    long h(ByteString byteString);

    String j(long j5);

    long o(g gVar);

    void p(g gVar, long j5);

    String q();

    byte readByte();

    int readInt();

    short readShort();

    boolean request(long j5);

    void skip(long j5);

    void t(long j5);

    ByteString v(long j5);

    String x(Charset charset);

    int z(p pVar);
}
