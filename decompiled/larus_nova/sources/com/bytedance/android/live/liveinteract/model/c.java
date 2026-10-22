package com.bytedance.android.live.liveinteract.model;

import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/model/c;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/l1;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends vh7.e<l1>, l1 {
    @Override // com.bytedance.android.livesdk.link.model.bridge.l1, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ int getAiGuestType();

    /* synthetic */ long getAppId();

    /* synthetic */ long getChorusGuestStatus();

    /* synthetic */ long getClientVersion();

    /* synthetic */ long getCurrentTime();

    /* synthetic */ String getDevicePlatform();

    /* synthetic */ long getExpectLeaveTime();

    /* synthetic */ long getFanTicket();

    /* synthetic */ String getFanTicketFuzzyStr();

    /* synthetic */ String getFanTicketRealStr();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    /* synthetic */ long getJoinChannelTime();

    /* synthetic */ Linkmic2DAvatar getLinkmic2DAvatar();

    /* synthetic */ int getListUserRole();

    /* synthetic */ kd1.b getMicDress();

    /* synthetic */ long getOriginLinkType();

    /* synthetic */ long getPaidCount();

    /* synthetic */ long getSelfDisciplineDurationTime();

    /* synthetic */ long getSelfDisciplineStartTime();

    /* synthetic */ long getSelfDisciplineTargetDuration();

    /* synthetic */ int getThemedCompetitionRole();

    /* synthetic */ boolean isAnonymous();

    /* synthetic */ boolean isEnlarged();

    /* synthetic */ boolean isHost();

    /* synthetic */ boolean isMicHidden();

    /* synthetic */ void setAiGuestType(int r100);

    /* synthetic */ void setAppId(long r100);

    /* synthetic */ void setChorusGuestStatus(long r100);

    /* synthetic */ void setClientVersion(long r100);

    /* synthetic */ void setCurrentTime(long r100);

    /* synthetic */ void setDevicePlatform(String r100);

    /* synthetic */ void setExpectLeaveTime(long r100);

    /* synthetic */ void setFanTicket(long r100);

    /* synthetic */ void setFanTicketFuzzyStr(String r100);

    /* synthetic */ void setFanTicketRealStr(String r100);

    /* synthetic */ void setHost(boolean r100);

    /* synthetic */ void setJoinChannelTime(long r100);

    /* synthetic */ void setLinkmic2DAvatar(Linkmic2DAvatar r100);

    /* synthetic */ void setListUserRole(int r100);

    /* synthetic */ void setMicDress(kd1.b r100);

    /* synthetic */ void setMicHidden(boolean r100);

    /* synthetic */ void setOriginLinkType(long r100);

    /* synthetic */ void setSelfDisciplineDurationTime(long r100);

    /* synthetic */ void setSelfDisciplineTargetDuration(long r100);

    /* synthetic */ void setThemedCompetitionRole(int r100);
}
