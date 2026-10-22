package androidx.appsearch.app;

import android.content.Context;
import android.os.UserHandle;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class JetpackAppSearchEnvironment implements AppSearchEnvironment {
    @Override // androidx.appsearch.app.AppSearchEnvironment
    public ExecutorService createCachedThreadPoolExecutor() {
        return Executors.newCachedThreadPool();
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public Context createContextAsUser(Context context, UserHandle userHandle) {
        return context;
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public ExecutorService createExecutorService(int i, int i6, long j5, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, int i10) {
        return new ThreadPoolExecutor(i, i6, j5, timeUnit, blockingQueue);
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public ExecutorService createSingleThreadExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public File getAppSearchDir(Context context, UserHandle userHandle) {
        return new File(context.getFilesDir(), "appsearch");
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public File getCacheDir(Context context) {
        return context.getCacheDir();
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public int getEnvironment() {
        return 1;
    }

    @Override // androidx.appsearch.app.AppSearchEnvironment
    public boolean isInfoLoggingEnabled() {
        return true;
    }
}
