package androidx.camera.core.processing;

import androidx.camera.core.SurfaceProcessor;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes2.dex */
public interface SurfaceProcessorInternal extends SurfaceProcessor {

    /* JADX INFO: renamed from: androidx.camera.core.processing.SurfaceProcessorInternal$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ListenableFuture $default$snapshot(SurfaceProcessorInternal r100, int r101, int r102) {
            return Futures.immediateFuture(null);
        }
    }

    void release();

    ListenableFuture<Void> snapshot(int r100, int r101);
}
