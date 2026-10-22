package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.RightTagEventParam;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f147723a = 0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ql.a f147724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.a f147725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f147726c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f147727d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f147728e;

        public a(ql.a r100, com.bytedance.android.ec.common.api.jump.model.a r101, String r102, String r103, String r104) {
            this.f147724a = r100;
            this.f147725b = r101;
            this.f147726c = r102;
            this.f147727d = r103;
            this.f147728e = r104;
        }

        public final void a() {
            int r100 = d2.f147723a;
            ql.a r101 = this.f147724a;
            com.bytedance.android.ec.common.api.jump.model.a r102 = this.f147725b;
            String r103 = this.f147726c;
            String r104 = this.f147727d;
            String r110 = this.f147728e;
            Map<String, List<ECRitTag>> r105 = r101.getRitTag();
            if (r105 == null) goto L15;
            Iterator<Map.Entry<String, List<ECRitTag>>> r111 = r105.entrySet().iterator();
        L6:
            if (r111.hasNext() == false) goto L15;
            Map.Entry<String, List<ECRitTag>> r106 = r111.next();
            String r107 = r106.getKey();
            Iterator<ECRitTag> r112 = r106.getValue().iterator();
        L9:
            if (r112.hasNext() == false) goto L6;
            RitTagTrack r108 = r112.next().getTagTrack();
            if (r108 == null) goto L9;
            if (r108.getVisibile() == false) goto L9;
            d2.d(r102, r103, r108, r101, r104, r110);
        L15:
            List<PromotionBenefitLabel> r109 = r101.getBenefitLabels();
            if (r109 == null) goto L25;
            Iterator<PromotionBenefitLabel> r113 = r109.iterator();
        L19:
            if (r113.hasNext() == false) goto L25;
            RitTagTrack r114 = r113.next().getTagTrack();
            if (r114 == null) goto L19;
            if (r114.getVisibile() == false) goto L19;
            d2.d(r102, r103, r114, r101, r104, r110);
        L25:
            RitTagTrack r115 = r101.getUpIconTagTrack();
            if (r115 != null) goto L28;
        L30:
            ECCurrentPromotion.PopBackground r116 = r101.getBackground();
            if (r116 == null) goto L53;
            RitTagTrack r117 = r116.tagTrack;
            if (r117 != null) goto L35;
            return;
        L35:
            if (r117.getVisibile() == false) goto L55;
            d2.d(r102, r103, r117, r101, r104, r110);
            return;
        L55:
            return;
        L53:
            return;
        L28:
            if (r115.getVisibile() == false) goto L30;
            d2.d(r102, r103, r115, r101, r104, r110);
            goto L30
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

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.a f147729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f147730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RitTagTrack f147731c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ql.a f147732d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ rh2.b f147733e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f147734f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f147735g;

        public b(com.bytedance.android.ec.common.api.jump.model.a r100, String r101, RitTagTrack r102, ql.a r103, rh2.b r104, String r105, String r106) {
            this.f147729a = r100;
            this.f147730b = r101;
            this.f147731c = r102;
            this.f147732d = r103;
            this.f147733e = r104;
            this.f147734f = r105;
            this.f147735g = r106;
        }

        public final void a() {
            sg2.v r100 = new sg2.v("product_tag_show", this.f147729a);
            r100.c("tag_show_scene", "live");
            r100.c("tag_show_page_position", this.f147730b);
            RightTagEventParam r101 = this.f147731c.getEventParam();
            String r102 = "";
            if (r101 == null) goto L6;
            String r103 = r101.getProductTag();
            if (r103 == null) goto L6;
        L7:
            r100.c("product_tag", r103);
            ql.a r104 = this.f147732d;
            if (r104 == null) goto L11;
            String r105 = r104.getProductId();
            if (r105 == null) goto L11;
        L12:
            r100.c("product_id", r105);
            RightTagEventParam r106 = this.f147731c.getEventParam();
            if (r106 == null) goto L18;
            String r107 = r106.getProductTagText();
            if (r107 == null) goto L18;
            r102 = r107;
        L18:
            r100.c("product_tag_text", r102);
            if (this.f147733e == null) goto L21;
            String r108 = "1";
        L22:
            r100.c("is_ecom_new", r108);
            r100.j(this.f147734f, this.f147735g);
            return;
        L21:
            r108 = "0";
        L11:
            r105 = "";
        L6:
            r103 = "";
            goto L7
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

    static {
    }

    public static Pair a(ql.a r110) {
        Intrinsics.checkNotNullParameter(r110, "promotion");
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        Map<String, List<ECRitTag>> r102 = r110.getRitTag();
        if (r102 == null) goto L13;
        Iterator<Map.Entry<String, List<ECRitTag>>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L13;
        Map.Entry<String, List<ECRitTag>> r104 = r103.next();
        String r105 = r104.getKey();
        Iterator<ECRitTag> r106 = r104.getValue().iterator();
    L9:
        if (r106.hasNext() == false) goto L6;
        RitTagTrack r107 = r106.next().getTagTrack();
        if (r107 == null) goto L9;
        b(r107, r100, r101);
    L13:
        List<PromotionBenefitLabel> r108 = r110.getBenefitLabels();
        if (r108 == null) goto L21;
        Iterator<PromotionBenefitLabel> r109 = r108.iterator();
    L17:
        if (r109.hasNext() == false) goto L21;
        RitTagTrack r111 = r109.next().getTagTrack();
        if (r111 == null) goto L17;
        b(r111, r100, r101);
    L21:
        RitTagTrack r112 = r110.getUpIconTagTrack();
        if (r112 == null) goto L24;
        b(r112, r100, r101);
    L24:
        ECCurrentPromotion.PopBackground r113 = r110.getBackground();
        if (r113 == null) goto L30;
        RitTagTrack r114 = r113.tagTrack;
        if (r114 == null) goto L30;
        b(r114, r100, r101);
    L30:
        if ((r110 instanceof ECUIPromotionV2) == false) goto L53;
        Map<String, String> r115 = r110.getEventParams();
        if (r115 == null) goto L53;
        String r116 = r115.get("tag_code_list");
        if (r116 == null) goto L53;
        String r117 = StringsKt.removeSurrounding(r116, "[", "]");
        if (r117 == null) goto L53;
        List r118 = StringsKt.split$default(r117, new String[]{","}, false, 0, 6, null);
        if (r118 == null) goto L53;
        ArrayList r119 = new ArrayList();
        Iterator r120 = r118.iterator();
    L41:
        if (r120.hasNext() == false) goto L48;
        Object r121 = r120.next();
        if (((String) r121).length() <= 0) goto L45;
        boolean r122 = true;
    L46:
        if (r122 == false) goto L41;
        r119.add(r121);
        goto L41
    L45:
        r122 = false;
        goto L46
    L48:
        Iterator r123 = r119.iterator();
    L50:
        if (r123.hasNext() == false) goto L53;
        r100.add((String) r123.next());
    L53:
        return new Pair(r100, r101);
    }

    public static void b(RitTagTrack r100, ArrayList r101, ArrayList r102) {
        if (r100.getVisibile() == false) goto L13;
        String r103 = r100.getTagCode();
        if (r103 == null) goto L14;
        r101.add(r103);
        RightTagEventParam r104 = r100.getEventParam();
        if (r104 == null) goto L10;
        String r105 = r104.getProductTagText();
        if (r105 == null) goto L10;
    L11:
        r102.add(r103 + ':' + r105);
        return;
    L10:
        r105 = "";
        goto L11
    L14:
        return;
    }

    public static void c(ql.a r100, com.bytedance.android.ec.common.api.jump.model.a r101, String r102, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "promotion");
        Intrinsics.checkNotNullParameter(r101, "promotionParams");
        Intrinsics.checkNotNullParameter(r102, "tagShowPagePosition");
        oh.a.c("reportPromotionProductTagShow", new a(r100, r101, r102, r110, r111));
    }

    public static void d(com.bytedance.android.ec.common.api.jump.model.a r100, String r110, RitTagTrack r111, ql.a r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        Intrinsics.checkNotNullParameter(r110, "tagShowPagePosition");
        Intrinsics.checkNotNullParameter(r111, "tagTrack");
        oh.a.c("sendProductTagShowEvent", new b(r100, r110, r111, r112, (rh2.b) r100.getParamsModel(Reflection.getOrCreateKotlinClass(rh2.b.class)), r113, r114));
    }
}
