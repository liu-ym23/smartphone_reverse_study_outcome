package yc;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: yc.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ExecutorC6042a implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f44308a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f44308a.post(runnable);
    }
}
