package r3;

import org.tensorflow.Graph;

/* loaded from: classes2.dex */
public final class b implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f14088a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Graph f14089b;

    public b(Graph graph) {
        this.f14089b = graph;
        synchronized (graph.f13814a) {
            try {
                boolean z4 = graph.f13815b != 0;
                this.f14088a = z4;
                if (!z4) {
                    throw new IllegalStateException("close() has been called on the Graph");
                }
                this.f14088a = true;
                graph.f13816c++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final long a() {
        long j4;
        synchronized (this.f14089b.f13814a) {
            try {
                j4 = this.f14088a ? this.f14089b.f13815b : 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j4;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f14089b.f13814a) {
            try {
                if (this.f14088a) {
                    this.f14088a = false;
                    Graph graph = this.f14089b;
                    int i4 = graph.f13816c - 1;
                    graph.f13816c = i4;
                    if (i4 == 0) {
                        graph.f13814a.notifyAll();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
