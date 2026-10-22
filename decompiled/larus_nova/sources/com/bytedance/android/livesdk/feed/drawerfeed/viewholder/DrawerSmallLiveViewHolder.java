package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.config.bp;
import com.bytedance.android.livesdk.config.jr;
import com.bytedance.android.livesdk.feed.drawerfeed.widget.FixedRatioRelativeLayout;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.widget.DrawLiveCoverOptView;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAppearance;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import j40.b4;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class DrawerSmallLiveViewHolder extends DrawerCommonLiveViewHolder {
    public static int V = -1;
    public static int W = -1;
    public static int X = -1;
    public static final List<String> Y = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ViewGroup f123925J;
    public final ViewGroup K;
    public final ViewGroup L;
    public final ImageView M;
    public final TextView N;
    public final ViewGroup O;
    public boolean P;
    public Disposable Q;
    public final HSImageView R;
    public final View S;
    public j0 T;
    public final DrawLiveCoverOptView U;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrawerSmallLiveViewHolder f123926a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
        }

        public a(DrawerSmallLiveViewHolder r100) {
            this.f123926a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Disposable r101 = this.f123926a.Q;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.isDisposed() == true) goto L9;
            this.f123926a.Q.dispose();
            this.f123926a.Q = null;
            return;
        }
    }

    public class b implements Observer<FollowPair> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Room f123927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DrawerSmallLiveViewHolder f123928b;

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            f2.b(R.string.ttlive_feed_live_no_network, 0);
        }

        @Override // io.reactivex.Observer
        public final void onNext(FollowPair r100) {
            DrawerSmallLiveViewHolder r101 = this.f123928b;
            int r102 = DrawerSmallLiveViewHolder.V;
            r101.f124095b.e(r101.f124096c, String.valueOf(this.f123927a.getId()));
            DrawerSmallLiveViewHolder r103 = this.f123928b;
            if (r103.f124107n == null) goto L7;
            com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
            String r104 = r103.V3();
            String r105 = r103.i4();
            HashMap r106 = new HashMap();
            r106.put("enter_from_merge", r104);
            r106.put("enter_method", r105);
            r106.put("action_type", "click");
            r106.put("request_page", com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK);
            r106.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, String.valueOf(r103.f124107n.getOwnerUserIdString()));
            r106.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_cover");
            r106.putAll(r103.j4());
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_unfollow", r106, new Object[]{Room.class, am2.n.f()});
            return;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (r100 == null) goto L5;
            this.f123928b.register(r100);
            return;
        }

        public b(DrawerSmallLiveViewHolder r100, Room r101) {
            this.f123928b = r100;
            this.f123927a = r101;
        }
    }

    public String k4() {
        return "";
    }

    static {
        Y = Arrays.asList(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public String V3() {
        com.bytedance.android.livesdk.feed.h r100 = this.f124106m;
        if (r100 == null) goto L13;
        if (r100.wg() == null) goto L13;
        String r101 = this.f124106m.wg().j();
        String r102 = this.f124106m.wg().e();
        if (TextUtils.isEmpty(r101) == true) goto L10;
        return r101;
    L10:
        if (TextUtils.isEmpty(r102) == true) goto L13;
        return r102;
    L13:
        if (Y.contains(super.V3()) == false) goto L17;
        return "drawer_follow";
    L17:
        if (TextUtils.equals(super.V3(), "homepage_fresh") == false) goto L20;
        return "drawer_city";
    L20:
        return "drawer_hot";
    }

    public String i4() {
        if (this.G == false) goto L6;
        return "drawer_cell";
    L6:
        return "drawer_cover";
    }

    public HashMap<String, String> j4() {
        HashMap<String, String> r100 = new HashMap();
        if (TTLiveService.getLiveService() == null) goto L5;
        String r101 = TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();
    L6:
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_VS_DRAWER_PAGE, r101);
        Room r102 = this.f124107n;
        if (r102 != null) goto L9;
    L20:
        return r100;
    L9:
        if (r102.isMergeVSRoom() == false) goto L20;
        LiveVSLog.f153393r.getClass();
        r100.putAll(LiveVSLog.b.a(r102).a());
        Activity r103 = bz2.b.a(this.itemView.getContext());
        if (r103 == null) goto L20;
        if (r103.getRequestedOrientation() != 0) goto L15;
    L18:
        String r104 = "landscape";
    L19:
        r100.put("vs_screen_type", r104);
        goto L20
    L15:
        if (r103.getRequestedOrientation() == 6) goto L18;
        r104 = "portrait";
        goto L19
    L5:
        r101 = "";
        goto L6
    }

    public boolean r4() {
        if (jr.f120546a.getValue().booleanValue() == true) goto L6;
        return false;
    L6:
        if (TTLiveService.getLiveService() != null) goto L8;
    L11:
        return false;
    L8:
        if (TTLiveService.getLiveService().getLiveOntologyRecord() == null) goto L11;
        String r100 = TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();
        TTLiveService.getLiveService().getLiveOntologyRecord().getEnterMethod();
        return bx1.a.a(r100);
    }

    public static Boolean n4() {
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L7;
        return Boolean.FALSE;
    L7:
        return Boolean.valueOf(e5.n());
    }

    public boolean m4() {
        ILiveService r100 = TTLiveService.getLiveService();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getLiveOntologyRecord() == null) goto L10;
        String r101 = TTLiveService.getLiveService().getLiveOntologyRecord().getReqFrom();
        return Y.contains(r101);
    L10:
        return false;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void unbind() {
        super.unbind();
        j0 r100 = this.T;
        if (r100 == null) goto L7;
        ViewGroup r101 = this.f123925J;
        if (r101 == null) goto L7;
        r101.removeOnLayoutChangeListener(r100);
    L7:
        this.T = null;
    }

    public static Activity l4(View r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Context r101 = r100.getContext();
        if (r101 != null) goto L9;
        return null;
    L9:
        if ((r101 instanceof ContextWrapper) == false) goto L15;
        if ((r101 instanceof Activity) == true) goto L13;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L9
    L13:
        return (Activity) r101;
    L15:
        return null;
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder
    public final void c4(FeedItem r100) {
        if (r100 != null) goto L4;
    L11:
        Bundle r101 = new Bundle();
        r101.putLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME, System.currentTimeMillis());
        String r102 = this.f124096c.f124004b;
        if (r102.contains("live") == false) goto L16;
        com.bytedance.android.livesdk.feed.feed.e r103 = this.f124101h;
        if (r103 == null) goto L16;
        r102 = r103.e();
    L16:
        r101.putString("source", r102);
        Bundle r104 = new Bundle();
        r104.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SOURCE, "live_small_picture");
        r104.putString("subtab", r102);
        Map<String, String> r105 = this.f124104k;
        String r106 = "";
        if (r105 != null) goto L19;
    L22:
        String r107 = "";
    L23:
        r104.putString("pull_type", r107);
        if (TextUtils.isEmpty(this.f124104k.get("cover_content_category")) == true) goto L26;
        r104.putString("cover_content_category", this.f124104k.get("cover_content_category"));
    L26:
        r101.putBundle(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_EXTRA_V1, r104);
        r101.putString("log_pb", r100.logPb);
        r101.putString("request_id", r100.resId);
        r101.putInt(VSConstants.EXTRA_ITEM_TYPE, r100.type);
        r101.putString("enter_from", "live");
        com.bytedance.android.livesdk.feed.feed.e r108 = this.f124101h;
        if (r108 == null) goto L29;
        r101.putLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_FROM, r108.l());
    L29:
        r101.putString("enter_from_merge", V3());
        r101.putString("enter_method", i4());
        r101.putInt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_ORDER, this.f124108o);
        if (r100.isRecommendCard == false) goto L33;
        r101.putString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FROM_MERGE_RECOMMEND, "pop_card");
    L33:
        if (TextUtils.isEmpty(r100.liveReason) == true) goto L36;
        r101.putString("live_reason", r100.liveReason);
    L36:
        if (r100.getRoom() == null) goto L41;
        if (TextUtils.isEmpty(r100.getRoom().getItemExplicitInfo()) == true) goto L41;
        r101.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO, r100.getRoom().getItemExplicitInfo());
    L41:
        if (TTLiveService.getLiveService() == null) goto L43;
        r106 = TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();
    L43:
        r101.putString(ILiveRoomPlayFragmentConstant.EXTRA_VS_DRAWER_PAGE, r106);
        r101.putString("drawer_inner_req_from", k4());
        if (r100.getRoom() != null) goto L46;
    L48:
        Y3(r100, false, "small_picture", r101);
        return;
    L46:
        if (r100.getRoom().getContentLabel() == null) goto L48;
        r101.putString("drawer_room_icon_type", String.valueOf(r100.getRoom().getContentLabel().getImageType()));
        goto L48
    L19:
        if (TextUtils.isEmpty(r105.get("pull_type")) == true) goto L22;
        r107 = this.f124104k.get("pull_type");
        goto L23
    L4:
        if (r100.getRoom() == null) goto L11;
        HashMap<String, String> r109 = j4();
        com.bytedance.android.livesdk.log.filter.o r110 = com.bytedance.android.livesdk.log.u.l().c(am2.o.class);
        if (r110 == null) goto L11;
        if (r110.getMap() == null) goto L11;
        r110.getMap().putAll(r109);
        am2.o r111 = new am2.o();
        r111.f4321a = r100.getRoom().getId();
        r110.setData(r111);
        goto L11
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder
    public final void d4(ImageModel r100) {
        if (r100 != null) goto L4;
        q4(0, 0);
        return;
    L4:
        q4(r100.width, r100.height);
    }

    public final void g4(boolean r100) {
        if (r100 == true) goto L5;
        UIUtils.setViewVisibility(this.K, 8);
        this.P = false;
        UIUtils.setViewVisibility(this.U, 0);
        return;
    L5:
        if (this.f124107n == null) goto L12;
        com.bytedance.android.livesdk.log.filter.o r101 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r102 = V3();
        String r103 = i4();
        if (r101.getMap().containsKey("action_type") == false) goto L10;
        String r104 = r101.getMap().get("action_type");
    L11:
        HashMap r105 = new HashMap();
        r105.put("enter_from_merge", r102);
        r105.put("enter_method", r103);
        r105.put("action_type", r104);
        r105.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_cover");
        r105.putAll(j4());
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_click_trans_layer", r105, new Object[]{Room.class});
        goto L12
    L10:
        r104 = "";
    L12:
        this.P = true;
        UIUtils.setViewVisibility(this.K, 0);
        UIUtils.setViewVisibility(this.O, 8);
        UIUtils.setViewVisibility(this.U, 8);
    }

    public final void h4(final Room r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        register(this.f124094a.a(r100.getId(), r100.getOwnerUserIdString(), r100.getRequestId(), V3(), i4()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g0(this, r100), new h0(this)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s4(Room r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getBaseOwner() == null) goto L12;
        FollowInfo r101 = (FollowInfo) r100.getBaseOwner().getFollowInfo();
        if (r101 == null) goto L9;
        r101.getFollowStatus();
    L9:
        com.bytedance.android.livesdk.user.f r102 = ((IUserService) jc1.k.f(IUserService.class)).user();
        com.bytedance.android.livesdk.user.n.b r103 = new com.bytedance.android.livesdk.user.n.b();
        l4(this.itemView);
        com.bytedance.android.livesdk.user.n.b r104 = (com.bytedance.android.livesdk.user.n.b) ((com.bytedance.android.livesdk.user.n.b) ((com.bytedance.android.livesdk.user.n.b) r103.f(r100.getId())).c(r100.getOwnerUserIdString())).e(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.LIVE_DRAWER));
        r104.getClass();
        r102.G(new com.bytedance.android.livesdk.user.n(r104)).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r100));
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final void X3(Room r110, Map<String, String> r111) {
        ((HashMap) r111).putAll(j4());
        String r100 = ((IHostBusiness) jc1.k.f(IHostBusiness.class)).createBtmId(((IHostBusiness) jc1.k.f(IHostBusiness.class)).getBtmIdByWidget("livesdk_live_drawer_widget"), this.O);
        if (r100.isEmpty() == true) goto L5;
        ((HashMap) r111).put("btm_id", r100);
    L5:
        super.X3(r110, r111);
        if (r110 != null) goto L9;
        return;
    L9:
        if (r110.getBaseOwner() != null) goto L11;
        String r112 = "0";
    L12:
        HashMap r101 = new HashMap();
        r101.put("enter_from_merge", V3());
        r101.put("enter_method", i4());
        r101.put("anchor_id", r112);
        r101.put("request_id", r110.getRequestId());
        r101.put("room_id", String.valueOf(r110.getId()));
        r101.put("action_type", "click");
        JSONObject r113 = new JSONObject();
        String r102 = "";
        if (this.U.getStyle() != 0) goto L33;
    L30:
        e = move-exception;
        e.printStackTrace();
    L92:
        r101.put("basic_info", r113.toString());
        r101.putAll(j4());
        com.bytedance.android.livesdk.log.u.l().sendLog("live_cover_info", r101, new Object[0]);
        return;
    L15:
        if (r110.getBaseOwner() != null) goto L17;
        String r103 = "";
    L18:
        r113.put("location", r103);     // Catch: Exception -> L30
        if (b4() == true) goto L22;
        r102 = r110.getLiveHashTagJson();     // Catch: Exception -> L30
    L22:
        r113.put("challenge_info", r102);     // Catch: Exception -> L30
        if (r110.isMediaRoom() == true) goto L25;
    L27:
        long r104 = r110.getUserCount();     // Catch: Exception -> L30
    L28:
        r113.put("user_count", r104);     // Catch: Exception -> L30
        goto L92
    L25:
        if (r110.getStats() == null) goto L27;
        r104 = r110.getStats().getTotalUser();     // Catch: Exception -> L30
        goto L28
    L17:
        r103 = r110.getBaseOwner().getCity();     // Catch: Exception -> L30
        goto L18
    L33:
        if (this.U.getStyle() != 1) goto L61;
    L52:
        e = move-exception;
        e.printStackTrace();
    L55:
        if (r110.getContentLabel() == null) goto L58;
        r101.put("main_info", String.valueOf(r110.getContentLabel().getImageType()));
    L58:
        if (r110.getOperationLabel() == null) goto L92;
        r101.put("sub_info", String.valueOf(r110.getOperationLabel().getImageType()));
        goto L92
    L35:
        if (b4() == false) goto L37;
        String r105 = "";
    L38:
        r113.put("challenge_info", r105);     // Catch: Exception -> L52
        if (b4() == true) goto L41;
    L43:
        r102 = r110.getContentTag();     // Catch: Exception -> L52
    L44:
        r113.put("content_tag", r102);     // Catch: Exception -> L52
        if (r110.isMediaRoom() == true) goto L47;
    L49:
        long r106 = r110.getUserCount();     // Catch: Exception -> L52
    L50:
        r113.put("user_count", r106);     // Catch: Exception -> L52
        goto L55
    L47:
        if (r110.getStats() == null) goto L49;
        r106 = r110.getStats().getTotalUser();     // Catch: Exception -> L52
        goto L50
    L41:
        if (r110.getLiveHashTagInfo() == null) goto L43;
    L37:
        r105 = r110.getLiveHashTagJson();     // Catch: Exception -> L52
        goto L38
    L61:
        if (this.U.getStyle() != 2) goto L92;
    L84:
        e = move-exception;
        e.printStackTrace();
    L87:
        if (r110.getContentLabel() == null) goto L90;
        r101.put("main_info", String.valueOf(r110.getContentLabel().getImageType()));
    L90:
        if (r110.getOperationLabel() == null) goto L92;
        r101.put("sub_info", String.valueOf(r110.getOperationLabel().getImageType()));
        goto L92
    L63:
        if (r110.getBaseOwner() != null) goto L65;
        String r107 = "";
    L66:
        r113.put("location", r107);     // Catch: Exception -> L84
        if (b4() == false) goto L69;
        String r108 = "";
    L70:
        r113.put("challenge_info", r108);     // Catch: Exception -> L84
        if (b4() == true) goto L73;
    L75:
        r102 = r110.getContentTag();     // Catch: Exception -> L84
    L76:
        r113.put("content_tag", r102);     // Catch: Exception -> L84
        if (r110.isMediaRoom() == true) goto L79;
    L81:
        long r109 = r110.getUserCount();     // Catch: Exception -> L84
    L82:
        r113.put("user_count", r109);     // Catch: Exception -> L84
        goto L87
    L79:
        if (r110.getStats() == null) goto L81;
        r109 = r110.getStats().getTotalUser();     // Catch: Exception -> L84
        goto L82
    L73:
        if (r110.getLiveHashTagInfo() == null) goto L75;
    L69:
        r108 = r110.getLiveHashTagJson();     // Catch: Exception -> L84
        goto L70
    L65:
        r107 = r110.getBaseOwner().getCity();     // Catch: Exception -> L84
        goto L66
    L11:
        r112 = r110.getBaseOwner().getIdString();
        goto L12
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder
    public final void a4(ImageModel r100, Room r101) {
        if (b4.a() == false) goto L7;
        j0 r102 = new j0(this, r100);
        this.T = r102;
        ViewGroup r103 = this.f123925J;
        if (r103 == null) goto L7;
        r103.addOnLayoutChangeListener(r102);
    L7:
        q4(r100.getWidth(), r100.getHeight());
        super.a4(r100, r101);
    }

    public final void q4(int r100, int r101) {
        if (n4().booleanValue() == false) goto L5;
        int r102 = W;
    L6:
        V = r102;
        V = (this.f123925J.getMeasuredWidth() - 3) / 2;
        if (n4().booleanValue() == false) goto L9;
        W = V;
    L10:
        if (r100 <= 0) goto L14;
        if (r101 <= 0) goto L14;
        int r103 = (int) (V / 0.7619048f);
    L15:
        ViewGroup.LayoutParams r104 = this.f124111s.getLayoutParams();
        int r105 = r104.width;
        int r106 = V;
        if (r105 == r106) goto L18;
    L20:
        r104.width = r106;
        r104.height = r103;
        this.f124111s.setLayoutParams(r104);
        return;
    L18:
        if (r104.height != r103) goto L20;
        return;
    L14:
        r103 = V;
        goto L15
    L9:
        X = V;
        goto L10
    L5:
        r102 = X;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerCommonLiveViewHolder, com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder, com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public void U3(FeedItem r100, final Room r110, int r111) {
        super.U3(r100, r110, r111);
        e4(this.f124115w, 8);
        if (r110.isMediaRoom() == false) goto L9;
        e4(this.f124116x, 8);
        User r101 = (User) r110.getBaseOwner();
        if (r101 == null) goto L9;
        if (TextUtils.isEmpty(r101.getRealNickName()) == true) goto L9;
        e4(this.f124110r, 0);
        this.f124110r.setText(r101.getRealNickName());
    L9:
        this.itemView.setOnLongClickListener(new y(this, r110));
        this.K.setVisibility(8);
        TTLiveService.getLiveService().getLiveOntologyRecord().getReqFrom();
        this.K.setOnClickListener(new z(this));
        if (m4() == false) goto L12;
        this.M.setImageResource(R.drawable.ttlive_mask_layer_unfollow);
        this.N.setText(R.string.ttlive_feed_unfollow);
        this.M.setOnClickListener(new a0(this, r110));
        this.N.setOnClickListener(new b0(this, r110));
    L13:
        this.N.setImportantForAccessibility(4);
        this.M.setImportantForAccessibility(4);
        this.L.setContentDescription(this.N.getText() + this.itemView.getContext().getString(R.string.ttlive_drawer_dislike_accessability_hint));
        Disposable r102 = this.Q;
        if (r102 != null) goto L16;
    L18:
        Disposable r103 = xs2.b.a().b(yv1.a.class).subscribe(new e0(this, r110), new f0());
        this.Q = r103;
        if (r103 == null) goto L21;
        register(r103);
    L21:
        UIUtils.setViewVisibility(this.f124112t, 8);
        UIUtils.setViewVisibility(this.O, 8);
        this.U.setVisibility(0);
        this.U.c(r110);
        this.itemView.addOnAttachStateChangeListener(new a(this));
        if (r4() == false) goto L30;
        if (TextUtils.isEmpty(r110.getDistanceKm()) == true) goto L30;
        DrawLiveCoverOptView r104 = this.U;
        r104.getClass();
        String r105 = r110.getDistanceKm();
        if (TextUtils.isEmpty(r105) == true) goto L28;
        r104.f160966l.setText(r105);
        r104.f160966l.setVisibility(0);
        r104.f160958d.setMaxEms(4);
    L28:
        r104.f160967m.setVisibility(8);
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r104.f160961g.getLayoutParams();
        r106.bottomMargin = s1.f(6.0f);
        r104.f160961g.setLayoutParams(r106);
    L30:
        if (f4() == false) goto L47;
        DrawLiveCoverOptView r107 = this.U;
        r107.getClass();
        String r108 = r110.getDistanceKm();
        int r109 = bp.f119889a.getValue().intValue();
        r107.f160966l.setTypeface(Typeface.defaultFromStyle(1));
        if (r109 != 3) goto L35;
        r107.f160966l.setVisibility(8);
        r107.f160967m.setVisibility(0);
        r107.f160958d.setMaxEms(8);
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r107.f160961g.getLayoutParams();
        r112.bottomMargin = 0;
        r107.f160961g.setLayoutParams(r112);
    L46:
        this.U.e(r110, false);
    L48:
        View r113 = this.S;
        if (r113 == null) goto L51;
        r113.setVisibility(0);
    L51:
        DrawLiveCoverOptView r114 = this.U;
        if (r114 == null) goto L57;
        ViewGroup r115 = r114.f160968n;
        if (r115 == null) goto L57;
        r115.setBackgroundResource(R.drawable.ttlive_bg_cover);
    L57:
        if (this.R == null) goto L77;
        RoomAppearance r116 = r110.appearance;
        if (r116 != null) goto L62;
    L72:
        this.R.setVisibility(8);
        return;
    L62:
        if (r116.getCoverDynamicMask() == null) goto L72;
        this.R.setVisibility(0);
        ImageLoader.d r117 = ImageLoader.load(r110.appearance.getCoverDynamicMask());
        r117.f66060e = new i0(this);
        r117.f66061f = true;
        r117.a(this.R);
        View r118 = this.S;
        if (r118 == null) goto L67;
        r118.setVisibility(8);
    L67:
        DrawLiveCoverOptView r119 = this.U;
        if (r119 == null) goto L74;
        ViewGroup r120 = r119.f160968n;
        if (r120 == null) goto L75;
        r120.setBackground(null);
        return;
    L75:
        return;
    L74:
        return;
    L77:
        return;
    L35:
        if (r109 != 2) goto L42;
        if (TextUtils.isEmpty(r108) == true) goto L39;
        r107.f160966l.setText(r108);
        r107.f160966l.setVisibility(0);
        r107.f160958d.setMaxEms(4);
    L40:
        r107.f160967m.setVisibility(8);
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r107.f160961g.getLayoutParams();
        r121.bottomMargin = s1.f(6.0f);
        r107.f160961g.setLayoutParams(r121);
        goto L46
    L39:
        r107.f160966l.setVisibility(8);
        r107.f160958d.setMaxEms(8);
        goto L40
    L42:
        if (TextUtils.isEmpty(r108) == true) goto L44;
        r107.f160963i.setText(r108);
    L45:
        r107.f160958d.setMaxEms(8);
        r107.f160966l.setVisibility(8);
        r107.f160967m.setVisibility(0);
        ViewGroup.MarginLayoutParams r122 = (ViewGroup.MarginLayoutParams) r107.f160961g.getLayoutParams();
        r122.bottomMargin = 0;
        r107.f160961g.setLayoutParams(r122);
        goto L46
    L44:
        r107.f160963i.setVisibility(8);
        goto L45
    L47:
        this.U.e(r110, true);
        goto L48
    L16:
        if (r102.isDisposed() == true) goto L18;
        this.Q.dispose();
        goto L18
    L12:
        this.M.setImageResource(R.drawable.ttlive_dislike);
        this.N.setText(R.string.ttlive_feed_dislike);
        this.M.setOnClickListener(new c0(this, r110));
        this.N.setOnClickListener(new d0(this, r110));
        goto L13
    }

    public DrawerSmallLiveViewHolder(View r110, tv1.c r111, com.bytedance.android.livesdk.feed.f r112, FeedDataKey r113, com.bytedance.android.livesdk.feed.j r114, ILiveRoomListDataSource r115, PublishSubject r116, PublishSubject r210, ViewGroup r211, Map r212, com.bytedance.android.livesdk.feed.h r213) {
        super(r110, r111, r112, r113, r114, r115, r116, r210, r213);
        this.P = false;
        this.f123925J = r211;
        this.K = (ViewGroup) r110.findViewById(R.id.dislike_layout);
        this.M = (ImageView) r110.findViewById(R.id.iv_dislike);
        this.N = (TextView) r110.findViewById(R.id.tv_dislike);
        this.L = (ViewGroup) r110.findViewById(R.id.dislike_accessibility_layout);
        this.O = (ViewGroup) r110.findViewById(R.id.content_container);
        DrawLiveCoverOptView r100 = (DrawLiveCoverOptView) r110.findViewById(R.id.live_cover_opt_view);
        this.U = r100;
        FixedRatioRelativeLayout r101 = (FixedRatioRelativeLayout) r110.findViewById(R.id.drawer_small_container);
        this.R = (HSImageView) r110.findViewById(R.id.live_cover_dynamic_mask);
        this.S = r110.findViewById(R.id.live_drawer_origin_mask);
        this.f124104k = r212;
        r101.setRatio(0.7619048f);
        if (n4().booleanValue() == false) goto L6;
        r100.a();
        return;
    }
}
