package org.libpag;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import gc.AbstractC4115a;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
class PAGAnimator {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference f37852a;

    /* renamed from: b, reason: collision with root package name */
    private float f37853b;
    private long nativeContext = 0;

    public interface Listener {
        void onAnimationCancel(PAGAnimator pAGAnimator);

        void onAnimationEnd(PAGAnimator pAGAnimator);

        void onAnimationRepeat(PAGAnimator pAGAnimator);

        void onAnimationStart(PAGAnimator pAGAnimator);

        void onAnimationUpdate(PAGAnimator pAGAnimator);
    }

    static {
        AbstractC4115a.e("pag");
        nativeInit();
    }

    private PAGAnimator(Context context, Listener listener) {
        this.f37852a = null;
        this.f37853b = 1.0f;
        this.f37852a = new WeakReference(listener);
        if (context != null) {
            this.f37853b = Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        nativeSetup();
    }

    public static PAGAnimator a(Context context, Listener listener) {
        if (listener == null) {
            return null;
        }
        return new PAGAnimator(context, listener);
    }

    private native void doStart();

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    private native void nativeSetup();

    private void onAnimationCancel() {
        Listener listener = (Listener) this.f37852a.get();
        if (listener != null) {
            listener.onAnimationCancel(this);
        }
    }

    private void onAnimationEnd() {
        Listener listener = (Listener) this.f37852a.get();
        if (listener != null) {
            listener.onAnimationEnd(this);
        }
    }

    private void onAnimationRepeat() {
        Listener listener = (Listener) this.f37852a.get();
        if (listener != null) {
            listener.onAnimationRepeat(this);
        }
    }

    private void onAnimationStart() {
        Listener listener = (Listener) this.f37852a.get();
        if (listener != null) {
            listener.onAnimationStart(this);
        }
    }

    private void onAnimationUpdate() {
        Listener listener = (Listener) this.f37852a.get();
        if (listener != null) {
            listener.onAnimationUpdate(this);
        }
    }

    public native void cancel();

    public native long duration();

    public void finalize() {
        nativeFinalize();
    }

    public native boolean isRunning();

    public native boolean isSync();

    public native double progress();

    public native int repeatCount();

    public native void setDuration(long j10);

    public native void setProgress(double d10);

    public native void setRepeatCount(int i10);

    public native void setSync(boolean z10);

    public native void update();

    public void a() {
        if (this.f37853b != 0.0f) {
            doStart();
            return;
        }
        Log.e("libpag", "PAGAnimator.play() The scale of animator duration is turned off!");
        Listener listener = (Listener) this.f37852a.get();
        if (listener != null) {
            listener.onAnimationUpdate(this);
            listener.onAnimationEnd(this);
        }
    }
}
