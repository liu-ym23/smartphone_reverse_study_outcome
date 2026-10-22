package qa;

import java.util.concurrent.CompletableFuture;

/* renamed from: qa.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1856h extends CompletableFuture {

    /* renamed from: a, reason: collision with root package name */
    public final v f5654a;

    public C1856h(v vVar) {
        this.f5654a = vVar;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        if (z10) {
            this.f5654a.cancel();
        }
        return super.cancel(z10);
    }
}
