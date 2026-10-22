package com.bytedance.applet.aibridge.datepicker.picker.reels.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kv3.f;
import kv3.g;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001fH\u0016J\u001c\u0010)\u001a\u00020*2\n\u0010+\u001a\u00060,R\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J$\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\t2\n\u0010+\u001a\u00060,R\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\tH\u0016J\u0014\u00104\u001a\u00020*2\n\u0010+\u001a\u00060,R\u00020-H\u0002J \u00105\u001a\u00020*2\u0006\u00106\u001a\u0002072\u0006\u00103\u001a\u00020\t2\u0006\u00108\u001a\u00020\u0007H\u0002J\u0006\u00109\u001a\u00020\tJ\u000e\u0010:\u001a\u00020\t2\u0006\u00103\u001a\u00020\tJ\u0006\u0010;\u001a\u00020\tJ \u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\tH\u0002J\u000e\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020\tJ\u000e\u0010D\u001a\u00020*2\u0006\u0010C\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\u0014¨\u0006E"}, d2 = {"Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "cameraDistancePx", "", "defaultStartColor", "", "getDefaultStartColor", "()I", "defaultStartColor$delegate", "Lkotlin/Lazy;", "defaultEndColor", "getDefaultEndColor", "defaultEndColor$delegate", "selectedColor", "getSelectedColor", "setSelectedColor", "(I)V", "normalColor", "getNormalColor", "setNormalColor", "itemAngle", "quarterCount", "degToRad", "itemHeightPx", "scrollOffsetPx", "radiusPx", "isCyclic", "", "()Z", "setCyclic", "(Z)V", "headTailPaddingItems", "getHeadTailPaddingItems", "setHeadTailPaddingItems", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "canScrollVertically", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollVerticallyBy", "dy", "scrollToPosition", "position", "layoutVisibleChildren", "applyTransform", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "scrollItems", "computeSnapDeltaToNearestCenter", "computeDeltaToCenterAtPosition", "getNearestCenterAdapterIndex", "lerp", "start", "end", "t", "calculateRadius", "itemHeight", "setSelectedTextColor", "color", "setNormalTextColor", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WheelLayoutManager extends RecyclerView.LayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f191048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f191049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f191050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f191051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f191052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f191053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f191054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f191055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f191056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f191057j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f191058k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f191059l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f191060m;

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public WheelLayoutManager(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r101 = Resources.getSystem();
        this.f191048a = TypedValue.applyDimension(1, 8000.0f, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
        Lazy r102 = LazyKt.lazy(new f(r100));
        this.f191049b = r102;
        Lazy r103 = LazyKt.lazy(new g(r100));
        this.f191050c = r103;
        this.f191051d = ((Number) r102.getValue()).intValue();
        this.f191052e = ((Number) r103.getValue()).intValue();
        this.f191053f = 30.0f;
        this.f191054g = 3;
        this.f191055h = 0.017453292f;
    }

    public final void p(RecyclerView.Recycler r110) {
        detachAndScrapAttachedViews(r110);
        int r100 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (r100 > 0) goto L5;
        return;
    L5:
        if (this.f191056i == 0) goto L21;
        float r101 = 2.0f;
        float r102 = getPaddingTop() + (r100 / 2.0f);
        float r103 = this.f191057j / this.f191056i;
        float r104 = 1;
        int r105 = RangesKt.coerceAtLeast((int) Math.floor((r103 - this.f191054g) - r104), 0);
        int r111 = RangesKt.coerceAtMost((int) Math.ceil((this.f191054g + r103) + r104), getItemCount() - 1);
        if (r105 > r111) goto L20;
        int r112 = r105;
    L10:
        View r113 = r110.getViewForPosition(r112);
        addView(r113);
        measureChildWithMargins(r113, 0, 0);
        int r106 = getDecoratedMeasuredWidth(r113);
        int r107 = ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - r106) / 2) + getPaddingLeft();
        int r108 = MathKt.roundToInt(r102 - (this.f191056i / r101));
        layoutDecorated(r113, r107, r108, r107 + r106, r108 + this.f191056i);
        float r109 = r112 - r103;
        float r114 = RangesKt.coerceIn(this.f191053f * r109, -90.0f, 90.0f);
        float r115 = this.f191055h * r114;
        float r116 = RangesKt.coerceIn(Math.abs(r114) / 90.0f, 0.0f, 1.0f);
        float r117 = RangesKt.coerceIn(Math.abs(r109), 0.0f, 1.0f);
        float r118 = ((-0.19999999f) * r116) + 1.0f;
        r113.setPivotX(r113.getWidth() / r101);
        r113.setPivotY(r113.getHeight() / r101);
        r113.setRotationX(r114);
        r113.setScaleX(r118);
        r113.setScaleY(r118);
        double r119 = r115;
        float r120 = r102;
        r113.setTranslationY(((float) Math.sin(r119)) * this.f191058k);
        float r121 = (float) Math.cos(r119);
        float r122 = this.f191058k;
        r113.setTranslationZ((r121 * r122) - r122);
        r113.setCameraDistance(this.f191048a);
        if ((r113 instanceof TextView) == false) goto L15;
        TextView r123 = (TextView) r113;
        r123.setTextColor(ColorUtils.blendARGB(this.f191051d, this.f191052e, r117));
        int r124 = MathKt.roundToInt((r117 * (-150.0f)) + 450.0f);
        if (Build.VERSION.SDK_INT < 28) goto L15;
        r123.setTypeface(Typeface.create(Typeface.DEFAULT, r124, false));
    L15:
        r113.setAlpha(1.0f + (r116 * (-0.8f)));
        if (r112 == r111) goto L22;
        r112 = r112 + 1;
        r102 = r120;
        r101 = 2.0f;
        goto L10
    L22:
        return;
    L20:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r100) {
        if (getItemCount() != 0) goto L5;
        return;
    L5:
        if (this.f191056i != 0) goto L8;
        return;
    L8:
        if (this.f191059l == false) goto L10;
        int r101 = RangesKt.coerceIn(r100, 0, getItemCount() - 1);
    L11:
        this.f191057j = r101 * this.f191056i;
        requestLayout();
        return;
    L10:
        int r102 = this.f191060m;
        r101 = RangesKt.coerceIn(r100, r102, RangesKt.coerceAtLeast((getItemCount() - this.f191060m) - 1, r102));
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        Intrinsics.checkNotNullParameter(r100, "recycler");
        Intrinsics.checkNotNullParameter(r101, "state");
        if (getItemCount() != 0) goto L7;
        detachAndScrapAttachedViews(r100);
        this.f191057j = 0.0f;
        return;
    L7:
        if (this.f191056i != 0) goto L9;
        View r102 = r100.getViewForPosition(0);
        addView(r102);
        measureChildWithMargins(r102, 0, 0);
        int r103 = getDecoratedMeasuredHeight(r102);
        this.f191056i = r103;
        this.f191058k = r103 / ((float) Math.tan(this.f191053f * this.f191055h));
        detachAndScrapView(r102, r100);
    L9:
        p(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r101, "recycler");
        Intrinsics.checkNotNullParameter(r102, "state");
        if (getChildCount() == 0) goto L16;
        if (r100 == 0) goto L16;
        if (this.f191056i == 0) goto L16;
        if (getItemCount() == 0) goto L16;
        float r103 = RangesKt.coerceAtLeast(getItemCount() - 1, 0) * this.f191056i;
        if (this.f191059l == false) goto L13;
        Pair r104 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(r103));
    L14:
        float r105 = RangesKt.coerceIn(this.f191057j + r100, ((Number) r104.component1()).floatValue(), ((Number) r104.component2()).floatValue());
        float r106 = r105 - this.f191057j;
        this.f191057j = r105;
        p(r101);
        return MathKt.roundToInt(r106);
    L13:
        int r107 = this.f191060m;
        int r108 = RangesKt.coerceAtLeast((getItemCount() - this.f191060m) - 1, r107);
        int r109 = this.f191056i;
        r104 = TuplesKt.to(Float.valueOf(r107 * r109), Float.valueOf(r108 * r109));
    L16:
        return 0;
    }
}
