package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/repository/PDPRefreshStatus;", "", "SUCCESS", "FAILED", "CANCELED", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PDPRefreshStatus extends Enum<PDPRefreshStatus> {
    public static final PDPRefreshStatus CANCELED = null;
    public static final PDPRefreshStatus FAILED = null;
    public static final PDPRefreshStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PDPRefreshStatus[] f181864a = null;

    static {
        PDPRefreshStatus r100 = new PDPRefreshStatus("SUCCESS", 0);
        SUCCESS = r100;
        PDPRefreshStatus r101 = new PDPRefreshStatus("FAILED", 1);
        FAILED = r101;
        PDPRefreshStatus r102 = new PDPRefreshStatus("CANCELED", 2);
        CANCELED = r102;
        f181864a = new PDPRefreshStatus[]{r100, r101, r102};
    }

    public static PDPRefreshStatus valueOf(String r100) {
        return (PDPRefreshStatus) r27.a.a(PDPRefreshStatus.class, r100);
    }

    public static PDPRefreshStatus[] values() {
        return (PDPRefreshStatus[]) f181864a.clone();
    }

    public PDPRefreshStatus(String r100, int r101) {
        super(r100, r101);
    }
}
