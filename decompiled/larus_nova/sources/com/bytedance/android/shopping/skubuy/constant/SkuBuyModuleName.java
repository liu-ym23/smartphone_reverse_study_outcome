package com.bytedance.android.shopping.skubuy.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/constant/SkuBuyModuleName;", "", "", "rawValue", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "PAGE_LIFECYCLE_TRACK_MODULE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SkuBuyModuleName extends Enum<SkuBuyModuleName> {
    public static final SkuBuyModuleName PAGE_LIFECYCLE_TRACK_MODULE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkuBuyModuleName[] f183117a = null;
    private final String rawValue;

    static {
        SkuBuyModuleName r100 = new SkuBuyModuleName();
        PAGE_LIFECYCLE_TRACK_MODULE = r100;
        f183117a = new SkuBuyModuleName[]{r100};
    }

    public static SkuBuyModuleName valueOf(String r100) {
        return (SkuBuyModuleName) a.a(SkuBuyModuleName.class, r100);
    }

    public static SkuBuyModuleName[] values() {
        return (SkuBuyModuleName[]) f183117a.clone();
    }

    public SkuBuyModuleName() {
        super("PAGE_LIFECYCLE_TRACK_MODULE", 0);
        this.rawValue = "PageLifecycleTrackModule";
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
