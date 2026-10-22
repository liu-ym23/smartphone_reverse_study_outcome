package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0005-./01J\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0017\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001d\u0010\u001aJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001e\u0010\u001aJ\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001f\u0010\u001aJ\b\u0010 \u001a\u0004\u0018\u00010\u0003J\b\u0010\"\u001a\u0004\u0018\u00010!J\b\u0010#\u001a\u0004\u0018\u00010\u0003J\u000f\u0010$\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b$\u0010%J\b\u0010&\u001a\u0004\u0018\u00010\u0003J\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'J\u000e\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*¨\u00062"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemGroupLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "", "", "getImageUrlList", "getNameList", "getFirstIdList", "", "getCurrentPosition", "Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemGroupLayout$b;", "checkChangeListener", "", "setCheckedChangeListener", "", "getCheckedIdArray", "()[Ljava/lang/String;", "getCheckedId", "getCheckedSkuId", "getCheckSkuImageUrl", "getCheckSkuBigImageUrl", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;", "getCheckSkuMaxPurchaseCount", "getCheckSkuLeastPurchaseCount", "getLimitText", "", "getRealStock", "()Ljava/lang/Long;", "Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "getCheckSkuCarAdapt", "getCheckSkuPrice", "getCheckSkuOriginPrice", "getCheckSkuDiscountPrice", "getCheckSkuDiscountPriceText", "", "getSelectEPInfo", "getCheckSkuCampaignPriceHeader", "getCheckSkuPriceHedaerStyle", "()Ljava/lang/Integer;", "getNewBonusText", "", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "getSkuBenefitLabel", "Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemGroupLayout$d;", "logger", "setSpecGroupLogEventLogger", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecItemGroupLayout extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f43417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cg.g f43418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f43419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<n> f43420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<View> f43421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f43422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f43423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<String> f43424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<String> f43425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f43426j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f43427k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f43428l;

    public static final class a {
    }

    public interface b {
        void a(String[] r100);
    }

    public interface c {
        List<String> L0();

        cg.g M0();

        List<String> N0();

        List<String> O0();

        List<String> getNameList();
    }

    public interface d {
        void a(int r100);

        void b();
    }

    public interface e {
        n.c getCheckedItemViewInfo();
    }

    static {
    }

    public final String getCheckSkuBigImageUrl() {
        String[] r100 = this.f43419c;
        if (r100 == null) goto L8;
        cg.g r101 = this.f43418b;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        return r101.h(r100);
    L9:
        return null;
    L8:
        return null;
    }

    public final String getCheckSkuCampaignPriceHeader() {
        String[] r100 = this.f43419c;
        if (r100 == null) goto L9;
        cg.g r101 = this.f43418b;
        if (r101 == null) goto L11;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r102 = cg.g.i(r100);
        SkuItemInfoVO r103 = (SkuItemInfoVO) ((LinkedHashMap) r101.f23575a).get(r102);
        if (r103 != null) goto L13;
        return null;
    L13:
        return r103.getCampaignPriceHeader();
    L11:
        return null;
    L9:
        return "";
    }

    public final CarAdaptComponent getCheckSkuCarAdapt() {
        String[] r100 = this.f43419c;
        if (r100 == null) goto L8;
        cg.g r101 = this.f43418b;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.e(r100);
    L8:
        return null;
    }

    public final Long getCheckSkuDiscountPrice() {
        String[] r100 = this.f43419c;
        if (r100 == null) goto L10;
        cg.g r101 = this.f43418b;
        if (r101 == null) goto L11;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r102 = cg.g.i(r100);
        SkuItemInfoVO r103 = (SkuItemInfoVO) ((LinkedHashMap) r101.f23575a).get(r102);
        if (r103 != null) goto L13;
        return null;
    L13:
        return r103.getDiscountPrice();
    L11:
        return null;
    L10:
        return 0L;
    }

    public final String getCheckSkuDiscountPriceText() {
        String[] r100 = this.f43419c;
        if (r100 == null) goto L9;
        cg.g r101 = this.f43418b;
        if (r101 == null) goto L11;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r102 = cg.g.i(r100);
        SkuItemInfoVO r103 = (SkuItemInfoVO) ((LinkedHashMap) r101.f23575a).get(r102);
        if (r103 != null) goto L13;
        return null;
    L13:
        return r103.getDiscountPriceText();
    L11:
        return null;
    L9:
        return "";
    }

    public final String getCheckSkuImageUrl() {
        String[] r100 = this.f43419c;
        if (r100 == null) goto L8;
        cg.g r101 = this.f43418b;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        return r101.j(r100);
    L9:
        return null;
    L8:
        return null;
    }

    public final SkuLimit getCheckSkuLeastPurchaseCount() {
        cg.g r100 = this.f43418b;
        if (r100 == null) goto L23;
        String[] r101 = this.f43419c;
        if (r101 == null) goto L7;
        boolean r102 = true;
    L8:
        SkuLimit r103 = null;
        if (r102 == true) goto L12;
        r100 = null;
    L12:
        if (r100 == null) goto L23;
        Intrinsics.checkNotNull(r101);
        SkuLimit r104 = r100.c(r101);
        if (r104 == null) goto L23;
        if (r104.getCount() < 1) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L21;
        r103 = r104;
    L21:
        if (r103 == null) goto L23;
        return r103;
    L18:
        r105 = false;
        goto L19
    L7:
        r102 = false;
    L23:
        return new SkuLimit(1, th.a.h(getContext(), R.string.shopping_sku_buy_minimum, new Object[]{1}));
    }

    public final SkuLimit getCheckSkuMaxPurchaseCount() {
        cg.g r100 = this.f43418b;
        if (r100 == null) goto L15;
        String[] r101 = this.f43419c;
        if (r101 == null) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L15;
        Intrinsics.checkNotNull(r101);
        SkuLimit r103 = r100.l(r101);
        if (r103 == null) goto L15;
        return r103;
    L7:
        r102 = false;
    L15:
        return new SkuLimit(Long.MAX_VALUE, th.a.h(getContext(), R.string.shopping_sku_buy_maximum, new Object[]{Long.MAX_VALUE}));
    }

    public final Long getCheckSkuOriginPrice() {
        String[] r100 = this.f43419c;
        if (r100 == null) goto L10;
        cg.g r101 = this.f43418b;
        if (r101 == null) goto L11;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r102 = cg.g.i(r100);
        SkuItemInfoVO r103 = (SkuItemInfoVO) ((LinkedHashMap) r101.f23575a).get(r102);
        if (r103 != null) goto L13;
        return null;
    L13:
        return r103.getMarketPrice();
    L11:
        return null;
    L10:
        return 0L;
    }

    public final Long getCheckSkuPrice() {
        String[] r100 = this.f43419c;
        if (r100 == null) goto L9;
        cg.g r101 = this.f43418b;
        if (r101 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        return r101.k(r100);
    L7:
        return null;
    L9:
        return 0L;
    }

    public final Integer getCheckSkuPriceHedaerStyle() {
        String[] r100 = this.f43419c;
        if (r100 == null) goto L9;
        cg.g r101 = this.f43418b;
        if (r101 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        return r101.d(r100);
    L7:
        return null;
    L9:
        return -1;
    }

    public final String getCheckedId() {
        String[] r100 = this.f43419c;
        if (r100 != null) goto L5;
    L7:
        return null;
    L5:
        if (this.f43418b == null) goto L7;
        Intrinsics.checkNotNull(r100);
        return cg.g.b(r100);
    }

    public final String getCheckedSkuId() {
        cg.g r100 = this.f43418b;
        String r101 = null;
        if (r100 == null) goto L15;
        String[] r102 = this.f43419c;
        if (r102 == null) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L15;
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNullParameter(r102, "idArray");
        SkuItemInfoVO r104 = (SkuItemInfoVO) ((LinkedHashMap) r100.f23575a).get(cg.g.i(r102));
        if (r104 == null) goto L15;
        r101 = r104.getId();
        goto L15
    L7:
        r103 = false;
    L15:
        if (r101 != null) goto L18;
        return "";
    L18:
        return r101;
    }

    public final int getCurrentPosition() {
        String[] r100 = this.f43419c;
        if (r100 != null) goto L5;
        return -1;
    L5:
        if (r100[0] != null) goto L7;
        return 0;
    L7:
        List<String> r101 = this.f43426j;
        if (r101 == null) goto L20;
        int r102 = r101.size();
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L21;
        if (TextUtils.equals(r100[0], (CharSequence) ListProtector.get(r101, r103)) == true) goto L14;
        r103 = r103 + 1;
        goto L10
    L14:
        return r103 + 1;
    L21:
        return -1;
    L20:
        return -1;
    }

    public final List<String> getImageUrlList() {
        List<String> r100 = this.f43424h;
        if ((!r100.isEmpty()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L8;
        return r100;
    L8:
        return this.f43423g;
    }

    public final String getLimitText() {
        cg.g r100 = this.f43418b;
        if (r100 == null) goto L26;
        String[] r101 = this.f43419c;
        boolean r102 = false;
        if (r101 == null) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L26;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "idArray");
        SkuItemInfoVO r104 = (SkuItemInfoVO) ((LinkedHashMap) r100.f23575a).get(cg.g.i(r101));
        if (r104 == null) goto L15;
        String r105 = r104.getLimitText();
    L16:
        if (r105 == null) goto L26;
        if (r105.length() <= 0) goto L20;
        r102 = true;
    L20:
        if (r102 == true) goto L23;
        r105 = null;
    L23:
        if (r105 == null) goto L26;
        return r105;
    L15:
        r105 = null;
        goto L16
    L7:
        r103 = false;
    L26:
        cg.g r106 = this.f43418b;
        if (r106 != null) goto L29;
        return null;
    L29:
        return r106.f23578d;
    }

    public final String getNewBonusText() {
        String[] r100 = this.f43419c;
        if (r100 == null) goto L9;
        cg.g r101 = this.f43418b;
        if (r101 == null) goto L11;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r102 = cg.g.i(r100);
        SkuItemInfoVO r103 = (SkuItemInfoVO) ((LinkedHashMap) r101.f23575a).get(r102);
        if (r103 != null) goto L13;
        return null;
    L13:
        return r103.getNewBonusText();
    L11:
        return null;
    L9:
        return "";
    }

    public final Long getRealStock() {
        String[] r100 = this.f43419c;
        if (r100 == null) goto L8;
        cg.g r101 = this.f43418b;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f(r100);
    L8:
        return null;
    }

    public final Object getSelectEPInfo() {
        String[] r100 = this.f43419c;
        if (r100 == null) goto L9;
        cg.g r101 = this.f43418b;
        if (r101 == null) goto L11;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r100, "idArray");
        String r102 = cg.g.i(r100);
        SkuItemInfoVO r103 = (SkuItemInfoVO) ((LinkedHashMap) r101.f23575a).get(r102);
        if (r103 != null) goto L13;
        return null;
    L13:
        return r103.getEpInfo();
    L11:
        return null;
    L9:
        return "";
    }

    public final List<PromotionBenefitLabel> getSkuBenefitLabel() {
        cg.g r100 = this.f43418b;
        if (r100 == null) goto L5;
        String[] r101 = this.f43419c;
        Intrinsics.checkNotNull(r101);
        return r100.g(r101);
    L5:
        return null;
    }

    public final String[] getCheckedIdArray() {
        return this.f43419c;
    }

    public final List<String> getFirstIdList() {
        return this.f43426j;
    }

    public final List<String> getNameList() {
        return this.f43425i;
    }

    public final void setCheckedChangeListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "checkChangeListener");
        this.f43422f = r100;
    }

    public final void setSpecGroupLogEventLogger(d r100) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        this.f43427k = r100;
    }

    public SpecItemGroupLayout(Context r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mSkuStockData");
        super(r100, null, 0);
        this.f43428l = r101;
        this.f43417a = r100;
        setOrientation(1);
        this.f43420d = new ArrayList();
        this.f43421e = new ArrayList();
        this.f43423g = new ArrayList();
        this.f43424h = new ArrayList();
        this.f43425i = new ArrayList();
        this.f43426j = new ArrayList();
    }
}
