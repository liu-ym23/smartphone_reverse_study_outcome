package com.bytedance.android.livesdk.livecommerce.view.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import si2.p;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/coupon/ECNewAddCouponLayout;", "Lcom/bytedance/android/livesdk/livecommerce/view/coupon/ECNewBaseCouponLayout;", "Lcom/bytedance/android/livesdk/livecommerce/view/coupon/ECNewAddCouponLayout$a;", "handler", "", "setHandler", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECNewAddCouponLayout extends ECNewBaseCouponLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Integer, View> f153224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f153225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f153226d;

    public interface a {
    }

    public ECNewAddCouponLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECNewAddCouponLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f153226d = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewBaseCouponLayout
    public final View a(int r100) {
        if (this.f153224b != null) goto L5;
        this.f153224b = new LinkedHashMap();
    L5:
        View r101 = this.f153224b.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f153224b.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewBaseCouponLayout
    public final void b(final p r100) {
        Intrinsics.checkNotNullParameter(r100, "ecuiCoupon");
        super.b(r100);
        FrameLayout r101 = (FrameLayout) a(R.id.ec_coupon_btn_container);
        r101.removeAllViews();
        r101.addView(this.f153225c, new FrameLayout.LayoutParams(-1, -1));
        final TextView r102 = this.f153225c;
        r102.setTextColor(r102.getContext().getResources().getColor(R.color.ec_color_white));
        r102.setText(r102.getContext().getString(R.string.ec_add));
        r102.setTextSize(1, 12.0f);
        r102.setBackgroundResource(R.drawable.ec_coupon_new_bg);
        r102.setGravity(17);
        r102.setOnClickListener(new ECNewAddCouponLayout$updateInfo$$inlined$apply$lambda$1(r102, this, r100));
    }

    public final void setHandler(a r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f153226d = r100;
    }

    public ECNewAddCouponLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f153224b = new LinkedHashMap();
        this.f153225c = new TextView(r100);
    }

    public /* synthetic */ ECNewAddCouponLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
