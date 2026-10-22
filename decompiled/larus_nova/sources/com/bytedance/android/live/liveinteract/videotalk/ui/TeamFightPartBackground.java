package com.bytedance.android.live.liveinteract.videotalk.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/ui/TeamFightPartBackground;", "Landroid/view/View;", "Landroid/graphics/Shader;", "getShader", "Landroid/graphics/RectF;", "getRoundRect", "Landroid/graphics/Path;", "getRoundRectPath", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamFightPartBackground extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f79762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f79763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f79764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f79765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f79766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f79767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Shader f79768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f79769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Path f79770i;

    private final RectF getRoundRect() {
        if (this.f79769h != null) goto L8;
        float r100 = 2;
        float r101 = (this.f79763b * r100) + this.f79766e;
        if (this.f79767f == false) goto L7;
        this.f79769h = new RectF((-1) * r101, 0.0f, (getWidth() * 1.0f) - (this.f79766e / r100), (getHeight() * 1.0f) - this.f79766e);
        goto L8
    L7:
        this.f79769h = new RectF(this.f79766e / r100, 0.0f, (getWidth() * 1.0f) + r101, (getHeight() * 1.0f) - this.f79766e);
    L8:
        RectF r102 = this.f79769h;
        if (r102 == null) goto L12;
        return r102;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.RectF");
    }

    private final Path getRoundRectPath() {
        float r100 = s1.e(this.f79763b);
        if (this.f79770i != null) goto L8;
        Path r101 = new Path();
        this.f79770i = r101;
        if (this.f79767f == false) goto L7;
        r101.addRoundRect(getRoundRect(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, r100, r100, 0.0f, 0.0f}, Path.Direction.CW);
        goto L8
    L7:
        r101.addRoundRect(getRoundRect(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r100, r100}, Path.Direction.CW);
    L8:
        Path r102 = this.f79770i;
        if (r102 == null) goto L12;
        return r102;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Path");
    }

    private final Shader getShader() {
        if (this.f79768g != null) goto L5;
        this.f79768g = new LinearGradient(0.0f, 0.0f, 1.0f * getWidth(), 0.0f, this.f79764c, this.f79765d, Shader.TileMode.CLAMP);
    L5:
        Shader r100 = this.f79768g;
        if (r100 == null) goto L9;
        return r100;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Shader");
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Paint r101 = this.f79762a;
        if (r101 == null) goto L5;
        r100.drawPath(getRoundRectPath(), r101);
    L5:
        super.onDraw(r100);
    }

    public TeamFightPartBackground(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f79767f = true;
        Paint r102 = new Paint();
        this.f79762a = r102;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.bgCornerRadius, R.attr.endColor, R.attr.leftPart, R.attr.startColor, R.attr.strokeWidth});
        int r104 = r103.getColor(3, ColorProtector.parseColor(CustomHeaderConfig.COLOR_DARK));
        this.f79764c = r104;
        int r105 = r103.getColor(1, ColorProtector.parseColor(CustomHeaderConfig.COLOR_DARK));
        this.f79765d = r105;
        this.f79763b = r103.getDimension(0, 0.0f);
        boolean r106 = r103.getBoolean(2, true);
        this.f79767f = r106;
        float r107 = r103.getDimension(4, 0.0f);
        this.f79766e = r107;
        if (r106 == false) goto L5;
        r102.setColor(r105);
    L6:
        r102.setStrokeWidth(r107);
        r102.setAntiAlias(true);
        r102.setStyle(Paint.Style.STROKE);
        return;
    L5:
        r102.setColor(r104);
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(r100, r101);
        super.onMeasure(r100, r101);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == false) goto L8;
        Paint r105 = this.f79762a;
        if (r105 == null) goto L9;
        r105.setShader(getShader());
        return;
    L9:
        return;
    }
}
