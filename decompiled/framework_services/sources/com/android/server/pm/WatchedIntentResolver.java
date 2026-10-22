package com.android.server.pm;

import com.android.server.IntentResolver;
import com.android.server.pm.WatchedIntentFilter;
import com.android.server.pm.snapshot.PackageDataSnapshot;
import com.android.server.utils.Snappable;
import com.android.server.utils.Watchable;
import com.android.server.utils.WatchableImpl;
import com.android.server.utils.Watcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WatchedIntentResolver<F extends WatchedIntentFilter, R extends WatchedIntentFilter> extends IntentResolver<F, R> implements Watchable, Snappable {
    private static final Comparator<WatchedIntentFilter> sResolvePrioritySorter = null;
    private final Watchable mWatchable;
    private final Watcher mWatcher;

    public WatchedIntentResolver() {
        this.mWatchable = new WatchableImpl();
        this.mWatcher = new AnonymousClass1(this);
    }

    @Override // com.android.server.IntentResolver
    public /* bridge */ /* synthetic */ void addFilter(PackageDataSnapshot r1, Object r2) {
        addFilter(r1, (WatchedIntentFilter) r2);
    }

    @Override // com.android.server.IntentResolver
    public /* bridge */ /* synthetic */ void removeFilter(Object r1) {
        removeFilter((WatchedIntentFilter) r1);
    }

    @Override // com.android.server.IntentResolver
    protected /* bridge */ /* synthetic */ void removeFilterInternal(Object r1) {
        removeFilterInternal((WatchedIntentFilter) r1);
    }

    @Override // com.android.server.utils.Watchable
    public void registerObserver(Watcher observer) {
        this.mWatchable.registerObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public void unregisterObserver(Watcher observer) {
        this.mWatchable.unregisterObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public boolean isRegisteredObserver(Watcher observer) {
        return this.mWatchable.isRegisteredObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public void dispatchChange(Watchable what) {
        this.mWatchable.dispatchChange(what);
    }

    protected void onChanged() {
        dispatchChange(this);
    }

    public void addFilter(PackageDataSnapshot snapshot, F f) {
        super.addFilter(snapshot, f);
        f.registerObserver(this.mWatcher);
        onChanged();
    }

    public void removeFilter(F f) {
        f.unregisterObserver(this.mWatcher);
        super.removeFilter(f);
        onChanged();
    }

    protected void removeFilterInternal(F f) {
        f.unregisterObserver(this.mWatcher);
        super.removeFilterInternal(f);
        onChanged();
    }

    static {
        sResolvePrioritySorter = new AnonymousClass2();
    }

    @Override // com.android.server.IntentResolver
    protected void sortResults(List<R> results) {
        Collections.sort(results, sResolvePrioritySorter);
    }

    public ArrayList<F> findFilters(WatchedIntentFilter matching) {
        return super.findFilters(matching.getIntentFilter());
    }

    protected void copyFrom(WatchedIntentResolver orig) {
        super.copyFrom(orig);
    }
}
