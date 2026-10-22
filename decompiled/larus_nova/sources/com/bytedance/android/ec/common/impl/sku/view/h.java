package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfoItem;
import com.bytedance.android.ec.common.impl.sku.presenter.l1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f43503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f43504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f43505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f43506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f43507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SkuTermInfoItem f43509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Integer> f43510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SkuViewModel f43511i;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f43512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f43513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l1 f43514c;

        public a(h r100, int r101, l1 r102) {
            this.f43512a = r100;
            this.f43513b = r101;
            this.f43514c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f43512a.b(this.f43513b, this.f43514c);
            SkuViewModel.doSkuEventAction$default(this.f43512a.f43511i, "click_fxh_button_sku", new Pair[0], null, null, null, 28, null);
        }
    }

    private final int getAtmosphereColor() {
        Integer r100 = this.f43511i.getCurrentAtmosphereStyle().a();
        if (r100 == null) goto L9;
        if (r100.intValue() == 2) goto L11;
        return ColorProtector.parseColor("#FF3B52");
    L11:
        return ColorProtector.parseColor("#9E2DF5");
    L9:
        return ColorProtector.parseColor("#FF3B52");
    }

    public final boolean getSelectedStatus() {
        return this.f43507e.isSelected();
    }

    private final void setItemSelectBackground(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = getAtmosphereColor();
        GradientDrawable r102 = new GradientDrawable();
        r102.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(4));
        r102.setColor(com.bytedance.android.ec.common.impl.sku.utils.m.a(r101, 0.05f));
        r102.setStroke(vf4.a.b(1), com.bytedance.android.ec.common.impl.sku.utils.m.a(r101, 0.5f));
        this.f43507e.setBackgroundDrawable(r102);
    L5:
        this.f43507e.setSelected(r100);
        return;
    L4:
        this.f43507e.setBackgroundResource(R.drawable.shopping_bg_sku_installment_unselected_opt);
        goto L5
    }

    public final void setSelectedStatus(boolean r100) {
        if (r100 == true) goto L11;
        this.f43504b.setTextColor(th.a.a(getContext(), R.color.shopping_color_161823));
        this.f43504b.setTypeface(Typeface.defaultFromStyle(0));
        SkuTermInfoItem r101 = this.f43509g;
        if (r101 == null) goto L6;
        Boolean r102 = r101.getHighLightFlag();
    L8:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L10;
        this.f43505c.setTextColor(getAtmosphereColor());
    L18:
        setItemSelectBackground(r100);
        return;
    L10:
        this.f43505c.setTextColor(th.a.a(getContext(), R.color.shopping_color_57161823));
        goto L18
    L6:
        r102 = null;
        goto L8
    L11:
        Integer r103 = this.f43511i.getCurrentAtmosphereStyle().a();
        if (r103 != null) goto L15;
    L17:
        this.f43504b.setTextColor(th.a.a(getContext(), R.color.ec_color_pink_fe2c55));
        this.f43505c.setTextColor(th.a.a(getContext(), R.color.ec_color_ff3b52));
        this.f43504b.setTypeface(Typeface.defaultFromStyle(1));
        goto L18
    L15:
        if (r103.intValue() != 2) goto L17;
        this.f43504b.setTextColor(getAtmosphereColor());
        this.f43505c.setTextColor(getAtmosphereColor());
        goto L18
    }

    public h(SkuViewModel r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null, 0);
        this.f43511i = r100;
        View r102 = th.a.c(r101, R.layout.shopping_layout_sku_installment_optimize_item, this, true);
        this.f43503a = r102;
        this.f43504b = (TextView) r102.findViewById(R.id.tv_sku_installment_info_title);
        this.f43505c = (TextView) r102.findViewById(R.id.tv_sku_installment_service_info);
        this.f43506d = (TextView) r102.findViewById(R.id.tv_sku_installment_benefit);
        this.f43507e = r102.findViewById(R.id.cl_sku_installment_item);
        new ArrayList();
    }

    public final void b(int r110, l1 r111) {
        setSelectedStatus(!this.f43507e.isSelected());
        String r100 = null;
        if (this.f43507e.isSelected() == false) goto L67;
        LinearLayout r101 = r111.f43250g;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L7:
        int r102 = r101.getChildCount();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L19;
        if (r110 == r103) goto L18;
        LinearLayout r104 = r111.f43250g;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L13:
        View r105 = r104.getChildAt(r103);
        if ((r105 instanceof h) == false) goto L18;
        h r106 = (h) r105;
        if (r106.getSelectedStatus() == false) goto L18;
        r106.setSelectedStatus(false);
    L18:
        r103 = r103 + 1;
        goto L8
    L19:
        SkuViewModel r107 = r111.f43249f;
        if (r107 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        long r108 = r107.getCurrentPrice();
        SkuViewModel r109 = r111.f43249f;
        if (r109 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        if (r109.getCurrentCount() > 0) goto L28;
    L29:
        SkuViewModel r112 = r111.f43249f;
        if (r112 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L32:
        QLiveData<SkuInfoVO> r113 = r112.getSkuInfo();
        if (r113 == null) goto L43;
        SkuInfoVO r114 = r113.a();
        if (r114 == null) goto L43;
        SkuInstallmentItemInfo r115 = r114.getInstallmentInfo();
        if (r115 == null) goto L43;
        SkuTermInfo r116 = r115.getTermInfo();
        if (r116 == null) goto L43;
        String r117 = r116.getSelectionTip();
        if (r117 == null) goto L43;
        TextView r118 = (TextView) r111.Z().b(R.id.tv_sku_installment_desc).f();
        r118.setText(r117);
        r118.setVisibility(0);
    L43:
        SkuViewModel r119 = r111.f43249f;
        if (r119 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L47:
        if (r110 == r119.getCurrentInstallmentIndex()) goto L63;
        SkuViewModel r120 = r111.f43249f;
        if (r120 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L51:
        SkuInstallmentItemInfo r121 = r120.getValidInstallmentInfo().a();
        if (r121 == null) goto L58;
        SkuTermInfo r122 = r121.getTermInfo();
        if (r122 == null) goto L58;
        List<SkuTermInfoItem> r123 = r122.getItemList();
        if (r123 == null) goto L58;
        SkuTermInfoItem r124 = (SkuTermInfoItem) CollectionsKt.getOrNull(r123, r110);
    L59:
        SkuViewModel r125 = r111.f43249f;
        if (r125 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L62:
        r125.getCurrentDouInstallmentItem().g(r124);
    L58:
        r124 = null;
    L63:
        SkuViewModel r126 = r111.f43249f;
        if (r126 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L66:
        r126.setCurrentInstallmentIndex(r110);
    L75:
        if (this.f43507e.isSelected() == false) goto L84;
        SkuViewModel r127 = this.f43508f;
        if (r127 == null) goto L93;
        SkuTermInfoItem r128 = this.f43509g;
        if (r128 == null) goto L83;
        Integer r129 = r128.getTermCount();
        if (r129 == null) goto L83;
        r100 = String.valueOf(r129.intValue());
    L83:
        r127.setSelectFxhMethod(r100);
        return;
    L93:
        return;
    L84:
        SkuViewModel r130 = this.f43508f;
        if (r130 == null) goto L95;
        r130.setSelectFxhMethod(null);
        return;
    L95:
        return;
    L28:
        if (r108 > 0) goto L43;
    L67:
        SkuViewModel r131 = r111.f43249f;
        if (r131 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L70:
        r131.getCurrentDouInstallmentItem().g(null);
        r111.Z().b(R.id.tv_sku_installment_desc).c();
        SkuViewModel r132 = r111.f43249f;
        if (r132 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L73:
        r132.setCurrentInstallmentIndex(-1);
        goto L75
    }

    public final void a(SkuTermInfoItem r100, int r101, List<Integer> r102, SkuViewModel r110) {
        Intrinsics.checkNotNullParameter(r100, "termInfo");
        Intrinsics.checkNotNullParameter(r102, "termCountList");
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        int r103 = r102.size();
        String r104 = r100.getTermDetail();
        if (r104 == null) goto L5;
        this.f43504b.setText(r104);
    L5:
        String r105 = r100.getServiceLabel();
        if (r105 == null) goto L8;
        this.f43505c.setText(r105);
    L8:
        String r106 = r100.getTopTag();
        if (r106 == null) goto L11;
        this.f43506d.setText(r106);
    L11:
        jg.g.d(this.f43505c, jg.g.a(r100.getServiceLabel()));
        jg.g.d(this.f43506d, Intrinsics.areEqual(r100.getShowTopTag(), Boolean.TRUE));
        if (jg.g.a(r100.getTermDetail()) == false) goto L26;
        String r107 = r100.getServiceLabel();
        if (r107 != null) goto L16;
    L19:
        boolean r108 = true;
    L20:
        if (r108 == false) goto L26;
        TextView r109 = this.f43504b;
        ViewGroup.LayoutParams r111 = r109.getLayoutParams();
        if (r111 == null) goto L25;
        ConstraintLayout.LayoutParams r112 = (ConstraintLayout.LayoutParams) r111;
        r112.topToTop = 0;
        r112.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r112).topMargin = 0;
        Unit r113 = Unit.INSTANCE;
        r109.setLayoutParams(r112);
        goto L26
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L16:
        if (r107.length() == 0) goto L19;
        r108 = false;
    L26:
        ViewGroup.LayoutParams r114 = null;
        if (r101 != 0) goto L36;
        ViewGroup.LayoutParams r115 = this.f43507e.getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == false) goto L32;
        r114 = r115;
    L32:
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r114;
        if (r116 == null) goto L44;
        r116.leftMargin = 0;
    L44:
        this.f43508f = r110;
        this.f43509g = r100;
        this.f43510h = r102;
        setClipChildren(false);
        return;
    L36:
        if (r101 != (r103 - 1)) goto L44;
        ViewGroup.LayoutParams r117 = this.f43507e.getLayoutParams();
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == false) goto L41;
        r114 = r117;
    L41:
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r114;
        if (r118 == null) goto L44;
        r118.rightMargin = 0;
        goto L44
    }

    public final void c(boolean r100, int r101, int r102, l1 r103) {
        Intrinsics.checkNotNullParameter(r103, "installmentInfoPresenter");
        Boolean r104 = null;
        if (r100 == false) goto L11;
        setSelectedStatus(false);
        this.f43507e.setOnClickListener(new a(this, r101, r103));
        TextView r105 = this.f43506d;
        SkuTermInfoItem r106 = this.f43509g;
        if (r106 == null) goto L7;
        r104 = r106.getShowTopTag();
    L7:
        jg.g.d(r105, Intrinsics.areEqual(r104, Boolean.TRUE));
        if (r102 <= (-1)) goto L23;
        if (r102 != r101) goto L24;
        b(r101, r103);
        return;
    L24:
        return;
    L23:
        return;
    L11:
        this.f43507e.setSelected(false);
        this.f43504b.setTextColor(th.a.a(getContext(), R.color.shopping_color_57161823));
        SkuTermInfoItem r107 = this.f43509g;
        if (r107 == null) goto L14;
        Boolean r108 = r107.getHighLightFlag();
    L16:
        if (Intrinsics.areEqual(r108, Boolean.TRUE) == false) goto L18;
        this.f43505c.setTextColor(getAtmosphereColor());
    L19:
        this.f43507e.setBackgroundResource(R.drawable.shopping_bg_sku_installment_disable_opt);
        this.f43506d.setVisibility(8);
        this.f43507e.setOnClickListener(null);
        SkuViewModel r109 = this.f43508f;
        if (r109 == null) goto L26;
        r109.setSelectFxhMethod(null);
        return;
    L26:
        return;
    L18:
        this.f43505c.setTextColor(th.a.a(getContext(), R.color.shopping_color_57161823));
        goto L19
    L14:
        r108 = null;
        goto L16
    }
}
