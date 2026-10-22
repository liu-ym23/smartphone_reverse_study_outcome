package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.elements.CouponButtonElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/CouponButtonElementViewV2;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponButtonElementViewV2 extends RelativeLayout implements ActionHubAccessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CouponButtonElement f167831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextWithOneIconElementView f167832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelativeLayout f167833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f167834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextElementView f167835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SimpleDraweeView f167836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f167837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a f167838h;

    public CouponButtonElementViewV2(Context r100) {
        this(r100, null, 0, 14);
    }

    public CouponButtonElementViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public CouponButtonElementViewV2(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.f167838h;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.f167831a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final void a(final CouponButtonElement r110) {
        this.f167831a = r110;
        if (r110 != null) goto L5;
        return;
    L5:
        TextWithOneIconElement r100 = r110.getPrefix();
        boolean r101 = true;
        String r102 = null;
        if (r100 == null) goto L23;
        TextElement r103 = r100.getContent();
        if (r103 == null) goto L10;
        String r104 = r103.getText();
    L12:
        if (a2.b(r104) == false) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L20;
        TextWithOneIconElement r106 = r100;
    L21:
        if (r106 == null) goto L23;
        TextWithOneIconElementView.b(this.f167832b, r106, null, false, null, 14);
        this.f167832b.setVisibility(0);
        this.f167837g.setVisibility(0);
        this.f167837g.setBackgroundColor(com.bytedance.android.shopping.extensions.a.a(r110.getDividerColor(), ColorProtector.parseColor("#33FE2C55")));
    L24:
        TextWithOneIconElement r107 = r110.getSuffix();
        if (r107 == null) goto L54;
        TextElement r108 = r107.getContent();
        if (r108 == null) goto L29;
        String r109 = r108.getText();
    L31:
        if (a2.b(r109) == false) goto L33;
    L36:
        if (r101 == true) goto L39;
        r107 = null;
    L39:
        if (r107 == null) goto L54;
        TextElement r111 = r107.getContent();
        if (r111 == null) goto L43;
        String r112 = r111.getText();
    L45:
        if (a2.b(r112) == false) goto L48;
        this.f167835e.x(r107.getContent());
        this.f167835e.setVisibility(0);
    L48:
        if (r107.getIcon() == null) goto L50;
        ImageExtensionsKt.d(this.f167836f, r107.getIcon(), null);
        this.f167836f.setVisibility(0);
    L50:
        ExtensionsKt.j(this.f167833c, r107.getBackground());
        FrameLayout r113 = this.f167834d;
        Background r114 = r107.getBackground();
        if (r114 == null) goto L53;
        r102 = r114.getBackgroundColor();
    L53:
        r113.setBackgroundColor(com.bytedance.android.shopping.extensions.a.a(r102, 0));
    L55:
        this.f167833c.addOnLayoutChangeListener(new a(this));
        invalidate();
        setBackground(com.bytedance.commerce.base.drawable.a.a(new CouponButtonElementViewV2$bind$7(r110)));
        Action r115 = r110.getAction();
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r115);
        return;
    L43:
        r112 = null;
        goto L45
    L33:
        if (r107.getIcon() != null) goto L36;
        r101 = false;
        goto L36
    L29:
        r109 = null;
    L54:
        this.f167835e.setVisibility(8);
        this.f167836f.setVisibility(8);
        goto L55
    L20:
        r106 = null;
        goto L21
    L14:
        if (r100.getIcon() != null) goto L17;
        r105 = false;
        goto L18
    L10:
        r104 = null;
    L23:
        this.f167832b.setVisibility(8);
        this.f167837g.setVisibility(8);
        goto L24
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return ActionHubAccessor.DefaultImpls.c(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r100) {
        Intrinsics.checkNotNullParameter(r100, "hub");
        this.f167838h = r100;
    }

    public CouponButtonElementViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f167838h = null;
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_anchor_v4_view_coupon_v2, this, true);
        this.f167832b = (TextWithOneIconElementView) findViewById(R.id.anchor_v4_tv_coupon_prefix_v2);
        this.f167835e = (TextElementView) findViewById(R.id.anchor_v4_tv_coupon_post_v2);
        this.f167833c = (RelativeLayout) findViewById(R.id.anchor_v4_coupon_rl_post);
        this.f167834d = (FrameLayout) findViewById(R.id.anchor_v4_fl_divider);
        this.f167836f = (SimpleDraweeView) findViewById(R.id.anchor_v4_coupon_post_icon_v2);
        this.f167837g = findViewById(R.id.anchor_v4_coupon_divider_v2);
    }
}
