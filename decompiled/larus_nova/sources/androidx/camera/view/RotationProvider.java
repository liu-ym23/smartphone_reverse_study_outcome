package androidx.camera.view;

import android.content.Context;
import android.view.OrientationEventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class RotationProvider {
    boolean mIgnoreCanDetectForTest;
    final Map<Listener, ListenerWrapper> mListeners;
    final Object mLock;
    final OrientationEventListener mOrientationListener;

    public interface Listener {
        void onRotationChanged(int r100);
    }

    public static class ListenerWrapper {
        private final AtomicBoolean mEnabled;
        private final Executor mExecutor;
        private final Listener mListener;

        public static /* synthetic */ void a(ListenerWrapper r100, int r101) {
            r100.lambda$onRotationChanged$0(r101);
        }

        public void disable() {
            this.mEnabled.set(false);
        }

        private /* synthetic */ void lambda$onRotationChanged$0(int r100) {
            if (this.mEnabled.get() == false) goto L6;
            this.mListener.onRotationChanged(r100);
            return;
        }

        public void onRotationChanged(final int r100) {
            this.mExecutor.execute(new u(this, r100));
        }

        public ListenerWrapper(Listener r100, Executor r101) {
            this.mListener = r100;
            this.mExecutor = r101;
            this.mEnabled = new AtomicBoolean(true);
        }
    }

    public static int orientationToSurfaceRotation(int r100) {
        if (r100 < 315) goto L5;
        return 0;
    L5:
        if (r100 >= 45) goto L8;
        return 0;
    L8:
        if (r100 < 225) goto L12;
        return 1;
    L12:
        if (r100 < 135) goto L15;
        return 2;
    L15:
        return 3;
    }

    public RotationProvider(final Context r100) {
        this.mLock = new Object();
        this.mListeners = new HashMap();
        this.mIgnoreCanDetectForTest = false;
        this.mOrientationListener = new AnonymousClass1(this, r100);
    }

    public void removeListener(Listener r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        ListenerWrapper r102 = this.mListeners.get(r100);     // Catch: Throwable -> L12
        if (r102 == null) goto L8;
        r102.disable();     // Catch: Throwable -> L12
        this.mListeners.remove(r100);     // Catch: Throwable -> L12
    L8:
        if (this.mListeners.isEmpty() == false) goto L10;
        this.mOrientationListener.disable();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean addListener(Executor r100, Listener r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mOrientationListener.canDetectOrientation() == false) goto L7;
    L11:
        this.mListeners.put(r101, new ListenerWrapper(r101, r100));     // Catch: Throwable -> L15
        this.mOrientationListener.enable();     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        return true;
    L7:
        if (this.mIgnoreCanDetectForTest == true) goto L11;
        monitor-exit(r102);     // Catch: Throwable -> L15
        return false;
    }
}
