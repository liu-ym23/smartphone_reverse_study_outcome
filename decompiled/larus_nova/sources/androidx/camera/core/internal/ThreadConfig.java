package androidx.camera.core.internal;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public interface ThreadConfig extends ReadableConfig {
    public static final Config.Option<Executor> OPTION_BACKGROUND_EXECUTOR = null;

    /* JADX INFO: renamed from: androidx.camera.core.internal.ThreadConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Executor $default$getBackgroundExecutor(ThreadConfig r100) {
            return (Executor) r100.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR);
        }

        public static Executor $default$getBackgroundExecutor(ThreadConfig r100, Executor r101) {
            return (Executor) r100.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, r101);
        }
    }

    public interface Builder<B> {
        B setBackgroundExecutor(Executor r100);
    }

    Executor getBackgroundExecutor();

    Executor getBackgroundExecutor(Executor r100);

    static {
        OPTION_BACKGROUND_EXECUTOR = Config.Option.create("camerax.core.thread.backgroundExecutor", Executor.class);
    }
}
