package com.bytedance.android.live.liveinteract.plantform.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/WaitingListSource;", "", "UNKNOWN", "ANCHOR_PANEL", "AUDIENCE_PANEL", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum WaitingListSource extends Enum<WaitingListSource> {
    public static final WaitingListSource ANCHOR_PANEL = null;
    public static final WaitingListSource AUDIENCE_PANEL = null;
    public static final WaitingListSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WaitingListSource[] f77228a = null;

    static {
        WaitingListSource r100 = new WaitingListSource("UNKNOWN", 0);
        UNKNOWN = r100;
        WaitingListSource r101 = new WaitingListSource("ANCHOR_PANEL", 1);
        ANCHOR_PANEL = r101;
        WaitingListSource r102 = new WaitingListSource("AUDIENCE_PANEL", 2);
        AUDIENCE_PANEL = r102;
        f77228a = new WaitingListSource[]{r100, r101, r102};
    }

    public static WaitingListSource valueOf(String r100) {
        return (WaitingListSource) r27.a.a(WaitingListSource.class, r100);
    }

    public static WaitingListSource[] values() {
        return (WaitingListSource[]) f77228a.clone();
    }

    public WaitingListSource(String r100, int r101) {
        super(r100, r101);
    }
}
