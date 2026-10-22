package w5;

import java.io.Closeable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements Closeable {

    /* renamed from: c, reason: collision with root package name */
    public b f15242c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15243f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ e f15244g;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f15243f) {
            return;
        }
        this.f15243f = true;
        e eVar = this.f15244g;
        synchronized (eVar) {
            b bVar = this.f15242c;
            int i = bVar.f15241h - 1;
            bVar.f15241h = i;
            if (i == 0 && bVar.f15239f) {
                hc.g gVar = e.f15246u;
                eVar.F(bVar);
            }
        }
    }
}
