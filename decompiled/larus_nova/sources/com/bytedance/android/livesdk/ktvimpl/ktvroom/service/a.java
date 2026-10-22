package com.bytedance.android.livesdk.ktvimpl.ktvroom.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import java.util.List;
import java.util.Map;
import kk0.f;
import kk0.g;
import tf0.h;

/* JADX INFO: loaded from: classes10.dex */
public interface a {
    public static final C2261a S0 = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a$a, reason: collision with other inner class name */
    public static final class C2261a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C2261a f144833a = null;

        public C2261a() {
        }

        static {
            f144833a = new C2261a();
        }

        public static a a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(IVoiceChatAdminService.TAG);
            if ((r100 instanceof KtvRoomGlobalDataContext) == true) goto L5;
            r100 = null;
        L5:
            KtvRoomGlobalDataContext r101 = (KtvRoomGlobalDataContext) r100;
            if (r101 == null) goto L11;
            j<a> r102 = r101.getKtvAdminService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        S0 = C2261a.f144833a;
    }

    f Bb();

    void accept(IBaseUser r100);

    void accept(String r100, String r101);

    boolean canSilenceSelf();

    jg6.a getAdminStatusCenter();

    List<s0> getHeadPointList();

    h getInteractAnimationService();

    g getLinkMicSeatCallback();

    i<ILinkPlayerInfoBridge> getLinkUserInfoCenter();

    List<ILinkPlayerInfoBridge> getOnlineUserList();

    void invite(com.bytedance.android.live.liveinteract.videolink.a r100);

    boolean isEngineOn();

    void kickOut(IBaseUser r100);

    boolean ktvWillAutoSilenceSelf();

    MuteStateChecker muteChecker();

    com.bytedance.android.live.liveinteract.voicechat.b muteManager();

    void onChangeMediaInfo(ILinkerChangeMediaInfoContent r100, int r101);

    void onSwitchSceneMessage(z0 r100);

    hg6.g rtcManger();

    void setInviteCallback(uf0.c r100);

    void setPermitCallback(uf0.d r100);

    void showInviteAndPermitDialog(boolean r100, String r101, int r102);

    void switchAudioByClient(boolean r100, List<k> r101, ClientUIInfo r102, long r103, Map<Long, ? extends RoomLinkerContent> r104, String r105);
}
