package com.bytedance.android.shopping.abscontainer.common_biz.constant;

import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/PageShape;", "", "", "rawValue", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "DEFAULT", "HALF", "FINAL", "ZERO_BUY", "REFUEL", "AUCTION", "DIRECT", "SUPERMARKET_HOUR", "RECHARGE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PageShape extends Enum<PageShape> {
    public static final PageShape AUCTION = null;
    public static final PageShape DEFAULT = null;
    public static final PageShape DIRECT = null;
    public static final PageShape FINAL = null;
    public static final PageShape HALF = null;
    public static final PageShape RECHARGE = null;
    public static final PageShape REFUEL = null;
    public static final PageShape SUPERMARKET_HOUR = null;
    public static final PageShape ZERO_BUY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageShape[] f164220a = null;
    private final String rawValue;

    public static PageShape valueOf(String r100) {
        return (PageShape) a.a(PageShape.class, r100);
    }

    public static PageShape[] values() {
        return (PageShape[]) f164220a.clone();
    }

    static {
        PageShape r100 = new PageShape("DEFAULT", 0, "0");
        DEFAULT = r100;
        PageShape r101 = new PageShape("HALF", 1, "1");
        HALF = r101;
        PageShape r102 = new PageShape("FINAL", 2, "2");
        FINAL = r102;
        PageShape r103 = new PageShape("ZERO_BUY", 3, "3");
        ZERO_BUY = r103;
        PageShape r104 = new PageShape("REFUEL", 4, "4");
        REFUEL = r104;
        PageShape r105 = new PageShape("AUCTION", 5, "5");
        AUCTION = r105;
        PageShape r106 = new PageShape("DIRECT", 6, "6");
        DIRECT = r106;
        PageShape r107 = new PageShape("SUPERMARKET_HOUR", 7, "8");
        SUPERMARKET_HOUR = r107;
        PageShape r108 = new PageShape("RECHARGE", 8, Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
        RECHARGE = r108;
        f164220a = new PageShape[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public PageShape(String r100, int r101, String r102) {
        super(r100, r101);
        this.rawValue = r102;
    }
}
