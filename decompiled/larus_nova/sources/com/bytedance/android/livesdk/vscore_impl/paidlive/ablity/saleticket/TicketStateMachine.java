package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.message.model.qk;
import com.bytedance.android.livesdk.vscore_api.paidlive.g;
import com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class TicketStateMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<d, a, c> f160462a;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f160463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final qk f160464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.android.livesdk.vscore_api.paidlive.model.a f160465c;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket.TicketStateMachine$a$a, reason: collision with other inner class name */
        public static final class C2453a extends a {
            public C2453a() {
                super("Close", null, null, 6);
            }
        }

        public static final class b extends a {
            public b() {
                super("DisplayTimeOut", null, null, 6);
            }
        }

        public static final class c extends a {
            public c() {
                super("MessageDisable", null, null, 6);
            }
        }

        public static final class d extends a {
            public d(com.bytedance.android.livesdk.vscore_api.paidlive.model.a r100) {
                Intrinsics.checkNotNullParameter(r100, "info");
                super("MessageEnable", null, r100, 2);
            }
        }

        public static final class e extends a {
            public e() {
                super("MessageHide", null, null, 6);
            }
        }

        public static final class f extends a {
            public f(qk r100) {
                Intrinsics.checkNotNullParameter(r100, "message");
                super("MessageShow", r100, null, 4);
            }
        }

        public static final class g extends a {
            public g(com.bytedance.android.livesdk.vscore_api.paidlive.model.a r100) {
                Intrinsics.checkNotNullParameter(r100, "info");
                super("RoomEnable", null, r100, 2);
            }
        }

        public static final class h extends a {
            public h(qk r100) {
                Intrinsics.checkNotNullParameter(r100, "message");
                super("RoomShow", r100, null, 4);
            }
        }

        public static final class i extends a {
            public i() {
                super("ShieldTimeOut", null, null, 6);
            }
        }

        public a(String r100, qk r101, com.bytedance.android.livesdk.vscore_api.paidlive.model.a r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            this.f160463a = r100;
            this.f160464b = r101;
            this.f160465c = r102;
        }
    }

    public interface b {
        void disableTicket();

        void enableTicket(com.bytedance.android.livesdk.vscore_api.paidlive.model.a r100);

        void hideTicketCard();

        void showTicketCard(qk r100);
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f160466a;

        public static final class a extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f160467b = null;

            static {
                f160467b = new a();
            }

            public a() {
                super("DisableTicket");
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final b f160468b = null;

            static {
                f160468b = new b();
            }

            public b() {
                super("EnableTicket");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket.TicketStateMachine$c$c, reason: collision with other inner class name */
        public static final class C2454c extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C2454c f160469b = null;

            static {
                f160469b = new C2454c();
            }

            public C2454c() {
                super("HideTicketCard");
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final d f160470b = null;

            static {
                f160470b = new d();
            }

            public d() {
                super("NoOperation");
            }
        }

        public static final class e extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final e f160471b = null;

            static {
                f160471b = new e();
            }

            public e() {
                super("ShowTicketCard");
            }
        }

        public c(String r100) {
            this.f160466a = r100;
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f160472a;

        public static final class a extends d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f160473b = null;

            static {
                f160473b = new a();
            }

            public a() {
                super("Disable");
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final b f160474b = null;

            static {
                f160474b = new b();
            }

            public b() {
                super("Enable");
            }
        }

        public static final class c extends d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f160475b = null;

            static {
                f160475b = new c();
            }

            public c() {
                super("Show");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket.TicketStateMachine$d$d, reason: collision with other inner class name */
        public static final class C2455d extends d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C2455d f160476b = null;

            static {
                f160476b = new C2455d();
            }

            public C2455d() {
                super("Wait");
            }
        }

        public d(String r100) {
            this.f160472a = r100;
        }
    }

    public TicketStateMachine(final b r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        StateMachine.a r101 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<d, a, c>, Unit> r102 = new TicketStateMachine$stateMachine$1(r100);
        r101.getClass();
        this.f160462a = StateMachine.a.a(r102);
    }

    public final void a(a r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        int r100 = com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket.b.f160492a;
        Intrinsics.checkNotNullParameter(r110, "event");
        ALogger.i("PaidLiveTicketSaleTracer", "receive event: " + r110.f160463a);
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(g.f159443e, "paidlive_ticket_ticket_sale_state_change", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ticket_sale_state", r110.f160463a)}), null, null, null, 28, null);
        StateMachine<d, a, c> r101 = this.f160462a;
        StateMachine.a r102 = StateMachine.f66079c;
        r101.d(r110, null);
    }
}
