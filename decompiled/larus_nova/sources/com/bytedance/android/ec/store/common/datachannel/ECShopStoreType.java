package com.bytedance.android.ec.store.common.datachannel;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/store/common/datachannel/ECShopStoreType;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "sceneId", "getSceneId", "STORE", "WINDOW", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECShopStoreType extends Enum<ECShopStoreType> {
    public static final ECShopStoreType STORE = null;
    public static final ECShopStoreType WINDOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECShopStoreType[] f48224a = null;
    private final String des;
    private final String sceneId;

    static {
        ECShopStoreType r100 = new ECShopStoreType("STORE", 0, "shop", "1003");
        STORE = r100;
        ECShopStoreType r101 = new ECShopStoreType("WINDOW", 1, LiveEndPageData.TAG_WINDOW, "1004");
        WINDOW = r101;
        f48224a = new ECShopStoreType[]{r100, r101};
    }

    public static ECShopStoreType valueOf(String r100) {
        return (ECShopStoreType) a.a(ECShopStoreType.class, r100);
    }

    public static ECShopStoreType[] values() {
        return (ECShopStoreType[]) f48224a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public ECShopStoreType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.des = r102;
        this.sceneId = r103;
    }
}
