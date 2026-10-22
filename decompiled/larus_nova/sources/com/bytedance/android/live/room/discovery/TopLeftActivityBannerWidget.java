package com.bytedance.android.live.room.discovery;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.rowcontract.RowRecyclableWidget;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.message.model.InRoomBannerMessage;
import com.bytedance.android.livesdkapi.banner.BannerData;
import com.bytedance.android.livesdkapi.banner.IBannerManager;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/discovery/TopLeftActivityBannerWidget;", "Lcom/bytedance/android/live/rowcontract/RowRecyclableWidget;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopLeftActivityBannerWidget extends RowRecyclableWidget implements vlc.l, Observer<KVData> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f99357f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vo1.a f99358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f99359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public vlc.d f99360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Room f99361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f99362e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopLeftActivityBannerWidget f99363a;

        public b(TopLeftActivityBannerWidget r100) {
            this.f99363a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BannerInRoomCollection r101 = ((BannerData) r100).getData();
            if (r101.getSceneBanner() != null) goto L71;
            TopLeftActivityBannerWidget r102 = this.f99363a;
            int r103 = TopLeftActivityBannerWidget.f99357f;
            r102.getClass();
            TopLeftActivityBannerWidget r104 = this.f99363a;
            BannerInRoomCollection.BannerInfo r105 = r101.getTopLeftActivityBanner();
            if (r105 != null) goto L13;
            LinearLayout r106 = r104.f99359b;
            if (r106 == null) goto L9;
            r106.setVisibility(8);
        L9:
            LinearLayout r107 = r104.f99359b;
            if (r107 == null) goto L12;
            r107.removeAllViews();
        L12:
            Unit r108 = Unit.INSTANCE;
            return;
        L13:
            r104.getClass();
            Unit r109 = Unit.INSTANCE;
            String r110 = r105.getUrl();
            if (r110 != null) goto L16;
        L19:
            boolean r111 = true;
        L21:
            if (r111 == false) goto L42;
            List<b1> r112 = r105.getBannerList();
            if (r112 == null) goto L79;
            LinearLayout r113 = r104.f99359b;
            if (r113 == null) goto L28;
            r113.removeAllViews();
        L28:
            Iterator<T> r114 = r112.iterator();
        L30:
            if (r114.hasNext() == false) goto L80;
            b1 r115 = (b1) r114.next();
            View r116 = LayoutInflater.from(r104.context).inflate(R.layout.ttlive_item_top_left_activity_banner, r104.f99359b, false);
            if (r116 == null) goto L41;
            ImageView r117 = (ImageView) r116;
            ((IHostFrescoHelper) jc1.k.n(IHostFrescoHelper.class)).loadFirstAvailableImageBitmap(r115.getImage(), new s0(r117, r104));
            LinearLayout r118 = r104.f99359b;
            if (r118 == null) goto L36;
            r118.setVisibility(0);
        L36:
            LinearLayout r119 = r104.f99359b;
            if (r119 == null) goto L39;
            r119.addView(r117);
        L39:
            Unit r120 = Unit.INSTANCE;
            r117.setOnClickListener(new t0(r115, r104));
            r104.wq(String.valueOf(r115.getId()), "live_banner_show");
            goto L30
        L41:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        L80:
            return;
        L79:
            return;
        L42:
            String r121 = r105.getUrl();
            int r122 = vo1.e.f556493a;
            vo1.a r123 = new vo1.a();
            r104.f99358a = r123;
            Context r124 = r104.context;
            if (r124 == null) goto L70;
            vo1.i.a.a(r123, (Activity) r124, r121, null, new q0(r104));
            int r125 = com.bytedance.android.livesdk.utils.e.f158933a;
            Intrinsics.checkNotNullParameter(r123, "$this$getWebView");
            if (r123.hybridType() != IHybridComponent.HybridType.H5) goto L47;
            WebView r126 = (WebView) r123.g();
        L47:
            vo1.a r127 = r104.f99358a;
            if (r127 == null) goto L52;
            View r128 = r127.c();
            if (r128 == null) goto L52;
            r128.setBackgroundColor(0);
            r128.setLayoutParams(new FrameLayout.LayoutParams(s1.f(64.0f), s1.f(64.0f)));
        L52:
            LinearLayout r129 = r104.f99359b;
            if (r129 == null) goto L60;
            r129.removeAllViews();
            vo1.a r130 = r104.f99358a;
            if (r130 == null) goto L59;
            View r131 = r130.c();
            if (r131 == null) goto L59;
            r129.addView(r131);
        L59:
            r129.setVisibility(0);
        L60:
            vo1.a r132 = r104.f99358a;
            if (r132 == null) goto L65;
            View r133 = r132.c();
            if (r133 == null) goto L65;
            r133.setOnTouchListener(new r0(r104, r121));
        L65:
            vo1.a r134 = r104.f99358a;
            if (r134 == null) goto L68;
            r134.loadUrl(r121);
        L68:
            r104.wq(r121, "live_banner_show");
            return;
        L70:
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        L16:
            if (r110.length() == 0) goto L19;
            r111 = false;
            goto L21
        L71:
            this.f99363a.getClass();
            Unit r135 = Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_widget_top_left_activity_banner;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a129";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final Animator startShowAnimation() {
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        vlc.d r100 = this.f99360c;
        if (r100 == null) goto L5;
        r100.removeMessageListener(this);
    L5:
        vo1.a r101 = this.f99358a;
        if (r101 == null) goto L12;
        View r102 = r101.c();
        if (r102 == null) goto L12;
        LinearLayout r103 = this.f99359b;
        if (r103 == null) goto L12;
        r103.removeView(r102);
    L12:
        vo1.a r104 = this.f99358a;
        if (r104 == null) goto L15;
        r104.release();
    L15:
        this.dataCenter.removeObserver(this);
    }

    public TopLeftActivityBannerWidget() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101.getKey()) == true) goto L29;
        String r102 = r101.getKey();
        int r103 = r102.hashCode();
        if (r103 == (-1357019912)) goto L16;
        if (r103 == 1060055221) goto L13;
        return;
    L13:
        if (r102.equals("data_keyboard_status") == true) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(r101.getKey(), "data_pre_show_keyboard") == true) goto L31;
        Boolean r104 = (Boolean) r101.getData();
        Intrinsics.checkNotNull(r104);
        if (r104.booleanValue() == false) goto L23;
        this.contentView.setVisibility(8);
        return;
    L23:
        this.contentView.setVisibility(0);
        return;
    L31:
        return;
    L16:
        if (r102.equals("data_pre_show_keyboard") == true) goto L18;
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f99359b = (LinearLayout) this.contentView.findViewById(R.id.static_container);
        ((HSImageView) this.contentView.findViewById(R.id.iv_animation)).setVisibility(8);
        ((TextView) this.contentView.findViewById(R.id.common_banner_hint_view)).setVisibility(8);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f99361d = (Room) this.dataCenter.get("data_room", new Room());
        this.f99362e = com.bytedance.android.live.core.utils.z.b(this.dataCenter).f66429c;
        vlc.d r101 = (vlc.d) this.dataCenter.get("data_message_manager");
        this.f99360c = r101;
        if (r101 == null) goto L5;
        r101.addMessageListener(MessageType.IN_ROOM_BANNER_MESSAGE.getIntType(), this);
    L5:
        this.dataCenter.observe("data_pre_show_keyboard", this).observe("data_xt_landscape_tab_change", this).observe("data_keyboard_status", this);
        IBannerManager r102 = (IBannerManager) this.dataCenter.get("data_in_room_banner_manager", null);
        if (r102 == null) goto L17;
        Room r103 = this.f99361d;
        if (r103 == null) goto L10;
        long r104 = r103.getRoomId();
    L11:
        Observable<BannerData> r105 = r102.observeBanner(r104, 0);
        if (r105 == null) goto L18;
        ObservableSubscribeProxy r106 = (ObservableSubscribeProxy) r105.as(autoDispose());
        if (r106 == null) goto L19;
        r106.subscribe(new b(this));
        return;
    L19:
        return;
    L18:
        return;
    L10:
        r104 = 0;
        goto L11
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof InRoomBannerMessage) == false) goto L45;
        InRoomBannerMessage r101 = (InRoomBannerMessage) r100;
        if (r101.getPosition() != 2) goto L46;
        String r102 = GsonProtectorUtils.toJson(GsonHelper.getDefault(), r101.getExtra());
        JSONObject r103 = new JSONObject();
        r103.put("type", "refresh");
        r103.put("data", r102);
        JSONObject r104 = new JSONObject();
        com.bytedance.android.livesdk.log.filter.o r105 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r106 = "";
        if ((r105 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L15;
        com.bytedance.android.livesdk.log.filter.n0 r107 = (com.bytedance.android.livesdk.log.filter.n0) r105;
        if (r107.f153291b.containsKey("enter_from") == false) goto L12;
        String r108 = r107.f153291b.get("enter_from");
    L12:
        if (r107.f153291b.containsKey("source") == false) goto L14;
        String r109 = r107.f153291b.get("source");
    L14:
        HashMap r110 = new HashMap();
        Map<String, String> r111 = com.bytedance.android.livesdk.log.e0.f153286a;
        String r112 = (String) r110.get("enter_from_merge");
        String r113 = (String) r110.get("enter_method");
    L16:
        JSONObject r114 = r104.put("enter_from_merge", r112).put("enter_method", r113);
        if (this.f99362e == false) goto L19;
        String r115 = "live_take_detail";
    L20:
        JSONObject r116 = r114.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r115);
        Room r117 = this.f99361d;
        if (r117 == null) goto L24;
        String r118 = String.valueOf(r117.f162599id);
        if (r118 == null) goto L24;
    L25:
        JSONObject r119 = r116.put("room_id", r118);
        Room r120 = this.f99361d;
        if (r120 == null) goto L29;
        String r121 = r120.getOwnerUserIdString();
        if (r121 == null) goto L29;
    L30:
        JSONObject r122 = r119.put("anchor_id", r121);
        Room r123 = this.f99361d;
        if (r123 == null) goto L34;
        String r124 = r123.getRequestId();
        if (r124 == null) goto L34;
    L35:
        JSONObject r125 = r122.put("request_id", r124);
        Room r126 = this.f99361d;
        if (r126 == null) goto L41;
        String r127 = r126.getLog_pb();
        if (r127 == null) goto L41;
        r106 = r127;
    L41:
        r125.put("log_pb", r106);
        r103.put("log", r104);
        vo1.a r128 = this.f99358a;
        if (r128 == null) goto L47;
        r128.sendJsEvent("H5_roomStatusChange", r103);
        return;
    L47:
        return;
    L34:
        r124 = "";
    L29:
        r121 = "";
    L24:
        r118 = "";
        goto L25
    L19:
        r115 = "live_detail";
        goto L20
    L15:
        r113 = "";
        r112 = r113;
        goto L16
    L46:
        return;
    }

    public final void wq(String r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("banner_id", r100);
        r102.put("request_page", "topleft");
        com.bytedance.android.livesdk.log.g r103 = com.bytedance.android.livesdk.log.u.l();
        Object[] r104 = new Object[3];
        r104[0] = Room.class;
        am2.x r105 = new am2.x();
        r105.f4349a = "live_function";
        if (this.f99362e == false) goto L5;
        String r106 = "live_take_detail";
    L6:
        r105.f4350b = r106;
        r104[1] = r105;
        r104[2] = new am2.z();
        r103.sendLog(r101, r102, r104);
        return;
    L5:
        r106 = "live_detail";
        goto L6
    }
}
