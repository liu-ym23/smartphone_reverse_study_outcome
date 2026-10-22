package com.baidu.platform.comapi.bmsdk.animation;

import com.baidu.mapapi.animation.Animation;
import com.baidu.platform.comapi.bmsdk.BmObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BmAnimation extends BmObject {
    private static final int ABSOLUTE = 0;
    private static final int END = 2;
    public static final int FILL_AFTER = 2;
    public static final int FILL_BEFORE = 0;
    public static final int FILL_FIRST = 1;
    public static final int INFINITE = -1;
    private static final int RELATIVE_TO_SELF = 1;
    private static final int REPEAT = 3;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private static final int START = 1;
    private static final int START_ON_FIRST_FRAME = -1;
    private static Object sync = new Object();
    private static List<WeakReference<BmAnimation>> wkListenerAnimations = new ArrayList();
    public Animation.AnimationListener animationListener;
    long mDuration;
    private String mExtParam;
    int mFillMode;
    private com.baidu.platform.comapi.bmsdk.animation.a mInterpolator;
    private a mListener;
    int mRepeatCount;
    long mRepeatDelay;
    int mRepeatMode;
    long mStartDelay;

    public interface a {
        void a(BmAnimation bmAnimation);

        void b(BmAnimation bmAnimation);

        void c(BmAnimation bmAnimation);
    }

    private BmAnimation() {
        super(80, 0L);
        this.mFillMode = 0;
        this.mRepeatCount = 0;
        this.mRepeatMode = 1;
        this.mExtParam = "";
    }

    private static void addAnimation(BmAnimation bmAnimation) {
        if (bmAnimation == null) {
            return;
        }
        synchronized (sync) {
            try {
                int size = wkListenerAnimations.size() - 1;
                while (true) {
                    if (size < 0) {
                        wkListenerAnimations.add(new WeakReference<>(bmAnimation));
                        break;
                    }
                    BmAnimation bmAnimation2 = wkListenerAnimations.get(size).get();
                    if (bmAnimation2 == null || bmAnimation2 != bmAnimation) {
                        size--;
                    }
                }
            } finally {
            }
        }
    }

    public static boolean dispatchAnimationListener(long j4, int i4) {
        a aVar;
        synchronized (sync) {
            try {
                for (int size = wkListenerAnimations.size() - 1; size >= 0; size--) {
                    BmAnimation bmAnimation = wkListenerAnimations.get(size).get();
                    if (bmAnimation == null) {
                        wkListenerAnimations.remove(size);
                    } else if (bmAnimation.nativeInstance == j4 && (aVar = bmAnimation.mListener) != null) {
                        if (i4 == 1) {
                            aVar.a(bmAnimation);
                        } else if (i4 == 2) {
                            aVar.b(bmAnimation);
                        } else if (i4 == 3) {
                            aVar.c(bmAnimation);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    private static native boolean nativeCancel(long j4);

    private static native boolean nativePause(long j4);

    private static native boolean nativeReset(long j4);

    private static native boolean nativeResume(long j4);

    private static native boolean nativeSetDuration(long j4, long j5);

    private static native boolean nativeSetFillMode(long j4, int i4);

    private static native boolean nativeSetInterpolator(long j4, long j5);

    private static native boolean nativeSetListener(long j4, boolean z4);

    private static native boolean nativeSetRepeatCount(long j4, int i4);

    private static native boolean nativeSetRepeatDelay(long j4, long j5);

    private static native boolean nativeSetRepeatMode(long j4, int i4);

    private static native boolean nativeSetStartDelay(long j4, long j5);

    private static native boolean nativeSetStartTime(long j4, long j5);

    private static void removeAnimation(BmAnimation bmAnimation) {
    }

    public boolean cancel() {
        return nativeCancel(this.nativeInstance);
    }

    public String getExtParam() {
        return this.mExtParam;
    }

    public boolean pause() {
        return nativePause(this.nativeInstance);
    }

    public boolean reset() {
        return nativeReset(this.nativeInstance);
    }

    public boolean resume() {
        return nativeResume(this.nativeInstance);
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.animationListener = animationListener;
    }

    public boolean setDuration(long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative");
        }
        this.mDuration = j4;
        return nativeSetDuration(this.nativeInstance, j4);
    }

    public void setExtParam(String str) {
        this.mExtParam = str;
    }

    public boolean setFillMode(int i4) {
        this.mFillMode = i4;
        return nativeSetFillMode(this.nativeInstance, i4);
    }

    public boolean setInterpolator(com.baidu.platform.comapi.bmsdk.animation.a aVar) {
        this.mInterpolator = aVar;
        return nativeSetInterpolator(this.nativeInstance, aVar == null ? 0L : aVar.getNativeInstance());
    }

    public boolean setRepeatCount(int i4) {
        if (i4 < 0) {
            i4 = -1;
        }
        this.mRepeatCount = i4;
        return nativeSetRepeatCount(this.nativeInstance, i4);
    }

    public boolean setRepeatDelay(long j4) {
        this.mRepeatDelay = j4;
        return nativeSetRepeatDelay(this.nativeInstance, j4);
    }

    public boolean setRepeatMode(int i4) {
        this.mRepeatMode = i4;
        return nativeSetRepeatMode(this.nativeInstance, i4);
    }

    public boolean setStartDelay(long j4) {
        this.mStartDelay = j4;
        return nativeSetStartDelay(this.nativeInstance, j4);
    }

    public boolean setStartTime(long j4) {
        return nativeSetStartTime(this.nativeInstance, j4);
    }

    public boolean start() {
        return setStartTime(-1L);
    }

    public boolean setAnimationListener(a aVar) {
        this.mListener = aVar;
        if (aVar != null) {
            addAnimation(this);
        } else {
            removeAnimation(this);
        }
        return nativeSetListener(this.nativeInstance, aVar != null);
    }

    public BmAnimation(int i4, long j4) {
        super(i4, j4);
        this.mFillMode = 0;
        this.mRepeatCount = 0;
        this.mRepeatMode = 1;
        this.mExtParam = "";
    }
}
