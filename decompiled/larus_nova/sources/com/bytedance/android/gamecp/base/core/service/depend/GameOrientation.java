package com.bytedance.android.gamecp.base.core.service.depend;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/base/core/service/depend/GameOrientation;", "", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "LANDSCAPE", "PORTRAIT", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameOrientation extends Enum<GameOrientation> {
    public static final a Companion = null;
    public static final GameOrientation LANDSCAPE = null;
    public static final GameOrientation PORTRAIT = null;
    public static final GameOrientation UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameOrientation[] f51403a = null;
    private final int type;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.gamecp.base.core.service.depend.GameOrientation$a] */
    static {
        GameOrientation r100 = new GameOrientation("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        GameOrientation r101 = new GameOrientation("LANDSCAPE", 1, 0);
        LANDSCAPE = r101;
        GameOrientation r102 = new GameOrientation("PORTRAIT", 2, 1);
        PORTRAIT = r102;
        f51403a = new GameOrientation[]{r100, r101, r102};
        Companion = new a();
    }

    public static GameOrientation valueOf(String r100) {
        return (GameOrientation) r27.a.a(GameOrientation.class, r100);
    }

    public static GameOrientation[] values() {
        return (GameOrientation[]) f51403a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public GameOrientation(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
