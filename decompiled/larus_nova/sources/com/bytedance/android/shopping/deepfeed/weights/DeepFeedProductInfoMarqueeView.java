package com.bytedance.android.shopping.deepfeed.weights;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductInfoMarqueeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductInfoMarqueeView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f174107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f174108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f174109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f174110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f174111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f174112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f174113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f174114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f174115i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f174116j;

    public final void U5() {
        View r100 = this.f174107a;
        if (r100 == null) goto L5;
    L7:
        if (r100 == null) goto L9;
        r100.setTranslationY(0.0f);
    L9:
        View r101 = this.f174108b;
        if (r101 == null) goto L20;
        int r102 = this.f174109c;
        if (r102 <= 0) goto L15;
    L18:
        r101.setTranslationY(r102);
        return;
    L15:
        if (tc3.f.e() == false) goto L17;
        com.bytedance.android.shopping.deepfeed.ui.view.a r103 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r102 = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 20);
        goto L18
    L17:
        com.bytedance.android.shopping.deepfeed.ui.view.a r104 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r102 = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 16);
        goto L18
    L20:
        return;
    L5:
        if (this.f174108b != null) goto L7;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f174110d;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f174110d = null;
        Runnable r101 = this.f174111e;
        if (r101 == null) goto L8;
        this.f174112f.removeCallbacks(r101);
    L8:
        this.f174111e = null;
        U5();
    }

    public DeepFeedProductInfoMarqueeView(Context r100) {
        this(r100, null);
    }

    public static boolean T5(View r100) {
        List<View> r101 = com.bytedance.commerce.base.view.b.a(r100);
        if (r101 == null) goto L11;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        if (((View) r102.next()).getVisibility() != 0) goto L6;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    public DeepFeedProductInfoMarqueeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f174112f = new Handler(Looper.getMainLooper());
        this.f174113g = 670;
        this.f174114h = 2330;
        this.f174115i = true;
        this.f174116j = true;
    }

    public final void R5(ConstraintLayout r100, ConstraintLayout r101) {
        if (r100 == null) goto L28;
        if (r101 == null) goto L30;
        removeAllViews();
        this.f174107a = r100;
        this.f174108b = r101;
        ConstraintLayout.LayoutParams r102 = new ConstraintLayout.LayoutParams(-2, -2);
        r102.topToTop = 0;
        if (tc3.f.d() == false) goto L8;
        r102.leftToLeft = 0;
    L9:
        Unit r103 = Unit.INSTANCE;
        addView(r100, r102);
        View r104 = this.f174108b;
        ConstraintLayout.LayoutParams r105 = new ConstraintLayout.LayoutParams(-2, -2);
        r105.topToTop = 0;
        if (tc3.f.d() == false) goto L12;
        r105.leftToLeft = 0;
    L13:
        addView(r104, r105);
        View r106 = this.f174107a;
        if (r106 == null) goto L16;
    L18:
        if (r106 == null) goto L20;
        r106.setTranslationY(0.0f);
    L20:
        View r107 = this.f174108b;
        if (r107 != null) goto L23;
        return;
    L23:
        if (tc3.f.e() == false) goto L25;
        com.bytedance.android.shopping.deepfeed.ui.view.a r108 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        int r109 = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 20);
    L26:
        r107.setTranslationY(r109);
        return;
    L25:
        com.bytedance.android.shopping.deepfeed.ui.view.a r110 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r109 = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 16);
        goto L26
    L16:
        if (this.f174108b != null) goto L18;
        return;
    L12:
        r105.rightToRight = 0;
        goto L13
    L8:
        r102.rightToRight = 0;
        goto L9
    L30:
        return;
    }

    public static Pair S5(List r100, int r101, int r110, int r111) {
        if (r100.isEmpty() == true) goto L5;
        Iterator r102 = r100.iterator();
        int r103 = r110;
        boolean r104 = false;
        int r105 = 0;
    L8:
        if (r102.hasNext() == false) goto L31;
        Object r106 = r102.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        View r108 = (View) r106;
        if (r108.getVisibility() == 8) goto L29;
        r108.measure(View.MeasureSpec.makeMeasureSpec(r101, 0), r111);
        ViewGroup.LayoutParams r112 = r108.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == true) goto L17;
        r112 = null;
    L17:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        int r109 = r108.getMeasuredWidth();
        if (r113 == null) goto L20;
        int r114 = r113.leftMargin;
    L21:
        int r115 = r109 + r114;
        if (r113 == null) goto L24;
        int r116 = r113.rightMargin;
    L25:
        int r117 = r115 + r116;
        r103 = r103 + r117;
        if (r103 <= r101) goto L28;
        r108.setVisibility(8);
        r103 = r103 - r117;
        r104 = true;
    L28:
        r110 = r103;
        goto L29
    L24:
        r116 = 0;
        goto L25
    L20:
        r114 = 0;
    L29:
        r105 = r107;
        goto L8
    L31:
        return TuplesKt.to(Integer.valueOf(r110), Boolean.valueOf(r104));
    L5:
        return TuplesKt.to(Integer.valueOf(r110), Boolean.FALSE);
    }
}
