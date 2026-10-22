package com.bytedance.android.shopping.collect.common.controller;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/collect/common/controller/CollectHandleEventOpportunity;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "RECEIVE_PRODUCTS_CLEAN_UP", "PAGE_APPEAR_START", "PAGE_APPEAR_RESUME", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CollectHandleEventOpportunity extends Enum<CollectHandleEventOpportunity> {
    public static final CollectHandleEventOpportunity PAGE_APPEAR_RESUME = null;
    public static final CollectHandleEventOpportunity PAGE_APPEAR_START = null;
    public static final CollectHandleEventOpportunity RECEIVE_PRODUCTS_CLEAN_UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CollectHandleEventOpportunity[] f172095a = null;
    private final String value;

    static {
        CollectHandleEventOpportunity r100 = new CollectHandleEventOpportunity("RECEIVE_PRODUCTS_CLEAN_UP", 0, "receive_products_clean_up");
        RECEIVE_PRODUCTS_CLEAN_UP = r100;
        CollectHandleEventOpportunity r101 = new CollectHandleEventOpportunity("PAGE_APPEAR_START", 1, "page_appear_start");
        PAGE_APPEAR_START = r101;
        CollectHandleEventOpportunity r102 = new CollectHandleEventOpportunity("PAGE_APPEAR_RESUME", 2, "page_appear_resume");
        PAGE_APPEAR_RESUME = r102;
        f172095a = new CollectHandleEventOpportunity[]{r100, r101, r102};
    }

    public static CollectHandleEventOpportunity valueOf(String r100) {
        return (CollectHandleEventOpportunity) a.a(CollectHandleEventOpportunity.class, r100);
    }

    public static CollectHandleEventOpportunity[] values() {
        return (CollectHandleEventOpportunity[]) f172095a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public CollectHandleEventOpportunity(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
