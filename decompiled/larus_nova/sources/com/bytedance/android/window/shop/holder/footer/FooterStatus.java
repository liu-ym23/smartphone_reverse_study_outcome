package com.bytedance.android.window.shop.holder.footer;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/holder/footer/FooterStatus;", "", "LOADING", "NO_MORE", "NOTHING", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FooterStatus extends Enum<FooterStatus> {
    public static final FooterStatus LOADING = null;
    public static final FooterStatus NOTHING = null;
    public static final FooterStatus NO_MORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FooterStatus[] f187965a = null;

    static {
        FooterStatus r100 = new FooterStatus("LOADING", 0);
        LOADING = r100;
        FooterStatus r101 = new FooterStatus("NO_MORE", 1);
        NO_MORE = r101;
        FooterStatus r102 = new FooterStatus("NOTHING", 2);
        NOTHING = r102;
        f187965a = new FooterStatus[]{r100, r101, r102};
    }

    public static FooterStatus valueOf(String r100) {
        return (FooterStatus) r27.a.a(FooterStatus.class, r100);
    }

    public static FooterStatus[] values() {
        return (FooterStatus[]) f187965a.clone();
    }

    public FooterStatus(String r100, int r101) {
        super(r100, r101);
    }
}
