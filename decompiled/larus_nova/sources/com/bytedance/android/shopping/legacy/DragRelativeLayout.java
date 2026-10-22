package com.bytedance.android.shopping.legacy;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.customview.widget.ViewDragHelper;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ue3.b;
import ue3.c;
import ue3.d;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dB\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/legacy/DragRelativeLayout;", "Landroid/widget/RelativeLayout;", "", "dockMode", "", "setDockMode", "Lkotlin/Function0;", RXScreenCaptureService.KEY_INDEX, "Lkotlin/jvm/functions/Function0;", "getOnViewPositionChanged", "()Lkotlin/jvm/functions/Function0;", "setOnViewPositionChanged", "(Lkotlin/jvm/functions/Function0;)V", "onViewPositionChanged", "", ce.f26395j, "Z", "getEnableKeepLayout", "()Z", "setEnableKeepLayout", "(Z)V", "enableKeepLayout", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DragRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f176419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f176420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f176421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f176422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f176423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewDragHelper f176424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f176425g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f176426h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f176427i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f176428j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Pair<Integer, Integer> f176429k;

    public static final class a {
    }

    static {
    }

    public final void b() {
        if (getChildCount() <= 0) goto L6;
        this.f176425g = getChildAt(0);
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    @Override // android.widget.RelativeLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        if (this.f176428j == false) goto L12;
        View r100 = this.f176425g;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getWidth() != 0) goto L9;
        return;
    L9:
        if (r100.getHeight() == 0) goto L15;
        this.f176429k = new Pair(Integer.valueOf(r100.getTop()), Integer.valueOf(r100.getLeft()));
        return;
    L15:
        return;
    }

    public final boolean getEnableKeepLayout() {
        return this.f176428j;
    }

    public final Function0<Unit> getOnViewPositionChanged() {
        return this.f176427i;
    }

    public DragRelativeLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        View r101 = this.f176425g;
        if (r101 == null) goto L5;
        int r102 = r101.getLeft();
    L6:
        View r103 = this.f176425g;
        if (r103 == null) goto L9;
        int r104 = r103.getTop();
    L10:
        View r105 = this.f176425g;
        if (r105 == null) goto L13;
        int r106 = r105.getRight();
    L14:
        View r107 = this.f176425g;
        if (r107 == null) goto L17;
        int r108 = r107.getBottom();
    L19:
        if (r100.getX() >= r102) goto L21;
    L27:
        boolean r109 = false;
    L28:
        this.f176426h = r109;
        if (r109 == false) goto L34;
        ViewDragHelper r110 = this.f176424f;
        if (r110 != null) goto L36;
        return false;
    L36:
        return r110.shouldInterceptTouchEvent(r100);
    L34:
        return super.onInterceptTouchEvent(r100);
    L21:
        if (r100.getX() > r106) goto L27;
        if (r100.getY() < r104) goto L27;
        if (r100.getY() > r108) goto L27;
        r109 = true;
        goto L28
    L17:
        r108 = 0;
        goto L19
    L13:
        r106 = 0;
        goto L14
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f176426h == false) goto L12;
        ViewDragHelper r101 = this.f176424f;     // Catch: IllegalArgumentException -> L8
        if (r101 == null) goto L10;
        r101.processTouchEvent(r100);     // Catch: IllegalArgumentException -> L8
    L10:
        return true;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L10
    L12:
        return super.onTouchEvent(r100);
    }

    public final void setDockMode(int r100) {
        this.f176419a = r100;
    }

    public final void setEnableKeepLayout(boolean r100) {
        this.f176428j = r100;
    }

    public final void setOnViewPositionChanged(Function0<Unit> r100) {
        this.f176427i = r100;
    }

    public DragRelativeLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        if (r101 == null) goto L5;
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.dock_margin_bottom, R.attr.dock_margin_left, R.attr.dock_margin_right, R.attr.dock_margin_top, R.attr.dock_mode});
        this.f176419a = r102.getInt(4, R.id.drag_layout);
        this.f176420b = r102.getDimensionPixelOffset(1, 0);
        this.f176421c = r102.getDimensionPixelOffset(2, 0);
        this.f176422d = r102.getDimensionPixelOffset(3, 0);
        this.f176423e = r102.getDimensionPixelOffset(0, 0);
        r102.recycle();
    L5:
        this.f176424f = ViewDragHelper.create(this, 1.0f, new DragRelativeLayout$initDragHelper$1(this));
    }

    public static void a(DragRelativeLayout r100, View r101, int r102, int r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = 0;
    L8:
        r100.getClass();
        int r105 = r101.getLeft();
        int r106 = r101.getTop();
        if (r102 == 0) goto L11;
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{0, r102});
        r107.addUpdateListener(new ue3.a(r101, r105, r106));
        r107.addListener(new b(r100));
    L17:
        if (r107 == null) goto L19;
        r107.setDuration(250);
    L19:
        if (r107 == null) goto L22;
        r107.start();
        return;
    L22:
        return;
    L11:
        if (r103 == 0) goto L13;
        r107 = ValueAnimator.ofInt(new int[]{0, r103});
        r107.addUpdateListener(new c(r101, r105, r106));
        r107.addListener(new d(r100));
        goto L17
    L13:
        Function0<Unit> r108 = r100.f176427i;
        if (r108 == null) goto L16;
        Unit r109 = r108.invoke();
    L16:
        r107 = null;
        goto L17
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        View r105 = this.f176425g;
        Pair<Integer, Integer> r106 = this.f176429k;
        if (r105 == null) goto L7;
        if (r106 == null) goto L8;
        r105.layout(r106.getSecond().intValue(), r106.getFirst().intValue(), r106.getSecond().intValue() + r105.getWidth(), r106.getFirst().intValue() + r105.getHeight());
        return;
    L8:
        return;
    }
}
