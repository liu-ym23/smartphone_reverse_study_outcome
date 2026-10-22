package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
final class Jobs {
    private final Map<Key, EngineJob<?>> jobs;
    private final Map<Key, EngineJob<?>> onlyCacheJobs;

    public Map<Key, EngineJob<?>> getAll() {
        return Collections.unmodifiableMap(this.jobs);
    }

    public Jobs() {
        this.jobs = new HashMap();
        this.onlyCacheJobs = new HashMap();
    }

    private Map<Key, EngineJob<?>> getJobMap(boolean r100) {
        if (r100 == false) goto L5;
        return this.onlyCacheJobs;
    L5:
        return this.jobs;
    }

    public EngineJob<?> get(Key r100, boolean r101) {
        return getJobMap(r101).get(r100);
    }

    public void put(Key r100, EngineJob<?> r101) {
        getJobMap(r101.onlyRetrieveFromCache()).put(r100, r101);
    }

    public void removeIfCurrent(Key r100, EngineJob<?> r101) {
        Map<Key, EngineJob<?>> r102 = getJobMap(r101.onlyRetrieveFromCache());
        if (r101.equals(r102.get(r100)) == false) goto L6;
        r102.remove(r100);
        return;
    }
}
