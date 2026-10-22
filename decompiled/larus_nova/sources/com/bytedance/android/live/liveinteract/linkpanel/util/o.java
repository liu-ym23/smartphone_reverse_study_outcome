package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.model.o0;
import com.bytedance.android.live.liveinteract.plantform.model.z0;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.e0;
import com.bytedance.android.livesdk.config.link.InteractFrequencyConfig;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.search.dto.UserGroupScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f75051a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f75052b = null;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f75053a;

        public a(boolean r100) {
            this.f75053a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            com.bytedance.android.livesdk.sharedpref.e<Integer> r102 = com.bytedance.android.livesdk.sharedpref.c.f158262e1;
            if (this.f75053a == false) goto L5;
            int r103 = 1;
        L6:
            Integer r104 = Integer.valueOf(r103);
            r102.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r102, r104);
            if (TextUtils.isEmpty(((z0) r101.data).a()) == true) goto L10;
            f2.c(((z0) r101.data).a(), 0);
        L10:
            if (this.f75053a == false) goto L13;
            w.d();
            return;
        L13:
            return;
        L5:
            r103 = 2;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f75054a = null;

        static {
            f75054a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((Throwable) r100).printStackTrace();
            ALogger.e("[PaidQueue]", String.valueOf(Unit.INSTANCE));
        }
    }

    static {
        f75051a = new SimpleDateFormat("yyyy-MM-dd");
        f75052b = new g((InteractFrequencyConfig) vm2.d.f556007x0.getValue(null, vm2.d.f555776a[73]));
    }

    public static final boolean B() {
        com.bytedance.android.live.liveinteract.revenue.fight.b r100 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r100 == null) goto L9;
        com.bytedance.android.live.liveinteract.revenue.fight.a r101 = r100.o3();
        if (r101 == null) goto L9;
        if (r101.isFightShowing() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean I() {
        return ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().c();
    }

    public static final String J() {
        return ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n();
    }

    public static final int c() {
        return ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
    }

    public static final int d() {
        return ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentUiLayout();
    }

    public static final String j() {
        StringBuilder r100 = new StringBuilder();
        com.bytedance.android.live.liveinteract.api.data.a.f71432h.getClass();
        r100.append(com.bytedance.android.live.liveinteract.api.data.a.C1153a.g() + "抖币");
        r100.append(" ");
        int r101 = com.bytedance.android.live.liveinteract.api.data.a.C1153a.f();
        if (r101 >= 120) goto L5;
        String r102 = r101 + "秒";
    L6:
        r100.append(r102);
        return r100.toString();
    L5:
        r102 = (r101 / 60) + "分钟";
        goto L6
    }

    public static final boolean s() {
        if (((Boolean) vm2.h.f556240t5.getValue(null, vm2.h.f556082a[330(0x14a, float:4.62E-43)])).booleanValue() == false) goto L10;
        Integer r100 = com.bytedance.android.livesdk.sharedpref.c.f158262e1.getValue();
        if (r100 != null) goto L8;
    L9:
        return true;
    L8:
        if (r100.intValue() != 0) goto L9;
    L10:
        return false;
    }

    public static final boolean u() {
        if (((IKtvService) jc1.k.n(IKtvService.class)).isKtvComponentOpen() == false) goto L5;
        return true;
    L5:
        if (c() != 9) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r100 = false;
        goto L8
    }

    public static final boolean w() {
        if (((IInteractService) jc1.k.n(IInteractService.class)).getAudioTalkService().isKtvOn() == false) goto L5;
    L8:
        return true;
    L5:
        if (v() == true) goto L8;
        return false;
    }

    public static final boolean y() {
        cj0.a r100 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicContext();
        if (r100 == null) goto L9;
        cj0.c r101 = r100.getWidget();
        if (r101 == null) goto L9;
        if (r101.isIncreasePriceOn() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean z() {
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L13;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.c r100 = MultiRevenueDataContext.a.c();
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 != true) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r100.isPaidLinkOn() != true) goto L9;
        r101 = true;
        goto L10
    L13:
        return false;
    }

    public static final boolean C() {
        if (c() != 16) goto L11;
        com.bytedance.live.datacontext.m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L11;
        IRoom r101 = r100.getValue();
        if (r101 == null) goto L11;
        if (r101.isLiveTypeAudio() == true) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean D() {
        int r100 = c();
        if (r100 != 8) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 12) goto L8;
        return false;
    }

    public static final boolean H() {
        if (vm2.d.C0() == true) goto L6;
        ALogger.i("VideoKtv", "roomSupportVideoKtv,live_video_ktv_enable is false");
        return false;
    L6:
        float r100 = com.bytedance.android.livesdk.utils.z0.b(true);
        ALogger.i("VideoKtv", "roomSupportVideoKtv,score:" + r100);
        if (r100 > 0) goto L9;
    L10:
        return true;
    L9:
        if (r100 >= vm2.d.D0()) goto L10;
        return false;
    }

    public static final IRoom b() {
        com.bytedance.live.datacontext.m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    public static final String g() {
        com.bytedance.live.datacontext.m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L7;
        IRoom r101 = r100.getValue();
        if (r101 == null) goto L7;
        IRoomOthersData r102 = r101.getRoomOthers();
    L9:
        if ((r102 instanceof RoomOthersData) == true) goto L11;
        r102 = null;
    L11:
        RoomOthersData r103 = (RoomOthersData) r102;
        if (r103 != null) goto L14;
        return null;
    L14:
        return r103.getInvitePanelGuideContent();
    L7:
        r102 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String i() {
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L7;
        return "anchor";
    L7:
        if (((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().c() == false) goto L10;
        return UserGroupScene.DEFAULT_NAME_SPACE;
    L10:
        Integer r100 = (Integer) hd0.c.f().f481009b;
        if (r100 != null) goto L14;
        return SourceType.DEFAULT;
    L14:
        if (r100.intValue() != 2) goto L17;
        return "guest";
    L17:
        return SourceType.DEFAULT;
    }

    public static final boolean k() {
        com.bytedance.live.datacontext.m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L7;
        IRoom r101 = r100.getValue();
        if (r101 == null) goto L7;
        String r102 = r101.getAnchorAbValue("link_efficiency");
    L9:
        if (Intrinsics.areEqual(r102, "1") == false) goto L11;
    L14:
        return true;
    L11:
        if (Intrinsics.areEqual(r102, "2") == true) goto L14;
        return false;
    L7:
        r102 = null;
        goto L9
    }

    public static final boolean l() {
        if (c() != 16) goto L11;
        com.bytedance.live.datacontext.m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L11;
        IRoom r101 = r100.getValue();
        if (r101 == null) goto L11;
        if (r101.isLiveTypeAudio() != true) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean m() {
        if (c() != 5) goto L5;
        return true;
    L5:
        if (c() == 9) goto L16;
        com.bytedance.live.datacontext.m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L13;
        IRoom r101 = r100.getValue();
        if (r101 == null) goto L13;
        if (r101.isLiveTypeAudio() != true) goto L13;
        return true;
    L13:
        return false;
    L16:
        return true;
    }

    public static final boolean n() {
        if (c() != 5) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return true;
    L8:
        if (l() == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public static final boolean v() {
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r100 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r100 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r101 = r100.getValue();
        if (r101 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r102 = r101.t();
        if (r102 == null) goto L11;
        if (r102.f114792a != 9) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean A(IRoom r100) {
        if (r100 == null) goto L7;
        Map<String, String> r101 = r100.getAnchorABMap();
        if (r101 == null) goto L7;
        String r102 = r101.get("bigevent_disable_lynx_panel");
    L9:
        if (Intrinsics.areEqual(r102, "2") == false) goto L12;
    L18:
        return false;
    L12:
        if (vm2.i.a().getLinkServiceEnable() == false) goto L18;
        if (vm2.i.b().getSettingPanelOpen() == false) goto L16;
    L17:
        return true;
    L16:
        if (o(null) == false) goto L18;
    L7:
        r102 = null;
        goto L9
    }

    public static final boolean F(int r100) {
        if (((Boolean) vm2.d.J6.getValue(null, vm2.d.f555776a[397(0x18d, float:5.56E-43)])).booleanValue() == false) goto L5;
    L8:
        return true;
    L5:
        if (r100 != 28) goto L8;
        return false;
    }

    public static final boolean G(IRoom r100) {
        ReadOnlyProperty r101 = vm2.d.E0;
        KProperty<?>[] r102 = vm2.d.f555776a;
        if (((Boolean) r101.getValue(null, r102[80])).booleanValue() == true) goto L7;
        ALogger.w("supportKtvCamera", "LIVE_KTV_CAMERA_CLIENT_ENABLE:false");
        return false;
    L7:
        if (r100 == null) goto L9;
        e0.a(r100, "ktv_enable_open_camera");
    L18:
        boolean r103 = ((Boolean) vm2.d.f555928p1.getValue(null, r102[117(0x75, float:1.64E-43)])).booleanValue();
        ALogger.w("supportKtvCamera", "roomSupportKtv:" + r103);
        if (r103 == true) goto L30;
        float r104 = com.bytedance.android.livesdk.utils.z0.b(true);
        if (r104 > 0) goto L23;
    L26:
        boolean r105 = true;
    L27:
        if (r105 == true) goto L30;
        if (((Boolean) vm2.d.F0.getValue(null, r102[81])).booleanValue() == true) goto L30;
        return false;
    L23:
        if (r104 >= ((Number) vm2.d.I0.getValue(null, r102[84])).floatValue()) goto L26;
        r105 = false;
    L30:
        return true;
    L9:
        int r106 = e0.f105889a;
        IRoomContextService r107 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r107 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.o r108 = r107.getRoomDataContext(com.bytedance.live.datacontext.d.d(com.bytedance.android.livesdk.chatroom.o.class));
        if (r108 == null) goto L16;
        com.bytedance.live.datacontext.m<IRoom> r109 = r108.getRoom();
        if (r109 == null) goto L16;
        IRoom r110 = r109.getValue();
    L17:
        e0.a(r110, "ktv_enable_open_camera");
    L16:
        r110 = null;
        goto L17
    }

    public static final boolean L(ILinkPlayerInfoBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "linkPlayerInfo");
        z();
        if (z() == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.getPaidAmount() <= 0) goto L7;
        return true;
    }

    public static final ILinkPlayerInfoBridge M(n0 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLinkPlayerInfo");
        ILinkPlayerInfoBridge r101 = (ILinkPlayerInfoBridge) vh7.f.c(ILinkPlayerInfoBridge.class);
        r101.setHasApplied(r100.isHasApplied());
        r101.setUser(r100.getUserFlex());
        r101.setModifyTime(r100.getModifyTime());
        r101.setLinkStatus(r100.getMLinkStatus());
        r101.setLinkType(r100.getMLinkType());
        r101.setRoleType(r100.getMRoleType());
        long r102 = r100.getUserPosition();
        Intrinsics.checkNotNullParameter(r101, "$this$userPositionKt");
        r101.setUserPositionFlex((int) r102);
        r101.setSilenceStatus(r100.getSilenceStatus());
        r101.setInteractId(r100.getLinkmicIdStr());
        r101.setSongList(r100.getSongListFlex());
        r101.setOrderedSongCount(r100.getOrderedSongCount());
        r101.setClientVersion(r100.getClientVersion());
        r101.setAppId(r100.getAppId());
        r101.setDevicePlatform(r100.getDevicePlatform());
        r101.setListUserType(r100.getListUserType());
        r101.setListUserFromType(r100.getListUserFromType());
        r101.setWaitingListUserInfo((o0) vh7.f.c(o0.class));
        o0 r103 = r101.getWaitingListUserInfo();
        if (r103 == null) goto L5;
        r103.setHasExpired(r100.getHasExpired());
    L5:
        o0 r104 = r101.getWaitingListUserInfo();
        if (r104 == null) goto L8;
        r104.setMutualFollow(r100.isMutualFollow());
    L8:
        o0 r105 = r101.getWaitingListUserInfo();
        if (r105 == null) goto L11;
        r105.setApplyReason(r100.getApplyReason());
    L11:
        o0 r106 = r101.getWaitingListUserInfo();
        if (r106 == null) goto L14;
        r106.setLast7DaysGiftCountTxt(r100.getLast7DaysGiftCountTxt());
    L14:
        r101.setFuzzyFanTicket(r100.getFanTicket());
        r101.setRank(r100.getRank());
        r101.setAlreadyInvited(r100.getAlreadyInvited());
        r101.setAddPrice(r100.isAddPrice());
        r101.setAddPriceTime(r100.getAddPriceTime());
        r101.setAnonymous(r100.isAnonymous());
        r101.setMicPosTagInfo(r100.getMicPosTagFlex());
        r101.setApplyType(r100.getApplyType());
        r101.setInvitor(r100.getInvitorFlex());
        r101.setPaidAmount(r100.getPaidAmount());
        r101.setJoinTeamFightInfo(r100.getJoinTeamFightInfoFlex());
        r101.setInvitor(r100.getInvitorFlex());
        r101.setApplyTypeNew(r100.getApplyType());
        r101.setUserHighScoreSongTag(r100.getUserHighScoreSongTagFlex());
        r101.setTags(r100.getTags());
        r101.setEventInfo(r100.getEventInfo());
        r101.setButtonText(r100.getButtonText());
        r101.setTag(r100.getTag());
        return r101;
    }

    public static final ArrayList<ILinkPlayerInfoBridge> N(List<? extends n0> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLinkPlayerInfo");
        ArrayList<ILinkPlayerInfoBridge> r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(M((n0) r102.next()));
        goto L4
    L6:
        return r101;
    }

    public static final boolean o(Integer r100) {
        if (r100 != null) goto L5;
        IInteractService r101 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r101 == null) goto L13;
        Integer r102 = Integer.valueOf(r101.getCurrentUiLayout());
    L14:
        if (r102 != null) goto L17;
    L18:
        if (r102 != null) goto L21;
        return false;
    L21:
        if (r102.intValue() != 63) goto L25;
    L22:
        return true;
    L25:
        return false;
    L17:
        if (r102.intValue() == 62) goto L22;
    L13:
        r102 = null;
        goto L14
    L5:
        if (r100.intValue() != 62) goto L7;
    L8:
        return true;
    L7:
        if (r100.intValue() == 63) goto L8;
        return false;
    }

    public static final boolean p(DataCenter r100) {
        if (r100 == null) goto L17;
        IRoom r101 = (IRoom) r100.get("data_room");
        if (r101 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual((Boolean) r100.get("data_is_anchor"), Boolean.TRUE) == true) goto L10;
        return false;
    L10:
        if (r101.isLiveTypeAudio() != true) goto L12;
        return false;
    L12:
        if (vm2.d.r0() == true) goto L14;
        return false;
    L14:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L21;
        return true;
    L21:
        return false;
    L17:
        return false;
    }

    public static final boolean q(DataCenter r100) {
        if (r100 == null) goto L17;
        IRoom r101 = (IRoom) r100.get("data_room");
        if (r101 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual((Boolean) r100.get("data_is_anchor"), Boolean.TRUE) == true) goto L10;
        return false;
    L10:
        if (r101.isLiveTypeAudio() != true) goto L12;
        return false;
    L12:
        if (vm2.d.r0() == true) goto L14;
        return false;
    L14:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == true) goto L21;
        return true;
    L21:
        return false;
    L17:
        return false;
    }

    public static final boolean r(IRoom r100) {
        if (r100 == null) goto L9;
        Map<String, String> r101 = r100.getAnchorABMap();
        if (r101 == null) goto L9;
        String r102 = r101.get("ktv_kick_when_linker_full");
        if (r102 == null) goto L9;
        int r103 = CastIntegerProtector.parseInt(r102);
    L11:
        if (r103 != 1) goto L14;
        return true;
    L14:
        return false;
    L9:
        r103 = 0;
        goto L11
    }

    public static final boolean t(boolean r100) {
        if (c() != 10) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L17;
        if (r100 == false) goto L13;
        if (((Number) vm2.d.A0.getValue(null, vm2.d.f555776a[76])).intValue() != 1) goto L29;
    L14:
        return true;
    L29:
        return false;
    L13:
        if (((Number) vm2.d.B0.getValue(null, vm2.d.f555776a[77])).intValue() == 1) goto L14;
        return false;
    L17:
        if (c() != 4) goto L24;
        int r102 = com.bytedance.android.live.liveinteract.utils.r.f78824b;
        if (r102 != 2) goto L21;
    L22:
        return true;
    L21:
        if (r102 == 3) goto L22;
        return false;
    L24:
        if (r100 == false) goto L28;
        return vm2.d.z();
    L28:
        return ((Boolean) vm2.d.D0.getValue(null, vm2.d.f555776a[79])).booleanValue();
    L5:
        r101 = false;
        goto L7
    }

    public static final boolean x(IRoom r100) {
        if (r100 == null) goto L8;
        Map<String, String> r101 = r100.getAnchorABMap();
        if (r101 == null) goto L8;
        String r102 = r101.get("optran_paid_linkmic");
        if (r102 == null) goto L8;
        Integer r103 = StringsKt.toIntOrNull(r102);
    L9:
        if (r103 != null) goto L12;
    L14:
        return false;
    L12:
        if (r103.intValue() != 2) goto L14;
        return true;
    L8:
        r103 = null;
        goto L9
    }

    public static final void E(DataContext r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "selection");
        HashMap r102 = new HashMap();
        r102.put("live_type", "video_live");
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r103 = com.bytedance.android.live.liveinteract.api.utils.m.g(r100).getVideoTalkRoomSubScene();
        if (r103 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r104 = r103.getValue();
        if (r104 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r105 = r104.t();
        if (r105 == null) goto L9;
        m.B(r102, Integer.valueOf(r105.f114798a), 4);
    L9:
        m.J(r102);
        r102.put("selection", r101);
        j0.l().sendLog("livesdk_anchor_audience_connection_layout_change_popup_click", r102, new Object[]{IRoom.class});
    }

    public static final void a(TextView r100, g0 r101) {
        if (r100 == null) goto L15;
        int r102 = r100.getPaddingStart() + r100.getPaddingEnd();
        r100.measure(0, 0);
        int r103 = r100.getMeasuredWidth() + r102;
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
        if (r104 == null) goto L6;
        r104.width = r103;
        Unit r105 = Unit.INSTANCE;
    L7:
        r100.setLayoutParams(r104);
        if (r101.getBgColorImg() == null) goto L13;
        py.k r106 = r101.getBgColorImg();
        if (r106 == null) goto L17;
        r100.post(new n(r106, r100));
        return;
    L17:
        return;
    L13:
        r100.setBackgroundResource(R.drawable.ttlive_bg_apply_list_friend_host);
        return;
    L6:
        r104 = null;
        goto L7
    }

    public static final py.k h(IBaseUser r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getUserAvatar");
        if (r101 != AvatarType.AVATAR_THUMB.getValue()) goto L21;
        py.k r102 = r100.getAvatarThumbKt();
        if (r102 != null) goto L7;
    L9:
        py.k r103 = r100.getAvatarMedium();
        if (r103 != null) goto L12;
    L14:
        py.k r104 = r100.getAvatarLarge();
        if (r104 == null) goto L58;
        if ((!UtilityKotlinExtentionsKt.n(r104)) != true) goto L58;
        return r100.getAvatarLarge();
    L58:
        return r100.getAvatarLarge();
    L12:
        if ((!UtilityKotlinExtentionsKt.n(r103)) != true) goto L14;
        return r100.getAvatarMedium();
    L7:
        if ((!UtilityKotlinExtentionsKt.n(r102)) != true) goto L9;
        return r100.getAvatarThumbKt();
    L21:
        if (r101 != AvatarType.AVATAR_MEDIUM.getValue()) goto L38;
        py.k r105 = r100.getAvatarMedium();
        if (r105 != null) goto L25;
    L27:
        py.k r106 = r100.getAvatarThumbKt();
        if (r106 != null) goto L30;
    L32:
        py.k r107 = r100.getAvatarLarge();
        if (r107 == null) goto L62;
        if ((!UtilityKotlinExtentionsKt.n(r107)) != true) goto L62;
        return r100.getAvatarLarge();
    L62:
        return r100.getAvatarLarge();
    L30:
        if ((!UtilityKotlinExtentionsKt.n(r106)) != true) goto L32;
        return r100.getAvatarThumbKt();
    L25:
        if ((!UtilityKotlinExtentionsKt.n(r105)) != true) goto L27;
        return r100.getAvatarMedium();
    L38:
        py.k r108 = r100.getAvatarLarge();
        if (r108 != null) goto L41;
    L43:
        py.k r109 = r100.getAvatarMedium();
        if (r109 != null) goto L46;
    L48:
        py.k r110 = r100.getAvatarThumbKt();
        if (r110 == null) goto L54;
        if ((!UtilityKotlinExtentionsKt.n(r110)) != true) goto L54;
        return r100.getAvatarThumbKt();
    L54:
        return r100.getAvatarThumbKt();
    L46:
        if ((!UtilityKotlinExtentionsKt.n(r109)) != true) goto L48;
        return r100.getAvatarMedium();
    L41:
        if ((!UtilityKotlinExtentionsKt.n(r108)) != true) goto L43;
        return r100.getAvatarLarge();
    }

    public static final void O(IRoom r100, boolean r101, CompositeDisposable r102) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r102, "compositeDisposable");
        r102.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).updatePaidQueueSettings(r100.getId(), r101).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r101), b.f75054a));
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r103 = com.bytedance.android.livesdk.sharedpref.c.f158274i1;
        if (r103.getValue().booleanValue() == false) goto L6;
        Boolean r104 = Boolean.FALSE;
        r103.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r103, r104);
        return;
    }

    public static final String e(Context r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r103 = r102 - r101;
        long r104 = 60000;
        if (r103 <= r104) goto L5;
        long r105 = BaseConstants.Time.HOUR;
        if (r103 > r105) goto L11;
        return s1.C(R.string.ttlive_paid_minute_new, new Object[]{Integer.valueOf((int) (r103 / r104))});
    L11:
        if (r103 > 86400000) goto L15;
        return s1.C(R.string.ttlive_paid_hour_new, new Object[]{Integer.valueOf((int) (r103 / r105))});
    L15:
        return f75051a.format(new Date(r101));
    L5:
        return r100.getString(R.string.ttlive_paid_just_now);
    }

    public static final String f(Context r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r103 = r102 - r101;
        long r104 = 60000;
        if (r103 <= r104) goto L5;
        long r105 = BaseConstants.Time.HOUR;
        if (r103 > r105) goto L11;
        return s1.C(R.string.ttlive_paid_increase_price_wait_minute, new Object[]{Integer.valueOf((int) (r103 / r104))});
    L11:
        if (r103 > 86400000) goto L15;
        return s1.C(R.string.ttlive_paid_increase_price_wait_hour, new Object[]{Integer.valueOf((int) (r103 / r105))});
    L15:
        return f75051a.format(new Date(r101));
    L5:
        return r100.getString(R.string.ttlive_paid_just_add_price_now);
    }

    public static final void K(Context r100, IRoom r101, String r102, long r103, Integer r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "enterPageType");
        String r104 = null;
        u6 r105 = new u6((String) vm2.d.H0.getValue(null, vm2.d.f555776a[83]));
        if (r110 == null) goto L5;
        r105.b("height", String.valueOf(r110.intValue()));
    L5:
        u6 r111 = r105.d("url");
        if (r101 == null) goto L8;
        Long r106 = Long.valueOf(r101.getId());
    L9:
        r111.b("room_id", String.valueOf(r106));
        if (r101 == null) goto L12;
        r104 = r101.getOwnerUserIdString();
    L12:
        r111.b("anchor_id", r104);
        r111.b("function_type", m.a());
        if (r101 != null) goto L15;
    L17:
        String r107 = "video_live";
    L18:
        r111.b("live_type", r107);
        r111.b("user_type", i());
        r111.b(FastStartLiveConfig.PLAY_MODE, m.c());
        r111.b(CheckPointType.ENTER_PAGE, r102);
        r111.b(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE, String.valueOf(r103));
        ((IBaseLiveActionHandler) jc1.k.n(IBaseLiveActionHandler.class)).handle(r100, r105.c());
        return;
    L15:
        if (r101.isLiveTypeAudio() != true) goto L17;
        r107 = "voice_live";
        goto L18
    L8:
        r106 = null;
        goto L9
    }
}
