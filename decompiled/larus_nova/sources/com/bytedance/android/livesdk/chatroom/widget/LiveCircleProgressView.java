package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/LiveCircleProgressView;", "Landroid/view/View;", "", "progress", "", "setProgress", "maxProgress", "setMaxProgress", "color", "setBgCircleColor", "setProgressColor", "width", "setCircleWidth", "setBgCircleWidth", "angle", "setStartAngle", "c", "I", "getWidth$livecommonui_saasRelease", "()I", "setWidth$livecommonui_saasRelease", "(I)V", "d", "getHeight$livecommonui_saasRelease", "setHeight$livecommonui_saasRelease", "height", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCircleProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f118513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f118514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f118515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f118516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f118517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f118518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f118519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f118520h;

    public final int getHeight$livecommonui_saasRelease() {
        return this.f118516d;
    }

    public final int getWidth$livecommonui_saasRelease() {
        return this.f118515c;
    }

    public LiveCircleProgressView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        int r100 = this.f118515c;
        float r101 = r100 / 2.0f;
        float r102 = this.f118516d / 2.0f;
        float r103 = (r100 / 2.0f) - this.f118520h;
        Paint r104 = this.f118513a;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r110.drawCircle(r101, r102, r103, r104);
        int r105 = this.f118520h;
        RectF r106 = new RectF(r105, r105, this.f118515c - r105, this.f118516d - r105);
        float r107 = this.f118519g - 90;
        float r108 = ((this.f118517e * 1.0f) / this.f118518f) * 360;
        Paint r111 = this.f118514b;
        if (r111 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L8:
        r110.drawArc(r106, r107, r108, false, r111);
    }

    public final void setBgCircleColor(int r100) {
        Paint r101 = this.f118513a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r101.setColor(r100);
    }

    public final void setBgCircleWidth(int r100) {
        this.f118520h = r100 / 2;
        Paint r101 = this.f118513a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r101.setStrokeWidth(r100);
    }

    public final void setCircleWidth(int r100) {
        Paint r101 = this.f118514b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L5:
        r101.setStrokeWidth(r100);
    }

    public final void setHeight$livecommonui_saasRelease(int r100) {
        this.f118516d = r100;
    }

    public final void setMaxProgress(int r100) {
        this.f118518f = r100;
    }

    public final void setProgress(int r100) {
        this.f118517e = r100;
        invalidate();
    }

    public final void setProgressColor(int r100) {
        Paint r101 = this.f118514b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
    L5:
        r101.setColor(r100);
    }

    public final void setStartAngle(int r100) {
        this.f118519g = r100;
    }

    public final void setWidth$livecommonui_saasRelease(int r100) {
        this.f118515c = r100;
    }

    public LiveCircleProgressView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f118518f = 100;
        Paint r102 = new Paint();
        this.f118513a = r102;
        r102.setAntiAlias(true);
        Paint r103 = this.f118513a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L5:
        r103.setStyle(Paint.Style.STROKE);
        Paint r104 = this.f118513a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bgPaint");
    L8:
        Paint r105 = new Paint(r104);
        this.f118514b = r105;
        r105.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f118515c = View.MeasureSpec.getSize(r100);
        this.f118516d = View.MeasureSpec.getSize(r101);
    }
}
