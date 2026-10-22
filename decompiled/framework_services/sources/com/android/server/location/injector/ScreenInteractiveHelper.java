package com.android.server.location.injector;

import android.util.Log;
import com.android.server.location.LocationManagerService;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ScreenInteractiveHelper {
    private final CopyOnWriteArrayList<ScreenInteractiveChangedListener> mListeners;

    public interface ScreenInteractiveChangedListener {
        void onScreenInteractiveChanged(boolean r1);
    }

    public abstract boolean isInteractive();

    public ScreenInteractiveHelper() {
        this.mListeners = new CopyOnWriteArrayList();
    }

    public final void addListener(ScreenInteractiveChangedListener listener) {
        this.mListeners.add(listener);
    }

    public final void removeListener(ScreenInteractiveChangedListener listener) {
        this.mListeners.remove(listener);
    }

    protected final void notifyScreenInteractiveChanged(boolean interactive) {
        if (LocationManagerService.D == false) goto L5;
        Log.d(LocationManagerService.TAG, "screen interactive is now " + interactive);
    L5:
        Iterator<ScreenInteractiveChangedListener> r0 = this.mListeners.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ScreenInteractiveChangedListener listener = r0.next();
        listener.onScreenInteractiveChanged(interactive);
        goto L7
    }
}
