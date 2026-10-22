package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class GifFrameLoader {
    private final BitmapPool bitmapPool;
    private final List<FrameCallback> callbacks;
    private DelayTarget current;
    private Bitmap firstFrame;
    private final GifDecoder gifDecoder;
    private final Handler handler;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private DelayTarget next;

    @Nullable
    private OnEveryFrameListener onEveryFrameListener;
    private DelayTarget pendingTarget;
    private RequestBuilder<Bitmap> requestBuilder;
    final RequestManager requestManager;
    private boolean startFromFirstFrame;
    private Transformation<Bitmap> transformation;

    @VisibleForTesting
    public static class DelayTarget extends SimpleTarget<Bitmap> {
        private final Handler handler;
        final int index;
        private Bitmap resource;
        private final long targetTime;

        public DelayTarget(Handler r10, int r11, long r12) {
            this.handler = r10;
            this.index = r11;
            this.targetTime = r12;
        }

        public Bitmap getResource() {
            return this.resource;
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object r10, @Nullable Transition r11) {
            onResourceReady((Bitmap) r10, r11);
        }

        public void onResourceReady(@NonNull Bitmap r10, @Nullable Transition<? super Bitmap> r11) {
            this.resource = r10;
            Message r12 = this.handler.obtainMessage(1, this);
            this.handler.sendMessageAtTime(r12, this.targetTime);
        }
    }

    public interface FrameCallback {
        void onFrameReady();
    }

    public class FrameLoaderCallback implements Handler.Callback {
        static final int MSG_CLEAR = 2;
        static final int MSG_DELAY = 1;
        final /* synthetic */ GifFrameLoader this$0;

        public FrameLoaderCallback(GifFrameLoader r10) {
            this.this$0 = r10;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 != 1) goto L7;
            DelayTarget r12 = (DelayTarget) r10.obj;
            this.this$0.onFrameReady(r12);
            return true;
        L7:
            if (r11 != 2) goto L11;
            DelayTarget r13 = (DelayTarget) r10.obj;
            this.this$0.requestManager.clear(r13);
            return false;
        L11:
            return false;
        }
    }

    @VisibleForTesting
    public interface OnEveryFrameListener {
        void onFrameReady();
    }

    public GifFrameLoader(Glide r10, GifDecoder r11, int r12, int r13, Transformation<Bitmap> r14, Bitmap r15) {
        this(r10.getBitmapPool(), Glide.with(r10.getContext()), r11, null, getRequestBuilder(Glide.with(r10.getContext()), r12, r13), r14, r15);
    }

    private static Key getFrameSignature() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }

    private int getFrameSize() {
        return Util.getBitmapByteSize(getCurrentFrame().getWidth(), getCurrentFrame().getHeight(), getCurrentFrame().getConfig());
    }

    private static RequestBuilder<Bitmap> getRequestBuilder(RequestManager r10, int r11, int r12) {
        return r10.asBitmap().apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true).skipMemoryCache(true).override(r11, r12));
    }

    private void loadNextFrame() {
        if (this.isRunning == true) goto L5;
        return;
    L5:
        if (this.isLoadPending == false) goto L8;
        return;
    L8:
        if (this.startFromFirstFrame == true) goto L10;
    L14:
        DelayTarget r10 = this.pendingTarget;
        if (r10 == null) goto L18;
        this.pendingTarget = null;
        onFrameReady(r10);
        return;
    L18:
        this.isLoadPending = true;
        long r11 = SystemClock.uptimeMillis() + ((long) this.gifDecoder.getNextDelay());
        this.gifDecoder.advance();
        this.next = new DelayTarget(this.handler, this.gifDecoder.getCurrentFrameIndex(), r11);
        this.requestBuilder.apply(RequestOptions.signatureOf(getFrameSignature())).load(this.gifDecoder).into(this.next);
        return;
    L10:
        if (this.pendingTarget != null) goto L12;
        boolean r12 = true;
    L13:
        Preconditions.checkArgument(r12, "Pending target must be null when starting from the first frame");
        this.gifDecoder.resetFrameIndex();
        this.startFromFirstFrame = false;
        goto L14
    L12:
        r12 = false;
        goto L13
    }

    private void recycleFirstFrame() {
        Bitmap r10 = this.firstFrame;
        if (r10 == null) goto L6;
        this.bitmapPool.put(r10);
        this.firstFrame = null;
        return;
    }

    private void start() {
        if (this.isRunning == false) goto L5;
        return;
    L5:
        this.isRunning = true;
        this.isCleared = false;
        loadNextFrame();
    }

    private void stop() {
        this.isRunning = false;
    }

    public void clear() {
        this.callbacks.clear();
        recycleFirstFrame();
        stop();
        DelayTarget r10 = this.current;
        if (r10 == null) goto L5;
        this.requestManager.clear(r10);
        this.current = null;
    L5:
        DelayTarget r11 = this.next;
        if (r11 == null) goto L8;
        this.requestManager.clear(r11);
        this.next = null;
    L8:
        DelayTarget r12 = this.pendingTarget;
        if (r12 == null) goto L11;
        this.requestManager.clear(r12);
        this.pendingTarget = null;
    L11:
        this.gifDecoder.clear();
        this.isCleared = true;
    }

    public ByteBuffer getBuffer() {
        return this.gifDecoder.getData().asReadOnlyBuffer();
    }

    public Bitmap getCurrentFrame() {
        DelayTarget r10 = this.current;
        if (r10 == null) goto L6;
        return r10.getResource();
    L6:
        return this.firstFrame;
    }

    public int getCurrentIndex() {
        DelayTarget r10 = this.current;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.index;
    }

    public Bitmap getFirstFrame() {
        return this.firstFrame;
    }

    public int getFrameCount() {
        return this.gifDecoder.getFrameCount();
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.transformation;
    }

    public int getHeight() {
        return getCurrentFrame().getHeight();
    }

    public int getLoopCount() {
        return this.gifDecoder.getTotalIterationCount();
    }

    public int getSize() {
        return this.gifDecoder.getByteSize() + getFrameSize();
    }

    public int getWidth() {
        return getCurrentFrame().getWidth();
    }

    @VisibleForTesting
    public void onFrameReady(DelayTarget r10) {
        OnEveryFrameListener r11 = this.onEveryFrameListener;
        if (r11 == null) goto L5;
        r11.onFrameReady();
    L5:
        this.isLoadPending = false;
        if (this.isCleared == false) goto L10;
        this.handler.obtainMessage(2, r10).sendToTarget();
        return;
    L10:
        if (this.isRunning == true) goto L14;
        this.pendingTarget = r10;
        return;
    L14:
        if (r10.getResource() == null) goto L20;
        recycleFirstFrame();
        DelayTarget r12 = this.current;
        this.current = r10;
        int r13 = this.callbacks.size() - 1;
    L16:
        if (r13 < 0) goto L18;
        this.callbacks.get(r13).onFrameReady();
        r13 = r13 - 1;
        goto L16
    L18:
        if (r12 == null) goto L20;
        this.handler.obtainMessage(2, r12).sendToTarget();
    L20:
        loadNextFrame();
    }

    public void setFrameTransformation(Transformation<Bitmap> r10, Bitmap r11) {
        this.transformation = (Transformation) Preconditions.checkNotNull(r10);
        this.firstFrame = (Bitmap) Preconditions.checkNotNull(r11);
        this.requestBuilder = this.requestBuilder.apply(new RequestOptions().transform(r10));
    }

    public void setNextStartFromFirstFrame() {
        Preconditions.checkArgument(!this.isRunning, "Can't restart a running animation");
        this.startFromFirstFrame = true;
        DelayTarget r10 = this.pendingTarget;
        if (r10 == null) goto L6;
        this.requestManager.clear(r10);
        this.pendingTarget = null;
        return;
    }

    @VisibleForTesting
    public void setOnEveryFrameReadyListener(@Nullable OnEveryFrameListener r10) {
        this.onEveryFrameListener = r10;
    }

    public void subscribe(FrameCallback r10) {
        if (this.isCleared == true) goto L13;
        if (this.callbacks.contains(r10) == true) goto L11;
        boolean r11 = this.callbacks.isEmpty();
        this.callbacks.add(r10);
        if (r11 == false) goto L14;
        start();
        return;
    L14:
        return;
    L11:
        throw new IllegalStateException("Cannot subscribe twice in a row");
    L13:
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    public void unsubscribe(FrameCallback r10) {
        this.callbacks.remove(r10);
        if (this.callbacks.isEmpty() == false) goto L6;
        stop();
        return;
    }

    public GifFrameLoader(BitmapPool r10, RequestManager r11, GifDecoder r12, Handler r13, RequestBuilder<Bitmap> r14, Transformation<Bitmap> r15, Bitmap r16) {
        this.callbacks = new ArrayList();
        this.requestManager = r11;
        if (r13 != null) goto L5;
        r13 = new Handler(Looper.getMainLooper(), new FrameLoaderCallback(this));
    L5:
        this.bitmapPool = r10;
        this.handler = r13;
        this.requestBuilder = r14;
        this.gifDecoder = r12;
        setFrameTransformation(r15, r16);
    }
}
