package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.message.model.qk;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdk.vscore_api.paidlive.g;
import com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.AutoFallbackHybridComponentContainer;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/paidlive/ablity/saleticket/PaidLiveTicketSaleCardWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/vscore_impl/paidlive/ablity/saleticket/e$a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vsmain-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidLiveTicketSaleCardWidget extends RoomRecyclableWidget implements e.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f160452g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f160453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f160454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f160455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CompositeDisposable f160456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v61.a f160457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f160458f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidLiveTicketSaleCardWidget f160459a;

        public b(PaidLiveTicketSaleCardWidget r100) {
            this.f160459a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            SubscriberJsEvent r101 = (SubscriberJsEvent) r100;
            ALogger.d(this.f160459a.f160453a, "receive " + r101.getEventName() + " event! start hide card View");
            if ((!Intrinsics.areEqual(r101.getEventName(), "onExplainCardActivityClosed")) == true) goto L7;
            PaidLiveTicketSaleCardWidget.wq(this.f160459a);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_view_paid_live_ticket_card;
    }

    public final void xq() {
        e r100 = this.f160455c;
        v61.a r101 = null;
        if (r100 == null) goto L9;
        View r102 = r100.f160499c;
        if (r102 == null) goto L9;
        ViewPropertyAnimator r103 = r102.animate();
        if (r103 == null) goto L9;
        r103.setListener(null);
        r103.cancel();
    L9:
        e r104 = this.f160455c;
        if (r104 == null) goto L16;
        View r105 = r104.f160499c;
        if (r105 == null) goto L16;
        ViewGroup r106 = this.f160454b;
        if (r106 == null) goto L16;
        r106.removeView(r105);
    L16:
        e r107 = this.f160455c;
        if (r107 == null) goto L23;
        r107.f160500d = null;
        AutoFallbackHybridComponentContainer r108 = r107.f160498b;
        if (r108 == null) goto L23;
        r108.f160034e = null;
        HybridCard r109 = r108.f160032c;
        if (r109 == null) goto L23;
        r109.setOnTouchListener(null);
        r108.removeView(r108.f160032c);
        r108.f160032c.release();
        r108.f160032c = null;
    L23:
        this.f160455c = null;
        if (v71.a.c() == false) goto L32;
        v61.a r110 = this.f160457e;
        if (r110 != null) goto L28;
        return;
    L28:
        if (r110.o() == false) goto L30;
        r101 = r110;
    L30:
        if (r101 == null) goto L37;
        r101.dismiss();
        return;
    L37:
        return;
    L32:
        DataCenter r111 = this.dataCenter;
        if (r111 == null) goto L39;
        r111.put("data_paid_live_ticket_card_show", Boolean.FALSE);
        return;
    }

    public PaidLiveTicketSaleCardWidget() {
        this.f160453a = "PaidLiveTicketSaleCardWidget[" + hashCode() + ']';
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        xq();
        this.f160458f = false;
        CompositeDisposable r100 = this.f160456d;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public static final void wq(PaidLiveTicketSaleCardWidget r110) {
        if (r110.f160458f == false) goto L20;
        g r100 = g.f159443e;
        Map r101 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("visible", "false")});
        Map.Entry r102 = z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r110.dataCenter).D2());
        String r103 = null;
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r104 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r102.getValue();
        if (r104 == null) goto L11;
        PaidSceneViewEntry r105 = r104.k5();
        if (r105 == null) goto L11;
        String r106 = r105.name();
    L12:
        Map.Entry r107 = z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r110.dataCenter).D2());
        if (r107 == null) goto L19;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r108 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r107.getValue();
        if (r108 == null) goto L19;
        PaidSceneEnum r109 = r108.i0();
        if (r109 == null) goto L19;
        r103 = r109.name();
    L19:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r100, "paidlive_ticket_explain_card_show_status", r101, null, r106, r103, 4, null);
    L11:
        r106 = null;
    L20:
        e r111 = r110.f160455c;
        if (r111 == null) goto L25;
        View r112 = r111.f160499c;
        if (r112 == null) goto L25;
        r112.animate().alpha(0.0f).setDuration(200).setListener(new com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket.a(r110));
    L25:
        r110.f160458f = false;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket.e.a
    public final void Lj(qk r100) {
        Intrinsics.checkNotNullParameter(r100, "cardInfo");
        RoomContext r101 = getRoomContext();
        Object r102 = null;
        if (r101 == null) goto L7;
        j<ViewModel> r103 = r101.getPaidLiveTicketSaleManager();
        if (r103 == null) goto L7;
        ViewModel r104 = r103.getValue();
    L9:
        if ((r104 instanceof com.bytedance.android.livesdk.vscore_api.paidlive.ability.e) == false) goto L12;
        r102 = r104;
    L12:
        com.bytedance.android.livesdk.vscore_api.paidlive.ability.e r105 = (com.bytedance.android.livesdk.vscore_api.paidlive.ability.e) r102;
        if (r105 == null) goto L16;
        r105.closeTicketCard();
        return;
    L16:
        return;
    L7:
        r104 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket.e.a
    public final void jb(qk r110) {
        Intrinsics.checkNotNullParameter(r110, "cardInfo");
        g r100 = g.f159443e;
        Map.Entry r111 = z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.dataCenter).D2());
        if (r111 == null) goto L9;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r112 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r111.getValue();
        if (r112 == null) goto L9;
        PaidSceneViewEntry r113 = r112.k5();
        if (r113 == null) goto L9;
        String r101 = r113.name();
    L10:
        Map.Entry r114 = z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.dataCenter).D2());
        if (r114 == null) goto L17;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r115 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r114.getValue();
        if (r115 == null) goto L17;
        PaidSceneEnum r116 = r115.i0();
        if (r116 == null) goto L17;
        String r102 = r116.name();
    L18:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r100, "paidlive_ticket_explain_card_click", null, null, r101, r102, 6, null);
        return;
    L17:
        r102 = null;
    L9:
        r101 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f160454b = (ViewGroup) findViewById(R.id.fl_card_container);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        if (v71.a.c() == true) goto L6;
    L19:
        this.f160458f = false;
        this.f160456d = new CompositeDisposable();
        RoomContext r101 = getRoomContext();
        if (r101 == null) goto L24;
        j<ViewModel> r102 = r101.getPaidLiveTicketSaleManager();
        if (r102 == null) goto L24;
        r102.c(new AnonymousClass1(this));
    L24:
        Disposable r103 = ((IBrowserService) k.n(IBrowserService.class)).registerJsEventSubscriber("onExplainCardActivityClosed").observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        if (r103 == null) goto L28;
        RxUtilKt.c(r103, this.f160456d);
        return;
    L28:
        return;
    L6:
        if (v71.a.c() == false) goto L10;
        ViewGroup r104 = this.containerView;
        if (r104 == null) goto L10;
        UtilityKotlinExtentionsKt.t(r104);
    L10:
        IMsgWindowService r105 = (IMsgWindowService) k.f(IMsgWindowService.class);
        if (r105 == null) goto L17;
        u61.a r106 = r105.cardBuilder();
        if (r106 == null) goto L17;
        cm0.a r107 = r106.a(new PaidLiveTicketSaleCardWidget$initTicketSaleCard$1(this));
        if (r107 == null) goto L17;
        dm0.a r108 = r107.b();
    L18:
        this.f160457e = r108;
    L17:
        r108 = null;
        goto L18
    }
}
