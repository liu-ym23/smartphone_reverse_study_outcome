package com.bytedance.android.ec.sdk.helper;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/sdk/helper/ECommerceScene;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "COMMENT", "WERITE_COMMENT", "SHARE_VERIFY_SCHEMA", "SHARE_DURATION_MONITOR", "Share", "ec-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECommerceScene extends Enum<ECommerceScene> {
    public static final ECommerceScene COMMENT = null;
    public static final ECommerceScene SHARE_DURATION_MONITOR = null;
    public static final ECommerceScene SHARE_VERIFY_SCHEMA = null;
    public static final ECommerceScene Share = null;
    public static final ECommerceScene WERITE_COMMENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECommerceScene[] f48115a = null;
    private final String tag;

    static {
        ECommerceScene r100 = new ECommerceScene("COMMENT", 0, "Comment");
        COMMENT = r100;
        ECommerceScene r101 = new ECommerceScene("WERITE_COMMENT", 1, "WriteComment");
        WERITE_COMMENT = r101;
        ECommerceScene r102 = new ECommerceScene("SHARE_VERIFY_SCHEMA", 2, "Share_Verify_Schema");
        SHARE_VERIFY_SCHEMA = r102;
        ECommerceScene r103 = new ECommerceScene("SHARE_DURATION_MONITOR", 3, "Share_Duration_Monitor");
        SHARE_DURATION_MONITOR = r103;
        ECommerceScene r104 = new ECommerceScene("Share", 4, "Ecommerce_Share");
        Share = r104;
        f48115a = new ECommerceScene[]{r100, r101, r102, r103, r104};
    }

    public static ECommerceScene valueOf(String r100) {
        return (ECommerceScene) r27.a.a(ECommerceScene.class, r100);
    }

    public static ECommerceScene[] values() {
        return (ECommerceScene[]) f48115a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public ECommerceScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
