package com.bytedance.android.live.revenue.platform.hybrid.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/hybrid/api/HybridType;", "", "H5", "LYNX", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum HybridType extends Enum<HybridType> {
    public static final HybridType H5 = null;
    public static final HybridType LYNX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HybridType[] f91377a = null;

    static {
        HybridType r100 = new HybridType("H5", 0);
        H5 = r100;
        HybridType r101 = new HybridType("LYNX", 1);
        LYNX = r101;
        f91377a = new HybridType[]{r100, r101};
    }

    public static HybridType valueOf(String r100) {
        return (HybridType) a.a(HybridType.class, r100);
    }

    public static HybridType[] values() {
        return (HybridType[]) f91377a.clone();
    }

    public HybridType(String r100, int r101) {
        super(r100, r101);
    }
}
