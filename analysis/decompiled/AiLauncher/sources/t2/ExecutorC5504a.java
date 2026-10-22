package t2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import x2.c;

/* renamed from: t2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ExecutorC5504a implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f41996a;

    public ExecutorC5504a(Looper looper) {
        this.f41996a = new c(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f41996a.post(runnable);
    }
}
