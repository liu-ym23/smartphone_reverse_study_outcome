package androidx.lifecycle;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h1;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Closeable, CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f3515a;

    public d(CoroutineContext r10) {
        this.f3515a = r10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        h1.d(getCoroutineContext(), null, 1, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f3515a;
    }
}
