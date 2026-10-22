package com.bytedance.android.gamecp.business.gamedetail.page.root;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/page/root/GameDetailPreRequestTriggerFrom;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "GAME_CROWD", "AI", "SELF", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameDetailPreRequestTriggerFrom extends Enum<GameDetailPreRequestTriggerFrom> {
    public static final GameDetailPreRequestTriggerFrom AI = null;
    public static final GameDetailPreRequestTriggerFrom GAME_CROWD = null;
    public static final GameDetailPreRequestTriggerFrom SELF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameDetailPreRequestTriggerFrom[] f55452a = null;
    private final String key;

    static {
        GameDetailPreRequestTriggerFrom r100 = new GameDetailPreRequestTriggerFrom("GAME_CROWD", 0, "circled_cache");
        GAME_CROWD = r100;
        GameDetailPreRequestTriggerFrom r101 = new GameDetailPreRequestTriggerFrom("AI", 1, "ai_cache");
        AI = r101;
        GameDetailPreRequestTriggerFrom r102 = new GameDetailPreRequestTriggerFrom("SELF", 2, "self_cache");
        SELF = r102;
        f55452a = new GameDetailPreRequestTriggerFrom[]{r100, r101, r102};
    }

    public static GameDetailPreRequestTriggerFrom valueOf(String r100) {
        return (GameDetailPreRequestTriggerFrom) r27.a.a(GameDetailPreRequestTriggerFrom.class, r100);
    }

    public static GameDetailPreRequestTriggerFrom[] values() {
        return (GameDetailPreRequestTriggerFrom[]) f55452a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public GameDetailPreRequestTriggerFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
