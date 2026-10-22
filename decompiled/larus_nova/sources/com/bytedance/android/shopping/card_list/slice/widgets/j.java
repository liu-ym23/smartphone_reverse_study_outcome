package com.bytedance.android.shopping.card_list.slice.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ProgressBar;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j extends ProgressBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f171860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f171861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f171862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f171863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f171864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f171865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f171866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f171867h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f171868i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f171869j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f171870k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f171871l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f171872m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Paint f171873n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f171874o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SlcTemplateContext f171875p;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Paint r100 = new Paint();
        r100.setColor(this.f171862c);
        r100.setStyle(Paint.Style.STROKE);
        r100.setAntiAlias(true);
        r100.setStrokeWidth(this.f171860a);
        Unit r101 = Unit.INSTANCE;
        this.f171869j = r100;
        Paint r102 = new Paint();
        r102.setColor(this.f171867h);
        r102.setStyle(Paint.Style.STROKE);
        r102.setStrokeWidth(this.f171866g);
        r102.setAntiAlias(true);
        this.f171871l = r102;
        Paint r103 = new Paint();
        r103.setColor(ColorProtector.parseColor("#FFFFFFFF"));
        r103.setStyle(Paint.Style.FILL);
        r103.setAntiAlias(true);
        this.f171872m = r103;
        Paint r104 = new Paint();
        r104.setColor(this.f171865f);
        r104.setStyle(Paint.Style.STROKE);
        r104.setAntiAlias(true);
        r104.setStrokeWidth(this.f171861b);
        this.f171873n = r104;
        Paint r105 = new Paint();
        r105.setStyle(Paint.Style.STROKE);
        r105.setAntiAlias(true);
        r105.setStrokeWidth(this.f171861b);
        this.f171870k = r105;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("state", super.onSaveInstanceState());
        r100.putInt("circle_ring_color", this.f171867h);
        r100.putInt("circle_ring_width", this.f171866g);
        r100.putInt("circle_ring_radius", this.f171868i);
        r100.putInt("lt_gradient_color", this.f171863d);
        r100.putInt("rb_gradient_color", this.f171864e);
        r100.putInt("reach_bar_size", this.f171861b);
        r100.putInt("reach_bar_bg_color", this.f171865f);
        r100.putInt("normal_bar_color", this.f171862c);
        r100.putInt("normal_bar_height", this.f171860a);
        return r100;
    }

    public final SlcTemplateContext getSlcTemplateContext() {
        return this.f171875p;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        r210.save();
        r210.translate(getPaddingLeft(), getHeight() / 2);
        int r100 = this.f171868i * 2;
        float r101 = (getProgress() * 1.0f) / getMax();
        int r102 = this.f171874o;
        float r103 = r102 - r100;
        float r104 = r101 * r103;
        float r105 = r100;
        if ((r104 + r105) < r102) goto L5;
        float r211 = r103;
        boolean r212 = false;
    L6:
        float r106 = 0;
        if (r211 >= r106) goto L9;
    L26:
        if (r212 == false) goto L30;
        float r107 = r211 + r105;
        Paint r108 = this.f171869j;
        if (r108 == null) goto L30;
        r210.drawLine(r107, 0.0f, this.f171874o, 0.0f, r108);
    L30:
        r210.restore();
        return;
    L9:
        if (r211 <= r106) goto L19;
        Paint r109 = this.f171873n;
        if (r109 == null) goto L13;
        r210.drawLine(0.0f, 0.0f, r211, 0.0f, r109);
    L13:
        int r110 = this.f171861b;
        float r111 = 0.0f;
        LinearGradient r112 = new LinearGradient(0.0f, (-r110) / 2.0f, r211, r110 / 2.0f, CollectionsKt.toIntArray(CollectionsKt.listOf(new Integer[]{Integer.valueOf(this.f171863d), Integer.valueOf(this.f171864e)})), CollectionsKt.toFloatArray(CollectionsKt.listOf(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.66f)})), Shader.TileMode.CLAMP);
        Paint r113 = this.f171870k;
        if (r113 == null) goto L16;
        r113.setShader(r112);
    L16:
        Paint r114 = this.f171870k;
        if (r114 == null) goto L20;
        r210.drawLine(0.0f, 0.0f, r211, 0.0f, r114);
    L20:
        Paint r115 = this.f171872m;
        if (r115 == null) goto L23;
        r210.drawCircle(r211 + (r105 / 2.0f), r111, this.f171868i, r115);
    L23:
        Paint r116 = this.f171871l;
        if (r116 == null) goto L26;
        r210.drawCircle(r211 + (r105 / 2.0f), r111, this.f171868i - (this.f171866g / 2.0f), r116);
        goto L26
    L19:
        r111 = 0.0f;
        goto L20
    L5:
        r211 = r104;
        r212 = true;
        goto L6
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof Bundle) == false) goto L6;
        Bundle r101 = (Bundle) r100;
        this.f171867h = r101.getInt("circle_ring_color");
        this.f171866g = r101.getInt("circle_ring_width");
        this.f171868i = r101.getInt("circle_ring_radius");
        this.f171863d = r101.getInt("lt_gradient_color");
        this.f171864e = r101.getInt("rb_gradient_color");
        this.f171861b = r101.getInt("reach_bar_size");
        this.f171865f = r101.getInt("reach_bar_bg_color");
        this.f171862c = r101.getInt("normal_bar_color");
        this.f171860a = r101.getInt("normal_bar_height");
        CollectionsKt.listOf(new Integer[]{Integer.valueOf(this.f171863d), Integer.valueOf(this.f171864e)});
        a();
        super.onRestoreInstanceState(r101.getParcelable("state"));
        return;
    L6:
        super.onRestoreInstanceState(r100);
    }

    public j(Context r100, SlcTemplateContext r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "slcTemplateContext");
        super(r100, null, 0);
        this.f171875p = r101;
        this.f171860a = SlcDimensExtensionsKt.a(4, r101.m());
        this.f171861b = Math.round(SlcDimensExtensionsKt.c(4, r101.m()));
        this.f171866g = SlcDimensExtensionsKt.a(2, r101.m());
        this.f171868i = SlcDimensExtensionsKt.a(Double.valueOf(4.5d), r101.m());
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = this.f171868i * 2;
        setMeasuredDimension(r102, ProgressBar.resolveSize((Math.max(Math.max(this.f171860a, this.f171861b), r103) + getPaddingTop()) + getPaddingBottom(), r101));
        this.f171874o = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }
}
