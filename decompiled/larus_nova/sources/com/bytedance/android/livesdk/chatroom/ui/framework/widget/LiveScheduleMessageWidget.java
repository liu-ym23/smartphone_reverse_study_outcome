package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcast.api.model.ScheduledSettingInfo;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.announce.AnnouncementInfo;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.message.model.e2;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/LiveScheduleMessageWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvlc/l;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveScheduleMessageWidget extends MiddlewareRoomWidget implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.c f113147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.d f113148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public vlc.d f113149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f113150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b0 f113151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f113152f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveScheduleMessageWidget f113153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e2 f113154b;

        public a(LiveScheduleMessageWidget r100, e2 r101) {
            this.f113153a = r100;
            this.f113154b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            vlc.d r100 = n3.e(this.f113153a.dataCenter);     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.j(this.f113154b, true);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void wq() {
        if (this.f113152f == false) goto L5;
        return;
    L5:
        if (isViewValid() == false) goto L81;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r100 = ho1.a.d(getComponentContext());
        e2 r101 = null;
        String r102 = "";
        if (r100 != null) goto L10;
    L43:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r103 = ho1.a.d(getComponentContext());
        if (r103 == null) goto L46;
        Room r104 = r103.getRoom();
    L47:
        if (r104 != null) goto L49;
    L56:
        String r105 = null;
    L57:
        if (r105 != null) goto L59;
    L62:
        boolean r106 = true;
    L63:
        if (r106 == false) goto L65;
        r105 = null;
    L65:
        if (r105 != null) goto L67;
        return;
    L67:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r107 = ho1.a.d(getComponentContext());
        if (r107 == null) goto L70;
        Room r108 = r107.getRoom();
    L71:
        if (r108 == null) goto L73;
        r101 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.i.a(r108.getId(), r108.mo8271getOwner(), r105);
    L73:
        if (r101 == null) goto L75;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r.d(r101, PSMessageAction.CHAT);
    L75:
        Handler r109 = this.f113150d;
        if (r109 == null) goto L78;
        r109.postDelayed(new a(this, r101), 2000);
    L78:
        this.f113152f = true;
        HashMap r110 = new HashMap();
        r110.put("enter_from_merge", "live_message");
        com.bytedance.android.livesdk.log.u.l().sendLog("live_timetable_show", r110, new Object[0]);
        return;
    L70:
        r108 = null;
        goto L71
    L59:
        if (r105.length() == 0) goto L62;
        r106 = false;
        goto L63
    L49:
        if (TextUtils.isEmpty(r104.anchorScheduledTimeText) == true) goto L56;
        String r111 = r104.anchorScheduledTimeText;
        if (r111 == null) goto L55;
        r102 = r111;
    L55:
        r105 = r102;
        goto L57
    L46:
        r104 = null;
        goto L47
    L10:
        if (r100.dg() != true) goto L43;
        IAnnouncementService r112 = (IAnnouncementService) jc1.k.f(IAnnouncementService.class);
        if (r112 != null) goto L14;
    L28:
        ScheduledSettingInfo r113 = (ScheduledSettingInfo) this.dataCenter.get("data_live_scheduled_info", null);
        if (r113 == null) goto L56;
        if (TextUtils.isEmpty(r113.getScheduledTimeWords()) == true) goto L56;
        if (r113.getMasterSwitch() == false) goto L56;
        String r114 = r113.getScheduledTimeWords();
        if (r114 == null) goto L40;
        r102 = r114;
    L40:
        if (TextUtils.isEmpty(r102) == true) goto L56;
        r105 = s1.C(R.string.ttlive_forenotice_message_tip, new Object[]{r102});
        goto L57
    L14:
        if (r112.enable() == false) goto L28;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r115 = this.f113147a;
        if (r115 == null) goto L18;
        FragmentActivity r116 = r115.p0();
    L20:
        if (r112.announcementIsOpen(r116) == false) goto L40;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r117 = this.f113147a;
        if (r117 == null) goto L24;
        FragmentActivity r118 = r117.p0();
    L25:
        AnnouncementInfo r119 = r112.getAnnouncementInfo(r118, null);
        if (r119 == null) goto L40;
        r102 = r119.scheduledTimeText;
        goto L40
    L24:
        r118 = null;
        goto L25
    L18:
        r116 = null;
        goto L20
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.f113147a = ho1.a.d(getComponentContext());
        this.f113148b = ho1.a.i(getComponentContext());
        this.f113150d = new Handler(Looper.getMainLooper());
        this.f113149c = (vlc.d) this.dataCenter.get("data_message_manager");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r100 = this.f113147a;
        if (r100 == null) goto L5;
        boolean r101 = r100.dg();
    L6:
        if (r101 == false) goto L10;
        vlc.d r102 = this.f113149c;
        if (r102 == null) goto L17;
        r102.addMessageListener(MessageType.ROOM.getIntType(), this);
        return;
    L17:
        return;
    L10:
        HashSet r103 = new HashSet();
        r103.add(Integer.valueOf(MessageType.ROOM.getIntType()));
        b0 r104 = new b0(this, r103, r103, new HashSet(), new dmc.d(0));
        this.f113151e = r104;
        vlc.d r105 = this.f113149c;
        int r106 = d4.f158930a;
        if ((r105 instanceof dmc.a) == true) goto L13;
        r105 = null;
    L13:
        dmc.a r107 = (dmc.a) r105;
        if (r107 == null) goto L19;
        r107.C(r104);
        return;
    L19:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        b0 r100 = this.f113151e;
        if (r100 == null) goto L11;
        vlc.d r101 = this.f113149c;
        int r102 = d4.f158930a;
        if ((r101 instanceof dmc.a) == true) goto L7;
        r101 = null;
    L7:
        dmc.a r103 = (dmc.a) r101;
        if (r103 == null) goto L10;
        r103.o(r100);
    L10:
        this.f113151e = null;
    L11:
        vlc.d r104 = this.f113149c;
        if (r104 == null) goto L14;
        r104.removeMessageListener(this);
    L14:
        Handler r105 = this.f113150d;
        if (r105 == null) goto L17;
        r105.removeCallbacksAndMessages(null);
    L17:
        this.f113150d = null;
        DataCenter r106 = this.dataCenter;
        if (r106 == null) goto L23;
        vlc.d r107 = (vlc.d) r106.get("data_message_manager", null);
        if (r107 == null) goto L24;
        r107.removeMessageListener(this);
        return;
    L24:
        return;
    }

    public LiveScheduleMessageWidget() {
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100.getMessageMethod(), MessageType.ROOM.getWsMethod()) == false) goto L8;
        wq();
        return;
    }
}
