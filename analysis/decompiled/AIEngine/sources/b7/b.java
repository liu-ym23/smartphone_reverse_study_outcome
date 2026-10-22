package b7;

import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface b {
    void addUnloadListener(zb.l<? super String, lb.n> lVar);

    int capacity();

    boolean contains(String str);

    void evictAllIdle();

    void evictByRetainBudget(int i10);

    a get(String str);

    k getAcquiredConfig(String str);

    List<d7.b> getAllModelInfo();

    int getAvailableMemoryMb();

    long getHitCount();

    float getHitRate();

    List<String> getIdleModelsOlderThan(long j10);

    List<String> getLoadedModels();

    long getMissCount();

    int getRefCount(String str);

    int getTotalMemoryMb();

    void markPreloaded(String str);

    void onPreInit(k kVar);

    String refReleaseStats(String str);

    String refReleaseStatsAll();

    List<String> refSnapshot(String str);

    void scheduleIdleCheck();

    int size();
}
