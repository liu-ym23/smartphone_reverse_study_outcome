package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0014B#\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/DragContainer;", "Landroid/widget/FrameLayout;", "", "Ld42/d;", "dragParentView", "", "setDragParentView", "", "enable", "setEnableDrag", "", "getMaxWidth", "maxWidth", "setMaxWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DragContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f132748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d42.d f132749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f132750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f132751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f132752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f132753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f132754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f132755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f132756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f132757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f132758k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f132759l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f132760m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f132761n;

    public final int getMaxWidth() {
        return this.f132748a;
    }

    public DragContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f132760m = true;
        this.f132759l = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f132760m == false) goto L5;
        int r101 = r100.getAction();
        if (r101 != 0) goto L9;
        this.f132750c = getTranslationX();
        this.f132751d = getTranslationY();
        this.f132752e = r100.getRawX();
        float r102 = r100.getRawY();
        this.f132753f = r102;
        this.f132754g = this.f132752e;
        this.f132755h = r102;
    L45:
        return super.dispatchTouchEvent(r100);
    L9:
        if (r101 == 1) goto L38;
        if (r101 != 2) goto L13;
        this.f132758k = Math.abs(r100.getRawX() - this.f132754g);
        float r103 = Math.abs(r100.getRawY() - this.f132755h);
        float r104 = this.f132758k;
        float r105 = this.f132759l;
        if (r104 <= r105) goto L24;
    L25:
        requestDisallowInterceptTouchEvent(true);
        this.f132761n = true;
        this.f132756i = r100.getRawX() - this.f132752e;
        this.f132757j = r100.getRawY() - this.f132753f;
        d42.d r106 = this.f132749b;
        if (r106 != null) goto L28;
    L35:
        if (this.f132761n == false) goto L45;
        return true;
    L28:
        if (r106.e(getX() + this.f132756i, getWidth()) == false) goto L31;
        this.f132752e = r100.getRawX();
        setX(getX() + this.f132756i);
    L31:
        if (r106.i(getY() + this.f132757j, getHeight()) == false) goto L33;
        this.f132753f = r100.getRawY();
        setY(getY() + this.f132757j);
    L33:
        r106.g(this);
        goto L35
    L24:
        if (r103 <= r105) goto L35;
    L13:
        if (r101 != 3) goto L45;
        if (this.f132761n == false) goto L45;
        requestDisallowInterceptTouchEvent(false);
        this.f132761n = false;
        d42.d r107 = this.f132749b;
        if (r107 == null) goto L20;
        r107.c(this);
    L20:
        return true;
    L38:
        if (this.f132761n == false) goto L45;
        requestDisallowInterceptTouchEvent(false);
        this.f132761n = false;
        d42.d r108 = this.f132749b;
        if (r108 == null) goto L42;
        r108.f(this);
    L42:
        return true;
    L5:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return this.f132760m;
    }

    public void setDragParentView(d42.d r100) {
        this.f132749b = r100;
    }

    public void setEnableDrag(boolean r100) {
        this.f132760m = r100;
    }

    public final void setMaxWidth(int r100) {
        this.f132748a = r100;
    }

    public DragContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0);
        this.f132760m = true;
        this.f132759l = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = this.f132748a;
        if (r104 <= 0) goto L5;
        r103 = Math.min(r103, r104);
    L5:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r103, r102), r101);
    }

    public DragContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f132760m = true;
        this.f132759l = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
