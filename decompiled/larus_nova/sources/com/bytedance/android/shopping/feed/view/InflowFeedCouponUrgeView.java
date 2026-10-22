package com.bytedance.android.shopping.feed.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.model.response.anchorv3.CouponUrgeInfo;
import com.bytedance.android.ec.model.response.anchorv3.InnerFlowCouponExtra;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.feed.event.t1;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\u000b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InflowFeedCouponUrgeView;", "Landroid/widget/LinearLayout;", "Ln83/j;", "", "getCurrentDate", "", "style", "", "setUrgeViewStyle", "Lkotlin/Function0;", "onCountDownFinish", "setCountDownFinishCallback", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowFeedCouponUrgeView extends LinearLayout implements n83.j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f175511g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f175512h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f175513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l1 f175514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f175515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f175516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f175517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f175518f;

    public static final class a {
        public static final ArrayMap a() {
            Lazy r100 = InflowFeedCouponUrgeView.f175511g;
            return (ArrayMap) InflowFeedCouponUrgeView.f175511g.getValue();
        }

        public a() {
        }
    }

    public static final class b implements l1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InflowFeedCouponUrgeView f175519a;

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onStart() {
        }

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onFinish() {
            InflowFeedCouponUrgeView r100 = this.f175519a;
            Lazy r101 = InflowFeedCouponUrgeView.f175511g;
            r100.d(0);
            InflowFeedCouponUrgeView r102 = this.f175519a;
            r102.getClass();
            ObjectAnimator r103 = ObjectAnimator.ofFloat(r102, LinearLayout.ALPHA, new float[]{1.0f, 0.0f});
            r103.setDuration(200);
            r103.addListener(new h(r102));
            r103.start();
            Function0<Unit> r104 = this.f175519a.f175515c;
            if (r104 == null) goto L6;
            Unit r105 = r104.invoke();
            return;
        }

        public b(InflowFeedCouponUrgeView r100) {
            this.f175519a = r100;
        }

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onTick(long r100) {
            InflowFeedCouponUrgeView r101 = this.f175519a;
            Lazy r102 = InflowFeedCouponUrgeView.f175511g;
            r101.d(r100);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InflowFeedCouponUrgeView f175520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CouponUrgeInfo f175521b;

        public c(InflowFeedCouponUrgeView r100, CouponUrgeInfo r101) {
            this.f175520a = r100;
            this.f175521b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InflowFeedCouponUrgeView.c(this.f175520a, this.f175521b.getCouponMetaId());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public InflowFeedCouponUrgeView(Context r100) {
        this(r100, null, 0, 0, 14);
    }

    public InflowFeedCouponUrgeView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 0, 12);
    }

    public InflowFeedCouponUrgeView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 0, 8);
    }

    @Override // n83.j
    public final InflowFeedCouponUrgeView i() {
        return this;
    }

    static {
        new a();
        f175511g = LazyKt.lazy(InflowFeedCouponUrgeView$Companion$urgeShowCountMap$2.INSTANCE);
        int r100 = pi3.a.f529323a;
        f175512h = com.bytedance.android.ec.sdk.helper.q.f48131a.getString("inner_flow_coupon_urge_last_show_date", "");
    }

    private final String getCurrentDate() {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }

    @Override // n83.j
    public final void b() {
        l1 r100 = this.f175514b;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public final void d(long r100) {
        int r101 = (int) (r100 / ((long) BaseConstants.Time.HOUR));
        long r102 = r100 - ((long) (BaseConstants.Time.HOUR * r101));
        int r103 = (int) (r102 / ((long) 60000));
        long r104 = (r102 - ((long) (60000 * r103))) / ((long) 1000);
        if (this.f175513a != 1) goto L5;
        int r105 = R.string.shopping_inflow_urge_rest_countdown_halfscreen;
    L6:
        this.f175518f.setText(getContext().getString(r105, new Object[]{Integer.valueOf(r101), Integer.valueOf(r103), Long.valueOf(r104)}));
        return;
    L5:
        r105 = R.string.shopping_inflow_urge_rest_countdown_fullscreen;
        goto L6
    }

    @Override // n83.j
    public void setCountDownFinishCallback(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onCountDownFinish");
        this.f175515c = r100;
    }

    public void setUrgeViewStyle(int r100) {
        this.f175513a = r100;
        if (r100 != 1) goto L5;
        int r101 = com.bytedance.android.shopping.extensions.b.b(8);
        setPadding(r101, 0, r101, 0);
        setBackgroundResource(R.drawable.shopping_inflow_bg_urge_view_halfscreen);
        this.f175517e.setTypeface(Typeface.DEFAULT);
        this.f175518f.setTypeface(Typeface.DEFAULT);
        return;
    L5:
        if (r100 != 2) goto L11;
        int r102 = com.bytedance.android.shopping.extensions.b.b(12);
        setPadding(r102, 0, r102, 0);
        setBackgroundResource(R.drawable.shopping_inflow_bg_urge_view_fullscreen);
        this.f175517e.setTypeface(Typeface.DEFAULT_BOLD);
        this.f175518f.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    }

    public static final void c(InflowFeedCouponUrgeView r100, long r101) {
        String r102 = r100.getCurrentDate();
        if ((!Intrinsics.areEqual(r102, f175512h)) == false) goto L5;
        f175512h = r102;
        int r103 = pi3.a.f529323a;
        Intrinsics.checkNotNullParameter(r102, "jsonString");
        com.bytedance.android.ec.sdk.helper.q.f48131a.putString("inner_flow_coupon_urge_last_show_date", r102);
        a.a().clear();
    L5:
        Integer r104 = (Integer) a.a().get(Long.valueOf(r101));
        if (r104 == null) goto L8;
        int r105 = r104.intValue();
    L9:
        a.a().put(Long.valueOf(r101), Integer.valueOf(r105 + 1));
        int r106 = pi3.a.f529323a;
        String r107 = GsonProtectorUtils.toJson(new Gson(), a.a());
        Intrinsics.checkNotNullParameter(r107, "jsonString");
        com.bytedance.android.ec.sdk.helper.q.f48131a.putString("inner_flow_coupon_urge_show_count_map", r107);
        r100.f175516d = true;
        return;
    L8:
        r105 = 0;
        goto L9
    }

    @Override // n83.j
    public final void a(PromotionProductCouponsStruct r110, AnchorV3Param r111) {
        Intrinsics.checkNotNullParameter(r110, "couponInfo");
        InnerFlowCouponExtra r100 = r110.getInnerFlowCouponExtra();
        if (r100 == null) goto L5;
        CouponUrgeInfo r101 = r100.getCouponUrgeInfo();
    L7:
        if (r101 != null) goto L9;
    L50:
        setVisibility(8);
        return;
    L9:
        if (Intrinsics.areEqual(f175512h, getCurrentDate()) == false) goto L16;
        Integer r102 = (Integer) a.a().get(Long.valueOf(r101.getCouponMetaId()));
        if (r102 == null) goto L16;
        if (r102.intValue() <= r101.getShowTimePerDay()) goto L16;
        boolean r103 = false;
    L17:
        if (r103 == false) goto L50;
        long r112 = (r101.getExpireTime() * ((long) 1000)) - System.currentTimeMillis();
        if (r112 > 0) goto L23;
        setVisibility(8);
        return;
    L23:
        setVisibility(0);
        TextView r104 = this.f175517e;
        if (this.f175513a != 1) goto L26;
        String r105 = r101.getDesc();
    L27:
        r104.setText(r105);
        if (r112 >= 259200000) goto L30;
        d(r112);
        l1 r106 = new l1(r112, 1000, new b(this));
        this.f175514b = r106;
        r106.d();
    L32:
        if (this.f175513a != 2) goto L37;
        if (this.f175516d == true) goto L37;
        post(new c(this, r101));
    L37:
        if (this.f175513a != 1) goto L52;
        t1 r107 = new t1();
        if (r111 == null) goto L41;
        String r108 = r111.getProductId();
    L42:
        r107.f174915b = r108;
        r107.f174916c = 1000;
        r107.f174914a = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE;
        if (r111 == null) goto L47;
        AnchorV3PromotionRequestParam r109 = r111.getRequestParam();
        if (r109 == null) goto L47;
        String r113 = r109.getItemId();
    L48:
        r107.f174917d = r113;
        com.bytedance.android.shopping.feed.event.g.c(r107, getContext(), null);
        return;
    L47:
        r113 = null;
        goto L48
    L41:
        r108 = null;
        goto L42
    L52:
        return;
    L30:
        this.f175518f.setText(getContext().getString(R.string.shopping_inflow_urge_rest_days, new Object[]{Integer.valueOf((int) (r112 / ((long) BaseConstants.Time.DAY)))}));
        goto L32
    L26:
        r105 = r101.getDescShort();
    L16:
        r103 = true;
        goto L17
    L5:
        r101 = null;
        goto L7
    }

    public InflowFeedCouponUrgeView(Context r100, AttributeSet r101, int r102, int r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = 1;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f175513a = -1;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(r100).inflate(R.layout.shopping_inflow_urge_view, this);
        this.f175517e = (TextView) findViewById(R.id.urge_desc);
        this.f175518f = (TextView) findViewById(R.id.urge_rest_time);
        setUrgeViewStyle(r103);
        setOnClickListener(new g(r100));
    }
}
