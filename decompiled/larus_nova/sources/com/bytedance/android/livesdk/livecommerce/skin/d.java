package com.bytedance.android.livesdk.livecommerce.skin;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBackgroundElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBaseViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBorderElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBtnUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinImageElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinPriceUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, ? extends AbsECLiveSkinBaseUIConfig> f152976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f152977b;

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer a() {
        ECLiveSkinBaseViewUIConfig r100 = G("find_similar_btn", true);
        int r101 = s.f45717a;
        if (r100 == null) goto L9;
        ECLiveSkinTextElement r102 = r100.getText();
        if (r102 == null) goto L9;
        List<String> r103 = r102.getColor();
        if (r103 == null) goto L9;
        String r104 = (String) CollectionsKt.firstOrNull(r103);
    L10:
        Integer r105 = s.b(r104);
        if (r105 != null) goto L13;
        return null;
    L13:
        return Integer.valueOf(r105.intValue());
    L9:
        r104 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Drawable k() {
        ECLiveSkinBaseViewUIConfig r100 = G("find_similar_btn", true);
        if (r100 == null) goto L5;
        ECLiveSkinBackgroundElement r101 = r100.getBackground();
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return ECLiveSkinBackgroundElement.a.b(ECLiveSkinBackgroundElement.Companion, r101, null, null, 6);
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String t() {
        ECLiveSkinBaseViewUIConfig r100 = G("stepper_sub", true);
        if (r100 == null) goto L7;
        ECLiveSkinImageElement r101 = r100.getImage();
        if (r101 == null) goto L7;
        return r101.getUrl();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer D() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r100 = this.f152976a;
        if (r100 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r101 = r100.get("price_desc");
    L7:
        if ((r101 instanceof ECLiveSkinBaseViewUIConfig) == true) goto L9;
        r101 = null;
    L9:
        ECLiveSkinBaseViewUIConfig r102 = (ECLiveSkinBaseViewUIConfig) r101;
        if (r102 == null) goto L15;
        ECLiveSkinTextElement r103 = r102.getText();
        if (r103 != null) goto L14;
        return null;
    L14:
        return Integer.valueOf(r103.getFontSize());
    L15:
        return null;
    L5:
        r101 = null;
        goto L7
    }

    public final ECLiveSkinBaseViewUIConfig H() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r100 = this.f152976a;
        AbsECLiveSkinBaseUIConfig r101 = null;
        if (r100 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r102 = r100.get("explain_banner");
    L7:
        if ((r102 instanceof ECLiveSkinBaseViewUIConfig) == false) goto L11;
        r101 = r102;
    L11:
        return (ECLiveSkinBaseViewUIConfig) r101;
    L5:
        r102 = null;
        goto L7
    }

    public final ECLiveSkinPriceUIConfig I() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r100 = this.f152976a;
        AbsECLiveSkinBaseUIConfig r101 = null;
        if (r100 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r102 = r100.get("origin_price");
    L7:
        if ((r102 instanceof ECLiveSkinPriceUIConfig) == false) goto L11;
        r101 = r102;
    L11:
        return (ECLiveSkinPriceUIConfig) r101;
    L5:
        r102 = null;
        goto L7
    }

    public final ECLiveSkinPriceUIConfig J() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r100 = this.f152976a;
        AbsECLiveSkinBaseUIConfig r101 = null;
        if (r100 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r102 = r100.get("price");
    L7:
        if ((r102 instanceof ECLiveSkinPriceUIConfig) == false) goto L11;
        r101 = r102;
    L11:
        return (ECLiveSkinPriceUIConfig) r101;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final int e() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r100 = this.f152976a;
        AbsECLiveSkinBaseUIConfig r101 = null;
        if (r100 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r102 = r100.get("buy_btn");
    L7:
        if ((r102 instanceof ECLiveSkinBtnUIConfig) == false) goto L10;
        r101 = r102;
    L10:
        ECLiveSkinBtnUIConfig r103 = (ECLiveSkinBtnUIConfig) r101;
        if (r103 != null) goto L13;
        return 0;
    L13:
        ECLiveSkinBaseViewUIConfig r104 = r103.getEnabled();
        if (r104 == null) goto L19;
        ECLiveSkinTextElement r105 = r104.getText();
        if (r105 != null) goto L18;
        return 0;
    L18:
        return r105.getFontSize();
    L19:
        return 0;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer f() {
        int r100 = s.f45717a;
        ECLiveSkinBaseViewUIConfig r101 = G("buy_btn", true);
        if (r101 == null) goto L9;
        ECLiveSkinTextElement r102 = r101.getText();
        if (r102 == null) goto L9;
        List<String> r103 = r102.getColor();
        if (r103 == null) goto L9;
        String r104 = (String) CollectionsKt.firstOrNull(r103);
    L11:
        return s.b(r104);
    L9:
        r104 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Drawable l() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r100 = this.f152976a;
        List<String> r101 = null;
        if (r100 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r102 = r100.get("explain_bg");
    L7:
        if ((r102 instanceof ECLiveSkinBaseViewUIConfig) == true) goto L9;
        r102 = null;
    L9:
        ECLiveSkinBaseViewUIConfig r103 = (ECLiveSkinBaseViewUIConfig) r102;
        if (r103 == null) goto L64;
        int r104 = j.f152978a;
        ECLiveSkinBackgroundElement r105 = r103.getBackground();
        ECLiveSkinBorderElement r106 = r103.getBorder();
        List<Integer> r107 = r103.getRadius();
        if (r105 != null) goto L15;
        if (r106 != null) goto L15;
        return null;
    L15:
        GradientDrawable r108 = new GradientDrawable();
        if (r107 == null) goto L27;
        List<Integer> r109 = r107;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r111 = r109.iterator();
    L19:
        if (r111.hasNext() == false) goto L22;
        r110.add(Float.valueOf(UtilityKotlinExtentionsKt.c(Float.valueOf(((Number) r111.next()).intValue()))));
        goto L19
    L22:
        if (r110.size() != 4) goto L24;
        r108.setCornerRadii(CollectionsKt.toFloatArray(r110));
        goto L27
    L24:
        Float r112 = (Float) CollectionsKt.firstOrNull(r110);
        if (r112 == null) goto L27;
        r108.setCornerRadius(r112.floatValue());
    L27:
        if (r105 == null) goto L48;
        List<String> r113 = r105.getColor();
        if (r113 == null) goto L48;
        if ((!r113.isEmpty()) == false) goto L33;
        r101 = r113;
    L33:
        if (r101 == null) goto L48;
        ArrayList r114 = new ArrayList();
        Iterator<T> r115 = r101.iterator();
    L36:
        if (r115.hasNext() == false) goto L41;
        Integer r116 = s.b((String) r115.next());
        if (r116 == null) goto L36;
        r114.add(Integer.valueOf(r116.intValue()));
        goto L36
    L41:
        if (r114.size() != 1) goto L46;
        Integer r117 = (Integer) CollectionsKt.firstOrNull(r114);
        if (r117 == null) goto L48;
        r108.setColor(r117.intValue());
        goto L48
    L46:
        if (r114.size() <= 1) goto L48;
        r108.setColors(CollectionsKt.toIntArray(r114));
        r108.setGradientType(0);
        r108.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
    L48:
        if (r106 == null) goto L57;
        List<String> r118 = r106.getColor();
        if (r118 == null) goto L57;
        String r119 = (String) CollectionsKt.firstOrNull(r118);
        if (r119 == null) goto L57;
        Integer r120 = s.b(r119);
        if (r120 == null) goto L57;
        r108.setStroke((int) UtilityKotlinExtentionsKt.c(Float.valueOf(r106.getBorderWidth())), r120.intValue());
    L57:
        return r108;
    L64:
        return null;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Boolean p() {
        return Boolean.valueOf(this.f152977b.contains("instant_add_cart_large_size"));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer u() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r100 = this.f152976a;
        if (r100 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r101 = r100.get("stepper_count");
    L7:
        if ((r101 instanceof ECLiveSkinBaseViewUIConfig) == true) goto L9;
        r101 = null;
    L9:
        ECLiveSkinBaseViewUIConfig r102 = (ECLiveSkinBaseViewUIConfig) r101;
        if (r102 != null) goto L12;
        return null;
    L12:
        ECLiveSkinTextElement r103 = r102.getText();
        if (r103 != null) goto L15;
        return null;
    L15:
        return Integer.valueOf(r103.getFontSize());
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final List<Integer> v() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r100 = this.f152976a;
        if (r100 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r101 = r100.get("explain_bg");
    L7:
        if ((r101 instanceof ECLiveSkinBaseViewUIConfig) == true) goto L9;
        r101 = null;
    L9:
        ECLiveSkinBaseViewUIConfig r102 = (ECLiveSkinBaseViewUIConfig) r101;
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.getRadius();
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final List<Integer> w() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r100 = this.f152976a;
        if (r100 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r101 = r100.get("buy_btn");
    L7:
        if ((r101 instanceof ECLiveSkinBtnUIConfig) == true) goto L9;
        r101 = null;
    L9:
        ECLiveSkinBtnUIConfig r102 = (ECLiveSkinBtnUIConfig) r101;
        if (r102 != null) goto L13;
        return null;
    L13:
        return r102.getRadius();
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String x() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r100 = this.f152976a;
        if (r100 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r101 = r100.get("price_desc");
    L7:
        if ((r101 instanceof ECLiveSkinBaseViewUIConfig) == true) goto L9;
        r101 = null;
    L9:
        ECLiveSkinBaseViewUIConfig r102 = (ECLiveSkinBaseViewUIConfig) r101;
        if (r102 == null) goto L17;
        ECLiveSkinTextElement r103 = r102.getText();
        if (r103 == null) goto L18;
        List<String> r104 = r103.getColor();
        if (r104 != null) goto L16;
        return null;
    L16:
        return (String) CollectionsKt.firstOrNull(r104);
    L18:
        return null;
    L17:
        return null;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer y() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r100 = this.f152976a;
        if (r100 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r101 = r100.get("stepper_count");
    L7:
        if ((r101 instanceof ECLiveSkinBaseViewUIConfig) == true) goto L9;
        r101 = null;
    L9:
        ECLiveSkinBaseViewUIConfig r102 = (ECLiveSkinBaseViewUIConfig) r101;
        if (r102 != null) goto L12;
        return null;
    L12:
        int r103 = s.f45717a;
        ECLiveSkinTextElement r104 = r102.getText();
        if (r104 == null) goto L17;
        List<String> r105 = r104.getColor();
        if (r105 == null) goto L17;
        String r106 = (String) CollectionsKt.firstOrNull(r105);
    L18:
        Integer r107 = s.b(r106);
        if (r107 != null) goto L21;
        return null;
    L21:
        return Integer.valueOf(r107.intValue());
    L17:
        r106 = null;
        goto L18
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer A() {
        ECLiveSkinPriceUIConfig r100 = I();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getIntegerFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer B() {
        ECLiveSkinPriceUIConfig r100 = I();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getSuffixFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String C() {
        ECLiveSkinPriceUIConfig r100 = I();
        if (r100 == null) goto L7;
        List<String> r101 = r100.getColor();
        if (r101 == null) goto L7;
        return (String) CollectionsKt.firstOrNull(r101);
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer E() {
        ECLiveSkinPriceUIConfig r100 = I();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getYuanTagFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String b() {
        ECLiveSkinBaseViewUIConfig r100 = H();
        if (r100 == null) goto L9;
        ECLiveSkinTextElement r101 = r100.getText();
        if (r101 == null) goto L9;
        List<String> r102 = r101.getColor();
        if (r102 == null) goto L9;
        return (String) CollectionsKt.firstOrNull(r102);
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer c() {
        ECLiveSkinBaseViewUIConfig r100 = H();
        if (r100 == null) goto L7;
        ECLiveSkinTextElement r101 = r100.getText();
        if (r101 == null) goto L7;
        return Integer.valueOf(r101.getFontSize());
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String g() {
        ECLiveSkinPriceUIConfig r100 = J();
        if (r100 == null) goto L7;
        List<String> r101 = r100.getColor();
        if (r101 == null) goto L7;
        return (String) CollectionsKt.firstOrNull(r101);
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer h() {
        ECLiveSkinPriceUIConfig r100 = J();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getPrefixFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer i() {
        ECLiveSkinPriceUIConfig r100 = J();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getYuanTagFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer j() {
        ECLiveSkinPriceUIConfig r100 = J();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getSuffixFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer m() {
        ECLiveSkinPriceUIConfig r100 = J();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getIntegerFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer q() {
        ECLiveSkinPriceUIConfig r100 = I();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getDecimalFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer r() {
        ECLiveSkinPriceUIConfig r100 = I();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getPrefixFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String s() {
        ECLiveSkinBaseViewUIConfig r100 = H();
        if (r100 == null) goto L12;
        ECLiveSkinImageElement r101 = r100.getImage();
        if (r101 == null) goto L12;
        String r102 = r101.getResourceName();
        if (r102 == null) goto L12;
        ECLiveSkinUtil.f152968l.getClass();
        String r103 = ECLiveSkinUtil.f152958b.get(r102);
        if (r103 != null) goto L14;
        return r102;
    L14:
        return r103;
    L12:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer z() {
        ECLiveSkinPriceUIConfig r100 = J();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getDecimalFontSize());
    }

    public d(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "themes");
        this.f152977b = r100;
        ECLiveSkinUtil.f152968l.getClass();
        this.f152976a = ECLiveSkinUtil.f("promotion_card", r100);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer F(boolean r100) {
        ECLiveSkinBaseViewUIConfig r101 = G("add_cart_btn", r100);
        if (r101 == null) goto L7;
        ECLiveSkinImageElement r102 = r101.getImage();
        if (r102 == null) goto L7;
        String r103 = r102.getResourceName();
    L8:
        if (r103 != null) goto L15;
        return null;
    L15:
        ECLiveSkinUtil.f152968l.getClass();     // Catch: Exception -> L12
        return ECLiveSkinUtil.b(r103);
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String d(boolean r100) {
        ECLiveSkinBaseViewUIConfig r101 = G("stepper_add", r100);
        if (r101 == null) goto L7;
        ECLiveSkinImageElement r102 = r101.getImage();
        if (r102 == null) goto L7;
        return r102.getUrl();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Drawable n(boolean r100) {
        ECLiveSkinBaseViewUIConfig r101 = G("buy_btn", r100);
        if (r101 == null) goto L5;
        ECLiveSkinBackgroundElement r102 = r101.getBackground();
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        return ECLiveSkinBackgroundElement.a.b(ECLiveSkinBackgroundElement.Companion, r102, null, null, 6);
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Drawable o(boolean r100) {
        ECLiveSkinBaseViewUIConfig r101 = G("add_cart_btn", r100);
        if (r101 == null) goto L5;
        ECLiveSkinBackgroundElement r102 = r101.getBackground();
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        return ECLiveSkinBackgroundElement.a.b(ECLiveSkinBackgroundElement.Companion, r102, null, null, 6);
    L5:
        r102 = null;
        goto L6
    }

    public final ECLiveSkinBaseViewUIConfig G(String r100, boolean r101) {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r102 = this.f152976a;
        if (r102 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r103 = r102.get(r100);
    L7:
        if ((r103 instanceof ECLiveSkinBtnUIConfig) == true) goto L9;
        r103 = null;
    L9:
        ECLiveSkinBtnUIConfig r104 = (ECLiveSkinBtnUIConfig) r103;
        if (r104 != null) goto L12;
        return null;
    L12:
        if (r101 == false) goto L15;
        return r104.getEnabled();
    L15:
        return r104.getDisabled();
    L5:
        r103 = null;
        goto L7
    }
}
