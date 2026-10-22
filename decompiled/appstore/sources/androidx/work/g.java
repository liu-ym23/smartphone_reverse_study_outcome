package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f5413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f5414b;

    public g(CancellableContinuation r10, ListenableFuture r11) {
        this.f5413a = r10;
        this.f5414b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CancellableContinuation r10 = this.f5413a;     // Catch: Throwable -> L4
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L4
        r10.resumeWith(Result.m35constructorimpl(this.f5414b.get()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Throwable r12 = th.getCause();
        if (r12 != null) goto L9;
        r12 = th;
    L9:
        if ((th instanceof CancellationException) == false) goto L11;
        this.f5413a.cancel(r12);
        return;
    L11:
        CancellableContinuation r13 = this.f5413a;
        Result.a r14 = Result.Companion;
        r13.resumeWith(Result.m35constructorimpl(kotlin.c.a(r12)));
    }
}
