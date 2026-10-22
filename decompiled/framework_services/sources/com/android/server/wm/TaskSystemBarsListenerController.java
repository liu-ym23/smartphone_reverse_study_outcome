package com.android.server.wm;

import com.android.internal.os.BackgroundThread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class TaskSystemBarsListenerController {
    private final Executor mBackgroundExecutor;
    private final HashSet<WindowManagerInternal.TaskSystemBarsListener> mListeners;

    public static /* synthetic */ void $r8$lambda$xLbhF443h1sXa4hCa8Y_6VFoe4A(HashSet r0, int r1, boolean r2, boolean r3) {
        lambda$dispatchTransientSystemBarVisibilityChanged$0(r0, r1, r2, r3);
    }

    TaskSystemBarsListenerController() {
        this.mListeners = new HashSet();
        this.mBackgroundExecutor = BackgroundThread.getExecutor();
    }

    void registerListener(WindowManagerInternal.TaskSystemBarsListener listener) {
        this.mListeners.add(listener);
    }

    void unregisterListener(WindowManagerInternal.TaskSystemBarsListener listener) {
        this.mListeners.remove(listener);
    }

    void dispatchTransientSystemBarVisibilityChanged(final int taskId, final boolean visible, final boolean wereRevealedFromSwipeOnSystemBar) {
        if (this.mListeners.isEmpty() == false) goto L5;
        return;
    L5:
        final HashSet<WindowManagerInternal.TaskSystemBarsListener> localListeners = new HashSet(this.mListeners);
        this.mBackgroundExecutor.execute(new TaskSystemBarsListenerController$$ExternalSyntheticLambda0(localListeners, taskId, visible, wereRevealedFromSwipeOnSystemBar));
    }

    private static /* synthetic */ void lambda$dispatchTransientSystemBarVisibilityChanged$0(HashSet localListeners, int taskId, boolean visible, boolean wereRevealedFromSwipeOnSystemBar) {
        Iterator r0 = localListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        WindowManagerInternal.TaskSystemBarsListener listener = (WindowManagerInternal.TaskSystemBarsListener) r0.next();
        listener.onTransientSystemBarsVisibilityChanged(taskId, visible, wereRevealedFromSwipeOnSystemBar);
        goto L4
    }
}
