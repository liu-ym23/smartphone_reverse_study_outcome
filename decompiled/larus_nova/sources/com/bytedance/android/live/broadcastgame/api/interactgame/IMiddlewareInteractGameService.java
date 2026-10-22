package com.bytedance.android.live.broadcastgame.api.interactgame;

import android.view.Surface;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\bH&J\"\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H&J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0002H&J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\fH&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u001a\u001a\u00020\fH&J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH&J\b\u0010\u001d\u001a\u00020\u0004H&¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/interactgame/IMiddlewareInteractGameService;", "Lcom/bytedance/android/live/base/IService;", "", "appId", "", "getEntranceVisibility", "Lcom/bytedance/android/live/base/model/message/t;", "message", "", "cacheOpenPlatformMessage", "anchorLaunchGame", "audienceLaunchGame", "", "success", "Landroid/view/Surface;", "surface", "fps", "notifyStartLinkCastResult", "notifyStopLinkCastResult", "reason", "stopRunningPlugin", "isAnchor", "Lcom/bytedance/android/live/broadcastgame/api/model/h;", "fetchGameIconInfo", "Lcom/bytedance/android/live/broadcastgame/api/xplay/e;", "getXplayGlobalService", "isPlayingGame", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractID;", "gameType", "getCurrentPlayingGameId", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareInteractGameService extends IService {
    public static final a Companion = null;
    public static final int ENTRANCE_INVISIBLE = 0;
    public static final int ENTRANCE_VISIBLE = 1;
    public static final int ENTRANCE_VISIBLE_UNKNOWED = -1;
    public static final String EXIT_FROM_EFFECT_SINGLE = "effect-single";
    public static final String EXIT_FROM_WMINI_GAME_TYPE = "wmini-game-type";
    public static final int FORCE_TO_STOP_GAME = 1000;
    public static final int TYPE_FOLD_MANAGER_DEFAULT = 0;
    public static final int TYPE_FOLD_MANAGER_INTERACT = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f59294a = null;

        public a() {
        }

        static {
            f59294a = new a();
        }
    }

    static {
        Companion = a.f59294a;
    }

    void anchorLaunchGame(String r100);

    void audienceLaunchGame();

    void cacheOpenPlatformMessage(String r100, t r101);

    com.bytedance.android.live.broadcastgame.api.model.h fetchGameIconInfo(String r100, boolean r101);

    int getCurrentPlayingGameId();

    int getEntranceVisibility(String r100);

    com.bytedance.android.live.broadcastgame.api.xplay.e getXplayGlobalService();

    boolean isPlayingGame();

    boolean isPlayingGame(InteractID r100);

    void notifyStartLinkCastResult(boolean r100, Surface r101, int r102);

    void notifyStopLinkCastResult(boolean r100);

    void stopRunningPlugin(String r100);
}
