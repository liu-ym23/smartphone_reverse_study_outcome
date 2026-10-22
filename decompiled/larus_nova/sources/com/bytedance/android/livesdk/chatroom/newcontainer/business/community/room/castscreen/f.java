package com.bytedance.android.livesdk.chatroom.newcontainer.business.community.room.castscreen;

import am2.x;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostLiveByteCast;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastSourceOptionConstant;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIHelper;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;
import com.bytedance.android.livesdk.castscreen.utils.LivePadPcLogger;
import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.config.jj;
import com.bytedance.android.livesdk.config.lj;
import com.bytedance.android.livesdk.config.oj;
import com.bytedance.android.livesdk.config.p;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdk.room.state.RoomDataType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.util.LiveSdkApiBundleOptUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import ts2.i;
import ts2.j;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends com.bytedance.android.livesdk.room.c<ls2.c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f107441b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f107442a = null;

        static {
            int[] r100 = new int[LiveMode.values().length];
            f107442a = r100;
            r100[LiveMode.AUDIO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f107442a[LiveMode.THIRD_PARTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    public f() {
        this.f107441b = null;
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void i(com.bytedance.android.livesdk.room.b r100) {
        d r101 = this.f107441b;
        if (r101 == null) goto L5;
        r101.disable();
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void s(com.bytedance.android.livesdk.room.b r100) {
        ((yj1.a) r100.b("RoomDataConst_live_room_player_context")).f568057d.getEventHub().getSeiUpdate().observe(r100.f510501h, new e(this, r100));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void u(com.bytedance.android.livesdk.room.b r100) {
        ik1.c r101 = jk1.a.c(r100);
        if (r101.f490211d == null) goto L5;
        int r102 = com.bytedance.android.livesdk.castscreen.api.b.f104452a;
    L5:
        FragmentActivity r103 = (FragmentActivity) r100.getActivity();
        if (r103 == null) goto L13;
        if (PadConfigUtils.a() == false) goto L13;
        if (oj.f120909a.getValue().booleanValue() == false) goto L13;
        d r104 = new d(this, r103, r100, r101);
        this.f107441b = r104;
        r104.enable();
    L13:
        if (CastScreenViewModel.getShared() != null) goto L15;
        new CastScreenViewModel();
    L15:
        z(r100, r101);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public static void B(com.bytedance.android.livesdk.room.b r100, String r101) {
        if (r101.contains("common_in_anchor_cast_sei") == false) goto L38;
        LiveSeiUtil.f71508i.getClass();     // Catch: JSONException -> L34
        JSONObject r102 = LiveSeiUtil.c(r101);     // Catch: JSONException -> L34
        boolean r103 = JSONObjectProtectorUtils.getBoolean(JSONObjectProtectorUtils.getJSONObject(r102, "common_in_anchor_cast_sei"), "is_castScreening");     // Catch: JSONException -> L34
        boolean r104 = JSONObjectProtectorUtils.getBoolean(JSONObjectProtectorUtils.getJSONObject(r102, "common_in_anchor_cast_sei"), "is_Applet");     // Catch: JSONException -> L34
        String r105 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r102, "common_in_anchor_cast_sei"), "cast_scene");     // Catch: JSONException -> L34
        String r106 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r102, "common_in_anchor_cast_sei"), "cast_biz_value");     // Catch: JSONException -> L34
        RoomContext r107 = jk1.a.d(r100);     // Catch: JSONException -> L34
        if (r103 == false) goto L17;
        if (r104 == false) goto L12;
        if (r107.isCastingForAudience().getValue().booleanValue() == true) goto L12;
        ((IOpenPlatformAudienceService) k.f(IOpenPlatformAudienceService.class)).hideMiniAppExplainCard();     // Catch: JSONException -> L34
    L12:
        if (r107.isCastingForAudience().getValue().booleanValue() == true) goto L14;
        A(r100, r105, r106);     // Catch: JSONException -> L34
    L14:
        m<Boolean> r108 = r107.isCastingForAudience();     // Catch: JSONException -> L34
        Boolean r109 = Boolean.TRUE;     // Catch: JSONException -> L34
        r108.setValue(r109);     // Catch: JSONException -> L34
        r107.isEverCast().setValue(r109);     // Catch: JSONException -> L34
        ((IInteractService) k.f(IInteractService.class)).setLinkEverCast(r100.f510496c.longValue());     // Catch: JSONException -> L34
        r100.f157610s.put("data_common_casting_show", r109);     // Catch: JSONException -> L34
        return;
    L17:
        if (p.f120944a.getValue().booleanValue() == true) goto L19;
        if (r104 == true) goto L29;
        if ("applet".equals(r106) == true) goto L29;
    L31:
        r107.isCastingForAudience().setValue(Boolean.FALSE);     // Catch: JSONException -> L34
    L32:
        r100.f157610s.put("data_common_casting_show", Boolean.FALSE);     // Catch: JSONException -> L34
        return;
    L29:
        if (r107.isCastingForAudience().getValue().booleanValue() == false) goto L31;
        ((IOpenPlatformAudienceService) k.f(IOpenPlatformAudienceService.class)).showMiniAppExplainCard();     // Catch: JSONException -> L34
        goto L31
    L19:
        if (r107.isCastingForAudience().getValue().booleanValue() == false) goto L32;
        r107.isCastingForAudience().setValue(Boolean.FALSE);     // Catch: JSONException -> L34
        if (r104 == false) goto L23;
    L24:
        ((IOpenPlatformAudienceService) k.f(IOpenPlatformAudienceService.class)).showMiniAppExplainCard();     // Catch: JSONException -> L34
        goto L32
    L23:
        if ("applet".equals(r106) == false) goto L32;
    L34:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void z(final com.bytedance.android.livesdk.room.b r100, final ik1.c r101) {
        if (oj.f120909a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (PadConfigUtils.a() == false) goto L22;
        final CastScreenViewModel r102 = CastScreenViewModel.getShared();
        Consumer<? super Boolean> r103 = new com.bytedance.android.livesdk.chatroom.newcontainer.business.community.room.castscreen.a(r102, r100, r101);
        if (r102 != null) goto L19;
    L12:
        boolean r104 = false;
    L13:
        r103.accept(Boolean.valueOf(r104));     // Catch: Exception -> L11
    L14:
        if (r102 == null) goto L23;
        Observable<Boolean> r105 = r102.getCastOrMirrorScreenMode().a();
        if (r105 == null) goto L24;
        r105.subscribe(r103);
        return;
    L24:
        return;
    L23:
        return;
    L19:
        if (r102.getCastOrMirrorScreenMode().getValue().booleanValue() == false) goto L12;
        r104 = true;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void n(com.bytedance.android.livesdk.room.b r100, i r101) {
        if (r101.f547349b != RoomDataType.ALL_ROOM) goto L27;
        String r102 = r100.f510497d.getString("enter_from_merge", "");
        String r103 = r100.f510497d.getString(ILiveRoomPlayFragmentConstant.EXTRA_IS_APP_LOGIN, "");
        String r104 = r100.f510497d.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENABLE_PAD_CAST_LOGIN, "");
        Bundle r105 = LiveSdkApiBundleOptUtils.getBundleBinderData(r100.f510497d, "live.intent.extra.ENTER_LIVE_EXTRA");
        if (r105 != null) goto L7;
    L12:
        boolean r106 = "1".equals(r103);
        boolean r107 = "1".equals(r104);
        boolean r108 = ((IUserService) k.f(IUserService.class)).user().isLogin();
        ArrayList<String> r109 = com.bytedance.android.livesdk.castscreen.utils.d.f104735a;
        Intrinsics.checkNotNullParameter(r102, "enterFromMerge");
        if (Intrinsics.areEqual(r102, "screen_share_to_pad") == false) goto L20;
        if (r106 == false) goto L18;
        if (r108 == true) goto L18;
        if (r107 == true) goto L20;
    L18:
        if (PadConfigUtils.c() == false) goto L20;
        f2.c("正在播放手机端的直播", 0);
    L20:
        ik1.c r110 = jk1.a.c(r100);
        Intrinsics.checkNotNullParameter(r102, "enterFromMerge");
        if (Intrinsics.areEqual(r102, "scan_share_to_pad") == false) goto L27;
        RoomSession r111 = r110.f490211d;
        if (r111 == null) goto L27;
        Bundle r112 = r111.getExtra();
        if (r112 == null) goto L27;
        String r113 = r112.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_EXTRA_PARAMS, "");
        LivePadPcLogger.e(r100.f157610s, r113);
        goto L27
    L7:
        if (TextUtils.isEmpty(r103) == false) goto L10;
        r103 = r105.getString(ILiveRoomPlayFragmentConstant.EXTRA_IS_APP_LOGIN);
    L10:
        if (TextUtils.isEmpty(r104) == false) goto L12;
        r104 = r105.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENABLE_PAD_CAST_LOGIN);
    L27:
        String r114 = LiveByteCastUIManager.f104549a;
        Room r115 = r100.f157611t;
        WeakReference<com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a> r116 = LiveByteCastUIManager.f104553e;
        if (r116 == null) goto L32;
        com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a r117 = r116.get();
        if (r117 == null) goto L32;
        r117.i();
    L32:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void t(final com.bytedance.android.livesdk.room.b r100, ts2.f r101) {
        String r102 = LiveByteCastUIManager.f104549a;
        DataCenter r103 = r100.f157610s;
        r100.f157617z.add(xs2.b.a().b(pv0.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r100), new c()));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public static void A(com.bytedance.android.livesdk.room.b r100, String r101, String r102) {
        HashMap r103 = new HashMap();
        Room r104 = r100.f157611t;
        if (r104 == null) goto L5;
        r103.put("anchor_id", r104.getOwnerUserIdString());
    L5:
        r103.put("room_id", String.valueOf(r100.f510496c));
        int r105 = a.f107442a[jk1.a.c(r100).f490211d.getStreamType().ordinal()];
        if (r105 == 1) goto L10;
        if (r105 == 2) goto L9;
        String r106 = "video_live";
    L11:
        r103.put("live_type", r106);
        r103.put("cast_scene", r101);
        r103.put("cast_biz_value", r102);
        u.l().sendLog("livesdk_anchor_screenprojection_audience_side_show", r103, new Object[]{Room.class, x.class});
        return;
    L9:
        r106 = PriorityModule.SCENE_THIRD_PARTY;
        goto L11
    L10:
        r106 = "voice_live";
        goto L11
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void f(com.bytedance.android.livesdk.room.b r100, ContainerLifecycle r110, ts2.a r111) {
        boolean r101 = false;
        if (r110 != ContainerLifecycle.ON_DESTROY) goto L33;
        String r102 = LiveByteCastUIManager.f104549a;
        DataCenter r103 = r100.f157610s;
        Room r104 = r100.f157611t;
        if (jj.f120530a.getValue().booleanValue() == true) goto L27;
        WeakReference<com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a> r105 = LiveByteCastUIManager.f104553e;
        Long r106 = null;
        if (r105 == null) goto L11;
        com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a r107 = r105.get();
        if (r107 == null) goto L11;
        Room r108 = r107.l();
    L12:
        if (r104 == null) goto L14;
        Long r109 = Long.valueOf(r104.getRoomId());
    L15:
        if (r108 == null) goto L18;
        r106 = Long.valueOf(r108.getRoomId());
    L18:
        if ((!Intrinsics.areEqual(r109, r106)) == false) goto L23;
        if (r103 == null) goto L33;
        if (qf1.a.b(r103) != true) goto L33;
    L23:
        qf1.a.c(r103, false);
        qf1.a.d(r103, false);
        Iterator<T> r112 = LiveByteCastUIManager.f104550b.iterator();
    L25:
        if (r112.hasNext() == false) goto L27;
        ((LiveByteCastUIManager.a) r112.next()).x7();
        goto L25
    L14:
        r109 = null;
    L11:
        r108 = null;
    L27:
        if (r104 == null) goto L31;
        IHostLiveByteCast r113 = LiveByteCastUIManager.k();
        if (r113 == null) goto L31;
        r113.sendBusinessEvent(LiveCastSourceOptionConstant.OPTION_LIVE_ROOM_CLOSE, new JSONObject());
    L31:
        LiveByteCastUIHelper.f104525c.clear();
    L33:
        if (r110 == ContainerLifecycle.ON_PAGE_SCROLL_STATE_CHANGED_CALL_BACK) goto L35;
    L52:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L35:
        if (((j) r111).f547350a.intValue() != 1) goto L52;
        Activity r114 = r100.getActivity();
        if (r114 != null) goto L39;
    L47:
        if (r101 == false) goto L52;
        RoomContext r115 = jk1.a.d(r100);
        if (lj.f120685a.getValue().b() != 2) goto L51;
        r115.isShowFullScreenUIByClickScreen().setValue(Boolean.FALSE);
    L51:
        r115.isShowCastScreenUIByClickScreen().setValue(Boolean.FALSE);
        goto L52
    L39:
        if (r114.isFinishing() == true) goto L47;
        if (r114.isDestroyed() == true) goto L47;
        if (((BaseFragment) r100.f510501h).isDestroyed() == true) goto L47;
        if (r100.f510501h.isDetached() == true) goto L47;
        r101 = true;
        goto L47
    }
}
