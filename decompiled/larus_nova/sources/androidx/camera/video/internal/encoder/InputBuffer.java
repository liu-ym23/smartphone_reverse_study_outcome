package androidx.camera.video.internal.encoder;

import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface InputBuffer {
    boolean cancel();

    ByteBuffer getByteBuffer();

    ListenableFuture<Void> getTerminationFuture();

    void setEndOfStream(boolean r100);

    void setPresentationTimeUs(long r100);

    boolean submit();
}
