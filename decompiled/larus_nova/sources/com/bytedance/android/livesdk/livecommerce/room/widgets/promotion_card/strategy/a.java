package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import si2.e0;
import si2.f0;

/* JADX INFO: loaded from: classes10.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2350a f152679a = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a$a, reason: collision with other inner class name */
    public static final class C2350a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C2350a f152680a = null;

        public C2350a() {
        }

        static {
            f152680a = new C2350a();
        }
    }

    public static final class b {
        public static void a(boolean r100) {
            dm.a.a("ExplainCardShowStrategy").i("Received dialog hover hide event, isFromHalf = " + r100);
        }

        public static void b(boolean r100) {
            dm.a.a("ExplainCardShowStrategy").i("Received dialog hover show event, isHalf = " + r100);
        }
    }

    static {
        f152679a = C2350a.f152680a;
    }

    void a(boolean r100);

    void b(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r100, boolean r101, Function1<? super ECUIPromotion, Unit> r102);

    void d(ECUIPromotion r100);

    void e(boolean r100);

    void g(String r100, ECHotAtmosphere r101);

    void h();

    void j(ECUIPromotion r100);

    void k(boolean r100);

    void l(f0 r100, boolean r101, boolean r102, Function1<? super ECUIPromotion, Unit> r103);

    void m(ECLiveCardPanelType r100);

    void n(e0 r100, boolean r101, boolean r102, Function2<? super ECUIPromotion, ? super Integer, Unit> r103);

    void o();

    void p(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r100, boolean r101);
}
