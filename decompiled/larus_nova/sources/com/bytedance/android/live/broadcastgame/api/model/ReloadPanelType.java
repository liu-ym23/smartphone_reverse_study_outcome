package com.bytedance.android.live.broadcastgame.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/ReloadPanelType;", "", "FROM_CAHCE", "FROM_SEVER", "NOT_RELOAD", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReloadPanelType extends Enum<ReloadPanelType> {
    public static final ReloadPanelType FROM_CAHCE = null;
    public static final ReloadPanelType FROM_SEVER = null;
    public static final ReloadPanelType NOT_RELOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReloadPanelType[] f59332a = null;

    static {
        ReloadPanelType r100 = new ReloadPanelType("FROM_CAHCE", 0);
        FROM_CAHCE = r100;
        ReloadPanelType r101 = new ReloadPanelType("FROM_SEVER", 1);
        FROM_SEVER = r101;
        ReloadPanelType r102 = new ReloadPanelType("NOT_RELOAD", 2);
        NOT_RELOAD = r102;
        f59332a = new ReloadPanelType[]{r100, r101, r102};
    }

    public static ReloadPanelType valueOf(String r100) {
        return (ReloadPanelType) r27.a.a(ReloadPanelType.class, r100);
    }

    public static ReloadPanelType[] values() {
        return (ReloadPanelType[]) f59332a.clone();
    }

    public ReloadPanelType(String r100, int r101) {
        super(r100, r101);
    }
}
