package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.watchcard;

import am2.x;
import android.net.Uri;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.k;
import com.bytedance.android.livesdk.vscore_api.paidlive.l;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.pay.TicketData;
import com.bytedance.android.livesdkapi.depend.model.live.pay.main.IMainPaidLiveData;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import nm1.v;

/* JADX INFO: loaded from: classes11.dex */
public class PaidRoomTempWatchCard implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f160517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f160518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f160519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f160520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f160521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f160522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CompositeDisposable f160523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f160524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a f160525i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.k
    public final void reset() {
        this.f160522f = false;
        CompositeDisposable r100 = this.f160523g;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final pu2.e c() {
        return (pu2.e) com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.b(this.f160525i).w1(pu2.e.class);
    }

    public Map<String, String> d() {
        HashMap r100 = new HashMap();
        o r101 = u.l().c(x.class);
        String r102 = r101.getMap().get("enter_method");
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r100.put("enter_method", r102);
        String r104 = r101.getMap().get("action_type");
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r100.put("action_type", r104);
        String r105 = r101.getMap().get("live_reason");
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        r100.put("live_reason", r105);
        RoomContext.a r106 = RoomContext.Companion;
        RoomContext r107 = RoomContext.a.c(r106, this.f160525i.D().getDataCenter(), 0, 2);
        if (r107 == null) goto L28;
        m<Room> r108 = r107.getRoom();
        if (r108 == null) goto L28;
        Room r109 = r108.getValue();
        if (r109 == null) goto L28;
        r100.put("room_id", String.valueOf(r109.getRoomId()));
        r100.put("anchor_id", r109.getOwnerUserIdString());
        TicketData r110 = r109.getTicketInfo();
        if (r110 == null) goto L23;
        String r111 = r110.getTicketCategoryLogStr();
        if (r111 == null) goto L23;
        r103 = r111;
    L23:
        r100.put("ticket_type", r103);
        PaidLiveData r112 = r109.getPaidLiveData();
        if (r112 == null) goto L26;
        Long r113 = r112.mo8274getMaxViewDuration();
    L27:
        r100.put("try_duration", String.valueOf(r113));
        r100.put(PaidReplayConstants.KEY_FROM_CONTENT_ID, String.valueOf(r109.getRoomId()));
        r100.put("from_author_id", r109.getOwnerUserIdString());
        r100.putAll(g4.g(r109.getRoomId()));
        goto L28
    L26:
        r113 = null;
    L28:
        r100.put(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, "live");
        l r114 = this.f160525i.l().getCurrentState().getValue();
        r114.getClass();
        String r115 = "0";
        if ((r114 instanceof l.f) == true) goto L31;
        Object r116 = "1";
    L32:
        r100.put("is_finished", r116);
        if (s.g().K(this.f160525i.D().getDataCenter()) == null) goto L41;
        VSCameraInfo r117 = s.g().K(this.f160525i.D().getDataCenter());
        if (r117 != null) goto L37;
    L39:
        Object r118 = "0";
    L40:
        r100.put("vs_is_portraid_content", r118);
        goto L41
    L37:
        if (v.a(r117) != 2) goto L39;
        r118 = "1";
    L41:
        RoomContext r119 = RoomContext.a.c(r106, null, 0, 3);
        if (r119 == null) goto L48;
        m<Boolean> r120 = r119.isCleanMode();
        if (r120 == null) goto L48;
        if (r120.getValue().booleanValue() != true) goto L48;
        r115 = "1";
    L48:
        r100.put("if_clear_mode", r115);
        com.bytedance.android.livesdk.vscore_api.paidlive.d r121 = this.f160525i.D().getRoomContext();
        if (r121 == null) goto L59;
        m<Boolean> r122 = r121.getTicketConversionCardNeedAutoOpen();
        if (r122 == null) goto L59;
        if (r122.getValue().booleanValue() != true) goto L59;
        r100.put("auto_open_panel", "1");
        com.bytedance.android.livesdk.vscore_api.paidlive.d r123 = this.f160525i.D().getRoomContext();
        if (r123 == null) goto L59;
        m<Boolean> r124 = r123.getTicketConversionCardNeedAutoOpen();
        if (r124 == null) goto L59;
        r124.setValue(Boolean.FALSE);
    L59:
        r100.put("is_other_channel", g4.b());
        s.g().x(this.f160525i.D().getDataCenter(), r100);
        r100.putAll(this.f160525i.l().getCommonExtraMap());
        r100.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, "paidlive_live_tryend_card");
        r100.put("enable_opt_live_bill_fmp", String.valueOf(((oq1.a) this.f160524h.getValue()).a()));
        return r100;
    L31:
        r116 = "0";
        goto L32
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        f("onStart: " + a());
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        Disposable r100 = this.f160517a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f160517a = null;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.k
    public final String x3() {
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(com.bytedance.android.livesdk.vscore_api.paidlive.g.f159443e, "paidlive_audience_try_watch_card_show", null, null, this.f160525i.w0().name(), this.f160525i.i0().name(), 6, null);
        boolean r100 = false;
        if (this.f160519c.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        String r102 = this.f160519c;
    L22:
        if (r102 == null) goto L37;
        f("load paid conversion card paidRoomConversionJumpUrl = ".concat(r102));
        Map<String, String> r103 = d();
        Uri r104 = UriProtector.parse(r102);
        String r105 = UriProtector.getQueryParameter(r104, "url");
        if (r105 != null) goto L26;
    L27:
        r100 = true;
    L28:
        if (r100 == false) goto L32;
        String r106 = com.bytedance.android.livesdk.vscore_impl.paidlive.f.a(r102, r103);
        if (r106 == null) goto L36;
        r104 = UriProtector.parse(r106);
    L36:
        return r104.toString();
    L32:
        String r107 = com.bytedance.android.livesdk.vscore_impl.paidlive.f.a(UriProtector.getQueryParameter(r104, "url"), r103);
        if (r107 == null) goto L36;
        r104 = com.bytedance.android.livesdk.vscore_impl.paidlive.f.f(r104, r107);
        goto L36
    L26:
        if (r105.length() != 0) goto L28;
    L37:
        f("paid conversion card url is empty");
        return "";
    L8:
        com.bytedance.android.livesdk.vscore_api.paidlive.d r108 = this.f160525i.D().getRoomContext();
        if (r108 == null) goto L21;
        m<Room> r109 = com.bytedance.android.livesdk.vscore_impl.paidlive.f.b(r108);
        if (r109 == null) goto L21;
        Room r110 = r109.getValue();
        if (r110 == null) goto L21;
        PaidLiveData r111 = r110.getPaidLiveData();
        if (r111 == null) goto L21;
        IMainPaidLiveData r112 = (IMainPaidLiveData) r111.castToOrNull(IMainPaidLiveData.class);
        if (r112 == null) goto L21;
        TicketData r113 = r112.getTicketSession();
        if (r113 == null) goto L21;
        r102 = r113.getPaidConversionJumpUrl();
    L21:
        r102 = null;
        goto L22
    L5:
        r101 = false;
        goto L6
    }

    public String a() {
        return this.f160518b;
    }

    public PaidRoomTempWatchCard(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "attachScene");
        this.f160525i = r100;
        this.f160518b = "PaidRoomTempWatchCard[" + hashCode() + "][" + r100.i0() + "][" + r100.w0() + ']';
        this.f160519c = "";
        this.f160520d = "ticket_grab_done";
        this.f160521e = "ticket_open_panel_portrait";
        this.f160523g = new CompositeDisposable();
        this.f160524h = LazyKt.lazy(PaidRoomTempWatchCard$preloadConfig$2.INSTANCE);
        Disposable r101 = this.f160517a;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        com.bytedance.android.livesdk.vscore_api.paidlive.d r102 = r100.D().getRoomContext();
        if (r102 == null) goto L12;
        m<? extends Boolean> r103 = r102.isPortraitInteraction();
        if (r103 == null) goto L12;
        Observable<? extends Boolean> r104 = r103.a();
        if (r104 == null) goto L12;
        Disposable r105 = r104.subscribe(new e(this));
    L13:
        this.f160517a = r105;
        return;
    L12:
        r105 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.k
    public final void C0(long r100) {
        if (this.f160522f == false) goto L8;
        pu2.e r101 = c();
        if (r101 == null) goto L9;
        r101.ak(this.f160525i.i0(), r100);
        return;
    L9:
        return;
    }

    public final void f(String r100) {
        ALogger.d(a(), " " + r100);
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.k
    public final void jb(boolean r100) {
        if (this.f160525i.l().getTempWatchCardForceVisible().getValue().booleanValue() == true) goto L17;
        if (r100 == false) goto L20;
        Triple<Long, Long, Long> r101 = this.f160525i.l().getPaidTempWatchRemainTime().getValue();
        if (r101 == null) goto L8;
        Long r102 = r101.getThird();
    L9:
        long r103 = r102.longValue();
        l r104 = this.f160525i.l().getCurrentState().getValue();
        r104.getClass();
        if ((r104 instanceof l.f) == true) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == true) goto L20;
        return;
    L12:
        if (r103 <= 2) goto L14;
        r105 = true;
        goto L15
    L8:
        r102 = null;
    L20:
        if (this.f160525i.l().getTempWatchCardForceVisible().getValue().booleanValue() == false) goto L22;
        f("forceVisible true , param visible:" + r100);
        r100 = true;
    L22:
        pu2.e r106 = c();
        if (r106 != null) goto L25;
    L30:
        if (r100 == true) goto L32;
    L47:
        pu2.e r107 = c();
        if (r107 == null) goto L51;
        r107.Fe(this.f160525i.i0(), r100);
        return;
    L51:
        return;
    L32:
        if (this.f160522f == false) goto L37;
        pu2.e r108 = c();
        if (r108 == null) goto L47;
        if (r108.Mp(this.f160525i.i0()) == true) goto L47;
    L37:
        pu2.e r109 = c();
        if (r109 == null) goto L47;
        r109.ba(this.f160525i.i0(), this);
        this.f160523g = new CompositeDisposable();
        com.bytedance.revenue.platform.api.core.rx.f.a(((IBrowserService) jc1.k.n(IBrowserService.class)).registerJsEventSubscriber(this.f160520d).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)), this.f160523g);
        com.bytedance.revenue.platform.api.core.rx.f.a(((IBrowserService) jc1.k.n(IBrowserService.class)).registerJsEventSubscriber(this.f160521e).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this)), this.f160523g);
        Observable<SubscriberJsEvent> r110 = ((IBrowserService) jc1.k.n(IBrowserService.class)).registerJsEventSubscriber("ticket_open_live_bill_panel");
        if (r110 == null) goto L46;
        Observable<SubscriberJsEvent> r111 = r110.observeOn(AndroidSchedulers.mainThread());
        if (r111 == null) goto L46;
        Disposable r112 = r111.subscribe(new d(this));
        if (r112 == null) goto L46;
        com.bytedance.revenue.platform.api.core.rx.f.a(r112, this.f160523g);
    L46:
        this.f160522f = true;
        goto L47
    L25:
        if (r100 != r106.Mp(this.f160525i.i0())) goto L30;
        if (this.f160522f == false) goto L30;
        f("updateCardVisiblity same visiblity:" + r100 + ", skip");
        return;
    L17:
        if (r100 == true) goto L20;
    }
}
