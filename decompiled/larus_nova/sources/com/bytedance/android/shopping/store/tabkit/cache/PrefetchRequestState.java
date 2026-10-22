package com.bytedance.android.shopping.store.tabkit.cache;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/cache/PrefetchRequestState;", "", "", "value", "I", "getValue", "()I", "NO_MATCH", "NO_STORE", "MATCH_SUCCESS_NORMAL", "MATCH_SUCCESS_EXPIRED", "MATCH_QUERY_FAILED", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PrefetchRequestState extends Enum<PrefetchRequestState> {
    public static final PrefetchRequestState MATCH_QUERY_FAILED = null;
    public static final PrefetchRequestState MATCH_SUCCESS_EXPIRED = null;
    public static final PrefetchRequestState MATCH_SUCCESS_NORMAL = null;
    public static final PrefetchRequestState NO_MATCH = null;
    public static final PrefetchRequestState NO_STORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PrefetchRequestState[] f186632a = null;
    private final int value;

    static {
        PrefetchRequestState r100 = new PrefetchRequestState("NO_MATCH", 0, -1);
        NO_MATCH = r100;
        PrefetchRequestState r101 = new PrefetchRequestState("NO_STORE", 1, 0);
        NO_STORE = r101;
        PrefetchRequestState r102 = new PrefetchRequestState("MATCH_SUCCESS_NORMAL", 2, 1);
        MATCH_SUCCESS_NORMAL = r102;
        PrefetchRequestState r103 = new PrefetchRequestState("MATCH_SUCCESS_EXPIRED", 3, 2);
        MATCH_SUCCESS_EXPIRED = r103;
        PrefetchRequestState r104 = new PrefetchRequestState("MATCH_QUERY_FAILED", 4, 3);
        MATCH_QUERY_FAILED = r104;
        f186632a = new PrefetchRequestState[]{r100, r101, r102, r103, r104};
    }

    public static PrefetchRequestState valueOf(String r100) {
        return (PrefetchRequestState) r27.a.a(PrefetchRequestState.class, r100);
    }

    public static PrefetchRequestState[] values() {
        return (PrefetchRequestState[]) f186632a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PrefetchRequestState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
