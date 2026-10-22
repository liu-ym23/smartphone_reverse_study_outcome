package com.bytedance.android.live.profit.dress.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profit/dress/api/OpenAssetPlayErrorType;", "", "", "value", "I", "getValue", "()I", "Success", "Unknown", "DressIdNotFound", "AssetNotFound", "PlayError", "Other", "SomeIsNull", "UserInfoRenderFailed", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum OpenAssetPlayErrorType extends Enum<OpenAssetPlayErrorType> {
    public static final OpenAssetPlayErrorType AssetNotFound = null;
    public static final OpenAssetPlayErrorType DressIdNotFound = null;
    public static final OpenAssetPlayErrorType Other = null;
    public static final OpenAssetPlayErrorType PlayError = null;
    public static final OpenAssetPlayErrorType SomeIsNull = null;
    public static final OpenAssetPlayErrorType Success = null;
    public static final OpenAssetPlayErrorType Unknown = null;
    public static final OpenAssetPlayErrorType UserInfoRenderFailed = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenAssetPlayErrorType[] f87080a = null;
    private final int value;

    public static OpenAssetPlayErrorType valueOf(String r100) {
        return (OpenAssetPlayErrorType) a.a(OpenAssetPlayErrorType.class, r100);
    }

    public static OpenAssetPlayErrorType[] values() {
        return (OpenAssetPlayErrorType[]) f87080a.clone();
    }

    static {
        OpenAssetPlayErrorType r100 = new OpenAssetPlayErrorType("Success", 0, 0);
        Success = r100;
        OpenAssetPlayErrorType r101 = new OpenAssetPlayErrorType("Unknown", 1, 1);
        Unknown = r101;
        OpenAssetPlayErrorType r102 = new OpenAssetPlayErrorType("DressIdNotFound", 2, 2);
        DressIdNotFound = r102;
        OpenAssetPlayErrorType r103 = new OpenAssetPlayErrorType("AssetNotFound", 3, 3);
        AssetNotFound = r103;
        OpenAssetPlayErrorType r104 = new OpenAssetPlayErrorType("PlayError", 4, 4);
        PlayError = r104;
        OpenAssetPlayErrorType r105 = new OpenAssetPlayErrorType("Other", 5, 1000);
        Other = r105;
        OpenAssetPlayErrorType r106 = new OpenAssetPlayErrorType("SomeIsNull", 6, 1001);
        SomeIsNull = r106;
        OpenAssetPlayErrorType r107 = new OpenAssetPlayErrorType("UserInfoRenderFailed", 7, 1003);
        UserInfoRenderFailed = r107;
        f87080a = new OpenAssetPlayErrorType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final int getValue() {
        return this.value;
    }

    public OpenAssetPlayErrorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
