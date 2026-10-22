package ch.qos.logback.core.rolling.helper;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public class AsynchronousCompressor {
    Compressor compressor;

    public AsynchronousCompressor(Compressor compressor) {
        this.compressor = compressor;
    }

    public Future<?> compressAsynchronously(String str, String str2, String str3) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        Future<?> futureSubmit = scheduledExecutorServiceNewScheduledThreadPool.submit(new CompressionRunnable(this.compressor, str, str2, str3));
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        return futureSubmit;
    }
}
