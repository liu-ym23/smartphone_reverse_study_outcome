package cg;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.SkuStatusDetail;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, SkuItemInfoVO> f23575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f23576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SkuLimit f23577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f23578d;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.f23576b;
    }

    public static String b(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "idArray");
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        boolean r103 = false;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L10;
        String r105 = r100[r104];
        if (r105 == null) goto L6;
        r101.append(r105);
        r101.append("_");
        r104 = r104 + 1;
        goto L3
    L6:
        return null;
    L10:
        if (r101.length() <= 0) goto L12;
        r103 = true;
    L12:
        if (r103 == false) goto L15;
        r101.deleteCharAt(r101.length() - 1);
    L15:
        return r101.toString();
    }

    public static String i(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "idArray");
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        boolean r103 = false;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L10;
        String r105 = r100[r104];
        if (r105 != null) goto L7;
        r101.append("0");
    L8:
        r101.append("_");
        r104 = r104 + 1;
        goto L3
    L7:
        r101.append(r105);
        goto L8
    L10:
        if (r101.length() <= 0) goto L12;
        r103 = true;
    L12:
        if (r103 == false) goto L15;
        r101.deleteCharAt(r101.length() - 1);
    L15:
        return r101.toString();
    }

    public final boolean a(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r101 = i(r100);
        SkuItemInfoVO r102 = (SkuItemInfoVO) ((LinkedHashMap) this.f23575a).get(r101);
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.getCanSelect();
    }

    public final SkuLimit c(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r101 = i(r100);
        if (com.bytedance.android.ec.core.abtest.d.E() == false) goto L8;
        SkuItemInfoVO r102 = (SkuItemInfoVO) ((LinkedHashMap) this.f23575a).get(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        SkuLimit r103 = new SkuLimit(r102.getLowerLimit(), r102.getLowerLimitToast());
    L13:
        return r103;
    L8:
        SkuItemInfoVO r104 = (SkuItemInfoVO) ((LinkedHashMap) this.f23575a).get(r101);
        if (r104 == null) goto L15;
        r103 = new SkuLimit(r104.getLowerLimit(), r104.getLowerLimitToast());
        goto L13
    L15:
        return this.f23577c;
    }

    public final Integer d(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r101 = i(r100);
        SkuItemInfoVO r102 = (SkuItemInfoVO) ((LinkedHashMap) this.f23575a).get(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r102.getPriceHeaderStyle());
    }

    public final CarAdaptComponent e(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r101 = i(r100);
        if (r101 == null) goto L7;
        SkuItemInfoVO r102 = (SkuItemInfoVO) ((LinkedHashMap) this.f23575a).get(r101);
        if (r102 == null) goto L7;
        return r102.getCarAdaptComponent();
    L7:
        return null;
    }

    public final Long f(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r101 = i(r100);
        SkuItemInfoVO r102 = (SkuItemInfoVO) ((LinkedHashMap) this.f23575a).get(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r102.getStockNum());
    }

    public final List<PromotionBenefitLabel> g(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r101 = i(r100);
        if (Intrinsics.areEqual(r101, "0") == false) goto L6;
        return null;
    L6:
        SkuItemInfoVO r102 = (SkuItemInfoVO) ((LinkedHashMap) this.f23575a).get(r101);
        if (r102 == null) goto L11;
        List<PromotionBenefitLabel> r103 = r102.getBenefitLabels();
        if (r103 == null) goto L11;
        return r103;
    L11:
        return CollectionsKt.emptyList();
    }

    public final String h(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r101 = i(r100);
        SkuItemInfoVO r102 = (SkuItemInfoVO) ((LinkedHashMap) this.f23575a).get(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getBigImageUrl();
    }

    public final String j(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r101 = i(r100);
        SkuItemInfoVO r102 = (SkuItemInfoVO) ((LinkedHashMap) this.f23575a).get(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getImageUrl();
    }

    public final Long k(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r101 = i(r100);
        SkuItemInfoVO r102 = (SkuItemInfoVO) ((LinkedHashMap) this.f23575a).get(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r102.getPrice());
    }

    public final SkuLimit l(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r101 = i(r100);
        long r102 = Long.MAX_VALUE;
        if (com.bytedance.android.ec.core.abtest.d.E() == false) goto L11;
        SkuItemInfoVO r103 = (SkuItemInfoVO) ((LinkedHashMap) this.f23575a).get(r101);
        if (r103 != null) goto L7;
        return null;
    L7:
        Long r104 = r103.getUserLimit();
        if (r104 == null) goto L10;
        r102 = r104.longValue();
    L10:
        SkuLimit r105 = new SkuLimit(r102, r103.getUpperLimitToast());
    L19:
        return r105;
    L11:
        SkuItemInfoVO r106 = (SkuItemInfoVO) ((LinkedHashMap) this.f23575a).get(r101);
        if (r106 == null) goto L21;
        Long r107 = r106.getUserLimit();
        if (r107 == null) goto L17;
        r102 = r107.longValue();
    L17:
        r105 = new SkuLimit(r102, r106.getUpperLimitToast());
        goto L19
    L21:
        return this.f23577c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Context r101, Map<String, SkuItemInfoVO> r102, Map<String, String> r103, Map<String, String> r104, SkuLimit r105, SkuLimit r106, String r107) {
        Intrinsics.checkNotNullParameter(r102, "skuInfoMap");
        Intrinsics.checkNotNullParameter(r103, "skuImageMap");
        Intrinsics.checkNotNullParameter(r105, "noSelectedSkuUpperLimit");
        Intrinsics.checkNotNullParameter(r106, "noSelectedSkuLowerLimit");
        this.f23576b = r101;
        this.f23577c = r106;
        this.f23578d = r107;
        int r100 = k.f23590a;
        Intrinsics.checkNotNullParameter(r102, "skuInfoMap");
        Intrinsics.checkNotNullParameter(r103, "skuImageMap");
        Intrinsics.checkNotNullParameter("0", "noneId");
        Intrinsics.checkNotNullParameter("_", "serverLinkSymbol");
        Intrinsics.checkNotNullParameter(r105, "noSkuUpperLimit");
        Intrinsics.checkNotNullParameter(r106, "noSkuLowerLimit");
        LinkedHashMap r108 = new LinkedHashMap();
        Iterator<Map.Entry<String, SkuItemInfoVO>> r109 = r102.entrySet().iterator();
    L4:
        if (r109.hasNext() == false) goto L59;
        Map.Entry<String, SkuItemInfoVO> r110 = r109.next();
        String r111 = r110.getKey();
        SkuItemInfoVO r112 = r110.getValue();
        List<String> r113 = new Regex("_").split(r111, 0);
        if (r113.isEmpty() == true) goto L16;
        ListIterator<String> r114 = r113.listIterator(r113.size());
    L9:
        if (r114.hasPrevious() == false) goto L16;
        if (r114.previous().length() != 0) goto L13;
        boolean r115 = true;
    L14:
        if (r115 == true) goto L9;
        List r116 = CollectionsKt.take(r113, r114.nextIndex() + 1);
    L17:
        Object[] r117 = r116.toArray(new String[0]);
        if (r117 == null) goto L58;
        String[] r118 = (String[]) r117;
        int r119 = r118.length;
        int r120 = 1 << r119;
        int r121 = 0;
    L20:
        if (r121 >= r120) goto L4;
        Object r122 = null;
        String r1010 = null;
        String r123 = "";
        int r124 = 0;
    L22:
        if (r124 >= r119) goto L33;
        if (((r121 >> r124) & 1) != 0) goto L28;
        String r125 = r123 + "0_";
        String r126 = r1010;
    L26:
        r123 = r125;
        r124 = r124 + 1;
        r109 = r109;
        r1010 = r126;
        goto L22
    L28:
        if (r124 != 0) goto L30;
        r126 = r118[0];
    L31:
        r125 = (r123 + r118[r124]) + "_";
        goto L26
    L30:
        r126 = r1010;
        goto L31
    L33:
        Iterator<Map.Entry<String, SkuItemInfoVO>> r127 = r109;
        String r128 = r123.substring(0, r123.length() - 1);
        SkuItemInfoVO r129 = (SkuItemInfoVO) r108.get(r128);
        if (r129 == null) goto L46;
        r129.setStockNum(r129.getStockNum() + r112.getStockNum());
        if (r129.getCanSelect() == true) goto L38;
        r129.setCanSelect(r112.getCanSelect());
    L38:
        SkuStatusDetail r130 = r129.getSkuStatusDetail();
        if (r130 == null) goto L44;
        if (r130.equals(r112.getSkuStatusDetail()) != true) goto L44;
        r122 = r129.getSkuStatusDetail();
    L44:
        r129.setSkuStatusDetail(r122);
        Unit r131 = Unit.INSTANCE;
    L56:
        r121 = r121 + 1;
        r120 = r120;
        r109 = r127;
        goto L20
    L46:
        if (TextUtils.equals(r128, r111) == false) goto L48;
        SkuItemInfoVO r132 = r112;
    L50:
        if (TextUtils.isEmpty(r1010) == true) goto L55;
        String r133 = r1010;
        r132.setImageUrl(r103.get(r133));
        if (r104 == null) goto L54;
        r122 = (String) r104.get(r133);
    L54:
        r132.setBigImageUrl(r122);
    L55:
        r108.put(r128, r132);
        goto L56
    L48:
        SkuItemInfoVO r134 = new SkuItemInfoVO("", r112.getStockNum(), null, -1, -1, null, null, Long.valueOf(r105.getCount()), r106.getCount(), r105.getToast(), r106.getToast(), null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, null, 0, null, 0, null, false, false, null, -1L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1948, -33, 1, null);
        r134.setStockNum(r112.getStockNum());
        r134.setCanSelect(r112.getCanSelect());
        r134.setSkuStatusDetail(r112.getSkuStatusDetail());
        Unit r135 = Unit.INSTANCE;
        r132 = r134;
        goto L50
    L58:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L13:
        r115 = false;
    L16:
        r116 = CollectionsKt.emptyList();
        goto L17
    L59:
        this.f23575a = r108;
    }
}
