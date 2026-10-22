package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.startup.Initializer;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class ProfileInstallerInitializer implements Initializer<Result> {
    private static final int DELAY_MS = 5000;

    public static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler createAsync(Looper r100) {
            return Handler.createAsync(r100);
        }
    }

    public static class Result {
        public Result() {
        }
    }

    public ProfileInstallerInitializer() {
    }

    public static /* synthetic */ void a(ProfileInstallerInitializer r100, Context r101, long r102) {
        r100.lambda$create$0(r101, r102);
    }

    public static /* synthetic */ void b(Context r100) {
        lambda$installAfterDelay$1(r100);
    }

    public static /* synthetic */ void c(Context r100) {
        lambda$writeInBackground$2(r100);
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    private static /* synthetic */ void lambda$installAfterDelay$1(Context r100) {
        writeInBackground(r100);
    }

    private static /* synthetic */ void lambda$writeInBackground$2(Context r100) {
        ProfileInstaller.writeProfile(r100);
    }

    private static void writeInBackground(final Context r100) {
        new PThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("ProfileInstallerInitializer")).execute(new f(r100));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public Result create(Context r100) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        final Context r101 = r100.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new g(this, r101));
        return new Result();
    L5:
        return new Result();
    }

    public void installAfterDelay(final Context r100) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        Handler r101 = Handler28Impl.createAsync(Looper.getMainLooper());
    L6:
        r101.postDelayed(new e(r100), new Random().nextInt(Math.max(1000, 1)) + 5000);
        return;
    L5:
        r101 = new Handler(Looper.getMainLooper());
        goto L6
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Result create(Context r100) {
        return create(r100);
    }

    private /* synthetic */ void lambda$create$0(Context r100, long r101) {
        installAfterDelay(r100);
    }
}
