package com.bytedance.android.ec.adapter.api.strategy;

import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/strategy/FeatureType;", "", "STATIC", BannerBizName.DYNAMIC, "MONITOR", "DYNAMIC_MONITOR", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FeatureType extends Enum<FeatureType> {
    public static final FeatureType DYNAMIC = null;
    public static final FeatureType DYNAMIC_MONITOR = null;
    public static final FeatureType MONITOR = null;
    public static final FeatureType STATIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeatureType[] f42717a = null;

    static {
        FeatureType r100 = new FeatureType("STATIC", 0);
        STATIC = r100;
        FeatureType r101 = new FeatureType(BannerBizName.DYNAMIC, 1);
        DYNAMIC = r101;
        FeatureType r102 = new FeatureType("MONITOR", 2);
        MONITOR = r102;
        FeatureType r103 = new FeatureType("DYNAMIC_MONITOR", 3);
        DYNAMIC_MONITOR = r103;
        f42717a = new FeatureType[]{r100, r101, r102, r103};
    }

    public static FeatureType valueOf(String r100) {
        return (FeatureType) a.a(FeatureType.class, r100);
    }

    public static FeatureType[] values() {
        return (FeatureType[]) f42717a.clone();
    }

    public FeatureType(String r100, int r101) {
        super(r100, r101);
    }
}
