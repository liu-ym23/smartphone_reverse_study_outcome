package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickActivityBtn;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopActivityState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PageProgressBarData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVIActivityTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopActivityState, GiftAction> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f127979m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f127980n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HSImageView f127981o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f127982p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HSImageView f127983q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HSImageView f127984r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ProgressBar f127985s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f127986t;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftMVIActivityTopView f127987a;

        public a(GiftMVIActivityTopView r100) {
            this.f127987a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            GiftMVIActivityTopView r101 = this.f127987a;
            r101.o(new ClickActivityBtn(r101.f127986t));
        }
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        this.f127982p = (TextView) r().findViewById(R.id.sub_text_tv);
        this.f127980n = (TextView) r().findViewById(R.id.title_tv);
        this.f127981o = (HSImageView) r().findViewById(R.id.title_iv);
        this.f127979m = (TextView) r().findViewById(R.id.detail_btn);
        this.f127983q = (HSImageView) r().findViewById(R.id.background_image_view);
        TextView r100 = this.f127979m;
        if (r100 == null) goto L5;
        r100.setOnClickListener(new a(this));
    L5:
        this.f127984r = (HSImageView) r().findViewById(R.id.left_icon_image_view);
        this.f127985s = (ProgressBar) r().findViewById(R.id.progress_bar);
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L6;
        return R.layout.ttlive_gift_activity_top_view_new_framework;
    L6:
        return R.layout.ttlive_gift_activity_top_view;
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVIActivityTopView$bindToParent$1 r101 = GiftMVIActivityTopView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r100, MVIState r101) {
        GiftTopActivityState r102 = (GiftTopActivityState) r101;
        Intrinsics.checkNotNullParameter(r100, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r102, "state");
        r0<GiftTopActivityState, String> r103 = r102.getTitle();
        Object r104 = r100.f41740c.a(r103);
        if (r104 == null) goto L13;
        r100.f41739b.f41563a.invoke(r103);
        String r105 = (String) r104;
        HSImageView r106 = this.f127981o;
        if (r106 == null) goto L7;
        UtilityKotlinExtentionsKt.u(r106);
    L7:
        TextView r107 = this.f127980n;
        if (r107 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r107);
    L10:
        TextView r108 = this.f127980n;
        if (r108 == null) goto L13;
        r108.setText(r105);
    L13:
        r0<GiftTopActivityState, String> r109 = r102.getText();
        Object r110 = r100.f41740c.a(r109);
        if (r110 == null) goto L18;
        r100.f41739b.f41563a.invoke(r109);
        String r111 = (String) r110;
        TextView r112 = this.f127982p;
        if (r112 == null) goto L18;
        r112.setText(r111);
    L18:
        r0<GiftTopActivityState, String> r113 = r102.getButtonText();
        Object r114 = r100.f41740c.a(r113);
        if (r114 == null) goto L23;
        r100.f41739b.f41563a.invoke(r113);
        String r115 = (String) r114;
        TextView r116 = this.f127979m;
        if (r116 == null) goto L23;
        r116.setText(r115);
    L23:
        r0<GiftTopActivityState, py.k> r117 = r102.getTitleImg();
        Object r118 = r100.f41740c.a(r117);
        if (r118 == null) goto L34;
        r100.f41739b.f41563a.invoke(r117);
        py.k r119 = (py.k) r118;
        if ((!Intrinsics.areEqual(r119, GiftTopActivityState.Companion.getDefaultImg())) == false) goto L34;
        TextView r120 = this.f127980n;
        if (r120 == null) goto L30;
        UtilityKotlinExtentionsKt.u(r120);
    L30:
        HSImageView r121 = this.f127981o;
        if (r121 == null) goto L33;
        UtilityKotlinExtentionsKt.w(r121);
    L33:
        ImageLoader.bindImage(this.f127981o, r119, (int) com.bytedance.android.live.revenue.common.i.a(15), (int) com.bytedance.android.live.revenue.common.i.a(91), new b(this));
    L34:
        r0<GiftTopActivityState, py.k> r122 = r102.getBackgroundImg();
        Object r123 = r100.f41740c.a(r122);
        Drawable r124 = null;
        if (r123 == null) goto L47;
        r100.f41739b.f41563a.invoke(r122);
        py.k r125 = (py.k) r123;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == true) goto L39;
        return;
    L39:
        if (this.f127983q != null) goto L42;
        return;
    L42:
        if ((!Intrinsics.areEqual(r125, GiftTopActivityState.Companion.getDefaultImg())) == false) goto L44;
        ImageLoader.bindImage(this.f127983q, r125);
        goto L47
    L44:
        HSImageView r126 = this.f127983q;
        if (r126 == null) goto L47;
        r126.setController(null);
        r126.setBackground(s1.m(R.drawable.ttlive_base_gift_operation_container_bg));
    L47:
        r0<GiftTopActivityState, py.k> r127 = r102.getIconImage();
        Object r128 = r100.f41740c.a(r127);
        int r129 = 0;
        if (r128 == null) goto L62;
        r100.f41739b.f41563a.invoke(r127);
        py.k r130 = (py.k) r128;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L62;
        if (this.f127984r == null) goto L62;
        if ((!Intrinsics.areEqual(r130, GiftTopActivityState.Companion.getDefaultImg())) == false) goto L59;
        HSImageView r131 = this.f127984r;
        if (r131 == null) goto L58;
        r131.setVisibility(0);
    L58:
        float r132 = 32;
        ImageLoader.bindImage(this.f127984r, r130, (int) com.bytedance.android.live.revenue.common.i.a(r132), (int) com.bytedance.android.live.revenue.common.i.a(r132));
        goto L62
    L59:
        HSImageView r133 = this.f127984r;
        if (r133 == null) goto L62;
        r133.setVisibility(8);
    L62:
        r0<GiftTopActivityState, String> r134 = r102.getCurrentPageName();
        Object r135 = r100.f41740c.a(r134);
        if (r135 == null) goto L65;
        r100.f41739b.f41563a.invoke(r134);
        this.f127986t = (String) r135;
    L65:
        r0<GiftTopActivityState, PageProgressBarData> r136 = r102.getProgressBarData();
        Object r137 = r100.f41740c.a(r136);
        if (r137 == null) goto L100;
        r100.f41739b.f41563a.invoke(r136);
        PageProgressBarData r138 = (PageProgressBarData) r137;
        ProgressBar r139 = this.f127985s;
        if (r139 != null) goto L70;
        return;
    L70:
        if (r138.getShow() == true) goto L73;
        r129 = 8;
    L73:
        r139.setVisibility(r129);
        r139.setProgress((int) (100 * r138.getPercentage()));
        int r140 = r138.getColor();
        ProgressBar r141 = this.f127985s;
        if (r141 == null) goto L76;
        Drawable r142 = r141.getProgressDrawable();
    L78:
        if ((r142 instanceof LayerDrawable) == true) goto L80;
        r142 = null;
    L80:
        LayerDrawable r143 = (LayerDrawable) r142;
        if (r143 == null) goto L83;
        Drawable r144 = r143.findDrawableByLayerId(android.R.id.progress);
    L85:
        if ((r144 instanceof ScaleDrawable) == true) goto L87;
        r144 = null;
    L87:
        ScaleDrawable r145 = (ScaleDrawable) r144;
        if (r145 == null) goto L90;
        Drawable r146 = r145.getDrawable();
    L92:
        if ((r146 instanceof GradientDrawable) == false) goto L95;
        r124 = r146;
    L95:
        GradientDrawable r147 = (GradientDrawable) r124;
        if (r147 == null) goto L102;
        r147.setColor(r140);
        return;
    L102:
        return;
    L90:
        r146 = null;
        goto L92
    L83:
        r144 = null;
        goto L85
    L76:
        r142 = null;
        goto L78
    }

    public GiftMVIActivityTopView(Context r100, ViewGroup r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        super(r100, r101);
        this.f127986t = "";
    }
}
