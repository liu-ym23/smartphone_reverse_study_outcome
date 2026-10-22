package X;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final class m extends B0.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ B0.f f2070b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f2071c;

    public m(B0.f fVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f2070b = fVar;
        this.f2071c = threadPoolExecutor;
    }

    @Override // B0.f
    public final void U(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f2071c;
        try {
            this.f2070b.U(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // B0.f
    public final void V(t.d dVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f2071c;
        try {
            this.f2070b.V(dVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
