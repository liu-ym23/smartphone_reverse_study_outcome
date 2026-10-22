package androidx.camera.core.impl.utils.executor;

import android.os.Process;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class AudioExecutor implements Executor {
    private static volatile Executor sExecutor;
    private final ExecutorService mAudioService;

    /* JADX INFO: renamed from: androidx.camera.core.impl.utils.executor.AudioExecutor$1, reason: invalid class name */
    public class AnonymousClass1 implements ThreadFactory {
        private static final String THREAD_NAME_STEM = "CameraX-camerax_audio_%d";
        private final AtomicInteger mThreadId;
        final /* synthetic */ AudioExecutor this$0;

        public static /* synthetic */ void a(Runnable r100) {
            lambda$newThread$0(r100);
        }

        public AnonymousClass1(AudioExecutor r100) {
            this.this$0 = r100;
            this.mThreadId = new AtomicInteger(0);
        }

        private static /* synthetic */ void lambda$newThread$0(Runnable r100) {
            Process.setThreadPriority(-16);
            r100.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(new a(r100), "AudioExecutor$1");
            ThreadMethodProxy.setName(r101, String.format(Locale.US, THREAD_NAME_STEM, new Object[]{Integer.valueOf(this.mThreadId.getAndIncrement())}));
            return r101;
        }
    }

    public static Executor getInstance() {
        if (sExecutor == null) goto L7;
        return sExecutor;
    L7:
        monitor-enter(AudioExecutor.class);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (sExecutor != null) goto L11;
        sExecutor = new AudioExecutor();     // Catch: Throwable -> L14
    L11:
        monitor-exit(AudioExecutor.class);     // Catch: Throwable -> L14
        return sExecutor;
    }

    public AudioExecutor() {
        this.mAudioService = PThreadExecutorsUtils.newFixedThreadPool(2, new AnonymousClass1(this));
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        this.mAudioService.execute(r100);
    }
}
