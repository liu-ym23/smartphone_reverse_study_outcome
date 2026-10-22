package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.message.model.na;
import com.facebook.keyframes.model.KFAnimation;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class LotteryIMDataSource implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublishSubject<b> f87939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject f87940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublishSubject<f1> f87941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PublishSubject f87942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PublishSubject<e1> f87943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PublishSubject f87944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PublishSubject<h1> f87945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PublishSubject f87946h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BehaviorSubject<y2> f87947i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BehaviorSubject f87948j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<yh6.c, Unit> f87949k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f87950l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.message.g f87951m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final yz0.k f87952n;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LotteryIMDataSource f87953a;

        public a(LotteryIMDataSource r100) {
            this.f87953a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f87953a.f87943e.onComplete();
            this.f87953a.f87941c.onComplete();
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final t f87954a;

            public final int hashCode() {
                t r100 = this.f87954a;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "LotteryCanceled(info=" + this.f87954a + ")";
            }

            @Override // com.bytedance.android.live.profit.lottery.LotteryIMDataSource.b
            public final t a() {
                return this.f87954a;
            }

            public a(t r100) {
                Intrinsics.checkNotNullParameter(r100, "info");
                this.f87954a = r100;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.f87954a, ((a) r100).f87954a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.lottery.LotteryIMDataSource$b$b, reason: collision with other inner class name */
        public static final class C1346b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final t f87955a;

            public final int hashCode() {
                t r100 = this.f87955a;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "LotteryFinished(info=" + this.f87955a + ")";
            }

            @Override // com.bytedance.android.live.profit.lottery.LotteryIMDataSource.b
            public final t a() {
                return this.f87955a;
            }

            public C1346b(t r100) {
                Intrinsics.checkNotNullParameter(r100, "info");
                this.f87955a = r100;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C1346b) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.f87955a, ((C1346b) r100).f87955a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final t f87956a;

            public final int hashCode() {
                t r100 = this.f87956a;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "LotteryOngoing(info=" + this.f87956a + ")";
            }

            @Override // com.bytedance.android.live.profit.lottery.LotteryIMDataSource.b
            public final t a() {
                return this.f87956a;
            }

            public c(t r100) {
                Intrinsics.checkNotNullParameter(r100, "info");
                this.f87956a = r100;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof c) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.f87956a, ((c) r100).f87956a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final t f87957a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final i1 f87958b;

            public final int hashCode() {
                t r100 = this.f87957a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                i1 r104 = this.f87958b;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "LotteryRejected(info=" + this.f87957a + ", rejectInfo=" + this.f87958b + ")";
            }

            @Override // com.bytedance.android.live.profit.lottery.LotteryIMDataSource.b
            public final t a() {
                return this.f87957a;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof d) == false) goto L10;
                d r101 = (d) r100;
                if (Intrinsics.areEqual(this.f87957a, r101.f87957a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f87958b, r101.f87958b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public d(t r100, i1 r101) {
                Intrinsics.checkNotNullParameter(r100, "info");
                Intrinsics.checkNotNullParameter(r101, "rejectInfo");
                this.f87957a = r100;
                this.f87958b = r101;
            }
        }

        public b() {
        }

        public abstract t a();
    }

    public final class c implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f87959a;

        public c(Function1 r100) {
            this.f87959a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f87959a.invoke(r100);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f87950l.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f87950l.isDisposed();
    }

    public final void b(na r100, long r101) {
        ALogger.i("HOT_LOTTERY", "time = " + System.currentTimeMillis());
        LinkedHashMap<String, String> r102 = LotteryTraceMonitor.f88034a;
        LotteryTraceMonitor.EventName r103 = LotteryTraceMonitor.EventName.lottery_init_im;
        StringBuilder r104 = new StringBuilder("lotterystatus = ");
        b r105 = null;
        if (r100 == null) goto L5;
        Integer r106 = Integer.valueOf(r100.getLotteryStatus());
    L6:
        r104.append(Integer.valueOf(r106.intValue()));
        r104.append(" starttime = ");
        if (r100 == null) goto L9;
        Long r107 = Long.valueOf(r100.getLotteryStartTime());
    L10:
        r104.append(Long.valueOf(r107.longValue()));
        r104.append(" CurrentTime = ");
        if (r100 == null) goto L13;
        Long r108 = Long.valueOf(r100.getLotteryCurrentTime());
    L14:
        r104.append(Long.valueOf(r108.longValue()));
        r104.append(" drawtime = ");
        if (r100 == null) goto L17;
        Long r109 = Long.valueOf(r100.getLotteryDrawTime());
    L18:
        r104.append(Long.valueOf(r109.longValue()));
        r104.append(" lotteryid = ");
        if (r100 == null) goto L21;
        Long r110 = Long.valueOf(r100.getLotteryId());
    L22:
        r104.append(Long.valueOf(r110.longValue()));
        LotteryTraceMonitor.a(r103, r104.toString());
        int r111 = r100.getLotteryStatus();
        if (r111 != 1) goto L25;
        r105 = new b.c(t0.a(r100, r101, this.f87952n));
    L42:
        if (r105 == null) goto L45;
        this.f87939a.onNext(r105);
        return;
    L45:
        return;
    L25:
        if (r111 != 2) goto L27;
        r105 = new b.C1346b(t0.a(r100, r101, this.f87952n));
        goto L42
    L27:
        if (r111 != 3) goto L29;
        r105 = new b.a(t0.a(r100, r101, this.f87952n));
        goto L42
    L29:
        if (r111 != 5) goto L42;
        t r112 = t0.a(r100, r101, this.f87952n);
        Intrinsics.checkNotNullParameter(r100, "$this$toLotteryRejectInfo");
        String r113 = r100.getLotteryRulePageScheme();
        String r114 = "";
        if (r113 != null) goto L34;
        r113 = "";
    L34:
        String r115 = r100.getLotteryAuditFailureReason();
        if (r115 == null) goto L38;
        r114 = r115;
    L38:
        r105 = new b.d(r112, new i1(r113, r114));
        goto L42
    L21:
        r110 = null;
        goto L22
    L17:
        r109 = null;
        goto L18
    L13:
        r108 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r106 = null;
        goto L6
    }

    public LotteryIMDataSource(yz0.l r100, CompositeDisposable r101, com.bytedance.android.livesdk.revenue.service.message.g r102, yz0.k r103) {
        Intrinsics.checkNotNullParameter(r100, "messageService");
        Intrinsics.checkNotNullParameter(r101, "cd");
        Intrinsics.checkNotNullParameter(r102, "wrdsService");
        Intrinsics.checkNotNullParameter(r103, "roomDataService");
        this.f87950l = r101;
        this.f87951m = r102;
        this.f87952n = r103;
        PublishSubject<b> r104 = PublishSubject.create();
        this.f87939a = r104;
        this.f87940b = r104;
        PublishSubject<f1> r105 = PublishSubject.create();
        this.f87941c = r105;
        this.f87942d = r105;
        PublishSubject<e1> r106 = PublishSubject.create();
        this.f87943e = r106;
        this.f87944f = r106;
        PublishSubject<h1> r107 = PublishSubject.create();
        this.f87945g = r107;
        this.f87946h = r107;
        BehaviorSubject<y2> r108 = BehaviorSubject.create();
        this.f87947i = r108;
        this.f87948j = r108;
        Function1<yh6.c, Unit> r109 = new LotteryIMDataSource$messageListener$1(this);
        this.f87949k = r109;
        r100.h(new o0());
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(yz0.h.a.a(r100, com.bytedance.android.live.revenue.common.message.b.f90905v, false, 6).subscribe(new c(r109)), r101);
        RxUtilKt.c(yz0.h.a.a(r100, com.bytedance.android.live.revenue.common.message.b.f90906w, false, 6).subscribe(new c(r109)), r101);
        RxUtilKt.c(yz0.h.a.a(r100, com.bytedance.android.live.revenue.common.message.b.f90907x, false, 6).subscribe(new c(r109)), r101);
        RxUtilKt.c(yz0.h.a.a(r100, com.bytedance.android.live.revenue.common.message.b.f90908y, false, 6).subscribe(new c(r109)), r101);
        r101.add(Disposables.fromAction(new a(this)));
        com.bytedance.android.live.profit.lottery.model.d r110 = (com.bytedance.android.live.profit.lottery.model.d) r102.ga(LotteryIMDataSource$subscribeTempStatusInfoMessage$roomDataSyncModel$1.INSTANCE);
        com.bytedance.android.livesdk.revenue.message.k.b r111 = r110.f88146d;
        KProperty r112 = com.bytedance.android.live.profit.lottery.model.d.f88145e[0];
        r111.getClass();
        Intrinsics.checkNotNullParameter(r110, "thisRef");
        Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        RxUtilKt.c(r111.a().a().subscribe(new s0(this)), r101);
    }
}
