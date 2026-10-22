package com.bytedance.android.live.broadcastgame.api;

import android.content.Context;
import android.view.Surface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.common.ui.GameExitConformDialog;
import com.bytedance.android.live.broadcastgame.h0;
import com.bytedance.android.live.broadcastgame.widget.AnchorGameWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public interface e {
    void a();

    void b();

    AnchorGameWidget getAnchorGameWidget(com.bytedance.android.live.pushstream.d r100, Room r101, Fragment r102, FragmentManager r103);

    u getCurrentPlayingGame();

    String getGameCategory();

    GameExitConformDialog getGameExitConformDialog(Context r100, String r101);

    h0 getLiveOpenFeatureSceneFilter(DataCenter r100);

    boolean isPlayingGame();

    boolean isPlayingGame(InteractID r100);

    void notifyStartLinkCastResult(boolean r100, Surface r101, int r102);

    void notifyStopLinkCastResult(boolean r100);

    void sendGameCastStatusSEI(boolean r100, JSONObject r101);

    void sendGameSeiData(String r100, String r101);

    void sendServerMergeCastStatusSEI(boolean r100, JSONObject r101);

    void stopGameCastToAudience();

    void stopRunningPlugin(String r100);

    void tryGetSwitchGameConfirmDialog(u r100, Context r101, DataCenter r102, Function0<Unit> r103, Function0<Unit> r104);
}
