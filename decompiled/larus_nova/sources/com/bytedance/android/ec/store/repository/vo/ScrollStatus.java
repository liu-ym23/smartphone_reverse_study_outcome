package com.bytedance.android.ec.store.repository.vo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/ScrollStatus;", "", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "CANT_SCROLL", "CAN_BUT_NOT_SCROLL", "SCROLLED", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ScrollStatus extends Enum<ScrollStatus> {
    public static final ScrollStatus CANT_SCROLL = null;
    public static final ScrollStatus CAN_BUT_NOT_SCROLL = null;
    public static final ScrollStatus SCROLLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScrollStatus[] f48402a = null;
    private final String status;

    static {
        ScrollStatus r100 = new ScrollStatus("CANT_SCROLL", 0, "0");
        CANT_SCROLL = r100;
        ScrollStatus r101 = new ScrollStatus("CAN_BUT_NOT_SCROLL", 1, "1");
        CAN_BUT_NOT_SCROLL = r101;
        ScrollStatus r102 = new ScrollStatus("SCROLLED", 2, "2");
        SCROLLED = r102;
        f48402a = new ScrollStatus[]{r100, r101, r102};
    }

    public static ScrollStatus valueOf(String r100) {
        return (ScrollStatus) r27.a.a(ScrollStatus.class, r100);
    }

    public static ScrollStatus[] values() {
        return (ScrollStatus[]) f48402a.clone();
    }

    public final String getStatus() {
        return this.status;
    }

    public ScrollStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.status = r102;
    }
}
