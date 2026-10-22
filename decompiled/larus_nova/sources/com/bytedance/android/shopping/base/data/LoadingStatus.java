package com.bytedance.android.shopping.base.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/base/data/LoadingStatus;", "", "SUCCESS", "ERROR", "LOADING", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadingStatus extends Enum<LoadingStatus> {
    public static final LoadingStatus ERROR = null;
    public static final LoadingStatus LOADING = null;
    public static final LoadingStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadingStatus[] f170693a = null;

    static {
        LoadingStatus r100 = new LoadingStatus("SUCCESS", 0);
        SUCCESS = r100;
        LoadingStatus r101 = new LoadingStatus("ERROR", 1);
        ERROR = r101;
        LoadingStatus r102 = new LoadingStatus("LOADING", 2);
        LOADING = r102;
        f170693a = new LoadingStatus[]{r100, r101, r102};
    }

    public static LoadingStatus valueOf(String r100) {
        return (LoadingStatus) a.a(LoadingStatus.class, r100);
    }

    public static LoadingStatus[] values() {
        return (LoadingStatus[]) f170693a.clone();
    }

    public LoadingStatus(String r100, int r101) {
        super(r100, r101);
    }
}
