package com.bytedance.android.livesdk.revenue.service.interact;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.ui.GiftAnchorTicketWidget;
import com.bytedance.android.livesdk.asr.GiftSpeechSdkManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import dq2.i;
import dq2.j;
import dq2.m;
import dq2.o;
import dq2.p;
import dq2.s;
import dq2.t;
import dq2.v;
import dq2.w;
import fr2.f0;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface d extends dy0.a, com.bytedance.live.kmp.core.c {
    v Ag();

    void Bk();

    void C2(View r100);

    boolean Dk(List<Integer> r100);

    void I0(String r100, long r101, boolean r102, Map<String, String> r103);

    void I1(int r100, boolean r101);

    gq2.a Il();

    void M0(Map<String, String> r100);

    w M1();

    int M5();

    int O0();

    void Qb(boolean r100, GiftSpeechSdkManager r101);

    gq2.b Qc();

    void R1();

    boolean Sl();

    s T9();

    boolean X1(IRoom r100);

    dq2.b Yn();

    boolean Z4();

    void a5(int r100, boolean r101);

    void c3(View r100);

    boolean cg(h80.a r100);

    String changeMode2String(int r100);

    boolean dynamicFromAudience();

    void fa(boolean r100, f0 r101);

    i getAdventureService();

    j getAudioTalkService();

    String getCurrentFunctionType();

    int getCurrentScene();

    pc0.e getData();

    String getDisplayTicketStr(long r100, List<Long> r101, String r102, String r103);

    com.bytedance.ies.web.jsbridge2.f.b getFeedMultiLinkDynamicJsbMethodProvider(String r100, DataCenter r101);

    String getFunctionTypeForLog();

    o getInteractAnimationService();

    p getInteractAudienceService();

    String getLinkConnectionType();

    String getLiveTypeForLog();

    int getMultiInteractMode();

    int getMultiLinkScene();

    List<a> getOnlineList();

    t getRadioLinkService();

    void hc();

    m ig();

    boolean isAudienceLinkEngineOn();

    boolean isMicRoomHost(String r100);

    boolean isTalkRoomLoaded();

    void multiAnchorLoadVideoTalk();

    void multiAnchorUnloadVideoTalk();

    void pkInviteUnloadWidget();

    void s4();

    void showLynxGuestContributionRankList(Context r100, DataCenter r101, IBaseUser r102, IRoom r103, Map<String, String> r104);

    void wj(GiftAnchorTicketWidget.b r100);

    void xf(int r100);

    void zm(GiftAnchorTicketWidget.b r100);
}
