package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right_kmp.slice.component;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.ec.core.widget.AuctionHotAtmosphereView;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphereData;
import com.bytedance.android.ec.model.response.ECAuctionCountdownAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionDigitalAtmosphere;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.d;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: classes10.dex */
public final class KMPAuctionHeaderV2ViewManager extends com.bytedance.android.ecom.arch.slice.render.elements.b<AuctionHotAtmosphereView> {
    public AtmosphereHelper H3;

    public static final class AtmosphereHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f152060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ECAuctionAtmosphere f152061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f152062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Runnable f152063d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f152064e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f152065f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AuctionHotAtmosphereView f152066g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final com.bytedance.android.ec.common.api.jump.model.a f152067h;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/bottom_right_kmp/slice/component/KMPAuctionHeaderV2ViewManager$AtmosphereHelper$CountState;", "", "NOT_START", "IN_PROGRESS", "FINISHED", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum CountState extends Enum<CountState> {
            public static final CountState FINISHED = null;
            public static final CountState IN_PROGRESS = null;
            public static final CountState NOT_START = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ CountState[] f152068a = null;

            static {
                CountState r100 = new CountState("NOT_START", 0);
                NOT_START = r100;
                CountState r101 = new CountState("IN_PROGRESS", 1);
                IN_PROGRESS = r101;
                CountState r102 = new CountState("FINISHED", 2);
                FINISHED = r102;
                f152068a = new CountState[]{r100, r101, r102};
            }

            public static CountState valueOf(String r100) {
                return (CountState) r27.a.a(CountState.class, r100);
            }

            public static CountState[] values() {
                return (CountState[]) f152068a.clone();
            }

            public CountState(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final class a {
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AtmosphereHelper f152069a;

            public b(AtmosphereHelper r100) {
                this.f152069a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f152069a.f152062c = false;     // Catch: Throwable -> L4
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

        public final void b(ECAuctionCountdownAtmosphere r110) {
            dm.a.a("AuctionV2").a("count down startTime convert to local: " + wl.a.a(r110.getStartTime() * 1000) + ", systemclock: " + SystemClock.elapsedRealtime());
            if ((!this.f152062c) == false) goto L5;
            ECAuctionCountdownAtmosphere r100 = r110;
        L6:
            if (r100 == null) goto L35;
            long r101 = SystemClock.elapsedRealtime();
            long r102 = wl.a.a(r110.getStartTime() * 1000);
            long r103 = wl.a.a(r110.getEndTime() * 1000);
            long r111 = (r103 - r101) / 1000;
            if (r101 >= r102) goto L10;
            Pair r104 = new Pair(CountState.NOT_START, 0L);
        L21:
            CountState r105 = (CountState) r104.component1();
            long r106 = ((Number) r104.component2()).longValue();
            dm.a.a("AuctionV2").i("only countDownAtmosphere, countDownState=" + r105 + ", remainSecond=" + r106);
            int r107 = com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right_kmp.slice.component.a.f152070a[r105.ordinal()];
            if (r107 == 1) goto L32;
            if (r107 == 2) goto L32;
            if (r107 != 3) goto L39;
            ECAuctionAtmosphereData r112 = r110.getData();
            if (r112 == null) goto L36;
            ECAuctionAtmosphereData.a r108 = ECAuctionAtmosphereData.Companion;
            String r109 = String.valueOf(r106);
            r108.getClass();
            ECHotAtmosphere r113 = ECAuctionAtmosphereData.a.a(r112, r109);
            this.f152060a = true;
            r113.auctionType = "count_down";
            r113.afterTextIconResId = R.drawable.ec_auction_v2_atmosphere_icon_second;
            a(r113, "count_down");
            return;
        L36:
            return;
        L39:
            return;
        L32:
            if (this.f152060a == false) goto L38;
            this.f152060a = false;
            this.f152066g.setVisibility(4);
            return;
        L38:
            return;
        L10:
            if (r101 < r102) goto L18;
            if (r101 > r103) goto L18;
            if (r111 > 0) goto L16;
            r104 = new Pair(CountState.FINISHED, 0L);
            goto L21
        L16:
            r104 = new Pair(CountState.IN_PROGRESS, Long.valueOf(r111));
        L18:
            if (r101 <= r103) goto L20;
            r104 = new Pair(CountState.FINISHED, 0L);
            goto L21
        L20:
            r104 = new Pair(CountState.NOT_START, 0L);
            goto L21
        L35:
            return;
        L5:
            r100 = null;
            goto L6
        }

        public final void c(ECAuctionDigitalAtmosphere r100) {
            String r101 = r100.getFrequencyKey();
            Long r102 = Long.valueOf(r100.getFrequencyCount());
            int r103 = d.f153071a;
            if (d.a(this.f152064e, this.f152065f, r101, r102, false) == false) goto L11;
            ECAuctionAtmosphereData r104 = r100.getData();
            if (r104 == null) goto L14;
            ECAuctionAtmosphereData.Companion.getClass();
            ECHotAtmosphere r105 = ECAuctionAtmosphereData.a.a(r104, null);
            r105.auctionType = ECAuctionAtmosphere.TYPE_DIGITAL;
            a(r105, ECAuctionAtmosphere.TYPE_DIGITAL);
            this.f152062c = true;
            this.f152060a = false;
            b r106 = new b(this);
            Handler r107 = UtilityKotlinExtentionsKt.f153057b;
            r107.postDelayed(r106, 3000);
            Unit r108 = Unit.INSTANCE;
            Runnable r109 = this.f152063d;
            if (r109 == null) goto L9;
            r107.removeCallbacks(r109);
        L9:
            this.f152063d = r106;
            return;
        L14:
            return;
        L11:
            if (this.f152060a == true) goto L16;
            this.f152066g.setVisibility(4);
            return;
        }

        public final void a(ECHotAtmosphere r100, String r101) {
            if (this.f152066g.getVisibility() != 4) goto L5;
            AuctionHotAtmosphereView r102 = this.f152066g;
            r102.setAlpha(0.0f);
            r102.setVisibility(0);
            r102.animate().cancel();
            ViewPropertyAnimator r103 = r102.animate().alpha(1.0f);
            r103.setDuration(160);
            r103.start();
        L5:
            this.f152066g.i(r100, true, false);
            v r104 = new v("livesdk_show_auction_hot_sale", this.f152067h);
            jf.b.e r105 = jf.b.e.f498853b;
            r104.c(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "live_auction_card");
            r104.c("atmosphere_type", r101);
            r104.i("c2627.d4434");
        }

        public AtmosphereHelper(String r100, String r101, AuctionHotAtmosphereView r102, com.bytedance.android.ec.common.api.jump.model.a r103) {
            Intrinsics.checkNotNullParameter(r102, "atmosphereView");
            Intrinsics.checkNotNullParameter(r103, "absParam");
            this.f152064e = r100;
            this.f152065f = r101;
            this.f152066g = r102;
            this.f152067h = r103;
        }
    }

    public static final class a {
    }

    static {
    }

    public KMPAuctionHeaderV2ViewManager(SlcTemplateContext r100) {
        Intrinsics.checkNotNullParameter(r100, "templateContext");
        super(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void H0(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        Object r101 = r100.get(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (r101 != null) goto L14;
    L6:
        ECAuctionAtmosphere r102 = null;
    L8:
        if (((Unit) UtilityKotlinExtentionsKt.f(r102, k1(), new KMPAuctionHeaderV2ViewManager$onUpdateProp$1(this))) != null) goto L16;
        AtmosphereHelper r103 = this.H3;
        if (r103 == null) goto L17;
        r103.f152066g.setVisibility(4);
        Unit r104 = Unit.INSTANCE;
        return;
    L17:
        return;
    L16:
        return;
    L14:
        int r105 = m0.f153098a;     // Catch: Exception -> L13
        Gson r106 = m0.a.f153099a;     // Catch: Exception -> L13
        r102 = (ECAuctionAtmosphere) r106.fromJson(r106.toJson(r101), ECAuctionAtmosphere.class);     // Catch: Exception -> L13
        goto L8
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.b
    public final View n1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AuctionHotAtmosphereView r101 = new AuctionHotAtmosphereView(r100, null);
        r101.setVisibility(0);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r101.f(true);
        return r101;
    }
}
