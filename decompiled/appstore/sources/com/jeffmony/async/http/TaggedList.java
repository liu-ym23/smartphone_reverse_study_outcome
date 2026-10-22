package com.jeffmony.async.http;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class TaggedList<T> extends ArrayList<T> {
    private Object tag;

    public TaggedList() {
    }

    public synchronized <V> V tag() {
        monitor-enter(this);
        V r10 = (V) this.tag;
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <V> void tagNull(V r10) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.tag != null) goto L9;
        this.tag = r10;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    public synchronized <V> void tag(V r10) {
        monitor-enter(this);
        this.tag = r10;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
