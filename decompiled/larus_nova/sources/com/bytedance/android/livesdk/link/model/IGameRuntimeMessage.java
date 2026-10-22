package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u001dR\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IGameRuntimeMessage;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/h0;", "", "getRuntimeType", "()I", "setRuntimeType", "(I)V", "getRuntimeType$annotations", "()V", "runtimeType", "", "getGameId", "()Ljava/lang/Long;", "setGameId", "(Ljava/lang/Long;)V", "getGameId$annotations", "gameId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getAppId$annotations", "appId", "getLinkGameId", "setLinkGameId", "getLinkGameId$annotations", "linkGameId", "GameRuntimeType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IGameRuntimeMessage extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.h0>, com.bytedance.android.livesdk.link.model.bridge.h0 {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IGameRuntimeMessage$GameRuntimeType;", "", "Default", "GameStart", "GameFinish", "PlayerDead", "PlayerLive", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum GameRuntimeType extends Enum<GameRuntimeType> {
        public static final GameRuntimeType Default = null;
        public static final GameRuntimeType GameFinish = null;
        public static final GameRuntimeType GameStart = null;
        public static final GameRuntimeType PlayerDead = null;
        public static final GameRuntimeType PlayerLive = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GameRuntimeType[] f147038a = null;

        static {
            GameRuntimeType r100 = new GameRuntimeType("Default", 0);
            Default = r100;
            GameRuntimeType r101 = new GameRuntimeType("GameStart", 1);
            GameStart = r101;
            GameRuntimeType r102 = new GameRuntimeType("GameFinish", 2);
            GameFinish = r102;
            GameRuntimeType r103 = new GameRuntimeType("PlayerDead", 3);
            PlayerDead = r103;
            GameRuntimeType r104 = new GameRuntimeType("PlayerLive", 4);
            PlayerLive = r104;
            f147038a = new GameRuntimeType[]{r100, r101, r102, r103, r104};
        }

        public static GameRuntimeType valueOf(String r100) {
            return (GameRuntimeType) r27.a.a(GameRuntimeType.class, r100);
        }

        public static GameRuntimeType[] values() {
            return (GameRuntimeType[]) f147038a.clone();
        }

        public GameRuntimeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h0, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.h0, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "app_id")
    String getAppId();

    @Override // com.bytedance.android.livesdk.link.model.bridge.h0, yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "game_id")
    Long getGameId();

    @FieldName(name = "link_game_id")
    Long getLinkGameId();

    @FieldName(name = "runtime_type")
    int getRuntimeType();

    @FieldName(name = "app_id#setter")
    void setAppId(String r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.h0
    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    @FieldName(name = "game_id#setter")
    void setGameId(Long r100);

    @FieldName(name = "link_game_id#setter")
    void setLinkGameId(Long r100);

    @FieldName(name = "runtime_type#setter")
    void setRuntimeType(int r100);
}
