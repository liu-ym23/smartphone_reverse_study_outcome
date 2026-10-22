package com.bytedance.android.shopping.store.restore;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/restore/InvalidateReason;", "", "Expired", "Disabled", "TabConfigChanged", "Unknown", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InvalidateReason extends Enum<InvalidateReason> {
    public static final InvalidateReason Disabled = null;
    public static final InvalidateReason Expired = null;
    public static final InvalidateReason TabConfigChanged = null;
    public static final InvalidateReason Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InvalidateReason[] f185787a = null;

    static {
        InvalidateReason r100 = new InvalidateReason("Expired", 0);
        Expired = r100;
        InvalidateReason r101 = new InvalidateReason("Disabled", 1);
        Disabled = r101;
        InvalidateReason r102 = new InvalidateReason("TabConfigChanged", 2);
        TabConfigChanged = r102;
        InvalidateReason r103 = new InvalidateReason("Unknown", 3);
        Unknown = r103;
        f185787a = new InvalidateReason[]{r100, r101, r102, r103};
    }

    public static InvalidateReason valueOf(String r100) {
        return (InvalidateReason) r27.a.a(InvalidateReason.class, r100);
    }

    public static InvalidateReason[] values() {
        return (InvalidateReason[]) f185787a.clone();
    }

    public InvalidateReason(String r100, int r101) {
        super(r100, r101);
    }
}
