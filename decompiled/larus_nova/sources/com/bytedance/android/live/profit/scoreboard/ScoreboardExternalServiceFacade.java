package com.bytedance.android.live.profit.scoreboard;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class ScoreboardExternalServiceFacade implements com.bytedance.android.scope.o, h, j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f88819e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Long, ScoreboardExternalServiceImpl> f88820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject<dv0.h> f88821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublishSubject<dv0.h> f88822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PublishSubject<Pair<Long, j.a>> f88823d;

    public static final class ScoreboardExternalServiceImpl implements com.bytedance.android.scope.o, h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CompositeDisposable f88824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f88825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f88826c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Lazy f88827d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ScoreboardExternalServiceFacade f88828e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final yz0.k f88829f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final k f88830g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final i f88831h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ScoreboardApiClient f88832i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final l f88833j;

        @Override // com.bytedance.android.scope.o
        public final void onStart() {
            long r100 = this.f88829f.getRoom().getId();
            this.f88825b = r100;
            ScoreboardExternalServiceFacade r101 = this.f88828e;
            r101.getClass();
            Intrinsics.checkNotNullParameter(this, "impl");
            jy0.b.d("ScoreboardServiceFacade", "attachImpl " + r100 + ' ' + this);
            r101.f88820a.put(Long.valueOf(r100), this);
            this.f88830g.c().subscribe(new j0(r101));
            ((Observable) this.f88827d.getValue()).subscribe(new k0(r101, r100));
        }

        @Override // com.bytedance.android.scope.o
        public final void onStop() {
            ScoreboardExternalServiceFacade r100 = this.f88828e;
            long r101 = this.f88825b;
            r100.getClass();
            Intrinsics.checkNotNullParameter(this, "impl");
            jy0.b.d("ScoreboardServiceFacade", "detachImpl " + r101 + ' ' + this);
            if (r100.f88820a.get(Long.valueOf(r101)) != this) goto L5;
            r100.f88820a.remove(Long.valueOf(r101));
        L5:
            this.f88824a.dispose();
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final void i(String r100) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            this.f88831h.c();
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final void k2(String r100) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            this.f88831h.w();
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final ViewGroup G5(String r100, Context r101) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (this.f88831h.x() == true) goto L6;
            this.f88831h.y();
        L6:
            return this.f88831h.getContainer();
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final void H5(String r100, long r101, com.bytedance.android.live.broadcastgame.opengame.openapi.s.a r102) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            Intrinsics.checkNotNullParameter(r102, "configListener");
            ScoreboardApiClient r103 = this.f88832i;
            r103.getClass();
            Intrinsics.checkNotNullParameter(r100, "miniAppId");
            RxUtilKt.c(RxUtilKt.i(r103.a().getCounterConfig(r100, r101).map(new p(r103))).subscribe(new f0(this, r102)), this.f88824a);
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final void S3(String r100, long r101, com.bytedance.android.live.broadcastgame.opengame.sonicgame.l r102) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            Intrinsics.checkNotNullParameter(r102, "eventListener");
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final void s1(String r100, String r101, com.bytedance.android.live.broadcastgame.opengame.openapi.r.a r110) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            Intrinsics.checkNotNullParameter(r101, "counterId");
            Intrinsics.checkNotNullParameter(r110, "getCounterInfoListener");
            ScoreboardApiClient r102 = this.f88832i;
            long r103 = CastLongProtector.parseLong(r101);
            r102.getClass();
            Intrinsics.checkNotNullParameter(r100, "miniAppId");
            RxUtilKt.c(RxUtilKt.i(r102.a().getCounterInfo(r100, r102.f88799b.getRoom().getId(), r103).map(q.f88946a)).subscribe(new g0(r110)), this.f88824a);
        }

        public ScoreboardExternalServiceImpl(ScoreboardExternalServiceFacade r100, yz0.k r101, k r102, i r103, ScoreboardApiClient r104, l r105) {
            Intrinsics.checkNotNullParameter(r100, "facade");
            Intrinsics.checkNotNullParameter(r101, "roomDataService");
            Intrinsics.checkNotNullParameter(r102, "matchManager");
            Intrinsics.checkNotNullParameter(r103, "bannerController");
            Intrinsics.checkNotNullParameter(r104, "apiClient");
            Intrinsics.checkNotNullParameter(r105, "repository");
            this.f88828e = r100;
            this.f88829f = r101;
            this.f88830g = r102;
            this.f88831h = r103;
            this.f88832i = r104;
            this.f88833j = r105;
            this.f88824a = new CompositeDisposable();
            this.f88827d = LazyKt.lazy(new ScoreboardExternalServiceFacade$ScoreboardExternalServiceImpl$bannerStateSubject$2(this));
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final void S(String r110, LinkMode r111, int r112, com.bytedance.android.live.profit.scoreboard.c r113, String r114, com.bytedance.android.live.broadcastgame.opengame.openapi.b1.a r210) {
            Intrinsics.checkNotNullParameter(r110, "appId");
            Intrinsics.checkNotNullParameter(r111, "linkMode");
            Intrinsics.checkNotNullParameter(r114, "prevCounterId");
            Intrinsics.checkNotNullParameter(r210, "startScoreCountingListener");
            Long r100 = StringsKt.toLongOrNull(r114);
            if (r100 == null) goto L5;
            long r115 = r100.longValue();
        L7:
            if (e0.f88878a[r111.ordinal()] == 1) goto L9;
            Long r101 = 0L;
        L10:
            if (r101 != null) goto L14;
            r210.onFailed(-1, "no saved otherRoomId");
            return;
        L14:
            if (r101.longValue() == 0) goto L16;
            r101.longValue();
            dv0.n r102 = new dv0.c(r110, r115);
        L17:
            dv0.n r116 = r102;
            this.f88833j.h().onNext(r116);
            ScoreboardApiClient r103 = this.f88832i;
            long r104 = r101.longValue();
            long r105 = r112;
            if (r113 == null) goto L21;
            String r106 = GsonProtectorUtils.toJson(GsonHelper.get(), r113);
            if (r106 == null) goto L21;
        L22:
            String r107 = r106;
            r103.getClass();
            Intrinsics.checkNotNullParameter(r110, "miniAppId");
            Intrinsics.checkNotNullParameter(r107, "counterSettings");
            RxUtilKt.c(RxUtilKt.i(r103.a().gameRoundStart(r110, r103.f88799b.getRoom().getId(), r104, r105, r107, r115).map(u.f88972a)).subscribe(new h0(r116, r210)), this.f88824a);
            return;
        L21:
            r106 = "";
            goto L22
        L16:
            r102 = new dv0.m(r110, r115);
            goto L17
        L9:
            r101 = this.f88826c;
            goto L10
        L5:
            r115 = 0;
            goto L7
        }
    }

    public static final class a {
        public a() {
        }

        public static n b(com.bytedance.android.live.profit.scoreboard.dto.f r110) {
            int r100 = (int) r110.getIndex();
            String r101 = r110.getName();
            String r102 = r110.getDescription();
            List<com.bytedance.android.live.profit.scoreboard.dto.c> r111 = r110.getGiftChoices();
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
            Iterator<T> r112 = r111.iterator();
        L4:
            if (r112.hasNext() == false) goto L7;
            com.bytedance.android.live.profit.scoreboard.dto.c r104 = (com.bytedance.android.live.profit.scoreboard.dto.c) r112.next();
            ScoreboardExternalServiceFacade.f88819e.getClass();
            r103.add(new g((int) r104.getIndex(), r104.getGiftName(), r104.getIcon(), (int) r104.getValue()));
            goto L4
        L7:
            return new n(r100, r101, r102, r103);
        }

        public static final o a(a r110, dv0.h r111) {
            r110.getClass();
            String r100 = String.valueOf(r111.getRoundId());
            Collection<dv0.d> r101 = r111.getPlayers();
            ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
            Iterator<T> r103 = r101.iterator();
            int r104 = 0;
        L4:
            if (r103.hasNext() == false) goto L10;
            Object r105 = r103.next();
            int r106 = r104 + 1;
            if (r104 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            dv0.d r107 = (dv0.d) r105;
            r102.add(new m(r104, String.valueOf(r107.getRoomId()), r107.getScore(), Intrinsics.areEqual(r107, r111.getCreator())));
            r104 = r106;
            goto L4
        L10:
            return new o(r100, r102, r111.a(), r111.d(), r111.getActualFinishTime(), (int) r111.b(), 64);
        }
    }

    public static final class b<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f88837a;

        public b(long r100) {
            this.f88837a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (((Number) r101.getFirst()).longValue() != this.f88837a) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f88838a = null;

        static {
            f88838a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return (j.a) r101.getSecond();
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    static {
        f88819e = new a();
    }

    public final ScoreboardExternalServiceImpl a() {
        return (ScoreboardExternalServiceImpl) CollectionsKt.firstOrNull(this.f88820a.values());
    }

    public ScoreboardExternalServiceFacade() {
        this.f88820a = new HashMap();
        this.f88821b = PublishSubject.create();
        this.f88822c = PublishSubject.create();
        this.f88823d = PublishSubject.create();
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        jy0.b.d("ScoreboardServiceFacade", "destroyCounterWindowView " + r100);
        ScoreboardExternalServiceImpl r101 = a();
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final void k2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        jy0.b.d("ScoreboardServiceFacade", "showCounterWindowView " + r100);
        ScoreboardExternalServiceImpl r101 = a();
        if (r101 == null) goto L6;
        r101.k2(r100);
        return;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.j
    public final Observable<j.a> l5(long r100) {
        Observable r101 = this.f88823d;
        if (r100 == 0) goto L7;
        r101 = r101.filter(new b(r100));
    L7:
        return r101.map(c.f88838a);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final ViewGroup G5(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        jy0.b.d("ScoreboardServiceFacade", "getCounterWindowView " + r100);
        ScoreboardExternalServiceImpl r102 = a();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.G5(r100, r101);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final void H5(String r100, long r101, com.bytedance.android.live.broadcastgame.opengame.openapi.s.a r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r102, "configListener");
        jy0.b.d("ScoreboardServiceFacade", "getConfig " + r100 + ' ' + r101);
        ScoreboardExternalServiceImpl r103 = this.f88820a.get(Long.valueOf(r101));
        if (r103 != null) goto L6;
        r102.onFailed(-1, "impl not attached");
        return;
    L6:
        r103.H5(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final void S3(String r100, long r101, com.bytedance.android.live.broadcastgame.opengame.sonicgame.l r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r102, "eventListener");
        jy0.b.d("ScoreboardServiceFacade", "subscribeScoreCountingEvent " + r100 + ' ' + r101);
        CompositeDisposable r103 = new CompositeDisposable();
        r103.add(Disposables.fromAction(new l0(r100, r101)));
        r102.b(r103);
        RxUtilKt.c(this.f88821b.filter(new m0(r101)).subscribe(new n0(r100, r101, r102)), r103);
        RxUtilKt.c(this.f88822c.filter(new o0(r101)).subscribe(new p0(r100, r101, r102)), r103);
        ScoreboardExternalServiceImpl r104 = this.f88820a.get(Long.valueOf(r101));
        if (r104 == null) goto L8;
        k r105 = r104.f88830g;
        if (r105 == null) goto L9;
        r105.d(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final void s1(String r100, String r101, com.bytedance.android.live.broadcastgame.opengame.openapi.r.a r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "counterId");
        Intrinsics.checkNotNullParameter(r102, "getCounterInfoListener");
        jy0.b.d("ScoreboardServiceFacade", "getCounterRank " + r100 + ' ' + r101);
        ScoreboardExternalServiceImpl r103 = a();
        if (r103 != null) goto L6;
        r102.onFailed(-1, "impl not attached");
        return;
    L6:
        r103.s1(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final void S(String r110, LinkMode r111, int r112, com.bytedance.android.live.profit.scoreboard.c r113, String r114, com.bytedance.android.live.broadcastgame.opengame.openapi.b1.a r115) {
        Intrinsics.checkNotNullParameter(r110, "appId");
        Intrinsics.checkNotNullParameter(r111, "linkMode");
        Intrinsics.checkNotNullParameter(r114, "prevCounterId");
        Intrinsics.checkNotNullParameter(r115, "startScoreCountingListener");
        jy0.b.d("ScoreboardServiceFacade", "startScoreCounting " + r110 + ' ' + r111 + ' ' + r112 + ' ' + r113 + ' ' + r114);
        ScoreboardExternalServiceImpl r100 = a();
        if (r100 != null) goto L6;
        r115.onFailed(-1, "impl not attached");
        return;
    L6:
        r100.S(r110, r111, r112, r113, r114, r115);
    }
}
