package com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R6\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyricv2/view/KtvScrollLyricViewV2;", "Landroidx/recyclerview/widget/RecyclerView;", "", "getTopFadingEdgeStrength", "Lkotlin/Function2;", "", "", "c", "Lkotlin/jvm/functions/Function2;", "getOnSizeChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnSizeChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "onSizeChangedListener", "", ce.f26391f, "Z", "getFadingEdgeEnable", "()Z", "setFadingEdgeEnable", "(Z)V", "fadingEdgeEnable", "h", "getTouchable", "setTouchable", "touchable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvScrollLyricViewV2 extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f143233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Function2<Integer, Integer, Unit>> f143234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super Integer, ? super Integer, Unit> f143235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f143236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f143237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f143238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f143239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f143240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f143241i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f143242j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f143243k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f143244l;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvScrollLyricViewV2 f143245a;

        public a(KtvScrollLyricViewV2 r100) {
            this.f143245a = r100;
        }

        public final void a() {
            String r100 = "getSizeTask run w:" + this.f143245a.getMeasuredWidth() + ", h:" + this.f143245a.getMeasuredHeight();
            ALogger.i(bb0.b.b(), r100 + ", invoke class :KtvScrollLyricViewV2");
            Iterator<Function2<Integer, Integer, Unit>> r101 = this.f143245a.f143234b.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().invoke(Integer.valueOf(this.f143245a.getMeasuredWidth()), Integer.valueOf(this.f143245a.getMeasuredHeight()));
            goto L4
        L6:
            this.f143245a.f143234b.clear();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f143234b.clear();
    }

    public final boolean getFadingEdgeEnable() {
        return this.f143239g;
    }

    public final Function2<Integer, Integer, Unit> getOnSizeChangedListener() {
        return this.f143235c;
    }

    public final boolean getTouchable() {
        return this.f143240h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = r100.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.draw(r100);
        RectF r102 = this.f143241i;
        if (r102 == null) goto L16;
        this.f143242j.setEmpty();
        this.f143243k.setEmpty();
        if (r102.top <= 0) goto L8;
        RectF r103 = this.f143242j;
        r103.left = 0.0f;
        r103.top = 0.0f;
        r103.right = r102.right;
        r103.bottom = r102.top;
    L8:
        if (r102.bottom >= getHeight()) goto L11;
        RectF r104 = this.f143243k;
        r104.left = 0.0f;
        r104.top = r102.bottom;
        r104.right = r102.right;
        r104.bottom = getHeight();
    L11:
        if (this.f143242j.isEmpty() == true) goto L14;
        r100.drawRect(this.f143242j, this.f143244l);
    L14:
        if (this.f143243k.isEmpty() == true) goto L16;
        r100.drawRect(this.f143243k, this.f143244l);
    L16:
        r100.restoreToCount(r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f143240h == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    public final void r(Function2<? super Integer, ? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        int r101 = Math.max(getMeasuredWidth(), this.f143237e);
        int r102 = Math.max(this.f143238f, getMeasuredHeight());
        if (r101 > 0) goto L7;
        if (r102 > 0) goto L7;
        ALogger.i(bb0.b.b(), "post getSizeTask, invoke class :KtvScrollLyricViewV2");
        this.f143234b.add(r100);
        return;
    L7:
        r100.invoke(Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()));
        if (getVisibility() == 0) goto L12;
        ALogger.e(bb0.b.b(), "KtvScrollLyricView visible state is invisible, invoke class :KtvScrollLyricViewV2");
        return;
    }

    public final void setFadingEdgeEnable(boolean r100) {
        this.f143239g = r100;
    }

    public final void setOnSizeChangedListener(Function2<? super Integer, ? super Integer, Unit> r100) {
        this.f143235c = r100;
    }

    public final void setTouchable(boolean r100) {
        this.f143240h = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void smoothScrollToPosition(int r100) {
        final Context r101 = getContext();
        LinearSmoothScroller r102 = new AnonymousClass1(r101);
        r102.setTargetPosition(r100);
        RecyclerView.LayoutManager r103 = getLayoutManager();
        if ((r103 instanceof LinearLayoutManager) == true) goto L5;
        r103 = null;
    L5:
        LinearLayoutManager r104 = (LinearLayoutManager) r103;
        if (r104 == null) goto L9;
        r104.startSmoothScroll(r102);
        return;
    }

    public KtvScrollLyricViewV2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f143233a = new Handler();
        this.f143234b = new ArrayList();
        this.f143236d = new a(this);
        this.f143239g = true;
        this.f143240h = true;
        this.f143242j = new RectF();
        this.f143243k = new RectF();
        Paint r102 = new Paint();
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r102.setStyle(Paint.Style.FILL);
        r102.setAntiAlias(true);
        Unit r103 = Unit.INSTANCE;
        this.f143244l = r102;
        setVerticalFadingEdgeEnabled(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f143233a.removeCallbacks(this.f143236d);
        if (this.f143239g == false) goto L5;
        setFadingEdgeLength(r101 / 5);
    L5:
        String r104 = bb0.b.b();
        ALogger.i(r104, ("onSizeChanged w:" + r100 + ", h:" + r101) + ", invoke class :KtvScrollLyricViewV2");
        this.f143237e = r100;
        this.f143238f = r101;
        this.f143236d.run();
        Function2<? super Integer, ? super Integer, Unit> r105 = this.f143235c;
        if (r105 == null) goto L9;
        Unit r106 = r105.invoke(Integer.valueOf(r100), Integer.valueOf(r101));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
