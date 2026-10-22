package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.WebcastPaidLiveDataMessage;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.jsb.IExternalBrowserService;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.Maybe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class ToolbarVSMsgBoardBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, vlc.l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f117059i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s f117060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f117061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ToolbarVSMsgBoardBehavior f117062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f117063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f117064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f117065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f117066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f117067h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarVSMsgBoardBehavior f117068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DataCenter f117069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f117070c;

        public b(ToolbarVSMsgBoardBehavior r100, DataCenter r101, View r102) {
            this.f117068a = r100;
            this.f117069b = r101;
            this.f117070c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            DataCenter r102 = this.f117069b;
            Boolean r103 = Boolean.FALSE;
            if (((Boolean) r102.get("showPanelBefore", r103)).booleanValue() == true) goto L7;
            if (((Boolean) this.f117069b.get(VSConstants.EXTRA_SHOW_MSG_BOARD, r103)).booleanValue() == false) goto L7;
        L8:
            this.f117068a.b(this.f117070c, VSConstants.EXTRA_SHOW_MSG_BOARD_FROM_PASSIVE_ACTION);
            return;
        L7:
            if (TextUtils.isEmpty((CharSequence) this.f117069b.get("comment_id")) == false) goto L8;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
        this.f117060a = r100;
        if (r100 == null) goto L11;
        py.k r101 = r100.f116193c;
        if (r101 != null) goto L7;
        return;
    L7:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.f117067h).n(ToolbarButton.VS_MESSAGE_BOARD) == false) goto L13;
        this.f117063d = com.bytedance.android.livesdk.chatroom.utils.a1.l(r101, com.bytedance.android.live.core.utils.s1.f(38.0f), com.bytedance.android.live.core.utils.s1.f(38.0f), false, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new r5(this), s5.f117367a);
        return;
    L13:
        return;
    }

    public final void a(final String r100) {
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, this.f117067h, 0, 2);
        if (r101 == null) goto L8;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.l> r102 = r101.getLoggerHelper();
        if (r102 == null) goto L9;
        r102.c(new ToolbarVSMsgBoardBehavior$logEvent$1(this, r100));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        if (this.f117066g == false) goto L6;
        return;
    L6:
        if ((r100 instanceof pp1.g) == false) goto L18;
        StringBuilder r101 = new StringBuilder("move to more = ");
        pp1.g r102 = (pp1.g) r100;
        r101.append(r102.f530187a);
        ALogger.e("ToolbarVSMsgBoardBehavior", r101.toString());
        DataCenter r103 = this.f117067h;
        if (r103 == null) goto L11;
        r103.put("data_vs_message_board_move_to_more", Boolean.valueOf(r102.f530187a));
    L11:
        if (r102.f530187a == true) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.f117067h).d(ToolbarButton.VS_MESSAGE_BOARD, this.f117062c);
        return;
    L13:
        if (this.f117062c != null) goto L15;
        this.f117062c = new ToolbarVSMsgBoardBehavior(true, this.f117067h);
    L15:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.f117067h).k(ToolbarButton.VS_MESSAGE_BOARD, this.f117062c);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b(r100, "active");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void onHide(boolean r100) {
        this.f117060a = null;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof WebcastPaidLiveDataMessage) == false) goto L9;
        qh1.a r101 = pm1.f.n();
        if (r101 == null) goto L7;
        r101.paidStatusChanged(this.f117067h);
    L7:
        ((IExternalBrowserService) jc1.k.n(IExternalBrowserService.class)).enqueueEvent("ticket_unpaid", new JSONObject());
        return;
    }

    public ToolbarVSMsgBoardBehavior(boolean r100, DataCenter r101) {
        this.f117066g = r100;
        this.f117067h = r101;
        this.f117065f = LazyKt.lazy(new ToolbarVSMsgBoardBehavior$params$2(this));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Disposable r102 = this.f117063d;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        Disposable r103 = this.f117064e;
        if (r103 == null) goto L9;
        r103.dispose();
        return;
    }

    public final void b(View r110, String r111) {
        IVSPlayerService r100 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r100 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r101 = r100.provideVSPlayerViewControlService(this.f117067h);
        if (r101 == null) goto L7;
        r101.setVisibilityStatus(false);
    L7:
        Disposable r102 = this.f117064e;
        if (r102 == null) goto L10;
        r102.dispose();
    L10:
        DataCenter r103 = this.f117067h;
        if (r103 == null) goto L13;
        r103.put("showPanelBefore", Boolean.TRUE);
    L13:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r104 = this.f117060a;
        Uri r105 = null;
        if (r104 == null) goto L16;
        String r106 = r104.f116195e;
    L18:
        if (TextUtils.isEmpty(r106) == false) goto L24;
        qh1.a r107 = pm1.f.n();
        if (r107 == null) goto L22;
        r106 = r107.getMsgBoardSchema(this.f117067h);
        goto L24
    L22:
        r106 = null;
    L24:
        if (TextUtils.isEmpty(r106) == false) goto L26;
        return;
    L26:
        a("livesdk_vs_guest_book_icon_click");
        a("livesdk_toolbar_icon_click");
        if (r110 == null) goto L29;
        Context r112 = r110.getContext();
    L30:
        DataCenter r108 = this.f117067h;
        if (r112 == null) goto L102;
        if (r108 == null) goto L103;
        Uri r109 = UriProtector.parse(new UrlBuilder(r106).build());
        if (r109 == null) goto L36;
        String r113 = UriProtector.getQueryParameter(r109, "url");
    L38:
        if (TextUtils.isEmpty(r113) == false) goto L40;
        Uri.Builder r114 = r109.buildUpon();
    L49:
        if (r114 == null) goto L82;
        Map<String, String> r115 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap();
        if (r115 == null) goto L55;
        Map r116 = (Map) this.f117065f.getValue();
        if (r116 == null) goto L55;
        r116.putAll(r115);
    L55:
        Map<String, String> r117 = com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap();
        if (r117 == null) goto L60;
        Map r118 = (Map) this.f117065f.getValue();
        if (r118 == null) goto L60;
        r118.putAll(r117);
    L60:
        Map r119 = (Map) this.f117065f.getValue();
        if (r119 == null) goto L66;
        Iterator r120 = r119.entrySet().iterator();
    L64:
        if (r120.hasNext() == false) goto L66;
        Map.Entry r121 = (Map.Entry) r120.next();
        r114.appendQueryParameter((String) r121.getKey(), (String) r121.getValue());
    L66:
        Room r122 = com.bytedance.android.live.core.utils.z.o(r108);
        if (r122 == null) goto L70;
        String r123 = r122.getShareUrl();
        if (r123 == null) goto L70;
    L71:
        r114.appendQueryParameter("share_url", r123);
        r114.appendQueryParameter("show_type", r111);
        if (com.bytedance.android.live.core.utils.z.m(r108, true) == true) goto L79;
        if (PadConfigUtils.c() == true) goto L79;
        if (FoldScreenUtils.f() == true) goto L79;
        r114.appendQueryParameter("use_anim_in_landscape", "true");
    L79:
        if (TextUtils.isEmpty((CharSequence) r108.get("comment_id")) == true) goto L82;
        r114.appendQueryParameter("insert_comment_id", (String) r108.get("comment_id"));
        r108.put("comment_id", "");
    L70:
        r123 = "";
    L82:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r109, "url")) == true) goto L84;
        r105 = com.bytedance.android.live.schema.helper.h.b(r109, "url", String.valueOf(r114));
    L87:
        if (PadConfigUtils.c() == false) goto L89;
    L90:
        Intrinsics.checkNotNull(r105);
        r105 = com.bytedance.android.live.schema.helper.h.b(r105, "radius", "8");
    L92:
        if (FoldScreenUtils.f() == true) goto L94;
    L99:
        ((ILiveActionHandler) jc1.k.n(ILiveActionHandler.class)).handle(r112, r105);
        return;
    L94:
        if (FoldScreenUtils.e() == false) goto L97;
        Intrinsics.checkNotNull(r105);
        Uri r124 = com.bytedance.android.live.schema.helper.h.b(r105, "use_player_bottom_height", "0");
        Intrinsics.checkNotNull(r124);
        r105 = com.bytedance.android.live.schema.helper.h.b(r124, "pad_use_player_bottom_height", "0");
    L97:
        if (com.bytedance.android.live.core.utils.z.m(r108, true) == true) goto L99;
        float r125 = ((com.bytedance.android.live.core.utils.s1.w() * MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS) / 504) / com.bytedance.android.live.core.utils.s1.y();
        Intrinsics.checkNotNull(r105);
        r105 = com.bytedance.android.live.schema.helper.h.b(r105, "horizontal_width_percent", String.valueOf((int) (r125 * 100)));
        goto L99
    L89:
        if (com.bytedance.android.live.core.utils.z.m(r108, true) == true) goto L92;
    L84:
        if (r114 == null) goto L87;
        r105 = r114.build();
        goto L87
    L40:
        if (r109 == null) goto L43;
        String r126 = UriProtector.getQueryParameter(r109, "url");
        if (r126 == null) goto L43;
    L44:
        Uri r127 = UriProtector.parse(r126);
        if (r127 == null) goto L47;
        r114 = r127.buildUpon();
        goto L49
    L47:
        r114 = null;
    L43:
        r126 = "";
        goto L44
    L36:
        r113 = null;
        goto L38
    L103:
        return;
    L102:
        return;
    L29:
        r112 = null;
        goto L30
    L16:
        r106 = null;
        goto L18
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        if (com.bytedance.android.live.core.utils.z.o(r101) == null) goto L11;
        qh1.a r102 = pm1.f.n();
        if (r102 == null) goto L11;
        if (r102.roomToolbarDataHasDress(com.bytedance.android.live.core.utils.z.o(r101)) != true) goto L11;
        vlc.d r103 = (vlc.d) r101.get("data_message_manager");
        if (r103 == null) goto L11;
        r103.addMessageListener(MessageType.PAID_LIVE_DATA_MESSAGE.getIntType(), this);
    L11:
        this.f117061b = r100;
        Map r104 = (Map) this.f117065f.getValue();
        if (r104 != null) goto L14;
    L18:
        a("livesdk_vs_guest_book_icon_show");
        View r105 = this.f117061b;
        if (r105 == null) goto L21;
        r105.setOnClickListener(new com.bytedance.android.livesdk.utils.w0(new ToolbarVSMsgBoardBehavior$onLoad$1(this), 500));
    L21:
        Disposable r106 = null;
        RoomContext r107 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r107 == null) goto L28;
        com.bytedance.live.datacontext.j<Unit> r108 = r107.isFirstFrameShown();
        if (r108 == null) goto L28;
        Maybe<sh6.b<Unit>> r109 = r108.b();
        if (r109 == null) goto L28;
        r106 = r109.subscribe(new b(this, r101, r100));
    L28:
        this.f117064e = r106;
        com.bytedance.android.livesdk.r3.c(this.f117061b, "留言墙", true);
        return;
    L14:
        if (this.f117066g == false) goto L16;
        String r110 = "more";
    L17:
        String r111 = (String) r104.put("source", r110);
        goto L18
    L16:
        r110 = NewBroadcastMonitor.STAGE.TOOLBAR;
        goto L17
    }
}
