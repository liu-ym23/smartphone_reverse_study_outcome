package androidx.appsearch.app;

import android.content.Context;
import android.os.UserHandle;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public interface AppSearchEnvironment {
    public static final int FRAMEWORK_ENVIRONMENT = 2;
    public static final int JETPACK_ENVIRONMENT = 1;
    public static final int PLAY_SERVICES_ENVIRONMENT = 3;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EnvironmentType {
    }

    ExecutorService createCachedThreadPoolExecutor();

    Context createContextAsUser(Context context, UserHandle userHandle);

    ExecutorService createExecutorService(int i, int i6, long j5, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, int i10);

    ExecutorService createSingleThreadExecutor();

    File getAppSearchDir(Context context, UserHandle userHandle);

    File getCacheDir(Context context);

    int getEnvironment();

    boolean isInfoLoggingEnabled();
}
