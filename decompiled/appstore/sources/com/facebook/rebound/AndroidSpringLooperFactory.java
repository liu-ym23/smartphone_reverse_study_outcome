package com.facebook.rebound;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
abstract class AndroidSpringLooperFactory {

    @TargetApi(16)
    public static class ChoreographerAndroidSpringLooper extends SpringLooper {
        private final Choreographer mChoreographer;
        private final Choreographer.FrameCallback mFrameCallback;
        private long mLastTime;
        private boolean mStarted;

        public ChoreographerAndroidSpringLooper(Choreographer r10) {
            this.mChoreographer = r10;
            this.mFrameCallback = new AnonymousClass1(this);
        }

        public static /* synthetic */ boolean access$400(ChoreographerAndroidSpringLooper r10) {
            return r10.mStarted;
        }

        public static /* synthetic */ long access$500(ChoreographerAndroidSpringLooper r10) {
            return r10.mLastTime;
        }

        public static /* synthetic */ long access$502(ChoreographerAndroidSpringLooper r10, long r11) {
            r10.mLastTime = r11;
            return r11;
        }

        public static /* synthetic */ Choreographer.FrameCallback access$600(ChoreographerAndroidSpringLooper r10) {
            return r10.mFrameCallback;
        }

        public static /* synthetic */ Choreographer access$700(ChoreographerAndroidSpringLooper r10) {
            return r10.mChoreographer;
        }

        public static ChoreographerAndroidSpringLooper create() {
            return new ChoreographerAndroidSpringLooper(Choreographer.getInstance());
        }

        @Override // com.facebook.rebound.SpringLooper
        public void start() {
            if (this.mStarted == false) goto L5;
            return;
        L5:
            this.mStarted = true;
            this.mLastTime = SystemClock.uptimeMillis();
            this.mChoreographer.removeFrameCallback(this.mFrameCallback);
            this.mChoreographer.postFrameCallback(this.mFrameCallback);
        }

        @Override // com.facebook.rebound.SpringLooper
        public void stop() {
            this.mStarted = false;
            this.mChoreographer.removeFrameCallback(this.mFrameCallback);
        }
    }

    public static class LegacyAndroidSpringLooper extends SpringLooper {
        private final Handler mHandler;
        private long mLastTime;
        private final Runnable mLooperRunnable;
        private boolean mStarted;

        public LegacyAndroidSpringLooper(Handler r10) {
            this.mHandler = r10;
            this.mLooperRunnable = new AnonymousClass1(this);
        }

        public static /* synthetic */ boolean access$000(LegacyAndroidSpringLooper r10) {
            return r10.mStarted;
        }

        public static /* synthetic */ long access$100(LegacyAndroidSpringLooper r10) {
            return r10.mLastTime;
        }

        public static /* synthetic */ long access$102(LegacyAndroidSpringLooper r10, long r11) {
            r10.mLastTime = r11;
            return r11;
        }

        public static /* synthetic */ Runnable access$200(LegacyAndroidSpringLooper r10) {
            return r10.mLooperRunnable;
        }

        public static /* synthetic */ Handler access$300(LegacyAndroidSpringLooper r10) {
            return r10.mHandler;
        }

        public static SpringLooper create() {
            return new LegacyAndroidSpringLooper(new Handler());
        }

        @Override // com.facebook.rebound.SpringLooper
        public void start() {
            if (this.mStarted == false) goto L5;
            return;
        L5:
            this.mStarted = true;
            this.mLastTime = SystemClock.uptimeMillis();
            this.mHandler.removeCallbacks(this.mLooperRunnable);
            this.mHandler.post(this.mLooperRunnable);
        }

        @Override // com.facebook.rebound.SpringLooper
        public void stop() {
            this.mStarted = false;
            this.mHandler.removeCallbacks(this.mLooperRunnable);
        }
    }

    public AndroidSpringLooperFactory() {
    }

    public static SpringLooper createSpringLooper() {
        return ChoreographerAndroidSpringLooper.create();
    }
}
