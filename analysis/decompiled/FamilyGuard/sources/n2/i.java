package n2;

import C4.G;
import C4.y;
import java.io.IOException;

/* loaded from: classes.dex */
class i extends G {

    /* renamed from: b, reason: collision with root package name */
    private final long f18931b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f18932c;

    /* renamed from: d, reason: collision with root package name */
    private final y f18933d;

    /* renamed from: e, reason: collision with root package name */
    private final long f18934e;

    /* renamed from: f, reason: collision with root package name */
    private final L4.g f18935f;

    i(long j5, boolean z5, y yVar, long j6, L4.g gVar) {
        this.f18931b = j5;
        this.f18932c = z5;
        this.f18933d = yVar;
        this.f18934e = j6;
        this.f18935f = gVar;
    }

    public long A() {
        return this.f18931b;
    }

    boolean C() {
        return this.f18932c;
    }

    @Override // C4.G, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        L4.g gVar = this.f18935f;
        if (gVar != null) {
            try {
                gVar.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // C4.G
    public long o() {
        return this.f18934e;
    }

    @Override // C4.G
    public y r() {
        return this.f18933d;
    }

    @Override // C4.G
    public L4.g w() {
        return this.f18935f;
    }
}
