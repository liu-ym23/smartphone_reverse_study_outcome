package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class ScoreboardMatchManager implements com.bytedance.android.scope.o, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f88839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f88840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f88841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PublishSubject<sh6.b<dv0.h>> f88842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PublishSubject f88843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f88844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ScoreboardApiClient f88845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final yz0.k f88846h;

    public static final class a {
    }

    public static final class b implements dv0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f88847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f88848b;

        public final int hashCode() {
            long r100 = this.f88847a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f88848b;
            if (r102 == null) goto L5;
            int r103 = r102.hashCode();
        L7:
            return r101 + r103;
        L5:
            r103 = 0;
            goto L7
        }

        public final String toString() {
            return "MutablePlayer(roomId=" + this.f88847a + ", score=" + this.f88848b + ")";
        }

        @Override // dv0.d
        public final long getRoomId() {
            return this.f88847a;
        }

        @Override // dv0.d
        public final String getScore() {
            return this.f88848b;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f88847a == r101.f88847a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f88848b, r101.f88848b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public b(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_SCORE);
            this.f88847a = r100;
            this.f88848b = r101;
        }
    }

    public final class c implements dv0.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PublishSubject<dv0.h> f88849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f88850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<Long, b> f88851c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f88852d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f88853e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f88854f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f88855g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f88856h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f88857i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f88858j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final long f88859k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f88860l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ ScoreboardMatchManager f88861m;

        @Override // dv0.h
        public final Observable<dv0.h> c() {
            PublishSubject<dv0.h> r100 = this.f88849a;
            Completable r101 = this.f88861m.f88842d.ignoreElements();
            Intrinsics.checkNotNullParameter(r100, "$this$takeUntil");
            Intrinsics.checkNotNullParameter(r101, "completable");
            return r100.takeUntil(r101.toObservable());
        }

        @Override // dv0.h
        public final Collection<dv0.d> getPlayers() {
            return ((LinkedHashMap) this.f88851c).values();
        }

        public final String toString() {
            return "Round(roundId = " + this.f88857i + ", miniAppId = " + this.f88856h + ", roomId = " + this.f88858j + ", startTime = " + this.f88859k + ", isFinished = " + this.f88850b + ')';
        }

        @Override // dv0.h
        public final long a() {
            return this.f88853e;
        }

        @Override // dv0.h
        public final long b() {
            return this.f88855g;
        }

        @Override // dv0.h
        public final long d() {
            return this.f88860l;
        }

        @Override // dv0.h
        public final long getActualFinishTime() {
            return this.f88854f;
        }

        @Override // dv0.h
        public final b getCreator() {
            return this.f88852d;
        }

        @Override // dv0.h
        public final String getMiniAppId() {
            return this.f88856h;
        }

        @Override // dv0.h
        public final long getRoomId() {
            return this.f88858j;
        }

        @Override // dv0.h
        public final long getRoundId() {
            return this.f88857i;
        }

        @Override // dv0.h
        public final long getStartTime() {
            return this.f88859k;
        }

        @Override // dv0.h
        public final boolean isFinished() {
            return this.f88850b;
        }

        public final void e(long r100, long r101) {
            jy0.b.d("ScoreboardMatchManager", "finish round " + this.f88857i + ", resetTimeout = " + r100 + ", actualFinishTime = " + r101);
            this.f88850b = true;
            this.f88855g = r100;
            this.f88854f = r101;
            this.f88849a.onNext(this);
            this.f88849a.onComplete();
        }

        public final void update(List<? extends dv0.d> r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "players");
            Iterator<T> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            dv0.d r103 = (dv0.d) r102.next();
            Map<Long, b> r104 = this.f88851c;
            LinkedHashMap r105 = (LinkedHashMap) r104;
            b r106 = (b) r105.get(Long.valueOf(r103.getRoomId()));
            if (r106 == null) goto L4;
            String r107 = r103.getScore();
            Intrinsics.checkNotNullParameter(r107, "<set-?>");
            r106.f88848b = r107;
            goto L4
        L8:
            this.f88853e = r101;
            com.bytedance.android.live.revenue.common.u0 r108 = com.bytedance.android.live.revenue.common.u0.f90999f;
            long r109 = com.bytedance.android.live.revenue.common.t0.b().f91006a / com.bytedance.android.live.revenue.common.u0.f90995b;
            this.f88849a.onNext(this);
        }

        public c(ScoreboardMatchManager r100, String r110, long r111, long r112, long r113, long r114, long r115, List<? extends dv0.d> r210, long r211) {
            Intrinsics.checkNotNullParameter(r110, "miniAppId");
            Intrinsics.checkNotNullParameter(r210, "players");
            this.f88861m = r100;
            this.f88856h = r110;
            this.f88857i = r111;
            this.f88858j = r112;
            this.f88859k = r113;
            this.f88860l = r115;
            this.f88849a = PublishSubject.create();
            List<? extends dv0.d> r101 = r210;
            LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
            Iterator<T> r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            dv0.d r104 = (dv0.d) r103.next();
            Pair r105 = TuplesKt.to(Long.valueOf(r104.getRoomId()), new b(r104.getRoomId(), r104.getScore()));
            r102.put(r105.getFirst(), r105.getSecond());
            goto L4
        L6:
            this.f88851c = r102;
            Iterator r106 = r102.values().iterator();
        L8:
            if (r106.hasNext() == false) goto L15;
            Object r107 = r106.next();
            if (((b) r107).f88847a != r211) goto L12;
            boolean r108 = true;
        L13:
            if (r108 == false) goto L8;
        L16:
            this.f88852d = (b) r107;
            this.f88853e = r114;
            com.bytedance.android.live.revenue.common.u0 r109 = com.bytedance.android.live.revenue.common.u0.f90999f;
            long r116 = com.bytedance.android.live.revenue.common.t0.b().f91006a / com.bytedance.android.live.revenue.common.u0.f90995b;
            return;
        L12:
            r108 = false;
            goto L13
        L15:
            r107 = null;
            goto L16
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScoreboardMatchManager f88862a;

        public d(ScoreboardMatchManager r100) {
            this.f88862a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ScoreboardMatchManager r101 = this.f88862a;
            ScoreboardMatchManager.f(r101, (dv0.k) r100);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScoreboardMatchManager f88863a;

        public e(ScoreboardMatchManager r100) {
            this.f88863a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            dv0.j r101 = (dv0.j) r100;
            ScoreboardMatchManager r102 = this.f88863a;
            r102.f88840b = true;
            c r103 = r102.f88841c;
            if (r103 != null) goto L5;
            return;
        L5:
            if (r103.f88857i != r101.getRoundId()) goto L9;
            r103.e(r101.getExtra().b(), r101.getExtra().a());
            r102.g(null);
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScoreboardMatchManager f88864a;

        public f(ScoreboardMatchManager r100) {
            this.f88864a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            dv0.l r101 = (dv0.l) r100;
            c r102 = this.f88864a.f88841c;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.f88857i == r101.f470128a) goto L7;
        L9:
            boolean r103 = false;
        L10:
            if (r103 == true) goto L13;
            r102 = null;
        L13:
            if (r102 == null) goto L17;
            r102.update(r101.f470129b, r101.f470130c);
            return;
        L17:
            return;
        L7:
            if (r101.f470130c < r102.f88853e) goto L9;
            r103 = true;
            goto L10
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        RxUtilKt.c(this.f88844f.q().subscribe(new d(this)), this.f88839a);
        RxUtilKt.c(this.f88844f.g().subscribe(new e(this)), this.f88839a);
        RxUtilKt.c(this.f88844f.c().subscribe(new f(this)), this.f88839a);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f88842d.onComplete();
    }

    @Override // com.bytedance.android.live.profit.scoreboard.k
    public final c a() {
        return this.f88841c;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.k
    public final PublishSubject c() {
        return this.f88843e;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.k
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "miniAppId");
        if (this.f88840b == true) goto L6;
        ScoreboardApiClient r101 = this.f88845g;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "miniAppId");
        Maybe r102 = RxUtilKt.i(r101.a().getCounterInfo(r100, r101.f88799b.getRoom().getId(), 0)).filter(r.f88953a).filter(s.f88965a).map(new t(r101, r100));
        Function1<dv0.k, Unit> r103 = new ScoreboardMatchManager$initData$1(this);
        Intrinsics.checkNotNullParameter(r102, "$this$subscribeOnErrorTrace");
        Intrinsics.checkNotNullParameter("ScoreboardMatchManager", "tag");
        Intrinsics.checkNotNullParameter(r103, "onNext");
        RxUtilKt.c(r102.subscribe(new com.bytedance.android.live.core.utils.rxutils.u(r103), new com.bytedance.android.live.core.utils.rxutils.u(RxUtilKt.f("ScoreboardMatchManager"))), this.f88839a);
        return;
    }

    public final void g(c r100) {
        this.f88841c = r100;
        jy0.b.d("ScoreboardMatchManager", "current round is " + r100);
        this.f88842d.onNext(sh6.c.a(r100));
    }

    public static final void f(ScoreboardMatchManager r110, dv0.k r210) {
        r110.f88840b = true;
        c r100 = r110.f88841c;
        if (r100 != null) goto L5;
    L7:
        dv0.e r101 = r210.f470122a;
        r110.g(new c(r110, r101.getMiniAppId(), r101.getRoundId(), r110.f88846h.getRoom().getId(), r210.f470123b, r210.f470124c, r210.f470125d, r210.f470126e, r210.f470127f));
        return;
    L5:
        if (r100.f88850b == true) goto L7;
        jy0.b.d("ScoreboardMatchManager", "finish previous round " + r100);
        r100.e(-1, r210.f470124c);
        r110.g(null);
        goto L7
    }

    public ScoreboardMatchManager(l r100, ScoreboardApiClient r101, yz0.k r102) {
        Intrinsics.checkNotNullParameter(r100, "repository");
        Intrinsics.checkNotNullParameter(r101, "apiClient");
        Intrinsics.checkNotNullParameter(r102, "roomDataService");
        this.f88844f = r100;
        this.f88845g = r101;
        this.f88846h = r102;
        this.f88839a = new CompositeDisposable();
        PublishSubject<sh6.b<dv0.h>> r103 = PublishSubject.create();
        this.f88842d = r103;
        this.f88843e = r103;
    }
}
