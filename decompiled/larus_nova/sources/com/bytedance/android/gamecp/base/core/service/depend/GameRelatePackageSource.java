package com.bytedance.android.gamecp.base.core.service.depend;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/base/core/service/depend/GameRelatePackageSource;", "", "", "source", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "VIDEO_ANCHOR", "OUT_PROMOTE_ICON", "IN_PROMOTE_ICON", "PROMOTE_DETAIL", "CLOUD_GAME", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameRelatePackageSource extends Enum<GameRelatePackageSource> {
    public static final GameRelatePackageSource CLOUD_GAME = null;
    public static final a Companion = null;
    public static final GameRelatePackageSource IN_PROMOTE_ICON = null;
    public static final GameRelatePackageSource OUT_PROMOTE_ICON = null;
    public static final GameRelatePackageSource PROMOTE_DETAIL = null;
    public static final GameRelatePackageSource VIDEO_ANCHOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameRelatePackageSource[] f51404a = null;
    private final String source;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.gamecp.base.core.service.depend.GameRelatePackageSource$a] */
    static {
        GameRelatePackageSource r100 = new GameRelatePackageSource("VIDEO_ANCHOR", 0, "anchor_show");
        VIDEO_ANCHOR = r100;
        GameRelatePackageSource r101 = new GameRelatePackageSource("OUT_PROMOTE_ICON", 1, "out_promote_icon");
        OUT_PROMOTE_ICON = r101;
        GameRelatePackageSource r102 = new GameRelatePackageSource("IN_PROMOTE_ICON", 2, "in_promote_icon");
        IN_PROMOTE_ICON = r102;
        GameRelatePackageSource r103 = new GameRelatePackageSource("PROMOTE_DETAIL", 3, "promote_detail");
        PROMOTE_DETAIL = r103;
        GameRelatePackageSource r104 = new GameRelatePackageSource("CLOUD_GAME", 4, "cloud_game");
        CLOUD_GAME = r104;
        f51404a = new GameRelatePackageSource[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static GameRelatePackageSource valueOf(String r100) {
        return (GameRelatePackageSource) r27.a.a(GameRelatePackageSource.class, r100);
    }

    public static GameRelatePackageSource[] values() {
        return (GameRelatePackageSource[]) f51404a.clone();
    }

    public final String getSource() {
        return this.source;
    }

    public GameRelatePackageSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.source = r102;
    }
}
