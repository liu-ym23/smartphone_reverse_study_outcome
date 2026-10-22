package t6;

import java.io.IOException;
import n6.k;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: e, reason: collision with root package name */
    public boolean f5594e;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws NumberFormatException {
        if (this.f5588c) {
            return;
        }
        if (!this.f5594e) {
            a(f.f5595f);
        }
        this.f5588c = true;
    }

    @Override // t6.b, c7.v
    public final long h(long j4, c7.f fVar) throws NumberFormatException, IOException {
        if (this.f5588c) {
            throw new IllegalStateException("closed");
        }
        if (this.f5594e) {
            return -1L;
        }
        long jH = super.h(8192L, fVar);
        if (jH != -1) {
            return jH;
        }
        this.f5594e = true;
        a(k.f4053b);
        return -1L;
    }
}
