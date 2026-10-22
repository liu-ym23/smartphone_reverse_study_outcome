package com.bytedance.android.live.broadcast.api.gamepromote;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/gamepromote/GameStageType;", "", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, UserProfileEvent.POSITION_NONE, "RESERVATION", FlowDoraWifiScene.TEST, HttpMethod.DOWNLOAD, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameStageType extends Enum<GameStageType> {
    public static final a Companion = null;
    public static final GameStageType DOWNLOAD = null;
    public static final GameStageType NONE = null;
    public static final GameStageType RESERVATION = null;
    public static final GameStageType TEST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameStageType[] f59002a = null;
    private final int type;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.broadcast.api.gamepromote.GameStageType$a] */
    static {
        GameStageType r100 = new GameStageType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        GameStageType r101 = new GameStageType("RESERVATION", 1, 10);
        RESERVATION = r101;
        GameStageType r102 = new GameStageType(FlowDoraWifiScene.TEST, 2, 20);
        TEST = r102;
        GameStageType r103 = new GameStageType(HttpMethod.DOWNLOAD, 3, 30);
        DOWNLOAD = r103;
        f59002a = new GameStageType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static GameStageType valueOf(String r100) {
        return (GameStageType) r27.a.a(GameStageType.class, r100);
    }

    public static GameStageType[] values() {
        return (GameStageType[]) f59002a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public GameStageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
