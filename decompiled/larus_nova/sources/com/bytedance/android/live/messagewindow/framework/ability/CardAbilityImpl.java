package com.bytedance.android.live.messagewindow.framework.ability;

import android.os.Looper;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimState;
import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimType;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;
import com.bytedance.android.live.room.api.messagewindow.monitor.f;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.utils.t0;
import com.bytedance.android.livesdkapi.model.DSConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s71.g;

/* JADX INFO: loaded from: classes46.dex */
public final class CardAbilityImpl implements r61.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f83017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f83018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<t71.a> f83019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t61.a f83020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g<v61.c> f83021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f83022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f83023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PropertyOwner<ICardLifecycle$State> f83024h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Observable<ICardLifecycle$State> f83025i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PublishSubject<p71.a> f83026j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PublishSubject f83027k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PublishSubject<CardAnimState> f83028l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PublishSubject f83029m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PublishSubject<b71.a> f83030n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PublishSubject f83031o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final i f83032p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final v61.a f83033q;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardAbilityImpl f83034a;

        public a(CardAbilityImpl r100) {
            this.f83034a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            CompositeDisposable r101 = this.f83034a.f83023g;
            r101.add((Disposable) r100);
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardAbilityImpl f83035a;

        public c(CardAbilityImpl r100) {
            this.f83035a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            Disposable r102 = this.f83035a.f83022f;
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            this.f83035a.dismiss();
        }
    }

    static {
    }

    public final y61.b d() {
        IMiddlewareMsgWindowService r100 = (IMiddlewareMsgWindowService) k.f(IMiddlewareMsgWindowService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.middlewareCardCtx(this.f83033q.getDataCenter());
    }

    @Override // c71.b
    public final ICardLifecycle$State m() {
        return this.f83024h.f64752a;
    }

    @Override // r61.b
    public final void dismiss() {
        y61.b r100 = d();
        if (r100 == null) goto L8;
        e71.a r101 = r100.windowManager();
        if (r101 == null) goto L9;
        r101.dismiss(this.f83033q);
        return;
    L9:
        return;
    }

    public final q71.d<r71.e> e() {
        y61.b r100 = d();
        if (r100 == null) goto L7;
        q71.b r101 = r100.stateDispatcher();
        if (r101 == null) goto L7;
        q71.d<r71.e> r102 = r101.a();
    L9:
        if ((r102 instanceof q71.d) == true) goto L12;
        return null;
    L12:
        return r102;
    L7:
        r102 = null;
        goto L9
    }

    @Override // r61.b
    public final void hide() {
        y61.b r100 = d();
        if (r100 == null) goto L8;
        e71.a r101 = r100.windowManager();
        if (r101 == null) goto L9;
        r101.hide(this.f83033q);
        return;
    L9:
        return;
    }

    @Override // r61.b
    public final boolean o() {
        y61.b r100 = d();
        if (r100 == null) goto L7;
        d71.d<v61.a, d71.b> r101 = r100.recordManager(this.f83033q.getPosition());
        if (r101 == null) goto L7;
        return r101.g(this.f83033q);
    L7:
        return false;
    }

    @Override // r61.b
    public final void show() {
        y61.b r100 = d();
        if (r100 == null) goto L7;
        e71.a r101 = r100.windowManager();
        if (r101 == null) goto L7;
        r101.show(this.f83033q);
        return;
    L7:
        String r102 = v71.a.g(1024);
        IRoomContextService r103 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r103 == null) goto L10;
        o r104 = IRoomContextService.a.a(r103, this.f83018b, 0, 2);
    L11:
        String r105 = v71.a.f(r104, null);
        i r106 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r106 == null) goto L15;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r107 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_msg_card_show_fail");
        JSONObject r108 = new JSONObject();
        r108.put("stackMsg", r102);
        r108.put("container_loadMsg", r105);
        r107.c(new Pair[]{TuplesKt.to("card_id", this.f83033q.f553379j), TuplesKt.to("reason", "CardContextNull"), TuplesKt.to("extra_msg", r108.toString())});
        Unit r109 = Unit.INSTANCE;
        r106.b(r107.a());
    L15:
        p71.a.b r110 = new p71.a.b();
        Intrinsics.checkNotNullParameter("the cardContext is null when invoke card.show()", "<set-?>");
        r110.f527978b = "the cardContext is null when invoke card.show()";
        Unit r111 = Unit.INSTANCE;
        p(r110);
        f r112 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_context_get_null");
        r112.f99012b = 1000;
        r112.b(r102);
        r112.c("container_load_msg", r105);
        i r113 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r113 == null) goto L20;
        r113.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r112));
        return;
    L20:
        return;
    L10:
        r104 = null;
        goto L11
    }

    @Override // r61.b
    public final t61.a b() {
        return this.f83020d;
    }

    @Override // t61.b
    public final Observable<CardAnimState> f() {
        return this.f83029m;
    }

    @Override // r61.b
    public final DataCenter getDataCenter() {
        return this.f83018b;
    }

    @Override // r61.b
    public final o getRoomContext() {
        return this.f83017a;
    }

    @Override // r61.b
    public final g<v61.c> j() {
        return this.f83021e;
    }

    @Override // b71.b
    public final Observable<b71.a> l() {
        return this.f83031o;
    }

    @Override // r61.b
    public final Collection<t71.a> u() {
        return this.f83019c;
    }

    @Override // c71.b
    public final Observable<ICardLifecycle$State> v() {
        return this.f83025i;
    }

    @Override // o71.a
    public final Observable<p71.a> w() {
        return this.f83027k;
    }

    public CardAbilityImpl(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        this.f83033q = r100;
        y61.b r101 = d();
        i r102 = null;
        if (r101 == null) goto L5;
        o r103 = r101.getRoomContext();
    L6:
        this.f83017a = r103;
        y61.b r104 = d();
        if (r104 == null) goto L9;
        DataCenter r105 = r104.getDataCenter();
    L10:
        this.f83018b = r105;
        this.f83019c = new ArrayList();
        this.f83023g = new CompositeDisposable();
        PropertyOwner<ICardLifecycle$State> r106 = new PropertyOwner(ICardLifecycle$State.Initialized, CardAbilityImpl$_cardLifecycle$1.INSTANCE);
        r106.doOnSubscribe(new a(this));
        Unit r107 = Unit.INSTANCE;
        this.f83024h = r106;
        PropertyOwner<ICardLifecycle$State> r108 = r106;
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L13;
        r108 = r106.observeOn(AndroidSchedulers.mainThread());
    L13:
        this.f83025i = r108;
        PublishSubject<p71.a> r109 = PublishSubject.create();
        this.f83026j = r109;
        this.f83027k = r109;
        PublishSubject<CardAnimState> r110 = PublishSubject.create();
        this.f83028l = r110;
        this.f83029m = r110;
        PublishSubject<b71.a> r111 = PublishSubject.create();
        this.f83030n = r111;
        this.f83031o = r111;
        y61.b r112 = d();
        if (r112 == null) goto L16;
        r102 = r112.monitor();
    L16:
        this.f83032p = r102;
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // t61.b
    public final void a(CardAnimType r100) {
        Intrinsics.checkNotNullParameter(r100, "animType");
        CardAnimState r101 = new CardAnimState(CardAnimState.State.START, r100);
        this.f83028l.onNext(r101);
        y61.b r102 = d();
        q71.d r103 = null;
        if (r102 == null) goto L7;
        q71.b r104 = r102.stateDispatcher();
        if (r104 == null) goto L7;
        q71.d r105 = r104.b();
    L9:
        if ((r105 instanceof q71.d) == false) goto L12;
        r103 = r105;
    L12:
        if (r103 == null) goto L15;
        int r106 = r71.a.f536392a;
        r103.b(r71.a.C7443a.a(this.f83033q, r101));
        return;
    L15:
        return;
    L7:
        r105 = null;
        goto L9
    }

    @Override // r61.b
    public final void c(t61.a r100) {
        Intrinsics.checkNotNullParameter(r100, "anim");
        this.f83020d = r100;
    }

    @Override // t61.b
    public final void h(CardAnimType r100) {
        Intrinsics.checkNotNullParameter(r100, "animType");
        CardAnimState r101 = new CardAnimState(CardAnimState.State.END, r100);
        this.f83028l.onNext(r101);
        y61.b r102 = d();
        q71.d r103 = null;
        if (r102 == null) goto L7;
        q71.b r104 = r102.stateDispatcher();
        if (r104 == null) goto L7;
        q71.d r105 = r104.b();
    L9:
        if ((r105 instanceof q71.d) == false) goto L12;
        r103 = r105;
    L12:
        if (r103 == null) goto L15;
        int r106 = r71.a.f536392a;
        r103.b(r71.a.C7443a.a(this.f83033q, r101));
        return;
    L15:
        return;
    L7:
        r105 = null;
        goto L9
    }

    @Override // r61.b
    public final void i(t71.a r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        if (((ArrayList) this.f83019c).contains(r100) == true) goto L6;
        ((ArrayList) this.f83019c).add(r100);
        return;
    }

    @Override // o71.a
    public final /* bridge */ /* synthetic */ void k(Object r100) {
        p((p71.a) r100);
    }

    @Override // c71.b
    public final void n(Object r100) {
        ICardLifecycle$State r101 = (ICardLifecycle$State) r100;
        Intrinsics.checkNotNullParameter(r101, "state");
        switch(com.bytedance.android.live.messagewindow.framework.ability.a.f83055a[r101.ordinal()]) {
            case 2: goto L58;
            case 3: goto L55;
            case 4: goto L52;
            case 5: goto L49;
            case 6: goto L25;
            case 7: goto L5;
            default: goto L64;
        };
    L5:
        b71.a r102 = this.f83033q.f553377h;
        if (r102 == null) goto L19;
        Intrinsics.checkNotNullParameter(r102, "hideReason");
        this.f83030n.onNext(r102);
        y61.b r103 = d();
        q71.d r104 = null;
        if (r103 == null) goto L12;
        q71.b r105 = r103.stateDispatcher();
        if (r105 == null) goto L12;
        q71.d r106 = r105.e();
    L14:
        if ((r106 instanceof q71.d) == false) goto L17;
        r104 = r106;
    L17:
        if (r104 == null) goto L19;
        int r107 = r71.b.f536393a;
        Intrinsics.checkNotNullParameter(this.f83033q, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r102, "hideReason");
        r104.b(new r71.b());
    L12:
        r106 = null;
    L19:
        this.f83033q.f553377h = new b71.a.b();
        f r108 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_ability_lifecycle_hide");
        i r109 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r109 == null) goto L22;
        r109.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r108));
    L22:
        this.f83033q.K();
        q71.d<r71.e> r110 = e();
        if (r110 == null) goto L64;
        int r111 = r71.e.f536397c;
        v61.a r112 = this.f83033q;
        Intrinsics.checkNotNullParameter(r112, BrowserDependency.UrlClickType.CARD);
        r110.b(new r71.e(r112, ICardLifecycle$State.Hidden));
        goto L64
    L25:
        f r113 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_ability_lifecycle_show");
        i r114 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r114 == null) goto L28;
        r114.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r113));
    L28:
        Single.create(new com.bytedance.android.live.messagewindow.framework.ability.b(this)).subscribeOn(Schedulers.io()).subscribe();
        MiddlewareRoomContext r115 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.f83018b, 0, 2);
        boolean r116 = false;
        if (r115 == null) goto L35;
        m<Boolean> r117 = r115.isShowDSGuideAnim();
        if (r117 == null) goto L35;
        Boolean r118 = r117.getValue();
        if (r118 == null) goto L35;
        boolean r119 = r118.booleanValue();
    L36:
        if (r119 == false) goto L45;
        DSConfig r120 = t0.f159163a;
        if (r120 == null) goto L40;
        r116 = r120.getRightCardOPt();
    L40:
        if (r116 == false) goto L45;
        if (r120 == null) goto L43;
        long r121 = r120.getDuration();
    L44:
        Observable.timer(r121 + ((long) 1000), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.messagewindow.framework.ability.c(this));
    L46:
        q71.d<r71.e> r122 = e();
        if (r122 == null) goto L64;
        int r123 = r71.e.f536397c;
        v61.a r124 = this.f83033q;
        Intrinsics.checkNotNullParameter(r124, BrowserDependency.UrlClickType.CARD);
        r122.b(new r71.e(r124, ICardLifecycle$State.Showed));
        goto L64
    L43:
        r121 = 3000;
    L45:
        this.f83033q.L();
    L35:
        r119 = false;
        goto L36
    L49:
        this.f83033q.M();
        q71.d<r71.e> r125 = e();
        if (r125 == null) goto L64;
        int r126 = r71.e.f536397c;
        v61.a r127 = this.f83033q;
        Intrinsics.checkNotNullParameter(r127, BrowserDependency.UrlClickType.CARD);
        r125.b(new r71.e(r127, ICardLifecycle$State.Started));
        goto L64
    L52:
        q71.d<r71.e> r128 = e();
        if (r128 == null) goto L64;
        int r129 = r71.e.f536397c;
        v61.a r130 = this.f83033q;
        Intrinsics.checkNotNullParameter(r130, BrowserDependency.UrlClickType.CARD);
        r128.b(new r71.e(r130, ICardLifecycle$State.Stored));
        goto L64
    L55:
        this.f83033q.I();
        q71.d<r71.e> r131 = e();
        if (r131 == null) goto L64;
        int r132 = r71.e.f536397c;
        v61.a r133 = this.f83033q;
        Intrinsics.checkNotNullParameter(r133, BrowserDependency.UrlClickType.CARD);
        r131.b(new r71.e(r133, ICardLifecycle$State.Created));
        goto L64
    L58:
        q71.d<r71.e> r134 = e();
        if (r134 == null) goto L61;
        int r135 = r71.e.f536397c;
        v61.a r136 = this.f83033q;
        Intrinsics.checkNotNullParameter(r136, BrowserDependency.UrlClickType.CARD);
        r134.b(new r71.e(r136, ICardLifecycle$State.Destroyed));
    L61:
        this.f83033q.J();
        Disposable r137 = this.f83022f;
        if (r137 == null) goto L64;
        r137.dispose();
    L64:
        this.f83024h.a(r101);
    }

    public final void p(p71.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f83026j.onNext(r100);
        y61.b r101 = d();
        q71.d r102 = null;
        if (r101 == null) goto L7;
        q71.b r103 = r101.stateDispatcher();
        if (r103 == null) goto L7;
        q71.d r104 = r103.d();
    L9:
        if ((r104 instanceof q71.d) == false) goto L12;
        r102 = r104;
    L12:
        if (r102 == null) goto L15;
        int r105 = r71.d.f536396a;
        Intrinsics.checkNotNullParameter(this.f83033q, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r100, "failure");
        r102.b(new r71.d());
        return;
    L15:
        return;
    L7:
        r104 = null;
        goto L9
    }

    @Override // r61.a
    public final void s(CardConstraint r100) {
        Intrinsics.checkNotNullParameter(r100, "newConstraint");
        y61.b r101 = d();
        if (r101 == null) goto L8;
        w61.a<v61.a> r102 = r101.windowContainer(this.f83033q.getPosition());
        if (r102 == null) goto L9;
        r102.xl(this.f83033q, r100, CardAbilityImpl$updateConstraint$1.INSTANCE);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // r61.b
    public final void t(g<? extends v61.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "fight");
        this.f83021e = r100;
    }

    @Override // r61.b
    public final Disposable x(long r100) {
        Disposable r101 = this.f83022f;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        Disposable r102 = Observable.timer(r100, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        this.f83022f = r102;
        return r102;
    }

    @Override // r61.a
    public final void g(o r100, DataCenter r101) {
        if (r100 == null) goto L4;
        this.f83017a = r100;
    L4:
        if (r101 == null) goto L7;
        this.f83018b = r101;
        return;
    }
}
