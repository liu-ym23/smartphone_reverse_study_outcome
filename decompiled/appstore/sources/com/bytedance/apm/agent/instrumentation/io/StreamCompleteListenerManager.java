package com.bytedance.apm.agent.instrumentation.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class StreamCompleteListenerManager {
    private boolean streamComplete;
    private ArrayList<StreamCompleteListener> streamCompleteListeners;

    public StreamCompleteListenerManager() {
        this.streamComplete = false;
        this.streamCompleteListeners = new ArrayList();
    }

    private boolean checkComplete() {
        monitor-enter(this);
        boolean r10 = isComplete();     // Catch: Throwable -> L6
        if (r10 == true) goto L8;
        this.streamComplete = true;     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    private List<StreamCompleteListener> getStreamCompleteListeners() {
        ArrayList<StreamCompleteListener> r10 = this.streamCompleteListeners;
        monitor-enter(r10);
        ArrayList r11 = new ArrayList(this.streamCompleteListeners);     // Catch: Throwable -> L7
        this.streamCompleteListeners.clear();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public void addStreamCompleteListener(StreamCompleteListener r10) {
        ArrayList<StreamCompleteListener> r11 = this.streamCompleteListeners;
        monitor-enter(r11);
        this.streamCompleteListeners.add(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isComplete() {
        monitor-enter(this);
        boolean r10 = this.streamComplete;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public void notifyStreamComplete(StreamCompleteEvent r10) {
        if (checkComplete() == true) goto L8;
        Iterator<StreamCompleteListener> r11 = getStreamCompleteListeners().iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        r11.next().streamComplete(r10);
        goto L6
    L10:
        return;
    }

    public void notifyStreamError(StreamCompleteEvent r10) {
        if (checkComplete() == true) goto L8;
        Iterator<StreamCompleteListener> r11 = getStreamCompleteListeners().iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        r11.next().streamError(r10);
        goto L6
    L10:
        return;
    }

    public void removeStreamCompleteListener(StreamCompleteListener r10) {
        ArrayList<StreamCompleteListener> r11 = this.streamCompleteListeners;
        monitor-enter(r11);
        this.streamCompleteListeners.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
