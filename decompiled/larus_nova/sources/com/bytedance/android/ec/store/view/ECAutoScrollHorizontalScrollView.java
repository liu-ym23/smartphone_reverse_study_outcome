package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.Scroller;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECAutoScrollHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "", "d", "I", "getAutoScrollSpeed", "()I", "setAutoScrollSpeed", "(I)V", "autoScrollSpeed", "Lkotlin/Function0;", "", "e", "Lkotlin/jvm/functions/Function0;", "getOnMovedByHandListener", "()Lkotlin/jvm/functions/Function0;", "setOnMovedByHandListener", "(Lkotlin/jvm/functions/Function0;)V", "onMovedByHandListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAutoScrollHorizontalScrollView extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Scroller f48703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f48704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f48705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f48706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f48707e;

    public ECAutoScrollHorizontalScrollView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECAutoScrollHorizontalScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void computeScroll() {
        if (this.f48703a.computeScrollOffset() == false) goto L6;
        scrollTo(this.f48703a.getCurrX(), this.f48703a.getCurrY());
        postInvalidate();
        return;
    }

    public final int getAutoScrollSpeed() {
        return this.f48706d;
    }

    public final Function0<Unit> getOnMovedByHandListener() {
        return this.f48707e;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        if (r101 == 1) goto L12;
        if (r101 != 2) goto L18;
        if (this.f48704b == true) goto L10;
        this.f48703a.forceFinished(true);
        this.f48704b = true;
    L10:
        this.f48705c = true;
    L18:
        return super.onTouchEvent(r100);
    L12:
        if (this.f48705c == false) goto L18;
        Function0<Unit> r102 = this.f48707e;
        if (r102 == null) goto L16;
        Unit r103 = r102.invoke();
    L16:
        this.f48705c = false;
        goto L18
    }

    public final void setAutoScrollSpeed(int r100) {
        this.f48706d = r100;
    }

    public final void setOnMovedByHandListener(Function0<Unit> r100) {
        this.f48707e = r100;
    }

    public ECAutoScrollHorizontalScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f48703a = new Scroller(r100, new LinearInterpolator());
        this.f48706d = 50;
    }

    public /* synthetic */ ECAutoScrollHorizontalScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
