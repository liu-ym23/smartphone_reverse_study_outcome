package com.bytedance.android.livesdk.coupon;

import am2.x;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.v;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.qi1;
import com.bytedance.android.livesdk.coupon.customview.UgCouponGoodsNewDialog;
import com.bytedance.android.livesdk.coupon.customview.s;
import com.bytedance.android.livesdk.coupon.util.UgCouponNewDialogFrequencyController;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.pj;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import vlc.l;

/* JADX INFO: loaded from: classes8.dex */
public class UgCouponWidget extends LiveRecyclableWidget implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vlc.d f121809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f121810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f121811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f121812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f121813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f121814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f121815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final UgCouponNewDialogFrequencyController f121816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.live.room.l f121817i;

    public class a implements kf1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UgCouponWidget f121818a;

        @Override // kf1.a
        public final String tag() {
            return "UgCouponWidget";
        }

        @Override // kf1.a
        public final CloseRoomInterceptList config() {
            return CloseRoomInterceptList.UG_COUPON_REMAIN;
        }

        public a(UgCouponWidget r100) {
            this.f121818a = r100;
        }

        @Override // kf1.a
        public final boolean qa(Runnable r110, boolean r210) {
            if (r210 == false) goto L5;
            return false;
        L5:
            UgCouponWidget r100 = this.f121818a;
            if (r100.f121813e == false) goto L8;
            return false;
        L8:
            b r101 = r100.f121812d;
            if (r101 != null) goto L11;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, ugCouponResponse is null");
        L40:
            boolean r102 = false;
        L42:
            if (r102 == false) goto L73;
            UgCouponWidget r103 = this.f121818a;
            b r104 = r103.f121812d;
            if (r104 == null) goto L72;
            int r105 = r104.windowStyle;
            if (r105 != 1) goto L57;
            b.c r106 = r104.couponData;
            if (r106 == null) goto L72;
            s r107 = new s(r103.context, r106, new f(r103, r106, r110));
            r107.setCanceledOnTouchOutside(false);
            if (DialogLancet.shouldBlockDialogShow(r107) == false) goto L81;
            DialogLancet.handleBlockedDialogShow(r107);
        L56:
            r103.f121813e = true;
            com.bytedance.android.livesdk.sharedpref.e<Integer> r108 = com.bytedance.android.livesdk.sharedpref.b.A1;
            com.bytedance.android.livesdk.sharedpref.f.d(r108, Integer.valueOf(r108.getValue().intValue() + 1));
            com.bytedance.android.livesdk.sharedpref.e<Long> r109 = com.bytedance.android.livesdk.sharedpref.b.B1;
            Long r111 = Long.valueOf(System.currentTimeMillis());
            r109.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r109, r111);
            HashMap r112 = new HashMap();
            r112.put("coupon_id", r106.couponId);
            r112.put("coupon_meta_id", r106.couponMetaId);
            u.l().sendLog("tobsdk_livesdk_unused_coupon_pop_show", r112, new Object[]{Room.class, x.class});
            goto L72
        L81:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L74
        L55:
            DialogLancet.beforeDialogShow(r107);
            r107.show();
            DialogLancet.afterDialogShow(r107);
            goto L56
        L57:
            if (r105 != 2) goto L64;
            com.bytedance.android.livesdk.coupon.customview.h r113 = new com.bytedance.android.livesdk.coupon.customview.h(r103.context, r104, new g(r103, r104, r110));
            if (DialogLancet.shouldBlockDialogShow(r113) == false) goto L77;
            DialogLancet.handleBlockedDialogShow(r113);
        L63:
            r103.f121813e = true;
            UgCouponWidget.Cq(r104);
            ((com.bytedance.android.livesdk.coupon.util.b) r103.f121816h.f121920b.getValue()).call();
            goto L72
        L77:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L75
        L62:
            DialogLancet.beforeDialogShow(r113);
            r113.show();
            DialogLancet.afterDialogShow(r113);
            goto L63
        L64:
            if (r105 != 3) goto L71;
            UgCouponGoodsNewDialog r114 = new UgCouponGoodsNewDialog(r103.context, r104, new h(r103, r104, r110));
            if (DialogLancet.shouldBlockDialogShow(r114) == false) goto L79;
            DialogLancet.handleBlockedDialogShow(r114);
        L70:
            r103.f121813e = true;
            UgCouponWidget.Cq(r104);
            ((com.bytedance.android.livesdk.coupon.util.b) r103.f121816h.f121920b.getValue()).call();
            goto L72
        L79:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L76
        L69:
            DialogLancet.beforeDialogShow(r114);
            r114.show();
            DialogLancet.afterDialogShow(r114);
            goto L70
        L71:
            ALogger.w("UgCouponWidget", "showDialog() >>> invalid windowStyle?");
        L72:
            return true;
        L73:
            return false;
        L11:
            int r115 = r101.windowStyle;
            if (y3.l().n(ToolbarButton.COMMERCE) == true) goto L15;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, commerce is not show windowStyle=" + r115);
            goto L40
        L15:
            if (r100.yq(r115) == false) goto L18;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, show count max windowStyle=" + r115);
            goto L40
        L18:
            if (r115 != 1) goto L23;
            b.c r116 = r101.couponData;
            if (r116 != null) goto L22;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, coupon is null windowStyle=" + r115);
            goto L40
        L22:
            long r117 = r116.expireTimestamp;
            long r118 = 0;
        L34:
            long r119 = com.bytedance.android.livesdk.utils.ntp.e.a() / 1000;
            r100.f121815g = r119;
            if (r119 <= r117) goto L37;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, coupon expired, expTime:" + r117 + " curTime:" + r100.f121815g + " windowStyle: " + r115);
            goto L40
        L37:
            long r120 = r100.f121817i.getDuration() / 1000;
            if (r120 >= r118) goto L41;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, watch time not reach minWatchTime: [" + r118 + "s]  currentRoomWatchDuration: [" + r120 + "s]  windowStyle: " + r115);
            goto L40
        L41:
            r102 = true;
            goto L42
        L23:
            if (r115 == 3) goto L27;
            if (r115 == 2) goto L27;
            ALogger.i("UgCouponWidget", "unknown window_style=" + r115);
        L27:
            b.C1771b r121 = r101.retainWindowInfoV2;
            if (r121 != null) goto L30;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, retainWindowInfoV2 is null windowStyle=" + r115);
            goto L40
        L30:
            b.c r122 = r121.couponData;
            if (r122 != null) goto L33;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, coupon is null windowStyle=" + r115);
            goto L40
        L33:
            r117 = r122.expireTimestamp;
            r118 = r121.minWatchTime;
            goto L34
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public static ILiveOntologyInfoManager zq() {
        IMiddlewareLiveService r100 = (IMiddlewareLiveService) k.f(IMiddlewareLiveService.class);
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getLiveOntologyRecord();
    }

    public final boolean Bq() {
        com.bytedance.android.livesdk.coupon.util.b r100 = (com.bytedance.android.livesdk.coupon.util.b) this.f121816h.f121920b.getValue();
        boolean r101 = false;
        if (r100.f121923a <= 0) goto L18;
        long r102 = com.bytedance.android.livesdk.coupon.util.b.a();
        int r103 = 1 - r100.f121923a;
        Calendar r104 = Calendar.getInstance();
        r104.setTime(new Date(r102));
        r104.add(5, r103);
        long r105 = r104.getTimeInMillis();
        List<Long> r106 = r100.f121925c.a();
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L7:
        if (r108.hasNext() == false) goto L15;
        Object r109 = r108.next();
        if (((Number) r109).longValue() <= r105) goto L11;
        boolean r110 = true;
    L12:
        if (r110 == false) goto L7;
        r107.add(r109);
        goto L7
    L11:
        r110 = false;
        goto L12
    L15:
        if (r107.size() >= r100.f121924b) goto L18;
        r101 = true;
    L18:
        return !r101;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        RoomContext r100 = RoomContext.getShared(this.dataCenter);
        if (r100 == null) goto L5;
        r100.getCloseRoomInterceptors().getValue().remove(this.f121814f);
    L5:
        Disposable r101 = this.f121810b;
        if (r101 != null) goto L8;
    L10:
        Disposable r102 = this.f121811c;
        if (r102 != null) goto L13;
    L15:
        vlc.d r103 = this.f121809a;
        if (r103 == null) goto L18;
        r103.removeMessageListener(this);
    L18:
        this.f121813e = false;
        return;
    L13:
        if (r102.isDisposed() == true) goto L15;
        this.f121811c.dispose();
        goto L15
    L8:
        if (r101.isDisposed() == true) goto L10;
        this.f121810b.dispose();
        goto L10
    }

    public static boolean Aq() {
        long r100 = System.currentTimeMillis();
        long r101 = com.bytedance.android.livesdk.sharedpref.b.B1.getValue().longValue();
        Calendar r102 = Calendar.getInstance();
        Calendar r103 = Calendar.getInstance();
        r102.setTime(new Date(r100));
        r103.setTime(new Date(r101));
        if (r102.get(6) == r103.get(6)) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L10;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r105 = com.bytedance.android.livesdk.sharedpref.b.A1;
        r105.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r105, 0);
        return false;
    L10:
        if (com.bytedance.android.livesdk.sharedpref.b.A1.getValue().intValue() >= LiveConfigSettingKeys.UG_COUPON_WINDOW_SHOW_COUNT.getValue().intValue()) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (r102.get(1) != r103.get(1)) goto L7;
        r104 = true;
        goto L8
    }

    public UgCouponWidget(com.bytedance.android.live.room.l r100) {
        this.f121813e = false;
        this.f121814f = new a(this);
        SettingKey<qi1> r101 = LiveConfigSettingKeys.LIVE_UG_COUPON_NEW_DIALOG_CONFIG;
        this.f121816h = new UgCouponNewDialogFrequencyController(r101.getValue().a(), r101.getValue().b());
        this.f121817i = r100;
    }

    public static void Cq(b r100) {
        b.C1771b r101 = r100.retainWindowInfoV2;
        if (r101 != null) goto L5;
        return;
    L5:
        HashMap r102 = new HashMap();
        int r103 = r100.windowStyle;
        if (r103 != 2) goto L9;
        r102.put("popup_type", "only_coupon");
    L11:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_KOL_USER_TAG, r101.kolUserTag);
        u.l().sendLog("tobsdk_livesdk_onefen_buy_popup_show", r102, new Object[]{Room.class, x.class});
        return;
    L9:
        if (r103 != 3) goto L11;
        r102.put("popup_type", "product_coupon");
        goto L11
    }

    public final void Eq(int r100) {
        Disposable r101 = this.f121810b;
        if (r101 != null) goto L5;
    L7:
        RoomContext r102 = RoomContext.getShared(this.dataCenter);
        if (r102 != null) goto L11;
        return;
    L11:
        if (((IUserService) k.f(IUserService.class)).user().isLogin() == true) goto L14;
        ALogger.i("UgCouponWidget", "updateCouponData return, not login");
        return;
    L14:
        SettingKey<List<String>> r103 = LiveConfigSettingKeys.UG_COUPON_ENTRANCE;
        boolean r104 = true;
        if (r103.getValue().isEmpty() == false) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == true) goto L21;
        ALogger.i("UgCouponWidget", "updateCouponData return, illegalEntrance");
        return;
    L21:
        RoomContext r106 = RoomContext.getShared(this.dataCenter);
        boolean r107 = false;
        if (r106 != null) goto L24;
    L26:
        r104 = false;
    L27:
        if (r104 == false) goto L30;
        ALogger.i("UgCouponWidget", "updateCouponData return, is media room");
        return;
    L30:
        RoomContext r108 = RoomContext.getShared(this.dataCenter);
        if (r108 != null) goto L33;
        ALogger.i("UgCouponWidget", "isCommerceRoom() >>> roomContext is null?");
    L40:
        if (r107 == true) goto L44;
        ALogger.i("UgCouponWidget", "can not ShowRemainDialog, commerce is not show windowType=" + r100);
        return;
    L44:
        if (yq(r100) == false) goto L47;
        ALogger.i("UgCouponWidget", "updateCouponData return, frequencyCheck failed windowType=" + r100);
        return;
    L47:
        this.f121810b = ((CommerceCouponApi) com.bytedance.android.live.network.c.b().e(CommerceCouponApi.class)).getUgCouponData(r100, r102.getRoom().getValue().getId(), zq().getEnterMethod(), zq().getEnterFromMerge()).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this), new e(this));
        return;
    L33:
        Room r109 = r108.getRoom().getValue();
        if (r109 != null) goto L36;
        ALogger.i("UgCouponWidget", "isCommerceRoom() >>> room is null?");
        goto L40
    L36:
        IRoomCart r110 = r109.getRoomCart();
        if (r110 != null) goto L39;
        ALogger.i("UgCouponWidget", "isCommerceRoom() >>> roomCart is null?");
        goto L40
    L39:
        r107 = r110.getContainCart();
        goto L40
    L24:
        if (r106.getRoom().getValue().isMediaRoom() == false) goto L26;
    L17:
        r105 = r103.getValue().contains(zq().getEnterFromMerge() + "-" + zq().getEnterMethod());
        goto L18
    L5:
        if (r101.isDisposed() == true) goto L7;
        this.f121810b.dispose();
        goto L7
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f121813e = false;
        RoomContext r101 = RoomContext.getShared(this.dataCenter);
        if (r101 == null) goto L5;
        r101.getCloseRoomInterceptors().getValue().add(0, this.f121814f);
    L5:
        DataCenter r102 = this.dataCenter;
        if (r102 == null) goto L10;
        vlc.d r103 = (vlc.d) r102.get("data_message_manager", null);
        this.f121809a = r103;
        if (r103 == null) goto L10;
        r103.addMessageListener(MessageType.RETAIN_POPUP_WINDOW_MESSAGE.getIntType(), this);
    L10:
        Eq(-1);
        this.f121811c = ((v) ((IUserService) k.f(IUserService.class)).user().m().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) this.context))).subscribe(new c(this));
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof pj) == false) goto L6;
        ALogger.i("UgCouponWidget", "receiveRetainMessage");
        Eq(((pj) r100).windowType);
        return;
    }

    public final boolean yq(int r100) {
        if (r100 == (-1)) goto L15;
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L11;
        if (r100 == 3) goto L11;
        return false;
    L11:
        return Bq();
    L13:
        return Aq();
    L15:
        if (Aq() == true) goto L17;
        return false;
    L17:
        if (Bq() == false) goto L21;
        return true;
    L21:
        return false;
    }

    public static void wq(UgCouponWidget r100, b.c r101, String r102) {
        r100.getClass();
        HashMap r103 = new HashMap();
        r103.put("coupon_id", r101.couponId);
        r103.put("coupon_meta_id", r101.couponMetaId);
        r103.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r102);
        u.l().sendLog("tobsdk_livesdk_unused_coupon_pop_click", r103, new Object[]{Room.class, x.class});
    }

    public static void xq(UgCouponWidget r100, b r101, String r102) {
        r100.getClass();
        b.C1771b r103 = r101.retainWindowInfoV2;
        if (r103 == null) goto L13;
        HashMap r104 = new HashMap();
        int r105 = r101.windowStyle;
        if (r105 != 2) goto L9;
        r104.put("popup_type", "only_coupon");
    L11:
        r104.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r102);
        r104.put(com.bytedance.android.ec.core.event.a.KEY_KOL_USER_TAG, r103.kolUserTag);
        u.l().sendLog("tobsdk_livesdk_onefen_buy_popup_click", r104, new Object[]{Room.class, x.class});
        return;
    L9:
        if (r105 != 3) goto L11;
        r104.put("popup_type", "product_coupon");
        goto L11
    }
}
