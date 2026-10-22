package com.bytedance.android.gamecp.host_api.model.toolbar;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/toolbar/GameUnionType;", "", "", "type", "J", "getType", "()J", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNION_GAME", "NON_UNION_GAME", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameUnionType extends Enum<GameUnionType> {
    public static final a Companion = null;
    public static final GameUnionType NON_UNION_GAME = null;
    public static final GameUnionType UNION_GAME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameUnionType[] f57398a = null;
    private final long type;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.gamecp.host_api.model.toolbar.GameUnionType$a] */
    static {
        GameUnionType r100 = new GameUnionType("UNION_GAME", 0, 0);
        UNION_GAME = r100;
        GameUnionType r101 = new GameUnionType("NON_UNION_GAME", 1, 1);
        NON_UNION_GAME = r101;
        f57398a = new GameUnionType[]{r100, r101};
        Companion = new a();
    }

    public static GameUnionType valueOf(String r100) {
        return (GameUnionType) r27.a.a(GameUnionType.class, r100);
    }

    public static GameUnionType[] values() {
        return (GameUnionType[]) f57398a.clone();
    }

    public final long getType() {
        return this.type;
    }

    public GameUnionType(String r100, int r101, long r102) {
        super(r100, r101);
        this.type = r102;
    }
}
