package com.bytedance.android.live.feature.api;

import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/feature/api/FeatureType;", "", "", "value", "I", "getValue", "()I", "STATIC", BannerBizName.DYNAMIC, "MONITOR", "DYNAMIC_MONITOR", "livefeature-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FeatureType extends Enum<FeatureType> {
    public static final FeatureType DYNAMIC = null;
    public static final FeatureType DYNAMIC_MONITOR = null;
    public static final FeatureType MONITOR = null;
    public static final FeatureType STATIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeatureType[] f68989a = null;
    private final int value;

    static {
        FeatureType r100 = new FeatureType("STATIC", 0, 0);
        STATIC = r100;
        FeatureType r101 = new FeatureType(BannerBizName.DYNAMIC, 1, 1);
        DYNAMIC = r101;
        FeatureType r102 = new FeatureType("MONITOR", 2, -1);
        MONITOR = r102;
        FeatureType r103 = new FeatureType("DYNAMIC_MONITOR", 3, 2);
        DYNAMIC_MONITOR = r103;
        f68989a = new FeatureType[]{r100, r101, r102, r103};
    }

    public static FeatureType valueOf(String r100) {
        return (FeatureType) a.a(FeatureType.class, r100);
    }

    public static FeatureType[] values() {
        return (FeatureType[]) f68989a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public FeatureType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
