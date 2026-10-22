package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Deprecated;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Deprecated(message = "向前兼容暴露, 后续使用 LivePlayerScene")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/PlayerClientScene;", "", "scene", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "PREVIEW", "REWARD_AD_PREVIEW", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayerClientScene extends Enum<PlayerClientScene> {
    private static final /* synthetic */ PlayerClientScene[] $VALUES = null;
    public static final PlayerClientScene PREVIEW = null;
    public static final PlayerClientScene REWARD_AD_PREVIEW = null;
    private final String scene;

    static {
        PlayerClientScene r100 = new PlayerClientScene("PREVIEW", 0, "preview");
        PREVIEW = r100;
        PlayerClientScene r101 = new PlayerClientScene("REWARD_AD_PREVIEW", 1, "reward_ad_preview");
        REWARD_AD_PREVIEW = r101;
        $VALUES = new PlayerClientScene[]{r100, r101};
    }

    public static PlayerClientScene valueOf(String r100) {
        return (PlayerClientScene) a.a(PlayerClientScene.class, r100);
    }

    public static PlayerClientScene[] values() {
        return (PlayerClientScene[]) $VALUES.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    private PlayerClientScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
