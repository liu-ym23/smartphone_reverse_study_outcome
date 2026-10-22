package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.base.widget.round.RoundView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB\u001d\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B%\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\u0012J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/pannel/view/ECCarouselIndicatorView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/pannel/utils/PagerSnapScrollListener$a;", "", "position", "", "setSelected", "", "unSelectedDotAlpha", "setUnSelectDotAlpha", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCarouselIndicatorView extends LinearLayout implements PagerSnapScrollListener.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FastOutSlowInInterpolator f152163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f152164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f152165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f152166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f152167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f152168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f152169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f152170h;

    public ECCarouselIndicatorView(Context r100) {
        super(r100);
        setGravity(17);
        this.f152163a = new FastOutSlowInInterpolator();
        this.f152164b = UtilityKotlinExtentionsKt.d(4);
        this.f152165c = UtilityKotlinExtentionsKt.d(12);
        this.f152166d = UtilityKotlinExtentionsKt.d(4);
        this.f152167e = -1;
        this.f152168f = 0.8f;
        this.f152169g = 253106211;
    }

    private final void setSelected(int r100) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        this.f152170h = r100;
        int r101 = getChildCount();
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L12;
        View r104 = getChildAt(r103);
        if (this.f152170h != r103) goto L10;
        boolean r105 = true;
    L11:
        e(r104, r105);
        r103 = r103 + 1;
        goto L6
    L10:
        r105 = false;
        goto L11
    L12:
        int r106 = getChildCount();
    L13:
        if (r102 >= r106) goto L15;
        f(getChildAt(r102), r102);
        r102 = r102 + 1;
        goto L13
    L15:
        invalidate();
    }

    public final void c(int r100) {
        if (r100 != getChildCount()) goto L5;
        return;
    L5:
        removeAllViews();
        int r101 = 0;
    L6:
        if (r101 >= r100) goto L12;
        RoundView r102 = new RoundView(getContext());
        if (this.f152170h != r101) goto L10;
        boolean r103 = true;
    L11:
        e(r102, r103);
        f(r102, r101);
        addView(r102);
        r101 = r101 + 1;
        goto L6
    L10:
        r103 = false;
        goto L11
    L12:
        setSelected(this.f152170h);
    }

    public final int d(float r100) {
        return Color.argb((int) Math.floor(((double) r100) * ((double) 255)), Color.red(this.f152167e), Color.green(this.f152167e), Color.blue(this.f152167e));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener.a
    public final void onPageScrollStateChanged(int r100) {
        if (r100 != 0) goto L5;
        setSelected(this.f152170h);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener.a
    public final void onPageSelected(int r100) {
        setSelected(r100);
    }

    public final void setUnSelectDotAlpha(float r100) {
        this.f152168f = r100;
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        View r103 = getChildAt(r102);
        if (this.f152170h != r102) goto L7;
        boolean r104 = true;
    L8:
        e(r103, r104);
        r102 = r102 + 1;
        goto L3
    L7:
        r104 = false;
        goto L8
    }

    public ECCarouselIndicatorView(Context r100, AttributeSet r101) {
        super(r100, r101);
        setGravity(17);
        this.f152163a = new FastOutSlowInInterpolator();
        this.f152164b = UtilityKotlinExtentionsKt.d(4);
        this.f152165c = UtilityKotlinExtentionsKt.d(12);
        this.f152166d = UtilityKotlinExtentionsKt.d(4);
        this.f152167e = -1;
        this.f152168f = 0.8f;
        this.f152169g = 253106211;
    }

    public static final /* synthetic */ void b(ECCarouselIndicatorView r100, int r101) {
        r100.setSelected(r101);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener.a
    public final void a(int r110, float r111) {
        if (r111 != 0.0f) goto L5;
        return;
    L5:
        if (getChildCount() == 0) goto L23;
        float r112 = this.f152163a.getInterpolation(r111);
        View r100 = getChildAt(r110);
        int r101 = r110 + 1;
        View r102 = getChildAt(r101);
        if (r100 == null) goto L10;
        int r103 = this.f152165c;
        int r104 = this.f152164b;
        float r105 = ((this.f152168f - 1.0f) * r112) + 1.0f;
        g(r100, (int) (r103 + ((r104 - r103) * r112)), r104, this.f152166d, r105);
    L10:
        if (r102 == null) goto L12;
        int r113 = this.f152164b;
        float r106 = r113 + ((this.f152165c - r113) * r112);
        float r107 = this.f152168f;
        g(r102, (int) r106, r113, this.f152166d, ((1.0f - r107) * r112) + r107);
    L12:
        int r114 = getChildCount();
        int r108 = 0;
    L13:
        if (r108 >= r114) goto L24;
        if (r108 == r110) goto L17;
        if (r108 == r101) goto L17;
        View r109 = getChildAt(r108);
        int r115 = this.f152164b;
        g(r109, r115, r115, this.f152166d, this.f152168f);
    L17:
        r108 = r108 + 1;
        goto L13
    L24:
        return;
    }

    public final void e(View r100, boolean r101) {
        Drawable r102 = null;
        if ((r100 instanceof RoundView) == true) goto L5;
        r100 = null;
    L5:
        RoundView r103 = (RoundView) r100;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r101 == false) goto L10;
        float r104 = 1.0f;
    L11:
        int r105 = d(r104);
        Lazy r106 = UtilityKotlinExtentionsKt.f153056a;
        Intrinsics.checkNotNullParameter(r103, "$this$setBgColor");
        Drawable r107 = r103.getBackground();
        if ((r107 instanceof BackgroundDrawable) == true) goto L14;
        r107 = null;
    L14:
        BackgroundDrawable r108 = (BackgroundDrawable) r107;
        if (r108 == null) goto L17;
        r108.setBgColor(r105);
    L17:
        int r109 = this.f152169g;
        Intrinsics.checkNotNullParameter(r103, "$this$setStrokeColor");
        Drawable r110 = r103.getBackground();
        if ((r110 instanceof BackgroundDrawable) == true) goto L20;
        r110 = null;
    L20:
        BackgroundDrawable r111 = (BackgroundDrawable) r110;
        if (r111 == null) goto L23;
        r111.setStrokeColor(r109);
    L23:
        int r112 = UtilityKotlinExtentionsKt.d(Double.valueOf(0.5d));
        Intrinsics.checkNotNullParameter(r103, "$this$setStrokeWidth");
        Drawable r113 = r103.getBackground();
        if ((r113 instanceof BackgroundDrawable) == true) goto L26;
        r113 = null;
    L26:
        BackgroundDrawable r114 = (BackgroundDrawable) r113;
        if (r114 == null) goto L29;
        r114.setStrokeWidth(r112);
    L29:
        Intrinsics.checkNotNullParameter(r103, "$this$makeDrawable");
        Drawable r115 = r103.getBackground();
        if ((r115 instanceof BackgroundDrawable) == false) goto L33;
        r102 = r115;
    L33:
        BackgroundDrawable r116 = (BackgroundDrawable) r102;
        if (r116 == null) goto L37;
        r116.invalidate();
        return;
    L37:
        return;
    L10:
        r104 = this.f152168f;
        goto L11
    }

    public final void f(View r100, int r101) {
        if ((r100 instanceof RoundView) == true) goto L5;
        r100 = null;
    L5:
        RoundView r102 = (RoundView) r100;
        if (r102 != null) goto L8;
        return;
    L8:
        int r103 = this.f152170h;
        boolean r104 = true;
        if (r103 != r101) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        int r106 = this.f152165c;
    L15:
        int r107 = this.f152164b;
        int r108 = this.f152166d;
        if (r103 == r101) goto L19;
        r104 = false;
    L19:
        if (r104 == false) goto L21;
        float r109 = 1.0f;
    L22:
        g(r102, r106, r107, r108, r109);
        return;
    L21:
        r109 = this.f152168f;
        goto L22
    L14:
        r106 = this.f152164b;
        goto L15
    L11:
        r105 = false;
        goto L12
    }

    public ECCarouselIndicatorView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setGravity(17);
        this.f152163a = new FastOutSlowInInterpolator();
        this.f152164b = UtilityKotlinExtentionsKt.d(4);
        this.f152165c = UtilityKotlinExtentionsKt.d(12);
        this.f152166d = UtilityKotlinExtentionsKt.d(4);
        this.f152167e = -1;
        this.f152168f = 0.8f;
        this.f152169g = 253106211;
    }

    public final void g(View r100, int r101, int r102, int r103, float r104) {
        Drawable r105 = null;
        if ((r100 instanceof RoundView) == true) goto L5;
        r100 = null;
    L5:
        RoundView r106 = (RoundView) r100;
        if (r106 != null) goto L8;
        return;
    L8:
        float r107 = r102;
        Lazy r108 = UtilityKotlinExtentionsKt.f153056a;
        Intrinsics.checkNotNullParameter(r106, "$this$setCornerRadius");
        Drawable r109 = r106.getBackground();
        if ((r109 instanceof BackgroundDrawable) == true) goto L11;
        r109 = null;
    L11:
        BackgroundDrawable r110 = (BackgroundDrawable) r109;
        if (r110 == null) goto L14;
        r110.setCornerRadius(r107);
    L14:
        Intrinsics.checkNotNullParameter(r106, "$this$makeDrawable");
        Drawable r111 = r106.getBackground();
        if ((r111 instanceof BackgroundDrawable) == true) goto L17;
        r111 = null;
    L17:
        BackgroundDrawable r112 = (BackgroundDrawable) r111;
        if (r112 == null) goto L20;
        r112.invalidate();
    L20:
        ViewGroup.LayoutParams r113 = r106.getLayoutParams();
        if (r113 == null) goto L26;
        r113.width = r101;
        r113.height = r102;
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ((ViewGroup.MarginLayoutParams) r113).setMarginStart(r103);
    L25:
        requestLayout();
    L27:
        int r114 = d(r104);
        Intrinsics.checkNotNullParameter(r106, "$this$setBgColor");
        Drawable r115 = r106.getBackground();
        if ((r115 instanceof BackgroundDrawable) == false) goto L31;
        r105 = r115;
    L31:
        BackgroundDrawable r116 = (BackgroundDrawable) r105;
        if (r116 == null) goto L35;
        r116.setBgColor(r114);
        return;
    L35:
        return;
    L26:
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(r101, r102);
        r117.setMarginStart(r103);
        Unit r118 = Unit.INSTANCE;
        r106.setLayoutParams(r117);
        goto L27
    }
}
