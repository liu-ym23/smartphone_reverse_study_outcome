package od;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface k extends i0, ReadableByteChannel {
    String D();

    int E(y yVar);

    long J();

    InputStream L();

    i a();

    long k(j jVar);

    String q(long j10);

    boolean request(long j10);

    String x(Charset charset);
}
