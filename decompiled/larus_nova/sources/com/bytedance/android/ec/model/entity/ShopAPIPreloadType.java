package com.bytedance.android.ec.model.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/model/entity/ShopAPIPreloadType;", "", "", "value", "I", "getValue", "()I", "NO_PRELOAD", "OTHERS_HOMEPAGE_AI_PRELOAD", "LAUNCH_AD_PRELOAD", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum ShopAPIPreloadType extends Enum<ShopAPIPreloadType> {
    public static final ShopAPIPreloadType LAUNCH_AD_PRELOAD = null;
    public static final ShopAPIPreloadType NO_PRELOAD = null;
    public static final ShopAPIPreloadType OTHERS_HOMEPAGE_AI_PRELOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShopAPIPreloadType[] f47860a = null;
    private final int value;

    static {
        ShopAPIPreloadType r100 = new ShopAPIPreloadType("NO_PRELOAD", 0, 0);
        NO_PRELOAD = r100;
        ShopAPIPreloadType r101 = new ShopAPIPreloadType("OTHERS_HOMEPAGE_AI_PRELOAD", 1, 1);
        OTHERS_HOMEPAGE_AI_PRELOAD = r101;
        ShopAPIPreloadType r102 = new ShopAPIPreloadType("LAUNCH_AD_PRELOAD", 2, 2);
        LAUNCH_AD_PRELOAD = r102;
        f47860a = new ShopAPIPreloadType[]{r100, r101, r102};
    }

    public static ShopAPIPreloadType valueOf(String r100) {
        return (ShopAPIPreloadType) a.a(ShopAPIPreloadType.class, r100);
    }

    public static ShopAPIPreloadType[] values() {
        return (ShopAPIPreloadType[]) f47860a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ShopAPIPreloadType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
