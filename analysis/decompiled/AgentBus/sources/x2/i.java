package x2;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final class i extends n7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7.a f11123a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f11124b;

    public i(n7.a aVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f11123a = aVar;
        this.f11124b = threadPoolExecutor;
    }

    @Override // n7.a
    public final void t(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f11124b;
        try {
            this.f11123a.t(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // n7.a
    public final void u(i5.f fVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f11124b;
        try {
            this.f11123a.u(fVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
