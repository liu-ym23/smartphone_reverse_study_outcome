package com.android.server.utils;

import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SnapshotCache<T> extends Watcher {
    private static final boolean ENABLED = true;
    private static final WeakHashMap<SnapshotCache, Void> sCaches = null;
    private volatile boolean mSealed;
    private volatile T mSnapshot;
    protected final T mSource;
    private final Statistics mStatistics;

    public static class Auto<T extends Snappable<T>> extends SnapshotCache<T> {
        @Override // com.android.server.utils.SnapshotCache
        public /* bridge */ /* synthetic */ Object createSnapshot() {
            return createSnapshot();
        }

        public Auto(T source, Watchable watchable, String name) {
            super(source, watchable, name);
        }

        public Auto(T source, Watchable watchable) {
            this(source, watchable, null);
        }

        @Override // com.android.server.utils.SnapshotCache
        public T createSnapshot() {
            return (T) this.mSource.snapshot();
        }
    }

    public static class Sealed<T> extends SnapshotCache<T> {
        public Sealed() {
        }

        @Override // com.android.server.utils.SnapshotCache
        public T createSnapshot() {
            throw new UnsupportedOperationException("cannot snapshot a sealed snaphot");
        }
    }

    private static class Statistics {
        final String mName;
        private final AtomicInteger mRebuilt;
        private final AtomicInteger mReused;

        /* JADX INFO: renamed from: -$$Nest$fgetmRebuilt, reason: not valid java name */
        static /* bridge */ /* synthetic */ AtomicInteger m9269$$Nest$fgetmRebuilt(Statistics r0) {
            return r0.mRebuilt;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmReused, reason: not valid java name */
        static /* bridge */ /* synthetic */ AtomicInteger m9270$$Nest$fgetmReused(Statistics r0) {
            return r0.mReused;
        }

        Statistics(String n) {
            this.mReused = new AtomicInteger(0);
            this.mRebuilt = new AtomicInteger(0);
            this.mName = n;
        }
    }

    public abstract T createSnapshot();

    static {
        sCaches = new WeakHashMap();
    }

    public SnapshotCache(T source, Watchable watchable, String name) {
        this.mSnapshot = null;
        this.mSealed = false;
        this.mSource = source;
        watchable.registerObserver(this);
        if (name == null) goto L5;
        this.mStatistics = new Statistics(name);
        sCaches.put(this, null);
        return;
    L5:
        this.mStatistics = null;
    }

    public SnapshotCache(T source, Watchable watchable) {
        this(source, watchable, null);
    }

    public SnapshotCache() {
        this.mSnapshot = null;
        this.mSealed = false;
        this.mSource = null;
        this.mSealed = true;
        this.mStatistics = null;
    }

    @Override // com.android.server.utils.Watcher
    public final void onChange(Watchable what) {
        if (this.mSealed == true) goto L7;
        this.mSnapshot = null;
        return;
    L7:
        throw new IllegalStateException("attempt to change a sealed object");
    }

    public final void seal() {
        this.mSealed = true;
    }

    public final T snapshot() {
        T s = this.mSnapshot;
        if (s != null) goto L5;
        s = createSnapshot();
        this.mSnapshot = s;
        if (this.mStatistics == null) goto L10;
        Statistics.m9269$$Nest$fgetmRebuilt(this.mStatistics).incrementAndGet();
    L10:
        return s;
    L5:
        if (this.mStatistics == null) goto L10;
        Statistics.m9270$$Nest$fgetmReused(this.mStatistics).incrementAndGet();
        goto L10
    }
}
