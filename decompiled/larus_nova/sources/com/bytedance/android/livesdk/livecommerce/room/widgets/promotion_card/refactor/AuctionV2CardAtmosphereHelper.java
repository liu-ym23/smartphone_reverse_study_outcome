package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import android.os.Handler;
import android.os.SystemClock;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.ec.core.widget.AuctionHotAtmosphereView;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphereData;
import com.bytedance.android.ec.model.response.ECAuctionCountdownAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionDigitalAtmosphere;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: classes10.dex */
public final class AuctionV2CardAtmosphereHelper implements q83.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECAuctionAtmosphere f152293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f152294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f152295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f152296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f152297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f152298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AuctionHotAtmosphereView f152299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.ec.common.api.jump.model.a f152300h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/AuctionV2CardAtmosphereHelper$CountState;", "", "NOT_START", "IN_PROGRESS", "FINISHED", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CountState extends Enum<CountState> {
        public static final CountState FINISHED = null;
        public static final CountState IN_PROGRESS = null;
        public static final CountState NOT_START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CountState[] f152301a = null;

        static {
            CountState r100 = new CountState("NOT_START", 0);
            NOT_START = r100;
            CountState r101 = new CountState("IN_PROGRESS", 1);
            IN_PROGRESS = r101;
            CountState r102 = new CountState("FINISHED", 2);
            FINISHED = r102;
            f152301a = new CountState[]{r100, r101, r102};
        }

        public static CountState valueOf(String r100) {
            return (CountState) r27.a.a(CountState.class, r100);
        }

        public static CountState[] values() {
            return (CountState[]) f152301a.clone();
        }

        public CountState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuctionV2CardAtmosphereHelper f152302a;

        public b(AuctionV2CardAtmosphereHelper r100) {
            this.f152302a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f152302a.f152295c = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void b(ECAuctionDigitalAtmosphere r100) {
        String r101 = r100.getFrequencyKey();
        Long r102 = Long.valueOf(r100.getFrequencyCount());
        int r103 = com.bytedance.android.livesdk.livecommerce.utils.d.f153071a;
        if (com.bytedance.android.livesdk.livecommerce.utils.d.a(this.f152297e, this.f152298f, r101, r102, false) == false) goto L11;
        ECAuctionAtmosphereData r104 = r100.getData();
        if (r104 == null) goto L12;
        ECAuctionAtmosphereData.Companion.getClass();
        ECHotAtmosphere r105 = ECAuctionAtmosphereData.a.a(r104, null);
        r105.auctionType = ECAuctionAtmosphere.TYPE_DIGITAL;
        a(r105, ECAuctionAtmosphere.TYPE_DIGITAL);
        this.f152295c = true;
        this.f152294b = false;
        b r106 = new b(this);
        Handler r107 = UtilityKotlinExtentionsKt.f153057b;
        r107.postDelayed(r106, 3000);
        Unit r108 = Unit.INSTANCE;
        Runnable r109 = this.f152296d;
        if (r109 == null) goto L9;
        r107.removeCallbacks(r109);
    L9:
        this.f152296d = r106;
        return;
    L12:
        return;
    }

    @Override // q83.a
    public final boolean onTick(long r110) {
        dm.a.a("AuctionV2").a("auction atmosphere on tick " + r110);
        ECAuctionAtmosphere r100 = this.f152293a;
        ECAuctionCountdownAtmosphere r101 = null;
        if (r100 == null) goto L5;
        ECAuctionCountdownAtmosphere r102 = r100.getCountDown();
    L6:
        dm.a.b r103 = dm.a.a("AuctionV2");
        StringBuilder r104 = new StringBuilder("count down startTime convert to local: ");
        if (r102 == null) goto L9;
        Long r105 = Long.valueOf(wl.a.a(r102.getStartTime() * 1000));
    L10:
        r104.append(r105);
        r104.append(", systemclock: ");
        r104.append(SystemClock.elapsedRealtime());
        r103.a(r104.toString());
        if (r102 != null) goto L13;
    L61:
        return true;
    L13:
        if ((!this.f152295c) == false) goto L15;
        r101 = r102;
    L15:
        if (r101 == null) goto L61;
        ECAuctionAtmosphere r106 = this.f152293a;
        if (r106 != null) goto L19;
    L47:
        Pair r107 = new Pair(CountState.NOT_START, 0L);
    L48:
        CountState r108 = (CountState) r107.component1();
        long r109 = ((Number) r107.component2()).longValue();
        dm.a.a("AuctionV2").i("only countDownAtmosphere, countDownState=" + r108 + ", remainSecond=" + r109);
        int r111 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.b.f152312a[r108.ordinal()];
        if (r111 == 1) goto L59;
        if (r111 == 2) goto L59;
        if (r111 != 3) goto L61;
        ECAuctionAtmosphereData r112 = r102.getData();
        if (r112 == null) goto L61;
        ECAuctionAtmosphereData.a r113 = ECAuctionAtmosphereData.Companion;
        String r114 = String.valueOf(r109);
        r113.getClass();
        ECHotAtmosphere r115 = ECAuctionAtmosphereData.a.a(r112, r114);
        this.f152294b = true;
        r115.auctionType = "count_down";
        r115.afterTextIconResId = R.drawable.ec_auction_v2_atmosphere_icon_second;
        a(r115, "count_down");
    L59:
        if (this.f152294b == false) goto L61;
        this.f152299g.setVisibility(4);
        this.f152294b = false;
        goto L61
    L19:
        if (r106.getCountDown() == null) goto L47;
        long r116 = SystemClock.elapsedRealtime();
        ECAuctionAtmosphere r117 = this.f152293a;
        if (r117 == null) goto L26;
        ECAuctionCountdownAtmosphere r118 = r117.getCountDown();
        if (r118 == null) goto L26;
        long r119 = wl.a.a(r118.getStartTime() * 1000);
    L27:
        ECAuctionAtmosphere r120 = this.f152293a;
        if (r120 == null) goto L32;
        ECAuctionCountdownAtmosphere r121 = r120.getCountDown();
        if (r121 == null) goto L32;
        long r122 = wl.a.a(r121.getEndTime() * 1000);
    L33:
        long r123 = (r122 - r116) / 1000;
        if (r116 >= r119) goto L36;
        r107 = new Pair(CountState.NOT_START, 0L);
        goto L48
    L36:
        if (r116 < r119) goto L44;
        if (r116 > r122) goto L44;
        if (r123 > 0) goto L42;
        r107 = new Pair(CountState.FINISHED, 0L);
        goto L48
    L42:
        r107 = new Pair(CountState.IN_PROGRESS, Long.valueOf(r123));
    L44:
        if (r116 <= r122) goto L46;
        r107 = new Pair(CountState.FINISHED, 0L);
        goto L48
    L46:
        r107 = new Pair(CountState.NOT_START, 0L);
    L32:
        r122 = 0;
    L26:
        r119 = 0;
        goto L27
    L9:
        r105 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void a(ECHotAtmosphere r100, String r101) {
        if (this.f152299g.getVisibility() == 0) goto L5;
        this.f152299g.setVisibility(0);
        this.f152299g.f(true);
        AuctionHotAtmosphereView r102 = this.f152299g;
        r102.setAlpha(0.0f);
        r102.setVisibility(0);
        r102.animate().cancel();
        ViewPropertyAnimator r103 = r102.animate().alpha(1.0f);
        r103.setDuration(160);
        r103.start();
        this.f152299g.f45843i = true;
    L5:
        this.f152299g.i(r100, true, false);
        v r104 = new v("livesdk_show_auction_hot_sale", this.f152300h);
        jf.b.e r105 = jf.b.e.f498853b;
        r104.c(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "live_auction_card");
        r104.c("atmosphere_type", r101);
        r104.i("c2627.d4434");
    }

    public AuctionV2CardAtmosphereHelper(String r100, String r101, AuctionHotAtmosphereView r102, com.bytedance.android.ec.common.api.jump.model.a r103) {
        Intrinsics.checkNotNullParameter(r102, "atmosphereView");
        Intrinsics.checkNotNullParameter(r103, "absParam");
        this.f152297e = r100;
        this.f152298f = r101;
        this.f152299g = r102;
        this.f152300h = r103;
    }
}
