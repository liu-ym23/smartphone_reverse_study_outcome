package com.bytedance.android.ec.common.impl.sku.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
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
public final class l1 extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f43250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f43251h;

    public l1(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final void d0(l1 r100) {
        SkuViewModel r101 = r100.f43249f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        long r102 = r101.getCurrentPrice();
        SkuViewModel r103 = r100.f43249f;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        long r104 = r103.getCurrentCount();
        if (r102 > 0) goto L11;
    L16:
        SkuViewModel r105 = r100.f43249f;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        SkuInfoVO r106 = r105.getSkuInfo().a();
        if (r106 == null) goto L22;
        SkuInstallmentItemInfo r107 = r106.getInstallmentInfo();
    L23:
        r100.e0(r107, true);
        return;
    L22:
        r107 = null;
        goto L23
    L11:
        if (r104 <= 0) goto L16;
        SkuViewModel r108 = r100.f43249f;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        r108.getSkuInstallmentInfo();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f43249f = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f43250g = (LinearLayout) Z().b(R.id.ll_sku_installment_info_container).f();
        SkuViewModel r101 = this.f43249f;
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
        SkuViewModel r112 = this.f43249f;
        if (r112 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        if (Intrinsics.areEqual(r112.getSkuParams().getTermCount(), r111.getTermCount()) == false) goto L30;
        SkuViewModel r113 = this.f43249f;
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
        e0(r104, r116);
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
        SkuViewModel r121 = this.f43249f;
        if (r121 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L54:
        r121.getValidInstallmentInfo().b(ECQuickUtilKt.a(Y()), new g1(this));
        SkuViewModel r122 = this.f43249f;
        if (r122 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        r122.getSkuInfo().b(ECQuickUtilKt.a(Y()), new h1(this));
        SkuViewModel r123 = this.f43249f;
        if (r123 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L60:
        r123.m8148getCurrentPrice().b(ECQuickUtilKt.a(Y()), new i1(this));
        SkuViewModel r124 = this.f43249f;
        if (r124 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        r124.m8147getCurrentCount().b(ECQuickUtilKt.a(Y()), new j1(this));
        SkuViewModel r125 = this.f43249f;
        if (r125 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L66:
        r125.getCurrentAtmosphereStyle().b(ECQuickUtilKt.a(Y()), new k1(this));
        return;
    L37:
        r116 = true;
        goto L38
    L8:
        r104 = null;
        goto L10
    }

    public final void e0(SkuInstallmentItemInfo r110, boolean r111) {
        if (r110 == null) goto L72;
        SkuTermInfo r112 = r110.getTermInfo();
        if (r112 == null) goto L72;
        List<SkuTermInfoItem> r100 = r112.getItemList();
        SkuViewModel r101 = this.f43249f;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        if (Intrinsics.areEqual(r101.getInstallmentOriginalVisibility(), Boolean.TRUE) == false) goto L71;
        Y().d().q(dg.l.class, 0);
        if (TextUtils.isEmpty(r112.getTitle()) == true) goto L14;
        ((TextView) Z().b(R.id.tv_sku_installment_title).f()).setText(r112.getTitle());
    L14:
        if (r100 != null) goto L16;
        r100 = CollectionsKt.emptyList();
    L16:
        SkuViewModel r113 = this.f43249f;
        if (r113 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        int r114 = r113.getCurrentInstallmentIndex();
        if (r100.isEmpty() == false) goto L22;
        h0(false, -1);
    L66:
        if (this.f43251h == true) goto L80;
        this.f43251h = true;
        SkuViewModel r102 = this.f43249f;
        if (r102 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L70:
        SkuViewModel.doSkuEventAction$default(r102, "show_fxh_button_sku", new Pair[0], null, null, null, 28, null);
        return;
    L80:
        return;
    L22:
        int r103 = r100.size();
        LinearLayout r104 = this.f43250g;
        if (r104 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L26:
        if (r103 != r104.getChildCount()) goto L48;
        LinearLayout r105 = this.f43250g;
        if (r105 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L30:
        int r106 = r105.getChildCount();
        int r107 = 0;
    L31:
        if (r107 >= r106) goto L64;
        LinearLayout r108 = this.f43250g;
        if (r108 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L35:
        View r109 = r108.getChildAt(r107);
        if ((r109 instanceof com.bytedance.android.ec.common.impl.sku.view.h) == true) goto L38;
        r109 = null;
    L38:
        com.bytedance.android.ec.common.impl.sku.view.h r115 = (com.bytedance.android.ec.common.impl.sku.view.h) r109;
        if (r115 == null) goto L47;
        SkuTermInfoItem r116 = (SkuTermInfoItem) ListProtector.get(r100, r107);
        SkuViewModel r117 = this.f43249f;
        if (r117 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        List<Integer> r118 = r117.getTermCountList();
        SkuViewModel r119 = this.f43249f;
        if (r119 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L46:
        r115.a(r116, r107, r118, r119);
    L47:
        r107 = r107 + 1;
    L64:
        h0(r111, r114);
        goto L66
    L48:
        Iterator<T> r120 = r100.iterator();
    L50:
        if (r120.hasNext() == false) goto L64;
        SkuTermInfoItem r121 = (SkuTermInfoItem) r120.next();
        LinearLayout r122 = this.f43250g;
        if (r122 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L54:
        SkuViewModel r123 = this.f43249f;
        if (r123 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        com.bytedance.android.ec.common.impl.sku.view.h r124 = new com.bytedance.android.ec.common.impl.sku.view.h(r123, Y().c());
        int r125 = r100.indexOf(r121);
        SkuViewModel r126 = this.f43249f;
        if (r126 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L60:
        List<Integer> r127 = r126.getTermCountList();
        SkuViewModel r128 = this.f43249f;
        if (r128 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        r124.a(r121, r125, r127, r128);
        Unit r129 = Unit.INSTANCE;
        r122.addView(r124);
        goto L50
    L71:
        Y().d().q(dg.l.class, 8);
        return;
    L72:
        Y().d().q(dg.l.class, 8);
    }

    public final void h0(boolean r100, int r101) {
        LinearLayout r102 = this.f43250g;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L5:
        int r103 = r102.getChildCount();
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L14;
        LinearLayout r105 = this.f43250g;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L10:
        View r106 = r105.getChildAt(r104);
        if ((r106 instanceof com.bytedance.android.ec.common.impl.sku.view.h) == false) goto L13;
        ((com.bytedance.android.ec.common.impl.sku.view.h) r106).c(r100, r104, r101, this);
    L13:
        r104 = r104 + 1;
        goto L6
    }
}
