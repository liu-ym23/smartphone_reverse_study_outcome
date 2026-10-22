package com.bytedance.android.shopping.api.mall;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"com/bytedance/android/shopping/api/mall/IECNativeContainerLoadState$MallState", "", "Lcom/bytedance/android/shopping/api/mall/IECNativeContainerLoadState$MallState;", ErrorCode.INIT, "LOADING", "CACHE_RENDER", "FMP", "ERROR", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IECNativeContainerLoadState$MallState extends Enum<IECNativeContainerLoadState$MallState> {
    public static final IECNativeContainerLoadState$MallState CACHE_RENDER = null;
    public static final IECNativeContainerLoadState$MallState ERROR = null;
    public static final IECNativeContainerLoadState$MallState FMP = null;
    public static final IECNativeContainerLoadState$MallState INIT = null;
    public static final IECNativeContainerLoadState$MallState LOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IECNativeContainerLoadState$MallState[] f170208a = null;

    static {
        IECNativeContainerLoadState$MallState r100 = new IECNativeContainerLoadState$MallState(ErrorCode.INIT, 0);
        INIT = r100;
        IECNativeContainerLoadState$MallState r101 = new IECNativeContainerLoadState$MallState("LOADING", 1);
        LOADING = r101;
        IECNativeContainerLoadState$MallState r102 = new IECNativeContainerLoadState$MallState("CACHE_RENDER", 2);
        CACHE_RENDER = r102;
        IECNativeContainerLoadState$MallState r103 = new IECNativeContainerLoadState$MallState("FMP", 3);
        FMP = r103;
        IECNativeContainerLoadState$MallState r104 = new IECNativeContainerLoadState$MallState("ERROR", 4);
        ERROR = r104;
        f170208a = new IECNativeContainerLoadState$MallState[]{r100, r101, r102, r103, r104};
    }

    public static IECNativeContainerLoadState$MallState valueOf(String r100) {
        return (IECNativeContainerLoadState$MallState) r27.a.a(IECNativeContainerLoadState$MallState.class, r100);
    }

    public static IECNativeContainerLoadState$MallState[] values() {
        return (IECNativeContainerLoadState$MallState[]) f170208a.clone();
    }

    public IECNativeContainerLoadState$MallState(String r100, int r101) {
        super(r100, r101);
    }
}
