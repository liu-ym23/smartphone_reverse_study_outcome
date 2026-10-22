package com.bytedance.android.shopping.anchorv4.voavhs.base.components;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.ScaleFrame;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.KolReviewElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/KolGridComponentView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class KolGridComponentView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f167795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<KolReviewElement> f167796b;

    public KolGridComponentView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KolGridComponentView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f167795a.e(r100);
        super.draw(r100);
        this.f167795a.d(r100);
    }

    public final void a(List r100, Function0 r101) {
        removeAllViews();
        this.f167796b = r100;
        if (r100 == null) goto L10;
        List r102 = CollectionsKt.filterNotNull(r100);
        if (r102 == null) goto L10;
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        KolReviewElement r104 = (KolReviewElement) r103.next();
        KolReviewElementView r105 = new KolReviewElementView(getContext(), null, 0, 14);
        r105.a(r104, new FrameLayout.LayoutParams(-1, -1));
        Unit r106 = Unit.INSTANCE;
        addView(r105);
    L10:
        post(new a(r101));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        Iterator<T> r102 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L20;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r106 = (View) r104;
        List<KolReviewElement> r107 = this.f167796b;
        if (r107 == null) goto L11;
        KolReviewElement r108 = (KolReviewElement) CollectionsKt.getOrNull(r107, r103);
    L12:
        if (r108 == null) goto L18;
        ScaleFrame r109 = r108.getScaleFrame();
        if (r109 == null) goto L18;
        Float r110 = r109.getScaleWidth();
        if (r110 == null) goto L18;
        float r111 = r110.floatValue();
    L19:
        int r112 = (int) (r111 * getMeasuredWidth());
        r106.measure(View.MeasureSpec.makeMeasureSpec(r112, 1073741824), View.MeasureSpec.makeMeasureSpec(r112, 1073741824));
        r103 = r105;
    L18:
        r111 = 0.0f;
        goto L19
    L11:
        r108 = null;
        goto L12
    }

    public KolGridComponentView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        b r103 = new b(this);
        this.f167795a = r103;
        ViewParent r104 = getParent();
        if ((r104 instanceof FrameLayout) == true) goto L5;
        r104 = null;
    L5:
        FrameLayout r105 = (FrameLayout) r104;
        if (r105 == null) goto L8;
        int r106 = g1.f45599a;
        r105.setBackgroundColor(g1.a.a(r100, R.color.shopping_color_F6F6F9));
    L8:
        r103.f(new Radius(10, 10, 10, 10));
    }

    public /* synthetic */ KolGridComponentView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f167795a.c(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        super.onLayout(r100, r101, r102, r101 + getMeasuredWidth(), r102 + getMeasuredWidth());
        Iterator<T> r103 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L38;
        Object r105 = r103.next();
        int r112 = r104 + 1;
        if (r104 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r106 = (View) r105;
        List<KolReviewElement> r113 = this.f167796b;
        if (r113 == null) goto L13;
        KolReviewElement r107 = (KolReviewElement) CollectionsKt.getOrNull(r113, r104);
        if (r107 == null) goto L13;
        ScaleFrame r108 = r107.getScaleFrame();
    L14:
        float r114 = 0.0f;
        if (r108 == null) goto L19;
        Float r109 = r108.getScaleX();
        if (r109 == null) goto L19;
        float r115 = r109.floatValue();
    L20:
        int r116 = (int) (r115 * getMeasuredWidth());
        if (r108 == null) goto L25;
        Float r117 = r108.getScaleY();
        if (r117 == null) goto L25;
        float r118 = r117.floatValue();
    L26:
        int r119 = (int) (r118 * getMeasuredWidth());
        if (r108 == null) goto L31;
        Float r120 = r108.getScaleX();
        if (r120 == null) goto L31;
        float r121 = r120.floatValue();
    L32:
        int r122 = ((int) (r121 * getMeasuredWidth())) + r106.getMeasuredWidth();
        if (r108 == null) goto L37;
        Float r123 = r108.getScaleY();
        if (r123 == null) goto L37;
        r114 = r123.floatValue();
    L37:
        r106.layout(r116, r119, r122, ((int) (r114 * getMeasuredWidth())) + r106.getMeasuredWidth());
        r104 = r112;
    L31:
        r121 = 0.0f;
    L25:
        r118 = 0.0f;
    L19:
        r115 = 0.0f;
    L13:
        r108 = null;
        goto L14
    }
}
