package com.bytedance.android.live.revlink.impl.mergepk.pkdouble;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.jsb.h0;
import com.bytedance.android.livesdk.link.model.h7;
import io.reactivex.subjects.PublishSubject;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public interface c {
    boolean canSwitchMulti();

    String getAudienceConnectCnt();

    String getConnectionType();

    MutableLiveData<Integer> getContributionListAlphaEvent();

    int getCurAuraType();

    int getCurrentMatchType();

    String getEndReason();

    Integer getEndType();

    LiveData<IBaseUser> getGuestUser();

    PublishSubject<Boolean> getInstallKillMsgEvent();

    int getInviteType();

    LiveData<List<h7.b>> getLeftMvpRankList();

    long getLinkStartTime();

    LiveData<String> getPkGuestListStr();

    MutableLiveData<Boolean> getPkLynxInfoIsShowing();

    MutableLiveData<Boolean> getPkProgressBarAdditionAnim();

    MutableLiveData<Boolean> getPkProgressBarSecKillLine();

    LiveData<List<h7.b>> getRightMvpRankList();

    MutableLiveData<h0> getTeamTaskOptAddition();

    com.bytedance.android.live.revlink.impl.pk.vm.pk.e getTeamTaskService();

    int isBattleStatsObtained();

    boolean isFinisher();

    boolean isInContributor();

    String isManager();

    boolean isPlayModeInviter();

    boolean isRealOrgnizer();

    boolean isRoomCloser();

    void onFeedBackInfoUpdate(boolean r100, List<String> r101);
}
