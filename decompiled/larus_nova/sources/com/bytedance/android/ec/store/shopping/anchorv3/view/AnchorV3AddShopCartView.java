package com.bytedance.android.ec.store.shopping.anchorv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import hl.b;
import hl.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0007J&\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/store/shopping/anchorv3/view/AnchorV3AddShopCartView;", "Landroid/widget/FrameLayout;", "Lhl/d;", "event", "", "onCartCountChangeEvent", "Lhl/b;", "addShopCartSuccessEvent", "", "white", "asBottom", "show", "", "cartProductCount", "update", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorV3AddShopCartView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f48576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f48577b;

    public static final class a {
    }

    static {
    }

    public AnchorV3AddShopCartView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3AddShopCartView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public FrameLayout.LayoutParams a() {
        return new FrameLayout.LayoutParams(-1, -1, 17);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        s0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s0.e(this);
    }

    @Subscribe
    public final void addShopCartSuccessEvent(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.f485615a <= 0) goto L17;
        View r101 = this.f48577b;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        View r102 = this.f48577b;
        if ((r102 instanceof TextView) == true) goto L10;
        r102 = null;
    L10:
        TextView r103 = (TextView) r102;
        if (r103 == null) goto L21;
        int r104 = r100.f485615a;
        if (r104 <= 99) goto L15;
        String r105 = "99+";
    L16:
        r103.setText(r105);
        return;
    L15:
        r105 = String.valueOf(r104);
        goto L16
    L21:
        return;
    L17:
        View r106 = this.f48577b;
        if (r106 == null) goto L23;
        r106.setVisibility(8);
        return;
    }

    @Subscribe
    public final void onCartCountChangeEvent(d r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.f485633a;
        if (r101 <= 0) goto L17;
        View r102 = this.f48577b;
        if (r102 == null) goto L7;
        r102.setVisibility(0);
    L7:
        View r103 = this.f48577b;
        if ((r103 instanceof TextView) == true) goto L10;
        r103 = null;
    L10:
        TextView r104 = (TextView) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        if (r101 <= 99) goto L15;
        String r105 = "99+";
    L16:
        r104.setText(r105);
        return;
    L15:
        r105 = String.valueOf(r101);
        goto L16
    L17:
        View r106 = this.f48577b;
        if (r106 == null) goto L23;
        r106.setVisibility(8);
        return;
    }

    public AnchorV3AddShopCartView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ AnchorV3AddShopCartView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void update(boolean r100, boolean r101, boolean r102, int r110) {
        if (r102 == false) goto L47;
        setVisibility(0);
        int r103 = getChildCount();
        int r104 = R.drawable.anchor_v4_top_right_cart_white;
        if (r103 != 2) goto L25;
        View r105 = getChildAt(0);
        View r111 = getChildAt(1);
        if (r105 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r105, this.f48576a) == false) goto L50;
        if (r111 != null) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r111, this.f48577b) == false) goto L52;
        View r106 = this.f48577b;
        if (r106 == null) goto L16;
        r106.setVisibility(8);
    L16:
        ImageView r107 = this.f48576a;
        if (r107 == null) goto L53;
        if (r101 == false) goto L20;
        r104 = R.drawable.commerce_nav_btn_add_to_cart_22;
    L23:
        r107.setBackgroundResource(r104);
        return;
    L20:
        if (r100 == true) goto L23;
        r104 = R.drawable.anchor_v4_top_right_cart;
        goto L23
    L53:
        return;
    L52:
        return;
    L50:
        return;
    L25:
        removeAllViews();
        ImageView r108 = new ImageView(getContext());
        if (r101 == false) goto L28;
        r104 = R.drawable.commerce_nav_btn_add_to_cart_22;
    L31:
        r108.setBackgroundResource(r104);
        addView(r108, a());
        Unit r109 = Unit.INSTANCE;
        this.f48576a = r108;
        View r112 = LayoutInflater.from(getContext()).inflate(R.layout.shopping_view_add_cart_dot_count_cp, this, false);
        if (r110 <= 0) goto L44;
        r112.setVisibility(0);
        if ((r112 instanceof TextView) == true) goto L36;
        View r113 = null;
    L37:
        TextView r114 = (TextView) r113;
        if (r114 != null) goto L40;
    L45:
        addView(r112);
        this.f48577b = r112;
        return;
    L40:
        if (r110 <= 99) goto L42;
        String r115 = "99+";
    L43:
        r114.setText(r115);
        goto L45
    L42:
        r115 = String.valueOf(r110);
        goto L43
    L36:
        r113 = r112;
        goto L37
    L44:
        r112.setVisibility(8);
        goto L45
    L28:
        if (r100 == true) goto L31;
        r104 = R.drawable.anchor_v4_top_right_cart;
        goto L31
    L47:
        setVisibility(8);
    }
}
