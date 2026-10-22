package com.bytedance.android.shopping.abscontainer.common_biz.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/PageStartupStatus;", "", "", "rawValue", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "LOADING", "RENDERING", "RENDER_FINISH", "PAGE_ERROR", "PAY_SUCCESS", "PAY_FAIL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PageStartupStatus extends Enum<PageStartupStatus> {
    public static final PageStartupStatus LOADING = null;
    public static final PageStartupStatus PAGE_ERROR = null;
    public static final PageStartupStatus PAY_FAIL = null;
    public static final PageStartupStatus PAY_SUCCESS = null;
    public static final PageStartupStatus RENDERING = null;
    public static final PageStartupStatus RENDER_FINISH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageStartupStatus[] f164221a = null;
    private final String rawValue;

    static {
        PageStartupStatus r100 = new PageStartupStatus("LOADING", 0, "loading");
        LOADING = r100;
        PageStartupStatus r101 = new PageStartupStatus("RENDERING", 1, com.bytedance.android.shopping.buynow.data.model.PageStartupStatus.RENDERING);
        RENDERING = r101;
        PageStartupStatus r102 = new PageStartupStatus("RENDER_FINISH", 2, com.bytedance.android.shopping.buynow.data.model.PageStartupStatus.RENDER_FINISH);
        RENDER_FINISH = r102;
        PageStartupStatus r103 = new PageStartupStatus("PAGE_ERROR", 3, com.bytedance.android.shopping.buynow.data.model.PageStartupStatus.PAGE_ERROR);
        PAGE_ERROR = r103;
        PageStartupStatus r104 = new PageStartupStatus("PAY_SUCCESS", 4, com.bytedance.android.shopping.buynow.data.model.PageStartupStatus.PAY_SUCCESS);
        PAY_SUCCESS = r104;
        PageStartupStatus r105 = new PageStartupStatus("PAY_FAIL", 5, com.bytedance.android.shopping.buynow.data.model.PageStartupStatus.PAY_FAIL);
        PAY_FAIL = r105;
        f164221a = new PageStartupStatus[]{r100, r101, r102, r103, r104, r105};
    }

    public static PageStartupStatus valueOf(String r100) {
        return (PageStartupStatus) a.a(PageStartupStatus.class, r100);
    }

    public static PageStartupStatus[] values() {
        return (PageStartupStatus[]) f164221a.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public PageStartupStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.rawValue = r102;
    }
}
