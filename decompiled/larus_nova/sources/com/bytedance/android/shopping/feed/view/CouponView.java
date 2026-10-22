package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.response.anchorv3.CouponUrgeInfo;
import com.bytedance.android.shopping.feed.resourcecard.view.countdownview.CouponCountDownViewV2;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\n\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/CouponView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f175482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECDraweeView f175483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f175484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CouponCountDownViewV2 f175485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f175486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f175487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f175488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f175489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f175490i;

    public static final class a {
    }

    public interface b {
        void a(String r100);

        void b(String r100);
    }

    public static final class c implements com.bytedance.android.shopping.feed.resourcecard.view.countdownview.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CouponView f175491a;

        @Override // com.bytedance.android.shopping.feed.resourcecard.view.countdownview.a
        public final void a() {
            ConstraintLayout r100 = this.f175491a.f175489h;
            if (r100 == null) goto L6;
            r100.setVisibility(8);
            return;
        }

        public c(CouponView r100) {
            this.f175491a = r100;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CouponView f175492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f175493b;

        public d(CouponView r100, SpannableStringBuilder r101) {
            this.f175492a = r100;
            this.f175493b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f175492a.f175490i;
            if (r101 == null) goto L6;
            r101.b(this.f175493b.toString());
            return;
        }
    }

    static {
    }

    public CouponView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CouponView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final SpannableStringBuilder b(String r100) {
        SpannableStringBuilder r101 = new SpannableStringBuilder(getContext().getString(R.string.ec_new_coupon_price, new Object[]{r100}));
        r101.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.ec_inflow_coupon_desc_color_161823)), 0, r101.toString().length(), 33);
        r101.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.ec_inflow_coupon_price_color_FE2C55)), 2, r101.toString().length() - 3, 33);
        return r101;
    }

    public CouponView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_coupon_view, this, true);
        this.f175482a = (TextView) findViewById(R.id.coupon_price_tv);
        this.f175483b = (ECDraweeView) findViewById(R.id.coupon_left_img_dv);
        this.f175486e = (TextView) findViewById(R.id.coupon_right_tv);
        this.f175484c = (TextView) findViewById(R.id.coupon_desc_tv);
        this.f175485d = (CouponCountDownViewV2) findViewById(R.id.coupon_right_count_down);
        this.f175487f = (ImageView) findViewById(R.id.coupon_right_iv);
        this.f175488g = findViewById(R.id.coupon_right_click);
        this.f175489h = (ConstraintLayout) findViewById(R.id.coupon_container_cl);
    }

    public final void a(CouponUrgeInfo r110, boolean r111, b r112) {
        Intrinsics.checkNotNullParameter(r110, "couponUrgeInfo");
        this.f175490i = r112;
        ECDraweeView r100 = this.f175483b;
        if (r100 == null) goto L5;
        h0.d(r100, r110.getBgImg(), new com.bytedance.android.ec.core.imagex.r("ec_goods_feed", "ec_goods_feed_default"), null, null, null, null, 120);
    L5:
        TextView r101 = this.f175482a;
        if (r101 == null) goto L8;
        r101.setText(com.bytedance.android.shopping.extensions.i.a(Long.valueOf(r110.getPrice())));
    L8:
        SpannableStringBuilder r102 = b(com.bytedance.android.shopping.extensions.i.a(Long.valueOf(r110.getPrice())));
        TextView r103 = this.f175484c;
        if (r103 == null) goto L12;
        r103.setText(r102);
    L12:
        if (r110.getExpireTime() == 1) goto L19;
        CouponCountDownViewV2 r104 = this.f175485d;
        if (r104 == null) goto L16;
        r104.setVisibility(0);
    L16:
        CouponCountDownViewV2 r105 = this.f175485d;
        if (r105 == null) goto L19;
        long r106 = r110.getExpireTime();
        c r107 = new c(this);
        r105.f175360e = Long.valueOf(r106);
        r105.f175361f = r107;
        r105.d();
    L19:
        if (r111 == false) goto L29;
        TextView r113 = this.f175486e;
        if (r113 == null) goto L23;
        wg.a.f(r113, 0, 0, 0, 0);
    L23:
        ImageView r114 = this.f175487f;
        if (r114 == null) goto L26;
        r114.setVisibility(0);
    L26:
        View r115 = this.f175488g;
        if (r115 == null) goto L35;
        r115.setOnClickListener(new d(this, r102));
    L35:
        ConstraintLayout r116 = this.f175489h;
        if (r116 != null) goto L38;
        return;
    L38:
        if (r116.getVisibility() != 0) goto L42;
        r112.a(b(com.bytedance.android.shopping.extensions.i.a(Long.valueOf(r110.getPrice()))).toString());
        return;
    L42:
        return;
    L29:
        ImageView r117 = this.f175487f;
        if (r117 == null) goto L32;
        r117.setVisibility(8);
    L32:
        TextView r118 = this.f175486e;
        if (r118 == null) goto L35;
        wg.a.f(r118, 0, 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
        goto L35
    }

    public /* synthetic */ CouponView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
