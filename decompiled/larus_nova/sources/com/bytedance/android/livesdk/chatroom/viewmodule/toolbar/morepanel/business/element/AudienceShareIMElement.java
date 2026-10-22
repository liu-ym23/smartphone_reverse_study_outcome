package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.base.IBaseHostShare;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMContact;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMShareContactType;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.model.ShopGuideApi;
import com.bytedance.android.livesdk.chatroom.model.k3;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.a5;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.i5;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.z4;
import com.bytedance.android.livesdk.config.xl;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class AudienceShareIMElement extends BaseElement<ip1.d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ElementType f116529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f116530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f116531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f116532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f116533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f116534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f116535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f116536j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f116537k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f116538l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, String> f116539m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f116540n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f116541o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final jp1.b f116542p;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final void f() {
        this.f116530d = true;
    }

    @Override // kp1.b
    public final void i() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final Integer k() {
        return null;
    }

    @Override // kp1.b
    public final void release() {
        this.f116530d = false;
        this.f116539m = null;
        this.f116540n = 0;
        this.f116538l.clear();
    }

    public final DataCenter p() {
        return this.f116542p.getDataCenter();
    }

    public final Room q() {
        RoomContext r100 = this.f116542p.a();
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.m<Room> r101 = r100.getRoom();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.f116529c;
    }

    public AudienceShareIMElement(jp1.b r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        super(r100);
        this.f116542p = r100;
        this.f116529c = ElementType.ShareIM;
        this.f116538l = new CompositeDisposable();
        this.f116541o = LazyKt.lazy(AudienceShareIMElement$disableIMTitle$2.INSTANCE);
    }

    public static final void o(AudienceShareIMElement r100) {
        r100.getClass();
        if ((System.currentTimeMillis() - r100.f116540n) < 2000) goto L21;
        r100.f116540n = System.currentTimeMillis();
        Room r101 = r100.q();
        if (r101 == null) goto L22;
        long r102 = r101.f162599id;
        Room r103 = r100.q();
        if (r103 == null) goto L9;
        String r104 = r103.getLabels();
    L10:
        HashMap<String, String> r105 = new HashMap();
        com.bytedance.android.livesdk.share.e.f158089a.getClass();
        String r106 = String.valueOf(com.bytedance.android.livesdk.share.e.a.b("chat_merge"));
        if (TextUtils.isEmpty(r106) == true) goto L13;
        r105.put("target_id", r106);
    L13:
        String r107 = String.valueOf(1);
        if (TextUtils.isEmpty(r107) == true) goto L16;
        r105.put("share_type", r107);
    L16:
        String r108 = String.valueOf(r104);
        if (TextUtils.isEmpty(r108) == true) goto L19;
        r105.put("common_label_list", r108);
    L19:
        com.bytedance.android.livesdk.service.l.d().getClass();
        ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).sendShare(r102, r105).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(r100.f116542p.a(), r100.p()));
        return;
    L9:
        r104 = null;
        goto L10
    L22:
        return;
    }

    @Override // kp1.b
    public final void h(lp1.b r110) {
        ip1.d r100 = (ip1.d) r110;
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (this.f116530d == true) goto L69;
        ViewGroup r101 = this.f116531e;
        if (r101 == null) goto L70;
        ViewGroup r102 = this.f116532f;
        if (r102 == null) goto L71;
        r101.removeAllViews();
        r102.removeAllViews();
        Activity r103 = ContextUtil.contextToActivity(r101.getContext());
        if (r103 == null) goto L72;
        int r104 = (int) ToolbarButton.IM_LIST_VIRTUAL.getId();
        if (r104 == (-1)) goto L65;
        ArrayList<T> r105 = r100.f495256a;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L18:
        if (r107.hasNext() == false) goto L21;
        r106.add(Integer.valueOf(((lp1.a) r107.next()).getButton().f115915g));
        goto L18
    L21:
        if (r106.contains(Integer.valueOf(r104)) == false) goto L66;
        c0.b r108 = y3.f(p()).t(ToolbarButton.SHARE);
        if ((r108 instanceof e5) == true) goto L25;
        r108 = null;
    L25:
        final e5 r109 = (e5) r108;
        if (r109 != null) goto L38;
        c0 r111 = y3.m(p());
        if ((r111 instanceof x3) == true) goto L30;
        r111 = null;
    L30:
        x3 r112 = (x3) r111;
        if (r112 == null) goto L33;
        c0.b r113 = r112.t(ToolbarButton.SHARE);
    L35:
        if ((r113 instanceof e5) == true) goto L37;
        r113 = null;
    L37:
        r109 = (e5) r113;
        goto L38
    L33:
        r113 = null;
    L38:
        if (r109 != null) goto L40;
        ALogger.e(MoreMixSharePanelUtils.TAG, "IM toolbarShareBehavior is null");
        Single r114 = null;
    L59:
        if (r114 == null) goto L67;
        Disposable r115 = r114.subscribe(new m(this, r103, r101, r102), n.f116574a);
        if (r115 == null) goto L68;
        RxUtilKt.c(r115, this.f116538l);
        return;
    L68:
        return;
    L67:
        return;
    L40:
        RoomContext r116 = r109.f117137f;
        if (r116 == null) goto L43;
        r109.f117132a = r116.getRoom().getValue();
        r109.f117135d = r109.f117137f.getUser().getValue();
    L43:
        Room r117 = r109.f117132a;
        if (r117 != null) goto L47;
        Single r118 = Single.error(new Exception("room is null"));
    L46:
        r114 = r118;
        goto L59
    L47:
        final ShareParams.Builder r119 = ShareParams.buildUponRoom(r117);
        if (xl.f121614a.getValue().booleanValue() == false) goto L50;
        String r120 = ((IHostBusiness) jc1.k.f(IHostBusiness.class)).getBcmChainInfo();
    L51:
        String r121 = (String) r109.f117140i.get("log_action_type", "");
        final HashMap<String, String> r122 = new HashMap();
        if (e5.b() == false) goto L58;
        String r123 = g4.e();
        String r124 = g4.d();
        long r125 = z.o(r109.f117140i).getId();
        String r126 = z.o(r109.f117140i).getOwnerUserIdString();
        String r127 = r109.f117132a.lifeShareId;
        Intrinsics.checkNotNullParameter(r126, "userId");
        com.bytedance.android.livesdk.service.l.d().getClass();
        ShopGuideApi r128 = (ShopGuideApi) com.bytedance.android.live.network.c.b().e(ShopGuideApi.class);
        if (r128 == null) goto L56;
        Single<Response<k3>> r129 = r128.queryShopGuideId(r125, r126, r120, r127, "livebroadcasting", r123, r124, r121);
    L57:
        r118 = r129.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onErrorReturn(new z4()).doOnSuccess(new i5(r122, r119)).map(new a5(r109, r119, r122));
        goto L46
    L56:
        r129 = null;
        goto L57
    L58:
        r118 = Single.just(r109.e(r119, r122).build());
        goto L46
    L50:
        r120 = null;
        goto L51
    L66:
        return;
    L65:
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final View j(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r101 = LayoutInflater.from(r100.getContext());
        if (((Boolean) this.f116541o.getValue()).booleanValue() == false) goto L5;
        int r102 = R.layout.ttlive_more_panel_audience_share_im_element_no_im_title;
    L6:
        int r103 = 0;
        View r104 = r101.inflate(r102, r100, false);
        if (r104 == null) goto L9;
        ViewGroup r105 = (ViewGroup) r104.findViewById(R.id.share_im_placeholder);
    L10:
        this.f116536j = r105;
        if (r104 == null) goto L17;
        LinearLayout r106 = (LinearLayout) r104.findViewById(R.id.placeholder_item_container);
        if (r106 == null) goto L17;
        this.f116537k = r106;
        int r107 = s1.y() - UtilityKotlinExtentionsKt.i(10);
        int r108 = UtilityKotlinExtentionsKt.i(68);
        int r109 = UtilityKotlinExtentionsKt.i(12);
        int r110 = (int) ((((double) (r107 + r109)) / ((double) (r108 + r109))) + 1.0d);
    L15:
        if (r103 >= r110) goto L17;
        r101.inflate(R.layout.ttlive_more_panel_audience_share_im_placeholder_item, r106, true);
        r103 = r103 + 1;
    L17:
        return r104;
    L9:
        r105 = null;
        goto L10
    L5:
        r102 = R.layout.ttlive_more_panel_audience_share_im_element;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final void l(View r100) {
        Intrinsics.checkNotNullParameter(r100, "elementView");
        if (this.f116531e != null) goto L6;
        this.f116531e = (ViewGroup) r100.findViewById(R.id.share_element_im_container);
    L6:
        if (this.f116532f != null) goto L9;
        this.f116532f = (ViewGroup) this.f116542p.findView(R.id.im_share_container);
    L9:
        if (this.f116533g != null) goto L12;
        this.f116533g = this.f116542p.findView(R.id.im_share_layer);
    L12:
        if (this.f116534h != null) goto L15;
        this.f116534h = this.f116542p.findView(R.id.im_share_container_bottom_mask);
    L15:
        if (this.f116535i != null) goto L18;
        this.f116535i = this.f116542p.findView(R.id.more_mix_share_panel_root);
        return;
    }

    public static final void n(AudienceShareIMElement r110, List r111) {
        r110.getClass();
        LinkedHashMap r100 = new LinkedHashMap();
        Long r101 = null;
        if (r111.isEmpty() == false) goto L5;
        r110.r(com.bytedance.android.livesdk.locallife.g.a(r110.q(), null), r110.f116539m);
    L24:
        if (c1.b(r110.p()) == false) goto L50;
        JSONObject r112 = new JSONObject();
        Room r102 = r110.q();     // Catch: JSONException -> L38
        if (r102 == null) goto L31;
        IUser r103 = r102.author();     // Catch: JSONException -> L38
        if (r103 == null) goto L31;
        String r104 = r103.getIdString();     // Catch: JSONException -> L38
    L32:
        r112.put("anchor_id", r104);     // Catch: JSONException -> L38
        Room r105 = r110.q();     // Catch: JSONException -> L38
        if (r105 == null) goto L35;
        Long r106 = Long.valueOf(r105.f162599id);     // Catch: JSONException -> L38
    L36:
        r112.put("room_id", String.valueOf(r106));     // Catch: JSONException -> L38
    L40:
        k1.f(r112);
        ILiveDouPlusService r107 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
        if (r107 == null) goto L50;
        HashMap r108 = new HashMap();
        r108.put("ad_extra_data", r112.toString());
        Map<String, String> r113 = c1.e(r110.p());
        if (r113 != null) goto L45;
    L48:
        r107.logEvent(true, "live_ad", "live_share", r108);
        goto L50
    L45:
        if (r113.isEmpty() == true) goto L48;
        r108.putAll(r113);
        goto L48
    L35:
        r106 = null;
    L31:
        r104 = null;
    L38:
        e = move-exception;
        e.printStackTrace();
    L50:
        if (c1.c(r110.p()) == false) goto L81;
        JSONObject r114 = new JSONObject();
        Room r109 = r110.q();     // Catch: JSONException -> L63
        if (r109 == null) goto L57;
        IUser r115 = r109.author();     // Catch: JSONException -> L63
        if (r115 == null) goto L57;
        String r116 = r115.getIdString();     // Catch: JSONException -> L63
    L58:
        r114.put("anchor_id", r116);     // Catch: JSONException -> L63
        Room r117 = r110.q();     // Catch: JSONException -> L63
        if (r117 == null) goto L61;
        r101 = Long.valueOf(r117.f162599id);     // Catch: JSONException -> L63
    L61:
        r114.put("room_id", String.valueOf(r101));     // Catch: JSONException -> L63
    L65:
        k1.f(r114);
        ILiveDouPlusService r118 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
        if (r118 == null) goto L82;
        HashMap r119 = new HashMap();
        r119.put("ad_extra_data", r114.toString());
        Map<String, String> r120 = c1.f(r110.p());
        if (r120.isEmpty() == true) goto L71;
        r119.putAll(r120);
    L71:
        r118.logEvent(true, "live_ad", "live_share", r119);
        return;
    L82:
        return;
    L57:
        r116 = null;
    L63:
        e = move-exception;
        e.printStackTrace();
        goto L65
    L81:
        return;
    L5:
        Iterator r121 = r111.iterator();
    L7:
        if (r121.hasNext() == false) goto L24;
        LiveIMContact r122 = (LiveIMContact) r121.next();
        r100.clear();
        String r123 = "";
        if ((r122 instanceof LiveIMContact.LiveIMUser) == false) goto L16;
        LiveIMContact.LiveIMUser r124 = (LiveIMContact.LiveIMUser) r122;
        String r125 = r124.getId();
        if (r125 == null) goto L14;
        r123 = r125;
    L14:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r123);
        r100.putAll(com.bytedance.android.livesdk.locallife.g.a(r110.q(), r124.getId()));
    L22:
        r110.r(r100, r110.f116539m);
        goto L7
    L16:
        if ((r122 instanceof LiveIMContact.LiveConversation) == false) goto L22;
        String r126 = ((LiveIMContact.LiveConversation) r122).getConversationId();
        if (r126 == null) goto L21;
        r123 = r126;
    L21:
        r100.put("conversation_id", r123);
        r100.putAll(com.bytedance.android.livesdk.locallife.g.a(r110.q(), null));
        goto L22
    }

    public final void r(Map r100, Map r101) {
        HashMap r102 = new HashMap();
        r102.putAll(r100);
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_SHARE_PLATFORM, "chat_merge");
        if (TextUtils.equals("chat_merge", IBaseHostShare.SHARE_TO_DAILY) == false) goto L5;
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_SHARE_PLATFORM, "share_to_diary");
    L5:
        r102.put("is_pyramid_sale", "0");
        r102.put("type", "link");
        r102.put("share_type", "link");
        r102.put("request_page", "live_room");
        DataCenter r103 = this.f116542p.getDataCenter();
        Map<String, String> r104 = null;
        if (r103 == null) goto L8;
        Boolean r105 = (Boolean) r103.get("data_is_portrait", Boolean.TRUE);
    L9:
        String r106 = "1";
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L12;
        Object r107 = "1";
    L14:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(p()).isPaidLive() == true) goto L17;
        r106 = "0";
    L17:
        r102.put("is_paidlive", r106);
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_WATCH_PAID_LIVE_STATUS, com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(p()).J0().q(p()));
        r102.put("is_from_shopping_guide", "0");
        r102.put("shopping_guide_id", "");
        r102.put("is_vr_machine", VrUtils.o(p()));
        r102.put("room_orientation", r107);
        if (r101 != null) goto L20;
    L47:
        r102.put("enter_from", "share_panel");
        com.bytedance.android.livesdk.log.u.l().sendLog("share", r102, new Object[]{new am2.x(), Room.class, am2.n.f()});
        return;
    L20:
        if (r101.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LOCALLIFE_LIVE_PARAMS) == false) goto L47;
        String r108 = (String) r101.get(ILiveRoomPlayFragmentConstant.EXTRA_LOCALLIFE_LIVE_PARAMS);
        Room r109 = q();
        HashMap r110 = new HashMap();
        if (r108 != null) goto L24;
    L27:
        boolean r111 = true;
    L28:
        if (r111 == true) goto L46;
        if (r109 != null) goto L50;
    L31:
        String r112 = new JSONObject(r108).optString("share_info");     // Catch: Exception -> L49
        if (TextUtils.isEmpty(r112) == true) goto L46;
        ILiveShareService r113 = (ILiveShareService) jc1.k.f(ILiveShareService.class);     // Catch: Exception -> L49
        if (r113 == null) goto L37;
        r104 = r113.getLocalLifeShareParams(r112);     // Catch: Exception -> L49
    L37:
        if (r104 != null) goto L39;
    L42:
        boolean r114 = true;
    L43:
        if (r114 == true) goto L45;
        r110.putAll(r104);     // Catch: Exception -> L49
    L45:
        com.bytedance.android.livesdk.chatroom.c1 r115 = (com.bytedance.android.livesdk.chatroom.c1) GsonHelper.get().fromJson(r112, com.bytedance.android.livesdk.chatroom.c1.class);     // Catch: Exception -> L49
        goto L46
    L39:
        if (r104.isEmpty() == true) goto L42;
        r114 = false;
        goto L43
    L50:
        r110.put("life_share_id", r109.lifeShareId);     // Catch: Exception -> L49
    L46:
        r102.putAll(r110);
        goto L47
    L24:
        if (r108.length() == 0) goto L27;
        r111 = false;
        goto L28
    L12:
        r107 = "0";
        goto L14
    L8:
        r105 = null;
        goto L9
    }

    public static final void m(AudienceShareIMElement r100, LiveIMShareContactType r101, LiveIMContact r102, boolean r103) {
        r100.getClass();
        int r104 = e.f116557a[r101.ordinal()];
        if (r104 == 1) goto L12;
        if (r104 != 2) goto L7;
        s(null, null, null, true, false);
        return;
    L7:
        if (r104 != 3) goto L22;
        s(null, null, null, false, true);
        return;
    L22:
        return;
    L12:
        if ((r102 instanceof LiveIMContact.LiveIMUser) == false) goto L15;
        s(Boolean.valueOf(r103), ((LiveIMContact.LiveIMUser) r102).getId(), null, false, false);
        return;
    L15:
        if ((r102 instanceof LiveIMContact.LiveConversation) == false) goto L21;
        s(Boolean.valueOf(r103), null, ((LiveIMContact.LiveConversation) r102).getConversationId(), false, false);
        return;
    }

    public static void s(Boolean r100, String r101, String r102, boolean r103, boolean r104) {
        LinkedHashMap r105 = new LinkedHashMap();
        if (r101 == null) goto L5;
        r105.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r101);
    L5:
        if (r102 == null) goto L7;
        r105.put("conversation_id", r102);
    L7:
        if (r100 == null) goto L13;
        r100.booleanValue();
        if (r100.booleanValue() == false) goto L11;
        String r106 = "select";
    L12:
        r105.put("after_status", r106);
        goto L13
    L11:
        r106 = "cancel";
    L13:
        String r107 = "1";
        if (r103 == false) goto L16;
        Object r108 = "1";
    L17:
        r105.put("is_more_click", r108);
        if (r104 == true) goto L21;
        r107 = "0";
    L21:
        r105.put("is_recent_click", r107);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_share_panel_head_click", r105, new Object[]{Room.class, am2.x.class});
        return;
    L16:
        r108 = "0";
        goto L17
    }
}
