package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.message.model.k7;
import com.larus.nova.R;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class r0 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f88954g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f88955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yz0.k f88956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f88957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.broadcast.a f88958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ScoreboardApiClient f88959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScoreboardEventTracker f88960f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r0 f88961a;

        public b(r0 r100) {
            this.f88961a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            final r0 r101 = this.f88961a;
            Object r102 = sh6.c.b((sh6.b) r100);
            if (r102 == null) goto L13;
            final dv0.f r103 = (dv0.f) r102;
            r101.getClass();
            jy0.b.d("ScoreboardInvitationHandler", "processInvitation invitation = " + r103);
            Single<T> r104 = Single.create(new h1(r101, r103.f470112c, r103.f470113d)).takeUntil(r101.f88957c.k().take(1).ignoreElements()).doOnSuccess(new x0(r101, r103));
            if (r103.f470111b == true) goto L7;
            Single r105 = Single.just(Boolean.TRUE);
        L11:
            RxUtilKt.c(RxUtilKt.q(Single.concat(r104, r105).all(y0.f89012a).doOnError(new z0(r101, r103)).doFinally(new a1(r101, r103)), "ScoreboardInvitationHandler", new ScoreboardInvitationHandler$processInvitation$5(r101, r103)), r101.f88955a);
            return;
        L7:
            jy0.b.d("ScoreboardInvitationHandler", "showAuthDialog roundId = " + r103.getRoundId());
            k7 r106 = r103.getEntranceInfo();
            if (r106 != null) goto L10;
            r105 = Single.error(new IllegalArgumentException("missing entrance info"));
            goto L11
        L10:
            r105 = Single.defer(new g1(r101, r106));
            goto L11
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r0 f88962a;

        public c(r0 r100) {
            this.f88962a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            dv0.b r101 = (dv0.b) r100;
            r0 r102 = this.f88962a;
            String r103 = r101.f470109c;
            r102.getClass();
            if (r103.length() <= 0) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == false) goto L8;
            ToastUtil.b(r103, 0);
        L9:
            this.f88962a.f88960f.i(r101.f470107a, r101.f470108b, ScoreboardEventTracker.ToastContent.InvitationDeclined);
            return;
        L8:
            ToastUtil.a(R.string.ttlive_scoreboard_toast_invitation_declined, 0);
            goto L9
        L5:
            r104 = false;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r0 f88963a;

        public d(r0 r100) {
            this.f88963a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            dv0.j r101 = (dv0.j) r100;
            if (r101.getExtra().c() == false) goto L5;
            return;
        L5:
            if (r101.getExtra().b() != 0) goto L9;
            this.f88963a.getClass();
            ToastUtil.a(R.string.ttlive_scoreboard_toast_round_terminated, 0);
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r0 f88964a;

        public e(r0 r100) {
            this.f88964a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            dv0.n r101 = (dv0.n) r100;
            RxUtilKt.c(r101.f470132b.subscribe(new v0(this, r101), new w0(this)), this.f88964a.f88955a);
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        RxUtilKt.c(this.f88957c.k().subscribe(new b(this)), this.f88955a);
        RxUtilKt.c(this.f88957c.i().subscribe(new c(this)), this.f88955a);
        RxUtilKt.c(this.f88957c.g().subscribe(new d(this)), this.f88955a);
        RxUtilKt.c(this.f88957c.h().subscribe(new e(this)), this.f88955a);
    }

    public static final void a(r0 r100, dv0.f r110, boolean r111) {
        r100.getClass();
        jy0.b.d("ScoreboardInvitationHandler", "respondToInvitation roundId = " + r110.getRoundId() + ", accept = " + r111);
        ScoreboardApiClient r101 = r100.f88959e;
        String r102 = r110.getMiniAppId();
        long r103 = r110.getRoundId();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "miniAppId");
        Completable r104 = r101.a().gameRoundAccept(r102, r101.f88799b.getRoom().getId(), r103, r111).ignoreElement();
        Intrinsics.checkNotNullParameter(r104, "$this$observeOnUi");
        RxUtilKt.c(r104.observeOn(AndroidSchedulers.mainThread()).subscribe(b1.f88870a, c1.f88873a), r100.f88955a);
        if (r111 == false) goto L6;
        r100.f88958d.hidePlugin(true);
        Completable r112 = Completable.create(new s0(r100, r110));
        ScoreboardApiClient r105 = r100.f88959e;
        String r106 = r110.getMiniAppId();
        long r107 = r110.getRoundId();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "miniAppId");
        Completable r113 = r105.a().gameRoundReady(r106, r105.f88799b.getRoom().getId(), r107).ignoreElement();
        Intrinsics.checkNotNullParameter(r113, "$this$observeOnUi");
        RxUtilKt.c(r112.andThen(r113.observeOn(AndroidSchedulers.mainThread())).doOnError(d1.f88876a).subscribe(e1.f88879a, f1.f88882a), r100.f88955a);
        return;
    }

    public r0(yz0.k r100, l r101, com.bytedance.android.livesdk.revenue.service.broadcast.a r102, ScoreboardApiClient r103, ScoreboardEventTracker r104) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "repository");
        Intrinsics.checkNotNullParameter(r102, "gameService");
        Intrinsics.checkNotNullParameter(r103, "apiClient");
        Intrinsics.checkNotNullParameter(r104, "eventTracker");
        this.f88956b = r100;
        this.f88957c = r101;
        this.f88958d = r102;
        this.f88959e = r103;
        this.f88960f = r104;
        this.f88955a = new CompositeDisposable();
    }
}
