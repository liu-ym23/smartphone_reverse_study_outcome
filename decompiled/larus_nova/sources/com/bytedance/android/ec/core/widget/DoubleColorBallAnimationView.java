package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/core/widget/DoubleColorBallAnimationView;", "Landroid/view/View;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "size", "setProgressBarInfo", "", "progress", "setProgress", "cycleBias", "setCycleBias", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DoubleColorBallAnimationView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f45865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f45866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f45867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f45868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f45869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f45870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f45871g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f45872h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f45873i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PorterDuffXfermode f45874j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f45875k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f45876l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f45877m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f45878n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f45879o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f45880p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f45881q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f45882r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f45883s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f45884t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f45885u;

    public final void d() {
        this.f45879o = false;
        this.f45877m = false;
        this.f45875k = 0.0f;
    }

    public final void a() {
        this.f45880p = -1;
        if (this.f45881q > 0) goto L5;
        setProgressBarInfo(getContext().getResources().getDimensionPixelSize(R.dimen.ec_loading_side));
    L5:
        int r100 = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.f45881q <= r100) goto L10;
        if (r100 <= 0) goto L10;
        setProgressBarInfo(r100);
    L10:
        if (this.f45873i != null) goto L12;
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        r101.setDither(true);
        r101.setStyle(Paint.Style.FILL);
        this.f45873i = r101;
    L12:
        this.f45877m = true;
    }

    public final void c() {
        a();
        this.f45879o = true;
        this.f45876l = true;
        postInvalidate();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public DoubleColorBallAnimationView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
        b(r100);
    }

    public final void b(Context r100) {
        this.f45871g = ContextCompat.getColor(r100, R.color.ec_loading_color1);
        this.f45872h = ContextCompat.getColor(r100, R.color.ec_loading_color2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.f45879o == true) goto L7;
        if (this.f45876l == false) goto L7;
        return;
    L7:
        if (this.f45877m == false) goto L43;
        boolean r100 = false;
        if (this.f45876l == false) goto L18;
        long r101 = System.nanoTime() / ((long) 1000000);
        if (this.f45880p >= 0) goto L14;
        this.f45880p = r101;
    L14:
        float r102 = (r101 - this.f45880p) / this.f45869e;
        this.f45875k = r102;
        int r103 = (int) r102;
        if (((this.f45878n + r103) & 1) != 1) goto L17;
        r100 = true;
    L17:
        this.f45875k = r102 - r103;
        boolean r104 = r100;
    L19:
        float r105 = this.f45875k;
        if (r105 >= 0.5d) goto L22;
        float r106 = (2 * r105) * r105;
    L23:
        float r111 = r106;
        int r107 = this.f45881q;
        int r108 = r110.saveLayer(0.0f, 0.0f, r107, r107, this.f45873i, 31);
        float r109 = (this.f45885u * r111) + this.f45884t;
        if (r111 >= 0.5d) goto L26;
        float r112 = r111 * 2.0f;
    L27:
        float r113 = this.f45865a * r112;
        float r114 = this.f45883s;
        float r115 = (r113 * r114) + r114;
        Paint r116 = this.f45873i;
        Intrinsics.checkNotNull(r116);
        if (r104 == false) goto L30;
        int r117 = this.f45872h;
    L31:
        r116.setColor(r117);
        Paint r118 = this.f45873i;
        if (r118 == null) goto L34;
        r110.drawCircle(r109, this.f45882r, r115, r118);
    L34:
        float r119 = this.f45881q - r109;
        float r120 = this.f45883s;
        float r121 = r120 - ((r112 * this.f45866b) * r120);
        Paint r122 = this.f45873i;
        Intrinsics.checkNotNull(r122);
        if (r104 == false) goto L37;
        int r123 = this.f45871g;
    L38:
        r122.setColor(r123);
        Paint r124 = this.f45873i;
        Intrinsics.checkNotNull(r124);
        r124.setXfermode(this.f45874j);
        Paint r125 = this.f45873i;
        if (r125 == null) goto L41;
        r110.drawCircle(r119, this.f45882r, r121, r125);
    L41:
        Paint r126 = this.f45873i;
        Intrinsics.checkNotNull(r126);
        r126.setXfermode(null);
        r110.restoreToCount(r108);
        postInvalidateDelayed(this.f45870f);
        return;
    L37:
        r123 = this.f45872h;
        goto L38
    L30:
        r117 = this.f45871g;
        goto L31
    L26:
        float r127 = 2;
        r112 = r127 - (r111 * r127);
        goto L27
    L22:
        float r128 = 2;
        r106 = ((r128 * r105) * (r128 - r105)) - 1;
        goto L23
    L18:
        r104 = false;
        goto L19
    }

    public final void setCycleBias(int r100) {
        this.f45878n = r100;
    }

    public final void setProgress(float r100) {
        if (this.f45877m == true) goto L5;
        a();
    L5:
        this.f45875k = r100;
        this.f45879o = false;
        this.f45876l = false;
        postInvalidate();
    }

    public final void setProgressBarInfo(int r100) {
        if (r100 <= 0) goto L5;
        this.f45881q = r100;
        this.f45882r = r100 / 2.0f;
        float r101 = (r100 >> 1) * this.f45868d;
        this.f45883s = r101;
        float r102 = (this.f45867c * r100) + r101;
        this.f45884t = r102;
        this.f45885u = r100 - (r102 * 2);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        c();
        return;
    L5:
        d();
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
        b(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = Math.min(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        if (this.f45881q <= r102) goto L7;
        if (r102 <= 0) goto L8;
        setProgressBarInfo(r102);
        return;
    L8:
        return;
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f45865a = 0.25f;
        this.f45866b = 0.375f;
        this.f45867c = 0.16f;
        this.f45868d = 0.32f;
        this.f45869e = 400.0f;
        this.f45870f = 17;
        this.f45874j = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.f45880p = -1;
        this.f45881q = -1;
        b(r100);
    }
}
