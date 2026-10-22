package com.bumptech.glide.manager;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes39.dex */
public final class TargetTracker implements LifecycleListener {
    private final Set<Target<?>> targets;

    public void clear() {
        this.targets.clear();
    }

    public List<Target<?>> getAll() {
        return Util.getSnapshot(this.targets);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        Iterator r100 = Util.getSnapshot(this.targets).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Target) r100.next()).onDestroy();
        goto L4
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Iterator r100 = Util.getSnapshot(this.targets).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Target) r100.next()).onStart();
        goto L4
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Iterator r100 = Util.getSnapshot(this.targets).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Target) r100.next()).onStop();
        goto L4
    }

    public TargetTracker() {
        this.targets = Collections.newSetFromMap(new WeakHashMap());
    }

    public void track(Target<?> r100) {
        this.targets.add(r100);
    }

    public void untrack(Target<?> r100) {
        this.targets.remove(r100);
    }
}
