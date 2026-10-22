package com.bytedance.android.live.broadcast.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/BubblePosition;", "", "Bottom", "Top", "livebroadcast-shared-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BubblePosition extends Enum<BubblePosition> {
    public static final BubblePosition Bottom = null;
    public static final BubblePosition Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BubblePosition[] f58965a = null;

    static {
        BubblePosition r100 = new BubblePosition("Bottom", 0);
        Bottom = r100;
        BubblePosition r101 = new BubblePosition("Top", 1);
        Top = r101;
        f58965a = new BubblePosition[]{r100, r101};
    }

    public static BubblePosition valueOf(String r100) {
        return (BubblePosition) a.a(BubblePosition.class, r100);
    }

    public static BubblePosition[] values() {
        return (BubblePosition[]) f58965a.clone();
    }

    public BubblePosition(String r100, int r101) {
        super(r100, r101);
    }
}
