package com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.base.gamedetail.w0;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.ui.FlowLayout;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.p0;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_list.RecyclerViewItemWidget;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wu.k4;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/OrderGameDetailInfoItemWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/j;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderGameDetailInfoItemWidget extends BaseGameDetailWidget<j> {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f54719z = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f54720o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FlowLayout f54721p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f54722q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f54723r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f54724s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f54725t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f54726u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ShapeDrawable f54727v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Integer f54728w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final w0 f54729x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.h f54730y;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderGameDetailInfoItemWidget f54731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f54732b;

        public a(OrderGameDetailInfoItemWidget r100, int r101) {
            this.f54731a = r100;
            this.f54732b = r101;
        }

        public final void a() {
            float[] r100 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            ShapeDrawable r101 = new ShapeDrawable(new RoundRectShape(r100, new RectF(0.0f, 0.0f, 0.0f, 0.0f), r100));
            r101.getPaint().setColor(this.f54732b);
            View r102 = this.f54731a.f54723r;
            if (r102 == null) goto L5;
            int r103 = r102.getWidth();
        L6:
            View r104 = this.f54731a.f54723r;
            if (r104 == null) goto L9;
            int r105 = r104.getHeight();
        L10:
            r101.setBounds(new Rect(0, 0, r103, r105));
            OrderGameDetailInfoItemWidget r106 = this.f54731a;
            r106.f54727v = r101;
            View r107 = r106.f54722q;
            if (r107 == null) goto L13;
            r107.setBackground(r101);
        L13:
            View r108 = this.f54731a.f54723r;
            if (r108 == null) goto L17;
            r108.setBackground(r101);
            return;
        L17:
            return;
        L9:
            r105 = 136;
            goto L10
        L5:
            r103 = 0;
            goto L6
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

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_audience_game_order_detail_widget;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        ImageView r100 = (ImageView) this.contentView.findViewById(R.id.game_security);
        if (k4.f561340a.getValue().a() == 1) goto L5;
        UtilityKotlinExtentionsKt.h(r100);
    L5:
        this.f54720o = (TextView) this.contentView.findViewById(R.id.tv_game_header_short_additional_desc);
        this.f54721p = (FlowLayout) this.contentView.findViewById(R.id.tags_container);
        this.f54722q = this.contentView.findViewById(R.id.v_game_header_full_bg);
        this.f54723r = this.contentView.findViewById(R.id.cl_game_header_info_container);
        this.f54724s = this.contentView.findViewById(R.id.v_game_header_top_alpha);
        int r101 = this.f54729x.f51676a;
        View r102 = this.f54723r;
        if (r102 == null) goto L8;
        r102.setBackground(y0.e(R.drawable.gamecp_transparent));
    L8:
        View r103 = this.f54723r;
        if (r103 == null) goto L11;
        r103.setPadding(0, r101, 0, 0);
    L11:
        View r104 = this.f54724s;
        if (r104 != null) goto L14;
    L18:
        View r105 = this.f54722q;
        if (r105 == null) goto L23;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L23;
        r106.height = this.f54729x.f51679d;
    L23:
        Integer r107 = this.f54728w;
        if (r107 != null) goto L27;
    L39:
        View r108 = this.f54723r;
        if (r108 == null) goto L43;
        HashMap<String, String> r109 = GamecpTracker.f56755a;
        GamecpTracker.r(r108, "top_pic", MapsKt.mapOf(TuplesKt.to("top_pic_source", 0)), new c(this), false, 112);
        return;
    L43:
        return;
    L27:
        if (r107.intValue() != 1) goto L39;
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r110 = this.f54730y;
        if (r110 == null) goto L35;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r111 = r110.c();
        if (r111 == null) goto L35;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r112 = r111.b();
        if (r112 == null) goto L35;
        int r113 = r112.a(R.color.white);
    L36:
        View r114 = this.f54723r;
        if (r114 == null) goto L39;
        r114.post(new a(this, r113));
    L35:
        r113 = y0.c(R.color.white);
        goto L36
    L14:
        if (this.f54729x.f51678c == false) goto L16;
        int r115 = 0;
    L17:
        r104.setVisibility(r115);
        goto L18
    L16:
        r115 = 8;
        goto L17
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        dr((j) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        dr((j) r100);
    }

    public final void dr(j r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        r.a.c(this, r100, OrderGameDetailInfoItemWidget$onUpdate$1.INSTANCE, new OrderGameDetailInfoItemWidget$onUpdate$2(this));
        r.a.c(this, r100, OrderGameDetailInfoItemWidget$onUpdate$3.INSTANCE, new OrderGameDetailInfoItemWidget$onUpdate$4(this));
        r.a.c(this, r100, OrderGameDetailInfoItemWidget$onUpdate$5.INSTANCE, new OrderGameDetailInfoItemWidget$onUpdate$6(this));
        com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a r101 = r100.f54791h;
        if (r101 == null) goto L29;
        if (TextUtils.isEmpty(r101.d()) == true) goto L41;
        TextView r102 = this.f54720o;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
    L9:
        TextView r103 = this.f54720o;
        if (r103 == null) goto L12;
        r103.setText(r101.d());
    L12:
        Long r104 = r101.a();
        if (r104 == null) goto L18;
        if (r104.longValue() == (-1)) goto L41;
    L18:
        if (TextUtils.isEmpty(r101.b()) == true) goto L41;
        TextView r105 = this.f54720o;
        if (r105 == null) goto L22;
        r105.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.gamecp_game_detail_right_arrow_icon_black, 0);
    L22:
        TextView r106 = this.f54720o;
        if (r106 == null) goto L25;
        r106.setCompoundDrawablePadding(y0.b(4.0f));
    L25:
        TextView r107 = this.f54720o;
        if (r107 == null) goto L41;
        r107.setOnClickListener(new d(this, r101));
    L41:
        r.a.c(this, r100, OrderGameDetailInfoItemWidget$onUpdate$7.INSTANCE, new OrderGameDetailInfoItemWidget$onUpdate$8(this));
        Wo(tt.b.C7771b.f547498a);
        return;
    L29:
        if (TextUtils.isEmpty(r100.f54790g) == true) goto L41;
        String r108 = r100.f54790g;
        Intrinsics.checkNotNull(r108);
        if (r108.length() <= 0) goto L33;
        boolean r109 = true;
    L34:
        if (r109 == false) goto L41;
        TextView r110 = this.f54720o;
        if (r110 == null) goto L38;
        r110.setVisibility(0);
    L38:
        TextView r111 = this.f54720o;
        if (r111 == null) goto L41;
        r111.setText(r108);
        goto L41
    L33:
        r109 = false;
        goto L34
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(p r100) {
        dr((j) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        Intrinsics.checkNotNullParameter((j) r101, "data");
    }

    public OrderGameDetailInfoItemWidget(w0 r100, dt.b r101, com.bytedance.android.gamecp.business.gamedetail.base.model.h r102, Function1<? super RecyclerViewItemWidget<j>, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "uiStyle");
        Integer r104 = null;
        super(null, r103, null, 4);
        this.f54729x = r100;
        this.f54730y = r102;
        if (r101 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        this.f54725t = r105;
        this.f54726u = true ^ p0.a();
        if (r102 == null) goto L15;
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r106 = r102.c();
        if (r106 == null) goto L15;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r107 = r106.b();
        if (r107 == null) goto L15;
        r104 = Integer.valueOf(r107.c());
    L15:
        this.f54728w = r104;
        return;
    L5:
        if (r101.c() != true) goto L7;
        r105 = true;
        goto L8
    }
}
