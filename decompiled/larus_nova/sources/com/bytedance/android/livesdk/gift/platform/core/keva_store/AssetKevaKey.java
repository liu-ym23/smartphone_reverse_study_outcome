package com.bytedance.android.livesdk.gift.platform.core.keva_store;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/keva_store/AssetKevaKey;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "RESOURCE_DELETE_WHITE_LIST", "RESOURCE_DOWNLOAD_BLACK_LIST", "RESOURCE_USED_INFORMATION_RECORD", "RESOURCE_LRU_MD5_CACHE", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AssetKevaKey extends Enum<AssetKevaKey> {
    public static final AssetKevaKey RESOURCE_DELETE_WHITE_LIST = null;
    public static final AssetKevaKey RESOURCE_DOWNLOAD_BLACK_LIST = null;
    public static final AssetKevaKey RESOURCE_LRU_MD5_CACHE = null;
    public static final AssetKevaKey RESOURCE_USED_INFORMATION_RECORD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AssetKevaKey[] f130724a = null;
    private final String key;

    static {
        AssetKevaKey r100 = new AssetKevaKey("RESOURCE_DELETE_WHITE_LIST", 0, "live_asset_delete_white_list");
        RESOURCE_DELETE_WHITE_LIST = r100;
        AssetKevaKey r101 = new AssetKevaKey("RESOURCE_DOWNLOAD_BLACK_LIST", 1, "live_asset_download_black_list");
        RESOURCE_DOWNLOAD_BLACK_LIST = r101;
        AssetKevaKey r102 = new AssetKevaKey("RESOURCE_USED_INFORMATION_RECORD", 2, "live_asset_used_information_record");
        RESOURCE_USED_INFORMATION_RECORD = r102;
        AssetKevaKey r103 = new AssetKevaKey("RESOURCE_LRU_MD5_CACHE", 3, "live_asset_lru_md5_cache");
        RESOURCE_LRU_MD5_CACHE = r103;
        f130724a = new AssetKevaKey[]{r100, r101, r102, r103};
    }

    public static AssetKevaKey valueOf(String r100) {
        return (AssetKevaKey) r27.a.a(AssetKevaKey.class, r100);
    }

    public static AssetKevaKey[] values() {
        return (AssetKevaKey[]) f130724a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public AssetKevaKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
