package com.bytedance.android.shopping.collect.container;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/collect/container/CollectYataSkeletonLoadingStatus;", "", "SUCCESS", "ERROR", "LOADING", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CollectYataSkeletonLoadingStatus extends Enum<CollectYataSkeletonLoadingStatus> {
    public static final CollectYataSkeletonLoadingStatus ERROR = null;
    public static final CollectYataSkeletonLoadingStatus LOADING = null;
    public static final CollectYataSkeletonLoadingStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CollectYataSkeletonLoadingStatus[] f172144a = null;

    static {
        CollectYataSkeletonLoadingStatus r100 = new CollectYataSkeletonLoadingStatus("SUCCESS", 0);
        SUCCESS = r100;
        CollectYataSkeletonLoadingStatus r101 = new CollectYataSkeletonLoadingStatus("ERROR", 1);
        ERROR = r101;
        CollectYataSkeletonLoadingStatus r102 = new CollectYataSkeletonLoadingStatus("LOADING", 2);
        LOADING = r102;
        f172144a = new CollectYataSkeletonLoadingStatus[]{r100, r101, r102};
    }

    public static CollectYataSkeletonLoadingStatus valueOf(String r100) {
        return (CollectYataSkeletonLoadingStatus) r27.a.a(CollectYataSkeletonLoadingStatus.class, r100);
    }

    public static CollectYataSkeletonLoadingStatus[] values() {
        return (CollectYataSkeletonLoadingStatus[]) f172144a.clone();
    }

    public CollectYataSkeletonLoadingStatus(String r100, int r101) {
        super(r100, r101);
    }
}
