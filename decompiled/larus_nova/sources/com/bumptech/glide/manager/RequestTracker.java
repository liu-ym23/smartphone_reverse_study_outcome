package com.bumptech.glide.manager;

import com.alipay.sdk.m.u.i;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes39.dex */
public class RequestTracker {
    private static final String TAG = "RequestTracker";
    private boolean isPaused;
    private final List<Request> pendingRequests;
    private final Set<Request> requests;

    public void pauseAllRequests() {
        this.isPaused = true;
        Iterator r100 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        Request r101 = (Request) r100.next();
        if (r101.isRunning() == true) goto L9;
        if (r101.isComplete() == false) goto L4;
    L9:
        r101.clear();
        this.pendingRequests.add(r101);
        goto L4
    }

    public void pauseRequests() {
        this.isPaused = true;
        Iterator r100 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Request r101 = (Request) r100.next();
        if (r101.isRunning() == false) goto L4;
        r101.pause();
        this.pendingRequests.add(r101);
        goto L4
    }

    public void resumeRequests() {
        this.isPaused = false;
        Iterator r100 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        Request r101 = (Request) r100.next();
        if (r101.isComplete() == true) goto L4;
        if (r101.isRunning() == true) goto L4;
        r101.begin();
        goto L4
    L10:
        this.pendingRequests.clear();
    }

    public void clearRequests() {
        Iterator r100 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        clearAndRemove((Request) r100.next());
        goto L4
    L6:
        this.pendingRequests.clear();
    }

    public void restartRequests() {
        Iterator r100 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        Request r101 = (Request) r100.next();
        if (r101.isComplete() == true) goto L4;
        if (r101.isCleared() == true) goto L4;
        r101.clear();
        if (this.isPaused == false) goto L11;
        this.pendingRequests.add(r101);
        goto L4
    L11:
        r101.begin();
        goto L4
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.requests.size() + ", isPaused=" + this.isPaused + i.f25855d;
    }

    public RequestTracker() {
        this.requests = Collections.newSetFromMap(new WeakHashMap());
        this.pendingRequests = new ArrayList();
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void addRequest(Request r100) {
        this.requests.add(r100);
    }

    public boolean clearAndRemove(Request r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
        return true;
    L5:
        boolean r102 = this.requests.remove(r100);
        if (this.pendingRequests.remove(r100) == true) goto L10;
        if (r102 == true) goto L10;
        r101 = false;
    L10:
        if (r101 == false) goto L12;
        r100.clear();
    L12:
        return r101;
    }

    public void runRequest(Request r100) {
        this.requests.add(r100);
        if (this.isPaused == true) goto L5;
        r100.begin();
        return;
    L5:
        r100.clear();
        GlideLogUtil.w(TAG, "Paused, delaying request");
        this.pendingRequests.add(r100);
    }
}
