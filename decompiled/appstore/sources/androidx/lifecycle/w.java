package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class w extends CoroutineDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f3578c;

    public w() {
        this.f3578c = new h();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void a(CoroutineContext r10, Runnable r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "block");
        this.f3578c.c(r10, r11);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean c(CoroutineContext r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        if (kotlinx.coroutines.l0.c().e().c(r10) == false) goto L6;
        return true;
    L6:
        return !this.f3578c.b();
    }
}
