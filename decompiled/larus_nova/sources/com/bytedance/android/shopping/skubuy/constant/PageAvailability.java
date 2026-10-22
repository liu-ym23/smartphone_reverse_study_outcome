package com.bytedance.android.shopping.skubuy.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/constant/PageAvailability;", "", "", "rawValue", "I", "getRawValue", "()I", "FAILED", "ALL_FOR_FORBIDDEN", "SUCCESS", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PageAvailability extends Enum<PageAvailability> {
    public static final PageAvailability ALL_FOR_FORBIDDEN = null;
    public static final PageAvailability FAILED = null;
    public static final PageAvailability SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageAvailability[] f183116a = null;
    private final int rawValue;

    static {
        PageAvailability r100 = new PageAvailability("FAILED", 0, 0);
        FAILED = r100;
        PageAvailability r101 = new PageAvailability("ALL_FOR_FORBIDDEN", 1, 1);
        ALL_FOR_FORBIDDEN = r101;
        PageAvailability r102 = new PageAvailability("SUCCESS", 2, 2);
        SUCCESS = r102;
        f183116a = new PageAvailability[]{r100, r101, r102};
    }

    public static PageAvailability valueOf(String r100) {
        return (PageAvailability) a.a(PageAvailability.class, r100);
    }

    public static PageAvailability[] values() {
        return (PageAvailability[]) f183116a.clone();
    }

    public final int getRawValue() {
        return this.rawValue;
    }

    public PageAvailability(String r100, int r101, int r102) {
        super(r100, r101);
        this.rawValue = r102;
    }
}
