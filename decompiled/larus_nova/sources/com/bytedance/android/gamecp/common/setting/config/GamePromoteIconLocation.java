package com.bytedance.android.gamecp.common.setting.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/GamePromoteIconLocation;", "", "", "location", "Ljava/lang/String;", "getLocation", "()Ljava/lang/String;", "GAME_PROMOTE_ICON", "GAME_DETAIL_INTRO_VERTICAL", "GAME_DETAIL_INTRO_HORIZONTAL", "GAME_DETAIL_ICON", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GamePromoteIconLocation extends Enum<GamePromoteIconLocation> {
    public static final GamePromoteIconLocation GAME_DETAIL_ICON = null;
    public static final GamePromoteIconLocation GAME_DETAIL_INTRO_HORIZONTAL = null;
    public static final GamePromoteIconLocation GAME_DETAIL_INTRO_VERTICAL = null;
    public static final GamePromoteIconLocation GAME_PROMOTE_ICON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GamePromoteIconLocation[] f56735a = null;
    private final String location;

    static {
        GamePromoteIconLocation r100 = new GamePromoteIconLocation("GAME_PROMOTE_ICON", 0, "game_promote_icon");
        GAME_PROMOTE_ICON = r100;
        GamePromoteIconLocation r101 = new GamePromoteIconLocation("GAME_DETAIL_INTRO_VERTICAL", 1, "game_detail_intro_vertical");
        GAME_DETAIL_INTRO_VERTICAL = r101;
        GamePromoteIconLocation r102 = new GamePromoteIconLocation("GAME_DETAIL_INTRO_HORIZONTAL", 2, "game_detail_intro_horizontal");
        GAME_DETAIL_INTRO_HORIZONTAL = r102;
        GamePromoteIconLocation r103 = new GamePromoteIconLocation("GAME_DETAIL_ICON", 3, "game_detail_icon");
        GAME_DETAIL_ICON = r103;
        f56735a = new GamePromoteIconLocation[]{r100, r101, r102, r103};
    }

    public static GamePromoteIconLocation valueOf(String r100) {
        return (GamePromoteIconLocation) r27.a.a(GamePromoteIconLocation.class, r100);
    }

    public static GamePromoteIconLocation[] values() {
        return (GamePromoteIconLocation[]) f56735a.clone();
    }

    public final String getLocation() {
        return this.location;
    }

    public GamePromoteIconLocation(String r100, int r101, String r102) {
        super(r100, r101);
        this.location = r102;
    }
}
