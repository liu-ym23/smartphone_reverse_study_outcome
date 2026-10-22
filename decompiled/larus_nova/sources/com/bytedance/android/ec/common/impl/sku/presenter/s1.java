package com.bytedance.android.ec.common.impl.sku.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuDiscountInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfoItem;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class s1 extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f43288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f43289h;

    public s1(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final void d0(s1 r100) {
        SkuViewModel r101 = r100.f43287f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        long r102 = r101.getCurrentPrice();
        SkuViewModel r103 = r100.f43287f;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        long r104 = r103.getCurrentCount();
        if (r102 > 0) goto L11;
    L16:
        SkuViewModel r105 = r100.f43287f;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        SkuInfoVO r106 = r105.getSkuInfo().a();
        if (r106 == null) goto L22;
        SkuInstallmentItemInfo r107 = r106.getInstallmentInfo();
    L23:
        r100.h0(r107, true);
        return;
    L22:
        r107 = null;
        goto L23
    L11:
        if (r104 <= 0) goto L16;
        SkuViewModel r108 = r100.f43287f;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        r108.getSkuInstallmentInfo();
    }

    public static final void e0(s1 r100) {
        SkuViewModel r101 = r100.f43287f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        long r102 = r101.getCurrentCount();
        SkuViewModel r103 = r100.f43287f;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        SkuInstallmentItemInfo r104 = null;
        if (com.bytedance.android.ec.core.utils.a2.b(r103.getSelectedSkuId()) == true) goto L11;
    L36:
        SkuViewModel r105 = r100.f43287f;
        if (r105 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L39:
        SkuInfoVO r106 = r105.getSkuInfo().a();
        if (r106 == null) goto L42;
        r104 = r106.getInstallmentInfo();
    L42:
        r100.h0(r104, true);
        return;
    L11:
        if (r102 <= 0) goto L36;
        SkuViewModel r107 = r100.f43287f;
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        SkuInfoVO r108 = r107.getSkuInfo().a();
        if (r108 == null) goto L20;
        SkuInstallmentItemInfo r109 = r108.getInstallmentInfo();
        if (r109 == null) goto L20;
        SkuTermInfo r110 = r109.getTermInfo();
    L21:
        if (r110 != null) goto L32;
        SkuViewModel r111 = r100.f43287f;
        if (r111 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        SkuInfoVO r112 = r111.getSkuInfo().a();
        if (r112 == null) goto L30;
        SkuInstallmentItemInfo r113 = r112.getInstallmentInfo();
        if (r113 == null) goto L30;
        SkuDiscountInfo r114 = r113.getDiscountInfo();
    L31:
        if (r114 == null) goto L36;
    L30:
        r114 = null;
    L32:
        SkuViewModel r115 = r100.f43287f;
        if (r115 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L35:
        r115.getSkuInstallmentInfo();
        return;
    L20:
        r110 = null;
        goto L21
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f43287f = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f43288g = (LinearLayout) Z().b(R.id.ll_sku_installment_info_container).f();
        SkuViewModel r101 = this.f43287f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r102 = r101.getSkuInfo().a();
        Boolean r103 = null;
        if (r102 == null) goto L8;
        SkuInstallmentItemInfo r104 = r102.getInstallmentInfo();
    L10:
        if (r104 == null) goto L31;
        SkuTermInfo r105 = r104.getTermInfo();
        if (r105 == null) goto L31;
        List<SkuTermInfoItem> r106 = r105.getItemList();
        if (r106 == null) goto L31;
        Iterator<T> r107 = r106.iterator();
        int r108 = 0;
    L17:
        if (r107.hasNext() == false) goto L31;
        Object r109 = r107.next();
        int r110 = r108 + 1;
        if (r108 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        SkuTermInfoItem r111 = (SkuTermInfoItem) r109;
        SkuViewModel r112 = this.f43287f;
        if (r112 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        if (Intrinsics.areEqual(r112.getSkuParams().getTermCount(), r111.getTermCount()) == false) goto L30;
        SkuViewModel r113 = this.f43287f;
        if (r113 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L29:
        r113.setCurrentInstallmentIndex(r108);
    L30:
        r108 = r110;
    L31:
        if (r104 == null) goto L37;
        SkuTermInfo r114 = r104.getTermInfo();
        if (r114 == null) goto L37;
        Boolean r115 = r114.getSelectable();
        if (r115 == null) goto L37;
        boolean r116 = r115.booleanValue();
    L38:
        h0(r104, r116);
        if (r104 == null) goto L44;
        SkuTermInfo r117 = r104.getTermInfo();
        if (r117 == null) goto L44;
        r103 = r117.getSelectable();
    L44:
        if (Intrinsics.areEqual(r103, Boolean.FALSE) == false) goto L51;
        if (r104 == null) goto L51;
        SkuTermInfo r118 = r104.getTermInfo();
        if (r118 == null) goto L51;
        String r119 = r118.getCreditTip();
        if (r119 == null) goto L51;
        TextView r120 = (TextView) Z().b(R.id.tv_sku_installment_desc).f();
        r120.setText(r119);
        r120.setVisibility(0);
    L51:
        SkuViewModel r121 = this.f43287f;
        if (r121 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L54:
        r121.getValidInstallmentInfo().b(ECQuickUtilKt.a(Y()), new m1(this));
        int r122 = qf.a.f532712a;
        SkuViewModel r123 = this.f43287f;
        if (r123 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L58:
        if (qf.a.e.a(r123.getSkuParams()) == true) goto L69;
        SkuViewModel r124 = this.f43287f;
        if (r124 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L62:
        r124.getSkuInfo().b(ECQuickUtilKt.a(Y()), new n1(this));
        SkuViewModel r125 = this.f43287f;
        if (r125 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L65:
        r125.m8148getCurrentPrice().b(ECQuickUtilKt.a(Y()), new o1(this));
        SkuViewModel r126 = this.f43287f;
        if (r126 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L68:
        r126.m8147getCurrentCount().b(ECQuickUtilKt.a(Y()), new p1(this));
        return;
    L69:
        SkuViewModel r127 = this.f43287f;
        if (r127 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L72:
        r127.getOnItemChange().b(ECQuickUtilKt.a(Y()), new q1(this));
        SkuViewModel r128 = this.f43287f;
        if (r128 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L75:
        r128.m8147getCurrentCount().b(ECQuickUtilKt.a(Y()), new r1(this));
        return;
    L37:
        r116 = true;
        goto L38
    L8:
        r104 = null;
        goto L10
    }

    public final void h0(SkuInstallmentItemInfo r110, boolean r111) {
        if (r110 == null) goto L72;
        SkuTermInfo r112 = r110.getTermInfo();
        if (r112 == null) goto L72;
        List<SkuTermInfoItem> r100 = r112.getItemList();
        SkuViewModel r101 = this.f43287f;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        if (Intrinsics.areEqual(r101.getInstallmentOriginalVisibility(), Boolean.TRUE) == false) goto L71;
        Y().d().q(dg.k.class, 0);
        if (TextUtils.isEmpty(r112.getTitle()) == true) goto L14;
        ((TextView) Z().b(R.id.tv_sku_installment_title).f()).setText(r112.getTitle());
    L14:
        if (r100 != null) goto L16;
        r100 = CollectionsKt.emptyList();
    L16:
        SkuViewModel r113 = this.f43287f;
        if (r113 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        int r114 = r113.getCurrentInstallmentIndex();
        if (r100.isEmpty() == false) goto L22;
        i0(false, -1);
    L66:
        if (this.f43289h == true) goto L80;
        this.f43289h = true;
        SkuViewModel r102 = this.f43287f;
        if (r102 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L70:
        SkuViewModel.doSkuEventAction$default(r102, "show_fxh_button_sku", new Pair[0], null, null, null, 28, null);
        return;
    L80:
        return;
    L22:
        int r103 = r100.size();
        LinearLayout r104 = this.f43288g;
        if (r104 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L26:
        if (r103 != r104.getChildCount()) goto L48;
        LinearLayout r105 = this.f43288g;
        if (r105 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L30:
        int r106 = r105.getChildCount();
        int r107 = 0;
    L31:
        if (r107 >= r106) goto L64;
        LinearLayout r108 = this.f43288g;
        if (r108 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L35:
        View r109 = r108.getChildAt(r107);
        if ((r109 instanceof com.bytedance.android.ec.common.impl.sku.view.g) == true) goto L38;
        r109 = null;
    L38:
        com.bytedance.android.ec.common.impl.sku.view.g r115 = (com.bytedance.android.ec.common.impl.sku.view.g) r109;
        if (r115 == null) goto L47;
        SkuTermInfoItem r116 = (SkuTermInfoItem) ListProtector.get(r100, r107);
        SkuViewModel r117 = this.f43287f;
        if (r117 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        List<Integer> r118 = r117.getTermCountList();
        SkuViewModel r119 = this.f43287f;
        if (r119 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L46:
        r115.a(r116, r107, r118, r119);
    L47:
        r107 = r107 + 1;
    L64:
        i0(r111, r114);
        goto L66
    L48:
        Iterator<T> r120 = r100.iterator();
    L50:
        if (r120.hasNext() == false) goto L64;
        SkuTermInfoItem r121 = (SkuTermInfoItem) r120.next();
        LinearLayout r122 = this.f43288g;
        if (r122 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L54:
        SkuViewModel r123 = this.f43287f;
        if (r123 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        com.bytedance.android.ec.common.impl.sku.view.g r124 = new com.bytedance.android.ec.common.impl.sku.view.g(r123, Y().c());
        int r125 = r100.indexOf(r121);
        SkuViewModel r126 = this.f43287f;
        if (r126 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L60:
        List<Integer> r127 = r126.getTermCountList();
        SkuViewModel r128 = this.f43287f;
        if (r128 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        r124.a(r121, r125, r127, r128);
        Unit r129 = Unit.INSTANCE;
        r122.addView(r124);
        goto L50
    L71:
        Y().d().q(dg.k.class, 8);
        return;
    L72:
        Y().d().q(dg.k.class, 8);
    }

    public final void i0(boolean r100, int r101) {
        LinearLayout r102 = this.f43288g;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L5:
        int r103 = r102.getChildCount();
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L14;
        LinearLayout r105 = this.f43288g;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L10:
        View r106 = r105.getChildAt(r104);
        if ((r106 instanceof com.bytedance.android.ec.common.impl.sku.view.g) == false) goto L13;
        ((com.bytedance.android.ec.common.impl.sku.view.g) r106).c(r100, r104, r101, this);
    L13:
        r104 = r104 + 1;
        goto L6
    }
}
