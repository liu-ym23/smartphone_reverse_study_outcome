package com.baidu.platform.comapi.bmsdk.animation;

import com.baidu.mapapi.animation.Animation;
import com.baidu.platform.comapi.bmsdk.BmObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
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
    private static Object sync;
    private static List<WeakReference<BmAnimation>> wkListenerAnimations;
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
        void a(BmAnimation r100);

        void b(BmAnimation r100);

        void c(BmAnimation r100);
    }

    private static native boolean nativeCancel(long r100);

    private static native boolean nativePause(long r100);

    private static native boolean nativeReset(long r100);

    private static native boolean nativeResume(long r100);

    private static native boolean nativeSetDuration(long r100, long r101);

    private static native boolean nativeSetFillMode(long r100, int r101);

    private static native boolean nativeSetInterpolator(long r100, long r101);

    private static native boolean nativeSetListener(long r100, boolean r101);

    private static native boolean nativeSetRepeatCount(long r100, int r101);

    private static native boolean nativeSetRepeatDelay(long r100, long r101);

    private static native boolean nativeSetRepeatMode(long r100, int r101);

    private static native boolean nativeSetStartDelay(long r100, long r101);

    private static native boolean nativeSetStartTime(long r100, long r101);

    private static void removeAnimation(BmAnimation r100) {
    }

    static {
        sync = new Object();
        wkListenerAnimations = new ArrayList();
    }

    private BmAnimation() {
        super(80, 0);
        this.mFillMode = 0;
        this.mRepeatCount = 0;
        this.mRepeatMode = 1;
        this.mExtParam = "";
    }

    public boolean cancel() {
        return nativeCancel(this.nativeInstance);
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

    public boolean start() {
        return setStartTime(-1);
    }

    public String getExtParam() {
        return this.mExtParam;
    }

    private static void addAnimation(BmAnimation r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Object r101 = sync;
        monitor-enter(r101);
        boolean r102 = true;
        int r103 = wkListenerAnimations.size() - 1;     // Catch: Throwable -> L18
    L7:
        if (r103 < 0) goto L13;
        BmAnimation r104 = wkListenerAnimations.get(r103).get();     // Catch: Throwable -> L18
        if (r104 == null) goto L12;
        if (r104 != r100) goto L12;
    L14:
        if (r102 == true) goto L16;
        wkListenerAnimations.add(new WeakReference(r100));     // Catch: Throwable -> L18
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L18
        return;
    L12:
        r103 = r103 - 1;     // Catch: Throwable -> L18
        goto L7
    L13:
        r102 = false;
    L18:
        th = move-exception;
        throw th;
    }

    public boolean setAnimationListener(a r100) {
        this.mListener = r100;
        if (r100 == null) goto L5;
        addAnimation(this);
    L6:
        long r101 = this.nativeInstance;
        if (r100 != null) goto L9;
        boolean r102 = false;
    L11:
        return nativeSetListener(r101, r102);
    L9:
        r102 = true;
        goto L11
    L5:
        removeAnimation(this);
        goto L6
    }

    public boolean setDuration(long r100) {
        if (r100 < 0) goto L7;
        this.mDuration = r100;
        return nativeSetDuration(this.nativeInstance, r100);
    L7:
        throw new IllegalArgumentException("Animation duration cannot be negative");
    }

    public void setExtParam(String r100) {
        this.mExtParam = r100;
    }

    public boolean setFillMode(int r100) {
        this.mFillMode = r100;
        return nativeSetFillMode(this.nativeInstance, r100);
    }

    public boolean setInterpolator(com.baidu.platform.comapi.bmsdk.animation.a r100) {
        this.mInterpolator = r100;
        long r101 = this.nativeInstance;
        if (r100 != null) goto L5;
        long r102 = 0;
    L7:
        return nativeSetInterpolator(r101, r102);
    L5:
        r102 = r100.getNativeInstance();
        goto L7
    }

    public boolean setRepeatCount(int r100) {
        if (r100 >= 0) goto L4;
        r100 = -1;
    L4:
        this.mRepeatCount = r100;
        return nativeSetRepeatCount(this.nativeInstance, r100);
    }

    public boolean setRepeatDelay(long r100) {
        this.mRepeatDelay = r100;
        return nativeSetRepeatDelay(this.nativeInstance, r100);
    }

    public boolean setRepeatMode(int r100) {
        this.mRepeatMode = r100;
        return nativeSetRepeatMode(this.nativeInstance, r100);
    }

    public boolean setStartDelay(long r100) {
        this.mStartDelay = r100;
        return nativeSetStartDelay(this.nativeInstance, r100);
    }

    public boolean setStartTime(long r100) {
        return nativeSetStartTime(this.nativeInstance, r100);
    }

    public void setAnimationListener(Animation.AnimationListener r100) {
        this.animationListener = r100;
    }

    public BmAnimation(int r100, long r101) {
        super(r100, r101);
        this.mFillMode = 0;
        this.mRepeatCount = 0;
        this.mRepeatMode = 1;
        this.mExtParam = "";
    }

    public static boolean dispatchAnimationListener(long r100, int r101) {
        Object r102 = sync;
        monitor-enter(r102);
        int r103 = wkListenerAnimations.size() - 1;     // Catch: Throwable -> L24
    L5:
        if (r103 < 0) goto L22;
        BmAnimation r104 = wkListenerAnimations.get(r103).get();     // Catch: Throwable -> L24
        if (r104 != null) goto L10;
        wkListenerAnimations.remove(r103);     // Catch: Throwable -> L24
    L21:
        r103 = r103 - 1;     // Catch: Throwable -> L24
        goto L5
    L10:
        if (r104.nativeInstance != r100) goto L21;
        a r105 = r104.mListener;     // Catch: Throwable -> L24
        if (r105 == null) goto L21;
        if (r101 != 1) goto L16;
        r105.a(r104);     // Catch: Throwable -> L24
        goto L21
    L16:
        if (r101 != 2) goto L19;
        r105.b(r104);     // Catch: Throwable -> L24
        goto L21
    L19:
        if (r101 != 3) goto L21;
        r105.c(r104);     // Catch: Throwable -> L24
        goto L21
    L22:
        monitor-exit(r102);     // Catch: Throwable -> L24
        return true;
    L24:
        th = move-exception;
        throw th;
    }
}
