package com.bytedance.android.live.core.tetris.widgets.cache;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/tetris/widgets/cache/CachePoolModel;", "", "BATCH_POOL_MODEL", "SINGLE_POOL_MODEL", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CachePoolModel extends Enum<CachePoolModel> {
    public static final CachePoolModel BATCH_POOL_MODEL = null;
    public static final CachePoolModel SINGLE_POOL_MODEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CachePoolModel[] f65959a = null;

    static {
        CachePoolModel r100 = new CachePoolModel("BATCH_POOL_MODEL", 0);
        BATCH_POOL_MODEL = r100;
        CachePoolModel r101 = new CachePoolModel("SINGLE_POOL_MODEL", 1);
        SINGLE_POOL_MODEL = r101;
        f65959a = new CachePoolModel[]{r100, r101};
    }

    public static CachePoolModel valueOf(String r100) {
        return (CachePoolModel) r27.a.a(CachePoolModel.class, r100);
    }

    public static CachePoolModel[] values() {
        return (CachePoolModel[]) f65959a.clone();
    }

    public CachePoolModel(String r100, int r101) {
        super(r100, r101);
    }
}
