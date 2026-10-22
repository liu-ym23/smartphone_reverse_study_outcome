package sd;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface h extends e0, ReadableByteChannel {
    long E0();

    InputStream F0();

    void I(e eVar, long j10);

    boolean M(long j10);

    String N();

    int R(w wVar);

    void T(long j10);

    ByteString X(long j10);

    e c();

    long d0(e eVar);

    boolean f0();

    String p0(Charset charset);

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    void skip(long j10);

    String v();

    String x(long j10);
}
