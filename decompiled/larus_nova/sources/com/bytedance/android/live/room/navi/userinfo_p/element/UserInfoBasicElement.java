package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoBasicPresenter;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementBasicVM;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.dsl.api.IDSLManagerService;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAvator;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.larus.nova.R;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt1.q;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/element/UserInfoBasicElement;", "Lcom/bytedance/android/live/room/navi/userinfo_p/element/base/BaseElement;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoBasicElement extends BaseElement {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UserInfoBasicPresenter f99836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f99837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f99838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f99839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f99840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f99841i;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserInfoBasicElement f99842a;

        public a(UserInfoBasicElement r100) {
            this.f99842a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            IRoom r111 = this.f99842a.getRoom();
            if (r111 == null) goto L8;
            IBaseUser r112 = r111.getOwner();
            if (r112 == null) goto L8;
            String r113 = r112.getIdString();
            if (r113 == null) goto L8;
        L9:
            IRoom r100 = this.f99842a.getRoom();
            if (r100 == null) goto L17;
            IBaseUser r101 = r100.getOwner();
            if (r101 == null) goto L17;
            py.f r102 = r101.getBorder();
            if (r102 == null) goto L17;
            String r103 = r102.getDressId();
            if (r103 == null) goto L17;
        L18:
            com.bytedance.android.livesdk.chatroom.o r104 = z51.a.h(this.f99842a.getDataCenter(), 2);
            if (r104 == null) goto L25;
            com.bytedance.live.datacontext.n<z70.b> r105 = r104.getTemplateContext();
            if (r105 == null) goto L25;
            z70.b r106 = r105.getValue();
            if (r106 == null) goto L25;
            boolean r107 = r106.j("anchor_avatar");
        L26:
            if (r107 == false) goto L34;
            IRoom r114 = this.f99842a.getRoom();
            if (r114 == null) goto L33;
            RoomAvator r115 = gb2.b.c(r114);
            if (r115 == null) goto L33;
            r113 = r115.getUserId();
            if (r113 != null) goto L34;
        L33:
            r113 = "0";
        L34:
            UserInfoBasicPresenter r108 = this.f99842a.f99836d;
            if (r108 == null) goto L59;
            Intrinsics.checkNotNullParameter(r113, "userId");
            Intrinsics.checkNotNullParameter(r103, "dressId");
            if (q0.a(r113) == false) goto L64;
            UserProfileEvent r109 = new UserProfileEvent(r113);
            r109.mSource = UserProfileEvent.SOURCE_ANCHOR_AVATAR;
            r109.setClickUserPosition(UserProfileEvent.POSITION_OPEN_TOP_LEFT_ANCHOR);
            r109.setReportType(UserProfileEvent.DATA_TYPE_CARD_ANCHOR);
            r109.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_USER_INFO));
            r109.wearId = r103;
            if (r108.f100070e.b().getMiddleVm().isAppointmentShowing().getValue().booleanValue() == false) goto L42;
            r109.addProfileClickUserExtraLog("is_announce_show", "1");
        L43:
            xs2.b.a().post(r109);
            ((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).userInfoAutoAntiDeterioration();
            Integer r116 = ev1.e.f474215a.getValue();
            if (r116 != null) goto L47;
            return;
        L47:
            if (r116.intValue() != 2) goto L60;
            Integer r117 = ev1.f.f474216a.getValue();
            if (r117 != null) goto L52;
            return;
        L52:
            if (r117.intValue() != 1) goto L61;
            String r118 = ns0.d.f520283a;
            q r119 = new q("shop_card_slice", r118);
            IDSLManagerService r120 = (IDSLManagerService) jc1.k.f(IDSLManagerService.class);
            if (r120 != null) goto L56;
            return;
        L56:
            if (r120.hasLocalGlobalCache(r119) == true) goto L63;
            ALogger.i("Live_LynxAir", "start preload.");
            int r121 = com.bytedance.android.anniex.api.b.f40245a;
            Intrinsics.checkNotNullParameter(r118, "url");
            com.bytedance.ies.bullet.forest.f<String, com.bytedance.forest.model.o> r122 = ForestLoader.f246728a;
            ForestLoader.k(null, r118, false, null, PreloadType.LYNX, true, "AnnieX_card", null, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK);
            return;
        L63:
            return;
        L61:
            return;
        L60:
            return;
        L42:
            r109.addProfileClickUserExtraLog("is_announce_show", "0");
            goto L43
        L64:
            return;
        L59:
            return;
        L25:
            r107 = false;
        L17:
            r103 = "";
        L8:
            r113 = "0";
            goto L9
        }
    }

    public static final class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserInfoBasicElement f99844a;

        public b(UserInfoBasicElement r100) {
            this.f99844a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            FragmentActivity r101 = this.f99844a.getFragment().getActivity();
            if (r101 != null) goto L6;
            return false;
        L6:
            l81.n r102 = ((INavigationProxyService) jc1.k.n(INavigationProxyService.class)).getILiveSdkProjectModeService();
            if (r102 == null) goto L11;
            r102.a(r101);
            return true;
        L11:
            return true;
        }
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void l(IRoom r100) {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void h() {
        this.f99836d = new UserInfoBasicPresenter(this.f99896c, this.f99841i);
        this.f99841i.setOnClickListener(new a(this));
        l81.n r100 = ((INavigationProxyService) jc1.k.n(INavigationProxyService.class)).getILiveSdkProjectModeService();
        if (r100 == null) goto L5;
        Boolean r101 = r100.isPerfToolsDebug();
    L7:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L10;
        this.f99841i.setOnLongClickListener(new b(this));
    L10:
        if (((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).isNewFeedStyle(getDataCenter()) == false) goto L12;
        this.f99841i.setBackground(s1.m(R.drawable.ttlive_bg_user_layout_optimize_new_style));
        b().getMiddleVm().getUserNameLayoutMaxWidthPx().setValue(Integer.valueOf((int) UIUtils.dip2Px(getContext(), this.f99837e)));
        return;
    L12:
        this.f99841i.setBackground(s1.m(R.drawable.ttlive_bg_user_layout_new_style));
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void j() {
        UserInfoBasicPresenter r100 = this.f99836d;
        if (r100 == null) goto L6;
        r100.e();
    L6:
        if (j1.f142014a.getValue().getFixUserInfo() == false) goto L9;
        this.f99841i.removeOnAttachStateChangeListener(this.f99839g);
        r3.o(getContext(), this.f99840h);
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void k() {
        UserInfoBasicPresenter r100 = this.f99836d;
        if (r100 == null) goto L16;
        if (r100.f100068c == true) goto L10;
        if (r100.f100069d == true) goto L10;
        r100.f100072f.setBackground(s1.m(R.drawable.ttlive_bg_user_layout_land));
    L10:
        if (r100.g() == false) goto L12;
    L14:
        r100.f100072f.setBackground(s1.m(R.drawable.ttlive_bg_user_layout));
        goto L16
    L12:
        if (((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).isNewFeedStyle(r100.a()) == false) goto L14;
        r100.f100072f.setBackground(s1.m(R.drawable.ttlive_bg_user_layout_optimize_new_style));
    L16:
        if (isAnchor() == true) goto L37;
        String[] r101 = {"money", "fans", "nothing", "room_money"};     // Catch: Exception -> L32
        HashMap r102 = new HashMap();     // Catch: Exception -> L32
        IRoom r103 = getRoom();     // Catch: Exception -> L32
        String r104 = "";
        if (r103 == null) goto L23;
        String r105 = r103.getOwnerUserIdString();     // Catch: Exception -> L32
        if (r105 == null) goto L23;
    L24:
        r102.put("anchor_id", r105);     // Catch: Exception -> L32
        IRoom r106 = getRoom();     // Catch: Exception -> L32
        if (r106 == null) goto L30;
        String r107 = r106.getIdStr();     // Catch: Exception -> L32
        if (r107 == null) goto L30;
        r104 = r107;
    L30:
        r102.put("room_id", r104);     // Catch: Exception -> L32
        r102.put("rank_type", r101[3]);     // Catch: Exception -> L32
        ((IHostLog) jc1.k.n(IHostLog.class)).logV3("livesdk_live_room_info", r102);     // Catch: Exception -> L32
        return;
    L23:
        r105 = "";
    L32:
        e = move-exception;
        Logger.throwException(e);
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void i() {
        ElementBasicVM r100 = b().getBasicVm();
        m(r100.getContainerContentDescription().a(), new UserInfoBasicElement$initVm$$inlined$run$lambda$1(this));
        m(r100.getAnchorContentDesc().a(), new UserInfoBasicElement$initVm$$inlined$run$lambda$2(this));
        m(r100.getShowProfile().onEvent(), new UserInfoBasicElement$initVm$$inlined$run$lambda$3(this));
        ViewGroup r101 = this.f99841i;
        IRoom r102 = getRoom();
        if (r102 == null) goto L7;
        String r103 = com.bytedance.android.live.room.navi.userinfo_p.utils.b.a(r102);
        if (r103 == null) goto L7;
    L8:
        r101.setContentDescription(r103);
        r3.e(this.f99841i, new UserInfoBasicElement$accessibilityCompat$1(this));
        if (j1.f142014a.getValue().getFixUserInfo() == false) goto L11;
        r3.f(getContext(), this.f99840h);
        this.f99841i.addOnAttachStateChangeListener(this.f99839g);
        return;
    L11:
        com.bytedance.android.live.room.navi.userinfo_p.element.b r104 = new com.bytedance.android.live.room.navi.userinfo_p.element.b(this);
        r3.f(getContext(), r104);
        this.f99841i.addOnAttachStateChangeListener(new com.bytedance.android.live.room.navi.userinfo_p.element.a(this, r104));
        return;
    L7:
        r103 = "";
        goto L8
    }

    public UserInfoBasicElement(m91.d r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r101, "anchorInfoContainer");
        super(r100);
        this.f99841i = r101;
        this.f99837e = 80.0f;
        this.f99838f = "UserInfoBasicElementAccError";
        this.f99839g = new c(this);
        this.f99840h = new d(this);
    }
}
