package com.bytedance.android.live.room.discovery;

import android.animation.Animator;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.rowcontract.RowRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.u0;
import com.bytedance.android.livesdk.config.yz;
import com.bytedance.android.livesdk.message.model.ak;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveHotSpotInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public class LiveHotSpotWidget extends RowRecyclableWidget implements vlc.l, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f99312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f99313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f99314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f99315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f99316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f99317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Room f99318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f99319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f99320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public vlc.d f99321j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Dialog f99322k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f99323l;

    public class a extends com.bytedance.android.live.core.tetris.task.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LiveHotSpotWidget f99324c;

        @Override // java.lang.Runnable
        public final void run() {
            LiveHotSpotWidget r100 = this.f99324c;
            LiveHotSpotInfo r101 = r100.f99318g.getLiveHotSpotInfo();
            if (r100.xq() == false) goto L5;
            r100.containerView.setVisibility(8);
            Unit r102 = Unit.INSTANCE;
        L11:
            ViewGroup.LayoutParams r103 = r100.f99317f.getLayoutParams();
            Room r104 = r100.f99318g;
            if (r104 != null) goto L14;
        L18:
            r100.f99312a.setMaxWidth((int) UIUtils.dip2Px(r100.getContext(), 80.0f));
            if (r103 == null) goto L21;
            r103.height = (int) UIUtils.dip2Px(r100.getContext(), 20.0f);
        L21:
            r100.f99317f.setLayoutParams(r103);
            b(true);
            return;
        L14:
            if (r104.isMediaRoom() == false) goto L18;
            r100.f99312a.setMaxWidth((int) UIUtils.dip2Px(r100.getContext(), 80.0f));
            if (r103 == null) goto L21;
            r103.height = (int) UIUtils.dip2Px(r100.getContext(), 22.0f);
            goto L21
        L5:
            if (r101 != null) goto L7;
        L10:
            r100.containerView.setVisibility(8);
            Unit r105 = Unit.INSTANCE;
            goto L11
        L7:
            if (TextUtils.isEmpty(r101.title) == true) goto L10;
            r100.yq(r101.title);
            r100.wq();
            goto L11
        }

        public a(LiveHotSpotWidget r100) {
            this.f99324c = r100;
            super("hot_spot_widget_load");
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_hotspot_widget_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a145";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final Animator startShowAnimation() {
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        vlc.d r100 = this.f99321j;
        if (r100 == null) goto L5;
        r100.removeMessageListener(this);
    L5:
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L8;
        r101.removeObserver(this);
    L8:
        Dialog r102 = this.f99322k;
        if (r102 == null) goto L28;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r102);
    L25:
        this.f99322k = null;
        goto L28
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r104 == null) goto L24;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L24
    L13:
        if (Looper.myLooper() == r103.getLooper()) goto L15;
        r103.post(DialogLancet.createDismissRunnable(r102));
    L28:
        this.f99320i = "";
    }

    public final void wq() {
        HashMap r100 = new HashMap();
        r100.put("trending_topic", String.valueOf(this.f99320i));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_topic_show", r100, new Object[]{new am2.x(), Room.class});
    }

    public final boolean xq() {
        DataCenter r100 = this.dataCenter;
        if (r100 != null) goto L5;
        return false;
    L5:
        u0 r101 = (u0) r100.get("data_hot_spot_room_info", null);
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.f106973a == true) goto L11;
        return false;
    L11:
        if (r101.f106974b == false) goto L15;
        return true;
    L15:
        return false;
    }

    public LiveHotSpotWidget() {
        this.f99320i = "";
        this.f99323l = "";
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (xq() == false) goto L6;
        return;
    L6:
        if ("data_keyboard_status_douyin".equals(r101.getKey()) == true) goto L8;
        return;
    L8:
        if (r101.getData() != null) goto L10;
        return;
    L10:
        if (((Boolean) r101.getData()).booleanValue() == false) goto L12;
        UIUtils.setViewVisibility(this.containerView, 8);
        Unit r102 = Unit.INSTANCE;
        return;
    L12:
        yq(this.f99320i);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f99312a = (TextView) findViewById(R.id.hotspot_desc_tv);
        this.f99313b = (ImageView) findViewById(R.id.fold_iv);
        this.f99317f = (ViewGroup) findViewById(R.id.hotspot_container);
        this.f99314c = (ImageView) findViewById(R.id.icon_hotspot_iv);
        this.f99315d = (ImageView) findViewById(R.id.icon_hotspot_desc);
        this.f99316e = (ImageView) findViewById(R.id.icon_hotspot_new);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f99318g = (Room) this.dataCenter.get("data_room", null);
        this.f99319h = ((Boolean) this.dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.f99313b.setRotation(0.0f);
        this.f99317f.setOnClickListener(new d0(this));
        vlc.d r101 = (vlc.d) this.dataCenter.get("data_message_manager", null);
        this.f99321j = r101;
        if (r101 == null) goto L5;
        r101.addMessageListener(MessageType.ROOM_HOTSPOT_MESSAGE.getIntType(), this);
    L5:
        this.dataCenter.observe("data_keyboard_status_douyin", this);
        final a r102 = new a(this);
        RoomContext.a r103 = RoomContext.Companion;
        DataCenter r104 = this.dataCenter;
        long r105 = this.f99318g.getId();
        r103.getClass();
        RoomContext r106 = RoomContext.a.a(r104, r105);
        if (r106 == null) goto L9;
        r106.getWidgetLoadTaskScheduler().c(new e0(this, r102));
    L9:
        if (yz.f121726a.getValue().booleanValue() == false) goto L11;
    L14:
        UIUtils.setViewVisibility(this.f99314c, 8);
        UIUtils.setViewVisibility(this.f99315d, 8);
        UIUtils.setViewVisibility(this.f99313b, 8);
        UIUtils.setViewVisibility(this.f99316e, 0);
        this.contentView.setPadding(0, 0, s1.f(8.0f), 0);
        return;
    L11:
        if (this.f99318g.isMergeVSRoom() == true) goto L14;
        UIUtils.setViewVisibility(this.f99314c, 0);
        UIUtils.setViewVisibility(this.f99315d, 0);
        UIUtils.setViewVisibility(this.f99313b, 0);
        UIUtils.setViewVisibility(this.f99316e, 8);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (xq() == false) goto L6;
        return;
    L6:
        if ((r100 instanceof ak) == false) goto L18;
        ak r101 = (ak) r100;
        LiveHotSpotInfo r102 = r101.E();
        if (r102 != null) goto L10;
    L16:
        this.dataCenter.put("cmd_update_live_hotspot_show", Boolean.FALSE);
        int r103 = ib6.a.f488996a;
        this.f99318g.getId();
        yq("");
        return;
    L10:
        if (TextUtils.isEmpty(r102.title) == true) goto L16;
        if (TextUtils.equals(r102.title, this.f99320i) == true) goto L15;
        wq();
    L15:
        yq(r102.title);
        this.f99318g.setLiveHotSpotInfo(r101.G());
        return;
    }

    public final void yq(String r100) {
        this.f99320i = r100;
        if (TextUtils.isEmpty(r100) == true) goto L8;
        this.containerView.setVisibility(0);
        Unit r101 = Unit.INSTANCE;
        this.f99312a.setText(this.f99320i);
        this.dataCenter.put("cmd_update_live_hotspot_show", Boolean.TRUE);
        int r102 = ib6.a.f488996a;
        this.f99318g.getId();
        if (this.f99318g.isMergeVSRoom() == false) goto L7;
        this.f99312a.setText("热点");
        return;
    L7:
        this.f99312a.setText(this.f99320i);
        return;
    L8:
        this.containerView.setVisibility(8);
        Unit r103 = Unit.INSTANCE;
    }
}
