package com.bytedance.android.live.broadcastgame.opengame.panel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/panel/OpenPanelType;", "", "OPEN_PANEL", "FULL_SCREEN_OPEN_PANEL", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenPanelType extends Enum<OpenPanelType> {
    public static final OpenPanelType FULL_SCREEN_OPEN_PANEL = null;
    public static final OpenPanelType OPEN_PANEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenPanelType[] f60658a = null;

    static {
        OpenPanelType r100 = new OpenPanelType("OPEN_PANEL", 0);
        OPEN_PANEL = r100;
        OpenPanelType r101 = new OpenPanelType("FULL_SCREEN_OPEN_PANEL", 1);
        FULL_SCREEN_OPEN_PANEL = r101;
        f60658a = new OpenPanelType[]{r100, r101};
    }

    public static OpenPanelType valueOf(String r100) {
        return (OpenPanelType) r27.a.a(OpenPanelType.class, r100);
    }

    public static OpenPanelType[] values() {
        return (OpenPanelType[]) f60658a.clone();
    }

    public OpenPanelType(String r100, int r101) {
        super(r100, r101);
    }
}
