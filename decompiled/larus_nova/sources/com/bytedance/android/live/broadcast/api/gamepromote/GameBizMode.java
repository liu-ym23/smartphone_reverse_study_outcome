package com.bytedance.android.live.broadcast.api.gamepromote;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/gamepromote/GameBizMode;", "", "", "mode", "J", "getMode", "()J", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CPS", "CPA", "SALARY", "POI", "CPC", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameBizMode extends Enum<GameBizMode> {
    public static final GameBizMode CPA = null;
    public static final GameBizMode CPC = null;
    public static final GameBizMode CPS = null;
    public static final a Companion = null;
    public static final GameBizMode POI = null;
    public static final GameBizMode SALARY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameBizMode[] f59001a = null;
    private final long mode;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.broadcast.api.gamepromote.GameBizMode$a] */
    static {
        GameBizMode r100 = new GameBizMode("CPS", 0, 0);
        CPS = r100;
        GameBizMode r101 = new GameBizMode("CPA", 1, 1);
        CPA = r101;
        GameBizMode r102 = new GameBizMode("SALARY", 2, 2);
        SALARY = r102;
        GameBizMode r103 = new GameBizMode("POI", 3, 3);
        POI = r103;
        GameBizMode r104 = new GameBizMode("CPC", 4, 4);
        CPC = r104;
        f59001a = new GameBizMode[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static GameBizMode valueOf(String r100) {
        return (GameBizMode) r27.a.a(GameBizMode.class, r100);
    }

    public static GameBizMode[] values() {
        return (GameBizMode[]) f59001a.clone();
    }

    public final long getMode() {
        return this.mode;
    }

    public GameBizMode(String r100, int r101, long r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
