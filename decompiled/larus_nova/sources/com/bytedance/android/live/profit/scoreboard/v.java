package com.bytedance.android.live.profit.scoreboard;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.revenue.service.ui.IRevFloatingBannerManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes47.dex */
public final class v implements com.bytedance.android.scope.o, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f88974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yz0.k f88975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f88976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IRevFloatingBannerManager f88977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.broadcast.a f88978e;

    public static final class a implements ScoreboardBannerView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j80.d f88979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f88980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Pair<? extends RegionId, j80.d> f88981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d f88982d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final e<c> f88983e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final l f88984f;

        @Override // com.bytedance.android.live.profit.scoreboard.ScoreboardBannerView.c
        public final void a() {
            this.f88984f.d().a(Boolean.FALSE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.live.profit.scoreboard.ScoreboardBannerView.c
        public final void onDragStart() {
            d r100 = this.f88982d;
            if ((r100 instanceof f) == true) goto L5;
            r100 = null;
        L5:
            f r101 = (f) r100;
            if (r101 == null) goto L8;
            r101.f88991c = j80.b.a(r101.f88993e);
        L8:
            this.f88979a = this.f88982d.getPos();
            Iterator r102 = this.f88983e.f88988a.iterator();
        L10:
            if (r102.hasNext() == false) goto L12;
            c r103 = (c) r102.next();
            o1.b(r103.f88987c, r103.f88985a);
            goto L10
        L12:
            this.f88981c = (Pair) this.f88984f.x().f64752a;
            this.f88984f.d().a(Boolean.TRUE);
        }

        @Override // com.bytedance.android.live.profit.scoreboard.ScoreboardBannerView.c
        public final void b(j80.d r110) {
            Intrinsics.checkNotNullParameter(r110, "offset");
            this.f88979a = j80.c.e(this.f88979a, r110);
            this.f88982d.b(this.f88980b);
            Rect r111 = new Rect(this.f88980b);
            j80.b.d(r111, j80.c.f(this.f88979a));
            Rect r100 = this.f88980b;
            Intrinsics.checkNotNullParameter(r100, "currentRect");
            Intrinsics.checkNotNullParameter(r111, "desiredRect");
            j80.e r101 = j80.c.c(j80.b.b(r111), j80.b.b(r100));
            float r102 = j80.c.d(j80.c.h(r101));
            e<c> r103 = this.f88983e;
            r103.getClass();
            Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
            HashSet r104 = r103.f88988a;
            ArrayList r105 = new ArrayList();
            Iterator r106 = r104.iterator();
        L4:
            if (r106.hasNext() == false) goto L8;
            Object r107 = r106.next();
            if (((e.a) r107).a().contains(r100) == false) goto L4;
            r105.add(r107);
            goto L4
        L8:
            Iterator r108 = r105.iterator();
            float r109 = Float.MIN_VALUE;
            Pair r112 = null;
        L10:
            if (r108.hasNext() == false) goto L17;
            c r113 = (c) r108.next();
            if (r113.f88985a.contains(r111) == true) goto L13;
            Rect r114 = r113.b(r111);
            float r115 = j80.c.g(j80.c.c(j80.b.b(r114), j80.b.b(r100)), r101) / r102;
            if (r115 <= r109) goto L10;
            r112 = TuplesKt.to(r113, r114);
            r109 = r115;
            goto L10
        L13:
            r112 = TuplesKt.to(r113, new Rect(r111));
        L17:
            if (r112 != null) goto L37;
            j80.d r116 = j80.c.h(j80.b.b(r100));
            HashSet r117 = this.f88983e.f88988a;
            ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
            Iterator r119 = r117.iterator();
        L20:
            if (r119.hasNext() == false) goto L22;
            c r120 = (c) r119.next();
            r118.add(TuplesKt.to(r120, r120.b(r100)));
            goto L20
        L22:
            Iterator r121 = r118.iterator();
            if (r121.hasNext() == true) goto L25;
            Object r122 = null;
        L34:
            Pair r123 = (Pair) r122;
            if (r123 == null) goto L37;
            r112 = TuplesKt.to((c) r123.component1(), (Rect) r123.component2());
            goto L37
        L25:
            r122 = r121.next();
            if (r121.hasNext() == false) goto L34;
            float r124 = j80.c.a(r116, j80.c.h(j80.b.b((Rect) ((Pair) r122).component2())));
        L29:
            Object r125 = r121.next();
            float r126 = j80.c.a(r116, j80.c.h(j80.b.b((Rect) ((Pair) r125).component2())));
            if (Float.compare(r124, r126) <= 0) goto L33;
            r122 = r125;
            r124 = r126;
        L33:
            if (r121.hasNext() == true) goto L29;
        L37:
            if (r112 == null) goto L65;
            c r127 = (c) r112.component1();
            Rect r128 = (Rect) r112.component2();
            j80.d r129 = j80.c.h(j80.b.b(r128));
            r127.getClass();
            Intrinsics.checkNotNullParameter(r128, "objectRect");
            float r130 = r127.f88985a.width() - r128.width();
            float r131 = r127.f88985a.height() - r128.height();
            float r132 = 0.0f;
            if (r130 != 0.0f) goto L41;
            float r133 = 0.0f;
        L43:
            if (r131 == 0.0f) goto L46;
            r132 = (r128.top - r127.f88985a.top) / r131;
        L46:
            j80.d r134 = new j80.d(r133, r132);
            this.f88982d.a(r129);
            Pair r135 = TuplesKt.to(r127.f88986b, r134);
            this.f88984f.x().a(r135);
            Pair<? extends RegionId, j80.d> r136 = this.f88981c;
            if (r136 == null) goto L49;
            this.f88984f.j().onNext(TuplesKt.to(r136, r135));
        L49:
            this.f88981c = null;
            return;
        L41:
            r133 = (r128.left - r127.f88985a.left) / r130;
            goto L43
        }

        public a(d r100, e<c> r101, l r102) {
            Intrinsics.checkNotNullParameter(r100, "bannerView");
            Intrinsics.checkNotNullParameter(r101, "regionManager");
            Intrinsics.checkNotNullParameter(r102, "repository");
            this.f88982d = r100;
            this.f88983e = r101;
            this.f88984f = r102;
            this.f88979a = new j80.d(0.0f, 0.0f);
            this.f88980b = new Rect();
        }
    }

    public static final class b {
    }

    public static final class c implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f88985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RegionId f88986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f88987c;

        @Override // com.bytedance.android.live.profit.scoreboard.v.e.a
        public final Rect a() {
            return this.f88985a;
        }

        public final Rect b(Rect r100) {
            Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
            Rect r101 = new Rect(r100);
            Rect r102 = this.f88985a;
            int r103 = Math.max(0, r102.left - r101.left);
            int r104 = Math.min(0, r102.right - r101.right);
            r101.offset(r103 + r104, Math.max(0, r102.top - r101.top) + Math.min(0, r102.bottom - r101.bottom));
            return r101;
        }

        public c(RegionId r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f88986b = r100;
            this.f88987c = r101;
            this.f88985a = new Rect();
        }
    }

    public interface d {
        void a(j80.d r100);

        void b(Rect r100);

        j80.d getPos();
    }

    public static final class e<R extends a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashSet<R> f88988a;

        public interface a {
            Rect a();
        }

        public e() {
            this.f88988a = new LinkedHashSet();
        }
    }

    public static final class f implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f88989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f88990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j80.d f88991c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f88992d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f88993e;

        public static final class a extends ValueAnimator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public j80.d f88994a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final View f88995b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final j80.d f88996c;

            /* JADX INFO: renamed from: com.bytedance.android.live.profit.scoreboard.v$f$a$a, reason: collision with other inner class name */
            public static final class C1365a implements ValueAnimator.AnimatorUpdateListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f88997a;

                public C1365a(a r100) {
                    this.f88997a = r100;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator r100) {
                    Intrinsics.checkNotNullParameter(r100, "it");
                    a r101 = this.f88997a;
                    j80.d r102 = j80.c.b(r101.f88994a, r101.f88996c);
                    a r103 = this.f88997a;
                    View r104 = r103.f88995b;
                    j80.d r105 = r103.f88996c;
                    float r106 = r103.getAnimatedFraction();
                    Intrinsics.checkNotNullParameter(r102, "$this$times");
                    j80.b.e(r104, j80.c.e(r105, new j80.d(r102.a().floatValue() * r106, r102.b().floatValue() * r106)));
                }
            }

            public a(View r100, j80.d r101, long r102) {
                Intrinsics.checkNotNullParameter(r100, "view");
                Intrinsics.checkNotNullParameter(r101, "startPos");
                this.f88995b = r100;
                this.f88996c = r101;
                setFloatValues(new float[]{0.0f, 1.0f});
                setInterpolator(new AccelerateDecelerateInterpolator());
                setDuration(r102);
                addUpdateListener(new C1365a(this));
                this.f88994a = new j80.d(0.0f, 0.0f);
            }
        }

        @Override // com.bytedance.android.live.profit.scoreboard.v.d
        public final j80.d getPos() {
            return this.f88991c;
        }

        public f(ScoreboardBannerView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f88993e = r100;
            this.f88989a = com.bytedance.android.live.revenue.common.i.a(25);
            this.f88990b = 200;
            this.f88991c = j80.b.a(r100);
        }

        @Override // com.bytedance.android.live.profit.scoreboard.v.d
        public final void a(final j80.d r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f88991c = r100;
            float r101 = j80.c.a(j80.b.a(this.f88993e), r100);
            a r102 = this.f88992d;
            if (r102 == null) goto L6;
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            r102.f88994a = r100;
            return;
        L6:
            if (r101 <= this.f88989a) goto L8;
            View r103 = this.f88993e;
            final a r104 = new a(r103, j80.b.a(r103), this.f88990b);
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            r104.f88994a = r100;
            com.bytedance.android.live.revenue.common.e.b(r104, new ScoreboardBannerController$SmoothBannerView$onPosChanged$$inlined$also$lambda$1(r104, this, r100));
            r104.start();
            Unit r105 = Unit.INSTANCE;
            this.f88992d = r104;
            return;
        L8:
            j80.b.e(this.f88993e, r100);
        }

        @Override // com.bytedance.android.live.profit.scoreboard.v.d
        public final void b(Rect r100) {
            Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
            int r101 = MathKt.roundToInt(this.f88991c.a().floatValue());
            int r102 = MathKt.roundToInt(this.f88991c.b().floatValue());
            o1.b(this.f88993e, r100);
            r100.offsetTo(r101, r102);
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CompositeDisposable f88998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f88999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ScoreboardBannerView f89000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d f89001d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f89002e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final e<c> f89003f;

        public g(View r100, ScoreboardBannerView r101, f r102, View r103, e r104) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r101, "bannerView");
            Intrinsics.checkNotNullParameter(r102, "bannerInterface");
            Intrinsics.checkNotNullParameter(r103, "regionA");
            Intrinsics.checkNotNullParameter(r104, "regionManager");
            this.f88999b = r100;
            this.f89000c = r101;
            this.f89001d = r102;
            this.f89002e = r103;
            this.f89003f = r104;
            this.f88998a = new CompositeDisposable();
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.live.profit.scoreboard.i
    public final void c() {
        g r100 = this.f88974a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.f88998a.dispose();
        this.f88977d.H1(r100.f88999b);
        this.f88974a = null;
        this.f88976c.w().a(Boolean.FALSE);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.i
    public final ViewGroup getContainer() {
        g r100 = this.f88974a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f89000c;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.i
    public final void w() {
        g r100 = this.f88974a;
        if (r100 == null) goto L7;
        ScoreboardBannerView r101 = r100.f89000c;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        this.f88976c.w().a(Boolean.TRUE);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.i
    public final boolean x() {
        if (this.f88974a == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.live.profit.scoreboard.i
    public final void y() {
        if (x() == false) goto L5;
        return;
    L5:
        View r100 = LayoutInflater.from(this.f88975b.getContext()).inflate(R.layout.ttlive_scoreboard_drag_layout, null, false);
        View r101 = r100.findViewById(R.id.region_a);
        View r102 = r100.findViewById(R.id.region_b);
        View r103 = r100.findViewById(R.id.entry_anim_placeholder);
        ScoreboardBannerView r104 = (ScoreboardBannerView) r100.findViewById(R.id.banner_view);
        this.f88977d.n0(r100);
        this.f88977d.se(r100, r103, IRevFloatingBannerManager.Element.EntryAnim);
        e r105 = new e();
        c r106 = new c(RegionId.A, r101);
        Intrinsics.checkNotNullParameter(r106, "reg");
        r105.f88988a.add(r106);
        c r107 = new c(RegionId.B, r102);
        Intrinsics.checkNotNullParameter(r107, "reg");
        r105.f88988a.add(r107);
        View r108 = new View(r104.getContext());
        r108.setOnClickListener(new w(this));
        r104.addView(r108, -1, -1);
        g r109 = new g(r100, r104, new f(r104), r101, r105);
        this.f88974a = r109;
        boolean r110 = this.f88975b.isAnchor();
        jy0.b.d("ScoreboardBannerController", "isAnchor = " + r110);
        if (r110 == false) goto L8;
        r109.f89000c.setDragCallback(new a(r109.f89001d, r109.f89003f, this.f88976c));
        RxUtilKt.c(Disposables.fromAction(new z(r109)), r109.f88998a);
        RxUtilKt.c(RxUtilKt.g(r109.f89000c, true).subscribe(new a0(this, r109)), r109.f88998a);
    L9:
        this.f88976c.w().a(Boolean.FALSE);
        RxUtilKt.c(RxUtilKt.g(r104, true).map(new x(r104)).distinctUntilChanged().subscribe(new y(this)), r109.f88998a);
        r109.f89000c.setVisibility(8);
        return;
    L8:
        RxUtilKt.c(RxUtilKt.g(r109.f89000c, true).switchMap(new b0(this)).subscribe(new c0(this, r109)), r109.f88998a);
        goto L9
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        c();
    }

    public v(yz0.k r100, l r101, IRevFloatingBannerManager r102, com.bytedance.android.livesdk.revenue.service.broadcast.a r103) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "repository");
        Intrinsics.checkNotNullParameter(r102, "floatingBannerManager");
        Intrinsics.checkNotNullParameter(r103, "gameService");
        this.f88975b = r100;
        this.f88976c = r101;
        this.f88977d = r102;
        this.f88978e = r103;
    }

    public static final j80.d a(v r100, e r101, ScoreboardBannerView r102, RegionId r103, j80.d r104) {
        r100.getClass();
        Iterator r105 = r101.f88988a.iterator();
    L4:
        if (r105.hasNext() == false) goto L11;
        Object r106 = r105.next();
        if (((c) r106).f88986b != r103) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L4;
    L12:
        c r108 = (c) r106;
        if (r108 == null) goto L22;
        o1.b(r108.f88987c, r108.f88985a);
        Rect r109 = new Rect();
        o1.b(r102, r109);
        Intrinsics.checkNotNullParameter(r109, "objectRect");
        Intrinsics.checkNotNullParameter(r104, ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION);
        r109.offsetTo(MathKt.roundToInt(r108.f88985a.left + ((r108.f88985a.width() - r109.width()) * r104.a().floatValue())), MathKt.roundToInt(r108.f88985a.top + ((r108.f88985a.height() - r109.height()) * r104.b().floatValue())));
        return j80.c.h(j80.b.b(r109));
    L22:
        return j80.b.a(r102);
    L8:
        r107 = false;
        goto L9
    L11:
        r106 = null;
        goto L12
    }
}
