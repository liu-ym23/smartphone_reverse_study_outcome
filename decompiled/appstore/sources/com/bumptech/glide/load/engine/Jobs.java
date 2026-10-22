package com.bumptech.glide.load.engine;

import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class Jobs {
    private final Map<Key, EngineJob<?>> jobs;
    private final Map<Key, EngineJob<?>> onlyCacheJobs;

    public Jobs() {
        this.jobs = new HashMap();
        this.onlyCacheJobs = new HashMap();
    }

    private Map<Key, EngineJob<?>> getJobMap(boolean r10) {
        if (r10 == false) goto L5;
        return this.onlyCacheJobs;
    L5:
        return this.jobs;
    }

    public EngineJob<?> get(Key r10, boolean r11) {
        return getJobMap(r11).get(r10);
    }

    @VisibleForTesting
    public Map<Key, EngineJob<?>> getAll() {
        return Collections.unmodifiableMap(this.jobs);
    }

    public void put(Key r10, EngineJob<?> r11) {
        getJobMap(r11.onlyRetrieveFromCache()).put(r10, r11);
    }

    public void removeIfCurrent(Key r10, EngineJob<?> r11) {
        Map<Key, EngineJob<?>> r12 = getJobMap(r11.onlyRetrieveFromCache());
        if (r11.equals(r12.get(r10)) == false) goto L6;
        r12.remove(r10);
        return;
    }
}
