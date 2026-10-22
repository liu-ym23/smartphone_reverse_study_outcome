package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.backroom.LiveBackRoomStackManager;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdk.config.oj1;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.event.BackRoomViewState;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.CircleProgressView;
import com.bytedance.android.livesdkapi.depend.live.IBackRoomStackKt;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.android.livesdkapi.eventbus.VSJumpCameraEvent;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes8.dex */
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f115437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f115438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f115439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f115440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CircleProgressView f115441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lifecycle f115442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ObjectAnimator f115443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f115444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f115445i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Bundle f115446j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f115447k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.live.base.model.g f115448l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, String> f115449m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f115450n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public BackRoomViewState.ChangeType f115451o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Disposable f115452p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f115453q;

    public static String b(int r100) {
        if (r100 != 17) goto L7;
        return "record";
    L7:
        if (r100 != 16) goto L11;
        return EnterRoomExtra.VS_TYPE_PREMIERE;
    L11:
        if (r100 != 15) goto L14;
        return "live";
    L14:
        return "";
    }

    public final boolean a(String r110) {
        Bundle r100 = this.f115446j;
        if (r100 != null) goto L5;
        return false;
    L5:
        long r101 = r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ITEM_ID, 0);
        com.bytedance.android.live.base.model.g r102 = this.f115448l;
        if (r102 != null) goto L8;
    L10:
        if (r102 != null) goto L12;
    L14:
        int r103 = 1;
    L16:
        if (r103 != 1) goto L43;
        int r104 = this.f115446j.getInt(VSConstants.EXTRA_ITEM_TYPE, 1);
        com.bytedance.android.livesdk.log.filter.o r111 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        com.bytedance.android.livesdk.log.filter.o r112 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        com.bytedance.android.livesdk.log.m0 r113 = new com.bytedance.android.livesdk.log.m0();
        r113.b("return_type", r110);
        ObjectAnimator r105 = this.f115443g;
        if (r105 != null) goto L20;
        long r114 = 0;
    L21:
        r113.b("process_duration", String.valueOf(r114));
        r113.a(r111, new String[]{"room_id", "anchor_id"});
        r113.b("to_room_id", String.valueOf(this.f115446j.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID)));
        r113.b("to_anchor_id", com.bytedance.android.live.base.model.user.n0.c(this.f115446j, "anchor_id"));
        Lazy r106 = LiveBackRoomStackManager.f105110a;
        r113.b("layer_level", String.valueOf(LiveBackRoomStackManager.b(ContextUtil.contextToActivity(this.f115444h)).size()));
        r113.b("orientation", String.valueOf(this.f115446j.getInt("orientation", 0)));
        r113.a(r112, new String[]{"enter_from_merge", "enter_method", "action_type"});
        if (r104 == 16) goto L27;
        if (r104 == 17) goto L27;
        if (r104 == 15) goto L27;
        r113.b("to_room_type", "normal_room");
    L28:
        com.bytedance.android.live.base.model.g r107 = this.f115448l;
        if ((r107 instanceof Room) == false) goto L34;
        if (((Room) r107).isMergeVSRoom() == false) goto L34;
        LiveVSLog.b r108 = LiveVSLog.f153393r;
        Room r109 = (Room) this.f115448l;
        r108.getClass();
        r113.c(LiveVSLog.b.a(r109).a());
    L34:
        if (this.f115446j.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_VS_LOG_EXTRA) == false) goto L42;
        LiveVSLog r115 = (LiveVSLog) this.f115446j.getParcelable(ILiveRoomPlayFragmentConstant.EXTRA_VS_LOG_EXTRA);
        if (r115 == null) goto L42;
        r113.b("to_vs_episode_id", r115.f153398e);
        r113.b("to_vs_ep_group_id", r115.f153396c);
        if (r115.f153402i != EpisodeMod.EpisodeStageType.PREMIERE) goto L40;
        String r116 = "vs_premiere";
    L41:
        r113.b("to_room_type", r116);
        goto L42
    L40:
        r116 = PriorityModule.SCENE_VS_LIVE;
    L42:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_return_click", r113.f153381a, new Object[]{Room.class, new am2.x(), am2.n.f()});
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_return_last_click", r113.f153381a, new Object[]{Room.class, new am2.x(), am2.n.f()});
    L48:
        RoomContext r117 = RoomContext.getShared();
        if (r117 != null) goto L51;
    L68:
        JumpToOtherRoomEvent r118 = new JumpToOtherRoomEvent(r101, com.bytedance.android.livesdk.chatroom.helper.a.a(this.f115446j), true, true);
        r118.source = "sourceJumpToOtherLiveBackRoomViewControllerV2";
        xs2.b.a().post(r118);
        return true;
    L51:
        if (r117.getRoom().getValue().getId() != r101) goto L68;
        long r119 = this.f115446j.getLong(VSConstants.EXTRA_VS_CAMERA_ID, 0);
        long r120 = this.f115446j.getLong(VSConstants.EXTRA_VS_MATCH_ID, 0);
        ALogger.i("LiveBackRoomViewControllerV2", "try jump to camera, cameraId:" + r119 + ", matchId:" + r120);
        if (r119 == 0) goto L68;
        if (dq1.b.b(r117.isVSRoom()) == true) goto L57;
        VSJumpCameraEvent r121 = new VSJumpCameraEvent();
        r121.setCameraId(r119);
        r121.setMatchId(r120);
        r121.setBackSource(IBackRoomStackKt.JUMP_SOURCE_ROOM_BACK);
        xs2.b.a().post(r121);
    L60:
        Lazy r122 = LiveBackRoomStackManager.f105110a;
        LiveBackRoomStackManager.b(ContextUtil.contextToActivity(this.f115444h)).popRoomInfo();
        if (this.f115440d == null) goto L66;
        ValueAnimator r123 = this.f115453q;
        if (r123 == null) goto L65;
        r123.cancel();
    L65:
        UIUtils.updateLayout(this.f115440d, -2, -3);
    L66:
        c(r101);
        return true;
    L57:
        if (pm1.f.a() == null) goto L60;
        pm1.f.a().l4(Long.valueOf(r119), null, false, IBackRoomStackKt.JUMP_SOURCE_ROOM_BACK, null);
    L27:
        r113.b("to_vs_episode_id", String.valueOf(this.f115446j.getLong(VSConstants.EXTRA_VS_EPISODE_ID, 0)));
        r113.b("to_vs_ep_group_id", this.f115446j.getString(VSConstants.EXTRA_EPISODE_GROUP_ID, ""));
        r113.b("to_room_type", "vs_room");
        r113.b("to_vs_episode_stage", b(r104));
        goto L28
    L20:
        r114 = r105.getCurrentPlayTime();
        goto L21
    L43:
        if (r103 == 15) goto L47;
        if (r103 == 16) goto L47;
        d("vs_video_return_last_click", r110);
    L47:
        d("vs_livesdk_return_last_click", r110);
        goto L48
    L12:
        if ((r102 instanceof Episode) == false) goto L14;
        r103 = 17;
        goto L16
    L8:
        if ((r102 instanceof Room) == false) goto L10;
        r103 = ArgumentsBuilder.getRoomType((Room) r102);
        goto L16
    }

    public final void c(long r100) {
        Lazy r101 = LiveBackRoomStackManager.f105110a;
        if (LiveBackRoomStackManager.b(ContextUtil.contextToActivity(this.f115444h)).peekRoomInfo() == null) goto L5;
        this.f115446j = LiveBackRoomStackManager.b(ContextUtil.contextToActivity(this.f115444h)).peekRoomInfo();
    L7:
        if (this.f115446j != null) goto L10;
        UIUtils.setViewVisibility(this.f115438b, 8);
        f(0);
        return;
    L10:
        com.bytedance.android.livesdk.config.m0 r102 = com.bytedance.android.livesdk.config.m0.f120721a;
        if (r102.getValue().enableOnlyBackPress() == false) goto L14;
        UIUtils.setViewVisibility(this.f115438b, 8);
        f(0);
        return;
    L14:
        Parcelable r103 = this.f115446j.getParcelable(ILiveRoomPlayFragmentConstant.EXTRA_PRE_AVATAR_THUMB);
        if ((r103 instanceof ImageModel) == false) goto L17;
        int r104 = this.f115437a;
        ImageLoader.bindAvatar(this.f115439c, (ImageModel) r103, r104, r104);
    L17:
        this.f115438b.setOnClickListener(new r1(this));
        CircleProgressView r105 = this.f115441e;
        if (tb1.c.f545229a == false) goto L20;
        int r106 = -54187;
    L21:
        r105.setBorderColor(r106);
        this.f115441e.setBorderWidth(com.bytedance.android.live.core.utils.s1.f(1.5f));
        this.f115441e.setCounterClockWise(false);
        long r107 = this.f115446j.getInt(ILiveRoomPlayFragmentConstant.EXTRA_ITEM_TYPE);
        if (r107 != VSConstants.VS_EPISODE) goto L24;
    L29:
        this.f115438b.setContentDescription(this.f115444h.getString(R.string.ttlive_back_to_pre_episode));
        this.f115440d.setText(R.string.ttlive_back_to_pre_episode);
    L30:
        String r108 = this.f115446j.getString(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_BACK_ENTRY_TEXT);
        if (TextUtils.isEmpty(r108) == true) goto L34;
        this.f115438b.setContentDescription(r108);
        this.f115440d.setText(r108);
    L34:
        if (r102.getValue().enableFixed() == true) goto L41;
        long r109 = r102.getValue().totalTime * 1000;
        ObjectAnimator r110 = this.f115443g;
        if (r110 == null) goto L38;
        r110.cancel();
    L38:
        ObjectAnimator r111 = ObjectAnimator.ofFloat(this.f115441e, "progress", new float[]{360.0f, 0.0f});
        this.f115443g = r111;
        if (r111 == null) goto L41;
        r111.setDuration(r109);
        this.f115443g.addListener(new q1(this));
        this.f115443g.start();
    L41:
        Context r112 = this.f115444h;
        if ((r112 instanceof Activity) == false) goto L44;
        j(((Activity) r112).getRequestedOrientation(), null);
    L44:
        f(0);
        long r113 = r102.getValue().delayTime * 1000;
        Disposable r114 = this.f115452p;
        if (r114 != null) goto L47;
    L49:
        this.f115452p = ((ObservableSubscribeProxy) Observable.just(this).delay(r113, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this.f115442f, Lifecycle.Event.ON_DESTROY)))).subscribe(new l1(), RxUtil.getNoOpThrowable());
        this.f115445i = Long.valueOf(r100);
        this.f115447k = true;
        if ((this.f115444h instanceof FragmentActivity) == false) goto L54;
        ((ObservableSubscribeProxy) xs2.b.a().b(zg1.t0.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) this.f115444h))).subscribe(new m1(this));
        return;
    L54:
        return;
    L47:
        if (r114.isDisposed() == true) goto L49;
        this.f115452p.dispose();
        goto L49
    L24:
        if (r107 == VSConstants.VS_FIRST_SHOW) goto L29;
        if (r107 == VSConstants.VS_LIVE) goto L29;
        this.f115438b.setContentDescription(this.f115444h.getString(R.string.ttlive_back_to_pre_room));
        this.f115440d.setText(R.string.ttlive_back_to_pre_room);
        goto L30
    L20:
        r106 = -45517;
        goto L21
    L5:
        this.f115446j = null;
        UIUtils.setViewVisibility(this.f115438b, 8);
        goto L7
    }

    public final void f(final int r100) {
        if (this.f115438b.getVisibility() != 0) goto L5;
        this.f115451o = BackRoomViewState.ChangeType.VISIBLE;
        this.f115450n = this.f115438b.getRight();
        this.f115438b.post(new n1(this, r100));
        return;
    L5:
        this.f115451o = BackRoomViewState.ChangeType.GONE;
        this.f115450n = 0;
        g(r100);
    }

    public final void g(int r100) {
        Long r101 = this.f115445i;
        if (r101 != null) goto L5;
    L7:
        RoomContext r102 = RoomContext.getShared();
    L8:
        com.bytedance.android.livesdk.interactivity.api.h r103 = com.bytedance.android.livesdk.interactivity.api.i.a(r102, null);
        if (r103 == null) goto L12;
        r103.getBackRoomViewState().setValue(new BackRoomViewState(this.f115451o, this.f115450n));
        r103.getBackRoomChanged().post(new o52.a(new BackRoomViewState(this.f115451o, this.f115450n), r100));
        return;
    L12:
        return;
    L5:
        if (r101.longValue() <= 0) goto L7;
        r102 = RoomContext.getShared(null, this.f115445i.longValue());
        goto L8
    }

    public final void h(boolean r100) {
        RoomContext r101 = RoomContext.getShared();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isVSSpecialDrawer() == false) goto L17;
        ViewGroup r102 = this.f115438b;
        if (r102 == null) goto L19;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102.getLayoutParams();
        if (r103 == null) goto L18;
        if (r100 == false) goto L13;
        r103.bottomMargin = com.bytedance.android.live.core.utils.s1.f(98.0f);
    L14:
        this.f115438b.setLayoutParams(r103);
        return;
    L13:
        r103.bottomMargin = com.bytedance.android.live.core.utils.s1.f(52.0f);
        goto L14
    L18:
        return;
    L19:
        return;
    }

    public final void i(boolean r100) {
        ViewGroup r101 = this.f115438b;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100 == false) goto L9;
        r101.setVisibility(8);
    L20:
        f(0);
        return;
    L9:
        if (this.f115446j == null) goto L20;
        ObjectAnimator r102 = this.f115443g;
        if (r102 == null) goto L15;
        if (r102.isRunning() == false) goto L15;
    L16:
        boolean r103 = true;
    L18:
        if (r103 == false) goto L20;
        this.f115438b.setVisibility(0);
    L15:
        if (com.bytedance.android.livesdk.config.m0.f120721a.getValue().enableFixed() == true) goto L16;
        r103 = false;
        goto L18
    }

    public final void d(String r110, String r111) {
        long r100 = this.f115446j.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID, 0);
        int r101 = this.f115446j.getInt(VSConstants.EXTRA_ITEM_TYPE, 1);
        Map<String, String> r102 = this.f115449m;
        if (r102 != null) goto L5;
        r102 = new HashMap();
    L5:
        HashMap r103 = new HashMap();
        r103.put("return_type", r111);
        ObjectAnimator r112 = this.f115443g;
        if (r112 != null) goto L8;
        long r104 = 0;
    L9:
        r103.put("process_duration", String.valueOf(r104));
        Lazy r113 = LiveBackRoomStackManager.f105110a;
        r103.put("layer_level", String.valueOf(LiveBackRoomStackManager.b(ContextUtil.contextToActivity(this.f115444h)).size()));
        r103.put("orientation", String.valueOf(this.f115446j.getInt("orientation", 0)));
        if (r101 != 16) goto L12;
    L17:
        r102.put("to_vs_episode_id", String.valueOf(this.f115446j.getLong(VSConstants.EXTRA_VS_EPISODE_ID, 0)));
        r102.put("to_vs_ep_group_id", this.f115446j.getString(VSConstants.EXTRA_EPISODE_GROUP_ID, ""));
        r102.put("to_room_type", "vs_room");
        r102.put("to_vs_episode_stage", b(r101));
    L18:
        r102.put("to_room_id", String.valueOf(r100));
        r102.put("to_anchor_id", com.bytedance.android.live.base.model.user.n0.c(this.f115446j, "anchor_id"));
        r102.putAll(r103);
        com.bytedance.android.livesdk.vs.f.f159373c.c(r110, r102, new Object[0]);
        return;
    L12:
        if (r101 == 17) goto L17;
        if (r101 == 15) goto L17;
        r102.put("to_room_type", "normal_room");
        goto L18
    L8:
        r104 = r112.getCurrentPlayTime();
        goto L9
    }

    public final void e(String r110, Map<String, String> r111) {
        long r100 = this.f115446j.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ITEM_ID, 0);
        int r101 = this.f115446j.getInt(VSConstants.EXTRA_ITEM_TYPE, 1);
        if (r111 != null) goto L5;
        r111 = new HashMap();
    L5:
        Lazy r102 = LiveBackRoomStackManager.f105110a;
        r111.put("layer_level", String.valueOf(LiveBackRoomStackManager.b(ContextUtil.contextToActivity(this.f115444h)).size()));
        r111.put("orientation", String.valueOf(this.f115446j.getInt("orientation", 0)));
        if (r101 != 16) goto L8;
    L12:
        r111.put("to_vs_episode_id", String.valueOf(this.f115446j.getLong(VSConstants.EXTRA_VS_EPISODE_ID, 0)));
        r111.put("to_vs_ep_group_id", this.f115446j.getString(VSConstants.EXTRA_EPISODE_GROUP_ID, ""));
        r111.put("to_room_type", "vs_room");
        r111.put("to_vs_episode_stage", b(r101));
    L13:
        if (r101 == 15) goto L16;
        if (r101 == 1) goto L16;
        if (r101 == 16) goto L16;
    L17:
        com.bytedance.android.livesdk.vs.f.f159373c.c(r110, r111, new Object[0]);
        return;
    L16:
        r111.put("to_room_id", String.valueOf(r100));
        r111.put("to_anchor_id", com.bytedance.android.live.base.model.user.n0.c(this.f115446j, "anchor_id"));
        goto L17
    L8:
        if (r101 == 17) goto L12;
        if (r101 == 15) goto L12;
        r111.put("to_room_type", "normal_room");
        goto L13
    }

    public final void j(int r100, Configuration r101) {
        if (this.f115446j == null) goto L41;
        ObjectAnimator r102 = this.f115443g;
        if (r102 == null) goto L9;
        if (r102.isRunning() == false) goto L9;
    L10:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L41;
        if (r101 == null) goto L16;
    L18:
        RoomContext r104 = RoomContext.getShared();
        if (r100 == 1) goto L38;
        if (r101 != null) goto L22;
    L24:
        if (r104 != null) goto L26;
    L39:
        f(0);
        return;
    L26:
        if (r104.isVSSpecialDrawer() == false) goto L39;
        if (oj1.f120911a.getValue().b() == false) goto L39;
        if (PadConfigUtils.c() == true) goto L32;
    L34:
        if (r100 != 0) goto L36;
    L37:
        i(false);
        h(true);
        goto L39
    L36:
        if (r100 != 8) goto L39;
    L32:
        if (r100 != 13) goto L34;
        i(false);
        h(true);
        goto L39
    L22:
        if (r101.orientation != 1) goto L24;
    L38:
        i(false);
        h(false);
        goto L39
    L16:
        if (com.bytedance.android.live.core.utils.s1.getResources() == null) goto L18;
        r101 = com.bytedance.android.live.core.utils.s1.getResources().getConfiguration();
    L9:
        if (com.bytedance.android.livesdk.config.m0.f120721a.getValue().enableFixed() == true) goto L10;
        r103 = false;
    L41:
        i(true);
    }

    public s1(Context r100, Lifecycle r101, ViewGroup r102) {
        this.f115447k = false;
        this.f115450n = 0;
        this.f115451o = BackRoomViewState.ChangeType.GONE;
        this.f115442f = r101;
        this.f115438b = r102;
        this.f115444h = r100;
        if (r100 == null) goto L6;
        this.f115439c = (HSImageView) r102.findViewById(R.id.user_avatar);
        this.f115440d = (TextView) r102.findViewById(R.id.back_pre_desc_tv);
        this.f115441e = (CircleProgressView) r102.findViewById(R.id.circle_progress_view);
        UIUtils.updateLayout(r102, -3, com.bytedance.android.live.core.utils.s1.f(26.0f));
    L6:
        this.f115437a = (int) UIUtils.dip2Px(r100, 20.0f);
    }
}
