package com.android.server.pm;

import android.content.IntentFilter;
import com.android.server.utils.Snappable;
import com.android.server.utils.SnapshotCache;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class PreferredIntentResolver extends WatchedIntentResolver<PreferredActivity, PreferredActivity> implements Snappable {
    final SnapshotCache<PreferredIntentResolver> mSnapshot;

    /* synthetic */ PreferredIntentResolver(PreferredIntentResolver r1, PreferredIntentResolverIA r2) {
        this(r1);
    }

    @Override // com.android.server.IntentResolver
    protected /* bridge */ /* synthetic */ void dumpFilter(PrintWriter r1, String r2, Object r3) {
        dumpFilter(r1, r2, (PreferredActivity) r3);
    }

    @Override // com.android.server.IntentResolver
    protected /* bridge */ /* synthetic */ IntentFilter getIntentFilter(Object r1) {
        return getIntentFilter((PreferredActivity) r1);
    }

    @Override // com.android.server.IntentResolver
    protected /* bridge */ /* synthetic */ boolean isPackageForFilter(String r1, Object r2) {
        return isPackageForFilter(r1, (PreferredActivity) r2);
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
        return snapshot((PreferredActivity) r1);
    }

    @Override // com.android.server.IntentResolver
    protected PreferredActivity[] newArray(int size) {
        return new PreferredActivity[size];
    }

    protected boolean isPackageForFilter(String packageName, PreferredActivity filter) {
        return packageName.equals(filter.mPref.mComponent.getPackageName());
    }

    protected void dumpFilter(PrintWriter out, String prefix, PreferredActivity filter) {
        filter.mPref.dump(out, prefix, filter);
    }

    protected IntentFilter getIntentFilter(PreferredActivity input) {
        return input.getIntentFilter();
    }

    public boolean shouldAddPreferredActivity(PreferredActivity pa) {
        ArrayList<PreferredActivity> pal = findFilters(pa);
        if (pal != null) goto L5;
    L22:
        return true;
    L5:
        if (pal.isEmpty() == true) goto L22;
        if (pa.mPref.mAlways == true) goto L10;
        return false;
    L10:
        int activityCount = pal.size();
        int i = 0;
    L11:
        if (i >= activityCount) goto L21;
        PreferredActivity cur = pal.get(i);
        if (cur.mPref.mAlways == false) goto L19;
        if (cur.mPref.mMatch != (pa.mPref.mMatch & 268369920)) goto L19;
        if (cur.mPref.sameSet(pa.mPref) == false) goto L19;
        return false;
    L19:
        i = i + 1;
        goto L11
    L21:
        return true;
    }

    public PreferredIntentResolver() {
        this.mSnapshot = makeCache();
    }

    protected PreferredActivity snapshot(PreferredActivity f) {
        if (f != null) goto L5;
        return null;
    L5:
        return f.snapshot();
    }

    private PreferredIntentResolver(PreferredIntentResolver f) {
        copyFrom(f);
        this.mSnapshot = new SnapshotCache.Sealed();
    }

    private SnapshotCache makeCache() {
        return new AnonymousClass1(this, this, this);
    }

    @Override // com.android.server.utils.Snappable
    public PreferredIntentResolver snapshot() {
        return this.mSnapshot.snapshot();
    }
}
