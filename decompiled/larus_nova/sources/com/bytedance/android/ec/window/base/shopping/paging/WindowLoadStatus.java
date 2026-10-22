package com.bytedance.android.ec.window.base.shopping.paging;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/window/base/shopping/paging/WindowLoadStatus;", "", "Initialize", "InitializeSuccess", "InitializeError", "InitializeEmpty", "LoadMoreIn", "LoadMoreSuccess", "LoadMoreError", "LoadMoreEnd", "Refresh", "RefreshError", "RefreshWhenError", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowLoadStatus extends Enum<WindowLoadStatus> {
    public static final WindowLoadStatus Initialize = null;
    public static final WindowLoadStatus InitializeEmpty = null;
    public static final WindowLoadStatus InitializeError = null;
    public static final WindowLoadStatus InitializeSuccess = null;
    public static final WindowLoadStatus LoadMoreEnd = null;
    public static final WindowLoadStatus LoadMoreError = null;
    public static final WindowLoadStatus LoadMoreIn = null;
    public static final WindowLoadStatus LoadMoreSuccess = null;
    public static final WindowLoadStatus Refresh = null;
    public static final WindowLoadStatus RefreshError = null;
    public static final WindowLoadStatus RefreshWhenError = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowLoadStatus[] f49673a = null;

    static {
        WindowLoadStatus r100 = new WindowLoadStatus("Initialize", 0);
        Initialize = r100;
        WindowLoadStatus r101 = new WindowLoadStatus("InitializeSuccess", 1);
        InitializeSuccess = r101;
        WindowLoadStatus r102 = new WindowLoadStatus("InitializeError", 2);
        InitializeError = r102;
        WindowLoadStatus r103 = new WindowLoadStatus("InitializeEmpty", 3);
        InitializeEmpty = r103;
        WindowLoadStatus r104 = new WindowLoadStatus("LoadMoreIn", 4);
        LoadMoreIn = r104;
        WindowLoadStatus r105 = new WindowLoadStatus("LoadMoreSuccess", 5);
        LoadMoreSuccess = r105;
        WindowLoadStatus r106 = new WindowLoadStatus("LoadMoreError", 6);
        LoadMoreError = r106;
        WindowLoadStatus r107 = new WindowLoadStatus("LoadMoreEnd", 7);
        LoadMoreEnd = r107;
        WindowLoadStatus r108 = new WindowLoadStatus("Refresh", 8);
        Refresh = r108;
        WindowLoadStatus r109 = new WindowLoadStatus("RefreshError", 9);
        RefreshError = r109;
        WindowLoadStatus r110 = new WindowLoadStatus("RefreshWhenError", 10);
        RefreshWhenError = r110;
        f49673a = new WindowLoadStatus[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public static WindowLoadStatus valueOf(String r100) {
        return (WindowLoadStatus) a.a(WindowLoadStatus.class, r100);
    }

    public static WindowLoadStatus[] values() {
        return (WindowLoadStatus[]) f49673a.clone();
    }

    public WindowLoadStatus(String r100, int r101) {
        super(r100, r101);
    }
}
