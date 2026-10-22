package com.bytedance.android.ec.core.sku;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u001c\u0010\u0013\u001a\u00020\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/core/sku/CommonMarqueeView;", "Landroid/widget/FrameLayout;", "", "delay", "", "setStartDelay", "", VideoThumbInfo.KEY_INTERVAL, "setInterval", "scrollDuration", "setScrollDuration", "spacing", "setItemSpacing", "", "vertical", "setOrientation", "Lkotlin/Function1;", "Landroid/view/View;", "listener", "setOnViewExposedListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonMarqueeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f45309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f45311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f45312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f45313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super View, Unit> f45314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f45315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f45316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f45317i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f45318j;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonMarqueeView f45319a;

        @Override // java.lang.Runnable
        public final void run() {
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
            CommonMarqueeView.a(this.f45319a);     // Catch: Throwable -> L4
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        L6:
            CommonMarqueeView r101 = this.f45319a;     // Catch: Throwable -> L8
            r101.f45317i.postDelayed(this, r101.f45312d);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        L4:
            th = move-exception;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
            Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L8
            goto L6
        }

        public a(CommonMarqueeView r100) {
            this.f45319a = r100;
        }
    }

    public CommonMarqueeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonMarqueeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void d() {
        this.f45317i.removeCallbacks(this.f45318j);
        this.f45315g = false;
    }

    public final void b() {
        Iterator<T> r100 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L16;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r104 = (View) r102;
        int r105 = this.f45316h;
        if (r101 != r105) goto L11;
    L14:
        r104.setVisibility(0);
        r104.setTranslationY(0.0f);
    L15:
        r101 = r103;
        goto L4
    L11:
        if (r101 == (r105 % getChildCount())) goto L14;
        r104.setVisibility(8);
        goto L15
    }

    public final void c() {
        if (getChildCount() > 1) goto L5;
        return;
    L5:
        if (this.f45315g == true) goto L9;
        this.f45315g = true;
        b();
        this.f45317i.postDelayed(this.f45318j, (long) this.f45313e);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public static final void a(CommonMarqueeView r110) {
        if (r110.getChildCount() <= 1) goto L32;
        int r100 = (r110.f45316h + 1) % r110.getChildCount();
        View r101 = r110.getChildAt(r110.f45316h % r110.getChildCount());
        View r102 = r110.getChildAt(r100);
        if (r110.f45309a == true) goto L7;
    L9:
        Iterator<T> r103 = com.bytedance.commerce.base.view.b.a(r110).iterator();
        int r104 = 0;
    L11:
        if (r103.hasNext() == false) goto L23;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        View r107 = (View) r105;
        int r108 = r110.f45316h;
        if (r104 != r108) goto L18;
    L21:
        r107.setVisibility(0);
    L22:
        r104 = r106;
        goto L11
    L18:
        if (r104 == ((r108 + 1) % r110.getChildCount())) goto L21;
        r107.setVisibility(8);
        goto L22
    L23:
        int[] r109 = new int[2];
        r109[0] = 0;
        if (r110.f45309a == false) goto L26;
        int r111 = r101.getHeight();
    L27:
        r109[1] = r111 + r110.f45310b;
        ValueAnimator r112 = ValueAnimator.ofInt(r109);
        r112.addListener(new com.bytedance.android.ec.core.sku.a(r110, r100));
        r112.setDuration(r110.f45311c);
        r112.addUpdateListener(new b(r110, r101, r102));
        r112.start();
        return;
    L26:
        r111 = r101.getWidth();
        goto L27
    L7:
        if (r101.getTop() == 0) goto L9;
        r101.setTranslationY(0.0f);
        goto L9
    }

    public final void setInterval(int r100) {
        this.f45312d = r100;
    }

    public final void setItemSpacing(int r100) {
        this.f45310b = r100;
    }

    public final void setOnViewExposedListener(Function1<? super View, Unit> r100) {
        this.f45314f = r100;
    }

    public final void setOrientation(boolean r100) {
        this.f45309a = r100;
    }

    public final void setScrollDuration(int r100) {
        this.f45311c = r100;
    }

    public final void setStartDelay(float r100) {
        this.f45313e = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getChildCount();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r103 >= r102) goto L5;
        View r106 = getChildAt(r103);
        measureChild(r106, r100, r101);
        r104 = Math.max(r104, r106.getMeasuredWidth());
        r105 = Math.max(r105, r106.getMeasuredHeight());
        r103 = r103 + 1;
        goto L3
    L5:
        setMeasuredDimension(r104 + (getPaddingLeft() + getPaddingRight()), r105 + (getPaddingTop() + getPaddingBottom()));
    }

    public CommonMarqueeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f45309a = true;
        this.f45310b = 20;
        this.f45311c = 400;
        this.f45312d = 3000;
        this.f45313e = 3000.0f;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f45317i = new Handler(Looper.getMainLooper());
        this.f45318j = new a(this);
    }

    public /* synthetic */ CommonMarqueeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
