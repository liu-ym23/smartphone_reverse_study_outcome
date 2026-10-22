package com.bytedance.android.ec.window.base.widget;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/window/base/widget/BouncingMarqueeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "J", "getScrollPxPerSecond", "()J", "setScrollPxPerSecond", "(J)V", "scrollPxPerSecond", "b", "getEdgePauseDuration", "setEdgePauseDuration", "edgePauseDuration", "", "c", "I", "getMaxRoundCount", "()I", "setMaxRoundCount", "(I)V", "maxRoundCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BouncingMarqueeTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f49891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f49892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f49894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f49895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f49896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f49897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f49898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f49899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f49900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f49901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f49902l;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BouncingMarqueeTextView f49903a;

        public a(BouncingMarqueeTextView r100) {
            this.f49903a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            BouncingMarqueeTextView r100 = this.f49903a;
            r100.y(r100.f49898h);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BouncingMarqueeTextView f49904a;

        public b(BouncingMarqueeTextView r100) {
            this.f49904a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            BouncingMarqueeTextView r102 = this.f49904a;
            r102.y(r102.f49898h);
        }
    }

    public BouncingMarqueeTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BouncingMarqueeTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void x() {
        Disposable r100 = this.f49894d;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f49894d = bg4.b.b(Observable.timer(this.f49892b, TimeUnit.MILLISECONDS)).subscribe(new b(this));
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f49895e;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f49895e = null;
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f49902l);
    }

    public final long getEdgePauseDuration() {
        return this.f49892b;
    }

    public final int getMaxRoundCount() {
        return this.f49893c;
    }

    public final long getScrollPxPerSecond() {
        return this.f49891a;
    }

    public final void setEdgePauseDuration(long r100) {
        this.f49892b = r100;
    }

    public final void setMaxRoundCount(int r100) {
        this.f49893c = r100;
    }

    public final void setScrollPxPerSecond(long r100) {
        this.f49891a = r100;
    }

    public final void y(int r100) {
        int r101 = r100 | this.f49901k;
        this.f49901k = r101;
        if (r101 == this.f49900j) goto L5;
        return;
    L5:
        Layout r102 = getLayout();
        if (r102 != null) goto L9;
        return;
    L9:
        if (getWidth() > 0) goto L11;
        return;
    L11:
        int r103 = RangesKt.coerceAtLeast((int) (r102.getLineWidth(0) - getWidth()), 0);
        this.f49896f = r103;
        if (this.f49897g != r103) goto L14;
        return;
    L14:
        this.f49897g = r103;
        if (r103 <= 0) goto L29;
        int r104 = this.f49893c;
        if (r104 <= 0) goto L29;
        if (r103 > 0) goto L21;
        return;
    L21:
        if (this.f49891a <= 0) goto L36;
        if (r104 <= 0) goto L37;
        ValueAnimator r105 = this.f49895e;
        if (r105 == null) goto L28;
        r105.cancel();
    L28:
        this.f49895e = null;
        long r106 = RangesKt.coerceAtLeast(((long) (this.f49896f * 1000)) / this.f49891a, 1000);
        int r107 = (this.f49893c * 2) - 1;
        ValueAnimator r108 = ValueAnimator.ofInt(new int[]{0, this.f49896f});
        r108.setDuration(r106);
        r108.setInterpolator(new LinearInterpolator());
        r108.setRepeatMode(2);
        r108.setRepeatCount(r107);
        r108.addUpdateListener(new com.bytedance.android.ec.window.base.widget.a(this));
        r108.addListener(new com.bytedance.android.ec.window.base.widget.b(this));
        r108.start();
        Unit r109 = Unit.INSTANCE;
        this.f49895e = r108;
        return;
    L37:
        return;
    L36:
        return;
    L29:
        ValueAnimator r110 = this.f49895e;
        if (r110 == null) goto L32;
        r110.cancel();
    L32:
        this.f49895e = null;
        scrollTo(0, 0);
    }

    public BouncingMarqueeTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        this.f49891a = com.bytedance.android.ec.hybrid.list.util.c.d(20);
        this.f49892b = 1000;
        this.f49893c = 3;
        this.f49897g = -1;
        this.f49898h = 1;
        this.f49899i = 2;
        this.f49900j = 3;
        a r104 = new a(this);
        this.f49902l = r104;
        setSingleLine(true);
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setMarqueeRepeatLimit(0);
        setHorizontalFadingEdgeEnabled(true);
        setFadingEdgeLength(com.bytedance.android.ec.hybrid.list.util.c.d(10));
        getViewTreeObserver().addOnGlobalLayoutListener(r104);
    }

    public /* synthetic */ BouncingMarqueeTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = R.attr.textViewStyle;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        x();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        super.onTextChanged(r100, r101, r102, r103);
        x();
    }
}
