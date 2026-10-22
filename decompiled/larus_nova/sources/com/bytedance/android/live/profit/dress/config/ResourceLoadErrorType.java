package com.bytedance.android.live.profit.dress.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/ResourceLoadErrorType;", "", "", "code", "I", "getCode", "()I", "Succeed", "Unknown", "DressNotFound", "DressConfigNotFound", "DownloadFailed", "DownloadPartFailed", "NoResourceToLoad", "ExistedTypeMismatch", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ResourceLoadErrorType extends Enum<ResourceLoadErrorType> {
    public static final ResourceLoadErrorType DownloadFailed = null;
    public static final ResourceLoadErrorType DownloadPartFailed = null;
    public static final ResourceLoadErrorType DressConfigNotFound = null;
    public static final ResourceLoadErrorType DressNotFound = null;
    public static final ResourceLoadErrorType ExistedTypeMismatch = null;
    public static final ResourceLoadErrorType NoResourceToLoad = null;
    public static final ResourceLoadErrorType Succeed = null;
    public static final ResourceLoadErrorType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceLoadErrorType[] f87093a = null;
    private final int code;

    public static ResourceLoadErrorType valueOf(String r100) {
        return (ResourceLoadErrorType) r27.a.a(ResourceLoadErrorType.class, r100);
    }

    public static ResourceLoadErrorType[] values() {
        return (ResourceLoadErrorType[]) f87093a.clone();
    }

    static {
        ResourceLoadErrorType r100 = new ResourceLoadErrorType("Succeed", 0, 0);
        Succeed = r100;
        ResourceLoadErrorType r101 = new ResourceLoadErrorType("Unknown", 1, 1);
        Unknown = r101;
        ResourceLoadErrorType r102 = new ResourceLoadErrorType("DressNotFound", 2, 2);
        DressNotFound = r102;
        ResourceLoadErrorType r103 = new ResourceLoadErrorType("DressConfigNotFound", 3, 3);
        DressConfigNotFound = r103;
        ResourceLoadErrorType r104 = new ResourceLoadErrorType("DownloadFailed", 4, 4);
        DownloadFailed = r104;
        ResourceLoadErrorType r105 = new ResourceLoadErrorType("DownloadPartFailed", 5, 5);
        DownloadPartFailed = r105;
        ResourceLoadErrorType r106 = new ResourceLoadErrorType("NoResourceToLoad", 6, 1000);
        NoResourceToLoad = r106;
        ResourceLoadErrorType r107 = new ResourceLoadErrorType("ExistedTypeMismatch", 7, 1001);
        ExistedTypeMismatch = r107;
        f87093a = new ResourceLoadErrorType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final int getCode() {
        return this.code;
    }

    public ResourceLoadErrorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
