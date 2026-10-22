package com.bytedance.android.window.shop.widget.product;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.keyframes.model.KFAnimation;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import lq3.d;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0004\fB\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#R+\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u0017R4\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/bytedance/android/window/shop/widget/product/WindowFollowCouponTagView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "<set-?>", "b", "Lkotlin/properties/ReadWriteProperty;", "getLargeMode", "()Z", "setLargeMode", "(Z)V", "largeMode", "Landroid/widget/TextView;", "c", "Lkotlin/Lazy;", "getCouponDescTagView", "()Landroid/widget/TextView;", "couponDescTagView", "d", "getCouponActionDescView", "couponActionDescView", "Landroid/view/View;", "e", "getRecoverView", "()Landroid/view/View;", "recoverView", "Llq3/b;", "Llq3/d;", RXScreenCaptureService.KEY_INDEX, "Llq3/b;", "getFansCouponSceneParam", "()Llq3/b;", "fansCouponSceneParam", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowFollowCouponTagView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f190081j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f190082k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f190083l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f190084m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f190085n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f190086o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f190087p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f190088q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f190089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f190090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f190091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f190092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f190093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ECDraweeView f190094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ECDraweeView f190095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f190096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public lq3.b<d> f190097i;

    public static final class a extends ObservableProperty<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f190098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WindowFollowCouponTagView f190099b;

        public a(Object r100, Object r101, WindowFollowCouponTagView r102) {
            this.f190098a = r100;
            this.f190099b = r102;
            super(r101);
        }

        @Override // kotlin.properties.ObservableProperty
        public final void afterChange(KProperty<?> r100, Boolean r101, Boolean r102) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            boolean r103 = r102.booleanValue();
            if (r101.booleanValue() == r103) goto L10;
            WindowFollowCouponTagView r104 = this.f190099b;
            if (r103 == false) goto L7;
            b r105 = WindowFollowCouponTagView.f190082k;
        L8:
            r104.f190089a = r105;
            WindowFollowCouponTagView.R5(r104);
            return;
        L7:
            r105 = WindowFollowCouponTagView.f190083l;
            goto L8
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f190100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f190101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f190102c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f190103d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f190104e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L16;
            b r101 = (b) r100;
            if (this.f190100a == r101.f190100a) goto L8;
            return false;
        L8:
            if (this.f190101b == r101.f190101b) goto L10;
            return false;
        L10:
            if (Float.compare(this.f190102c, r101.f190102c) == 0) goto L12;
            return false;
        L12:
            if (this.f190103d == r101.f190103d) goto L14;
            return false;
        L14:
            if (this.f190104e == r101.f190104e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            return (((((((this.f190100a * 31) + this.f190101b) * 31) + Float.floatToIntBits(this.f190102c)) * 31) + this.f190103d) * 31) + this.f190104e;
        }

        public final String toString() {
            return "Appearance(leftSideDrawableResId=" + this.f190100a + ", height=" + this.f190101b + ", textSize=" + this.f190102c + ", couponBackgroundColor=" + this.f190103d + ", dashVerticalMargin=" + this.f190104e + ")";
        }

        public b(int r100, int r101, float r102, int r103, int r104) {
            this.f190100a = r100;
            this.f190101b = r101;
            this.f190102c = r102;
            this.f190103d = r103;
            this.f190104e = r104;
        }
    }

    public static final class c {
    }

    static {
        f190081j = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(WindowFollowCouponTagView.class, "largeMode", "getLargeMode()Z", 0))};
        f190082k = new b(R.drawable.ec_window_coupon_follow_left_cut_view_large, 24, 11.0f, 234830674, 4);
        f190083l = new b(R.drawable.ec_window_coupon_follow_left_cut_view_small, 14, 10.0f, 536820562, 0);
        f190084m = ViewCompat.generateViewId();
        f190085n = ViewCompat.generateViewId();
        f190086o = ViewCompat.generateViewId();
        f190087p = ViewCompat.generateViewId();
        f190088q = ViewCompat.generateViewId();
    }

    private final TextView getCouponActionDescView() {
        return (TextView) this.f190092d.getValue();
    }

    private final TextView getCouponDescTagView() {
        return (TextView) this.f190091c.getValue();
    }

    private final View getRecoverView() {
        return (View) this.f190093e.getValue();
    }

    public final boolean getLargeMode() {
        return this.f190090b.getValue(this, f190081j[0]).booleanValue();
    }

    public final void setLargeMode(boolean r100) {
        this.f190090b.setValue(this, f190081j[0], Boolean.valueOf(r100));
    }

    public final lq3.b<d> getFansCouponSceneParam() {
        return this.f190097i;
    }

    public WindowFollowCouponTagView(final Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, null);
        this.f190089a = f190083l;
        Delegates r100 = Delegates.INSTANCE;
        Boolean r101 = Boolean.FALSE;
        this.f190090b = new a(r101, r101, this);
        this.f190091c = LazyKt.lazy(new WindowFollowCouponTagView$couponDescTagView$2(this, r110));
        this.f190092d = LazyKt.lazy(new WindowFollowCouponTagView$couponActionDescView$2(this, r110));
        this.f190093e = LazyKt.lazy(new WindowFollowCouponTagView$recoverView$2(this, r110));
        ECDraweeView r102 = new ECDraweeView(r110, null, 0, 6, null);
        r102.setAdjustMode(1);
        r102.setId(f190084m);
        Unit r103 = Unit.INSTANCE;
        this.f190094f = r102;
        ECDraweeView r104 = new ECDraweeView(r110, null, 0, 6, null);
        r104.setId(f190085n);
        r104.setAdjustMode(1);
        r104.setScaleX(-1.0f);
        this.f190095g = r104;
        FrameLayout r105 = new FrameLayout(r110, null);
        r105.setBackgroundColor(this.f190089a.f190103d);
        CouponVerticalDashView r106 = new CouponVerticalDashView(r110, null);
        r106.setConfig(new CouponVerticalDashView.a(q.a(2), q.a(2), q.a(Double.valueOf(-0.8d))));
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(RangesKt.coerceAtLeast(com.bytedance.android.shopping.extensions.b.b(1), 1), -1);
        int r108 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(this.f190089a.f190104e));
        r107.setMargins(0, r108, 0, r108);
        r107.gravity = 17;
        r105.addView(r106, r107);
        r105.setId(f190088q);
        this.f190096h = r105;
        ImageView r109 = new ImageView(r110);
        r109.setScaleType(ImageView.ScaleType.FIT_XY);
        r109.setImageResource(R.drawable.ec_window_item_coupon_follow_navigate);
        T5(r102);
        ConstraintLayout.LayoutParams r111 = new ConstraintLayout.LayoutParams(-2, -1);
        r111.leftToLeft = 0;
        r111.topToTop = 0;
        r111.bottomToBottom = 0;
        addView(r102, r111);
        T5(r104);
        ConstraintLayout.LayoutParams r112 = new ConstraintLayout.LayoutParams(-2, -1);
        r112.rightToRight = 0;
        r112.topToTop = 0;
        r112.bottomToBottom = 0;
        addView(r104, r112);
        TextView r113 = getCouponDescTagView();
        ConstraintLayout.LayoutParams r114 = new ConstraintLayout.LayoutParams(-2, -1);
        r114.leftToRight = r102.getId();
        r114.topToTop = 0;
        r114.bottomToBottom = 0;
        addView(r113, r114);
        ConstraintLayout.LayoutParams r115 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(10), -1);
        r115.leftToRight = getCouponDescTagView().getId();
        r115.topToTop = 0;
        r115.bottomToBottom = 0;
        addView(r105, r115);
        TextView r116 = getCouponActionDescView();
        ConstraintLayout.LayoutParams r117 = new ConstraintLayout.LayoutParams(-2, -1);
        r117.leftToRight = r105.getId();
        r117.topToTop = 0;
        r117.bottomToBottom = 0;
        addView(r116, r117);
        View r118 = getRecoverView();
        ConstraintLayout.LayoutParams r119 = new ConstraintLayout.LayoutParams(0, -1);
        r119.leftToRight = getCouponActionDescView().getId();
        r119.rightToLeft = r104.getId();
        r119.topToTop = 0;
        r119.bottomToBottom = 0;
        addView(r118, r119);
        ConstraintLayout.LayoutParams r120 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12));
        r120.leftToRight = getCouponActionDescView().getId();
        r120.topToTop = 0;
        r120.bottomToBottom = 0;
        addView(r109, r120);
    }

    public static final void R5(WindowFollowCouponTagView r100) {
        r100.getCouponDescTagView().setBackgroundColor(r100.f190089a.f190103d);
        r100.getCouponDescTagView().setTextSize(1, r100.f190089a.f190102c);
        r100.getCouponActionDescView().setBackgroundColor(r100.f190089a.f190103d);
        r100.getCouponActionDescView().setTextSize(1, r100.f190089a.f190102c);
        r100.getRecoverView().setBackgroundColor(r100.f190089a.f190103d);
        r100.T5(r100.f190094f);
        r100.T5(r100.f190095g);
        r100.f190096h.setBackgroundColor(r100.f190089a.f190103d);
        View r101 = r100.f190096h.getChildAt(0);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L7;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        int r104 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r100.f190089a.f190104e));
        r103.setMargins(0, r104, 0, r104);
        Unit r105 = Unit.INSTANCE;
        r101.setLayoutParams(r103);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void T5(ECDraweeView r100) {
        r100.setAdjustMode(1);
        ImageRequest r101 = ImageRequestBuilder.newBuilderWithResourceId(this.f190089a.f190100a).build();
        r100.setController(Fresco.newDraweeControllerBuilder().setImageRequest(r101).build());
    }

    public final void S5(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "discountMsg");
        Intrinsics.checkNotNullParameter(r101, "actionMsg");
        Intrinsics.checkNotNullParameter(r102, "couponId");
        Intrinsics.checkNotNullParameter(r103, "promotionId");
        getCouponDescTagView().setText(r100);
        getCouponActionDescView().setText(r101);
        this.f190097i = new lq3.b(lq3.c.f510294a, new d(r102, r103));
    }
}
