package com.bumptech.glide.manager;

import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes39.dex */
class ActivityFragmentLifecycle implements Lifecycle {
    private boolean isDestroyed;
    private boolean isStarted;
    private final Set<LifecycleListener> lifecycleListeners;

    public void onDestroy() {
        this.isDestroyed = true;
        Iterator r100 = Util.getSnapshot(this.lifecycleListeners).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((LifecycleListener) r100.next()).onDestroy();
        goto L4
    }

    public void onStart() {
        this.isStarted = true;
        Iterator r100 = Util.getSnapshot(this.lifecycleListeners).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((LifecycleListener) r100.next()).onStart();
        goto L4
    }

    public void onStop() {
        this.isStarted = false;
        Iterator r100 = Util.getSnapshot(this.lifecycleListeners).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((LifecycleListener) r100.next()).onStop();
        goto L4
    }

    public ActivityFragmentLifecycle() {
        this.lifecycleListeners = Collections.newSetFromMap(new WeakHashMap());
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(LifecycleListener r100) {
        this.lifecycleListeners.add(r100);
        if (this.isDestroyed == false) goto L6;
        r100.onDestroy();
        return;
    L6:
        if (this.isStarted == false) goto L8;
        r100.onStart();
        return;
    L8:
        r100.onStop();
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(LifecycleListener r100) {
        this.lifecycleListeners.remove(r100);
    }
}
