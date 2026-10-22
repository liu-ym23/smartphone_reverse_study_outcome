package com.bytedance.android.live.revlink.impl.mergepk.pkmulti;

import androidx.lifecycle.LiveData;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import w20.v9;

/* JADX INFO: loaded from: classes47.dex */
public interface b {
    v9 getBattleBgImage();

    Map<String, String> getCurrentSceneLogParam();

    String getInviteModeStatus();

    i31.a getPkBeforeFinishData();

    j31.a getPkStartParam();

    int getPkUserCnt();

    LiveData<List<af2.b>> getScoreState();

    Pair<List<String>, List<String>> getTeamPkUids();

    Pair<List<String>, List<String>> getTeamPkUids4Finish();

    String getTeamType();

    Map<String, Long> getUserIdToTeamId();

    HashMap<String, Integer> getUserRoleMap();

    void handleBattleBgImage(v9 r100);

    boolean isAnchorLinkFinisher();

    boolean isOnceMore();

    boolean isPkLauncher();

    void notifyPkContext(r r100, boolean r101);

    void setAnchorLinkFinisher(boolean r100);

    void setPkLauncher(boolean r100);

    void updateAudioPunishInfo(z r100);
}
