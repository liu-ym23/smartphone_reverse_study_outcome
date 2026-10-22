package com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource;

import android.text.TextUtils;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.c1;
import com.bytedance.android.ec.model.response.d1;
import com.bytedance.android.ec.model.response.h1;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2HotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.ECV2InteractionData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCommentaryVideoInfo;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListCacheCenter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListTabPromotionData;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mj2.e;
import mj2.j;

/* JADX INFO: loaded from: classes10.dex */
public final class LivePromotionListLocalDataSourceUpdateDelegate implements tj2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f151156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LivePromotionListCacheCenter f151157b;

    public final List<ql.a> e() {
        ArrayList r100 = new ArrayList();
        r100.addAll(this.f151156a.f());
        LivePromotionListCacheCenter r101 = this.f151157b;
        if (r101 != null) goto L5;
    L42:
        List r102 = CollectionsKt.emptyList();
    L43:
        r100.addAll(r102);
        return r100;
    L5:
        if (r101.f151061b != null) goto L7;
        r102 = CollectionsKt.emptyList();
    L40:
        if (r102 == null) goto L42;
    L7:
        ArrayList r103 = new ArrayList();
        e r104 = r101.f151061b;
        if (r104 == null) goto L12;
        List<? extends ql.a> r105 = r104.f514177a;
        if (r105 == null) goto L12;
        r103.addAll(r105);
    L12:
        e r106 = r101.f151061b;
        if (r106 == null) goto L17;
        List<? extends ql.a> r107 = r106.f514178b;
        if (r107 == null) goto L17;
        r103.addAll(r107);
    L17:
        e r108 = r101.f151061b;
        if (r108 == null) goto L23;
        ql.a r109 = r108.f514179c;
        if (r109 == null) goto L23;
        r103.add(r109);
    L23:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == false) goto L29;
        e r110 = r101.f151061b;
        if (r110 == null) goto L34;
        List<? extends ql.a> r111 = r110.f514181e;
        if (r111 == null) goto L34;
        r103.addAll(r111);
    L34:
        e r112 = r101.f151061b;
        if (r112 == null) goto L39;
        List<? extends ql.a> r113 = r112.f514182f;
        if (r113 == null) goto L39;
        r103.addAll(r113);
    L39:
        r102 = r103;
        goto L40
    L29:
        e r114 = r101.f151061b;
        if (r114 == null) goto L34;
        ql.a r115 = r114.f514180d;
        if (r115 == null) goto L34;
        r103.add(r115);
        goto L34
    }

    @Override // tj2.c
    public final void a(ECV2AuctionInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "auctionInfo");
        Iterator r101 = ((ArrayList) e()).iterator();
    L4:
        if (r101.hasNext() == false) goto L21;
        ql.a r102 = (ql.a) r101.next();
        if ((r102 instanceof ECUIPromotionV2) == true) goto L8;
        r102 = null;
    L8:
        ECUIPromotionV2 r103 = (ECUIPromotionV2) r102;
        if (r103 == null) goto L4;
        if (Intrinsics.areEqual(r103.getProductId(), String.valueOf(r100.productId)) == false) goto L4;
        if (r103.isAuction() == false) goto L4;
        r103.setAuctionInfo(r100.toECPromotionAuctionInfo());
        d1 r104 = r103.getPrice();
        if (r104 == null) goto L4;
        h1 r105 = r104.c();
        if (r105 == null) goto L4;
        c1 r106 = r105.b();
        if (r106 == null) goto L4;
        r106.d(r100.price);
        goto L4
    }

    @Override // tj2.c
    public final void d(List<? extends ql.a> r110) {
        Intrinsics.checkNotNullParameter(r110, "promotions");
        a r100 = this.f151156a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "promotions");
        Iterator<T> r101 = r110.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (((ql.a) r102).isOnTopExplaining() == false) goto L4;
    L9:
        ql.a r103 = (ql.a) r102;
        if (r103 == null) goto L12;
        r100.d(r103, CollectionsKt.emptyList(), false);
    L12:
        Iterator r104 = ((ArrayList) r100.c()).iterator();
    L14:
        if (r104.hasNext() == false) goto L63;
        LivePromotionListTabPromotionData r105 = (LivePromotionListTabPromotionData) ((Pair) r104.next()).getSecond();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r110, "promotions");
        List<? extends ql.a> r106 = CollectionsKt.toMutableList(r105.f151102a);
        Iterator<T> r107 = r106.iterator();
        int r108 = 0;
    L17:
        if (r107.hasNext() == false) goto L41;
        Object r111 = r107.next();
        int r112 = r108 + 1;
        if (r108 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        ql.a r113 = (ql.a) r111;
        Iterator<T> r114 = r110.iterator();
    L23:
        if (r114.hasNext() == false) goto L33;
        Object r115 = r114.next();
        ql.a r116 = (ql.a) r115;
        if (Intrinsics.areEqual(r116.getUniTag(), r113.getUniTag()) == true) goto L27;
    L29:
        boolean r109 = false;
    L30:
        if (r109 == false) goto L23;
    L34:
        ql.a r117 = (ql.a) r115;
        if (r117 == null) goto L37;
        ql.a r118 = l.a(r117);
    L38:
        if (r118 == null) goto L40;
        r118.setIronIndex(r113.getIronIndex());
        r118.setRealIndex(r113.getRealIndex());
        r118.setRelatedInfo(r113.isRelatedInfo());
        r118.setDynamicRecommendIndex(r113.getDynamicRecommendIndex());
        r118.copyIconDataFromPromotion(r113);
        r118.setDynamicSlot(r113.getDynamicSlot());
        ListProtector.set(r106, r108, r118);
    L40:
        r108 = r112;
        goto L17
    L37:
        r118 = null;
        goto L38
    L27:
        if (r116.isOnTopExplaining() == true) goto L29;
        r109 = true;
        goto L30
    L33:
        r115 = null;
        goto L34
    L41:
        r105.f151102a = r106;
        Iterator<T> r119 = r105.f151106e.iterator();
    L43:
        if (r119.hasNext() == false) goto L14;
        j r120 = (j) r119.next();
        Iterator<T> r121 = r110.iterator();
    L46:
        if (r121.hasNext() == false) goto L55;
        Object r122 = r121.next();
        if (Intrinsics.areEqual(((ql.a) r122).getUniTag(), r120.f514211b.getUniTag()) == true) goto L50;
    L52:
        boolean r123 = false;
    L53:
        if (r123 == false) goto L46;
    L56:
        ql.a r124 = (ql.a) r122;
        if (r124 == null) goto L59;
        ql.a r125 = l.a(r124);
    L60:
        if (r125 == null) goto L43;
        r125.setIronIndex(r120.f514211b.getIronIndex());
        r125.setRealIndex(r120.f514211b.getRealIndex());
        r125.setRelatedInfo(r120.f514211b.isRelatedInfo());
        r125.setDynamicRecommendIndex(r120.f514211b.getDynamicRecommendIndex());
        r125.copyIconDataFromPromotion(r120.f514211b);
        r125.setDynamicSlot(r120.f514211b.getDynamicSlot());
        Intrinsics.checkNotNullParameter(r125, "<set-?>");
        r120.f514211b = r125;
        goto L43
    L59:
        r125 = null;
        goto L60
    L50:
        if (r120.f514211b.isOnTopExplaining() == true) goto L52;
        r123 = true;
        goto L53
    L55:
        r122 = null;
        goto L56
    L63:
        LivePromotionListCacheCenter r126 = this.f151157b;
        if (r126 == null) goto L255;
        Intrinsics.checkNotNullParameter(r110, "promotions");
        Iterator<T> r127 = r110.iterator();
    L67:
        if (r127.hasNext() == false) goto L71;
        Object r128 = r127.next();
        if (((ql.a) r128).isOnTopExplaining() == false) goto L67;
    L72:
        ql.a r129 = (ql.a) r128;
        if (r129 == null) goto L78;
        e r130 = r126.f151061b;
        if (r130 == null) goto L78;
        r130.f514179c = r129;
    L78:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == false) goto L104;
        e r131 = r126.f151061b;
        if (r131 == null) goto L128;
        List<? extends ql.a> r132 = r131.f514181e;
        if (r132 == null) goto L128;
        ArrayList r133 = new ArrayList();
        Iterator<T> r134 = r132.iterator();
    L85:
        if (r134.hasNext() == false) goto L103;
        ql.a r135 = (ql.a) r134.next();
        int r136 = l.f153096a;
        Iterator<T> r137 = r110.iterator();
    L88:
        if (r137.hasNext() == false) goto L96;
        Object r138 = r137.next();
        String r139 = ((ql.a) r138).getUniTag();
        if (r135 == null) goto L92;
        String r140 = r135.getUniTag();
    L94:
        if (Intrinsics.areEqual(r139, r140) == false) goto L88;
    L97:
        ql.a r141 = l.a((ql.a) r138);
        if (r141 == null) goto L100;
        r141.setRelatedInfo(r135.isRelatedInfo());
        r141.copyIconDataFromPromotion(r135);
        r141.setDynamicSlot(r135.getDynamicSlot());
    L101:
        if (r141 == null) goto L85;
        r133.add(r141);
        goto L85
    L100:
        r141 = null;
        goto L101
    L92:
        r140 = null;
        goto L94
    L96:
        r138 = null;
        goto L97
    L103:
        r131.f514181e = r133;
    L128:
        e r142 = r126.f151061b;
        if (r142 == null) goto L149;
        List<? extends ql.a> r143 = r142.f514182f;
        if (r143 == null) goto L149;
        ArrayList r144 = new ArrayList();
        Iterator<T> r145 = r143.iterator();
    L134:
        if (r145.hasNext() == false) goto L148;
        ql.a r146 = (ql.a) r145.next();
        int r147 = l.f153096a;
        Iterator<T> r148 = r110.iterator();
    L137:
        if (r148.hasNext() == false) goto L141;
        Object r149 = r148.next();
        if (Intrinsics.areEqual(((ql.a) r149).getUniTag(), r146.getUniTag()) == false) goto L137;
    L142:
        ql.a r150 = l.a((ql.a) r149);
        if (r150 == null) goto L145;
        r150.setDynamicRecommendIndex(r146.getDynamicRecommendIndex());
        r150.setRelatedInfo(r146.isRelatedInfo());
        r150.copyIconDataFromPromotion(r146);
        r150.setDynamicSlot(r146.getDynamicSlot());
    L146:
        if (r150 == null) goto L134;
        r144.add(r150);
        goto L134
    L145:
        r150 = null;
        goto L146
    L141:
        r149 = null;
        goto L142
    L148:
        r142.f514182f = r144;
    L149:
        e r151 = r126.f151061b;
        if (r151 == null) goto L175;
        List<? extends ql.a> r152 = r151.f514178b;
        if (r152 == null) goto L173;
        List<? extends ql.a> r153 = CollectionsKt.toMutableList(r152);
        if (r153 == null) goto L173;
        Iterator<T> r154 = r153.iterator();
        int r155 = 0;
    L157:
        if (r154.hasNext() == false) goto L172;
        Object r156 = r154.next();
        int r157 = r155 + 1;
        if (r155 >= 0) goto L161;
        CollectionsKt.throwIndexOverflow();
    L161:
        ql.a r158 = (ql.a) r156;
        Iterator<T> r159 = r110.iterator();
    L163:
        if (r159.hasNext() == false) goto L167;
        Object r160 = r159.next();
        if (Intrinsics.areEqual(((ql.a) r160).getUniTag(), r158.getUniTag()) == false) goto L163;
    L168:
        ql.a r161 = (ql.a) r160;
        if (r161 == null) goto L171;
        r161.setIronIndex(r158.getIronIndex());
        r161.setRealIndex(r158.getRealIndex());
        r161.setRelatedInfo(r158.isRelatedInfo());
        r161.copyIconDataFromPromotion(r158);
        r161.setDynamicSlot(r158.getDynamicSlot());
        ListProtector.set(r153, r155, r161);
    L171:
        r155 = r157;
        goto L157
    L167:
        r160 = null;
        goto L168
    L172:
        Unit r162 = Unit.INSTANCE;
    L174:
        r151.f514178b = r153;
    L173:
        r153 = null;
    L175:
        e r163 = r126.f151061b;
        if (r163 == null) goto L256;
        List<? extends ql.a> r164 = r163.f514177a;
        if (r164 == null) goto L199;
        List<? extends ql.a> r165 = CollectionsKt.toMutableList(r164);
        if (r165 == null) goto L199;
        Iterator<T> r166 = r165.iterator();
        int r167 = 0;
    L183:
        if (r166.hasNext() == false) goto L198;
        Object r168 = r166.next();
        int r169 = r167 + 1;
        if (r167 >= 0) goto L187;
        CollectionsKt.throwIndexOverflow();
    L187:
        ql.a r170 = (ql.a) r168;
        Iterator<T> r171 = r110.iterator();
    L189:
        if (r171.hasNext() == false) goto L193;
        Object r172 = r171.next();
        if (Intrinsics.areEqual(((ql.a) r172).getUniTag(), r170.getUniTag()) == false) goto L189;
    L194:
        ql.a r173 = (ql.a) r172;
        if (r173 == null) goto L197;
        r173.setIronIndex(r170.getIronIndex());
        r173.setRealIndex(r170.getRealIndex());
        r173.setRelatedInfo(r170.isRelatedInfo());
        r173.copyIconDataFromPromotion(r170);
        r173.setDynamicSlot(r170.getDynamicSlot());
        ListProtector.set(r165, r167, r173);
    L197:
        r167 = r169;
        goto L183
    L193:
        r172 = null;
        goto L194
    L198:
        Unit r174 = Unit.INSTANCE;
        List<? extends ql.a> r175 = r165;
    L200:
        r163.f514177a = r175;
        return;
    L199:
        r175 = null;
        goto L200
    L256:
        return;
    L104:
        Iterator<T> r176 = r110.iterator();
    L106:
        if (r176.hasNext() == false) goto L116;
        Object r177 = r176.next();
        String r178 = ((ql.a) r177).getUniTag();
        e r179 = r126.f151061b;
        if (r179 == null) goto L112;
        ql.a r180 = r179.f514180d;
        if (r180 == null) goto L112;
        String r181 = r180.getUniTag();
    L114:
        if (Intrinsics.areEqual(r178, r181) == false) goto L106;
    L117:
        ql.a r182 = (ql.a) r177;
        if (r182 == null) goto L128;
        e r183 = r126.f151061b;
        if (r183 == null) goto L128;
        ql.a r184 = r183.f514180d;
        if (r184 == null) goto L128;
        ql.a r185 = l.a(r182);
        if (r185 == null) goto L126;
        r185.setRelatedInfo(r184.isRelatedInfo());
        r185.copyIconDataFromPromotion(r184);
        r185.setDynamicSlot(r184.getDynamicSlot());
        Unit r186 = Unit.INSTANCE;
    L127:
        r183.f514180d = r185;
        goto L128
    L126:
        r185 = null;
    L112:
        r181 = null;
        goto L114
    L116:
        r177 = null;
        goto L117
    L71:
        r128 = null;
        goto L72
    L255:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public LivePromotionListLocalDataSourceUpdateDelegate(a r100, LivePromotionListCacheCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "localDataSource");
        this.f151156a = r100;
        this.f151157b = r101;
    }

    @Override // tj2.c
    public final void b(ECV2UpdatedCommentaryVideoInfo r110, List<Long> r111) {
        if (r111 != null) goto L4;
        return;
    L4:
        int r100 = r111.size();
        int r101 = 0;
    L5:
        if (r101 >= r100) goto L31;
        Iterator r102 = ((ArrayList) e()).iterator();
    L8:
        if (r102.hasNext() == false) goto L30;
        ql.a r103 = (ql.a) r102.next();
        if (TextUtils.equals(r103.getProductId(), String.valueOf(ListProtector.get(r111, r101))) == false) goto L8;
        if (r110 == null) goto L21;
        if (r110.action != 2) goto L21;
        if ((r103 instanceof ECUIPromotion) == true) goto L18;
        r103 = null;
    L18:
        ECUIPromotion r104 = (ECUIPromotion) r103;
        if (r104 == null) goto L8;
        r104.hasCommentaryVideo = true;
    L21:
        if (r110 == null) goto L8;
        if (r110.action != 1) goto L8;
        if ((r103 instanceof ECUIPromotion) == true) goto L27;
        r103 = null;
    L27:
        ECUIPromotion r105 = (ECUIPromotion) r103;
        if (r105 == null) goto L8;
        r105.hasCommentaryVideo = false;
        goto L8
    L30:
        r101 = r101 + 1;
        goto L5
    }

    @Override // tj2.c
    public final boolean c(ECV2HotAtmosphere r100, ECV2InteractionData r101, List<Long> r110) {
        int r102 = 0;
        if (r110 != null) goto L5;
        return false;
    L5:
        int r103 = r110.size();
        boolean r104 = false;
    L6:
        if (r102 >= r103) goto L15;
        String r105 = String.valueOf(ListProtector.get(r110, r102));
        Iterator r106 = ((ArrayList) e()).iterator();
    L9:
        if (r106.hasNext() == false) goto L14;
        ql.a r107 = (ql.a) r106.next();
        if (TextUtils.equals(r107.getProductId(), r105) == false) goto L9;
        if (r100 == null) goto L9;
        r107.updateHotAtmosphere(r100);
        UtilityKotlinExtentionsKt.f(r101, r107.getAtmosphereHeaderStateOrDefault(), LivePromotionListLocalDataSourceUpdateDelegate$updateHotAtmosphere$1.INSTANCE);
        r104 = true;
        goto L9
    L14:
        r102 = r102 + 1;
        goto L6
    L15:
        return r104;
    }
}
