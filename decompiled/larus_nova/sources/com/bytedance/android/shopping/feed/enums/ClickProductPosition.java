package com.bytedance.android.shopping.feed.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/enums/ClickProductPosition;", "", "", "position", "Ljava/lang/String;", "getPosition", "()Ljava/lang/String;", "CLICK_AREA_BUTTON", "CLICK_AREA_PIC", "CLICK_AREA_BLANK", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ClickProductPosition extends Enum<ClickProductPosition> {
    public static final ClickProductPosition CLICK_AREA_BLANK = null;
    public static final ClickProductPosition CLICK_AREA_BUTTON = null;
    public static final ClickProductPosition CLICK_AREA_PIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClickProductPosition[] f174440a = null;
    private final String position;

    static {
        ClickProductPosition r100 = new ClickProductPosition("CLICK_AREA_BUTTON", 0, "button");
        CLICK_AREA_BUTTON = r100;
        ClickProductPosition r101 = new ClickProductPosition("CLICK_AREA_PIC", 1, "pic");
        CLICK_AREA_PIC = r101;
        ClickProductPosition r102 = new ClickProductPosition("CLICK_AREA_BLANK", 2, "blank");
        CLICK_AREA_BLANK = r102;
        f174440a = new ClickProductPosition[]{r100, r101, r102};
    }

    public static ClickProductPosition valueOf(String r100) {
        return (ClickProductPosition) a.a(ClickProductPosition.class, r100);
    }

    public static ClickProductPosition[] values() {
        return (ClickProductPosition[]) f174440a.clone();
    }

    public final String getPosition() {
        return this.position;
    }

    public ClickProductPosition(String r100, int r101, String r102) {
        super(r100, r101);
        this.position = r102;
    }
}
