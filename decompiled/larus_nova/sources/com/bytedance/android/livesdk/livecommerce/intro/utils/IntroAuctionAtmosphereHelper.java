package com.bytedance.android.livesdk.livecommerce.intro.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.presenter.IntroAuctionAtmosphereState;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.auction.IntroAuctionHotAtmosphereView;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.n;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.p;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class IntroAuctionAtmosphereHelper implements q83.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f148479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f148480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f148481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.intro.model.resp.d f148482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f148483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IntroAuctionAtmosphereState f148484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f148485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f148486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Runnable f148487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f148488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f148489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final IntroAuctionHotAtmosphereView f148490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ECDraweeView f148491m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function1<Boolean, Unit> f148492n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function1<String, Unit> f148493o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/utils/IntroAuctionAtmosphereHelper$CountState;", "", "NOT_START", "IN_PROGRESS", "FINISHED", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CountState extends Enum<CountState> {
        public static final CountState FINISHED = null;
        public static final CountState IN_PROGRESS = null;
        public static final CountState NOT_START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CountState[] f148494a = null;

        static {
            CountState r100 = new CountState("NOT_START", 0);
            NOT_START = r100;
            CountState r101 = new CountState("IN_PROGRESS", 1);
            IN_PROGRESS = r101;
            CountState r102 = new CountState("FINISHED", 2);
            FINISHED = r102;
            f148494a = new CountState[]{r100, r101, r102};
        }

        public static CountState valueOf(String r100) {
            return (CountState) r27.a.a(CountState.class, r100);
        }

        public static CountState[] values() {
            return (CountState[]) f148494a.clone();
        }

        public CountState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntroAuctionAtmosphereHelper f148495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e f148496b;

        public b(IntroAuctionAtmosphereHelper r100, com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r101) {
            this.f148495a = r100;
            this.f148496b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f148495a.e(this.f148496b, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntroAuctionAtmosphereHelper f148497a;

        public c(IntroAuctionAtmosphereHelper r100) {
            this.f148497a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f148497a.f148485g = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntroAuctionAtmosphereHelper f148498a;

        public d(IntroAuctionAtmosphereHelper r100) {
            this.f148498a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (ViewCompat.isAttachedToWindow(this.f148498a.f148490l) == false) goto L6;
            IntroAuctionHotAtmosphereView r101 = this.f148498a.f148490l;
            r101.f148004i = true;
            r101.g(false);
            this.f148498a.f148492n.invoke(Boolean.FALSE);
            return;
        }
    }

    public static final class e implements com.bytedance.android.ec.core.widget.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntroAuctionAtmosphereHelper f148499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e f148500b;

        @Override // com.bytedance.android.ec.core.widget.h
        public final void a(ECHotAtmosphere r100) {
        }

        @Override // com.bytedance.android.ec.core.widget.h
        public final void c(ECHotAtmosphere r100) {
        }

        @Override // com.bytedance.android.ec.core.widget.h
        public final void b() {
            this.f148499a.f148492n.invoke(Boolean.TRUE);
        }

        @Override // com.bytedance.android.ec.core.widget.h
        public final void onAttachedToWindow() {
            if (this.f148499a.f148490l.getTag() != null) goto L6;
            this.f148499a.e(this.f148500b, false);
            return;
        }

        @Override // com.bytedance.android.ec.core.widget.h
        public final void onDetachedFromWindow() {
            this.f148499a.f148490l.setTag(null);
            this.f148499a.f148490l.a();
        }

        public e(IntroAuctionAtmosphereHelper r100, com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r101) {
            this.f148499a = r100;
            this.f148500b = r101;
        }
    }

    static {
    }

    public final void a(com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f148479a = r100.f147893g;
        this.f148480b = r100.f147894h;
        IntroAtmosphere r101 = r100.f147888b;
        n r102 = null;
        if (r101 == null) goto L7;
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.d r103 = r101.b();
        if (r103 == null) goto L7;
        p r104 = r103.b();
    L8:
        IntroAtmosphere r105 = r100.f147888b;
        if (r105 == null) goto L14;
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.d r106 = r105.b();
        if (r106 == null) goto L14;
        r102 = r106.a();
    L14:
        if (r104 != null) goto L28;
        if (r102 == null) goto L28;
        Pair<CountState, Long> r107 = b(r102);
        CountState r108 = r107.component1();
        r107.component2().longValue();
        int r109 = com.bytedance.android.livesdk.livecommerce.intro.utils.a.f148517a[r108.ordinal()];
        if (r109 != 2) goto L19;
        e(r100, false);
        return;
    L19:
        if (r109 != 3) goto L40;
        c(r100, false);
        long r110 = (SystemClock.elapsedRealtime() + ((r102.d() * 1000) - System.currentTimeMillis())) - SystemClock.elapsedRealtime();
        if (r110 <= 0) goto L35;
        b r111 = new b(this, r100);
        Handler r112 = UtilityKotlinExtentionsKt.f153057b;
        r112.postDelayed(r111, r110);
        Unit r113 = Unit.INSTANCE;
        Runnable r114 = this.f148487i;
        if (r114 == null) goto L26;
        r112.removeCallbacks(r114);
    L26:
        this.f148487i = r111;
        return;
    L35:
        return;
    L40:
        return;
    L28:
        if (r104 == null) goto L33;
        String r115 = r104.c();
        Long r116 = Long.valueOf(r104.b());
        int r117 = com.bytedance.android.livesdk.livecommerce.utils.d.f153071a;
        if (com.bytedance.android.livesdk.livecommerce.utils.d.a(this.f148479a, this.f148480b, r115, r116, true) == false) goto L32;
        e(r100, false);
        return;
    L32:
        c(r100, true);
        return;
    L33:
        c(r100, false);
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final Pair<CountState, Long> b(n r110) {
        if (r110 == null) goto L5;
        long r100 = SystemClock.elapsedRealtime();
        long r111 = SystemClock.elapsedRealtime() + ((r110.d() * 1000) - System.currentTimeMillis());
        long r112 = SystemClock.elapsedRealtime() + ((r110.b() * 1000) - System.currentTimeMillis());
        long r101 = Math.round((r112 - r100) / 1000);
        if (r100 >= r111) goto L9;
        Pair<CountState, Long> r102 = new Pair(CountState.NOT_START, 0L);
    L20:
        dm.a.a("IntroAuction").a("getCountState, result = " + r102 + ", currentTime = " + r100 + ", startTime = " + r111 + ", endTime = " + r112 + ", remainSecond = " + r101);
        return r102;
    L9:
        if (r100 < r111) goto L17;
        if (r100 > r112) goto L17;
        if (r101 > 0) goto L15;
        r102 = new Pair(CountState.FINISHED, 0L);
        goto L20
    L15:
        r102 = new Pair(CountState.IN_PROGRESS, Long.valueOf(r101));
    L17:
        if (r100 <= r112) goto L19;
        r102 = new Pair(CountState.FINISHED, 0L);
        goto L20
    L19:
        r102 = new Pair(CountState.NOT_START, 0L);
        goto L20
    L5:
        return new Pair(CountState.NOT_START, 0L);
    }

    @Override // q83.a
    public final boolean onTick(long r110) {
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.d r100 = this.f148482d;
        String r101 = null;
        if (r100 == null) goto L5;
        final n r102 = r100.a();
    L7:
        if (r102 != null) goto L9;
    L59:
        return true;
    L9:
        if ((!this.f148485g) == false) goto L11;
        n r103 = r102;
    L12:
        if (r103 == null) goto L59;
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.d r104 = this.f148482d;
        if (r104 == null) goto L16;
        n r105 = r104.a();
    L17:
        Pair<CountState, Long> r106 = b(r105);
        CountState r107 = r106.component1();
        final long r108 = r106.component2().longValue();
        int r109 = com.bytedance.android.livesdk.livecommerce.intro.utils.a.f148518b[r107.ordinal()];
        boolean r111 = false;
        if (r109 == 1) goto L53;
        if (r109 == 2) goto L53;
        if (r109 != 3) goto L59;
        int r112 = n.f148476a;
        String r113 = String.valueOf(r108);
        Intrinsics.checkNotNullParameter(r102, "$this$convertToHotAtmosphere");
        ECHotAtmosphere r114 = new ECHotAtmosphere();
        ECUrlModel r115 = r102.c();
        if (r115 == null) goto L27;
        String r116 = r115.getFirstUrl();
    L28:
        r114.img = r116;
        r114.type = 100;
        r114.uiType = 5000;
        r114.num = r113;
        r114.bgColor = "#00000000";
        r114.borderColor = "#00000000";
        r114.bgColors = CollectionsKt.listOf(new String[]{"#00000000", "#00000000", "#00000000"});
        r114.borderColors = CollectionsKt.listOf(new String[]{"#00000000", "#00000000", "#00000000"});
        this.f148490l.setVisibility(0);
        this.f148491m.setVisibility(0);
        ECUrlModel r117 = r102.a();
        if (r117 == null) goto L31;
        this.f148491m.setVisibility(0);
        h0.d(this.f148491m, r117, null, null, null, null, null, 120);
        UtilityKotlinExtentionsKt.f(Integer.valueOf(r117.getWidth()), Integer.valueOf(r117.getHeight()), new IntroAuctionAtmosphereHelper$onTick$$inlined$also$lambda$1(r108, this, r102));
    L32:
        r114.auctionType = "count_down";
        IntroAuctionAtmosphereState r118 = this.f148484f;
        if (r118 != null) goto L35;
    L42:
        boolean r119 = true;
    L43:
        this.f148483e = true;
        r114.afterTextIconResId = R.drawable.ec_intro_card_auction_icon_second;
        IntroAuctionHotAtmosphereView r120 = this.f148490l;
        r120.f148004i = true;
        r120.g(false);
        IntroAuctionHotAtmosphereView r121 = this.f148490l;
        IntroAuctionAtmosphereState r122 = this.f148484f;
        if (r122 == null) goto L46;
        r111 = r122.isFold();
    L46:
        r121.i(r114, r119, r111);
        this.f148493o.invoke("count_down");
        IntroAuctionAtmosphereState r123 = this.f148484f;
        if (r123 == null) goto L49;
        r123.setLastInfo(String.valueOf(r108));
    L49:
        IntroAuctionAtmosphereState r124 = this.f148484f;
        if (r124 == null) goto L59;
        r124.setLastType(1);
        goto L59
    L35:
        if (r118.getLastType() != 1) goto L42;
        IntroAuctionAtmosphereState r125 = this.f148484f;
        if (r125 == null) goto L40;
        r101 = r125.getLastInfo();
    L40:
        if (Intrinsics.areEqual(r101, String.valueOf(r108)) == false) goto L42;
        r119 = false;
        goto L43
    L31:
        this.f148491m.setVisibility(8);
        Unit r126 = Unit.INSTANCE;
        goto L32
    L27:
        r116 = null;
    L53:
        if (this.f148483e == false) goto L58;
        this.f148492n.invoke(Boolean.TRUE);
        IntroAuctionAtmosphereState r127 = this.f148484f;
        if (r127 == null) goto L57;
        r127.reset();
    L57:
        this.f148490l.setCallback(null);
        this.f148490l.setTag(null);
        this.f148490l.setVisibility(4);
        this.f148490l.h();
        this.f148491m.setVisibility(4);
    L58:
        this.f148483e = false;
        goto L59
    L16:
        r105 = null;
        goto L17
    L11:
        r103 = null;
        goto L12
    L5:
        r102 = null;
        goto L7
    }

    public final void c(com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (r101 == true) goto L5;
        this.f148482d = null;
    L5:
        this.f148492n.invoke(Boolean.TRUE);
        r100.f147887a.reset();
        this.f148490l.setCallback(null);
        this.f148490l.setTag(null);
        this.f148490l.setVisibility(4);
        this.f148490l.h();
        this.f148491m.setVisibility(4);
    }

    public final void d(p r110, com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r111) {
        String r100 = r110.e();
        if (Intrinsics.areEqual(r100, r111.f147887a.getLastInfo()) == true) goto L5;
    L7:
        boolean r101 = true;
    L9:
        if (Intrinsics.areEqual(this.f148490l.getTag(R.id.ec_list_card_auction_atmosphere_tag), r100) == false) goto L11;
        r101 = false;
    L11:
        if (r101 == false) goto L13;
        r111.f147887a.setFold(false);
    L13:
        int r112 = com.bytedance.android.livesdk.livecommerce.utils.d.f153071a;
        if (com.bytedance.android.livesdk.livecommerce.utils.d.a(this.f148479a, this.f148480b, r110.c(), Long.valueOf(r110.b()), !r101) == true) goto L18;
        if (r101 == false) goto L18;
        c(r111, true);
        return;
    L18:
        this.f148490l.setVisibility(0);
        ECUrlModel r102 = r110.a();
        if (r102 == null) goto L21;
        this.f148491m.setVisibility(0);
        h0.d(this.f148491m, r102, null, null, null, null, null, 120);
        UtilityKotlinExtentionsKt.f(Integer.valueOf(r102.getWidth()), Integer.valueOf(r102.getHeight()), new IntroAuctionAtmosphereHelper$showDigitalAtmosphere$$inlined$also$lambda$1(this));
    L22:
        int r103 = p.f148477a;
        Intrinsics.checkNotNullParameter(r110, "$this$convertToHotAtmosphere");
        ECHotAtmosphere r104 = new ECHotAtmosphere();
        ECUrlModel r113 = r110.d();
        if (r113 == null) goto L25;
        String r114 = r113.getFirstUrl();
    L26:
        r104.img = r114;
        r104.type = 100;
        r104.uiType = 5000;
        r104.num = r110.e();
        r104.bgColor = "#00000000";
        r104.borderColor = "#00000000";
        r104.bgColors = CollectionsKt.listOf(new String[]{"#00000000", "#00000000", "#00000000"});
        r104.borderColors = CollectionsKt.listOf(new String[]{"#00000000", "#00000000", "#00000000"});
        r104.auctionType = ECAuctionAtmosphere.TYPE_DIGITAL;
        this.f148490l.i(r104, r101, r111.f147887a.isFold());
        this.f148493o.invoke(ECAuctionAtmosphere.TYPE_DIGITAL);
        IntroAuctionAtmosphereState r105 = r111.f147887a;
        if (r100 != null) goto L29;
        String r106 = "";
    L30:
        r105.setLastInfo(r106);
        r111.f147887a.setLastType(2);
        IntroAuctionHotAtmosphereView r107 = this.f148490l;
        if (r100 != null) goto L33;
        r100 = "";
    L33:
        r107.setTag(R.id.ec_list_card_auction_atmosphere_tag, r100);
        this.f148483e = false;
        this.f148485g = true;
        c r108 = new c(this);
        Handler r109 = UtilityKotlinExtentionsKt.f153057b;
        r109.postDelayed(r108, 3000);
        Unit r115 = Unit.INSTANCE;
        Runnable r116 = this.f148486h;
        if (r116 == null) goto L36;
        r109.removeCallbacks(r116);
    L36:
        this.f148486h = r108;
        return;
    L29:
        r106 = r100;
        goto L30
    L25:
        r114 = null;
        goto L26
    L21:
        this.f148491m.setVisibility(8);
        Unit r117 = Unit.INSTANCE;
        goto L22
    L5:
        if (2 != r111.f147887a.getLastType()) goto L7;
        r101 = false;
        goto L9
    }

    public final void e(com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r100, boolean r110) {
        IntroAtmosphere r101 = r100.f147888b;
        String r102 = null;
        if (r101 == null) goto L5;
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.d r103 = r101.b();
    L6:
        this.f148482d = r103;
        this.f148484f = r100.f147887a;
        if (r103 == null) goto L9;
        p r104 = r103.b();
    L10:
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.d r105 = this.f148482d;
        if (r105 == null) goto L13;
        n r106 = r105.a();
    L14:
        this.f148485g = false;
        Runnable r107 = this.f148486h;
        if (r107 == null) goto L17;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r107);
    L17:
        this.f148486h = null;
        if (this.f148482d == null) goto L53;
        IntroProduct r108 = r100.f147891e;
        if (r108 == null) goto L22;
        String r109 = r108.i();
    L23:
        Object r111 = this.f148490l.getTag();
        if ((r111 instanceof com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e) == true) goto L26;
        r111 = null;
    L26:
        com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r112 = (com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e) r111;
        if (r112 == null) goto L32;
        IntroProduct r113 = r112.f147891e;
        if (r113 == null) goto L32;
        r102 = r113.i();
    L32:
        if ((!Intrinsics.areEqual(r109, r102)) == false) goto L34;
        this.f148490l.h();
    L34:
        this.f148490l.setVisibility(0);
        this.f148490l.setMaxWidth(UtilityKotlinExtentionsKt.d(Float.valueOf(116.0f)));
        this.f148490l.f(r100.f147890d, 24.0f, 18);
        dm.a.a("IntroAuction").a("updateAuctionAtmosphere, isFirstShow: " + this.f148488j);
        if (this.f148488j == true) goto L37;
        this.f148490l.setTag(r100);
        this.f148490l.f148004i = true;
        this.f148492n.invoke(Boolean.FALSE);
        this.f148490l.setAlpha(1.0f);
    L41:
        r100.f147887a.setHasShown(true);
        if (r104 != null) goto L44;
        if (r106 == null) goto L44;
    L52:
        this.f148490l.setCallback(new e(this, r100));
        return;
    L44:
        if (r104 == null) goto L48;
        if (r106 != null) goto L48;
        if (r110 == true) goto L52;
        d(r104, r100);
    L48:
        if (r104 == null) goto L52;
        if (r106 == null) goto L52;
        if (r110 == true) goto L52;
        d(r104, r100);
        goto L52
    L37:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM() == false) goto L39;
        this.f148489k.setTranslationX(UtilityKotlinExtentionsKt.c(100));
        this.f148489k.setAlpha(0.0f);
        this.f148489k.animate().translationX(0.0f).alpha(1.0f).setDuration(500).setInterpolator(new DecelerateInterpolator()).setListener(new d(this)).start();
    L39:
        this.f148488j = false;
        goto L41
    L22:
        r109 = null;
        goto L23
    L53:
        c(r100, false);
        return;
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IntroAuctionAtmosphereHelper(View r100, IntroAuctionHotAtmosphereView r101, ECDraweeView r102, Function1<? super Boolean, Unit> r103, Function1<? super String, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "hotAtmosphereView");
        Intrinsics.checkNotNullParameter(r102, "bgView");
        Intrinsics.checkNotNullParameter(r103, "setTopLeftTagVisibility");
        Intrinsics.checkNotNullParameter(r104, "onShowHotAtmosphere");
        this.f148489k = r100;
        this.f148490l = r101;
        this.f148491m = r102;
        this.f148492n = r103;
        this.f148493o = r104;
        this.f148488j = true;
    }
}
