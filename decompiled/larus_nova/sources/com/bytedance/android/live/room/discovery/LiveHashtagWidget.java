package com.bytedance.android.live.room.discovery;

import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.rowcontract.RowRecyclableWidget;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.depend.hashtag.LiveHashTag;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.vj;
import com.bytedance.android.livesdk.config.yz;
import com.bytedance.android.livesdk.message.model.yj;
import com.bytedance.android.livesdkapi.depend.live.IBackRoomStackKt;
import com.bytedance.android.livesdkapi.depend.live.ILiveBackRoomStack;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveHashTagInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveHotSpotInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.CircleInfo;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.Unit;
import zg1.h1;

/* JADX INFO: loaded from: classes47.dex */
public class LiveHashtagWidget extends RowRecyclableWidget implements vlc.l, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f99292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f99293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f99294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f99295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vlc.d f99296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f99297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConstraintLayout f99298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Room f99299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f99300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f99301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f99302k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f99303l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CircleInfo f99304m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Dialog f99305n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DialogFragment f99306o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f99307p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f99308q;

    public class a extends com.bytedance.android.live.core.tetris.task.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LiveHashtagWidget f99309c;

        @Override // java.lang.Runnable
        public final void run() {
            LiveHashtagWidget r100 = this.f99309c;
            if (r100.f99304m == null) goto L8;
            r100.f99293b.setBackgroundResource(R.drawable.ttlive_icon_circle_hashtag);
            r100.f99294c.setBackgroundResource(R.drawable.ttlive_ic_circle_hashtag_desc);
            UIUtils.setViewVisibility(r100.f99293b, 0);
            UIUtils.setViewVisibility(r100.f99294c, 0);
            UIUtils.setViewVisibility(r100.f99295d, 8);
            r100.f99292a.setText(r100.f99304m.getCircleName());
            if (r100.f99300i == false) goto L7;
            UIUtils.setViewVisibility(r100.f99297f, 8);
            r100.f99298g.setOnClickListener(new z(r100));
        L41:
            b(true);
            return;
        L7:
            UIUtils.setViewVisibility(r100.f99297f, 0);
            r100.f99298g.setOnClickListener(new a0(r100));
            goto L41
        L8:
            View r101 = r100.f99292a;
            if (vj.f121455a.getValue().intValue() != 1) goto L11;
        L12:
            r101 = r100.contentView;
        L13:
            r101.setOnClickListener(new b0(r100));
            vlc.d r102 = (vlc.d) r100.dataCenter.get("data_message_manager", null);
            r100.f99296e = r102;
            if (r102 == null) goto L16;
            r102.addMessageListener(MessageType.ROOM_CHALLENGE_MESSAGE.getIntType(), r100);
        L16:
            LiveHashTagInfo r103 = r100.f99299h.getLiveHashTagInfo();
            LiveHotSpotInfo r104 = r100.f99299h.getLiveHotSpotInfo();
            if (r104 != null) goto L19;
        L21:
            r100.f99307p = true;
        L22:
            if (r103 != null) goto L24;
        L33:
            r100.containerView.setVisibility(8);
            Unit r105 = Unit.INSTANCE;
        L34:
            UIUtils.setViewVisibility(r100.f99297f, 8);
            r100.f99293b.setBackgroundResource(R.drawable.ttlive_icon_hashtag);
            r100.f99294c.setBackgroundResource(R.drawable.ttlive_ic_hashtag_desc);
            if (yz.f121726a.getValue().booleanValue() == false) goto L37;
        L40:
            UIUtils.setViewVisibility(r100.f99293b, 8);
            UIUtils.setViewVisibility(r100.f99294c, 8);
            UIUtils.setViewVisibility(r100.f99295d, 0);
            goto L41
        L37:
            if (r100.f99299h.isMergeVSRoom() == true) goto L40;
            UIUtils.setViewVisibility(r100.f99293b, 0);
            UIUtils.setViewVisibility(r100.f99294c, 0);
            UIUtils.setViewVisibility(r100.f99295d, 8);
            goto L41
        L24:
            if (TextUtils.isEmpty(r103.f162597id) == true) goto L33;
            if (TextUtils.isEmpty(r103.name) == true) goto L33;
            r100.zq(r103.f162597id, r103.name);
            LiveHashTag r106 = (LiveHashTag) r100.dataCenter.get("cmd_update_live_challenge", null);
            if (r106 != null) goto L30;
        L32:
            r100.xq(new LiveHashTag(r103.f162597id, r103.name));
            goto L34
        L30:
            if (TextUtils.equals(r103.f162597id, r106.getId()) == false) goto L32;
            r100.xq(r106);
            goto L34
        L19:
            if (TextUtils.isEmpty(r104.title) == true) goto L21;
            r100.f99307p = false;
            goto L22
        L11:
            if (r100.f99292a.isShown() == true) goto L13;
            goto L12
        }

        public a(LiveHashtagWidget r100) {
            this.f99309c = r100;
            super("hash_tag_widget_load");
        }
    }

    public class b implements IMiddlewareHostBusiness.HashTagCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f99310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveHashtagWidget f99311b;

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.HashTagCallback
        public final void onDismiss() {
        }

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.HashTagCallback
        public final void onShow() {
        }

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.HashTagCallback
        public final void onVideoRecordOpened() {
            xs2.b.a().post(new h1(32));
            this.f99311b.f99306o.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r100 = DialogFragmentLancet.sLastShowStack;
            if (r100 == null) goto L12;
            com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public b(LiveHashtagWidget r100, long r101) {
            this.f99311b = r100;
            this.f99310a = r101;
        }

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.HashTagCallback
        public final void onJumpToOtherRoom(long r100, String r101, long r102) {
            Bundle r103 = new Bundle();
            r103.putString("enter_from_merge", ILiveBackRoomStack.JUMP_SOURCE_LIVE_CHALLENGE);
            r103.putString("enter_method", "live_cell");
            r103.putString("anchor_id", r101);
            r103.putString(ILiveRoomPlayFragmentConstant.EXTRA_CHALLENGE_PAGE, "live_detail");
            r103.putString("tag_id", this.f99310a + "");
            if (r102 != 1) goto L5;
            String r104 = "autoCover";
        L6:
            r103.putString(ILiveRoomPlayFragmentConstant.EXTRA_COVER_TYPE, r104);
            JumpToOtherRoomEvent r105 = new JumpToOtherRoomEvent(r100, r103);
            vj r106 = vj.f121455a;
            if (r106.getValue().intValue() != 1) goto L9;
            r105.jumpSource = IBackRoomStackKt.JUMP_SOURCE_LIVE_CHALLENGE;
        L9:
            r105.source = "sourceJumpToOtherLiveHashTagW";
            xs2.b.a().post(r105);
            if (r106.getValue().intValue() != 1) goto L13;
            r103.putString("source", ILiveBackRoomStack.JUMP_SOURCE_LIVE_CHALLENGE);
            r103.putInt("back_source", 8);
            ContextUtil.contextToActivity(this.f99311b.context);
            DataCenter r107 = this.f99311b.dataCenter;
            return;
        L13:
            return;
        L5:
            r104 = "other";
            goto L6
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_hashtag_widget_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a241";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final Animator startShowAnimation() {
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        vlc.d r100 = this.f99296e;
        if (r100 == null) goto L5;
        r100.removeMessageListener(this);
    L5:
        this.f99302k = 0;
        this.f99301j = false;
        this.dataCenter.removeObserver(this);
        Dialog r101 = this.f99305n;
        if (r101 == null) goto L25;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r101);
    L22:
        this.f99305n = null;
        goto L25
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r103 == null) goto L21;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L10:
        if (Looper.myLooper() == r102.getLooper()) goto L12;
        r102.post(DialogLancet.createDismissRunnable(r101));
    L25:
        DialogFragment r104 = this.f99306o;
        if (r104 == null) goto L40;
        r104.dismissAllowingStateLoss();     // Catch: Exception -> L29
    L33:
        this.f99306o = null;
        return;
    L29:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L33;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L33
    }

    public LiveHashtagWidget() {
        this.f99303l = "";
        this.f99304m = null;
        this.f99307p = true;
        this.f99308q = true;
    }

    public static void wq(LiveHashtagWidget r100) {
        r100.getClass();
        HashMap r101 = new HashMap();
        if (r100.f99299h.isLiveTypeAudio() == false) goto L5;
        String r102 = "voice_live";
    L6:
        r101.put("live_type", r102);
        r101.put("anchor_id", r100.f99299h.getOwnerUserIdString());
        r101.put("room_id", r100.f99299h.getId() + "");
        int r103 = ((IInteractService) jc1.k.f(IInteractService.class)).getCurrentScene();
        com.bytedance.android.live.liveinteract.api.utils.a.f71509a.getClass();
        com.bytedance.android.live.liveinteract.api.utils.a.C1154a.b(r101, r103);
        if (r100.f99300i == false) goto L9;
        r101.put("user_type", "anchor");
    L10:
        CircleInfo r104 = r100.f99304m;
        if (r104 == null) goto L14;
        r101.put("circle_name", r104.getCircleName());
    L14:
        if (r100.f99300i == false) goto L16;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_circle_icon_click", r101, new Object[0]);
        return;
    L16:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_circle_icon_click", r101, new Object[]{am2.x.class});
        return;
    L9:
        r101.put("user_type", "user");
        goto L10
    L5:
        r102 = "video_live";
        goto L6
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (isViewValid() == false) goto L58;
        if (r101 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101.getKey()) == false) goto L8;
        return;
    L8:
        if (r101.getData() == null) goto L67;
        String r102 = r101.getKey();
        r102.getClass();
        switch(r102.hashCode()) {
            case -2095376959: goto L26;
            case 256598095: goto L22;
            case 294674590: goto L18;
            case 872172481: goto L14;
            default: goto L29;
        };
    L29:
        byte r103 = -1;
    L30:
        if (r103 != 0) goto L32;
        LiveHashTag r104 = (LiveHashTag) r101.getData();
        if (r104 == null) goto L69;
        zq(r104.getId(), r104.getName());
        return;
    L69:
        return;
    L32:
        if (r103 == 1) goto L50;
        if (r103 == 2) goto L38;
        if (r103 != 3) goto L68;
        ((Integer) r101.getData()).intValue();
        return;
    L68:
        return;
    L38:
        if (r101.getData() == null) goto L62;
        boolean r105 = ((Boolean) r101.getData()).booleanValue();
        LiveHashTagInfo r106 = this.f99299h.getLiveHashTagInfo();
        if (this.f99307p == false) goto L48;
        if (r105 == true) goto L48;
        if (r106 == null) goto L48;
        if (TextUtils.isEmpty(r106.f162597id) == true) goto L48;
        if (TextUtils.isEmpty(r106.name) == true) goto L48;
        UIUtils.setViewVisibility(this.containerView, 0);
        Unit r107 = Unit.INSTANCE;
        return;
    L48:
        UIUtils.setViewVisibility(this.containerView, 8);
        Unit r108 = Unit.INSTANCE;
        return;
    L62:
        return;
    L50:
        if (((Boolean) r101.getData()).booleanValue() == false) goto L52;
        this.f99307p = false;
        UIUtils.setViewVisibility(this.containerView, 8);
        Unit r109 = Unit.INSTANCE;
        return;
    L52:
        this.f99307p = true;
        zq(String.valueOf(this.f99302k), this.f99303l);
        return;
    L14:
        if (r102.equals("data_link_state") == false) goto L29;
        r103 = 3;
        goto L30
    L18:
        if (r102.equals("data_keyboard_status_douyin") == false) goto L29;
        r103 = 2;
        goto L30
    L22:
        if (r102.equals("cmd_update_live_hotspot_show") == false) goto L29;
        r103 = 1;
        goto L30
    L26:
        if (r102.equals("cmd_update_live_challenge") == false) goto L29;
        r103 = 0;
        goto L30
    L67:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f99292a = (TextView) findViewById(R.id.hashtag_desc_tv);
        this.f99293b = (ImageView) findViewById(R.id.icon_hashtag_iv);
        this.f99294c = (ImageView) findViewById(R.id.icon_hashtag_desc);
        this.f99295d = (ImageView) findViewById(R.id.icon_hashtag_new);
        this.f99297f = (ImageView) findViewById(R.id.icon_circle_detail_open);
        this.f99298g = (ConstraintLayout) findViewById(R.id.hashtag_container);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f99299h = (Room) this.dataCenter.get("data_room", null);
        DataCenter r101 = this.dataCenter;
        Boolean r102 = Boolean.FALSE;
        this.f99300i = ((Boolean) r101.get("data_is_anchor", r102)).booleanValue();
        this.f99301j = ((Boolean) this.dataCenter.get("data_is_from_back_to_pre_room", r102)).booleanValue();
        this.f99304m = (CircleInfo) this.f99299h.getCircleInfo();
        this.dataCenter.observe("cmd_update_live_challenge", this).observe("data_link_state", this).observe("data_keyboard_status_douyin", this).observe("cmd_update_live_hotspot_show", this);
        final a r103 = new a(this);
        RoomContext.a r104 = RoomContext.Companion;
        DataCenter r105 = this.dataCenter;
        long r106 = this.f99299h.getId();
        r104.getClass();
        RoomContext r107 = RoomContext.a.a(r105, r106);
        if (r107 == null) goto L6;
        r107.getWidgetLoadTaskScheduler().c(new x(this, r103));
    L6:
        if (this.f99301j == true) goto L8;
        return;
    L8:
        if ("live_challenge_live_detail".equals(this.dataCenter.get("data_from_back_scene", "")) == false) goto L12;
        yq(this.f99302k);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof yj) == false) goto L17;
        yj r101 = (yj) r100;
        LiveHashTagInfo r102 = r101.E();
        if (r102 == null) goto L12;
        zq(r102.f162597id, r102.name);
        this.f99299h.setLiveHashTagInfo(r101.G());
        LiveHashTag r103 = (LiveHashTag) this.dataCenter.get("cmd_update_live_challenge", null);
        if (r103 != null) goto L9;
    L11:
        xq(new LiveHashTag(r102.f162597id, r102.name));
    L13:
        String r104 = r101.getToastContent();
        if (TextUtils.isEmpty(r104) == true) goto L18;
        f2.c(r104, 0);
        return;
    L18:
        return;
    L9:
        if (TextUtils.equals(r102.f162597id, r103.getId()) == false) goto L11;
        xq(r103);
        goto L13
    L12:
        zq("0", "");
        this.f99299h.setLiveHashTagInfo(null);
        xq(null);
        goto L13
    }

    public final void xq(LiveHashTag r100) {
        if (this.f99304m == null) goto L5;
        return;
    L5:
        this.dataCenter.put("cmd_update_live_challenge", r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void yq(long r100) {
        if (((Integer) hd0.c.f().f481009b).intValue() != 2) goto L6;
        f2.b(R.string.live_room_link_status_toast, 0);
        return;
    L6:
        DialogFragment r101 = this.f99306o;
        if (r101 == null) goto L14;
        if (r101.getDialog() == null) goto L14;
        if (this.f99306o.getDialog().isShowing() == false) goto L14;
        return;
    L14:
        if (this.f99299h != null) goto L16;
        return;
    L16:
        HashMap r102 = new HashMap();
        r102.put("tag_id", String.valueOf(r100));
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_CHALLENGE_PAGE, "live_detail");
        r102.put("enter_from", ILiveBackRoomStack.JUMP_SOURCE_LIVE_CHALLENGE);
        com.bytedance.android.livesdk.log.filter.o r103 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r103 == null) goto L21;
        String r104 = r103.getMap().get("enter_from_merge");
        if ((r104 instanceof String) == false) goto L21;
        r102.put("previous_page", r104.toString());
    L21:
        com.bytedance.android.livesdk.log.u.l().e("enter_tag_detail", r102, new Object[]{new am2.x(), Room.class});
        this.f99306o = ((IHostBusiness) jc1.k.f(IHostBusiness.class)).showHashTagDialog((Activity) this.context, this.f99299h.liveHotSpotJsonStr, new b(this, r100));
    }

    public final void zq(String r110, String r111) {
        if (this.f99304m == null) goto L30;
        return;
    L30:
        Long r100 = CastLongProtector.valueOf(r110);     // Catch: NumberFormatException -> L28
        if (r100.longValue() != 0) goto L8;
    L13:
        this.f99303l = r111;     // Catch: NumberFormatException -> L28
        if (this.f99302k != 0) goto L17;
    L26:
        this.containerView.setVisibility(8);
        Unit r112 = Unit.INSTANCE;
        return;
    L17:
        if (TextUtils.isEmpty(r111) == true) goto L26;
        if (this.f99307p == false) goto L21;
        this.containerView.setVisibility(0);
        Unit r113 = Unit.INSTANCE;
    L23:
        if (this.f99299h.isMergeVSRoom() == false) goto L25;
        this.f99292a.setText("话题");
        return;
    L25:
        this.f99292a.setText(this.f99303l);
        return;
    L21:
        this.containerView.setVisibility(8);
        Unit r114 = Unit.INSTANCE;
        goto L23
    L8:
        if (this.f99302k == r100.longValue()) goto L13;
        long r101 = r100.longValue();     // Catch: NumberFormatException -> L28
        this.f99302k = r101;     // Catch: NumberFormatException -> L28
        if (this.f99300i == false) goto L12;
        com.bytedance.android.livesdk.log.l.a(r101);     // Catch: NumberFormatException -> L28
        goto L13
    L12:
        HashMap r102 = new HashMap();     // Catch: NumberFormatException -> L28
        r102.put("tag_id", String.valueOf(r101));     // Catch: NumberFormatException -> L28
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_challenge_show", r102, new Object[]{new am2.x(), Room.class});     // Catch: NumberFormatException -> L28
    L28:
        ALogger.e("hash_tag_info", "change hash tag id exception, tagId = " + r110 + ", tagName = " + r111);
    }
}
