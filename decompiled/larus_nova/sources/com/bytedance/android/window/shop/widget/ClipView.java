package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ClipView;", "Landroid/view/View;", "Lkotlin/Triple;", "Landroid/graphics/Path;", "", "", "getArcLine", "Landroid/graphics/Paint;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint", RXScreenCaptureService.KEY_INDEX, FaceService.girlLabel, "getRadius", "()F", "radius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClipView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f189824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f189825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f189826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f189827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f189828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f189829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f189830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f189831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f189832i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f189833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f189834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f189835c;

        public final float[] a(float r100) {
            float r101 = r100 - this.f189834b;
            float r102 = Math.abs(r101);
            float r103 = this.f189835c;
            if (r102 <= r103) goto L6;
            ECExceptionMonitor.e(new IllegalArgumentException("y: " + r100 + " out of circle"));
            float r104 = this.f189833a;
            return new float[]{r104, r104};
        L6:
            float r105 = (float) Math.sqrt((r103 * r103) - (r101 * r101));
            float r106 = this.f189833a;
            return new float[]{r106 - r105, r106 + r105};
        }

        public a(float r100, float r101, float r102) {
            this.f189833a = r100;
            this.f189834b = r101;
            this.f189835c = r102;
        }
    }

    private final Triple<Path, float[], Float> getArcLine() {
        if ((this.f189828e - this.f189829f) != this.f189826c) goto L6;
        Path r100 = new Path();
        r100.moveTo(this.f189827d - this.f189829f, this.f189826c);
        r100.lineTo(this.f189827d + this.f189829f, this.f189826c);
        Unit r101 = Unit.INSTANCE;
        float r102 = this.f189827d;
        float r103 = this.f189829f;
        float r104 = r102 + r103;
        return new Triple(r100, new float[]{r102 - r103, r104}, Float.valueOf(r104));
    L6:
        Path r105 = new Path();
        r105.moveTo(this.f189830g, this.f189826c);
        float r106 = this.f189827d;
        float r107 = this.f189828e;
        float r108 = this.f189829f;
        a r109 = new a(r106, r107, r108);
        float[] r110 = r109.a(this.f189826c);
        float[] r111 = r109.a(this.f189831h);
        float r112 = r110[0];
        float r113 = this.f189826c;
        float r114 = -1;
        float r115 = r114 / ((r107 - r113) / (r106 - r112));
        float r116 = r110[1];
        float r117 = r114 / ((r107 - r113) / (r106 - r116));
        r105.moveTo(this.f189830g, r113);
        float r118 = this.f189826c;
        r105.quadTo((r118 - (r113 - (r112 * r115))) / r115, r118, r111[0], this.f189831h);
        PointF r119 = new PointF(r111[0], this.f189831h);
        Intrinsics.checkNotNullParameter(r119, "point");
        float r120 = (float) ((((double) ((float) Math.atan((r119.y - r107) / (r119.x - r106)))) / 6.283185307179586d) * ((double) 360));
        r105.addArc(new RectF(r106 - r108, r107 - r108, r106 + r108, r107 + r108), 180 + r120, (90 - r120) * 2);
        float r121 = (r106 - this.f189830g) + r106;
        r105.moveTo(r121, this.f189826c);
        float r122 = this.f189826c;
        r105.quadTo((r122 - (r113 - (r116 * r117))) / r117, r122, r111[1], this.f189831h);
        return new Triple(r105, r111, Float.valueOf(r121));
    }

    public final Paint getPaint() {
        return this.f189824a;
    }

    public final float getRadius() {
        return this.f189832i;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        Triple<Path, float[], Float> r100 = getArcLine();
        Path r101 = r100.component1();
        float[] r102 = r100.component2();
        float r103 = r100.component3().floatValue();
        Path r104 = new Path();
        r104.moveTo(this.f189830g, this.f189826c);
        r104.lineTo(r102[0], this.f189831h);
        r104.lineTo(r102[0], this.f189826c);
        r104.lineTo(this.f189830g, this.f189826c);
        Path r105 = new Path();
        r105.moveTo(r103, this.f189826c);
        r105.lineTo(r102[1], this.f189831h);
        r105.lineTo(r102[1], this.f189826c);
        r105.lineTo(r103, this.f189826c);
        Path r106 = new Path();
        r106.moveTo(r102[0], this.f189831h);
        r106.lineTo(r102[1], this.f189831h);
        r106.lineTo(r102[1], this.f189826c);
        r106.lineTo(r102[0], this.f189826c);
        r106.lineTo(r102[0], this.f189831h);
        Path r107 = new Path();
        r107.addPath(r101);
        r107.addPath(r104);
        r107.addPath(r105);
        r107.addPath(r106);
        r110.drawPath(r107, this.f189825b);
        r110.drawPath(r101, this.f189824a);
        float r108 = getWidth();
        float r109 = getHeight();
        float r111 = this.f189826c;
        Path r112 = new Path();
        r112.moveTo(this.f189832i, r111);
        float r113 = 2;
        float r114 = this.f189832i * r113;
        r112.arcTo(new RectF(0.0f, r111, r114, r114 + r111), 270.0f, -90.0f, true);
        r112.lineTo(0.0f, r109 - this.f189832i);
        float r115 = this.f189832i * r113;
        r112.arcTo(new RectF(0.0f, r109 - r115, r115, r109), 180.0f, -90.0f, true);
        r112.lineTo(r108 - this.f189832i, r109);
        float r116 = this.f189832i * r113;
        r112.arcTo(new RectF(r108 - r116, r109 - r116, r108, r109), 90.0f, -90.0f, true);
        r112.lineTo(r108, this.f189832i + r111);
        float r117 = this.f189832i * r113;
        r112.arcTo(new RectF(r108 - r117, r111, r108, r117 + r111), 0.0f, -90.0f, true);
        r112.lineTo(this.f189832i, r111);
        r110.drawPath(r112, this.f189824a);
        float r118 = this.f189832i;
        Paint r119 = this.f189825b;
        int r120 = com.bytedance.android.ec.window.base.utils.c.f49722a;
        Intrinsics.checkNotNullParameter(r110, "$this$drawRoundRectCompat");
        Intrinsics.checkNotNullParameter(r119, "paint");
        r110.drawRoundRect(0.0f, r111, r108, r109, r118, r118, r119);
    }

    public ClipView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        Paint r102 = new Paint();
        r102.setStyle(Paint.Style.STROKE);
        r102.setColor(-1);
        r102.setAntiAlias(true);
        r102.setStrokeWidth(r100.getResources().getDimension(R.dimen.avatar_stroke_width));
        Unit r103 = Unit.INSTANCE;
        this.f189824a = r102;
        Paint r104 = new Paint();
        r104.setStyle(Paint.Style.FILL);
        r104.setAntiAlias(true);
        r104.setColor(-1);
        this.f189825b = r104;
        float r105 = com.bytedance.android.shopping.extensions.b.b(18);
        this.f189826c = r105;
        float r106 = com.bytedance.android.shopping.extensions.b.b(53);
        this.f189827d = r106;
        float r107 = com.bytedance.android.shopping.extensions.b.b(38);
        this.f189828e = r107;
        float r108 = com.bytedance.android.shopping.extensions.b.b(38);
        this.f189829f = r108;
        this.f189830g = r106 - r108;
        this.f189831h = r105 - ((r105 - (r107 - r108)) * 0.25f);
        this.f189832i = com.bytedance.android.shopping.extensions.b.b(12);
    }
}
