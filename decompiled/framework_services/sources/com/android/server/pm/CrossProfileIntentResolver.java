package com.android.server.pm;

import android.content.IntentFilter;
import com.android.server.utils.Snappable;
import com.android.server.utils.SnapshotCache;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class CrossProfileIntentResolver extends WatchedIntentResolver<CrossProfileIntentFilter, CrossProfileIntentFilter> implements Snappable {
    final SnapshotCache<CrossProfileIntentResolver> mSnapshot;

    /* synthetic */ CrossProfileIntentResolver(CrossProfileIntentResolver r1, CrossProfileIntentResolverIA r2) {
        this(r1);
    }

    @Override // com.android.server.IntentResolver
    protected /* bridge */ /* synthetic */ IntentFilter getIntentFilter(Object r1) {
        return getIntentFilter((CrossProfileIntentFilter) r1);
    }

    @Override // com.android.server.IntentResolver
    protected /* bridge */ /* synthetic */ boolean isPackageForFilter(String r1, Object r2) {
        return isPackageForFilter(r1, (CrossProfileIntentFilter) r2);
    }

    @Override // com.android.server.IntentResolver
    protected /* bridge */ /* synthetic */ Object[] newArray(int r1) {
        return newArray(r1);
    }

    @Override // com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ Object snapshot() {
        return snapshot();
    }

    @Override // com.android.server.IntentResolver
    protected /* bridge */ /* synthetic */ Object snapshot(Object r1) {
        return snapshot((CrossProfileIntentFilter) r1);
    }

    @Override // com.android.server.IntentResolver
    protected CrossProfileIntentFilter[] newArray(int size) {
        return new CrossProfileIntentFilter[size];
    }

    protected boolean isPackageForFilter(String packageName, CrossProfileIntentFilter filter) {
        if ((filter.mFlags & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.WatchedIntentResolver, com.android.server.IntentResolver
    protected void sortResults(List<CrossProfileIntentFilter> results) {
    }

    protected IntentFilter getIntentFilter(CrossProfileIntentFilter input) {
        return input.getIntentFilter();
    }

    CrossProfileIntentResolver() {
        this.mSnapshot = makeCache();
    }

    protected CrossProfileIntentFilter snapshot(CrossProfileIntentFilter f) {
        if (f != null) goto L5;
        return null;
    L5:
        return f.snapshot();
    }

    private CrossProfileIntentResolver(CrossProfileIntentResolver f) {
        copyFrom(f);
        this.mSnapshot = new SnapshotCache.Sealed();
    }

    private SnapshotCache makeCache() {
        return new AnonymousClass1(this, this, this);
    }

    @Override // com.android.server.utils.Snappable
    public CrossProfileIntentResolver snapshot() {
        return this.mSnapshot.snapshot();
    }
}
