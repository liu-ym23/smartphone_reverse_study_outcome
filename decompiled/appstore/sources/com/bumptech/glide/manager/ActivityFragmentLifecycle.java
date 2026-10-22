package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class ActivityFragmentLifecycle implements Lifecycle {
    private boolean isDestroyed;
    private boolean isStarted;
    private final Set<LifecycleListener> lifecycleListeners;

    public ActivityFragmentLifecycle() {
        this.lifecycleListeners = Collections.newSetFromMap(new WeakHashMap());
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(@NonNull LifecycleListener r10) {
        this.lifecycleListeners.add(r10);
        if (this.isDestroyed == false) goto L6;
        r10.onDestroy();
        return;
    L6:
        if (this.isStarted == false) goto L8;
        r10.onStart();
        return;
    L8:
        r10.onStop();
    }

    public void onDestroy() {
        this.isDestroyed = true;
        Iterator r10 = Util.getSnapshot(this.lifecycleListeners).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((LifecycleListener) r10.next()).onDestroy();
        goto L4
    }

    public void onStart() {
        this.isStarted = true;
        Iterator r10 = Util.getSnapshot(this.lifecycleListeners).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((LifecycleListener) r10.next()).onStart();
        goto L4
    }

    public void onStop() {
        this.isStarted = false;
        Iterator r10 = Util.getSnapshot(this.lifecycleListeners).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((LifecycleListener) r10.next()).onStop();
        goto L4
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(@NonNull LifecycleListener r10) {
        this.lifecycleListeners.remove(r10);
    }
}
