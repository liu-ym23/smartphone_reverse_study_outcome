package com.bytedance.android.gamecp.business.orderdownload.api.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/gamecp/business/orderdownload/api/entity/GameOrderDownloadLaunchType;", "", "COLD", "WARM", "TIMER", "WEB_SOCKET", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameOrderDownloadLaunchType extends Enum<GameOrderDownloadLaunchType> {
    public static final GameOrderDownloadLaunchType COLD = null;
    public static final GameOrderDownloadLaunchType TIMER = null;
    public static final GameOrderDownloadLaunchType WARM = null;
    public static final GameOrderDownloadLaunchType WEB_SOCKET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameOrderDownloadLaunchType[] f56192a = null;

    static {
        GameOrderDownloadLaunchType r100 = new GameOrderDownloadLaunchType("COLD", 0);
        COLD = r100;
        GameOrderDownloadLaunchType r101 = new GameOrderDownloadLaunchType("WARM", 1);
        WARM = r101;
        GameOrderDownloadLaunchType r102 = new GameOrderDownloadLaunchType("TIMER", 2);
        TIMER = r102;
        GameOrderDownloadLaunchType r103 = new GameOrderDownloadLaunchType("WEB_SOCKET", 3);
        WEB_SOCKET = r103;
        f56192a = new GameOrderDownloadLaunchType[]{r100, r101, r102, r103};
    }

    public static GameOrderDownloadLaunchType valueOf(String r100) {
        return (GameOrderDownloadLaunchType) a.a(GameOrderDownloadLaunchType.class, r100);
    }

    public static GameOrderDownloadLaunchType[] values() {
        return (GameOrderDownloadLaunchType[]) f56192a.clone();
    }

    public GameOrderDownloadLaunchType(String r100, int r101) {
        super(r100, r101);
    }
}
