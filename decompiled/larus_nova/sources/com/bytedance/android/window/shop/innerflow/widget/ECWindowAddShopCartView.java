package com.bytedance.android.window.shop.innerflow.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.extensions.b;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import hl.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/widget/ECWindowAddShopCartView;", "Landroid/widget/FrameLayout;", "", "getProperImage", "Lhl/d;", "event", "", "onCartCountChanged", "Lhl/b;", "onAddToShopCartSuccess", "Landroid/widget/TextView;", "getAndAddDotTextView", "getProductCountLimit", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECWindowAddShopCartView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f189217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f189218b;

    public static final class a {
    }

    static {
    }

    public ECWindowAddShopCartView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECWindowAddShopCartView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getProperImage() {
        return R.drawable.ec_shop_ic_inner_flow_shop_cart;
    }

    public int getProductCountLimit() {
        return 99;
    }

    public FrameLayout.LayoutParams b() {
        return new FrameLayout.LayoutParams(b.b(32), b.b(32), 3);
    }

    public TextView getAndAddDotTextView() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.shopping_view_add_cart_dot_count_cp, this, false);
        addView(r100);
        if (r100 == null) goto L7;
        return (TextView) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
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

    public final String a(int r100) {
        if (r100 <= getProductCountLimit()) goto L6;
        StringBuilder r101 = new StringBuilder();
        r101.append(getProductCountLimit());
        r101.append('+');
        return r101.toString();
    L6:
        return String.valueOf(r100);
    }

    public final void c(int r100) {
        setVisibility(0);
        if (getChildCount() != 2) goto L18;
        View r101 = getChildAt(0);
        View r102 = getChildAt(1);
        if (r101 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r101, this.f189217a) == false) goto L25;
        if (r102 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r102, this.f189218b) == false) goto L27;
        TextView r103 = this.f189218b;
        if (r103 == null) goto L14;
        r103.setVisibility(8);
    L14:
        ImageView r104 = this.f189217a;
        if (r104 == null) goto L28;
        r104.setBackgroundResource(getProperImage());
        return;
    L28:
        return;
    L27:
        return;
    L25:
        return;
    L18:
        removeAllViews();
        ImageView r105 = new ImageView(getContext());
        r105.setScaleType(ImageView.ScaleType.FIT_XY);
        r105.setBackgroundResource(getProperImage());
        addView(r105, b());
        Unit r106 = Unit.INSTANCE;
        this.f189217a = r105;
        TextView r107 = getAndAddDotTextView();
        if (r100 <= 0) goto L21;
        r107.setVisibility(0);
        r107.setText(a(r100));
    L22:
        this.f189218b = r107;
        return;
    L21:
        r107.setVisibility(8);
        goto L22
    }

    @Subscribe
    public final void onAddToShopCartSuccess(hl.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.f485615a <= 0) goto L10;
        TextView r101 = this.f189218b;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        TextView r102 = this.f189218b;
        if (r102 == null) goto L14;
        r102.setText(a(r100.f485615a));
        return;
    L14:
        return;
    L10:
        TextView r103 = this.f189218b;
        if (r103 == null) goto L16;
        r103.setVisibility(8);
        return;
    }

    @Subscribe
    public final void onCartCountChanged(d r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.f485633a;
        if (r101 <= 0) goto L10;
        TextView r102 = this.f189218b;
        if (r102 == null) goto L7;
        r102.setVisibility(0);
    L7:
        TextView r103 = this.f189218b;
        if (r103 == null) goto L14;
        r103.setText(a(r101));
        return;
    L14:
        return;
    L10:
        TextView r104 = this.f189218b;
        if (r104 == null) goto L16;
        r104.setVisibility(8);
        return;
    }

    public ECWindowAddShopCartView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ECWindowAddShopCartView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
