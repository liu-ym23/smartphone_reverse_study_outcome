package com.bytedance.android.livesdk.chatroom.end;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.eb;
import com.bytedance.android.livesdk.config.nt0;
import com.bytedance.android.livesdk.config.vg;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class NewLiveBroadcastEndFragment extends LiveEndFragment implements com.bytedance.android.live.room.i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f106016o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f106017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f106018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f106019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Room f106020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f106021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f106022i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HybridCard f106023j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AnnieXWebKit f106024k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f106025l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f106026m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CompositeDisposable f106027n;

    @Override // com.bytedance.android.live.core.ui.BaseFragment, tw2.b
    public final String getSpm() {
        return "a100.a208";
    }

    public final void S90() {
        HybridCard r100 = this.f106023j;
        if (r100 != null) goto L5;
    L7:
        AnnieXWebKit r101 = this.f106024k;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.f41417e == null) goto L15;
        SSWebView r102 = this.f106024k.f41417e;
        r102.setBackgroundColor(0);
        r102.setLayoutParams(this.f106017d.getLayoutParams());
        this.f106017d.addView(r102);
        return;
    L15:
        return;
    L5:
        if (r100.getHybridView() == null) goto L7;
        View r103 = this.f106023j.getHybridView();
        r103.setBackgroundColor(0);
        r103.setLayoutParams(this.f106017d.getLayoutParams());
        this.f106017d.addView(this.f106023j);
    }

    public final String U90() {
        Room r100 = this.f106020g;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getStreamType().getSceneName();
    }

    public NewLiveBroadcastEndFragment() {
        this.f106026m = nt0.f120859a.getValue().booleanValue();
        this.f106027n = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        HashMap r100 = new HashMap();
        r100.put("duration", String.valueOf(this.f106022i));
        com.bytedance.android.livesdk.log.u.l().sendLog("live_end_duration", r100, new Object[]{am2.x.class, Room.class});
        HybridCard r101 = this.f106023j;
        if (r101 == null) goto L5;
        r101.release();
    L5:
        com.bytedance.android.livesdk.log.filter.o r102 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        r102.c("enter_from_merge", null);
        ((com.bytedance.android.livesdk.log.filter.n0) r102).f153311h = null;
        FrameLayout r103 = this.f106017d;
        if (r103 == null) goto L8;
        r103.removeAllViews();
    L8:
        CompositeDisposable r104 = this.f106027n;
        if (r104 == null) goto L12;
        r104.clear();
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.f106022i += SystemClock.elapsedRealtime() - this.f106021h;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f106021h = SystemClock.elapsedRealtime();
    }

    public final Uri T90(String r100) {
        String r101 = "";
        if (TextUtils.isEmpty(r100) == true) goto L5;
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        Room r103 = this.f106020g;
        if (r103 != null) goto L9;
    L18:
        String r104 = "";
    L19:
        Room r105 = this.f106020g;
        if (r105 == null) goto L25;
        if (r105.getBaseOwner() == null) goto L25;
        r101 = this.f106020g.getBaseOwner().getIdString();
    L25:
        if (TextUtils.isEmpty(r104) == true) goto L27;
        r102.appendQueryParameter("anchor_avatar", r104);
    L27:
        r102.appendQueryParameter("user_id", r101);
        Room r106 = this.f106020g;
        if (r106 == null) goto L30;
        long r107 = r106.getId();
    L31:
        r102.appendQueryParameter("room_id", String.valueOf(r107));
        IHostContext r108 = (IHostContext) jc1.k.f(IHostContext.class);
        if (r108 == null) goto L34;
        r102.appendQueryParameter("aid", String.valueOf(r108.hostAppId()));
    L34:
        Bundle r109 = getArguments();
        if (r109 != null) goto L37;
    L39:
        String r110 = "0";
    L40:
        r102.appendQueryParameter("record_panel_show", r110);
        return r102.build();
    L37:
        if (r109.getBoolean("record_panel_show") == false) goto L39;
        r110 = "1";
        goto L40
    L30:
        r107 = 0;
        goto L31
    L9:
        if (r103.getBaseOwner() == null) goto L18;
        ImageModel r111 = (ImageModel) this.f106020g.getBaseOwner().getAvatarLarge();
        if (r111 == null) goto L18;
        if (r111.getUrls() == null) goto L18;
        if (r111.getUrls().size() <= 0) goto L18;
        r104 = (String) ListProtector.get(r111.getUrls(), 0);
        goto L19
    L5:
        return UriProtector.parse("");
    }

    public final void X90(Uri r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r100, "web_bg_color")) == false) goto L6;
        return;
    L6:
        if (getView() == null) goto L20;
        getView().setBackgroundColor(Color.parseColor(UriProtector.getQueryParameter(r100, "web_bg_color")));     // Catch: Exception -> L12
        View r101 = this.f106019f;     // Catch: Exception -> L12
        if (r101 == null) goto L19;
        r101.setBackgroundColor(Color.parseColor(UriProtector.getQueryParameter(r100, AppConstants.BUNDLE_STATUS_BAR_BG_COLOR)));     // Catch: Exception -> L12
        return;
    L19:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
    }

    public void onEvent(com.bytedance.android.livesdk.event.o r100) {
        if (r100 == null) goto L19;
        JSONObject r101 = r100.f123361a;
        if (r101 == null) goto L20;
    L12:
        e = move-exception;
        ALogger.e("NewLiveBroadcastEndFragment", e);
        return;
    L6:
        if (TextUtils.equals("endlive_backbtn_style", r101.optString("eventName", "")) == true) goto L8;
    L15:
        return;
    L8:
        if (JSONObjectProtectorUtils.getBoolean(JSONObjectProtectorUtils.getJSONObject(r101, "data"), "btnFloat") == false) goto L10;
        this.f106018e.getBackground().setAlpha(255);     // Catch: Exception -> L12
        goto L15
    L10:
        this.f106018e.getBackground().setAlpha(0);     // Catch: Exception -> L12
        goto L15
    L20:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setArguments(Bundle r100) {
        super.setArguments(r100);
    }

    public final void W90(Context r100, Uri r101) {
        IBrowserService r102 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r102 == null) goto L9;
        HybridCard r103 = r102.getHybridCard(r100, r101, new y0(this));
        this.f106023j = r103;
        if (this.f106026m == false) goto L10;
        if (r103 == null) goto L11;
        r103.load(null, null);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        if (this.f106020g != null) goto L6;
    L7:
        ALogger.i("NewLiveBroadcastEndFragment", "onViewCreated room is null");
        return;
    L6:
        if (TextUtils.isEmpty(this.f106025l) == true) goto L7;
        ((ObservableSubscribeProxy) xs2.b.a().b(com.bytedance.android.livesdk.event.o.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new u0(this));
        this.f106017d = (FrameLayout) findViewById(R.id.adapted_end_container);
        this.f106019f = findViewById(R.id.status_bg);
        View r102 = findViewById(R.id.left_back_to_main);
        this.f106018e = r102;
        r102.getBackground().setAlpha(0);
        this.f106018e.setOnClickListener(new v0(this));
        this.f106018e.setVisibility(0);
        r3.a(this.f106018e, s1.B(R.string.ttlive_broadcast_back_to_main));
        PaidLiveData r103 = null;
        if (this.f106026m == true) goto L12;
    L18:
        Context r104 = getContext();
        Room r105 = this.f106020g;
        if (r105 == null) goto L21;
        String r106 = r105.finish_url;
    L22:
        V90(r104, r106, false);
        S90();
        HybridCard r107 = this.f106023j;
        if (r107 == null) goto L26;
        r107.load(null, null);
    L26:
        if (jc1.k.f(IBrowserService.class) == null) goto L29;
        this.f106027n.add(((IBrowserService) jc1.k.f(IBrowserService.class)).registerJsEventSubscriber("live_broadcast_end_event").observeOn(AndroidSchedulers.mainThread()).subscribe(new w0(this)));
    L29:
        if (jc1.k.f(IBrowserService.class) == null) goto L31;
        this.f106027n.add(((IBrowserService) jc1.k.f(IBrowserService.class)).registerJsEventSubscriber("live_close_page_loaded").observeOn(AndroidSchedulers.mainThread()).subscribe(new x0(this)));
    L31:
        HashMap r108 = new HashMap();
        if (vg.f121447a.getValue().booleanValue() == false) goto L34;
        ((IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class)).broadcastFloatWindowManager();
    L34:
        Room r109 = this.f106020g;
        if (r109 == null) goto L37;
        PaidLiveData r110 = r109.getPaidLiveData();
    L38:
        if (r110 == null) goto L43;
        Room r111 = this.f106020g;
        if (r111 == null) goto L42;
        r103 = r111.getPaidLiveData();
    L42:
        int r112 = r103.getPaidType();
    L44:
        r108.put("is_paidlive", String.valueOf(r112));
        Room r113 = this.f106020g;
        if (r113 != null) goto L47;
    L53:
        com.bytedance.android.livesdk.log.u.l().sendLog("live_over", r108, new Object[]{Room.class});
        ((IPerformanceManager) jc1.k.f(IPerformanceManager.class)).monitorPerformance(IPerformanceManager.SCENE_CLOSE_ANCHOR_LIVE_ROOM);
        com.bytedance.android.livesdk.utils.j.b();
        Room r114 = this.f106020g;
        if (r114 != null) goto L56;
    L58:
        Room r115 = this.f106020g;
        if (r115 == null) goto L61;
        long r116 = r115.getId();
    L62:
        String.valueOf(r116);
        Room r117 = this.f106020g;
        if (r117 == null) goto L65;
        r117.getStreamType();
        return;
    L65:
        LiveMode r118 = LiveMode.VIDEO;
        return;
    L61:
        r116 = 0;
        goto L62
    L56:
        if (r114.getBaseOwner() == null) goto L58;
        this.f106020g.getBaseOwner().getIdString();
        goto L58
    L47:
        if (r113.isPaidRoom() == false) goto L53;
        if (this.f106020g.getPaidLiveData() == null) goto L53;
        if (this.f106020g.getPaidLiveData().getTicketSession() == null) goto L53;
        r108.put("ticket_id", String.valueOf(this.f106020g.getPaidLiveData().getTicketSession().getTicketId()));
        r108.put("ticket_name", String.valueOf(this.f106020g.getPaidLiveData().getTicketSession().getTitle()));
        goto L53
    L43:
        r112 = 0;
        goto L44
    L37:
        r110 = null;
        goto L38
    L21:
        r106 = "";
        goto L22
    L12:
        if (this.f106023j == null) goto L14;
    L17:
        S90();
        goto L26
    L14:
        if (this.f106024k == null) goto L18;
        if (eb.f120112a.getValue().booleanValue() == false) goto L18;
        goto L17
    }

    public final void V90(Context r110, String r111, boolean r112) {
        if (TextUtils.isEmpty(r111) == false) goto L5;
        return;
    L5:
        HashMap r100 = new HashMap();
        if (U90() == null) goto L8;
        r100.put("scene", U90());
    L8:
        r100.put("stage", "close_page_start_load_time");
        String r101 = UriProtector.getQueryParameter(UriProtector.parse(r111), "url");
        boolean r102 = TextUtils.isEmpty(r101);
        if (r112 == false) goto L17;
        if (r102 == true) goto L17;
        Uri r113 = T90(r101);
        Uri r103 = com.bytedance.android.live.schema.helper.h.b(UriProtector.parse(r111), "url", r113.toString());
        X90(r103);
        if (eb.f120112a.getValue().booleanValue() == false) goto L16;
        IBroadcastService r104 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        if (r104 == null) goto L24;
        this.f106024k = r104.loadAnnieXWebKit(r110, r103, "live_broadcast_end", null, null, null, null);
        return;
    L24:
        return;
    L16:
        W90(r110, r103);
        return;
    L17:
        Uri r114 = T90(r111);
        X90(r114);
        Uri r105 = x6.a.b(r114.toString());
        if (eb.f120112a.getValue().booleanValue() == false) goto L22;
        IBroadcastService r106 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        if (r106 == null) goto L27;
        this.f106024k = r106.loadAnnieXWebKit(r110, r105, "live_broadcast_end", null, null, null, null);
        return;
    L27:
        return;
    L22:
        W90(r110, r105);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return LayoutInflater.from(getContext()).inflate(R.layout.ttlive_fragment_live_end_new, r101, false);
    }
}
