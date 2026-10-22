package com.bytedance.android.live.profit.scoreboard;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/LinkMode;", "", "UN_KNOW", "SINGlE", "TWIN", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkMode extends Enum<LinkMode> {
    public static final LinkMode SINGlE = null;
    public static final LinkMode TWIN = null;
    public static final LinkMode UN_KNOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkMode[] f88795a = null;

    static {
        LinkMode r100 = new LinkMode("UN_KNOW", 0);
        UN_KNOW = r100;
        LinkMode r101 = new LinkMode("SINGlE", 1);
        SINGlE = r101;
        LinkMode r102 = new LinkMode("TWIN", 2);
        TWIN = r102;
        f88795a = new LinkMode[]{r100, r101, r102};
    }

    public static LinkMode valueOf(String r100) {
        return (LinkMode) r27.a.a(LinkMode.class, r100);
    }

    public static LinkMode[] values() {
        return (LinkMode[]) f88795a.clone();
    }

    public LinkMode(String r100, int r101) {
        super(r100, r101);
    }
}
