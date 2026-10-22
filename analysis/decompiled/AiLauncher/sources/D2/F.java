package D2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class F implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f2209a = new B2.a(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f2209a.post(runnable);
    }
}
