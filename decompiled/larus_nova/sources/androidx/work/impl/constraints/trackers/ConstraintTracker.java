package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConstraintTracker<T> {
    private static final String TAG = null;
    protected final Context mAppContext;
    T mCurrentState;
    private final Set<ConstraintListener<T>> mListeners;
    private final Object mLock;
    protected final TaskExecutor mTaskExecutor;

    public abstract T getInitialState();

    public abstract void startTracking();

    public abstract void stopTracking();

    static {
        TAG = Logger.tagWithPrefix("ConstraintTracker");
    }

    public void addListener(ConstraintListener<T> r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mListeners.add(r100) == true) goto L7;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L7:
        if (this.mListeners.size() != 1) goto L9;
        this.mCurrentState = getInitialState();     // Catch: Throwable -> L12
        Logger.get().debug(TAG, String.format("%s: initial state = %s", new Object[]{getClass().getSimpleName(), this.mCurrentState}), new Throwable[0]);     // Catch: Throwable -> L12
        startTracking();     // Catch: Throwable -> L12
    L9:
        r100.onConstraintChanged(this.mCurrentState);     // Catch: Throwable -> L12
        goto L10
    }

    public void removeListener(ConstraintListener<T> r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mListeners.remove(r100) == true) goto L7;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mListeners.isEmpty() == false) goto L9;
        stopTracking();     // Catch: Throwable -> L11
        goto L9
    }

    public void setState(T r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        T r102 = this.mCurrentState;     // Catch: Throwable -> L15
        if (r102 == r100) goto L13;
        if (r102 != null) goto L8;
    L10:
        this.mCurrentState = r100;     // Catch: Throwable -> L15
        final ArrayList r103 = new ArrayList(this.mListeners);     // Catch: Throwable -> L15
        this.mTaskExecutor.getMainThreadExecutor().execute(new AnonymousClass1(this, r103));     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L8:
        if (r102.equals(r100) == false) goto L10;
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public ConstraintTracker(Context r100, TaskExecutor r101) {
        this.mLock = new Object();
        this.mListeners = new LinkedHashSet();
        this.mAppContext = r100.getApplicationContext();
        this.mTaskExecutor = r101;
    }
}
