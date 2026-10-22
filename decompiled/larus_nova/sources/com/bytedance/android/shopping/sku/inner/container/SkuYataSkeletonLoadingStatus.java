package com.bytedance.android.shopping.sku.inner.container;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/container/SkuYataSkeletonLoadingStatus;", "", "SUCCESS", "ERROR", "LOADING", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SkuYataSkeletonLoadingStatus extends Enum<SkuYataSkeletonLoadingStatus> {
    public static final SkuYataSkeletonLoadingStatus ERROR = null;
    public static final SkuYataSkeletonLoadingStatus LOADING = null;
    public static final SkuYataSkeletonLoadingStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkuYataSkeletonLoadingStatus[] f182830a = null;

    static {
        SkuYataSkeletonLoadingStatus r100 = new SkuYataSkeletonLoadingStatus("SUCCESS", 0);
        SUCCESS = r100;
        SkuYataSkeletonLoadingStatus r101 = new SkuYataSkeletonLoadingStatus("ERROR", 1);
        ERROR = r101;
        SkuYataSkeletonLoadingStatus r102 = new SkuYataSkeletonLoadingStatus("LOADING", 2);
        LOADING = r102;
        f182830a = new SkuYataSkeletonLoadingStatus[]{r100, r101, r102};
    }

    public static SkuYataSkeletonLoadingStatus valueOf(String r100) {
        return (SkuYataSkeletonLoadingStatus) r27.a.a(SkuYataSkeletonLoadingStatus.class, r100);
    }

    public static SkuYataSkeletonLoadingStatus[] values() {
        return (SkuYataSkeletonLoadingStatus[]) f182830a.clone();
    }

    public SkuYataSkeletonLoadingStatus(String r100, int r101) {
        super(r100, r101);
    }
}
