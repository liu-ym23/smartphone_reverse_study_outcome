package o3;

import java.util.concurrent.Callable;

/* renamed from: o3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class CallableC1758a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f5418a;

    public CallableC1758a(f fVar) {
        this.f5418a = fVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (this.f5418a) {
            try {
                f fVar = this.f5418a;
                if (fVar.i == null) {
                    return null;
                }
                fVar.F();
                if (this.f5418a.i()) {
                    this.f5418a.s();
                    this.f5418a.k = 0;
                }
                return null;
            } finally {
            }
        }
    }
}
