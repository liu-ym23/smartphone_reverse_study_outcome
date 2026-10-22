package com.android.server.uri;

import android.app.StatsManager;
import android.content.Context;
import android.util.SparseArray;
import android.util.StatsEvent;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.FrameworkStatsLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
final class UriMetricsHelper {
    private static final StatsManager.PullAtomMetadata DAILY_PULL_METADATA = null;
    private final Context mContext;
    private final PersistentUriGrantsProvider mPersistentUriGrantsProvider;

    interface PersistentUriGrantsProvider {
        ArrayList<UriPermission> providePersistentUriGrants();
    }

    public static /* synthetic */ int $r8$lambda$j_o1IwY1bMMNaVR_UXOBbVzgJo0(UriMetricsHelper r0, int r1, List r2) {
        return r0.lambda$registerPuller$0(r1, r2);
    }

    static {
        DAILY_PULL_METADATA = new StatsManager.PullAtomMetadata.Builder().setCoolDownMillis(TimeUnit.DAYS.toMillis(1)).build();
    }

    UriMetricsHelper(Context context, PersistentUriGrantsProvider provider) {
        this.mContext = context;
        this.mPersistentUriGrantsProvider = provider;
    }

    void registerPuller() {
        StatsManager statsManager = (StatsManager) this.mContext.getSystemService(StatsManager.class);
        statsManager.setPullAtomCallback(FrameworkStatsLog.PERSISTENT_URI_PERMISSIONS_AMOUNT_PER_PACKAGE, DAILY_PULL_METADATA, ConcurrentUtils.DIRECT_EXECUTOR, new UriMetricsHelper$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ int lambda$registerPuller$0(int atomTag, List data) {
        reportPersistentUriPermissionsPerPackage(data);
        return 0;
    }

    void reportPersistentUriFlushed(int amount) {
        FrameworkStatsLog.write(FrameworkStatsLog.PERSISTENT_URI_PERMISSIONS_FLUSHED, amount);
    }

    private void reportPersistentUriPermissionsPerPackage(List<StatsEvent> data) {
        ArrayList<UriPermission> persistentUriGrants = this.mPersistentUriGrantsProvider.providePersistentUriGrants();
        SparseArray<Integer> perUidCount = new SparseArray();
        int persistentUriGrantsSize = persistentUriGrants.size();
        int i = 0;
    L3:
        if (i >= persistentUriGrantsSize) goto L5;
        UriPermission uriPermission = persistentUriGrants.get(i);
        perUidCount.put(uriPermission.targetUid, Integer.valueOf(perUidCount.get(uriPermission.targetUid, 0).intValue() + 1));
        i = i + 1;
        goto L3
    L5:
        int perUidCountSize = perUidCount.size();
        int i2 = 0;
    L6:
        if (i2 >= perUidCountSize) goto L9;
        int uid = perUidCount.keyAt(i2);
        int amount = perUidCount.valueAt(i2).intValue();
        data.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.PERSISTENT_URI_PERMISSIONS_AMOUNT_PER_PACKAGE, uid, amount));
        i2 = i2 + 1;
        goto L6
    }
}
