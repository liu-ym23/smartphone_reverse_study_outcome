package com.bytedance.android.live.recharge.exchange.service;

import am2.x;
import android.content.Context;
import android.view.Window;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.RechargeCenter;
import com.bytedance.android.live.recharge.exchange.view.ExchangeConfirmDefaultView;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.android.live.recharge.platform.service.PayService;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements com.bytedance.android.scope.o, com.bytedance.android.live.recharge.platform.service.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f89900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f89901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PayService f89902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f89903d;

    public final class a implements com.bytedance.android.live.recharge.order.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f89904a;

        @Override // com.bytedance.android.live.recharge.order.e
        public final void c(com.bytedance.android.live.recharge.order.f.b r100) {
            Intrinsics.checkNotNullParameter(r100, "order");
        }

        public a(b r100) {
            this.f89904a = r100;
        }

        @Override // com.bytedance.android.live.recharge.order.e
        public final void a(Order r110, com.bytedance.android.live.recharge.order.f.b.a r111) {
            Intrinsics.checkNotNullParameter(r110, "order");
            Intrinsics.checkNotNullParameter(r111, "handle");
            this.f89904a.getClass();
            int r100 = b.d();
            com.bytedance.android.live.recharge.utils.c r101 = (com.bytedance.android.live.recharge.utils.c) com.bytedance.android.live.recharge.utils.j.f90479p.getValue(null, com.bytedance.android.live.recharge.utils.j.f90464a[13]);
            if (r101.getType() == 0) goto L23;
            if (com.bytedance.android.live.incentive.exchange.i.a() == true) goto L23;
            if (r101.getType() != 1) goto L14;
            if (r100 < r110.o().g()) goto L12;
            b(r110, r111, 1);
            return;
        L12:
            b(r110, r111, 0);
            return;
        L14:
            if (r101.getType() == 2) goto L16;
            return;
        L16:
            if (r100 >= r110.o().g()) goto L18;
            b(r110, r111, 0);
            return;
        L18:
            if (r110.o().e() > r101.a()) goto L20;
            d(r110, r111);
            return;
        L20:
            b(r110, r111, 1);
            return;
        L23:
            if (r100 < r110.o().g()) goto L25;
            d(r110, r111);
            return;
        L25:
            b(r110, r111, 0);
        }

        public final void d(Order r100, com.bytedance.android.live.recharge.order.f.b.a r101) {
            com.bytedance.android.live.recharge.deal.f r102 = r100.o();
            int r103 = com.bytedance.android.live.recharge.utils.e.f90456a;
            IExchangeService.ExchangeApiType r104 = com.bytedance.android.live.recharge.utils.e.b(r100.o());
            if (com.bytedance.android.live.incentive.exchange.i.a() == false) goto L5;
            String r105 = "v1";
        L6:
            IExchangeService.b r106 = new IExchangeService.b(r102, r104, r105, false, 14);
            this.f89904a.f89903d.t1(r106, r100.a(), new com.bytedance.android.live.recharge.utils.g(r101));
            return;
        L5:
            r105 = "";
            goto L6
        }

        public final void b(Order r100, com.bytedance.android.live.recharge.order.f.b.a r101, long r102) {
            this.f89904a.getClass();
            int r103 = b.d();
            if (r102 <= 0) goto L5;
            com.bytedance.android.live.recharge.order.j r104 = r100.a().f90118a;
            r104.getClass();
            Intrinsics.checkNotNullParameter("1", "<set-?>");
            r104.f90115f.b(r104, com.bytedance.android.live.recharge.order.j.f90109i[5], "1");
            this.f89904a.f89902c.a(r100.o(), r100.a(), new com.bytedance.android.live.recharge.utils.h(r101), (int) (r100.o().g() - r102));
            return;
        L5:
            this.f89904a.f89902c.a(r100.o(), r100.a(), new com.bytedance.android.live.recharge.utils.h(r101), r103);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.exchange.service.b$b, reason: collision with other inner class name */
    public static final class C1378b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f89905a = 0;

        static {
        }
    }

    public final class c implements com.bytedance.android.live.recharge.order.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f89906a;

        @Override // com.bytedance.android.live.recharge.order.e
        public final void c(com.bytedance.android.live.recharge.order.f.b r100) {
            Intrinsics.checkNotNullParameter(r100, "order");
        }

        public c(b r100) {
            this.f89906a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.live.recharge.order.e
        public final void a(Order r110, com.bytedance.android.live.recharge.order.f.b.a r111) {
            Intrinsics.checkNotNullParameter(r110, "order");
            Intrinsics.checkNotNullParameter(r111, "handle");
            com.bytedance.tools.kcp.spongepreference.runtime.a r112 = lw0.a.f510984c;
            KProperty<?>[] r100 = lw0.a.f510982a;
            if (((Boolean) r112.getValue(null, r100[1])).booleanValue() == false) goto L49;
            int r113 = C1378b.f89905a;
            long r101 = System.currentTimeMillis() / 1000;
            long r102 = ((Number) lw0.a.f510983b.getValue(null, r100[0])).longValue();     // Catch: Throwable -> L7
        L56:
            if ((Math.abs(r102 - r101) / ((long) 86400)) >= 7) goto L15;
            boolean r103 = false;
        L16:
            if (r103 == false) goto L49;
            this.f89906a.getClass();
            if (b.d() <= 0) goto L49;
            yz0.k r104 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
            if (r104 == null) goto L22;
            Context r105 = r104.getContext();
        L24:
            if (r105 == null) goto L48;
            int r106 = C1378b.f89905a;
            lw0.a.f510983b.setValue(null, lw0.a.f510982a[0], Long.valueOf(System.currentTimeMillis() / 1000));
            this.f89906a.getClass();
            int r107 = b.d();
            long r108 = r111.f90098a.f90096f.g();
            if (com.bytedance.android.live.incentive.exchange.i.a() == false) goto L28;
            int r109 = R.string.ttlive_balance_exchange_confirm_currency_equivalent_cash;
        L29:
            String r114 = s1.B(r109);
            if (com.bytedance.android.live.incentive.exchange.i.a() == false) goto L32;
            int r115 = R.string.ttlive_balance_exchange_confirm_title_tax_saving;
        L33:
            long r116 = r107;
            if (r116 < r108) goto L36;
            String r117 = s1.C(R.string.ttlive_balance_exchange_confirm_no_extra_price, new Object[]{r114, com.bytedance.android.live.recharge.utils.q.b(r108), e4.a()});
        L39:
            Ref.BooleanRef r118 = new Ref.BooleanRef();
            r118.element = false;
            c9.b r119 = new c9.b();
            r119.f112681a = r105;
            r119.f112682b = 2;
            r119.f112683c = R.layout.ttlive_dialog_recharge_balance_exchange_confirm;
            r119.f112685e = r105.getText(r115);
            r119.f112686f = r117;
            r119.f112687g = 17;
            r119.f112696p = true;
            r119.f112697q = true;
            d r120 = new d(this, r111, r118);
            r119.f112690j = r119.f112681a.getText(R.string.ttlive_balance_exchange_confirm_unuse);
            r119.f112691k = r120;
            e r121 = new e(this, r111, r118);
            r119.f112692l = r119.f112681a.getText(R.string.ttlive_balance_exchange_confirm_use);
            r119.f112693m = r121;
            c9 r122 = new c9(r119.f112681a, r119);
            ((ExchangeConfirmDefaultView) r122.f112670e.findViewById(R.id.exchange_confirm_default_view)).setMOnSelectClickListner(new com.bytedance.android.live.recharge.exchange.service.c(r118));
            Window r123 = r122.getWindow();
            if (r123 == null) goto L43;
            r123.setWindowAnimations(R.style.ttlive_NoAnimationDialog);
        L43:
            if (DialogLancet.shouldBlockDialogShow(r122) == false) goto L52;
            DialogLancet.handleBlockedDialogShow(r122);
        L47:
            com.bytedance.android.live.recharge.order.k r124 = r111.f90098a.f90097g;
            Map r125 = MapsKt.mapOf(new Pair[]{TuplesKt.to("request_page", r124.f90118a.b()), TuplesKt.to("charge_reason", r124.f90118a.a())});
            HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r126 = com.bytedance.android.live.recharge.utils.f.f90457a;
            com.bytedance.android.live.recharge.utils.f.d("livesdk_balance_deduction_popup_show", r125, new Class[]{IRoom.class, x.class});
            return;
        L52:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L51
        L46:
            DialogLancet.beforeDialogShow(r122);
            r122.show();
            DialogLancet.afterDialogShow(r122);
            goto L47
        L36:
            if (r107 <= 0) goto L38;
            r117 = s1.C(R.string.ttlive_balance_exchange_confirm_extra_price, new Object[]{r114, com.bytedance.android.live.recharge.utils.q.b(r116), com.bytedance.android.live.recharge.utils.q.b(r108 - r116), e4.a()});
            goto L39
        L38:
            r117 = "";
            goto L39
        L32:
            r115 = R.string.ttlive_balance_exchange_confirm_title;
            goto L33
        L28:
            r109 = R.string.ttlive_balance_exchange_confirm_currency_income;
            goto L29
        L48:
            jy0.b.c("CombinedPayProcessor", "Context is not available, processor is skipped", null, 4);
            r111.f();
            return;
        L22:
            r105 = null;
        L15:
            r103 = true;
        L7:
            r102 = 0;
        L49:
            r111.f();
        }

        public static final void b(c r100, com.bytedance.android.live.recharge.order.k r101, boolean r102, boolean r103) {
            r100.getClass();
            Pair[] r104 = new Pair[4];
            r104[0] = TuplesKt.to("request_page", r101.f90118a.b());
            r104[1] = TuplesKt.to("charge_reason", r101.f90118a.a());
            if (r103 == false) goto L5;
            String r105 = "1";
        L6:
            r104[2] = TuplesKt.to("if_deduction_default", r105);
            if (r102 == false) goto L9;
            String r106 = BdpAppEventConstant.YES;
        L10:
            r104[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r106);
            Map r107 = MapsKt.mapOf(r104);
            HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r108 = com.bytedance.android.live.recharge.utils.f.f90457a;
            com.bytedance.android.live.recharge.utils.f.d("livesdk_balance_deduction_popup_click", r107, new Class[]{IRoom.class, x.class});
            return;
        L9:
            r106 = BdpAppEventConstant.NO;
            goto L10
        L5:
            r105 = "0";
            goto L6
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public static int d() {
        ExchangeInfo r100 = RechargeCenter.getInstance().getExchangeInfo();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getExchangeBalance();
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void c(com.bytedance.android.live.recharge.order.f.b r100) {
        Intrinsics.checkNotNullParameter(r100, "order");
        if (r100.f90096f.c().b() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.live.recharge.utils.j.c() == false) goto L8;
        return;
    L8:
        if (r100.f90097g.f90122e == true) goto L10;
        return;
    L10:
        r100.b(this);
    }

    public b(PayService r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, "payService");
        Intrinsics.checkNotNullParameter(r101, "exchangeService");
        this.f89902c = r100;
        this.f89903d = r101;
        this.f89900a = new a(this);
        this.f89901b = new c(this);
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void a(Order r100, com.bytedance.android.live.recharge.order.f.b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "order");
        Intrinsics.checkNotNullParameter(r101, "handle");
        if (r100.a().f90123f == false) goto L5;
        r101.e(this.f89900a);
        return;
    L5:
        r101.e(this.f89901b);
    }
}
