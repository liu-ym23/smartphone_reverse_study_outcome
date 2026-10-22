package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Observer;
import com.bytedance.android.shopping.deepfeed.data.api.Coupon;
import com.bytedance.android.shopping.deepfeed.data.api.CouponData;
import com.bytedance.android.shopping.deepfeed.data.api.CouponMeta;
import com.bytedance.android.shopping.deepfeed.weights.common.DeepFeedCountDownRecView;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductPriceView;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductQcpxTimeView;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductRecommendView;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import he3.e1;
import he3.p0;
import he3.q1;
import he3.r1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductInfoExtraView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductInfoExtraView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProductPriceView f174088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProductTextView f174089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SalesViewContainer f174090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProductRecommendView f174091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProductRecommendView f174092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProductRecommendView f174093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProductRecommendView f174094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ProductRecommendView f174095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ProductRecommendView f174096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DeepFeedProductInfoMarqueeView f174097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ProductQcpxTimeView f174098k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DeepFeedCountDownRecView f174099l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f174100m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public InFeedProductV2 f174101n;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductInfoExtraView f174102a;

        public a(DeepFeedProductInfoExtraView r100) {
            this.f174102a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f174102a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductInfoExtraView f174103a;

        public b(DeepFeedProductInfoExtraView r100) {
            this.f174103a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            uc3.c r111 = (uc3.c) r110;
            CouponData r100 = r111.a();
            Integer r101 = null;
            if (r100 == null) goto L5;
            Coupon r102 = r100.getCoupon();
        L6:
            InFeedProductV2 r103 = this.f174103a.f174101n;
            if (r103 == null) goto L19;
            InFeedProductPackData r104 = r103.getPackData();
            if (r104 == null) goto L19;
            InFeedProductPackDataElements r105 = r104.getElements();
            if (r105 == null) goto L19;
            List<p0> r106 = r105.getProducts();
            if (r106 == null) goto L19;
            p0 r107 = (p0) CollectionsKt.firstOrNull(r106);
            if (r107 == null) goto L19;
            e1 r108 = r107.b();
            if (r108 == null) goto L19;
            String r109 = r108.a();
        L20:
            CouponData r112 = r111.a();
            if (r112 == null) goto L25;
            CouponMeta r113 = r112.getCouponMeta();
            if (r113 == null) goto L25;
            String r114 = r113.getProductId();
        L27:
            if (Intrinsics.areEqual(r109, r114) == false) goto L64;
            if (r102 == null) goto L64;
            if (com.bytedance.android.shopping.deepfeed.utlis.a.g(r102) != true) goto L64;
            this.f174103a.f174098k.setVisibility(0);
            ProductQcpxTimeView r115 = this.f174103a.f174098k;
            r115.getClass();
            CouponData r116 = r111.a();
            if (r116 == null) goto L34;
            Coupon r117 = r116.getCoupon();
        L35:
            if (r116 == null) goto L37;
            CouponMeta r118 = r116.getCouponMeta();
        L38:
            if (r117 == null) goto L40;
            r101 = r117.getStatus();
        L40:
            if (r101 == null) goto L61;
            if (r101.intValue() != 1) goto L61;
            if (r117.getCountDown() == null) goto L61;
            long r119 = 0;
            if (r117.getCountDown().longValue() <= 0) goto L61;
            r115.setVisibility(0);
            if (r118 == null) goto L53;
            Long r120 = r118.getThreshold();
            if (r120 == null) goto L53;
            long r121 = r120.longValue();
        L54:
            long r122 = 100;
            long r123 = r121 / r122;
            if (r118 == null) goto L59;
            Long r124 = r118.getCredit();
            if (r124 == null) goto L59;
            r119 = r124.longValue();
        L59:
            r115.f174211b.setText("满" + r123 + 20943 + (r119 / r122) + " · ");
            r115.f174212c = r117.getCountDown().longValue();
            r115.removeCallbacks(r115.f174213d);
            r115.a();
            r115.postDelayed(r115.f174213d, 1000);
        L53:
            r121 = 0;
        L61:
            if (tc3.f.b() == false) goto L63;
            DeepFeedProductInfoExtraView r125 = this.f174103a;
            InFeedProductV2 r126 = r125.f174101n;
            Intrinsics.checkNotNull(r126);
            r125.V5(r126, MarqueeViewItemType.HAS_QCPX_VIEW);
            return;
        L63:
            this.f174103a.f174099l.setVisibility(8);
            this.f174103a.f174091d.setVisibility(8);
            this.f174103a.f174092e.setVisibility(8);
            return;
        L37:
            r118 = null;
            goto L38
        L34:
            r117 = null;
        L64:
            this.f174103a.f174098k.setVisibility(8);
            if (tc3.f.b() == false) goto L67;
            DeepFeedProductInfoExtraView r127 = this.f174103a;
            InFeedProductV2 r128 = r127.f174101n;
            Intrinsics.checkNotNull(r128);
            r127.V5(r128, MarqueeViewItemType.TWO_REC_REASON_VIEW);
            return;
        L67:
            DeepFeedProductInfoExtraView r129 = this.f174103a;
            InFeedProductV2 r130 = r129.f174101n;
            Intrinsics.checkNotNull(r130);
            r129.S5(r130);
            return;
        L25:
            r114 = null;
        L19:
            r109 = null;
            goto L20
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductInfoExtraView f174104a;

        public c(DeepFeedProductInfoExtraView r100) {
            this.f174104a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f174104a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductInfoExtraView f174105a;

        public d(DeepFeedProductInfoExtraView r100) {
            this.f174105a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f174105a.f174097j.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedProductInfoExtraView f174106a;

        public e(DeepFeedProductInfoExtraView r100) {
            this.f174106a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f174106a.f174097j.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public DeepFeedProductInfoExtraView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepFeedProductInfoExtraView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public static Pair U5(InFeedProductV2 r100) {
        he3.l r101 = r100.getDynamicData().f484842d;
        if (r101 == null) goto L20;
        Map<Long, he3.j> r102 = r101.b();
        if (r102 == null) goto L22;
        Collection<he3.j> r103 = r102.values();
        if (r103 == null) goto L23;
        he3.j r104 = (he3.j) CollectionsKt.firstOrNull(r103);
        if (r104 == null) goto L24;
        he3.i r105 = r104.b();
        if (r105 == null) goto L25;
        String r106 = r104.a();
        if (r106 == null) goto L17;
        Long r107 = StringsKt.toLongOrNull(r106);
        if (r107 == null) goto L17;
        long r108 = r107.longValue();
    L19:
        return TuplesKt.to(r105, Long.valueOf(r108));
    L17:
        r108 = -1;
        goto L19
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L20:
        return null;
    }

    public final void S5(InFeedProductV2 r100) {
        InFeedProductPackData r101 = r100.getPackData();
        if (r101 == null) goto L52;
        InFeedProductPackDataElements r102 = r101.getElements();
        if (r102 == null) goto L53;
        List<p0> r103 = r102.getProducts();
        if (r103 == null) goto L54;
        p0 r104 = (p0) CollectionsKt.firstOrNull(r103);
        if (r104 != null) goto L12;
        return;
    L12:
        if (U5(r100) == null) goto L14;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L19;
        this.f174091d.setVisibility(8);
        this.f174092e.setVisibility(8);
        this.f174098k.setVisibility(8);
        return;
    L19:
        this.f174099l.setVisibility(8);
        r1 r106 = r104.m();
        if (r106 == null) goto L50;
        List<q1> r107 = r106.a();
        if (r107 == null) goto L50;
        if (r107.size() < 2) goto L41;
        r1 r108 = r104.m();
        if (r108 == null) goto L32;
        List<q1> r109 = r108.a();
        if (r109 == null) goto L32;
        q1 r110 = (q1) CollectionsKt.getOrNull(r109, 1);
        if (r110 == null) goto L32;
        this.f174091d.a(r110);
        this.f174091d.setVisibility(0);
    L33:
        r1 r111 = r104.m();
        if (r111 == null) goto L40;
        List<q1> r112 = r111.a();
        if (r112 == null) goto L40;
        q1 r113 = (q1) CollectionsKt.getOrNull(r112, 0);
        if (r113 == null) goto L40;
        this.f174092e.a(r113);
        this.f174092e.setVisibility(0);
        return;
    L40:
        this.f174092e.setVisibility(8);
        return;
    L32:
        this.f174091d.setVisibility(8);
        goto L33
    L41:
        r1 r114 = r104.m();
        if (r114 == null) goto L48;
        List<q1> r115 = r114.a();
        if (r115 == null) goto L48;
        q1 r116 = (q1) CollectionsKt.getOrNull(r115, 0);
        if (r116 == null) goto L48;
        this.f174091d.a(r116);
        this.f174091d.setVisibility(0);
    L49:
        this.f174092e.setVisibility(8);
        return;
    L48:
        this.f174091d.setVisibility(8);
    L50:
        this.f174091d.setVisibility(8);
        this.f174092e.setVisibility(8);
        return;
    L14:
        r105 = false;
        goto L16
    L54:
        return;
    L53:
        return;
    }

    public final void V5(InFeedProductV2 r100, MarqueeViewItemType r101) {
        int r102 = l.f174235a[r101.ordinal()];
        if (r102 != 1) goto L5;
        this.f174097j.setVisibility(8);
        this.f174098k.setVisibility(8);
        post(new c(this));
        return;
    L5:
        if (r102 != 2) goto L7;
        this.f174097j.setVisibility(8);
        this.f174099l.setVisibility(8);
        post(new d(this));
        return;
    L7:
        if (r102 != 3) goto L15;
        this.f174097j.setVisibility(0);
        this.f174093f.setVisibility(0);
        this.f174094g.setVisibility(0);
        this.f174095h.setVisibility(0);
        this.f174096i.setVisibility(0);
        this.f174098k.setVisibility(8);
        this.f174099l.setVisibility(8);
        T5(r100, 0, this.f174093f, this.f174094g);
        T5(r100, 1, this.f174095h, this.f174096i);
        this.f174097j.post(new e(this));
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        int r112 = View.MeasureSpec.getSize(r110);
        Iterator<T> r100 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r101 = 0;
        boolean r102 = false;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r100.hasNext() == false) goto L91;
        Object r105 = r100.next();
        int r106 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r107 = (View) r105;
        if (r107.getVisibility() != 0) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == false) goto L90;
        ViewGroup.LayoutParams r109 = null;
        if ((r107 instanceof DeepFeedCountDownRecView) == false) goto L28;
        DeepFeedCountDownRecView r113 = (DeepFeedCountDownRecView) r107;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == true) goto L19;
        r114 = null;
    L19:
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        int r116 = getPaddingTop() + getPaddingBottom();
        if (r115 == null) goto L22;
        int r117 = r115.topMargin;
    L23:
        int r118 = r116 + r117;
        if (r115 == null) goto L26;
        int r119 = r115.bottomMargin;
    L27:
        r107.measure(View.MeasureSpec.makeMeasureSpec(r112, 0), ViewGroup.getChildMeasureSpec(r111, r118 + r119, r113.getLayoutParams().height));
    L30:
        if ((r107 instanceof DeepFeedProductInfoMarqueeView) == false) goto L63;
        DeepFeedProductInfoMarqueeView r120 = (DeepFeedProductInfoMarqueeView) r107;
        View r121 = r120.f174107a;
        if (r121 == null) goto L35;
        List<View> r122 = com.bytedance.commerce.base.view.b.a(r121);
        if (r122 == null) goto L35;
    L36:
        View r123 = r120.f174108b;
        if (r123 == null) goto L40;
        List<View> r124 = com.bytedance.commerce.base.view.b.a(r123);
        if (r124 == null) goto L40;
    L41:
        Pair r125 = DeepFeedProductInfoMarqueeView.S5(r122, r112, r104, r111);
        int r126 = ((Number) r125.component1()).intValue();
        boolean r127 = ((Boolean) r125.component2()).booleanValue();
        Pair r128 = DeepFeedProductInfoMarqueeView.S5(r124, r112, r104, r111);
        int r129 = ((Number) r128.component1()).intValue();
        boolean r130 = ((Boolean) r128.component2()).booleanValue();
        Integer r131 = Integer.valueOf(Math.max(r126, r129));
        if (r127 == true) goto L46;
        if (r130 == true) goto L46;
        boolean r132 = false;
    L47:
        Pair r133 = TuplesKt.to(r131, Boolean.valueOf(r132));
        int r134 = ((Number) r133.component1()).intValue();
        boolean r135 = ((Boolean) r133.component2()).booleanValue();
        ViewGroup.LayoutParams r136 = r120.getLayoutParams();
        if ((r136 instanceof ViewGroup.MarginLayoutParams) == false) goto L51;
        r109 = r136;
    L51:
        ViewGroup.MarginLayoutParams r137 = (ViewGroup.MarginLayoutParams) r109;
        if (r137 == null) goto L54;
        int r138 = r137.leftMargin;
    L55:
        int r139 = r134 + r138;
        if (r137 == null) goto L58;
        int r140 = r137.rightMargin;
    L59:
        int r141 = r139 + r140;
        if (r135 == false) goto L62;
        r101 = r141;
    L87:
        r104 = r101;
        r102 = true;
        goto L90
    L62:
        r101 = r141;
    L89:
        r104 = r101;
        goto L90
    L58:
        r140 = 0;
        goto L59
    L54:
        r138 = 0;
    L46:
        r132 = true;
    L40:
        r124 = CollectionsKt.emptyList();
    L35:
        r122 = CollectionsKt.emptyList();
        goto L36
    L63:
        ViewGroup.LayoutParams r142 = r107.getLayoutParams();
        if ((r142 instanceof ViewGroup.MarginLayoutParams) == false) goto L67;
        r109 = r142;
    L67:
        ViewGroup.MarginLayoutParams r143 = (ViewGroup.MarginLayoutParams) r109;
        if (r103 != 0) goto L76;
        int r144 = r107.getMeasuredWidth();
        if (r143 == null) goto L72;
        int r145 = r143.leftMargin;
    L73:
        int r146 = r144 + r145;
        if (r143 == null) goto L83;
        int r147 = r143.rightMargin;
    L84:
        int r148 = r146 + r147;
        int r149 = r104 + r148;
        if (r149 <= r112) goto L88;
        r107.setVisibility(8);
        r101 = r149 - r148;
        goto L87
    L88:
        r101 = r149;
    L83:
        r147 = 0;
        goto L84
    L72:
        r145 = 0;
        goto L73
    L76:
        int r150 = r107.getMeasuredWidth();
        if (r143 == null) goto L79;
        int r151 = r143.leftMargin;
    L80:
        r146 = r150 + r151;
        if (r143 == null) goto L83;
        r147 = r143.rightMargin;
        goto L84
    L79:
        r151 = 0;
        goto L80
    L26:
        r119 = 0;
        goto L27
    L22:
        r117 = 0;
        goto L23
    L28:
        r107.measure(View.MeasureSpec.makeMeasureSpec(r112, 0), r111);
    L90:
        r103 = r106;
        goto L4
    L11:
        r108 = false;
        goto L12
    L91:
        setMeasuredDimension(r101, getMeasuredHeight());
        if (r102 == false) goto L99;
        post(new a(this));
        return;
    }

    public DeepFeedProductInfoExtraView(Context r210, AttributeSet r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211, r212);
        AttributeSet r100 = null;
        int r101 = 6;
        int r102 = 0;
        ProductPriceView r103 = new ProductPriceView(r210, null, 6, 0);
        r103.setId(ViewCompat.generateViewId());
        r103.setGravity(80);
        Unit r104 = Unit.INSTANCE;
        this.f174088a = r103;
        ProductTextView r105 = new ProductTextView(r210, null, 6, 0);
        r105.setId(ViewCompat.generateViewId());
        r105.setIncludeFontPadding(false);
        r105.setMaxLines(1);
        com.bytedance.android.shopping.deepfeed.ui.view.a r106 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r105.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r210, 12));
        r105.setTextColor(ColorProtector.parseColor("#FFFF3344"));
        this.f174089b = r105;
        SalesViewContainer r107 = new SalesViewContainer(r210, r100, r101, r102);
        this.f174090c = r107;
        ProductRecommendView r108 = new ProductRecommendView(r210, r100, r101, r102);
        r108.setId(ViewCompat.generateViewId());
        r108.setGravity(17);
        this.f174091d = r108;
        ProductRecommendView r110 = new ProductRecommendView(r210, r100, r101, r102);
        r110.setId(ViewCompat.generateViewId());
        r110.setGravity(17);
        this.f174092e = r110;
        ProductRecommendView r111 = new ProductRecommendView(r210, r100, r101, r102);
        r111.setId(ViewCompat.generateViewId());
        r111.setGravity(17);
        this.f174093f = r111;
        ProductRecommendView r112 = new ProductRecommendView(r210, r100, r101, r102);
        r112.setId(ViewCompat.generateViewId());
        r112.setGravity(17);
        this.f174094g = r112;
        ProductRecommendView r113 = new ProductRecommendView(r210, r100, r101, r102);
        r113.setId(ViewCompat.generateViewId());
        r113.setGravity(17);
        this.f174095h = r113;
        ProductRecommendView r114 = new ProductRecommendView(r210, r100, r101, r102);
        r114.setId(ViewCompat.generateViewId());
        r114.setGravity(17);
        this.f174096i = r114;
        DeepFeedProductInfoMarqueeView r109 = new DeepFeedProductInfoMarqueeView(r210, null);
        r109.setId(ViewCompat.generateViewId());
        this.f174097j = r109;
        ConstraintLayout r115 = new ConstraintLayout(r210);
        r115.setId(ViewCompat.generateViewId());
        r115.setLayoutParams(new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r210, 16)));
        ConstraintLayout r116 = new ConstraintLayout(r210);
        r116.setId(ViewCompat.generateViewId());
        r116.setLayoutParams(new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r210, 16)));
        ProductQcpxTimeView r117 = new ProductQcpxTimeView(r210, null, 6, 0);
        r117.setId(ViewCompat.generateViewId());
        r117.setGravity(17);
        r117.setVisibility(8);
        this.f174098k = r117;
        DeepFeedCountDownRecView r118 = new DeepFeedCountDownRecView(r210, null, 6, 0);
        this.f174099l = r118;
        View r119 = new View(r210);
        r119.setId(ViewCompat.generateViewId());
        r119.setBackgroundColor(ColorProtector.parseColor("#F8F8F8"));
        this.f174100m = r119;
        new b(this);
        ConstraintLayout.LayoutParams r120 = new ConstraintLayout.LayoutParams(-2, -2);
        r120.leftToLeft = 0;
        r120.bottomToBottom = 0;
        r120.rightToLeft = r105.getId();
        addView(r103, r120);
        boolean r121 = tc3.f.d();
        Double r122 = Double.valueOf(0.5d);
        if (r121 == true) goto L5;
        ProductRecommendView r123 = r110;
        SalesViewContainer r124 = r107;
        ConstraintLayout.LayoutParams r125 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 16));
        r125.bottomToBottom = 0;
        r125.leftToRight = r105.getId();
        ((ViewGroup.MarginLayoutParams) r125).leftMargin = com.bytedance.android.shopping.extensions.b.b(4);
        addView(r124, r125);
        if (tc3.f.b() == false) goto L16;
        R5(r115, r111, r112);
        R5(r116, r113, r114);
        r109.R5(r115, r116);
        int r126 = 16;
        int r127 = -2;
        ConstraintLayout.LayoutParams r128 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 16));
        int r129 = 0;
        r128.bottomToBottom = 0;
        r128.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r128).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r109, r128);
        View r130 = r108;
    L17:
        ConstraintLayout.LayoutParams r131 = new ConstraintLayout.LayoutParams(r127, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), r126));
        r131.bottomToBottom = r129;
        r131.rightToRight = r129;
        addView(r117, r131);
        ConstraintLayout.LayoutParams r132 = new ConstraintLayout.LayoutParams(r127, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), r126));
        r132.bottomToBottom = r129;
        r132.leftToRight = r103.getId();
        r132.rightToLeft = r124.getId();
        ((ViewGroup.MarginLayoutParams) r132).leftMargin = com.bytedance.android.shopping.extensions.b.b(2);
        ((ViewGroup.MarginLayoutParams) r132).bottomMargin = com.bytedance.android.shopping.extensions.b.b(r122);
        addView(r105, r132);
        ConstraintLayout.LayoutParams r133 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(180), -2);
        r133.leftToLeft = 0;
        r133.topToTop = 0;
        r133.bottomToBottom = 0;
        addView(r119, r133);
        ConstraintLayout.LayoutParams r134 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 16));
        r134.rightToRight = 0;
        r134.bottomToBottom = 0;
        addView(r118, r134);
    L19:
        if (tc3.f.e() == false) goto L41;
        Integer r135 = tc3.f.c();
        if (r135 != null) goto L25;
    L27:
        Integer r136 = tc3.f.c();
        if (r136 != null) goto L31;
    L33:
        o.a(r124, 20);
        if (tc3.f.b() == true) goto L37;
        o.a(r123, 20);
        o.a(r130, 20);
    L37:
        if (tc3.f.b() == false) goto L40;
        o.a(r109, 20);
        o.a(r115, 20);
        o.a(r116, 20);
        return;
    L40:
        return;
    L31:
        if (r136.intValue() != 2) goto L33;
        o.a(r103, 23);
        goto L33
    L25:
        if (r135.intValue() != 1) goto L27;
        o.a(r103, 29);
        goto L33
    L41:
        return;
    L16:
        ConstraintLayout.LayoutParams r137 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 16));
        r137.bottomToBottom = 0;
        r137.rightToLeft = r108.getId();
        ((ViewGroup.MarginLayoutParams) r137).rightMargin = com.bytedance.android.shopping.extensions.b.b(8);
        ((ViewGroup.MarginLayoutParams) r137).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r123, r137);
        r126 = 16;
        r127 = -2;
        ConstraintLayout.LayoutParams r138 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 16));
        r129 = 0;
        r138.bottomToBottom = 0;
        r138.rightToRight = 0;
        r130 = r108;
        addView(r130, r138);
        goto L17
    L5:
        if (tc3.f.b() == false) goto L7;
        R5(r115, r111, r112);
        R5(r116, r113, r114);
        r109.R5(r115, r116);
        int r139 = -2;
        ConstraintLayout.LayoutParams r140 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 16));
        r140.bottomToBottom = 0;
        r140.leftToRight = r105.getId();
        ((ViewGroup.MarginLayoutParams) r140).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r109, r140);
        r123 = r110;
        int r141 = 0;
        int r142 = 16;
    L8:
        ConstraintLayout.LayoutParams r143 = new ConstraintLayout.LayoutParams(r139, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), r142));
        r143.bottomToBottom = r141;
        r143.rightToRight = r141;
        ((ViewGroup.MarginLayoutParams) r143).leftMargin = com.bytedance.android.shopping.extensions.b.b(4);
        r124 = r107;
        addView(r124, r143);
        ConstraintLayout.LayoutParams r144 = new ConstraintLayout.LayoutParams(r139, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), r142));
        r144.bottomToBottom = 0;
        r144.leftToRight = r105.getId();
        ((ViewGroup.MarginLayoutParams) r144).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r117, r144);
        ConstraintLayout.LayoutParams r145 = new ConstraintLayout.LayoutParams(r139, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), r142));
        r145.bottomToBottom = 0;
        r145.leftToRight = r103.getId();
        if (tc3.f.b() == false) goto L11;
        int r146 = r109.getId();
    L12:
        r145.rightToLeft = r146;
        ((ViewGroup.MarginLayoutParams) r145).leftMargin = com.bytedance.android.shopping.extensions.b.b(2);
        ((ViewGroup.MarginLayoutParams) r145).bottomMargin = com.bytedance.android.shopping.extensions.b.b(r122);
        addView(r105, r145);
        ConstraintLayout.LayoutParams r147 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(180), -2);
        r147.leftToLeft = 0;
        r147.topToTop = 0;
        r147.bottomToBottom = 0;
        addView(r119, r147);
        ConstraintLayout.LayoutParams r148 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 16));
        r148.leftToRight = r105.getId();
        r148.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r148).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r118, r148);
        r130 = r108;
        goto L19
    L11:
        r146 = r123.getId();
        goto L12
    L7:
        ConstraintLayout.LayoutParams r149 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 16));
        r149.bottomToBottom = 0;
        r149.leftToRight = r105.getId();
        r149.rightToLeft = r108.getId();
        ((ViewGroup.MarginLayoutParams) r149).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r123 = r110;
        addView(r123, r149);
        r142 = 16;
        ConstraintLayout.LayoutParams r150 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 16));
        r150.bottomToBottom = 0;
        r150.leftToRight = r123.getId();
        ((ViewGroup.MarginLayoutParams) r150).leftMargin = com.bytedance.android.shopping.extensions.b.b(8);
        addView(r108, r150);
        r141 = 0;
        r139 = -2;
        goto L8
    }

    public final void R5(ConstraintLayout r100, ProductRecommendView r101, ProductRecommendView r102) {
        if (tc3.f.e() == false) goto L5;
        int r103 = 20;
    L6:
        com.bytedance.android.shopping.deepfeed.ui.view.a r104 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        ConstraintLayout.LayoutParams r105 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), r103));
        r105.topToTop = 0;
        r105.bottomToBottom = 0;
        r105.leftToLeft = 0;
        r105.rightToLeft = r101.getId();
        Unit r106 = Unit.INSTANCE;
        r100.addView(r102, r105);
        ConstraintLayout.LayoutParams r107 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), r103));
        r107.topToTop = 0;
        r107.bottomToBottom = 0;
        r107.leftToRight = r102.getId();
        ((ViewGroup.MarginLayoutParams) r107).leftMargin = com.bytedance.android.shopping.extensions.b.b(8);
        r100.addView(r101, r107);
        return;
    L5:
        r103 = 16;
        goto L6
    }

    public final void Y5(InFeedProductV2 r100, com.bytedance.android.shopping.deepfeed.action.h r101, boolean r102) {
        InFeedProductPackData r103 = r100.getPackData();
        if (r103 == null) goto L9;
        InFeedProductPackDataElements r104 = r103.getElements();
        if (r104 == null) goto L9;
        List<p0> r105 = r104.getProducts();
        if (r105 == null) goto L9;
        p0 r106 = (p0) CollectionsKt.firstOrNull(r105);
    L10:
        U5(r100);
        r101.d();
        System.currentTimeMillis();
        if (r106 != null) goto L13;
        this.f174099l.setVisibility(8);
        this.f174091d.setVisibility(8);
        this.f174092e.setVisibility(8);
        return;
    L13:
        if (tc3.f.b() == false) goto L15;
        V5(r100, MarqueeViewItemType.TWO_REC_REASON_VIEW);
    L16:
        this.f174099l.setVisibility(8);
        this.f174090c.setVisibility(0);
        return;
    L15:
        S5(r100);
    L9:
        r106 = null;
        goto L10
    }

    public /* synthetic */ DeepFeedProductInfoExtraView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void T5(InFeedProductV2 r100, int r101, ProductRecommendView r102, ProductRecommendView r103) {
        InFeedProductPackData r104 = r100.getPackData();
        if (r104 == null) goto L52;
        InFeedProductPackDataElements r105 = r104.getElements();
        if (r105 == null) goto L53;
        List<p0> r106 = r105.getProducts();
        if (r106 == null) goto L54;
        p0 r107 = (p0) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L58;
        r1 r108 = r107.m();
        if (r108 == null) goto L27;
        List<q1> r109 = r108.a();
        if (r109 == null) goto L27;
        ArrayList r110 = new ArrayList();
        Iterator<T> r111 = r109.iterator();
    L17:
        if (r111.hasNext() == false) goto L29;
        Object r112 = r111.next();
        Integer r113 = ((q1) r112).a();
        if (r113 != null) goto L22;
    L24:
        boolean r114 = false;
    L25:
        if (r114 == false) goto L17;
        r110.add(r112);
        goto L17
    L22:
        if (r113.intValue() != r101) goto L24;
        r114 = true;
    L29:
        if (r110 != null) goto L31;
        r102.setVisibility(8);
        r103.setVisibility(8);
        return;
    L31:
        if (r110.size() < 2) goto L40;
        q1 r115 = (q1) CollectionsKt.getOrNull(r110, 1);
        if (r115 == null) goto L35;
        r102.a(r115);
        r102.setVisibility(0);
    L36:
        q1 r116 = (q1) CollectionsKt.getOrNull(r110, 0);
        if (r116 == null) goto L39;
        r103.a(r116);
        r103.setVisibility(0);
        return;
    L39:
        r103.setVisibility(8);
        return;
    L35:
        r102.setVisibility(8);
        goto L36
    L40:
        q1 r117 = (q1) CollectionsKt.getOrNull(r110, 0);
        if (r117 == null) goto L43;
        r103.a(r117);
        r103.setVisibility(0);
    L44:
        r102.setVisibility(8);
        return;
    L43:
        r103.setVisibility(8);
    L27:
        r110 = null;
        goto L29
    L58:
        return;
    L54:
        return;
    L53:
        return;
    }
}
