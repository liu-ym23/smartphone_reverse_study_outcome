package com.bytedance.android.live.recharge.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\u0013\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB\u001d\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B%\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/TreasureBoxCircleProgressView;", "Landroid/view/View;", "", "getProgress", "progress", "", "setProgress", "", "isDrawCircleOutside", "setCircleOutsideGone", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TreasureBoxCircleProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f90733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f90734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f90735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f90736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f90737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RectF f90738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f90739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f90740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f90741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f90742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f90743k;

    public static final class a {
    }

    static {
    }

    public final float getProgress() {
        return this.f90739g / 360;
    }

    public final void a() {
        this.f90734b = getResources().getColor(R.color.ttlive_progress_track_color_white);
        this.f90735c = getResources().getColor(R.color.ttlive_treasure_progress_bar_outer);
        Paint r100 = new Paint();
        this.f90733a = r100;
        r100.setAntiAlias(true);
        Paint r101 = this.f90733a;
        if (r101 == null) goto L6;
        r101.setDither(true);
        return;
    }

    public TreasureBoxCircleProgressView(Context r100) {
        super(r100);
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        Paint r101 = this.f90733a;
        if (r101 == null) goto L5;
        r101.setStyle(Paint.Style.STROKE);
    L5:
        Paint r102 = this.f90733a;
        if (r102 == null) goto L8;
        r102.setColor(this.f90734b);
    L8:
        Paint r103 = this.f90733a;
        if (r103 == null) goto L12;
        r103.setStrokeWidth(this.f90736d);
    L12:
        if (this.f90743k == true) goto L14;
    L16:
        Paint r104 = this.f90733a;
        if (r104 == null) goto L19;
        r104.setColor(this.f90735c);
    L19:
        RectF r105 = this.f90738f;
        if (r105 != null) goto L22;
        return;
    L22:
        if (this.f90733a == null) goto L26;
        Intrinsics.checkNotNull(r105);
        float r106 = this.f90739g;
        Paint r107 = this.f90733a;
        Intrinsics.checkNotNull(r107);
        r100.drawArc(r105, -90.0f, r106, false, r107);
        return;
    L26:
        return;
    L14:
        if (this.f90733a == null) goto L16;
        float r108 = getWidth() / 2.0f;
        float r109 = getHeight() / 2.0f;
        float r110 = this.f90737e;
        Paint r111 = this.f90733a;
        Intrinsics.checkNotNull(r111);
        r100.drawCircle(r108, r109, r110, r111);
        goto L16
    }

    public final void setCircleOutsideGone(boolean r100) {
        this.f90743k = r100;
    }

    public final void setProgress(float r100) {
        float r101 = 360;
        float r102 = r100 * r101;
        this.f90739g = r102;
        if (r102 < r101) goto L5;
        this.f90739g = r101;
    L5:
        invalidate();
    }

    public TreasureBoxCircleProgressView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public TreasureBoxCircleProgressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f90737e != 0.0f) goto L5;
    L6:
        float r105 = getWidth();
        float r106 = (0.061f * r105) * 0.8f;
        this.f90736d = r106;
        this.f90737e = (r105 - r106) / 2.0f;
        float r107 = 0;
        float r108 = this.f90736d;
        float r109 = 2;
        this.f90738f = new RectF((r108 / r109) + r107, r107 + (r108 / r109), r105 - (r108 / r109), r105 - (r108 / r109));
        int r110 = (int) (((double) (getWidth() - this.f90736d)) * 0.45d);
        int r111 = (int) (((double) (getHeight() - this.f90736d)) * 0.32d);
        this.f90741i = (getWidth() - r110) / 2;
        this.f90742j = getHeight() / 2;
        getWidth();
        int r112 = (getWidth() - r110) / 2;
        int r113 = (getHeight() - r111) / 2;
        Path r114 = new Path();
        this.f90740h = r114;
        r114.moveTo(this.f90741i, this.f90742j);
        return;
    L5:
        if (this.f90740h == null) goto L6;
    }
}
