package com.bytedance.android.shopping.sku.inner.controller;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/controller/SkuBizErrorCode;", "", "", "code", "I", "getCode", "()I", "Invalid", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SkuBizErrorCode extends Enum<SkuBizErrorCode> {
    public static final SkuBizErrorCode Invalid = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkuBizErrorCode[] f182878a = null;
    private final int code;

    static {
        SkuBizErrorCode r100 = new SkuBizErrorCode();
        Invalid = r100;
        f182878a = new SkuBizErrorCode[]{r100};
    }

    public static SkuBizErrorCode valueOf(String r100) {
        return (SkuBizErrorCode) r27.a.a(SkuBizErrorCode.class, r100);
    }

    public static SkuBizErrorCode[] values() {
        return (SkuBizErrorCode[]) f182878a.clone();
    }

    public SkuBizErrorCode() {
        super("Invalid", 0);
        this.code = 1002;
    }

    public final int getCode() {
        return this.code;
    }
}
