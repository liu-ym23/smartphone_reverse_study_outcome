package c7;

import java.io.Closeable;
import java.io.Flushable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public interface t extends Closeable, Flushable {
    void close();

    x d();

    @Override // java.io.Flushable
    void flush();

    void x(long j4, f fVar);
}
