package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
class InputBufferImpl implements InputBuffer {
    private final int mBufferIndex;
    private final ByteBuffer mByteBuffer;
    private boolean mIsEndOfStream;
    private final MediaCodec mMediaCodec;
    private long mPresentationTimeUs;
    private final AtomicBoolean mTerminated;
    private final CallbackToFutureAdapter.Completer<Void> mTerminationCompleter;
    private final ListenableFuture<Void> mTerminationFuture;

    public static /* synthetic */ Object a(AtomicReference r100, CallbackToFutureAdapter.Completer r101) {
        return lambda$new$0(r100, r101);
    }

    private void throwIfTerminated() {
        if (this.mTerminated.get() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("The buffer is submitted or canceled.");
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public boolean cancel() {
        if (this.mTerminated.getAndSet(true) == false) goto L11;
        return false;
    L11:
        this.mMediaCodec.queueInputBuffer(this.mBufferIndex, 0, 0, 0, 0);     // Catch: IllegalStateException -> L8
        this.mTerminationCompleter.set(null);     // Catch: IllegalStateException -> L8
    L10:
        return true;
    L8:
        e = move-exception;
        this.mTerminationCompleter.setException(e);
        goto L10
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public ListenableFuture<Void> getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public boolean submit() {
        if (this.mTerminated.getAndSet(true) == false) goto L14;
        return false;
    L14:
        MediaCodec r100 = this.mMediaCodec;     // Catch: IllegalStateException -> L11
        int r101 = this.mBufferIndex;     // Catch: IllegalStateException -> L11
        int r102 = this.mByteBuffer.position();     // Catch: IllegalStateException -> L11
        int r103 = this.mByteBuffer.limit();     // Catch: IllegalStateException -> L11
        long r104 = this.mPresentationTimeUs;     // Catch: IllegalStateException -> L11
        if (this.mIsEndOfStream == false) goto L8;
        int r105 = 4;
    L9:
        r100.queueInputBuffer(r101, r102, r103, r104, r105);     // Catch: IllegalStateException -> L11
        this.mTerminationCompleter.set(null);     // Catch: IllegalStateException -> L11
        return true;
    L8:
        r105 = 0;
    L11:
        e = move-exception;
        this.mTerminationCompleter.setException(e);
        return false;
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public ByteBuffer getByteBuffer() {
        throwIfTerminated();
        return this.mByteBuffer;
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public void setEndOfStream(boolean r100) {
        throwIfTerminated();
        this.mIsEndOfStream = r100;
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public void setPresentationTimeUs(long r100) {
        throwIfTerminated();
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101);
        this.mPresentationTimeUs = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public InputBufferImpl(MediaCodec r100, int r101) throws MediaCodec.CodecException {
        this.mTerminated = new AtomicBoolean(false);
        this.mPresentationTimeUs = 0;
        this.mIsEndOfStream = false;
        this.mMediaCodec = (MediaCodec) Preconditions.checkNotNull(r100);
        this.mBufferIndex = Preconditions.checkArgumentNonnegative(r101);
        this.mByteBuffer = r100.getInputBuffer(r101);
        final AtomicReference r102 = new AtomicReference();
        this.mTerminationFuture = CallbackToFutureAdapter.getFuture(new q0(r102));
        this.mTerminationCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r102.get());
    }

    private static /* synthetic */ Object lambda$new$0(AtomicReference r100, CallbackToFutureAdapter.Completer r101) throws Exception {
        r100.set(r101);
        return "Terminate InputBuffer";
    }
}
