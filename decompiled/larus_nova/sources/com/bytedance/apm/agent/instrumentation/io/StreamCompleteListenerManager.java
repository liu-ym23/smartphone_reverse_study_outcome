package com.bytedance.apm.agent.instrumentation.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
class StreamCompleteListenerManager {
    private boolean streamComplete;
    private ArrayList<StreamCompleteListener> streamCompleteListeners;

    private boolean checkComplete() {
        monitor-enter(this);
        boolean r100 = isComplete();     // Catch: Throwable -> L8
        if (r100 == true) goto L6;
        this.streamComplete = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r100;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isComplete() {
        monitor-enter(this);
        boolean r100 = this.streamComplete;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    private List<StreamCompleteListener> getStreamCompleteListeners() {
        ArrayList<StreamCompleteListener> r100 = this.streamCompleteListeners;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.streamCompleteListeners);     // Catch: Throwable -> L7
        this.streamCompleteListeners.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public StreamCompleteListenerManager() {
        this.streamComplete = false;
        this.streamCompleteListeners = new ArrayList();
    }

    public void addStreamCompleteListener(StreamCompleteListener r100) {
        ArrayList<StreamCompleteListener> r101 = this.streamCompleteListeners;
        monitor-enter(r101);
        this.streamCompleteListeners.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyStreamComplete(StreamCompleteEvent r100) {
        if (checkComplete() == true) goto L8;
        Iterator<StreamCompleteListener> r101 = getStreamCompleteListeners().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        r101.next().streamComplete(r100);
        goto L6
    L10:
        return;
    }

    public void notifyStreamError(StreamCompleteEvent r100) {
        if (checkComplete() == true) goto L8;
        Iterator<StreamCompleteListener> r101 = getStreamCompleteListeners().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        r101.next().streamError(r100);
        goto L6
    L10:
        return;
    }

    public void removeStreamCompleteListener(StreamCompleteListener r100) {
        ArrayList<StreamCompleteListener> r101 = this.streamCompleteListeners;
        monitor-enter(r101);
        this.streamCompleteListeners.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
