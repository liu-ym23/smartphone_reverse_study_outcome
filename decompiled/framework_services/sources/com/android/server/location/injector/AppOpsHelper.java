package com.android.server.location.injector;

import android.location.util.identity.CallerIdentity;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppOpsHelper {
    private final CopyOnWriteArrayList<LocationAppOpListener> mListeners;

    public interface LocationAppOpListener {
        void onAppOpsChanged(String r1);
    }

    public abstract boolean checkOpNoThrow(int r1, CallerIdentity r2);

    public abstract void finishOp(int r1, CallerIdentity r2);

    public abstract boolean noteOp(int r1, CallerIdentity r2);

    public abstract boolean noteOpNoThrow(int r1, CallerIdentity r2);

    public abstract boolean startOpNoThrow(int r1, CallerIdentity r2);

    public AppOpsHelper() {
        this.mListeners = new CopyOnWriteArrayList();
    }

    protected final void notifyAppOpChanged(String packageName) {
        Iterator<LocationAppOpListener> r0 = this.mListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        LocationAppOpListener listener = r0.next();
        listener.onAppOpsChanged(packageName);
        goto L4
    }

    public final void addListener(LocationAppOpListener listener) {
        this.mListeners.add(listener);
    }

    public final void removeListener(LocationAppOpListener listener) {
        this.mListeners.remove(listener);
    }
}
