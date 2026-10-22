package com.bytedance.android.shopping.store.home.preload.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/home/preload/data/AIPreloadType;", "", "", "value", "I", "getValue", "()I", "NO_PRELOAD", "AI_PRELOAD_EXPIRED", "AI_PRELOAD_SUCCESS", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AIPreloadType extends Enum<AIPreloadType> {
    public static final AIPreloadType AI_PRELOAD_EXPIRED = null;
    public static final AIPreloadType AI_PRELOAD_SUCCESS = null;
    public static final AIPreloadType NO_PRELOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AIPreloadType[] f183796a = null;
    private final int value;

    static {
        AIPreloadType r100 = new AIPreloadType("NO_PRELOAD", 0, 0);
        NO_PRELOAD = r100;
        AIPreloadType r101 = new AIPreloadType("AI_PRELOAD_EXPIRED", 1, 1);
        AI_PRELOAD_EXPIRED = r101;
        AIPreloadType r102 = new AIPreloadType("AI_PRELOAD_SUCCESS", 2, 2);
        AI_PRELOAD_SUCCESS = r102;
        f183796a = new AIPreloadType[]{r100, r101, r102};
    }

    public static AIPreloadType valueOf(String r100) {
        return (AIPreloadType) r27.a.a(AIPreloadType.class, r100);
    }

    public static AIPreloadType[] values() {
        return (AIPreloadType[]) f183796a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AIPreloadType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
