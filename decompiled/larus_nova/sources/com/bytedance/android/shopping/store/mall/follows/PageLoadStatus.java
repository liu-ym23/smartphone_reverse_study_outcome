package com.bytedance.android.shopping.store.mall.follows;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/PageLoadStatus;", "", "", "value", "I", "getValue", "()I", "SUCCESS", "EMPTY", "ERROR", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PageLoadStatus extends Enum<PageLoadStatus> {
    public static final PageLoadStatus EMPTY = null;
    public static final PageLoadStatus ERROR = null;
    public static final PageLoadStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageLoadStatus[] f185528a = null;
    private final int value;

    static {
        PageLoadStatus r100 = new PageLoadStatus("SUCCESS", 0, 0);
        SUCCESS = r100;
        PageLoadStatus r101 = new PageLoadStatus("EMPTY", 1, 1);
        EMPTY = r101;
        PageLoadStatus r102 = new PageLoadStatus("ERROR", 2, 2);
        ERROR = r102;
        f185528a = new PageLoadStatus[]{r100, r101, r102};
    }

    public static PageLoadStatus valueOf(String r100) {
        return (PageLoadStatus) a.a(PageLoadStatus.class, r100);
    }

    public static PageLoadStatus[] values() {
        return (PageLoadStatus[]) f185528a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PageLoadStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
