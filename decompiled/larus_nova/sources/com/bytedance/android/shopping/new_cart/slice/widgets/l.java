package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l extends ProgressBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f179321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f179322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f179323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f179324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f179325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f179326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f179327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f179328h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f179329i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f179330j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f179331k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f179332l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f179333m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Paint f179334n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f179335o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SlcTemplateContext f179336p;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f179337a;

        public b(l r100) {
            this.f179337a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseSlcViewManager<?> r100 = SlcViewExtensionsKt.g(this.f179337a);     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            SlcCommonAction r101 = new SlcCommonAction("cartProgressAnimationHide", MapsKt.emptyMap());     // Catch: Throwable -> L6
            l r102 = this.f179337a;     // Catch: Throwable -> L6
            r100.getTemplateContext().d(r101, r102, r100.l(), null, null);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final void a() {
        Paint r100 = new Paint();
        r100.setColor(this.f179323c);
        r100.setStyle(Paint.Style.STROKE);
        r100.setAntiAlias(true);
        r100.setStrokeWidth(this.f179321a);
        Unit r101 = Unit.INSTANCE;
        this.f179330j = r100;
        Paint r102 = new Paint();
        r102.setColor(this.f179328h);
        r102.setStyle(Paint.Style.STROKE);
        r102.setStrokeWidth(this.f179327g);
        r102.setAntiAlias(true);
        this.f179332l = r102;
        Paint r103 = new Paint();
        r103.setColor(ColorProtector.parseColor("#FFFFFFFF"));
        r103.setStyle(Paint.Style.FILL);
        r103.setAntiAlias(true);
        this.f179333m = r103;
        Paint r104 = new Paint();
        r104.setColor(this.f179326f);
        r104.setStyle(Paint.Style.STROKE);
        r104.setAntiAlias(true);
        r104.setStrokeWidth(this.f179322b);
        this.f179334n = r104;
        Paint r105 = new Paint();
        r105.setStyle(Paint.Style.STROKE);
        r105.setAntiAlias(true);
        r105.setStrokeWidth(this.f179322b);
        this.f179331k = r105;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("state", super.onSaveInstanceState());
        r100.putInt("circle_ring_color", this.f179328h);
        r100.putInt("circle_ring_width", this.f179327g);
        r100.putInt("circle_ring_radius", this.f179329i);
        r100.putInt("lt_gradient_color", this.f179324d);
        r100.putInt("rb_gradient_color", this.f179325e);
        r100.putInt("reach_bar_size", this.f179322b);
        r100.putInt("reach_bar_bg_color", this.f179326f);
        r100.putInt("normal_bar_color", this.f179323c);
        r100.putInt("normal_bar_height", this.f179321a);
        return r100;
    }

    public final SlcTemplateContext getSlcTemplateContext() {
        return this.f179336p;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        r210.save();
        r210.translate(getPaddingLeft(), getHeight() / 2);
        int r100 = this.f179329i * 2;
        float r101 = (getProgress() * 1.0f) / getMax();
        int r102 = this.f179335o;
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
        Paint r108 = this.f179330j;
        if (r108 == null) goto L30;
        r210.drawLine(r107, 0.0f, this.f179335o, 0.0f, r108);
    L30:
        r210.restore();
        return;
    L9:
        if (r211 <= r106) goto L19;
        Paint r109 = this.f179334n;
        if (r109 == null) goto L13;
        r210.drawLine(0.0f, 0.0f, r211, 0.0f, r109);
    L13:
        int r110 = this.f179322b;
        float r111 = 0.0f;
        LinearGradient r112 = new LinearGradient(0.0f, (-r110) / 2.0f, r211, r110 / 2.0f, CollectionsKt.toIntArray(CollectionsKt.listOf(new Integer[]{Integer.valueOf(this.f179324d), Integer.valueOf(this.f179325e)})), CollectionsKt.toFloatArray(CollectionsKt.listOf(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.66f)})), Shader.TileMode.CLAMP);
        Paint r113 = this.f179331k;
        if (r113 == null) goto L16;
        r113.setShader(r112);
    L16:
        Paint r114 = this.f179331k;
        if (r114 == null) goto L20;
        r210.drawLine(0.0f, 0.0f, r211, 0.0f, r114);
    L20:
        Paint r115 = this.f179333m;
        if (r115 == null) goto L23;
        r210.drawCircle(r211 + (r105 / 2.0f), r111, this.f179329i, r115);
    L23:
        Paint r116 = this.f179332l;
        if (r116 == null) goto L26;
        r210.drawCircle(r211 + (r105 / 2.0f), r111, this.f179329i - (this.f179327g / 2.0f), r116);
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
        this.f179328h = r101.getInt("circle_ring_color");
        this.f179327g = r101.getInt("circle_ring_width");
        this.f179329i = r101.getInt("circle_ring_radius");
        this.f179324d = r101.getInt("lt_gradient_color");
        this.f179325e = r101.getInt("rb_gradient_color");
        this.f179322b = r101.getInt("reach_bar_size");
        this.f179326f = r101.getInt("reach_bar_bg_color");
        this.f179323c = r101.getInt("normal_bar_color");
        this.f179321a = r101.getInt("normal_bar_height");
        CollectionsKt.listOf(new Integer[]{Integer.valueOf(this.f179324d), Integer.valueOf(this.f179325e)});
        a();
        super.onRestoreInstanceState(r101.getParcelable("state"));
        return;
    L6:
        super.onRestoreInstanceState(r100);
    }

    public l(Context r100, SlcTemplateContext r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "slcTemplateContext");
        super(r100, null, 0);
        this.f179336p = r101;
        this.f179321a = SlcDimensExtensionsKt.a(4, r101.m());
        this.f179322b = Math.round(SlcDimensExtensionsKt.c(4, r101.m()));
        this.f179327g = SlcDimensExtensionsKt.a(2, r101.m());
        this.f179329i = SlcDimensExtensionsKt.a(Double.valueOf(4.5d), r101.m());
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = this.f179329i * 2;
        setMeasuredDimension(r102, ProgressBar.resolveSize((Math.max(Math.max(this.f179321a, this.f179322b), r103) + getPaddingTop()) + getPaddingBottom(), r101));
        this.f179335o = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final void b(Float r100, Float r101, boolean r102, List<String> r103, String r104, String r105, String r110, int r111) {
        if (r103 == null) goto L53;
        if (r104 == null) goto L54;
        if (r105 == null) goto L59;
        Integer r106 = s.b(r104);
        if (r106 == null) goto L9;
        int r107 = r106.intValue();
    L10:
        this.f179323c = r107;
        Integer r108 = s.b((String) CollectionsKt.getOrNull(r103, 0));
        if (r108 == null) goto L13;
        int r109 = r108.intValue();
    L14:
        this.f179324d = r109;
        Integer r112 = s.b((String) CollectionsKt.getOrNull(r103, 1));
        if (r112 == null) goto L17;
        int r113 = r112.intValue();
    L18:
        this.f179325e = r113;
        Integer r114 = s.b(r110);
        if (r114 == null) goto L21;
        int r115 = r114.intValue();
    L22:
        this.f179326f = r115;
        Integer r116 = s.b(r105);
        if (r116 == null) goto L25;
        int r117 = r116.intValue();
    L26:
        this.f179328h = r117;
        CollectionsKt.listOf(new Integer[]{Integer.valueOf(this.f179324d), Integer.valueOf(this.f179325e)});
        a();
        if (r100 == null) goto L29;
        float r118 = r100.floatValue();
    L30:
        if (r101 == null) goto L32;
        float r119 = r101.floatValue();
    L33:
        if (r102 == true) goto L35;
        int r120 = (int) r119;
        if (r120 == getProgress()) goto L58;
        setProgress(r120);
        return;
    L58:
        return;
    L35:
        if (r118 != 0.0f) goto L40;
        if (r119 <= 0.0f) goto L40;
        animate().alpha(1.0f).setDuration(200).start();
    L44:
        int r121 = r111 * 100;
        float r122 = Math.abs((r119 - r118) + r121) * 10;
        int r123 = (int) r119;
        if (r123 != getProgress()) goto L47;
        return;
    L47:
        if (r122 <= 0) goto L56;
        long r124 = (long) r122;
        ValueAnimator r125 = ValueAnimator.ofInt(new int[]{getProgress(), r123 + r121});
        r125.addUpdateListener(new m(this));
        r125.setInterpolator(new AccelerateDecelerateInterpolator());
        r125.setDuration(r124);
        r125.start();
        return;
    L56:
        return;
    L40:
        if (r119 != 0.0f) goto L44;
        if (r118 <= 0.0f) goto L44;
        animate().alpha(0.0f).setDuration(200).withEndAction(new b(this)).start();
        goto L44
    L32:
        r119 = 0.0f;
        goto L33
    L29:
        r118 = 0.0f;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L59:
        return;
    L54:
        return;
    }
}
