package com.bytedance.android.gamecp.host_api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/GamePromoteBizMode;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CPS", "BOUNTY", "BASE_SALARY", "POI", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GamePromoteBizMode extends Enum<GamePromoteBizMode> {
    public static final GamePromoteBizMode BASE_SALARY = null;
    public static final GamePromoteBizMode BOUNTY = null;
    public static final GamePromoteBizMode CPS = null;
    public static final GamePromoteBizMode POI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GamePromoteBizMode[] f57366a = null;
    private final String value;

    static {
        GamePromoteBizMode r100 = new GamePromoteBizMode("CPS", 0, "0");
        CPS = r100;
        GamePromoteBizMode r101 = new GamePromoteBizMode("BOUNTY", 1, "1");
        BOUNTY = r101;
        GamePromoteBizMode r102 = new GamePromoteBizMode("BASE_SALARY", 2, "2");
        BASE_SALARY = r102;
        GamePromoteBizMode r103 = new GamePromoteBizMode("POI", 3, "3");
        POI = r103;
        f57366a = new GamePromoteBizMode[]{r100, r101, r102, r103};
    }

    public static GamePromoteBizMode valueOf(String r100) {
        return (GamePromoteBizMode) r27.a.a(GamePromoteBizMode.class, r100);
    }

    public static GamePromoteBizMode[] values() {
        return (GamePromoteBizMode[]) f57366a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public GamePromoteBizMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
