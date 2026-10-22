package com.bytedance.android.livesdk.livecommerce.view.coupon;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.livesdk.livecommerce.utils.x;
import com.bytedance.android.livesdk.livecommerce.view.ECHostDistributeCouponStatusLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sg2.h;
import si2.p;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/coupon/ECNewCouponLayout;", "Lcom/bytedance/android/livesdk/livecommerce/view/coupon/ECNewBaseCouponLayout;", "Lcom/bytedance/android/livesdk/livecommerce/view/coupon/ECNewCouponLayout$a;", "handler", "", "setCouponHandler", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECNewCouponLayout extends ECNewBaseCouponLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Integer, View> f153231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECHostDistributeCouponStatusLayout f153232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f153233d;

    public interface a {
        void a(ECHostDistributeCouponStatusLayout r100);

        void distributeCoupon(p r100);
    }

    public static final class b implements ECHostDistributeCouponStatusLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECNewCouponLayout f153234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f153235b;

        public b(ECNewCouponLayout r100, p r101) {
            this.f153234a = r100;
            this.f153235b = r101;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.view.ECHostDistributeCouponStatusLayout.b
        public final void onClick() {
            a r100 = this.f153234a.f153233d;
            if (r100 == null) goto L5;
            r100.distributeCoupon(this.f153235b);
        L5:
            h r101 = h.a.f541804a;
            r101.f541802d = this.f153235b;
        }
    }

    public ECNewCouponLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECNewCouponLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewBaseCouponLayout
    public final View a(int r100) {
        if (this.f153231b != null) goto L5;
        this.f153231b = new LinkedHashMap();
    L5:
        View r101 = this.f153231b.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f153231b.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewBaseCouponLayout
    public final void b(p r100) {
        Intrinsics.checkNotNullParameter(r100, "ecuiCoupon");
        super.b(r100);
        FrameLayout r101 = (FrameLayout) a(R.id.ec_coupon_btn_container);
        r101.removeAllViews();
        r101.addView(this.f153232c, new FrameLayout.LayoutParams(-1, -1));
        ((RelativeLayout) a(R.id.ec_new_coupon_layout)).setAlpha(1.0f);
        h r102 = h.a.f541804a;
        boolean r103 = false;
        if (r100.f542200l != 1) goto L20;
        this.f153232c.b(getContext().getString(R.string.ec_end_distribute_coupon), true);
        SharedPreferences r104 = x.b(getContext());
        if (r104 != null) goto L7;
    L9:
        if (r103 == true) goto L27;
        a r105 = this.f153233d;
        if (r105 == null) goto L13;
        r105.a(this.f153232c);
    L13:
        SharedPreferences r106 = x.b(getContext());
        if (r106 == null) goto L27;
        if (TextUtils.isEmpty("ec_coupon_end_guide") == true) goto L27;
        SharedPreferences.Editor r107 = r106.edit();
        if (r107 == null) goto L27;
        r107.putBoolean("ec_coupon_end_guide", true);
        r107.apply();
    L27:
        this.f153232c.setDistributeCouponButtonAlpha(1.0f);
        if (r100.f542199k == true) goto L30;
    L31:
        this.f153232c.setDistributeCouponButtonAlpha(0.5f);
    L32:
        this.f153232c.setDistributeClickListener(new b(this, r100));
        return;
    L30:
        if (r100.f542197i != 0) goto L32;
    L7:
        if (TextUtils.isEmpty("ec_coupon_end_guide") == true) goto L9;
        r103 = r104.getBoolean("ec_coupon_end_guide", false);
        goto L9
    L20:
        this.f153232c.setVisibility(0);
        if (r100.f542199k == true) goto L23;
        ECHostDistributeCouponStatusLayout r108 = this.f153232c;
        r108.f153149g = false;
        r108.f153144b.setBackground(null);
        r108.f153144b.setTextColor(r108.f153145c);
        r108.f153144b.setText(R.string.ec_invalid_coupon);
        r108.f153144b.setTypeface(Typeface.DEFAULT_BOLD);
        ((RelativeLayout) a(R.id.ec_new_coupon_layout)).setAlpha(0.6f);
        goto L27
    L23:
        if (r100.f542197i > 0) goto L25;
        ECHostDistributeCouponStatusLayout r109 = this.f153232c;
        r109.f153149g = false;
        r109.f153144b.setBackground(null);
        r109.f153144b.setTextColor(r109.f153146d);
        r109.f153144b.setText(R.string.ec_no_more_coupon_to_distribute);
        r109.f153144b.setTypeface(Typeface.DEFAULT_BOLD);
        ((RelativeLayout) a(R.id.ec_new_coupon_layout)).setAlpha(0.6f);
        goto L27
    L25:
        this.f153232c.b(getContext().getString(R.string.ec_distribute_coupon_immediately), r102.f541803e);
        goto L27
    }

    public final void setCouponHandler(a r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f153233d = r100;
    }

    public ECNewCouponLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f153231b = new LinkedHashMap();
        this.f153232c = new ECHostDistributeCouponStatusLayout(r100);
    }

    public /* synthetic */ ECNewCouponLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
