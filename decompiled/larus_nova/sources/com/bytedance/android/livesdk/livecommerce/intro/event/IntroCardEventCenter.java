package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import sg2.v;

/* JADX INFO: loaded from: classes10.dex */
public final class IntroCardEventCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.intro.event.a f148224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.promotion.card.e f148225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final il.a f148226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<ql.a, com.bytedance.android.ec.common.api.jump.model.g> f148227d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntroCardEventCenter f148228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f148229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f148230c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f148231d;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter$a$a, reason: collision with other inner class name */
        public static final class RunnableC2296a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IntroPromotionVO f148232a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f148233b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f148234c;

            public RunnableC2296a(IntroPromotionVO r100, com.bytedance.android.ec.common.api.jump.model.g r101, a r102) {
                this.f148232a = r100;
                this.f148233b = r101;
                this.f148234c = r102;
            }

            public final void a() {
                a r100 = this.f148234c;
                IntroCardEventCenter r101 = r100.f148228a;
                String r102 = r100.f148229b;
                com.bytedance.android.ec.common.api.jump.model.a r103 = this.f148233b;
                if (r103 != null) goto L5;
                r103 = com.bytedance.android.ec.common.api.jump.model.b.f42853a;
            L5:
                v r104 = new v(r102, r103);
                IntroPromotionVO r105 = this.f148232a;
                if (r105 == null) goto L8;
                String r106 = r105.getProductId();
            L9:
                r104.c("product_id", r106);
                IntroPromotionVO r107 = this.f148232a;
                r104.d(r107.getEventParams());
                r104.c("product_id", r107.getProductId());
                if (r107.isOnExplaining() == false) goto L12;
                String r108 = "1";
            L13:
                r104.c("is_explaining", r108);
                int r109 = 1;
                r104.a(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, !r107.getSingleSku() ? 1 : 0);
                r104.a("local_num", r107.getLocalNum());
                ECUIAskExplainInfo r110 = r107.getAskExplainInfo();
                if (r110 != null) goto L16;
            L18:
                r109 = 0;
            L19:
                r104.a(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, r109);
                Unit r111 = Unit.INSTANCE;
                r104.d(this.f148234c.f148230c);
                r101.d(r104, this.f148234c.f148231d);
                return;
            L16:
                if (r110.isAsked() != true) goto L18;
            L12:
                r108 = "0";
                goto L13
            L8:
                r106 = null;
                goto L9
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(IntroCardEventCenter r100, String r101, Map r102, String r103) {
            this.f148228a = r100;
            this.f148229b = r101;
            this.f148230c = r102;
            this.f148231d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.ec.common.api.jump.model.g r100 = IntroCardEventCenter.c(this.f148228a);     // Catch: Throwable -> L11
            if (r100 == null) goto L14;
            ql.a r101 = r100.f42873a;     // Catch: Throwable -> L11
            if ((r101 instanceof IntroPromotionVO) == true) goto L7;
            r101 = null;
        L7:
            IntroPromotionVO r102 = (IntroPromotionVO) r101;     // Catch: Throwable -> L11
            if (r102 == null) goto L18;
            oh.a.c(this.f148229b, new RunnableC2296a(r102, r100, this));     // Catch: Throwable -> L11
            return;
        L18:
            return;
        L14:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f148235a;

        public b(Runnable r100) {
            this.f148235a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f148235a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static void b(Runnable r100) {
        UtilityKotlinExtentionsKt.f153057b.post(new b(r100));
    }

    public static com.bytedance.android.ec.common.api.jump.model.g c(IntroCardEventCenter r100) {
        return r100.f148227d.invoke(null);
    }

    public final void d(final v r100, String r101) {
        final Ref.BooleanRef r102 = new Ref.BooleanRef();
        com.bytedance.android.livesdk.livecommerce.promotion.card.e r103 = this.f148225b;
        if (r103 == null) goto L11;
        String r104 = r100.f541821d;
        Map<String, String> r105 = r100.g();
        com.bytedance.android.ec.common.api.jump.model.g r106 = (com.bytedance.android.ec.common.api.jump.model.g) r100.f541822e.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class));
        if (r106 == null) goto L7;
        ql.a r107 = r106.f42873a;
    L8:
        boolean r108 = r103.a(r104, r105, r101, r107, new IntroCardEventCenter$saveByIntercept$1(r100, r102));
        boolean r109 = true;
        if (r108 != true) goto L11;
    L12:
        r102.element = r109;
        if (r109 == false) goto L15;
        return;
    L15:
        r100.i(r101);
        return;
    L7:
        r107 = null;
    L11:
        r109 = false;
        goto L12
    }

    public final void a(String r100, Map<String, String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        b(new a(this, r100, r101, r102));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IntroCardEventCenter(com.bytedance.android.livesdk.livecommerce.intro.event.a r100, com.bytedance.android.livesdk.livecommerce.promotion.card.e r101, il.a r102, Function1<? super ql.a, com.bytedance.android.ec.common.api.jump.model.g> r103) {
        Intrinsics.checkNotNullParameter(r102, "eventMap");
        Intrinsics.checkNotNullParameter(r103, "getPromotionParams");
        this.f148224a = r100;
        this.f148225b = r101;
        this.f148226c = r102;
        this.f148227d = r103;
    }
}
