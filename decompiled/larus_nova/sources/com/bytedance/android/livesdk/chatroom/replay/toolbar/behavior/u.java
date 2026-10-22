package com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior;

import am2.a0;
import am2.b0;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeShare;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class u implements c0.b, vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f110070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f110071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f110072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f110073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f110074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f110075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f110076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f110077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f110078i;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f110079a;

        public b(u r100) {
            this.f110079a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r110, MotionEvent r111) {
            int r100 = r111.getAction();
            if (r100 != 0) goto L5;
            r110.setAlpha(0.7f);
            return false;
        L5:
            if (r100 != 1) goto L7;
            r110.setAlpha(1.0f);
            long r101 = System.currentTimeMillis();
            u r102 = this.f110079a;
            if ((r101 - r102.f110072c) >= r102.f110073d) goto L13;
            return true;
        L13:
            r102.f110072c = r101;
            if ((r111.getEventTime() - r111.getDownTime()) >= ViewConfiguration.getLongPressTimeout()) goto L21;
            this.f110079a.b(r110, "active");
            return true;
        L21:
            return false;
        L7:
            if (r100 != 3) goto L22;
            r110.setAlpha(1.0f);
            return false;
        L22:
            return false;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f110080a;

        public c(u r100) {
            this.f110080a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f110080a.a();
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
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void a() {
        Disposable r100 = this.f110074e;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        DataCenter r101 = this.f110077h;
        Boolean r102 = Boolean.FALSE;
        if (((Boolean) r101.get("showPanelBefore", r102)).booleanValue() == true) goto L10;
        if (((Boolean) this.f110077h.get(VSConstants.EXTRA_SHOW_MSG_BOARD, r102)).booleanValue() == false) goto L10;
    L11:
        b(this.f110070a, VSConstants.EXTRA_SHOW_MSG_BOARD_FROM_PASSIVE_ACTION);
        return;
    L10:
        if (TextUtils.isEmpty((CharSequence) this.f110077h.get("comment_id")) == false) goto L11;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b(r100, "active");
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getMessageMethod();
    L5:
        ku2.d r102 = ku2.e.f506189a;
        if (Intrinsics.areEqual(r101, xq1.b.a(ku2.e.f506202n)) == false) goto L14;
        yq1.b r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.h();
        if (r103 == null) goto L10;
        r103.paidStatusChanged(this.f110077h);
    L10:
        fq1.e r104 = fq1.f.a();
        if (r104 == null) goto L15;
        r104.sendJsEvent("ticket_unpaid", new JSONObject());
        return;
    L15:
        return;
    L14:
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Disposable r102 = this.f110071b;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        Disposable r103 = this.f110074e;
        if (r103 == null) goto L9;
        r103.dispose();
        return;
    }

    public final void b(View r110, String r111) {
        mq1.t r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e();
        if (r100 == null) goto L7;
        mq1.v r101 = r100.provideVSPlayerViewControlService(this.f110077h);
        if (r101 == null) goto L7;
        r101.setVisibilityStatus(false);
    L7:
        DataCenter r102 = this.f110077h;
        if (r102 == null) goto L10;
        r102.put("showPanelBefore", Boolean.TRUE);
    L10:
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.f110077h).e("livesdk_vs_guest_book_icon_click", (Map) this.f110075f.getValue(), new Object[0]);
        yq1.b r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.h();
        Uri r104 = null;
        if (r103 == null) goto L13;
        String r105 = r103.getMsgBoardSchema(this.f110077h);
    L15:
        if (TextUtils.isEmpty(r105) == false) goto L17;
        return;
    L17:
        if (r110 == null) goto L19;
        Context r112 = r110.getContext();
    L20:
        DataCenter r106 = this.f110077h;
        if (r112 == null) goto L111;
        if (r106 == null) goto L112;
        Uri r107 = UriProtector.parse(new UrlBuilder(r105).build());
        if (r107 == null) goto L26;
        String r108 = UriProtector.getQueryParameter(r107, "url");
    L28:
        if (TextUtils.isEmpty(r108) == false) goto L30;
        Uri.Builder r109 = r107.buildUpon();
    L38:
        if (r109 == null) goto L79;
        com.bytedance.android.livesdk.log.filter.o r113 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r106).c(a0.class);
        if (r113 == null) goto L47;
        Map<String, String> r114 = r113.getMap();
        if (r114 == null) goto L47;
        Iterator<Map.Entry<String, String>> r115 = r114.entrySet().iterator();
    L45:
        if (r115.hasNext() == false) goto L47;
        Map.Entry<String, String> r116 = r115.next();
        r109.appendQueryParameter(r116.getKey(), r116.getValue());
    L47:
        com.bytedance.android.livesdk.log.filter.o r117 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r106).c(b0.class);
        if (r117 == null) goto L55;
        Map<String, String> r118 = r117.getMap();
        if (r118 == null) goto L55;
        Iterator<Map.Entry<String, String>> r119 = r118.entrySet().iterator();
    L53:
        if (r119.hasNext() == false) goto L55;
        Map.Entry<String, String> r120 = r119.next();
        r109.appendQueryParameter(r120.getKey(), r120.getValue());
    L55:
        Map r121 = (Map) this.f110075f.getValue();
        if (r121 == null) goto L61;
        Iterator r122 = r121.entrySet().iterator();
    L59:
        if (r122.hasNext() == false) goto L61;
        Map.Entry r123 = (Map.Entry) r122.next();
        r109.appendQueryParameter((String) r123.getKey(), (String) r123.getValue());
    L61:
        Episode r124 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r106);
        if (r124 == null) goto L67;
        EpisodeShare r125 = r124.share;
        if (r125 == null) goto L67;
        String r126 = r125.shareUrl;
        if (r126 == null) goto L67;
    L68:
        r109.appendQueryParameter("share_url", r126);
        r109.appendQueryParameter("show_type", r111);
        if (this.f110078i == true) goto L76;
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r127 = ReplayRoomFragmentScopeUtil.f117917a;
        if (((com.bytedance.android.livesdk.chatroom.replay.ui.c0) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.c0.class)).g() == true) goto L76;
        if (FoldScreenUtils.f() == true) goto L76;
        r109.appendQueryParameter("use_anim_in_landscape", "true");
    L76:
        if (TextUtils.isEmpty((CharSequence) r106.get("comment_id")) == true) goto L79;
        r109.appendQueryParameter("insert_comment_id", (String) r106.get("comment_id"));
        r106.put("comment_id", "");
    L67:
        r126 = "";
    L79:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r107, "url")) == true) goto L83;
        fq1.e r128 = fq1.f.a();
        if (r128 == null) goto L86;
        r104 = r128.d(r107, String.valueOf(r109));
    L86:
        if (PadConfigUtils.c() == false) goto L89;
        Intrinsics.checkNotNull(r104);
        Uri r129 = com.bytedance.android.live.schema.helper.h.b(r104, "pad_use_player_bottom_height", "1");
        Intrinsics.checkNotNull(r129);
        Uri r130 = com.bytedance.android.live.schema.helper.h.b(r129, "radius", "8");
    L95:
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r131 = ReplayRoomFragmentScopeUtil.f117917a;
        if (((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.f) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.f.class)).l() == true) goto L100;
        if (FoldScreenUtils.f() == true) goto L100;
    L106:
        fq1.d.a().handleSchema(r112, String.valueOf(r130));
        return;
    L100:
        if (FoldScreenUtils.f() == false) goto L106;
        if (this.f110078i == true) goto L106;
        float r132 = ((s1.w() * MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS) / 504) / s1.y();
        if (r130 == null) goto L106;
        r130 = com.bytedance.android.live.schema.helper.h.b(r130, "horizontal_width_percent", String.valueOf((int) (r132 * 100)));
        goto L106
    L89:
        if (this.f110078i == true) goto L91;
        Intrinsics.checkNotNull(r104);
        r104 = com.bytedance.android.live.schema.helper.h.b(r104, "radius", "8");
    L91:
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r133 = ReplayRoomFragmentScopeUtil.f117917a;
        if (((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.f) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.f.class)).l() == false) goto L94;
        Intrinsics.checkNotNull(r104);
        r130 = com.bytedance.android.live.schema.helper.h.b(r104, "use_player_bottom_height", "0");
        goto L95
    L94:
        r130 = r104;
        goto L95
    L83:
        if (r109 == null) goto L86;
        r104 = r109.build();
        goto L86
    L30:
        if (r107 == null) goto L33;
        String r134 = UriProtector.getQueryParameter(r107, "url");
        if (r134 == null) goto L33;
    L34:
        Uri r135 = UriProtector.parse(r134);
        if (r135 == null) goto L37;
        r109 = r135.buildUpon();
        goto L38
    L37:
        r109 = null;
    L33:
        r134 = "";
        goto L34
    L26:
        r108 = null;
        goto L28
    L112:
        return;
    L111:
        return;
    L19:
        r112 = null;
        goto L20
    L13:
        r105 = null;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, "dataCenter");
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r110) == null) goto L11;
        yq1.b r101 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.h();
        if (r101 == null) goto L11;
        if (r101.replayToolbarDataHasDress(com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r110)) != true) goto L11;
        vlc.d r102 = (vlc.d) r110.get("data_message_manager");
        if (r102 == null) goto L11;
        r102.addMessageListener(xq1.b.a(ku2.e.f506202n), this);
    L11:
        this.f110070a = r100;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r110).e("livesdk_vs_guest_book_icon_show", (Map) this.f110075f.getValue(), new Object[0]);
        yq1.b r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.h();
        if (r103 != null) goto L14;
        return;
    L14:
        if (r103.canShowMsgBoard(r110) != true) goto L46;
        yq1.b r104 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.h();
        Disposable r105 = null;
        if (r104 == null) goto L18;
        String r106 = r104.getMsgBoardSchema(r110);
    L20:
        if ((!TextUtils.isEmpty(r106)) != true) goto L47;
        c0 r107 = y3.m(this.f110077h);
        ToolbarButton r108 = ToolbarButton.VS_MESSAGE_BOARD;
        r107.c(r108.extended());
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.f110077h).e("livesdk_vs_guest_book_icon_show", (Map) this.f110075f.getValue(), new Object[0]);
        r100.findViewById(R.id.icon).setBackgroundDrawable(this.f110076g.getResources().getDrawable(R.drawable.ttlive_ic_vs_msg_board));
        yq1.b r109 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.h();
        if (r109 == null) goto L29;
        py.k r111 = r109.getVsMsgBoardIcon(r110);
        if (r111 == null) goto L29;
        if (y3.m(this.f110077h).n(r108) == false) goto L29;
        this.f110071b = a1.l(r111, s1.f(38.0f), s1.f(38.0f), false, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new v(this), w.f110082a);
    L29:
        r100.setOnTouchListener(new b(this));
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r112 = ReplayDataContext.a.b(r110);
        if (r112 == null) goto L36;
        com.bytedance.live.datacontext.m<Boolean> r113 = r112.getRoomFirstFrame();
        if (r113 == null) goto L36;
        if (r113.getValue().booleanValue() != true) goto L36;
        a();
        return;
    L36:
        ReplayDataContext r114 = ReplayDataContext.a.b(r110);
        if (r114 == null) goto L43;
        com.bytedance.live.datacontext.m<Boolean> r115 = r114.getRoomFirstFrame();
        if (r115 == null) goto L43;
        Observable<Boolean> r116 = r115.a();
        if (r116 == null) goto L43;
        r105 = r116.subscribe(new c(this));
    L43:
        this.f110074e = r105;
        return;
    L47:
        return;
    L18:
        r106 = null;
        goto L20
    }

    public u(Context r100, DataCenter r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f110076g = r100;
        this.f110077h = r101;
        this.f110078i = r102;
        this.f110073d = 500;
        this.f110075f = LazyKt.lazy(new ReplayToolbarUnfoldedVSMsgBoardBehavior$params$2(this));
    }
}
