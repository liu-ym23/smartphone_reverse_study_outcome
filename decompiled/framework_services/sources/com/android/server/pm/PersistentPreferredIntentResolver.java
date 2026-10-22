package com.android.server.pm;

import android.content.IntentFilter;
import com.android.server.utils.Snappable;
import com.android.server.utils.SnapshotCache;

/* JADX INFO: loaded from: classes2.dex */
public class PersistentPreferredIntentResolver extends WatchedIntentResolver<PersistentPreferredActivity, PersistentPreferredActivity> implements Snappable {
    final SnapshotCache<PersistentPreferredIntentResolver> mSnapshot;

    /* synthetic */ PersistentPreferredIntentResolver(PersistentPreferredIntentResolver r1, PersistentPreferredIntentResolverIA r2) {
        this(r1);
    }

    @Override // com.android.server.IntentResolver
    protected /* bridge */ /* synthetic */ IntentFilter getIntentFilter(Object r1) {
        return getIntentFilter((PersistentPreferredActivity) r1);
    }

    @Override // com.android.server.IntentResolver
    protected /* bridge */ /* synthetic */ boolean isPackageForFilter(String r1, Object r2) {
        return isPackageForFilter(r1, (PersistentPreferredActivity) r2);
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
        return snapshot((PersistentPreferredActivity) r1);
    }

    @Override // com.android.server.IntentResolver
    protected PersistentPreferredActivity[] newArray(int size) {
        return new PersistentPreferredActivity[size];
    }

    protected IntentFilter getIntentFilter(PersistentPreferredActivity input) {
        return input.getIntentFilter();
    }

    protected boolean isPackageForFilter(String packageName, PersistentPreferredActivity filter) {
        return packageName.equals(filter.mComponent.getPackageName());
    }

    public PersistentPreferredIntentResolver() {
        this.mSnapshot = makeCache();
    }

    protected PersistentPreferredActivity snapshot(PersistentPreferredActivity f) {
        if (f != null) goto L5;
        return null;
    L5:
        return f.snapshot();
    }

    private PersistentPreferredIntentResolver(PersistentPreferredIntentResolver f) {
        copyFrom(f);
        this.mSnapshot = new SnapshotCache.Sealed();
    }

    private SnapshotCache makeCache() {
        return new AnonymousClass1(this, this, this);
    }

    @Override // com.android.server.utils.Snappable
    public PersistentPreferredIntentResolver snapshot() {
        return this.mSnapshot.snapshot();
    }
}
