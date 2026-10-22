package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class BufferCopiedEncodedData implements EncodedData {
    private final MediaCodec.BufferInfo mBufferInfo;
    private final ByteBuffer mByteBuffer;
    private final CallbackToFutureAdapter.Completer<Void> mClosedCompleter;
    private final ListenableFuture<Void> mClosedFuture;

    public static /* synthetic */ Object a(AtomicReference r100, CallbackToFutureAdapter.Completer r101) {
        return lambda$new$0(r100, r101);
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData, java.lang.AutoCloseable
    public void close() {
        this.mClosedCompleter.set(null);
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public ListenableFuture<Void> getClosedFuture() {
        return Futures.nonCancellationPropagating(this.mClosedFuture);
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public long getPresentationTimeUs() {
        return this.mBufferInfo.presentationTimeUs;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public boolean isKeyFrame() {
        if ((this.mBufferInfo.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public long size() {
        return this.mBufferInfo.size;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public MediaCodec.BufferInfo getBufferInfo() {
        return this.mBufferInfo;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public ByteBuffer getByteBuffer() {
        return this.mByteBuffer;
    }

    public BufferCopiedEncodedData(EncodedData r100) {
        this.mBufferInfo = generateCopiedByteInfo(r100);
        this.mByteBuffer = generateCopiedByteBuffer(r100);
        final AtomicReference r101 = new AtomicReference();
        this.mClosedFuture = CallbackToFutureAdapter.getFuture(new a(r101));
        this.mClosedCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r101.get());
    }

    private ByteBuffer generateCopiedByteBuffer(EncodedData r100) {
        ByteBuffer r101 = r100.getByteBuffer();
        MediaCodec.BufferInfo r102 = r100.getBufferInfo();
        r101.position(r102.offset);
        r101.limit(r102.offset + r102.size);
        ByteBuffer r103 = ByteBuffer.allocate(r102.size);
        r103.order(r101.order());
        r103.put(r101);
        r103.flip();
        return r103;
    }

    private MediaCodec.BufferInfo generateCopiedByteInfo(EncodedData r100) {
        MediaCodec.BufferInfo r101 = r100.getBufferInfo();
        MediaCodec.BufferInfo r102 = new MediaCodec.BufferInfo();
        r102.set(0, r101.size, r101.presentationTimeUs, r101.flags);
        return r102;
    }

    private static /* synthetic */ Object lambda$new$0(AtomicReference r100, CallbackToFutureAdapter.Completer r101) throws Exception {
        r100.set(r101);
        return "Data closed";
    }
}
