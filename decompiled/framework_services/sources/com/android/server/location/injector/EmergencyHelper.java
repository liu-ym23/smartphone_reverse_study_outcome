package com.android.server.location.injector;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EmergencyHelper {
    private final CopyOnWriteArrayList<EmergencyStateChangedListener> mListeners;

    public interface EmergencyStateChangedListener {
        void onStateChanged();
    }

    public abstract boolean isInEmergency(long r1);

    protected EmergencyHelper() {
        this.mListeners = new CopyOnWriteArrayList();
    }

    public void addOnEmergencyStateChangedListener(EmergencyStateChangedListener listener) {
        this.mListeners.add(listener);
    }

    public void removeOnEmergencyStateChangedListener(EmergencyStateChangedListener listener) {
        this.mListeners.remove(listener);
    }

    protected final void dispatchEmergencyStateChanged() {
        Iterator<EmergencyStateChangedListener> r0 = this.mListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        EmergencyStateChangedListener listener = r0.next();
        listener.onStateChanged();
        goto L4
    }
}
