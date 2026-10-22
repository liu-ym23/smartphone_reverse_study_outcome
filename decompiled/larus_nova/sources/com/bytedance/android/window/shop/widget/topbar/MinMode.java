package com.bytedance.android.window.shop.widget.topbar;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/widget/topbar/MinMode;", "", "ICON", CardAdapter.TEXT, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MinMode extends Enum<MinMode> {
    public static final MinMode ICON = null;
    public static final MinMode TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MinMode[] f190121a = null;

    static {
        MinMode r100 = new MinMode("ICON", 0);
        ICON = r100;
        MinMode r101 = new MinMode(CardAdapter.TEXT, 1);
        TEXT = r101;
        f190121a = new MinMode[]{r100, r101};
    }

    public static MinMode valueOf(String r100) {
        return (MinMode) a.a(MinMode.class, r100);
    }

    public static MinMode[] values() {
        return (MinMode[]) f190121a.clone();
    }

    public MinMode(String r100, int r101) {
        super(r100, r101);
    }
}
