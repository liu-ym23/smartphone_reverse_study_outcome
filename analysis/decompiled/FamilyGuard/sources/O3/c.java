package O3;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class c implements Future<Object> {

    /* renamed from: a, reason: collision with root package name */
    final A3.c f4364a;

    c(A3.c cVar) {
        this.f4364a = cVar;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        this.f4364a.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j5, TimeUnit timeUnit) {
        return null;
    }
}
