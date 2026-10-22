package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.dsl.api.IDSLManagerService;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.user.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.o;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;
import yt1.q;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/BaseElementPresenter;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseElementPresenter implements l, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f100066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.d f100067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f100068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f100069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m91.c f100070e;

    @Override // vlc.l
    public void onMessage(tlc.d r100) {
    }

    public final DataCenter a() {
        return this.f100070e.getDataCenter();
    }

    public void e() {
        this.f100066a.clear();
        vlc.d r100 = this.f100067b;
        if (r100 == null) goto L5;
        r100.removeMessageListener(this);
    L5:
        DataCenter r101 = a();
        if (r101 == null) goto L9;
        r101.removeObserver(this);
        return;
    }

    public final IRoom b() {
        DataCenter r100 = a();
        if (r100 != null) goto L5;
        return null;
    L5:
        return (IRoom) r100.get("data_room", null);
    }

    public final boolean c() {
        if (a0.i(a()) == false) goto L5;
    L14:
        return true;
    L5:
        if (a0.f(a()) == true) goto L14;
        if (a0.h(a()) == true) goto L14;
        if (a0.g(a()) == true) goto L14;
        if (((IMiddlewareRoomService) k.n(IMiddlewareRoomService.class)).isNewFeedStyle(a()) == true) goto L14;
        return false;
    }

    public final boolean d() {
        if (g() == false) goto L5;
    L9:
        return false;
    L5:
        if (((IMiddlewareRoomService) k.n(IMiddlewareRoomService.class)).isNewFeedStyle(a()) == false) goto L7;
    L8:
        return true;
    L7:
        if (((IMiddlewareRoomService) k.n(IMiddlewareRoomService.class)).isNewStyleForTTLite(a()) == false) goto L9;
        goto L8
    }

    public final boolean g() {
        if (a0.i(a()) == false) goto L5;
    L12:
        return true;
    L5:
        if (a0.h(a()) == true) goto L12;
        if (a0.f(a()) == true) goto L12;
        if (a0.g(a()) == true) goto L12;
        return false;
    }

    public BaseElementPresenter(m91.c r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfoAbility");
        this.f100070e = r100;
        this.f100066a = new CompositeDisposable();
        DataCenter r101 = a();
        vlc.d r102 = null;
        if (r101 == null) goto L5;
        r102 = (vlc.d) r101.get("data_message_manager", null);
    L5:
        this.f100067b = r102;
        DataCenter r103 = a();
        if (r103 == null) goto L10;
        Boolean r104 = (Boolean) r103.get("data_is_anchor", Boolean.FALSE);
        if (r104 == null) goto L10;
        boolean r105 = r104.booleanValue();
    L11:
        this.f100068c = r105;
        DataCenter r106 = a();
        if (r106 == null) goto L16;
        Boolean r107 = (Boolean) r106.get("data_is_portrait", Boolean.TRUE);
        if (r107 == null) goto L16;
        boolean r108 = r107.booleanValue();
    L17:
        this.f100069d = r108;
        return;
    L16:
        r108 = true;
    L10:
        r105 = false;
        goto L11
    }

    public final void f(Map<String, String> r110) {
        IRoom r100 = b();
        if (r100 == null) goto L41;
        IBaseUser r101 = r100.getOwner();
        if (r101 == null) goto L46;
        UserProfileEvent r102 = new UserProfileEvent(r101.getIdString());
        r102.mSource = UserProfileEvent.SOURCE_ANCHOR_AVATAR;
        r102.setClickUserPosition(UserProfileEvent.POSITION_OPEN_TOP_LEFT_ANCHOR);
        r102.setReportType(UserProfileEvent.DATA_TYPE_CARD_ANCHOR);
        r102.setExtraFollowParams(j.b(LiveFollowScene.PROFILE_USER_INFO));
        if (r110 == null) goto L14;
        Iterator<Map.Entry<String, String>> r111 = r110.entrySet().iterator();
    L11:
        if (r111.hasNext() == false) goto L14;
        Map.Entry<String, String> r103 = r111.next();
        r102.addProfileClickUserExtraLog(r103.getKey(), r103.getValue());
    L14:
        if (r101.getBorder() == null) goto L24;
        py.f r112 = r101.getBorder();
        String r104 = null;
        if (r112 == null) goto L18;
        String r113 = r112.getDressId();
    L19:
        if (r113 == null) goto L24;
        py.f r114 = r101.getBorder();
        if (r114 == null) goto L23;
        r104 = r114.getDressId();
    L23:
        r102.wearId = r104;
        goto L24
    L18:
        r113 = null;
    L24:
        xs2.b.a().post(r102);
        ((IMiddlewareRoomService) k.n(IMiddlewareRoomService.class)).userInfoAutoAntiDeterioration();
        Integer r115 = ev1.e.f474215a.getValue();
        if (r115 != null) goto L28;
        return;
    L28:
        if (r115.intValue() != 2) goto L42;
        Integer r116 = ev1.f.f474216a.getValue();
        if (r116 != null) goto L33;
        return;
    L33:
        if (r116.intValue() != 1) goto L43;
        String r105 = ns0.d.f520283a;
        q r117 = new q("shop_card_slice", r105);
        IDSLManagerService r106 = (IDSLManagerService) k.f(IDSLManagerService.class);
        if (r106 != null) goto L37;
        return;
    L37:
        if (r106.hasLocalGlobalCache(r117) == true) goto L45;
        ALogger.i("Live_LynxAir", "start preload.");
        int r118 = com.bytedance.android.anniex.api.b.f40245a;
        Intrinsics.checkNotNullParameter(r105, "url");
        com.bytedance.ies.bullet.forest.f<String, o> r119 = ForestLoader.f246728a;
        ForestLoader.k(null, r105, false, null, PreloadType.LYNX, true, "AnnieX_card", null, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK);
        return;
    L45:
        return;
    L43:
        return;
    L42:
        return;
    L46:
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
    }
}
