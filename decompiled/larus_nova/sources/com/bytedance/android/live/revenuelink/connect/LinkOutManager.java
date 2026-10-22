package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.bridge.d1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.bridge.m0;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class LinkOutManager implements com.bytedance.android.live.revenuelink.multimsg.e, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.revenuelink.multimsg.a f91744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f91745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Disposable> f91746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MultiLinkServerMonitor f91747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConnectDataContext f91748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.connect.j f91749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final yz0.f f91750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.withroom.a f91751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final IRoomBase f91752i;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkOutManager f91753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.b f91754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f91755c;

        public a(LinkOutManager r100, d11.b r101, long r102) {
            this.f91753a = r100;
            this.f91754b = r101;
            this.f91755c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            ExtraResponse r111 = (ExtraResponse) r110;
            if (r111 == null) goto L20;
            com.bytedance.android.livesdk.link.model.f r100 = (com.bytedance.android.livesdk.link.model.f) r111.data;
            if (r100 == null) goto L21;
            com.bytedance.android.live.revenuelink.connect.j r101 = this.f91753a.f91749f;
            if (r101 == null) goto L9;
            r101.e5(this.f91754b, r100, this.f91755c);
        L9:
            MultiLinkServerMonitor r102 = this.f91753a.f91747d;
            int r103 = this.f91754b.f466263a;
            i97.a r104 = i97.a.f488802a;
            long r105 = System.currentTimeMillis() - this.f91755c;
            Intrinsics.checkNotNullParameter(r111, "$this$requestTypeExt");
            int r106 = r111.f83936a;
            int r112 = MultiLinkServerMonitor.f91794e;
            r102.f(r103, "linkmic/apply/", r105, r106, MultiLinkServerMonitor$monitorApiCallSuccess$2.INSTANCE);
            if (r100.getWaitSec() <= 0) goto L12;
            long r107 = r100.getWaitSec() + h11.a.f483518f.a().O1();
        L13:
            com.bytedance.revenue.platform.api.core.rx.l r113 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
            int r114 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
            Scheduler r115 = Schedulers.computation();
            Disposable r116 = Observable.timer(r107 * ((long) 1000), TimeUnit.MILLISECONDS, r115).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new s(this));
            this.f91753a.f91745b.add(r116);
            IBaseUser r108 = this.f91754b.f466270h.getOwnerKt();
            if (r108 == null) goto L16;
            String r109 = iz.a.a(r108);
        L17:
            if (r109 == null) goto L22;
            this.f91753a.f91746c.put(r109, r116);
            return;
        L22:
            return;
        L16:
            r109 = null;
            goto L17
        L12:
            r107 = h11.a.f483518f.a().o2();
            goto L13
        L21:
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkOutManager f91756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.b f91757b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f91758c;

        public b(LinkOutManager r100, d11.b r101, long r102) {
            this.f91756a = r100;
            this.f91757b = r101;
            this.f91758c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            MultiLinkServerMonitor r102 = this.f91756a.f91747d;
            int r103 = this.f91757b.f466263a;
            i97.a r104 = i97.a.f488802a;
            MultiLinkServerMonitor.e(r102, r103, "linkmic/apply/", r101, System.currentTimeMillis() - this.f91758c);
            com.bytedance.android.live.revenuelink.connect.j r105 = this.f91756a.f91749f;
            if (r105 == null) goto L6;
            r105.W4(this.f91757b, r101, this.f91758c);
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkOutManager f91759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.c f91760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f91761c;

        public c(LinkOutManager r100, d11.c r101, long r102) {
            this.f91759a = r100;
            this.f91760b = r101;
            this.f91761c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            Disposable r102 = this.f91759a.f91746c.get(this.f91760b.f466276d);
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            HashMap<String, Disposable> r103 = this.f91759a.f91746c;
            String r104 = this.f91760b.f466276d;
            if (r103 == null) goto L12;
            TypeIntrinsics.asMutableMap(r103).remove(r104);
            MultiLinkServerMonitor r105 = this.f91759a.f91747d;
            int r106 = this.f91760b.f466273a;
            i97.a r107 = i97.a.f488802a;
            long r108 = System.currentTimeMillis() - this.f91761c;
            int r109 = MultiLinkServerMonitor.f91794e;
            r105.g(r106, "linkmic/cancel/", r108, "");
            com.bytedance.android.live.revenuelink.connect.j r110 = this.f91759a.f91749f;
            if (r110 == null) goto L13;
            r110.d5(this.f91760b, this.f91761c);
            return;
        L13:
            return;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkOutManager f91762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.c f91763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f91764c;

        public d(LinkOutManager r100, d11.c r101, long r102) {
            this.f91762a = r100;
            this.f91763b = r101;
            this.f91764c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Disposable r102 = this.f91762a.f91746c.get(this.f91763b.f466276d);
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            HashMap<String, Disposable> r103 = this.f91762a.f91746c;
            String r104 = this.f91763b.f466276d;
            if (r103 == null) goto L12;
            TypeIntrinsics.asMutableMap(r103).remove(r104);
            MultiLinkServerMonitor r105 = this.f91762a.f91747d;
            int r106 = this.f91763b.f466273a;
            i97.a r107 = i97.a.f488802a;
            MultiLinkServerMonitor.e(r105, r106, "linkmic/cancel/", r101, System.currentTimeMillis() - this.f91764c);
            com.bytedance.android.live.revenuelink.connect.j r108 = this.f91762a.f91749f;
            if (r108 == null) goto L13;
            r108.S4(this.f91763b, r101, this.f91764c);
            return;
        L13:
            return;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkOutManager f91765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Disposable f91766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f91767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d11.d f91768d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f91769e;

        public e(LinkOutManager r100, Disposable r101, Function1 r102, d11.d r103, long r104) {
            this.f91765a = r100;
            this.f91766b = r101;
            this.f91767c = r102;
            this.f91768d = r103;
            this.f91769e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            ExtraResponse r111 = (ExtraResponse) r110;
            if (r111 == null) goto L44;
            m0 r100 = (m0) r111.data;
            if (r100 == null) goto L45;
            final v4 r101 = (v4) r100.castTo(v4.class);
            if (r101 != null) goto L9;
            return;
        L9:
            if (this.f91766b.isDisposed() == true) goto L13;
            Function1 r102 = this.f91767c;
            if (r102 == null) goto L13;
            Unit r103 = (Unit) r102.invoke(this.f91768d);
        L13:
            xa1.b r104 = xa1.b.f563035d;
            r104.getClass();
            if (((Boolean) xa1.b.f563034c.getValue(r104, xa1.b.f563032a[1])).booleanValue() == true) goto L16;
        L18:
            com.bytedance.android.live.revenuelink.connect.j r105 = this.f91765a.f91749f;
            if (r105 == null) goto L21;
            r105.a5(this.f91768d, this.f91769e, r101);
        L21:
            final MultiLinkServerMonitor r106 = this.f91765a.f91747d;
            final d11.d r107 = this.f91768d;
            final long r108 = this.f91769e;
            Intrinsics.checkNotNullParameter(r111, "$this$requestTypeExt");
            int r112 = r111.f83936a;
            r106.getClass();
            Intrinsics.checkNotNullParameter(r107, "params");
            Intrinsics.checkNotNullParameter(r101, "result");
            int r113 = MultiLinkServerMonitor.f91794e;
            int r114 = r107.f466281a;
            int r109 = r107.f466289i;
            if (r109 != 1) goto L24;
        L29:
            r114 = 1;
        L30:
            i97.a r115 = i97.a.f488802a;
            int r116 = r114;
            r106.f(r116, "linkmic/invite/", System.currentTimeMillis() - r108, r112, new MultiLinkServerMonitor$monitorInviteSuccess$1(r106, r107, r101, r108));
            Intrinsics.checkNotNull(r101);
            if (r101.getWaitSec() <= 0) goto L33;
            long r117 = r101.getWaitSec() + h11.a.f483518f.a().O1();
        L34:
            com.bytedance.revenue.platform.api.core.rx.l r118 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
            int r119 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
            Scheduler r120 = Schedulers.computation();
            Disposable r121 = Observable.timer(r117 * ((long) 1000), TimeUnit.MILLISECONDS, r120).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new u(this));
            this.f91765a.f91745b.add(r121);
            IRoom r122 = this.f91768d.f466288h;
            if (r122 == null) goto L40;
            IBaseUser r123 = r122.getOwnerKt();
            if (r123 == null) goto L40;
            String r124 = iz.a.a(r123);
            if (r124 == null) goto L40;
        L41:
            if (r124 == null) goto L47;
            this.f91765a.f91746c.put(r124, r121);
            return;
        L47:
            return;
        L40:
            r124 = this.f91768d.f466286f;
            goto L41
        L33:
            r117 = h11.a.f483518f.a().D0();
            goto L34
        L24:
            if (r109 == 2) goto L29;
            if (r109 != 3) goto L30;
            r114 = 7;
            goto L30
        L16:
            if (r101.getInviteeRoom() == null) goto L18;
            d11.d r125 = this.f91768d;
            r125.f466288h = r101.getInviteeRoom();
            goto L18
        L45:
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkOutManager f91770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Disposable f91771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f91772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d11.d f91773d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f91774e;

        public f(LinkOutManager r100, Disposable r101, Function1 r102, d11.d r103, long r104) {
            this.f91770a = r100;
            this.f91771b = r101;
            this.f91772c = r102;
            this.f91773d = r103;
            this.f91774e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if (this.f91771b.isDisposed() == true) goto L7;
            Function1 r102 = this.f91772c;
            if (r102 == null) goto L7;
            Unit r103 = (Unit) r102.invoke(this.f91773d);
        L7:
            MultiLinkServerMonitor r104 = this.f91770a.f91747d;
            int r105 = this.f91773d.f466281a;
            i97.a r106 = i97.a.f488802a;
            MultiLinkServerMonitor.e(r104, r105, "linkmic/invite/", r101, System.currentTimeMillis() - this.f91774e);
            Integer r107 = null;
            if ((r101 instanceof ApiServerException) == true) goto L10;
            Throwable r108 = null;
        L11:
            ApiServerException r109 = (ApiServerException) r108;
            if (r109 == null) goto L14;
            r107 = Integer.valueOf(r109.getErrorCode());
        L14:
            if (r107 != null) goto L17;
        L19:
            com.bytedance.android.live.revenue.common.k.a(com.bytedance.live.kmp.util.c.f255167a.getContext(), r101);
        L20:
            com.bytedance.android.live.revenuelink.connect.j r110 = this.f91770a.f91749f;
            if (r110 == null) goto L24;
            r110.V4(this.f91773d, r101, this.f91774e);
            return;
        L24:
            return;
        L17:
            if (r107.intValue() != 31012) goto L19;
        L10:
            r108 = r101;
            goto L11
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkOutManager f91775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.e f91776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f91777c;

        public g(LinkOutManager r100, d11.e r101, long r102) {
            this.f91775a = r100;
            this.f91776b = r101;
            this.f91777c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            MultiLinkServerMonitor r102 = this.f91775a.f91747d;
            int r103 = this.f91776b.f466307a;
            i97.a r104 = i97.a.f488802a;
            long r105 = System.currentTimeMillis() - this.f91777c;
            Intrinsics.checkNotNullParameter(r101, "$this$requestTypeExt");
            int r106 = r101.f83936a;
            int r107 = MultiLinkServerMonitor.f91794e;
            r102.f(r103, "linkmic/kickout/", r105, r106, MultiLinkServerMonitor$monitorApiCallSuccess$2.INSTANCE);
            com.bytedance.android.live.revenuelink.connect.j r108 = this.f91775a.f91749f;
            if (r108 == null) goto L6;
            r108.Z1(this.f91776b, this.f91777c);
            return;
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkOutManager f91778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.e f91779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f91780c;

        public h(LinkOutManager r100, d11.e r101, long r102) {
            this.f91778a = r100;
            this.f91779b = r101;
            this.f91780c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            MultiLinkServerMonitor r102 = this.f91778a.f91747d;
            int r103 = this.f91779b.f466307a;
            i97.a r104 = i97.a.f488802a;
            MultiLinkServerMonitor.e(r102, r103, "linkmic/kickout/", r101, System.currentTimeMillis() - this.f91780c);
            com.bytedance.android.live.revenuelink.connect.j r105 = this.f91778a.f91749f;
            if (r105 == null) goto L6;
            r105.O1(this.f91779b, r101, this.f91780c);
            return;
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkOutManager f91781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.f f91782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f91783c;

        public i(LinkOutManager r100, d11.f r101, long r102) {
            this.f91781a = r100;
            this.f91782b = r101;
            this.f91783c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            ExtraResponse r111 = (ExtraResponse) r110;
            if (r111 == null) goto L11;
            com.bytedance.android.livesdk.link.model.v r100 = (com.bytedance.android.livesdk.link.model.v) r111.data;
            if (r100 == null) goto L12;
            com.bytedance.android.live.revenuelink.connect.j r101 = this.f91781a.f91749f;
            if (r101 == null) goto L9;
            r101.U4(this.f91782b, r100, this.f91783c);
        L9:
            final MultiLinkServerMonitor r102 = this.f91781a.f91747d;
            final d11.f r103 = this.f91782b;
            final com.bytedance.android.livesdk.link.model.v r104 = (com.bytedance.android.livesdk.link.model.v) r111.data;
            final long r105 = this.f91783c;
            Intrinsics.checkNotNullParameter(r111, "$this$requestTypeExt");
            int r112 = r111.f83936a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "params");
            Intrinsics.checkNotNullParameter(r104, "permitData");
            int r106 = r103.f466314a;
            i97.a r107 = i97.a.f488802a;
            r102.f(r106, "linkmic/permit/", System.currentTimeMillis() - r105, r112, new MultiLinkServerMonitor$monitorPermitSuccess$1(r102, r103, r104, r105));
            return;
        L12:
            return;
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkOutManager f91784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.f f91785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f91786c;

        public j(LinkOutManager r100, d11.f r101, long r102) {
            this.f91784a = r100;
            this.f91785b = r101;
            this.f91786c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            MultiLinkServerMonitor r102 = this.f91784a.f91747d;
            int r103 = this.f91785b.f466314a;
            i97.a r104 = i97.a.f488802a;
            r102.d(r103, "linkmic/permit/", r101, System.currentTimeMillis() - this.f91786c, new LinkOutManager$permit$3$1(this));
            com.bytedance.android.live.revenuelink.connect.j r105 = this.f91784a.f91749f;
            if (r105 == null) goto L6;
            r105.c5(this.f91785b, r101, this.f91786c);
            return;
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkOutManager f91787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.g f91788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f91789c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f91790d;

        public k(LinkOutManager r100, d11.g r101, long r102, boolean r103) {
            this.f91787a = r100;
            this.f91788b = r101;
            this.f91789c = r102;
            this.f91790d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            ExtraResponse r100 = (ExtraResponse) r210;
            if (r100 == null) goto L41;
            d1 r101 = (d1) r100.data;
            if (r101 == null) goto L42;
            q5 r102 = (q5) r101.castTo(q5.class);
            if (r102 == null) goto L43;
            com.bytedance.android.live.revenuelink.connect.j r103 = this.f91787a.f91749f;
            if (r103 == null) goto L11;
            r103.R4(this.f91788b, r102, this.f91789c);
        L11:
            MultiLinkServerMonitor r104 = this.f91787a.f91747d;
            d11.g r110 = this.f91788b;
            Intrinsics.checkNotNullParameter(r100, "$this$requestTypeExt");
            int r105 = r100.f83936a;
            long r111 = this.f91789c;
            boolean r112 = this.f91790d;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r110, "params");
            Intrinsics.checkNotNullParameter(r102, "replyResult");
            com.bytedance.android.live.revenuelink.withroom.a r106 = r104.f91796c;
            int r107 = 1;
            if (r106 == null) goto L18;
            com.bytedance.android.live.revenuelink.f r108 = r106.getRevenueLinkTraceMonitor();
            if (r108 == null) goto L18;
            if (r108.X("linkmic/reply/") != true) goto L18;
            return;
        L18:
            int r109 = MultiLinkServerMonitor.f91794e;
            int r113 = r110.f466321a;
            int r114 = r110.f466322b;
            if (r114 != 1) goto L21;
        L26:
            LiveTracingMonitorKt r115 = LiveTracingMonitorKt.f64913a;
            LiveTracingMonitorKt.EventModule r116 = LiveTracingMonitorKt.a(r107);
            JSONObject r117 = new JSONObject();
            r104.b(r117, r107, r116);
            Iterator<p> r118 = r104.f91795b.iterator();
        L28:
            if (r118.hasNext() == false) goto L30;
            r118.next().d(r110, r102, r111, r117);
            goto L28
        L30:
            int r119 = y50.b.f566204a;
            i97.a r120 = i97.a.f488802a;
            y50.b.a.c(r117, "duration", System.currentTimeMillis() - r111);
            y50.b.a.d(r117, "server_api_name", "linkmic/reply/");
            y50.b.a.b(r117, "reply_type", r110.f466325e);
            y50.b.a.b(r117, "request_type", r105);
            if (r112 == false) goto L33;
            String r121 = "0";
        L34:
            y50.b.a.d(r117, "from_status", r121);
            y50.b.a.b(r117, "to_biz_type", r102.getToBizType());
            HashMap r122 = new HashMap();
            r122.put("server_api_name", "linkmic/reply/");
            r122.put("android_event_key", "linkmic/reply/");
            com.bytedance.android.live.revenuelink.withroom.a r123 = r104.f91796c;
            if (r123 == null) goto L44;
            com.bytedance.android.live.revenuelink.f r124 = r123.getRevenueLinkTraceMonitor();
            if (r124 == null) goto L45;
            r124.Z("ttlive_interact_server_api_call", r116, r122, r117, r110.f466323c);
            return;
        L45:
            return;
        L44:
            return;
        L33:
            r121 = "1";
            goto L34
        L21:
            if (r114 == 2) goto L26;
            if (r114 == 3) goto L25;
            r107 = r113;
            goto L26
        L25:
            r107 = 7;
            goto L26
        L43:
            return;
        L42:
            return;
        }
    }

    public static final class l<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkOutManager f91791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d11.g f91792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f91793c;

        public l(LinkOutManager r100, d11.g r101, long r102) {
            this.f91791a = r100;
            this.f91792b = r101;
            this.f91793c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r111 = (Throwable) r110;
            MultiLinkServerMonitor r100 = this.f91791a.f91747d;
            final d11.g r101 = this.f91792b;
            long r102 = this.f91793c;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "params");
            int r103 = MultiLinkServerMonitor.f91794e;
            int r104 = r101.f466321a;
            int r105 = r101.f466322b;
            if (r105 != 1) goto L5;
        L10:
            r104 = 1;
        L11:
            i97.a r106 = i97.a.f488802a;
            long r107 = System.currentTimeMillis() - r102;
            Function1<JSONObject, Unit> r108 = new MultiLinkServerMonitor$monitorReplyFailed$1(r101);
            r100.d(r104, "linkmic/reply/", r111, r107, r108);
            com.bytedance.android.live.revenuelink.connect.j r109 = this.f91791a.f91749f;
            if (r109 == null) goto L15;
            r109.T4(this.f91792b, r111, this.f91793c);
            return;
        L15:
            return;
        L5:
            if (r105 == 2) goto L10;
            if (r105 != 3) goto L11;
            r104 = 7;
            goto L11
        }
    }

    @Override // com.bytedance.android.live.revenuelink.multimsg.e
    public final void a(yh6.c r100) {
        l(r100, true);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void b(com.bytedance.android.live.revlink.impl.multianchor.utils.t r100) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        MultiLinkServerMonitor r101 = this.f91747d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "filter");
        if (r101.f91795b.contains(r100) == true) goto L6;
        r101.f91795b.add(r100);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void c(i6 r100) {
        Intrinsics.checkNotNullParameter(r100, "linkerMessage");
        l((yh6.c) r100.castTo(i6.class), false);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void i(com.bytedance.android.live.revlink.impl.multianchor.utils.t r100) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        MultiLinkServerMonitor r101 = this.f91747d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "filter");
        if (r101.f91795b.contains(r100) == true) goto L6;
        r101.f91795b.remove(r100);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void j(d11.e r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        i97.a r100 = i97.a.f488802a;
        long r101 = System.currentTimeMillis();
        e11.b r102 = e11.c.a(e11.b.f470687a);
        e11.a r103 = (e11.a) r102;
        Observable<ExtraResponse<Object, Extra>> r104 = r103.i(r110.f466308b, r110.f466309c, r110.f466310d, r110.f466307a, r110.f466311e, r110.f466312f);
        int r105 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Disposable r111 = r104.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r110, r101), new h(this, r110, r101));
        this.f91745b.add(r111);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void d(d11.d r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        f(r100, null, null, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void e(d11.c r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        i97.a r102 = i97.a.f488802a;
        long r103 = System.currentTimeMillis();
        com.bytedance.android.live.revenuelink.connect.j r104 = this.f91749f;
        if (r104 == null) goto L5;
        r104.Y1(r100, r103);
    L5:
        e11.b r105 = e11.c.a(e11.b.f470687a);
        e11.a r106 = (e11.a) r105;
        Observable<ExtraResponse<Object, Extra>> r107 = r106.d(r100.a(), r101);
        int r108 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Disposable r109 = r107.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r100, r103), new d(this, r100, r103));
        this.f91745b.add(r109);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void g(d11.b r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        i97.a r102 = i97.a.f488802a;
        long r103 = System.currentTimeMillis();
        e11.b r104 = e11.c.a(e11.b.f470687a);
        e11.a r105 = (e11.a) r104;
        Observable<ExtraResponse<com.bytedance.android.livesdk.link.model.f, Extra>> r106 = r105.c(r100.a(), r101);
        int r107 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Disposable r108 = r106.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r100, r103), new b(this, r100, r103));
        this.f91745b.add(r108);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void h(d11.g r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        com.bytedance.android.live.revenuelink.connect.j r100 = this.f91749f;
        if (r100 == null) goto L5;
        r100.Z3(r110);
    L5:
        ey.f r101 = this.f91748e.getRealConnectState().getValue();
        if (r101 != null) goto L8;
        boolean r102 = true;
    L9:
        i97.a r103 = i97.a.f488802a;
        long r104 = System.currentTimeMillis();
        e11.b r105 = e11.c.a(e11.b.f470687a);
        e11.a r106 = (e11.a) r105;
        Observable<ExtraResponse<d1, Extra>> r112 = r106.l(r110.a(), r111);
        int r107 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Disposable r113 = r112.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this, r110, r104, r102), new l(this, r110, r104));
        if (r113 == null) goto L13;
        this.f91745b.add(r113);
        return;
    L13:
        return;
    L8:
        r102 = true ^ (r101 instanceof ey.f.C5832f);
        goto L9
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void k(d11.f r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (r100.f466315b != 0) goto L17;
        MultiLinkServerMonitor r102 = this.f91747d;
        int r103 = r100.f466314a;
        LinkOutManager$permit$1 r104 = LinkOutManager$permit$1.INSTANCE;
        r102.getClass();
        Intrinsics.checkNotNullParameter("interact_link_channel_id_error", "event");
        Intrinsics.checkNotNullParameter(r104, "putExtra");
        LiveTracingMonitorKt r105 = LiveTracingMonitorKt.f64913a;
        LiveTracingMonitorKt.EventModule r106 = LiveTracingMonitorKt.a(r103);
        com.bytedance.android.live.revenuelink.withroom.a r107 = r102.f91796c;
        if (r107 == null) goto L11;
        com.bytedance.android.live.revenuelink.f r108 = r107.getRevenueLinkTraceMonitor();
        if (r108 == null) goto L11;
        if (r108.X("interact_link_channel_id_error") != true) goto L11;
        return;
    L11:
        JSONObject r109 = new JSONObject();
        r102.b(r109, r103, r106);
        r104.invoke(r109);
        HashMap r110 = new HashMap();
        r110.put("android_event_key", "interact_link_channel_id_error");
        com.bytedance.android.live.revenuelink.withroom.a r111 = r102.f91796c;
        if (r111 == null) goto L19;
        com.bytedance.android.live.revenuelink.f r112 = r111.getRevenueLinkTraceMonitor();
        if (r112 == null) goto L20;
        com.bytedance.android.live.revenuelink.f.a.a(r112, "ttlive_pk_business_api_call", r106, r110, r109);
        return;
    L20:
        return;
    L19:
        return;
    L17:
        i97.a r113 = i97.a.f488802a;
        long r114 = System.currentTimeMillis();
        e11.b r115 = e11.c.a(e11.b.f470687a);
        e11.a r116 = (e11.a) r115;
        Observable<ExtraResponse<com.bytedance.android.livesdk.link.model.v, Extra>> r117 = r116.j(r100.a(), r101);
        int r118 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Disposable r119 = r117.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this, r100, r114), new j(this, r100, r114));
        this.f91745b.add(r119);
    }

    public final void l(yh6.c r110, boolean r111) {
        ey.f r100 = this.f91748e.getRealConnectState().getValue();
        if (r100 != null) goto L5;
        boolean r112 = true;
    L7:
        if ((r110 instanceof h1) == false) goto L50;
        i6 r101 = (i6) ((vh7.c) r110).castTo(i6.class);
        int r102 = (int) i1.b(r101);
        Intrinsics.checkNotNullParameter(r101, "$this$typeExt");
        int r103 = (int) r101.getType2();
        if (r103 != 3) goto L11;
        com.bytedance.android.live.revenuelink.connect.j r113 = this.f91749f;
        if (r113 == null) goto L47;
        r113.Z4(r101);
    L47:
        if (r111 == false) goto L57;
        MultiLinkServerMonitor r104 = this.f91747d;
        Intrinsics.checkNotNullParameter(r101, "$this$linkerIdExt");
        long r105 = r101.getLinkerId();
        i97.a r114 = i97.a.f488802a;
        MultiLinkServerMonitor.h(r104, r102, r101, r105, r103, System.currentTimeMillis(), r112, 192);
        return;
    L57:
        return;
    L11:
        if (r103 != 4) goto L13;
        com.bytedance.android.live.revenuelink.connect.j r115 = this.f91749f;
        if (r115 == null) goto L42;
        r115.Y4(r101);
    L42:
        if (r111 == false) goto L55;
        MultiLinkServerMonitor r106 = this.f91747d;
        Intrinsics.checkNotNullParameter(r101, "$this$linkerIdExt");
        long r107 = r101.getLinkerId();
        i97.a r116 = i97.a.f488802a;
        MultiLinkServerMonitor.h(r106, r102, r101, r107, r103, System.currentTimeMillis(), r112, 192);
        return;
    L55:
        return;
    L13:
        if (r103 != 5) goto L15;
    L26:
        k6 r117 = r101.getReply();
        if (r117 == null) goto L34;
        String r118 = r117.getToUid();
        if (r118 == null) goto L34;
        Disposable r108 = this.f91746c.get(r118);
        if (r108 == null) goto L33;
        r108.dispose();
    L33:
        Disposable r119 = this.f91746c.remove(r118);
    L34:
        com.bytedance.android.live.revenuelink.connect.j r120 = this.f91749f;
        if (r120 == null) goto L37;
        r120.b5(r101);
    L37:
        if (r111 == false) goto L53;
        MultiLinkServerMonitor r109 = this.f91747d;
        Intrinsics.checkNotNullParameter(r101, "$this$linkerIdExt");
        long r121 = r101.getLinkerId();
        i97.a r122 = i97.a.f488802a;
        MultiLinkServerMonitor.h(r109, r102, r101, r121, r103, System.currentTimeMillis(), r112, 192);
        return;
    L53:
        return;
    L15:
        if (r103 == 8) goto L26;
        if (r103 != 9) goto L19;
    L21:
        com.bytedance.android.live.revenuelink.connect.j r123 = this.f91749f;
        if (r123 == null) goto L24;
        r123.X4(r101);
    L24:
        if (r111 == false) goto L51;
        MultiLinkServerMonitor r124 = this.f91747d;
        Intrinsics.checkNotNullParameter(r101, "$this$linkerIdExt");
        long r125 = r101.getLinkerId();
        i97.a r126 = i97.a.f488802a;
        MultiLinkServerMonitor.h(r124, r102, r101, r125, r103, System.currentTimeMillis(), r112, 192);
        return;
    L51:
        return;
    L19:
        if (r103 == 14) goto L21;
        return;
    L50:
        return;
    L5:
        r112 = true ^ (r100 instanceof ey.f.C5832f);
        goto L7
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final Disposable f(d11.d r110, Function1<? super d11.d, Unit> r111, Function1<? super d11.d, Unit> r112, Map<String, String> r113) {
        Intrinsics.checkNotNullParameter(r110, "params");
        com.bytedance.android.live.revenuelink.connect.j r100 = this.f91749f;
        if (r100 == null) goto L5;
        r100.A3(r110);
    L5:
        i97.a r101 = i97.a.f488802a;
        long r102 = System.currentTimeMillis();
        com.bytedance.android.live.revenuelink.withroom.a r103 = this.f91751h;
        if (r103 == null) goto L10;
        com.bytedance.android.live.revenuelink.connect.g r104 = r103.getAnchorConnectUtils();
        if (r104 == null) goto L10;
        Long r105 = Long.valueOf(r104.getChannelId());
    L11:
        long r106 = r105.longValue();
        int r107 = com.bytedance.revenue.platform.api.core.rx.h.f267513a;
        Disposable r114 = com.bytedance.revenue.platform.api.core.rx.h.a(LinkOutManager$invite$disposable$1.INSTANCE);
        e11.b r108 = e11.c.a(e11.b.f470687a);
        e11.a r109 = (e11.a) r108;
        Observable<ExtraResponse<m0, Extra>> r115 = r109.g(r110.a(r106), r113);
        if (r115 == null) goto L20;
        int r116 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Observable<ExtraResponse<m0, Extra>> r117 = r115.subscribeOn(Schedulers.io());
        if (r117 == null) goto L20;
        Observable<ExtraResponse<m0, Extra>> r118 = r117.observeOn(AndroidSchedulers.mainThread());
        if (r118 == null) goto L20;
        Disposable r119 = r118.subscribe(new e(this, r114, r111, r110, r102), new f(this, r114, r112, r110, r102));
        if (r119 == null) goto L20;
        this.f91745b.add(r119);
    L20:
        return r114;
    L10:
        r105 = null;
        goto L11
    }

    public LinkOutManager(ConnectDataContext r100, ConnectDataContext.e r101, yz0.f r102, com.bytedance.android.live.revenuelink.withroom.a r103, IRoomBase r104) {
        Intrinsics.checkNotNullParameter(r100, "connectDataContext");
        Intrinsics.checkNotNullParameter(r103, "linkStoreService");
        this.f91748e = r100;
        this.f91749f = r101;
        this.f91750g = r102;
        this.f91751h = r103;
        this.f91752i = r104;
        this.f91745b = new CompositeDisposable();
        this.f91746c = new HashMap();
        this.f91747d = new MultiLinkServerMonitor(r103, r104);
    }
}
