package com.bytedance.android.shopping.sku.inner.container;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/container/SkuYataQueryFrom;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "FIRST_SCREEN", "ERROR_RETRY", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SkuYataQueryFrom extends Enum<SkuYataQueryFrom> {
    public static final SkuYataQueryFrom ERROR_RETRY = null;
    public static final SkuYataQueryFrom FIRST_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkuYataQueryFrom[] f182829a = null;
    private final String value;

    static {
        SkuYataQueryFrom r100 = new SkuYataQueryFrom("FIRST_SCREEN", 0, "首屏");
        FIRST_SCREEN = r100;
        SkuYataQueryFrom r101 = new SkuYataQueryFrom("ERROR_RETRY", 1, "错误重试");
        ERROR_RETRY = r101;
        f182829a = new SkuYataQueryFrom[]{r100, r101};
    }

    public static SkuYataQueryFrom valueOf(String r100) {
        return (SkuYataQueryFrom) r27.a.a(SkuYataQueryFrom.class, r100);
    }

    public static SkuYataQueryFrom[] values() {
        return (SkuYataQueryFrom[]) f182829a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public SkuYataQueryFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
