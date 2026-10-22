package com.bytedance.android.ec.hybrid.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/hybrid/ui/ECMediaType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "VIDEO", "LIVE", "PRODUCT", "INNERLIST", "DEEP_FEED", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECMediaType extends Enum<ECMediaType> {
    public static final ECMediaType DEEP_FEED = null;
    public static final ECMediaType INNERLIST = null;
    public static final ECMediaType LIVE = null;
    public static final ECMediaType PRODUCT = null;
    public static final ECMediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECMediaType[] f47673a = null;
    private final String type;

    static {
        ECMediaType r100 = new ECMediaType("VIDEO", 0, "video");
        VIDEO = r100;
        ECMediaType r101 = new ECMediaType("LIVE", 1, "live");
        LIVE = r101;
        ECMediaType r102 = new ECMediaType("PRODUCT", 2, "product");
        PRODUCT = r102;
        ECMediaType r103 = new ECMediaType("INNERLIST", 3, "innerlist");
        INNERLIST = r103;
        ECMediaType r104 = new ECMediaType("DEEP_FEED", 4, "deepFeed");
        DEEP_FEED = r104;
        f47673a = new ECMediaType[]{r100, r101, r102, r103, r104};
    }

    public static ECMediaType valueOf(String r100) {
        return (ECMediaType) r27.a.a(ECMediaType.class, r100);
    }

    public static ECMediaType[] values() {
        return (ECMediaType[]) f47673a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public ECMediaType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
