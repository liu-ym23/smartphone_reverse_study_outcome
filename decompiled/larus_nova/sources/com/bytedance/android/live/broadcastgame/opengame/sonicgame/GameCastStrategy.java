package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/sonicgame/GameCastStrategy;", "", UserProfileEvent.POSITION_NONE, "VIDEO_SINGLE", "VIDEO_CHATROOM", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameCastStrategy extends Enum<GameCastStrategy> {
    public static final GameCastStrategy NONE = null;
    public static final GameCastStrategy VIDEO_CHATROOM = null;
    public static final GameCastStrategy VIDEO_SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameCastStrategy[] f61010a = null;

    static {
        GameCastStrategy r100 = new GameCastStrategy(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        GameCastStrategy r101 = new GameCastStrategy("VIDEO_SINGLE", 1);
        VIDEO_SINGLE = r101;
        GameCastStrategy r102 = new GameCastStrategy("VIDEO_CHATROOM", 2);
        VIDEO_CHATROOM = r102;
        f61010a = new GameCastStrategy[]{r100, r101, r102};
    }

    public static GameCastStrategy valueOf(String r100) {
        return (GameCastStrategy) r27.a.a(GameCastStrategy.class, r100);
    }

    public static GameCastStrategy[] values() {
        return (GameCastStrategy[]) f61010a.clone();
    }

    public GameCastStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
