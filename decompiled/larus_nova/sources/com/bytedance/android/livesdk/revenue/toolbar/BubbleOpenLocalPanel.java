package com.bytedance.android.livesdk.revenue.toolbar;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/toolbar/BubbleOpenLocalPanel;", "", "PkPanel", "LinkPanel", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BubbleOpenLocalPanel extends Enum<BubbleOpenLocalPanel> {
    public static final BubbleOpenLocalPanel LinkPanel = null;
    public static final BubbleOpenLocalPanel PkPanel = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BubbleOpenLocalPanel[] f157518a = null;

    static {
        BubbleOpenLocalPanel r100 = new BubbleOpenLocalPanel("PkPanel", 0);
        PkPanel = r100;
        BubbleOpenLocalPanel r101 = new BubbleOpenLocalPanel("LinkPanel", 1);
        LinkPanel = r101;
        f157518a = new BubbleOpenLocalPanel[]{r100, r101};
    }

    public static BubbleOpenLocalPanel valueOf(String r100) {
        return (BubbleOpenLocalPanel) a.a(BubbleOpenLocalPanel.class, r100);
    }

    public static BubbleOpenLocalPanel[] values() {
        return (BubbleOpenLocalPanel[]) f157518a.clone();
    }

    public BubbleOpenLocalPanel(String r100, int r101) {
        super(r100, r101);
    }
}
