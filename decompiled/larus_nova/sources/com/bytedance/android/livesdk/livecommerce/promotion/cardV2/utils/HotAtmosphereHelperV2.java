package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.widget.AuctionHotAtmosphereView;
import com.bytedance.android.ec.core.widget.h;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphereData;
import com.bytedance.android.ec.model.response.ECAuctionCountdownAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionDigitalAtmosphere;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.model.AuctionAtmosphereState;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.roundcorner.ECPromotionTopTagLinearlayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class HotAtmosphereHelperV2 implements q83.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f150750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f150751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECAuctionAtmosphere f150752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f150753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AuctionAtmosphereState f150754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f150755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f150756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f150757h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Runnable f150758i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AuctionHotAtmosphereView f150759j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f150760k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function2<Integer, String, Unit> f150761l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/utils/HotAtmosphereHelperV2$CountState;", "", "NOT_START", "IN_PROGRESS", "FINISHED", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CountState extends Enum<CountState> {
        public static final CountState FINISHED = null;
        public static final CountState IN_PROGRESS = null;
        public static final CountState NOT_START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CountState[] f150762a = null;

        static {
            CountState r100 = new CountState("NOT_START", 0);
            NOT_START = r100;
            CountState r101 = new CountState("IN_PROGRESS", 1);
            IN_PROGRESS = r101;
            CountState r102 = new CountState("FINISHED", 2);
            FINISHED = r102;
            f150762a = new CountState[]{r100, r101, r102};
        }

        public static CountState valueOf(String r100) {
            return (CountState) r27.a.a(CountState.class, r100);
        }

        public static CountState[] values() {
            return (CountState[]) f150762a.clone();
        }

        public CountState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HotAtmosphereHelperV2 f150763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jj2.c f150764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f150765c;

        public b(HotAtmosphereHelperV2 r100, jj2.c r101, boolean r102) {
            this.f150763a = r100;
            this.f150764b = r101;
            this.f150765c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f150763a.e(this.f150764b, this.f150765c, true);     // Catch: Throwable -> L4
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
        public final /* synthetic */ HotAtmosphereHelperV2 f150766a;

        public c(HotAtmosphereHelperV2 r100) {
            this.f150766a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f150766a.f150756g = false;     // Catch: Throwable -> L4
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
        public final /* synthetic */ HotAtmosphereHelperV2 f150767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jj2.c f150768b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (ViewCompat.isAttachedToWindow(this.f150767a.f150759j) == false) goto L6;
            this.f150768b.f499287a.setHasShown(true);
            AuctionHotAtmosphereView r101 = this.f150767a.f150759j;
            r101.f45843i = true;
            r101.g(false);
            return;
        }

        public d(HotAtmosphereHelperV2 r100, jj2.c r101) {
            this.f150767a = r100;
            this.f150768b = r101;
        }
    }

    public static final class e implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HotAtmosphereHelperV2 f150769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jj2.c f150770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f150771c;

        @Override // com.bytedance.android.ec.core.widget.h
        public final void a(ECHotAtmosphere r100) {
        }

        @Override // com.bytedance.android.ec.core.widget.h
        public final void c(ECHotAtmosphere r100) {
        }

        @Override // com.bytedance.android.ec.core.widget.h
        public final void b() {
            this.f150771c.animate().alpha(1.0f).setDuration(120).start();
        }

        @Override // com.bytedance.android.ec.core.widget.h
        public final void onAttachedToWindow() {
            if (this.f150769a.f150759j.getTag() != null) goto L6;
            this.f150769a.e(this.f150770b, false, false);
            return;
        }

        @Override // com.bytedance.android.ec.core.widget.h
        public final void onDetachedFromWindow() {
            this.f150769a.f150759j.setTag(null);
            this.f150771c.animate().cancel();
            this.f150769a.f150759j.a();
        }

        public e(HotAtmosphereHelperV2 r100, jj2.c r101, View r102) {
            this.f150769a = r100;
            this.f150770b = r101;
            this.f150771c = r102;
        }
    }

    static {
    }

    public final Pair<CountState, Long> b(ECAuctionCountdownAtmosphere r110) {
        if (r110 == null) goto L5;
        long r100 = SystemClock.elapsedRealtime();
        long r101 = r110.getStartTime() * 1000;
        long r102 = System.currentTimeMillis();
        long r111 = SystemClock.elapsedRealtime() + (r101 - r102);
        long r103 = r110.getEndTime() * 1000;
        long r104 = System.currentTimeMillis();
        long r112 = SystemClock.elapsedRealtime() + (r103 - r104);
        long r105 = (r112 - r100) / 1000;
        if (r100 < r111) goto L21;
        if (r100 < r111) goto L17;
        if (r100 > r112) goto L17;
        if (r105 > 0) goto L23;
        return new Pair(CountState.FINISHED, 0L);
    L23:
        return new Pair(CountState.IN_PROGRESS, Long.valueOf(r105));
    L17:
        if (r100 <= r112) goto L20;
        return new Pair(CountState.FINISHED, 0L);
    L20:
        return new Pair(CountState.NOT_START, 0L);
    L21:
        return new Pair(CountState.NOT_START, 0L);
    L5:
        return new Pair(CountState.NOT_START, 0L);
    }

    public final void c(jj2.c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f150760k.setAlpha(1.0f);
        r100.f499287a.reset();
        this.f150759j.setCallback(null);
        this.f150759j.setTag(null);
        this.f150759j.setVisibility(4);
        this.f150759j.h();
    }

    @Override // q83.a
    public final boolean onTick(long r100) {
        ECAuctionAtmosphere r101 = this.f150752c;
        String r102 = null;
        if (r101 == null) goto L5;
        ECAuctionCountdownAtmosphere r103 = r101.getCountDown();
    L7:
        if (r103 != null) goto L9;
    L52:
        return true;
    L9:
        if ((!this.f150756g) == false) goto L11;
        ECAuctionCountdownAtmosphere r104 = r103;
    L12:
        if (r104 == null) goto L52;
        ECAuctionAtmosphere r105 = this.f150752c;
        if (r105 == null) goto L16;
        ECAuctionCountdownAtmosphere r106 = r105.getCountDown();
    L17:
        Pair<CountState, Long> r107 = b(r106);
        CountState r108 = r107.component1();
        long r109 = r107.component2().longValue();
        int r110 = com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.b.f150781b[r108.ordinal()];
        boolean r111 = false;
        if (r110 == 1) goto L47;
        if (r110 == 2) goto L47;
        if (r110 != 3) goto L52;
        ECAuctionAtmosphereData r112 = r103.getData();
        if (r112 == null) goto L52;
        ECAuctionAtmosphereData.a r113 = ECAuctionAtmosphereData.Companion;
        String r114 = String.valueOf(r109);
        r113.getClass();
        ECHotAtmosphere r115 = ECAuctionAtmosphereData.a.a(r112, r114);
        r115.auctionType = "count_down";
        AuctionAtmosphereState r116 = this.f150754e;
        if (r116 != null) goto L29;
    L36:
        boolean r117 = true;
    L37:
        this.f150753d = true;
        r115.afterTextIconResId = R.drawable.ec_auction_v2_atmosphere_icon_second_list_card;
        AuctionHotAtmosphereView r118 = this.f150759j;
        AuctionAtmosphereState r119 = this.f150754e;
        if (r119 == null) goto L40;
        r111 = r119.isFold();
    L40:
        r118.i(r115, r117, r111);
        this.f150761l.invoke(Integer.valueOf(this.f150755f), "count_down");
        AuctionAtmosphereState r120 = this.f150754e;
        if (r120 == null) goto L43;
        r120.setLastInfo(String.valueOf(r109));
    L43:
        AuctionAtmosphereState r121 = this.f150754e;
        if (r121 == null) goto L52;
        r121.setLastType(1);
        goto L52
    L29:
        if (r116.getLastType() != 1) goto L36;
        AuctionAtmosphereState r122 = this.f150754e;
        if (r122 == null) goto L34;
        r102 = r122.getLastInfo();
    L34:
        if (Intrinsics.areEqual(r102, String.valueOf(r109)) == false) goto L36;
        r117 = false;
    L47:
        if (this.f150753d == false) goto L52;
        this.f150760k.setAlpha(1.0f);
        AuctionAtmosphereState r123 = this.f150754e;
        if (r123 == null) goto L51;
        r123.reset();
    L51:
        this.f150759j.setCallback(null);
        this.f150759j.setTag(null);
        this.f150759j.setVisibility(4);
        this.f150759j.h();
        this.f150753d = false;
        goto L52
    L16:
        r106 = null;
        goto L17
    L11:
        r104 = null;
        goto L12
    L5:
        r103 = null;
        goto L7
    }

    public final void a(jj2.c r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f150755f = r100.f499295i;
        this.f150750a = r100.f499298l;
        this.f150751b = r100.f499299m;
        ECAuctionAtmosphere r101 = r100.f499289c.a();
        ECAuctionCountdownAtmosphere r102 = null;
        if (r101 == null) goto L5;
        ECAuctionDigitalAtmosphere r103 = r101.getDigital();
    L6:
        ECAuctionAtmosphere r104 = r100.f499289c.a();
        if (r104 == null) goto L10;
        r102 = r104.getCountDown();
    L10:
        if (r103 != null) goto L24;
        if (r102 == null) goto L24;
        Pair<CountState, Long> r105 = b(r102);
        CountState r106 = r105.component1();
        r105.component2().longValue();
        int r107 = com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.b.f150780a[r106.ordinal()];
        if (r107 != 2) goto L15;
        e(r100, r110, false);
        return;
    L15:
        if (r107 != 3) goto L35;
        c(r100);
        long r108 = (SystemClock.elapsedRealtime() + ((r102.getStartTime() * 1000) - System.currentTimeMillis())) - SystemClock.elapsedRealtime();
        if (r108 <= 0) goto L30;
        b r109 = new b(this, r100, r110);
        Handler r111 = UtilityKotlinExtentionsKt.f153057b;
        r111.postDelayed(r109, r108);
        Unit r112 = Unit.INSTANCE;
        Runnable r113 = this.f150758i;
        if (r113 == null) goto L22;
        r111.removeCallbacks(r113);
    L22:
        this.f150758i = r109;
        return;
    L30:
        return;
    L35:
        return;
    L24:
        if (r103 == null) goto L28;
        String r114 = r103.getFrequencyKey();
        Long r115 = Long.valueOf(r103.getFrequencyCount());
        int r116 = com.bytedance.android.livesdk.livecommerce.utils.d.f153071a;
        if (com.bytedance.android.livesdk.livecommerce.utils.d.a(this.f150750a, this.f150751b, r114, r115, true) == false) goto L33;
        e(r100, r110, false);
        return;
    L33:
        return;
    L28:
        c(r100);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public HotAtmosphereHelperV2(AuctionHotAtmosphereView r100, ECPromotionTopTagLinearlayout r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "hotAtmosphereView");
        Intrinsics.checkNotNullParameter(r101, "topLeftContainer");
        Intrinsics.checkNotNullParameter(r102, "onShowHotAtmosphere");
        this.f150759j = r100;
        this.f150760k = r101;
        this.f150761l = r102;
    }

    public final void d(ECAuctionDigitalAtmosphere r110, jj2.c r111, boolean r112) {
        ECAuctionAtmosphereData r100 = r110.getData();
        if (r100 == null) goto L5;
        String r101 = r100.getNum();
    L7:
        if (Intrinsics.areEqual(r101, r111.f499288b.getLastInfo()) == true) goto L9;
    L12:
        boolean r113 = true;
    L14:
        if (Intrinsics.areEqual(this.f150759j.getTag(R.id.ec_list_card_auction_atmosphere_tag), r101) == false) goto L16;
        r113 = false;
    L16:
        if (r113 == false) goto L18;
        r111.f499288b.setFold(false);
    L18:
        int r102 = com.bytedance.android.livesdk.livecommerce.utils.d.f153071a;
        if (com.bytedance.android.livesdk.livecommerce.utils.d.a(this.f150750a, this.f150751b, r110.getFrequencyKey(), Long.valueOf(r110.getFrequencyCount()), !r113) == true) goto L21;
        if (r113 == false) goto L21;
        return;
    L21:
        ECAuctionAtmosphereData r114 = r110.getData();
        if (r114 == null) goto L24;
        ECAuctionAtmosphereData.Companion.getClass();
        ECHotAtmosphere r115 = ECAuctionAtmosphereData.a.a(r114, null);
        r115.auctionType = ECAuctionAtmosphere.TYPE_DIGITAL;
        this.f150759j.i(r115, r113, r111.f499288b.isFold());
        this.f150761l.invoke(Integer.valueOf(r111.f499295i), ECAuctionAtmosphere.TYPE_DIGITAL);
    L24:
        AuctionAtmosphereState r116 = r111.f499288b;
        if (r101 != null) goto L27;
        String r103 = "";
    L28:
        r116.setLastInfo(r103);
        r111.f499288b.setLastType(2);
        AuctionHotAtmosphereView r117 = this.f150759j;
        if (r101 != null) goto L31;
        r101 = "";
    L31:
        r117.setTag(R.id.ec_list_card_auction_atmosphere_tag, r101);
        this.f150756g = true;
        c r118 = new c(this);
        Handler r119 = UtilityKotlinExtentionsKt.f153057b;
        r119.postDelayed(r118, 3000);
        Unit r120 = Unit.INSTANCE;
        Runnable r121 = this.f150757h;
        if (r121 == null) goto L34;
        r119.removeCallbacks(r121);
    L34:
        this.f150757h = r118;
        return;
    L27:
        r103 = r101;
        goto L28
    L9:
        if (2 != r111.f499288b.getLastType()) goto L12;
        if (r112 == true) goto L12;
        r113 = false;
        goto L14
    L5:
        r101 = null;
        goto L7
    }

    public final void e(jj2.c r110, boolean r111, boolean r112) {
        View r100 = this.f150760k;
        ECAuctionAtmosphere r101 = r110.f499289c.a();
        this.f150752c = r101;
        this.f150754e = r110.f499288b;
        String r102 = null;
        if (r101 == null) goto L5;
        ECAuctionDigitalAtmosphere r103 = r101.getDigital();
    L6:
        ECAuctionAtmosphere r104 = this.f150752c;
        if (r104 == null) goto L9;
        ECAuctionCountdownAtmosphere r105 = r104.getCountDown();
    L10:
        this.f150756g = false;
        Runnable r106 = this.f150757h;
        if (r106 == null) goto L13;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r106);
    L13:
        this.f150757h = null;
        if (Intrinsics.areEqual(r110.f499289c.i(), Boolean.TRUE) == true) goto L16;
    L43:
        c(r110);
        return;
    L16:
        if (this.f150752c == null) goto L43;
        String r107 = r110.f499292f;
        Object r108 = this.f150759j.getTag();
        if ((r108 instanceof jj2.c) == true) goto L20;
        r108 = null;
    L20:
        jj2.c r109 = (jj2.c) r108;
        if (r109 == null) goto L24;
        r102 = r109.f499292f;
    L24:
        if ((!Intrinsics.areEqual(r107, r102)) == false) goto L26;
        this.f150759j.h();
    L26:
        this.f150759j.setVisibility(0);
        this.f150759j.setMaxWidth(UtilityKotlinExtentionsKt.d(Float.valueOf(116.0f)));
        this.f150759j.f(false);
        if (r110.f499287a.getHasShown() == false) goto L29;
        this.f150759j.setTag(r110);
        this.f150759j.f45843i = true;
        r100.animate().cancel();
        r100.setAlpha(0.0f);
        this.f150759j.setAlpha(1.0f);
    L32:
        if (r103 != null) goto L34;
        if (r105 == null) goto L34;
    L42:
        this.f150759j.setCallback(new e(this, r110, r100));
        return;
    L34:
        if (r103 == null) goto L38;
        if (r105 != null) goto L38;
        if (r112 == true) goto L42;
        d(r103, r110, r111);
    L38:
        if (r103 == null) goto L42;
        if (r105 == null) goto L42;
        if (r112 == true) goto L42;
        d(r103, r110, r111);
        goto L42
    L29:
        if (this.f150759j.getTag() != null) goto L32;
        this.f150759j.setTag(r110);
        r100.animate().alpha(0.0f).setDuration(120).start();
        this.f150759j.setAlpha(0.0f);
        this.f150759j.animate().alpha(1.0f).setDuration(160).setStartDelay(80).setListener(new d(this, r110)).start();
        goto L32
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
