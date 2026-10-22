package com.bytedance.android.livesdk.revenue.host;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/host/RevHostPluginType;", "", "Player", "XGPlayer", "LITE_PLAYER_CONTAINER", "LivePcdnDouyin", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevHostPluginType extends Enum<RevHostPluginType> {
    public static final RevHostPluginType LITE_PLAYER_CONTAINER = null;
    public static final RevHostPluginType LivePcdnDouyin = null;
    public static final RevHostPluginType Player = null;
    public static final RevHostPluginType XGPlayer = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevHostPluginType[] f157165a = null;

    static {
        RevHostPluginType r100 = new RevHostPluginType("Player", 0);
        Player = r100;
        RevHostPluginType r101 = new RevHostPluginType("XGPlayer", 1);
        XGPlayer = r101;
        RevHostPluginType r102 = new RevHostPluginType("LITE_PLAYER_CONTAINER", 2);
        LITE_PLAYER_CONTAINER = r102;
        RevHostPluginType r103 = new RevHostPluginType("LivePcdnDouyin", 3);
        LivePcdnDouyin = r103;
        f157165a = new RevHostPluginType[]{r100, r101, r102, r103};
    }

    public static RevHostPluginType valueOf(String r100) {
        return (RevHostPluginType) a.a(RevHostPluginType.class, r100);
    }

    public static RevHostPluginType[] values() {
        return (RevHostPluginType[]) f157165a.clone();
    }

    public RevHostPluginType(String r100, int r101) {
        super(r100, r101);
    }
}
