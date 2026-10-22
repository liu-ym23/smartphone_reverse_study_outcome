package com.facebook.rebound;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
public class ChoreographerCompat {
    private static final boolean IS_JELLYBEAN_OR_HIGHER = false;
    private static final long ONE_FRAME_MILLIS = 17;
    private static ChoreographerCompat __instance;
    private Choreographer mChoreographer;
    private Handler mHandler;

    public static abstract class FrameCallback {
        private Choreographer.FrameCallback mFrameCallback;
        private Runnable mRunnable;

        public FrameCallback() {
        }

        public abstract void doFrame(long r10);

        @TargetApi(16)
        public Choreographer.FrameCallback getFrameCallback() {
            if (this.mFrameCallback != null) goto L6;
            this.mFrameCallback = new AnonymousClass1(this);
        L6:
            return this.mFrameCallback;
        }

        public Runnable getRunnable() {
            if (this.mRunnable != null) goto L6;
            this.mRunnable = new AnonymousClass2(this);
        L6:
            return this.mRunnable;
        }
    }

    static {
        IS_JELLYBEAN_OR_HIGHER = true;
        __instance = new ChoreographerCompat();
    }

    private ChoreographerCompat() {
        if (IS_JELLYBEAN_OR_HIGHER == false) goto L5;
        this.mChoreographer = getChoreographer();
        return;
    L5:
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @TargetApi(16)
    private void choreographerPostFrameCallback(Choreographer.FrameCallback r10) {
        this.mChoreographer.postFrameCallback(r10);
    }

    @TargetApi(16)
    private void choreographerPostFrameCallbackDelayed(Choreographer.FrameCallback r10, long r11) {
        this.mChoreographer.postFrameCallbackDelayed(r10, r11);
    }

    @TargetApi(16)
    private void choreographerRemoveFrameCallback(Choreographer.FrameCallback r10) {
        this.mChoreographer.removeFrameCallback(r10);
    }

    @TargetApi(16)
    private Choreographer getChoreographer() {
        return Choreographer.getInstance();
    }

    public static ChoreographerCompat getInstance() {
        return __instance;
    }

    public void postFrameCallback(FrameCallback r10) {
        if (IS_JELLYBEAN_OR_HIGHER == false) goto L5;
        choreographerPostFrameCallback(r10.getFrameCallback());
        return;
    L5:
        this.mHandler.postDelayed(r10.getRunnable(), 0);
    }

    public void postFrameCallbackDelayed(FrameCallback r10, long r11) {
        if (IS_JELLYBEAN_OR_HIGHER == false) goto L5;
        choreographerPostFrameCallbackDelayed(r10.getFrameCallback(), r11);
        return;
    L5:
        this.mHandler.postDelayed(r10.getRunnable(), r11 + ONE_FRAME_MILLIS);
    }

    public void removeFrameCallback(FrameCallback r10) {
        if (IS_JELLYBEAN_OR_HIGHER == false) goto L5;
        choreographerRemoveFrameCallback(r10.getFrameCallback());
        return;
    L5:
        this.mHandler.removeCallbacks(r10.getRunnable());
    }
}
