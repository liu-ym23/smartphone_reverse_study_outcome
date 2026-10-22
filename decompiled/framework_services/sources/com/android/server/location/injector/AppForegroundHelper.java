package com.android.server.location.injector;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppForegroundHelper {
    protected static final int FOREGROUND_IMPORTANCE_CUTOFF = 125;
    private final CopyOnWriteArrayList<AppForegroundListener> mListeners;

    public interface AppForegroundListener {
        void onAppForegroundChanged(int r1, boolean r2);
    }

    public abstract boolean isAppForeground(int r1);

    protected static boolean isForeground(int importance) {
        if (importance > 125) goto L5;
        return true;
    L5:
        return false;
    }

    public AppForegroundHelper() {
        this.mListeners = new CopyOnWriteArrayList();
    }

    public final void addListener(AppForegroundListener listener) {
        this.mListeners.add(listener);
    }

    public final void removeListener(AppForegroundListener listener) {
        this.mListeners.remove(listener);
    }

    protected final void notifyAppForeground(int uid, boolean foreground) {
        Iterator<AppForegroundListener> r0 = this.mListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        AppForegroundListener listener = r0.next();
        listener.onAppForegroundChanged(uid, foreground);
        goto L4
    }

    public CopyOnWriteArrayList<AppForegroundListener> getListeners() {
        return this.mListeners;
    }
}
