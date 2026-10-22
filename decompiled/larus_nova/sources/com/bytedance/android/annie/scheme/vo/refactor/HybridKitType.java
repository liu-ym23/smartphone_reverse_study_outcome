package com.bytedance.android.annie.scheme.vo.refactor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/HybridKitType;", "", "UNKNOWN", "WEB", "LYNX", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum HybridKitType extends Enum<HybridKitType> {
    public static final HybridKitType LYNX = null;
    public static final HybridKitType UNKNOWN = null;
    public static final HybridKitType WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HybridKitType[] f39811a = null;

    public static HybridKitType valueOf(String r100) {
        return (HybridKitType) a.a(HybridKitType.class, r100);
    }

    public static HybridKitType[] values() {
        return (HybridKitType[]) f39811a.clone();
    }

    static {
        HybridKitType r100 = new HybridKitType("UNKNOWN", 0);
        UNKNOWN = r100;
        HybridKitType r101 = new HybridKitType("WEB", 1);
        WEB = r101;
        HybridKitType r102 = new HybridKitType("LYNX", 2);
        LYNX = r102;
        f39811a = new HybridKitType[]{r100, r101, r102};
    }

    public HybridKitType(String r100, int r101) {
        super(r100, r101);
    }
}
