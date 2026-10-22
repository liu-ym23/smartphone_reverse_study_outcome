package com.bytedance.android.live.schema.convert;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/schema/convert/HybridType;", "", "COMMON", "H5", "Lynx", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HybridType extends Enum<HybridType> {
    public static final HybridType COMMON = null;
    public static final HybridType H5 = null;
    public static final HybridType Lynx = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HybridType[] f100508a = null;

    static {
        HybridType r100 = new HybridType("COMMON", 0);
        COMMON = r100;
        HybridType r101 = new HybridType("H5", 1);
        H5 = r101;
        HybridType r102 = new HybridType("Lynx", 2);
        Lynx = r102;
        f100508a = new HybridType[]{r100, r101, r102};
    }

    public static HybridType valueOf(String r100) {
        return (HybridType) a.a(HybridType.class, r100);
    }

    public static HybridType[] values() {
        return (HybridType[]) f100508a.clone();
    }

    public HybridType(String r100, int r101) {
        super(r100, r101);
    }
}
