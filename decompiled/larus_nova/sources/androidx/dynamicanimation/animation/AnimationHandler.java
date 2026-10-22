package androidx.dynamicanimation.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
class AnimationHandler {
    private static final long FRAME_DELAY_MS = 10;
    public static final ThreadLocal<AnimationHandler> sAnimatorHandler = null;
    final ArrayList<AnimationFrameCallback> mAnimationCallbacks;
    private final AnimationCallbackDispatcher mCallbackDispatcher;
    long mCurrentFrameTime;
    private final SimpleArrayMap<AnimationFrameCallback, Long> mDelayedCallbackStartTime;
    private boolean mListDirty;
    private AnimationFrameCallbackProvider mProvider;

    public class AnimationCallbackDispatcher {
        final /* synthetic */ AnimationHandler this$0;

        public void dispatchAnimationFrame() {
            AnimationHandler r100 = this.this$0;
            r100.mCurrentFrameTime = SystemClock.uptimeMillis();
            AnimationHandler r101 = this.this$0;
            r101.doAnimationFrame(r101.mCurrentFrameTime);
            if (this.this$0.mAnimationCallbacks.size() <= 0) goto L6;
            this.this$0.getProvider().postFrameCallback();
            return;
        }

        public AnimationCallbackDispatcher(AnimationHandler r100) {
            this.this$0 = r100;
        }
    }

    public interface AnimationFrameCallback {
        boolean doAnimationFrame(long r100);
    }

    public static abstract class AnimationFrameCallbackProvider {
        final AnimationCallbackDispatcher mDispatcher;

        public abstract void postFrameCallback();

        public AnimationFrameCallbackProvider(AnimationCallbackDispatcher r100) {
            this.mDispatcher = r100;
        }
    }

    public static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {
        private final Handler mHandler;
        long mLastFrameTime;
        private final Runnable mRunnable;

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        public void postFrameCallback() {
            long r100 = Math.max(10 - (SystemClock.uptimeMillis() - this.mLastFrameTime), 0);
            this.mHandler.postDelayed(this.mRunnable, r100);
        }

        public FrameCallbackProvider14(AnimationCallbackDispatcher r100) {
            super(r100);
            this.mLastFrameTime = -1;
            this.mRunnable = new AnonymousClass1(this);
            this.mHandler = new Handler(Looper.myLooper());
        }
    }

    public static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {
        private final Choreographer mChoreographer;
        private final Choreographer.FrameCallback mChoreographerCallback;

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        public void postFrameCallback() {
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }

        public FrameCallbackProvider16(AnimationCallbackDispatcher r100) {
            super(r100);
            this.mChoreographer = Choreographer.getInstance();
            this.mChoreographerCallback = new AnonymousClass1(this);
        }
    }

    static {
        sAnimatorHandler = new ThreadLocal();
    }

    private void cleanUpList() {
        if (this.mListDirty == false) goto L15;
        int r100 = this.mAnimationCallbacks.size() - 1;
    L5:
        if (r100 < 0) goto L10;
        if (ListProtector.get(this.mAnimationCallbacks, r100) != null) goto L9;
        ListProtector.remove(this.mAnimationCallbacks, r100);
    L9:
        r100 = r100 - 1;
        goto L5
    L10:
        this.mListDirty = false;
        return;
    }

    public static long getFrameTime() {
        ThreadLocal<AnimationHandler> r100 = sAnimatorHandler;
        if (r100.get() != null) goto L7;
        return 0;
    L7:
        return r100.get().mCurrentFrameTime;
    }

    public static AnimationHandler getInstance() {
        ThreadLocal<AnimationHandler> r100 = sAnimatorHandler;
        if (r100.get() != null) goto L6;
        r100.set(new AnimationHandler());
    L6:
        return r100.get();
    }

    public AnimationFrameCallbackProvider getProvider() {
        if (this.mProvider != null) goto L6;
        this.mProvider = new FrameCallbackProvider16(this.mCallbackDispatcher);
    L6:
        return this.mProvider;
    }

    public AnimationHandler() {
        this.mDelayedCallbackStartTime = new SimpleArrayMap();
        this.mAnimationCallbacks = new ArrayList();
        this.mCallbackDispatcher = new AnimationCallbackDispatcher(this);
        this.mCurrentFrameTime = 0;
        this.mListDirty = false;
    }

    public void doAnimationFrame(long r100) {
        long r101 = SystemClock.uptimeMillis();
        int r102 = 0;
    L4:
        if (r102 >= this.mAnimationCallbacks.size()) goto L12;
        AnimationFrameCallback r103 = (AnimationFrameCallback) ListProtector.get(this.mAnimationCallbacks, r102);
        if (r103 == null) goto L11;
        if (isCallbackDue(r103, r101) == false) goto L11;
        r103.doAnimationFrame(r100);
    L11:
        r102 = r102 + 1;
        goto L4
    L12:
        cleanUpList();
    }

    public void removeCallback(AnimationFrameCallback r100) {
        this.mDelayedCallbackStartTime.remove(r100);
        int r101 = this.mAnimationCallbacks.indexOf(r100);
        if (r101 < 0) goto L6;
        ListProtector.set(this.mAnimationCallbacks, r101, null);
        this.mListDirty = true;
        return;
    }

    public void setProvider(AnimationFrameCallbackProvider r100) {
        this.mProvider = r100;
    }

    private boolean isCallbackDue(AnimationFrameCallback r100, long r101) {
        Long r102 = this.mDelayedCallbackStartTime.get(r100);
        if (r102 != null) goto L6;
        return true;
    L6:
        if (r102.longValue() >= r101) goto L9;
        this.mDelayedCallbackStartTime.remove(r100);
        return true;
    L9:
        return false;
    }

    public void addAnimationFrameCallback(AnimationFrameCallback r100, long r101) {
        if (this.mAnimationCallbacks.size() != 0) goto L6;
        getProvider().postFrameCallback();
    L6:
        if (this.mAnimationCallbacks.contains(r100) == true) goto L9;
        this.mAnimationCallbacks.add(r100);
    L9:
        if (r101 <= 0) goto L12;
        this.mDelayedCallbackStartTime.put(r100, Long.valueOf(SystemClock.uptimeMillis() + r101));
        return;
    }
}
