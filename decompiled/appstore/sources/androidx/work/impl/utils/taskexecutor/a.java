package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.o;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class a implements TaskExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f5852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f5853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f5854c;

    /* JADX INFO: renamed from: androidx.work.impl.utils.taskexecutor.a$a, reason: collision with other inner class name */
    public class ExecutorC0062a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f5855a;

        public ExecutorC0062a(a r10) {
            this.f5855a = r10;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            this.f5855a.f5853b.post(r10);
        }
    }

    public a(Executor r10) {
        this.f5853b = new Handler(Looper.getMainLooper());
        this.f5854c = new ExecutorC0062a(this);
        this.f5852a = new o(r10);
    }

    public o a() {
        return this.f5852a;
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public Executor getMainThreadExecutor() {
        return this.f5854c;
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public /* bridge */ /* synthetic */ SerialExecutor getSerialTaskExecutor() {
        return a();
    }
}
