package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class RequestTracker {
    private static final String TAG = "RequestTracker";
    private boolean isPaused;
    private final List<Request> pendingRequests;
    private final Set<Request> requests;

    public RequestTracker() {
        this.requests = Collections.newSetFromMap(new WeakHashMap());
        this.pendingRequests = new ArrayList();
    }

    private boolean clearRemoveAndMaybeRecycle(@Nullable Request r10, boolean r11) {
        boolean r12 = true;
        if (r10 != null) goto L5;
        return true;
    L5:
        boolean r13 = this.requests.remove(r10);
        if (this.pendingRequests.remove(r10) == true) goto L10;
        if (r13 == true) goto L10;
        r12 = false;
    L10:
        if (r12 == false) goto L14;
        r10.clear();
        if (r11 == false) goto L14;
        r10.recycle();
    L14:
        return r12;
    }

    @VisibleForTesting
    public void addRequest(Request r10) {
        this.requests.add(r10);
    }

    public boolean clearRemoveAndRecycle(@Nullable Request r10) {
        return clearRemoveAndMaybeRecycle(r10, true);
    }

    public void clearRequests() {
        Iterator r10 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        clearRemoveAndMaybeRecycle((Request) r10.next(), false);
        goto L4
    L6:
        this.pendingRequests.clear();
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void pauseAllRequests() {
        this.isPaused = true;
        Iterator r10 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Request r11 = (Request) r10.next();
        if (r11.isRunning() == true) goto L9;
        if (r11.isComplete() == false) goto L4;
    L9:
        r11.clear();
        this.pendingRequests.add(r11);
        goto L4
    }

    public void pauseRequests() {
        this.isPaused = true;
        Iterator r10 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Request r11 = (Request) r10.next();
        if (r11.isRunning() == false) goto L4;
        r11.clear();
        this.pendingRequests.add(r11);
        goto L4
    }

    public void restartRequests() {
        Iterator r10 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r10.hasNext() == false) goto L13;
        Request r11 = (Request) r10.next();
        if (r11.isComplete() == true) goto L4;
        if (r11.isCleared() == true) goto L4;
        r11.clear();
        if (this.isPaused == false) goto L11;
        this.pendingRequests.add(r11);
        goto L4
    L11:
        r11.begin();
        goto L4
    }

    public void resumeRequests() {
        this.isPaused = false;
        Iterator r10 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Request r11 = (Request) r10.next();
        if (r11.isComplete() == true) goto L4;
        if (r11.isRunning() == true) goto L4;
        r11.begin();
        goto L4
    L10:
        this.pendingRequests.clear();
    }

    public void runRequest(@NonNull Request r10) {
        this.requests.add(r10);
        if (this.isPaused == true) goto L5;
        r10.begin();
        return;
    L5:
        r10.clear();
        if (Log.isLoggable(TAG, 2) == false) goto L8;
        Log.v(TAG, "Paused, delaying request");
    L8:
        this.pendingRequests.add(r10);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.requests.size() + ", isPaused=" + this.isPaused + "}";
    }
}
